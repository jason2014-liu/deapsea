/**
 * project name:deapsea
 * file name:MyX509TrustManager.java
 * package name:com.lmstudio.deapsea.util
 * create date:2017年11月23日下午4:29:42
*/
package com.lmstudio.deapsea.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * TODO 证书信任管理器（用于https请求）
 *
 *@author jason-liu
 *
 */
public class MyX509TrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {

		return null;
	}

}
