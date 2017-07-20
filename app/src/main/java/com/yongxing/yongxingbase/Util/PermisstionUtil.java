package com.yongxing.yongxingbase.Util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.LinkedList;
import java.util.List;

/**
 * 权限申请工具
 * Created by admin on 2017/7/19.
 */

public class PermisstionUtil
{
    /**
     * 检查和申请权限
     *
     * @param permisstion
     */
    public static void checkPermisstion(Activity context, String[] permisstion)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            List<String> permisstions = new LinkedList<>();
            for (String per : permisstion)
            {
                if (context.checkSelfPermission(per) == PackageManager.PERMISSION_DENIED)
                {
                    permisstions.add(per);
                }
            }
            if (permisstions.size() > 0)
            {
                context.requestPermissions(permisstions.toArray(new String[permisstions.size()]), 1);
                permisstions.clear();
            }
        }
    }
}
