package org.tphc.wlp;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long nanotime = System.nanoTime();
    private Date date = new Date();
    private String data = UUID.randomUUID().toString();

    public Long getId() {
        return id;
    }

    public long getNanotime() {
        return nanotime;
    }

    public Date getDate() {
        return date;
    }

    public String getData() {
        return data;
    }
}