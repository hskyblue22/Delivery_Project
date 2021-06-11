package com.projectGo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.projectGo.controller.OrderController;
import com.projectGo.model.vo.Order;

public class OrderView extends MainFrame{
	
	
	private JFrame frame;
	private JTextField reqTextField;
	private JTextField pointTextField;
	private JLabel usedPointLab;
	private JLabel totalPaymentLab;
	
	private OrderController ordCont;
	private int usePoint;
	private int totalPayment;

	
	public OrderView(Order order) {
		
		ordCont = new OrderController(order);
		totalPayment = ordCont.getTotalCharge() + ordCont.getDeliveryTip();
//		totalPayment = ordCont.getTotalCharge() + ordCont.getDeliveryTip() - usePoint;
		
		frame = MainFrame.mainFrame;
		frame.getContentPane().removeAll();
		frame.validate();
		frame.repaint();
		initialize();
		
	}
	
	
	public void initialize() {
		
		JLabel mainLabel = new JLabel("주문하기");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		mainLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(mainLabel);
		
		
		JButton preButton = new JButton("이전");
		preButton.setBounds(15, 20, 80, 40);
		preButton.setSize(80, 40);
		preButton.setBackground(Color.orange);
		preButton.setForeground(Color.white);
		preButton.setBorderPainted(false); //테두리 제거
		preButton.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(preButton);
		
		preButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//이전으로 화면 전환 되었을 때, 초기 값이 아닌 변경된 데이터로 저장
				new BasketView(ordCont.getBasket());
			}
			
		});
		
		
		//배달정보
		JLabel deliveryInfo = new JLabel("배달정보");
		deliveryInfo.setFont(new Font("굴림",Font.PLAIN, 25));
		deliveryInfo.setBounds(15, 80, 250, 60);
		frame.getContentPane().add(deliveryInfo);
		
		JLabel addressLab = new JLabel("주소 : " + ordCont.getUserAddress());
		addressLab.setFont(new Font("굴림", Font.PLAIN, 17));
		addressLab.setBounds(15, 135, 368, 40);
		frame.getContentPane().add(addressLab);
		
		JLabel phoneNumLab = new JLabel("연락처 : " + ordCont.getUserPhone());
		phoneNumLab.setBounds(15, 168, 368, 40);
		phoneNumLab.setFont(new Font("굴림", Font.PLAIN, 17));
		frame.getContentPane().add(phoneNumLab);
		
		
		//요청사항
		JPanel requestPanel = new JPanel();
		requestPanel.setBounds(0, 221, 534, 125);
		frame.getContentPane().add(requestPanel);
		requestPanel.setLayout(null);
		
		JLabel requestLab = new JLabel("요청사항");
		requestLab.setFont(new Font("굴림", Font.PLAIN, 17));
		requestLab.setBounds(34, 20, 93, 29);
		requestPanel.add(requestLab);
		
		reqTextField = new JTextField();
		reqTextField.setBounds(34, 59, 456, 29);
		requestPanel.add(reqTextField);
		reqTextField.setColumns(10);
		
		
		//요청사항 전달
		reqTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ordCont.setRequest(reqTextField.getText());
			}
		});
		
		
		//포인트
		JPanel pointPanel = new JPanel();
		pointPanel.setBounds(0, 356, 534, 125);
		frame.getContentPane().add(pointPanel);
		pointPanel.setLayout(null);
		
		
		//포인트 불러오기
		JLabel pointLab = new JLabel("보유포인트  : " + ordCont.getPoint());
		pointLab.setFont(new Font("굴림", Font.PLAIN, 17));
		pointLab.setBounds(40, 22, 200, 31);
		pointPanel.add(pointLab);
		
		
		JLabel usePointLab = new JLabel("사용할 금액 : ");
		usePointLab.setFont(new Font("굴림", Font.PLAIN, 17));
		usePointLab.setBounds(40, 63, 108, 31);
		pointPanel.add(usePointLab);
		

		pointTextField = new JTextField();
		pointTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		pointTextField.setBounds(264, 64, 222, 31);
		pointPanel.add(pointTextField);
		pointTextField.setColumns(10);
		
		
		pointTextField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				
				// 포인트 없을 때 팝업
				if (ordCont.getPoint() == 0) {
					JOptionPane.showMessageDialog(null, "사용 가능한 포인트가 없습니다.");
					return;
				}
				

				// 숫자가 아닌 다른값을 입력했을때?
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || c == '')) {
					JOptionPane.showMessageDialog(null, "숫자만 입력해 주세요.");
					pointTextField.setText("");
					usedPointLab.setText("포인트 사용     : ");
					return;
				}
				
				if(c == '') {
					pointTextField.setText("");
					usedPointLab.setText("포인트 사용     : ");
					return;
				}

				usePoint = Integer.parseInt(pointTextField.getText());
				
				if(usePoint > ordCont.getPoint()) {
					JOptionPane.showMessageDialog(null, "사용 가능한 금액을 초과하였습니다.");
					pointTextField.setText("");
					usedPointLab.setText("포인트 사용     : ");
					return;
				}
				
				usedPointLab.setText("포인트 사용     : -" + usePoint);
				totalPaymentLab.setText("총 결제 금액 : " + (totalPayment - usePoint));

				ordCont.setPoint(usePoint); // 보유 포인트 - usePoint

			}

		});
		
		
		//결제 금액
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBounds(0, 491, 534, 183);
		frame.getContentPane().add(paymentPanel);
		paymentPanel.setLayout(null);
		
		
		JPanel line1 = new JPanel();
		line1.setBackground(Color.GRAY);
		line1.setBounds(0, 491, 534, 4);
		paymentPanel.add(line1);
		
		
		JLabel paymetLabel = new JLabel("결제 금액");
		paymetLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		paymetLabel.setBounds(40, 10, 106, 33);
		paymentPanel.add(paymetLabel);
		
		
		JLabel orderChargeLab = new JLabel("주문 금액        : " + ordCont.getTotalCharge());
		orderChargeLab.setFont(new Font("굴림", Font.PLAIN, 15));
		orderChargeLab.setBounds(40, 46, 456, 33);
		paymentPanel.add(orderChargeLab);

		
		JLabel deliveryTipLab = new JLabel("배달팁            : " + ordCont.getDeliveryTip());
		deliveryTipLab.setFont(new Font("굴림", Font.PLAIN, 15));
		deliveryTipLab.setBounds(40, 74, 456, 33);
		paymentPanel.add(deliveryTipLab);
		
		
		usedPointLab = new JLabel("포인트 사용     : ");
		usedPointLab.setFont(new Font("굴림", Font.PLAIN, 15));
		usedPointLab.setBounds(40, 104, 456, 33);
		paymentPanel.add(usedPointLab);
		
		
		totalPaymentLab = new JLabel("총 결제 금액 : " + totalPayment);
		totalPaymentLab.setFont(new Font("굴림", Font.PLAIN, 17));
		totalPaymentLab.setBounds(40, 140, 456, 33);
		paymentPanel.add(totalPaymentLab);
		

		JButton paymentButton = new JButton("결제하기");
		paymentButton.setForeground(Color.WHITE);
		paymentButton.setBackground(Color.ORANGE);
		paymentButton.setBounds(-1, 690, 535, 60);
		paymentButton.setBorderPainted(false); //테두리 제거
		paymentButton.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(paymentButton);
		
		paymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//포인트 사용하지 않았을 경우 결제 금액?? 포인트 사용하고 결제하기 누르면??
				
				ordCont.setTotalPayment(totalPayment - usePoint);
//				System.out.println(totalPayment - usePoint);
				
				//유저 정보에서 포인트 적립률 가져오기??
				ordCont.savePoint((int)((totalPayment -usePoint) * 0.01));
				ordCont.orderOutPut();
				
				
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				completeOrder();
			}
		});
		
	}
		

	//주문 완료 페이지
	private void completeOrder() {
	
		JLabel mainLabel = new JLabel("주문완료");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		mainLabel.setBounds(150, 10, 250, 60);
		frame.getContentPane().add(mainLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 156, 476, 178);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주문이 완료되었습니다!");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 27, 285, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("결제 금액 : " + (totalPayment -usePoint));
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(130, 82, 161, 35);
		panel.add(lblNewLabel_1);
		
		
//		포인트 적립
//		int savePoint = totalPayment * (/*user객체 받아서 불러오기 getUser().getPointRatio*/);
		
		JLabel lblNewLabel_2 = new JLabel("적립 포인트 : " + (int)((totalPayment -usePoint) * 0.01)); 
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(130, 113, 150, 35);
		panel.add(lblNewLabel_2);
		
		
		JButton btnNewButton = new JButton("주문 내역 보기");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(31, 583, 476, 60);
		btnNewButton.setBorderPainted(false); //테두리 제거
		btnNewButton.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					new  OrderListView();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton homeButton = new JButton("홈으로 돌아가기");
		homeButton.setForeground(Color.WHITE);
		homeButton.setBackground(Color.ORANGE);
		homeButton.setBounds(31, 653, 476, 60);
		homeButton.setBorderPainted(false); //테두리 제거
		homeButton.setFocusPainted(false); //텍스트 테두리 제거
		frame.getContentPane().add(homeButton);
		
		homeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new HomeView();
			}
		});
		

		Image icon = new ImageIcon("images/check.PNG").getImage().getScaledInstance(100, 100, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(220, 400, 100, 100);
		frame.getContentPane().add(label);
		
		frame.validate();
		frame.repaint();
		
	}

}
