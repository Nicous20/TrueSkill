package learn_spring;

import learn_spring.dao.TestDao;
import learn_spring.service.TestService;
import learn_spring.service.impl.TestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        TestService testService = new TestServiceImpl();
//        testService.save();


        //get Ioc container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //get bean from appContext
        TestService testService = (TestService) ctx.getBean("testService");
        testService.save();

    }
}
