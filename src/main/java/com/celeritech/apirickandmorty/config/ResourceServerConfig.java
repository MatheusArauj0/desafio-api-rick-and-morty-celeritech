package com.celeritech.apirickandmorty.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static String[] PUBLIC = {"/oauth/token", "/h2-console/**", 
			"/swagger-resources/**", "/swagger-ui/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**"};
	private static String[] ADMIN = {"/personagens/**", "/locais/**", "/users/**"};
	
	@Override // decodificar o token e fazer as validações
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//libera o H2
		if(Arrays.asList(env.getActiveProfiles()).contains("test")){
			http.headers().frameOptions().disable();
		}
		
		
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, ADMIN).permitAll()
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	
}
