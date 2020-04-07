package demo.spring.common.config;

import demo.spring.common.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description
 * @author yuanjie 2019/12/18 17:49
 */
@ComponentScan
@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public Employee employee() {
        return new Employee();
    }
}
