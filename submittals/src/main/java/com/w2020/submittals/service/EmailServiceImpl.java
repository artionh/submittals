package com.w2020.submittals.service;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.core.common.base.ProblemSeverity;
import com.core.common.base.ServiceMessage;
import com.core.common.base.ServiceResponse;
import com.w2020.submittals.pojo.Email;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	CheckingMails checkingMails;

	public int getNumberOfMessages() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ServiceResponse<List<Email>> getEmails() {
		List<ServiceMessage> serviceMessageList = new ArrayList<ServiceMessage>();
		serviceMessageList.add(new ServiceMessage("200", "fifth service message", ProblemSeverity.INFO));
		return new ServiceResponse<List<Email>>(serviceMessageList, checkingMails.getEmails());
	}

}
