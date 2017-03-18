package com.base.daoImp;

import com.base.Model.Device;
import com.base.dao.DeviceDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Georgi on 05.02.2017.
 */
public class DeviceDAOImp implements DeviceDAO {

    private Session session;

    public DeviceDAOImp(Session session) {
        this.session = session;
    }

    public void addDevice(Device device) throws SQLException, Exception {
        session.beginTransaction();
        session.save(device);
        session.getTransaction().commit();
    }

    public void updateDevice(Device device) throws SQLException, Exception {
        session.beginTransaction();
        session.update(device);
        session.getTransaction().commit();
    }

    public Device getDeviceById(Integer id) throws SQLException, Exception {
        Device device;
        device = session.load(Device.class, id);
        return device;
    }

    public Device getDeviceByNumber(Integer number) throws SQLException, Exception {
        Query query = session.createQuery("from Device");
        List<Device> dvc = query.list();
        for(Device d:dvc){
            if(d.getNetNumber().equals(number)) return d;
        }
        return null;
    }

    public List<Device> getAllDevices() throws SQLException, Exception {
        List<Device> devices;
        Query query = session.createQuery("from Device");
        devices = query.list();
        return devices;
    }

    public void deleteDevice(Device device) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(device);
        session.getTransaction().commit();
    }
}
