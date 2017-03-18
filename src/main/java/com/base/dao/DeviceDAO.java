package com.base.dao;

import com.base.Model.Device;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Georgi on 05.02.2017.
 */
public interface DeviceDAO {
    public void addDevice(Device device) throws SQLException, Exception;
    public void updateDevice(Device device) throws SQLException, Exception;
    public Device getDeviceById(Integer id) throws SQLException, Exception;
    public Device getDeviceByNumber(Integer number) throws SQLException, Exception;
    public List<Device> getAllDevices() throws SQLException, Exception;
    public void deleteDevice(Device device) throws SQLException, Exception;
}