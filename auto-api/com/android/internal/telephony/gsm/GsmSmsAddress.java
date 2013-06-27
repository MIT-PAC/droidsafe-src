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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.359 -0400", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "6E4E1C01915829F2F240BB570ADEE0B8")
    public  GsmSmsAddress(byte[] data, int offset, int length) {
        origBytes = new byte[length];
        System.arraycopy(data, offset, origBytes, 0, length);
        int addressLength;
        addressLength = origBytes[OFFSET_ADDRESS_LENGTH] & 0xff;
        int toa;
        toa = origBytes[OFFSET_TOA] & 0xff;
        ton = 0x7 & (toa >> 4);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Invalid TOA - high bit must be set");
        } //End block
        {
            boolean var8AA5DB479CE3C3E465759EDBACB469BD_54850941 = (isAlphanumeric());
            {
                int countSeptets;
                countSeptets = addressLength * 4 / 7;
                address = GsmAlphabet.gsm7BitPackedToString(origBytes,
                    OFFSET_ADDRESS_VALUE, countSeptets);
            } //End block
            {
                byte lastByte;
                lastByte = origBytes[length - 1];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.359 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "ED5B94578B0EB724B562F7C487729C8F")
    public String getAddressString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1250023529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1250023529 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1250023529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1250023529;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.366 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "B3ABFA10C487C62995B12E6B44C0EC27")
    public boolean isAlphanumeric() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279183733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_279183733;
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.366 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "71D51C09D1A67EA6E80C7EB4E62337E8")
    public boolean isNetworkSpecific() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233404579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233404579;
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.367 -0400", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "EF2678F36D34E1B2D77E61741FCA0474")
    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean varDC3103C9C0B3609F4E175B06DFB54BDD_1402590104 = ((origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107479748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107479748;
        // ---------- Original Method ----------
        //return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                //&& isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.367 -0400", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "BA2181F84C9E7BAA14EC07F7A49C4514")
    public boolean isCphsVoiceMessageSet() {
        boolean var61880FEBF4D8063F5585CFF83B6C1D47_397569150 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631079872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631079872;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.367 -0400", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "5900CBAF23512B613971815437284310")
    public boolean isCphsVoiceMessageClear() {
        boolean var734188D61E85191EE9574E91D393DEB6_2070250101 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2132561653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2132561653;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.367 -0400", hash_original_field = "FE0C689D40893F8D8408B0C3C164717C", hash_generated_field = "BFBFD01C8D1616FDD55A32C54E42801F")

    static int OFFSET_ADDRESS_LENGTH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.367 -0400", hash_original_field = "D51390E83923F00957E2D1C0C4CB59F9", hash_generated_field = "FC0ED2D77E428AB9A5199BA0DCD7F4FC")

    static int OFFSET_TOA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.367 -0400", hash_original_field = "D5730F45AA393C85136C068E8D1F3B94", hash_generated_field = "72E2F1961907439BF63BA279D68B040F")

    static int OFFSET_ADDRESS_VALUE = 2;
}

