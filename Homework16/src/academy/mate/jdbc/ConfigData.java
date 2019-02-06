package academy.mate.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class ConfigData {
	private String driver;
	private String host ;
	private String user  ;
	private String password ;

	 public ConfigData() {

	 }

	 public ConfigData(String driver, String host, String user, String password) {
	   this.driver = driver;
	   this.host = host;
	   this.user = user;
	   this.password = password;
	 }

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
