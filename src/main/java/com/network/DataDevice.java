package com.network;

import com.base.Model.DataDay;
import com.base.Model.DataHour;
import com.base.Model.Device;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Georgi on 12.02.2017.
 */
public class DataDevice {

    private static final Logger log = Logger.getLogger(DataDevice.class);

    public DataDay getDataDayFromDevice(Device device) throws IOException {
        DataDay dataDay = null;
        ArrayList<Integer> list = getIntegerListDataDayFromDevice(device);
        if ((list.size() > 4)&& (list.get(1) == list.size() - 6) &&
                (list.get(2) == list.size() - 6) &&
                (list.get(list.size()-1) == 0x16)) {
            log.info("OK Get data from IP = "+device.getIp().getIpName()+" !");
            dataDay = DataParser.MyParserDataDay(device, list, 19);
        }
        else {log.error("ERROR Get data from IP = "+device.getIp().getIpName()+" !");}
        return dataDay;
    }

    public ArrayList<Integer> getIntegerListDataDayFromDevice(Device device) throws IOException {

        String ip = device.getIp().getIpName();
        Integer port = device.getIp().getPort();
        Integer netAddress = device.getNetNumber();
        ArrayList<Integer> list = new ArrayList<Integer>();

        Socket socket = null;
        try {
            socket = new Socket(ip, port);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            dOut.write(new byte[]{0x10, 0x40, netAddress.byteValue(), 0x41, 0x16});
            dOut.flush();

            int e5 = dataInputStream.readUnsignedByte();
            if(e5 == 0xE5 || e5 == 0xF9){
                dOut.write(new byte[]{0x68, 0x04, 0x04, 0x68, 0x53, netAddress.byteValue(), 0x50, 0x10, (byte) 0xB4, 0x16});
                dOut.flush();
                e5 = dataInputStream.readUnsignedByte();
                if(e5 == 0xE5 || e5 == 0xF9){
                    dOut.write(new byte[]{0x10, 0x5B, netAddress.byteValue(), 0x5C, 0x16});
                    dOut.flush();

                    for(int i=0;i<4;i++){
                        list.add(dataInputStream.readUnsignedByte());
                    }

                    int len = list.get(list.size()-2);
                    for(int i=0;i<len+2;i++){
                        list.add(dataInputStream.readUnsignedByte());
                    }
                }
            }
        }catch (Exception e){
            System.out.print("Whoops! It didn't work!:" + device.getIp().getIpName());
            //e.printStackTrace();
            System.out.print(e.getLocalizedMessage());
            System.out.print("\n");
        }finally {
            //if (socket != null && socket.isConnected()) {
            if (socket != null) {
                socket.close();
            }
        }
        return list;
    }

    public static DataHour getDataHourFromDevice(Device device) {
        return null;
    }
}
