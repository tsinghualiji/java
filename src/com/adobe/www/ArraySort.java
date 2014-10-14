package com.adobe.www;

public class ArraySort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,2,6,9,8,-1};
		bubbleSort(arr);
		String str = printArray(arr);
		System.out.println(str);
	}

	/*
	 * 每次都拿指定的一个元素和后面的元素进行比较
	 * 第一轮比较之后，最值出现在第一个位置
	 * 每轮比较只进行一次交换
	 */
	public static void selectionSort(int arr[]){
		
		for (int i = 0; i < arr.length; i++){
			
			//j ＝ i+1；第n轮比较的时候，从第i+1个元素开始取元素去和第i个先比较
			for (int j=i+1; j< arr.length; j++){
				
				if (arr[i] > arr[j]){
					
					int temp;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
		}
	}
	/*
	 * 冒泡排序：
	 * 相邻两个元素相互比较，符合条件就换位
	 * 第一轮比较之后，最大值出现在最后一个位置
	 */
	public static void bubbleSort(int arr[]){
		//最后一个元素后面就没有相邻元素乐
		for (int i = 0; i< arr.length - 1; i++){
			//每次内循环都从第一个元素开始比较，第n圈的时候，arr。length － N
			for (int j = 0; j< arr.length - i - 1; j ++){
				//相邻比较只能用j，当j取到最大值时，j＋1就越界乐
				if(arr[j] > arr[j+1]){
					
					int temp;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
	}
	
	public static String printArray(int[] arr){
		
		String str = "[";
		for (int i = 0; i < arr.length; i++){
			str += arr[i];
			if ( i == arr.length -1 ){
				str += "]";
			}
			str += ",";
		}
		return str;
	}
}
