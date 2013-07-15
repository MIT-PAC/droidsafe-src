package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface DownloadListener {

    
    public void onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength);

}
