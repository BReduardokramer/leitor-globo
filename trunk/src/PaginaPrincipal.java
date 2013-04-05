import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PaginaPrincipal {
	
	private static String content = "";
	
	public static void main(String[] args) {
		try {
	        BufferedReader in = new BufferedReader(new FileReader("paginaprincipal.html"));
	        String str;
	        while ((str = in.readLine()) != null) {
	            content +=str;
	        }
	        System.out.println(content);
	        in.close();
	    } catch (IOException e) {
	    }

	}
	
    
}
