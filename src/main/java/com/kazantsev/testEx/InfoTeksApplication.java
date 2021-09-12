package com.kazantsev.testEx;

import com.kazantsev.testEx.data.TestDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoTeksApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoTeksApplication.class, args);
		TestDataBase.DataBase.put("test", "content");
	}

}
