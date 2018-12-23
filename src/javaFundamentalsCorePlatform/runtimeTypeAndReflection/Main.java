package javaFundamentalsCorePlatform.runtimeTypeAndReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.BankAccount;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Class1 class1 = new Class1();
		Class2 class2 = new Class2();
		showName(class2.getClass());
		showName(class2.getClass().getSuperclass());

		Class<?>[] interfaces = class2.getClass().getInterfaces();
		for (Class<?> i : interfaces) {
			showName(i);
		}

		try {
			showName(Class.forName(
					"javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.BankAccount"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int modifiers = class2.getClass().getModifiers();
		if ((modifiers & Modifier.FINAL) > 0)
			System.out.println(modifiers);

		// To obtain some class information
		HighVolumeAccount hvAccount = new HighVolumeAccount(0);
		modifiers = hvAccount.getClass().getModifiers();
		System.out.println("Modifier.FINAL: " + Modifier.FINAL);
		System.out.println("modifiers: " + modifiers);
		if ((modifiers & Modifier.FINAL) > 0)
			System.out.println(modifiers);

		if (Modifier.isFinal(modifiers))
			System.out.println("is final");

		if (Modifier.isPublic(modifiers))
			System.out.println("is public");

		if (Modifier.isSynchronized(modifiers))
			System.out.println("is Synchronized");

		// To obtain fields information .getSuperclass()
		Class<?> theClass = hvAccount.getClass();
		Field[] fields = theClass.getFields();
		Field[] declaredFields = theClass.getDeclaredFields();
//		displayFields(fields);
//		displayFields(declaredFields);

//		theClass = hvAccount.getClass();
		Method[] methods = theClass.getMethods();
		Method[] declaredMethods = theClass.getDeclaredMethods();
		displayMethods(methods);
		displayMethods(declaredMethods);

		// Call methods
		Method m;
		try {
			m = theClass.getMethod("sayHello", String.class);
			Object result = m.invoke(hvAccount, "world");
			System.out.println("result is " + result);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		try {
			BankAccount ba = new BankAccount(500);
			reflectionImpl("javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.Worker", ba);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void displayMethods(Method[] methods) {
		System.out.println(" Display methods ");
		for (Method method : methods) {
			// N'affiche que les method déclarées (pas de notify equals et autre)
			if (method.getDeclaringClass() != Object.class)
				System.out.println(method.getName() + " : " + method.getReturnType());
		}
	}

	private static void displayFields(Field[] fields) {
		System.out.println(" Display fields ");
		for (Field field : fields) {
			System.out.println(field.getName() + " : " + field.getType());
		}

	}

	private static void showName(Class<?> theClass) {
		System.out.println(theClass.getSimpleName());
	}

	private static void reflectionImpl(String worker, Object target)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> workerType = Class.forName(worker);
		Class<?> targetType = target.getClass();
		Constructor c = workerType.getConstructor(targetType);
		Object workerInstance = c.newInstance(target);
		Method sayHello = workerType.getMethod("sayHello");
		sayHello.invoke(workerInstance);
//		workerInstance.sayHello();
		
		// Other way to do the same when a no argument constructor exists and an interface implementation
		TaskWorker workerViaInterface = (TaskWorker) workerType.newInstance();
		workerViaInterface.setBankAccount(target);
		workerViaInterface.sayHello();
	}
}
