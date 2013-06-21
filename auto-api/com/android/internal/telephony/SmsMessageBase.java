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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.481 -0400", hash_original_method = "AD05D967CC0CB7102379795614E6FCD0", hash_generated_method = "AD05D967CC0CB7102379795614E6FCD0")
        public SmsMessageBase ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.482 -0400", hash_original_method = "852AB853407A268846BFEA18AE440E9F", hash_generated_method = "60FD93F6187BB6F44DFF49163A43F26F")
    @DSModeled(DSC.SAFE)
    public String getServiceCenterAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.482 -0400", hash_original_method = "2AFA8196465DE272F0DC79D229118536", hash_generated_method = "EB096CB1D54AC7972A5262C773CF1BA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginatingAddress() {
        String var21B6E482FB178ABD0BE0F046622BC549_1207627153 = (originatingAddress.getAddressString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (originatingAddress == null) {
            //return null;
        //}
        //return originatingAddress.getAddressString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.482 -0400", hash_original_method = "FD557C93F70B0337CD517510ED3486DC", hash_generated_method = "DEA928D0563DDA85A00C605524F536C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayOriginatingAddress() {
        {
            String var88F6FA6E292B41790CE2772846B14094_56645254 = (getOriginatingAddress());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailFrom;
        //} else {
            //return getOriginatingAddress();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.482 -0400", hash_original_method = "38D6DF2B366D642F936058839D02FFF6", hash_generated_method = "D324D4D5CC446C7EB29B28254F246207")
    @DSModeled(DSC.SAFE)
    public String getMessageBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return messageBody;
    }

    
    public abstract MessageClass getMessageClass();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.483 -0400", hash_original_method = "294CD2EFEADD47C746EB46385E4DBE4C", hash_generated_method = "F5D36DCC9436FEF230018B5A31FFF608")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayMessageBody() {
        {
            String var72A554CA17686BCE05A1367E1FA6A6DE_1212717437 = (getMessageBody());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isEmail) {
            //return emailBody;
        //} else {
            //return getMessageBody();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.483 -0400", hash_original_method = "C834A1A0643901270795A5B4BCF99FAB", hash_generated_method = "48C9799825661B9BE897E2553E025CC3")
    @DSModeled(DSC.SAFE)
    public String getPseudoSubject() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pseudoSubject == null ? "" : pseudoSubject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.483 -0400", hash_original_method = "43D56B1D4867C5433D89553E5EBA105D", hash_generated_method = "342F87001B2A07DFB25910822B481BCB")
    @DSModeled(DSC.SAFE)
    public long getTimestampMillis() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return scTimeMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.483 -0400", hash_original_method = "F105D3C22F0B3EBD8918C75272BAD29F", hash_generated_method = "D14AEFF28CF5BE055FBCF80EFDC6EC65")
    @DSModeled(DSC.SAFE)
    public boolean isEmail() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isEmail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.483 -0400", hash_original_method = "919AAA5779B3BEE7D0F95136809BE031", hash_generated_method = "91460B302FC10FBA4A6E112783A23C33")
    @DSModeled(DSC.SAFE)
    public String getEmailBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return emailBody;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.483 -0400", hash_original_method = "A55C12CE9F92FEDF0E5D1A5BBEF00065", hash_generated_method = "2717E3EAECBD6BABFE769F09DE5136A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.484 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "D5118E39456905DBD6DE87AE444258FF")
    @DSModeled(DSC.SAFE)
    public byte[] getUserData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.485 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "1ED49F7851CDDADF339A0D3F80937A8B")
    @DSModeled(DSC.SAFE)
    public SmsHeader getUserDataHeader() {
        return (SmsHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return userDataHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.485 -0400", hash_original_method = "8FB8695B65A836E3485315734D763070", hash_generated_method = "9437B5E4EE4F3FD8C75958CADEC8060C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.485 -0400", hash_original_method = "2631F0A4279B64E7D3B05442B104C580", hash_generated_method = "F09F5C12F32F230AB771442D9389DA96")
    @DSModeled(DSC.SAFE)
    public int getStatusOnIcc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return statusOnIcc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.486 -0400", hash_original_method = "AAC76DD7B09CC0753456FB5F01AB7263", hash_generated_method = "78DB26326C000A84F935C20F24B30D53")
    @DSModeled(DSC.SAFE)
    public int getIndexOnIcc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOnIcc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.486 -0400", hash_original_method = "595A54C85C11E702FC7EAA57C11F8990", hash_generated_method = "321B7D9C0CCA1A63EA1CCF5FA49CB6EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseMessageBody() {
        {
            boolean varC5753371EE5C9E73D9AC8D524467CE07_47492836 = (originatingAddress != null && originatingAddress.couldBeEmailGateway());
            {
                extractEmailAddressFromMessageBody();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (originatingAddress != null && originatingAddress.couldBeEmailGateway()) {
            //extractEmailAddressFromMessageBody();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.486 -0400", hash_original_method = "F064FDF94541D815C716CEC1EDEFC617", hash_generated_method = "41D1A92D44188B808165BFC8DC8F75E7")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.486 -0400", hash_original_method = "B2D4E090EDFC44832DF9266305B7A8C4", hash_generated_method = "B2D4E090EDFC44832DF9266305B7A8C4")
                public TextEncodingDetails ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.496 -0400", hash_original_method = "0DAE77F81824922FC906417D2F567A0C", hash_generated_method = "7FA477D65B7846837068D7D778A9E914")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.496 -0400", hash_original_method = "52358799A64B62248CAF80EBC016B547", hash_generated_method = "52358799A64B62248CAF80EBC016B547")
                public SubmitPduBase ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.496 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "E10C66900A7851B00580FCB64FFBD11C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varD7043DD576E6C9EDFF336B8E03E30D31_1413139821 = ("SubmitPdu: encodedScAddress = "
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


    
    private static final String LOG_TAG = "SMS";
}

