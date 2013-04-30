package br.com.globo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.faces.bean.ManagedBean;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;

@ManagedBean
public class Noticia2 {

	private String load = "";
	
	public Noticia2() {
		File f = new File("C:/Users/Johann/Desktop/workspace/leitor-globo/noticia2.wav");
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
	}

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}

}