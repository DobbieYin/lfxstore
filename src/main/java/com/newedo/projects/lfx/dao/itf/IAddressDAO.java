package com.newedo.projects.lfx.dao.itf;

import com.newedo.projects.lfx.entity.Address;

import java.util.List;

/**
 * 地址数据操作接口
 */
public interface IAddressDAO {
    /**
     * 获取所有地址
     * @return 地址集合
     * @throws Exception
     */
    List<Address> getAll() throws Exception;

    /**
     * 通过id查找一个地址对象
     * @param addr
     * @return
     * @throws Exception
     */
    Address findById(String addr) throws Exception;

    /**
     * 新增所有地址集合
     * @param vos 地址集合
     * @throws Exception
     */
    void addAll(List<Address> vos) throws Exception;

    /**
     * 保存所有地址集合
     * @param vos 地址集合
     * @throws Exception
     */
    void updateAll(List<Address> vos) throws Exception;

    /**
     * 删除所有地址集合
     * @param vos 地址集合
     * @throws Exception
     */
    void deleteAll(List<Address> vos) throws Exception;

    /**
     * 删除所有地址集合
     * @throws Exception
     */
    void deleteAll() throws Exception;
}
