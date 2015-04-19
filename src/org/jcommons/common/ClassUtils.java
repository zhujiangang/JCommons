package org.jcommons.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;

public class ClassUtils {
	public static Class<?> getPojoClass(Method method) {
		Type type = method.getGenericReturnType();
		String clsName = type.toString();
		if (clsName.contains("<") && clsName.contains(">")) {
			int s = clsName.indexOf("<") + 1;
			int e = clsName.indexOf(">");

			String str = clsName.substring(s, e);
			return ClassUtils.getPojoClass(str);
		} else
			return method.getReturnType();
	}

	public static Class<?> getPojoClass(String className) {
		Class<?> cls;
		try {
			cls = Thread.currentThread().getContextClassLoader().loadClass(className);

			if (isPojo(cls))
				return cls;

		} catch (ClassNotFoundException e) {
		}

		return null;
	}


	public static boolean isPojo(Class<?> cls) {
		if (cls == null)
			return false;

		if (Collection.class.isAssignableFrom(cls)) {
		} else {
			if (Integer.class.isAssignableFrom(cls)
					|| int.class.isAssignableFrom(cls)) {
			} else if (Integer[].class.isAssignableFrom(cls)
					|| int[].class.isAssignableFrom(cls)) {

			} else if (Long.class.isAssignableFrom(cls)
					|| long.class.isAssignableFrom(cls)) {

			} else if (Long[].class.isAssignableFrom(cls)
					|| long[].class.isAssignableFrom(cls)) {

			} else if (Float.class.isAssignableFrom(cls)
					|| float.class.isAssignableFrom(cls)) {

			} else if (Float[].class.isAssignableFrom(cls)
					|| float[].class.isAssignableFrom(cls)) {

			} else if (Double.class.isAssignableFrom(cls)
					|| double.class.isAssignableFrom(cls)) {

			} else if (Double[].class.isAssignableFrom(cls)
					|| double[].class.isAssignableFrom(cls)) {

			} else if (String.class.isAssignableFrom(cls)) {
			} else if (String[].class.isAssignableFrom(cls)) {
			} else if (Date.class.isAssignableFrom(cls)) {

			} else if (Date[].class.isAssignableFrom(cls)) {

			} else {
				try {
					cls.newInstance();
					return true;
				} catch (InstantiationException e) {
				} catch (IllegalAccessException e) {
				}
			}
		}

		return false;
	}

	/**
	 * 
	 * @param <T>
	 * @param fieldName
	 * @param v
	 * @param vs
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public static <T> T injectFieldValue(T pojo, String fieldName, String[] vs)
			throws Exception {

		if (pojo == null)
			return null;

		if (vs == null)
			return pojo;

		ReflectUtils ru = new ReflectUtils(pojo);
		Field f = ru.getField(fieldName);
		if (f == null)
			return pojo;

		Method setter = ru.getSetter(fieldName);
		if (setter == null)
			return pojo;

		Class<?> clazz = f.getType();
		
		if (Object[].class.isAssignableFrom(clazz)) {
			Object obj = getParamVals(clazz, vs);
			if (obj != null)
				setter.invoke(pojo, new Object[] { obj });
		} else {
			Object obj = getParamVal(clazz, vs[0]);
			if (obj != null)
				setter.invoke(pojo, obj);
		}
		return pojo;
	}

	public static Object getParamVal(Class<?> fieldType, String fieldVal) {
		Class<?> clazz = fieldType;
		String v = fieldVal;
		if (v == null)
			return null;

		try {
			if (int.class.isAssignableFrom(clazz)
					|| Integer.class.isAssignableFrom(clazz)) {
				if ("".equals(v.trim()))
					v = "0";
				
				try {
					return Integer.parseInt(v);
				} catch (Exception e){
					return 0;
				}
			} else if (long.class.isAssignableFrom(clazz)
					|| Long.class.isAssignableFrom(clazz)) {
				if ("".equals(v.trim()))
					v = "0L";
				try {
					return Long.parseLong(v);
				}catch(Exception e){
					return 0L;
				}
			} else if (double.class.isAssignableFrom(clazz)
					|| Double.class.isAssignableFrom(clazz)) {
				if ("".equals(v.trim()))
					v = "0.0D";

				try {
					return Double.parseDouble(v);
				}catch(Exception e){
					return 0.0D;
				}
			} else if (float.class.isAssignableFrom(clazz)
					|| Float.class.isAssignableFrom(clazz)) {
				if ("".equals(v.trim()))
					v = "0.0F";

				try {
					return Float.parseFloat(v);
				}catch(Exception e){
					return 0.0F;
				}
			} else if (boolean.class.isAssignableFrom(clazz)
					|| Boolean.class.isAssignableFrom(clazz)) {
				if ("".equals(v.trim()))
					v = "false";
				try {
					return Boolean.parseBoolean(v);
				}catch(Exception e){
					return false;
				}
			} else if (String.class.isAssignableFrom(clazz)) {
				return v;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Object getParamVals(Class<?> fieldType, String[] fieldVals) {
		Class<?> clazz = fieldType;
		String[] vs = fieldVals;
		if (vs == null)
			return null;
		try {
			int length = vs.length;
			if (Integer[].class.isAssignableFrom(clazz)) {
				Integer[] args = new Integer[length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0";
					try {
						args[i] = Integer.parseInt(vs[i]);
					} catch (Exception e){
						args[i] = 0;
					}
				}

				return args;
			} else if (int[].class.isAssignableFrom(clazz)) {
				int[] args = new int[length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0";
					try{
					args[i] = Integer.parseInt(vs[i]);
					} catch (Exception e){
						args[i] = 0;
					}
				}

				return args;
			} else if (Long[].class.isAssignableFrom(clazz)) {
				Long[] args = new Long[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0";
					try{
						args[i] = Long.parseLong(vs[i]);
					} catch (Exception e){
						args[i] = 0L;
					}
				}

				return args;
			} else if (long[].class.isAssignableFrom(clazz)) {
				long[] args = new long[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0";
					try{
						args[i] = Long.parseLong(vs[i]);
					} catch (Exception e){
						args[i] = 0L;
					}
				}

				return args;
			} else if (Double[].class.isAssignableFrom(clazz)) {
				Double[] args = new Double[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0.0";
					try{
						args[i] = Double.parseDouble(vs[i]);
					} catch (Exception e){
						args[i] = 0.0D;
					}
				}

				return args;
			} else if (double[].class.isAssignableFrom(clazz)) {
				double[] args = new double[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0.0";
					try{
						args[i] = Double.parseDouble(vs[i]);
					} catch (Exception e){
						args[i] = 0.0D;
					}
				}

				return args;
			} else if (Float[].class.isAssignableFrom(clazz)) {
				Float[] args = new Float[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0.0";

					try{
						args[i] = Float.parseFloat(vs[i]);
					} catch (Exception e){
						args[i] = 0.0F;
					}
				}

				return args;
			} else if (float[].class.isAssignableFrom(clazz)) {
				float[] args = new float[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "0.0";
					try{
						args[i] = Float.parseFloat(vs[i]);
					} catch (Exception e){
						args[i] = 0.0F;
					}
				}

				return args;
			} else if (Boolean[].class.isAssignableFrom(clazz)) {
				Boolean[] args = new Boolean[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "false";

					try{
						args[i] = Boolean.parseBoolean(vs[i]);
					} catch (Exception e){
						args[i] = false;
					}
				}

				return args;
			} else if (boolean[].class.isAssignableFrom(clazz)) {
				boolean[] args = new boolean[vs.length];
				for (int i = 0; i < vs.length; i++) {
					if ("".equals(vs[i].trim()))
						vs[i] = "false";
					try{
						args[i] = Boolean.parseBoolean(vs[i]);
					} catch (Exception e){
						args[i] = false;
					}
				}

				return args;
			} else if (String[].class.isAssignableFrom(clazz)) {
				return vs;
			}
		} catch (Exception e) {
			return null;
		} catch (Error e) {
			return null;
		}
		return null;
	}

	public static Class<?> getGenericType(Field f){
		Class<?> cls = f.getType();
		if (!Collection.class.isAssignableFrom(cls))
			return cls;
		
		ParameterizedType pt = (ParameterizedType) f.getGenericType();
		Type type = pt.getActualTypeArguments()[0];
		
		Class<?> targetCls = ClassUtils.getPojoClass(type.toString().replace("class ", "").replace("interface ", "").trim());
		if (targetCls == null)
			return cls;

		return targetCls;

	}
	
	public static boolean isListClass(Field f) {
		Class<?> cls = f.getType();
		if (!Collection.class.isAssignableFrom(cls))
			return false;
		ParameterizedType pt = (ParameterizedType) f.getGenericType();
		Type type = pt.getActualTypeArguments()[0];

		Class<?> targetCls = ClassUtils.getPojoClass(type.toString().replace("class ", ""));
		if (targetCls == null)
			return false;

		return true;
	}

	public static boolean isListString(Field f) {
		Class<?> cls = f.getType();

		if (!Collection.class.isAssignableFrom(cls))
			return false;

		ParameterizedType pt = (ParameterizedType) f.getGenericType();
		Type type = pt.getActualTypeArguments()[0];

		if ("class java.lang.String".equals(type.toString()))
			return true;

		return false;
	}

}
