package com.practice.design.bridging.config;

import com.practice.design.bridging.dict.MsgType;
import com.practice.design.bridging.sender.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/20 22:44
 */
@Service
public class MsgSenderFactory {

	private final Map<MsgType, MsgSender> msgSenderMap = new HashMap<>();

	@Autowired
	public MsgSenderFactory(@Qualifier("EMAIL") MsgSender emailMsgSender,
	                        @Qualifier("TELEPHONE") MsgSender telephoneMsgSender,
	                        @Qualifier("WECHAT") MsgSender wechatMsgsender) {
		msgSenderMap.put(MsgType.EMAIL, emailMsgSender);
		msgSenderMap.put(MsgType.TELEPHONE, telephoneMsgSender);
		msgSenderMap.put(MsgType.WECHAT, wechatMsgsender);
	}

	public MsgSender getMsgSender(MsgType msgType) {
		return msgSenderMap.get(msgType);
	}
}
