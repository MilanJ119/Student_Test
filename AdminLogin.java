import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AdminLogin extends JPanel implements KeyListener{
	JLabel un,up;
	JTextField tx1;
	JPasswordField tx2;
	JButton b1,b2;
	ImageIcon i0=new ImageIcon("bg.png");
	Image bg=i0.getImage();
	ImageIcon i1=new ImageIcon("buttonL.png");
	Image login=i1.getImage();
	ImageIcon i2=new ImageIcon("buttonB.png");
	Image back=i2.getImage();
	AdminLogin(FDemo f){
		setLayout(null);
		Font f1=new Font("Arial Rounded MT Bold",Font.BOLD,28);
		Font f2=new Font("",Font.BOLD,20);
		un=new JLabel("Enter Name:");
		un.setBounds(50,160,220,40);
		un.setFont(f1);
		add(un);
		tx1=new JTextField("Enter Name");
		tx1.setBounds(320,160,220,40);
		tx1.setForeground(Color.GRAY);
		tx1.setFont(f2);
		add(tx1);
		up=new JLabel("Enter Password:");
		up.setBounds(50,230,250,40);
		up.setFont(f1);
		add(up);
		tx2=new JPasswordField("Enter Password");
		tx2.setForeground(Color.GRAY);
		tx2.setEchoChar((char)0);
		tx2.setBounds(320,230,220,40);
		tx2.setFont(f2);
		add(tx2);
		b1=new JButton(i1);
		b1.setBounds(250,300,110,30);
		add(b1);
		b2=new JButton(i2);
		b2.setBounds(250,480,110,30);
		add(b2);
		b1.addActionListener(f);
		b2.addActionListener(f);
		tx1.addKeyListener(this);
		tx2.addKeyListener(this);
	}
	public void keyReleased(KeyEvent k)
	{	
		if(tx1.isFocusOwner())
		{
		String s1=tx1.getText().trim();
		if(s1.equals(""))
		{
			tx1.setForeground(Color.GRAY);
			tx1.setText("Enter Name");
		}
		}
		if(tx2.isFocusOwner())
		{
		String s2=tx2.getText().trim();
		if(s2.equals(""))
		{
			tx2.setForeground(Color.GRAY);
			tx2.setText("Enter Password");
			tx2.setEchoChar((char)0);
		}
			
		}
		
	}
	public void keyPressed(KeyEvent k)
	{
		if(tx1.isFocusOwner())
		{
		String s1=tx1.getText();
		if(s1.equals("Enter Name"))
		{
		tx1.setText("");
		tx1.setForeground(Color.BLACK);
			
		}
		}
		if(tx2.isFocusOwner())
		{
		String s2=tx2.getText();
		if(s2.equals("Enter Password"))
		{
		tx2.setText("");
		tx2.setForeground(Color.BLACK);
		tx2.setEchoChar('*');	
		}
			
		}
	}
	public void keyTyped(KeyEvent k){}
	public void paintComponent(Graphics g){
		g.drawImage(bg,0,0,this);
		g.drawImage(login,235,297,this);
		g.drawImage(back,235,477,this);
	}
}