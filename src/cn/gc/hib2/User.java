package cn.gc.hib2;

public class User {
	
	//名字和地址不会重复
	private CompositeKeys keys;
	private int age;
	
	
	public CompositeKeys getKeys() {
		return keys;
	}
	public void setKeys(CompositeKeys keys) {
		this.keys = keys;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
