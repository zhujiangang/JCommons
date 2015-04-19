package org.jcommons.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUtils {

	public static <T> Set<T> List2Set(List<T> list){
		Set<T> set = new HashSet<T>();
		if(list==null)
			return null;
		for(T t:list){
			set.add(t);
		}
		return set;
	}
	
	public static <T> List<T> Set2List(Set<T> set){
		List<T> list = new ArrayList<T>();
		if(set == null)
			return null;
		for(T t : set)
			list.add(t);
		return list;
	}
	public static <T> Set<T> intersection(Set<T> a,Set<T> b){
		Set<T> set = new HashSet<T>();
		for(T t1:a){
			for(T t2:b){
				if(t1.equals(t2)){
					set.add(t1);
					break;
				}
			}
		}
		return set;
	}
	
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		if(a==null && b==null)
			return null;
		if(a==null && b!=null)
			return b;
		if(a!=null && b==null)
			return a;
		
		for(T t:b){
			if(!a.contains(t))
				a.add(t);
		}
		return a;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
