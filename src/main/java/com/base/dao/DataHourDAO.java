package com.base.dao;

import com.base.Model.DataHour;

import java.sql.SQLException;
import java.util.Collection;

public interface DataHourDAO {
    public void addDataHour(DataHour dataHour) throws SQLException, Exception;
    public void updateDataHour(DataHour dataHour) throws SQLException, Exception;
    public DataHour getDataHourById(Integer id) throws SQLException, Exception;
    public Collection<DataHour> getAllDataHour() throws SQLException, Exception;
    public void deleteDataHour(DataHour dataHour) throws SQLException, Exception;
}