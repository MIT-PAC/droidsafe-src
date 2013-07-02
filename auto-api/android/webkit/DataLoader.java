package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.net.http.EventHandler;
import com.android.internal.R;
import java.io.ByteArrayInputStream;
import libcore.io.Base64;

class DataLoader extends StreamLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.409 -0400", hash_original_method = "973C5174F409BF73FE3F5C468E90899A", hash_generated_method = "B713219388617F6E4A20343F0F69A82E")
      DataLoader(String dataUrl, LoadListener loadListener) {
        super(loadListener);
        String url = dataUrl.substring("data:".length());
        byte[] data = null;
        int commaIndex = url.indexOf(',');
        {
            String contentType = url.substring(0, commaIndex);
            data = url.substring(commaIndex + 1).getBytes();
            loadListener.parseContentTypeHeader(contentType);
            {
                boolean varDB8BCB478219F9C23321F67F114D2478_1129262497 = ("base64".equals(loadListener.transferEncoding()));
                {
                    data = Base64.decode(data);
                } 
            } 
        } 
        {
            data = url.getBytes();
        } 
        {
            mDataStream = new ByteArrayInputStream(data);
            mContentLength = data.length;
        } 
        addTaint(dataUrl.getTaint());
        addTaint(loadListener.getTaint());
        
        
        
        
        
            
            
            
            
                
            
        
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.409 -0400", hash_original_method = "741CD292254249FEBDFDE203F8AC2D5E", hash_generated_method = "0ADA1F0868FDACC6E424BBD28DFE9B0F")
    @Override
    protected boolean setupStreamAndSendStatus() {
        {
            mLoadListener.status(1, 1, 200, "OK");
        } 
        {
            mLoadListener.error(EventHandler.ERROR,
                    mContext.getString(R.string.httpError));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801224847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801224847;
        
        
            
            
        
            
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.409 -0400", hash_original_method = "2B11D339C271386CE83AD39A9189005C", hash_generated_method = "DD3C4AC742A0B9EC492618A2D675A09F")
    @Override
    protected void buildHeaders(android.net.http.Headers h) {
        addTaint(h.getTaint());
        
    }

    
}

