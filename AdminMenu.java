import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class AdminMenu extends JPanel{
	JButton b1;
	JTabbedPane tab1;
	ViewProfile vp;
	// Courses c; 
	AddQues add;
	ShowQues sq;
	LogOut lg;
	AdminMenu(FDemo f){
		setLayout(new BorderLayout());
		tab1=new JTabbedPane();
		
		vp=new ViewProfile();
		// c=new Courses();
		add=new AddQues();
		sq=new ShowQues();
		lg=new LogOut(f);
		
		
		tab1.addTab("View Profile",vp);
		// tab1.addTab("Courses",c);
		tab1.addTab("Add Questions",add);
		tab1.addTab("Show Questions",sq);
		tab1.addTab("LogOut",lg);	
		
		add(tab1);
		
	}
}
class ViewProfile extends JPanel implements ActionListener
{
	JButton b1;
	JLabel un,up;
	JLabel uw;
	JTextField tx1,tx2;
	ImageIcon i=new ImageIcon("try2.jpg");
	Image bg=i.getImage();
	ViewProfile()
	{
		setLayout(null);
		Font f1=new Font("Arial Rounded MT Bold",Font.BOLD,28);
		Font f2=new Font("",Font.BOLD,20);
		Font f3=new Font("Calibri",Font.BOLD,70);
		uw=new JLabel("WELCOME!");
		uw.setBounds(120,30,460,100);
		uw.setForeground(Color.WHITE);
		uw.setFont(f3);
		add(uw);
		un=new JLabel("Your Name:");
		un.setBounds(50,160,220,40);
		un.setFont(f1);
		add(un);
		tx1=new JTextField();
		tx1.setBounds(320,160,220,40);
		tx1.setFont(f2);
		add(tx1);
		up=new JLabel("Your Password:");
		up.setBounds(50,230,250,40);
		up.setFont(f1);
		add(up);
		tx2=new JTextField();
		tx2.setBounds(320,230,220,40);
		tx2.setFont(f2);
		add(tx2);
		b1=new JButton("Update");
		b1.setBounds(250,300,110,30);
		add(b1);
		
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from AdminLogin";
			ResultSet rs=st.executeQuery(q);
			if(rs.next()){
				tx1.setText(rs.getString(1));
				tx2.setText(rs.getString(2));
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=tx1.getText();
		String s2=tx2.getText();
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="UPDATE AdminLogin SET Name='"+s1+"',Password='"+s2+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null,"Data Updated");
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
	}
}


/* class Courses extends JPanel implements ActionListener
{
	JTextField tx1;
	JButton b1;
	JComboBox cb1;
	String a[]={"Python","Java"}; 
	ImageIcon i=new ImageIcon("try2.jpg");
	Image bg=i.getImage();
	Courses()
	{
		setLayout(null);
		tx1=new JTextField();
		tx1.setBounds(100,80,160,30);
		add(tx1);
		
		b1=new JButton("Add");
		b1.setBounds(190,120,60,30);
		add(b1);
		
		cb1=new JComboBox(a);
		cb1.setBounds(300,80,150,25);
		add(cb1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		cb1.addItem(tx1.getText());
		tx1.setText("");
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
	}
}
 */

class AddQues extends JPanel implements ActionListener
{
	JLabel u1,u2,u3,u4,u5,u6,u7,u8;
	JComboBox cb1;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
	JTextArea ta1;
	JButton b1,b2,b3,b4;
	String s2[]={"Java"};
	ImageIcon i=new ImageIcon("try2.jpg");
	Image bg=i.getImage();
	//Object item;
	AddQues()
	{
		setLayout(null);
		Font f1=new Font("",Font.BOLD,20);
		Font f2=new Font("",Font.BOLD,14);
		
		u1=new JLabel("Select Course:");
		u1.setBounds(50,40,180,30);
		u1.setFont(f1);
		add(u1);
																			
		/* Courses c=new Courses();
		int num = c.cb1.getItemCount();
		for (int i = 0; i < num; i++) 
		{
			item = c.cb1.getItemAt(i);
			s2[i]=s2[i]+item;
		} */
		cb1=new JComboBox(s2);
		cb1.setBounds(240,40,150,30);
		add(cb1);
		
	
    	u2=new JLabel("SNo.");
		u2.setBounds(50,90,90,30);
		u2.setFont(f1);
 		add(u2);
		
		b4=new JButton("Search");
		b4.setBounds(200,90,100,30);
		b4.setFont(f2);
		add(b4);
		
		tx2=new JTextField();
		tx2.setBounds(110,90,60,30);
		tx2.setFont(f2);
		add(tx2);
		
		u3=new JLabel("Question:");
		u3.setBounds(50,130,100,30);
		u3.setFont(f1);
 		add(u3);
		
		ta1=new JTextArea();
		ta1.setBounds(150,130,400,60);
		ta1.setFont(f2);
		add(ta1);
		
		u4=new JLabel("Option1:");
		u4.setBounds(50,210,100,30);
		u4.setFont(f1);
 		add(u4);
		
		tx3=new JTextField();
		tx3.setBounds(140,210,150,30);
		tx3.setFont(f2);
		add(tx3);
		
		u5=new JLabel("Option2:");
		u5.setBounds(50,250,100,30);
		u5.setFont(f1);
 		add(u5);
		
		tx4=new JTextField();
		tx4.setBounds(140,250,150,30);
		tx4.setFont(f2);
		add(tx4);
		
		u6=new JLabel("Option3:");
		u6.setBounds(50,290,100,30);
		u6.setFont(f1);
 		add(u6);
		
		tx5=new JTextField();
		tx5.setBounds(140,290,150,30);
		tx5.setFont(f2);
		add(tx5);
		
		u7=new JLabel("Option4:");
		u7.setBounds(50,330,100,30);
		u7.setFont(f1);
 		add(u7);
		
		tx6=new JTextField();
		tx6.setBounds(140,330,150,30);
		tx6.setFont(f2);
		add(tx6);
		
		u8=new JLabel("Correct Option:");
		u8.setBounds(50,390,180,30);
		u8.setFont(f1);
 		add(u8);
		
		tx7=new JTextField();
		tx7.setBounds(210,390,150,30);
		tx7.setFont(f2);
		add(tx7);
		
		b1=new JButton("Update");
		b1.setFont(f1);
		b1.setBounds(75,485,120,35);
		add(b1);
		
		b2=new JButton("Add");
		b2.setFont(f1);
		b2.setBounds(250,485,80,35);
		add(b2);
		
		b3=new JButton("Delete");
		b3.setFont(f1);
		b3.setBounds(405,485,120,35);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent e)
	{
		
		String s1=tx2.getText();
		String s2=ta1.getText();
		String s3=tx3.getText();
		String s4=tx4.getText();
		String s5=tx5.getText();
		String s6=tx6.getText();
		String s7=tx7.getText();
//Search
		if(e.getSource()==b4)
		{
			String s11=tx2.getText();
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from Java where SNo='"+s11+"'";
			ResultSet rs=st.executeQuery(q);
			if(rs.next()){
				ta1.setText(rs.getString(2));
				tx3.setText(rs.getString(3));
				tx4.setText(rs.getString(4));
				tx5.setText(rs.getString(5));
				tx6.setText(rs.getString(6));
				tx7.setText(rs.getString(7));
			}
			else{
				JOptionPane.showMessageDialog(null,"No Question Available");
				
				ta1.setText("");
				tx3.setText("");
				tx4.setText("");
				tx5.setText("");
				tx6.setText("");
				tx7.setText("");
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		}
//ADD
		if(e.getSource()==b2)
		{
				String s0=(String)cb1.getSelectedItem();
			/* if(s0.equals("Java"))
				{ */
				try{
					String url="jdbc:mysql://localhost:3306/mini_project1";
					String uname="root";
					String upass="0119";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,upass);
				Statement st=con.createStatement();
				String q="insert into Java values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
				st.executeUpdate(q);
				JOptionPane.showMessageDialog(null,"Data Inserted");
				con.close();
				}
				catch(Exception exc)
				{
					System.out.println(exc);
				}			
					System.out.println("trueeeeeeeeeeeeee");
				// }
		/* else
		{
				try{
				String url="jdbc:mysql://localhost:3306/mini_project1";
				String uname="root";
				String upass="0119";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="insert into Python values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null,"Data Inserted");
			con.close();
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}		

		} */
		}
//Updated
		if(e.getSource()==b1)
		{
			try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="UPDATE java SET Ques='"+s2+"',Opt1='"+s3+"',Opt2='"+s4+"',Opt3='"+s5+"',Opt4='"+s6+"',Correct='"+s7+"' WHERE SNo='"+s1+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null,"Data Updated");
			ta1.setText("");
			tx2.setText("");
			tx3.setText("");
			tx4.setText("");
			tx5.setText("");
			tx6.setText("");
			tx7.setText("");
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		}
//Deleted
		if(e.getSource()==b3)
		{
			try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Delete from Java where SNo='"+s1+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null,"Data Deleted");
			ta1.setText("");
			tx2.setText("");
			tx3.setText("");
			tx4.setText("");
			tx5.setText("");
			tx6.setText("");
			tx7.setText("");
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
	}
}

class ShowQues extends JPanel implements ActionListener
{
	JButton b1;
		JScrollPane scroll;
		static JTable table;
		DefaultTableModel model;
		String column[]={"Sno.","Question","Option1","Option2","Option3","Option4","Correct Option"};
		ImageIcon i=new ImageIcon("try2.jpg");
		Image bg=i.getImage();
	ShowQues()
	{
		setLayout(null);
		b1=new JButton("Show All Questions");
		b1.setBounds(120,50,200,30);
		add(b1);
		
		/* i=new ImageIcon("bg4.jfif");
		im=i.getImage(); */
		
		b1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
		{
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		
		table=new JTable();
		table.setModel(model);
		
		scroll=new JScrollPane(table);
		
		String Sno="";
		String Ques="";
		String Opt1="";
		String Opt2="";
		String Opt3="";
		String Opt4="";
		String Correct="";
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from Java";
			ResultSet rs=st.executeQuery(q);
		
			
			while(rs.next()){
				Sno=rs.getString("SNo"); 
				Ques=rs.getString("Ques"); 
				Opt1=rs.getString("Opt1"); 
				Opt2=rs.getString("Opt2"); 
				Opt3=rs.getString("Opt3"); 
				Opt4=rs.getString("Opt4"); 
				Correct=rs.getString("Correct"); 
				model.addRow(new Object[]{Sno,Ques,Opt1,Opt2,Opt3,Opt4,Correct});
			}
			add(scroll);
			scroll.setVisible(true);
			scroll.setBounds(30,100,520,300);
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
	}
}
class LogOut extends JPanel
{
	JButton b1;
	ImageIcon i=new ImageIcon("try2.jpg");
	Image bg=i.getImage();
	LogOut(FDemo f)
	{
		b1=new JButton("LogOut");
		b1.setBounds(150,100,80,35);
		add(b1);
		b1.addActionListener(f);
	
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
	}
}