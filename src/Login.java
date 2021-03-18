
import java.io.IOException;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
 
	 static JFrame frmlogin;
	  static JLabel lblusername, lblpswrd, lbltitle,titledown;
	 static JButton btn_lgn;
	 static JCheckBox showencr;
	 private JTextField txt_usr;
	 static JPasswordField txt_pss;
	 Shops shop = new Shops();
	 
	  public  Login() {
		  frmlogin = new JFrame ("LOGIN");
	        frmlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmlogin.setVisible(true);
	        frmlogin.setBounds(100, 100, 461, 484);
	        frmlogin.setResizable(false);
			frmlogin.getContentPane().setLayout(null);
			frmlogin.getContentPane().setBackground(new Color(139, 0, 0));
	    	frmlogin.getContentPane().setLayout(null);
			frmlogin.setLocationRelativeTo(null);

			lbltitle = new JLabel("FOOD MONKEY");
			lbltitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 16));
			lbltitle.setForeground(new Color(248, 248, 255));
	        lbltitle.setBounds(163, 66, 195, 46);
			frmlogin.getContentPane().add(lbltitle);
			frmlogin.repaint();
          
          btn_lgn = new JButton ("LOGIN");
	        btn_lgn.setFont(new Font("Rockwell", Font.BOLD, 10));
	        btn_lgn.setBounds(163, 366, 132, 37);
	        btn_lgn.setForeground(Color.BLACK);
	        btn_lgn.setBackground(Color.WHITE);
	        frmlogin.getContentPane().add(btn_lgn);
			frmlogin.repaint();

			lblusername = new JLabel("USERNAME :");
			lblusername.setForeground(new Color(245, 255, 250));
			lblusername.setBackground(new Color(245, 255, 250));
			lblusername.setFont(new Font("Rockwell", Font.BOLD, 11));
			lblusername.setBounds(74, 257, 89, 30);
			frmlogin.getContentPane().add(lblusername);
			
			lblpswrd= new JLabel("PASSWORD :");
			lblpswrd.setForeground(new Color(245, 255, 250));
			lblpswrd.setFont(new Font("Rockwell", Font.BOLD, 12));
			lblpswrd.setBounds(74, 287, 89, 30);
			frmlogin.getContentPane().add(lblpswrd);

			txt_usr=new JTextField("mikasa");
			txt_usr.setBounds(163, 262, 214, 20);
	   		frmlogin.getContentPane().add(txt_usr);
			txt_usr.setColumns(20);
			frmlogin.repaint();
	    
	    	txt_pss = new JPasswordField("hakim");
			txt_pss.setBounds(163, 293, 214, 20);
	    	frmlogin.getContentPane().add(txt_pss);
			txt_pss.setColumns(20);
			frmlogin.repaint();
		
			titledown = new JLabel("Welcome to our food delivery in UKM Bangi!");
			titledown.setFont(new Font("Rockwell", Font.BOLD, 16));
			titledown.setForeground(new Color(245, 255, 250));
			titledown.setBounds(60, 40, 410, 30);
			frmlogin.getContentPane().add(titledown);
			frmlogin.repaint();

			showencr = new JCheckBox("Show Password");
			showencr.setFont(new Font("Rockwell", Font.BOLD, 11));
			showencr.setForeground(new Color(245, 245, 245));
			showencr.setBackground(new Color(139,0,0));
			showencr.setBounds(218,320,123,23);
			frmlogin.getContentPane().add(showencr);
			frmlogin.repaint();
	        
	        showencr.addActionListener(this);
			btn_lgn.addActionListener(this);
			
			
			 Image image = null;
				try {
					image = ImageIO.read(this.getClass().getResource("/monkey.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image imageScaled = image.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(imageScaled);
				JLabel pic = new JLabel(imageIcon);
				pic.setBounds(153, 110, 157, 110);
				frmlogin.getContentPane().add(pic);
				frmlogin.repaint();
	  }

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn_lgn) {
				String user,pass;
				user=txt_usr.getText();
				pass=txt_pss.getText();

				if(user.equalsIgnoreCase("mikasa")&&pass.equalsIgnoreCase("hakim")){
					JOptionPane.showMessageDialog(this, "Login Successful");
					
    		try {
    				shop.main();
    				frmlogin.dispose();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
				}
				}
				else{
					JOptionPane.showMessageDialog(this, "Invalid Username or Password","Warning",JOptionPane.WARNING_MESSAGE);
					txt_pss.setText("");
					txt_usr.setText("");
				}				
	}
	if(e.getSource()==showencr){
		if(showencr.isSelected()){
			txt_pss.setEchoChar((char)0);
		}
		else{
			txt_pss.setEchoChar('*');
			}
		}

	}
	public static void main(String[] args) {
	 
		new Login();
	}
	
}
