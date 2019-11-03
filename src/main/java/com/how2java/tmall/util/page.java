package com.how2java.tmall.util;

import java.util.PrimitiveIterator;

public class page {

    private  int start = 0;

    private  int count = 5  ;

    private  int total ;

    private  String param;

    private  int totalPage;

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public  int   getTotalPage(){
    int totalPage;
    if ( total <= count ){
        totalPage=1;
    }else {
        if ( total%count ==0){
            totalPage = total/count;
        }
        else
            totalPage= total/count +1;
    }
     return totalPage;
    }

    public int getLast(){
        int last;
        if ( total % count ==0){
            last = total - count;
        }
        else {
            last = total - total%count;
        }
        last = last<0?0:last;
        return  last;
    }
    public boolean isHasPreviouse(){
        if (start==0)
        return  false;
        return true;
    }

    public boolean isHasNext(){
        if (start==getLast())
        return  false;
        return true;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }
}
