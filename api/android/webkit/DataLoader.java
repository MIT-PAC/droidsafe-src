package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;

import libcore.io.Base64;
import android.net.http.EventHandler;

import com.android.internal.R;





class DataLoader extends StreamLoader {

    /**
     * Constructor uses the dataURL as the source for an InputStream
     * @param dataUrl data: URL string optionally containing a mimetype
     * @param loadListener LoadListener to pass the content to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.938 -0500", hash_original_method = "973C5174F409BF73FE3F5C468E90899A", hash_generated_method = "973C5174F409BF73FE3F5C468E90899A")
    DataLoader(String dataUrl, LoadListener loadListener) {
        super(loadListener);

        String url = dataUrl.substring("data:".length());
        byte[] data = null;
        int commaIndex = url.indexOf(',');
        if (commaIndex != -1) {
            String contentType = url.substring(0, commaIndex);
            data = url.substring(commaIndex + 1).getBytes();
            loadListener.parseContentTypeHeader(contentType);
            if ("base64".equals(loadListener.transferEncoding())) {
                data = Base64.decode(data);
            }
        } else {
            data = url.getBytes();
        }
        if (data != null) {
            mDataStream = new ByteArrayInputStream(data);
            mContentLength = data.length;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.939 -0500", hash_original_method = "741CD292254249FEBDFDE203F8AC2D5E", hash_generated_method = "A73B364F77DE34AD223121C6605AF5FF")
    @Override
protected boolean setupStreamAndSendStatus() {
        if (mDataStream != null) {
            mLoadListener.status(1, 1, 200, "OK");
            return true;
        } else {
            mLoadListener.error(EventHandler.ERROR,
                    mContext.getString(R.string.httpError));
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.939 -0500", hash_original_method = "2B11D339C271386CE83AD39A9189005C", hash_generated_method = "138E19A88952EC3EA1712D8583B9657B")
    @Override
protected void buildHeaders(android.net.http.Headers h) {
    }

    
}

