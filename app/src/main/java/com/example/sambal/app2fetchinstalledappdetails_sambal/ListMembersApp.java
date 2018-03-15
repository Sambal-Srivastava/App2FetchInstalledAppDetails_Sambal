package com.example.sambal.app2fetchinstalledappdetails_sambal;

import android.support.v7.app.AppCompatActivity;

public class ListMembersApp extends AppCompatActivity {
    String itemAppDetails ;

    public ListMembersApp(String itemAppDetails) {
        this.itemAppDetails = itemAppDetails;
    }

    public String getItemAppDetails() {
        return itemAppDetails;
    }

}
