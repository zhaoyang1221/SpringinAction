package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * <p>Title: JdbcConfig</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-25
 **/
@Configuration
public class JdbcConfig {

    /**
     * 配置jndi数据源
     *
     * 另外 还能配置具有连接池功能的数据源
     * 例如 Apache Commons DBCP
     *      c3p0
     *      BoneCP
     * 这些配置可参考书上的配置
     */
    // @Bean
    // public JndiObjectFactoryBean dataSource() {
    //     JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
    //     jndiObjectFactoryBean.setJndiName("/jdbc/SpittrDs");
    //     jndiObjectFactoryBean.setResourceRef(true);
    //     jndiObjectFactoryBean.setProxyInterface(DataSource.class);
    //     return jndiObjectFactoryBean;
    // }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:schema.sql", "classpath:test-data.sql")
                .build();
    }
}