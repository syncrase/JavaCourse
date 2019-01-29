/**
 * 
 */
/**
 * @author I310911
 *
 */
package javaFundamentalsCorePlatform.designpattern.creational.factory;

/*
 * see :
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/Factory_method
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/
 * 
 * https://fr.wikipedia.org/wiki/Fabrique_(patron_de_conception)
 * https://fr.wikipedia.org/wiki/Fabrique_abstraite
 * http://coding-geek.com/design-pattern-factory-patterns/
 * Abstract_Factory (nice diagram)
 * 
 * The factory pattern is a design pattern used to promote encapsulation of data
 * representation.
 * 
 * Problem : We want to decide at run time what object is to be created based on
 * some configuration or application parameter. When we write the code we do not
 * know what class should be instantiated. <br/> Solution : Define an interface
 * for creating an object, but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses. It's primary
 * purpose is to provide a way for users to retrieve an instance with a known
 * compile-time type, but whose runtime type may actually be different. In other
 * words, a factory method that is supposed to return an instance of the class
 * Foo may return an instance of the class Foo, or it may return an instance of
 * the class Bar, so long as Bar inherits from Foo. The reason for this is that
 * it strengthens the boundary between implementor and client, hiding the true
 * representation of the data (see Abstraction Barrier) from the user, thereby
 * allowing the implementor to change this representation at anytime without
 * affecting the client, as long as the client facing interface doesn't change.
 */
