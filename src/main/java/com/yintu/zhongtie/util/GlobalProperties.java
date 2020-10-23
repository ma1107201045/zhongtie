package com.yintu.zhongtie.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/23 16:30
 */
@Component
public class GlobalProperties {
    @Value("${other.file.path}")
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


}
