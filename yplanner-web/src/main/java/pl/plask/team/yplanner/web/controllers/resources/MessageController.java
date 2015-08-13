package pl.plask.team.yplanner.web.controllers.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Resource(name = "messagesProperties")
	private Properties messages;

	@RequestMapping(value = "/res/messages.js",  method = RequestMethod.GET)
	public Map<String, String> loadMessages() {
		Map<String, String> map = new HashMap<>();
		for (String key : messages.stringPropertyNames()) {
			map.put(key, messages.getProperty(key));
		}
		return map;
	}

	public Properties getMessages() {
		return messages;
	}

	public void setMessages(Properties messages) {
		this.messages = messages;
	}
	
}
