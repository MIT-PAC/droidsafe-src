package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.lang.Comparable;
import android.telephony.PhoneNumberUtils;

public class DriverCall implements Comparable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "AE1343475DB0F2C28979E182E3B11BCC")

    public int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "29B792D576B1CEF92259AA1D29B9F3FD", hash_generated_field = "1A0B53EAA247DC6719F4EC7AD9624134")

    public boolean isMT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "B721BC48DDB182AF0928FEBCA7FA4E6F")

    public State state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "9F6A5BA9DC1BC6518D717E5056AA93BD", hash_generated_field = "5597A2BC6D4A0BF542E9B87403689D72")

    public boolean isMpty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

    public String number;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "39C3867BC992E67140BEC331F3007B98", hash_generated_field = "195906E00D55E129634D3DD1275757F6")

    public int TOA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "25A592F74F5BD1F7C3D19B4F2496237D", hash_generated_field = "8B156B469FEE8F94B916262DE52D2D33")

    public boolean isVoice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "F39DD7C66200B31D992F0757D45FB8C9", hash_generated_field = "97DCB49DD9336A67AD545FC983BB6020")

    public boolean isVoicePrivacy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "C3955CF318F60D815066DAA73A622297", hash_generated_field = "1646A9C49DEAD15E3295B8D01B9977F8")

    public int als;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "F00A6033EECCE0EBD17BDAAC2E6671A9", hash_generated_field = "6CB3D906347F781338EC2DA9AF9D3365")

    public int numberPresentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "2EA6554455FD669EC0582028CFF50FED", hash_generated_field = "7E759DEFD9070D930A5C3E6F52204FE3")

    public int namePresentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.708 -0400", hash_original_field = "B06E6373CFB44BD5F02CE42C64608D89", hash_generated_field = "AD0525E103DB38F174D56C60CB9BD86E")

    public UUSInfo uusInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.709 -0400", hash_original_method = "DF91F81E80FDB939BBEABFE9635EC975", hash_generated_method = "A0F6DD97DA81B4F7A55DEAA088C14728")
    public  DriverCall() {
        // ---------- Original Method ----------
    }

    
        static DriverCall fromCLCCLine(String line) {
        DriverCall ret = new DriverCall();
        ATResponseParser p = new ATResponseParser(line);
        try {
            ret.index = p.nextInt();
            ret.isMT = p.nextBoolean();
            ret.state = stateFromCLCC(p.nextInt());
            ret.isVoice = (0 == p.nextInt());
            ret.isMpty = p.nextBoolean();
            ret.numberPresentation = Connection.PRESENTATION_ALLOWED;
            if (p.hasMore()) {
                ret.number = PhoneNumberUtils.extractNetworkPortionAlt(p.nextString());
                if (ret.number.length() == 0) {
                    ret.number = null;
                }
                ret.TOA = p.nextInt();
                ret.number = PhoneNumberUtils.stringFromStringAndTOA(
                                ret.number, ret.TOA);
            }
        } catch (ATParseEx ex) {
            Log.e(LOG_TAG,"Invalid CLCC line: '" + line + "'");
            return null;
        }
        return ret;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.710 -0400", hash_original_method = "7AA84AC8F947102F8EF05D3C97C1753D", hash_generated_method = "26862FAF5417F2D35217E63421E200F6")
    public String toString() {
String var73E2365DCE80719343796B149C5DF735_2026198323 =         "id=" + index + ","
                + state + ","
                + "toa=" + TOA + ","
                + (isMpty ? "conf" : "norm") + ","
                + (isMT ? "mt" : "mo") + ","
                + als + ","
                + (isVoice ? "voc" : "nonvoc") + ","
                + (isVoicePrivacy ? "evp" : "noevp") + ","
                 + ",cli=" + numberPresentation + ","
                 + "," + namePresentation;
        var73E2365DCE80719343796B149C5DF735_2026198323.addTaint(taint);
        return var73E2365DCE80719343796B149C5DF735_2026198323;
        // ---------- Original Method ----------
        //return "id=" + index + ","
                //+ state + ","
                //+ "toa=" + TOA + ","
                //+ (isMpty ? "conf" : "norm") + ","
                //+ (isMT ? "mt" : "mo") + ","
                //+ als + ","
                //+ (isVoice ? "voc" : "nonvoc") + ","
                //+ (isVoicePrivacy ? "evp" : "noevp") + ","
                 //+ ",cli=" + numberPresentation + ","
                 //+ "," + namePresentation;
    }

    
        @DSModeled(DSC.BAN)
    public static State stateFromCLCC(int state) throws ATParseEx {
        switch(state) {
            case 0: return State.ACTIVE;
            case 1: return State.HOLDING;
            case 2: return State.DIALING;
            case 3: return State.ALERTING;
            case 4: return State.INCOMING;
            case 5: return State.WAITING;
            default:
                throw new ATParseEx("illegal call state " + state);
        }
    }

    
        @DSModeled(DSC.BAN)
    public static int presentationFromCLIP(int cli) throws ATParseEx {
        switch(cli) {
            case 0: return Connection.PRESENTATION_ALLOWED;
            case 1: return Connection.PRESENTATION_RESTRICTED;
            case 2: return Connection.PRESENTATION_UNKNOWN;
            case 3: return Connection.PRESENTATION_PAYPHONE;
            default:
                throw new ATParseEx("illegal presentation " + cli);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.711 -0400", hash_original_method = "7A57313C9AA4F0F08ECFF99E7B6FC0B1", hash_generated_method = "079678F34F08CF6B5C6BF4E4FB8D5233")
    public int compareTo(Object o) {
        addTaint(o.getTaint());
        DriverCall dc;
        dc = (DriverCall)o;
    if(index < dc.index)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1587830972 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959393180 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959393180;
        } //End block
        else
    if(index == dc.index)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1653476 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99158285 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99158285;
        } //End block
        else
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1849279687 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591522230 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1591522230;
        } //End block
        // ---------- Original Method ----------
        //DriverCall dc;
        //dc = (DriverCall)o;
        //if (index < dc.index) {
            //return -1;
        //} else if (index == dc.index) {
            //return 0;
        //} else { 
            //return 1;
        //}
    }

    
    public enum State {
        ACTIVE,
        HOLDING,
        DIALING,    
        ALERTING,   
        INCOMING,   
        WAITING;    
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.711 -0400", hash_original_field = "4DBD40250117FD6239DF36E7EBA17FD5", hash_generated_field = "DB7A35D86E816F9CDE58D28E944FC412")

    static final String LOG_TAG = "RILB";
}

