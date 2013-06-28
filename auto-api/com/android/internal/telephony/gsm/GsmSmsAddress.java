package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.PhoneNumberUtils;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsAddress;

public class GsmSmsAddress extends SmsAddress {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.759 -0400", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "A22F5AC7D2B24E395ECC9DCF8ED6A7F6")
    public  GsmSmsAddress(byte[] data, int offset, int length) {
        origBytes = new byte[length];
        System.arraycopy(data, offset, origBytes, 0, length);
        int addressLength = origBytes[OFFSET_ADDRESS_LENGTH] & 0xff;
        int toa = origBytes[OFFSET_TOA] & 0xff;
        ton = 0x7 & (toa >> 4);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid TOA - high bit must be set");
        } //End block
        {
            boolean var8AA5DB479CE3C3E465759EDBACB469BD_672513556 = (isAlphanumeric());
            {
                int countSeptets = addressLength * 4 / 7;
                address = GsmAlphabet.gsm7BitPackedToString(origBytes,
                    OFFSET_ADDRESS_VALUE, countSeptets);
            } //End block
            {
                byte lastByte = origBytes[length - 1];
                {
                    origBytes[length - 1] |= 0xf0;
                } //End block
                address = PhoneNumberUtils.calledPartyBCDToString(origBytes,
                    OFFSET_TOA, length - OFFSET_TOA);
                origBytes[length - 1] = lastByte;
            } //End block
        } //End collapsed parenthetic
        addTaint(data[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.760 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "5EC4B64933FA111B79263CB3CDC0067D")
    public String getAddressString() {
        String varB4EAC82CA7396A68D541C85D26508E83_93090444 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_93090444 = address;
        varB4EAC82CA7396A68D541C85D26508E83_93090444.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93090444;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.761 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "7227E9C640A054E3DCAFCF105C6A0E0C")
    public boolean isAlphanumeric() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885820562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885820562;
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.761 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "F7536202E4C43E37371E681418C371E2")
    public boolean isNetworkSpecific() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_277590462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_277590462;
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.761 -0400", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "748CFCA80A55511266FA581D96574F67")
    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean varDC3103C9C0B3609F4E175B06DFB54BDD_2038650230 = ((origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448772766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448772766;
        // ---------- Original Method ----------
        //return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                //&& isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.762 -0400", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "B3EFD48DAC43B4D9A4F7F89D4503E241")
    public boolean isCphsVoiceMessageSet() {
        boolean var61880FEBF4D8063F5585CFF83B6C1D47_442264072 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745469431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745469431;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.762 -0400", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "A22FECAEDC160ECF4E702087E708874E")
    public boolean isCphsVoiceMessageClear() {
        boolean var734188D61E85191EE9574E91D393DEB6_942555472 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260024762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260024762;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.762 -0400", hash_original_field = "FE0C689D40893F8D8408B0C3C164717C", hash_generated_field = "BAEAAA3B1617171D1C1E99BC0FAB1BFC")

    static final int OFFSET_ADDRESS_LENGTH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.762 -0400", hash_original_field = "D51390E83923F00957E2D1C0C4CB59F9", hash_generated_field = "7FDA3A692BC2298A10BEE7791ED6AD24")

    static final int OFFSET_TOA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.762 -0400", hash_original_field = "D5730F45AA393C85136C068E8D1F3B94", hash_generated_field = "E0E5804158D85D8E1B3FA048EFDDDD90")

    static final int OFFSET_ADDRESS_VALUE = 2;
}

