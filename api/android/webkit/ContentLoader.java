package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.net.Uri;
import android.net.http.EventHandler;
import android.net.http.Headers;





class ContentLoader extends StreamLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.953 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.953 -0400", hash_original_field = "24B8797543549EFE4715ED8CFEFE95BC", hash_generated_field = "1F620CC4F21CDF80833E6AB697F4F4F7")

    private String mContentType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.953 -0400", hash_original_method = "F3A29FB813CE2FB46A21E47C37FE57A3", hash_generated_method = "26E7508488D25213B1E8675E7C066DC3")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.954 -0400", hash_original_method = "3AAB3C35B7568FF6188E6678FD0DC16D", hash_generated_method = "16D3D6B0460565CBF5C41918D1E94EFB")
    private String errString(Exception ex) {
        addTaint(ex.getTaint());
        String exMessage = ex.getMessage();
        String errString = mContext.getString(
                com.android.internal.R.string.httpErrorFileNotFound);
        if(exMessage != null)        
        {
            errString += " " + exMessage;
        } //End block
String varF917352FB1129841F1BC9CC901BB1B99_1366998444 =         errString;
        varF917352FB1129841F1BC9CC901BB1B99_1366998444.addTaint(taint);
        return varF917352FB1129841F1BC9CC901BB1B99_1366998444;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.954 -0400", hash_original_method = "F4E0066B6783A6A372AAD1A4891DEB15", hash_generated_method = "D8BA1115B45DB32F5458454EF6980AFF")
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
            boolean var68934A3E9455FA72420237EB05902327_36787488 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442387956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_442387956;
        } //End block
        try 
        {
            mDataStream = mContext.getContentResolver().openInputStream(uri);
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        catch (java.io.FileNotFoundException ex)
        {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
            boolean var68934A3E9455FA72420237EB05902327_1374280345 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063185637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063185637;
        } //End block
        catch (RuntimeException ex)
        {
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
            boolean var68934A3E9455FA72420237EB05902327_887826909 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_505379787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_505379787;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_7429007 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524556215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524556215;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.954 -0400", hash_original_method = "2D22B97545C25E7E6811FFA13F6C8031", hash_generated_method = "435EAE2EAB5604DA5FDD6019ADE1BF53")
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

