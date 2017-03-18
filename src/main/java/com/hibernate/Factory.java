package com.hibernate;

import com.base.dao.*;
import com.base.daoImp.*;
import org.hibernate.Session;

/**
 * Created by Georgi on 28.01.2017.
 */
public class Factory {

    private static Factory instance = null;
    private static AddressDAO addressDAO = null;
    private static IpDAO ipDAO = null;
    private static DeviceDAO deviceDAO = null;
    private static DataDayDAO dataDayDAO = null;
    private static DataHourDAO dataHourDAO = null;

    private static Session s;


    public Factory(Session s) {
        this.s = s;
    }

    public static synchronized Factory getInstance(Session s) {
        if(instance == null) instance = new Factory(s);
        return instance;
    }

    public AddressDAO getAddressDAO(){
       // if(addressDAO == null) addressDAO = new AddressDAOImpl(s);
        return null;
    }

    public IpDAO getIpDAO(){
        if(ipDAO == null) ipDAO = new IpDAOImpl(s);
        return ipDAO;
    }

    public DeviceDAO getDeviceDAO(){
        if(deviceDAO == null) deviceDAO = new DeviceDAOImp(s);
        return deviceDAO;
    }


    public DataDayDAO getDataDayDAO(){
        if(dataDayDAO == null) dataDayDAO = new DataDayDAOImpl(s);
        return dataDayDAO;
    }

    public DataHourDAO getDataHourDAO(){
        if(dataHourDAO == null) dataHourDAO = new DataHourDAOImpl(s);
        return dataHourDAO;
    }
}
