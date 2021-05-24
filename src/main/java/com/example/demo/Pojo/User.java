package com.example.demo.Pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

//这是lombok,有它可以省去get set等代码
@Table(name = "tkuser")     //指定表名
public class User {

    @Id                         //需要指定主键
    @Column(name = "id")    //指定mysql用户表字段名,如果不指定,这里的驼峰命名默认对应数据库字段下划线分隔开
    private Integer id;
    private String tkname;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTkname() {
        return tkname;
    }

    public void setTkname(String tkname) {
        this.tkname = tkname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
