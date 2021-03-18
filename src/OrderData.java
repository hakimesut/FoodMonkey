import javax.swing.table.DefaultTableModel;

public class OrderData {

		private static String ordershop="";
		private static DefaultTableModel type;
		private static double totalpayment;

			
		public void setchecking(String id) {
			ordershop=id;
		}
			
		public void settotal(double t) {
			totalpayment=t;
		}
		
		public void setorder(DefaultTableModel dtm) {
			type=dtm;
		
		}
		public String getchecking() {
			return ordershop;
		}
		
		public DefaultTableModel getorder() {
			return type;
		}
		public double gettotalpayment() {
			return totalpayment;
		}
}
