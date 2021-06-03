package com.projectGo.model.comparator;

import java.util.Comparator;

import com.projectGo.model.vo.Store;

public class DscAveStar implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {
		// TODO Auto-generated method stub
		return (int) (o2.getAveStar()*10 - o1.getAveStar()*10 );
	}

	

}
