package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;






public class AsYouTypeFormatter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "587DFC21273768F857001AF4DED4A6C2", hash_generated_field = "0C350DE511BE7B52540BBA3416D1A46C")

    private String currentOutput = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "9C7B57FCC2047555285BE852A4B2943F", hash_generated_field = "09F9323AC7F5DB51B79E6FB4689A0073")

    private StringBuilder formattingTemplate = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "4FBD98FDDEE7B846B71DF829DFC1C978", hash_generated_field = "6A54B02BA2C7E4165F427873C017B488")

    private String currentFormattingPattern = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "0EE2ED1280BE50DC5A0B71C01B505EF2", hash_generated_field = "29CDE2D2FAA8268827B1B884DC2F18BA")

    private StringBuilder accruedInput = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "48E61261D0E6A721DDE49948BAE6E5FB", hash_generated_field = "E579FAA49690664D33A278DEA0E8B5A6")

    private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "C6C6C291305739DAC8EFBEF0C9C86773", hash_generated_field = "2095ACFBFC258F92C73D192F518E00D7")

    private boolean ableToFormat = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "84A093E41F72D463AA839067E1B4DC2D", hash_generated_field = "168C680E9820B2FFBEB1B9E07688ACEE")

    private boolean isInternationalFormatting = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "FAFF8308CA553E2E22D15CCA48E047D9", hash_generated_field = "9C2BB325FBB2EC7864F760CFE394F16E")

    private boolean isExpectingCountryCallingCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "8DDE134A73A97EF1C52A79F2EA1BEA97", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "65B2F933146CFA88C7D3B8E0FFCB3603", hash_generated_field = "6FD38F26B0E8DBBA6EF73F09FB6B4141")

    private String defaultCountry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "3BBE52C5C6888410EE33760B1B194818", hash_generated_field = "120A053E2F4E55161B2E4207EE1C05CF")

    private PhoneMetadata defaultMetaData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "ECC8858CCAF9726976F895C4946EC91F", hash_generated_field = "35B49383D60A264DAE321C3C26CE1990")

    private PhoneMetadata currentMetaData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "C57C6C03AC264E94F23DA5BDEAC85E70", hash_generated_field = "23C1B63DC4A3B45E60BB35F865EFF73E")

    private String digitPlaceholder = "\u2008";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "AFFA108041D9C7C6B1F036D62D2C3AB3", hash_generated_field = "A012D752824ECE91B83A6649421B0E5D")

    private Pattern digitPattern = Pattern.compile(digitPlaceholder);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.514 -0400", hash_original_field = "7A0EE11C8BC5F6F4825317CF1BEB784B", hash_generated_field = "118190E2A789D8F137699A3B010FBDD5")

    private int lastMatchPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_field = "555F90F22B033B3B3225B5F9914F20EC", hash_generated_field = "AAA5D18DEE083F7BBA851AA262F094CB")

    private int originalPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_field = "BF1413E6C4EB4C0A0714AE4F41C37666", hash_generated_field = "8C72AA3A3DE1D2EFB37D75F2D908776F")

    private int positionToRemember = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_field = "3777965CF9620D0EC3EF9D148ED3ADAF", hash_generated_field = "E91BED07269C3A918A7C430BB9D5D341")

    private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_field = "0B2CD1BEAC92768B16F5279A28B974BF", hash_generated_field = "5578ADECAFE9EAFCE3065ED8EBE1D841")

    private StringBuilder nationalNumber = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_field = "4F05C64762A4432672AD2501E8DF3569", hash_generated_field = "23CDF3D9149C891AD1D66C6C35974D4E")

    private List<NumberFormat> possibleFormats = new ArrayList<NumberFormat>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_field = "FC60034C5DB0EEBE16CF2AFE16BDD383", hash_generated_field = "FEE3B86D57B366ADF75BCFCDCCAF1CE3")

    private RegexCache regexCache = new RegexCache(64);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.515 -0400", hash_original_method = "936F5C412B2E8DF425145B47DD5CAEF0", hash_generated_method = "FE3B8DF7E339A94E519494A3A5DB6E47")
      AsYouTypeFormatter(String regionCode) {
        defaultCountry = regionCode;
        currentMetaData = getMetadataForRegion(defaultCountry);
        defaultMetaData = currentMetaData;
        // ---------- Original Method ----------
        //defaultCountry = regionCode;
        //currentMetaData = getMetadataForRegion(defaultCountry);
        //defaultMetaData = currentMetaData;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.516 -0400", hash_original_method = "881E62338E39DD444804F246615E6E62", hash_generated_method = "952C1E7A73F7A9247FA925266BC0A5BF")
    private PhoneMetadata getMetadataForRegion(String regionCode) {
        addTaint(regionCode.getTaint());
        int countryCallingCode = phoneUtil.getCountryCodeForRegion(regionCode);
        String mainCountry = phoneUtil.getRegionCodeForCountryCode(countryCallingCode);
        PhoneMetadata metadata = phoneUtil.getMetadataForRegion(mainCountry);
        if(metadata != null)        
        {
PhoneMetadata varDD4984A0B7A246C66EA6810C1C4348D7_2109606384 =             metadata;
            varDD4984A0B7A246C66EA6810C1C4348D7_2109606384.addTaint(taint);
            return varDD4984A0B7A246C66EA6810C1C4348D7_2109606384;
        } //End block
PhoneMetadata varFBEA0CBA6FC02D2747A4C6810F21686A_1942009525 =         EMPTY_METADATA;
        varFBEA0CBA6FC02D2747A4C6810F21686A_1942009525.addTaint(taint);
        return varFBEA0CBA6FC02D2747A4C6810F21686A_1942009525;
        // ---------- Original Method ----------
        //int countryCallingCode = phoneUtil.getCountryCodeForRegion(regionCode);
        //String mainCountry = phoneUtil.getRegionCodeForCountryCode(countryCallingCode);
        //PhoneMetadata metadata = phoneUtil.getMetadataForRegion(mainCountry);
        //if (metadata != null) {
      //return metadata;
    //}
        //return EMPTY_METADATA;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.516 -0400", hash_original_method = "AB8E8EDD80C278D4452E081702FFED46", hash_generated_method = "8DE8F24EE2777049577C42149F0B6CA2")
    private boolean maybeCreateNewTemplate() {
        Iterator<NumberFormat> it = possibleFormats.iterator();
        while
(it.hasNext())        
        {
            NumberFormat numberFormat = it.next();
            String pattern = numberFormat.getPattern();
            if(currentFormattingPattern.equals(pattern))            
            {
                boolean var68934A3E9455FA72420237EB05902327_128927763 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659411561 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659411561;
            } //End block
            if(createFormattingTemplate(numberFormat))            
            {
                currentFormattingPattern = pattern;
                boolean varB326B5062B2F0E69046810717534CB09_915331014 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345820455 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_345820455;
            } //End block
            else
            {
                it.remove();
            } //End block
        } //End block
        ableToFormat = false;
        boolean var68934A3E9455FA72420237EB05902327_861117788 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275388695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275388695;
        // ---------- Original Method ----------
        //Iterator<NumberFormat> it = possibleFormats.iterator();
        //while (it.hasNext()) {
      //NumberFormat numberFormat = it.next();
      //String pattern = numberFormat.getPattern();
      //if (currentFormattingPattern.equals(pattern)) {
        //return false;
      //}
      //if (createFormattingTemplate(numberFormat)) {
        //currentFormattingPattern = pattern;
        //return true;
      //} else {  
        //it.remove();
      //}
    //}
        //ableToFormat = false;
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.517 -0400", hash_original_method = "37D81E1E00F803BB98B41301D27D6488", hash_generated_method = "3DE1E8001B5B6BA849F349A4FD48B6DC")
    private void getAvailableFormats(String leadingThreeDigits) {
        addTaint(leadingThreeDigits.getTaint());
        List<NumberFormat> formatList = (isInternationalFormatting && currentMetaData.intlNumberFormatSize() > 0)
        ? currentMetaData.intlNumberFormats()
        : currentMetaData.numberFormats();
for(NumberFormat format : formatList)
        {
            if(isFormatEligible(format.getFormat()))            
            {
                possibleFormats.add(format);
            } //End block
        } //End block
        narrowDownPossibleFormats(leadingThreeDigits);
        // ---------- Original Method ----------
        //List<NumberFormat> formatList =
        //(isInternationalFormatting && currentMetaData.intlNumberFormatSize() > 0)
        //? currentMetaData.intlNumberFormats()
        //: currentMetaData.numberFormats();
        //for (NumberFormat format : formatList) {
      //if (isFormatEligible(format.getFormat())) {
        //possibleFormats.add(format);
      //}
    //}
        //narrowDownPossibleFormats(leadingThreeDigits);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.517 -0400", hash_original_method = "0CD8D9B07AADCF252FD63C0FF91E8BCD", hash_generated_method = "ADD0A99F977BF10579D8AB69AC584F87")
    private boolean isFormatEligible(String format) {
        addTaint(format.getTaint());
        boolean varB3190CE6520D441E523F03940FE5C969_243380696 = (ELIGIBLE_FORMAT_PATTERN.matcher(format).matches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043297098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043297098;
        // ---------- Original Method ----------
        //return ELIGIBLE_FORMAT_PATTERN.matcher(format).matches();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.518 -0400", hash_original_method = "3E367C813BED2017BCCC9CAE77808F34", hash_generated_method = "48D31EC47ABE2BB257B8250E6754C3F3")
    private void narrowDownPossibleFormats(String leadingDigits) {
        addTaint(leadingDigits.getTaint());
        int indexOfLeadingDigitsPattern = leadingDigits.length() - MIN_LEADING_DIGITS_LENGTH;
        Iterator<NumberFormat> it = possibleFormats.iterator();
        while
(it.hasNext())        
        {
            NumberFormat format = it.next();
            if(format.leadingDigitsPatternSize() > indexOfLeadingDigitsPattern)            
            {
                Pattern leadingDigitsPattern = regexCache.getPatternForRegex(
                format.getLeadingDigitsPattern(indexOfLeadingDigitsPattern));
                Matcher m = leadingDigitsPattern.matcher(leadingDigits);
                if(!m.lookingAt())                
                {
                    it.remove();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int indexOfLeadingDigitsPattern = leadingDigits.length() - MIN_LEADING_DIGITS_LENGTH;
        //Iterator<NumberFormat> it = possibleFormats.iterator();
        //while (it.hasNext()) {
      //NumberFormat format = it.next();
      //if (format.leadingDigitsPatternSize() > indexOfLeadingDigitsPattern) {
        //Pattern leadingDigitsPattern =
            //regexCache.getPatternForRegex(
                //format.getLeadingDigitsPattern(indexOfLeadingDigitsPattern));
        //Matcher m = leadingDigitsPattern.matcher(leadingDigits);
        //if (!m.lookingAt()) {
          //it.remove();
        //}
      //} 
    //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.519 -0400", hash_original_method = "2542CBCB3D3982D996EED604A627F745", hash_generated_method = "4D3E7149A0251AD196AD38B82BBD8E06")
    private boolean createFormattingTemplate(NumberFormat format) {
        addTaint(format.getTaint());
        String numberPattern = format.getPattern();
        if(numberPattern.indexOf('|') != -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1801660832 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056251729 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056251729;
        } //End block
        numberPattern = CHARACTER_CLASS_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        numberPattern = STANDALONE_DIGIT_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        formattingTemplate.setLength(0);
        String tempTemplate = getFormattingTemplate(numberPattern, format.getFormat());
        if(tempTemplate.length() > 0)        
        {
            formattingTemplate.append(tempTemplate);
            boolean varB326B5062B2F0E69046810717534CB09_272760855 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606000679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606000679;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1625757812 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2055764072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2055764072;
        // ---------- Original Method ----------
        //String numberPattern = format.getPattern();
        //if (numberPattern.indexOf('|') != -1) {
      //return false;
    //}
        //numberPattern = CHARACTER_CLASS_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        //numberPattern = STANDALONE_DIGIT_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        //formattingTemplate.setLength(0);
        //String tempTemplate = getFormattingTemplate(numberPattern, format.getFormat());
        //if (tempTemplate.length() > 0) {
      //formattingTemplate.append(tempTemplate);
      //return true;
    //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.519 -0400", hash_original_method = "D11FAAF63EBAF37B7C1EC170EAFCD005", hash_generated_method = "7710D7F1ABDC37DDF520A34DDCE1F90A")
    private String getFormattingTemplate(String numberPattern, String numberFormat) {
        addTaint(numberFormat.getTaint());
        addTaint(numberPattern.getTaint());
        String longestPhoneNumber = "999999999999999";
        Matcher m = regexCache.getPatternForRegex(numberPattern).matcher(longestPhoneNumber);
        m.find();
        String aPhoneNumber = m.group();
        if(aPhoneNumber.length() < nationalNumber.length())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1747187389 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1747187389.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1747187389;
        } //End block
        String template = aPhoneNumber.replaceAll(numberPattern, numberFormat);
        template = template.replaceAll("9", digitPlaceholder);
String var09CEB08BD4344BF0DF3CD0571C30EE3D_2147363592 =         template;
        var09CEB08BD4344BF0DF3CD0571C30EE3D_2147363592.addTaint(taint);
        return var09CEB08BD4344BF0DF3CD0571C30EE3D_2147363592;
        // ---------- Original Method ----------
        //String longestPhoneNumber = "999999999999999";
        //Matcher m = regexCache.getPatternForRegex(numberPattern).matcher(longestPhoneNumber);
        //m.find();
        //String aPhoneNumber = m.group();
        //if (aPhoneNumber.length() < nationalNumber.length()) {
      //return "";
    //}
        //String template = aPhoneNumber.replaceAll(numberPattern, numberFormat);
        //template = template.replaceAll("9", digitPlaceholder);
        //return template;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.521 -0400", hash_original_method = "8F04C2F49656580CD2F07A034451AAD3", hash_generated_method = "A2D19CBC5012A97B0F24A634FB8A6122")
    public void clear() {
        currentOutput = "";
        accruedInput.setLength(0);
        accruedInputWithoutFormatting.setLength(0);
        formattingTemplate.setLength(0);
        lastMatchPosition = 0;
        currentFormattingPattern = "";
        prefixBeforeNationalNumber.setLength(0);
        nationalNumber.setLength(0);
        ableToFormat = true;
        positionToRemember = 0;
        originalPosition = 0;
        isInternationalFormatting = false;
        isExpectingCountryCallingCode = false;
        possibleFormats.clear();
        if(!currentMetaData.equals(defaultMetaData))        
        {
            currentMetaData = getMetadataForRegion(defaultCountry);
        } //End block
        // ---------- Original Method ----------
        //currentOutput = "";
        //accruedInput.setLength(0);
        //accruedInputWithoutFormatting.setLength(0);
        //formattingTemplate.setLength(0);
        //lastMatchPosition = 0;
        //currentFormattingPattern = "";
        //prefixBeforeNationalNumber.setLength(0);
        //nationalNumber.setLength(0);
        //ableToFormat = true;
        //positionToRemember = 0;
        //originalPosition = 0;
        //isInternationalFormatting = false;
        //isExpectingCountryCallingCode = false;
        //possibleFormats.clear();
        //if (!currentMetaData.equals(defaultMetaData)) {
      //currentMetaData = getMetadataForRegion(defaultCountry);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.521 -0400", hash_original_method = "F7260472EF36A540999D13D4CAA6ECE9", hash_generated_method = "BD5886E68113E716ECC0752BE40081DF")
    public String inputDigit(char nextChar) {
        currentOutput = inputDigitWithOptionToRememberPosition(nextChar, false);
String var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1900589315 =         currentOutput;
        var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1900589315.addTaint(taint);
        return var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1900589315;
        // ---------- Original Method ----------
        //currentOutput = inputDigitWithOptionToRememberPosition(nextChar, false);
        //return currentOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.521 -0400", hash_original_method = "5CF2674AEE53F09D43FB9E46A011FFC0", hash_generated_method = "C28AA6AD9E16EB898899AA00EE924AC1")
    public String inputDigitAndRememberPosition(char nextChar) {
        currentOutput = inputDigitWithOptionToRememberPosition(nextChar, true);
String var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1298965236 =         currentOutput;
        var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1298965236.addTaint(taint);
        return var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1298965236;
        // ---------- Original Method ----------
        //currentOutput = inputDigitWithOptionToRememberPosition(nextChar, true);
        //return currentOutput;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.523 -0400", hash_original_method = "6C89C7F3A0AAC3A12D8456578D2D5E4E", hash_generated_method = "651FBF2F86F13FE5E83163F866916431")
    @SuppressWarnings("fallthrough")
    private String inputDigitWithOptionToRememberPosition(char nextChar, boolean rememberPosition) {
        addTaint(rememberPosition);
        addTaint(nextChar);
        accruedInput.append(nextChar);
        if(rememberPosition)        
        {
            originalPosition = accruedInput.length();
        } //End block
        if(!isDigitOrLeadingPlusSign(nextChar))        
        {
            ableToFormat = false;
        } //End block
        if(!ableToFormat)        
        {
String var5DA4F23BDAFA099675D0A84B89FB971F_292587652 =             accruedInput.toString();
            var5DA4F23BDAFA099675D0A84B89FB971F_292587652.addTaint(taint);
            return var5DA4F23BDAFA099675D0A84B89FB971F_292587652;
        } //End block
        nextChar = normalizeAndAccrueDigitsAndPlusSign(nextChar, rememberPosition);
switch(accruedInputWithoutFormatting.length()){
        case 0:
        case 1:
        case 2:
String var5DA4F23BDAFA099675D0A84B89FB971F_1690449541 =         accruedInput.toString();
        var5DA4F23BDAFA099675D0A84B89FB971F_1690449541.addTaint(taint);
        return var5DA4F23BDAFA099675D0A84B89FB971F_1690449541;
        case 3:
        if(attemptToExtractIdd())        
        {
            isExpectingCountryCallingCode = true;
        } //End block
        else
        {
            removeNationalPrefixFromNationalNumber();
String var6E079CFAB6A3F75F2D894571ED8C37B5_1161988266 =             attemptToChooseFormattingPattern();
            var6E079CFAB6A3F75F2D894571ED8C37B5_1161988266.addTaint(taint);
            return var6E079CFAB6A3F75F2D894571ED8C37B5_1161988266;
        } //End block
        case 4:
        case 5:
        if(isExpectingCountryCallingCode)        
        {
            if(attemptToExtractCountryCallingCode())            
            {
                isExpectingCountryCallingCode = false;
            } //End block
String varC50A07DAEE4370E981DA39BFDFC4411F_1551524727 =             prefixBeforeNationalNumber + nationalNumber.toString();
            varC50A07DAEE4370E981DA39BFDFC4411F_1551524727.addTaint(taint);
            return varC50A07DAEE4370E981DA39BFDFC4411F_1551524727;
        } //End block
        case 6:
        if(isExpectingCountryCallingCode && !attemptToExtractCountryCallingCode())        
        {
            ableToFormat = false;
String var5DA4F23BDAFA099675D0A84B89FB971F_942191958 =             accruedInput.toString();
            var5DA4F23BDAFA099675D0A84B89FB971F_942191958.addTaint(taint);
            return var5DA4F23BDAFA099675D0A84B89FB971F_942191958;
        } //End block
        default:
        if(possibleFormats.size() > 0)        
        {
            String tempNationalNumber = inputDigitHelper(nextChar);
            String formattedNumber = attemptToFormatAccruedDigits();
            if(formattedNumber.length() > 0)            
            {
String varEDFF1D0B1BD24FE7D8CDDCD8E673E22D_741433409 =                 formattedNumber;
                varEDFF1D0B1BD24FE7D8CDDCD8E673E22D_741433409.addTaint(taint);
                return varEDFF1D0B1BD24FE7D8CDDCD8E673E22D_741433409;
            } //End block
            narrowDownPossibleFormats(nationalNumber.toString());
            if(maybeCreateNewTemplate())            
            {
String varDEEDA02C42BAE77FE1A00F9B7037448A_2099059026 =                 inputAccruedNationalNumber();
                varDEEDA02C42BAE77FE1A00F9B7037448A_2099059026.addTaint(taint);
                return varDEEDA02C42BAE77FE1A00F9B7037448A_2099059026;
            } //End block
String varCA4068B6CC598939A01C31B3884B5E64_347417405 =             ableToFormat
             ? prefixBeforeNationalNumber + tempNationalNumber
             : accruedInput.toString();
            varCA4068B6CC598939A01C31B3884B5E64_347417405.addTaint(taint);
            return varCA4068B6CC598939A01C31B3884B5E64_347417405;
        } //End block
        else
        {
String var6E079CFAB6A3F75F2D894571ED8C37B5_116598190 =             attemptToChooseFormattingPattern();
            var6E079CFAB6A3F75F2D894571ED8C37B5_116598190.addTaint(taint);
            return var6E079CFAB6A3F75F2D894571ED8C37B5_116598190;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.523 -0400", hash_original_method = "3C59019883483E3D8800E37699311374", hash_generated_method = "4B74DBC461884A2D1A68EC805B05442D")
    private boolean isDigitOrLeadingPlusSign(char nextChar) {
        addTaint(nextChar);
        boolean var7835BECA9E03B63FB5BBE52B4A194D3C_1841312477 = (Character.isDigit(nextChar) ||
        (accruedInput.length() == 1 &&
         PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479405021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479405021;
        // ---------- Original Method ----------
        //return Character.isDigit(nextChar) ||
        //(accruedInput.length() == 1 &&
         //PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.524 -0400", hash_original_method = "9BC9DDDBE79729997007D59699BB4F8B", hash_generated_method = "715E7F6950817D90D4B278BE7FEF60DC")
     String attemptToFormatAccruedDigits() {
for(NumberFormat numFormat : possibleFormats)
        {
            Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
            if(m.matches())            
            {
                String formattedNumber = m.replaceAll(numFormat.getFormat());
String var8FB010F2567C912DF075A24A1D74303B_15864495 =                 prefixBeforeNationalNumber + formattedNumber;
                var8FB010F2567C912DF075A24A1D74303B_15864495.addTaint(taint);
                return var8FB010F2567C912DF075A24A1D74303B_15864495;
            } //End block
        } //End block
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1100724953 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1100724953.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1100724953;
        // ---------- Original Method ----------
        //for (NumberFormat numFormat : possibleFormats) {
      //Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
      //if (m.matches()) {
        //String formattedNumber = m.replaceAll(numFormat.getFormat());
        //return prefixBeforeNationalNumber + formattedNumber;
      //}
    //}
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.524 -0400", hash_original_method = "454614081331C76956AF09B40EA354E2", hash_generated_method = "B508B80B789C429F109F4D3C1ACFE25E")
    public int getRememberedPosition() {
        if(!ableToFormat)        
        {
            int var7C0104DD00C05197CB4A03324766B975_1654295995 = (originalPosition);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878575407 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878575407;
        } //End block
        int accruedInputIndex = 0;
        int currentOutputIndex = 0;
        while
(accruedInputIndex < positionToRemember && currentOutputIndex < currentOutput.length())        
        {
            if(accruedInputWithoutFormatting.charAt(accruedInputIndex) ==
          currentOutput.charAt(currentOutputIndex))            
            {
                accruedInputIndex++;
            } //End block
            currentOutputIndex++;
        } //End block
        int var443014F47B3770CBE17B057B5FFBD072_614525533 = (currentOutputIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231928927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231928927;
        // ---------- Original Method ----------
        //if (!ableToFormat) {
      //return originalPosition;
    //}
        //int accruedInputIndex = 0, currentOutputIndex = 0;
        //while (accruedInputIndex < positionToRemember && currentOutputIndex < currentOutput.length()) {
      //if (accruedInputWithoutFormatting.charAt(accruedInputIndex) ==
          //currentOutput.charAt(currentOutputIndex)) {
        //accruedInputIndex++;
      //}
      //currentOutputIndex++;
    //}
        //return currentOutputIndex;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.525 -0400", hash_original_method = "4C8321A90BCC237ABE581FD0E018E0B0", hash_generated_method = "AEAC26F82875D49AF8D03CCBC442734A")
    private String attemptToChooseFormattingPattern() {
        if(nationalNumber.length() >= MIN_LEADING_DIGITS_LENGTH)        
        {
            getAvailableFormats(nationalNumber.substring(0, MIN_LEADING_DIGITS_LENGTH));
            maybeCreateNewTemplate();
String varDEEDA02C42BAE77FE1A00F9B7037448A_2071521087 =             inputAccruedNationalNumber();
            varDEEDA02C42BAE77FE1A00F9B7037448A_2071521087.addTaint(taint);
            return varDEEDA02C42BAE77FE1A00F9B7037448A_2071521087;
        } //End block
        else
        {
String varC50A07DAEE4370E981DA39BFDFC4411F_1915626865 =             prefixBeforeNationalNumber + nationalNumber.toString();
            varC50A07DAEE4370E981DA39BFDFC4411F_1915626865.addTaint(taint);
            return varC50A07DAEE4370E981DA39BFDFC4411F_1915626865;
        } //End block
        // ---------- Original Method ----------
        //if (nationalNumber.length() >= MIN_LEADING_DIGITS_LENGTH) {
      //getAvailableFormats(nationalNumber.substring(0, MIN_LEADING_DIGITS_LENGTH));
      //maybeCreateNewTemplate();
      //return inputAccruedNationalNumber();
    //} else {
      //return prefixBeforeNationalNumber + nationalNumber.toString();
    //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.525 -0400", hash_original_method = "A0C52ED0A89DE12301F2C974C5007560", hash_generated_method = "600469DA323BE9F8F05A58BB4B688096")
    private String inputAccruedNationalNumber() {
        int lengthOfNationalNumber = nationalNumber.length();
        if(lengthOfNationalNumber > 0)        
        {
            String tempNationalNumber = "";
for(int i = 0;i < lengthOfNationalNumber;i++)
            {
                tempNationalNumber = inputDigitHelper(nationalNumber.charAt(i));
            } //End block
String varCA4068B6CC598939A01C31B3884B5E64_2043721999 =             ableToFormat
          ? prefixBeforeNationalNumber + tempNationalNumber
          : accruedInput.toString();
            varCA4068B6CC598939A01C31B3884B5E64_2043721999.addTaint(taint);
            return varCA4068B6CC598939A01C31B3884B5E64_2043721999;
        } //End block
        else
        {
String var59EDF629DC029F16882F612A4FB211C0_419983249 =             prefixBeforeNationalNumber.toString();
            var59EDF629DC029F16882F612A4FB211C0_419983249.addTaint(taint);
            return var59EDF629DC029F16882F612A4FB211C0_419983249;
        } //End block
        // ---------- Original Method ----------
        //int lengthOfNationalNumber = nationalNumber.length();
        //if (lengthOfNationalNumber > 0) {
      //String tempNationalNumber = "";
      //for (int i = 0; i < lengthOfNationalNumber; i++) {
        //tempNationalNumber = inputDigitHelper(nationalNumber.charAt(i));
      //}
      //return ableToFormat
          //? prefixBeforeNationalNumber + tempNationalNumber
          //: accruedInput.toString();
    //} else {
      //return prefixBeforeNationalNumber.toString();
    //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.526 -0400", hash_original_method = "810622AECED476A4374C59B83D98E171", hash_generated_method = "96CAA668E06ED6868FBB9D80B8ECFC79")
    private void removeNationalPrefixFromNationalNumber() {
        int startOfNationalNumber = 0;
        if(currentMetaData.getCountryCode() == 1 && nationalNumber.charAt(0) == '1')        
        {
            startOfNationalNumber = 1;
            prefixBeforeNationalNumber.append("1 ");
            isInternationalFormatting = true;
        } //End block
        else
        if(currentMetaData.hasNationalPrefix())        
        {
            Pattern nationalPrefixForParsing = regexCache.getPatternForRegex(currentMetaData.getNationalPrefixForParsing());
            Matcher m = nationalPrefixForParsing.matcher(nationalNumber);
            if(m.lookingAt())            
            {
                isInternationalFormatting = true;
                startOfNationalNumber = m.end();
                prefixBeforeNationalNumber.append(nationalNumber.substring(0, startOfNationalNumber));
            } //End block
        } //End block
        nationalNumber.delete(0, startOfNationalNumber);
        // ---------- Original Method ----------
        //int startOfNationalNumber = 0;
        //if (currentMetaData.getCountryCode() == 1 && nationalNumber.charAt(0) == '1') {
      //startOfNationalNumber = 1;
      //prefixBeforeNationalNumber.append("1 ");
      //isInternationalFormatting = true;
    //} else if (currentMetaData.hasNationalPrefix()) {
      //Pattern nationalPrefixForParsing =
        //regexCache.getPatternForRegex(currentMetaData.getNationalPrefixForParsing());
      //Matcher m = nationalPrefixForParsing.matcher(nationalNumber);
      //if (m.lookingAt()) {
        //isInternationalFormatting = true;
        //startOfNationalNumber = m.end();
        //prefixBeforeNationalNumber.append(nationalNumber.substring(0, startOfNationalNumber));
      //}
    //}
        //nationalNumber.delete(0, startOfNationalNumber);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.527 -0400", hash_original_method = "B953FBA4B3460899EA66156C6BB3FF32", hash_generated_method = "D690EBCB392249A5E85E285AAA8D5E4A")
    private boolean attemptToExtractIdd() {
        Pattern internationalPrefix = regexCache.getPatternForRegex("\\" + PhoneNumberUtil.PLUS_SIGN + "|" +
            currentMetaData.getInternationalPrefix());
        Matcher iddMatcher = internationalPrefix.matcher(accruedInputWithoutFormatting);
        if(iddMatcher.lookingAt())        
        {
            isInternationalFormatting = true;
            int startOfCountryCallingCode = iddMatcher.end();
            nationalNumber.setLength(0);
            nationalNumber.append(accruedInputWithoutFormatting.substring(startOfCountryCallingCode));
            prefixBeforeNationalNumber.append(
          accruedInputWithoutFormatting.substring(0, startOfCountryCallingCode));
            if(accruedInputWithoutFormatting.charAt(0) != PhoneNumberUtil.PLUS_SIGN)            
            {
                prefixBeforeNationalNumber.append(" ");
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1211942847 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046777429 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046777429;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1809333085 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224684415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224684415;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.527 -0400", hash_original_method = "218BC2BA6DFB456EB7693A201AB85277", hash_generated_method = "8C9379374FD5A87B86A2618E137FB2DB")
    private boolean attemptToExtractCountryCallingCode() {
        if(nationalNumber.length() == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1310277107 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928794931 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928794931;
        } //End block
        StringBuilder numberWithoutCountryCallingCode = new StringBuilder();
        int countryCode = phoneUtil.extractCountryCode(nationalNumber, numberWithoutCountryCallingCode);
        if(countryCode == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_531361313 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882440711 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_882440711;
        } //End block
        nationalNumber.setLength(0);
        nationalNumber.append(numberWithoutCountryCallingCode);
        String newRegionCode = phoneUtil.getRegionCodeForCountryCode(countryCode);
        if(!newRegionCode.equals(defaultCountry))        
        {
            currentMetaData = getMetadataForRegion(newRegionCode);
        } //End block
        String countryCodeString = Integer.toString(countryCode);
        prefixBeforeNationalNumber.append(countryCodeString).append(" ");
        boolean varB326B5062B2F0E69046810717534CB09_1259006195 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895866388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895866388;
        // ---------- Original Method ----------
        //if (nationalNumber.length() == 0) {
      //return false;
    //}
        //StringBuilder numberWithoutCountryCallingCode = new StringBuilder();
        //int countryCode = phoneUtil.extractCountryCode(nationalNumber, numberWithoutCountryCallingCode);
        //if (countryCode == 0) {
      //return false;
    //}
        //nationalNumber.setLength(0);
        //nationalNumber.append(numberWithoutCountryCallingCode);
        //String newRegionCode = phoneUtil.getRegionCodeForCountryCode(countryCode);
        //if (!newRegionCode.equals(defaultCountry)) {
      //currentMetaData = getMetadataForRegion(newRegionCode);
    //}
        //String countryCodeString = Integer.toString(countryCode);
        //prefixBeforeNationalNumber.append(countryCodeString).append(" ");
        //return true;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.528 -0400", hash_original_method = "77D81BD33F378FE00304ED0E0D731511", hash_generated_method = "0FDD53852399C7CDCD592EB23EFFCBDB")
    private char normalizeAndAccrueDigitsAndPlusSign(char nextChar, boolean rememberPosition) {
        addTaint(rememberPosition);
        addTaint(nextChar);
        char normalizedChar;
        if(nextChar == PhoneNumberUtil.PLUS_SIGN)        
        {
            normalizedChar = nextChar;
            accruedInputWithoutFormatting.append(nextChar);
        } //End block
        else
        {
            int radix = 10;
            normalizedChar = Character.forDigit(Character.digit(nextChar, radix), radix);
            accruedInputWithoutFormatting.append(normalizedChar);
            nationalNumber.append(normalizedChar);
        } //End block
        if(rememberPosition)        
        {
            positionToRemember = accruedInputWithoutFormatting.length();
        } //End block
        char var4F8B2A2448B711D54608AA9E10E12663_1284605274 = (normalizedChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_2093052461 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2093052461;
        // ---------- Original Method ----------
        //char normalizedChar;
        //if (nextChar == PhoneNumberUtil.PLUS_SIGN) {
      //normalizedChar = nextChar;
      //accruedInputWithoutFormatting.append(nextChar);
    //} else {
      //int radix = 10;
      //normalizedChar = Character.forDigit(Character.digit(nextChar, radix), radix);
      //accruedInputWithoutFormatting.append(normalizedChar);
      //nationalNumber.append(normalizedChar);
    //}
        //if (rememberPosition) {
      //positionToRemember = accruedInputWithoutFormatting.length();
    //}
        //return normalizedChar;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.529 -0400", hash_original_method = "E1A45868A03256452AD2B7163B170B11", hash_generated_method = "68413EAA9BECA181F5BE28152A5D945D")
    private String inputDigitHelper(char nextChar) {
        addTaint(nextChar);
        Matcher digitMatcher = digitPattern.matcher(formattingTemplate);
        if(digitMatcher.find(lastMatchPosition))        
        {
            String tempTemplate = digitMatcher.replaceFirst(Character.toString(nextChar));
            formattingTemplate.replace(0, tempTemplate.length(), tempTemplate);
            lastMatchPosition = digitMatcher.start();
String var69F07413ED8015BA8F9A54A3B788140A_1746411445 =             formattingTemplate.substring(0, lastMatchPosition + 1);
            var69F07413ED8015BA8F9A54A3B788140A_1746411445.addTaint(taint);
            return var69F07413ED8015BA8F9A54A3B788140A_1746411445;
        } //End block
        else
        {
            if(possibleFormats.size() == 1)            
            {
                ableToFormat = false;
            } //End block
            currentFormattingPattern = "";
String var5DA4F23BDAFA099675D0A84B89FB971F_1299098242 =             accruedInput.toString();
            var5DA4F23BDAFA099675D0A84B89FB971F_1299098242.addTaint(taint);
            return var5DA4F23BDAFA099675D0A84B89FB971F_1299098242;
        } //End block
        // ---------- Original Method ----------
        //Matcher digitMatcher = digitPattern.matcher(formattingTemplate);
        //if (digitMatcher.find(lastMatchPosition)) {
      //String tempTemplate = digitMatcher.replaceFirst(Character.toString(nextChar));
      //formattingTemplate.replace(0, tempTemplate.length(), tempTemplate);
      //lastMatchPosition = digitMatcher.start();
      //return formattingTemplate.substring(0, lastMatchPosition + 1);
    //} else {
      //if (possibleFormats.size() == 1) {
        //ableToFormat = false;
      //}  
      //currentFormattingPattern = "";
      //return accruedInput.toString();
    //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.529 -0400", hash_original_field = "61158E732E552EC810F8738B9805D687", hash_generated_field = "5B7D0B52CB21DA6A99C67E3BE1997092")

    private static final PhoneMetadata EMPTY_METADATA = new PhoneMetadata().setInternationalPrefix("NA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.529 -0400", hash_original_field = "35A028FF00BEB060B0EFB3D3BF69C219", hash_generated_field = "CDA8B06E4D1979CCC7536AC7E4352157")

    private static final Pattern CHARACTER_CLASS_PATTERN = Pattern.compile("\\[([^\\[\\]])*\\]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.529 -0400", hash_original_field = "6677810ED39749757FB9724C9FC93820", hash_generated_field = "BE2A4ACD67BE9F1D23C78B794AB2971C")

    private static final Pattern STANDALONE_DIGIT_PATTERN = Pattern.compile("\\d(?=[^,}][^,}])");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.530 -0400", hash_original_field = "3B829B24B9A48E8D695B7854B3461D48", hash_generated_field = "8E4ACB2A885AD8D446337A76E5C6D479")

    private static final Pattern ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*" +
          "(\\$\\d" + "[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*)+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.530 -0400", hash_original_field = "916690B3AAEA02ED5BB6D44BA6E02578", hash_generated_field = "6B9E305E543306EA81CC751EC725A701")

    private static final int MIN_LEADING_DIGITS_LENGTH = 3;
}

