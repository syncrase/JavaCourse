package javaFundamentalsCorePlatform.records;

public class Main {

	public static void main(String[] args) {
        MyFirstRecord p1 = new MyFirstRecord( 0, 0 );
        System.out.println( p1 );
        
        MyFirstRecord p2 = new MyFirstRecord( 10, 10 );
        System.out.println( p2 );
        
        System.out.println( "Egalité : " + ( p1 == p2 ) );
        System.out.println( "Hash code : " + p2.hashCode() );
        System.out.println( "Getters : " + p2.x() + " - " + p2.y() );
	}

}
