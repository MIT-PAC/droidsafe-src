package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HttpHost;

interface RequestFeeder {

    Request getRequest();
    Request getRequest(HttpHost host);

    
    boolean haveRequest(HttpHost host);

    
    void requeueRequest(Request request);
}
