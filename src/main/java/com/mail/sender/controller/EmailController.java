package com.mail.sender.controller;

import com.mail.sender.Exceptions.InvalidContentException;
import com.mail.sender.Exceptions.PartnerAPIException;
import com.mail.sender.Pojos.EmailRequest;
import com.mail.sender.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    public EmailService emailService;

    @GetMapping("/sendEmail")
    public ResponseEntity<Void> sendEmail(@RequestBody EmailRequest emailRequest) throws InvalidContentException, PartnerAPIException {
        emailService.sendEmail(
                emailRequest.toAddress,
                emailRequest.subject,
                emailRequest.message
        );
        return ResponseEntity.ok().build();
    }
}
