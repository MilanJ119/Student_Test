//set classpath=C:\MilanJava\java_adv\graphics\card_layout\mini_project2\mysql-connector-java-8.0.20.jar;.;%classpath%
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
class FDemo extends JFrame implements ActionListener
{
	Container cn=getContentPane();
	CardLayout card;
	final JPanel panel;
	HomeDemo home;
	StudentLogin Slog;
	AdminLogin Alog;
	StudentReg Sreg;
	AdminMenu Amenu;
	StudentMenu Smenu;
	FDemo()
	{
		card=new CardLayout();
		setLayout(card);
		panel=new JPanel();

		home=new HomeDemo(this);
		add(home,"home");
		Slog=new StudentLogin(this);
		add(Slog,"Slog");
		Sreg=new StudentReg(this);
		add(Sreg,"Sreg");
		Smenu=new StudentMenu(this);
		add(Smenu,"Smenu");
		Alog=new AdminLogin(this);
		add(Alog,"Alog");
		Amenu=new AdminMenu(this);
		add(Amenu,"Amenu");
		
	}
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource()==home.b1)
		{
		card.next(cn);
		}
		if(e.getSource()==home.b2)
		{
		card.show(cn,"Alog");
		}
		if(e.getSource()==Slog.b1)
		{
			try{
				String s1=Slog.tx1.getText();
				String s2=Slog.tx2.getText();
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,upass);
		Statement st=con.createStatement();
		String q="select * from StudentLogin where Name='"+s1+"' AND Password='"+s2+"'";
		ResultSet rs=st.executeQuery(q);
		//Studentlogin	
		if(rs.next()){
			card.show(cn,"Smenu");}
			else{    JOptionPane.showMessageDialog(panel, "Get Yourself Registered First!", "Error", JOptionPane.ERROR_MESSAGE);}
		con.close();
		
		}
			catch(Exception ex){
				System.out.println(ex);
				}
			Slog.tx1.setText("");
			Slog.tx2.setText("");
		}
		//StudentRegistration
		if(e.getSource()==Slog.b2)
		{
			card.show(cn,"Sreg");
		}
		//Student back button
		if(e.getSource()==Slog.b3)
		{
			card.show(cn,"home");
		}
		//Sreg k b1(register) ka toh usi page code likha h aur b2(login)ka niche
		if(e.getSource()==Sreg.b2)
		{
			card.show(cn,"Slog");
		}
		//Admin k login button pr click kra toh
		if(e.getSource()==Alog.b1)
		{
			try{
				String s1=Alog.tx1.getText();
				String s2=Alog.tx2.getText();
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,upass);
		Statement st=con.createStatement();
		String q="select * from AdminLogin where Name='"+s1+"' AND Password='"+s2+"'";
		ResultSet rs=st.executeQuery(q);
			if(rs.next())	{card.show(cn,"Amenu");}
			else{    JOptionPane.showMessageDialog(panel, "Invalid UserName and Password", "Error", JOptionPane.ERROR_MESSAGE);}
		con.close();
		
		}
			catch(Exception ex){
				System.out.println(ex);
				}
			Alog.tx1.setText("");
			Alog.tx2.setText("");
		}
		//admin back button 
		if(e.getSource()==Alog.b2)
		{
			card.show(cn,"home");
		}
		if(e.getSource()==Amenu.lg.b1)
		{
			card.show(cn,"home");
		}
		if(e.getSource()==Smenu.lg.b1)
		{
			card.show(cn,"home");
		}
	}
}
class Demo
{
	public static void main(String ar[])
	{
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setResizable(false);
		f.setBounds(300,50,600,650);
		Toolkit t=Toolkit.getDefaultToolkit();
		Image i=t.getImage("logo1.png");
		f.setIconImage(i);
		f.setTitle("Examination Application");
	}
}