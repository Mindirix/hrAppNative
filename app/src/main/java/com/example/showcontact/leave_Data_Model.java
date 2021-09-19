package com.example.showcontact;

import java.io.Serializable;

public class leave_Data_Model implements Serializable {


    String manager, reason,numdays, startdate;

    public leave_Data_Model() {
    }

    public leave_Data_Model(String numdays, String startdate, String manager, String reason) {
        this.numdays = numdays;
        this.startdate = startdate;
        this.manager = manager;
        this.reason = reason;
    }

    public leave_Data_Model(String startdate, String manager, String reason) {
        this.startdate = startdate;
        this.manager = manager;
        this.reason = reason;
    }


    public String getNumdays() {
        return numdays;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getManager() {
        return manager;
    }

    public String getReason() {
        return reason;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setNumdays(String numdays) {
        this.numdays = numdays;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
}





