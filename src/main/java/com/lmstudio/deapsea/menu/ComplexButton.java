/**
 * project name:deapsea
 * file name:ComplexButton.java
 * package name:com.lmstudio.deapsea.menu
 * create date:2017年11月23日下午4:23:32
*/
package com.lmstudio.deapsea.menu;

/**
 * TODO 父菜单项
 *
 *@author jason-liu
 *
 */
public class ComplexButton extends Button {

	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
