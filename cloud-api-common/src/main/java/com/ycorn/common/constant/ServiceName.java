package com.ycorn.common.constant;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-15 19:49
 */
public class ServiceName {
    public final static String PAYMENT_BASE_SERVICE_NAME = "CLOUD-SERVICE-PAYMENT";

    public final static String PAYMENT_ZK_SERVICE_NAME = "cloud-service-payment-zk";

    public final static String PAYMENT_CONSUL_SERVICE_NAME = "cloud-service-payment8005-consul";

    public final static String PAYMENT_HYSTRIX_SERVICE_NAME = "cloud-service-payment8006-hystrix";

    public static String getPrefixUrl(String name) {
        return String.format("http://%s/", name);
    }

}