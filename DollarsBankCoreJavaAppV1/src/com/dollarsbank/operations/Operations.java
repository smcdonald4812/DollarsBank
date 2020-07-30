package com.dollarsbank.operations;

import java.util.Vector;

public interface Operations<T> {
	public T get(int id);
	public Vector<T> getAll();
	public void create(T t);
	public void update(T t);
	public void delete(int id);
}
