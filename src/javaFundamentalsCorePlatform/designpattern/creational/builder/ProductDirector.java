package javaFundamentalsCorePlatform.designpattern.creational.builder;

public class ProductDirector {

	private ProductBuilderABSTRACT prodBuilder;
	
	public void setProductBuilder(final ProductBuilderABSTRACT pb){
		this.prodBuilder = pb;
	}
	
	public Product getProduct(){
		return this.prodBuilder.getProduct();
	}
	
	public void constructProduct(){
		this.prodBuilder.createNewProduct();
		this.prodBuilder.buildType1();
		this.prodBuilder.buildType2();
		this.prodBuilder.buildType3();
	}
}
