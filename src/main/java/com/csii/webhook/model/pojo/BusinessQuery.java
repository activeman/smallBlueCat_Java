package com.csii.webhook.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * Created by liushuai on 2020/4/23.
 */
/*
https://www.cnblogs.com/pcheng/p/10945476.html

@Data 实体类上使用，实体类的各个属性就不需要书写get和set方法。

安装方法：

1、File→Settings→Plugins，输入mybatis plugin，本地没搜到，就可以点击Search in repositories（或直接点击Browse repositories进入搜索），搜到Free MyBatis plugin后选择Install进行安装即可，安装后需重启IDEA。

@AllArgsConstructor  加在类上，可以生成含实体类全参数的构造方法。

@NoArgsConstructor  加在类上，可以生成无参构造方法。

@RequiredArgsConstructor  加在类上，配合@NonNull注解使用，生成指定参数的构造方法。比如在age属性前面加@NonNull注解，则User生成需要age参数的构造方法。

@Getter  加在类上，可以生成实体类所有属性的getter方法。

@Setter  加在类上，可以生成实体类所有属性的setter方法。

@ToString  加在类上，调用toString()方法，可以输出实体类中所有属性的值。

 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BusinessQuery {
    private String Id, Token, SessionId, Utterance, DeviceOpenId;//全部继承TaskQuery信息//每一次请求都要验证token
    private String BusinessIntent;//业务意图，非TaskQuery意图
    private Map<String, SlotEntity> SlotEntities;//从TaskQuery信息处理后的得到

}

