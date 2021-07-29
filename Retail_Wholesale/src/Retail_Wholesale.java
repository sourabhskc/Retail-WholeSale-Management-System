import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main java File
public class Retail_Wholesale extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	Container container = getContentPane();
	JLabel label, eUser, nUser;
	JButton login;
	JButton register;
	
	Reg rg;
	Login lf;
	
	Retail_Wholesale() {
		
		rg = new Reg();
		lf = new Login();
		// setting frame
		getContentPane().setBackground(Color.gray);
		setTitle("Welcome Page");
		setVisible(true);
		setBounds(20, 30, 600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
		
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
	
	public void setLayoutManager()
	{
		container.setLayout(null);
	}
	
	public void setLocationAndSize() 
	{
		label = new JLabel("Welcome to Retail_Wholesale_Management_System"); 
        label.setBounds(50, 30, 500, 50);
		label.setForeground(Color.orange);
		label.setFont(new Font("SansSerif" , Font.BOLD , 18));
		
		login = new JButton("Login");
		login.setBounds(100, 150, 150, 50);
		login.setForeground(Color.blue);
		login.setFont(new Font("Sanserif", Font.BOLD, 20));
		
		eUser = new JLabel("Existing user!!!");
		eUser.setBounds(140, 120, 100, 30);
		eUser.setForeground(Color.orange);
		eUser.setFont(new Font("SansSerif" , Font.BOLD , 12));
		
		
		register = new JButton("Register");
		register.setBounds(320, 150, 150, 50);
		register.setForeground(Color.blue);
		register.setFont(new Font("SansSerif" , Font.BOLD , 20));
		
		nUser = new JLabel("New user!!!");
		nUser.setBounds(360, 120, 80, 30);
		nUser.setForeground(Color.orange);
		nUser.setFont(new Font("SansSerif" , Font.BOLD , 12));
		
	}
	public void addComponentsToContainer()
	{
		container.add(label);
		container.add(login);
		container.add(register);
		container.add(eUser);
		container.add(nUser);
	}
	
	public void addActionEvent()
	{
		register.addActionListener(this);
		login.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == register)
		{
			try
			{
				rg.setVisible(true);
				Thread.sleep(2000);
			}catch(Exception ex) {}
			
			setVisible(false);
		}
		if(e.getSource() == login)
		{
			try
			{
				lf.setVisible(true);
				Thread.sleep(2000);
			}catch(Exception ex) {}
			
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
			new Retail_Wholesale();
	}
}