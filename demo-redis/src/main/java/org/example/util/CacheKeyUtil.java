package org.example.util;

public class CacheKeyUtil {

    public static String getCompanySkuKey(Long companyId) {
        return "smart_list:" + companyId;
    }

    public static String getPageIdKey(String pageId) {
        return "lmc:page:" + pageId;
    }
}
