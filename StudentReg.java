import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
class StudentReg extends JPanel implements ActionListener{
	JLabel un,up,uc,ue;
	JTextField tx1,tx2,tx3;
	JPasswordField pf2;
	JButton b1,b2;
	ImageIcon i0=new ImageIcon("bg.png");
	Image bg=i0.getImage();
	ImageIcon i1=new ImageIcon("buttonR.png");
	Image reg=i1.getImage();
	ImageIcon i2=new ImageIcon("buttonL.png");
	Image login=i2.getImage();
	StudentReg(FDemo f){
		setLayout(null);
		Font f1=new Font("Arial Rounded MT Bold",Font.BOLD,28);
		Font f2=new Font("",Font.BOLD,20);
		un=new JLabel("Enter Name:");
		un.setBounds(50,100,220,30);
		un.setFont(f1);
		add(un);
		tx1=new JTextField(20);
		tx1.setBounds(340,100,170,40);
		tx1.setFont(f2);
		add(tx1);
		up=new JLabel("Enter Password:");
		up.setBounds(50,150,270,30);
		up.setFont(f1);
		add(up);
		pf2=new JPasswordField(20);
		pf2.setFont(f2);
		pf2.setBounds(340,150,170,40);
		add(pf2);
		uc=new JLabel("Enter Contact No.");
		uc.setBounds(50,200,270,30);
		uc.setFont(f1);
		add(uc);
		 
		tx2=new JTextField(20);
		tx2.setBounds(340,200,170,40);
		tx2.setFont(f2);
		add(tx2);
		ue=new JLabel("Enter Email ID:");
		ue.setBounds(50,250,250,30);
		ue.setFont(f1);
		add(ue);
		tx3=new JTextField(20);
		tx3.setBounds(340,250,170,40);
		tx3.setFont(f2);
		add(tx3);
		b1=new JButton(i1);
		b1.setBounds(250,350,110,30);
		add(b1);
		b2=new JButton(i2);
		b2.setBounds(250,410,110,30);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(f);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=tx1.getText();
		String s2=pf2.getText();
		String s3=tx2.getText();
		String s4=tx3.getText();
		if((s1.trim().length()>=1)&&(s2.trim().length()>=1)&&(s3.trim().length()>=1)&&(s4.trim().length()>=1))
		{
			
		try{
			
			String url="jdbc:mysql://localhost:3306/mini_project1";
			String uname="root";
			String upass="0119";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,upass);
		Statement st=con.createStatement();
		String q="insert into StudentLogin values('"+s1+"','"+s2+"')";
		st.executeUpdate(q);
		con.close();
			System.out.println("Data inserted...........");
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		}
		else{
			JOptionPane.showMessageDialog(null,"Please Enter All Fields");
		}
	}
	public void paintComponent(Graphics g){
		g.drawImage(bg,0,0,this);
		g.drawImage(reg,240,347,this);
		g.drawImage(login,240,407,this);
		
	}
}