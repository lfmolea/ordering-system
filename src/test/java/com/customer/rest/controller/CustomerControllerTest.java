package com.customer.rest.controller;

import com.customer.CustomerApplication;
import com.customer.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
     classes = CustomerApplication.class)
public class CustomerControllerTest {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();//apply(springSecurity()).build();

    }

    @Test
    public void authenticate()throws Exception{

        User customer = new User();
        customer.setUsername("tmmolea");
        customer.setEmailAddress("ltmolea@gmail.com");
        customer.setPassword("thendokhulu1");
        customer.setContactDetail("0789662752");

        mockMvc.perform(post("/customers/new").content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    protected String asJsonString(final Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
