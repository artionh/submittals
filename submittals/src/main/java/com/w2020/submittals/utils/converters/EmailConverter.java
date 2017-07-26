package com.w2020.submittals.utils.converters;

import com.google.common.base.Converter;
import com.w2020.submittals.pojo.Email;
import com.w2020.submittals.pojo.EmailEntity;

public class EmailConverter extends Converter<Email, EmailEntity> {

	@Override
	protected Email doBackward(EmailEntity emailEntity) {
		Email email = new Email();

		email.setAction(emailEntity.getAction());
		email.setAtachments(emailEntity.getAtachmentsFileName());
		email.setDateRec(emailEntity.getDateRec());
		email.setDateSend(emailEntity.getDateSend());
		email.setDescription(emailEntity.getDescription());
		email.setDetailer(emailEntity.getDetailer());
		email.setHcec(emailEntity.getHcec());
		email.setJobName(emailEntity.getJobName());
		email.setSendTo(emailEntity.getSendTo());
		email.setSubject(emailEntity.getSubject());
		email.setSubmittalNo(emailEntity.getSubmittalNo());
		email.setTransNo(emailEntity.getTransNo());
		email.setVia(emailEntity.getVia());

		return email;
	}

	@Override
	protected EmailEntity doForward(Email email) {
		// not needed at this moment
		return null;
	}

}
