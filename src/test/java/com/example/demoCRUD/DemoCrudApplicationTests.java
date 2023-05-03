package com.example.demoCRUD;

import com.example.demoCRUD.rest.PostRestController;
import com.example.demoCRUD.rest.UserRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoCrudApplicationTests {

	@Autowired
	UserRestController userRestController;
	@Autowired
	PostRestController postRestController;
	@Test
	void contextLoads() throws Exception{
		assertThat(userRestController).isNotNull();
		assertThat(postRestController).isNotNull();
	}
}
