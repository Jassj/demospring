package demo.spring.common.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * description: employee实体类
 * @author yuanjie 2019/12/18 19:04
 */
@Lazy //延迟初始化，在第一次获取bean的时候进行初始化
public class Employee {
    private int employeeId;
    private String departId;
    private String employeeName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getEmployeeName() {
        System.out.println(employeeName);
        return employeeName;
    }

    @Value(value = "Mike")
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @PostConstruct //初始化回调函数，等价于init-method = init
    public void init() {
        System.out.println("Employee init");
    }

    @PreDestroy //销毁回调函数，等价于destroy-method = destroy
    public void destroy() {
        System.out.println("Employee destroy");
    }
}
