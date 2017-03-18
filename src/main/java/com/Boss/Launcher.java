package com.Boss;

import com.base.Model.DataDay;
import com.base.Model.Device;
import com.base.util.HibernateUtil;
import com.hibernate.Factory;
import com.network.DataDevice;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.TimerTask;


public class Launcher extends TimerTask{

    private static final Logger log = Logger.getLogger(Launcher.class);

    @Override
    public void run() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Device> devices = Factory.getInstance(session).getDeviceDAO().getAllDevices();
            for (Device device : devices) {
                DataDevice dataDevice  = new DataDevice();
                for(int i =0; i<3;i++) {
                    {
                        DataDay dataDay = dataDevice.getDataDayFromDevice(device);
                        System.out.println(device.getId_Device() + " " + dataDay);
                        if(dataDay != null){
                            //if (!Factory.getInstance(session).getDataDayDAO().getAllDataDays().equals(dataDay)) {}
                            Factory.getInstance(session).getDataDayDAO().addDataDay(dataDay);
                            log.error("OK Set data to DB with IP = "+device.getIp().getIpName()+" !");
                            break;
                        }
                        else log.error("ERROR Set data to DB with IP = "+device.getIp().getIpName()+" !");
                    }
                }
            }

/*                for (Device hour : devices) {
                    DataHour dataHour = DataDevice.getDataHourFromDevice(hour);
                     if (!Factory.getInstance(session).getDataHourDAO().getAllDataHour().equals(dataHour)) {
                      Factory.getInstance(session).getDataHourDAO().addDataHour(dataHour);
                    }*/


        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.shutdown();
            }
        }

    }
    //128.140.248.72

        /*Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Device> devices = Factory.getInstance(session).getDeviceDAO().getAllDevices();
            for (Device device : devices) {
                DataDevice dataDevice  = new DataDevice();
                for(int i =0; i<3;i++) {
                     {
                        DataDay dataDay = dataDevice.getDataDayFromDevice(device);
                        System.out.println(device.getId_Device() + " " + dataDay);
                        if(dataDay != null){
                            //if (!Factory.getInstance(session).getDataDayDAO().getAllDataDays().equals(dataDay)) {}
                            Factory.getInstance(session).getDataDayDAO().addDataDay(dataDay);
                            break;
                        }
                    }
                }
            }

*//*                for (Device hour : devices) {
                    DataHour dataHour = DataDevice.getDataHourFromDevice(hour);
                     if (!Factory.getInstance(session).getDataHourDAO().getAllDataHour().equals(dataHour)) {
                      Factory.getInstance(session).getDataHourDAO().addDataHour(dataHour);
                    }*//*


        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                HibernateUtil.shutdown();
            }
        }
*/

}

