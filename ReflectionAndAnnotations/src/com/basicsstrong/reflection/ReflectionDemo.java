package com.basicsstrong.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyClass{

	private MyClass() {
		System.out.println("MyClass object created!");
	}
	
}

public class ReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

		// não é possível instanciar o objeto pois a classe é privada
		//MyClass obj = new MyClass();

		// É possível criar o objeto de MyClass baseado no FQN da classe
		Class<?> clss = Class.forName("com.basicsstrong.reflection.MyClass");
		Constructor<?> con = clss.getDeclaredConstructor();
		con.setAccessible(true); // essa linha deixa o construtor visível e acessível

		// é possível instanciar o objeto classe das duas formas abaixo:
		MyClass newInstance = (MyClass)con.newInstance();
		Object classObject = con.newInstance();

	}

}
