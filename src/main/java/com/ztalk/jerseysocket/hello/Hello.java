package com.ztalk.jerseysocket.hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {

    private static final Logger logger = LogManager.getLogger();
    private String id;
    private String summary;
    private String description;

    public Hello (){
        new Hello("1", "Frank");
    }

    public Hello (String id, String name){
        this.id = id;
        this.summary = summary;
    }
    public String getId() {
        logger.debug("getId() is called");
        return id;
    }
    public void setId(String id) {
        logger.debug("setId() is called");
        this.id = id;
    }
    public String getSummary() {
        logger.debug("getSummary() is called");
        return summary;
    }
    public void setSummary(String summary) {
        logger.debug("setSummary() is called");
        this.summary = summary;
    }
    public String getDescription() {
        logger.debug("getDescription() is called");
        return description;
    }
    public void setDescription(String description) {
        logger.debug("setDescription() is called");
        this.description = description;
    }
}
