
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Try {

    /**
     * @param args 
     */
    public static void main(String[] args) throws Exception {
    	
        String s = ScrapHTML("http://www.azlyrics.com/lyrics/systemofadown/radiovideo.html");
        System.out.println("The content of document ...........");
        System.out.println(s);

    }

    public static String ScrapHTML(String url) throws Exception {

    	Element doc;
    	//URL lii = new URL(url);
    	doc = Jsoup.connect(url).userAgent("Mozilla")
				.ignoreHttpErrors(true).timeout(0).get();
    	
    	return doc.html().replace("<b />","\n").replace("<br>","").trim().replace("\n", "\n");

    }
}

