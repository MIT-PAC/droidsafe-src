package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static com.android.internal.telephony.RILConstants.*;
import android.os.Parcel;

public final class CdmaInformationRecords {
    public Object record;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.476 -0400", hash_original_method = "71E05E964ADC392142B0BD4E6150C714", hash_generated_method = "C772D5324FFFDA509BA39762760465E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CdmaInformationRecords(Parcel p) {
        dsTaint.addTaint(p.dsTaint);
        int id;
        id = p.readInt();
        //Begin case RIL_CDMA_DISPLAY_INFO_REC RIL_CDMA_EXTENDED_DISPLAY_INFO_REC 
        record  = new CdmaDisplayInfoRec(id, p.readString());
        //End case RIL_CDMA_DISPLAY_INFO_REC RIL_CDMA_EXTENDED_DISPLAY_INFO_REC 
        //Begin case RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC RIL_CDMA_CONNECTED_NUMBER_INFO_REC 
        record = new CdmaNumberInfoRec(id, p.readString(), p.readInt(), p.readInt(),
                        p.readInt(), p.readInt());
        //End case RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC RIL_CDMA_CONNECTED_NUMBER_INFO_REC 
        //Begin case RIL_CDMA_SIGNAL_INFO_REC 
        record = new CdmaSignalInfoRec(p.readInt(), p.readInt(), p.readInt(), p.readInt());
        //End case RIL_CDMA_SIGNAL_INFO_REC 
        //Begin case RIL_CDMA_REDIRECTING_NUMBER_INFO_REC 
        record = new CdmaRedirectingNumberInfoRec(p.readString(), p.readInt(), p.readInt(),
                        p.readInt(), p.readInt(), p.readInt());
        //End case RIL_CDMA_REDIRECTING_NUMBER_INFO_REC 
        //Begin case RIL_CDMA_LINE_CONTROL_INFO_REC 
        record = new CdmaLineControlInfoRec(p.readInt(), p.readInt(), p.readInt(),
                        p.readInt());
        //End case RIL_CDMA_LINE_CONTROL_INFO_REC 
        //Begin case RIL_CDMA_T53_CLIR_INFO_REC 
        record = new CdmaT53ClirInfoRec(p.readInt());
        //End case RIL_CDMA_T53_CLIR_INFO_REC 
        //Begin case RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC 
        record = new CdmaT53AudioControlInfoRec(p.readInt(), p.readInt());
        //End case RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC 
        //Begin case RIL_CDMA_T53_RELEASE_INFO_REC default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("RIL_UNSOL_CDMA_INFO_REC: unsupported record. Got "
                                            + CdmaInformationRecords.idToString(id) + " ");
        //End case RIL_CDMA_T53_RELEASE_INFO_REC default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static String idToString(int id) {
        switch(id) {
        case RIL_CDMA_DISPLAY_INFO_REC: return "RIL_CDMA_DISPLAY_INFO_REC";
        case RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC: return "RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC";
        case RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC: return "RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC";
        case RIL_CDMA_CONNECTED_NUMBER_INFO_REC: return "RIL_CDMA_CONNECTED_NUMBER_INFO_REC";
        case RIL_CDMA_SIGNAL_INFO_REC: return "RIL_CDMA_SIGNAL_INFO_REC";
        case RIL_CDMA_REDIRECTING_NUMBER_INFO_REC: return "RIL_CDMA_REDIRECTING_NUMBER_INFO_REC";
        case RIL_CDMA_LINE_CONTROL_INFO_REC: return "RIL_CDMA_LINE_CONTROL_INFO_REC";
        case RIL_CDMA_EXTENDED_DISPLAY_INFO_REC: return "RIL_CDMA_EXTENDED_DISPLAY_INFO_REC";
        case RIL_CDMA_T53_CLIR_INFO_REC: return "RIL_CDMA_T53_CLIR_INFO_REC";
        case RIL_CDMA_T53_RELEASE_INFO_REC: return "RIL_CDMA_T53_RELEASE_INFO_REC";
        case RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC: return "RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC";
        default: return "<unknown record>";
        }
    }

    
    public static class CdmaSignalInfoRec {
        public boolean isPresent;
        public int signalType;
        public int alertPitch;
        public int signal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.478 -0400", hash_original_method = "65C1B1FAB01F8320C332C9AE75D3022E", hash_generated_method = "46E0D37F3F57B4E83750C7DDAE4663DA")
        @DSModeled(DSC.SAFE)
        public CdmaSignalInfoRec() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.479 -0400", hash_original_method = "086C7141CE5438F46B273808409370D3", hash_generated_method = "F25823E7487DE28FBED78282785E76C9")
        @DSModeled(DSC.SAFE)
        public CdmaSignalInfoRec(int isPresent, int signalType, int alertPitch, int signal) {
            dsTaint.addTaint(alertPitch);
            dsTaint.addTaint(signal);
            dsTaint.addTaint(signalType);
            dsTaint.addTaint(isPresent);
            this.isPresent = isPresent != 0;
            // ---------- Original Method ----------
            //this.isPresent = isPresent != 0;
            //this.signalType = signalType;
            //this.alertPitch = alertPitch;
            //this.signal = signal;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.479 -0400", hash_original_method = "7B06985E180C621ECAFE7B9C193EA068", hash_generated_method = "8CD7A844E70A454AA50181E1CBC1484A")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaSignalInfo: {" +
                    //" isPresent: " + isPresent +
                    //", signalType: " + signalType +
                    //", alertPitch: " + alertPitch +
                    //", signal: " + signal +
                    //" }";
        }

        
    }


    
    public static class CdmaDisplayInfoRec {
        public int id;
        public String alpha;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.479 -0400", hash_original_method = "57D8FEC1FF8A1AEABF24ABAE12007FFA", hash_generated_method = "34E64B2DC3D3A4C3A73FE14E43401681")
        @DSModeled(DSC.SAFE)
        public CdmaDisplayInfoRec(int id, String alpha) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(alpha);
            // ---------- Original Method ----------
            //this.id = id;
            //this.alpha = alpha;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.480 -0400", hash_original_method = "CF7F6486CAA3B052EADF0380EBB958B2", hash_generated_method = "64E4664B663C2E749A501B008FEC9E55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var91E2CD098EACAB654FE48435C303240B_1096392764 = ("CdmaDisplayInfoRec: {" +
                    " id: " + CdmaInformationRecords.idToString(id) +
                    ", alpha: " + alpha +
                    " }");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaDisplayInfoRec: {" +
                    //" id: " + CdmaInformationRecords.idToString(id) +
                    //", alpha: " + alpha +
                    //" }";
        }

        
    }


    
    public static class CdmaNumberInfoRec {
        public int id;
        public String number;
        public byte numberType;
        public byte numberPlan;
        public byte pi;
        public byte si;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.480 -0400", hash_original_method = "30901569B1879A594122A889E080532A", hash_generated_method = "2F87CD43D952CFFEDBE01751A1E5E47A")
        @DSModeled(DSC.SAFE)
        public CdmaNumberInfoRec(int id, String number, int numberType, int numberPlan, int pi,
                int si) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(number);
            dsTaint.addTaint(pi);
            dsTaint.addTaint(numberPlan);
            dsTaint.addTaint(si);
            dsTaint.addTaint(numberType);
            this.numberType = (byte)numberType;
            this.numberPlan = (byte)numberPlan;
            this.pi = (byte)pi;
            this.si = (byte)si;
            // ---------- Original Method ----------
            //this.number = number;
            //this.numberType = (byte)numberType;
            //this.numberPlan = (byte)numberPlan;
            //this.pi = (byte)pi;
            //this.si = (byte)si;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.480 -0400", hash_original_method = "AA45E08965936A74DE899E6F859B6FCB", hash_generated_method = "EA4AFFB4F30EE0CF2979649A907C67D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7F8B009B42E18F250273B1E3891F512D_1832306979 = ("CdmaNumberInfoRec: {" +
                    " id: " + CdmaInformationRecords.idToString(id) +
                    ", number: " + number +
                    ", numberType: " + numberType +
                    ", numberPlan: " + numberPlan +
                    ", pi: " + pi +
                    ", si: " + si +
                    " }");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaNumberInfoRec: {" +
                    //" id: " + CdmaInformationRecords.idToString(id) +
                    //", number: " + number +
                    //", numberType: " + numberType +
                    //", numberPlan: " + numberPlan +
                    //", pi: " + pi +
                    //", si: " + si +
                    //" }";
        }

        
    }


    
    public static class CdmaRedirectingNumberInfoRec {
        public CdmaNumberInfoRec numberInfoRec;
        public int redirectingReason;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.480 -0400", hash_original_method = "7CFE91613E5CCC29F21B49D48FA73AF0", hash_generated_method = "2E1A21FC93FF11498717D072B49D9CF7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CdmaRedirectingNumberInfoRec(String number, int numberType, int numberPlan,
                int pi, int si, int reason) {
            dsTaint.addTaint(reason);
            dsTaint.addTaint(number);
            dsTaint.addTaint(pi);
            dsTaint.addTaint(numberPlan);
            dsTaint.addTaint(si);
            dsTaint.addTaint(numberType);
            numberInfoRec = new CdmaNumberInfoRec(RIL_CDMA_REDIRECTING_NUMBER_INFO_REC,
                                                  number, numberType, numberPlan, pi, si);
            // ---------- Original Method ----------
            //numberInfoRec = new CdmaNumberInfoRec(RIL_CDMA_REDIRECTING_NUMBER_INFO_REC,
                                                  //number, numberType, numberPlan, pi, si);
            //redirectingReason = reason;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.481 -0400", hash_original_method = "D87DB983AB005EF9C7C06219E3B89A0C", hash_generated_method = "32264F3F0D41B435FFE8E3806FFDAB45")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaNumberInfoRec: {" +
                    //" numberInfoRec: " + numberInfoRec +
                    //", redirectingReason: " + redirectingReason +
                    //" }";
        }

        
        public static final int REASON_UNKNOWN = 0;
        public static final int REASON_CALL_FORWARDING_BUSY = 1;
        public static final int REASON_CALL_FORWARDING_NO_REPLY = 2;
        public static final int REASON_CALLED_DTE_OUT_OF_ORDER = 9;
        public static final int REASON_CALL_FORWARDING_BY_THE_CALLED_DTE = 10;
        public static final int REASON_CALL_FORWARDING_UNCONDITIONAL = 15;
    }


    
    public static class CdmaLineControlInfoRec {
        public byte lineCtrlPolarityIncluded;
        public byte lineCtrlToggle;
        public byte lineCtrlReverse;
        public byte lineCtrlPowerDenial;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.481 -0400", hash_original_method = "CD5D73B58C4B4B187F005CD1226E94E1", hash_generated_method = "8AC2720344C700AB56094627639C9483")
        @DSModeled(DSC.SAFE)
        public CdmaLineControlInfoRec(int lineCtrlPolarityIncluded, int lineCtrlToggle,
                int lineCtrlReverse, int lineCtrlPowerDenial) {
            dsTaint.addTaint(lineCtrlReverse);
            dsTaint.addTaint(lineCtrlToggle);
            dsTaint.addTaint(lineCtrlPowerDenial);
            dsTaint.addTaint(lineCtrlPolarityIncluded);
            this.lineCtrlPolarityIncluded = (byte)lineCtrlPolarityIncluded;
            this.lineCtrlToggle = (byte)lineCtrlToggle;
            this.lineCtrlReverse = (byte)lineCtrlReverse;
            this.lineCtrlPowerDenial = (byte)lineCtrlPowerDenial;
            // ---------- Original Method ----------
            //this.lineCtrlPolarityIncluded = (byte)lineCtrlPolarityIncluded;
            //this.lineCtrlToggle = (byte)lineCtrlToggle;
            //this.lineCtrlReverse = (byte)lineCtrlReverse;
            //this.lineCtrlPowerDenial = (byte)lineCtrlPowerDenial;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.481 -0400", hash_original_method = "31B594EC48675C621293EE1C64F7F9A1", hash_generated_method = "D0CED30CF315BD86B2DACA87566514BD")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaLineControlInfoRec: {" +
                    //" lineCtrlPolarityIncluded: " + lineCtrlPolarityIncluded +
                    //" lineCtrlToggle: " + lineCtrlToggle +
                    //" lineCtrlReverse: " + lineCtrlReverse +
                    //" lineCtrlPowerDenial: " + lineCtrlPowerDenial +
                    //" }";
        }

        
    }


    
    public static class CdmaT53ClirInfoRec {
        public byte cause;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.481 -0400", hash_original_method = "7027858F3A41904E7AAC3077331910E1", hash_generated_method = "01BD0E3876F0A05253F58CEB43D0A40F")
        @DSModeled(DSC.SAFE)
        public CdmaT53ClirInfoRec(int cause) {
            dsTaint.addTaint(cause);
            this.cause = (byte)cause;
            // ---------- Original Method ----------
            //this.cause = (byte)cause;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.481 -0400", hash_original_method = "74C570B6C9610C7A851D818E47741A96", hash_generated_method = "B5F3DBE99182F938C47C2E4DD29EB48D")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaT53ClirInfoRec: {" +
                    //" cause: " + cause +
                    //" }";
        }

        
    }


    
    public static class CdmaT53AudioControlInfoRec {
        public byte uplink;
        public byte downlink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.482 -0400", hash_original_method = "50F8C49F080380C1715EB0BA46949181", hash_generated_method = "2F9D3762C01AB9C8123ED0D55DDA7859")
        @DSModeled(DSC.SAFE)
        public CdmaT53AudioControlInfoRec(int uplink, int downlink) {
            dsTaint.addTaint(uplink);
            dsTaint.addTaint(downlink);
            this.uplink = (byte) uplink;
            this.downlink = (byte) downlink;
            // ---------- Original Method ----------
            //this.uplink = (byte) uplink;
            //this.downlink = (byte) downlink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.482 -0400", hash_original_method = "2D0051C7D271A045193565807D73F90A", hash_generated_method = "5620B6CCB931C97B0E7F12512D079D3B")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CdmaT53AudioControlInfoRec: {" +
                    //" uplink: " + uplink +
                    //" downlink: " + downlink +
                    //" }";
        }

        
    }


    
    public static final int RIL_CDMA_DISPLAY_INFO_REC = 0;
    public static final int RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC = 1;
    public static final int RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC = 2;
    public static final int RIL_CDMA_CONNECTED_NUMBER_INFO_REC = 3;
    public static final int RIL_CDMA_SIGNAL_INFO_REC = 4;
    public static final int RIL_CDMA_REDIRECTING_NUMBER_INFO_REC = 5;
    public static final int RIL_CDMA_LINE_CONTROL_INFO_REC = 6;
    public static final int RIL_CDMA_EXTENDED_DISPLAY_INFO_REC = 7;
    public static final int RIL_CDMA_T53_CLIR_INFO_REC = 8;
    public static final int RIL_CDMA_T53_RELEASE_INFO_REC = 9;
    public static final int RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC = 10;
}

