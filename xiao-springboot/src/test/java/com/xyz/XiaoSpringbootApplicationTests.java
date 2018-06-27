package com.xyz;

import com.xyz.xiao20180619.CommandManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XiaoSpringbootApplicationTests {

	@Autowired
	CommandManager commandManager;

	@Test
	public void contextLoads() {

		commandManager.process();
	}

}
