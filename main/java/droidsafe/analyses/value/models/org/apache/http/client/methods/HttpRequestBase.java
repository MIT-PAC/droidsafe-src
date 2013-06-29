package droidsafe.analyses.value.models.org.apache.http.client.methods;

//import java.io.IOException;

//import org.apache.http.ProtocolVersion;
//import org.apache.http.RequestLine;
//import org.apache.http.conn.ClientConnectionRequest;
//import org.apache.http.conn.ConnectionReleaseTrigger;

import soot.jimple.spark.pag.AllocNode;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.models.java.net.URI;

public abstract class HttpRequestBase extends ValueAnalysisModeledObject {

    private URI uri;

    public HttpRequestBase(AllocNode allocNode) {
        super(allocNode);
    }

    public void _init_() {
        /*
        super();
        this.abortLock = new ReentrantLock();
        */
    }

    /**
     * Returns the original request URI.
     * <p>
     * Please note URI remains unchanged in the course of request execution and
     * is not updated if the request is redirected to another location.
     */
    public URI getURI() {
        return this.uri;
    }

    public void setURI(final URI uri) {
        this.uri = uri;
    }

//    public ProtocolVersion getProtocolVersion() {
//        invalidate();
//        return null;
//        /*
//        return HttpProtocolParams.getVersion(getParams());
//        */
//    }
//
//    public RequestLine getRequestLine() {
//        invalidate();
//        return null;
//        /*
//        String method = getMethod();
//        ProtocolVersion ver = getProtocolVersion();
//        URI uri = getURI();
//        String uritext = null;
//        if (uri != null) {
//            uritext = uri.toASCIIString();
//        }
//        if (uritext == null || uritext.length() == 0) {
//            uritext = "/";
//        }
//        return new BasicRequestLine(method, uritext, ver);
//        */
//    }
//
//    public void setConnectionRequest(final ClientConnectionRequest connRequest) throws IOException {
//        invalidate();
//        /*
//        this.abortLock.lock();
//        try {
//            if (this.aborted) {
//                throw new IOException("Request already aborted");
//            }
//
//            this.releaseTrigger = null;
//            this.connRequest = connRequest;
//        } finally {
//            this.abortLock.unlock();
//        }
//        */
//    }
//
//    public void setReleaseTrigger(final ConnectionReleaseTrigger releaseTrigger) throws IOException {
//        invalidate();
//        /*
//        this.abortLock.lock();
//        try {
//            if (this.aborted) {
//                throw new IOException("Request already aborted");
//            }
//
//            this.connRequest = null;
//            this.releaseTrigger = releaseTrigger;
//        } finally {
//            this.abortLock.unlock();
//        }
//        */
//    }
//
//    public void abort() {
//        invalidate();
//        /*
//        ClientConnectionRequest localRequest;
//        ConnectionReleaseTrigger localTrigger;
//
//        this.abortLock.lock();
//        try {
//            if (this.aborted) {
//                return;
//            }
//            this.aborted = true;
//
//            localRequest = connRequest;
//            localTrigger = releaseTrigger;
//        } finally {
//            this.abortLock.unlock();
//        }
//
//        // Trigger the callbacks outside of the lock, to prevent
//        // deadlocks in the scenario where the callbacks have
//        // their own locks that may be used while calling
//        // setReleaseTrigger or setConnectionRequest.
//        if (localRequest != null) {
//            localRequest.abortRequest();
//        }
//        if (localTrigger != null) {
//            try {
//                localTrigger.abortConnection();
//            } catch (IOException ex) {
//                // ignore
//            }
//        }
//        */
//    }
//
//    public boolean isAborted() {
//        invalidate();
//        return false;
//        /*
//        return this.aborted;
//        */
//    }
//
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        invalidate();
//        return null;
//        /*
//        HttpRequestBase clone = (HttpRequestBase) super.clone();
//        clone.abortLock = new ReentrantLock();
//        clone.aborted = false;
//        clone.releaseTrigger = null;
//        clone.connRequest = null;
//        clone.headergroup = (HeaderGroup) CloneUtils.clone(this.headergroup);
//        clone.params = (HttpParams) CloneUtils.clone(this.params);
//        return clone;
//        */
//    }
}
