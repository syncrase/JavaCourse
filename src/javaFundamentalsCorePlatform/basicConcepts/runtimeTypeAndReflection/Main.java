package javaFundamentalsCorePlatform.basicConcepts.runtimeTypeAndReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javaFundamentalsCorePlatform.basicConcepts.multithreadingAndConcurrency.coordinatingExample.BankAccount;
import javaFundamentalsCorePlatform.basicConcepts.multithreadingAndConcurrency.coordinatingExample.ProcessedBy;
import javaFundamentalsCorePlatform.basicConcepts.multithreadingAndConcurrency.coordinatingExample.WorkHandler;

/**
 * References : https://www.baeldung.com/java-reflection
 * 
 * @author Pierre
 *
 */
public class Main {

	public static void main(String[] args) {

		basicsUse();
		fullExampleWithGenerics();
	}

	private static void basicsUse() {
		Class2 class2 = new Class2("");
		System.out.println(class2.getClass().getSimpleName());// Class2
		System.out.println(class2.getClass().getSuperclass().getSimpleName());// Class1

		Class<?>[] interfaces = class2.getClass().getInterfaces();
		for (Class<?> i : interfaces) {
			System.out.println(i.getSimpleName());
		}

		try {
			System.out.println(Class
					.forName(
							"javaFundamentalsCorePlatform.multithreadingAndConcurrency.coordinatingExample.BankAccount")
					.getSimpleName());// BankAccount
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int modifiers = class2.getClass().getModifiers();
//
		System.out.println("Modifier.FINAL: " + Modifier.FINAL);// Modifier.FINAL: 16
		System.out.println("modifiers: " + modifiers);// modifiers: 17

		System.out.println("is final : " + Modifier.isFinal(modifiers));
		System.out.println("is public : " + Modifier.isPublic(modifiers));
		System.out.println("is synchronized : " + Modifier.isSynchronized(modifiers));

		HighVolumeAccount hvAccount = new HighVolumeAccount(0);
		displayFields(hvAccount.getClass().getSuperclass().getFields());
		displayFields(hvAccount.getClass().getSuperclass().getDeclaredFields());
		System.out.println();
		displayMethods(hvAccount.getClass().getMethods());
		System.out.println();
		displayMethods(hvAccount.getClass().getDeclaredMethods());
		System.out.println();

		// Call methods
		Method sayHelloMethod;
		try {
			sayHelloMethod = hvAccount.getClass().getMethod("sayHello", String.class);
			Object result = sayHelloMethod.invoke(hvAccount, "world");
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
			// N'affiche que les method d�clar�es (pas de notify equals et autre)
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

	private static void reflectionImpl(String worker, Object target)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<?> workerType = Class.forName(worker);
		Class<?> targetType = target.getClass();
		Constructor<?> c = workerType.getConstructor(targetType);
		// Constructor<?>[] constructors = workerType.getConstructors();
		// c = constructors[0];
		Object workerInstance = c.newInstance(target);
		Method sayHello = workerType.getMethod("sayHello");
		sayHello.invoke(workerInstance);

		// Other way to do the same when a no argument constructor exists and an
		// interface implementation
		TaskWorker workerViaInterface = (TaskWorker) workerType.newInstance();
		workerViaInterface.setBankAccount(target);
	}

	private static void fullExampleWithGenerics() {
		// Works only if the class as one constructor with one parameter
		Injector injector = new Injector().with("Helloworld");
		Class2 c2 = injector.newInstance(Class2.class);
		c2.printInfo();
	}

}
