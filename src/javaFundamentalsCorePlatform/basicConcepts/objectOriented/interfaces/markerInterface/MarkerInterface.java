package javaFundamentalsCorePlatform.basicConcepts.objectOriented.interfaces.markerInterface;

/**
 * An empty interface is known as tag or marker interface which is implemented
 * to claim the membership in a particular set. <br>
 * <strike>It informs the JVM that a class implementing this interface will have
 * some special behaviour.</strike> <br>
 * It provide run-time type information about objects<br>
 * For example :
 * <ul>
 * <li>Serializable</li>
 * <li>Cloneable</li>
 * <li>EventListener</li>
 * <li>Remote</li>
 * <li>TrheadSafe</li>
 * <li>...</li>
 * </ul>
 * 
 * In other word, like annotations, a marker interface convey metadata about a
 * class. Annotations are often considered to be the better option to mark a
 * class.<br>
 * But, unlike annotations, interfaces allow us to take advantage of
 * polymorphism
 * 
 * @author syncrase
 *
 */
public interface MarkerInterface {
// It's a marker interface. The content must be kept empty
}
