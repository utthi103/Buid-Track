package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JLabel;

public class muticlock extends Thread {
	private JLabel lable;
	 
	
	public muticlock(JLabel lable) {
		super();
		this.lable = lable;
	}


	public void run() {
		while(true) {
			
			Calendar cal = Calendar.getInstance(); 
			Date date = cal.getTime();
			  SimpleDateFormat sp = new SimpleDateFormat("hh:mm:ss ");
			  String s = sp.format(date);
			  lable.setText(s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
