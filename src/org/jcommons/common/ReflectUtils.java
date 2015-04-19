package org.jcommons.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reflect tools
 * @author Zhu
 * 
 */
public class ReflectUtils {
	private Object object;
	private boolean requireSuper = true; // 是否需要父类

	public void setRequiredSuper(boolean flag){
		this.requireSuper = flag;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}

	public Object getObject() {
		return this.object;
	}

	public ReflectUtils(Object object) {
		this.object = object;
	}

	public ReflectUtils() {
	}

	public ReflectUtils(Class<?> clazz) throws InstantiationException,
			IllegalAccessException {

		this.object = clazz.newInstance();

	}

	public String getSimpleName() {
		return this.object.getClass().getSimpleName();
	}

	public String getName() {
		return this.object.getClass().getName();
	}

	/**
	 * 包括父类
	 * 
	 * @return
	 */
	public String[] getFieldsName() {
		Field[] fields = this.getFields();
		String[] result = null;
		if (fields != null) {
			result = new String[fields.length];
			for (int i = 0; i < result.length; ++i) {
				result[i] = fields[i].getName();
			}
		}

		return result == null ? new String[] { "" } : result;
	}

	/**
	 * 取得所有声明过的属性包括父类的
	 * 
	 * @return
	 */
	public Field[] getFields() {
		List<Field> list = new ArrayList<Field>();
		Class<?> clazz = object.getClass();

		if (!this.requireSuper)
			return clazz.getDeclaredFields();
		
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				list.addAll(new ArrayList<Field>(Arrays.asList(clazz.getDeclaredFields())));
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}

		return list.toArray(new Field[] {});
	}

	/**
	 * 取得跟输入名字相符的方法实例，包括父类
	 * 
	 * @param name
	 * @param t
	 * @return
	 */
	public Method getMethod(String name) {
		Method result = null;
		try {
			Method[] ms = this.getMethods();
			for (Method m : ms) {
				if (name.equals(m.getName())) {
					result = m;
					break;
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 包括父类
	 * 
	 * @param name
	 * @return
	 */
	public Method[] getMethods(String name) {
		List<Method> list = new ArrayList<Method>();
		try {
			for (Method m : this.getMethods()) {
				if (m.getName().equals(name)) {
					list.add(m);
				}
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return list.toArray(new Method[] {});
	}

	/**
	 * 包括父类
	 * 
	 * @param name
	 * @return
	 */
	public Method getGetter(String name) {
		return this.getMethod("get" + CommonUtils.toUpCaseFirst(name));
	}

	/**
	 * 包括父类
	 * 
	 * @param name
	 * @return
	 */
	public Method getSetter(String name) {
		return this.getMethod("set" + CommonUtils.toUpCaseFirst(name));
	}

	/**
	 * 取得跟输入名字相符的属性实例
	 * 
	 * @param name
	 * @param t
	 * @return
	 */
	public Field getField(String name) {
		if (name == null)
			return null;
		Field result = null;
		try {
			Field[] fs = this.getFields();
			for (Field f : fs) {
				if (name.equals(f.getName())) {
					result = f;
					break;
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 取得所有声明过的方法包括父类的
	 * 
	 * @return
	 */
	public Method[] getMethods() {
		List<Method> list = new ArrayList<Method>();
		Class<?> clazz = object.getClass();
		
		if (!this.requireSuper)
			return clazz.getDeclaredMethods();
		
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				list.addAll(new ArrayList<Method>(Arrays.asList(clazz.getDeclaredMethods())));
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}

		return list.size() > 0 ? list.toArray(new Method[] {}) : null;
	}
}
