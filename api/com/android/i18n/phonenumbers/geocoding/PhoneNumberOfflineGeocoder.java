package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneNumberOfflineGeocoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.150 -0400", hash_original_field = "8DDE134A73A97EF1C52A79F2EA1BEA97", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.150 -0400", hash_original_field = "33622575E591C04644E3F61489775F61", hash_generated_field = "92760DB70C2CE2B3E4C70D256B78E2F9")

    private String phonePrefixDataDirectory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.150 -0400", hash_original_field = "08EA8D50D57A6CE9F7C688D3772CFBBF", hash_generated_field = "B412E6CE4E26CA0C92AEBADBE8BA5459")

    private MappingFileProvider mappingFileProvider = new MappingFileProvider();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.150 -0400", hash_original_field = "895771E29DB96A099CF9E48CFDF84278", hash_generated_field = "B5CC7111807DA68B52F2786A0C78F9B7")

    private Map<String, AreaCodeMap> availablePhonePrefixMaps = new HashMap<String, AreaCodeMap>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.150 -0400", hash_original_method = "22A2DBF8A31EE9DB065525841631FE26", hash_generated_method = "3868814D8E0AC4D85442BFE352DF642A")
      PhoneNumberOfflineGeocoder(String phonePrefixDataDirectory) {
        this.phonePrefixDataDirectory = phonePrefixDataDirectory;
        loadMappingFileProvider();
        // ---------- Original Method ----------
        //this.phonePrefixDataDirectory = phonePrefixDataDirectory;
        //loadMappingFileProvider();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.150 -0400", hash_original_method = "E1BB23E7722226D1F2FA0A624B863E50", hash_generated_method = "34D9A04D01486DC7BEDD574D6C9737F0")
    private void loadMappingFileProvider() {
        InputStream source = PhoneNumberOfflineGeocoder.class.getResourceAsStream(phonePrefixDataDirectory + "config");
        ObjectInputStream in = null;
        try 
        {
            in = new ObjectInputStream(source);
            mappingFileProvider.readExternal(in);
        } //End block
        catch (IOException e)
        {
            LOGGER.log(Level.WARNING, e.toString());
        } //End block
        finally 
        {
            close(in);
        } //End block
        // ---------- Original Method ----------
        //InputStream source =
        //PhoneNumberOfflineGeocoder.class.getResourceAsStream(phonePrefixDataDirectory + "config");
        //ObjectInputStream in = null;
        //try {
      //in = new ObjectInputStream(source);
      //mappingFileProvider.readExternal(in);
    //} catch (IOException e) {
      //LOGGER.log(Level.WARNING, e.toString());
    //} finally {
      //close(in);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.151 -0400", hash_original_method = "83306CA98099E8F54D458F6E7B135EF3", hash_generated_method = "2A1B8327D80EEE5174A3A9B748DF5FF4")
    private AreaCodeMap getPhonePrefixDescriptions(
      int countryCallingCode, String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        addTaint(countryCallingCode);
        String fileName = mappingFileProvider.getFileName(countryCallingCode, language, script, region);
    if(fileName.length() == 0)        
        {
AreaCodeMap var540C13E9E156B687226421B24F2DF178_328360302 =             null;
            var540C13E9E156B687226421B24F2DF178_328360302.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_328360302;
        } //End block
    if(!availablePhonePrefixMaps.containsKey(fileName))        
        {
            loadAreaCodeMapFromFile(fileName);
        } //End block
AreaCodeMap var5B1B4B795B719A2CCEF18674C52B5D6E_435183533 =         availablePhonePrefixMaps.get(fileName);
        var5B1B4B795B719A2CCEF18674C52B5D6E_435183533.addTaint(taint);
        return var5B1B4B795B719A2CCEF18674C52B5D6E_435183533;
        // ---------- Original Method ----------
        //String fileName = mappingFileProvider.getFileName(countryCallingCode, language, script, region);
        //if (fileName.length() == 0) {
      //return null;
    //}
        //if (!availablePhonePrefixMaps.containsKey(fileName)) {
      //loadAreaCodeMapFromFile(fileName);
    //}
        //return availablePhonePrefixMaps.get(fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.151 -0400", hash_original_method = "2B0DD58A818613E514EB671D31CFE754", hash_generated_method = "BA04A8E4C19D1AF27233CC65EEDC6DA9")
    private void loadAreaCodeMapFromFile(String fileName) {
        addTaint(fileName.getTaint());
        InputStream source = PhoneNumberOfflineGeocoder.class.getResourceAsStream(phonePrefixDataDirectory + fileName);
        ObjectInputStream in = null;
        try 
        {
            in = new ObjectInputStream(source);
            AreaCodeMap map = new AreaCodeMap();
            map.readExternal(in);
            availablePhonePrefixMaps.put(fileName, map);
        } //End block
        catch (IOException e)
        {
            LOGGER.log(Level.WARNING, e.toString());
        } //End block
        finally 
        {
            close(in);
        } //End block
        // ---------- Original Method ----------
        //InputStream source =
        //PhoneNumberOfflineGeocoder.class.getResourceAsStream(phonePrefixDataDirectory + fileName);
        //ObjectInputStream in = null;
        //try {
      //in = new ObjectInputStream(source);
      //AreaCodeMap map = new AreaCodeMap();
      //map.readExternal(in);
      //availablePhonePrefixMaps.put(fileName, map);
    //} catch (IOException e) {
      //LOGGER.log(Level.WARNING, e.toString());
    //} finally {
      //close(in);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.151 -0400", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "7CE12CBA9981D7C7423F70765D3C0151")
    private void close(InputStream in) {
        addTaint(in.getTaint());
    if(in != null)        
        {
            try 
            {
                in.close();
            } //End block
            catch (IOException e)
            {
                LOGGER.log(Level.WARNING, e.toString());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (in != null) {
      //try {
        //in.close();
      //} catch (IOException e) {
        //LOGGER.log(Level.WARNING, e.toString());
      //}
    //}
    }

    
        public static synchronized PhoneNumberOfflineGeocoder getInstance() {
        if (instance == null) {
      instance = new PhoneNumberOfflineGeocoder(MAPPING_DATA_DIRECTORY);
    }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.151 -0400", hash_original_method = "BFC255CAA5852747525F7A463403B75F", hash_generated_method = "216B8E04C6FB3C70E23A90DDF9E459D9")
    private String getCountryNameForNumber(PhoneNumber number, Locale language) {
        addTaint(language.getTaint());
        addTaint(number.getTaint());
        String regionCode = phoneUtil.getRegionCodeForNumber(number);
String varC942936C1DE055EED6142794CDBBAC27_887384098 =         (regionCode == null || regionCode.equals("ZZ"))
        ? "" : new Locale("", regionCode).getDisplayCountry(language);
        varC942936C1DE055EED6142794CDBBAC27_887384098.addTaint(taint);
        return varC942936C1DE055EED6142794CDBBAC27_887384098;
        // ---------- Original Method ----------
        //String regionCode = phoneUtil.getRegionCodeForNumber(number);
        //return (regionCode == null || regionCode.equals("ZZ"))
        //? "" : new Locale("", regionCode).getDisplayCountry(language);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.151 -0400", hash_original_method = "F67DBDA157A908486C2CB4AE34C3AE55", hash_generated_method = "C5778892751798846627779650D7EEAF")
    public String getDescriptionForValidNumber(PhoneNumber number, Locale languageCode) {
        addTaint(languageCode.getTaint());
        addTaint(number.getTaint());
        String langStr = languageCode.getLanguage();
        String scriptStr = "";
        String regionStr = languageCode.getCountry();
        String areaDescription = getAreaDescriptionForNumber(number, langStr, scriptStr, regionStr);
String varD34CF9974FC14F46EA66AD196503C90F_256722724 =         (areaDescription.length() > 0)
        ? areaDescription : getCountryNameForNumber(number, languageCode);
        varD34CF9974FC14F46EA66AD196503C90F_256722724.addTaint(taint);
        return varD34CF9974FC14F46EA66AD196503C90F_256722724;
        // ---------- Original Method ----------
        //String langStr = languageCode.getLanguage();
        //String scriptStr = "";
        //String regionStr = languageCode.getCountry();
        //String areaDescription =
        //getAreaDescriptionForNumber(number, langStr, scriptStr, regionStr);
        //return (areaDescription.length() > 0)
        //? areaDescription : getCountryNameForNumber(number, languageCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.152 -0400", hash_original_method = "C5758C9E624EBA9DEEAB32D591791FD6", hash_generated_method = "065F4B5FAB327D281FCA94695FE69378")
    public String getDescriptionForNumber(PhoneNumber number, Locale languageCode) {
        addTaint(languageCode.getTaint());
        addTaint(number.getTaint());
    if(!phoneUtil.isValidNumber(number))        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_427181466 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_427181466.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_427181466;
        } //End block
String var4E416BD293427CE8843A4D977CB49767_1895274549 =         getDescriptionForValidNumber(number, languageCode);
        var4E416BD293427CE8843A4D977CB49767_1895274549.addTaint(taint);
        return var4E416BD293427CE8843A4D977CB49767_1895274549;
        // ---------- Original Method ----------
        //if (!phoneUtil.isValidNumber(number)) {
      //return "";
    //}
        //return getDescriptionForValidNumber(number, languageCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.152 -0400", hash_original_method = "0C41F4A14E4338A7839D0DC3A0BBE9E6", hash_generated_method = "7C97B9D08F19E7649DFA26B7FF575759")
    private String getAreaDescriptionForNumber(
      PhoneNumber number, String lang, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(lang.getTaint());
        addTaint(number.getTaint());
        int countryCallingCode = number.getCountryCode();
        int phonePrefix = (countryCallingCode != 1) ?
        countryCallingCode : (1000 + (int) (number.getNationalNumber() / 10000000));
        AreaCodeMap phonePrefixDescriptions = getPhonePrefixDescriptions(phonePrefix, lang, script, region);
String var2B27E3BBA63F45F369F65694B5848533_135488492 =         (phonePrefixDescriptions != null) ? phonePrefixDescriptions.lookup(number) : "";
        var2B27E3BBA63F45F369F65694B5848533_135488492.addTaint(taint);
        return var2B27E3BBA63F45F369F65694B5848533_135488492;
        // ---------- Original Method ----------
        //int countryCallingCode = number.getCountryCode();
        //int phonePrefix = (countryCallingCode != 1) ?
        //countryCallingCode : (1000 + (int) (number.getNationalNumber() / 10000000));
        //AreaCodeMap phonePrefixDescriptions =
        //getPhonePrefixDescriptions(phonePrefix, lang, script, region);
        //return (phonePrefixDescriptions != null) ? phonePrefixDescriptions.lookup(number) : "";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.152 -0400", hash_original_field = "A81ED48CF13BC1CB56AE4320709DE841", hash_generated_field = "E956C1F9B0B8D1D3733E94DD57FB1DEA")

    private static PhoneNumberOfflineGeocoder instance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.152 -0400", hash_original_field = "B1A3A23763D84E23AE209194AB372A81", hash_generated_field = "0FB1175094D23C4E6E63D4DF27FF59A7")

    private static final String MAPPING_DATA_DIRECTORY = "/com/android/i18n/phonenumbers/geocoding/data/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:16.152 -0400", hash_original_field = "3814AF29A771E7FC7DB7B9B5BC67E1C9", hash_generated_field = "97B9B12074A1BC1CA5A6C6270FD6D366")

    private static final Logger LOGGER = Logger.getLogger(PhoneNumberOfflineGeocoder.class.getName());
}

