package com.designknot.salessearch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.designknot.salessearch.service.impl.UserSecurityService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserSecurityService userSecurityService;

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/images/**","/css/**","/js/**").permitAll()
                .anyRequest().authenticated()//全ページへのセキュリティ有効
                .and()
            .formLogin()
                .loginPage("/login") //ログインページ指定、セキュリティなし
                .failureUrl("/login-error")//ログイン失敗
                .defaultSuccessUrl("/user/arealist", true)
                .successForwardUrl("/user/arealist")
                .loginProcessingUrl("/sign_up") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
                .usernameParameter("username") //リクエストパラメータのname属性を明示
                .passwordParameter("password") //同上


                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")//ログアウトURL指定
                .logoutSuccessUrl("/login?logout")//ログアウト後に遷移するURL
                .deleteCookies("JSESSIONID")//JSESSIONID削除
    			.invalidateHttpSession(true)//セッション無効
    			.permitAll();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(userSecurityService)
			.passwordEncoder(passwordEncoder());
	}
}
