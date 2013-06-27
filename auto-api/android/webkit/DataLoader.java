package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.EventHandler;
import com.android.internal.R;
import java.io.ByteArrayInputStream;
import libcore.io.Base64;

class DataLoader extends StreamLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.982 -0400", hash_original_method = "973C5174F409BF73FE3F5C468E90899A", hash_generated_method = "1D3D1CC97145799CA699945E6E0DFAD4")
      DataLoader(String dataUrl, LoadListener loadListener) {
        super(loadListener);
        String url;
        url = dataUrl.substring("data:".length());
        byte[] data;
        data = null;
        int commaIndex;
        commaIndex = url.indexOf(',');
        {
            String contentType;
            contentType = url.substring(0, commaIndex);
            data = url.substring(commaIndex + 1).getBytes();
            loadListener.parseContentTypeHeader(contentType);
            {
                boolean varDB8BCB478219F9C23321F67F114D2478_606376052 = ("base64".equals(loadListener.transferEncoding()));
                {
                    data = Base64.decode(data);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            data = url.getBytes();
        } //End block
        {
            mDataStream = new ByteArrayInputStream(data);
            mContentLength = data.length;
        } //End block
        addTaint(dataUrl.getTaint());
        addTaint(loadListener.getTaint());
        // ---------- Original Method ----------
        //String url = dataUrl.substring("data:".length());
        //byte[] data = null;
        //int commaIndex = url.indexOf(',');
        //if (commaIndex != -1) {
            //String contentType = url.substring(0, commaIndex);
            //data = url.substring(commaIndex + 1).getBytes();
            //loadListener.parseContentTypeHeader(contentType);
            //if ("base64".equals(loadListener.transferEncoding())) {
                //data = Base64.decode(data);
            //}
        //} else {
            //data = url.getBytes();
        //}
        //if (data != null) {
            //mDataStream = new ByteArrayInputStream(data);
            //mContentLength = data.length;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.983 -0400", hash_original_method = "741CD292254249FEBDFDE203F8AC2D5E", hash_generated_method = "3441E52319162EED242988C4DF79070C")
    @Override
    protected boolean setupStreamAndSendStatus() {
        {
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        {
            mLoadListener.error(EventHandler.ERROR,
                    mContext.getString(R.string.httpError));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501944011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501944011;
        // ---------- Original Method ----------
        //if (mDataStream != null) {
            //mLoadListener.status(1, 1, 200, "OK");
            //return true;
        //} else {
            //mLoadListener.error(EventHandler.ERROR,
                    //mContext.getString(R.string.httpError));
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.983 -0400", hash_original_method = "2B11D339C271386CE83AD39A9189005C", hash_generated_method = "DD3C4AC742A0B9EC492618A2D675A09F")
    @Override
    protected void buildHeaders(android.net.http.Headers h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
    }

    
}

