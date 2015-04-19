package org.jcommons.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void downloadFile(String url, File file) {
		URL urlfile = null;
//		HttpURLConnection httpUrl = null;
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
		InputStream in = null;
		OutputStream out = null;
		OutputStreamWriter writer = null;
		if(!file.exists())
			return;
		try {
			urlfile = new URL(url);
//			httpUrl = (HttpURLConnection) urlfile.openConnection();
//			httpUrl.connect();
//			bis = new BufferedInputStream(httpUrl.getInputStream());
//			bos = new BufferedOutputStream(new FileOutputStream(file));
//			int len = 2048;
//			byte[] b = new byte[len];
//			while ((len = bis.read(b)) != -1) {
//				bos.write(b, 0, len);
//			}
//			bos.flush();
//			bis.close();
//			httpUrl.disconnect();
			
			try{
				in = urlfile.openStream();
			}catch(Exception e){
				e.printStackTrace();
			}
	        
	        out = new BufferedOutputStream(new FileOutputStream(file));
	        writer = new OutputStreamWriter(out,"UTF-8");
	        for (int b; (b = in.read()) != -1;) {
	            writer.write(b);
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
		        writer.close();
				out.close();
		        in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
