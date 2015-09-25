package com;

import com.buobao.eie.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by dqf on 2015/9/18.
 */

class Counter implements Runnable{
    private int start;
    private int end;
    private String name;

    public Counter (int start, int end, String name){
        super();
        this.start = start;
        this.end = end;
        this.name = name;
    }

    public void run() {
        boolean flag;
        for (int i=this.start;i<=this.end;i++){
            int tmp = (int)Math.sqrt(i);
            flag = true;
            for (int j=2;j<=tmp;j++){
                if (i%j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(name+":"+i);
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Tests {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private SessionFactory sessionFactory;

    @Test
    public void testa(){
        new Thread(new Counter(1,1000,"A")).start();
        //new Thread(new Counter(1001,2000,"B")).start();
        //new Thread(new Counter(2001,3000,"C")).start();
    }

    @Test
    public void testDB(){
        String sql = "select * from test";
        List<Map<String,Object>> lis = (List<Map<String, Object>>) jdbcTemplate.queryForList(sql);
        for (Map<String,Object> l : lis){
            System.out.println(l.get("name") + ":" + l.get("sal"));
        }

        System.out.println("-----------");
        Session session =  sessionFactory.openSession();
        TestEntity thisEntity = (TestEntity) session.get(TestEntity.class,1);
        System.out.println(thisEntity.getName());
        session.close();
    }

    @Test
    public void fileTest(){
        File newFile = new File("E:/","new.txt");
    }
}



























