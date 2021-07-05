package com.buildapi.gdp.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class GDP {
    private static final Logger logger = LoggerFactory.getLogger(GDP.class);
    private static AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private String gdp;


    public GDP() {

    }

    public GDP(String name, String gdp) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.gdp = gdp;

        logger.info("Country accessed");
        logger.debug("created Country with id of: " + this.id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    @Override
    public String toString() {
        return "GDP{" + "id=" + id + ", Country='" + name + '\'' + ", gdp=" + gdp + '}';
    }
}
