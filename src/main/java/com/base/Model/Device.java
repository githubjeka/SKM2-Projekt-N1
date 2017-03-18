package com.base.Model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Georgi on 05.02.2017.
 */
@Entity
@Table(name = "DEVICE_TABLE", catalog = "skm2_model_2")
public class Device implements Serializable{

    private Integer Id_Device;
    private Integer netNumber;
    private Ip ip;
    private Set<DataDay> dataDays = new HashSet<DataDay>();
    private Set<DataHour> dataHours = new HashSet<DataHour>();

    /*public void addDay(DataDay dataDay) {
        dataDay.setDevice(this);
        this.dataDays.add(dataDay);
    }

    public void addHour(DataHour dataHour){
        dataHour.setDevice(this);
        this.dataHours.add(dataHour);
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEVICE", nullable = false)
    public Integer getId_Device() {return Id_Device;}
    public void setId_Device(Integer id_Device) {
        Id_Device = id_Device;}

    @Column(name = "NET_NUMBER")
    public Integer getNetNumber() {return netNumber;}
    public void setNetNumber(Integer number) {this.netNumber = number;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_IP", referencedColumnName = "ID_IP", nullable = false)
    public Ip getIp() {return ip;}
    public void setIp(Ip ip) {this.ip = ip;}

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<DataDay> getDataDays() {return dataDays;}
    public void setDataDays(Set<DataDay> dataDays) {this.dataDays = dataDays;}

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<DataHour> getDataHours() {return dataHours;}
    public void setDataHours(Set<DataHour> dataHours) {this.dataHours = dataHours;}

}
