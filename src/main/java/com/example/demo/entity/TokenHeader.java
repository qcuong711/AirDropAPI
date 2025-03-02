package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "token_header")
public class TokenHeader {
    @Id
    private int id;
    public int getid()
    {
        return this.id;
    }
    public void setid(int value)
    {
        this.id = value;
    }

    private String code;
    public String getcode()
    {
        return this.code;
    }
    public void setcode(String value)
    {
        this.code = value;
    }

    private String name;
    public String getname()
    {
        return this.name;
    }
    public void setname(String value)
    {
        this.name = value;
    }

    private String describe;
    public String getdescribe()
    {
        return this.describe;
    }
    public void setdescribe(String value)
    {
        this.describe = value;
    }

    private short status;
    public short getstatus()
    {
        return this.status;
    }
    public void setstatus(short value)
    {
        this.status = value;
    }

    private String img_url;
    public String getimg_url()
    {
        return this.img_url;
    }
    public void setimg_url(String value)
    {
        this.img_url = value;
    }

    public TokenHeader() {
    }

    public TokenHeader(int id_,String code_,String name_,String describe_,short status_,String img_url_)
    {
        this.id = id_;
        this.code = code_;
        this.name = name_;
        this.describe = describe_;
        this.status = status_;
        this.img_url = img_url_;
    }
}
