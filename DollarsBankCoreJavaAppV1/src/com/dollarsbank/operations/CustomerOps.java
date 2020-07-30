package com.dollarsbank.operations;

//marker to help others visualize code
public interface CustomerOps<T> extends Operations<T> {
	public T get(String username);
	public T get(char[] mobile);
}
