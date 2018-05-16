package kr.co.toyproject.springboot.config;

import java.io.File;

/**
 * Created by daou on 2018-05-16.
 */
public class LocalFileConfig implements FileConfig {

    @Override
    public String getBaseDir() {
        return "D:" + File.separator + "data_asp00";
    }
}
