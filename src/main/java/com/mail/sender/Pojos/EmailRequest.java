package com.mail.sender.Pojos;

public class EmailRequest {

    public String toAddress;
    public String subject;
    public String message;

    public EmailRequest(final String toAddress, final String subject, final String message) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.message = message;
    }
}
