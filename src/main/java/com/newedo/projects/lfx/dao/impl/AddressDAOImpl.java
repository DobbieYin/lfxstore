package com.newedo.projects.lfx.dao.impl;

import com.newedo.projects.lfx.dao.itf.IAddressDAO;
import com.newedo.projects.lfx.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * 地址数据操作接口实现类
 */
public class AddressDAOImpl implements IAddressDAO {
    private EntityManagerFactory factory;
    private EntityManager em;
    private String pu_name;
    public AddressDAOImpl(String pu_name){
        this.pu_name = pu_name;
        initEntityMgrAndFactory();
    }

    private void initEntityMgrAndFactory() {
        this.factory = Persistence.createEntityManagerFactory(this.pu_name);
        this.em = factory.createEntityManager();
    }


    @Override
    public List<Address> getAll() throws Exception{
        try{
            initEntityMgrAndFactory();
            List resultList = new ArrayList();
            resultList = em.createQuery("from Address").getResultList();//获得结果列表
            return resultList;
        } catch (Exception e) {
            throw new Exception(e.getMessage(),e);
        } finally{
            em.close();
            factory.close();
        }
    }

    @Override
    public Address findById(String addr) throws Exception {
        try{
            if(addr == null) return null;
            initEntityMgrAndFactory();
            return em.find(Address.class, addr);//Hibernate:get()非延迟，不缓存，null
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e.getMessage(),e);
        } finally{
            em.close();
            factory.close();
        }
    }

    @Override
    public void addAll(List<Address> vos) throws Exception{
        try {
            if(vos != null && !vos.isEmpty()){
                initEntityMgrAndFactory();
                em.getTransaction().begin();
                for (Address address : vos) {
                    if(address != null){
                        //新增
                        em.persist(address);
                    }
                }
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception(e.getMessage(),e);
        } finally {
            em.close();
            factory.close();
        }
    }

    @Override
    public void updateAll(List<Address> vos) throws Exception{
        try {
            if(vos != null && !vos.isEmpty()){
                initEntityMgrAndFactory();
                em.getTransaction().begin();
                for (Address address : vos) {
                    Address addressById = findById(address.getAddr());
                    if(addressById != null){
                        //更新
                        em.merge(address);
                    }
                }
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception(e.getMessage(),e);
        } finally {
            em.close();
            factory.close();
        }
    }

    @Override
    public void deleteAll(List<Address> vos) throws Exception{
        try {
            if(vos != null && !vos.isEmpty()){
                initEntityMgrAndFactory();
                em.getTransaction().begin();
                for (Address address : vos) {
                    Address findResult = em.find(Address.class, address.getAddr());
                    if(findResult != null){
                        //删除
                        em.remove(findResult);
                    }
                }
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e.getMessage(),e);
        } finally {
            em.close();
            factory.close();
        }
    }

    @Override
    public void deleteAll() throws Exception{
        initEntityMgrAndFactory();
        deleteAll(getAll());
    }
}
