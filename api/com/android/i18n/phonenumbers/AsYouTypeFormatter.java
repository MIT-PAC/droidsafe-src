package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsYouTypeFormatter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.346 -0400", hash_original_field = "587DFC21273768F857001AF4DED4A6C2", hash_generated_field = "0C350DE511BE7B52540BBA3416D1A46C")

    private String currentOutput = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.346 -0400", hash_original_field = "9C7B57FCC2047555285BE852A4B2943F", hash_generated_field = "09F9323AC7F5DB51B79E6FB4689A0073")

    private StringBuilder formattingTemplate = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.346 -0400", hash_original_field = "4FBD98FDDEE7B846B71DF829DFC1C978", hash_generated_field = "6A54B02BA2C7E4165F427873C017B488")

    private String currentFormattingPattern = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.346 -0400", hash_original_field = "0EE2ED1280BE50DC5A0B71C01B505EF2", hash_generated_field = "29CDE2D2FAA8268827B1B884DC2F18BA")

    private StringBuilder accruedInput = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.346 -0400", hash_original_field = "48E61261D0E6A721DDE49948BAE6E5FB", hash_generated_field = "E579FAA49690664D33A278DEA0E8B5A6")

    private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "C6C6C291305739DAC8EFBEF0C9C86773", hash_generated_field = "2095ACFBFC258F92C73D192F518E00D7")

    private boolean ableToFormat = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "84A093E41F72D463AA839067E1B4DC2D", hash_generated_field = "168C680E9820B2FFBEB1B9E07688ACEE")

    private boolean isInternationalFormatting = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "FAFF8308CA553E2E22D15CCA48E047D9", hash_generated_field = "9C2BB325FBB2EC7864F760CFE394F16E")

    private boolean isExpectingCountryCallingCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "8DDE134A73A97EF1C52A79F2EA1BEA97", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "65B2F933146CFA88C7D3B8E0FFCB3603", hash_generated_field = "6FD38F26B0E8DBBA6EF73F09FB6B4141")

    private String defaultCountry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "3BBE52C5C6888410EE33760B1B194818", hash_generated_field = "120A053E2F4E55161B2E4207EE1C05CF")

    private PhoneMetadata defaultMetaData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "ECC8858CCAF9726976F895C4946EC91F", hash_generated_field = "35B49383D60A264DAE321C3C26CE1990")

    private PhoneMetadata currentMetaData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "C57C6C03AC264E94F23DA5BDEAC85E70", hash_generated_field = "23C1B63DC4A3B45E60BB35F865EFF73E")

    private String digitPlaceholder = "\u2008";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "AFFA108041D9C7C6B1F036D62D2C3AB3", hash_generated_field = "A012D752824ECE91B83A6649421B0E5D")

    private Pattern digitPattern = Pattern.compile(digitPlaceholder);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "7A0EE11C8BC5F6F4825317CF1BEB784B", hash_generated_field = "118190E2A789D8F137699A3B010FBDD5")

    private int lastMatchPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "555F90F22B033B3B3225B5F9914F20EC", hash_generated_field = "AAA5D18DEE083F7BBA851AA262F094CB")

    private int originalPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "BF1413E6C4EB4C0A0714AE4F41C37666", hash_generated_field = "8C72AA3A3DE1D2EFB37D75F2D908776F")

    private int positionToRemember = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.347 -0400", hash_original_field = "3777965CF9620D0EC3EF9D148ED3ADAF", hash_generated_field = "E91BED07269C3A918A7C430BB9D5D341")

    private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.348 -0400", hash_original_field = "0B2CD1BEAC92768B16F5279A28B974BF", hash_generated_field = "5578ADECAFE9EAFCE3065ED8EBE1D841")

    private StringBuilder nationalNumber = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.348 -0400", hash_original_field = "4F05C64762A4432672AD2501E8DF3569", hash_generated_field = "23CDF3D9149C891AD1D66C6C35974D4E")

    private List<NumberFormat> possibleFormats = new ArrayList<NumberFormat>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.348 -0400", hash_original_field = "FC60034C5DB0EEBE16CF2AFE16BDD383", hash_generated_field = "FEE3B86D57B366ADF75BCFCDCCAF1CE3")

    private RegexCache regexCache = new RegexCache(64);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.349 -0400", hash_original_method = "936F5C412B2E8DF425145B47DD5CAEF0", hash_generated_method = "FE3B8DF7E339A94E519494A3A5DB6E47")
      AsYouTypeFormatter(String regionCode) {
        defaultCountry = regionCode;
        currentMetaData = getMetadataForRegion(defaultCountry);
        defaultMetaData = currentMetaData;
        // ---------- Original Method ----------
        //defaultCountry = regionCode;
        //currentMetaData = getMetadataForRegion(defaultCountry);
        //defaultMetaData = currentMetaData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.349 -0400", hash_original_method = "881E62338E39DD444804F246615E6E62", hash_generated_method = "EC95AD04D6230C865DCAA9C738A8229D")
    private PhoneMetadata getMetadataForRegion(String regionCode) {
        addTaint(regionCode.getTaint());
        int countryCallingCode = phoneUtil.getCountryCodeForRegion(regionCode);
        String mainCountry = phoneUtil.getRegionCodeForCountryCode(countryCallingCode);
        PhoneMetadata metadata = phoneUtil.getMetadataForRegion(mainCountry);
    if(metadata != null)        
        {
PhoneMetadata varDD4984A0B7A246C66EA6810C1C4348D7_1718853221 =             metadata;
            varDD4984A0B7A246C66EA6810C1C4348D7_1718853221.addTaint(taint);
            return varDD4984A0B7A246C66EA6810C1C4348D7_1718853221;
        } //End block
PhoneMetadata varFBEA0CBA6FC02D2747A4C6810F21686A_1441391134 =         EMPTY_METADATA;
        varFBEA0CBA6FC02D2747A4C6810F21686A_1441391134.addTaint(taint);
        return varFBEA0CBA6FC02D2747A4C6810F21686A_1441391134;
        // ---------- Original Method ----------
        //int countryCallingCode = phoneUtil.getCountryCodeForRegion(regionCode);
        //String mainCountry = phoneUtil.getRegionCodeForCountryCode(countryCallingCode);
        //PhoneMetadata metadata = phoneUtil.getMetadataForRegion(mainCountry);
        //if (metadata != null) {
      //return metadata;
    //}
        //return EMPTY_METADATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.350 -0400", hash_original_method = "AB8E8EDD80C278D4452E081702FFED46", hash_generated_method = "2D85B45445791EB646550938DB345535")
    private boolean maybeCreateNewTemplate() {
        Iterator<NumberFormat> it = possibleFormats.iterator();
        while
(it.hasNext())        
        {
            NumberFormat numberFormat = it.next();
            String pattern = numberFormat.getPattern();
    if(currentFormattingPattern.equals(pattern))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1413026769 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048661487 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048661487;
            } //End block
    if(createFormattingTemplate(numberFormat))            
            {
                currentFormattingPattern = pattern;
                boolean varB326B5062B2F0E69046810717534CB09_1130055690 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663902956 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_663902956;
            } //End block
            else
            {
                it.remove();
            } //End block
        } //End block
        ableToFormat = false;
        boolean var68934A3E9455FA72420237EB05902327_1003923602 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627750903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_627750903;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.351 -0400", hash_original_method = "37D81E1E00F803BB98B41301D27D6488", hash_generated_method = "3DE1E8001B5B6BA849F349A4FD48B6DC")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.352 -0400", hash_original_method = "0CD8D9B07AADCF252FD63C0FF91E8BCD", hash_generated_method = "B3A5768050808800EFCD98E2348EE4D2")
    private boolean isFormatEligible(String format) {
        addTaint(format.getTaint());
        boolean varB3190CE6520D441E523F03940FE5C969_1596806942 = (ELIGIBLE_FORMAT_PATTERN.matcher(format).matches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467055523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467055523;
        // ---------- Original Method ----------
        //return ELIGIBLE_FORMAT_PATTERN.matcher(format).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.352 -0400", hash_original_method = "3E367C813BED2017BCCC9CAE77808F34", hash_generated_method = "48D31EC47ABE2BB257B8250E6754C3F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.353 -0400", hash_original_method = "2542CBCB3D3982D996EED604A627F745", hash_generated_method = "0E9C497253AED7CE22CE6ADB00BA0D98")
    private boolean createFormattingTemplate(NumberFormat format) {
        addTaint(format.getTaint());
        String numberPattern = format.getPattern();
    if(numberPattern.indexOf('|') != -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_857071553 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711435506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711435506;
        } //End block
        numberPattern = CHARACTER_CLASS_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        numberPattern = STANDALONE_DIGIT_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        formattingTemplate.setLength(0);
        String tempTemplate = getFormattingTemplate(numberPattern, format.getFormat());
    if(tempTemplate.length() > 0)        
        {
            formattingTemplate.append(tempTemplate);
            boolean varB326B5062B2F0E69046810717534CB09_606407465 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071338293 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071338293;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_310771857 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446897134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_446897134;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.354 -0400", hash_original_method = "D11FAAF63EBAF37B7C1EC170EAFCD005", hash_generated_method = "FFACE373E4B050860AB50A7426623B2B")
    private String getFormattingTemplate(String numberPattern, String numberFormat) {
        addTaint(numberFormat.getTaint());
        addTaint(numberPattern.getTaint());
        String longestPhoneNumber = "999999999999999";
        Matcher m = regexCache.getPatternForRegex(numberPattern).matcher(longestPhoneNumber);
        m.find();
        String aPhoneNumber = m.group();
    if(aPhoneNumber.length() < nationalNumber.length())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_650014558 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_650014558.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_650014558;
        } //End block
        String template = aPhoneNumber.replaceAll(numberPattern, numberFormat);
        template = template.replaceAll("9", digitPlaceholder);
String var09CEB08BD4344BF0DF3CD0571C30EE3D_814084833 =         template;
        var09CEB08BD4344BF0DF3CD0571C30EE3D_814084833.addTaint(taint);
        return var09CEB08BD4344BF0DF3CD0571C30EE3D_814084833;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.355 -0400", hash_original_method = "8F04C2F49656580CD2F07A034451AAD3", hash_generated_method = "A2D19CBC5012A97B0F24A634FB8A6122")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.355 -0400", hash_original_method = "F7260472EF36A540999D13D4CAA6ECE9", hash_generated_method = "FC9A6A02B2FC7A84D40CAE8DFFE0F009")
    public String inputDigit(char nextChar) {
        currentOutput = inputDigitWithOptionToRememberPosition(nextChar, false);
String var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1175589888 =         currentOutput;
        var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1175589888.addTaint(taint);
        return var6D28BBF6C3B5B42D7B24DF7C977E5CFB_1175589888;
        // ---------- Original Method ----------
        //currentOutput = inputDigitWithOptionToRememberPosition(nextChar, false);
        //return currentOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.356 -0400", hash_original_method = "5CF2674AEE53F09D43FB9E46A011FFC0", hash_generated_method = "28F0F4547297715A7C71490B2CB7E22B")
    public String inputDigitAndRememberPosition(char nextChar) {
        currentOutput = inputDigitWithOptionToRememberPosition(nextChar, true);
String var6D28BBF6C3B5B42D7B24DF7C977E5CFB_973222714 =         currentOutput;
        var6D28BBF6C3B5B42D7B24DF7C977E5CFB_973222714.addTaint(taint);
        return var6D28BBF6C3B5B42D7B24DF7C977E5CFB_973222714;
        // ---------- Original Method ----------
        //currentOutput = inputDigitWithOptionToRememberPosition(nextChar, true);
        //return currentOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.357 -0400", hash_original_method = "6C89C7F3A0AAC3A12D8456578D2D5E4E", hash_generated_method = "5C4CCC486965C070D47949B9B984A098")
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
String var5DA4F23BDAFA099675D0A84B89FB971F_1303481570 =             accruedInput.toString();
            var5DA4F23BDAFA099675D0A84B89FB971F_1303481570.addTaint(taint);
            return var5DA4F23BDAFA099675D0A84B89FB971F_1303481570;
        } //End block
        nextChar = normalizeAndAccrueDigitsAndPlusSign(nextChar, rememberPosition);
switch(accruedInputWithoutFormatting.length()){
        case 0:
        case 1:
        case 2:
String var5DA4F23BDAFA099675D0A84B89FB971F_1839587608 =         accruedInput.toString();
        var5DA4F23BDAFA099675D0A84B89FB971F_1839587608.addTaint(taint);
        return var5DA4F23BDAFA099675D0A84B89FB971F_1839587608;
        case 3:
    if(attemptToExtractIdd())        
        {
            isExpectingCountryCallingCode = true;
        } //End block
        else
        {
            removeNationalPrefixFromNationalNumber();
String var6E079CFAB6A3F75F2D894571ED8C37B5_1739928573 =             attemptToChooseFormattingPattern();
            var6E079CFAB6A3F75F2D894571ED8C37B5_1739928573.addTaint(taint);
            return var6E079CFAB6A3F75F2D894571ED8C37B5_1739928573;
        } //End block
        case 4:
        case 5:
    if(isExpectingCountryCallingCode)        
        {
    if(attemptToExtractCountryCallingCode())            
            {
                isExpectingCountryCallingCode = false;
            } //End block
String varC50A07DAEE4370E981DA39BFDFC4411F_733165513 =             prefixBeforeNationalNumber + nationalNumber.toString();
            varC50A07DAEE4370E981DA39BFDFC4411F_733165513.addTaint(taint);
            return varC50A07DAEE4370E981DA39BFDFC4411F_733165513;
        } //End block
        case 6:
    if(isExpectingCountryCallingCode && !attemptToExtractCountryCallingCode())        
        {
            ableToFormat = false;
String var5DA4F23BDAFA099675D0A84B89FB971F_131151870 =             accruedInput.toString();
            var5DA4F23BDAFA099675D0A84B89FB971F_131151870.addTaint(taint);
            return var5DA4F23BDAFA099675D0A84B89FB971F_131151870;
        } //End block
        default:
    if(possibleFormats.size() > 0)        
        {
            String tempNationalNumber = inputDigitHelper(nextChar);
            String formattedNumber = attemptToFormatAccruedDigits();
    if(formattedNumber.length() > 0)            
            {
String varEDFF1D0B1BD24FE7D8CDDCD8E673E22D_1325666583 =                 formattedNumber;
                varEDFF1D0B1BD24FE7D8CDDCD8E673E22D_1325666583.addTaint(taint);
                return varEDFF1D0B1BD24FE7D8CDDCD8E673E22D_1325666583;
            } //End block
            narrowDownPossibleFormats(nationalNumber.toString());
    if(maybeCreateNewTemplate())            
            {
String varDEEDA02C42BAE77FE1A00F9B7037448A_2109635287 =                 inputAccruedNationalNumber();
                varDEEDA02C42BAE77FE1A00F9B7037448A_2109635287.addTaint(taint);
                return varDEEDA02C42BAE77FE1A00F9B7037448A_2109635287;
            } //End block
String varCA4068B6CC598939A01C31B3884B5E64_2017652406 =             ableToFormat
             ? prefixBeforeNationalNumber + tempNationalNumber
             : accruedInput.toString();
            varCA4068B6CC598939A01C31B3884B5E64_2017652406.addTaint(taint);
            return varCA4068B6CC598939A01C31B3884B5E64_2017652406;
        } //End block
        else
        {
String var6E079CFAB6A3F75F2D894571ED8C37B5_924718248 =             attemptToChooseFormattingPattern();
            var6E079CFAB6A3F75F2D894571ED8C37B5_924718248.addTaint(taint);
            return var6E079CFAB6A3F75F2D894571ED8C37B5_924718248;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.358 -0400", hash_original_method = "3C59019883483E3D8800E37699311374", hash_generated_method = "ACB291E1B0B0AF32AA99D7BFA84FAB06")
    private boolean isDigitOrLeadingPlusSign(char nextChar) {
        addTaint(nextChar);
        boolean var7835BECA9E03B63FB5BBE52B4A194D3C_1924573733 = (Character.isDigit(nextChar) ||
        (accruedInput.length() == 1 &&
         PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331227439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331227439;
        // ---------- Original Method ----------
        //return Character.isDigit(nextChar) ||
        //(accruedInput.length() == 1 &&
         //PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.358 -0400", hash_original_method = "9BC9DDDBE79729997007D59699BB4F8B", hash_generated_method = "DF0AE8522275D01C23F85B358C07E75F")
     String attemptToFormatAccruedDigits() {
for(NumberFormat numFormat : possibleFormats)
        {
            Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
    if(m.matches())            
            {
                String formattedNumber = m.replaceAll(numFormat.getFormat());
String var8FB010F2567C912DF075A24A1D74303B_898259915 =                 prefixBeforeNationalNumber + formattedNumber;
                var8FB010F2567C912DF075A24A1D74303B_898259915.addTaint(taint);
                return var8FB010F2567C912DF075A24A1D74303B_898259915;
            } //End block
        } //End block
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1702033346 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1702033346.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1702033346;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.359 -0400", hash_original_method = "454614081331C76956AF09B40EA354E2", hash_generated_method = "0B6BA09229BB0ADB93951061ED16B03E")
    public int getRememberedPosition() {
    if(!ableToFormat)        
        {
            int var7C0104DD00C05197CB4A03324766B975_1377919659 = (originalPosition);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117986968 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117986968;
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
        int var443014F47B3770CBE17B057B5FFBD072_294684655 = (currentOutputIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420322000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420322000;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.360 -0400", hash_original_method = "4C8321A90BCC237ABE581FD0E018E0B0", hash_generated_method = "D64F42F1AB22A816540FA38303771E51")
    private String attemptToChooseFormattingPattern() {
    if(nationalNumber.length() >= MIN_LEADING_DIGITS_LENGTH)        
        {
            getAvailableFormats(nationalNumber.substring(0, MIN_LEADING_DIGITS_LENGTH));
            maybeCreateNewTemplate();
String varDEEDA02C42BAE77FE1A00F9B7037448A_9899456 =             inputAccruedNationalNumber();
            varDEEDA02C42BAE77FE1A00F9B7037448A_9899456.addTaint(taint);
            return varDEEDA02C42BAE77FE1A00F9B7037448A_9899456;
        } //End block
        else
        {
String varC50A07DAEE4370E981DA39BFDFC4411F_142181550 =             prefixBeforeNationalNumber + nationalNumber.toString();
            varC50A07DAEE4370E981DA39BFDFC4411F_142181550.addTaint(taint);
            return varC50A07DAEE4370E981DA39BFDFC4411F_142181550;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.360 -0400", hash_original_method = "A0C52ED0A89DE12301F2C974C5007560", hash_generated_method = "49B7F757DFB99FF002C6F21BB1AAACBA")
    private String inputAccruedNationalNumber() {
        int lengthOfNationalNumber = nationalNumber.length();
    if(lengthOfNationalNumber > 0)        
        {
            String tempNationalNumber = "";
for(int i = 0;i < lengthOfNationalNumber;i++)
            {
                tempNationalNumber = inputDigitHelper(nationalNumber.charAt(i));
            } //End block
String varCA4068B6CC598939A01C31B3884B5E64_844401419 =             ableToFormat
          ? prefixBeforeNationalNumber + tempNationalNumber
          : accruedInput.toString();
            varCA4068B6CC598939A01C31B3884B5E64_844401419.addTaint(taint);
            return varCA4068B6CC598939A01C31B3884B5E64_844401419;
        } //End block
        else
        {
String var59EDF629DC029F16882F612A4FB211C0_475888047 =             prefixBeforeNationalNumber.toString();
            var59EDF629DC029F16882F612A4FB211C0_475888047.addTaint(taint);
            return var59EDF629DC029F16882F612A4FB211C0_475888047;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.361 -0400", hash_original_method = "810622AECED476A4374C59B83D98E171", hash_generated_method = "96CAA668E06ED6868FBB9D80B8ECFC79")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.362 -0400", hash_original_method = "B953FBA4B3460899EA66156C6BB3FF32", hash_generated_method = "90E9B54034239D2AE90C8FE74EA4B006")
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
            boolean varB326B5062B2F0E69046810717534CB09_448080662 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144570624 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144570624;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_472537122 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442724758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442724758;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.363 -0400", hash_original_method = "218BC2BA6DFB456EB7693A201AB85277", hash_generated_method = "8ED3A8D4CFF22B1C02FD2A5C21BF3E27")
    private boolean attemptToExtractCountryCallingCode() {
    if(nationalNumber.length() == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1942535891 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807248956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807248956;
        } //End block
        StringBuilder numberWithoutCountryCallingCode = new StringBuilder();
        int countryCode = phoneUtil.extractCountryCode(nationalNumber, numberWithoutCountryCallingCode);
    if(countryCode == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_284526356 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119722758 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119722758;
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
        boolean varB326B5062B2F0E69046810717534CB09_1667975984 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120741573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120741573;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.364 -0400", hash_original_method = "77D81BD33F378FE00304ED0E0D731511", hash_generated_method = "0DBFD5E2CD353B141DFE694CC496966D")
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
        char var4F8B2A2448B711D54608AA9E10E12663_911521796 = (normalizedChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1502309990 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1502309990;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.364 -0400", hash_original_method = "E1A45868A03256452AD2B7163B170B11", hash_generated_method = "6C637E03A45A6F9ECC7D0635D2521261")
    private String inputDigitHelper(char nextChar) {
        addTaint(nextChar);
        Matcher digitMatcher = digitPattern.matcher(formattingTemplate);
    if(digitMatcher.find(lastMatchPosition))        
        {
            String tempTemplate = digitMatcher.replaceFirst(Character.toString(nextChar));
            formattingTemplate.replace(0, tempTemplate.length(), tempTemplate);
            lastMatchPosition = digitMatcher.start();
String var69F07413ED8015BA8F9A54A3B788140A_1738520620 =             formattingTemplate.substring(0, lastMatchPosition + 1);
            var69F07413ED8015BA8F9A54A3B788140A_1738520620.addTaint(taint);
            return var69F07413ED8015BA8F9A54A3B788140A_1738520620;
        } //End block
        else
        {
    if(possibleFormats.size() == 1)            
            {
                ableToFormat = false;
            } //End block
            currentFormattingPattern = "";
String var5DA4F23BDAFA099675D0A84B89FB971F_1295492066 =             accruedInput.toString();
            var5DA4F23BDAFA099675D0A84B89FB971F_1295492066.addTaint(taint);
            return var5DA4F23BDAFA099675D0A84B89FB971F_1295492066;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.365 -0400", hash_original_field = "61158E732E552EC810F8738B9805D687", hash_generated_field = "5B7D0B52CB21DA6A99C67E3BE1997092")

    private static final PhoneMetadata EMPTY_METADATA = new PhoneMetadata().setInternationalPrefix("NA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.365 -0400", hash_original_field = "35A028FF00BEB060B0EFB3D3BF69C219", hash_generated_field = "CDA8B06E4D1979CCC7536AC7E4352157")

    private static final Pattern CHARACTER_CLASS_PATTERN = Pattern.compile("\\[([^\\[\\]])*\\]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.365 -0400", hash_original_field = "6677810ED39749757FB9724C9FC93820", hash_generated_field = "BE2A4ACD67BE9F1D23C78B794AB2971C")

    private static final Pattern STANDALONE_DIGIT_PATTERN = Pattern.compile("\\d(?=[^,}][^,}])");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.365 -0400", hash_original_field = "3B829B24B9A48E8D695B7854B3461D48", hash_generated_field = "8E4ACB2A885AD8D446337A76E5C6D479")

    private static final Pattern ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*" +
          "(\\$\\d" + "[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*)+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.365 -0400", hash_original_field = "916690B3AAEA02ED5BB6D44BA6E02578", hash_generated_field = "6B9E305E543306EA81CC751EC725A701")

    private static final int MIN_LEADING_DIGITS_LENGTH = 3;
}

