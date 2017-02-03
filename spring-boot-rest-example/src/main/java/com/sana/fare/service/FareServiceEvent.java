package com.sana.fare.service;

import org.springframework.context.ApplicationEvent;

/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */
public class FareServiceEvent extends ApplicationEvent {

	public FareServiceEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "My FareService Event";
	}
}