package com.view;

import java.util.Scanner;

public class P_InOut {
	private Scanner scan = new Scanner(System.in);
	
	public void onePrint(String str) {
		System.out.print(str);
	}
	public void twoPrint(String str) {
		System.out.println(str);
	}
	
	public String inputStr(String str){
		onePrint(str);
		String s = scan.nextLine();
		return s;
	}
	public int inputNum(String str) {
		onePrint(str);
		int n = -999999;
		String s = scan.nextLine();
		
		try {
			n = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			n = -999999;
		}
		
		return n;
	}
	
}
