package com.workflow.conductor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "mysql")
public class MysqlConnection {
    public static String url;
    public static String username;
    public static String password;
}
