package com.base.dao;

import com.base.Model.Address;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.Collection;

public interface AddressDAO{
    void addAddress(Address address) throws SQLException, Exception;
    void updateAddress(Address address) throws SQLException, Exception;
    Address getAddressById(Integer id) throws SQLException, Exception;
    Address getAddressByName(String name) throws SQLException, Exception;
    Collection<Address> getAllAddress() throws SQLException, Exception, HibernateException;
    void deleteAddress(Address address) throws SQLException, Exception;
}