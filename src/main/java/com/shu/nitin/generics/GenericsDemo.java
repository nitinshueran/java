package com.shu.nitin.generics;


public class GenericsDemo {

	public static void main(String[] args) {
		System.out.println(getNonRepeatableChar("abc"));
	}
	
	private static char getNonRepeatableChar(String input){
		int[] temp = new int[26];
		char[] inputArray = input.toCharArray();
		for(int i=0; i<inputArray.length;i++) {
			temp[inputArray[i]-'a'] = temp[inputArray[i]-'a']+1;
			
		}
		for(int i=0;i<inputArray.length;i++) {
			if(temp[inputArray[i]-'a']==1) {
				return inputArray[i];
			}
		}
		return 0;
	}
}
