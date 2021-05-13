package com.example.boxticketingwebapi.dto.response;

import java.util.List;

public class JwtResponseDTO {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private double amountInWallet;
	private List<String> roles;

	public JwtResponseDTO(String accessToken, Long id, String username, List<String> roles, double amountInWallet) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.amountInWallet = amountInWallet;
	}

	public double getAmountInWallet() {
		return amountInWallet;
	}

	public void setAmountInWallet(double amountInWallet) {
		this.amountInWallet = amountInWallet;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
