import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class StudentMenu extends JPanel{
	JButton b1;
	JTabbedPane tab1;
	SViewProfile vp;
	SCourses c; 
	Result r;
	/* int totalll;
	int corr;
	int wrong; */
	LogOut lg;
	StudentMenu(FDemo f){
		setLayout(new BorderLayout());
		tab1=new JTabbedPane();
		
		vp=new SViewProfile();
		c=new SCourses();
		/* int OP[]=c.getData();
		totalll=OP[0];
		corr=OP[1];
		wrong=OP[2]; 
		r=new Result(totalll,corr,wrong); */
		r=new Result();
		lg=new LogOut(f);
		
		tab1.addTab("View Profile",vp);
		tab1.addTab("Courses",c);
		tab1.addTab("Result",r);
		tab1.addTab("LogOut",lg);
		
		add(tab1);
		
	}
}
class SViewProfile extends JPanel implements ActionListener
{
	JButton b1;
	JLabel un,up;
	JLabel uw;
	JTextField tx1,tx2;
	ImageIcon i=new ImageIcon("try2.jpg");
	Image bg=i.getImage();
	SViewProfile()
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
			String q="Select * from StudentLogin";
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
			String q="UPDATE StudentLogin SET Name='"+s1+"',Password='"+s2+"'";
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

class SCourses extends JPanel implements ActionListener,ItemListener
{
	JLabel u1,u2;
	JRadioButton u3,u4,u5,u6;
	ButtonGroup bg;
	JComboBox cb1;
	JTextArea ta1;
	JTextField tx2;
	JButton b1,b2,b3,b4;
	String op1="";
	String op2="";
	String op3="";
	String op4="";
	String s2[]={"Java"};
	ImageIcon i=new ImageIcon("try2.jpg");
	Image back=i.getImage();
	int count;
	int cAns;
	int wAns;
	//Object item;
	SCourses()
	{
		setLayout(null);
		bg=new ButtonGroup();
		Font f1=new Font("",Font.BOLD,20);
		Font f2=new Font("",Font.BOLD,16);
																			
		/* Courses c=new Courses();
		int num = c.cb1.getItemCount();
		for (int i = 0; i < num; i++) 
		{
			item = c.cb1.getItemAt(i);
			s2[i]=s2[i]+item;
		} */
		cb1=new JComboBox(s2);
		cb1.setBounds(50,40,150,30);
		add(cb1);
		
		b1=new JButton("START");
		b1.setBounds(200,40,120,30);
		b1.setFont(f2);
		add(b1);
		
		
		u1=new JLabel("No. of Questions:");
		u1.setBounds(50,90,200,30);
		u1.setFont(f1);
		add(u1);
		
//To get total No.s of Questions
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
				count++;
			}
			con.close();
			}
			catch(Exception ex){
				System.out.println(ex);
			}
		
		tx2=new JTextField(""+count);
		tx2.setBounds(230,90,40,30);
		tx2.setFont(f2);
		add(tx2);
		
		u2=new JLabel("Question:");
		u2.setBounds(50,150,100,30);
		u2.setFont(f1);
 		add(u2);
		
		ta1=new JTextArea();
		ta1.setBounds(150,150,400,60);
		ta1.setFont(f2);
		ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
		add(ta1);
	
		
		
		u3=new JRadioButton(op1);
		u3.setBounds(50,230,180,30);
		u3.setFont(f1);
		add(u3);
		bg.add(u3);
		
		
		u4=new JRadioButton(op2);
		u4.setBounds(50,280,180,30);
		u4.setFont(f1);
 		add(u4);
		bg.add(u4);
		
		
		u5=new JRadioButton(op3);
		u5.setBounds(50,330,180,30);
		u5.setFont(f1);
 		add(u5);
		
		bg.add(u5);
		
		u6=new JRadioButton(op4);
		u6.setBounds(50,380,180,30);
		u6.setFont(f1);
 		add(u6);
		
		bg.add(u6);
		
		b2=new JButton("Prev");
		b2.setFont(f1);
		b2.setBounds(75,485,100,35);
		add(b2);
		
		b3=new JButton("Submit");
		b3.setFont(f1);
		b3.setBounds(210,485,150,35);
		add(b3);
		
		b4=new JButton("Next");
		b4.setFont(f1);
		b4.setBounds(405,485,120,35);
		add(b4);
		b1.addActionListener(this);
		u3.addItemListener(this);
		u4.addItemListener(this);
		u5.addItemListener(this);
		u6.addItemListener(this);
		b3.addActionListener(this);
		/* System.out.println("....................."); */
	}
	int x=1;
	String ans="";
	String correct="";
	int total;
	public void itemStateChanged(ItemEvent ie)
			{
			
				if(u3.isSelected())
				{
					ans=u3.getLabel();
				}
				if(u4.isSelected())
				{
					ans=u4.getLabel();
				}
				if(u5.isSelected())
				{
					ans=u5.getLabel();
				}
				if(u6.isSelected())
				{
					ans=u6.getLabel();
				}
			}
	public void actionPerformed(ActionEvent e)
	{
		
		
//Start
		 if(e.getSource()==b1)
		{
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from Java where SNo='"+x+"'";
			ResultSet rs=st.executeQuery(q);
			b2.addActionListener(this);
			b4.addActionListener(this);
			if(rs.next()){
				ta1.setText(""+x+") "+rs.getString(2));
				op1=rs.getString(3);
				u3.setText(op1);
				op2=rs.getString(4);
				u4.setText(op2);
				op3=rs.getString(5);
				u5.setText(op3);
				op4=rs.getString(6);
				u6.setText(op4);
				correct=rs.getString(7);	
			}
			con.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println(ex);
			}
		}
		b1.removeActionListener(this); 
//Prev	
		if(e.getSource()==b2)
		{
		x--;
		if(x==0)
		{
			JOptionPane.showMessageDialog(null,"No Prev Ques");
		}
		else{
			try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from Java where SNo='"+x+"'";
			ResultSet rs=st.executeQuery(q);
			if(rs.next()){
				ta1.setText(""+x+") "+rs.getString(2));
				op1=rs.getString(3);
				u3.setText(op1);
				op2=rs.getString(4);
				u4.setText(op2);
				op3=rs.getString(5);
				u5.setText(op3);
				op4=rs.getString(6);
				u6.setText(op4);
				correct=rs.getString(7);
			if(ans.equals(correct))
			{
				System.out.println("correct:"+correct);
				System.out.println("selected:"+ans);
				cAns--;
			}
			else{
				wAns--;
			}
				con.close();
				}
			}
			catch(Exception ex){
				System.out.println(ex);
			}
			}
		}
//Submit
	if(e.getSource()==b3)
	{
		b2.removeActionListener(this);
		b4.removeActionListener(this);
		System.out.println("total correct ans:"+cAns);
		System.out.println("total wrong ans:"+wAns);
		total=cAns+wAns;
		System.out.println("total ques:"+total);
		try{
					String url="jdbc:mysql://localhost:3306/mini_project1";
					String uname="root";
					String upass="0119";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,uname,upass);
				Statement st=con.createStatement();
				String q="insert into Result values('"+total+"','"+cAns+"','"+wAns+"')";
				st.executeUpdate(q);
				con.close();
				}
				catch(Exception exc)
				{
					System.out.println(exc);
				}	
	}
//Next
	if(e.getSource()==b4)
		{
			
				System.out.println("Correct:"+correct);
				System.out.println("selected:"+ans);
				
				if(ans.equals(correct))
				{
				cAns++;
				}
				else{
				wAns++;	
				}
						
			
		if(x==0)
		{
			x++;
			x++;
		}
		else{
			x++;
		}
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from Java where SNo='"+x+"'";
			ResultSet rs=st.executeQuery(q);
			if(rs.next()){
				// tx2.setText(""+x);
				ta1.setText(""+x+") "+rs.getString(2));
				op1=rs.getString(3);
				u3.setText(op1);
				op2=rs.getString(4);
				u4.setText(op2);
				op3=rs.getString(5);
				u5.setText(op3);
				op4=rs.getString(6);
				u6.setText(op4);
				correct=rs.getString(7);
				System.out.println("--------------------------");
			}
			else{
				JOptionPane.showMessageDialog(null,"No more Questions");
			}
			con.close();
			}	
			catch(Exception ex){
				System.out.println("next ki exception");
				System.out.println(ex);
				// ex.printStackTrace();
			}
			
		}
	}	
	/* int[] getData()
	{
		int arr[]=new int[3];
		arr[0]=total;
		arr[1]=cAns;
		arr[2]=wAns;
		System.out.println("+++++++++++++++");
		System.out.println("t"+total);
		System.out.println("c"+cAns);
		System.out.println("w"+wAns);
		return arr;
	} */
	public void paintComponent(Graphics g)
	{
		g.drawImage(back,0,0,this);
	}
}
class Result extends JPanel 
{
	JLabel u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,uw,note,note1,note2,note3;
	String s1,s2,s3,result;
	int a;
	int x,y;
	ImageIcon i=new ImageIcon("try2.jpg");
	Image bg=i.getImage();
	Result()
	{
		setLayout(null);
		Font f1=new Font("Arial Rounded MT Bold",Font.BOLD,28);
		Font f2=new Font("Arial Rounded MT Bold",Font.BOLD,24);
		Font f3=new Font("Calibri",Font.BOLD,70);
		Font f4=new Font("",Font.BOLD,22);
		Font f5=new Font("",Font.BOLD,20);
		
		try{
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,upass);
			Statement st=con.createStatement();
			String q="Select * from Result";
			ResultSet rs=st.executeQuery(q);
			while(rs.next()){
				/* System.out.println("s1"+s1);
				System.out.println("s2"+s2);
				System.out.println("s3"+s3); */
				s1=rs.getString(1);
				s2=rs.getString(2);
				s3=rs.getString(3);
			}
			x=Integer.parseInt(s2);
			y=Integer.parseInt(s3);
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
//Welcome
		uw=new JLabel("Result");
		uw.setBounds(140,30,460,100);
		uw.setForeground(Color.WHITE);
		uw.setFont(f3);
		add(uw);	
		
//Course
		u1=new JLabel("Course:");
		u1.setBounds(50,130,150,30);
		u1.setFont(f1);
		add(u1);
		u2=new JLabel("Java");
		u2.setBounds(170,130,210,30);
		u2.setFont(f2);
		add(u2);
//total ques		
		u3=new JLabel("Total No. Questions:");
		u3.setBounds(50,180,340,30);
		u3.setFont(f1);
		add(u3);
		u4=new JLabel(s1);
		u4.setBounds(360,183,210,30);
		u4.setFont(f2);
		add(u4);
//Correct
		u5=new JLabel("Correct Answer:");
		u5.setBounds(50,230,290,30);
		u5.setFont(f1);
		add(u5);
		u6=new JLabel(s2);
		u6.setBounds(300,233,210,30);
		u6.setFont(f2);
		add(u6);
		
		u7=new JLabel("Wrong Answer:");
		u7.setBounds(50,280,240,35);
		u7.setFont(f1);
		add(u7);
		u8=new JLabel(s3);
		u8.setBounds(300,283,210,30);
		u8.setFont(f2);
		add(u8);
		
//Result		
		u9=new JLabel("Result:");
		u9.setBounds(90,350,140,30);
		u9.setFont(f1);
		add(u9);
		if(x>y)
		{
			result="PASS";
		}
		else{
			result="FAIL";
			
		}
		u10=new JLabel(result);
		u10.setBounds(195,350,210,30);
		u10.setFont(f2);
		add(u10);
		
		note=new JLabel("***Note***");
		note.setBounds(40,430,500,30);
		note.setFont(f4);
		add(note);
		
		note1=new JLabel("1) This above result is of Last Test.");
		note1.setBounds(50,455,500,30);
		note1.setFont(f5);
		add(note1);
		
		note2=new JLabel("2) To view the result of current test please kindly");
		note2.setBounds(50,480,500,30);
		note2.setFont(f5);
		add(note2);
		
		note3=new JLabel("reopen this application.");
		note3.setBounds(75,500,500,30);
		note3.setFont(f5);
		add(note3);
	}	
	public void paintComponent(Graphics g)
	{
		g.drawImage(bg,0,0,this);
	}
}

class LogDemo extends JPanel
{
	JButton b1;
	ImageIcon i=new ImageIcon("try2.jpg");
	Image im=i.getImage();
	LogDemo(FDemo f)
	{
		b1=new JButton("LogOut");
		b1.setBounds(150,100,80,35);
		add(b1);
		b1.addActionListener(f);
	}
	public void paintComponent(Graphics g){
		g.drawImage(im,0,0,this);
	}
}
	