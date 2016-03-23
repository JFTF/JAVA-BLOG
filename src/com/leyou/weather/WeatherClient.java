package com.leyou.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;





import com.moon.service.ArrayOfString;
import com.moon.service.WeatherWebService;
import com.moon.service.WeatherWebServiceSoap;



public class WeatherClient {
    public  List<String> weather(String city){
    	WeatherWebService weatherWS = new WeatherWebService();
		WeatherWebServiceSoap weatherWSSoap = weatherWS.getWeatherWebServiceSoap();
		ArrayOfString weather = weatherWSSoap.getWeatherbyCityName(city);
		List<String> list = weather.getString();
		return list;
	}
  
}

