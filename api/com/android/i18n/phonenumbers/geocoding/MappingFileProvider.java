package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;



public class MappingFileProvider implements Externalizable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.618 -0400", hash_original_field = "69F496FCE87C6BC7DC2D0257BB43A268", hash_generated_field = "3E0B4451FC75BFBEA7BE0888ADA52D93")

    private int numOfEntries = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.619 -0400", hash_original_field = "8F1EF5DE313B3CF3485F9D5F2024448D", hash_generated_field = "5D843B062DC0F709662151020D18BCC2")

    private int[] countryCallingCodes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.619 -0400", hash_original_field = "C59A8EB3CF7DF10278F316915F723451", hash_generated_field = "297401D4476B3C0539FAD27EE481B768")

    private List<Set<String>> availableLanguages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.619 -0400", hash_original_method = "8FB53B01F748B2BCB846F8E0ABF1A4BF", hash_generated_method = "E1EA2CA8DCBD71E4D8727E1C0D169F8E")
    public  MappingFileProvider() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.620 -0400", hash_original_method = "2C1785672959EEFC03879AF7408DB866", hash_generated_method = "6EAE1C7997A2232323DE446F3607DAA0")
    public void readFileConfigs(SortedMap<Integer, Set<String>> availableDataFiles) {
        numOfEntries = availableDataFiles.size();
        countryCallingCodes = new int[numOfEntries];
        availableLanguages = new ArrayList<Set<String>>(numOfEntries);
        int index = 0;
for(int countryCallingCode : availableDataFiles.keySet())
        {
            countryCallingCodes[index++] = countryCallingCode;
            availableLanguages.add(new HashSet<String>(availableDataFiles.get(countryCallingCode)));
        } //End block
        // ---------- Original Method ----------
        //numOfEntries = availableDataFiles.size();
        //countryCallingCodes = new int[numOfEntries];
        //availableLanguages = new ArrayList<Set<String>>(numOfEntries);
        //int index = 0;
        //for (int countryCallingCode : availableDataFiles.keySet()) {
      //countryCallingCodes[index++] = countryCallingCode;
      //availableLanguages.add(new HashSet<String>(availableDataFiles.get(countryCallingCode)));
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.621 -0400", hash_original_method = "A5B4139EF2A7D591E843D1D3DA56504C", hash_generated_method = "C0608A0E6F919483BF8AC84100E8ED1D")
    public void readExternal(ObjectInput objectInput) throws IOException {
        numOfEntries = objectInput.readInt();
        if(countryCallingCodes == null || countryCallingCodes.length < numOfEntries)        
        {
            countryCallingCodes = new int[numOfEntries];
        } //End block
        if(availableLanguages == null)        
        {
            availableLanguages = new ArrayList<Set<String>>();
        } //End block
for(int i = 0;i < numOfEntries;i++)
        {
            countryCallingCodes[i] = objectInput.readInt();
            int numOfLangs = objectInput.readInt();
            Set<String> setOfLangs = new HashSet<String>();
for(int j = 0;j < numOfLangs;j++)
            {
                setOfLangs.add(objectInput.readUTF());
            } //End block
            availableLanguages.add(setOfLangs);
        } //End block
        // ---------- Original Method ----------
        //numOfEntries = objectInput.readInt();
        //if (countryCallingCodes == null || countryCallingCodes.length < numOfEntries) {
      //countryCallingCodes = new int[numOfEntries];
    //}
        //if (availableLanguages == null) {
      //availableLanguages = new ArrayList<Set<String>>();
    //}
        //for (int i = 0; i < numOfEntries; i++) {
      //countryCallingCodes[i] = objectInput.readInt();
      //int numOfLangs = objectInput.readInt();
      //Set<String> setOfLangs = new HashSet<String>();
      //for (int j = 0; j < numOfLangs; j++) {
        //setOfLangs.add(objectInput.readUTF());
      //}
      //availableLanguages.add(setOfLangs);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.622 -0400", hash_original_method = "E326CA0D62F025609F12A4A9B87E4431", hash_generated_method = "7908203CB08C559DD3A7651FC267DF4E")
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        addTaint(objectOutput.getTaint());
        objectOutput.writeInt(numOfEntries);
for(int i = 0;i < numOfEntries;i++)
        {
            objectOutput.writeInt(countryCallingCodes[i]);
            Set<String> setOfLangs = availableLanguages.get(i);
            int numOfLangs = setOfLangs.size();
            objectOutput.writeInt(numOfLangs);
for(String lang : setOfLangs)
            {
                objectOutput.writeUTF(lang);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //objectOutput.writeInt(numOfEntries);
        //for (int i = 0; i < numOfEntries; i++) {
      //objectOutput.writeInt(countryCallingCodes[i]);
      //Set<String> setOfLangs = availableLanguages.get(i);
      //int numOfLangs = setOfLangs.size();
      //objectOutput.writeInt(numOfLangs);
      //for (String lang : setOfLangs) {
        //objectOutput.writeUTF(lang);
      //}
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.623 -0400", hash_original_method = "17C0EB7BC2271962455DE53D535BEB5E", hash_generated_method = "274B6CC9A9DF197397968282702EB663")
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
for(int i = 0;i < numOfEntries;i++)
        {
            output.append(countryCallingCodes[i]);
            output.append('|');
            SortedSet<String> sortedSetOfLangs = new TreeSet<String>(availableLanguages.get(i));
for(String lang : sortedSetOfLangs)
            {
                output.append(lang);
                output.append(',');
            } //End block
            output.append('\n');
        } //End block
String varEBF0387156E2D98F471F997058C674A5_710308645 =         output.toString();
        varEBF0387156E2D98F471F997058C674A5_710308645.addTaint(taint);
        return varEBF0387156E2D98F471F997058C674A5_710308645;
        // ---------- Original Method ----------
        //StringBuilder output = new StringBuilder();
        //for (int i = 0; i < numOfEntries; i++) {
      //output.append(countryCallingCodes[i]);
      //output.append('|');
      //SortedSet<String> sortedSetOfLangs = new TreeSet<String>(availableLanguages.get(i));
      //for (String lang : sortedSetOfLangs) {
        //output.append(lang);
        //output.append(',');
      //}
      //output.append('\n');
    //}
        //return output.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.624 -0400", hash_original_method = "F40661B16774EA00988010D992802DCB", hash_generated_method = "AF78D503CDD5D24485B08ED0129E9D14")
     String getFileName(int countryCallingCode, String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        addTaint(countryCallingCode);
        if(language.length() == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2145727996 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2145727996.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2145727996;
        } //End block
        int index = Arrays.binarySearch(countryCallingCodes, countryCallingCode);
        if(index < 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1605677926 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1605677926.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1605677926;
        } //End block
        Set<String> setOfLangs = availableLanguages.get(index);
        if(setOfLangs.size() > 0)        
        {
            String languageCode = findBestMatchingLanguageCode(setOfLangs, language, script, region);
            if(languageCode.length() > 0)            
            {
                StringBuilder fileName = new StringBuilder();
                fileName.append(countryCallingCode).append('_').append(languageCode);
String var43BA8F2DD2C0F2EB249ACFEE2BFD792C_305621707 =                 fileName.toString();
                var43BA8F2DD2C0F2EB249ACFEE2BFD792C_305621707.addTaint(taint);
                return var43BA8F2DD2C0F2EB249ACFEE2BFD792C_305621707;
            } //End block
        } //End block
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_938545489 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_938545489.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_938545489;
        // ---------- Original Method ----------
        //if (language.length() == 0) {
      //return "";
    //}
        //int index = Arrays.binarySearch(countryCallingCodes, countryCallingCode);
        //if (index < 0) {
      //return "";
    //}
        //Set<String> setOfLangs = availableLanguages.get(index);
        //if (setOfLangs.size() > 0) {
      //String languageCode = findBestMatchingLanguageCode(setOfLangs, language, script, region);
      //if (languageCode.length() > 0) {
        //StringBuilder fileName = new StringBuilder();
        //fileName.append(countryCallingCode).append('_').append(languageCode);
        //return fileName.toString();
      //}
    //}
        //return "";
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.624 -0400", hash_original_method = "18F97AE37D6D32FF4C5E8DE16502349B", hash_generated_method = "A028CE6BEDE541F956440663AB9C55B5")
    private String findBestMatchingLanguageCode(
      Set<String> setOfLangs, String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        addTaint(setOfLangs.getTaint());
        StringBuilder fullLocale = constructFullLocale(language, script, region);
        String fullLocaleStr = fullLocale.toString();
        String normalizedLocale = LOCALE_NORMALIZATION_MAP.get(fullLocaleStr);
        if(normalizedLocale != null)        
        {
            if(setOfLangs.contains(normalizedLocale))            
            {
String var4F21C8D8A98FB4F4085BDD1058E274A3_1933271581 =                 normalizedLocale;
                var4F21C8D8A98FB4F4085BDD1058E274A3_1933271581.addTaint(taint);
                return var4F21C8D8A98FB4F4085BDD1058E274A3_1933271581;
            } //End block
        } //End block
        if(setOfLangs.contains(fullLocaleStr))        
        {
String varABD38B61BC1463D561DF0B5C9D9373DC_367438000 =             fullLocaleStr;
            varABD38B61BC1463D561DF0B5C9D9373DC_367438000.addTaint(taint);
            return varABD38B61BC1463D561DF0B5C9D9373DC_367438000;
        } //End block
        if(onlyOneOfScriptOrRegionIsEmpty(script, region))        
        {
            if(setOfLangs.contains(language))            
            {
String var9CB6700F2CAEB604A10339BD9223F8CA_855301560 =                 language;
                var9CB6700F2CAEB604A10339BD9223F8CA_855301560.addTaint(taint);
                return var9CB6700F2CAEB604A10339BD9223F8CA_855301560;
            } //End block
        } //End block
        else
        if(script.length() > 0 && region.length() > 0)        
        {
            StringBuilder langWithScript = new StringBuilder(language).append('_').append(script);
            String langWithScriptStr = langWithScript.toString();
            if(setOfLangs.contains(langWithScriptStr))            
            {
String varF400C0A70FA82FC6FF75E78191F0FEE3_1451780732 =                 langWithScriptStr;
                varF400C0A70FA82FC6FF75E78191F0FEE3_1451780732.addTaint(taint);
                return varF400C0A70FA82FC6FF75E78191F0FEE3_1451780732;
            } //End block
            StringBuilder langWithRegion = new StringBuilder(language).append('_').append(region);
            String langWithRegionStr = langWithRegion.toString();
            if(setOfLangs.contains(langWithRegionStr))            
            {
String var1EF1FABAB075CBFCECF61B0B93FECE86_218382912 =                 langWithRegionStr;
                var1EF1FABAB075CBFCECF61B0B93FECE86_218382912.addTaint(taint);
                return var1EF1FABAB075CBFCECF61B0B93FECE86_218382912;
            } //End block
            if(setOfLangs.contains(language))            
            {
String var9CB6700F2CAEB604A10339BD9223F8CA_78317367 =                 language;
                var9CB6700F2CAEB604A10339BD9223F8CA_78317367.addTaint(taint);
                return var9CB6700F2CAEB604A10339BD9223F8CA_78317367;
            } //End block
        } //End block
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1028802449 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1028802449.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1028802449;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.625 -0400", hash_original_method = "AAED8563DDED3C53862CE4371524442C", hash_generated_method = "3FB9D44F0F1AC969B59F7B520B4FA1EA")
    private boolean onlyOneOfScriptOrRegionIsEmpty(String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        boolean var8EE7BA4ABB3A7F4D7885F2EBBDA4D7C0_179388200 = ((script.length() == 0 && region.length() > 0) ||
            (region.length() == 0 && script.length() > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284405821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284405821;
        // ---------- Original Method ----------
        //return (script.length() == 0 && region.length() > 0) ||
            //(region.length() == 0 && script.length() > 0);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.626 -0400", hash_original_method = "67AD4EAACC19DF5D4391EFA1CE27EABA", hash_generated_method = "45640DE8566BAE1DB980969D335ABA7D")
    private StringBuilder constructFullLocale(String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        StringBuilder fullLocale = new StringBuilder(language);
        appendSubsequentLocalePart(script, fullLocale);
        appendSubsequentLocalePart(region, fullLocale);
StringBuilder var690DC80614311B79D32C7436393D703D_691592578 =         fullLocale;
        var690DC80614311B79D32C7436393D703D_691592578.addTaint(taint);
        return var690DC80614311B79D32C7436393D703D_691592578;
        // ---------- Original Method ----------
        //StringBuilder fullLocale = new StringBuilder(language);
        //appendSubsequentLocalePart(script, fullLocale);
        //appendSubsequentLocalePart(region, fullLocale);
        //return fullLocale;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.626 -0400", hash_original_method = "A3149B7498B5162CA69A1D6F38AF4B31", hash_generated_method = "13DCF82EAE07D2565C97EFBC6B5DE69D")
    private void appendSubsequentLocalePart(String subsequentLocalePart, StringBuilder fullLocale) {
        addTaint(fullLocale.getTaint());
        addTaint(subsequentLocalePart.getTaint());
        if(subsequentLocalePart.length() > 0)        
        {
            fullLocale.append('_').append(subsequentLocalePart);
        } //End block
        // ---------- Original Method ----------
        //if (subsequentLocalePart.length() > 0) {
      //fullLocale.append('_').append(subsequentLocalePart);
    //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.626 -0400", hash_original_field = "D136F28DA99FB1BAEE2F3425F9A35786", hash_generated_field = "98909880D8EAD8B8385A6005C50C5E65")

    private static Map<String, String> LOCALE_NORMALIZATION_MAP;
    static {
    Map<String, String> normalizationMap = new HashMap<String, String>();
    normalizationMap.put("zh_TW", "zh_Hant");
    normalizationMap.put("zh_HK", "zh_Hant");
    normalizationMap.put("zh_MO", "zh_Hant");
    LOCALE_NORMALIZATION_MAP = Collections.unmodifiableMap(normalizationMap);
  }
    
}

