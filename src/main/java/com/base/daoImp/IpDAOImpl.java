package com.base.daoImp;

import com.base.Model.Ip;
import com.base.dao.IpDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Georgi on 27.01.2017.
 */
public class IpDAOImpl implements IpDAO {

    private Session session;

    /*public IpDAOImpl() {
    //    if(session == null) session = HibernateUtil.getSessionFactory().openSession();
    }*/

    public IpDAOImpl(Session session) {
        this.session = session;
    }

    public void addIp(Ip ip) throws SQLException, Exception {
        session.beginTransaction();
        session.save(ip);
        session.getTransaction().commit();
    }

    public void updateIp(Ip ip) throws SQLException, Exception {
        session.beginTransaction();
        session.update(ip);
        session.getTransaction().commit();
    }

  /*  public Integer getIpAndNumber(String ip, Integer numb) throws SQLException, Exception {
        Ip ipAndNumbe;
        *//*Query query = session.createQuery("from Ip where ipName = :ip and number = :numb");
        ipAndNumber = (Ip)query.getSingleResult();*//*
        Query query = session.createQuery("SELECT e FROM Ip e WHERE e.ipName = ? and  e.number = ?");
        query.setParameter(0,ip);
        query.setParameter(1, numb);
        ipAndNumbe = (Ip)query.getSingleResult();
        return ipAndNumbe.getIp_Id();
    }*/

    public Ip getIpById(Integer id) throws SQLException, Exception {
        Ip ip;
        ip = session.load(Ip.class, id);
        return ip;
    }

    public Ip getIpByName(String name) throws SQLException, Exception {
        Query query = session.createQuery("from Ip");
        List<Ip> ips = query.list();
        for(Ip ip:ips){
            if(ip.getIpName().equals(name)) return ip;
        }
        return null;
    }

    public Collection<Ip> getAllIps() throws SQLException, Exception {
        List<Ip> ips;
        //ipAndNumber1s = session.createCriteria(Ip.class).list();
        Query query = session.createQuery("from Ip");
        ips = query.list();
        return ips;
    }

    public void deleteIp(Ip ip1) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(ip1);
        session.getTransaction().commit();
    }
}
