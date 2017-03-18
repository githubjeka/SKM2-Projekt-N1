package com.base.dao;

import com.base.Model.Ip;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Georgi on 27.01.2017.
 */
public interface IpDAO {
    public void addIp(Ip ip) throws SQLException, Exception;
    public void updateIp(Ip ip) throws SQLException, Exception;
    public Ip getIpById(Integer id) throws SQLException, Exception;
    public Ip getIpByName(String name) throws SQLException, Exception;
    public Collection<Ip> getAllIps() throws SQLException, Exception;
    public void deleteIp (Ip ip) throws SQLException, Exception;
}


