package pl.mskreczko.trackingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class TrackingapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackingapiApplication.class, args);
    }

}
