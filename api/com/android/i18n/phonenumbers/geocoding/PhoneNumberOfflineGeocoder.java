package com.android.i18n.phonenumbers.geocoding;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;



public class PhoneNumberOfflineGeocoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.650 -0400", hash_original_field = "8DDE134A73A97EF1C52A79F2EA1BEA97", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.651 -0400", hash_original_field = "33622575E591C04644E3F61489775F61", hash_generated_field = "92760DB70C2CE2B3E4C70D256B78E2F9")

    private String phonePrefixDataDirectory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.651 -0400", hash_original_field = "08EA8D50D57A6CE9F7C688D3772CFBBF", hash_generated_field = "B412E6CE4E26CA0C92AEBADBE8BA5459")

    private MappingFileProvider mappingFileProvider = new MappingFileProvider();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.651 -0400", hash_original_field = "895771E29DB96A099CF9E48CFDF84278", hash_generated_field = "B5CC7111807DA68B52F2786A0C78F9B7")

    private Map<String, AreaCodeMap> availablePhonePrefixMaps = new HashMap<String, AreaCodeMap>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.651 -0400", hash_original_method = "22A2DBF8A31EE9DB065525841631FE26", hash_generated_method = "3868814D8E0AC4D85442BFE352DF642A")
      PhoneNumberOfflineGeocoder(String phonePrefixDataDirectory) {
        this.phonePrefixDataDirectory = phonePrefixDataDirectory;
        loadMappingFileProvider();
        // ---------- Original Method ----------
        //this.phonePrefixDataDirectory = phonePrefixDataDirectory;
        //loadMappingFileProvider();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.652 -0400", hash_original_method = "E1BB23E7722226D1F2FA0A624B863E50", hash_generated_method = "34D9A04D01486DC7BEDD574D6C9737F0")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.652 -0400", hash_original_method = "83306CA98099E8F54D458F6E7B135EF3", hash_generated_method = "49E5C8085DECED4CA3C06D8F44B10D81")
    private AreaCodeMap getPhonePrefixDescriptions(
      int countryCallingCode, String language, String script, String region) {
        addTaint(region.getTaint());
        addTaint(script.getTaint());
        addTaint(language.getTaint());
        addTaint(countryCallingCode);
        String fileName = mappingFileProvider.getFileName(countryCallingCode, language, script, region);
        if(fileName.length() == 0)        
        {
AreaCodeMap var540C13E9E156B687226421B24F2DF178_1990855275 =             null;
            var540C13E9E156B687226421B24F2DF178_1990855275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1990855275;
        } //End block
        if(!availablePhonePrefixMaps.containsKey(fileName))        
        {
            loadAreaCodeMapFromFile(fileName);
        } //End block
AreaCodeMap var5B1B4B795B719A2CCEF18674C52B5D6E_511753923 =         availablePhonePrefixMaps.get(fileName);
        var5B1B4B795B719A2CCEF18674C52B5D6E_511753923.addTaint(taint);
        return var5B1B4B795B719A2CCEF18674C52B5D6E_511753923;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.653 -0400", hash_original_method = "2B0DD58A818613E514EB671D31CFE754", hash_generated_method = "BA04A8E4C19D1AF27233CC65EEDC6DA9")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.654 -0400", hash_original_method = "A1113EBAB3D0682FE612F1231142344C", hash_generated_method = "7CE12CBA9981D7C7423F70765D3C0151")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.654 -0400", hash_original_method = "BFC255CAA5852747525F7A463403B75F", hash_generated_method = "FE328D3AAC5D10DA5E0EB740B4DD3139")
    private String getCountryNameForNumber(PhoneNumber number, Locale language) {
        addTaint(language.getTaint());
        addTaint(number.getTaint());
        String regionCode = phoneUtil.getRegionCodeForNumber(number);
String varC942936C1DE055EED6142794CDBBAC27_698902791 =         (regionCode == null || regionCode.equals("ZZ"))
        ? "" : new Locale("", regionCode).getDisplayCountry(language);
        varC942936C1DE055EED6142794CDBBAC27_698902791.addTaint(taint);
        return varC942936C1DE055EED6142794CDBBAC27_698902791;
        // ---------- Original Method ----------
        //String regionCode = phoneUtil.getRegionCodeForNumber(number);
        //return (regionCode == null || regionCode.equals("ZZ"))
        //? "" : new Locale("", regionCode).getDisplayCountry(language);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.655 -0400", hash_original_method = "F67DBDA157A908486C2CB4AE34C3AE55", hash_generated_method = "60CB4A0EFBFFAB6551C91DD7AFFA82DD")
    public String getDescriptionForValidNumber(PhoneNumber number, Locale languageCode) {
        addTaint(languageCode.getTaint());
        addTaint(number.getTaint());
        String langStr = languageCode.getLanguage();
        String scriptStr = "";
        String regionStr = languageCode.getCountry();
        String areaDescription = getAreaDescriptionForNumber(number, langStr, scriptStr, regionStr);
String varD34CF9974FC14F46EA66AD196503C90F_1440715086 =         (areaDescription.length() > 0)
        ? areaDescription : getCountryNameForNumber(number, languageCode);
        varD34CF9974FC14F46EA66AD196503C90F_1440715086.addTaint(taint);
        return varD34CF9974FC14F46EA66AD196503C90F_1440715086;
        // ---------- Original Method ----------
        //String langStr = languageCode.getLanguage();
        //String scriptStr = "";
        //String regionStr = languageCode.getCountry();
        //String areaDescription =
        //getAreaDescriptionForNumber(number, langStr, scriptStr, regionStr);
        //return (areaDescription.length() > 0)
        //? areaDescription : getCountryNameForNumber(number, languageCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.655 -0400", hash_original_method = "C5758C9E624EBA9DEEAB32D591791FD6", hash_generated_method = "2AE19D27668056CE10ABC5B24F6FC774")
    public String getDescriptionForNumber(PhoneNumber number, Locale languageCode) {
        addTaint(languageCode.getTaint());
        addTaint(number.getTaint());
        if(!phoneUtil.isValidNumber(number))        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1345758345 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1345758345.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1345758345;
        } //End block
String var4E416BD293427CE8843A4D977CB49767_280535443 =         getDescriptionForValidNumber(number, languageCode);
        var4E416BD293427CE8843A4D977CB49767_280535443.addTaint(taint);
        return var4E416BD293427CE8843A4D977CB49767_280535443;
        // ---------- Original Method ----------
        //if (!phoneUtil.isValidNumber(number)) {
      //return "";
    //}
        //return getDescriptionForValidNumber(number, languageCode);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.656 -0400", hash_original_method = "0C41F4A14E4338A7839D0DC3A0BBE9E6", hash_generated_method = "6A614FCFE6816765BC99093DFCC9E23B")
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
String var2B27E3BBA63F45F369F65694B5848533_859484693 =         (phonePrefixDescriptions != null) ? phonePrefixDescriptions.lookup(number) : "";
        var2B27E3BBA63F45F369F65694B5848533_859484693.addTaint(taint);
        return var2B27E3BBA63F45F369F65694B5848533_859484693;
        // ---------- Original Method ----------
        //int countryCallingCode = number.getCountryCode();
        //int phonePrefix = (countryCallingCode != 1) ?
        //countryCallingCode : (1000 + (int) (number.getNationalNumber() / 10000000));
        //AreaCodeMap phonePrefixDescriptions =
        //getPhonePrefixDescriptions(phonePrefix, lang, script, region);
        //return (phonePrefixDescriptions != null) ? phonePrefixDescriptions.lookup(number) : "";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.656 -0400", hash_original_field = "A81ED48CF13BC1CB56AE4320709DE841", hash_generated_field = "E956C1F9B0B8D1D3733E94DD57FB1DEA")

    private static PhoneNumberOfflineGeocoder instance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.656 -0400", hash_original_field = "B1A3A23763D84E23AE209194AB372A81", hash_generated_field = "0FB1175094D23C4E6E63D4DF27FF59A7")

    private static final String MAPPING_DATA_DIRECTORY = "/com/android/i18n/phonenumbers/geocoding/data/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.656 -0400", hash_original_field = "3814AF29A771E7FC7DB7B9B5BC67E1C9", hash_generated_field = "97B9B12074A1BC1CA5A6C6270FD6D366")

    private static final Logger LOGGER = Logger.getLogger(PhoneNumberOfflineGeocoder.class.getName());
}

