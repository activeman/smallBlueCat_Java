package com.csii.webhook.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liushuai on 2020/4/23.
 */
public class IntentCommon {
    public static final String DONE = "done";

    public static final String ANSWER_DEFAULT = "欢迎使用渤海银行";//需要一个util方法，替换字符串里的槽位，后面放若干个数值

    public static final Map<String, String> IntentKV = new HashMap<String, String>() {{
        put(DONE, ANSWER_DEFAULT);

    }};
}
