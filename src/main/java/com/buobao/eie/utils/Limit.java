package com.buobao.eie.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.Map;

/**
 * Created by dqf on 2015/10/10.
 */
public class Limit {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;
    private Map<String, Object> param = null;
    private DetachedCriteria detachedCriteria = null;
    /**
     * true为升序，false为降序
     */
    private boolean orderByType = false;
    private String orderByColumnName = null;

    public Limit(){}

    public Limit(Integer pageNumber,Integer pageSize, Map<String, Object> param, DetachedCriteria detachedCriteria,String orderByColumnName,Boolean orderByType){

        if (pageSize == null || pageSize<=0){
            this.pageNumber = 0;
            this.pageSize = 0;
        } else {
            this.pageSize = pageSize;
            if (pageNumber == null || pageNumber <=0){
                this.pageNumber = 0;
            }else{
                this.pageNumber = pageNumber;
            }
        }

        this.param = param;
        this.detachedCriteria = detachedCriteria;
        this.orderByColumnName = orderByColumnName;
        if (orderByType != null) {
            this.orderByType = orderByType;
        }
    }

    /**
     * 获取查询起始
     * @return
     */
    public Integer getStart(){
        return (this.getPageNumber()-1)*this.getPageSize();
    }

    /**
     * 获取查询结束
     * @return
     */
    public Integer getMaxResults(){
        return this.getPageSize();
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }

    public boolean getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(boolean orderByType) {
        this.orderByType = orderByType;
    }

    public String getOrderByColumnName() {
        return orderByColumnName;
    }

    public void setOrderByColumnName(String orderByColumnName) {
        this.orderByColumnName = orderByColumnName;
    }
}
