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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.138 -0400", hash_original_method = "A0B07CD6AB37B7B30863E7D1CAF36981", hash_generated_method = "F557C92EADB79D8797DB172B46F9CC83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GsmSmsAddress(byte[] data, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
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
            boolean var8AA5DB479CE3C3E465759EDBACB469BD_969993803 = (isAlphanumeric());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.139 -0400", hash_original_method = "EAD8B5BB0DBAF5034E5C9FE6C7B0909A", hash_generated_method = "B5EDFF72FFAD56D4F84712449E3063E9")
    @DSModeled(DSC.SAFE)
    public String getAddressString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.139 -0400", hash_original_method = "364284D6387231DFE8BEB00860E244AE", hash_generated_method = "CEDE5334FB33C91BAB0D9C952428ADAD")
    @DSModeled(DSC.SAFE)
    public boolean isAlphanumeric() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ton == TON_ALPHANUMERIC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.139 -0400", hash_original_method = "9A297062C2D2EDFA0EA27742D0F1F520", hash_generated_method = "BA85489B178F5808CF835EC96833DBFC")
    @DSModeled(DSC.SAFE)
    public boolean isNetworkSpecific() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ton == TON_NETWORK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.140 -0400", hash_original_method = "7BECB9552858FA87C7AFE2E5228279B4", hash_generated_method = "418900BEF88E712FB94A6829DB127B65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean varDC3103C9C0B3609F4E175B06DFB54BDD_874450548 = ((origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                && isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (origBytes[OFFSET_ADDRESS_LENGTH] & 0xff) == 4
                //&& isAlphanumeric() && (origBytes[OFFSET_TOA] & 0x0f) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.140 -0400", hash_original_method = "4D79B8C2A51115F6F438822C99644146", hash_generated_method = "8D3B3FC7059CB00C312D90D92C1301E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCphsVoiceMessageSet() {
        boolean var61880FEBF4D8063F5585CFF83B6C1D47_1226201065 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x11;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.140 -0400", hash_original_method = "4C77C20AE3A5F3CC1A1FB56D13643756", hash_generated_method = "35C88C2F83807B4C92DF825E2D3118CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCphsVoiceMessageClear() {
        boolean var734188D61E85191EE9574E91D393DEB6_840519112 = (isCphsVoiceMessageIndicatorAddress()
                && (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isCphsVoiceMessageIndicatorAddress()
                //&& (origBytes[OFFSET_ADDRESS_VALUE] & 0xff) == 0x10;
    }

    
    static final int OFFSET_ADDRESS_LENGTH = 0;
    static final int OFFSET_TOA = 1;
    static final int OFFSET_ADDRESS_VALUE = 2;
}

