package com.adobe.www;

public abstract class WeekDay1 {

	private WeekDay1(){};
	
	public final static WeekDay1 MON = new WeekDay1(){

		public WeekDay1 nextDay(){
			return SUN;
		}
		
	};
	
	public final static WeekDay1 SUN = new WeekDay1(){
		
		public WeekDay1 nextDay(){
			return MON;
		}
		
	};
	
/*	public WeekDay nextDay(){
	
		if(this == SUN){
			return MON;
		}else{
			return SUN;
		}
	}*/
	
	public abstract WeekDay1 nextDay();
	
}
