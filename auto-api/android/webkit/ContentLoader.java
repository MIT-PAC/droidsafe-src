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
    private String mUrl;
    private String mContentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.944 -0400", hash_original_method = "F3A29FB813CE2FB46A21E47C37FE57A3", hash_generated_method = "C85E24B55D260A04F5E7B1EBFFA6B7A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ContentLoader(String rawUrl, LoadListener loadListener) {
        super(loadListener);
        dsTaint.addTaint(rawUrl);
        dsTaint.addTaint(loadListener.dsTaint);
        int mimeIndex;
        mimeIndex = rawUrl.lastIndexOf('?');
        {
            mUrl = rawUrl.substring(0, mimeIndex);
            mContentType = rawUrl.substring(mimeIndex + 1);
        } //End block
        // ---------- Original Method ----------
        //int mimeIndex = rawUrl.lastIndexOf('?');
        //if (mimeIndex != -1) {
            //mUrl = rawUrl.substring(0, mimeIndex);
            //mContentType = rawUrl.substring(mimeIndex + 1);
        //} else {
            //mUrl = rawUrl;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.945 -0400", hash_original_method = "3AAB3C35B7568FF6188E6678FD0DC16D", hash_generated_method = "D4CC29C5662154B8DFC505E942877E5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String errString(Exception ex) {
        dsTaint.addTaint(ex.dsTaint);
        String exMessage;
        exMessage = ex.getMessage();
        String errString;
        errString = mContext.getString(
                com.android.internal.R.string.httpErrorFileNotFound);
        {
            errString += " " + exMessage;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String exMessage = ex.getMessage();
        //String errString = mContext.getString(
                //com.android.internal.R.string.httpErrorFileNotFound);
        //if (exMessage != null) {
            //errString += " " + exMessage;
        //}
        //return errString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.945 -0400", hash_original_method = "F4E0066B6783A6A372AAD1A4891DEB15", hash_generated_method = "02B00E2DDD68270300F7C567A7DC1DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setupStreamAndSendStatus() {
        Uri uri;
        uri = Uri.parse(mUrl);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.946 -0400", hash_original_method = "2D22B97545C25E7E6811FFA13F6C8031", hash_generated_method = "3A272E2238369E00EC8C7FE40658A712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void buildHeaders(Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        {
            headers.setContentType("text/html");
        } //End block
        headers.setCacheControl("no-store, no-cache");
        // ---------- Original Method ----------
        //if (mContentType != null) {
            //headers.setContentType("text/html");
        //}
        //headers.setCacheControl("no-store, no-cache");
    }

    
}

