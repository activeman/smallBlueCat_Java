//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.csii.webhook.model.pojo;

import com.alibaba.da.coin.ide.spi.standard.SecurityWrapperTaskQuery;
import com.csii.webhook.model.pojo.TaskQuery;
import com.alibaba.da.coin.ide.spi.trans.GsonUtils;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class MetaFormat {
    public MetaFormat() {
    }

    public static TaskQuery parseToQuery(String requestMetaData) {
        Type type = (new TypeToken<TaskQuery>() {
        }).getType();
        TaskQuery query = (TaskQuery) GsonUtils.gson.fromJson(requestMetaData, type);
        return query;
    }

    public static SecurityWrapperTaskQuery parseToWrapperQuery(String requestMetaData) {
        Type type = (new TypeToken<SecurityWrapperTaskQuery>() {
        }).getType();
        SecurityWrapperTaskQuery wapperQuery = (SecurityWrapperTaskQuery)GsonUtils.gson.fromJson(requestMetaData, type);
        return wapperQuery;
    }
}
