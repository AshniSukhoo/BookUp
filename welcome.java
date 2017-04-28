
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class welcome extends JFrame{
	
	
	
	JLabel JL_welmsg, img, descript;
	JButton exit, booking;
	
	
	public  welcome(){
	
	
		JL_welmsg = new JLabel("BookUp");
		JL_welmsg.setFont(new Font("Serif", Font.ITALIC, 36));
		JL_welmsg.setBounds(280, 10, 200, 100);
		add(JL_welmsg);
		
		img = new JLabel((new ImageIcon("Images/rsz_bookup1.jpg")));
		img.setBounds(200, 10, 70, 80);
		add(img);
		
		descript = new JLabel("BookUp proposed you a ");
		
		booking = new JButton("RESERVE");
		booking.setBounds(220, 350, 100, 50);
		booking.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae){
				
				dispose();
				new form();
			}
			
		});
		add(booking);
		
		
		
		exit = new JButton("EXIT");
		exit.setBounds(380, 350, 100, 50);
		exit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
		add(exit);
		
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setSize(700,500);
		setLocationRelativeTo(null);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new welcome();

	}

}
