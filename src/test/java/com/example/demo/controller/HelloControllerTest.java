package com.example.demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {


@Autowired
private MockMvc mockMvc;


@Test
public void helloWithoutNameReturnsHelloWorld() throws Exception {
mockMvc.perform(get("/api/hello"))
.andExpect(status().isOk())
.andExpect(content().string("Hello, world!"));
}


@Test
public void helloWithNameReturnsHelloName() throws Exception {
mockMvc.perform(get("/api/hello").param("name", "Zeyaul"))
.andExpect(status().isOk())
.andExpect(content().string("Hello, Zeyaul!"));
}
}
