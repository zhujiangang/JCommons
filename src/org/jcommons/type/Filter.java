package org.jcommons.type;

/**
 * Filters are boolean cooccurrences which accept or reject items.
 * 
 * from berkeley
 */
public interface Filter<T> {
	boolean accept(T t);
}
