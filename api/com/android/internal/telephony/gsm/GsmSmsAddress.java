package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.telephony.PhoneNumberUtils;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsAddress;

public class GsmSmsAddress extends SmsAddress {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.412 -0400", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "7F1AD34958D911C580798ABF07860B3C")
    public  GsmSmsAddress(byte[] data, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(data[0]);
        origBytes = new byte[length];
        System.arraycopy(data, offset, origBytes, 0, length);
        int addressLength = origBytes[OFFSET_ADDRESS_LENGTH] & 0xff;
        int toa = origBytes[OFFSET_TOA] & 0xff;
        ton = 0x7 & (toa >> 4);
        if((toa & 0x80) != 0x80)        
        {
            RuntimeException var6CA3073F7E67558B97FD5C508BD6CFEC_1176108925 = new RuntimeException("Invalid TOA - high bit must be set");
            var6CA3073F7E67558B97FD5C508BD6CFEC_1176108925.addTaint(taint);
            throw var6CA3073F7E67558B97FD5C508BD6CFEC_1176108925;
        } //End block
        if(isAlphanumeric())        
        {
            int countSeptets = addressLength * 4 / 7;
            address = GsmAlphabet.gsm7BitPackedToString(origBytes,
                    OFFSET_ADDRESS_VALUE, countSeptets);
        } //End block
        else
        {
            byte lastByte = origBytes[length - 1];
            if((addressLength & 1) == 1)            
            {
                origBytes[length - 1] |= 0xf0;
            } //End block
            address = PhoneNumberUtils.calledPartyBCDToString(origBytes,
                    OFFSET_TOA, length - OFFSET_TOA);
            origBytes[length - 1] = lastByte;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.412 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "4779B4B6BD4D676D3C7ADCBFC818D660")
    public String getAddressString() {
String var814577DDD37BAFB17E08CBEFDB411BAE_786891284 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_786891284.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_786891284;
        // ---------- Original Method ----------
        //return address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.412 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "7D0F3273BF40802A7011144E385ED164")
    public boolean isAlphanumeric() {
        boolean var8474A011523A2E65AABA589B65056EFA_1166853336 = (ton == TON_ALPHANUMERIC);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468599816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468599816;
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "A0518BD4C7E7CB78429D245A1F1406E5")
    public boolean isNetworkSpecific() {
        boolean varAC4CC2CBB1E733051BE0F1E272DA0F89_868561599 = (ton == TON_NETWORK);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735829264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735829264;
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "4744AFEA24CAB7FA1A7A9D21FE7FC326")
    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean var95ACF0A9BE4A49BF12B0430CD6C50261_774385182 = ((origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943672991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943672991;
        // ---------- Original Method ----------
        //return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                //&& isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "079EEB721B933EE0B2C3D6B99A5A4E12")
    public boolean isCphsVoiceMessageSet() {
        boolean varFB8178DB0D1582B09684FEDA60AAB8D2_646605073 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738503983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738503983;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "471D4659BC9673DE119B1D8AA694A034")
    public boolean isCphsVoiceMessageClear() {
        boolean var1E82CA9B40E32514DB7591611C2E873C_690871101 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634136273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634136273;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_field = "FE0C689D40893F8D8408B0C3C164717C", hash_generated_field = "BAEAAA3B1617171D1C1E99BC0FAB1BFC")

    static final int OFFSET_ADDRESS_LENGTH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_field = "D51390E83923F00957E2D1C0C4CB59F9", hash_generated_field = "7FDA3A692BC2298A10BEE7791ED6AD24")

    static final int OFFSET_TOA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.413 -0400", hash_original_field = "D5730F45AA393C85136C068E8D1F3B94", hash_generated_field = "E0E5804158D85D8E1B3FA048EFDDDD90")

    static final int OFFSET_ADDRESS_VALUE = 2;
}

