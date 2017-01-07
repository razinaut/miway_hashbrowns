package base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Input {

	private static void download() throws IOException{
		String website1 = "https://www.miapp.ca/GTFS_RT/TripUpdate/TripUpdates.pb";

		URL website = new URL(website1);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream("TripUpdates.pb");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
	}
	
	public static String inputHandle (String in){
		try{
			Input.download();
		}
		catch (MalformedURLException e){
			return "Fail";
		}
		catch (IOException i) {
			return "Fail on connection";
		}
		return "Success";
	}
}
