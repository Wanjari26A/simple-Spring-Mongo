package com.app;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTryJavaApplication {
  public static void main(String[] args) {
    BasicConfigurator.configure();
    SpringApplication.run(DemoTryJavaApplication.class, args);
	}
}
