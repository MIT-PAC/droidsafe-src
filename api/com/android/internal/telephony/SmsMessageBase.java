package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;

import android.provider.Telephony;
import android.telephony.SmsMessage.MessageClass;





public abstract class SmsMessageBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.239 -0400", hash_original_field = "AE65F5A2A066853A360B6A8EEDA57828", hash_generated_field = "953A5C64799AB1489311C6011B533333")

    protected String scAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.239 -0400", hash_original_field = "5EB8D3EE49C59B31F6D2F65E87308429", hash_generated_field = "BD1560877F03EFED669748DBD0B45D62")

    protected SmsAddress originatingAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.239 -0400", hash_original_field = "6F630DA3AEF8F7E4E45D557FB821D65B", hash_generated_field = "89FF02F808D4BCE9F2E8DE3F563B9297")

    protected String messageBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "DA2F70C53D4BB513A32E2A6D9A3F41D0", hash_generated_field = "F74B21F6B8EB43522C8AAD82743C1818")

    protected String pseudoSubject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "31A50A1A6CCCA12543A55AA2F1122470", hash_generated_field = "7B75FB2345D907D56CE40FF55DDA4A51")

    protected String emailFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "CD83A1536D4596AB099BAEC34CF19CAE", hash_generated_field = "189574383A7EFDFC06B3E0A321B81EBA")

    protected String emailBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "3A71D936EE6FA891F0580F4DCE8486C1", hash_generated_field = "478672105AACCDC1F70A2E57ADFFF0F7")

    protected boolean isEmail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "5D17F4263C8F3708E1008880A17F7F73", hash_generated_field = "8EDB9B390EE3259DE2DD15A91F70DC53")

    protected long scTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "32434698E354D5AA090ECC3E076F454A", hash_generated_field = "BA53D9DF4124F5DBA3147C734F54E4C9")

    protected byte[] mPdu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "9056A38F8A99B2156D72FF9C286756D1")

    protected byte[] userData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "743D61CD0F8B499FFB5961C09D48393C", hash_generated_field = "795D77BADD3A2245C310BC7A0306EDF8")

    protected SmsHeader userDataHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "07F998F191EA34BF66F74C30A254C92E", hash_generated_field = "9A8C140F12CA6BAEF77B663768EC11A8")

    protected boolean isMwi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "C55EEDCBF950B4FA81BA9CF32A725B48", hash_generated_field = "9E7C2D18EC8B466F534E24DB5E6976E4")

    protected boolean mwiSense;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.240 -0400", hash_original_field = "4A4249921A310FDD4EEA842FDABE038E", hash_generated_field = "80949CD2AAA8F25ACC6F49334505D1D1")

    protected boolean mwiDontStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.241 -0400", hash_original_field = "68B427DC49BB3DC1ACC3CB1290D45468", hash_generated_field = "015E8B2F6DDFB1E30C16A36FA8BAA4EA")

    protected int statusOnIcc = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.241 -0400", hash_original_field = "B33FDB85E1B810B3B58D5B2C4DD6A0D8", hash_generated_field = "AD5AACBF52B9949A1B98619B33EE1DE0")

    protected int indexOnIcc = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.241 -0400", hash_original_field = "3DD57A6A28CB3BA5D3DDB93FBFBCD8F0", hash_generated_field = "5CD03C13D64B13DD53837A089F842F4C")

    public int messageRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.241 -0400", hash_original_method = "448E7EA73DB604D088340102AC4D011C", hash_generated_method = "448E7EA73DB604D088340102AC4D011C")
    public SmsMessageBase ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.241 -0400", hash_original_method = "852AB853407A268846BFEA18AE440E9F", hash_generated_method = "55123B39D699465675190FD9934BEAA9")
    public String getServiceCenterAddress() {
String varC22572C2F3CC51BA7680DA2DA227B3B9_1057326635 =         scAddress;
        varC22572C2F3CC51BA7680DA2DA227B3B9_1057326635.addTaint(taint);
        return varC22572C2F3CC51BA7680DA2DA227B3B9_1057326635;
        // ---------- Original Method ----------
        //return scAddress;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.242 -0400", hash_original_method = "2AFA8196465DE272F0DC79D229118536", hash_generated_method = "8C40C564E5F7967B97271C4ED932F197")
    public String getOriginatingAddress() {
        if(originatingAddress == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1100583120 =             null;
            var540C13E9E156B687226421B24F2DF178_1100583120.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1100583120;
        } //End block
String varBAEECC0C0325F00158F1A51E9AF62F0C_249596078 =         originatingAddress.getAddressString();
        varBAEECC0C0325F00158F1A51E9AF62F0C_249596078.addTaint(taint);
        return varBAEECC0C0325F00158F1A51E9AF62F0C_249596078;
        // ---------- Original Method ----------
        //if (originatingAddress == null) {
            //return null;
        //}
        //return originatingAddress.getAddressString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.243 -0400", hash_original_method = "FD557C93F70B0337CD517510ED3486DC", hash_generated_method = "D60E0F4EEEDEA633DFC8A207851E2CB0")
    public String getDisplayOriginatingAddress() {
        if(isEmail)        
        {
String varA948FCDBBF98CC7E4A7212A0C59F6386_184721707 =             emailFrom;
            varA948FCDBBF98CC7E4A7212A0C59F6386_184721707.addTaint(taint);
            return varA948FCDBBF98CC7E4A7212A0C59F6386_184721707;
        } //End block
        else
        {
String var7792F6A6B43019569BC7C607D05CFF32_345610970 =             getOriginatingAddress();
            var7792F6A6B43019569BC7C607D05CFF32_345610970.addTaint(taint);
            return var7792F6A6B43019569BC7C607D05CFF32_345610970;
        } //End block
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailFrom;
        //} else {
            //return getOriginatingAddress();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.243 -0400", hash_original_method = "38D6DF2B366D642F936058839D02FFF6", hash_generated_method = "93EAE729FAC5FC7337A08F1C3E3AD86F")
    public String getMessageBody() {
String var5D6A012E3EF316E3C3E5BCB26D5E53FC_803995810 =         messageBody;
        var5D6A012E3EF316E3C3E5BCB26D5E53FC_803995810.addTaint(taint);
        return var5D6A012E3EF316E3C3E5BCB26D5E53FC_803995810;
        // ---------- Original Method ----------
        //return messageBody;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract MessageClass getMessageClass();

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.244 -0400", hash_original_method = "294CD2EFEADD47C746EB46385E4DBE4C", hash_generated_method = "DFBE3C42181944EBD1B79FB78CABB6C5")
    public String getDisplayMessageBody() {
        if(isEmail)        
        {
String varD73E2475F4CD20448590C468FB789077_616547942 =             emailBody;
            varD73E2475F4CD20448590C468FB789077_616547942.addTaint(taint);
            return varD73E2475F4CD20448590C468FB789077_616547942;
        } //End block
        else
        {
String var76AE8A9B7982C2851ABBF27CDF28723D_399280480 =             getMessageBody();
            var76AE8A9B7982C2851ABBF27CDF28723D_399280480.addTaint(taint);
            return var76AE8A9B7982C2851ABBF27CDF28723D_399280480;
        } //End block
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailBody;
        //} else {
            //return getMessageBody();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.244 -0400", hash_original_method = "C834A1A0643901270795A5B4BCF99FAB", hash_generated_method = "8FFA4C2BC02C3A58CB58BD7D5046A7E3")
    public String getPseudoSubject() {
String var43B45F15709B426F8541F15D34F995DB_496817228 =         pseudoSubject == null ? "" : pseudoSubject;
        var43B45F15709B426F8541F15D34F995DB_496817228.addTaint(taint);
        return var43B45F15709B426F8541F15D34F995DB_496817228;
        // ---------- Original Method ----------
        //return pseudoSubject == null ? "" : pseudoSubject;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.245 -0400", hash_original_method = "43D56B1D4867C5433D89553E5EBA105D", hash_generated_method = "A99252073A90917CBA9D5F15F1D1448E")
    public long getTimestampMillis() {
        long var5D17F4263C8F3708E1008880A17F7F73_1805058241 = (scTimeMillis);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_609799820 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_609799820;
        // ---------- Original Method ----------
        //return scTimeMillis;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.245 -0400", hash_original_method = "F105D3C22F0B3EBD8918C75272BAD29F", hash_generated_method = "B5857FD10A940A9EF077DBFAA259A475")
    public boolean isEmail() {
        boolean var3A71D936EE6FA891F0580F4DCE8486C1_1231443912 = (isEmail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_430759451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_430759451;
        // ---------- Original Method ----------
        //return isEmail;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.246 -0400", hash_original_method = "919AAA5779B3BEE7D0F95136809BE031", hash_generated_method = "CDF1D2BB5A2805C34A91FC6E6149744D")
    public String getEmailBody() {
String varD73E2475F4CD20448590C468FB789077_410051728 =         emailBody;
        varD73E2475F4CD20448590C468FB789077_410051728.addTaint(taint);
        return varD73E2475F4CD20448590C468FB789077_410051728;
        // ---------- Original Method ----------
        //return emailBody;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.246 -0400", hash_original_method = "A55C12CE9F92FEDF0E5D1A5BBEF00065", hash_generated_method = "D433060AF547BE2D0F391861C6D33F03")
    public String getEmailFrom() {
String varA948FCDBBF98CC7E4A7212A0C59F6386_2066306201 =         emailFrom;
        varA948FCDBBF98CC7E4A7212A0C59F6386_2066306201.addTaint(taint);
        return varA948FCDBBF98CC7E4A7212A0C59F6386_2066306201;
        // ---------- Original Method ----------
        //return emailFrom;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int getProtocolIdentifier();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isReplace();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isCphsMwiMessage();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isMWIClearMessage();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isMWISetMessage();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isMwiDontStore();

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.248 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "F162B00A05F20475C1C8459CAD2AFAE1")
    public byte[] getUserData() {
        byte[] var56491F2E1C74898E18BB6E47D2425B19_1217076404 = (userData);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1534005470 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1534005470;
        // ---------- Original Method ----------
        //return userData;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.250 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "F2D8EE8F739FF7E74359902791AAB208")
    public SmsHeader getUserDataHeader() {
SmsHeader varC667C99DB117EC88666F8C8FC671A339_2114390902 =         userDataHeader;
        varC667C99DB117EC88666F8C8FC671A339_2114390902.addTaint(taint);
        return varC667C99DB117EC88666F8C8FC671A339_2114390902;
        // ---------- Original Method ----------
        //return userDataHeader;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.251 -0400", hash_original_method = "8FB8695B65A836E3485315734D763070", hash_generated_method = "45FD0C9F6A2B7EA5A7BCAFD74B9C0316")
    public byte[] getPdu() {
        byte[] var32434698E354D5AA090ECC3E076F454A_712116158 = (mPdu);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1236738423 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1236738423;
        // ---------- Original Method ----------
        //return mPdu;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int getStatus();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isStatusReportMessage();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isReplyPathPresent();

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.254 -0400", hash_original_method = "2631F0A4279B64E7D3B05442B104C580", hash_generated_method = "C1BD529865AC4F5AA7E91967F38138F1")
    public int getStatusOnIcc() {
        int var9B77A7241CF7AAD28F9628F9AB075B7C_1840848611 = (statusOnIcc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607128482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607128482;
        // ---------- Original Method ----------
        //return statusOnIcc;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.254 -0400", hash_original_method = "AAC76DD7B09CC0753456FB5F01AB7263", hash_generated_method = "B475CFE495C13EA3C2FA4A31ADA3FDD6")
    public int getIndexOnIcc() {
        int var3FC0421908CD5C8EB18377CDED0E586C_411730398 = (indexOnIcc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846768204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_846768204;
        // ---------- Original Method ----------
        //return indexOnIcc;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.255 -0400", hash_original_method = "595A54C85C11E702FC7EAA57C11F8990", hash_generated_method = "D64609881E15D7D9294453549C3CBFEF")
    protected void parseMessageBody() {
        if(originatingAddress != null && originatingAddress.couldBeEmailGateway())        
        {
            extractEmailAddressFromMessageBody();
        } //End block
        // ---------- Original Method ----------
        //if (originatingAddress != null && originatingAddress.couldBeEmailGateway()) {
            //extractEmailAddressFromMessageBody();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.256 -0400", hash_original_method = "F064FDF94541D815C716CEC1EDEFC617", hash_generated_method = "86534B4D7F7766F2EBFABD9618B8E8AE")
    protected void extractEmailAddressFromMessageBody() {
        String[] parts = messageBody.split("( /)|( )", 2);
        if(parts.length < 2)        
        return;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.256 -0400", hash_original_field = "FB6BB8D362A5891D772EE4EBDED02762", hash_generated_field = "0251AE8A4048E6E755DB65AA050EB95C")

        public int msgCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_field = "461948BCCC145D03F29BD11E78D82F44", hash_generated_field = "3B840D4249C6B174906961DA14E685E7")

        public int codeUnitCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_field = "A007EBD93959B0FF86050A7F06F574CA", hash_generated_field = "F425BDB43E90C40F2525966C09A36899")

        public int codeUnitsRemaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_field = "316B591A30F507B11B4242B296623A2B", hash_generated_field = "41FB06B8E10A61794CF2BF33D375493C")

        public int codeUnitSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_field = "B7785329B01021D25A3839E1068301ED", hash_generated_field = "3EBE9A5056219E00E65F8C29210512F1")

        public int languageTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_field = "DE31467D92F70B33D61FA7B2C3DD7E3F", hash_generated_field = "35E03F3700F4C29377F021AC1C80EBE5")

        public int languageShiftTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_method = "EB12EF3C02FD35F6F8285394EA102741", hash_generated_method = "EB12EF3C02FD35F6F8285394EA102741")
        public TextEncodingDetails ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.258 -0400", hash_original_method = "0DAE77F81824922FC906417D2F567A0C", hash_generated_method = "4053C8AEB353784E291E073534440C52")
        @Override
        public String toString() {
String var51CB2F3A1B387177F3F1DF7BFDBF9F7C_1727401243 =             "TextEncodingDetails " +
                    "{ msgCount=" + msgCount +
                    ", codeUnitCount=" + codeUnitCount +
                    ", codeUnitsRemaining=" + codeUnitsRemaining +
                    ", codeUnitSize=" + codeUnitSize +
                    ", languageTable=" + languageTable +
                    ", languageShiftTable=" + languageShiftTable +
                    " }";
            var51CB2F3A1B387177F3F1DF7BFDBF9F7C_1727401243.addTaint(taint);
            return var51CB2F3A1B387177F3F1DF7BFDBF9F7C_1727401243;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.259 -0400", hash_original_field = "275E12BC2D1B7A1135AB78E2E8FED5C1", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.259 -0400", hash_original_field = "482E018453FC47667D6222532DFEB427", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.259 -0400", hash_original_method = "85475C24C22C84D0619264E9E7FF5BD8", hash_generated_method = "85475C24C22C84D0619264E9E7FF5BD8")
        public SubmitPduBase ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.260 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "CA6595BAC179DEDBB2A8BDBD9BE1464A")
        public String toString() {
String var7D8267AB38F2C416692BE7250E9741D6_1414722967 =             "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
            var7D8267AB38F2C416692BE7250E9741D6_1414722967.addTaint(taint);
            return var7D8267AB38F2C416692BE7250E9741D6_1414722967;
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.260 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "5D6970F5D62D74D2B187EA5DA34AA652")

    private static final String LOG_TAG = "SMS";
}

