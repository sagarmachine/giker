package com.example.demo.utility;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;


@Component
public class GeoLiteService  implements IGeoLite{

	
	Logger logg= Logger.getLogger(GeoLiteService.class);	
	 File database ;
	    DatabaseReader dbReader ;
	
	public GeoLiteService(){
		database = new File("GeoLite2-City.mmdb");
		try {
			dbReader = new DatabaseReader.Builder(database).build();
		} catch (IOException e) {
                         logg.info("IOException----=-=->"+e);			
		}
	}
	
	@Override
	public String getCity(String ip) {  
      
		String cityname=null;
		
		try {
		InetAddress ipAddress = InetAddress.getByName(ip);
	     CityResponse response = dbReader.city(ipAddress);
	      cityname = response.getCity().getName();
	    // logg.info("CITY FOUND_+_+_+_+_+_"+cityname+"         "+response.getCity().getName());
		}
		catch(Exception ex) {
			
			logg.info("ex-getCity()-->"+ex);
		}
	     
		
		return cityname;
	}
	

}
