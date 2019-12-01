package com.learn;


import com.learn.dao.UserDaoMo;
import com.learn.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class mongotest{
    @Autowired
    private UserDaoMo userDaoMo;

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("wing");
        user.setPassword("123");
        user.setLastVisit(new Date());
        userDaoMo.saveUser(user);
    }
}

