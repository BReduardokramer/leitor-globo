package br.com.globo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PrincipalBean {
	
	private String xml = "jhhfg";
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> links = new ArrayList<String>();
	
	private String xmlPath = "C:/Users/Johann/Desktop/workspace/leitor-globo/src/br/com/globo/g1principal.xml";
	
	public PrincipalBean() {
		try {
	        BufferedReader in = new BufferedReader(new 
	        		FileReader(xmlPath));
	        String str;
	        while ((str = in.readLine()) != null) {
//	        	System.out.println(str + "\n");
	        	if( str.indexOf("<title>") != -1 ) {
	        		String strFormatted = "";
	        		strFormatted = str.replace("<title>", "").replace("</title>", "");
	        		titles.add(strFormatted);
	        	} else if( str.indexOf("<link>") != -1 ) {
	        		String strFormatted = "";
	        		strFormatted = str.replace("<link>", "").replace("</link>", "");
	        		links.add(strFormatted);
	        	}
	        	xml +=str;
	        }
	        System.out.println(titles);
	        in.close();
	    } catch (IOException e) {
	    	System.out.println(e);
	    }
	}

	public ArrayList<String> getTitles() {
		return titles;
	}

	public void setTitles(ArrayList<String> titles) {
		this.titles = titles;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

}
