package br.com.globo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.print.attribute.standard.Media;

@ManagedBean
public class PrincipalBean {
	
	private String xml = "jhhfg";
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> links = new ArrayList<String>();
	
	private String xmlPath = "C:/Users/Johann/Desktop/workspace/leitor-globo/src/br/com/globo/g1principal.xml";
	
	public PrincipalBean() {
		File f = new File("C:/Users/Johann/Desktop/workspace/leitor-globo/audioprincipal.wav");
		MediaLocator ml = null;
		try {
			ml = new MediaLocator(f.toURL());
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Player p = null;
		try {
			p = Manager.createPlayer(ml);
		} catch (NoPlayerException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p.start();
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
