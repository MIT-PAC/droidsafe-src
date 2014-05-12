package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;

import libcore.util.EmptyArray;

public final class SSLSessionImpl implements SSLSession, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.196 -0500", hash_original_field = "5BCA2038B74699E0EF29DA83147E23C8", hash_generated_field = "4097B493A1663D0BA471C72A0F0B7465")

    public static final SSLSessionImpl NULL_SESSION = new SSLSessionImpl(null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.198 -0500", hash_original_field = "9D5259E44721BAC80FAB5E719998510B", hash_generated_field = "8A4271AF76CEF8B5667B49A4D9A7868D")

    private long creationTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.201 -0500", hash_original_field = "FFFCC50D3A278EF95DEB022E99DE2B21", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.203 -0500", hash_original_field = "5572873E708318B5BCB1211CAFB42224", hash_generated_field = "9D0FE98D3FB5DD14BD6D5D1B013768C8")

    private final Map<String, Object> values = new HashMap<String, Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.205 -0500", hash_original_field = "90A5D328FD00C6FE5EBB6109B912317E", hash_generated_field = "90A5D328FD00C6FE5EBB6109B912317E")

    byte[] id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.207 -0500", hash_original_field = "C69F06F47E4978627AC3DF239BEBA6F7", hash_generated_field = "C69F06F47E4978627AC3DF239BEBA6F7")

    long lastAccessedTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.209 -0500", hash_original_field = "47A36952B8C6C23935E0D010B5EDBA00", hash_generated_field = "47A36952B8C6C23935E0D010B5EDBA00")

    ProtocolVersion protocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.211 -0500", hash_original_field = "7A3E5BBFBB21F28A5ECA0047133B26EF", hash_generated_field = "7A3E5BBFBB21F28A5ECA0047133B26EF")

    CipherSuite cipherSuite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.213 -0500", hash_original_field = "7CFAD181A1CAE73DBA9CB5F6589A0B7B", hash_generated_field = "7CFAD181A1CAE73DBA9CB5F6589A0B7B")

    SSLSessionContext context;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.216 -0500", hash_original_field = "32A66D390E195F822A847B8B4CE21F22", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.218 -0500", hash_original_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.220 -0500", hash_original_field = "C33A347C63CF676DBDFD0CCC029E433E", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.223 -0500", hash_original_field = "B3622AB429836A8D09D8B344FA643F7F", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.225 -0500", hash_original_field = "02F423993F3653EC8EA2F9443B12F112", hash_generated_field = "02F423993F3653EC8EA2F9443B12F112")

    byte[] master_secret;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.227 -0500", hash_original_field = "F56FE881C825B7CD93F8A0F7E04073D2", hash_generated_field = "F56FE881C825B7CD93F8A0F7E04073D2")

    byte[] clientRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.229 -0500", hash_original_field = "1A7A7530C9D8C2184F28723319A6FF4F", hash_generated_field = "1A7A7530C9D8C2184F28723319A6FF4F")

    byte[] serverRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.231 -0500", hash_original_field = "0B1F63DBE702DEAA610286811BDE9119", hash_generated_field = "0B1F63DBE702DEAA610286811BDE9119")

     boolean isServer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.234 -0500", hash_original_method = "8B77818B34D277F665DFA23ABC8DBC5D", hash_generated_method = "69FE77E307CF580F3A22AD2A5BC1B8FE")
    
public SSLSessionImpl(CipherSuite cipher_suite, SecureRandom secureRandom) {
        creationTime = System.currentTimeMillis();
        lastAccessedTime = creationTime;
        if (cipher_suite == null) {
            this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            id = EmptyArray.BYTE;
            isServer = false;
            isValid = false;
        } else {
            this.cipherSuite = cipher_suite;
            id = new byte[32];
            secureRandom.nextBytes(id);
            long time = creationTime / 1000;
            id[28] = (byte) ((time & 0xFF000000) >>> 24);
            id[29] = (byte) ((time & 0x00FF0000) >>> 16);
            id[30] = (byte) ((time & 0x0000FF00) >>> 8);
            id[31] = (byte) ((time & 0x000000FF));
            isServer = true;
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.237 -0500", hash_original_method = "6D9F19E2EE775580BB96A397C59A5AA5", hash_generated_method = "680392CDA41386CD426D9080DBA70C46")
    
public SSLSessionImpl(SecureRandom secureRandom) {
        this(null, secureRandom);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.239 -0500", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "E81B1F1B3E4F15AAEFD04FB4DC689CD7")
    
public int getApplicationBufferSize() {
        return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.242 -0500", hash_original_method = "745D2790D3F85591FE85537A877B7167", hash_generated_method = "8891BB909A2665C5100EE699C9A3740E")
    
public String getCipherSuite() {
        return cipherSuite.getName();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.245 -0500", hash_original_method = "09A0842085DDEEEFFBE4843237FA7655", hash_generated_method = "7DEB74E1D764C57E44EE034B9B835D12")
    
public long getCreationTime() {
        return creationTime;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.247 -0500", hash_original_method = "6FF1AD4C2D68C6B37F5B643FEDAC8BE4", hash_generated_method = "B223273CBB754C3FB9FBC8DEC4A4206A")
    
public byte[] getId() {
        return id;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.249 -0500", hash_original_method = "79FEA1654BACC0D1C8F52D94037731AA", hash_generated_method = "6DFC80835F49DDA5791AE8053CB92D87")
    
public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.251 -0500", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "DCB7B96357BAC93BE08BBFECA9CC1109")
    
public Certificate[] getLocalCertificates() {
        return localCertificates;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.253 -0500", hash_original_method = "458F509C66510A71C33EE842436FD9CE", hash_generated_method = "2B6E9DADD5D6D7C75712693A8A512635")
    
public Principal getLocalPrincipal() {
        if (localCertificates != null && localCertificates.length > 0) {
            return localCertificates[0].getSubjectX500Principal();
        }
        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.255 -0500", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "49066EE1ED41F2667BDAEB4A3668CF26")
    
public int getPacketBufferSize() {
        return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.258 -0500", hash_original_method = "671707B73FC0A29660C8CE2F332B40EC", hash_generated_method = "288E7D4E06864EE860F887F0A880D2AB")
    
public javax.security.cert.X509Certificate[] getPeerCertificateChain()
            throws SSLPeerUnverifiedException {
        if (peerCertificates == null) {
            throw new SSLPeerUnverifiedException("No peer certificate");
        }
        javax.security.cert.X509Certificate[] certs = new javax.security.cert.X509Certificate[peerCertificates.length];
        for (int i = 0; i < certs.length; i++) {
            try {
                certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        .getEncoded());
            } catch (javax.security.cert.CertificateException ignored) {
            } catch (CertificateEncodingException ignored) {
            }
        }
        return certs;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.261 -0500", hash_original_method = "3CCB3131DE484F2F007F820172400088", hash_generated_method = "E59CD2B0702118D0F4B0D2F8423212E5")
    
public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        if (peerCertificates == null) {
            throw new SSLPeerUnverifiedException("No peer certificate");
        }
        return peerCertificates;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.263 -0500", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "B884ECED502456841527EC5FB85A2015")
    
public String getPeerHost() {
        return peerHost;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.265 -0500", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "0A13911FE5FD34A377B4DEB23C492969")
    
public int getPeerPort() {
        return peerPort;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.268 -0500", hash_original_method = "B290FEA54ECCBD8C8D1AB720544591AB", hash_generated_method = "D1BE035341DD91FC202CAF4DF4D271BD")
    
public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if (peerCertificates == null) {
            throw new SSLPeerUnverifiedException("No peer certificate");
        }
        return peerCertificates[0].getSubjectX500Principal();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.270 -0500", hash_original_method = "70FFC4864CFD3FC7BC69978E71944D24", hash_generated_method = "71F58FEB7D20DFC654CB9FACA0B6120B")
    
public String getProtocol() {
        return (protocol == null) ? "NONE" : protocol.name;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.272 -0500", hash_original_method = "E54F5411F9B3E4DD60F47670618D45C7", hash_generated_method = "54AA719FEBF681696927ED26D7C9E3D3")
    
public SSLSessionContext getSessionContext() {
        return context;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.274 -0500", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "482A1EBBD4ADC2D29BC2576BF219C8BF")
    
public Object getValue(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name == null");
        }
        return values.get(name);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.277 -0500", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "212BEDE870CA0A8C4B9BA72912F392CA")
    
public String[] getValueNames() {
        return values.keySet().toArray(new String[values.size()]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.279 -0500", hash_original_method = "81658CAC0BD01D20DC226803375A1EFC", hash_generated_method = "C9FA146E501DB2B2BBD5D72F07CB6A4E")
    
public void invalidate() {
        isValid = false;
        context = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.281 -0500", hash_original_method = "901AA8BB3AAD61331954CF916345412F", hash_generated_method = "7C8A76222906ECE930E5263872E26F82")
    
public boolean isValid() {
        if (isValid && context != null && context.getSessionTimeout() != 0
                && lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis()) {
            isValid = false;
        }
        return isValid;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.285 -0500", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "3D28D4DAA15DA59E1E198C43B216F883")
    
public void putValue(String name, Object value) {
        if (name == null || value == null) {
            throw new IllegalArgumentException("name == null || value == null");
        }
        Object old = values.put(name, value);
        if (value instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        }
        if (old instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.287 -0500", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "C1F063A87C38C41A8C0646FAC8DC1A82")
    
public void removeValue(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name == null");
        }
        Object old = values.remove(name);
        if (old instanceof SSLSessionBindingListener) {
            SSLSessionBindingListener listener = (SSLSessionBindingListener) old;
            listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.290 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.292 -0500", hash_original_method = "1B64858E0F9CF91B520A55B4E94E3F8D", hash_generated_method = "1B64858E0F9CF91B520A55B4E94E3F8D")
    
void setPeer(String peerHost, int peerPort) {
        this.peerHost = peerHost;
        this.peerPort = peerPort;
    }
}

