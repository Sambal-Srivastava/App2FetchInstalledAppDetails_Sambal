package com.example.sambal.app2fetchinstalledappdetails_sambal;

/**
 * Created by Sambal on 2/16/2018.
 */

public class ModelForJson {

    private String PackageName;
    private String AppName;
    private String VerName;
    private int VerShort;

    public ModelForJson() {
    }

    public ModelForJson(String packageName, String appName, String verName, int verShort) {
        PackageName = packageName;
        AppName = appName;
        VerName = verName;
        VerShort = verShort;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public void setVerName(String verName) {
        VerName = verName;
    }

    public void setVerShort(int verShort) {
        VerShort = verShort;
    }

    public String getPackageName() {
        return PackageName;
    }

    public String getAppName() {
        return AppName;
    }

    public String getVerName() {
        return VerName;
    }

    public int getVerShort() {
        return VerShort;
    }
}
