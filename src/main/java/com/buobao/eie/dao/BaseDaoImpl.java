package com.buobao.eie.dao;

import com.buobao.eie.entity.BaseEntity;
import com.buobao.eie.utils.Limit;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/10/12.
 */
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao {
    public Class<T> entityClass;

    @Resource
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
        Class c = this.getClass();
        Type type = c.getGenericSuperclass();
        if(type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType)type).getActualTypeArguments();
            this.entityClass = (Class)parameterizedType[0];
        }

    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public T get(String id) {
        String hql = "from "+this.entityClass.getName()+" t where t.id =:id";
        Query query = getSession().createQuery(hql).setParameter("id", id);
        return (T) query.uniqueResult();
    }

    public List<T> findByLimit(Limit limit) {

        Criteria criteria;
        if (limit.getDetachedCriteria() != null){
            criteria = limit.getDetachedCriteria().getExecutableCriteria(getSession());
        } else{
            criteria = getSession().createCriteria(entityClass);
        }

        Map<String, Object> param = limit.getParam();
        if (param != null && param.size() > 0){
            for (String key : param.keySet()){
                criteria.add(Restrictions.eq(key, param.get(key)));
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

    public void update(BaseEntity entity) {
        getSession().update(entity);
    }

    public void add(BaseEntity entity) {
        getSession().save(entity);
    }

}
