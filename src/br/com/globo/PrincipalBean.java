package br.com.globo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.print.attribute.standard.Media;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import com.sun.xml.internal.txw2.Document;

@ManagedBean
public class PrincipalBean {
	
	private String load = "";
	
	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}

	private String xmlToView;
	public String getXmlToView() {
		return xmlToView;
	}

	public void setXmlToView(String xmlToView) {
		this.xmlToView = xmlToView;
	}

	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> links = new ArrayList<String>();
	
	private String xmlPath = "C:/Users/Johann/Desktop/workspace/leitor-globo/src/br/com/globo/g1principal.xml";

	private Player mainPlayer = null;
	
	private String rawXml;
	
	public String getNoticia1Title() {
		return noticia1Title;
	}

	public void setNoticia1Title(String noticia1Title) {
		this.noticia1Title = noticia1Title;
	}

	public String getNoticia2Title() {
		return noticia2Title;
	}

	public void setNoticia2Title(String noticia2Title) {
		this.noticia2Title = noticia2Title;
	}

	public String getNoticia3Title() {
		return noticia3Title;
	}

	public void setNoticia3Title(String noticia3Title) {
		this.noticia3Title = noticia3Title;
	}

	public String getNoticia4Title() {
		return noticia4Title;
	}

	public void setNoticia4Title(String noticia4Title) {
		this.noticia4Title = noticia4Title;
	}

	public String getNoticia5Title() {
		return noticia5Title;
	}

	public void setNoticia5Title(String noticia5Title) {
		this.noticia5Title = noticia5Title;
	}

	public String getNoticia6Title() {
		return noticia6Title;
	}

	public void setNoticia6Title(String noticia6Title) {
		this.noticia6Title = noticia6Title;
	}

	public String getNoticia7Title() {
		return noticia7Title;
	}

	public void setNoticia7Title(String noticia7Title) {
		this.noticia7Title = noticia7Title;
	}

	public String getNoticia8Title() {
		return noticia8Title;
	}

	public void setNoticia8Title(String noticia8Title) {
		this.noticia8Title = noticia8Title;
	}

	public String getNoticia9Title() {
		return noticia9Title;
	}

	public void setNoticia9Title(String noticia9Title) {
		this.noticia9Title = noticia9Title;
	}

	public String getNoticia10Title() {
		return noticia10Title;
	}

	public void setNoticia10Title(String noticia10Title) {
		this.noticia10Title = noticia10Title;
	}

	private String noticia1Title;
	private String noticia2Title;
	private String noticia3Title;
	private String noticia4Title;
	private String noticia5Title;
	private String noticia6Title;
	private String noticia7Title;
	private String noticia8Title;
	private String noticia9Title;
	private String noticia10Title;
	
	public String getNoticia1Link() {
		return noticia1Link;
	}

	public void setNoticia1Link(String noticia1Link) {
		this.noticia1Link = noticia1Link;
	}

	public String getNoticia2Link() {
		return noticia2Link;
	}

	public void setNoticia2Link(String noticia2Link) {
		this.noticia2Link = noticia2Link;
	}

	public String getNoticia3Link() {
		return noticia3Link;
	}

	public void setNoticia3Link(String noticia3Link) {
		this.noticia3Link = noticia3Link;
	}

	public String getNoticia4Link() {
		return noticia4Link;
	}

	public void setNoticia4Link(String noticia4Link) {
		this.noticia4Link = noticia4Link;
	}

	public String getNoticia5Link() {
		return noticia5Link;
	}

	public void setNoticia5Link(String noticia5Link) {
		this.noticia5Link = noticia5Link;
	}

	public String getNoticia6Link() {
		return noticia6Link;
	}

	public void setNoticia6Link(String noticia6Link) {
		this.noticia6Link = noticia6Link;
	}

	public String getNoticia7Link() {
		return noticia7Link;
	}

	public void setNoticia7Link(String noticia7Link) {
		this.noticia7Link = noticia7Link;
	}

	public String getNoticia8Link() {
		return noticia8Link;
	}

	public void setNoticia8Link(String noticia8Link) {
		this.noticia8Link = noticia8Link;
	}

	public String getNoticia9Link() {
		return noticia9Link;
	}

	public void setNoticia9Link(String noticia9Link) {
		this.noticia9Link = noticia9Link;
	}

	public String getNoticia10Link() {
		return noticia10Link;
	}

	public void setNoticia10Link(String noticia10Link) {
		this.noticia10Link = noticia10Link;
	}

	private String noticia1Link;
	private String noticia2Link;
	private String noticia3Link;
	private String noticia4Link;
	private String noticia5Link;
	private String noticia6Link;
	private String noticia7Link;
	private String noticia8Link;
	private String noticia9Link;
	private String noticia10Link;

	public PrincipalBean() {
//		File f = new File("C:/Users/Johann/Desktop/workspace/leitor-globo/audioprincipalv3.wav");
//		MediaLocator ml = null;
//		try {
//			ml = new MediaLocator(f.toURL());
//		} catch (MalformedURLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		try {
//			mainPlayer = Manager.createPlayer(ml);
//		} catch (NoPlayerException | IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//mainPlayer.start();
		
		try {
			URL g1rss = new URL("http://g1.globo.com/dynamo/rss2.xml");
			BufferedReader in = new BufferedReader(new InputStreamReader(g1rss.openStream(), "UTF-8"));
			String xml = in.toString();
			System.out.println(xml);
			int c; 
			int count = 1;
			while ((c = in.read()) != -1){
				String line = in.readLine();
				
				String[] parts = line.split("<title>");
				
				for( String part:parts ){
					if( part.indexOf("<link>") != -1 ){
						String[] title;
						String[] link;
						title = part.split("</title>");
						link = part.split("<link>");
						if(title[0].charAt(0) != '/' && title[0].indexOf("http") == -1 && title[0].indexOf("G1") == -1) {
							//System.out.println(link[1]);
							String[] linkFiltered;
							linkFiltered = link[1].split("</link><description>");
							//System.out.println(linkFiltered[0]);
							//System.out.println(count);
							
							if(count == 1) {
								noticia1Title = title[0]; 
								noticia1Link = linkFiltered[0];
							}
							if(count == 2) {
								noticia2Title = title[0];
								noticia2Link = linkFiltered[0];
							}
							if(count == 3) {
								noticia3Title = title[0];
								noticia3Link = linkFiltered[0];
							}
							if(count == 4) {
								noticia4Title = title[0];
								noticia4Link = linkFiltered[0];
							}
							if(count == 5) {
								noticia5Title = title[0];
								noticia5Link = linkFiltered[0];
							}
							if(count == 6) {
								noticia6Title = title[0];
								noticia6Link = linkFiltered[0];
							}
							if(count == 7) {
								noticia7Title = title[0];
								noticia7Link = linkFiltered[0];
							}
							if(count == 8) {
								noticia8Title = title[0];
								noticia8Link = linkFiltered[0];
							}
							if(count == 9) {
								noticia9Title = title[0];
								noticia9Link = linkFiltered[0];
							}
							if(count == 10) {
								noticia10Title = title[0];
								noticia10Link = linkFiltered[0];
							}
							if(count == 11) break;
							
							System.out.println(noticia1Link);
							
							count++;
						}
					}
				}
			}
			
			//System.out.println(xmlToView);
			
//	        String str;
//			while ((str = in.readLine()) != null) {
////	        	System.out.println(str + "\n");
//	        	if( str.indexOf("<title>") != -1 ) {
//	        		String strFormatted = "";
//	        		strFormatted = str.replace("<title>", "").replace("</title>", "");
//	        		titles.add(strFormatted);
//	        	} else if( str.indexOf("<link>") != -1 ) {
//	        		String strFormatted = "";
//	        		strFormatted = str.replace("<link>", "").replace("</link>", "");
//	        		links.add(strFormatted);
//	        	}
//	        	xml +=str;
//	        }
//	        System.out.println(titles);
//	        in.close();
	    } catch (IOException e) {
	    	System.out.println(e);
	    }
	}
	
	public String getRawXml() {
		return rawXml;
	}

	public void setRawXml(String rawXml) {
		this.rawXml = rawXml;
	}

	public void stopMainReading(){
		mainPlayer.start();
	}

	public ArrayList<String> getTitles() {
		return titles;
	}

	public void setTitles(ArrayList<String> titles) {
		this.titles = titles;
	}
}
