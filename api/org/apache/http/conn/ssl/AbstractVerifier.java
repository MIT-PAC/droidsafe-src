package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.conn.util.InetAddressUtils;






public abstract class AbstractVerifier implements X509HostnameVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.042 -0400", hash_original_method = "F9761A2E230B965E685AB0F097FC8BA3", hash_generated_method = "B512B82EB5D4AD689C485137CF7AD9E0")
    public  AbstractVerifier() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.042 -0400", hash_original_method = "A023267D72420C341ECC242060C387E3", hash_generated_method = "C7607A7B95325859FF8AC721406D9048")
    public final void verify(String host, SSLSocket ssl) throws IOException {
        addTaint(ssl.getTaint());
        addTaint(host.getTaint());
        if(host == null)        
        {
            NullPointerException var3BB76A6D73CB84B2B487DF16075DE90E_1898120888 = new NullPointerException("host to verify is null");
            var3BB76A6D73CB84B2B487DF16075DE90E_1898120888.addTaint(taint);
            throw var3BB76A6D73CB84B2B487DF16075DE90E_1898120888;
        } //End block
        SSLSession session = ssl.getSession();
        Certificate[] certs = session.getPeerCertificates();
        X509Certificate x509 = (X509Certificate) certs[0];
        verify(host, x509);
        // ---------- Original Method ----------
        //if(host == null) {
            //throw new NullPointerException("host to verify is null");
        //}
        //SSLSession session = ssl.getSession();
        //Certificate[] certs = session.getPeerCertificates();
        //X509Certificate x509 = (X509Certificate) certs[0];
        //verify(host, x509);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.043 -0400", hash_original_method = "43EDB91BF0A5D9A44DF28C7ADED9E98C", hash_generated_method = "C76AB7FF121B2E2F400F083FAE95E4ED")
    public final boolean verify(String host, SSLSession session) {
        addTaint(session.getTaint());
        addTaint(host.getTaint());
        try 
        {
            Certificate[] certs = session.getPeerCertificates();
            X509Certificate x509 = (X509Certificate) certs[0];
            verify(host, x509);
            boolean varB326B5062B2F0E69046810717534CB09_460635515 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763044039 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_763044039;
        } //End block
        catch (SSLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_685923369 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678999619 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_678999619;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Certificate[] certs = session.getPeerCertificates();
            //X509Certificate x509 = (X509Certificate) certs[0];
            //verify(host, x509);
            //return true;
        //}
        //catch(SSLException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.043 -0400", hash_original_method = "08CBAD509C26DA74CD541E0020FFDCD1", hash_generated_method = "DDAC0DADC0C636F9C963A041DE582BB7")
    public final void verify(String host, X509Certificate cert) throws SSLException {
        addTaint(cert.getTaint());
        addTaint(host.getTaint());
        String[] cns = getCNs(cert);
        String[] subjectAlts = getDNSSubjectAlts(cert);
        verify(host, cns, subjectAlts);
        // ---------- Original Method ----------
        //String[] cns = getCNs(cert);
        //String[] subjectAlts = getDNSSubjectAlts(cert);
        //verify(host, cns, subjectAlts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.044 -0400", hash_original_method = "9A07FB90ABAE18EA37F4E80ACC04FEE0", hash_generated_method = "7CF5308918796D5B9A9677F59D477CAE")
    public final void verify(final String host, final String[] cns,
                             final String[] subjectAlts,
                             final boolean strictWithSubDomains) throws SSLException {
        addTaint(strictWithSubDomains);
        addTaint(subjectAlts[0].getTaint());
        addTaint(cns[0].getTaint());
        addTaint(host.getTaint());
        LinkedList<String> names = new LinkedList<String>();
        if(cns != null && cns.length > 0 && cns[0] != null)        
        {
            names.add(cns[0]);
        } //End block
        if(subjectAlts != null)        
        {
for(String subjectAlt : subjectAlts)
            {
                if(subjectAlt != null)                
                {
                    names.add(subjectAlt);
                } //End block
            } //End block
        } //End block
        if(names.isEmpty())        
        {
            String msg = "Certificate for <" + host + "> doesn't contain CN or DNS subjectAlt";
            SSLException var0BFA7FEBA6B92E90F4D898F185A2E909_1182124527 = new SSLException(msg);
            var0BFA7FEBA6B92E90F4D898F185A2E909_1182124527.addTaint(taint);
            throw var0BFA7FEBA6B92E90F4D898F185A2E909_1182124527;
        } //End block
        StringBuffer buf = new StringBuffer();
        String hostName = host.trim().toLowerCase(Locale.ENGLISH);
        boolean match = false;
for(Iterator<String> it = names.iterator();it.hasNext();)
        {
            String cn = it.next();
            cn = cn.toLowerCase(Locale.ENGLISH);
            buf.append(" <");
            buf.append(cn);
            buf.append('>');
            if(it.hasNext())            
            {
                buf.append(" OR");
            } //End block
            boolean doWildcard = cn.startsWith("*.") &&
                                 cn.indexOf('.', 2) != -1 &&
                                 acceptableCountryWildcard(cn) &&
                                 !InetAddressUtils.isIPv4Address(host);
            if(doWildcard)            
            {
                match = hostName.endsWith(cn.substring(1));
                if(match && strictWithSubDomains)                
                {
                    match = countDots(hostName) == countDots(cn);
                } //End block
            } //End block
            else
            {
                match = hostName.equals(cn);
            } //End block
            if(match)            
            {
                break;
            } //End block
        } //End block
        if(!match)        
        {
            SSLException var69568A3CBCF7D574078C6D84DF2EC977_2106581592 = new SSLException("hostname in certificate didn't match: <" + host + "> !=" + buf);
            var69568A3CBCF7D574078C6D84DF2EC977_2106581592.addTaint(taint);
            throw var69568A3CBCF7D574078C6D84DF2EC977_2106581592;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean acceptableCountryWildcard(String cn) {
        int cnLen = cn.length();
        if(cnLen >= 7 && cnLen <= 9) {
            if(cn.charAt(cnLen - 3) == '.') {
                String s = cn.substring(2, cnLen - 3);
                int x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                return x < 0;
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SPEC)
    public static String[] getCNs(X509Certificate cert) {
        LinkedList<String> cnList = new LinkedList<String>();
        String subjectPrincipal = cert.getSubjectX500Principal().toString();
        StringTokenizer st = new StringTokenizer(subjectPrincipal, ",");
        while(st.hasMoreTokens()) {
            String tok = st.nextToken();
            int x = tok.indexOf("CN=");
            if(x >= 0) {
                cnList.add(tok.substring(x + 3));
            }
        }
        if(!cnList.isEmpty()) {
            String[] cns = new String[cnList.size()];
            cnList.toArray(cns);
            return cns;
        } else {
            return null;
        }
    }

    
    public static String[] getDNSSubjectAlts(X509Certificate cert) {
        LinkedList<String> subjectAltList = new LinkedList<String>();
        Collection<List<?>> c = null;
        try {
            c = cert.getSubjectAlternativeNames();
        }
        catch(CertificateParsingException cpe) {
            Logger.getLogger(AbstractVerifier.class.getName())
                    .log(Level.FINE, "Error parsing certificate.", cpe);
        }
        if(c != null) {
            for (List<?> aC : c) {
                List<?> list = aC;
                int type = ((Integer) list.get(0)).intValue();
                if (type == 2) {
                    String s = (String) list.get(1);
                    subjectAltList.add(s);
                }
            }
        }
        if(!subjectAltList.isEmpty()) {
            String[] subjectAlts = new String[subjectAltList.size()];
            subjectAltList.toArray(subjectAlts);
            return subjectAlts;
        } else {
            return null;
        }
    }

    
    public static int countDots(final String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                count++;
            }
        }
        return count;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.046 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "6968AEDC2C31A50F6ADB7A7EFEF7EBAD")

    private final static String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
}

