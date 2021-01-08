package com.example.buildrestfulwebservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * You can write mock tests with spring
 */

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testNoParamGreetingShouldReturnDefaultMessage() throws Exception{
    this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, world!"));
  }

  @Test
  public void testParamGreetingShouldReturnTailoredMessage() throws Exception{
    this.mockMvc.perform(get("/greeting").param("name", "user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, user!"));    
  }
}
