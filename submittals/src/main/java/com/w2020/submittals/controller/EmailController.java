package com.w2020.submittals.controller;
/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w2020.submittals.service.EmailService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController("emailCore")
@RequestMapping("/emailCore")
public class EmailController {

	@Autowired
	EmailService emailService;
}
