package com.base.daoImp;

import com.base.Model.DataDay;
import com.base.dao.DataDayDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sun.util.calendar.BaseCalendar;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Georgi on 27.01.2017.
 */
public class DataDayDAOImpl implements DataDayDAO {

    private Session session;

    public DataDayDAOImpl(Session session) {
        this.session = session;
    }

    public void addDataDay(DataDay dataDay) throws SQLException, Exception {
        session.beginTransaction();
        session.save(dataDay);
        session.getTransaction().commit();
    }

    public void updateDataDay(DataDay dataDay) throws SQLException, Exception {
        session.beginTransaction();
        session.update(dataDay);
        session.getTransaction().commit();
    }

    public DataDay getDataDayById(Integer id) throws SQLException, Exception {
        DataDay dataDay;
        dataDay = session.load(DataDay.class, id);
        return dataDay;
    }

    public DataDay getDataDayByName(BaseCalendar.Date date) throws SQLException, Exception {
        Query query = session.createQuery("from DataDay ");
        List<DataDay> dataDays = query.list();
        for(DataDay dd:dataDays){
            if(dd.getDateTime().equals(date)) return dd;
        }
        return null;
    }

    public Collection<DataDay> getAllDataDays() throws SQLException, Exception {
        List<DataDay> dataDays;
        //dataDay1s = session.createCriteria(DataDay.class).list();
        Query query = session.createQuery("from DataDay");
        dataDays = query.list();
        return dataDays;
    }

    public void deleteDataDay(DataDay dataDay) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(dataDay);
        session.getTransaction().commit();
    }
}
