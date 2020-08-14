package com.mgskj.utils;

import com.mgskj.entity.CMSColor;

public class CMSColorUtil {
    public static String color2String(int color) {
        switch (color) {
            case CMSColor
                    .Black:
                return "黑色";
            case CMSColor
                    .Red:
                return "红色";
            case CMSColor
                    .Green:
                return "绿色";
            case CMSColor
                    .Orange:
                return "橙色";
            default:
                return "无";
        }
    }
}
