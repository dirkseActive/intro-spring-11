package com.apress.isf.java.service;

/**
 * @author dirkseActive
 * @since 4/25/2017
 *
 */
public interface Login {
	public boolean isAuthorized(String email, String pass);
}
