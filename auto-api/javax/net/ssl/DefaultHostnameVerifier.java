package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class DefaultHostnameVerifier implements HostnameVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.036 -0400", hash_original_method = "4A6F398602E5F38CEFB0B6BC8CB5C447", hash_generated_method = "4A6F398602E5F38CEFB0B6BC8CB5C447")
        public DefaultHostnameVerifier ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.039 -0400", hash_original_method = "648595920530E4C54EAA991A797FC9D5", hash_generated_method = "482C718CECAF153187DC2D5C44C3CD8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean verify(String host, SSLSession session) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(session.dsTaint);
        Certificate[] certs;
        try 
        {
            certs = session.getPeerCertificates();
        } //End block
        catch (SSLException e)
        { }
        X509Certificate x509;
        x509 = (X509Certificate) certs[0];
        String hostName;
        hostName = host.trim().toLowerCase(Locale.ENGLISH);
        String firstCn;
        firstCn = getFirstCn(x509);
        {
            boolean var29EDEFEF2843435DB2D9ED7F0A830B4A_1846113672 = (matches(hostName, firstCn));
        } //End collapsed parenthetic
        {
            Iterator<String> var85D067CFAE92C30817A3CFD58AF3EDFF_1865852820 = (getDNSSubjectAlts(x509)).iterator();
            var85D067CFAE92C30817A3CFD58AF3EDFF_1865852820.hasNext();
            String cn = var85D067CFAE92C30817A3CFD58AF3EDFF_1865852820.next();
            {
                {
                    boolean varAA8A1F5E9B1AFEFBACB19B19015D2736_1719424737 = (matches(hostName, cn));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Certificate[] certs;
        //try {
            //certs = session.getPeerCertificates();
        //} catch (SSLException e) {
            //return false;
        //}
        //X509Certificate x509 = (X509Certificate) certs[0];
        //String hostName = host.trim().toLowerCase(Locale.ENGLISH);
        //String firstCn = getFirstCn(x509);
        //if (matches(hostName, firstCn)) {
            //return true;
        //}
        //for (String cn : getDNSSubjectAlts(x509)) {
            //if (matches(hostName, cn)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.040 -0400", hash_original_method = "310064F85DB6CB010FFDA9849E47D727", hash_generated_method = "8B855654459BC6CE79BFAC6D28DE69A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matches(String hostName, String cn) {
        dsTaint.addTaint(cn);
        dsTaint.addTaint(hostName);
        cn = cn.toLowerCase(Locale.ENGLISH);
        {
            boolean varF7D3801EBF5FB948A1E85640EC3BD086_1935721263 = (cn.startsWith("*."));
            {
                int matchLength;
                matchLength = cn.length() - 1;
                boolean var42068F7156658AC8E7BBA3792503CC9B_1051873752 = (hostName.regionMatches(hostName.length() - matchLength, cn, 1, matchLength)
                    && cn.indexOf('.', 2) != -1
                    && acceptableCountryWildcard(cn)
                    && !InetAddress.isNumeric(hostName));
            } //End block
            {
                boolean varBED26020AD4B547D64FB1356A9AD9C82_975385209 = (hostName.equals(cn));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (cn == null) {
            //return false;
        //}
        //cn = cn.toLowerCase(Locale.ENGLISH);
        //if (cn.startsWith("*.")) {
            //int matchLength = cn.length() - 1;
            //return hostName.regionMatches(hostName.length() - matchLength, cn, 1, matchLength)
                    //&& cn.indexOf('.', 2) != -1
                    //&& acceptableCountryWildcard(cn)
                    //&& !InetAddress.isNumeric(hostName);
        //} else {
            //return hostName.equals(cn);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.040 -0400", hash_original_method = "FE150C1B8C346B276109DA6F46173FD5", hash_generated_method = "A0C6A4A1F25B10E952022597E379988F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean acceptableCountryWildcard(String cn) {
        dsTaint.addTaint(cn);
        int cnLen;
        cnLen = cn.length();
        {
            {
                boolean var864F55A9DD3A6ABB8C8A48AFBD8437A1_1203155420 = (cn.charAt(cnLen - 3) == '.');
                {
                    String s;
                    s = cn.substring(2, cnLen - 3);
                    int x;
                    x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int cnLen = cn.length();
        //if (cnLen >= 7 && cnLen <= 9) {
            //if (cn.charAt(cnLen - 3) == '.') {
                //String s = cn.substring(2, cnLen - 3);
                //int x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                //return x < 0;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.042 -0400", hash_original_method = "6C819E0D5A8E8E96C06210327678F487", hash_generated_method = "79095C49536242ABF55F1C3AE4D06523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getFirstCn(X509Certificate cert) {
        dsTaint.addTaint(cert.dsTaint);
        String subjectPrincipal;
        subjectPrincipal = cert.getSubjectX500Principal().toString();
        {
            String token = subjectPrincipal.split(",")[0];
            {
                int x;
                x = token.indexOf("CN=");
                {
                    String var04D1C201A7E9D77A8AEFED09E3821DEC_1213116522 = (token.substring(x + 3));
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String subjectPrincipal = cert.getSubjectX500Principal().toString();
        //for (String token : subjectPrincipal.split(",")) {
            //int x = token.indexOf("CN=");
            //if (x >= 0) {
                //return token.substring(x + 3);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.043 -0400", hash_original_method = "F40DC2B7DE530D6D3AB694EABABE065F", hash_generated_method = "D51CCADAD5736A876FED4799039116FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private List<String> getDNSSubjectAlts(X509Certificate cert) {
        dsTaint.addTaint(cert.dsTaint);
        Collection<List<?>> subjectAlternativeNames;
        try 
        {
            subjectAlternativeNames = cert.getSubjectAlternativeNames();
        } //End block
        catch (CertificateParsingException cpe)
        {
            System.logI("Error parsing certificate", cpe);
            List<String> var1F7E6404BCDE565051377D8968B6B9AF_1463573641 = (Collections.emptyList());
        } //End block
        {
            List<String> var1F7E6404BCDE565051377D8968B6B9AF_1255446620 = (Collections.emptyList());
        } //End block
        List<String> subjectAltList;
        subjectAltList = new ArrayList<String>();
        {
            subjectAlternativeNames.iterator().hasNext();
            List<?> pair = subjectAlternativeNames.iterator().next();
            {
                int type;
                type = (Integer) pair.get(0);
                {
                    subjectAltList.add((String) pair.get(1));
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<List<?>> subjectAlternativeNames;
        //try {
            //subjectAlternativeNames = cert.getSubjectAlternativeNames();
        //} catch (CertificateParsingException cpe) {
            //System.logI("Error parsing certificate", cpe);
            //return Collections.emptyList();
        //}
        //if (subjectAlternativeNames == null) {
            //return Collections.emptyList();
        //}
        //List<String> subjectAltList = new ArrayList<String>();
        //for (List<?> pair : subjectAlternativeNames) {
            //int type = (Integer) pair.get(0);
            //if (type == 2) {
                //subjectAltList.add((String) pair.get(1));
            //}
        //}
        //return subjectAltList;
    }

    
    private static final String[] BAD_COUNTRY_2LDS =
          { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
}

