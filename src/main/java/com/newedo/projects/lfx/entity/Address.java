package com.newedo.projects.lfx.entity;

import javax.persistence.*;

/**
 * 地址类
 */

@Entity
public class Address {
    @Id
    private String addr;
    private Double lng;//经度
    private Double lat;//纬度

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Address(String addr, Double lng, Double lat) {
        this.addr = addr;
        this.lng = lng;
        this.lat = lat;
    }
    public Address(String addr, Integer lng, Integer lat) {
        this(addr,Double.valueOf(lng),Double.valueOf(lat));
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "addr='" + addr + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
