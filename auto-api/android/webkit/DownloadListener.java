package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface DownloadListener {

    
    public void onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength);

}
