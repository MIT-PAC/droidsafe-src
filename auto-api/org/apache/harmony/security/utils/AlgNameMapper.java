package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.354 -0400", hash_original_method = "22469560D029349EBF273B6D8BC83B7A", hash_generated_method = "31CEA5AC8FC09495AFA62E889F9BA508")
    @DSModeled(DSC.SAFE)
    private AlgNameMapper() {
        // ---------- Original Method ----------
    }

    
        public static String map2OID(String algName) {
        return alg2OidMap.get(algName.toUpperCase(Locale.US));
    }

    
        public static String map2AlgName(String oid) {
        String algUC = oid2AlgMap.get(oid);
        return algUC == null ? null : algAliasesMap.get(algUC);
    }

    
        public static String getStandardName(String algName) {
        return algAliasesMap.get(algName.toUpperCase(Locale.US));
    }

    
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

    
        public static boolean isOID(String alias) {
        return ObjectIdentifier.isOID(normalize(alias));
    }

    
        public static String normalize(String oid) {
        return oid.startsWith("OID.")
            ? oid.substring(4)
            : oid;
    }

    
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

