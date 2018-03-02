package com.xp.agent;

import com.xp.agent.util.Maths;

public class DirectMemoryCollector {
	public static String getString() {
		String result = "Error";
		try {
			DirectMemoryClassInfo info = new DirectMemoryClassInfo();
			result ="max:"+ Maths.BToM(info.getMaxInfo()) + " reserved:" + Maths.BToM(info.getReservedInfo());
		} catch (Exception e) {
		}
		return result;

	}
}
