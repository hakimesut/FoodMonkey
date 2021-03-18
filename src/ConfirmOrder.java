
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;


@SuppressWarnings("serial")
public class ConfirmOrder extends JFrame implements ActionListener{
	
	
	static private JFrame frm_confirm;
	static private JButton btn_okey, btn_cancel;
	static private JTextField txt_name,txt_number,txt_address,txt_sub,txt_to2;
    static private JLabel lblname,lblnumber,lbladdress,lblataspic,plusmee,plusmeat,pluschick,lblDeli,plusrice,lblpay,
    						orderid,date,showorderid,dateshow, lblyourord,lbltotal2,lblcustomize,lblsubtotal2,adcust,lbl_totalpayment ;
    static private JCheckBox chaddrice,chaddmeat,chaddchick,chadmee;
	static private JComboBox cmbplace;
    String ordering="";
    private JTable tablecust;
	DefaultTableModel dtm2;
	OrderData oo = new OrderData();
	StatusOrder status = new StatusOrder();
	
	double total = 0,rice=0,meat=0,chick=0,mee=0,charge=0;
	
	
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void  orderconfirm (){


    	frm_confirm = new JFrame();
		frm_confirm.setResizable(false);
		frm_confirm.getContentPane().setBackground(new Color(139, 0,0));
		frm_confirm.setTitle("CUSTOMIZE AND CONFIRM ORDER");
        frm_confirm.setBounds(100, 100, 1000, 703);
        frm_confirm.setVisible(true);
		frm_confirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm_confirm.getContentPane().setLayout(null);
		frm_confirm.setLocationRelativeTo(null);
		
		tablecust = new JTable();
		dtm2 = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		
		dtm2.setColumnIdentifiers(header);
		dtm2.addRow(header);
		dtm2=oo.getorder();
		tablecust  = new JTable();
		tablecust .setModel(dtm2);
		tablecust .setBounds(54, 56, 258, 232); // int x, int y, int width, int height
		tablecust .setSize(330, 200); // width,height
		tablecust .getColumnModel().getColumn(0).setPreferredWidth(80);
		tablecust .getColumnModel().getColumn(1).setPreferredWidth(30);
		tablecust .getColumnModel().getColumn(2).setPreferredWidth(30);

		tablecust .getColumnModel().getColumn(3).setMinWidth(0);  // hide spinner value
		tablecust .getColumnModel().getColumn(3).setMaxWidth(0);

		tablecust .setShowGrid(false); // remove cell boarder
		
		frm_confirm.getContentPane().add(tablecust );
		
		lbladdress= new JLabel("LOCATION TO DELIVER :");
		lbladdress.setForeground(Color.WHITE);
		lbladdress.setFont(new Font("Rockwell", Font.BOLD, 13));
		lbladdress.setBounds(511, 404, 190, 23);
		frm_confirm.getContentPane().add(lbladdress);
		frm_confirm.repaint();
		
		txt_address = new JTextField();
		txt_address.setBounds(711, 438, 217, 29);
		frm_confirm.getContentPane().add(txt_address);
        txt_address.setColumns(30);
        frm_confirm.repaint();
		
		btn_okey = new JButton("CONFIRM ORDER");
		btn_okey.setForeground(Color.BLACK);
		btn_okey.setFont(new Font("Rockwell", Font.BOLD, 11));
		btn_okey.setBackground(Color.WHITE);
		btn_okey.setBounds(778, 538, 150, 37);
		frm_confirm.getContentPane().add(btn_okey);
		frm_confirm.repaint();
		btn_okey.addActionListener(this);
		
		lblname= new JLabel("NAME  :");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblname.setBounds(622, 342, 70, 20);
		frm_confirm.getContentPane().add(lblname);
		frm_confirm.repaint();
		
		lblnumber = new JLabel("CONTACT NUM :");
		lblnumber.setForeground(Color.WHITE);
		lblnumber.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblnumber.setBounds(565, 373, 133, 20);
		frm_confirm.getContentPane().add(lblnumber);
		frm_confirm.repaint();
		
		txt_name = new JTextField("MIKASA");
		txt_name.setEditable(false);
		txt_name.setBounds(711, 343, 217, 20);
		frm_confirm.getContentPane().add(txt_name);
        txt_name.setColumns(30);
        frm_confirm.repaint();
		
		txt_number = new JTextField("0123456789");
		txt_number.setEditable(false);
		txt_number.setBounds(711, 374, 217, 20);
		frm_confirm.getContentPane().add(txt_number);
        txt_number.setColumns(20);
       
        lblyourord = new JLabel("Yours Order:");
        lblyourord.setForeground(new Color(255, 255, 255));
        lblyourord.setFont(new Font("Rockwell", Font.BOLD, 12));
        lblyourord.setBounds(44, 16, 102, 29);
		frm_confirm.getContentPane().add(lblyourord);
		frm_confirm.repaint();
	
		lbltotal2= new JLabel("TOTAL :");
		lbltotal2.setFont(new Font("Rockwell", Font.BOLD, 11));
		lbltotal2.setForeground(new Color(255, 255, 255));
		lbltotal2.setBounds(67, 497, 61, 20);
		frm_confirm.getContentPane().add(lbltotal2);
		frm_confirm.repaint();
		
		lblcustomize = new JLabel("CUSTOMIZE YOUR FOOD :");
		lblcustomize.setForeground(new Color(255, 255, 255));
		lblcustomize.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblcustomize.setBounds(43, 267, 156, 27);
		frm_confirm.getContentPane().add(lblcustomize);
		frm_confirm.repaint();
		
		total=oo.gettotalpayment();
		txt_sub = new JTextField();
		txt_sub.setText(Double.toString(total));
		txt_sub .setBounds(133, 464, 102, 20);
		txt_sub.setEditable(false);
		frm_confirm.getContentPane().add(txt_sub );
		txt_sub .setColumns(10);
		frm_confirm.repaint();
	
		lblsubtotal2 = new JLabel("SUB TOTAL :");
		lblsubtotal2 .setForeground(new Color(255, 255, 255));
		lblsubtotal2 .setFont(new Font("Rockwell", Font.BOLD, 11));
		lblsubtotal2 .setBounds(44, 464, 79, 20);
		frm_confirm.getContentPane().add(lblsubtotal2 );
		frm_confirm.repaint();
		
		txt_to2 = new JTextField();
		txt_to2.setBounds(133, 497, 102, 20);
		txt_to2.setText(Double.toString(total));
		txt_to2.setEditable(false);
		frm_confirm.getContentPane().add(txt_to2);
		txt_to2.setColumns(10);
		frm_confirm.repaint();
		
		 Image image = null;
			try {
				image = ImageIO.read(this.getClass().getResource("/monkey2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Image imageScaled = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			JLabel pic = new JLabel(imageIcon);
			pic.setBounds(673, 120, 217, 174);
			frm_confirm.getContentPane().add(pic);
			
			chaddrice = new JCheckBox("More Rice");
			chaddrice.setForeground(new Color(255, 255, 255));
			chaddrice.setBackground(new Color(139, 0, 0));
			chaddrice.setFont(new Font("Rockwell", Font.BOLD, 11));
			chaddrice.setBounds(79, 309, 97, 23);
	        frm_confirm.getContentPane().add(chaddrice);
	        frm_confirm.repaint();
	        chaddrice.addActionListener(this);
	        
	        chaddmeat = new JCheckBox("More Meat");
	        chaddmeat.setFont(new Font("Rockwell", Font.BOLD, 11));
	        chaddmeat.setForeground(new Color(255, 255, 255));
	        chaddmeat.setBackground(new Color(139, 0, 0));
	        chaddmeat.setBounds(79, 366, 130, 37);
	        frm_confirm.getContentPane().add(chaddmeat);
	        frm_confirm.repaint();
	        chaddmeat.addActionListener(this);
	        
	        chaddchick = new JCheckBox("More Chicken");
	        chaddchick.setForeground(new Color(255, 255, 255));
	        chaddchick.setFont(new Font("Rockwell", Font.BOLD, 11));
	        chaddchick.setBackground(new Color(139, 0, 0));
	        chaddchick.setBounds(79, 405, 120, 23);
	        frm_confirm.getContentPane().add( chaddchick);
	        frm_confirm.repaint();
	        chaddchick.addActionListener(this);

	        lblataspic = new JLabel("CONFIRM YOUR ORDER AND LOCATION TO SEND");
	        lblataspic.setForeground(new Color(255, 204, 0));
	        lblataspic.setFont(new Font("Rockwell", Font.BOLD, 14));
	        lblataspic.setBounds(587, 55, 383, 76);
	        frm_confirm.getContentPane().add( lblataspic);
	        frm_confirm.repaint();
	        
	        lblpay = new JLabel("YOUR TOTAL PAYMENT IS RM");
	        lblpay.setForeground(new Color(255, 215, 0));
	        lblpay.setFont(new Font("Rockwell", Font.BOLD, 18));
	        lblpay.setBounds(217, 578, 303, 37);
	        frm_confirm.getContentPane().add(lblpay);
	        frm_confirm.repaint();
	        
	        lbl_totalpayment = new JLabel("Payment");
	        lbl_totalpayment.setText(Double.toString(total));
			lbl_totalpayment.setForeground(new Color(0, 206, 209));
			lbl_totalpayment.setFont(new Font("Rockwell", Font.BOLD, 22));
			lbl_totalpayment.setBounds(530, 567, 120, 55);
			frm_confirm.getContentPane().add(lbl_totalpayment);
			frm_confirm.repaint();
			  
			chadmee = new JCheckBox("More Mee");
			chadmee.setBackground(new Color(139, 0, 0));
			chadmee.setForeground(Color.WHITE);
			chadmee.setFont(new Font("Rockwell", Font.BOLD, 11));
			chadmee.setBounds(79, 335, 130, 37);
			chadmee.addActionListener(this);
			frm_confirm.getContentPane().add(chadmee);
			frm_confirm.repaint();
				
			plusmee = new JLabel("+RM 0.50");
			plusmee.setFont(new Font("Rockwell", Font.BOLD, 11));
			plusmee.setForeground(new Color(255, 222, 173));
			plusmee.setBounds(215, 346, 72, 14);
			frm_confirm.getContentPane().add(plusmee);
			frm_confirm.repaint();
			
		    plusrice = new JLabel("+RM 0.80");
			plusrice.setForeground(new Color(255, 218, 185));					
			plusrice.setFont(new Font("Rockwell", Font.BOLD, 11));
			plusrice.setBounds(217, 313, 70, 14);
			frm_confirm.getContentPane().add(plusrice);
			frm_confirm.repaint();
			
		
			
			plusmeat = new JLabel("+ RM 1");
			plusmeat.setForeground(new Color(255, 218, 185));
			plusmeat.setFont(new Font("Rockwell", Font.BOLD, 11));
			plusmeat.setBounds(217, 377, 70, 14);
			frm_confirm.getContentPane().add(plusmeat);
			frm_confirm.repaint();
			
			pluschick = new JLabel("+ RM 1");
			pluschick.setFont(new Font("Rockwell", Font.BOLD, 11));
			pluschick.setForeground(new Color(255, 218, 185));
			pluschick.setBounds(217, 409, 70, 14);
			frm_confirm.getContentPane().add(pluschick);
			frm_confirm.repaint();
			
			adcust = new JLabel("+ Customize");
			adcust.setFont(new Font("Rockwell", Font.BOLD, 10));
			adcust.setForeground(new Color(255, 250, 250));
			adcust.setBounds(245, 499, 94, 17);
			frm_confirm.getContentPane().add(adcust);
			frm_confirm.repaint();
			
			btn_cancel = new JButton("CANCEL ORDER");
			btn_cancel.setFont(new Font("Rockwell", Font.BOLD, 11));
			btn_cancel.setBounds(778, 601, 150, 37);
			btn_cancel.addActionListener(this);
			frm_confirm.getContentPane().add(btn_cancel);
			frm_confirm.repaint();
			
			cmbplace = new JComboBox();
			cmbplace .setModel(new DefaultComboBoxModel(new String[] {"", "Kolej Burhannudin Helmi", "Kolej Pendeta Zaba", "Kolej Rahim Kajai", "Kolej Ibrahim Yaakub", "Kolej Ungku Omar",
					"Kolej Tun Hussien Onn", "Kolej Keris Emas", "Kolej Ibu Zain", "Kolej Aminuddin Baki", "Fakulti Teknologi dan Sains Maklumat", "Fakulti Pengajian Islam", "Fakulti Undang Undang",
					"Fakulti Kejuruteraan dan Alam Bina", "Fakulti Pendidikan", "Fakulti ekonomi dan Pengurusan",
					"Fakulti Sains dan Teknologi", "Pusat Citra Universiti", "Pusat GENIUS@Pintar Negara"}));
			cmbplace .setBounds(711, 405, 217, 22);
			cmbplace.addActionListener(this);
			frm_confirm.getContentPane().add(cmbplace );
			frm_confirm.repaint();

			lblDeli = new JLabel("+ Delivery Fee");
			lblDeli.setForeground(new Color(255, 255, 255));
			lblDeli.setFont(new Font("Rockwell", Font.BOLD, 11));
			lblDeli.setBounds(245, 467, 107, 14);
			frm_confirm.getContentPane().add(lblDeli);
			frm_confirm.repaint();
			
			orderid = new JLabel("ORDER ID :");
			orderid.setForeground(new Color(255, 255, 255));
			orderid.setFont(new Font("Rockwell", Font.BOLD, 13));
			orderid.setBounds(604, 293, 79, 14);
			frm_confirm.getContentPane().add(orderid);
			
			
			 
			
			date = new JLabel("DATE :");
			date.setForeground(new Color(255, 255, 255));
			date.setFont(new Font("Rockwell", Font.BOLD, 13));
			date.setBounds(632, 317, 70, 14);
			frm_confirm.getContentPane().add(date);
			
			showorderid = new JLabel("FM1002");
			showorderid.setForeground(new Color(255, 255, 255));
			showorderid.setFont(new Font("Rockwell", Font.BOLD, 13));
			showorderid.setBounds(711, 294, 88, 14);
			frm_confirm.getContentPane().add(showorderid);
			frm_confirm.repaint();
			
			dateshow = new JLabel("date");
			dateshow.setFont(new Font("Rockwell", Font.BOLD, 13));
			dateshow.setForeground(new Color(255, 255, 255));
			dateshow.setBounds(711, 318, 88, 14);
			  frm_confirm.getContentPane().add(dateshow);
			  frm_confirm.repaint();
			
			 javax.swing.Timer t = new javax.swing.Timer(1000, new DateListener());
		        t.start();
		        
		        
		}
  
	 class DateListener implements ActionListener {
	    	public void actionPerformed(ActionEvent e) {
	    		
	            Calendar now = Calendar.getInstance();
	            int month = now.get(Calendar.MONTH);
	            int day = now.get(Calendar.DAY_OF_MONTH);
	            int year = now.get(Calendar.YEAR);
	            dateshow.setText("" +day + "/" +  (month + 1) + "/" + year);
	           
	    	}
	 }
    public void actionPerformed (ActionEvent e){
    		if(e.getSource()== cmbplace) {
    		
    		String selected = cmbplace.getSelectedItem().toString();
    		txt_address.setText(selected);
    		
    	}
    	if(e.getSource()==btn_cancel) {
    	
    		ordering=oo.getchecking();
    		if(ordering=="kioks") {
			int confirm = JOptionPane.showConfirmDialog(null, "ARE YOU SURE?", "CONFIRM",
	                JOptionPane.YES_NO_OPTION);
			 if (confirm == 0) {
			Kioks4Menu food = new Kioks4Menu();;
			try {
				frm_confirm.dispose();
		
				food.menu();
					
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			 else if(confirm==1) {
				 
			 }
		}
    		else if(ordering=="mee"){
    			int confirm = JOptionPane.showConfirmDialog(null, "ARE YOU SURE?", "CONFIRM",
    	                JOptionPane.YES_NO_OPTION);
    			 if (confirm == 0) {
    			Meetarikmenu food1 = new Meetarikmenu();
    			try {
    				frm_confirm.dispose();  		
    				food1.menu();
	
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    		}
    			 else if(confirm==1) {
  	
    		}
    	}

    }
	if(e.getSource()==btn_okey) {
			
			if(txt_address.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill in the location!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(this, "Thank you for the order, your food is being prepared!");
            
            frm_confirm.dispose();
                status.bar();
            }
		}
	if(e.getSource()==chaddrice) {
		if(chaddrice.isSelected()) {
			rice=0.8;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
		else {
			rice=0;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
	}
	if(e.getSource()==chaddmeat) {
		if(chaddmeat.isSelected()) {
			meat=1;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
		else {
			meat=0;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
	}
	if(e.getSource()==chaddchick) {
		if(chaddchick.isSelected()) {
			chick=1;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}else {
			chick=0;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
	}
	if(e.getSource()==chadmee) {
		if(chadmee.isSelected()) {
			mee=0.5;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
		else {
			mee=0;
			txt_to2.setText(total + meat+rice+mee+chick+ "");
			lbl_totalpayment.setText(total +meat+rice+mee+chick+ "");
		}
	}
	
    }
}