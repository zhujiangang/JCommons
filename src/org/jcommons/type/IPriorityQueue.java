package org.jcommons.type;

public interface IPriorityQueue<E> {
	/**
	 * Returns true if the priority queue is non-empty
	 */
	boolean hasNext();

	/**
	 * Returns the element in the queue with highest priority, and pops it from
	 * the queue.
	 */
	E next();

	/**
	 * Not supported -- next() already removes the head of the queue.
	 */
	void remove();

	/**
	 * Returns the highest-priority element in the queue, but does not pop it.
	 */
	E peek();

	/**
	 * Gets the priority of the highest-priority element of the queue.
	 */
	double getPriority();

	/**
	 * Number of elements in the queue.
	 */
	int size();

	/**
	 * True if the queue is empty (size == 0).
	 */
	boolean isEmpty();

	/**
	 * Adds a key to the queue with the given priority.  If the key is already in
	 * the queue, it will be added an additional time, NOT promoted/demoted.
	 *
	 * @param key
	 * @param priority
	 */
	void put(E key, double priority);
}
