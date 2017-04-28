import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class form extends JFrame{
	
	JLabel JL_welmsg, img, info;
	JLabel surname, name, phone, email;
	JTextField JT_surname, JT_name, JT_phone, JT_email;
	JButton next;
	
	public form(){

		JL_welmsg = new JLabel("BookUp");
		JL_welmsg.setFont(new Font("Serif", Font.ITALIC, 36));
		JL_welmsg.setBounds(280, 10, 200, 100);
		add(JL_welmsg);
		
		img = new JLabel((new ImageIcon("Images/rsz_bookup1.jpg")));
		img.setBounds(200, 10, 70, 80);
		add(img);
		
		info = new JLabel("Fill out the form before proceeding to the next step to complete your reservation.");
		info.setBounds(100, 90 , 500, 100);
		add(info);
		
		surname = new JLabel("SURNAME");
		surname.setBounds(200, 190, 70, 50);
		add(surname);
		
		name = new JLabel("NAME");
		name.setBounds(200, 230, 70, 50);
		add(name);
		
		phone = new JLabel("PHONE NUMBER");
		phone.setBounds(200, 270,100 , 50);
		add(phone);	
		
		email = new JLabel("EMAIL");
		email.setBounds(200, 310, 70, 50);
		add(email);
		
		JT_surname = new JTextField(15);
		JT_surname.setBounds(300, 200, 200, 30);
		//validation that only allows letter to be inputted 
		JT_surname.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				
				char sn = e.getKeyChar();
				if(Character.isLetter(sn) || Character.isISOControl(sn))
				{
				
				}
				else
				{
					 JOptionPane.showMessageDialog(null, "Only letters are allowed!");
	                    JT_surname.setText(" ");
				}
			}
		});
		add(JT_surname);
		
		JT_name = new JTextField(10);
		JT_name.setBounds(300, 240, 200, 30);
		JT_name.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				
				char sn = e.getKeyChar();
				if(Character.isLetter(sn) || Character.isISOControl(sn))
				{
				
				}
				else
				{
					 JOptionPane.showMessageDialog(null, "Only letters are allowed!");
	                    JT_name.setText(" ");
				}
			}
		});
		add(JT_name);
		
		JT_phone = new JTextField(15);
		JT_phone.setBounds(300, 280, 200, 30);
		JT_phone.addKeyListener(new KeyAdapter(){
			
			public void keyPressed(KeyEvent e){
				
				char ch = e.getKeyChar();
				if(Character.isDigit(ch)){
				}
				else
				{
					 JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
	                    JT_phone.setText(" ");
				}
			}
			
		});
		
		add(JT_phone);
		
		JT_email = new JTextField(30);
		JT_email.setBounds(300, 320, 200, 30);
		add(JT_email);
		
		next = new JButton("Next");
		next.setBounds(300,390, 70, 40);
		next.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
			
				try{
					saveQuery("insert into diners (surname, name, phone_num, email) values ('"+JT_surname.getText()+"', '"+JT_name.getText()+"', "+JT_phone.getText()+", '"+JT_email.getText()+"')");
				
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
					
			// prevent jtextfield from being empty
				
			if(JT_name.getText().trim().isEmpty())
			{
				 JOptionPane.showMessageDialog(null, "Name required");
			}
			 if(JT_surname.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "surname required");
			}
			 if(JT_phone.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Phone Number required");
			}
			 if(JT_email.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Email required");
			}
			
			
			
			dispose();
			
			new reservation();
			}
			
		});
		add(next);
		
		
		
		
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setSize(700,500);
		setLocationRelativeTo(null);
	}
	
	private void saveQuery(String query) {
		
		Connection con = null;
		Statement st = null;
		
		try{
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bookup", "root", "");
			st = (Statement) con.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Your contact details has been saved.");
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	

}
