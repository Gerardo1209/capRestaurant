package com.capgemini.bootcamp.java.excerciseone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExcerciseoneApplicationTests {

	@Test
	void contextLoads() {
		String[] args = {};
		assertDoesNotThrow(() -> ExcerciseoneApplication.main(args));
	}

}
