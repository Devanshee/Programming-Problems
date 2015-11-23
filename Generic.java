import java.io.*;
import java.util.ArrayList;

public class Generic {
	public static void main(String[] args){
		MyList<String, Integer> map = new MyList<String, Integer>();
		map.put("Lars", 1);
	}
}

class MyList<K,V>{

	private int size = 0;
	private int DEFAULT_CAPACITY = 16;
  
	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];
	
	 public void put(K key, V value) {		
		values[size++] = new MyEntry<K, V>(key, value);
		System.out.println("Sucessfully added!!");
	}
}

class Pair<K,V> {
	K key;
	V value;
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
		System.out.println("Key is "+key);
		System.out.println("Value is "+value);
	}	
	void setKey(K ke){
		key = ke;
		System.out.println("KEy is "+key);
	}
	void setValue(V val){
		value = val;
		System.out.println("Value is "+value);
	}
}