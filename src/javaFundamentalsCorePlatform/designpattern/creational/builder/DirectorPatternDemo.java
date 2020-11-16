package javaFundamentalsCorePlatform.designpattern.creational.builder;

public class DirectorPatternDemo {

	public static void main(String[] args) {
		
		final ProductDirector pd = new ProductDirector();
		
		pd.setProductBuilder(new Product1Builder());
		pd.constructProduct();
		final Product p1 = pd.getProduct();
		
		pd.setProductBuilder(new Product2Builder());
		pd.constructProduct();
		final Product p2 = pd.getProduct();
		
		System.out.println("Product 1 :");
		System.out.println(p1.getType1());
		System.out.println(p1.getType2());
		System.out.println(p1.getType3());
		System.out.println("Product 2 :");
		System.out.println(p2.getType1());
		System.out.println(p2.getType2());
		System.out.println(p2.getType3());
	}

}
