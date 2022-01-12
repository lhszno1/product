package com.service;

import java.util.List;

import com.dao.P_Dao;
import com.dto.P_Dto;

public class P_Service {
	P_Dao pDao = new P_Dao();
	
	//1. 입력
	public String insertProduct(P_Dto product) {
		String msg = null;
		int result = pDao.inputProduct(product);
		
		if(result > 0 ) {
			msg = "입력 성공";
		}else {
			msg = "입력 실패";
		}
		return msg;
	}
	
	//2. 출력
	public List<P_Dto> getList(){
		List<P_Dto>	pList = pDao.selectAll();
		return pList;
	}
	
	//3. 구분출력
	public List<P_Dto> getCate(String cate){
		List<P_Dto> pList = pDao.selectCate(cate);
		return pList;
	}
	
	//4. 검색
	public P_Dto getProduct(int code) {
		P_Dto product = pDao.selectProduct(code);
		return product;
	}
	
	//5. 수정
	public String updateProduct(P_Dto product) {
		String msg = null;
		int result = pDao.updateProduct(product);
		if(result > 0) {
			msg = "수정 성공";
		}else {
			msg = "수정 실패";
		}
		return msg;
	}
	//6. 삭제
	public String deleteProduct(int code) {
		String msg = null;
		int result = pDao.deleteProduct(code);
		if(result > 0 ) {
			msg = "삭제 성공";
		}else {
			msg = "삭제 실패";
		}
		return msg;
	}

}//class























