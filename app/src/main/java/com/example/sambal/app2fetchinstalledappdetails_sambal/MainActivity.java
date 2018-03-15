package com.example.sambal.app2fetchinstalledappdetails_sambal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView userInstalledApps = findViewById(R.id.installed_app_list);

        List<ListMembersApp> installedApps = getInstalledApps();
        MyAdapter installedAppAdapter = new MyAdapter(MainActivity.this, installedApps);
        userInstalledApps.setAdapter(installedAppAdapter);


    }

    private List<ListMembersApp> getInstalledApps() {
        List<ListMembersApp> res = new ArrayList<ListMembersApp>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((isSystemPackage(p) == false)) {
                String Package = p.packageName ;
                String AppName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                String VersionName = p.versionName;
                int VersionShort = p.versionCode;
//                        " , App Name : " +
//                        p.applicationInfo.loadLabel(getPackageManager()).toString()
//                                + " , Version Name : " +  p.versionName.toString()
//                                + " , Version Code : " +  p.versionCode ;


                ModelForJson obj = new ModelForJson(Package, AppName, VersionName, VersionShort);
                obj.setPackageName(Package);
                obj.setAppName(AppName);
                obj.setVerName(VersionName);
                obj.setVerShort(VersionShort);


                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String JSON = gson.toJson(obj);


                res.add(new ListMembersApp(JSON));
            }
        }
        return res;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }
}
