package com.projectGo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.projectGo.controller.SellerController;
import com.projectGo.model.vo.Store;

public class StoreModifyView extends MainFrame{

	
	
	JFrame frame;
	
	SellerController sc = new SellerController();
	
	String storeName, storeIntroduce;
	int category, deliveryTip, deliveryTime;
	
	
	
	
	public StoreModifyView()  {
		
		
		Store beforeStore = sc.myStoreLoad();
		
		
		
		JLabel snl = new JLabel("가게 이름");
		JTextField snt = new JTextField();
		snt.setText(beforeStore.getStoreName());
		

		JLabel cl = new JLabel("카테고리");
		String categorySelect [] = {"한식", "중식", "일식", "양식", "분식", "디저트", "피자", "치킨", "패스트푸드" };
		
		JComboBox<String> combo = new JComboBox<String>(categorySelect);
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String c1 = combo.getSelectedItem().toString();
				category = sc.categorySelect(c1);
				
			}
		});
		
		
		JLabel dtl = new JLabel("예정 배달 소요 시간");
		JTextField dtt = new JTextField();
		int num1 = beforeStore.getDeliveryTime();
		String s1 = Integer.toString(num1);
		dtt.setText(s1);
		
		JLabel dtipl = new JLabel("배달 팁");
		JTextField dtipt = new JTextField();
		int num2 = beforeStore.getDeliveryTip();
		String s2 = Integer.toString(num2);
		dtipl.setText(s2);
		
		JLabel sil = new JLabel("가게 소개");
		JTextField sit = new JTextField();
		sil.setText(beforeStore.getStoreIntroduce());
		
		
		
		
		
		
		
	
		
		sc.storeModify(storeName, storeIntroduce, category, deliveryTip, deliveryTime);
		
		
		
		
		
	}
	
	
	
	
	
}
