package org.jcommons.math;

import java.io.Serializable;

public class Vector implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3806085750533208634L;

	private double[] array;

	private int length;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Vector(double[] array) {
		super();
		this.array = array;
	}

	public Vector(int length) {
		super();
		this.length = length;
	}
	
	
	public double[] getArray() {
		return array;
	}

	public void setArray(double[] array) {
		this.array = array;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
		array = new double[length];
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return this.copy();
	}

	/**
	 * Make a deep copy of a matrix
	 */
	public Vector copy() {
		Vector vector = new Vector(length);
		double[] value = vector.getArray();
		for (int i = 0; i < length; i++) {
			value[i] = array[i];
		}
		return vector;
	}

}
