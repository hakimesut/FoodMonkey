
import java.io.IOException;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Shops extends JPanel implements ActionListener {
		
	private static final long serialVersionUID = 1L;
	JLabel picLabel, title,title1,shop1,shop2;
	JButton btn_kioks4, btn_meetarik;
	Box right,left;
	Panel panel_1;
	Panel panel_2;
	static JFrame frame;
	String shopid="";
	OrderData oo = new OrderData();
	Meetarikmenu food1 = new Meetarikmenu(); 
	 Kioks4Menu food = new Kioks4Menu();
	
	public void createAndShowGUI() throws IOException {			//method
		 JPanel panel = new JPanel(new BorderLayout());
		 JPanel panel1 = new JPanel(new BorderLayout());

		//Kioks4 and Meetarik picture
		
		Image image = ImageIO.read(this.getClass().getResource("/kioks4.jpg"));
		Image imageScaled = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		shop1 = new JLabel(imageIcon);
		
		
		Image image1 = ImageIO.read(this.getClass().getResource("/meetarik.jpg"));
		Image imageScaled1 = image1.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
		ImageIcon imageIcon1 = new ImageIcon(imageScaled1);
		shop2 = new JLabel(imageIcon1);
	
		left = Box.createVerticalBox();
		panel_1 = new Panel();
		title = new JLabel("KIOKS4 CAFE");
		title.setAlignmentX(Component.RIGHT_ALIGNMENT);
		title.setAlignmentY(0.0f);
		title.setHorizontalAlignment(SwingConstants.RIGHT);
		title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
		title.setForeground(Color.BLUE);
		
		right = Box.createVerticalBox();
		panel_2 = new Panel();
		title1 = new JLabel("MEE TARIK");
		title1.setAlignmentX(Component.LEFT_ALIGNMENT);
		title1.setAlignmentY(0.0f);
		title1.setHorizontalAlignment(SwingConstants.LEFT);
		title1.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
		title1.setForeground(Color.BLUE);
		


	// Button for kioks4 and meetarik
		btn_kioks4 = new JButton("Order Food Now >>");
		panel_1.add(btn_kioks4);
		btn_kioks4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		
		btn_meetarik = new JButton ("Order Food Now >>");
		panel_2.add(btn_meetarik);
		btn_meetarik.setAlignmentX(Component.LEFT_ALIGNMENT);

		panel.add(shop1, BorderLayout.WEST);
		panel.add(left, BorderLayout.SOUTH);
		left.add(title);
		left.add(panel_1);
		add(panel);
		
		panel1.add(shop2, BorderLayout.EAST);
		panel1.add(right, BorderLayout.SOUTH);
		right.add(title1);
		right.add(panel_2);
		add(panel1);
		

		btn_kioks4.addActionListener(this);
		btn_meetarik.addActionListener(this);
	
	}

	 public void actionPerformed(ActionEvent e) {
		 

		 if(e.getSource()==btn_kioks4) {
			
			 	shopid="kioks";
				
				try {
					
					
					oo.setchecking(shopid);
					
					food.menu();			
					setVisible(false);
					frame.dispose(); 
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
		 
		 if(e.getSource()== btn_meetarik) {
		shopid="mee";
			 
			 try {
	
					oo.setchecking(shopid);
				 
				food1.menu();
			
				setVisible(false);
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }
	 }
	 
	 public  void main() throws IOException {
			Shops main = new Shops();
			main.createAndShowGUI();
			frame = new JFrame();
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("FOOD MONKEY");
			frame.setResizable(false);
			frame.getContentPane().add(main);
			frame.setBackground(new Color(139, 0, 0));
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
	

	
}
