package com.dollarsbank.operations;

import java.util.Vector;

public interface AccountOps<T> extends Operations<T> {
	public T get(int custId);
	public Vector<T> getAll(int custId);
}
