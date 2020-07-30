package com.dollarsbank.operations;

import java.util.Vector;

public interface TransactionOps<T> extends Operations<T> {
	public T get(int customerId);
	public Vector<T> getAll(int custId);
}
