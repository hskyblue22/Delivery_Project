package com.projectGo.model.comparator;

import java.util.Comparator;

import com.projectGo.model.vo.Store;

public class AscDeliveryTip implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {
		// TODO Auto-generated method stub
		return o1.getDeliveryTip() - o2.getDeliveryTip();
	}

}
