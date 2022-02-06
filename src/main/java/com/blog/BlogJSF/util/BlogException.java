package com.blog.BlogJSF.util;

public class BlogException extends Exception{
	
	public BlogException() {
		super();
	}
	
	public BlogException(String msg, Throwable thr) {
		super(msg,thr);
	}
	
	public BlogException(String msg) {
		super(msg);
	}
	
	public BlogException(Throwable thr) {
		super(thr);
	}

}
