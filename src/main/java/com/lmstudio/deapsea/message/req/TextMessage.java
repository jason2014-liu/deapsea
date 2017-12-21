/**
 * project name:deapsea
 * file name:TextMessage.java
 * package name:com.lmstudio.deapsea.message.req
 * create date:2017年11月15日下午4:58:42
*/
package com.lmstudio.deapsea.message.req;

/**
 * TODO
 *
 * @author jason-liu
 *
 */
public class TextMessage extends BaseMessage {

	// 消息id，64位整型
	private long MsgId;

	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

}
