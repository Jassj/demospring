package demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description
 * @author yuanjie 2019/12/18 17:49
 */
@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public Employee employee() {
        System.out.println("Configuration Annotation");
        return new Employee();
    }
}
