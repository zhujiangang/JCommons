package org.jcommons.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloaderTest {
	public static void main(String[] args) throws IOException{
		Document doc = Jsoup.connect("http://meta.stackexchange.com/questions/134495/academic-papers-using-stack-exchange-data").get();
		Elements eles = doc.getElementsContainingText("[PDF]");
		eles.addAll(doc.getElementsContainingText("[arXiv]"));
		String folderName = "D:/dl";
		for(Element ele : eles){
			String src = ele.attr("href");
			if(src==null || src.trim().equals(""))
				continue;
			URL url = new URL(src);
			Element parent = ele.parent();
			Elements eles1 = parent.getElementsByTag("strong");
			Element nameEle = eles1.get(0);
			
			String fileName = nameEle.text().replace(":", " ").replace("\"", "").replace("'", "").replace("?", "");
			if(fileName.contains("Fit or"))
				continue;
			if(!fileName.endsWith("."))
				fileName = fileName.concat(".");
			fileName = fileName.concat("pdf");
			System.out.println(fileName);
			InputStream in = null;
			try{
				in = url.openStream();
			}catch(Exception e){
				continue;
			}
	        
	        OutputStream out = new BufferedOutputStream(new FileOutputStream(folderName+"/"+fileName));

	        for (int b; (b = in.read()) != -1;) {
	            out.write(b);
	        }
	        out.close();
	        in.close();
		}
	}
}
