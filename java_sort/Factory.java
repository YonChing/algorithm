package org.rudolf.sort;

public class Factory {
	
	public static String[] names = new String[] {"Select", "Bubble", "Insert", "Heap", "Merge", "Quick", "Shell"};	
	
	public static Sort create(int which) {
		String name = "org.rudolf.sort." + names[which - 1] + "Sort";
		Sort s = null;
		try {
			@SuppressWarnings("unchecked")
			Class<Sort> clazz = (Class<Sort>) Class.forName(name);	
			s = (Sort) clazz.newInstance();			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return s;
	}
	
}
