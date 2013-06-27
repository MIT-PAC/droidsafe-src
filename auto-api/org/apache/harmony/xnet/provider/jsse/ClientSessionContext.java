package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;

public class ClientSessionContext extends AbstractSessionContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.664 -0400", hash_original_field = "3FF53BDDBB229917E2937614A224DF58", hash_generated_field = "8D4650520519101820222604BE50C58C")

    Map<HostAndPort, SSLSession> sessionsByHostAndPort = new HashMap<HostAndPort, SSLSession>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.664 -0400", hash_original_field = "AA2F0669D76C361D6298E17FC081F394", hash_generated_field = "312837744C3EC509F2C946202771C82A")

    private SSLClientSessionCache persistentCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.664 -0400", hash_original_method = "6120BD96B39A4004425E377055807D67", hash_generated_method = "F659DA8BD462D7F6605B182211013349")
    public  ClientSessionContext() {
        super(10, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.665 -0400", hash_original_method = "6D75428DC9ADEDF784907D2671C869EF", hash_generated_method = "568232BAE393E4197747FD1B5D62FAF2")
    public int size() {
        int varB5AFB539594923F68E6D16A74F830496_16472051 = (sessionsByHostAndPort.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694375936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694375936;
        // ---------- Original Method ----------
        //return sessionsByHostAndPort.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.665 -0400", hash_original_method = "FA4F1A172590244BE031F2E8797E17F3", hash_generated_method = "A79C5685284AC076EFF257C20CDA7F14")
    public void setPersistentCache(SSLClientSessionCache persistentCache) {
        this.persistentCache = persistentCache;
        // ---------- Original Method ----------
        //this.persistentCache = persistentCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.665 -0400", hash_original_method = "A3E2A8D686FD14337461D9600D56C1BC", hash_generated_method = "E7FA9BD64385CCEE17E86B2E8F32238C")
    protected void sessionRemoved(SSLSession session) {
        String host;
        host = session.getPeerHost();
        int port;
        port = session.getPeerPort();
        HostAndPort hostAndPortKey;
        hostAndPortKey = new HostAndPort(host, port);
        {
            sessionsByHostAndPort.remove(hostAndPortKey);
        } //End block
        addTaint(session.getTaint());
        // ---------- Original Method ----------
        //String host = session.getPeerHost();
        //int port = session.getPeerPort();
        //if (host == null) {
            //return;
        //}
        //HostAndPort hostAndPortKey = new HostAndPort(host, port);
        //synchronized (sessionsByHostAndPort) {
            //sessionsByHostAndPort.remove(hostAndPortKey);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.684 -0400", hash_original_method = "B5A73604CB734A09BF7E857D2D91FD28", hash_generated_method = "DD332665A278BC7F251C06E3ED59981C")
    public SSLSession getSession(String host, int port) {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1300640799 = null; //Variable for return #1
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1312781681 = null; //Variable for return #2
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1071620692 = null; //Variable for return #3
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_972474167 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1300640799 = null;
        } //End block
        SSLSession session;
        HostAndPort hostAndPortKey;
        hostAndPortKey = new HostAndPort(host, port);
        {
            session = sessionsByHostAndPort.get(hostAndPortKey);
        } //End block
        {
            boolean var784A1CDA62AB9B2C753832FCE828B745_241727156 = (session != null && session.isValid());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1312781681 = session;
            } //End block
        } //End collapsed parenthetic
        {
            byte[] data;
            data = persistentCache.getSessionData(host, port);
            {
                session = toSession(data, host, port);
                {
                    boolean varE0B94CD6DB7A63F5969E6C0C96C6CFF0_1962147774 = (session != null && session.isValid());
                    {
                        super.putSession(session);
                        {
                            sessionsByHostAndPort.put(hostAndPortKey, session);
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_1071620692 = session;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_972474167 = null;
        addTaint(host.getTaint());
        addTaint(port);
        SSLSession varA7E53CE21691AB073D9660D615818899_266620547; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_266620547 = varB4EAC82CA7396A68D541C85D26508E83_1300640799;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_266620547 = varB4EAC82CA7396A68D541C85D26508E83_1312781681;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_266620547 = varB4EAC82CA7396A68D541C85D26508E83_1071620692;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_266620547 = varB4EAC82CA7396A68D541C85D26508E83_972474167;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_266620547.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_266620547;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.685 -0400", hash_original_method = "BD633AD4CEEF6AC5498C26DA8E919EC2", hash_generated_method = "FE555A095692CA5A1ADE71334BC6CAA2")
    @Override
    public void putSession(SSLSession session) {
        super.putSession(session);
        String host;
        host = session.getPeerHost();
        int port;
        port = session.getPeerPort();
        HostAndPort hostAndPortKey;
        hostAndPortKey = new HostAndPort(host, port);
        {
            sessionsByHostAndPort.put(hostAndPortKey, session);
        } //End block
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
        //String host = session.getPeerHost();
        //int port = session.getPeerPort();
        //if (host == null) {
            //return;
        //}
        //HostAndPort hostAndPortKey = new HostAndPort(host, port);
        //synchronized (sessionsByHostAndPort) {
            //sessionsByHostAndPort.put(hostAndPortKey, session);
        //}
        //if (persistentCache != null) {
            //byte[] data = toBytes(session);
            //if (data != null) {
                //persistentCache.putSessionData(session, data);
            //}
        //}
    }

    
    static class HostAndPort {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.685 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "3EBF9FC23C14AE1E55EAA4D77C46C987")

        String host;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.685 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "5A948EF636511EF149269A68FE278AED")

        int port;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.685 -0400", hash_original_method = "EB165053DB1A3C349320DF850A0D5A85", hash_generated_method = "84EF2DBC1C64C3B8AF7BCB08B75838B4")
          HostAndPort(String host, int port) {
            this.host = host;
            this.port = port;
            // ---------- Original Method ----------
            //this.host = host;
            //this.port = port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.686 -0400", hash_original_method = "4275ECED88C546D6C48AA6C77D620659", hash_generated_method = "0C5E5AEFA168285B2F5959EDF48C6E35")
        @Override
        public int hashCode() {
            int var7486CBF8614CDB9AEBCF903E96EF526C_2045995541 = (host.hashCode() * 31 + port);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308006655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1308006655;
            // ---------- Original Method ----------
            //return host.hashCode() * 31 + port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.686 -0400", hash_original_method = "B55E1F045FCFEF599209FA0277EB136A", hash_generated_method = "9BB89A52376FB90A2DB2216C2825067E")
        @Override
        public boolean equals(Object o) {
            HostAndPort lhs;
            lhs = (HostAndPort) o;
            boolean var5D96864B593BFC0377F29170A33FCDAC_1237007924 = (host.equals(lhs.host) && port == lhs.port);
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952438110 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_952438110;
            // ---------- Original Method ----------
            //if (!(o instanceof HostAndPort)) {
                //return false;
            //}
            //HostAndPort lhs = (HostAndPort) o;
            //return host.equals(lhs.host) && port == lhs.port;
        }

        
    }


    
}

