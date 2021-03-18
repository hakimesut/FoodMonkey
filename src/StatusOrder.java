import java.io.IOException;
import javax.swing.*;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusOrder extends JFrame implements ActionListener{
		private static JFrame frame;
					private static JButton btn_okey;
					private static JLabel lbl_progress,pic,pic2,pic3;
					static JProgressBar statusbar;
					static JPanel panelstatus,paneltext,panelbtn;
					private static Image image,image2,image3;
					private static final long LOOP_LENGTH = 199999999;
					
						public void bar() {
							 frame = new JFrame("Order Status");
				
								frame.getContentPane().setLayout(null);
								statusbar = new JProgressBar(SwingConstants.HORIZONTAL);
								statusbar.setFont(new Font("Tahoma", Font.BOLD, 11));
								statusbar.setForeground(new Color(0, 0, 0));
								statusbar.setBounds(154, 62, 395, 30);
								statusbar.setBackground(new Color(255, 255, 255));
								frame.getContentPane().add(statusbar);
							// set intial bar value
								statusbar.setValue(0);
								statusbar.setStringPainted(true);
							

								ProgressWorker worker = new ProgressWorker(statusbar);
								worker.execute();

								//create panel and text progress
								lbl_progress = new JLabel();
								lbl_progress.setHorizontalAlignment(SwingConstants.CENTER);
								lbl_progress.setForeground(new Color(255, 255, 255));
								lbl_progress.setBounds(67, 11, 551, 40);
								
								lbl_progress.setFont(new Font("Rockwell", Font.BOLD, 15));
								lbl_progress.setText("Please Wait");
								frame.getContentPane().add(lbl_progress);
							
					//create panel and button next
								btn_okey = new JButton("OKEY");
								btn_okey.setForeground(Color.BLACK);
								btn_okey.setBounds(267, 223, 161, 23);
								btn_okey.setEnabled(false);
								frame.getContentPane().add(btn_okey);
								btn_okey.addActionListener(this);
								
								frame.setBounds(100, 100, 693, 300);; // x,y,width,height
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.getContentPane().setBackground(new Color(139, 0, 0));
								frame.setResizable(false);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
								
								  image = null;
									try {
										image = ImageIO.read(this.getClass().getResource("/monkeyride.png"));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image imageScaled = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									ImageIcon imageIcon = new ImageIcon(imageScaled);
									 pic = new JLabel(imageIcon);
									pic.setVisible(false);
									pic.setBounds(291, 124, 119, 58);
									frame.getContentPane().add(pic);
									frame.repaint();
									
									image2 = null;
									try {
										image2 = ImageIO.read(this.getClass().getResource("/monkeyarrive.png"));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image imageScaled2 = image2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									ImageIcon imageIcon2 = new ImageIcon(imageScaled2);
									 pic2 = new JLabel(imageIcon2);
									pic2.setVisible(false);
									pic2.setBounds(291, 124, 119, 58);
									frame.getContentPane().add(pic2);
									frame.repaint();
									
									image3 = null;
									try {
										image3 = ImageIO.read(this.getClass().getResource("/thank-you.png"));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image imageScaled3 = image3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
									ImageIcon imageIcon3 = new ImageIcon(imageScaled3);
									 pic3 = new JLabel(imageIcon3);
									pic3.setVisible(false);
									pic3.setBounds(350, 97, 119, 58);
									frame.getContentPane().add(pic3);
									frame.repaint();
		
	}

	// to make the loading work in online
	private static class ProgressWorker extends SwingWorker<Void, Integer> {
        private final JProgressBar progress;

        public ProgressWorker(JProgressBar progress) {
            this.progress = progress;
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (long i = LOOP_LENGTH; i > 0; i--) {
                final int progr = (int) ((100L * (LOOP_LENGTH - i)) / LOOP_LENGTH);
                publish(progr);
            }
            return null;
        }

        @Override
        protected void process(List<Integer> chunks) {
            progress.setValue(chunks.get(chunks.size() - 1));
			super.process(chunks);
			lbl_progress.setText("Your food is being packaged and will be out for delivery immediately!");
			pic.setVisible(true);
        }

        @Override
        protected void done() {
			progress.setValue(100);
			lbl_progress.setText("Your order has arrived and please get ready the cash!");
			pic.setVisible(false);
			pic2.setVisible(true);
			pic3.setVisible(true);
			btn_okey.setEnabled(true);
        }
    }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_okey){
			Shops shop = new Shops();
    			try {
					JOptionPane.showMessageDialog(null, "Thank you for using our application!");
    				shop.main();
    				frame.dispose();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
		}
	}
	
	
	 
}
