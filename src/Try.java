
import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Try {

    /**
     * @param args 
     */
    public static void main(String[] args) throws Exception {
    	
       // String s = ScrapHTML("http://www.songlyrics.com/taylor-swift/out-of-the-woods-lyrics/");
        /*File temp= new File("temp.txt");
        PrintWriter w = new PrintWriter(temp);
        w.print(s);
        w.close();
        System.out.println("The content of document ...........");
       Scanner p = new Scanner (temp);
       int i=0;
       while (p.hasNext()) {
    	   if(p.nextLine().equals("<!-- start of lyrics -->")) break;
    	   System.out.println(i++);}
       while (p.nextLine().equals("<!-- end of lyrics --> ")) System.out.println(p.nextLine());
       p.close();*/
    	//GoogleScraper gs = new GoogleScraper("Linkin Park Faint");
    	//String s = ScrapHTML (gs.LyricsLink());
    	System.out.print(ScrapHTML("http://www.songlyrics.com/imagine-dragons/warriors-lyrics/"));
        //System.out.println(s);
       

    }

    public static String ScrapHTML(String url) throws Exception {

    	Document doc;
    	//URL lii = new URL(url);
    	
    	doc = Jsoup.connect(url).userAgent("Mozilla")
				.ignoreHttpErrors(true).timeout(0).get();
    	Element Lyrics = doc.getElementById("songLyricsDiv");
    	return Lyrics.html().replace("<br></br>","\n").replace("<br>", "\n").trim().replace("\n", "\n");

    }
}

