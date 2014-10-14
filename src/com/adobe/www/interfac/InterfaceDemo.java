package com.adobe.www.interfac;

interface IUSB{

	public abstract void swapData();
	
}

interface WIRE{
	
	public abstract void transferData();
}

class MouseUSBImpl implements IUSB{
	
	public void swapData(){
		System.out.println("Mouse is moving");
	}
}

public class InterfaceDemo {

	public static void main(String[] args){
		
		IUSB usb = new MouseUSBImpl();
		usb.swapData();
		
	}
	
}
