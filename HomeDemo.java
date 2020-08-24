import javax.swing.*;
import java.awt.*;
class HomeDemo extends JPanel{
	JButton b1,b2;
	ImageIcon i0=new ImageIcon("bg.png");
	Image bg=i0.getImage();
	ImageIcon i=new ImageIcon("home.png");
	Image logo=i.getImage();
	ImageIcon i1=new ImageIcon("buttonS.png");
	Image student=i1.getImage();
	ImageIcon i2=new ImageIcon("buttonA.png");
	Image admin=i2.getImage();
	HomeDemo(FDemo f){
	setLayout(null);
	b1=new JButton(i1);
	b1.setBounds(230,225,120,25);
	add(b1);
	b2=new JButton(i2);
	b2.setBounds(230,525,120,25);
	add(b2);
	b1.addActionListener(f);
	b2.addActionListener(f);
	}
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		g.drawImage(bg,0,0,this);
		g.drawImage(logo,200,30,this);
		g.drawImage(student,220,220,this);
		g.drawImage(logo,200,320,this);
		g.drawImage(admin,220,520,this);
	}
}