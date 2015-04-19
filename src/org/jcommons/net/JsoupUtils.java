package org.jcommons.net;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class JsoupUtils {
	public static Document fetch(String url,boolean force,StringBuffer realUrl){
		Response res = null;
		boolean flag = false;
		int times = 100;
		while (!flag) {
			try {
				res = Jsoup.connect(url).timeout(5000).execute();
				//times--;
				if (res != null
						&& (res.statusCode() == 200 || res
								.statusCode() == 404))
					flag = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				times--;
				if(!force){
					if (res != null
							&& (res.statusCode() == 200 || res
									.statusCode() == 404))
						flag = true;
				}
				if (times < 0 && res == null)
					flag = true;
			}
		}
		if (res == null || res.statusCode() != 200){
			realUrl = null;
			return null;
		}
		realUrl.append(res.url().toString());
		Document doc = Jsoup.parse(res.body());
		return doc;
	}
	
	public static Document fetch(String url,boolean force){
		Response res = null;
		boolean flag = false;
		int times = 100;
		while (!flag) {
			try {
				res = Jsoup.connect(url).timeout(5000).execute();
				//times--;
				if (res != null
						&& (res.statusCode() == 200 || res
								.statusCode() == 404))
					flag = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				times--;
				if(!force){
					if (res != null
							&& (res.statusCode() == 200 || res
									.statusCode() == 404))
						flag = true;
				}
				if (times < 0 && res == null)
					flag = true;
			}
		}
		if (res == null || res.statusCode() != 200){
			return null;
		}
		Document doc = Jsoup.parse(res.body());
		return doc;
	}
	
	public static Document fetch(String url,int times,boolean force){
		Response res = null;
		boolean flag = false;
		while (!flag) {
			try {
				res = Jsoup.connect(url).timeout(5000).execute();
				//times--;
				if (res != null
						&& (res.statusCode() == 200 || res
								.statusCode() == 404))
					flag = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				times--;
				if(!force){
					if (res != null
							&& (res.statusCode() == 200 || res
									.statusCode() == 404))
						flag = true;
				}
				if (times < 0 && res == null)
					flag = true;
			}
		}
		if (res == null || res.statusCode() != 200){
			return null;
		}
		Document doc = Jsoup.parse(res.body());
		return doc;
	}
}
