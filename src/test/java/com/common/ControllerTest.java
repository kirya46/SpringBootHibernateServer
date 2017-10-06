package com.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@EnableAutoConfiguration
public class ControllerTest {

//    @Autowired
//    private MockMvc mvc;

//    @Test
//    public void getHello() throws Exception {
//        mvc
//                .perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(new ResultMatcher() {
//                    @Override
//                    public void match(MvcResult result) throws Exception {
//                        final boolean b = result.getResponse().getStatus() == HttpServletResponse.SC_OK;
//                    }
//                })
//                .andExpect(new ResultMatcher() {
//                    @Override
//                    public void match(MvcResult result) throws Exception {
//                        System.out.println();
//
//                        final boolean equals = result.getResponse().getContentAsString().equals("Greetings from Spring Boot!");
//                        if (!equals)throw new Exception();
//                    }
//                });
//    }
}
