package com.newedo.projects.lfx.dao.impl;

import com.alibaba.fastjson.JSON;
import com.newedo.projects.lfx.dao.itf.IAddressDAO;
import com.newedo.projects.lfx.entity.Address;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dobbie on 15-2-10.
 */
public class AddressDAOImplTest {
    @Test
    public void addAll() throws Exception{
        IAddressDAO dao = new AddressDAOImpl("local");
        List<Address> addresses = new ArrayList<Address>();
        for (int i = 0; i < 10; i++) {
            addresses.add(new Address("地址"+i,i,10+i));
        }
        dao.addAll(addresses);
    }
    @Test
    public void getAll() throws Exception{
        IAddressDAO dao = new AddressDAOImpl("local");
        List<Address> addresses = dao.getAll();
//        System.out.println(addresses);
        System.out.println(JSON.toJSONString(addresses));
    }
}
