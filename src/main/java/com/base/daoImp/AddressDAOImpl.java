package com.base.daoImp;

import com.base.Model.Address;
import com.base.dao.AddressDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Georgi on 27.01.2017.
 */



@Component
public class AddressDAOImpl implements AddressDAO{


    @Autowired
    private SessionFactory sessionFactory;


    private Session session;

   /* public AddressDAOImpl() {
       // if(session == null) session = HibernateUtil.getSessionFactory().openSession();
    }*/

    public AddressDAOImpl() {
      //  this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void addAddress(Address address) throws SQLException, Exception {
        session.beginTransaction();
        session.save(address);
        //session.getTransaction().commit();
    }

    public void updateAddress(Address address) throws SQLException, Exception {
        session.beginTransaction();
        session.update(address);
       // session.getTransaction().commit();
    }

    public Address getAddressById(Integer id) throws SQLException, Exception {
        Address address;
        address = session.load(Address.class,id);
        return address;
    }

    public Address getAddressByName(String name) throws SQLException, Exception {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Address");
//        List<Address> address = query.list();
//        for(Address ad:address){
//            if(ad.getAddress().equals(name)) return ad;
//        }
        return null;
    }


    public Collection<Address> getAllAddress() throws SQLException, Exception, HibernateException {
        List<Address> address;
        Query query = sessionFactory.getCurrentSession().createQuery("from Address");
        address = query.list();
        return address;
    }

    public void deleteAddress(Address address) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(address);
        //session.getTransaction().commit();
    }
}
