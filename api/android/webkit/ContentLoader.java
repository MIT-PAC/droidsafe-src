package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.net.Uri;

class ContentLoader extends StreamLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.516 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.516 -0400", hash_original_field = "24B8797543549EFE4715ED8CFEFE95BC", hash_generated_field = "1F620CC4F21CDF80833E6AB697F4F4F7")

    private String mContentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.516 -0400", hash_original_method = "F3A29FB813CE2FB46A21E47C37FE57A3", hash_generated_method = "26E7508488D25213B1E8675E7C066DC3")
      ContentLoader(String rawUrl, LoadListener loadListener) {
        super(loadListener);
        addTaint(loadListener.getTaint());
        int mimeIndex = rawUrl.lastIndexOf('?');
    if(mimeIndex != -1)        
        {
            mUrl = rawUrl.substring(0, mimeIndex);
            mContentType = rawUrl.substring(mimeIndex + 1);
        } //End block
        else
        {
            mUrl = rawUrl;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.517 -0400", hash_original_method = "3AAB3C35B7568FF6188E6678FD0DC16D", hash_generated_method = "818D7BE7F855618D231F114C5BA0284E")
    private String errString(Exception ex) {
        addTaint(ex.getTaint());
        String exMessage = ex.getMessage();
        String errString = mContext.getString(
                com.android.internal.R.string.httpErrorFileNotFound);
    if(exMessage != null)        
        {
            errString += " " + exMessage;
        } //End block
String varF917352FB1129841F1BC9CC901BB1B99_821843188 =         errString;
        varF917352FB1129841F1BC9CC901BB1B99_821843188.addTaint(taint);
        return varF917352FB1129841F1BC9CC901BB1B99_821843188;
        // ---------- Original Method ----------
        //String exMessage = ex.getMessage();
        //String errString = mContext.getString(
                //com.android.internal.R.string.httpErrorFileNotFound);
        //if (exMessage != null) {
            //errString += " " + exMessage;
        //}
        //return errString;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.518 -0400", hash_original_method = "F4E0066B6783A6A372AAD1A4891DEB15", hash_generated_method = "D79B9EB63E4973B290E5BE242937502D")
    @Override
    protected boolean setupStreamAndSendStatus() {
        Uri uri = Uri.parse(mUrl);
    if(uri == null)        
        {
            mLoadListener.error(
                    EventHandler.FILE_NOT_FOUND_ERROR,
                    mContext.getString(
                            com.android.internal.R.string.httpErrorBadUrl) +
                    " " + mUrl);
            boolean var68934A3E9455FA72420237EB05902327_864219680 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717452211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_717452211;
        } //End block
        try 
        {
            mDataStream = mContext.getContentResolver().openInputStream(uri);
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        catch (java.io.FileNotFoundException ex)
        {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
            boolean var68934A3E9455FA72420237EB05902327_936547705 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611056609 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611056609;
        } //End block
        catch (RuntimeException ex)
        {
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
            boolean var68934A3E9455FA72420237EB05902327_1978897399 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477215359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477215359;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2008665104 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512103728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512103728;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.518 -0400", hash_original_method = "2D22B97545C25E7E6811FFA13F6C8031", hash_generated_method = "435EAE2EAB5604DA5FDD6019ADE1BF53")
    @Override
    protected void buildHeaders(Headers headers) {
        addTaint(headers.getTaint());
    if(mContentType != null)        
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

