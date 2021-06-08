package com.projectGo.view;

import java.util.ArrayList;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Store;

public class SellerOrderCheckView extends MainFrame{
	
	SellerController sc = new SellerController();
	
	ArrayList <Store> sellerOrder = new ArrayList<Store>();
	sellerOrder = sc.loadSellerOrder();
	
	
	
	

}
