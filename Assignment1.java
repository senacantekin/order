import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Assignment1<E> extends JFrame implements ActionListener {
	private static final LayoutManager FlowLayout = null;
	private JLabel lblSelectSize,lblSelect, lblHowM,lblAdded;
	private JTextField txtOne;
	private JButton buttonAdd,buttonOrder;
	private JRadioButton juice,water,tea,coffee;
	private JComboBox<E> SELECT;
	ArrayList<String>order= new ArrayList<String>();
	int price =0;
	// i defined all data that i will use
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Assignment1();


	
		
	} //i called my assignment1 constructor that has my frame and others which  are required to create my program
	
	
	//constructor
	public Assignment1() {
		setLayout(null);
		
	//my frame's properties
		setSize(700,600);
		setTitle("ORDER");
		setResizable(true);//ekraný büyütüp küçültür
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		
		
	lblSelectSize= new JLabel("Select Size");
	//lblSelectSize.setHorizontalAlignment(2);
	lblSelectSize.setLocation(200, 30);
	lblSelectSize.setSize(800, 100);
	add(lblSelectSize);
	
	
	lblSelect= new JLabel ("Select which type of beverage you want to order");
	lblSelect.setLocation(200, 90);
	lblSelect.setSize(800, 100);
	add(lblSelect);
	
	lblHowM= new JLabel ("Select how many glasses you want to order");
	//lblHowM.setHorizontalAlignment(0);//etiketi merkeze yerleþtirir
	lblHowM.setSize(300, 50);
	lblHowM.setLocation(200, 200);
	
	
	add(lblHowM);
	
	lblAdded=new JLabel();
	lblAdded.setSize(500,50);
	lblAdded.setLocation(200, 400);
	add(lblAdded);
	
	txtOne= new JTextField();
	txtOne.setLocation(200, 250);
	txtOne.setSize(250, 30);
	add(txtOne);
	
	buttonAdd= new JButton("Add");
	buttonAdd.setLocation(200,300);
	buttonAdd.setSize(60, 30);
	add(buttonAdd);
	
	buttonOrder=new  JButton ("Order");
	buttonOrder.setSize(90, 30);
	buttonOrder.setLocation(300, 300);
	add(buttonOrder);
	
	juice= new JRadioButton("juice");
	juice.setLocation(200, 150);
	juice.setSize(80, 50);
	add(juice);
	
	water=new JRadioButton("water");
	water.setLocation(280, 150);
	water.setSize(80, 50);
	add(water);
	

	
	tea=new JRadioButton("tea");
	tea.setLocation(360, 150);
	tea.setSize(80, 50);
	add(tea);
	
	coffee= new JRadioButton("coffee");
	coffee.setSize(80, 50);
	coffee.setLocation(440, 150);
	add(coffee);
	
	DefaultComboBoxModel model= new DefaultComboBoxModel<E>();
	model.addElement("small");
	model.addElement("medium");
	model.addElement("large");
	SELECT=new JComboBox<E>();
	SELECT.setSize(95, 20);
	SELECT.setModel(model);
	
	SELECT.setLocation(200, 100);
	add(SELECT);
	
	buttonAdd.addActionListener(this);//to operate the button
	//this means in this class
	buttonOrder.addActionListener(this);
	


	
	setVisible(true);
	
	
	
	
		
		
		
	}


	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
	
		if (e.getSource().equals(buttonAdd)) {
		
			int number=Integer.parseInt(txtOne.getText());//to convert the number to string
			
			
		
			if(!juice.isSelected()&& !coffee.isSelected()&&!water.isSelected()&&!tea.isSelected()) {
				JOptionPane.showMessageDialog(null,
						"Choose a beverage type and enter an amount", "Message",
						JOptionPane.WARNING_MESSAGE
						);
			}
			
			//if conditions for click buttons
			//option panes
			
			if(juice.isSelected()) {
				
				String []juices= {"apple","orange","pinaple" };
				String juice= (String)JOptionPane.showInputDialog(this,
						"","Select a fruit",
						JOptionPane.QUESTION_MESSAGE,
						null, juices,juices[2]		);
			
								
								if(juice.equals("apple")) {
									int c=5;
									order.add(SELECT.getSelectedItem()+" "+number+" "+" apple juice   -"+c+"tl\n");
									lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+" apple juice added.");
									int s=c*number;
									price+=s;
								}
								else if(juice.equals("orange")) {
									int c=13;
									lblAdded.setText(	SELECT.getSelectedItem()+" "+number+" "+" orange juice added.");
									order.add(SELECT.getSelectedItem()+" "+number+" "+" orange juice added   -"+c+"tl\n");
									int s=c*number;
									price+=s;
								}
								
							else {
								int c=15;
								lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+" pinaple juice added.");
								order.add(SELECT.getSelectedItem()+" "+number+" "+" pinaple juice added   -"+c+"tl\n");
								int s=c*number;
								price+=s;
								
								
								
								
							}
								
		}
		else order.remove("Juice");
			
			
				
			if(coffee.isSelected()) {
				
				int k=JOptionPane.showConfirmDialog(this, "Do you want milk?",
						"Question",JOptionPane.YES_NO_OPTION);
				if(k==JOptionPane.YES_OPTION) {
					int c=5;
					order.add(SELECT.getSelectedItem()+" "+number+" "+" Coffee with milk added   -"+c+"tl\n");
					lblAdded.setText(SELECT.getSelectedItem()+" "+number*c+" "+" Coffee with milk added");
					int s=c*number;
					price+=s;
				}
				else {
					int c=5;
					lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+" Coffee");
					order.add(SELECT.getSelectedItem()+" "+number+" "+" Coffee   -"+c+"tl\n");
					int s=c*number;
					price+=s;
				}
			}
			else order.remove("Coffee");
				
			
			
			if(tea.isSelected()) {
				
				int j=JOptionPane.showConfirmDialog(this, "Do you want sugar?",
						"Question",JOptionPane.YES_NO_OPTION);
				if(j==JOptionPane.YES_OPTION) {
					int c=7;
					order.add(SELECT.getSelectedItem()+" "+number+" "+" Tea with sugar added   -"+c+"tl\n");
					lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+"  Tea with sugar added.");
					int s=c*number;
					price+=s;
				}
				else {
					int c=2;
					order.add(SELECT.getSelectedItem()+" "+number+" "+"tea   -"+c+"tl\n");
					lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+" Tea.");
					int s=c*number;
					price+=s;
				}
			}
			else order.remove("Tea");
			
			if(water.isSelected()) {
				
				int p=JOptionPane.showConfirmDialog(this, "Do you want ice?",
						"Question",JOptionPane.YES_NO_OPTION);
				if(p==JOptionPane.YES_OPTION) {
					int c=8;
					order.add(SELECT.getSelectedItem()+" "+number+" "+"water with ice added   -" +c+"tl\n");
					lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+" water with ice added.");
					int s=c*number;
					price+=s;
				}
				else {
					int c=5;
					lblAdded.setText(SELECT.getSelectedItem()+" "+number+" "+" water.");
					order.add(SELECT.getSelectedItem()+" "+number+" "+"water   -"+c+"tl\n");
					int s=c*number;
					price+=s;
				}
			}
			else order.remove("water");
			
			
			
		}
	if(e.getSource().equals(buttonOrder)) {
		for(int i=0;i<order.size();i++) {
			order.get(i);
		}
		JOptionPane.showMessageDialog(this, order
		
		,"order",JOptionPane.INFORMATION_MESSAGE);
		
		
		
		JOptionPane.showMessageDialog(this, "you should pay "+price+"  tl"
				
				,"order",JOptionPane.INFORMATION_MESSAGE);
				
		
		//clear the arraylist and price=0
		order.clear();
		int price = 0;
		
	}}}
	
	
	


