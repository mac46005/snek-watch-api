package com.preciado.snek_watch_api;


import java.util.function.Supplier;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.preciado.snek_watch_api.service.SqlStatementCreator;

@SpringBootTest
class SnekWatchApiApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(SnekWatchApiApplicationTests.class);


	@Test
	void contextLoads() {
		String selectStmnt = SqlStatementCreator.createSelectStatement("table", "", "column 1", "column 2");
		logger.info(() -> selectStmnt);
	}

}
