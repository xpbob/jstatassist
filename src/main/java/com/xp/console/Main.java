package com.xp.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Main {

	public static void main(String[] args)
			throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
		
		//String pid = args[0];
		//String agentPath = args[1];
		final String agentPath="F:\\jstatassist\\jstatassist\\jstatassist";
		final String pid="469268";
		if (pid == null) {
			System.out.println("input pid");
			return;
		}

		final String jarName = "jstatassist-0.0.1-agent.jar";
	
		new Thread(){
			public void run() {
				VirtualMachine vm;
				try {
					vm = VirtualMachine.attach(pid);
					vm.loadAgent(agentPath + "/" + jarName);
				}  catch (Exception e) {
	
					e.printStackTrace();
				}
	
			};
		}.start();
		
		
		Socket s =new Socket("127.0.0.1",6161);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(br.readLine());
		br.close();
		

	}

}
