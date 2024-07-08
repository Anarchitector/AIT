package org.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("UserRepo")
    public UserRepository getUserRepo(){
        return new UserRepository();
    }

    @Bean("UserServ")
    public UserService getUserService(UserRepository userRepo){
        return new UserService(userRepo);
    }
}
