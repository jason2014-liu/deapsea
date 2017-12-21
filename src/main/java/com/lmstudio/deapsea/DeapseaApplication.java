package com.lmstudio.deapsea;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lmstudio.deapsea.menu.MenuManager;
import com.lmstudio.deapsea.message.MessageUtils;
import com.lmstudio.deapsea.message.req.BaseMessage;
import com.lmstudio.deapsea.message.resp.TextRespMessage;
import com.lmstudio.deapsea.util.AccessToken;
import com.lmstudio.deapsea.util.WeixinUtils;

@RestController
@SpringBootApplication
public class DeapseaApplication {

	private static final Logger log = LoggerFactory.getLogger(DeapseaApplication.class);

	private static final String WX_TOKEN = "agroait2017";

	public static void main(String[] args) {
		SpringApplication.run(DeapseaApplication.class, args);
	}

	/**
	 * 确认请求来自微信服务器
	 * 
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param echostr
	 *            随机字符串
	 * @return
	 *
	 * @author jason-liu
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.GET)
	public String handle(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {

		// 字典排序
		String[] arr = new String[] { WX_TOKEN, timestamp, nonce };
		Arrays.sort(arr);

		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		// sha1加密
		String digestContent = DigestUtils.sha1Hex(content.toString());

		log.info("digestContent:{}", digestContent);
		log.info("signature:{}", signature);

		// 与signature对比
		if (digestContent.equals(signature)) {
			return echostr;
		}

		return "";
	}

	/**
	 * 处理微信服务器发来的消息或事件
	 * 
	 * @param message
	 * @return
	 *
	 * @author jason-liu
	 * @throws Exception
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.POST)
	public String processRequest(BaseMessage message, HttpServletRequest request) throws Exception {

		// 调用parseXml方法解析请求消息
		Map<String, String> requestMap = MessageUtils.parseXml(request);
		// 发送方帐号
		String fromUserName = requestMap.get("FromUserName");
		// 开发者微信号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 回复文本消息
		TextRespMessage textMessage = new TextRespMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_TEXT);

		// 设置文本消息的内容
		textMessage.setContent("你发的是文本信息");
		// 将文本消息对象转换成xml
		String respXml = MessageUtils.messageToXml(textMessage);

		return respXml;
	}

	@RequestMapping(value = "createMenu", method = RequestMethod.GET)
	public void createMenu() {
		// 第三方用户唯一凭证
		String appId = "wxf5267576ea650409";
		// 第三方用户唯一凭证密钥
		String appSecret = "00f0e7334dd5eafc60df9f531b447c66";

		// 调用接口获取access_token
		AccessToken at = WeixinUtils.getAccessToken(appId, appSecret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtils.createMenu(MenuManager.getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败，错误码：" + result);

		}
	}

}
