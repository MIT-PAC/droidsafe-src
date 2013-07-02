package com.android.i18n.phonenumbers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.android.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsYouTypeFormatter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "587DFC21273768F857001AF4DED4A6C2", hash_generated_field = "0C350DE511BE7B52540BBA3416D1A46C")

    private String currentOutput = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "9C7B57FCC2047555285BE852A4B2943F", hash_generated_field = "09F9323AC7F5DB51B79E6FB4689A0073")

    private StringBuilder formattingTemplate = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "4FBD98FDDEE7B846B71DF829DFC1C978", hash_generated_field = "6A54B02BA2C7E4165F427873C017B488")

    private String currentFormattingPattern = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "0EE2ED1280BE50DC5A0B71C01B505EF2", hash_generated_field = "29CDE2D2FAA8268827B1B884DC2F18BA")

    private StringBuilder accruedInput = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "48E61261D0E6A721DDE49948BAE6E5FB", hash_generated_field = "E579FAA49690664D33A278DEA0E8B5A6")

    private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "C6C6C291305739DAC8EFBEF0C9C86773", hash_generated_field = "2095ACFBFC258F92C73D192F518E00D7")

    private boolean ableToFormat = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "84A093E41F72D463AA839067E1B4DC2D", hash_generated_field = "168C680E9820B2FFBEB1B9E07688ACEE")

    private boolean isInternationalFormatting = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.490 -0400", hash_original_field = "FAFF8308CA553E2E22D15CCA48E047D9", hash_generated_field = "9C2BB325FBB2EC7864F760CFE394F16E")

    private boolean isExpectingCountryCallingCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "8DDE134A73A97EF1C52A79F2EA1BEA97", hash_generated_field = "BE506E133CCC4FF41A3A629A7B84F9C7")

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "65B2F933146CFA88C7D3B8E0FFCB3603", hash_generated_field = "6FD38F26B0E8DBBA6EF73F09FB6B4141")

    private String defaultCountry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "3BBE52C5C6888410EE33760B1B194818", hash_generated_field = "120A053E2F4E55161B2E4207EE1C05CF")

    private PhoneMetadata defaultMetaData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "ECC8858CCAF9726976F895C4946EC91F", hash_generated_field = "35B49383D60A264DAE321C3C26CE1990")

    private PhoneMetadata currentMetaData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "C57C6C03AC264E94F23DA5BDEAC85E70", hash_generated_field = "23C1B63DC4A3B45E60BB35F865EFF73E")

    private String digitPlaceholder = "\u2008";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "AFFA108041D9C7C6B1F036D62D2C3AB3", hash_generated_field = "A012D752824ECE91B83A6649421B0E5D")

    private Pattern digitPattern = Pattern.compile(digitPlaceholder);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "7A0EE11C8BC5F6F4825317CF1BEB784B", hash_generated_field = "118190E2A789D8F137699A3B010FBDD5")

    private int lastMatchPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "555F90F22B033B3B3225B5F9914F20EC", hash_generated_field = "AAA5D18DEE083F7BBA851AA262F094CB")

    private int originalPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "BF1413E6C4EB4C0A0714AE4F41C37666", hash_generated_field = "8C72AA3A3DE1D2EFB37D75F2D908776F")

    private int positionToRemember = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "3777965CF9620D0EC3EF9D148ED3ADAF", hash_generated_field = "E91BED07269C3A918A7C430BB9D5D341")

    private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "0B2CD1BEAC92768B16F5279A28B974BF", hash_generated_field = "5578ADECAFE9EAFCE3065ED8EBE1D841")

    private StringBuilder nationalNumber = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "4F05C64762A4432672AD2501E8DF3569", hash_generated_field = "23CDF3D9149C891AD1D66C6C35974D4E")

    private List<NumberFormat> possibleFormats = new ArrayList<NumberFormat>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.491 -0400", hash_original_field = "FC60034C5DB0EEBE16CF2AFE16BDD383", hash_generated_field = "FEE3B86D57B366ADF75BCFCDCCAF1CE3")

    private RegexCache regexCache = new RegexCache(64);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.492 -0400", hash_original_method = "936F5C412B2E8DF425145B47DD5CAEF0", hash_generated_method = "FE3B8DF7E339A94E519494A3A5DB6E47")
      AsYouTypeFormatter(String regionCode) {
        defaultCountry = regionCode;
        currentMetaData = getMetadataForRegion(defaultCountry);
        defaultMetaData = currentMetaData;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.494 -0400", hash_original_method = "881E62338E39DD444804F246615E6E62", hash_generated_method = "6D4838EE32D58B0B45D7B36D5337C778")
    private PhoneMetadata getMetadataForRegion(String regionCode) {
        PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_382072533 = null; 
        PhoneMetadata varB4EAC82CA7396A68D541C85D26508E83_777172216 = null; 
        int countryCallingCode = phoneUtil.getCountryCodeForRegion(regionCode);
        String mainCountry = phoneUtil.getRegionCodeForCountryCode(countryCallingCode);
        PhoneMetadata metadata = phoneUtil.getMetadataForRegion(mainCountry);
        {
            varB4EAC82CA7396A68D541C85D26508E83_382072533 = metadata;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_777172216 = EMPTY_METADATA;
        addTaint(regionCode.getTaint());
        PhoneMetadata varA7E53CE21691AB073D9660D615818899_1847024698; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1847024698 = varB4EAC82CA7396A68D541C85D26508E83_382072533;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1847024698 = varB4EAC82CA7396A68D541C85D26508E83_777172216;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1847024698.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1847024698;
        
        
        
        
        
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.496 -0400", hash_original_method = "AB8E8EDD80C278D4452E081702FFED46", hash_generated_method = "9FDC5CE662E1597D6EE4E5DA37125556")
    private boolean maybeCreateNewTemplate() {
        Iterator<NumberFormat> it = possibleFormats.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1317023907 = (it.hasNext());
            {
                NumberFormat numberFormat = it.next();
                String pattern = numberFormat.getPattern();
                {
                    boolean var9D3C99BC147B43034B90D37FF5671C55_1503517037 = (currentFormattingPattern.equals(pattern));
                } 
                {
                    boolean var46DD5B81A422C5EDB3101C42925C029B_671359562 = (createFormattingTemplate(numberFormat));
                    {
                        currentFormattingPattern = pattern;
                    } 
                    {
                        it.remove();
                    } 
                } 
            } 
        } 
        ableToFormat = false;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681189798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681189798;
        
        
        
      
      
      
        
      
      
        
        
      
        
      
    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.518 -0400", hash_original_method = "37D81E1E00F803BB98B41301D27D6488", hash_generated_method = "087A9B2E03DEA303A40FF11CBED3D42D")
    private void getAvailableFormats(String leadingThreeDigits) {
        List<NumberFormat> formatList;
        boolean varB67884F1064609E1BAB5093CB3CEF971_1566510604 = ((isInternationalFormatting && currentMetaData.intlNumberFormatSize() > 0));
        formatList = currentMetaData.intlNumberFormats();
        formatList = currentMetaData.numberFormats();
        {
            Iterator<NumberFormat> varF655A3F35A8B90A9399EACEB9BC4E06E_1163046168 = (formatList).iterator();
            varF655A3F35A8B90A9399EACEB9BC4E06E_1163046168.hasNext();
            NumberFormat format = varF655A3F35A8B90A9399EACEB9BC4E06E_1163046168.next();
            {
                {
                    boolean var54A934D8D12F631100479FFAC7EA8383_914994417 = (isFormatEligible(format.getFormat()));
                    {
                        possibleFormats.add(format);
                    } 
                } 
            } 
        } 
        narrowDownPossibleFormats(leadingThreeDigits);
        addTaint(leadingThreeDigits.getTaint());
        
        
        
        
        
        
      
        
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.520 -0400", hash_original_method = "0CD8D9B07AADCF252FD63C0FF91E8BCD", hash_generated_method = "2D3CEC13CA561A6F158BDB4905273FC8")
    private boolean isFormatEligible(String format) {
        boolean var7686FCFDEFFDCE541184344D93564B1A_1762446145 = (ELIGIBLE_FORMAT_PATTERN.matcher(format).matches());
        addTaint(format.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1366199736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1366199736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.522 -0400", hash_original_method = "3E367C813BED2017BCCC9CAE77808F34", hash_generated_method = "93D89BEBBECDC51862BCF0DA8C283815")
    private void narrowDownPossibleFormats(String leadingDigits) {
        int indexOfLeadingDigitsPattern = leadingDigits.length() - MIN_LEADING_DIGITS_LENGTH;
        Iterator<NumberFormat> it = possibleFormats.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2058060702 = (it.hasNext());
            {
                NumberFormat format = it.next();
                {
                    boolean var36A163D8065CD423AD885FA1146B8F7C_1686322112 = (format.leadingDigitsPatternSize() > indexOfLeadingDigitsPattern);
                    {
                        Pattern leadingDigitsPattern = regexCache.getPatternForRegex(
                format.getLeadingDigitsPattern(indexOfLeadingDigitsPattern));
                        Matcher m = leadingDigitsPattern.matcher(leadingDigits);
                        {
                            boolean var5C061ECAA93AC270713BF55060A3AF88_1173496570 = (!m.lookingAt());
                            {
                                it.remove();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(leadingDigits.getTaint());
        
        
        
        
      
      
        
            
                
        
        
          
        
      
    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.523 -0400", hash_original_method = "2542CBCB3D3982D996EED604A627F745", hash_generated_method = "50E2C9CA13E067C47ED30B5D07183078")
    private boolean createFormattingTemplate(NumberFormat format) {
        String numberPattern = format.getPattern();
        {
            boolean var2AB75326CF6A134D241113D78E168352_685413630 = (numberPattern.indexOf('|') != -1);
        } 
        numberPattern = CHARACTER_CLASS_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        numberPattern = STANDALONE_DIGIT_PATTERN.matcher(numberPattern).replaceAll("\\\\d");
        formattingTemplate.setLength(0);
        String tempTemplate = getFormattingTemplate(numberPattern, format.getFormat());
        {
            boolean varE0888266596442D8E272FE26E4A070F2_686109320 = (tempTemplate.length() > 0);
            {
                formattingTemplate.append(tempTemplate);
            } 
        } 
        addTaint(format.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201961615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201961615;
        
        
        
      
    
        
        
        
        
        
      
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.527 -0400", hash_original_method = "D11FAAF63EBAF37B7C1EC170EAFCD005", hash_generated_method = "4BBBAD9396BDC8297FA2C35A66DD86BE")
    private String getFormattingTemplate(String numberPattern, String numberFormat) {
        String varB4EAC82CA7396A68D541C85D26508E83_1713388071 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1728603155 = null; 
        String longestPhoneNumber = "999999999999999";
        Matcher m = regexCache.getPatternForRegex(numberPattern).matcher(longestPhoneNumber);
        m.find();
        String aPhoneNumber = m.group();
        {
            boolean varBA1FD27F64B359E5AE7EA77F4E5E1541_26743511 = (aPhoneNumber.length() < nationalNumber.length());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1713388071 = "";
            } 
        } 
        String template = aPhoneNumber.replaceAll(numberPattern, numberFormat);
        template = template.replaceAll("9", digitPlaceholder);
        varB4EAC82CA7396A68D541C85D26508E83_1728603155 = template;
        addTaint(numberPattern.getTaint());
        addTaint(numberFormat.getTaint());
        String varA7E53CE21691AB073D9660D615818899_927888737; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_927888737 = varB4EAC82CA7396A68D541C85D26508E83_1713388071;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_927888737 = varB4EAC82CA7396A68D541C85D26508E83_1728603155;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_927888737.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_927888737;
        
        
        
        
        
        
      
    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.528 -0400", hash_original_method = "8F04C2F49656580CD2F07A034451AAD3", hash_generated_method = "85E474E3F8CEEE7A3B270B394D8103C8")
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
        {
            boolean var31691B7A890C77516E38C860E4D5B6AF_765226495 = (!currentMetaData.equals(defaultMetaData));
            {
                currentMetaData = getMetadataForRegion(defaultCountry);
            } 
        } 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.531 -0400", hash_original_method = "F7260472EF36A540999D13D4CAA6ECE9", hash_generated_method = "9ACAAFA70B9C6700AA8076F0E9994B6F")
    public String inputDigit(char nextChar) {
        String varB4EAC82CA7396A68D541C85D26508E83_402752779 = null; 
        currentOutput = inputDigitWithOptionToRememberPosition(nextChar, false);
        varB4EAC82CA7396A68D541C85D26508E83_402752779 = currentOutput;
        varB4EAC82CA7396A68D541C85D26508E83_402752779.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_402752779;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.535 -0400", hash_original_method = "5CF2674AEE53F09D43FB9E46A011FFC0", hash_generated_method = "FD56951B9C617AE08E52C51E8C72C40B")
    public String inputDigitAndRememberPosition(char nextChar) {
        String varB4EAC82CA7396A68D541C85D26508E83_1352669915 = null; 
        currentOutput = inputDigitWithOptionToRememberPosition(nextChar, true);
        varB4EAC82CA7396A68D541C85D26508E83_1352669915 = currentOutput;
        varB4EAC82CA7396A68D541C85D26508E83_1352669915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1352669915;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.545 -0400", hash_original_method = "6C89C7F3A0AAC3A12D8456578D2D5E4E", hash_generated_method = "E436A9F126BCB979FA46752BA617E5D1")
    @SuppressWarnings("fallthrough")
    private String inputDigitWithOptionToRememberPosition(char nextChar, boolean rememberPosition) {
        String varB4EAC82CA7396A68D541C85D26508E83_893039060 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1502520916 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1265076392 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1014143851 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2070913242 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_260716615 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_709479209 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1591317023 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_755525681 = null; 
        accruedInput.append(nextChar);
        {
            originalPosition = accruedInput.length();
        } 
        {
            boolean var9CC42AC4AF9C9FBE29EDD73247D992CC_463774674 = (!isDigitOrLeadingPlusSign(nextChar));
            {
                ableToFormat = false;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_893039060 = accruedInput.toString();
        } 
        nextChar = normalizeAndAccrueDigitsAndPlusSign(nextChar, rememberPosition);
        {
            Object var958DDC020A719BE9C0B56C0556A777B3_1106446540 = (accruedInputWithoutFormatting.length());
            
            varB4EAC82CA7396A68D541C85D26508E83_1502520916 = accruedInput.toString();
            
            
            {
                boolean varA190F04796E1900C48E0B801F46A04E4_423710390 = (attemptToExtractIdd());
                {
                    isExpectingCountryCallingCode = true;
                } 
                {
                    removeNationalPrefixFromNationalNumber();
                    varB4EAC82CA7396A68D541C85D26508E83_1265076392 = attemptToChooseFormattingPattern();
                } 
            } 
            
            
            {
                {
                    boolean varDAFAE5E33CFA96F2C0611CC43EAAA591_2089699239 = (attemptToExtractCountryCallingCode());
                    {
                        isExpectingCountryCallingCode = false;
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1014143851 = prefixBeforeNationalNumber + nationalNumber.toString();
            } 
            
            
            {
                boolean varF57D8B93BD89B2796D5B19E5CFCDED2E_284540223 = (isExpectingCountryCallingCode && !attemptToExtractCountryCallingCode());
                {
                    ableToFormat = false;
                    varB4EAC82CA7396A68D541C85D26508E83_2070913242 = accruedInput.toString();
                } 
            } 
            
            
            {
                boolean varA1374B0BCDACDBA19097DC387347E589_1921933163 = (possibleFormats.size() > 0);
                {
                    String tempNationalNumber = inputDigitHelper(nextChar);
                    String formattedNumber = attemptToFormatAccruedDigits();
                    {
                        boolean varF6DD175EAA1621DB1E8681BA262C055F_1974810047 = (formattedNumber.length() > 0);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_260716615 = formattedNumber;
                        } 
                    } 
                    narrowDownPossibleFormats(nationalNumber.toString());
                    {
                        boolean var09DADC53907D6077992B56A48A795551_1362520561 = (maybeCreateNewTemplate());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_709479209 = inputAccruedNationalNumber();
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1591317023 = ableToFormat
             ? prefixBeforeNationalNumber + tempNationalNumber
             : accruedInput.toString();
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_755525681 = attemptToChooseFormattingPattern();
                } 
            } 
            
        } 
        addTaint(nextChar);
        addTaint(rememberPosition);
        String varA7E53CE21691AB073D9660D615818899_1466099677; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_893039060;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_1502520916;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_1265076392;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_1014143851;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_2070913242;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_260716615;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_709479209;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_1591317023;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1466099677 = varB4EAC82CA7396A68D541C85D26508E83_755525681;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1466099677.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1466099677;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.546 -0400", hash_original_method = "3C59019883483E3D8800E37699311374", hash_generated_method = "1503B62E11D715636336FA3FB31DCB29")
    private boolean isDigitOrLeadingPlusSign(char nextChar) {
        boolean varB854EBA358CA21C8BFC88085E508B2C3_1095357417 = (Character.isDigit(nextChar) ||
        (accruedInput.length() == 1 &&
         PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches()));
        addTaint(nextChar);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755931691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_755931691;
        
        
        
         
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.559 -0400", hash_original_method = "9BC9DDDBE79729997007D59699BB4F8B", hash_generated_method = "B3BCAAE175C555263F4B4A3E053B2C01")
     String attemptToFormatAccruedDigits() {
        String varB4EAC82CA7396A68D541C85D26508E83_2010386946 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1886205533 = null; 
        {
            Iterator<NumberFormat> var9FC04A10F16699539DFE98E18A1430D1_621661363 = (possibleFormats).iterator();
            var9FC04A10F16699539DFE98E18A1430D1_621661363.hasNext();
            NumberFormat numFormat = var9FC04A10F16699539DFE98E18A1430D1_621661363.next();
            {
                Matcher m = regexCache.getPatternForRegex(numFormat.getPattern()).matcher(nationalNumber);
                {
                    boolean var03F830A2F9B944C784852C2931FA3F13_460601024 = (m.matches());
                    {
                        String formattedNumber = m.replaceAll(numFormat.getFormat());
                        varB4EAC82CA7396A68D541C85D26508E83_2010386946 = prefixBeforeNationalNumber + formattedNumber;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1886205533 = "";
        String varA7E53CE21691AB073D9660D615818899_966132310; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_966132310 = varB4EAC82CA7396A68D541C85D26508E83_2010386946;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_966132310 = varB4EAC82CA7396A68D541C85D26508E83_1886205533;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_966132310.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_966132310;
        
        
      
      
        
        
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.560 -0400", hash_original_method = "454614081331C76956AF09B40EA354E2", hash_generated_method = "CFDB2D0CF4432919A423A36A20E4B46F")
    public int getRememberedPosition() {
        int accruedInputIndex = 0;
        int currentOutputIndex = 0;
        {
            boolean var5371C1B90877D17E6BD64861C5C8658A_1612720918 = (accruedInputIndex < positionToRemember && currentOutputIndex < currentOutput.length());
            {
                {
                    boolean var1C52CDEF827B567419746C81F2C95CC1_1322406030 = (accruedInputWithoutFormatting.charAt(accruedInputIndex) ==
          currentOutput.charAt(currentOutputIndex));
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233640906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233640906;
        
        
      
    
        
        
      
          
        
      
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.561 -0400", hash_original_method = "4C8321A90BCC237ABE581FD0E018E0B0", hash_generated_method = "52646F5361CABE8B70228BDACA795DB9")
    private String attemptToChooseFormattingPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_764190112 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_114823334 = null; 
        {
            boolean var9FA4F6FDF556EBF21497E7A5C69401AC_1516079615 = (nationalNumber.length() >= MIN_LEADING_DIGITS_LENGTH);
            {
                getAvailableFormats(nationalNumber.substring(0, MIN_LEADING_DIGITS_LENGTH));
                maybeCreateNewTemplate();
                varB4EAC82CA7396A68D541C85D26508E83_764190112 = inputAccruedNationalNumber();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_114823334 = prefixBeforeNationalNumber + nationalNumber.toString();
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_1349621954; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1349621954 = varB4EAC82CA7396A68D541C85D26508E83_764190112;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1349621954 = varB4EAC82CA7396A68D541C85D26508E83_114823334;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1349621954.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1349621954;
        
        
      
      
      
    
      
    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.562 -0400", hash_original_method = "A0C52ED0A89DE12301F2C974C5007560", hash_generated_method = "6606893F021AEE860DBA1E818F1BF06B")
    private String inputAccruedNationalNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_411440617 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1041526046 = null; 
        int lengthOfNationalNumber = nationalNumber.length();
        {
            String tempNationalNumber = "";
            {
                int i = 0;
                {
                    tempNationalNumber = inputDigitHelper(nationalNumber.charAt(i));
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_411440617 = ableToFormat
          ? prefixBeforeNationalNumber + tempNationalNumber
          : accruedInput.toString();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1041526046 = prefixBeforeNationalNumber.toString();
        } 
        String varA7E53CE21691AB073D9660D615818899_824402708; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_824402708 = varB4EAC82CA7396A68D541C85D26508E83_411440617;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_824402708 = varB4EAC82CA7396A68D541C85D26508E83_1041526046;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_824402708.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_824402708;
        
        
        
      
      
        
      
      
          
          
    
      
    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.562 -0400", hash_original_method = "810622AECED476A4374C59B83D98E171", hash_generated_method = "EB107BBFC97F7BECA263FE47374F46E0")
    private void removeNationalPrefixFromNationalNumber() {
        int startOfNationalNumber = 0;
        {
            boolean var045B25E8B4EA73C8B1EF895EBD592D5B_1420905200 = (currentMetaData.getCountryCode() == 1 && nationalNumber.charAt(0) == '1');
            {
                startOfNationalNumber = 1;
                prefixBeforeNationalNumber.append("1 ");
                isInternationalFormatting = true;
            } 
            {
                boolean varD31C8D12C55204ED68FD13843381C23F_1256857359 = (currentMetaData.hasNationalPrefix());
                {
                    Pattern nationalPrefixForParsing = regexCache.getPatternForRegex(currentMetaData.getNationalPrefixForParsing());
                    Matcher m = nationalPrefixForParsing.matcher(nationalNumber);
                    {
                        boolean var03FC912A54B68CD37D1C2CF7165E7E97_1625117224 = (m.lookingAt());
                        {
                            isInternationalFormatting = true;
                            startOfNationalNumber = m.end();
                            prefixBeforeNationalNumber.append(nationalNumber.substring(0, startOfNationalNumber));
                        } 
                    } 
                } 
            } 
        } 
        nationalNumber.delete(0, startOfNationalNumber);
        
        
        
      
      
      
    
      
        
      
      
        
        
        
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.563 -0400", hash_original_method = "B953FBA4B3460899EA66156C6BB3FF32", hash_generated_method = "365B3F4AB5D0256582C9FF28551E5400")
    private boolean attemptToExtractIdd() {
        Pattern internationalPrefix = regexCache.getPatternForRegex("\\" + PhoneNumberUtil.PLUS_SIGN + "|" +
            currentMetaData.getInternationalPrefix());
        Matcher iddMatcher = internationalPrefix.matcher(accruedInputWithoutFormatting);
        {
            boolean varCBE3A2BF3A06EE46C03E1FD5AE741CF2_1417785987 = (iddMatcher.lookingAt());
            {
                isInternationalFormatting = true;
                int startOfCountryCallingCode = iddMatcher.end();
                nationalNumber.setLength(0);
                nationalNumber.append(accruedInputWithoutFormatting.substring(startOfCountryCallingCode));
                prefixBeforeNationalNumber.append(
          accruedInputWithoutFormatting.substring(0, startOfCountryCallingCode));
                {
                    boolean var00BDCF4F1081545026429ABCA34FACA3_928299595 = (accruedInputWithoutFormatting.charAt(0) != PhoneNumberUtil.PLUS_SIGN);
                    {
                        prefixBeforeNationalNumber.append(" ");
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885956389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_885956389;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.563 -0400", hash_original_method = "218BC2BA6DFB456EB7693A201AB85277", hash_generated_method = "5DDA30A72CFA08141BB9C375E4C6F93C")
    private boolean attemptToExtractCountryCallingCode() {
        {
            boolean varF2876EC5E1A56C14F3F673620F1139E3_1889200939 = (nationalNumber.length() == 0);
        } 
        StringBuilder numberWithoutCountryCallingCode = new StringBuilder();
        int countryCode = phoneUtil.extractCountryCode(nationalNumber, numberWithoutCountryCallingCode);
        nationalNumber.setLength(0);
        nationalNumber.append(numberWithoutCountryCallingCode);
        String newRegionCode = phoneUtil.getRegionCodeForCountryCode(countryCode);
        {
            boolean var379D4BBBB3A58B82FD2703703856594C_241410214 = (!newRegionCode.equals(defaultCountry));
            {
                currentMetaData = getMetadataForRegion(newRegionCode);
            } 
        } 
        String countryCodeString = Integer.toString(countryCode);
        prefixBeforeNationalNumber.append(countryCodeString).append(" ");
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672558652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672558652;
        
        
      
    
        
        
        
      
    
        
        
        
        
      
    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.564 -0400", hash_original_method = "77D81BD33F378FE00304ED0E0D731511", hash_generated_method = "DA239CD1FA2532627C2E6242C3B0BB34")
    private char normalizeAndAccrueDigitsAndPlusSign(char nextChar, boolean rememberPosition) {
        char normalizedChar;
        {
            normalizedChar = nextChar;
            accruedInputWithoutFormatting.append(nextChar);
        } 
        {
            int radix = 10;
            normalizedChar = Character.forDigit(Character.digit(nextChar, radix), radix);
            accruedInputWithoutFormatting.append(normalizedChar);
            nationalNumber.append(normalizedChar);
        } 
        {
            positionToRemember = accruedInputWithoutFormatting.length();
        } 
        addTaint(nextChar);
        addTaint(rememberPosition);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1732310818 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1732310818;
        
        
        
      
      
    
      
      
      
      
    
        
      
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.565 -0400", hash_original_method = "E1A45868A03256452AD2B7163B170B11", hash_generated_method = "02A7C24BCBB9E9E99B73EE162D03FCED")
    private String inputDigitHelper(char nextChar) {
        String varB4EAC82CA7396A68D541C85D26508E83_912183425 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1901053910 = null; 
        Matcher digitMatcher = digitPattern.matcher(formattingTemplate);
        {
            boolean var86845E1C5CE6DEC62C1CC3A89B8DE2D9_1316329504 = (digitMatcher.find(lastMatchPosition));
            {
                String tempTemplate = digitMatcher.replaceFirst(Character.toString(nextChar));
                formattingTemplate.replace(0, tempTemplate.length(), tempTemplate);
                lastMatchPosition = digitMatcher.start();
                varB4EAC82CA7396A68D541C85D26508E83_912183425 = formattingTemplate.substring(0, lastMatchPosition + 1);
            } 
            {
                {
                    boolean var381FDF789F1A9E08BDBD9A928277B406_725714279 = (possibleFormats.size() == 1);
                    {
                        ableToFormat = false;
                    } 
                } 
                currentFormattingPattern = "";
                varB4EAC82CA7396A68D541C85D26508E83_1901053910 = accruedInput.toString();
            } 
        } 
        addTaint(nextChar);
        String varA7E53CE21691AB073D9660D615818899_1030740707; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1030740707 = varB4EAC82CA7396A68D541C85D26508E83_912183425;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1030740707 = varB4EAC82CA7396A68D541C85D26508E83_1901053910;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1030740707.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1030740707;
        
        
        
      
      
      
      
    
      
        
      
      
      
    
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.565 -0400", hash_original_field = "61158E732E552EC810F8738B9805D687", hash_generated_field = "5B7D0B52CB21DA6A99C67E3BE1997092")

    private static final PhoneMetadata EMPTY_METADATA = new PhoneMetadata().setInternationalPrefix("NA");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.565 -0400", hash_original_field = "35A028FF00BEB060B0EFB3D3BF69C219", hash_generated_field = "CDA8B06E4D1979CCC7536AC7E4352157")

    private static final Pattern CHARACTER_CLASS_PATTERN = Pattern.compile("\\[([^\\[\\]])*\\]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.565 -0400", hash_original_field = "6677810ED39749757FB9724C9FC93820", hash_generated_field = "BE2A4ACD67BE9F1D23C78B794AB2971C")

    private static final Pattern STANDALONE_DIGIT_PATTERN = Pattern.compile("\\d(?=[^,}][^,}])");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.565 -0400", hash_original_field = "3B829B24B9A48E8D695B7854B3461D48", hash_generated_field = "8E4ACB2A885AD8D446337A76E5C6D479")

    private static final Pattern ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*" +
          "(\\$\\d" + "[" + PhoneNumberUtil.VALID_PUNCTUATION + "]*)+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.565 -0400", hash_original_field = "916690B3AAEA02ED5BB6D44BA6E02578", hash_generated_field = "6B9E305E543306EA81CC751EC725A701")

    private static final int MIN_LEADING_DIGITS_LENGTH = 3;
}

