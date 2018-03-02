package com.xp.agent;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

public class DirectMemoryClassInfo {
	private final String CLASS_NAME = "java.nio.Bits";
	private final String SUN_MAX_MEMORY_FIELD = "maxMemory";
	private final String IBM_MAX_MEMORY_FIELD = "maxCapacity";
	private final String RESERVED_MEMORY_FIELD = "reservedMemory";

	private Class bitsClass;
	private Field maxField;
	private Field reservedField;

	public DirectMemoryClassInfo() throws Exception {
		initClass();
		initMaxField();
		initreservedField();
	}

	private void initClass() throws ClassNotFoundException {
		bitsClass = Class.forName(CLASS_NAME);
	}

	private void initMaxField() {
		if (bitsClass != null) {
			Exception ex = null;
			try {
				maxField = bitsClass.getDeclaredField(SUN_MAX_MEMORY_FIELD);
				maxField.setAccessible(true);
			} catch (Exception e) {
				ex = e;
				try {
					maxField = bitsClass.getDeclaredField(IBM_MAX_MEMORY_FIELD);
					maxField.setAccessible(true);
				} catch (Exception e1) {
					ex = e1;
				}
			}
			if (maxField == null) {
				throw new RuntimeException(ex);
			}
		}
	}

	private void initreservedField() throws NoSuchFieldException, SecurityException {
		if (bitsClass != null) {
			reservedField = bitsClass.getDeclaredField(RESERVED_MEMORY_FIELD);
			reservedField.setAccessible(true);
		}
	}

	public long getMaxInfo() throws Exception {
		long result = 0;
		if (bitsClass != null) {
			Object object = maxField.get(bitsClass);
			if (object instanceof Long) {
				result = (Long) object;
			} else if (object instanceof AtomicLong) {
				result = ((AtomicLong) object).get();
			}
		}
		return result;
	}

	public long getReservedInfo() throws Exception {
		long result = 0;
		if (bitsClass != null) {
			Object object = reservedField.get(bitsClass);
			if (object instanceof Long) {
				result = (Long) object;
			} else if (object instanceof AtomicLong) {
				result = ((AtomicLong) object).get();
			}
		}
		return result;
	}

}
