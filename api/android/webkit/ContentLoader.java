package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.net.Uri;
import android.net.http.EventHandler;
import android.net.http.Headers;





class ContentLoader extends StreamLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.108 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")


    private String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.109 -0500", hash_original_field = "608DAE159C1CB591E99EAE76FAB7334E", hash_generated_field = "1F620CC4F21CDF80833E6AB697F4F4F7")

    private String mContentType;

    /**
     * Construct a ContentLoader with the specified content URI
     *
     * @param rawUrl "content:" url pointing to content to be loaded. This url
     *               is the same url passed in to the WebView.
     * @param loadListener LoadListener to pass the content to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.110 -0500", hash_original_method = "F3A29FB813CE2FB46A21E47C37FE57A3", hash_generated_method = "F42B6025FAEC26BD9B34DF75EE222DD4")
    ContentLoader(String rawUrl, LoadListener loadListener) {
        super(loadListener);

        /* strip off mimetype */
        int mimeIndex = rawUrl.lastIndexOf('?');
        if (mimeIndex != -1) {
            mUrl = rawUrl.substring(0, mimeIndex);
            mContentType = rawUrl.substring(mimeIndex + 1);
        } else {
            mUrl = rawUrl;
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.111 -0500", hash_original_method = "3AAB3C35B7568FF6188E6678FD0DC16D", hash_generated_method = "F10BA01B00D1000CE40F9872C037312B")
    private String errString(Exception ex) {
        String exMessage = ex.getMessage();
        String errString = mContext.getString(
                com.android.internal.R.string.httpErrorFileNotFound);
        if (exMessage != null) {
            errString += " " + exMessage;
        }
        return errString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.112 -0500", hash_original_method = "F4E0066B6783A6A372AAD1A4891DEB15", hash_generated_method = "648C62EDB1EA8ED387BC1DA147AEF234")
    @Override
protected boolean setupStreamAndSendStatus() {
        Uri uri = Uri.parse(mUrl);
        if (uri == null) {
            mLoadListener.error(
                    EventHandler.FILE_NOT_FOUND_ERROR,
                    mContext.getString(
                            com.android.internal.R.string.httpErrorBadUrl) +
                    " " + mUrl);
            return false;
        }

        try {
            mDataStream = mContext.getContentResolver().openInputStream(uri);
            mLoadListener.status(1, 1, 200, "OK");
        } catch (java.io.FileNotFoundException ex) {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
            return false;
        } catch (RuntimeException ex) {
            // readExceptionWithFileNotFoundExceptionFromParcel in DatabaseUtils
            // can throw a serial of RuntimeException. Catch them all here.
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.113 -0500", hash_original_method = "2D22B97545C25E7E6811FFA13F6C8031", hash_generated_method = "55C5197379879B1CFEABC611E7F6DFE3")
    @Override
protected void buildHeaders(Headers headers) {
        if (mContentType != null) {
            headers.setContentType("text/html");
        }
        // content can change, we don't want WebKit to cache it
        headers.setCacheControl("no-store, no-cache");
    }

    
}

