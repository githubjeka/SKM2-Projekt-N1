package com.base.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Georgi on 08.01.2017.
 */

@Entity
@Table(name = "HOUR_TABLE", catalog = "skm2_model_2")
public class DataHour implements Serializable {

    private Integer hour_Id;
    private Date date;
    private Double volume;
    private Float temper;
    private Float press;
    private Device device;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOUR", nullable = false)
    public Integer getHour_Id() {
        return hour_Id;
    }
    public void setHour_Id(Integer hour_Id) {
        this.hour_Id = hour_Id;
    }

    @Column(name = "DATE", nullable = false, unique = true)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "VOLUME1")
    public Double getVolume() {
        return volume;
    }
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Column(name = "TEMPER1")
    public Float getTemper() {
        return temper;
    }
    public void setTemper(Float temper) {
        this.temper = temper;
    }

    @Column(name = "PRESS1")
    public Float getPress() {
        return press;
    }
    public void setPress(Float press) {
        this.press = press;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_NUMBER", nullable = false)
    public Device getDevice() {
        return device;
    }
    public void setDevice(Device device) {
        this.device = device;
    }
}
