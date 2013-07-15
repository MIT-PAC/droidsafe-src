package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.telephony.PhoneNumberUtils;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsAddress;

public class GsmSmsAddress extends SmsAddress {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.306 -0400", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "3F824C08EE22DD6AA29C0E1270327A89")
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
            RuntimeException var6CA3073F7E67558B97FD5C508BD6CFEC_586456060 = new RuntimeException("Invalid TOA - high bit must be set");
            var6CA3073F7E67558B97FD5C508BD6CFEC_586456060.addTaint(taint);
            throw var6CA3073F7E67558B97FD5C508BD6CFEC_586456060;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.307 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "560FECE3006E573E593F64156C45FF30")
    public String getAddressString() {
String var814577DDD37BAFB17E08CBEFDB411BAE_631595472 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_631595472.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_631595472;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.307 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "A5E9C51C15950749170F70D134EC3732")
    public boolean isAlphanumeric() {
        boolean var8474A011523A2E65AABA589B65056EFA_967030195 = (ton == TON_ALPHANUMERIC);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907273644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907273644;
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.308 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "058CB8E5B16F04DFFAB7D60E6DC45A3D")
    public boolean isNetworkSpecific() {
        boolean varAC4CC2CBB1E733051BE0F1E272DA0F89_393251627 = (ton == TON_NETWORK);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873540371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873540371;
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.308 -0400", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "98FED263ABBF6F3B95D884D1F0C65928")
    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean var95ACF0A9BE4A49BF12B0430CD6C50261_423776206 = ((origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842950583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842950583;
        // ---------- Original Method ----------
        //return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                //&& isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.308 -0400", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "D4DCDBF43AF5B92625F3AF70915EC786")
    public boolean isCphsVoiceMessageSet() {
        boolean varFB8178DB0D1582B09684FEDA60AAB8D2_1093306122 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246639254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246639254;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.309 -0400", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "F12C28869298D0E79A759DC39D5C6D64")
    public boolean isCphsVoiceMessageClear() {
        boolean var1E82CA9B40E32514DB7591611C2E873C_1827984008 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971939365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971939365;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.309 -0400", hash_original_field = "FE0C689D40893F8D8408B0C3C164717C", hash_generated_field = "BAEAAA3B1617171D1C1E99BC0FAB1BFC")

    static final int OFFSET_ADDRESS_LENGTH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.309 -0400", hash_original_field = "D51390E83923F00957E2D1C0C4CB59F9", hash_generated_field = "7FDA3A692BC2298A10BEE7791ED6AD24")

    static final int OFFSET_TOA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.309 -0400", hash_original_field = "D5730F45AA393C85136C068E8D1F3B94", hash_generated_field = "E0E5804158D85D8E1B3FA048EFDDDD90")

    static final int OFFSET_ADDRESS_VALUE = 2;
}

