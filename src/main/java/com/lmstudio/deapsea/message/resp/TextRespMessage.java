/**
 * project name:deapsea
 * file name:TextMessage.java
 * package name:com.lmstudio.deapsea.message.resp
 * create date:2017年11月15日下午5:14:16
*/
package com.lmstudio.deapsea.message.resp;

/**
 * TODO
 *
 *@author jason-liu
 *
 */
public class TextRespMessage extends BaseRespMessage {

	// 回复的消息内容
    private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
    
    
}
