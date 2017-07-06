package com.w2020.submittals.controller;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.core.common.base.ServiceResponse;
import com.w2020.submittals.pojo.EmailEntity;
import com.w2020.submittals.service.EmailService;

@CrossOrigin(origins = "http://localhost:8085")
@RestController("emailCore")
@RequestMapping("/emailCore")
public class EmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping(value = "/getEmails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<EmailEntity>>> getFrStreetByIDStreets() throws Exception {

		ServiceResponse<List<EmailEntity>> result = emailService.getEmails();

		return new ResponseEntity<ServiceResponse<List<EmailEntity>>>(result, HttpStatus.OK);
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

}
