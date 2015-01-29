package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.377 -0500", hash_original_field = "CF832AED4ED292DEBA2E1483360AB57F", hash_generated_field = "3A751CA92898755F652261390A3F7AD7")

    private static final String[] BAD_COUNTRY_2LDS =
          { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.557 -0400", hash_original_method = "1ABE3FCDF9FB32248BCD2F796A0E487C", hash_generated_method = "1ABE3FCDF9FB32248BCD2F796A0E487C")
    public DefaultHostnameVerifier ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.380 -0500", hash_original_method = "648595920530E4C54EAA991A797FC9D5", hash_generated_method = "B33EAEBE68C1BC2E1DE35493554FC6DD")
    
public final boolean verify(String host, SSLSession session) {
        Certificate[] certs;
        try {
            certs = session.getPeerCertificates();
        } catch (SSLException e) {
            return false;
        }

        X509Certificate x509 = (X509Certificate) certs[0];

        // We can be case-insensitive when comparing the host we used to
        // establish the socket to the hostname in the certificate.
        String hostName = host.trim().toLowerCase(Locale.ENGLISH);

        // Verify the first CN provided. Other CNs are ignored. Firefox, wget,
        // curl, and Sun Java work this way.
        String firstCn = getFirstCn(x509);
        if (matches(hostName, firstCn)) {
            return true;
        }

        for (String cn : getDNSSubjectAlts(x509)) {
            if (matches(hostName, cn)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if {@code hostname} matches {@code cn}.
     *
     * @param hostName a trimmed, lowercase hostname to verify
     * @param cn a certificate CN or DNS subject alt. Either a literal name or
     *     a wildcard of the form "*.google.com".
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.383 -0500", hash_original_method = "310064F85DB6CB010FFDA9849E47D727", hash_generated_method = "7AFF45F57CB221839AF43D1350782560")
    
private boolean matches(String hostName, String cn) {
        if (cn == null) {
            return false;
        }

        // Don't trim the CN, though!
        cn = cn.toLowerCase(Locale.ENGLISH);

        if (cn.startsWith("*.")) {
            // When a wildcard matches, also check that the wildcard is legit
            //   - Wildcards must contain at least two dots: "*.google.com"
            //   - Wildcards must be for private domains. No "*.co.uk" etc.
            //   - Wildcards must not match IP addresses: "*.8.8"
            int matchLength = cn.length() - 1;
            return hostName.regionMatches(hostName.length() - matchLength, cn, 1, matchLength)
                    && cn.indexOf('.', 2) != -1
                    && acceptableCountryWildcard(cn)
                    && !InetAddress.isNumeric(hostName);
        } else {
            return hostName.equals(cn);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.385 -0500", hash_original_method = "FE150C1B8C346B276109DA6F46173FD5", hash_generated_method = "C59675BD211D3F135E1AEBBEAF5E91B2")
    
private boolean acceptableCountryWildcard(String cn) {
        int cnLen = cn.length();
        if (cnLen >= 7 && cnLen <= 9) {
            // Look for the '.' in the 3rd-last position:
            if (cn.charAt(cnLen - 3) == '.') {
                // Trim off the [*.] and the [.XX].
                String s = cn.substring(2, cnLen - 3);
                // And test against the sorted array of bad 2lds:
                int x = Arrays.binarySearch(BAD_COUNTRY_2LDS, s);
                return x < 0;
            }
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.388 -0500", hash_original_method = "6C819E0D5A8E8E96C06210327678F487", hash_generated_method = "A2DE3C6C397202048AE943C2CFF7C4C4")
    
private String getFirstCn(X509Certificate cert) {
        /*
         * Sebastian Hauer's original StrictSSLProtocolSocketFactory used
         * getName() and had the following comment:
         *
         *      Parses a X.500 distinguished name for the value of the
         *     "Common Name" field.  This is done a bit sloppy right
         *     now and should probably be done a bit more according to
         *     <code>RFC 2253</code>.
         *
         * I've noticed that toString() seems to do a better job than
         * getName() on these X500Principal objects, so I'm hoping that
         * addresses Sebastian's concern.
         *
         * For example, getName() gives me this:
         * 1.2.840.113549.1.9.1=#16166a756c6975736461766965734063756362632e636f6d
         *
         * whereas toString() gives me this:
         * EMAILADDRESS=juliusdavies@cucbc.com
         *
         * Looks like toString() even works with non-ascii domain names!
         * I tested it with "&#x82b1;&#x5b50;.co.jp" and it worked fine.
         */
        String subjectPrincipal = cert.getSubjectX500Principal().toString();
        for (String token : subjectPrincipal.split(",")) {
            int x = token.indexOf("CN=");
            if (x >= 0) {
                return token.substring(x + 3);
            }
        }
        return null;
    }

    /**
     * Returns all SubjectAlt DNS names from an X509Certificate.
     *
     * <p>Note: Java doesn't appear able to extract international characters
     * from the SubjectAlts.  It can only extract international characters
     * from the CN field.
     *
     * <p>(Or maybe the version of OpenSSL I'm using to test isn't storing the
     * international characters correctly in the SubjectAlts?).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.391 -0500", hash_original_method = "F40DC2B7DE530D6D3AB694EABABE065F", hash_generated_method = "163755B59EEC94F6B2CD5A45CFBB27D5")
    
private List<String> getDNSSubjectAlts(X509Certificate cert) {
        Collection<List<?>> subjectAlternativeNames;
        try {
            subjectAlternativeNames = cert.getSubjectAlternativeNames();
        } catch (CertificateParsingException cpe) {
            System.logI("Error parsing certificate", cpe);
            return Collections.emptyList();
        }

        if (subjectAlternativeNames == null) {
            return Collections.emptyList();
        }

        List<String> subjectAltList = new ArrayList<String>();
        for (List<?> pair : subjectAlternativeNames) {
            int type = (Integer) pair.get(0);
            // If type is 2, then we've got a dNSName
            if (type == 2) {
                subjectAltList.add((String) pair.get(1));
            }
        }
        return subjectAltList;
    }
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
}

