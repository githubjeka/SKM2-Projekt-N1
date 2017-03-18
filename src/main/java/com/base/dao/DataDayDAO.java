package com.base.dao;

import com.base.Model.DataDay;
import sun.util.calendar.BaseCalendar;

import java.sql.SQLException;
import java.util.Collection;

public interface DataDayDAO {
    public void addDataDay(DataDay dataDay) throws SQLException, Exception;
    public void updateDataDay(DataDay dataDa1) throws SQLException, Exception;
    public DataDay getDataDayById(Integer id) throws SQLException, Exception;
    public DataDay getDataDayByName(BaseCalendar.Date date) throws SQLException, Exception;
    public Collection<DataDay> getAllDataDays() throws SQLException, Exception;
    public void deleteDataDay(DataDay dataDay) throws SQLException, Exception;
}
