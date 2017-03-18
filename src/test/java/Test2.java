import com.base.Model.DataDay;
import com.base.Model.Device;
import com.base.Model.Ip;
import com.network.DataDevice;
import com.network.DataParser;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Georgi on 15.02.2017.
 */
public class Test2 {
    @Test
    public void testDataDevice() throws IOException {

        Device device = new Device();
        Ip ip = new Ip();
        //ip.setIpName("46.56.155.21");
        ip.setIpName("128.140.248.72");
        ip.setPort(5009);

        device.setNetNumber(1);
        device.setIp(ip);
        DataDevice dataDevice = new DataDevice();
        for(int i =0; i<3;i++) {
            ArrayList<Integer> list = dataDevice.getIntegerListDataDayFromDevice(device);
            if ((list.size() >4)&& (list.get(1) == list.size() - 6) &&
                                    (list.get(2) == list.size() - 6) &&
                                    (list.get(list.size()-1) == 0x16)) {
                DataDay dataDay = DataParser.MyParserDataDay(device, list, 19);
                System.out.println(device.getId_Device() + " " + dataDay);
                String str = String.format("%.2f", dataDay.getFlowV1());
                System.out.println("Это расход 1   -  "+str);
                int k = 0;
                //if(list.get(list.size()-1) == 0x16)
                for(Integer in:list){
                    //System.out.println("byte ["+k++ +"] = "+in);
                    System.out.println("list.add("+in+");");
                }
                break;
            }
            else System.out.println("Ошибка связи");
        }
        //ArrayList<Integer> list = DataDevice.getDataDayFromDevice(device);
        //DataDay dataDay = DataParser.MyParserDataDay (device, list, 19);

//        int k = 0;
//        if(list.get(list.size()-1) == 0x16)
//            for(Integer in:list){
//                System.out.println("byte ["+k++ +"] = "+in);
//            }
//        System.out.println("Это объем = " + dataDay.getVolume());
    }
}
