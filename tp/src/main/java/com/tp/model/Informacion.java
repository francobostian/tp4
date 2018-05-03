package com.tp.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Informacion {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String op;
    private String browser;

    public Informacion() {
	super();
    }

    public Informacion(String op, String browser) {
	super();
	this.op = op;
	this.browser = browser;
    }

    public String getOp() {
	return op;
    }

    public void setOp(String op) {
	this.op = op;
    }

    public String getBrowser() {
	return browser;
    }

    public void setBrowser(String browser) {
	this.browser = browser;
    }

    public long getId() {
	return id;
    }

    public ZonedDateTime getDept() {
	return fechaHora;
    }

    private ZonedDateTime fechaHora = ZonedDateTime.now();

    @Override
    public String toString() {
	return "Model [id=" + id + ", op=" + op + ", browser=" + browser + "]";
    }

}
