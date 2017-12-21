/**
 * project name:deapsea
 * file name:MenuEvent.java
 * package name:com.lmstudio.deapsea.message.event
 * create date:2017年11月15日下午5:07:16
*/
package com.lmstudio.deapsea.message.req.event;

import com.lmstudio.deapsea.message.req.BaseMessage;

/**
 * TODO
 *
 * @author jason-liu
 *
 */
public class MenuEvent extends BaseMessage {

	// 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	// 事件类型
	private String Event;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

}
