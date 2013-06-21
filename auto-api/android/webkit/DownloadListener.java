package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface DownloadListener {

    
    public void onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength);

}
