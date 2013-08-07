package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;

import android.net.http.Headers;





public class WebResourceResponse {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.427 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.427 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String mEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.427 -0400", hash_original_field = "AC8BA05A72AEC18F12DD0E8C012B9FFC", hash_generated_field = "2066844AD462D9280C47C6967D4F3E6F")

    private InputStream mInputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.428 -0400", hash_original_method = "4162893AC611CC9D36B64E02A003D671", hash_generated_method = "E653503C091ADCBCBFE9F7BFB2F6A32F")
    public  WebResourceResponse(String mimeType, String encoding,
            InputStream data) {
        mMimeType = mimeType;
        mEncoding = encoding;
        mInputStream = data;
        // ---------- Original Method ----------
        //mMimeType = mimeType;
        //mEncoding = encoding;
        //mInputStream = data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.428 -0400", hash_original_method = "1165C88EB0307FF1DFDA0D499F11D5AA", hash_generated_method = "C8A7435C68C155A5CFE8D0848286F857")
    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
        // ---------- Original Method ----------
        //mMimeType = mimeType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.429 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "D9CCF39D927E9C42CA9F8BC410F9272E")
    public String getMimeType() {
String varBE38DA462B031CDCB7789EAC19C3FD2D_1891801921 =         mMimeType;
        varBE38DA462B031CDCB7789EAC19C3FD2D_1891801921.addTaint(taint);
        return varBE38DA462B031CDCB7789EAC19C3FD2D_1891801921;
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.429 -0400", hash_original_method = "6642C41BC98D7E1BDACAB67A1DFBBC4B", hash_generated_method = "A8BE31D3863194E0609EC5C066013D56")
    public void setEncoding(String encoding) {
        mEncoding = encoding;
        // ---------- Original Method ----------
        //mEncoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.430 -0400", hash_original_method = "2712105DF2D5EC1ED27B9462D6F15E3A", hash_generated_method = "C730B56FAEE38994ADE62FCF4771BB50")
    public String getEncoding() {
String varD11A7DF5C4874207C4AF6345DC7F5843_796400779 =         mEncoding;
        varD11A7DF5C4874207C4AF6345DC7F5843_796400779.addTaint(taint);
        return varD11A7DF5C4874207C4AF6345DC7F5843_796400779;
        // ---------- Original Method ----------
        //return mEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.430 -0400", hash_original_method = "C26148C30E5EF65B476B7B323E30AB3C", hash_generated_method = "AECC74294CA1A9AFB603B72E07B7B0E9")
    public void setData(InputStream data) {
        mInputStream = data;
        // ---------- Original Method ----------
        //mInputStream = data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.430 -0400", hash_original_method = "70FED193DE86C029473917F94AE9B4C4", hash_generated_method = "9DE70DF74AD954013EEA6CEBB44873F1")
    public InputStream getData() {
InputStream var2E675DC7F4D82075BA9D940E3D1423A3_760654932 =         mInputStream;
        var2E675DC7F4D82075BA9D940E3D1423A3_760654932.addTaint(taint);
        return var2E675DC7F4D82075BA9D940E3D1423A3_760654932;
        // ---------- Original Method ----------
        //return mInputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.431 -0400", hash_original_method = "6FC74C7BC54A6B57AFC291C9E3571AE9", hash_generated_method = "19737D5C2003312847C523A14D948FB7")
     StreamLoader loader(LoadListener listener) {
        addTaint(listener.getTaint());
StreamLoader var5DB7DBF28A0F4B000D588BFE2242F8C3_814125059 =         new Loader(listener);
        var5DB7DBF28A0F4B000D588BFE2242F8C3_814125059.addTaint(taint);
        return var5DB7DBF28A0F4B000D588BFE2242F8C3_814125059;
        // ---------- Original Method ----------
        //return new Loader(listener);
    }

    
    private class Loader extends StreamLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.467 -0400", hash_original_method = "FF1E1DBFDB5E8CEAA6F22CFE65A4CDBA", hash_generated_method = "CED1DA0B7475DA803D26EF443840F8B8")
          Loader(LoadListener loadListener) {
            super(loadListener);
            addTaint(loadListener.getTaint());
            mDataStream = mInputStream;
            // ---------- Original Method ----------
            //mDataStream = mInputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.467 -0400", hash_original_method = "F11F1CED2E6EEAF3CF48BEFB2475FBE1", hash_generated_method = "79A10ADA421993CABFB514C276D7D00B")
        @Override
        protected boolean setupStreamAndSendStatus() {
            mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            boolean varB326B5062B2F0E69046810717534CB09_1328960658 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103938024 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103938024;
            // ---------- Original Method ----------
            //mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.467 -0400", hash_original_method = "4179DBF067EB1650CA924A33BC327D3E", hash_generated_method = "3B10E90D6A09D22D672A820471222370")
        @Override
        protected void buildHeaders(Headers headers) {
            addTaint(headers.getTaint());
            headers.setContentType(mMimeType);
            headers.setContentEncoding(mEncoding);
            // ---------- Original Method ----------
            //headers.setContentType(mMimeType);
            //headers.setContentEncoding(mEncoding);
        }

        
    }


    
}

