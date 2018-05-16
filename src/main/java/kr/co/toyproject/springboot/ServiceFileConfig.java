package kr.co.toyproject.springboot;

import kr.co.toyproject.springboot.config.FileConfig;
import kr.co.toyproject.springboot.config.LocalFileConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daou on 2018-05-16.
 */
@Slf4j
@Configuration
public class ServiceFileConfig {
    @Bean
    public FileConfig getLocalFileConfig() {
        log.info("config file configuration");
        return new LocalFileConfig();

    }
}