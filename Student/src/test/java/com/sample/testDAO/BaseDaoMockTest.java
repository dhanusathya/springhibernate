package com.sample.testDAO;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseDaoMockTest {
	
	@Before
    public void setUp(){
         MockitoAnnotations.initMocks(this);
    }

}
