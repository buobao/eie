package com.buobao.eie.dao;

import com.buobao.eie.entity.TestEntity;
import com.buobao.eie.utils.Limit;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/10/10.
 */
@Repository
public class TestEntityDaoImpl implements TestEntityDao {
    @Resource
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Object get(String id) {
        String hql = "from TestEntity t where t.id =:id";
        Query query = getSession().createQuery(hql).setParameter("id", id);
        return (TestEntity) query.uniqueResult();
    }

    public List<TestEntity> findByLimit(Limit limit) {

        Criteria criteria;
        if (limit.getDetachedCriteria() != null){
            criteria = limit.getDetachedCriteria().getExecutableCriteria(getSession());
        } else{
            criteria = getSession().createCriteria(TestEntity.class);
        }

        Map<String, Object> param = limit.getParam();
        if (param != null && param.size() > 0){
            for (String key : param.keySet()){
                criteria.add(Restrictions.eq(key,param.get(key)));
            }
        }

        if (limit.getOrderByColumnName() != null && !"".equals(limit.getOrderByColumnName())){
            if (limit.getOrderByType()){
                criteria.addOrder(org.hibernate.criterion.Order.asc(limit.getOrderByColumnName()));
            }else{
                criteria.addOrder(org.hibernate.criterion.Order.desc(limit.getOrderByColumnName()));
            }
        }

        if (limit.getPageSize() > 0){
            Integer start = limit.getStart();

            criteria.setFirstResult(start);
            criteria.setMaxResults(limit.getPageSize());
        }

        return criteria.list();
    }

    public void delete(String id) {
        getSession().delete(get(id));
//        Transaction tx = null;
//        Session session = getSession();
//        try{
//            tx = session.beginTransaction();
//            session.delete(get(id));
//            tx.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            if (null != tx){
//                tx.rollback();
//            }
//        }finally {
//
//        }
    }

    public void update(TestEntity testEntity) {
        getSession().update(testEntity);
    }

    public void add(TestEntity testEntity) {
        getSession().save(testEntity);
    }
}
