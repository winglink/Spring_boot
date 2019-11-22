package com.learn;

import com.learn.dao.UserDao;
import com.learn.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class hellotest {
    private MockMvc mockMvc;
    @Autowired
    private UserDao userDao;
    @Test
    public void hello(){
        System.out.println("hello world");
    }

    @Before
    public  void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public  void getHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/?name=wing中")
               .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public  void findUserByUserName_Test(){
            User user=userDao.findUserByUserName("admin");
            System.out.println(user);
    }
}
