package com;

import org.junit.Test;

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


public class Tests {
    @Test
    public void testa(){
        new Thread(new Counter(1,1000,"A")).start();
        //new Thread(new Counter(1001,2000,"B")).start();
        //new Thread(new Counter(2001,3000,"C")).start();
    }
}



























