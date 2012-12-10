package org.rudolf.sort;

public class Context {
	private Sort sort;
	
	public Context(Sort sort) {
		this.sort = sort;
	}
	
	public void execute() {
		Long begin = System.nanoTime();		
		this.sort.sort();
		Long end = System.nanoTime();
		System.out.print(this.sort.getClass().getSimpleName() + " run time is  ");
	    System.out.println(end - begin);
	}
}
