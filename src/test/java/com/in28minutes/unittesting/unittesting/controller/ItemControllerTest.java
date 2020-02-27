package com.in28minutes.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
		
		@Autowired
		MockMvc mockMvc;
		
		@Test
		public void helloWorld_matchers() throws Exception {
			RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

			// using content().string: not suggested as even a single space or change in order of properties will fail this test
			MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
					.andReturn();

			// using content().json: ok as even after fields are in any order or spaces
			result = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json("{\"name\":\"Ball\",\"id\"   :1,\"price\":10,\"quantity\":100}"))
					.andReturn();
		}
}
