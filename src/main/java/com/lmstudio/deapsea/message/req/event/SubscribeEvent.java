/**
 * project name:deapsea
 * file name:SubscribeEvent.java
 * package name:com.lmstudio.deapsea.message.event
 * create date:2017年11月15日下午5:05:43
*/
package com.lmstudio.deapsea.message.req.event;

import com.lmstudio.deapsea.message.req.BaseMessage;

/**
 * TODO
 *
 * @author jason-liu
 *
 */
public class SubscribeEvent extends BaseMessage {

	// 事件类型
	private String Event;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

}
