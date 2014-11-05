import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class GoogleScraper {
	
	//https://www.google.com/?gws_rd=ssl#q=system+of+a+down+atwa+www.Songlyrics.com
	
	private String keyword;
	private String GoogleQuery;
	
	public GoogleScraper (String keyword){
		this.keyword = keyword ;
		this.toSearchkey();
	}
	
	public void toSearchkey (){
		this.GoogleQuery = "http://www.google.com/?gws_rd=ssl#q="+keyword.trim().replace(" ", "+") + "+www.songLyrics.com";
		
	}
	
	public String LyricsLink () throws Exception{
		Document doc;

			doc = Jsoup.connect(GoogleQuery).userAgent("Mozzilla").ignoreHttpErrors(true).timeout(0).get();
			System.out.print(doc.text());
			Element link = doc.select("cite:contains(www.songlyrics.com)").first();
			return "http://"+link.text();
	

	}

}
