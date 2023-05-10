package com.vijay.user;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.model.TestClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.vijay.user.UserController.UserController;
import com.vijay.user.UserRepository.UserRepo;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	private MockMvc mockmvc;
	ObjectMapper objectmapper=new ObjectMapper();
	ObjectWriter objectwriter=objectmapper.writer();
	
	@Mock
	private UserRepo userrepo;

	@InjectMocks
	private UserController usercontroller;
	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(testClass:this);
//		this.mockmvc=MockMvcBuilders.standaloneSetup(usercontroller).build();
//	}
	

}
