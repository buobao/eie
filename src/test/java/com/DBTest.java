package com;

import com.buobao.eie.dao.TestEntityDao;
import com.buobao.eie.entity.TestEntity;
import com.buobao.eie.service.TestEntityService;
import com.buobao.eie.utils.Limit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/9/28.
 */
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DBTest extends AbstractTransactionalJUnit4SpringContextTests {
    //@Resource
    private SessionFactory sessionFactory;
    private Session session;

    @Resource
    private TestEntityDao testEntityDao;

    @Resource
    private TestEntityService testEntityService;

    @Test
    public void test1(){
        String hql = "from TestEntity";
        Query query = session.createQuery(hql);
        List<TestEntity> list = (List<TestEntity>) query.list();
        for (TestEntity e :list){
            System.out.println("id:"+e.getId()+"|name:"+e.getName()+"|sal:"+e.getSal());
        }
    }

    @Test
    public void test2(){
        String hql = "select new map(t.id,t.name,t.sal) from TestEntity t";
        Query query = session.createQuery(hql);
        List<Map> list = query.list();
        for (Map m:list){
            System.out.println("id:"+m.get("0")+"|name:"+m.get("1")+"|sal:"+m.get("2"));
        }
    }

    @Test
    public void test3(){
        String hql = "select new map(t.id as id,t.name as name,t.sal as sal) from TestEntity t";
        Query query = session.createQuery(hql);
        List<Map> list = query.list();
        for (Map m : list){
            System.out.println("id:"+m.get("id")+"|name:"+m.get("name")+"|sal:"+m.get("sal"));
        }
    }

    @Test
    public void test4(){
        //需要在test模型中定义构造器
        String hql = "select new TestEntity(t.id,t.name,t.sal) from TestEntity t";
        Query query = session.createQuery(hql);
        List<TestEntity> list = query.list();
        for (TestEntity t:list){
            System.out.println("id:"+t.getId()+"|name:"+t.getName()+"|sal:"+t.getSal());
        }
    }

    @Test
    public void test5(){
        //去重复,当返回一列值得时候默认是Object而不是Map！
        String hql = "select distinct t.dep from TestEntity t";
        Query query = session.createQuery(hql);
        List<Object> list = query.list();
        for (Object m:list){
            System.out.println(m.toString());
        }
    }

    @Test
    public void test6(){
        //where子句
        String hql = "select t.name from TestEntity t where t.dep= 'A' ";
        Query query = session.createQuery(hql);
        List<Object> list = query.list();
        for (Object o:list){
            System.out.println(o.toString());
        }
    }

    @Test
    public void test7(){
        String hql = "select t.name from TestEntity t where t.name like '_e%'";
        Query query = session.createQuery(hql);
        List<Object> list = query.list();
        for (Object o:list){
            System.out.println(o.toString());
        }
    }

    @Test
    public void test8(){
        String hql = "select new map(t.name as name,t.sal as sal,t.dep as dep) from TestEntity t where t.dep in ('A','D') order by t.dep desc";
        Query query = session.createQuery(hql);
        List<Map> list = query.list();
        for (Map m:list){
            System.out.println("name:"+m.get("name")+"|sal:"+m.get("sal")+"|dep:"+m.get("dep"));
        }
    }

    @Test
    public void test9(){
        String hql = "select new Map(t.name as name,t.dep as dep) from TestEntity t where t.dep > 'B'";
        Query query = session.createQuery(hql);
        List<Map> list = query.list();
        for (Map m:list){
            System.out.println("name:"+m.get("name")+"|dep:"+m.get("dep"));
        }
    }

    @Test
    public void test10(){
        String hql = "from TestEntity t where t.dep between 'A' and 'C' ";
        Query query = session.createQuery(hql);
        List<TestEntity> list = query.list();
        for (TestEntity t:list){
            System.out.println(t.getDep());
        }
    }

    @Test
    public void test11(){
        //要保证查询结果只有一个或没有
        String hql = "from TestEntity t where t.name='Tom'";
        Query query = session.createQuery(hql);
        TestEntity t = (TestEntity) query.uniqueResult();
        System.out.println("name:"+t.getName()+",sal:"+t.getSal());
    }

    @Test
    public void testDao1(){
//        TestEntity testEntity = (TestEntity) testEntityDao.get("1");
//        System.out.println(testEntity.getName());

//        TestEntity testEntity = new TestEntity();
//        testEntity.setName("张飞");
//        testEntity.setDep("F");
//        testEntity.setSal(9000);
//        testEntityDao.add(testEntity);

//        testEntityDao.delete("8a8a8b98504fb0dc01504fb0df030000");

        TestEntity testEntity = (TestEntity) testEntityDao.get("1");
        testEntity.setName("Jack");
        testEntityDao.update(testEntity);
    }

    @Test
    public void testService1(){
        TestEntity testEntity = (TestEntity) testEntityService.get("2");
        System.out.println(testEntity.toString());
    }

    @Test
    public void testImportant(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("dep", "A");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TestEntity.class);
        //detachedCriteria.add(Restrictions.gt("sal",99));
        detachedCriteria.add(Restrictions.or(Restrictions.like("name", "%y%"),Restrictions.in("dep", new String[]{"A","C"})));
        Limit limit = new Limit(null,null,null,detachedCriteria,null,null);
        List<TestEntity> list = testEntityService.findByLimit(limit);
        if (list != null){
            for (TestEntity t:list){
                System.out.println(t.toString());
            }
        }
    }

    @Before
    public void setUp() throws Exception{
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
//        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception{
//        session.close();
    }
}
