package com.newedo.projects.lfx.biz.impl;

import com.alibaba.fastjson.JSON;
import com.newedo.projects.lfx.biz.itf.IMapStoreService;
import com.newedo.projects.lfx.dao.impl.AddressDAOImpl;
import com.newedo.projects.lfx.dao.itf.IAddressDAO;
import com.newedo.projects.lfx.entity.Address;

import java.util.List;

/**
 * Created by dobbie on 15-2-11.
 */
public class MapStoreServiceImpl implements IMapStoreService {
    private IAddressDAO dao = new AddressDAOImpl("coding");
    public MapStoreServiceImpl(String pu_name){
        this.dao = new AddressDAOImpl(pu_name);
    }
    public MapStoreServiceImpl(){}

    @Override
    public String getAll() {
        String result = null;
        try {
            List<Address> addresses = dao.getAll();
            if(addresses != null && !addresses.isEmpty()){
                for (Address address : addresses) {
                    address.setAddr(new String(address.getAddr().getBytes(), "utf8"));
                }
            }
            result = JSON.toJSONString(addresses);
        } catch (Exception e) {
            System.err.println("获取所有地址异常："+e.getMessage());
            result = "获取所有地址异常："+e.getMessage();
        }
        return result;
    }

    @Override
    public String updateAll(String json) {
        String result = null;
        try {
            if(json != null && !json.trim().equals("")){
                dao.updateAll(JSON.parseArray(json, Address.class));
            }
        } catch (Exception e) {
            System.err.println("保存所有地址异常："+e.getMessage());
            result = "保存所有地址异常："+e.getMessage();
        }
        return result;
    }

    @Override
    public String addAll(String json) {
        String result = null;
        try {
            if(json != null && !json.trim().equals("")){
                dao.addAll(JSON.parseArray(json, Address.class));
            }
        } catch (Exception e) {
            System.err.println("保存所有地址异常："+e.getMessage());
            result = "保存所有地址异常："+e.getMessage();
        }
        return result;
    }

    @Override
    public String reset() {
        String result = null;
        try {
            dao.deleteAll();
        } catch (Exception e) {
            System.err.println("重置异常："+e.getMessage());
            result = "重置异常："+e.getMessage();
        }
        return result;
    }
}
