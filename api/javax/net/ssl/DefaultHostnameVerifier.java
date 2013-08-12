package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.557 -0400", hash_original_method = "1ABE3FCDF9FB32248BCD2F796A0E487C", hash_generated_method = "1ABE3FCDF9FB32248BCD2F796A0E487C")
    public DefaultHostnameVerifier ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.558 -0400", hash_original_method = "648595920530E4C54EAA991A797FC9D5", hash_generated_method = "E8981EEF053FA55C525E4E87C306282F")
    public final boolean verify(String host, SSLSession session) {
        addTaint(session.getTaint());
        addTaint(host.getTaint());
        Certificate[] certs;
        try 
        {
            certs = session.getPeerCertificates();
        } //End block
        catch (SSLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_893868397 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_754743308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_754743308;
        } //End block
        X509Certificate x509 = (X509Certificate) certs[0];
        String hostName = host.trim().toLowerCase(Locale.ENGLISH);
        String firstCn = getFirstCn(x509);
        if(matches(hostName, firstCn))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1628410019 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900697378 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900697378;
        } //End block
for(String cn : getDNSSubjectAlts(x509))
        {
            if(matches(hostName, cn))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_931033582 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272855227 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_272855227;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_127732460 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481563533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481563533;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.559 -0400", hash_original_method = "310064F85DB6CB010FFDA9849E47D727", hash_generated_method = "FF9A098325D07FFAA77ED843CAE563E8")
    private boolean matches(String hostName, String cn) {
        addTaint(cn.getTaint());
        addTaint(hostName.getTaint());
        if(cn == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1829085455 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458784176 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458784176;
        } //End block
        cn = cn.toLowerCase(Locale.ENGLISH);
        if(cn.startsWith("*."))        
        {
            int matchLength = cn.length() - 1;
            boolean var947009A6C4D2153421297767332E29DE_1876459312 = (hostName.regionMatches(hostName.length() - matchLength, cn, 1, matchLength)
                    && cn.indexOf('.', 2) != -1
                    && acceptableCountryWildcard(cn)
                    && !InetAddress.isNumeric(hostName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577125446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577125446;
        } //End block
        else
        {
            boolean var2666B50D3A0F31A384B26AF31255F5E8_1219366713 = (hostName.equals(cn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034585116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034585116;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.561 -0400", hash_original_method = "FE150C1B8C346B276109DA6F46173FD5", hash_generated_method = "9C4305B6696E12B27209682CB8A5808F")
    private boolean acceptableCountryWildcard(String cn) {
        addTaint(cn.getTaint());
        int cnLen = cn.length();
        if(cnLen >= 7 && cnLen <= 9)        
        {
            if(cn.charAt(cnLen - 3) == '.')            
            {
                String s = cn.substring(2, cnLen - 3);
                int x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                boolean var3B4A721B7390BAF1B8AFCC251D43D129_398854764 = (x < 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415482786 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415482786;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_888771833 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593531369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_593531369;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.561 -0400", hash_original_method = "6C819E0D5A8E8E96C06210327678F487", hash_generated_method = "E09C9D1D6220EA556B67B38A6221C3D6")
    private String getFirstCn(X509Certificate cert) {
        addTaint(cert.getTaint());
        String subjectPrincipal = cert.getSubjectX500Principal().toString();
for(String token : subjectPrincipal.split(","))
        {
            int x = token.indexOf("CN=");
            if(x >= 0)            
            {
String var6C45848D4E5C4A16DF70076C8744CB8A_921477681 =                 token.substring(x + 3);
                var6C45848D4E5C4A16DF70076C8744CB8A_921477681.addTaint(taint);
                return var6C45848D4E5C4A16DF70076C8744CB8A_921477681;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_960074410 =         null;
        var540C13E9E156B687226421B24F2DF178_960074410.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_960074410;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.562 -0400", hash_original_method = "F40DC2B7DE530D6D3AB694EABABE065F", hash_generated_method = "017F4CFB891E8E09A0F6902F5F57D3DB")
    private List<String> getDNSSubjectAlts(X509Certificate cert) {
        addTaint(cert.getTaint());
        Collection<List<?>> subjectAlternativeNames;
        try 
        {
            subjectAlternativeNames = cert.getSubjectAlternativeNames();
        } //End block
        catch (CertificateParsingException cpe)
        {
            System.logI("Error parsing certificate", cpe);
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_306911727 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_306911727.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_306911727;
        } //End block
        if(subjectAlternativeNames == null)        
        {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_1898541512 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_1898541512.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_1898541512;
        } //End block
        List<String> subjectAltList = new ArrayList<String>();
for(List<?> pair : subjectAlternativeNames)
        {
            int type = (Integer) pair.get(0);
            if(type == 2)            
            {
                subjectAltList.add((String) pair.get(1));
            } //End block
        } //End block
List<String> var1958EE9065303448D12A47CD69FD4819_548508494 =         subjectAltList;
        var1958EE9065303448D12A47CD69FD4819_548508494.addTaint(taint);
        return var1958EE9065303448D12A47CD69FD4819_548508494;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.563 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "3A751CA92898755F652261390A3F7AD7")

    private static final String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
}

