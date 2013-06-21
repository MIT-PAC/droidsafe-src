package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.Headers;
import java.io.InputStream;

public class WebResourceResponse {
    private String mMimeType;
    private String mEncoding;
    private InputStream mInputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.018 -0400", hash_original_method = "4162893AC611CC9D36B64E02A003D671", hash_generated_method = "AD361104A028FB707984CE90B315991F")
    @DSModeled(DSC.SAFE)
    public WebResourceResponse(String mimeType, String encoding,
            InputStream data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(mimeType);
        // ---------- Original Method ----------
        //mMimeType = mimeType;
        //mEncoding = encoding;
        //mInputStream = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.019 -0400", hash_original_method = "1165C88EB0307FF1DFDA0D499F11D5AA", hash_generated_method = "80F9DCA1A16A8367D6E1679452FDCD70")
    @DSModeled(DSC.SAFE)
    public void setMimeType(String mimeType) {
        dsTaint.addTaint(mimeType);
        // ---------- Original Method ----------
        //mMimeType = mimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.019 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "23B586E03B0339D7D12E0E1854AD4954")
    @DSModeled(DSC.SAFE)
    public String getMimeType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.019 -0400", hash_original_method = "6642C41BC98D7E1BDACAB67A1DFBBC4B", hash_generated_method = "4EE89EC4E9C66A2609FC8459EE49D11E")
    @DSModeled(DSC.SAFE)
    public void setEncoding(String encoding) {
        dsTaint.addTaint(encoding);
        // ---------- Original Method ----------
        //mEncoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.019 -0400", hash_original_method = "2712105DF2D5EC1ED27B9462D6F15E3A", hash_generated_method = "474F54849F58BB6A7E547A01E3C899D5")
    @DSModeled(DSC.SAFE)
    public String getEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.019 -0400", hash_original_method = "C26148C30E5EF65B476B7B323E30AB3C", hash_generated_method = "86594BEAD6854A26996283C0BB657A3A")
    @DSModeled(DSC.SAFE)
    public void setData(InputStream data) {
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
        //mInputStream = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.019 -0400", hash_original_method = "70FED193DE86C029473917F94AE9B4C4", hash_generated_method = "43B56E6F1F8F81F2DB0BC2ACBBCD994B")
    @DSModeled(DSC.SAFE)
    public InputStream getData() {
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.020 -0400", hash_original_method = "6FC74C7BC54A6B57AFC291C9E3571AE9", hash_generated_method = "3E8D075409CAAB49249E2146AC60C6A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     StreamLoader loader(LoadListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        StreamLoader varB97756218AC93463D52886A2AE89336B_376899286 = (new Loader(listener));
        return (StreamLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Loader(listener);
    }

    
    private class Loader extends StreamLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.020 -0400", hash_original_method = "FF1E1DBFDB5E8CEAA6F22CFE65A4CDBA", hash_generated_method = "E485D8D9CF32DF3FADAA31338CBEEAFA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Loader(LoadListener loadListener) {
            super(loadListener);
            dsTaint.addTaint(loadListener.dsTaint);
            mDataStream = mInputStream;
            // ---------- Original Method ----------
            //mDataStream = mInputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.020 -0400", hash_original_method = "F11F1CED2E6EEAF3CF48BEFB2475FBE1", hash_generated_method = "695004688892F0CEF008A691FC3F02B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean setupStreamAndSendStatus() {
            mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.020 -0400", hash_original_method = "4179DBF067EB1650CA924A33BC327D3E", hash_generated_method = "C722F253504F413CB00526075501AB64")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void buildHeaders(Headers headers) {
            dsTaint.addTaint(headers.dsTaint);
            headers.setContentType(mMimeType);
            headers.setContentEncoding(mEncoding);
            // ---------- Original Method ----------
            //headers.setContentType(mMimeType);
            //headers.setContentEncoding(mEncoding);
        }

        
    }


    
}

