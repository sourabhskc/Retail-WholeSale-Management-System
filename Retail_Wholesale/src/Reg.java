import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

 
public class Reg extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
	
	Container container = getContentPane();
    JLabel userLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel("Enter Password");
    JLabel lbl;
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton save = new JButton("SAVE");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
 
    Login lf;
    
    
    Reg() {
    	
    	lf = new Login();
    	
    	//setVisible(true);
    	setTitle("Register Information!!!");
        setBounds(50,40,400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	
    	lbl = new JLabel("REGISTER HERE !!!"); 
        lbl.setBounds(30, 30, 300, 50);
		lbl.setForeground(Color.BLACK);
		lbl.setFont(new Font("SansSerif" , Font.BOLD , 20));
		
        userLabel.setBounds(50, 150, 150, 30);
        passwordLabel.setBounds(50, 220, 150, 30);
        userTextField.setBounds(220, 150, 150, 30);
        passwordField.setBounds(220, 220, 150, 30);
        showPassword.setBounds(220, 250, 150, 30);
        showPassword.setForeground(Color.lightGray);
        save.setBounds(50, 300, 100, 50);
        resetButton.setBounds(200, 300, 100, 50);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(lbl);
    	container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(save);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        save.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
   
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == save) {
        	
        	String search="" , pwd="";
        	boolean same= false;
        	search= userTextField.getText();
            pwd = passwordField.getText();
        	
        	try {
        		
        		FileReader fr = new FileReader("src\\username.txt");
        		BufferedReader rdfile = new BufferedReader(fr);
        	
            	String[] line= new String[100];
        
                int x=0;
                while( (line[x]= rdfile.readLine()) != null)//reading username.txt; asigning to array[] line
                    x++;

                rdfile.close();
                
                for( int k=0; line[k] != null; k++){
                    same= false;
                    // since username and passwd is stored as
                    //tab separated in "username.txt" file.
                    // spliting 
                    
                    String[] temp= line[k].split("\t");
                    
                    if((temp[0].equals(search)) && (temp[1].equals(pwd)))
                    {
                    	same=true;
                    	break;
                    }
                }
        	}catch(IOException ex) {}
        	
        	 if((search.equals(""))|| (pwd.equals("")))
        	 {
        		 JOptionPane.showMessageDialog(null, "Enter item!", "Oops Wait...!", JOptionPane.ERROR_MESSAGE);
        	 }
        	 else if(same)
        	 {
        			JOptionPane.showMessageDialog(null, "Already Registered!\nLogin :)", "Oops Wait...!", JOptionPane.ERROR_MESSAGE);
        			JOptionPane.showMessageDialog(this, "Opening Login Page!!!");
        			try
        			{
        				Thread.sleep(2000);
        			}catch(Exception ex) {}
        			lf.setVisible(true);
        			try
        			{
        				Thread.sleep(2000);
        			}catch(Exception ex) {}
        			setVisible(false);
        	 }
        	 else
        	 {
        	 String data = search+"\t"+pwd;
        	// System.out.print(data);
        	 try
        	 {
        		 // Storing new username and pwd in file
   
        		 FileWriter fw = new FileWriter("src\\username.txt", true);
        		 PrintWriter pw = new PrintWriter(fw);
        		 pw.println(data);
        		 
        		 pw.flush();
        		 pw.close();
        	 }catch(IOException ex) {}
    	    
        	 JOptionPane.showMessageDialog(this, "REGISTERED SUCCESSFULLY :)");
        	 
 			try
 			{
 				Thread.sleep(1000);
 				JOptionPane.showMessageDialog(this, "Login Please :)");
 				Thread.sleep(1000);
 				lf.setVisible(true);
 				Thread.sleep(2000);
 				setVisible(false);
 			}catch(Exception ex) {}
		}
    }	
            	       
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            passwordField.setEchoChar('*');
        }
       
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } 
            else {
                passwordField.setEchoChar('*');
            }
        }
    }
}
