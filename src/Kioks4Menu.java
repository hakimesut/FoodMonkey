import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;




public class Kioks4Menu extends JFrame implements ActionListener  {
	
    static private JFrame frm_menu;
	static private JButton btn_back, btn_order;
	static private JTextField txt_total,txt_total2;
    static private GridBagConstraints gbc;
    static private JLabel lblorder,lblTotal,delivery,lblTotal2;

    static private JTabbedPane tab;    
	private JTable table;
	DefaultTableModel dtm;
	Double[] price;
	Double[] priceDrinks;
	
	double totalPrice = 0;
	double p1, p2, p3, p4, p5, p6;
	double d1, d2, d3;

	private JSpinner[] numSpinner;
	static private JLabel[] foodLabel;
	static private JLabel[] foodImage;
	private String[] fileFood;

	private JSpinner[] numSpinnerDrinks;
	static private JLabel[] drinkLabel;
	static private JLabel[] drinkImage;
	private String[] fileDrinks;

	private static final int Food_ELEMENTS = 6;
	private static final int DRINK_ELEMENTS = 3;

	double total = 0,charge=0,totalconfirm=0;;
	double food1, food2, food3, food4, food5, food6;
	double drink1, drink2, drink3;

	double totalForFoods;
	double totalForDrinks;
	OrderData oo = new OrderData();
	ConfirmOrder or = new ConfirmOrder();
    
        void menu() throws IOException{
        	frm_menu = new JFrame("KIOKS4 CAFE ");
            frm_menu.setBounds(100, 100, 1000, 550);
            frm_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  			frm_menu.getContentPane().setLayout(null);
  			frm_menu.setResizable(false);
  			frm_menu.setLocationRelativeTo(null);
  			frm_menu.getContentPane().setBackground(new Color(139, 0, 0));

            lblorder = new JLabel("Food Ordered");
            lblorder.setBounds(650, 11, 90, 14);
  			lblorder.setForeground(new Color(248, 248, 255));
  			frm_menu.getContentPane().add(lblorder);
  			frm_menu.repaint();
              
             table = new JTable();
             dtm = new DefaultTableModel(0, 0);
             final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
              
             dtm.setColumnIdentifiers(header);
             dtm.addRow(header);
             table = new JTable();
             table.setModel(dtm);
             table.setBounds(580, 31, 1, 1); // int x, int y, int width, int height
             table.setSize(330, 300); // width,height
             table.getColumnModel().getColumn(0).setPreferredWidth(80);
             table.getColumnModel().getColumn(1).setPreferredWidth(30);
             table.getColumnModel().getColumn(2).setPreferredWidth(30);

             table.getColumnModel().getColumn(3).setMinWidth(0);  // hide spinner value
             table.getColumnModel().getColumn(3).setMaxWidth(0);

             table.setShowGrid(false); // remove cell boarder
              
            frm_menu.getContentPane().add(table);
            
            lblTotal = new JLabel("Sub Total  : ");
  			lblTotal.setBounds(650, 340, 80, 14);
  			lblTotal.setForeground(new Color(248, 248, 255));
  			frm_menu.getContentPane().add(lblTotal);
  			frm_menu.repaint();
  		
  			delivery = new JLabel("+ Rm2 for Delivery Fee");
  			delivery.setBounds(820, 340, 190, 14);
  			delivery.setForeground(new Color(248, 248, 255));
  			frm_menu.getContentPane().add(delivery);
  			frm_menu.repaint();
              
            lblTotal2 = new JLabel("Total         : ");
  			lblTotal2.setBounds(650, 380, 80, 14);
  			lblTotal2.setForeground(new Color(248, 248, 255));
  			frm_menu.getContentPane().add(lblTotal2);
  			frm_menu.repaint();
            
            txt_total = new JTextField();
            txt_total.setBounds(730, 340, 86, 20);
  			frm_menu.getContentPane().add(txt_total);
  			txt_total.setEditable(false);
  			txt_total.setColumns(10);
  			
            txt_total2 = new JTextField();
  			txt_total2.setBounds(730, 380, 86, 20);
  			txt_total2.setEditable(false);
            frm_menu.getContentPane().add(txt_total2);
            txt_total2.setColumns(10);
              
              
            btn_order = new JButton("Order");
            btn_order.setBounds(650, 430, 89, 23);
  			frm_menu.getContentPane().add(btn_order);
  			btn_order.addActionListener(this);
              
              
              
              btn_back = new JButton("Back");
              btn_back.setBounds(740, 430, 89, 23);
              frm_menu.getContentPane().add(btn_back);
              btn_back.addActionListener(this);
              
      
              tab = new JTabbedPane(JTabbedPane.TOP);
              addIt(tab, "Foods");
              addIt1(tab, "Drinks");
              
              tab.setBounds(18, 11, 550, 450);
              frm_menu.getContentPane().add(tab);
              frm_menu.setVisible(true);
        }
    void addIt(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); // getting constraints for the specified
										// component
		gbc.insets = new Insets(10, 0, 0, 0);
		foodImage = new JLabel[Food_ELEMENTS];
		foodLabel = new JLabel[Food_ELEMENTS];
		numSpinner = new JSpinner[Food_ELEMENTS];
		fileFood = new String[Food_ELEMENTS];
		price = new Double[Food_ELEMENTS];

		fileFood[0] = new String("/NasiGorengCina.png");
		fileFood[1] = new String("/NasiGorengBiasa.png");
		fileFood[2] = new String("/NasiGorengKampung.png");
		fileFood[3] = new String("/NasiBajet.png");
		fileFood[4] = new String("/BihunGoreng.png");
		fileFood[5] = new String("/Bubur.png");
		
		foodLabel[0] = new JLabel("Nasi Goreng Cina");
		foodLabel[1] = new JLabel("Nasi Goreng Biasa");
		foodLabel[2] = new JLabel("Nasi Goreng Kampung");
		foodLabel[3] = new JLabel("Nasi Bajet");
		foodLabel[4] = new JLabel("Bihun Goreng");
		foodLabel[5] = new JLabel("Bubur");
		
		price[0] = 3.50;
		price[1] = 4.50;
		price[2] = 3.00;
		price[3] = 4.50;
		price[4] = 5.50;
		price[5] = 4.00;
		
		for (int i = 0; i < Food_ELEMENTS; i++) {	
			System.out.print(fileFood[i]);	
			try {	
			Image image = ImageIO.read(this.getClass().getResource(fileFood[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinner[i] = new JSpinner(spnummodel);
			numSpinner[i].addChangeListener(listener);
			foodImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0;														 // gridx 0 represent the most left
		for (int i = 0; i < Food_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(foodImage[i], gbc);
			gbc.gridy++; 													// gridy---> add one row,for foodLabel
			panel.add(foodLabel[i], gbc);
			gbc.gridy--; 													// remove the row
			gbc.gridx++; 													// move to next column
			panel.add(numSpinner[i], gbc);
			gbc.gridx++; 													// move to next column
			tabbedPane.addTab(text, panel);
		}
    }
    ChangeListener listener = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
	
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Nasi Goreng Cina")) {
						dtm.setValueAt(quantity, row, 1); 										// obj, row, column
						dtm.setValueAt(p1 * quantity, row, 2);
						food1 = p1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Nasi Goreng Biasa")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p2 * quantity, row, 2);
						food2 = p2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Nasi Goreng Kampung")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p3 * quantity, row, 2);
						food3 = p3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Nasi Bajet")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p4 * quantity, row, 2);
						food4 = p4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Bihun Goreng")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p5 * quantity, row, 2);
						food5 = p5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Bubur")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p6 * quantity, row, 2);
						food6 = p6 * quantity;
					} 
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 ;
					total = totalForFoods + totalForDrinks ;
					if(total==0) {
						charge=0;
					}
					else {
						charge=2;
					}
					totalconfirm=total+charge;
					oo.settotal(totalconfirm);
					txt_total.setText(total + "");		
					txt_total2.setText(total +charge+ "");
				
					return;
				}
	
			}
			
			for (int i = 0; i < Food_ELEMENTS; i++) {
																						
				if (numSpinner[i] == e.getSource()) {								// this is a "clicked" JSpinner
					totalPrice = price[i];
					switch (foodLabel[i].getText()) {
					case "Nasi Goreng Cina":
						p1 = 3.50;
						food1 = p1;
						break;
					case "Nasi Goreng Biasa":
						p2 = 4.50;
						food2 = p2;
						break;
					case "Nasi Goreng Kampung":
						p3 = 3.00;
						food3 = p3;
						break;
					case "Nasi Bajet":
						p4 = 4.50;
						food4 = p4;
						break;
					case "Bihun Goreng":
						p5 = 5.50;
						food5 = p5;
						break;
					case "Bubur":
						p6 = 4.00;
						food6 = p6;
						break;
					}
					totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 ;
					total = totalForFoods + totalForDrinks ;
					if(total==0) {
						charge=0;
					}
					else {
						charge=2;
					}
					totalconfirm=total+charge;
					oo.settotal(totalconfirm);
					txt_total.setText(total + "");
					txt_total2.setText(total +charge+ "");
		
					dtm.addRow(new Object[] { foodLabel[i].getText(), quantity, totalPrice, numSpinner[i] });
				
					return;
				}
			}
		}
    };
    void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		drinkImage = new JLabel[DRINK_ELEMENTS];
		drinkLabel = new JLabel[DRINK_ELEMENTS];
		numSpinnerDrinks = new JSpinner[DRINK_ELEMENTS];
		priceDrinks = new Double[DRINK_ELEMENTS];

		fileDrinks = new String[DRINK_ELEMENTS];
		fileDrinks[0] = new String("/sirapais.png");
		fileDrinks[1] = new String("/Miloais.png");
		fileDrinks[2] = new String("/teh-o-ais.png");
		

		drinkLabel[0] = new JLabel("Sirap Ais");
		drinkLabel[1] = new JLabel("Milo Ais");
		drinkLabel[2] = new JLabel("Teh o Ais");
		

		priceDrinks[0] = 3.50;
		priceDrinks[1] = 4.50;
		priceDrinks[2] = 3.00;
		

		for (int i = 0; i < DRINK_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileDrinks[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); 					// value,minimum,maximum,stepSize
			numSpinnerDrinks[i] = new JSpinner(spnummodel);
			numSpinnerDrinks[i].addChangeListener(listenerForDrinks);
			
			drinkImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; 
		gbc.insets = new Insets(10, 5, 0, 0); 
		for (int i = 0; i < DRINK_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(drinkImage[i], gbc);
			gbc.gridy++;													 // gridy---> add one row,for foodLabel
			panel.add(drinkLabel[i], gbc);
			gbc.gridy--; 													// remove the row
			gbc.gridx++; 													// move to next column
			panel.add(numSpinnerDrinks[i], gbc);
			gbc.gridx++;													 // move to next column
			tabbedPane.addTab(text, panel);
		}
	}
    ChangeListener listenerForDrinks = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Sirap Ais")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d1 * quantity, row, 2);
						drink1 = d1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Milo Ais")) {
						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(d2 * quantity, row, 2);
						drink2 = d2 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Teh o Ais")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(d3 * quantity, row, 2);
						drink3 = d3 * quantity;
					} 
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForDrinks = drink1 + drink2 + drink3 ;
					total = totalForFoods + totalForDrinks ;
					if(total==0) {
						charge=0;
					}
					else {
						charge=2;
					}
					totalconfirm=total+charge;
					oo.settotal(totalconfirm);
					txt_total.setText(total + "");
					txt_total2.setText(total +charge+ "");
			
					return;
				}
			}
			
			for (int i = 0; i < DRINK_ELEMENTS; i++) {
				
				if (numSpinnerDrinks[i] == e.getSource()) {					//this is a "clicked" Spinner
					totalPrice = priceDrinks[i];
					switch (drinkLabel[i].getText()) {
					case "Sirap Ais":
						d1 = 3.50;
						drink1 = d1;
						break;
					case "Milo Ais":
						d2 = 4.50;
						drink2 = d2;
						break;
					case "Teh o Ais":
						d3 = 3.00;
						drink3 = d3;
						break;
					}
					totalForDrinks = drink1 + drink2 + drink3 ;
					total = totalForFoods + totalForDrinks ;
					if(total==0) {
						charge=0;
					}
					else {
						charge=2;
					}
					totalconfirm=total+charge;
					oo.settotal(totalconfirm);
					txt_total.setText(total + "");
					txt_total2.setText(total +charge+ "");
					dtm.addRow(new Object[] { drinkLabel[i].getText(), quantity, totalPrice, numSpinnerDrinks[i] });
					return;
				}
			}
		}
	};	
    public void actionPerformed (ActionEvent e){
        if(e.getSource()== btn_back) {
			try {
				Shops shops = new Shops();
				shops.main();
				shops.createAndShowGUI();
				shops.setVisible(true);
				frm_menu.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		}
		if(e.getSource()==btn_order) {
		if(total==0) {
				JOptionPane.showMessageDialog(null, "Please choose your food","Warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
			oo.setorder(dtm);
			
			or.orderconfirm();			
			frm_menu.dispose();		
			}	
		}
		
    }	
}

