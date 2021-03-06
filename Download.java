/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdo sniper
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

public class Download {

    
   public File download(URL url, File dstFile) {
		CloseableHttpClient httpclient = HttpClients.custom()
				.setRedirectStrategy(new LaxRedirectStrategy())  
				.build();
		try {
			HttpGet get = new HttpGet(url.toURI()); 
			File downloaded = httpclient.execute(get, new FileDownloadResponseHandler(dstFile));
			return downloaded;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			IOUtils.closeQuietly(httpclient);
		}
	} 
    
   static class FileDownloadResponseHandler implements ResponseHandler<File> {

		private final File target;

		public FileDownloadResponseHandler(File target) {
			this.target = target;
		}

		@Override
		public File handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			InputStream source = response.getEntity().getContent();
			FileUtils.copyInputStreamToFile(source, this.target);
			return this.target;
		}
		
	}
	 
   
   
}//
