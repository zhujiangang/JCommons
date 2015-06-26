package org.jcommons.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

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
		int times = 1000;
		while (!flag) {
			try {
				res = Jsoup.connect(url).timeout(5000).header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0").execute();
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
//		String html = "";
//		try {
//			html = new String(res.body().getBytes("utf-8"),"gb2312");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Document doc = Jsoup.parse(res.body());
		return doc;
	}
	
	public static Document fetch(String url,Map<String,String> cookies, boolean force){
		Response res = null;
		boolean flag = false;
		int times = 1000;
		while (!flag) {
			try {
				res = Jsoup.connect(url).timeout(5000).cookies(cookies).execute();
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
		String html = "";
		try {
			html = new String(res.body().getBytes("utf-8"),"gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
