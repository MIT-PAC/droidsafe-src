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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.116 -0400", hash_original_method = "973C5174F409BF73FE3F5C468E90899A", hash_generated_method = "67781764EBA9D59216ACFDB3EA4C652F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DataLoader(String dataUrl, LoadListener loadListener) {
        super(loadListener);
        dsTaint.addTaint(dataUrl);
        dsTaint.addTaint(loadListener.dsTaint);
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
                boolean varDB8BCB478219F9C23321F67F114D2478_1876648740 = ("base64".equals(loadListener.transferEncoding()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.116 -0400", hash_original_method = "741CD292254249FEBDFDE203F8AC2D5E", hash_generated_method = "8B8E2434CF8D36400B4352850A16F36A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setupStreamAndSendStatus() {
        {
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        {
            mLoadListener.error(EventHandler.ERROR,
                    mContext.getString(R.string.httpError));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.116 -0400", hash_original_method = "2B11D339C271386CE83AD39A9189005C", hash_generated_method = "D39F32E633EE2F51267FB366D24ED9F3")
    @DSModeled(DSC.SAFE)
    @Override
    protected void buildHeaders(android.net.http.Headers h) {
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
    }

    
}

