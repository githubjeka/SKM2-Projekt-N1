import com.base.Model.Address;
import com.base.Model.DataDay;
import com.base.Model.Device;
import com.base.util.HibernateUtil;
import com.network.DataParser;
import com.network.MyStruct;
import com.network.ParserMethod;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgi on 27.01.2017.
 */
public class myTest {
    public static void main123(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Address");
        List<Address> address = query.list();
        for(Address ad:address){
            if(ad.getAddress().equals("ul. one, 5"))
                System.out.println("Этот одрес существует - "+ad.getAddress());
            else {System.out.println("Такого адреса нету");}
        }
        HibernateUtil.shutdown();
    }

    public static void main333(String[] args) throws IOException {
        String ip = "128.140.248.72";
        Integer port = 5009;
        Integer netAddress = 1;
        Socket socket = null;

        try {
            socket = new Socket(ip, port);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            dOut.write(new byte[]{0x10, 0x40, netAddress.byteValue(), 0x41, 0x16});
            dOut.flush();

            if(dataInputStream.readUnsignedByte() == 0xE5){
                dOut.write(new byte[]{0x68, 0x04, 0x04, 0x68, 0x53, netAddress.byteValue(), 0x50, 0x10, (byte) 0xB4, 0x16});
                dOut.flush();
                if(dataInputStream.readUnsignedByte() == 0xE5){
                    dOut.write(new byte[]{0x10, 0x5B, netAddress.byteValue(), 0x5C, 0x16});
                    dOut.flush();

                    ArrayList<Integer> list = new ArrayList<Integer>();

                    for(int i=0;i<4;i++){list.add(dataInputStream.readUnsignedByte());}

                    int len = list.get(list.size()-2);
                    for(int i=0;i<len+2;i++){list.add(dataInputStream.readUnsignedByte());}
                    int k = 0;
                    if(list.get(list.size()-1) == 0x16)
                    for(Integer in:list){
                        System.out.println("byte ["+k++ +"] = "+in);
                    }
                }
            }
        } catch (Exception e) {
            System.out.print("Whoops! It didn't work!:");
            e.printStackTrace();
            System.out.print(e.getLocalizedMessage());
            System.out.print("\n");
        }finally {
            if (socket != null && socket.isConnected()) {
                socket.close();
            }
        }
    }

    public static void main(String[] args) {

        MyStruct myStruct;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0x04);
        list.add(0x06);
        list.add(0x83);
        list.add(0x05);
        list.add(0x00);
        list.add(0x00);
        list.add(0x00);


        DataDay dataDay = new DataDay();
        int a = 0;

        Device device =new Device();


        dataDay = DataParser.MyParserDataDay(device, list,0);
        System.out.println("Volume = "+ dataDay.getVolume1());

        switch (list.get(a)){
            case 0x04: {
                if(list.get(a+1).equals(6D)){System.out.println("77777777777777777777777777");}//Это энергия 1
                else {myStruct = ParserMethod.getEVMTInFloat(++a, list);
                dataDay.setVolume1(myStruct.getParam());
                a = myStruct.getCount();
                    System.out.println("5555555555555555555555555555");
                }

                switch (list.get(++a)){
                    case 0x07:break;
                    case 0x06://factor = 0.001f;
                        myStruct = ParserMethod.getEVMTInFloat(++a, list);
                        dataDay.setVolume1(myStruct.getParam());
                        a = myStruct.getCount();

                        break;
                }

            }
            break;
            case 0x84:
                break;
        }
    }
}
