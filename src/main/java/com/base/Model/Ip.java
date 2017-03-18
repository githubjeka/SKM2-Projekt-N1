package com.base.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Georgi on 08.01.2017.
 */
@Entity
@Table(name = "IP_TABLE", catalog = "skm2_model_2")
public class Ip implements Serializable{

    private Integer ip_Id;
    private String ipName;
    private Integer port;
    private Address address;
    private Set<Device> devices = new HashSet<Device>();

    /*public void addNumber(Device device){
        device.setIp(this);
        this.devices.add(device);
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IP", nullable = false)
    public Integer getIp_Id() {
        return ip_Id;
    }
    public void setIp_Id(Integer ipNumber_Id) {
        this.ip_Id = ipNumber_Id;
    }

    @Column(name = "IP_NAME", nullable = false, unique = true)
    public String getIpName() {
        return ipName;
    }
    public void setIpName(String ipName) {
        this.ipName = ipName;
    }

    @Column(name = "PORT", nullable = false)
    public Integer getPort() {return port;}
    public void setPort(Integer port) {this.port = port;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID_ADDRESS", nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {this.address = address;}


    /*@OneToMany(mappedBy = "ip", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<DataDay> getDataDay() {
        return dataDay;
    }
    public void setDataDay(Set<DataDay> dataDay) {
        this.dataDay = dataDay;
    }

    @OneToMany(mappedBy = "ip", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<DataHour> getDataHour() {return dataHour;}
    public void setDataHour(Set<DataHour> dataHour) {
        this.dataHour = dataHour;
    }
    */
    @OneToMany(mappedBy = "ip", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Device> getDevices() {return devices;}
    public void setDevices(Set<Device> devices) {this.devices = devices;}
}
