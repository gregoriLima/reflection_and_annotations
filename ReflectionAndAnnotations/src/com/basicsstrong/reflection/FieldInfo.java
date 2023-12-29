package com.basicsstrong.reflection;

import java.lang.reflect.Field;

public class FieldInfo {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Entity entityObject = new Entity(10,"id");
		Class<? extends Entity> clss = entityObject.getClass();

		// retorna informações sobre todos os campos da classe
		Field[] fields = clss.getFields();
		
		for (Field field : fields) {
			System.out.println("getFields()");
			System.out.println(field.getName());
		}

		System.out.println(" - - - - - - -");
		Field[] declaredFields = clss.getDeclaredFields();
		
		for (Field field : declaredFields) {
			System.out.println("getDeclaredFields() :");
			System.out.println(field.getName());
		}
		
		//non-declared : all the public elements in that class and in its super class
		//declared : all the elements present in that class only.

		// modificando o field 'type' da classe Entity
		Field fieldType = clss.getField("type");
		fieldType.set(entityObject, "rollNo.");

		// modificando o field 'val' da classe Entity
		Field fieldVal = clss.getDeclaredField("val"); // como é um campo privado, é necessário chamar o getDeclaredField
		fieldVal.setAccessible(true); // e setar a visibilidade para true
		fieldVal.set(entityObject, 19);
		
		System.out.println(entityObject.getType()+" "+entityObject.getVal());
		
		

	}

}
