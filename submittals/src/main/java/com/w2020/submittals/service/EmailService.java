package com.w2020.submittals.service;

import java.util.List;
import com.core.common.base.ServiceResponse;
import com.w2020.submittals.pojo.Email;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
public interface EmailService {

	public int getNumberOfMessages();
	
	public ServiceResponse<List<Email>>  getEmails();
}
