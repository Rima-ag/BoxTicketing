package com.example.boxticketingwebapi.dto;

import org.springframework.hateoas.RepresentationModel;

public class MessageResponseDTO extends RepresentationModel<MessageResponseDTO> {
	private String message;

	public MessageResponseDTO(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
