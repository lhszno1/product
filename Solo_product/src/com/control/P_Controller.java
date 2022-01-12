package com.control;

import java.util.List;

import com.dto.P_Dto;
import com.service.P_Service;
import com.view.P_View;

public class P_Controller {
	P_View pv = new P_View();
	P_Service ps = new P_Service();

	public void run() {
		int menu = -1;
		while(true) {
			menu = pv.showFirst();
			if(menu == 0) {
				pv.printMsg("종료");
				return;
			}
			switch(menu) {
			case 1 :
				inputProduct();
				break;
			case 2 :
				outputProduct();
				break;
			case 3 :
				searchProduct();
				break;
			case 4 :
				updateProduct();
				break;
			case 5 :
				deleteProduct();
				break;
			}
		}
	}//run



	private void deleteProduct() {
		int code = pv.searchCode("삭제코드 : ");
		P_Dto product = ps.getProduct(code);
		if(product != null) {
			pv.outputProduct(product);
			String msg = ps.deleteProduct(code);
			pv.printMsg(msg);
		}else {
			pv.printMsg("해당 데이터 없음");
		}
		

	}

	private void updateProduct() {
		int code = pv.searchCode("수정 코드 : ");
		P_Dto product = ps.getProduct(code);
		if(product != null) {
			pv.updateProduct(product);
			ps.updateProduct(product);
			String msg = ps.updateProduct(product);
			pv.printMsg(msg);
		}else {
			pv.printMsg("해당 데이터 없음");
		}

	}

	private void searchProduct() {
		int code = pv.searchCode("검색 코드 : ");
		P_Dto product = ps.getProduct(code);
		if(product != null) {
			pv.outputProduct(product);
		}else {
			pv.printMsg("검색결과 없음");
		}

	}
	private void outputProduct() {
		int sm = -1;
		while(true) {
			sm = pv.outputCategory();
			if(sm == 0) {
				pv.printMsg("상위 메뉴로 돌아갑니다");
				return;
			}
			switch (sm) {
			case 1:
				SelectAll();
				break;
			case 2:
				outputCategory();
				break;

			default:
				pv.printMsg("0~2 사이의 숫자를 입력하세요");
			}
		}
		
	}	
	public void SelectAll() {
		List<P_Dto> pList = ps.getList();
		pv.outputProduct(pList);
	}

	private void outputCategory() {
		int ssm = -1;
		while(true) {
			ssm = pv.CategoryList();
			if(ssm == 0){
				pv.printMsg("상위메뉴로 돌아갑니다"	);
				return;
			}
			switch(ssm) {
			case 1 : 
				List<P_Dto> pList = ps.getCate("가전");
				if(pList.size() != 0) {
					pv.cateOutput(pList, 1);
				}else {
					pv.printMsg("등록된 상품이 없습니다");
				}
				break;
			case 2 : 
				List<P_Dto> pList1 = ps.getCate("생활필수품");
				if(pList1.size() != 0) {
					pv.cateOutput(pList1, 2);
				}else {
					pv.printMsg("등록된 상품이 없습니다");
				}
				break;
			case 3 : 
				List<P_Dto> pList2 = ps.getCate("식품");
				if(pList2.size() != 0) {
					pv.cateOutput(pList2, 3);
				}else {
					pv.printMsg("등록된 상품이 없습니다");
				}
				break;
			}
		}

	}

	private void inputProduct() {
		int sm = -1;
		while(true) {
			sm = pv.inputCategory();
			if(sm == 0) {
				pv.printMsg("상위메뉴로 돌아갑니다");
				return;
			}
			String cate = "";
			switch(sm) {
			case 1 : 
				cate = "가전";
				break;
			case 2 : 
				cate = "생활필수품";
				break;
			case 3 : 
				cate = "식품";
				break;
			default :
				pv.printMsg("0~3사이의 숫자를 입력하세요");
				continue;
			}
			P_Dto product = new P_Dto();
			product.setCategory(cate);
			pv.inputProduct(product);
			String msg = ps.insertProduct(product);
			pv.printMsg(msg);
		}
	}
}//class




















