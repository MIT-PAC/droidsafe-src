package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.telephony.SmsHeader;
import java.util.Arrays;
import static android.telephony.SmsMessage.MessageClass;
import android.provider.Telephony;

public abstract class SmsMessageBase {
    private static final String LOG_TAG = "SMS";
    protected String scAddress;
    protected SmsAddress originatingAddress;
    protected String messageBody;
    protected String pseudoSubject;
    protected String emailFrom;
    protected String emailBody;
    protected boolean isEmail;
    protected long scTimeMillis;
    protected byte[] mPdu;
    protected byte[] userData;
    protected SmsHeader userDataHeader;
    protected boolean isMwi;
    protected boolean mwiSense;
    protected boolean mwiDontStore;
    protected int statusOnIcc = -1;
    protected int indexOnIcc = -1;
    public int messageRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.574 -0400", hash_original_method = "852AB853407A268846BFEA18AE440E9F", hash_generated_method = "8481A1075D7FB4DD4FE6DEE32699E7A4")
    @DSModeled(DSC.SAFE)
    public String getServiceCenterAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "2AFA8196465DE272F0DC79D229118536", hash_generated_method = "1CD374895771D35C82CE4BE52EA02459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginatingAddress() {
        String var21B6E482FB178ABD0BE0F046622BC549_1369987033 = (originatingAddress.getAddressString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (originatingAddress == null) {
            //return null;
        //}
        //return originatingAddress.getAddressString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "FD557C93F70B0337CD517510ED3486DC", hash_generated_method = "572C0BB4D26B1D66DAB7A84373FFD732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayOriginatingAddress() {
        {
            String var88F6FA6E292B41790CE2772846B14094_913105298 = (getOriginatingAddress());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailFrom;
        //} else {
            //return getOriginatingAddress();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "38D6DF2B366D642F936058839D02FFF6", hash_generated_method = "53B57160DAC7E27E975EF8B838E068DF")
    @DSModeled(DSC.SAFE)
    public String getMessageBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return messageBody;
    }

    
    public abstract MessageClass getMessageClass();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "294CD2EFEADD47C746EB46385E4DBE4C", hash_generated_method = "6476F09E02A46E10E53C955F19D78544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayMessageBody() {
        {
            String var72A554CA17686BCE05A1367E1FA6A6DE_2024913162 = (getMessageBody());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailBody;
        //} else {
            //return getMessageBody();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "C834A1A0643901270795A5B4BCF99FAB", hash_generated_method = "A5B3F6FD7EB4F7F5F6BDB16D1737C840")
    @DSModeled(DSC.SAFE)
    public String getPseudoSubject() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pseudoSubject == null ? "" : pseudoSubject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "43D56B1D4867C5433D89553E5EBA105D", hash_generated_method = "C3537F152D3EA4888355180CB8A9B95E")
    @DSModeled(DSC.SAFE)
    public long getTimestampMillis() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return scTimeMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "F105D3C22F0B3EBD8918C75272BAD29F", hash_generated_method = "C57E7EDB5ED5B277CC748F3CC186C7D6")
    @DSModeled(DSC.SAFE)
    public boolean isEmail() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isEmail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "919AAA5779B3BEE7D0F95136809BE031", hash_generated_method = "EC0F3E02C12D2D3D4274ACBD306D30D4")
    @DSModeled(DSC.SAFE)
    public String getEmailBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return emailBody;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "A55C12CE9F92FEDF0E5D1A5BBEF00065", hash_generated_method = "9853BF5DBC360511E6ADD4A7483AAD07")
    @DSModeled(DSC.SAFE)
    public String getEmailFrom() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return emailFrom;
    }

    
    public abstract int getProtocolIdentifier();

    
    public abstract boolean isReplace();

    
    public abstract boolean isCphsMwiMessage();

    
    public abstract boolean isMWIClearMessage();

    
    public abstract boolean isMWISetMessage();

    
    public abstract boolean isMwiDontStore();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "A4763B00924ABD91C258C5A3FF2CE8AC")
    @DSModeled(DSC.SAFE)
    public byte[] getUserData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "E10BA9C97550057B8021A77685083A4D")
    @DSModeled(DSC.SAFE)
    public SmsHeader getUserDataHeader() {
        return (SmsHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return userDataHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "8FB8695B65A836E3485315734D763070", hash_generated_method = "745416F5E79439D06F3AD988138807B1")
    @DSModeled(DSC.SAFE)
    public byte[] getPdu() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mPdu;
    }

    
    public abstract int getStatus();

    
    public abstract boolean isStatusReportMessage();

    
    public abstract boolean isReplyPathPresent();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "2631F0A4279B64E7D3B05442B104C580", hash_generated_method = "EA18081FD8AD2A512D366245FC6AD5A0")
    @DSModeled(DSC.SAFE)
    public int getStatusOnIcc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return statusOnIcc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "AAC76DD7B09CC0753456FB5F01AB7263", hash_generated_method = "FEA2EA3466109D32849173486A604C90")
    @DSModeled(DSC.SAFE)
    public int getIndexOnIcc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOnIcc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "595A54C85C11E702FC7EAA57C11F8990", hash_generated_method = "ED7655CBF197A6C13AEB182D9AF047DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseMessageBody() {
        {
            boolean varC5753371EE5C9E73D9AC8D524467CE07_1686747568 = (originatingAddress != null && originatingAddress.couldBeEmailGateway());
            {
                extractEmailAddressFromMessageBody();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (originatingAddress != null && originatingAddress.couldBeEmailGateway()) {
            //extractEmailAddressFromMessageBody();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "F064FDF94541D815C716CEC1EDEFC617", hash_generated_method = "2ED6274901415836BB2A0BBA509B7962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void extractEmailAddressFromMessageBody() {
        String[] parts;
        parts = messageBody.split("( /)|( )", 2);
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
        public int msgCount;
        public int codeUnitCount;
        public int codeUnitsRemaining;
        public int codeUnitSize;
        public int languageTable;
        public int languageShiftTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.575 -0400", hash_original_method = "0DAE77F81824922FC906417D2F567A0C", hash_generated_method = "1174E09B69BC259A46F2967B6B60DFBF")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
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
        public byte[] encodedScAddress;
        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.576 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "2BC27BCF6DB77BC540FC1A248A5E822A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varD7043DD576E6C9EDFF336B8E03E30D31_596701418 = ("SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
}


