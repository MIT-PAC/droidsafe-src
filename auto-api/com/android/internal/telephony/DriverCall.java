package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.lang.Comparable;
import android.telephony.PhoneNumberUtils;

public class DriverCall implements Comparable {
    public int index;
    public boolean isMT;
    public State state;
    public boolean isMpty;
    public String number;
    public int TOA;
    public boolean isVoice;
    public boolean isVoicePrivacy;
    public int als;
    public int numberPresentation;
    public String name;
    public int namePresentation;
    public UUSInfo uusInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.133 -0400", hash_original_method = "DF91F81E80FDB939BBEABFE9635EC975", hash_generated_method = "A0F6DD97DA81B4F7A55DEAA088C14728")
    @DSModeled(DSC.SAFE)
    public DriverCall() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.133 -0400", hash_original_method = "7AA84AC8F947102F8EF05D3C97C1753D", hash_generated_method = "5EEA65D9ED34EDC7A034781F199AB469")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.134 -0400", hash_original_method = "7A57313C9AA4F0F08ECFF99E7B6FC0B1", hash_generated_method = "EEC29E14CD0F32A30AA128D62D610515")
    @DSModeled(DSC.SAFE)
    public int compareTo(Object o) {
        dsTaint.addTaint(o.dsTaint);
        DriverCall dc;
        dc = (DriverCall)o;
        return dsTaint.getTaintInt();
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

    
    static final String LOG_TAG = "RILB";
}

