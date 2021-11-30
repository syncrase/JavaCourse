package javaFundamentalsCorePlatform.basicConcepts.collections.iterables;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Queue represents a data structure designed to have elements inserted at the
 * end, and elements removed from the beginning<br>
 * First In First Out<br>
 * Ordered sequence of objects<br>
 * In most Queue implementations the head and tail are at opposite ends<br>
 * In a stack they are in the same place<br>
 * 
 * Queue follows the FIFO (First In, First Out) order. This means that the
 * element is inserted in the queue at the end and removed from the queue at the
 * beginning.<br>
 * The Java queue interface provides all the methods of Collection interface
 * like insertion, deletion, etc.<br>
 * LinkedList and PriorityQueue are the classes that implement the Queue
 * interface. ArrayBlockingQueue is yet another class that implements the Queue
 * interface.<br>
 * The Queues that are a part of the java.util package can be classified as
 * unbounded queues while those present in java.util.the concurrent package is
 * bounded queues.<br>
 * The Deque is a queue that supports insertion and deletion from both the
 * ends.<br>
 * The deque is thread-safe.<br>
 * BlockingQueues are thread-safe and are used to implement producer-consumer
 * problems.<br>
 * BlockingQueues do not allow null elements. A NullPointerException is thrown
 * if any operation related to null values is attempted.<br>
 * 
 * @author syncrase
 *
 */
public class QueueExemple {

	public static void main(String[] args) {
		usingQueueInterface();
		differentTypesOfQueues();
	}

	private static void differentTypesOfQueues() {
		Queue<String> queue = new LinkedList<>();
		queue = new PriorityQueue<>();// Sort elements when adding it
	}

	/**
	 */
	private static void usingQueueInterface() {
		Queue<String> queue = new LinkedList<>();
		// Add with or without exception if list is full
		queue.add("element 1");// Insert or throw exception if Queue is full
		queue.offer("element 2");// Insert without exception
		queue.add("element 3");
		print(queue);

		// check the head item with or without exception
		System.out.println("element : " + queue.element());
		// Check if head's queue exists or throw exception
		System.out.println("peek : " + queue.peek());
		// Check if head's queue exists
		print(queue);

		// Get the head item with or without exception
		System.out.println("remove : " + queue.remove());
		// remove last inserted or throw exception
		System.out.println("poll : " + queue.poll());
		// Remove last inserted without exception
		print(queue);

		// Clear the queue
		queue.clear();

	}

	/**
	 */
	private static void usingCollectionInterface() {
		Collection<String> queue = new LinkedList<>();
		queue.size();
		queue.add("qsdqsd");
		queue.contains("Mazda");
		queue.removeIf(str -> str.toCharArray().length == 0);
		queue.stream().collect(Collectors.joining(", ", "[", "]"));

		// access via Iterator
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
		}

		// access via new for-loop
		for (String element : queue) {
			// do something with each element
		}
	}

	private static void print(Queue<String> queue) {
		System.out.println(queue.stream().collect(Collectors.joining(", ", "[", "]")));
	}

}
