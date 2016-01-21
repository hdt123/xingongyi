package com.xgy.entity.dto;

/**
 * {
"errcode":0,
"errmsg":"ok",
"ticket":"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA",
"expires_in":7200
}
 * @author huduoteng
 *
 */
public class TicketDto {

	private int errorcode;
	
	private String errmsg;
	
	private String ticket;
	
	private String expires_in;

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	
	
}
