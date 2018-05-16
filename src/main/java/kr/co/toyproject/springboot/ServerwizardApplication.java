package kr.co.toyproject.springboot;

import kr.co.toyproject.springboot.config.FileConfig;
import kr.co.toyproject.springboot.config.LocalFileConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 1. ComponentScan으로 Configuration 파일 찾을 수 있는지
 * 2. EnableAutoConfiguration vs ComponetScan vs Configuration 차이
 * 3.
 */

@SpringBootApplication
public class ServerwizardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerwizardApplication.class, args);
	}
}
