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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.981 -0400", hash_original_method = "22469560D029349EBF273B6D8BC83B7A", hash_generated_method = "31CEA5AC8FC09495AFA62E889F9BA508")
    private  AlgNameMapper() {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.990 -0400", hash_original_field = "95C84005255BA71E4E0DFD9847C47864", hash_generated_field = "60A613F29F2DD02DC04547D07F1E2D11")

    private static String[] serviceName = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.990 -0400", hash_original_field = "21B74BFA2FABF0E6722E810CB277A776", hash_generated_field = "673547DB94C3FF0A61D04BFC98AF9A97")

    private static String[][] knownAlgMappings = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.990 -0400", hash_original_field = "79AEE170E734025FB4D0A1CA8B23FF1E", hash_generated_field = "AA7E25703B08667214E260C0765B3356")

    private static Map<String, String> alg2OidMap = new HashMap<String, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.991 -0400", hash_original_field = "63669FC13871444DFC9A8E37922F5C59", hash_generated_field = "972FBC59AC4E460DBDAD1ABBE1593F18")

    private static Map<String, String> oid2AlgMap = new HashMap<String, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.991 -0400", hash_original_field = "C445BEF557E723787EE59416CAA70AB4", hash_generated_field = "F0CE86D12D62C8E46193001437152EA4")

    private static Map<String, String> algAliasesMap = new HashMap<String, String>();
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

