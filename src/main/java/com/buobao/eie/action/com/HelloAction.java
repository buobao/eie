package com.buobao.eie.action.com;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.ParentPackage;

/**
 * Created by dqf on 2015/9/17.
 */
@ParentPackage("com")
public class HelloAction extends ActionSupport{
    public String input(){
        System.out.println("input...");
        return "input";
    }
}
