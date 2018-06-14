package charles.lab.spring_boot_with_actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class BasicAuthConfig extends WebSecurityConfigurerAdapter {
    @Value("${security.user.password}")
    private String password;
    @Value("${security.user.name}")
    private String username;
    
    @Value("${security.user.role}")
    private String role;;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(username).password(password).roles(role);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.requestMatchers().antMatchers("/manage/shutdown") //
                .and().authorizeRequests().anyRequest().authenticated() //
                .and().httpBasic();
    }
}

