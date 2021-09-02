package com.earthquake.managementPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.*;
import java.util.Properties;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class UploadFile8001 {
    public static void main(String[] args) {
//        ProxySelector.getDefault();
//        Properties prop = System.getProperties();
//
//        prop.setProperty("ftp.proxyHost", "10.5.161.253");
//        prop.setProperty("ftp.proxyPort", "8099");
//        prop.setProperty("ftp.nonProxyHosts", "localhost|10.5.103.127");
//
//        // socks代理服务器的地址与端口
//        prop.setProperty("socksProxyHost", "10.5.161.253");
//        prop.setProperty("socksProxyPort", "8099");
//        prop.setProperty("socksNonProxyHosts", "localhost|10.5.103.127");
//        // 设置登陆到代理服务器的用户名和密码
//
//        Authenticator.setDefault(new MyAuthenticator("userName", "Password"));


        SpringApplication.run(UploadFile8001.class,args);
    }
    static class MyAuthenticator extends Authenticator {
        private String user = "jzzx";
        private String password = "jzzx";
        public MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }
    }
}
