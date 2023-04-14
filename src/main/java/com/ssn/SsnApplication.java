package com.ssn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//import com.netflix.discovery.EurekaClient;
 
@SpringBootApplication
//@EnableEurekaClient
//@EnableZuulProxy
//@EnableDiscoveryClient
 
public class SsnApplication {

//	@Autowired
//    @Lazy
//    private EurekaClient eurekaClient;
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    @Value("${server.port}")
//    private String portNumber;
//
//   
//
//    @Override
//    public String toString() {
//        System.out.println("Request received on port number " + portNumber);
//        return String.format("Hello from '%s with Port Number %s'!", eurekaClient.getApplication(appName)
//            .getName(), portNumber);
//    }
	public static void main(String[] args) {
 		SpringApplication.run(SsnApplication.class, args);
	}

}
