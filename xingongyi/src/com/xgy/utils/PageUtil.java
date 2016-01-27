package com.xgy.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
	public static List pageTools(int totalPage,int page){
		List pList = new ArrayList();//分页数字信息
		if(totalPage>5){
			for(int i=5;i>=1;i--){
				if(page<3){
					pList.add(6-i);
				}else if(page>(totalPage-2)){
					pList.add(totalPage-i+1);
				}else {
					pList.add(page+3-i);
				}
			}
		}else for(int j=1;j<=totalPage;j++){
			pList.add(j);
		}
		return pList;
	}
}
