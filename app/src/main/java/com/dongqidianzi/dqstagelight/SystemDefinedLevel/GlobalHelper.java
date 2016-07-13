package com.dongqidianzi.dqstagelight.SystemDefinedLevel;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2016/7/13.
 */
public class GlobalHelper {
    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    public static String getVersion(Context context) {
      String version="";
        try
        {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
           version = info.versionName;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return version;
    }
}
