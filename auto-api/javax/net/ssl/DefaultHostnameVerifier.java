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
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

class DefaultHostnameVerifier implements HostnameVerifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.479 -0400", hash_original_method = "1ABE3FCDF9FB32248BCD2F796A0E487C", hash_generated_method = "1ABE3FCDF9FB32248BCD2F796A0E487C")
    public DefaultHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.483 -0400", hash_original_method = "648595920530E4C54EAA991A797FC9D5", hash_generated_method = "F0C7B4E51638CA6F146E06A88F2FBD1D")
    public final boolean verify(String host, SSLSession session) {
        Certificate[] certs = null;
        try 
        {
            certs = session.getPeerCertificates();
        } //End block
        catch (SSLException e)
        { }
        X509Certificate x509 = (X509Certificate) certs[0];
        String hostName = host.trim().toLowerCase(Locale.ENGLISH);
        String firstCn = getFirstCn(x509);
        {
            boolean var29EDEFEF2843435DB2D9ED7F0A830B4A_1334625990 = (matches(hostName, firstCn));
        } //End collapsed parenthetic
        {
            Iterator<String> var85D067CFAE92C30817A3CFD58AF3EDFF_64029468 = (getDNSSubjectAlts(x509)).iterator();
            var85D067CFAE92C30817A3CFD58AF3EDFF_64029468.hasNext();
            String cn = var85D067CFAE92C30817A3CFD58AF3EDFF_64029468.next();
            {
                {
                    boolean varAA8A1F5E9B1AFEFBACB19B19015D2736_1448601743 = (matches(hostName, cn));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(host.getTaint());
        addTaint(session.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287568625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287568625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.483 -0400", hash_original_method = "310064F85DB6CB010FFDA9849E47D727", hash_generated_method = "26160A260D68C1BDD15C2256B9B844D3")
    private boolean matches(String hostName, String cn) {
        cn = cn.toLowerCase(Locale.ENGLISH);
        {
            boolean varF7D3801EBF5FB948A1E85640EC3BD086_2267397 = (cn.startsWith("*."));
            {
                int matchLength = cn.length() - 1;
                boolean var42068F7156658AC8E7BBA3792503CC9B_960443268 = (hostName.regionMatches(hostName.length() - matchLength, cn, 1, matchLength)
                    && cn.indexOf('.', 2) != -1
                    && acceptableCountryWildcard(cn)
                    && !InetAddress.isNumeric(hostName));
            } //End block
            {
                boolean varBED26020AD4B547D64FB1356A9AD9C82_1080043119 = (hostName.equals(cn));
            } //End block
        } //End collapsed parenthetic
        addTaint(hostName.getTaint());
        addTaint(cn.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206716828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206716828;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.484 -0400", hash_original_method = "FE150C1B8C346B276109DA6F46173FD5", hash_generated_method = "8C641BC5D7F4F26923A23137C6B93EC3")
    private boolean acceptableCountryWildcard(String cn) {
        int cnLen = cn.length();
        {
            {
                boolean var864F55A9DD3A6ABB8C8A48AFBD8437A1_905333492 = (cn.charAt(cnLen - 3) == '.');
                {
                    String s = cn.substring(2, cnLen - 3);
                    int x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(cn.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338843303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338843303;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.487 -0400", hash_original_method = "6C819E0D5A8E8E96C06210327678F487", hash_generated_method = "0B5D004061F229283D13CA214340A569")
    private String getFirstCn(X509Certificate cert) {
        String varB4EAC82CA7396A68D541C85D26508E83_365857526 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1885090681 = null; //Variable for return #2
        String subjectPrincipal = cert.getSubjectX500Principal().toString();
        {
            String token = subjectPrincipal.split(",")[0];
            {
                int x = token.indexOf("CN=");
                {
                    varB4EAC82CA7396A68D541C85D26508E83_365857526 = token.substring(x + 3);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1885090681 = null;
        addTaint(cert.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1552725425; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1552725425 = varB4EAC82CA7396A68D541C85D26508E83_365857526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1552725425 = varB4EAC82CA7396A68D541C85D26508E83_1885090681;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1552725425.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1552725425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.489 -0400", hash_original_method = "F40DC2B7DE530D6D3AB694EABABE065F", hash_generated_method = "46CB8E6E4845C58401462B8DB8DB7622")
    private List<String> getDNSSubjectAlts(X509Certificate cert) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_950623639 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_365650371 = null; //Variable for return #2
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1862439589 = null; //Variable for return #3
        Collection<List<?>> subjectAlternativeNames = new LinkedList<List<?>>();
        try 
        {
            subjectAlternativeNames = cert.getSubjectAlternativeNames();
        } //End block
        catch (CertificateParsingException cpe)
        {
            System.logI("Error parsing certificate", cpe);
            varB4EAC82CA7396A68D541C85D26508E83_950623639 = Collections.emptyList();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_365650371 = Collections.emptyList();
        } //End block
        List<String> subjectAltList = new ArrayList<String>();
        {
        	List<?> pair = (List<?>)subjectAlternativeNames.toArray()[0];
            
            {
                int type = (Integer) pair.get(0);
                addTaint(type);
                {
                    subjectAltList.add((String) pair.get(1));
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1862439589 = subjectAltList;
        addTaint(cert.getTaint());
        List<String> varA7E53CE21691AB073D9660D615818899_128098990; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_128098990 = varB4EAC82CA7396A68D541C85D26508E83_950623639;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_128098990 = varB4EAC82CA7396A68D541C85D26508E83_365650371;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_128098990 = varB4EAC82CA7396A68D541C85D26508E83_1862439589;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_128098990.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_128098990;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.489 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "3A751CA92898755F652261390A3F7AD7")

    private static final String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
}

