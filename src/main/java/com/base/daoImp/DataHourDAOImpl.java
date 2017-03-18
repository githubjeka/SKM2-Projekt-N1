package com.base.daoImp;

import com.base.Model.DataHour;
import com.base.dao.DataHourDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Georgi on 27.01.2017.
 */
public class DataHourDAOImpl implements DataHourDAO {

    private Session session;

    public DataHourDAOImpl(Session session) {
        this.session = session;
    }

    public void addDataHour(DataHour dataHour) throws SQLException, Exception {
        session.beginTransaction();
        session.save(dataHour);
        session.getTransaction().commit();
    }

    public void updateDataHour(DataHour dataHour) throws SQLException, Exception {
        session.beginTransaction();
        session.update(dataHour);
        session.getTransaction().commit();
    }

    public DataHour getDataHourById(Integer id) throws SQLException, Exception {
        DataHour dataHour;
        dataHour = session.load(DataHour.class, id);
        return dataHour;
    }

    public Collection<DataHour> getAllDataHour() throws SQLException, Exception {
//        List<DataHour> dataHours;
//        //dataHour1s = session.createCriteria(DataHour.class).list();
//        Query query = session.createQuery("from DataHour");
//        dataHours = query.list();
        return null;
    }

    public void deleteDataHour(DataHour dataHour1) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(dataHour1);
        session.getTransaction().commit();
    }
}
