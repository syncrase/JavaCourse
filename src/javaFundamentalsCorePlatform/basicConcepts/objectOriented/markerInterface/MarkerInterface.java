package javaFundamentalsCorePlatform.basicConcepts.objectOriented.markerInterface;

/**
 * An empty interface is known as tag or marker interface which is implemented
 * to claim the membership in a particular set. It informs the JVM that a class
 * implementing this interface will have some special behaviour. <br/>
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
 * class
 * 
 * @author syncrase
 *
 */
public interface MarkerInterface {
// It's a marker interface. The content must be kept empty
}
