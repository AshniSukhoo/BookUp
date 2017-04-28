import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;





public class reservation extends JFrame{
	
	JLabel JL_welmsg, img, pickdate, picktime, picknum_diners, placement;
	JTextField date;
	JButton datepicker, menu, save, exit;
	JComboBox combotime, num_diners;
	JRadioButton inside, terrace;
	
	public reservation(){
		JL_welmsg = new JLabel("BookUp");
		JL_welmsg.setFont(new Font("Serif", Font.ITALIC, 36));
		JL_welmsg.setBounds(280, 10, 200, 100);
		add(JL_welmsg);
		
		img = new JLabel((new ImageIcon("Images/rsz_bookup1.jpg")));
		img.setBounds(200, 10, 70, 80);
		add(img);
		
		pickdate = new JLabel("Select a date for your reservation.");
		pickdate.setBounds(50, 100, 200, 50);
		add(pickdate);
		
		date = new JTextField();
		date.setBounds(50, 150, 140, 20);
		add(date);
		
		datepicker = new JButton("...");
		datepicker.setBounds(190, 150, 30, 20);
		datepicker.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				JPanel JP_datepick = new JPanel();
				JP_datepick.setSize(100, 100);
				
				UtilDateModel model = new UtilDateModel();
				JDatePanelImpl datePanel;
				datePanel = new JDatePanelImpl(model, null);
				
				JDatePickerImpl datePicker;
				datePicker = new JDatePickerImpl(datePanel, null);
				
				datePicker.setBounds(100, 100, 200, 200);
				 
				JP_datepick.add(datePicker);
				
				Date selectedDate = (Date) datePicker.getModel().getValue();
				
			}
			
		});
		add(datepicker);
		
		picktime = new JLabel("Pick a time for reservation.");
		picktime.setBounds(280, 100, 250, 50);
		add(picktime);
		
		String[] timelist = {"6.00PM", "6.15PM", "6.30PM", "6.45PM", "7.00PM", "7.15PM", "7.30PM", "7.45PM","8.00PM"};
		combotime = new JComboBox<String>(timelist);
		combotime.setBounds(300, 150, 80, 20);
		add(combotime);
		
		
		picknum_diners = new JLabel("Pick the numbers of diners.");
		picknum_diners.setBounds(450, 100, 250, 50);
		add(picknum_diners);
		
		Integer[] dinerslist = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		num_diners = new JComboBox<Integer> (dinerslist);
		num_diners.setBounds(500, 150, 50, 20);
		add(num_diners);
		
		placement= new JLabel("Select where you want to dine.");
		placement.setBounds(50, 300, 300, 50);
		add(placement);
		
		terrace = new JRadioButton("On Restaurant's terrace");
		terrace.setBounds(100, 350, 100, 20);
		if(terrace.isSelected())
		{
			JOptionPane.showMessageDialog(null, "You will dine on the terrace");
		}
		
		
		
		groupButton();
		
		
		
		
		
		 
		
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setSize(700,500);
		setLocationRelativeTo(null);
		
	}

	private void groupButton() {
		ButtonGroup gp = new ButtonGroup();
		
		
		gp.add(terrace);
		
		inside = new JRadioButton("Inside the restaurant");
		inside.setBounds(250, 350, 100, 20);
		if(inside.isSelected())
		{
			JOptionPane.showMessageDialog(null, "You will dine inside.");
		}
		gp.add(inside);
		
		
	}

}
