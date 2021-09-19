package com.example.showcontact;

import java.io.Serializable;

public class Contact_Data_Model implements Serializable {


    private int imge_view;
    private String contactname;
    private String contacttitle;
    private String contactphone;

    public Contact_Data_Model() {
    }

    public Contact_Data_Model(int imge_view) {
        this.imge_view = imge_view;
    }

    public Contact_Data_Model(String contactname) {
        this.contactname = contactname;
    }

    public Contact_Data_Model(int imge_view, String contactname) {
        this.imge_view = imge_view;
        this.contactname = contactname;
    }

    public Contact_Data_Model(int imge_view, String contactname, String contacttitle) {
        this.imge_view = imge_view;
        this.contactname = contactname;
        this.contacttitle = contacttitle;
    }

    public Contact_Data_Model(int imge_view, String contactname, String contacttitle, String contactphone) {
        this.imge_view = imge_view;
        this.contactname = contactname;
        this.contacttitle = contacttitle;
        this.contactphone = contactphone;
    }

    public Contact_Data_Model(String contactname, String contacttitle, String contactphone) {
        this.contactname = contactname;
        this.contacttitle = contacttitle;
        this.contactphone = contactphone;
    }

    public int getImge_view() {
        return imge_view;
    }

    public void setImge_view(int imge_view) {
        this.imge_view = imge_view;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContacttitle() {
        return contacttitle;
    }

    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }
}
