package cn.woodwhales.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author woodwhales on 2021-10-07 0:36
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "info")
public class InfoConfig {

    private String product;

    private String version;
}
