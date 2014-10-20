package com.adobe.www;

public class EnumTest {

	public static void main(String[] args){

		WeekDay1 weekDay = WeekDay1.SUN;
		System.out.println(weekDay.nextDay());

		WeekDay weekDay2 = WeekDay.FRI;
		System.out.println(weekDay2.values().length);
	}	
	public enum WeekDay{
		
		SUN,MON,TUE,WED,THU,FRI,SAT;
		private WeekDay(){};
		private WeekDay(int Day){};
	}

	public enum TrafficLamp{
		RED(30){
			public TrafficLamp nextLamp(){
				return GREEN;
			}
		},
		GREEN(45){
			public TrafficLamp nextLamp(){
				return YELLOW;
			}			
		},
		YELLOW(5){
			public TrafficLamp nextLamp(){
				return RED;
			}			
		};
		public abstract TrafficLamp nextLamp();
		private int time;
		private TrafficLamp(int time){
			this.time = time;
		}
	}
}
