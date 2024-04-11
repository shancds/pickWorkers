package com.s92061491.pickworkers.Domain;

public class NotificationDomain {
    String name;
    String datetime;

    public NotificationDomain(String name, String datetime) {
        this.name = name;
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
