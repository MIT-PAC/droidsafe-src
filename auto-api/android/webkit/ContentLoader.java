package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.net.Uri;

class ContentLoader extends StreamLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.156 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.156 -0400", hash_original_field = "24B8797543549EFE4715ED8CFEFE95BC", hash_generated_field = "1F620CC4F21CDF80833E6AB697F4F4F7")

    private String mContentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.156 -0400", hash_original_method = "F3A29FB813CE2FB46A21E47C37FE57A3", hash_generated_method = "A73660614356C696083C8417D58BD29A")
      ContentLoader(String rawUrl, LoadListener loadListener) {
        super(loadListener);
        int mimeIndex = rawUrl.lastIndexOf('?');
        {
            mUrl = rawUrl.substring(0, mimeIndex);
            mContentType = rawUrl.substring(mimeIndex + 1);
        } //End block
        {
            mUrl = rawUrl;
        } //End block
        addTaint(loadListener.getTaint());
        // ---------- Original Method ----------
        //int mimeIndex = rawUrl.lastIndexOf('?');
        //if (mimeIndex != -1) {
            //mUrl = rawUrl.substring(0, mimeIndex);
            //mContentType = rawUrl.substring(mimeIndex + 1);
        //} else {
            //mUrl = rawUrl;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.157 -0400", hash_original_method = "3AAB3C35B7568FF6188E6678FD0DC16D", hash_generated_method = "CCF53FD2E6514D45D97AFD28EA9E38E5")
    private String errString(Exception ex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1532215145 = null; //Variable for return #1
        String exMessage = ex.getMessage();
        String errString = mContext.getString(
                com.android.internal.R.string.httpErrorFileNotFound);
        {
            errString += " " + exMessage;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1532215145 = errString;
        addTaint(ex.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1532215145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532215145;
        // ---------- Original Method ----------
        //String exMessage = ex.getMessage();
        //String errString = mContext.getString(
                //com.android.internal.R.string.httpErrorFileNotFound);
        //if (exMessage != null) {
            //errString += " " + exMessage;
        //}
        //return errString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.158 -0400", hash_original_method = "F4E0066B6783A6A372AAD1A4891DEB15", hash_generated_method = "056FB992B575CE92C7954963D72E59DD")
    @Override
    protected boolean setupStreamAndSendStatus() {
        Uri uri = Uri.parse(mUrl);
        {
            mLoadListener.error(
                    EventHandler.FILE_NOT_FOUND_ERROR,
                    mContext.getString(
                            com.android.internal.R.string.httpErrorBadUrl) +
                    " " + mUrl);
        } //End block
        try 
        {
            mDataStream = mContext.getContentResolver().openInputStream(uri);
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        catch (java.io.FileNotFoundException ex)
        {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
        } //End block
        catch (RuntimeException ex)
        {
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1466534015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1466534015;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.158 -0400", hash_original_method = "2D22B97545C25E7E6811FFA13F6C8031", hash_generated_method = "243475B0997091CBFEB654AA492D6984")
    @Override
    protected void buildHeaders(Headers headers) {
        {
            headers.setContentType("text/html");
        } //End block
        headers.setCacheControl("no-store, no-cache");
        addTaint(headers.getTaint());
        // ---------- Original Method ----------
        //if (mContentType != null) {
            //headers.setContentType("text/html");
        //}
        //headers.setCacheControl("no-store, no-cache");
    }

    
}

