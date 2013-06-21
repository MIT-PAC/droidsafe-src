package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLSession;

public class ServerSessionContext extends AbstractSessionContext {
    private SSLServerSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.398 -0400", hash_original_method = "9FA739694DBACEAA071D2AEDBA51A05E", hash_generated_method = "519FB45F9A385F0AC73A51E91875A433")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSessionContext() {
        super(100, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.398 -0400", hash_original_method = "72569EA6711DBA1D81D9BBC862AD3D03", hash_generated_method = "374260F2D7A0703A40411421F0DCDE01")
    @DSModeled(DSC.SAFE)
    public void setPersistentCache(SSLServerSessionCache persistentCache) {
        dsTaint.addTaint(persistentCache.dsTaint);
        // ---------- Original Method ----------
        //this.persistentCache = persistentCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.398 -0400", hash_original_method = "D4D4D8A9ED5E99BC7DD197F41DEEDD43", hash_generated_method = "B37C93B0295C0B22A853D4075DC4F5B9")
    @DSModeled(DSC.SAFE)
    protected void sessionRemoved(SSLSession session) {
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.399 -0400", hash_original_method = "B67FD63429286D10E1FBB2A9ED634511", hash_generated_method = "DF02B81209EE9F6FBC2338DE4FA3B55D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLSession getSession(byte[] sessionId) {
        dsTaint.addTaint(sessionId[0]);
        SSLSession session;
        session = super.getSession(sessionId);
        {
            byte[] data;
            data = persistentCache.getSessionData(sessionId);
            {
                session = toSession(data, null, -1);
                {
                    boolean varE0B94CD6DB7A63F5969E6C0C96C6CFF0_1959063729 = (session != null && session.isValid());
                    {
                        super.putSession(session);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SSLSession session = super.getSession(sessionId);
        //if (session != null) {
            //return session;
        //}
        //if (persistentCache != null) {
            //byte[] data = persistentCache.getSessionData(sessionId);
            //if (data != null) {
                //session = toSession(data, null, -1);
                //if (session != null && session.isValid()) {
                    //super.putSession(session);
                    //return session;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.399 -0400", hash_original_method = "6A881248A35D6FEA85AFAE8D9374366B", hash_generated_method = "5FD35AC2DC4E3BF8FBE6E433D98D0248")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void putSession(SSLSession session) {
        dsTaint.addTaint(session.dsTaint);
        super.putSession(session);
        {
            byte[] data;
            data = toBytes(session);
            {
                persistentCache.putSessionData(session, data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.putSession(session);
        //if (persistentCache != null) {
            //byte[] data = toBytes(session);
            //if (data != null) {
                //persistentCache.putSessionData(session, data);
            //}
        //}
    }

    
}

