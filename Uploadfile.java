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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
//import org.apache.http.util.EncodingUtils;
public class Uploadfile {
    
    public Uploadfile(String filename) {

        
        HttpClient httpclient =new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpPost httppost=new HttpPost("http://localhost:80/uplo.php");
        File file =new File(filename);
        MultipartEntity mpentity=new MultipartEntity();
        ContentBody cbfile=new FileBody(file, "image/jpeg");
        mpentity.addPart("userfile", cbfile);
        httppost.setEntity(mpentity);
        //
        
        HttpResponse response;
        
        try {
        
        
response =httpclient.execute(httppost);

HttpEntity resEntity=response.getEntity();

//

if(resEntity!=null){
    
    resEntity.consumeContent();
    
    
}



        }catch(IOException ex){
        Logger.getLogger(Uploadfile.class.getName()).log(Level.SEVERE,null,ex);
        
        
        }

        httpclient.getConnectionManager().shutdown();
       // JOptionPane.showMessageDialog(null, "File Upload Done ");
}
    

        
    
}
