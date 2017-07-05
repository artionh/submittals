package com.w2020.submittals.service;

import java.util.List;
import com.core.common.base.ServiceResponse;
import com.w2020.submittals.pojo.EmailEntity;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
public interface EmailService {

	public int getNumberOfMessages();
	
	public ServiceResponse<List<EmailEntity>>  getEmails();
}
