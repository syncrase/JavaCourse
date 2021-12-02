/**
 * The point of visitor is to extend a bunch of elements with a new operation without changing their implementation nor the caller's 
 * implementation.
 * http://c2.com/cgi/wiki?VisitorPattern
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/Visitor
 */
/**
 * @author I310911
 *
 */
package javaFundamentalsCorePlatform.designpattern.behavioral.visitors.setofactions;
/*
 * http://c2.com/cgi/wiki?VisitorPattern
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/Visitor
 * https://fr.wikipedia.org/wiki/Visiteur_(patron_de_conception)
 * comportemental
 * 
 * The point of visitor is to extend a bunch of elements with a new operation without changing their implementation nor the caller's 
 * implementation.
 * mani�re de s�parer un algorithme d'une structure de donn�es
 * 
 * Ce design pattern se base sur la surcharge des m�thodes du set d'actions. Fonction de l'�lement re�u, le traitement n'est pas le m�me
 * Possibilit� de coder quelque chose propre � l'instance
 */