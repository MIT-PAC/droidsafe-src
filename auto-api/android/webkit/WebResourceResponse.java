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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.810 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.810 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String mEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.810 -0400", hash_original_field = "AC8BA05A72AEC18F12DD0E8C012B9FFC", hash_generated_field = "2066844AD462D9280C47C6967D4F3E6F")

    private InputStream mInputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.811 -0400", hash_original_method = "4162893AC611CC9D36B64E02A003D671", hash_generated_method = "E653503C091ADCBCBFE9F7BFB2F6A32F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.811 -0400", hash_original_method = "1165C88EB0307FF1DFDA0D499F11D5AA", hash_generated_method = "C8A7435C68C155A5CFE8D0848286F857")
    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
        // ---------- Original Method ----------
        //mMimeType = mimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.811 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "B1847CA79C68AACAFA551430B553A51D")
    public String getMimeType() {
        String varB4EAC82CA7396A68D541C85D26508E83_775142120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_775142120 = mMimeType;
        varB4EAC82CA7396A68D541C85D26508E83_775142120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_775142120;
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.812 -0400", hash_original_method = "6642C41BC98D7E1BDACAB67A1DFBBC4B", hash_generated_method = "A8BE31D3863194E0609EC5C066013D56")
    public void setEncoding(String encoding) {
        mEncoding = encoding;
        // ---------- Original Method ----------
        //mEncoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.812 -0400", hash_original_method = "2712105DF2D5EC1ED27B9462D6F15E3A", hash_generated_method = "E377F738E75563D755B0444107D9D38E")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1368497845 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368497845 = mEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1368497845.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368497845;
        // ---------- Original Method ----------
        //return mEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.813 -0400", hash_original_method = "C26148C30E5EF65B476B7B323E30AB3C", hash_generated_method = "AECC74294CA1A9AFB603B72E07B7B0E9")
    public void setData(InputStream data) {
        mInputStream = data;
        // ---------- Original Method ----------
        //mInputStream = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.813 -0400", hash_original_method = "70FED193DE86C029473917F94AE9B4C4", hash_generated_method = "82B43B92A738656E0E66015FFFCCE5C7")
    public InputStream getData() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1015418827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1015418827 = mInputStream;
        varB4EAC82CA7396A68D541C85D26508E83_1015418827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015418827;
        // ---------- Original Method ----------
        //return mInputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.814 -0400", hash_original_method = "6FC74C7BC54A6B57AFC291C9E3571AE9", hash_generated_method = "1FD58B9FB79E05F1DD745ADFF14D2226")
     StreamLoader loader(LoadListener listener) {
        StreamLoader varB4EAC82CA7396A68D541C85D26508E83_382422282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_382422282 = new Loader(listener);
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_382422282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_382422282;
        // ---------- Original Method ----------
        //return new Loader(listener);
    }

    
    private class Loader extends StreamLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.814 -0400", hash_original_method = "FF1E1DBFDB5E8CEAA6F22CFE65A4CDBA", hash_generated_method = "7F50A6D3CEBE89527E538BFE294CB1BC")
          Loader(LoadListener loadListener) {
            super(loadListener);
            mDataStream = mInputStream;
            addTaint(loadListener.getTaint());
            // ---------- Original Method ----------
            //mDataStream = mInputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.815 -0400", hash_original_method = "F11F1CED2E6EEAF3CF48BEFB2475FBE1", hash_generated_method = "C99765277237CB2630362DCD721DA15F")
        @Override
        protected boolean setupStreamAndSendStatus() {
            mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388302399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388302399;
            // ---------- Original Method ----------
            //mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.815 -0400", hash_original_method = "4179DBF067EB1650CA924A33BC327D3E", hash_generated_method = "F40D4382E035CE6B7715C4D124218C2A")
        @Override
        protected void buildHeaders(Headers headers) {
            headers.setContentType(mMimeType);
            headers.setContentEncoding(mEncoding);
            addTaint(headers.getTaint());
            // ---------- Original Method ----------
            //headers.setContentType(mMimeType);
            //headers.setContentEncoding(mEncoding);
        }

        
    }


    
}

