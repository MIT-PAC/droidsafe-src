package com.android.internal.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import android.net.NetworkUtils;
import android.util.Log;

public class DomainNameValidator {

    /**
     * Checks the site certificate against the domain name of the site being visited
     * @param certificate The certificate to check
     * @param thisDomain The domain name of the site being visited
     * @return True iff if there is a domain match as specified by RFC2818
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.508 -0500", hash_original_method = "68F4A719CC13890482E2E4D067F0B6D6", hash_generated_method = "352A5D5B42344D6A9110067E6C3F7EBC")
    
public static boolean match(X509Certificate certificate, String thisDomain) {
        if (certificate == null || thisDomain == null || thisDomain.length() == 0) {
            return false;
        }

        thisDomain = thisDomain.toLowerCase();
        if (!isIpAddress(thisDomain)) {
            return matchDns(certificate, thisDomain);
        } else {
            return matchIpAddress(certificate, thisDomain);
        }
    }

    /**
     * @return True iff the domain name is specified as an IP address
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.512 -0500", hash_original_method = "E9F532CEF2F4F6A1EF805C8CA429D275", hash_generated_method = "86542C5257423536EE37AAD413F10E68")
    
private static boolean isIpAddress(String domain) {
        boolean rval = (domain != null && domain.length() != 0);
        if (rval) {
            try {
                // do a quick-dirty IP match first to avoid DNS lookup
                rval = domain.equals(
                        NetworkUtils.numericToInetAddress(domain).getHostAddress());
            } catch (IllegalArgumentException e) {
                if (LOG_ENABLED) {
                    Log.v(TAG, "DomainNameValidator.isIpAddress(): " + e);
                }

                rval = false;
            }
        }

        return rval;
    }

    /**
     * Checks the site certificate against the IP domain name of the site being visited
     * @param certificate The certificate to check
     * @param thisDomain The DNS domain name of the site being visited
     * @return True iff if there is a domain match as specified by RFC2818
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.514 -0500", hash_original_method = "DBB4EF5840B4656B4D7CD7498EF1A157", hash_generated_method = "B5D6BEEE5C50711516C06A63C9884CAB")
    
private static boolean matchIpAddress(X509Certificate certificate, String thisDomain) {
        if (LOG_ENABLED) {
            Log.v(TAG, "DomainNameValidator.matchIpAddress(): this domain: " + thisDomain);
        }

        try {
            Collection subjectAltNames = certificate.getSubjectAlternativeNames();
            if (subjectAltNames != null) {
                Iterator i = subjectAltNames.iterator();
                while (i.hasNext()) {
                    List altNameEntry = (List)(i.next());
                    if (altNameEntry != null && 2 <= altNameEntry.size()) {
                        Integer altNameType = (Integer)(altNameEntry.get(0));
                        if (altNameType != null) {
                            if (altNameType.intValue() == ALT_IPA_NAME) {
                                String altName = (String)(altNameEntry.get(1));
                                if (altName != null) {
                                    if (LOG_ENABLED) {
                                        Log.v(TAG, "alternative IP: " + altName);
                                    }
                                    if (thisDomain.equalsIgnoreCase(altName)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (CertificateParsingException e) {}

        return false;
    }

    /**
     * Checks the site certificate against the DNS domain name of the site being visited
     * @param certificate The certificate to check
     * @param thisDomain The DNS domain name of the site being visited
     * @return True iff if there is a domain match as specified by RFC2818
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.518 -0500", hash_original_method = "C83F44B9F19EF99C9FE0202DE345EC32", hash_generated_method = "744132E1B36703B77D181E917FFD7267")
    
private static boolean matchDns(X509Certificate certificate, String thisDomain) {
        boolean hasDns = false;
        try {
            Collection subjectAltNames = certificate.getSubjectAlternativeNames();
            if (subjectAltNames != null) {
                Iterator i = subjectAltNames.iterator();
                while (i.hasNext()) {
                    List altNameEntry = (List)(i.next());
                    if (altNameEntry != null && 2 <= altNameEntry.size()) {
                        Integer altNameType = (Integer)(altNameEntry.get(0));
                        if (altNameType != null) {
                            if (altNameType.intValue() == ALT_DNS_NAME) {
                                hasDns = true;
                                String altName = (String)(altNameEntry.get(1));
                                if (altName != null) {
                                    if (matchDns(thisDomain, altName)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (CertificateParsingException e) {
            String errorMessage = e.getMessage();
            if (errorMessage == null) {
                errorMessage = "failed to parse certificate";
            }

            Log.w(TAG, "DomainNameValidator.matchDns(): " + errorMessage);
            return false;
        }

        if (!hasDns) {
            final String cn = new DNParser(certificate.getSubjectX500Principal())
                    .find("cn");
            if (LOG_ENABLED) {
                Log.v(TAG, "Validating subject: DN:"
                        + certificate.getSubjectX500Principal().getName(X500Principal.CANONICAL)
                        + "  CN:" + cn);
            }
            if (cn != null) {
                return matchDns(thisDomain, cn);
            }
        }

        return false;
    }

    /**
     * @param thisDomain The domain name of the site being visited
     * @param thatDomain The domain name from the certificate
     * @return True iff thisDomain matches thatDomain as specified by RFC2818
     */
    // not private for testing
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.522 -0500", hash_original_method = "0B5A208364AC9B44AEB8DF5D731BCC74", hash_generated_method = "770287C4C10413BAD8138E7D865F2B54")
    
public static boolean matchDns(String thisDomain, String thatDomain) {
        if (LOG_ENABLED) {
            Log.v(TAG, "DomainNameValidator.matchDns():" +
                      " this domain: " + thisDomain +
                      " that domain: " + thatDomain);
        }

        if (thisDomain == null || thisDomain.length() == 0 ||
            thatDomain == null || thatDomain.length() == 0) {
            return false;
        }

        thatDomain = thatDomain.toLowerCase();

        // (a) domain name strings are equal, ignoring case: X matches X
        boolean rval = thisDomain.equals(thatDomain);
        if (!rval) {
            String[] thisDomainTokens = thisDomain.split("\\.");
            String[] thatDomainTokens = thatDomain.split("\\.");

            int thisDomainTokensNum = thisDomainTokens.length;
            int thatDomainTokensNum = thatDomainTokens.length;

            // (b) OR thatHost is a '.'-suffix of thisHost: Z.Y.X matches X
            if (thisDomainTokensNum >= thatDomainTokensNum) {
                for (int i = thatDomainTokensNum - 1; i >= 0; --i) {
                    rval = thisDomainTokens[i].equals(thatDomainTokens[i]);
                    if (!rval) {
                        // (c) OR we have a special *-match:
                        // *.Y.X matches Z.Y.X but *.X doesn't match Z.Y.X
                        rval = (i == 0 && thisDomainTokensNum == thatDomainTokensNum);
                        if (rval) {
                            rval = thatDomainTokens[0].equals("*");
                            if (!rval) {
                                // (d) OR we have a *-component match:
                                // f*.com matches foo.com but not bar.com
                                rval = domainTokenMatch(
                                    thisDomainTokens[0], thatDomainTokens[0]);
                            }
                        }
                        break;
                    }
                }
            } else {
              // (e) OR thatHost has a '*.'-prefix of thisHost:
              // *.Y.X matches Y.X
              rval = thatDomain.equals("*." + thisDomain);
            }
        }

        return rval;
    }

    /**
     * @param thisDomainToken The domain token from the current domain name
     * @param thatDomainToken The domain token from the certificate
     * @return True iff thisDomainToken matches thatDomainToken, using the
     * wildcard match as specified by RFC2818-3.1. For example, f*.com must
     * match foo.com but not bar.com
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.527 -0500", hash_original_method = "1D471F2BF3CC1DAFB05659B887498BFC", hash_generated_method = "38B50B82DF4BA0374F8D009DAA3B4212")
    
private static boolean domainTokenMatch(String thisDomainToken, String thatDomainToken) {
        if (thisDomainToken != null && thatDomainToken != null) {
            int starIndex = thatDomainToken.indexOf('*');
            if (starIndex >= 0) {
                if (thatDomainToken.length() - 1 <= thisDomainToken.length()) {
                    String prefix = thatDomainToken.substring(0,  starIndex);
                    String suffix = thatDomainToken.substring(starIndex + 1);

                    return thisDomainToken.startsWith(prefix) && thisDomainToken.endsWith(suffix);
                }
            }
        }

        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.493 -0500", hash_original_field = "90BA4ACBA52A64B2A93E30F1403CE221", hash_generated_field = "D762B92100EC492C8E2F43AE3DE0E7E1")

    private final static String TAG = "DomainNameValidator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.497 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.500 -0500", hash_original_field = "F06F6BE52D1AF076D79F1A84048E39C0", hash_generated_field = "C040F7E72494FCBA74A6440C651C9D2C")

    private static final boolean LOG_ENABLED = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.503 -0500", hash_original_field = "A194604B11DC96868B69180CE9EB583D", hash_generated_field = "D60747C22CE448F6B43389DBEE293EA4")

    private static final int ALT_DNS_NAME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.505 -0500", hash_original_field = "0127BD18D2C5AC00745DDAAD2707820A", hash_generated_field = "8F4F08DC629818A48F022D07A771C3BD")

    private static final int ALT_IPA_NAME = 7;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.388 -0400", hash_original_method = "C5190347A8092226EE089C86AEE611D1", hash_generated_method = "C5190347A8092226EE089C86AEE611D1")
    public DomainNameValidator ()
    {
        //Synthesized constructor
    }
}

