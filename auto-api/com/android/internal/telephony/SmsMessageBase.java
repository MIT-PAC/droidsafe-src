package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.SmsHeader;
import java.util.Arrays;
import static android.telephony.SmsMessage.MessageClass;
import android.provider.Telephony;

public abstract class SmsMessageBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "AE65F5A2A066853A360B6A8EEDA57828", hash_generated_field = "953A5C64799AB1489311C6011B533333")

    protected String scAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "5EB8D3EE49C59B31F6D2F65E87308429", hash_generated_field = "BD1560877F03EFED669748DBD0B45D62")

    protected SmsAddress originatingAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "6F630DA3AEF8F7E4E45D557FB821D65B", hash_generated_field = "89FF02F808D4BCE9F2E8DE3F563B9297")

    protected String messageBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "DA2F70C53D4BB513A32E2A6D9A3F41D0", hash_generated_field = "F74B21F6B8EB43522C8AAD82743C1818")

    protected String pseudoSubject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "31A50A1A6CCCA12543A55AA2F1122470", hash_generated_field = "7B75FB2345D907D56CE40FF55DDA4A51")

    protected String emailFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "CD83A1536D4596AB099BAEC34CF19CAE", hash_generated_field = "189574383A7EFDFC06B3E0A321B81EBA")

    protected String emailBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "3A71D936EE6FA891F0580F4DCE8486C1", hash_generated_field = "478672105AACCDC1F70A2E57ADFFF0F7")

    protected boolean isEmail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "5D17F4263C8F3708E1008880A17F7F73", hash_generated_field = "8EDB9B390EE3259DE2DD15A91F70DC53")

    protected long scTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "32434698E354D5AA090ECC3E076F454A", hash_generated_field = "BA53D9DF4124F5DBA3147C734F54E4C9")

    protected byte[] mPdu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "9056A38F8A99B2156D72FF9C286756D1")

    protected byte[] userData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "743D61CD0F8B499FFB5961C09D48393C", hash_generated_field = "795D77BADD3A2245C310BC7A0306EDF8")

    protected SmsHeader userDataHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "07F998F191EA34BF66F74C30A254C92E", hash_generated_field = "9A8C140F12CA6BAEF77B663768EC11A8")

    protected boolean isMwi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "C55EEDCBF950B4FA81BA9CF32A725B48", hash_generated_field = "9E7C2D18EC8B466F534E24DB5E6976E4")

    protected boolean mwiSense;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "4A4249921A310FDD4EEA842FDABE038E", hash_generated_field = "80949CD2AAA8F25ACC6F49334505D1D1")

    protected boolean mwiDontStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "68B427DC49BB3DC1ACC3CB1290D45468", hash_generated_field = "015E8B2F6DDFB1E30C16A36FA8BAA4EA")

    protected int statusOnIcc = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "B33FDB85E1B810B3B58D5B2C4DD6A0D8", hash_generated_field = "AD5AACBF52B9949A1B98619B33EE1DE0")

    protected int indexOnIcc = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_field = "3DD57A6A28CB3BA5D3DDB93FBFBCD8F0", hash_generated_field = "5CD03C13D64B13DD53837A089F842F4C")

    public int messageRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.952 -0400", hash_original_method = "448E7EA73DB604D088340102AC4D011C", hash_generated_method = "448E7EA73DB604D088340102AC4D011C")
    public SmsMessageBase ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.953 -0400", hash_original_method = "852AB853407A268846BFEA18AE440E9F", hash_generated_method = "E07B8CADB76C2B108A7ACF3951AD2FC4")
    public String getServiceCenterAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_603148958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_603148958 = scAddress;
        varB4EAC82CA7396A68D541C85D26508E83_603148958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603148958;
        // ---------- Original Method ----------
        //return scAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.953 -0400", hash_original_method = "2AFA8196465DE272F0DC79D229118536", hash_generated_method = "3BFBB618E7778DB623A7584B8A945DE1")
    public String getOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_145357398 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1818998765 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_145357398 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1818998765 = originatingAddress.getAddressString();
        String varA7E53CE21691AB073D9660D615818899_1735309491; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1735309491 = varB4EAC82CA7396A68D541C85D26508E83_145357398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1735309491 = varB4EAC82CA7396A68D541C85D26508E83_1818998765;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1735309491.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1735309491;
        // ---------- Original Method ----------
        //if (originatingAddress == null) {
            //return null;
        //}
        //return originatingAddress.getAddressString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.955 -0400", hash_original_method = "FD557C93F70B0337CD517510ED3486DC", hash_generated_method = "2C8B840F2D69FD109F50DA8B3AAF43E4")
    public String getDisplayOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1017601631 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_950441907 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1017601631 = emailFrom;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_950441907 = getOriginatingAddress();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1889374895; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1889374895 = varB4EAC82CA7396A68D541C85D26508E83_1017601631;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1889374895 = varB4EAC82CA7396A68D541C85D26508E83_950441907;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1889374895.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1889374895;
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailFrom;
        //} else {
            //return getOriginatingAddress();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.959 -0400", hash_original_method = "38D6DF2B366D642F936058839D02FFF6", hash_generated_method = "95EB4D21D71F1DC1124D6D1D4F31C058")
    public String getMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_965863610 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_965863610 = messageBody;
        varB4EAC82CA7396A68D541C85D26508E83_965863610.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_965863610;
        // ---------- Original Method ----------
        //return messageBody;
    }

    
    public abstract MessageClass getMessageClass();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.960 -0400", hash_original_method = "294CD2EFEADD47C746EB46385E4DBE4C", hash_generated_method = "E4E59627211E2D53119264CB3113FB7B")
    public String getDisplayMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1712224297 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1891341783 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1712224297 = emailBody;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1891341783 = getMessageBody();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_872491020; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_872491020 = varB4EAC82CA7396A68D541C85D26508E83_1712224297;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_872491020 = varB4EAC82CA7396A68D541C85D26508E83_1891341783;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_872491020.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_872491020;
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailBody;
        //} else {
            //return getMessageBody();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.961 -0400", hash_original_method = "C834A1A0643901270795A5B4BCF99FAB", hash_generated_method = "E7F7A816FF1CA0B21EE91494E839220A")
    public String getPseudoSubject() {
        String varB4EAC82CA7396A68D541C85D26508E83_612271379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_612271379 = pseudoSubject == null ? "" : pseudoSubject;
        varB4EAC82CA7396A68D541C85D26508E83_612271379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_612271379;
        // ---------- Original Method ----------
        //return pseudoSubject == null ? "" : pseudoSubject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.961 -0400", hash_original_method = "43D56B1D4867C5433D89553E5EBA105D", hash_generated_method = "5955912AFC5EF35539E9A5B30D539090")
    public long getTimestampMillis() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_508386592 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_508386592;
        // ---------- Original Method ----------
        //return scTimeMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.961 -0400", hash_original_method = "F105D3C22F0B3EBD8918C75272BAD29F", hash_generated_method = "8B00F2F180C20230EF159E1514ED4CEB")
    public boolean isEmail() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232765374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232765374;
        // ---------- Original Method ----------
        //return isEmail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.962 -0400", hash_original_method = "919AAA5779B3BEE7D0F95136809BE031", hash_generated_method = "425C6B850045535FF2F2B61F06E21326")
    public String getEmailBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1389373965 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1389373965 = emailBody;
        varB4EAC82CA7396A68D541C85D26508E83_1389373965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389373965;
        // ---------- Original Method ----------
        //return emailBody;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.962 -0400", hash_original_method = "A55C12CE9F92FEDF0E5D1A5BBEF00065", hash_generated_method = "E3D57C373BED7C0803015DBE1744331A")
    public String getEmailFrom() {
        String varB4EAC82CA7396A68D541C85D26508E83_1613281132 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1613281132 = emailFrom;
        varB4EAC82CA7396A68D541C85D26508E83_1613281132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613281132;
        // ---------- Original Method ----------
        //return emailFrom;
    }

    
    public abstract int getProtocolIdentifier();

    
    public abstract boolean isReplace();

    
    public abstract boolean isCphsMwiMessage();

    
    public abstract boolean isMWIClearMessage();

    
    public abstract boolean isMWISetMessage();

    
    public abstract boolean isMwiDontStore();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.963 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "0F21CFFBDE453F1613EB709828F171D6")
    public byte[] getUserData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2089925740 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2089925740;
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.963 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "D228E148A0BE92049173FDA47D1C18A5")
    public SmsHeader getUserDataHeader() {
        SmsHeader varB4EAC82CA7396A68D541C85D26508E83_1470120308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1470120308 = userDataHeader;
        varB4EAC82CA7396A68D541C85D26508E83_1470120308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470120308;
        // ---------- Original Method ----------
        //return userDataHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.964 -0400", hash_original_method = "8FB8695B65A836E3485315734D763070", hash_generated_method = "A4D4E9815F6C49BD0D69BCA131C8B931")
    public byte[] getPdu() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_436133389 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_436133389;
        // ---------- Original Method ----------
        //return mPdu;
    }

    
    public abstract int getStatus();

    
    public abstract boolean isStatusReportMessage();

    
    public abstract boolean isReplyPathPresent();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.964 -0400", hash_original_method = "2631F0A4279B64E7D3B05442B104C580", hash_generated_method = "22BF3429F0EE84352338C5150BD95C64")
    public int getStatusOnIcc() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103314006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103314006;
        // ---------- Original Method ----------
        //return statusOnIcc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.964 -0400", hash_original_method = "AAC76DD7B09CC0753456FB5F01AB7263", hash_generated_method = "7B2BEFDDE98D548D93D8557272186DFD")
    public int getIndexOnIcc() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080496211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080496211;
        // ---------- Original Method ----------
        //return indexOnIcc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.964 -0400", hash_original_method = "595A54C85C11E702FC7EAA57C11F8990", hash_generated_method = "62DFA458A7EFAE71DB270D0F769DE2B0")
    protected void parseMessageBody() {
        {
            boolean varC5753371EE5C9E73D9AC8D524467CE07_778988017 = (originatingAddress != null && originatingAddress.couldBeEmailGateway());
            {
                extractEmailAddressFromMessageBody();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (originatingAddress != null && originatingAddress.couldBeEmailGateway()) {
            //extractEmailAddressFromMessageBody();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_method = "F064FDF94541D815C716CEC1EDEFC617", hash_generated_method = "3F66117379CCC140598BF995F0D4B016")
    protected void extractEmailAddressFromMessageBody() {
        String[] parts = messageBody.split("( /)|( )", 2);
        emailFrom = parts[0];
        emailBody = parts[1];
        isEmail = Telephony.Mms.isEmailAddress(emailFrom);
        // ---------- Original Method ----------
        //String[] parts = messageBody.split("( /)|( )", 2);
        //if (parts.length < 2) return;
        //emailFrom = parts[0];
        //emailBody = parts[1];
        //isEmail = Telephony.Mms.isEmailAddress(emailFrom);
    }

    
    public static class TextEncodingDetails {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_field = "FB6BB8D362A5891D772EE4EBDED02762", hash_generated_field = "0251AE8A4048E6E755DB65AA050EB95C")

        public int msgCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_field = "461948BCCC145D03F29BD11E78D82F44", hash_generated_field = "3B840D4249C6B174906961DA14E685E7")

        public int codeUnitCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_field = "A007EBD93959B0FF86050A7F06F574CA", hash_generated_field = "F425BDB43E90C40F2525966C09A36899")

        public int codeUnitsRemaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_field = "316B591A30F507B11B4242B296623A2B", hash_generated_field = "41FB06B8E10A61794CF2BF33D375493C")

        public int codeUnitSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_field = "B7785329B01021D25A3839E1068301ED", hash_generated_field = "3EBE9A5056219E00E65F8C29210512F1")

        public int languageTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_field = "DE31467D92F70B33D61FA7B2C3DD7E3F", hash_generated_field = "35E03F3700F4C29377F021AC1C80EBE5")

        public int languageShiftTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.965 -0400", hash_original_method = "EB12EF3C02FD35F6F8285394EA102741", hash_generated_method = "EB12EF3C02FD35F6F8285394EA102741")
        public TextEncodingDetails ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.966 -0400", hash_original_method = "0DAE77F81824922FC906417D2F567A0C", hash_generated_method = "20C49BCE48F44744AE69CEC3424C12F5")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1115020656 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1115020656 = "TextEncodingDetails " +
                    "{ msgCount=" + msgCount +
                    ", codeUnitCount=" + codeUnitCount +
                    ", codeUnitsRemaining=" + codeUnitsRemaining +
                    ", codeUnitSize=" + codeUnitSize +
                    ", languageTable=" + languageTable +
                    ", languageShiftTable=" + languageShiftTable +
                    " }";
            varB4EAC82CA7396A68D541C85D26508E83_1115020656.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1115020656;
            // ---------- Original Method ----------
            //return "TextEncodingDetails " +
                    //"{ msgCount=" + msgCount +
                    //", codeUnitCount=" + codeUnitCount +
                    //", codeUnitsRemaining=" + codeUnitsRemaining +
                    //", codeUnitSize=" + codeUnitSize +
                    //", languageTable=" + languageTable +
                    //", languageShiftTable=" + languageShiftTable +
                    //" }";
        }

        
    }


    
    public static abstract class SubmitPduBase {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.966 -0400", hash_original_field = "275E12BC2D1B7A1135AB78E2E8FED5C1", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.966 -0400", hash_original_field = "482E018453FC47667D6222532DFEB427", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.967 -0400", hash_original_method = "85475C24C22C84D0619264E9E7FF5BD8", hash_generated_method = "85475C24C22C84D0619264E9E7FF5BD8")
        public SubmitPduBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.968 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "9C6DAD18EB7096E21F7EAAB23C2628EE")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1105741287 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1105741287 = "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
            varB4EAC82CA7396A68D541C85D26508E83_1105741287.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1105741287;
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.968 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "5D6970F5D62D74D2B187EA5DA34AA652")

    private static final String LOG_TAG = "SMS";
}

