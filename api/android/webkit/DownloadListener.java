package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface DownloadListener {

    
    public void onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength);

}
