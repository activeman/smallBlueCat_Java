package com.csii.webhook.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by liushuai on 2020/1/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser {
    /**
     * 昵称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
}
