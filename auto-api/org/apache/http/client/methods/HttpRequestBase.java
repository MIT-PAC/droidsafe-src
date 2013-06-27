package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public abstract class HttpRequestBase extends AbstractHttpMessage implements HttpUriRequest, AbortableHttpRequest, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.980 -0400", hash_original_field = "10FCE3ACD248786FEA19D4FD8EF82936", hash_generated_field = "44B412448D230F2FF1F66097B168F5A5")

    private Lock abortLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.980 -0400", hash_original_field = "DFB7069BFC6E0064A6C667626ECA07B4", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.980 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.981 -0400", hash_original_field = "FAFFE38284DD03831134F3DCA5636A97", hash_generated_field = "9BD569E8B5A75FB995CED8041D010CC7")

    private ClientConnectionRequest connRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.981 -0400", hash_original_field = "1D2148D46F6E571FED3D27C9091F509B", hash_generated_field = "67B34A5893107F972D9958340D6670E2")

    private ConnectionReleaseTrigger releaseTrigger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.984 -0400", hash_original_method = "F072003D9D59EEA9F49CAFB14589B2C0", hash_generated_method = "CB3BE9D25173B20027CFD7818BE8A532")
    public  HttpRequestBase() {
        super();
        this.abortLock = new ReentrantLock();
        // ---------- Original Method ----------
        //this.abortLock = new ReentrantLock();
    }

    
    public abstract String getMethod();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.996 -0400", hash_original_method = "E43BB65B6EAF4E56B5A8181704221BD7", hash_generated_method = "6047627D69EF23BA45A8C2F71A81A6E6")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1122022941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1122022941 = HttpProtocolParams.getVersion(getParams());
        varB4EAC82CA7396A68D541C85D26508E83_1122022941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1122022941;
        // ---------- Original Method ----------
        //return HttpProtocolParams.getVersion(getParams());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.996 -0400", hash_original_method = "548D933490D1B58733888D02043A11B0", hash_generated_method = "26D525B599451D4833C0049CD107860E")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1441710706 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1441710706 = this.uri;
        varB4EAC82CA7396A68D541C85D26508E83_1441710706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441710706;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.997 -0400", hash_original_method = "93E6AFEE57EFDA4898CAE2DF347D0D02", hash_generated_method = "08E265020F8BB90D134CDB44F29F1A85")
    public RequestLine getRequestLine() {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_705032335 = null; //Variable for return #1
        String method;
        method = getMethod();
        ProtocolVersion ver;
        ver = getProtocolVersion();
        URI uri;
        uri = getURI();
        String uritext;
        uritext = null;
        {
            uritext = uri.toASCIIString();
        } //End block
        {
            boolean var03A1675A35EE77EC28D14B979DA97E09_343651725 = (uritext == null || uritext.length() == 0);
            {
                uritext = "/";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_705032335 = new BasicRequestLine(method, uritext, ver);
        varB4EAC82CA7396A68D541C85D26508E83_705032335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705032335;
        // ---------- Original Method ----------
        //String method = getMethod();
        //ProtocolVersion ver = getProtocolVersion();
        //URI uri = getURI();
        //String uritext = null;
        //if (uri != null) {
            //uritext = uri.toASCIIString();
        //}
        //if (uritext == null || uritext.length() == 0) {
            //uritext = "/";
        //}
        //return new BasicRequestLine(method, uritext, ver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.002 -0400", hash_original_method = "3320A765B2CE48350AC27D9599EAC026", hash_generated_method = "C72876729647E8A3A80A7FBC268F56B2")
    public void setURI(final URI uri) {
        this.uri = uri;
        // ---------- Original Method ----------
        //this.uri = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.003 -0400", hash_original_method = "AD26D5D661F235A4EA5BC460121EF4B1", hash_generated_method = "CC53BAE5392A5B5F8D09A1A3FBDD1DAD")
    public void setConnectionRequest(final ClientConnectionRequest connRequest) throws IOException {
        this.abortLock.lock();
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Request already aborted");
            } //End block
            this.releaseTrigger = null;
            this.connRequest = connRequest;
        } //End block
        finally 
        {
            this.abortLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //this.abortLock.lock();
        //try {
            //if (this.aborted) {
                //throw new IOException("Request already aborted");
            //}
            //this.releaseTrigger = null;
            //this.connRequest = connRequest;
        //} finally {
            //this.abortLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.003 -0400", hash_original_method = "F06B06B54565935399EE76A02EF85A84", hash_generated_method = "71541D50C2A7ECA8F5A09F2CDEBE1432")
    public void setReleaseTrigger(final ConnectionReleaseTrigger releaseTrigger) throws IOException {
        this.abortLock.lock();
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Request already aborted");
            } //End block
            this.connRequest = null;
            this.releaseTrigger = releaseTrigger;
        } //End block
        finally 
        {
            this.abortLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //this.abortLock.lock();
        //try {
            //if (this.aborted) {
                //throw new IOException("Request already aborted");
            //}
            //this.connRequest = null;
            //this.releaseTrigger = releaseTrigger;
        //} finally {
            //this.abortLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.004 -0400", hash_original_method = "DAE61D1D90E50FDB083EDE1BB1F7240A", hash_generated_method = "39B5294C93A96E696DC9CB0E4440C3C9")
    public void abort() {
        ClientConnectionRequest localRequest;
        ConnectionReleaseTrigger localTrigger;
        this.abortLock.lock();
        try 
        {
            this.aborted = true;
            localRequest = connRequest;
            localTrigger = releaseTrigger;
        } //End block
        finally 
        {
            this.abortLock.unlock();
        } //End block
        {
            localRequest.abortRequest();
        } //End block
        {
            try 
            {
                localTrigger.abortConnection();
            } //End block
            catch (IOException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        //ClientConnectionRequest localRequest;
        //ConnectionReleaseTrigger localTrigger;
        //this.abortLock.lock();
        //try {
            //if (this.aborted) {
                //return;
            //}            
            //this.aborted = true;
            //localRequest = connRequest;
            //localTrigger = releaseTrigger;
        //} finally {
            //this.abortLock.unlock();
        //}
        //if (localRequest != null) {
            //localRequest.abortRequest();
        //}
        //if (localTrigger != null) {
            //try {
                //localTrigger.abortConnection();
            //} catch (IOException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.011 -0400", hash_original_method = "2E6315A95F3ECC29CFD4A6E95CF920AD", hash_generated_method = "70AA2816A7718BF4E6A71E2239626300")
    public boolean isAborted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101388;
        // ---------- Original Method ----------
        //return this.aborted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.018 -0400", hash_original_method = "7E78C92898A9406CD028D56B8CBA9D93", hash_generated_method = "D5AE0B88763DE0663759ED860852D445")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_646995989 = null; //Variable for return #1
        HttpRequestBase clone;
        clone = (HttpRequestBase) super.clone();
        clone.abortLock = new ReentrantLock();
        clone.aborted = false;
        clone.releaseTrigger = null;
        clone.connRequest = null;
        clone.headergroup = (HeaderGroup) CloneUtils.clone(this.headergroup);
        clone.params = (HttpParams) CloneUtils.clone(this.params);
        varB4EAC82CA7396A68D541C85D26508E83_646995989 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_646995989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_646995989;
        // ---------- Original Method ----------
        //HttpRequestBase clone = (HttpRequestBase) super.clone();
        //clone.abortLock = new ReentrantLock();
        //clone.aborted = false;
        //clone.releaseTrigger = null;
        //clone.connRequest = null;
        //clone.headergroup = (HeaderGroup) CloneUtils.clone(this.headergroup);
        //clone.params = (HttpParams) CloneUtils.clone(this.params);
        //return clone;
    }

    
}

