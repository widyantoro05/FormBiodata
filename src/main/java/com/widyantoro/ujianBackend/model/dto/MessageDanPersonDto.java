package com.widyantoro.ujianBackend.model.dto;

import java.sql.Date;

public class MessageDanPersonDto {
	private messageDto message;
	private personDto person;
	public messageDto getMessage() {
		return message;
	}
	public void setMessage(messageDto message) {
		this.message = message;
	}
	public personDto getPerson() {
		return person;
	}
	public void setPerson(personDto person) {
		this.person = person;
	}
	
}
