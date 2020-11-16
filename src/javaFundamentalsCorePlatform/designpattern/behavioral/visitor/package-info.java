/**
 * The point of visitor is to extend a bunch of elements with a new operation
 * without changing their implementation nor the caller's implementation.
 * http://c2.com/cgi/wiki?VisitorPattern
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/Visitor
 * https://fr.wikipedia.org/wiki/Visiteur_(patron_de_conception)
 * 
 * This design pattern is based on the overloading of the IPerformer method The
 * logic will differ based on the element type.<br>
 * It's possible to add a multitude of specific behaviour for each type which is
 * visited<br>
 * 
 * Separation of concerns :
 * <ul>
 * <li>visited elements aren't handle any logic</li>
 * <li>the logic is implemented visitors</li>
 * <li>many visitors can exist</li>
 * </ul>
 * 
 * Visitor pattern is misnamed, it implements a double dispatch
 * https://stackoverflow.com/questions/255214/when-should-i-use-the-visitor-design-pattern
 * 
 * @author Pierre TAQUET
 *
 */
package javaFundamentalsCorePlatform.designpattern.behavioral.visitor;
