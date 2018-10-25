package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * <p>Title: SecurityConfig</p>
 *  * java的方式配置DelegatingFilterProxy 即扩展WebSecurityConfigurerAdapter
 * @description: 安全配置文件
 * @author: xiongzy
 * @date: 2018-10-25
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 重载该方法，添加用户信息
     * 否则，默认情况下是没有用户能登录进来
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 启用内存用户存储
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");

        // jdbc配置
        // auth.jdbcAuthentication()
        //         .dataSource(DataSource())
        //         .usersByUsernameQuery(
        //                 "select username, password, true from Spitter where username=?"
        //         )
        //         .authoritiesByUsernameQuery(
        //                 "select username, 'ROLE_USER' from Spitter where username=?"
        //         )
        //         .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }

    /**
     * 对每个http请求进行细粒度的控制
     *
     * @param http 请求
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .rememberMe()
                //四周有效
                .tokenValiditySeconds(2419200)
                .key("spittrKey")
                .and()
                .authorizeRequests()
                .antMatchers("/spitters/me").authenticated()
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure() // 需要https
                .antMatchers("/").requiresInsecure(); // 通过http传送
    }
}