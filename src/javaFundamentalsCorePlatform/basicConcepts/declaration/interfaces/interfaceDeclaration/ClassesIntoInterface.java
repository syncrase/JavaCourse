package javaFundamentalsCorePlatform.basicConcepts.declaration.interfaces.interfaceDeclaration;

public interface ClassesIntoInterface {

	class MyNormalClass {
		static void initializeMyClass(Object obj, String str) {
			initializeMyClass2(obj, str);
		}

		private static void initializeMyClass2(Object obj, String str) {
		}
	}

	static class MyStaticClass {
		static void initializeMyClass(Object obj, String str) {
			initializeMyClass2(obj, str);
		}

		private static void initializeMyClass2(Object obj, String str) {
		}
	}

	final static class MyFinalStaticClass {
		static void initializeMyClass(Object obj, String str) {
		}

		private void initializeMyClass2(Object obj, String str) {
		}

		public void initializeMyClass3(Object obj, String str) {
			initializeMyClass2(obj, str);
		}
	}
}
