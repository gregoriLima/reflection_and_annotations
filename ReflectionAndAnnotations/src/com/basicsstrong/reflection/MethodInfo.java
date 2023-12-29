package com.basicsstrong.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInfo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Entity entityObject = new Entity(10, "id");
		Class<? extends Entity> clss = entityObject.getClass();

		// pega os métodos públicos declarados da classe e superclasses
		Method[] methods = clss.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("------------");

		// pega os métodos públicos e privados da classe só
		Method[] declaredMethods = clss.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
		
		Method method = clss.getDeclaredMethod("setVal", int.class); // nome do método, tipo esperado pelo construtor do método, no caso aqui é esperado um int no método
		method.setAccessible(true);
		method.invoke(entityObject, 15);
		
		Method method2 = clss.getMethod("getVal", null);
		System.out.println(method2.invoke(entityObject, null));
		
		
	}

}
