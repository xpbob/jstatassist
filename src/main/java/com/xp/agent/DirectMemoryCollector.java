package com.xp.agent;

import com.xp.agent.util.Maths;

public class DirectMemoryCollector {
		public static void main(String[] args){
			try {
				DirectMemoryClassInfo info = new DirectMemoryClassInfo();
				System.out.println(Maths.BToM(info.getMaxInfo())+" "+info.getReservedInfo());
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
}
