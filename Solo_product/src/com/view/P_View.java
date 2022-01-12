package com.view;

import java.util.List;

import com.dao.P_Dao;
import com.dto.P_Dto;

public class P_View {
	P_InOut pio = new P_InOut();
	
	//1.메인메뉴
	public int showFirst() {
		pio.twoPrint("");
		pio.twoPrint("제품관리 프로그램 연습");
		pio.twoPrint("----------------");
		pio.twoPrint("1. 입력");
		pio.twoPrint("2. 출력");
		pio.twoPrint("3. 검색");
		pio.twoPrint("4. 수정");
		pio.twoPrint("5. 삭제");
		pio.twoPrint("0. 종료");
		int m = pio.inputNum("선택 : ");
		return m;	
	}
	
	//2. 메시지 입력용
	public void printMsg(String msg) {
		pio.twoPrint(msg);
	}
	
	//3. 입력메인메뉴
	public int inputCategory() {
		int sm = -1;
		
		pio.twoPrint("<1. 데이터 입력>");
		pio.twoPrint("--------------");
		pio.twoPrint("1. 가전제품");
		pio.twoPrint("2. 생활필수품");
		pio.twoPrint("3. 식품");
		pio.twoPrint("0. 상위메뉴");
		sm = pio.inputNum("선택 : ");
		return sm;
	}
	//3-1 입력화면
	public void inputProduct(P_Dto product) {
		String str = null;
		int num = -1;
		
		pio.twoPrint("<제품 입력>");
		pio.twoPrint("-------------");
		
		num = pio.inputNum("코드 : ");
		product.setCode(num);
		str = pio.inputStr("이름 : ");
		product.setName(str);
		num = pio.inputNum("가격 : ");
		product.setPrice(num);
		num = pio.inputNum("재고 : ");
		product.setStock(num);
	}
	
	//4. 출력메인메뉴
	public int outputCategory() {
		int sm = -1;
		pio.twoPrint("<2. 데이터 출력>");
		pio.twoPrint("--------------");
		pio.twoPrint("1. 전체 출력");
		pio.twoPrint("2. 구분 출력");
		pio.twoPrint("0. 상위 메뉴");
		sm = pio.inputNum("선택 : ");
		return sm;
	}
	
	//4-1 전체 출력
	public void outputProduct(List<P_Dto> pList) {
		pio.twoPrint("<전체 출력>");
		pio.twoPrint("-----------------");
		for(P_Dto pd : pList) {
			pio.twoPrint(pd.toString());
			pio.twoPrint("-----------------");
		}
	}
	//4-2 카테고리출력메인
	public int CategoryList() {
		int ssm = -1;
		pio.twoPrint("<카테고리별  출력>");
		pio.twoPrint("-----------------");
		pio.twoPrint("1. 가전제품");
		pio.twoPrint("2. 생활필수품");
		pio.twoPrint("3. 식품");
		pio.twoPrint("0. 상위메뉴");
		ssm = pio.inputNum("선택 : ");
		return ssm;
	}
	
	//4-3 카테고리별 출력화면
	public void cateOutput(List<P_Dto> pList, int cate) {
		switch(cate) {
		case 1: 
			pio.twoPrint("--가전 카테고리--");
			break;
		case 2: 
			pio.twoPrint("--생활필수품 카테고리--");
			break;
		case 3: 
			pio.twoPrint("--식품 카테고리--");
			break;			
		}
		for(P_Dto pd : pList) {
			pio.twoPrint(pd.toString());
			pio.twoPrint("--------------");
		}
	}
	
	//5. 검색입력
	public int searchCode(String str) {
		int code = 0;
		pio.twoPrint("<데이터 검색>");
		pio.twoPrint("-----------------");
		code = pio.inputNum(str);
		return code;
	}
	
	//5-1 검색결과 출력용
	public void outputProduct(P_Dto product) {
		pio.twoPrint("<검색 결과>");
		pio.twoPrint("---------------");
		pio.twoPrint(product.toString());
	}
	
	// 6.수정
	public void updateProduct(P_Dto product) {
		String str = null;
		int n = -1;
		
		pio.twoPrint("<수정 내용>");
		pio.twoPrint("<수정 사항이 없으면 ENTER를 누르시오>");
		pio.twoPrint("----------------------------");
		str = pio.inputStr("이름 : ");
		if(!str.equals("")) {
			product.setName(str);
		}
		n = pio.inputNum("가격 : ");
		if(n != -999999) {
			product.setPrice(n);
		}
		n = pio.inputNum("재고 : ");
		if(n != -999999) {
			product.setStock(n);
		}
		str = pio.inputStr("구분 : ");
		if(!str.equals("")) {
			product.setCategory(str);
		}
	}

}//class end






















