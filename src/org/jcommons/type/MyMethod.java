package org.jcommons.type;

/**
 * A function wrapping interface.
 * 
 * from berkeley
 */
public interface MyMethod<I, O> {
	O call(I obj);
}
