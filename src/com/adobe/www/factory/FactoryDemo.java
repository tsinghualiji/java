package com.adobe.www.factory;
/**
 *简单工厂模式，不属于23种模式之一；
 *屏蔽子类实现间的差异； 
 */
interface CellPhone{
	void sendMsg();
}

class Android implements CellPhone{
	public void sendMsg(){
		System.out.println("Sending android message");
	}
}

class Ios implements CellPhone{
	public void sendMsg(){
		System.out.println("Sending Ios message");
	}
}
//简单的手机工厂
class CellPhoneFactory{
	public static CellPhone getInstance(String type){	
		if ("Android".equals(type)){
			return new Android();
		}else{
			return new Ios();
		}
	}
}

public class FactoryDemo {
	public static void main(String[] args){
		CellPhone cp = CellPhoneFactory.getInstance("Ios");
		cp.sendMsg();
	}
}
