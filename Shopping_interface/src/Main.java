import items.*;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {
		
		ArrayList <Cloths> basket_list = new ArrayList <Cloths>();
		ArrayList <JLabel> basket_list_labels = new ArrayList <JLabel>();
		
		Stock stock = new Stock(50,50,50,50);
		
		JFrame frame = new JFrame("shop");
		frame.setSize(750,500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Choose item buttons
		JLabel l_choose = new JLabel("choose:");
		l_choose.setBounds(10, 10, 150, 50);
		frame.add(l_choose);
		
		JButton b_shirt = new JButton("Shirt");
		b_shirt.setBounds(10, 60, 150, 50);
		frame.add(b_shirt);
		
		JButton b_t_shirt = new JButton("T-shirt");
		b_t_shirt.setBounds(10, 110, 150, 50);
		frame.add(b_t_shirt);
		
		JButton b_pants = new JButton("Pants");
		b_pants.setBounds(10, 160, 150, 50);
		frame.add(b_pants);
		
		JButton b_short = new JButton("Short");
		b_short.setBounds(10, 210, 150, 50);
		frame.add(b_short);
		
		
		// Basket
		int item_dis = 20;
		JLabel l_basket = new JLabel("basket:");
		l_basket.setBounds(250, 10, 150, 50);
		frame.add(l_basket);
		
		// Properties labels
		JLabel l_size = new JLabel("Size");
		l_size.setBounds(50, 300, 150, 50);
		frame.add(l_size);
		
		JLabel l_color = new JLabel("Color");
		l_color.setBounds(125, 300, 150, 50);
		frame.add(l_color);
		
		JLabel l_gender = new JLabel("Gender");
		l_gender.setBounds(200, 300, 150, 50);
		frame.add(l_gender);
		
		// properties control
		JTextField t_size = new JTextField();
		t_size.setBounds(50, 350, 25, 25);
		frame.add(t_size);
		
		JTextField t_color = new JTextField();
		t_color.setBounds(115, 350, 50, 25);
		frame.add(t_color);
		
		JCheckBox c_male = new JCheckBox("male");
		c_male.setBounds(200, 340, 150, 25);
		frame.add(c_male);
		
		JCheckBox c_female = new JCheckBox("female");
		c_female.setBounds(200, 360, 150, 25);
		frame.add(c_female);
		
		JCheckBox c_vcut = new JCheckBox("vcut(for shirts/T-shirts)");
		c_vcut.setBounds(20, 400, 200, 30);
		frame.add(c_vcut);
		
		JCheckBox c_aboveknee = new JCheckBox("aboveknee(for shorts)");
		c_aboveknee.setBounds(20, 430, 200, 30);
		frame.add(c_aboveknee);
		
		//Checkout
		JLabel l_name = new JLabel("User Name");
		l_name.setBounds(500, 10, 150, 30);
		frame.add(l_name);
		
		JTextField t_name = new JTextField();
		t_name.setBounds(600, 15, 100, 20);
		frame.add(t_name);
		
		JLabel l_pass = new JLabel("Password");
		l_pass.setBounds(500, 30, 150, 30);
		frame.add(l_pass);
		
		JTextField t_pass = new JTextField();
		t_pass.setBounds(600, 35, 100, 20);
		frame.add(t_pass);
		
		JButton b_checkout = new JButton("Checkout");
		b_checkout.setBounds(500, 100, 150, 50);
		frame.add(b_checkout);
		
		//empty basket
		JButton b_empty_basket = new JButton("empty basket");
		b_empty_basket.setBounds(250, 400, 120, 30);
		frame.add(b_empty_basket);
		
		
		//properties guide
		JLabel l_size_guid = new JLabel("Available sizes: S(small), M(medium), L(large)");
		l_size_guid.setBounds(400, 300, 300, 50);
		frame.add(l_size_guid);
		
		JLabel l_color_guid = new JLabel("Available colors: black, white, blue");
		l_color_guid.setBounds(400, 350, 300, 50);
		frame.add(l_color_guid);
		
		
		//choosing cloth item
		b_shirt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char size;
				String color;
				String gender;
				boolean vcut = c_vcut.isSelected();
				
				try {
					size = Character.toLowerCase(t_size.getText().charAt(0));
				}catch(StringIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(frame, "Please enter a size");
					return;
				}
				
				color = t_color.getText();
				color = color.toLowerCase();
				
				if(validate_fields(size, color) == 1) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid size");
					return;
				}else if(validate_fields(size, color) == 2) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid color");
					return;
				}
			
				
				if(c_male.isSelected() == true) {
					gender = "male";
				}else if(c_female.isSelected() == true){
					gender = "female";
				}else {
					JOptionPane.showMessageDialog(frame, "Please choose a gender");
					return;
				}
				
				//adding item to item list
				Shirts cloth = new Shirts(size, color, gender, vcut);
				basket_list.add(cloth);
				
				//adding item to item label list
				JLabel in_basket = new JLabel("shirt ("+Character.toUpperCase(cloth.getSize())+", "+cloth.getColor()+", "+cloth.getGender()+", vcut="+cloth.isVcut()+")");
				in_basket.setBounds(250, 40+item_dis*basket_list_labels.size()-1, 250, 50);
				basket_list_labels.add(in_basket);
				
				//Reprinting the list on the screen
				for(int i=0; i<basket_list_labels.size();i++) {
					frame.add(basket_list_labels.get(i));
					frame.repaint();
				}
				
				//clearing the fields
				t_size.setText("");
				t_color.setText("");
				c_male.setSelected(false);
				c_female.setSelected(false);
				c_vcut.setSelected(false);
				c_aboveknee.setSelected(false);
				
			}
		});
		
		
		b_t_shirt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				char size;
				String color;
				String gender;
				boolean vcut = c_vcut.isSelected();
				
				try {
					size = Character.toLowerCase(t_size.getText().charAt(0));
				}catch(StringIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(frame, "Please enter a size");
					return;
				}
				
				color = t_color.getText();
				color = color.toLowerCase();
				
				if(validate_fields(size, color) == 1) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid size");
					return;
				}else if(validate_fields(size, color) == 2) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid color");
					return;
				}
			
				
				if(c_male.isSelected() == true) {
					gender = "male";
				}else if(c_female.isSelected() == true){
					gender = "female";
				}else {
					JOptionPane.showMessageDialog(frame, "Please choose a gender");
					return;
				}
				
				//adding item to item list
				Tshirts cloth = new Tshirts(size, color, gender, vcut);
				basket_list.add(cloth);
				
				//adding item to item label list
				JLabel in_basket = new JLabel("T-shirt ("+Character.toUpperCase(cloth.getSize())+", "+cloth.getColor()+", "+cloth.getGender()+", vcut="+cloth.isVcut()+")");
				in_basket.setBounds(250, 40+item_dis*basket_list_labels.size()-1, 250, 50);
				basket_list_labels.add(in_basket);
				
				//Reprinting the list on the screen
				for(int i=0; i<basket_list_labels.size();i++) {
					frame.add(basket_list_labels.get(i));
					frame.repaint();
				}
				
				//clearing the fields
				t_size.setText("");
				t_color.setText("");
				c_male.setSelected(false);
				c_female.setSelected(false);
				c_vcut.setSelected(false);
				c_aboveknee.setSelected(false);
			
				
				
			}
		});
		
		b_pants.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char size;
				String color;
				String gender;
				
				try {
					size = Character.toLowerCase(t_size.getText().charAt(0));
				}catch(StringIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(frame, "Please enter a size");
					return;
				}
				
				color = t_color.getText();
				color = color.toLowerCase();
				
				if(validate_fields(size, color) == 1) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid size");
					return;
				}else if(validate_fields(size, color) == 2) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid color");
					return;
				}
			
				
				if(c_male.isSelected() == true) {
					gender = "male";
				}else if(c_female.isSelected() == true){
					gender = "female";
				}else {
					JOptionPane.showMessageDialog(frame, "Please choose a gender");
					return;
				}
				
				//adding item to item list
				Pants cloth = new Pants(size, color, gender);
				basket_list.add(cloth);
				
				//adding item to item label list
				JLabel in_basket = new JLabel("Pants ("+Character.toUpperCase(cloth.getSize())+", "+cloth.getColor()+", "+cloth.getGender()+")");
				in_basket.setBounds(250, 40+item_dis*basket_list_labels.size()-1, 250, 50);
				basket_list_labels.add(in_basket);
				
				//Reprinting the list on the screen
				for(int i=0; i<basket_list_labels.size();i++) {
					frame.add(basket_list_labels.get(i));
					frame.repaint();
				}
				
				//clearing the fields
				t_size.setText("");
				t_color.setText("");
				c_male.setSelected(false);
				c_female.setSelected(false);
				c_vcut.setSelected(false);
				c_aboveknee.setSelected(false);
				
			

			}
		});
		
		b_short.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char size;
				String color;
				String gender;
				boolean above_knee = c_aboveknee.isSelected();
				
				try {
					size = Character.toLowerCase(t_size.getText().charAt(0));
				}catch(StringIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(frame, "Please enter a size");
					return;
				}
				
				color = t_color.getText();
				color = color.toLowerCase();
				
				if(validate_fields(size, color) == 1) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid size");
					return;
				}else if(validate_fields(size, color) == 2) {
					JOptionPane.showMessageDialog(frame, "Please enter a valid color");
					return;
				}
			
				
				if(c_male.isSelected() == true) {
					gender = "male";
				}else if(c_female.isSelected() == true){
					gender = "female";
				}else {
					JOptionPane.showMessageDialog(frame, "Please choose a gender");
					return;
				}
				
				//adding item to item list
				Shorts cloth = new Shorts(size, color, gender, above_knee);
				basket_list.add(cloth);
				
				//adding item to item label list
				JLabel in_basket = new JLabel("Shorts ("+Character.toUpperCase(cloth.getSize())+", "+cloth.getColor()+", "+cloth.getGender()+", above knee="+cloth.isAbove_knee()+")");
				in_basket.setBounds(250, 40+item_dis*basket_list_labels.size()-1, 250, 50);
				basket_list_labels.add(in_basket);
				
				//Reprinting the list on the screen
				for(int i=0; i<basket_list_labels.size();i++) {
					frame.add(basket_list_labels.get(i));
					frame.repaint();
				}
				
				//clearing the fields
				t_size.setText("");
				t_color.setText("");
				c_male.setSelected(false);
				c_female.setSelected(false);
				c_vcut.setSelected(false);
				c_aboveknee.setSelected(false);
				
				
			}
		});
		
		c_male.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c_female.setSelected(false);
				
				
			}
		});
		
		c_female.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c_male.setSelected(false);
				
				
			}
		});
		
		
		
		//empty basket
		b_empty_basket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<basket_list_labels.size();i++) {
					frame.remove(basket_list_labels.get(i));
				}
				
				basket_list.clear();
				basket_list_labels.clear();
				frame.repaint();
				
			}
		});
		
		//checkout
		b_checkout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = t_name.getText();
				String pass = t_pass.getText();
				
				//clear fields
				t_name.setText("");
				t_pass.setText("");
				
				//Check valid input
				if(userName.equalsIgnoreCase("husam") && pass.equals("1234")) {
					
					//stock control
					for(int i=0; i<basket_list_labels.size();i++) {
						String item =basket_list_labels.get(i).getText();
						item = item.substring(0, item.indexOf('(')).strip();
						item = item.toLowerCase();
						switch(item) {
							case "shirt":
								stock.buyShirt();
								break;
							case "t-shirt":
								stock.buyT_shirt();
								break;
							case "pants":
								stock.buyPants();
								break;
							case "shorts":
								stock.buyShorts();
								break;
								
						}
					}
					
					//stock display on terminal
					System.out.printf("Shirts: %d  T-shirts: %d  Pants: %d   Shorts: %d", stock.getShirts(),stock.getT_shirts(),stock.getPants(),stock.getShorts());
					System.out.println();
					
					
					//empty basket
					for(int i=0; i<basket_list_labels.size();i++) {
						frame.remove(basket_list_labels.get(i));
					}
					
					basket_list.clear();
					basket_list_labels.clear();
					frame.repaint();
					
					//print success message
					JOptionPane.showMessageDialog(frame, "your purchase is successfull");
				}else {
					JOptionPane.showMessageDialog(frame, "wrong username or password. Try again.");
				}
			}
		});
		
	
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	
	
	public static int validate_fields(char size, String color) {
		if(!(size == 's' || size == 'm' || size == 'l')) {
			return 1;
		}
		
		if(!(color.equals("black") || color.equals("white") || color.equals("blue"))) {
			return 2;
		}
		
		return 0;
	}
}
