package com.celeritech.apirickandmorty.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.celeritech.apirickandmorty.entities.User;
import com.celeritech.apirickandmorty.repositories.UserRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer{
	
	@Autowired
	private UserRepository userRepository;

	@Override // recebe os 2 obejtos e entra no ciclo de vida do token e acrescenta os objetos passados
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userRepository.findByName(authentication.getName());
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", user.getName());
		map.put("userId", user.getId());
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
		

}
