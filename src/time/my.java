package time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class my extends Thread {
private  JLabel lable;

public my(JLabel lable) {
	super();
	this.lable = lable;
}
public void run() {
	while(true) {
			Calendar cal = Calendar.getInstance();
	cal.add(Calendar.HOUR_OF_DAY, -11);
	Date date = cal.getTime();
	SimpleDateFormat sim = new SimpleDateFormat("hh:mm:ss ");
	String s = sim.format(date);
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
