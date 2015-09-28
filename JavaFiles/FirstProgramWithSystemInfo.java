import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  * Sample Program with system information
 *  * 
 *  * Compile : javac FirstProgramWithSystemInfo.java
 *  * 	Run    : java FirstProgramWithSystemInfo
 *  */
public class FirstProgramWithSystemInfo {	
	public static void main(String[] args){

		System.out.println("My first program with System Information!");

		// Print Date with Time
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Today is: " + dateFormat.format(date));
		// Print Username
		System.out.println("Username is: " + System.getProperty("user.name"));
		// Print hostname
		try {
			java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
			System.out.println("Hostname is: " + localMachine.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("No host name: " + e.getMessage());
		}
	}
}
