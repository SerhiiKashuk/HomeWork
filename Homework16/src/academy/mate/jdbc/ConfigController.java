package academy.mate.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class ConfigController {
	 public static void write(ConfigData conf)  {
	   XStream xs = new XStream(new StaxDriver());
	   try {
			xs.toXML(conf, new FileOutputStream("config.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 public static ConfigData read(String path)  {
	   XStream xs = new XStream(new DomDriver());
	   ConfigData cd = new ConfigData();
	   try {
			xs.fromXML(new FileInputStream(path), cd);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return cd;
	 }
}
