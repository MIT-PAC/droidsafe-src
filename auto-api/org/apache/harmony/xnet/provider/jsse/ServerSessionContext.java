package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLSession;

public class ServerSessionContext extends AbstractSessionContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.122 -0400", hash_original_field = "AA2F0669D76C361D6298E17FC081F394", hash_generated_field = "03372E20A94CFEB28F0443462F1FB862")

    private SSLServerSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.122 -0400", hash_original_method = "9FA739694DBACEAA071D2AEDBA51A05E", hash_generated_method = "519FB45F9A385F0AC73A51E91875A433")
    public  ServerSessionContext() {
        super(100, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.122 -0400", hash_original_method = "72569EA6711DBA1D81D9BBC862AD3D03", hash_generated_method = "98DC823E6DF5392957E496FAD00FA2DE")
    public void setPersistentCache(SSLServerSessionCache persistentCache) {
        this.persistentCache = persistentCache;
        // ---------- Original Method ----------
        //this.persistentCache = persistentCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.123 -0400", hash_original_method = "D4D4D8A9ED5E99BC7DD197F41DEEDD43", hash_generated_method = "16DEE84B347D7E24654B9D4FF767833A")
    protected void sessionRemoved(SSLSession session) {
        addTaint(session.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.123 -0400", hash_original_method = "B67FD63429286D10E1FBB2A9ED634511", hash_generated_method = "5E3091FA0108F77BCFB2B00F521A505B")
    @Override
    public SSLSession getSession(byte[] sessionId) {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_278484878 = null; //Variable for return #1
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1951492654 = null; //Variable for return #2
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_184095493 = null; //Variable for return #3
        SSLSession session;
        session = super.getSession(sessionId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_278484878 = session;
        } //End block
        {
            byte[] data;
            data = persistentCache.getSessionData(sessionId);
            {
                session = toSession(data, null, -1);
                {
                    boolean varE0B94CD6DB7A63F5969E6C0C96C6CFF0_1697954867 = (session != null && session.isValid());
                    {
                        super.putSession(session);
                        varB4EAC82CA7396A68D541C85D26508E83_1951492654 = session;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_184095493 = null;
        addTaint(sessionId[0]);
        SSLSession varA7E53CE21691AB073D9660D615818899_183226947; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_183226947 = varB4EAC82CA7396A68D541C85D26508E83_278484878;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_183226947 = varB4EAC82CA7396A68D541C85D26508E83_1951492654;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_183226947 = varB4EAC82CA7396A68D541C85D26508E83_184095493;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_183226947.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_183226947;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.124 -0400", hash_original_method = "6A881248A35D6FEA85AFAE8D9374366B", hash_generated_method = "D021B228F915C1A8FAD61E4D9F129ED0")
    @Override
     void putSession(SSLSession session) {
        super.putSession(session);
        {
            byte[] data;
            data = toBytes(session);
            {
                persistentCache.putSessionData(session, data);
            } //End block
        } //End block
        addTaint(session.getTaint());
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

