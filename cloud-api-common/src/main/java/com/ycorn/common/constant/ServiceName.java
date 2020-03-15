package com.ycorn.common.constant;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-15 19:49
 */
public class ServiceName {

    public final static String PAYMENT_ZK_SERVICE_NAME = "cloud-service-payment-zk";

    public static String getPrefixUrl(String name) {
        return String.format("http://%s/", name);
    }

}