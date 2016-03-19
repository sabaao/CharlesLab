package test.charles.JsoupExample;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	//read yahoo home page
    	String url  = "https://tw.yahoo.com/";
    	Document doc = Jsoup.connect(url).get();
    	
    	//get first news tab one
    	Element t1 = doc.getElementById("t1");
    	
    	//get news title
    	Elements newsTitle = t1.select("a[href] > span");
    	
    	//print size
        System.out.println("size:" + newsTitle.size());
        
        //print news title
        for(Element e:newsTitle){
        	System.out.println("title:" + e.text());
        }
        
    }
}
