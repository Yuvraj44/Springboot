package com.example.LogWatcher.WebSocket;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class WebService {
	private final RandomAccessFile r;
	
	@Autowired
	private SimpMessagingTemplate m;
	
	long offset;
	
	public WebService() throws IOException
	{
		r = new RandomAccessFile("log.txt", "r");
		offset=getOffset();
	}
	@Scheduled(fixedDelay=100, initialDelay=3000)
	public void sendData()throws IOException
	{
		long l=r.length();
		r.seek(offset);
		

		while(r.getFilePointer() < l)
		{
			String d=r.readLine();
			System.out.println(d);
			String senddata="{\"content\": \"" + d + "\"}";
			m.convertAndSend("/topic/log", senddata);
		}
		offset=l;
	}
	
	private long getOffset() throws IOException
	{
		int c=0;
		long arr[]=new long[10];
		
		while(r.readLine()!=null)
		{
			arr[c%10]=r.getFilePointer();
			c++;
		}
		
		System.out.println(c);
		return arr[c%10];
	}
}
