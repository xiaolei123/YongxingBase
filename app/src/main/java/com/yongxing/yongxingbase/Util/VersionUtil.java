package com.yongxing.yongxingbase.Util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.xiaolei.easyfreamwork.utils.Log;

/**
 * Created by xiaolei on 2017/5/3.
 */

public class VersionUtil
{
    public static String getVersionName(Context context)
    {
        String versionName = "1.0.0";
        // 获取packagemanager的实例  
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息  
        PackageInfo packInfo = null;
        try
        {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionName = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return versionName;
    }

    public static int getVersionCode(Context context)
    {
        int versionCode = 0;
        // 获取packagemanager的实例  
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息  
        PackageInfo packInfo = null;
        try
        {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 版本号比较
     * @param version1
     * @param version2
     * @return  0代表相等，1代表version1大于version2，-1代表version1小于version2
     */
    public static int compareVersion(String version1, String version2)
    {
        Log.d("VERSION1", "version1:" + version1);
        Log.d("VERSION2", "version2:" + version2);
        if (version1.equals(version2))
        {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        
        int index = 0;
        // 获取最小长度值
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        // 循环判断每位的大小
        //Log.d("VERSION", "verTag2=2222=" + version1Array[index]);
        while (index < minLen
                && (diff = Integer.parseInt(version1Array[index])
                - Integer.parseInt(version2Array[index])) == 0)
        {
            index++;
        }
        if (diff == 0)
        {
            // 如果位数不一致，比较多余位数
            for (int i = index; i < version1Array.length; i++)
            {
                if (Integer.parseInt(version1Array[i]) > 0)
                {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++)
            {
                if (Integer.parseInt(version2Array[i]) > 0)
                {
                    return -1;
                }
            }
            return 0;
        } else
        {
            return diff > 0 ? 1 : -1;
        }
    }
}
