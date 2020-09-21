package com.cpown.springcloud;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderMainFeign8001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign8001.class,args);
    }
}
