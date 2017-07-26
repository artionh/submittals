package com.core.common.base;

import org.springframework.http.HttpStatus;

public enum ServiceStatus {

	EMPTYRESULT(HttpStatus.NOT_FOUND) {
		@Override
		public ServiceMessage getMessage() {
			return new ServiceMessage("001", "NO ITEMS FOUND", ProblemSeverity.WARN);
		}
	},
	SERVICEERROR(HttpStatus.INTERNAL_SERVER_ERROR) {
		@Override
		public ServiceMessage getMessage() {
			
			return new ServiceMessage("002", "SERVICE ERROR PLEASE TRY AGAIN", ProblemSeverity.ERROR);
		}
	},
	GENERICERROR(HttpStatus.INTERNAL_SERVER_ERROR) {
		@Override
		public ServiceMessage getMessage() {
			return new ServiceMessage("003", "REQUEST COULD NOT BE COMPLETED", ProblemSeverity.ERROR);
		}
	},
	SQLERROR(HttpStatus.INTERNAL_SERVER_ERROR) {
		@Override
		public ServiceMessage getMessage() {
			return new ServiceMessage("004", "DATABASE RELATED ERROR", ProblemSeverity.ERROR);
		}
	};
	
	
	private HttpStatus status;
	
	private ServiceStatus(HttpStatus httpstatus){
		this.status = httpstatus;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public abstract ServiceMessage getMessage();
}
