package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import android.provider.Telephony;
import android.telephony.SmsMessage.MessageClass;

public abstract class SmsMessageBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.451 -0500", hash_original_field = "C996BA564C8E7280B21DCC0E50132626", hash_generated_field = "5D6970F5D62D74D2B187EA5DA34AA652")

    private static final String LOG_TAG = "SMS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.454 -0500", hash_original_field = "3916B332823A84320FA4120C0B5FD1E7", hash_generated_field = "953A5C64799AB1489311C6011B533333")

    protected String scAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.457 -0500", hash_original_field = "8E48A8A53BC00A4314713595210ACE31", hash_generated_field = "BD1560877F03EFED669748DBD0B45D62")

    protected SmsAddress originatingAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.459 -0500", hash_original_field = "BE141F4A3B044451E98909739FCCAB14", hash_generated_field = "89FF02F808D4BCE9F2E8DE3F563B9297")

    protected String messageBody;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.461 -0500", hash_original_field = "719665F8C1528B6C3729D888C9370F3A", hash_generated_field = "F74B21F6B8EB43522C8AAD82743C1818")

    protected String pseudoSubject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.463 -0500", hash_original_field = "F6D07A2A5C3A203EA37D54A271902CBE", hash_generated_field = "7B75FB2345D907D56CE40FF55DDA4A51")

    protected String emailFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.465 -0500", hash_original_field = "9D1D3774457A4F7849336F8DBC6A45CF", hash_generated_field = "189574383A7EFDFC06B3E0A321B81EBA")

    protected String emailBody;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.468 -0500", hash_original_field = "8DFCF4525E6F4A8B48E03CAFFBD43AC0", hash_generated_field = "478672105AACCDC1F70A2E57ADFFF0F7")

    protected boolean isEmail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.470 -0500", hash_original_field = "97EFFF14419A8001D352EAE936326C18", hash_generated_field = "8EDB9B390EE3259DE2DD15A91F70DC53")

    protected long scTimeMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.473 -0500", hash_original_field = "AC40DF9E7D52434C8711958F6EB1F3FB", hash_generated_field = "BA53D9DF4124F5DBA3147C734F54E4C9")

    protected byte[] mPdu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.475 -0500", hash_original_field = "A84FAC4EE7B4249A85AFD54238EB3F78", hash_generated_field = "9056A38F8A99B2156D72FF9C286756D1")

    protected byte[] userData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.477 -0500", hash_original_field = "532180B80C80AE52803AEB5499571541", hash_generated_field = "795D77BADD3A2245C310BC7A0306EDF8")

    protected SmsHeader userDataHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.480 -0500", hash_original_field = "36A0053B475072D820F952C93B43D3DE", hash_generated_field = "DA65D7A242DF9B5BA880E7C32F090650")

    // 23.038 Section 4
    /** {@hide} */
    protected boolean isMwi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.483 -0500", hash_original_field = "7FFE6A60DE8AF6315FA422AA95A77148", hash_generated_field = "9E7C2D18EC8B466F534E24DB5E6976E4")

    protected boolean mwiSense;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.485 -0500", hash_original_field = "BB5A5F2A467AF900C15720BFA72F1AF6", hash_generated_field = "80949CD2AAA8F25ACC6F49334505D1D1")

    protected boolean mwiDontStore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.488 -0500", hash_original_field = "9F305738DF95B9CA0CCEDD7B75839D85", hash_generated_field = "015E8B2F6DDFB1E30C16A36FA8BAA4EA")

    protected int statusOnIcc = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.490 -0500", hash_original_field = "81BF6F2C2139FCF5D4FA517082623EEA", hash_generated_field = "AD5AACBF52B9949A1B98619B33EE1DE0")

    protected int indexOnIcc = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.492 -0500", hash_original_field = "E6F7BFC22487D00A28F9E36C2AA573F1", hash_generated_field = "5CD03C13D64B13DD53837A089F842F4C")

    public int messageRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.241 -0400", hash_original_method = "448E7EA73DB604D088340102AC4D011C", hash_generated_method = "448E7EA73DB604D088340102AC4D011C")
    public SmsMessageBase ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the address of the SMS service center that relayed this message
     * or null if there is none.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.527 -0500", hash_original_method = "852AB853407A268846BFEA18AE440E9F", hash_generated_method = "3E605C1FE68614AAC812FC5872AE1A75")
    
public String getServiceCenterAddress() {
        return scAddress;
    }

    /**
     * Returns the originating address (sender) of this SMS message in String
     * form or null if unavailable
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.529 -0500", hash_original_method = "2AFA8196465DE272F0DC79D229118536", hash_generated_method = "81EAC08A777C5C28124944A8F2B82D10")
    
public String getOriginatingAddress() {
        if (originatingAddress == null) {
            return null;
        }

        return originatingAddress.getAddressString();
    }

    /**
     * Returns the originating address, or email from address if this message
     * was from an email gateway. Returns null if originating address
     * unavailable.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.532 -0500", hash_original_method = "FD557C93F70B0337CD517510ED3486DC", hash_generated_method = "967FE1F7DA13385A123320CA4C74EF30")
    
public String getDisplayOriginatingAddress() {
        if (isEmail) {
            return emailFrom;
        } else {
            return getOriginatingAddress();
        }
    }

    /**
     * Returns the message body as a String, if it exists and is text based.
     * @return message body is there is one, otherwise null
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.534 -0500", hash_original_method = "38D6DF2B366D642F936058839D02FFF6", hash_generated_method = "C7D99EAEEAF8DC7F92458EB6BAE14559")
    
public String getMessageBody() {
        return messageBody;
    }

    /**
     * Returns the class of this message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.536 -0500", hash_original_method = "B61EE8B022E4AB2517F2EA63436214CD", hash_generated_method = "D0B1BBD2A5F62DEBA7E822C1A7C9A6ED")
    
public abstract MessageClass getMessageClass();

    /**
     * Returns the message body, or email message body if this message was from
     * an email gateway. Returns null if message body unavailable.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.539 -0500", hash_original_method = "294CD2EFEADD47C746EB46385E4DBE4C", hash_generated_method = "1A0D4EE64BBC5F9468BD74E8AC612DDB")
    
public String getDisplayMessageBody() {
        if (isEmail) {
            return emailBody;
        } else {
            return getMessageBody();
        }
    }

    /**
     * Unofficial convention of a subject line enclosed in parens empty string
     * if not present
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.541 -0500", hash_original_method = "C834A1A0643901270795A5B4BCF99FAB", hash_generated_method = "42C213E1283BFD7276924D9464C51132")
    
public String getPseudoSubject() {
        return pseudoSubject == null ? "" : pseudoSubject;
    }

    /**
     * Returns the service centre timestamp in currentTimeMillis() format
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.544 -0500", hash_original_method = "43D56B1D4867C5433D89553E5EBA105D", hash_generated_method = "5FB4B80755B3F1590BC259380D61686C")
    
public long getTimestampMillis() {
        return scTimeMillis;
    }

    /**
     * Returns true if message is an email.
     *
     * @return true if this message came through an email gateway and email
     *         sender / subject / parsed body are available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.547 -0500", hash_original_method = "F105D3C22F0B3EBD8918C75272BAD29F", hash_generated_method = "AB8CA7B58858A9BCED8F2407ECF942FD")
    
public boolean isEmail() {
        return isEmail;
    }

    /**
     * @return if isEmail() is true, body of the email sent through the gateway.
     *         null otherwise
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.549 -0500", hash_original_method = "919AAA5779B3BEE7D0F95136809BE031", hash_generated_method = "BED9E707F6CA1927762B6F4C1DF8DADD")
    
public String getEmailBody() {
        return emailBody;
    }

    /**
     * @return if isEmail() is true, email from address of email sent through
     *         the gateway. null otherwise
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.552 -0500", hash_original_method = "A55C12CE9F92FEDF0E5D1A5BBEF00065", hash_generated_method = "A8C91CB89F046AEB25D117B71F6C32F1")
    
public String getEmailFrom() {
        return emailFrom;
    }

    /**
     * Get protocol identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.554 -0500", hash_original_method = "3E66B2546D43CCD1D4D23DAAAC4A1AA6", hash_generated_method = "E150D45D651EBBBCBD4B8ABC274DFBA3")
    
public abstract int getProtocolIdentifier();

    /**
     * See TS 23.040 9.2.3.9 returns true if this is a "replace short message"
     * SMS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.556 -0500", hash_original_method = "64CB7FE0B301A04BAC030A1BA78B6D08", hash_generated_method = "D45051F00DD7385AB394D7C752D1569B")
    
public abstract boolean isReplace();

    /**
     * Returns true for CPHS MWI toggle message.
     *
     * @return true if this is a CPHS MWI toggle message See CPHS 4.2 section
     *         B.4.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.559 -0500", hash_original_method = "B823D1584A04CE44DC421738E7CD944E", hash_generated_method = "8041FC6F9120B0288E53EBB7B0A59E1D")
    
public abstract boolean isCphsMwiMessage();

    /**
     * returns true if this message is a CPHS voicemail / message waiting
     * indicator (MWI) clear message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.567 -0500", hash_original_method = "17D5F1B59BFF3ACF9AACAB0528BFA1A3", hash_generated_method = "ECD81ED7CE14FB0FD00A600B6805594B")
    
public abstract boolean isMWIClearMessage();

    /**
     * returns true if this message is a CPHS voicemail / message waiting
     * indicator (MWI) set message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.569 -0500", hash_original_method = "208EF101F62A8D1A5B50E120978B483F", hash_generated_method = "94704115E16862DF76050908295F5844")
    
public abstract boolean isMWISetMessage();

    /**
     * returns true if this message is a "Message Waiting Indication Group:
     * Discard Message" notification and should not be stored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.572 -0500", hash_original_method = "5B90E4B20FBB0E96385AD394954049F6", hash_generated_method = "0B704924EB1F6AD7648329708ADCA5A7")
    
public abstract boolean isMwiDontStore();

    /**
     * returns the user data section minus the user data header if one was
     * present.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.574 -0500", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "3C6B7B4E0AEF9204FAF6411B9A1EC06B")
    
public byte[] getUserData() {
        return userData;
    }

    /**
     * Returns an object representing the user data header
     *
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.577 -0500", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "AB01DF03CB1FA9D50ECC033F79C319DD")
    
public SmsHeader getUserDataHeader() {
        return userDataHeader;
    }

    /**
     * TODO(cleanup): The term PDU is used in a seemingly non-unique
     * manner -- for example, what is the difference between this byte
     * array and the contents of SubmitPdu objects.  Maybe a more
     * illustrative term would be appropriate.
     */

    /**
     * Returns the raw PDU for the message.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.579 -0500", hash_original_method = "8FB8695B65A836E3485315734D763070", hash_generated_method = "8BC9FED7DDF3572EAF3A38218494B90C")
    
public byte[] getPdu() {
        return mPdu;
    }

    /**
     * For an SMS-STATUS-REPORT message, this returns the status field from
     * the status report.  This field indicates the status of a previously
     * submitted SMS, if requested.  See TS 23.040, 9.2.3.15 TP-Status for a
     * description of values.
     *
     * @return 0 indicates the previously sent message was received.
     *         See TS 23.040, 9.9.2.3.15 for a description of other possible
     *         values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.581 -0500", hash_original_method = "133516DDD0D787C1D7D737647A15F491", hash_generated_method = "78DAC92C589514A7EDF05962AC126079")
    
public abstract int getStatus();

    /**
     * Return true iff the message is a SMS-STATUS-REPORT message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.585 -0500", hash_original_method = "07C11C5655EC5F1A3A1997AF95C77197", hash_generated_method = "BF48E1AB4852B4ED4CCF418B1996C09E")
    
public abstract boolean isStatusReportMessage();

    /**
     * Returns true iff the <code>TP-Reply-Path</code> bit is set in
     * this message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.587 -0500", hash_original_method = "3D83D5F35F081610F4F806A8BA1989DE", hash_generated_method = "D3DE6AB22CA2FD3887B6C91CA718C58B")
    
public abstract boolean isReplyPathPresent();

    /**
     * Returns the status of the message on the ICC (read, unread, sent, unsent).
     *
     * @return the status of the message on the ICC.  These are:
     *         SmsManager.STATUS_ON_ICC_FREE
     *         SmsManager.STATUS_ON_ICC_READ
     *         SmsManager.STATUS_ON_ICC_UNREAD
     *         SmsManager.STATUS_ON_ICC_SEND
     *         SmsManager.STATUS_ON_ICC_UNSENT
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.589 -0500", hash_original_method = "2631F0A4279B64E7D3B05442B104C580", hash_generated_method = "D4F63F8FC4A4B3637BE6377D8105CFB7")
    
public int getStatusOnIcc() {
        return statusOnIcc;
    }

    /**
     * Returns the record index of the message on the ICC (1-based index).
     * @return the record index of the message on the ICC, or -1 if this
     *         SmsMessage was not created from a ICC SMS EF record.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.592 -0500", hash_original_method = "AAC76DD7B09CC0753456FB5F01AB7263", hash_generated_method = "5821FB7208E6845C0E5A0C15B59D7F15")
    
public int getIndexOnIcc() {
        return indexOnIcc;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.594 -0500", hash_original_method = "595A54C85C11E702FC7EAA57C11F8990", hash_generated_method = "053495824B802D464C8A1D8558C6B268")
    
protected void parseMessageBody() {
        // originatingAddress could be null if this message is from a status
        // report.
        if (originatingAddress != null && originatingAddress.couldBeEmailGateway()) {
            extractEmailAddressFromMessageBody();
        }
    }
    
    public static class TextEncodingDetails {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.495 -0500", hash_original_field = "5643CD0ED1899D5B0898562BD627FF70", hash_generated_field = "0251AE8A4048E6E755DB65AA050EB95C")

        public int msgCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.498 -0500", hash_original_field = "F3CF2CBC134BF71F66D0893D7D97143A", hash_generated_field = "3B840D4249C6B174906961DA14E685E7")

        public int codeUnitCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.501 -0500", hash_original_field = "16C413E9494D294979C0C1B376522E0A", hash_generated_field = "F425BDB43E90C40F2525966C09A36899")

        public int codeUnitsRemaining;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.503 -0500", hash_original_field = "5DF399295EF949B6B18C75490F62C657", hash_generated_field = "41FB06B8E10A61794CF2BF33D375493C")

        public int codeUnitSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.505 -0500", hash_original_field = "EB04DC0F9D823ECDE8E8EC505F04F3D2", hash_generated_field = "3EBE9A5056219E00E65F8C29210512F1")

        public int languageTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.508 -0500", hash_original_field = "51586E6521B2F7C2D483B8605CB8B4F6", hash_generated_field = "35E03F3700F4C29377F021AC1C80EBE5")

        public int languageShiftTable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.257 -0400", hash_original_method = "EB12EF3C02FD35F6F8285394EA102741", hash_generated_method = "EB12EF3C02FD35F6F8285394EA102741")
        public TextEncodingDetails ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.512 -0500", hash_original_method = "0DAE77F81824922FC906417D2F567A0C", hash_generated_method = "BA24CF6DD454FA51B27C3BD5901CAF3D")
        
@Override
        public String toString() {
            return "TextEncodingDetails " +
                    "{ msgCount=" + msgCount +
                    ", codeUnitCount=" + codeUnitCount +
                    ", codeUnitsRemaining=" + codeUnitsRemaining +
                    ", codeUnitSize=" + codeUnitSize +
                    ", languageTable=" + languageTable +
                    ", languageShiftTable=" + languageShiftTable +
                    " }";
        }
        
    }
    
    public static abstract class SubmitPduBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.518 -0500", hash_original_field = "C8745BBAF5F74776C20A108492164E97", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.520 -0500", hash_original_field = "67003B73FD5C802781F626C68CAE8BB6", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.259 -0400", hash_original_method = "85475C24C22C84D0619264E9E7FF5BD8", hash_generated_method = "85475C24C22C84D0619264E9E7FF5BD8")
        public SubmitPduBase ()
        {
            //Synthesized constructor
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.523 -0500", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "D0C20D3DE0C0706C4141E4BF6E7BAEC9")
        
public String toString() {
            return "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
        }
        
    }

    /**
     * Try to parse this message as an email gateway message
     * There are two ways specified in TS 23.040 Section 3.8 :
     *  - SMS message "may have its TP-PID set for Internet electronic mail - MT
     * SMS format: [<from-address><space>]<message> - "Depending on the
     * nature of the gateway, the destination/origination address is either
     * derived from the content of the SMS TP-OA or TP-DA field, or the
     * TP-OA/TP-DA field contains a generic gateway address and the to/from
     * address is added at the beginning as shown above." (which is supported here)
     * - Multiple addresses separated by commas, no spaces, Subject field delimited
     * by '()' or '##' and '#' Section 9.2.3.24.11 (which are NOT supported here)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:39.597 -0500", hash_original_method = "F064FDF94541D815C716CEC1EDEFC617", hash_generated_method = "EF2E7510A21A5BE663EEDF38B5030665")
    
protected void extractEmailAddressFromMessageBody() {

        /* Some carriers may use " /" delimiter as below
         *
         * 1. [x@y][ ]/[subject][ ]/[body]
         * -or-
         * 2. [x@y][ ]/[body]
         */
         String[] parts = messageBody.split("( /)|( )", 2);
         if (parts.length < 2) return;
         emailFrom = parts[0];
         emailBody = parts[1];
         isEmail = Telephony.Mms.isEmailAddress(emailFrom);
    }
}

