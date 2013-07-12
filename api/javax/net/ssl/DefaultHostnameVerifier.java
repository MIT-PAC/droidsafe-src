package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.730 -0400", hash_original_method = "1ABE3FCDF9FB32248BCD2F796A0E487C", hash_generated_method = "1ABE3FCDF9FB32248BCD2F796A0E487C")
    public DefaultHostnameVerifier ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.732 -0400", hash_original_method = "648595920530E4C54EAA991A797FC9D5", hash_generated_method = "DAA4FE55515A408AD8928738B9AF8DEE")
    public final boolean verify(String host, SSLSession session) {
        addTaint(session.getTaint());
        addTaint(host.getTaint());
        Certificate[] certs;
        try 
        {
            certs = session.getPeerCertificates();
        } 
        catch (SSLException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_515704037 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752343221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752343221;
        } 
        X509Certificate x509 = (X509Certificate) certs[0];
        String hostName = host.trim().toLowerCase(Locale.ENGLISH);
        String firstCn = getFirstCn(x509);
    if(matches(hostName, firstCn))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_83229720 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162964890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162964890;
        } 
for(String cn : getDNSSubjectAlts(x509))
        {
    if(matches(hostName, cn))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_488299590 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603981773 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603981773;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1840649238 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658487559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658487559;
        
        
        
            
        
            
        
        
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.733 -0400", hash_original_method = "310064F85DB6CB010FFDA9849E47D727", hash_generated_method = "441B50B7BE9F1B6274D94A388F0B9237")
    private boolean matches(String hostName, String cn) {
        addTaint(cn.getTaint());
        addTaint(hostName.getTaint());
    if(cn == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1752992828 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048265194 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048265194;
        } 
        cn = cn.toLowerCase(Locale.ENGLISH);
    if(cn.startsWith("*."))        
        {
            int matchLength = cn.length() - 1;
            boolean var947009A6C4D2153421297767332E29DE_2030195081 = (hostName.regionMatches(hostName.length() - matchLength, cn, 1, matchLength)
                    && cn.indexOf('.', 2) != -1
                    && acceptableCountryWildcard(cn)
                    && !InetAddress.isNumeric(hostName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192674 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_192674;
        } 
        else
        {
            boolean var2666B50D3A0F31A384B26AF31255F5E8_1806900930 = (hostName.equals(cn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013465835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013465835;
        } 
        
        
            
        
        
        
            
            
                    
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.734 -0400", hash_original_method = "FE150C1B8C346B276109DA6F46173FD5", hash_generated_method = "85D71A6BE51B5BA729ACBAE6E3DD0750")
    private boolean acceptableCountryWildcard(String cn) {
        addTaint(cn.getTaint());
        int cnLen = cn.length();
    if(cnLen >= 7 && cnLen <= 9)        
        {
    if(cn.charAt(cnLen - 3) == '.')            
            {
                String s = cn.substring(2, cnLen - 3);
                int x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                boolean var3B4A721B7390BAF1B8AFCC251D43D129_1462524889 = (x < 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429692921 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429692921;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_2094681430 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328281964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328281964;
        
        
        
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.736 -0400", hash_original_method = "6C819E0D5A8E8E96C06210327678F487", hash_generated_method = "734310FA843DE023A067395BC3E3EE6A")
    private String getFirstCn(X509Certificate cert) {
        addTaint(cert.getTaint());
        String subjectPrincipal = cert.getSubjectX500Principal().toString();
for(String token : subjectPrincipal.split(","))
        {
            int x = token.indexOf("CN=");
    if(x >= 0)            
            {
String var6C45848D4E5C4A16DF70076C8744CB8A_1043102331 =                 token.substring(x + 3);
                var6C45848D4E5C4A16DF70076C8744CB8A_1043102331.addTaint(taint);
                return var6C45848D4E5C4A16DF70076C8744CB8A_1043102331;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_2082547663 =         null;
        var540C13E9E156B687226421B24F2DF178_2082547663.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2082547663;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.737 -0400", hash_original_method = "F40DC2B7DE530D6D3AB694EABABE065F", hash_generated_method = "6A8BB3FD7ABD32EEF9B0E5774D632783")
    private List<String> getDNSSubjectAlts(X509Certificate cert) {
        addTaint(cert.getTaint());
        Collection<List<?>> subjectAlternativeNames;
        try 
        {
            subjectAlternativeNames = cert.getSubjectAlternativeNames();
        } 
        catch (CertificateParsingException cpe)
        {
            System.logI("Error parsing certificate", cpe);
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_954976524 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_954976524.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_954976524;
        } 
    if(subjectAlternativeNames == null)        
        {
List<String> varB803AB532741AA7D5C2F301CCDDD25F2_1692639651 =             Collections.emptyList();
            varB803AB532741AA7D5C2F301CCDDD25F2_1692639651.addTaint(taint);
            return varB803AB532741AA7D5C2F301CCDDD25F2_1692639651;
        } 
        List<String> subjectAltList = new ArrayList<String>();
for(List<?> pair : subjectAlternativeNames)
        {
            int type = (Integer) pair.get(0);
    if(type == 2)            
            {
                subjectAltList.add((String) pair.get(1));
            } 
        } 
List<String> var1958EE9065303448D12A47CD69FD4819_1553751414 =         subjectAltList;
        var1958EE9065303448D12A47CD69FD4819_1553751414.addTaint(taint);
        return var1958EE9065303448D12A47CD69FD4819_1553751414;
        
        
        
            
        
            
            
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.738 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "3A751CA92898755F652261390A3F7AD7")

    private static final String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
}

