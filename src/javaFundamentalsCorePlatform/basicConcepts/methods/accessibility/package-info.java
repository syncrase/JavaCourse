package javaFundamentalsCorePlatform.basicConcepts.methods.accessibility;

/**
 *
 * <h1>Methods call</h1>
 * 
 * <pre>
* public method
* | Position de la class fille		| sibling 	| nested 	| out 	|
* | Callable by instance		 	|	yes		| yes		| yes	|
* | Callable from child declaration |	yes		| yes		| yes	|
* | Overridable by Child			|	yes		| yes		| yes	|
* 
* private method
* | Position de la class fille		| sibling 	| nested 	| out 	|
* | Callable by instance		 	|	no		| no		| no	|
* | Callable from child declaration |	no		| no		| no	|
* | Overridable by Child			|	no		| no		| no	|
* 
* Protected method
* | Position de la class fille		| sibling 	| nested 	| out 	|
* | Callable by instance		 	|	yes		| no		| no	|
* | Callable from child declaration |	yes		| yes		| yes	|
* | Overridable by Child			|	yes		| yes		| yes	|
 * </pre>
 * 
 * <ul>
 * <li>Protected and public methods can be called from the child class
 * declaration.</li>
 * <li>Only public methods can be called with the class instance. With the
 * exeption that</li>
 * <li>Protected methods from sibling class can be called with the class
 * instance</li>
 * </ul>
 * 
 * 
 *
 */