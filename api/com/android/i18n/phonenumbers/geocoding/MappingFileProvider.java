package com.android.i18n.phonenumbers.geocoding;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.476 -0400", hash_original_field = "69F496FCE87C6BC7DC2D0257BB43A268", hash_generated_field = "3E0B4451FC75BFBEA7BE0888ADA52D93")

    private int numOfEntries = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.476 -0400", hash_original_field = "8F1EF5DE313B3CF3485F9D5F2024448D", hash_generated_field = "5D843B062DC0F709662151020D18BCC2")

    private int[] countryCallingCodes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.477 -0400", hash_original_field = "C59A8EB3CF7DF10278F316915F723451", hash_generated_field = "297401D4476B3C0539FAD27EE481B768")

    private List<Set<String>> availableLanguages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.477 -0400", hash_original_method = "8FB53B01F748B2BCB846F8E0ABF1A4BF", hash_generated_method = "E1EA2CA8DCBD71E4D8727E1C0D169F8E")
    public  MappingFileProvider() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.119 -0400", hash_original_method = "2C1785672959EEFC03879AF7408DB866", hash_generated_method = "6EAE1C7997A2232323DE446F3607DAA0")
    public void readFileConfigs(SortedMap<Integer, Set<String>> availableDataFiles) {
        numOfEntries = availableDataFiles.size();
        countryCallingCodes = new int[numOfEntries];
        availableLanguages = new ArrayList<Set<String>>(numOfEntries);
        int index = 0;
for(int countryCallingCode : availableDataFiles.keySet())
        {
            countryCallingCodes[index++] = countryCallingCode;
            availableLanguages.add(new HashSet<String>(availableDataFiles.get(countryCallingCode)));
        } 
        
        
        
        
        
        
      
      
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.120 -0400", hash_original_method = "A5B4139EF2A7D591E843D1D3DA56504C", hash_generated_method = "C0608A0E6F919483BF8AC84100E8ED1D")
    public void readExternal(ObjectInput objectInput) throws IOException {
        numOfEntries = objectInput.readInt();
    if(countryCallingCodes == null || countryCallingCodes.length < numOfEntries)        
        {
            countryCallingCodes = new int[numOfEntries];
        } 
    if(availableLanguages == null)        
        {
            availableLanguages = new ArrayList<Set<String>>();
        } 
for(int i = 0;i < numOfEntries;i++)
        {
            countryCallingCodes[i] = objectInput.readInt();
            int numOfLangs = objectInput.readInt();
            Set<String> setOfLangs = new HashSet<String>();
for(int j = 0;j < numOfLangs;j++)
            {
                setOfLangs.add(objectInput.readUTF());
            } 
            availableLanguages.add(setOfLangs);
        } 
        
        
        
      
    
        
      
    
        
      
      
      
      
        
      
      
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.120 -0400", hash_original_method = "E326CA0D62F025609F12A4A9B87E4431", hash_generated_method = "7908203CB08C559DD3A7651FC267DF4E")
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
            } 
        } 
        
        
        
      
      
      
      
      
        
      
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.121 -0400", hash_original_method = "17C0EB7BC2271962455DE53D535BEB5E", hash_generated_method = "BAFC8308267C5EB0C6148E865EE406ED")
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
            } 
            output.append('\n');
        } 
String varEBF0387156E2D98F471F997058C674A5_53003265 =         output.toString();
        varEBF0387156E2D98F471F997058C674A5_53003265.addTaint(taint);
        return varEBF0387156E2D98F471F997058C674A5_53003265;
        
        
        
      
      
      
      
        
        
      
      
    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.121 -0400", hash_original_method = "F40661B16774EA00988010D992802DCB", hash_generated_method = "EB57F10B51E49F4F426E9A9F19FC10AA")
     String getFileName(int countryCallingCode, String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        addTaint(countryCallingCode);
    if(language.length() == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_340122738 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_340122738.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_340122738;
        } 
        int index = Arrays.binarySearch(countryCallingCodes, countryCallingCode);
    if(index < 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1976169662 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1976169662.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1976169662;
        } 
        Set<String> setOfLangs = availableLanguages.get(index);
    if(setOfLangs.size() > 0)        
        {
            String languageCode = findBestMatchingLanguageCode(setOfLangs, language, script, region);
    if(languageCode.length() > 0)            
            {
                StringBuilder fileName = new StringBuilder();
                fileName.append(countryCallingCode).append('_').append(languageCode);
String var43BA8F2DD2C0F2EB249ACFEE2BFD792C_1409318178 =                 fileName.toString();
                var43BA8F2DD2C0F2EB249ACFEE2BFD792C_1409318178.addTaint(taint);
                return var43BA8F2DD2C0F2EB249ACFEE2BFD792C_1409318178;
            } 
        } 
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_490548417 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_490548417.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_490548417;
        
        
      
    
        
        
      
    
        
        
      
      
        
        
        
      
    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.122 -0400", hash_original_method = "18F97AE37D6D32FF4C5E8DE16502349B", hash_generated_method = "00FAC165EFC69AD8D13247959F21542D")
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
String var4F21C8D8A98FB4F4085BDD1058E274A3_1190933388 =                 normalizedLocale;
                var4F21C8D8A98FB4F4085BDD1058E274A3_1190933388.addTaint(taint);
                return var4F21C8D8A98FB4F4085BDD1058E274A3_1190933388;
            } 
        } 
    if(setOfLangs.contains(fullLocaleStr))        
        {
String varABD38B61BC1463D561DF0B5C9D9373DC_1495543695 =             fullLocaleStr;
            varABD38B61BC1463D561DF0B5C9D9373DC_1495543695.addTaint(taint);
            return varABD38B61BC1463D561DF0B5C9D9373DC_1495543695;
        } 
    if(onlyOneOfScriptOrRegionIsEmpty(script, region))        
        {
    if(setOfLangs.contains(language))            
            {
String var9CB6700F2CAEB604A10339BD9223F8CA_1197940294 =                 language;
                var9CB6700F2CAEB604A10339BD9223F8CA_1197940294.addTaint(taint);
                return var9CB6700F2CAEB604A10339BD9223F8CA_1197940294;
            } 
        } 
        else
    if(script.length() > 0 && region.length() > 0)        
        {
            StringBuilder langWithScript = new StringBuilder(language).append('_').append(script);
            String langWithScriptStr = langWithScript.toString();
    if(setOfLangs.contains(langWithScriptStr))            
            {
String varF400C0A70FA82FC6FF75E78191F0FEE3_1713129684 =                 langWithScriptStr;
                varF400C0A70FA82FC6FF75E78191F0FEE3_1713129684.addTaint(taint);
                return varF400C0A70FA82FC6FF75E78191F0FEE3_1713129684;
            } 
            StringBuilder langWithRegion = new StringBuilder(language).append('_').append(region);
            String langWithRegionStr = langWithRegion.toString();
    if(setOfLangs.contains(langWithRegionStr))            
            {
String var1EF1FABAB075CBFCECF61B0B93FECE86_141457791 =                 langWithRegionStr;
                var1EF1FABAB075CBFCECF61B0B93FECE86_141457791.addTaint(taint);
                return var1EF1FABAB075CBFCECF61B0B93FECE86_141457791;
            } 
    if(setOfLangs.contains(language))            
            {
String var9CB6700F2CAEB604A10339BD9223F8CA_106847621 =                 language;
                var9CB6700F2CAEB604A10339BD9223F8CA_106847621.addTaint(taint);
                return var9CB6700F2CAEB604A10339BD9223F8CA_106847621;
            } 
        } 
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1742093200 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1742093200.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1742093200;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.123 -0400", hash_original_method = "AAED8563DDED3C53862CE4371524442C", hash_generated_method = "A72F85873CF38D3A5CABBE9B9B972F80")
    private boolean onlyOneOfScriptOrRegionIsEmpty(String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        boolean var8EE7BA4ABB3A7F4D7885F2EBBDA4D7C0_1989021261 = ((script.length() == 0 && region.length() > 0) ||
            (region.length() == 0 && script.length() > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912366445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912366445;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.123 -0400", hash_original_method = "67AD4EAACC19DF5D4391EFA1CE27EABA", hash_generated_method = "C60FD19CC33C517FCCB9D3B29BC66D6E")
    private StringBuilder constructFullLocale(String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        StringBuilder fullLocale = new StringBuilder(language);
        appendSubsequentLocalePart(script, fullLocale);
        appendSubsequentLocalePart(region, fullLocale);
StringBuilder var690DC80614311B79D32C7436393D703D_2039121957 =         fullLocale;
        var690DC80614311B79D32C7436393D703D_2039121957.addTaint(taint);
        return var690DC80614311B79D32C7436393D703D_2039121957;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.123 -0400", hash_original_method = "A3149B7498B5162CA69A1D6F38AF4B31", hash_generated_method = "13DCF82EAE07D2565C97EFBC6B5DE69D")
    private void appendSubsequentLocalePart(String subsequentLocalePart, StringBuilder fullLocale) {
        addTaint(fullLocale.getTaint());
        addTaint(subsequentLocalePart.getTaint());
    if(subsequentLocalePart.length() > 0)        
        {
            fullLocale.append('_').append(subsequentLocalePart);
        } 
        
        
      
    
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.124 -0400", hash_original_field = "D136F28DA99FB1BAEE2F3425F9A35786", hash_generated_field = "98909880D8EAD8B8385A6005C50C5E65")

    private static Map<String, String> LOCALE_NORMALIZATION_MAP;
    static {
    Map<String, String> normalizationMap = new HashMap<String, String>();
    normalizationMap.put("zh_TW", "zh_Hant");
    normalizationMap.put("zh_HK", "zh_Hant");
    normalizationMap.put("zh_MO", "zh_Hant");
    LOCALE_NORMALIZATION_MAP = Collections.unmodifiableMap(normalizationMap);
  }
    
}

