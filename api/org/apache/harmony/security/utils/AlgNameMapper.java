package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Returns OID for algName
     *
     * @param algName algorithm name to be mapped
     * @return OID as String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.848 -0500", hash_original_method = "4FADD03796EC8C0335BA0848BFDF836F", hash_generated_method = "83F952FCD8DC66405127C8E1FD5A6ED1")
    
public static String map2OID(String algName) {
        // alg2OidMap map contains upper case keys
        return alg2OidMap.get(algName.toUpperCase(Locale.US));
    }

    /**
     * Returns algName for OID
     *
     * @param oid OID to be mapped
     * @return algorithm name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.850 -0500", hash_original_method = "38EED3F0C044D08DA485A0576B49F3F8", hash_generated_method = "FAE9143618C665620E69EFA1D5B1E722")
    
public static String map2AlgName(String oid) {
        // oid2AlgMap map contains upper case values
        String algUC = oid2AlgMap.get(oid);
        // if not null there is always map UC->Orig
        return algUC == null ? null : algAliasesMap.get(algUC);
    }

    /**
     * Returns Algorithm name for given algorithm alias
     *
     * @param algName - alias
     * @return algorithm name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.853 -0500", hash_original_method = "313B623F7DAA498A73633C83991E4DA4", hash_generated_method = "4DEB350C63CA1737077538B01C67AD6E")
    
public static String getStandardName(String algName) {
        return algAliasesMap.get(algName.toUpperCase(Locale.US));
    }

    // Searches given provider for mappings like
    // Alg.Alias.<service>.<OID-INTS-DOT-SEPARATED>=<alg-name>
    //  or
    // Alg.Alias.<service>.OID.<OID-INTS-DOT-SEPARATED>=<alg-name>
    // Puts mappings found into appropriate internal maps
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.856 -0500", hash_original_method = "F5EE4B1951480F5B18913459BA38C43C", hash_generated_method = "609AB978FECBAB632388A7F1B3D06629")
    
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
                        // Do not overwrite already known mappings
                        boolean oid2AlgContains = oid2AlgMap.containsKey(alias);
                        boolean alg2OidContains = alg2OidMap.containsKey(algUC);
                        if (!oid2AlgContains || !alg2OidContains) {
                            if (!oid2AlgContains) {
                                oid2AlgMap.put(alias, algUC);
                            }
                            if (!alg2OidContains) {
                                alg2OidMap.put(algUC, alias);
                            }
                            // map upper case alg name to its original name
                            algAliasesMap.put(algUC, alg);
                        }
                           // Do not override known standard names
                    } else if (!algAliasesMap.containsKey(alias.toUpperCase(Locale.US))) {
                        algAliasesMap.put(alias.toUpperCase(Locale.US), alg);
                    }
                }
            }
        }
    }

    /**
     * Checks if parameter represents OID
     *
     * @param alias alias to be checked
     * @return 'true' if parameter represents OID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.858 -0500", hash_original_method = "9771398A54E019F3216B0B27CED1676A", hash_generated_method = "4A11C834A65CDACD5BA1233CAF7AF5D1")
    
public static boolean isOID(String alias) {
        return ObjectIdentifier.isOID(normalize(alias));
    }

    /**
     * Removes leading "OID." from oid String passed
     *
     * @param oid string that may contain leading "OID."
     * @return string passed without leading "OID."
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.860 -0500", hash_original_method = "6F84F8B81316E57A6E66508A61EE308C", hash_generated_method = "E59741060C67B78D88919DC982A8F9BC")
    
public static String normalize(String oid) {
        return oid.startsWith("OID.")
            ? oid.substring(4)
            : oid;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.831 -0500", hash_original_field = "6160EC0AA21FD16F819F7CB0EE3D15DF", hash_generated_field = "5B3209CE00A02D35075FCE27482EB452")

    private static final String[] serviceName = {
            "Cipher",
            "AlgorithmParameters",
            "Signature"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.835 -0500", hash_original_field = "634ED4F95CAD2FB4075EEE4991955192", hash_generated_field = "C2D3DE776FF0099B404D6FFD8A20B815")

    // by the ones from available providers
    // during maps initialization
    // (source: http://asn1.elibel.tm.fr):
    private static final String[][] knownAlgMappings = {
        {"1.2.840.10040.4.1",       "DSA"},
        {"1.2.840.10040.4.3",       "SHA1withDSA"},
        {"1.2.840.113549.1.1.1",    "RSA"},
        // BEGIN android-removed
        // Dropping MD2
        // {"1.2.840.113549.1.1.2",    "MD2withRSA"},
        // END android-removed
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.837 -0500", hash_original_field = "8A0254D251541099D05416AB394BCF6D", hash_generated_field = "11D4611592559DD6C26CF40B7FAA58FB")

    private static final Map<String, String> alg2OidMap = new HashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.840 -0500", hash_original_field = "8F2E92F8EF8DD594345DCF3F7F6B861E", hash_generated_field = "5895D55E9FDDA0E0353CE42466F9F51D")

    private static final Map<String, String> oid2AlgMap = new HashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.842 -0500", hash_original_field = "B9B14AD671EEA680E37B554235850741", hash_generated_field = "0F358DFC7E18735BA0EC9B4314046FA6")

    private static final Map<String, String> algAliasesMap = new HashMap<String, String>();

    // No instances
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.845 -0500", hash_original_method = "22469560D029349EBF273B6D8BC83B7A", hash_generated_method = "02F502788C65D3887C73CA265C60EA16")
    
private AlgNameMapper() {
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

