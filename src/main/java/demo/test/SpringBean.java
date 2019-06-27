package demo.test;

import demo.vo.StudentVo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringBean {
    public static void main(String[] args){
        //基于XML的配置文件定义Bean元数据,并加载到Spring上下文中
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\IdeaWorkspace\\demospring\\src\\main\\webapp\\WEB-INF\\config\\servlet-context.xml");
        //通过id获取上下文中的bean实例
        StudentVo student = (StudentVo) context.getBean("student");
        //使用实例
        System.out.println(student.toString());
    }
}
