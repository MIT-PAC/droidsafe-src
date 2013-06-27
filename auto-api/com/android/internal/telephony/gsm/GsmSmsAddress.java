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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.074 -0400", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "D8B5F9F963C7418C8E316B663D7AD6AF")
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
            boolean var8AA5DB479CE3C3E465759EDBACB469BD_1756870711 = (isAlphanumeric());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.075 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "65187B6337DF07DAD4FB09804F79EA5B")
    public String getAddressString() {
        String varB4EAC82CA7396A68D541C85D26508E83_255289747 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_255289747 = address;
        varB4EAC82CA7396A68D541C85D26508E83_255289747.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255289747;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.075 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "9436D7855017CBBD8989B971B17A5720")
    public boolean isAlphanumeric() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224094628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224094628;
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.075 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "7300566C3A76CA16A00508EAE83EDD86")
    public boolean isNetworkSpecific() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814710935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814710935;
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.082 -0400", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "5C3F31D4F65C1BE901486F159E3B9447")
    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean varDC3103C9C0B3609F4E175B06DFB54BDD_1675857969 = ((origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476905926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476905926;
        // ---------- Original Method ----------
        //return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                //&& isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.082 -0400", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "B5C2773AD8B7481D96B8D6E402897F8B")
    public boolean isCphsVoiceMessageSet() {
        boolean var61880FEBF4D8063F5585CFF83B6C1D47_1531922566 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142937899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142937899;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.082 -0400", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "517A0BF86AD6A0D7F41B4D69F333346C")
    public boolean isCphsVoiceMessageClear() {
        boolean var734188D61E85191EE9574E91D393DEB6_1297616384 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111279416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_111279416;
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.083 -0400", hash_original_field = "FE0C689D40893F8D8408B0C3C164717C", hash_generated_field = "BFBFD01C8D1616FDD55A32C54E42801F")

    static int OFFSET_ADDRESS_LENGTH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.083 -0400", hash_original_field = "D51390E83923F00957E2D1C0C4CB59F9", hash_generated_field = "FC0ED2D77E428AB9A5199BA0DCD7F4FC")

    static int OFFSET_TOA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.083 -0400", hash_original_field = "D5730F45AA393C85136C068E8D1F3B94", hash_generated_field = "72E2F1961907439BF63BA279D68B040F")

    static int OFFSET_ADDRESS_VALUE = 2;
}

