package com.example.LogWatcher.WebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.LogWatcher.FileMessage;

@Controller
public class WebController {
	@MessageMapping("/logs")
	@SendTo("/topic/log")
	public FileMessage getFileData(FileMessage msg) throws Exception {
		  return msg;
		}
}


