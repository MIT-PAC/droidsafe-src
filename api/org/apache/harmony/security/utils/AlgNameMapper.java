package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.Provider;
import java.security.Security;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.harmony.security.asn1.ObjectIdentifier;






public class AlgNameMapper {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.375 -0400", hash_original_method = "22469560D029349EBF273B6D8BC83B7A", hash_generated_method = "31CEA5AC8FC09495AFA62E889F9BA508")
    private  AlgNameMapper() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static String map2OID(String algName) {
        return alg2OidMap.get(algName.toUpperCase(Locale.US));
    }

    
    public static String map2AlgName(String oid) {
        String algUC = oid2AlgMap.get(oid);
        return algUC == null ? null : algAliasesMap.get(algUC);
    }

    
    @DSModeled(DSC.SAFE)
    public static String getStandardName(String algName) {
        return algAliasesMap.get(algName.toUpperCase(Locale.US));
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    public static boolean isOID(String alias) {
        return ObjectIdentifier.isOID(normalize(alias));
    }

    
    public static String normalize(String oid) {
        return oid.startsWith("OID.")
            ? oid.substring(4)
            : oid;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.391 -0400", hash_original_field = "95C84005255BA71E4E0DFD9847C47864", hash_generated_field = "5B3209CE00A02D35075FCE27482EB452")

    private static final String[] serviceName = {
            "Cipher",
            "AlgorithmParameters",
            "Signature"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.392 -0400", hash_original_field = "21B74BFA2FABF0E6722E810CB277A776", hash_generated_field = "A962EA8E18EE34D6D78785249A076B18")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.392 -0400", hash_original_field = "79AEE170E734025FB4D0A1CA8B23FF1E", hash_generated_field = "11D4611592559DD6C26CF40B7FAA58FB")

    private static final Map<String, String> alg2OidMap = new HashMap<String, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.392 -0400", hash_original_field = "63669FC13871444DFC9A8E37922F5C59", hash_generated_field = "5895D55E9FDDA0E0353CE42466F9F51D")

    private static final Map<String, String> oid2AlgMap = new HashMap<String, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.392 -0400", hash_original_field = "C445BEF557E723787EE59416CAA70AB4", hash_generated_field = "0F358DFC7E18735BA0EC9B4314046FA6")

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

