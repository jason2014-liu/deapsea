/**
 * project name:deapsea
 * file name:AccessToken.java
 * package name:com.lmstudio.deapsea
 * create date:2017年11月23日下午4:25:54
*/
package com.lmstudio.deapsea.util;

/**
 * TODO
 *
 *@author jason-liu
 *
 */
public class AccessToken {

	private String token;
	private int expiresIn;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
