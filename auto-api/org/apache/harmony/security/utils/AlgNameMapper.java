package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.security.Provider;
import java.security.Security;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public class AlgNameMapper {
    private static final String[] serviceName = {
            "Cipher",
            "AlgorithmParameters",
            "Signature"
    };
    private static final String[][] knownAlgMappings = {
        {"1.2.840.10040.4.1",       "DSA"},
        {"1.2.840.10040.4.3",       "SHA1withDSA"},
        {"1.2.840.113549.1.1.1",    "RSA"},
        
        
        
        
        {"1.2.840.113549.1.1.4",    "MD5withRSA"},
        {"1.2.840.113549.1.1.5",    "SHA1withRSA"},
        {"1.2.840.113549.1.3.1",    "DiffieHellman"},
        {"1.2.840.113549.1.5.3",    "pbeWithMD5AndDES-CBC"},
        {"1.2.840.113549.1.12.1.3", "pbeWithSHAAnd3-KeyTripleDES-CBC"},
        {"1.2.840.113549.1.12.1.6", "pbeWithSHAAnd40BitRC2-CBC"},
        {"1.2.840.113549.3.2",      "RC2-CBC"},
        {"1.2.840.113549.3.3",      "RC2-EBC"},
        {"1.2.840.113549.3.4",      "RC4"},
        {"1.2.840.113549.3.5",      "RC4WithMAC"},
        {"1.2.840.113549.3.6",      "DESx-CBC"},
        {"1.2.840.113549.3.7",      "TripleDES-CBC"},
        {"1.2.840.113549.3.8",      "rc5CBC"},
        {"1.2.840.113549.3.9",      "RC5-CBC"},
        {"1.2.840.113549.3.10",     "DESCDMF"},
        {"2.23.42.9.11.4.1",        "ECDSA"},
    };
    private static final Map<String, String> alg2OidMap = new HashMap<String, String>();
    private static final Map<String, String> oid2AlgMap = new HashMap<String, String>();
    private static final Map<String, String> algAliasesMap = new HashMap<String, String>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "22469560D029349EBF273B6D8BC83B7A", hash_generated_method = "7B6217F0ED7578E7EF909567F7426AE4")
    @DSModeled(DSC.SAFE)
    private AlgNameMapper() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "4FADD03796EC8C0335BA0848BFDF836F", hash_generated_method = "07E96361535DF59B762E8E9F0639B36C")
    public static String map2OID(String algName) {
        return alg2OidMap.get(algName.toUpperCase(Locale.US));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "38EED3F0C044D08DA485A0576B49F3F8", hash_generated_method = "8C54A7129EEDA3B1600FA89BE6165E74")
    public static String map2AlgName(String oid) {
        String algUC = oid2AlgMap.get(oid);
        return algUC == null ? null : algAliasesMap.get(algUC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "313B623F7DAA498A73633C83991E4DA4", hash_generated_method = "4DEB350C63CA1737077538B01C67AD6E")
    public static String getStandardName(String algName) {
        return algAliasesMap.get(algName.toUpperCase(Locale.US));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "F5EE4B1951480F5B18913459BA38C43C", hash_generated_method = "91C027CC0E864AC44FCC58DFB3F09F02")
    private static void selectEntries(Provider p) {
        Set<Map.Entry<Object, Object>> entrySet = p.entrySet();
        for (String service : serviceName) {
            String keyPrfix2find = "Alg.Alias." + service + ".";
            for (Entry<Object, Object> me : entrySet) {
                String key = (String)me.getKey();
                if (key.startsWith(keyPrfix2find)) {
                    String alias = key.substring(keyPrfix2find.length());
                    String alg = (String)me.getValue();
                    String algUC = alg.toUpperCase(Locale.US);
                    if (isOID(alias)) {
                        if (alias.startsWith("OID.")) {
                            alias = alias.substring(4);
                        }
                        boolean oid2AlgContains = oid2AlgMap.containsKey(alias);
                        boolean alg2OidContains = alg2OidMap.containsKey(algUC);
                        if (!oid2AlgContains || !alg2OidContains) {
                            if (!oid2AlgContains) {
                                oid2AlgMap.put(alias, algUC);
                            }
                            if (!alg2OidContains) {
                                alg2OidMap.put(algUC, alias);
                            }
                            algAliasesMap.put(algUC, alg);
                        }
                    } else if (!algAliasesMap.containsKey(alias.toUpperCase(Locale.US))) {
                        algAliasesMap.put(alias.toUpperCase(Locale.US), alg);
                    }
                }
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "9771398A54E019F3216B0B27CED1676A", hash_generated_method = "4A11C834A65CDACD5BA1233CAF7AF5D1")
    public static boolean isOID(String alias) {
        return ObjectIdentifier.isOID(normalize(alias));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.785 -0400", hash_original_method = "6F84F8B81316E57A6E66508A61EE308C", hash_generated_method = "E59741060C67B78D88919DC982A8F9BC")
    public static String normalize(String oid) {
        return oid.startsWith("OID.")
            ? oid.substring(4)
            : oid;
    }

    
    static {
        for (String[] element : knownAlgMappings) {
            String algUC = element[1].toUpperCase(Locale.US);
            alg2OidMap.put(algUC, element[0]);
            oid2AlgMap.put(element[0], algUC);
            algAliasesMap.put(algUC, element[1]);
        }
        Provider[] pl = Security.getProviders();
        for (Provider element : pl) {
            selectEntries(element);
        }
    }
    
}


