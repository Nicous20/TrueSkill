package learn_spring.service.impl;

import learn_spring.dao.TestDao;
import learn_spring.service.TestService;

public class TestServiceImpl implements TestService {
    //not need testDaoImpl using DI
    private TestDao testDao;
    public void save(){
        System.out.println("test serv save");
        testDao.save();

    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }
}
