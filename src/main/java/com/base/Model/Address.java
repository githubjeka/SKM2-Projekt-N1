package com.base.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Georgi on 17.01.2017.
 */

@Entity                                                 //аннотация, регистрирующая класс как сущность БД
@Table(name = "ADDRESS_TABLE", catalog = "skm2_model_2")
public class Address implements Serializable {

    private Integer address_Id;
    private String address;
    private Set<Ip> ips = new HashSet<Ip>();

    /*public void addIp(Ip ip) {
        ip.setAddress(this);
        this.ips.add(ip);
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS", nullable = false)
    public Integer getAddress_Id() {
        return address_Id;
    }
    public void setAddress_Id(Integer address_Id) {
        this.address_Id = address_Id;
    }

    @Column(name = "ADDRESS", nullable = false, unique = true)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy ="address", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Ip> getIp() {
        return ips;
    }
    public void setIp(Set<Ip> ip) {
        this.ips = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address11 = (Address) o;

        if (!address_Id.equals(address11.address_Id)) return false;
        if (!address.equals(address11.address)) return false;
        return ips != null ? ips.equals(address11.ips) : address11.ips == null;

    }

    @Override
    public int hashCode() {
        int result = address_Id.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (ips != null ? ips.hashCode() : 0);
        return result;
    }
}

