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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.943 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.943 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String mEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.943 -0400", hash_original_field = "AC8BA05A72AEC18F12DD0E8C012B9FFC", hash_generated_field = "2066844AD462D9280C47C6967D4F3E6F")

    private InputStream mInputStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.957 -0400", hash_original_method = "4162893AC611CC9D36B64E02A003D671", hash_generated_method = "E653503C091ADCBCBFE9F7BFB2F6A32F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.957 -0400", hash_original_method = "1165C88EB0307FF1DFDA0D499F11D5AA", hash_generated_method = "C8A7435C68C155A5CFE8D0848286F857")
    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
        // ---------- Original Method ----------
        //mMimeType = mimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.958 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "0A2DDE3BB00E000AEB48DCA5FC9B3A55")
    public String getMimeType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1153003065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1153003065 = mMimeType;
        varB4EAC82CA7396A68D541C85D26508E83_1153003065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1153003065;
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.958 -0400", hash_original_method = "6642C41BC98D7E1BDACAB67A1DFBBC4B", hash_generated_method = "A8BE31D3863194E0609EC5C066013D56")
    public void setEncoding(String encoding) {
        mEncoding = encoding;
        // ---------- Original Method ----------
        //mEncoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.959 -0400", hash_original_method = "2712105DF2D5EC1ED27B9462D6F15E3A", hash_generated_method = "1203593D092C03F23C7318900C00557C")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1127373361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1127373361 = mEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1127373361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1127373361;
        // ---------- Original Method ----------
        //return mEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.959 -0400", hash_original_method = "C26148C30E5EF65B476B7B323E30AB3C", hash_generated_method = "AECC74294CA1A9AFB603B72E07B7B0E9")
    public void setData(InputStream data) {
        mInputStream = data;
        // ---------- Original Method ----------
        //mInputStream = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.960 -0400", hash_original_method = "70FED193DE86C029473917F94AE9B4C4", hash_generated_method = "0385BEDC7B9BCCCFA6A4D87AEE1E494A")
    public InputStream getData() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_277367621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_277367621 = mInputStream;
        varB4EAC82CA7396A68D541C85D26508E83_277367621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277367621;
        // ---------- Original Method ----------
        //return mInputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.965 -0400", hash_original_method = "6FC74C7BC54A6B57AFC291C9E3571AE9", hash_generated_method = "F2EC9CB9B9DE79C17906938C4E507644")
     StreamLoader loader(LoadListener listener) {
        StreamLoader varB4EAC82CA7396A68D541C85D26508E83_49102012 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_49102012 = new Loader(listener);
        addTaint(listener.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_49102012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_49102012;
        // ---------- Original Method ----------
        //return new Loader(listener);
    }

    
    private class Loader extends StreamLoader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.966 -0400", hash_original_method = "FF1E1DBFDB5E8CEAA6F22CFE65A4CDBA", hash_generated_method = "7F50A6D3CEBE89527E538BFE294CB1BC")
          Loader(LoadListener loadListener) {
            super(loadListener);
            mDataStream = mInputStream;
            addTaint(loadListener.getTaint());
            // ---------- Original Method ----------
            //mDataStream = mInputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.966 -0400", hash_original_method = "F11F1CED2E6EEAF3CF48BEFB2475FBE1", hash_generated_method = "A39424CFF5E1AB24376D4148C285A371")
        @Override
        protected boolean setupStreamAndSendStatus() {
            mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775482794 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_775482794;
            // ---------- Original Method ----------
            //mLoadListener.status(1, 1, mDataStream != null ? 200 : 404, "");
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.986 -0400", hash_original_method = "4179DBF067EB1650CA924A33BC327D3E", hash_generated_method = "F40D4382E035CE6B7715C4D124218C2A")
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

