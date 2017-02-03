package com.sana.fare.domain;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * A sample class for adding error information in the response
 */
@SuppressWarnings("restriction")
@XmlRootElement
public class RestErrorInfo {
	public final String detail;
	public final String message;

	public RestErrorInfo(Exception ex, String detail) {
		this.message = ex.getLocalizedMessage();
		this.detail = detail;
	}
}
