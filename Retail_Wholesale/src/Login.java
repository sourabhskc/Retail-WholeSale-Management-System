import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

 
public class Login extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
	
	Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel lbl;
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
 
    Inventory in;
    
    Login() {
    	
    	in = new Inventory();
    	
    	//setVisible(true);
    	setTitle("Login From!!!");
        setBounds(20,30,400,500);
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
    	
    	lbl = new JLabel("LOGIN HERE !!!"); 
        lbl.setBounds(30, 30, 300, 50);
		lbl.setForeground(Color.BLUE);
		lbl.setFont(new Font("SansSerif" , Font.BOLD , 20));
		
        userLabel.setBounds(50, 120, 150, 30);
        passwordLabel.setBounds(50, 220, 150, 30);
        userTextField.setBounds(220, 120, 150, 30);
        passwordField.setBounds(220, 220, 150, 30);
        showPassword.setBounds(220, 250, 150, 30);
        showPassword.setForeground(Color.lightGray);
        loginButton.setBounds(50, 300, 100, 50);
        resetButton.setBounds(200, 300, 100, 50);
 
 
    }
 
    public void addComponentsToContainer() {
    	container.add(lbl);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
   
    @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == loginButton) {
        	
        	
        	try {
        		
        //	InputStream input = Login.class.getResourceAsStream("/username.txt");
        //	InputStreamReader ir = new InputStreamReader(input);
        //	BufferedReader rdfile = new BufferedReader(ir);
            	
        	FileReader fr = new FileReader("src\\username.txt");
        	BufferedReader rdfile = new BufferedReader(fr);
        	
        	String[] line= new String[100];
        	
        	String search="" , pwd="";
        	boolean same= false;
        	
            int x=0;
            while( (line[x]= rdfile.readLine()) != null)//reading username.txt; asigning to array[] line
                x++;

            rdfile.close();
            
            search= userTextField.getText();
            pwd = passwordField.getText();
         
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
            	if(same) 
                    {
                    	JOptionPane.showMessageDialog(this, "Login Successful");
                    	userTextField.setText("");
                        passwordField.setText("");
                        passwordField.setEchoChar('*');
                        
                        // threading concept
                        try
             			{
                        	Thread.sleep(1000);
                        	JOptionPane.showMessageDialog(this, "Opening Main Menu!!!");
                        	in.setVisible(true);
             				Thread.sleep(2000);
             				setVisible(false);
             			}catch(Exception ex) {}
                    }
                else
                {
                	JOptionPane.showMessageDialog(null, "Invalid username or password", "Oops Wait...!", JOptionPane.ERROR_MESSAGE);
                	userTextField.setText("");
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                	int ch=JOptionPane.showConfirmDialog(null, "WANT TO REGISTER FIRST ?");
                    if(ch==0){
                 	   try {
                 		   Thread.sleep(1000);
                 		  new Reg().setVisible(true);
                 		  setVisible(false);
                 	   }catch(Exception ex) {}
                    }  
                    else if(ch==1)
                    {
                    	JOptionPane.showMessageDialog(null, "Thanks :)");
                    	System.exit(0);
                    }     
                }
 
            
        	}catch(IOException ex){}
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
