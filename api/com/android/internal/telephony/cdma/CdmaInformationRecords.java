package com.android.internal.telephony.cdma;

// Droidsafe Imports
import android.os.Parcel;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class CdmaInformationRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.645 -0400", hash_original_field = "DE17F0F24B49F8364187891F8550FFBB", hash_generated_field = "946952F9E0B02B6DCE06B7EC0F5CF726")

    public Object record;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.647 -0400", hash_original_method = "71E05E964ADC392142B0BD4E6150C714", hash_generated_method = "E6E81A6365CC351101526EEAF3CA8603")
    public  CdmaInformationRecords(Parcel p) {
        int id = p.readInt();
switch(id){
        case RIL_CDMA_DISPLAY_INFO_REC:
        case RIL_CDMA_EXTENDED_DISPLAY_INFO_REC:
        record  = new CdmaDisplayInfoRec(id, p.readString());
        break;
        case RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC:
        case RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC:
        case RIL_CDMA_CONNECTED_NUMBER_INFO_REC:
        record = new CdmaNumberInfoRec(id, p.readString(), p.readInt(), p.readInt(),
                        p.readInt(), p.readInt());
        break;
        case RIL_CDMA_SIGNAL_INFO_REC:
        record = new CdmaSignalInfoRec(p.readInt(), p.readInt(), p.readInt(), p.readInt());
        break;
        case RIL_CDMA_REDIRECTING_NUMBER_INFO_REC:
        record = new CdmaRedirectingNumberInfoRec(p.readString(), p.readInt(), p.readInt(),
                        p.readInt(), p.readInt(), p.readInt());
        break;
        case RIL_CDMA_LINE_CONTROL_INFO_REC:
        record = new CdmaLineControlInfoRec(p.readInt(), p.readInt(), p.readInt(),
                        p.readInt());
        break;
        case RIL_CDMA_T53_CLIR_INFO_REC:
        record = new CdmaT53ClirInfoRec(p.readInt());
        break;
        case RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC:
        record = new CdmaT53AudioControlInfoRec(p.readInt(), p.readInt());
        break;
        case RIL_CDMA_T53_RELEASE_INFO_REC:
        default:
        RuntimeException var0A4404A9A803DCC7E773970F78CDD850_1609269360 = new RuntimeException("RIL_UNSOL_CDMA_INFO_REC: unsupported record. Got "
                                            + CdmaInformationRecords.idToString(id) + " ");
        var0A4404A9A803DCC7E773970F78CDD850_1609269360.addTaint(taint);
        throw var0A4404A9A803DCC7E773970F78CDD850_1609269360;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.649 -0400", hash_original_field = "9B5E5A2DCDDD73BC362DB72D9FF0D915", hash_generated_field = "766EEFBCBBC32A8B09E311AB27FDF552")

        public boolean isPresent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.649 -0400", hash_original_field = "14A5734B93F10BF0E2238159D9B18160", hash_generated_field = "C3DBA856A516B712CA372B9887F75527")

        public int signalType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.649 -0400", hash_original_field = "EFBC0E530FEE35C4625A059700403C54", hash_generated_field = "644C4013AC325045134F2A1D3FE944BE")

        public int alertPitch;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.649 -0400", hash_original_field = "521345A9FB579F52117F27BE6E0673EE", hash_generated_field = "EA292986602D36792255D5DBC38A5C75")

        public int signal;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.649 -0400", hash_original_method = "65C1B1FAB01F8320C332C9AE75D3022E", hash_generated_method = "46E0D37F3F57B4E83750C7DDAE4663DA")
        public  CdmaSignalInfoRec() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.651 -0400", hash_original_method = "086C7141CE5438F46B273808409370D3", hash_generated_method = "5A3733FEE3EDECBA3F3B4D069806D900")
        public  CdmaSignalInfoRec(int isPresent, int signalType, int alertPitch, int signal) {
            this.isPresent = isPresent != 0;
            this.signalType = signalType;
            this.alertPitch = alertPitch;
            this.signal = signal;
            // ---------- Original Method ----------
            //this.isPresent = isPresent != 0;
            //this.signalType = signalType;
            //this.alertPitch = alertPitch;
            //this.signal = signal;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.652 -0400", hash_original_method = "7B06985E180C621ECAFE7B9C193EA068", hash_generated_method = "A9D2DEF81AD4A69180668F9572D900FB")
        @Override
        public String toString() {
String varF6116CCA8A1591B4E776780FC5B28B16_1179548820 =             "CdmaSignalInfo: {" +
                    " isPresent: " + isPresent +
                    ", signalType: " + signalType +
                    ", alertPitch: " + alertPitch +
                    ", signal: " + signal +
                    " }";
            varF6116CCA8A1591B4E776780FC5B28B16_1179548820.addTaint(taint);
            return varF6116CCA8A1591B4E776780FC5B28B16_1179548820;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.652 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.652 -0400", hash_original_field = "2C1743A391305FBF367DF8E4F069F9F9", hash_generated_field = "8B80A8499BEE1CECC8CC54BE2313A487")

        public String alpha;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.653 -0400", hash_original_method = "57D8FEC1FF8A1AEABF24ABAE12007FFA", hash_generated_method = "326F1BA753A5949E5766B1E813FC2BC2")
        public  CdmaDisplayInfoRec(int id, String alpha) {
            this.id = id;
            this.alpha = alpha;
            // ---------- Original Method ----------
            //this.id = id;
            //this.alpha = alpha;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.653 -0400", hash_original_method = "CF7F6486CAA3B052EADF0380EBB958B2", hash_generated_method = "75F250D5F6BDDEEEDE35761AF8FDF0DA")
        @Override
        public String toString() {
String var66540B1AE234D793CAEEAF96CB8FC5D5_1887449666 =             "CdmaDisplayInfoRec: {" +
                    " id: " + CdmaInformationRecords.idToString(id) +
                    ", alpha: " + alpha +
                    " }";
            var66540B1AE234D793CAEEAF96CB8FC5D5_1887449666.addTaint(taint);
            return var66540B1AE234D793CAEEAF96CB8FC5D5_1887449666;
            // ---------- Original Method ----------
            //return "CdmaDisplayInfoRec: {" +
                    //" id: " + CdmaInformationRecords.idToString(id) +
                    //", alpha: " + alpha +
                    //" }";
        }

        
    }


    
    public static class CdmaNumberInfoRec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.654 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.654 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

        public String number;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.654 -0400", hash_original_field = "C96EC7AE450E302C973C98A94F4C4F8E", hash_generated_field = "CB3EAF3D5F0A0A8019887D94BD69E2CF")

        public byte numberType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.654 -0400", hash_original_field = "38786F58063652B570260E8A16FE7DB3", hash_generated_field = "A686DB57205923FB5B2D36D67D5CBD81")

        public byte numberPlan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.654 -0400", hash_original_field = "72AB8AF56BDDAB33B269C5964B26620A", hash_generated_field = "7FC700614E6544C130C161B9A5C9632E")

        public byte pi;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.654 -0400", hash_original_field = "AC5585D98646D255299C359140537783", hash_generated_field = "C6891584B2AAB055A74385EF80945343")

        public byte si;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.656 -0400", hash_original_method = "30901569B1879A594122A889E080532A", hash_generated_method = "FCDDF888BAF79C7BB83F85BAFB9A06AF")
        public  CdmaNumberInfoRec(int id, String number, int numberType, int numberPlan, int pi,
                int si) {
            addTaint(id);
            this.number = number;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.657 -0400", hash_original_method = "AA45E08965936A74DE899E6F859B6FCB", hash_generated_method = "3F4BE1B9BBAA481DD0D497C0BE181D44")
        @Override
        public String toString() {
String var17B573EFFC9D62D8F334884A496125D8_1636563528 =             "CdmaNumberInfoRec: {" +
                    " id: " + CdmaInformationRecords.idToString(id) +
                    ", number: " + number +
                    ", numberType: " + numberType +
                    ", numberPlan: " + numberPlan +
                    ", pi: " + pi +
                    ", si: " + si +
                    " }";
            var17B573EFFC9D62D8F334884A496125D8_1636563528.addTaint(taint);
            return var17B573EFFC9D62D8F334884A496125D8_1636563528;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.657 -0400", hash_original_field = "25C3E1D6729C48E14B59D39DCC45B24F", hash_generated_field = "99633BDA8A94484B44D1C34D187B3B50")

        public CdmaNumberInfoRec numberInfoRec;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.658 -0400", hash_original_field = "05F3670D20A2214AADC366C668114D4C", hash_generated_field = "9FE98E978C471B60CAECFC7C3520403D")

        public int redirectingReason;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.659 -0400", hash_original_method = "7CFE91613E5CCC29F21B49D48FA73AF0", hash_generated_method = "C06E5A1E7A56909B077F555D8B6EF00E")
        public  CdmaRedirectingNumberInfoRec(String number, int numberType, int numberPlan,
                int pi, int si, int reason) {
            numberInfoRec = new CdmaNumberInfoRec(RIL_CDMA_REDIRECTING_NUMBER_INFO_REC,
                                                  number, numberType, numberPlan, pi, si);
            redirectingReason = reason;
            // ---------- Original Method ----------
            //numberInfoRec = new CdmaNumberInfoRec(RIL_CDMA_REDIRECTING_NUMBER_INFO_REC,
                                                  //number, numberType, numberPlan, pi, si);
            //redirectingReason = reason;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.659 -0400", hash_original_method = "D87DB983AB005EF9C7C06219E3B89A0C", hash_generated_method = "2A05C36F57936B161C562C950B9EC495")
        @Override
        public String toString() {
String varDB93CB209FBF5516784CF592BF288EC8_871259282 =             "CdmaNumberInfoRec: {" +
                    " numberInfoRec: " + numberInfoRec +
                    ", redirectingReason: " + redirectingReason +
                    " }";
            varDB93CB209FBF5516784CF592BF288EC8_871259282.addTaint(taint);
            return varDB93CB209FBF5516784CF592BF288EC8_871259282;
            // ---------- Original Method ----------
            //return "CdmaNumberInfoRec: {" +
                    //" numberInfoRec: " + numberInfoRec +
                    //", redirectingReason: " + redirectingReason +
                    //" }";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.659 -0400", hash_original_field = "594C5172577F9EDBDC1FE8A52ADB4B96", hash_generated_field = "277DB1ED9D8523A313B00F353F323926")

        public static final int REASON_UNKNOWN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "5D408F3F2AA6604DCAE5CB0CC5C23669", hash_generated_field = "BFECBF2F322B080474B18D52C3763171")

        public static final int REASON_CALL_FORWARDING_BUSY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "BD5B706C84F8C4FEF8395724F23B177B", hash_generated_field = "3A378579595DC0A8A2A183210D309EE2")

        public static final int REASON_CALL_FORWARDING_NO_REPLY = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "78CC9C801726DA24CAEE2B5EA9DCFF95", hash_generated_field = "F305C42B924390152DB31E2F978F6DE2")

        public static final int REASON_CALLED_DTE_OUT_OF_ORDER = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "679174943441F473DDE93ECA7B63B11C", hash_generated_field = "2B3D0D1CAAE1F9CAB91B5CE3508AE59F")

        public static final int REASON_CALL_FORWARDING_BY_THE_CALLED_DTE = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "3E0953717234646B3EF4D9E7181C6AF7", hash_generated_field = "50F39F32B6D0C02AD7AE5CD226E74F32")

        public static final int REASON_CALL_FORWARDING_UNCONDITIONAL = 15;
    }


    
    public static class CdmaLineControlInfoRec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "51F76510DB9AFD8B2B321B58B3DA8F1E", hash_generated_field = "AB56D4429F407E23BE97E22B04B26614")

        public byte lineCtrlPolarityIncluded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "49C1E86987D0F175B60BEE8B7207F008", hash_generated_field = "4A2666C41EAEED4AED61B59638861893")

        public byte lineCtrlToggle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "B558D62052F2AAA60339D50C4B00FD42", hash_generated_field = "CA6BFBA917641BED860E222D7FBB7EA9")

        public byte lineCtrlReverse;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.660 -0400", hash_original_field = "793A9472E554CF1AE3A60654CBBB2ADB", hash_generated_field = "5CC1C9B9C9C711F0F6DB72D7CBDA44CD")

        public byte lineCtrlPowerDenial;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.661 -0400", hash_original_method = "CD5D73B58C4B4B187F005CD1226E94E1", hash_generated_method = "CDCFD7FACCCF9C61B58EF258030C2710")
        public  CdmaLineControlInfoRec(int lineCtrlPolarityIncluded, int lineCtrlToggle,
                int lineCtrlReverse, int lineCtrlPowerDenial) {
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.662 -0400", hash_original_method = "31B594EC48675C621293EE1C64F7F9A1", hash_generated_method = "A7CF75EAE20DC29A45316B59B04D944C")
        @Override
        public String toString() {
String var77B1AD702290CF500DD6732098282B5C_1841983094 =             "CdmaLineControlInfoRec: {" +
                    " lineCtrlPolarityIncluded: " + lineCtrlPolarityIncluded +
                    " lineCtrlToggle: " + lineCtrlToggle +
                    " lineCtrlReverse: " + lineCtrlReverse +
                    " lineCtrlPowerDenial: " + lineCtrlPowerDenial +
                    " }";
            var77B1AD702290CF500DD6732098282B5C_1841983094.addTaint(taint);
            return var77B1AD702290CF500DD6732098282B5C_1841983094;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.662 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "5AFE3443E8650E50C762D52B5A87BAB6")

        public byte cause;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.663 -0400", hash_original_method = "7027858F3A41904E7AAC3077331910E1", hash_generated_method = "253A7471455B9175589BC749538D99AF")
        public  CdmaT53ClirInfoRec(int cause) {
            this.cause = (byte)cause;
            // ---------- Original Method ----------
            //this.cause = (byte)cause;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.663 -0400", hash_original_method = "74C570B6C9610C7A851D818E47741A96", hash_generated_method = "BEA415F4B88844FE5E8FE4385967D0C3")
        @Override
        public String toString() {
String var97773021324657564F331D4E382DBD0B_1443956746 =             "CdmaT53ClirInfoRec: {" +
                    " cause: " + cause +
                    " }";
            var97773021324657564F331D4E382DBD0B_1443956746.addTaint(taint);
            return var97773021324657564F331D4E382DBD0B_1443956746;
            // ---------- Original Method ----------
            //return "CdmaT53ClirInfoRec: {" +
                    //" cause: " + cause +
                    //" }";
        }

        
    }


    
    public static class CdmaT53AudioControlInfoRec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.663 -0400", hash_original_field = "FA09BE8AA44A4075CBF13A8A2319AFC9", hash_generated_field = "9F199F8EB7C7978BE968369E879DA5EF")

        public byte uplink;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.664 -0400", hash_original_field = "42B847BA9F4B93FFC70109444A79680C", hash_generated_field = "4A6E9F7B5738F6C5F1F886C571587FA7")

        public byte downlink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.665 -0400", hash_original_method = "50F8C49F080380C1715EB0BA46949181", hash_generated_method = "E9EA2FB2EFC618036683820BD1761210")
        public  CdmaT53AudioControlInfoRec(int uplink, int downlink) {
            this.uplink = (byte) uplink;
            this.downlink = (byte) downlink;
            // ---------- Original Method ----------
            //this.uplink = (byte) uplink;
            //this.downlink = (byte) downlink;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.665 -0400", hash_original_method = "2D0051C7D271A045193565807D73F90A", hash_generated_method = "B41550FD561921E39E6863943363C559")
        @Override
        public String toString() {
String varD6C878C7151F84AFF9846608E098DD88_1244777587 =             "CdmaT53AudioControlInfoRec: {" +
                    " uplink: " + uplink +
                    " downlink: " + downlink +
                    " }";
            varD6C878C7151F84AFF9846608E098DD88_1244777587.addTaint(taint);
            return varD6C878C7151F84AFF9846608E098DD88_1244777587;
            // ---------- Original Method ----------
            //return "CdmaT53AudioControlInfoRec: {" +
                    //" uplink: " + uplink +
                    //" downlink: " + downlink +
                    //" }";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.665 -0400", hash_original_field = "9548D9C8E9EF68C79D95A3BD185A3C3A", hash_generated_field = "D58CC7EE04EC01B8C2610AF2C51563EA")

    public static final int RIL_CDMA_DISPLAY_INFO_REC = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "CF98E5D475234111DDEFF10C2D4203FD", hash_generated_field = "77CF7299DA136D5486F92438975FB303")

    public static final int RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "55B9143D5FEF5E248DDAD851DB21D6D5", hash_generated_field = "6A383AB2E2A2D5C8791774FF4E731FCA")

    public static final int RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "E3E0EB3901E4E2E512DA012DA5D1A978", hash_generated_field = "5304006DFD5A984FD958B01E360D4BEB")

    public static final int RIL_CDMA_CONNECTED_NUMBER_INFO_REC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "AEE6BED4D02E5A3CD67A153CD4F122F6", hash_generated_field = "FE3402021EBBE593405377DF31763AA9")

    public static final int RIL_CDMA_SIGNAL_INFO_REC = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "12876CC1ECD3F2474845B26FC410940C", hash_generated_field = "EA81C11EFDCA8CA107CEC699BDEB2F68")

    public static final int RIL_CDMA_REDIRECTING_NUMBER_INFO_REC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "A8066B2FB943E6C78A9C958191AD477A", hash_generated_field = "FF8AB1FAC5CAADCA6EC088533EB9E2FB")

    public static final int RIL_CDMA_LINE_CONTROL_INFO_REC = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "D96E08C83037C20359A97FC2B9841F38", hash_generated_field = "0909FC4977E8F961F49349A83270C779")

    public static final int RIL_CDMA_EXTENDED_DISPLAY_INFO_REC = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "B6B2A367A0DDB82F535CCF9DB4756281", hash_generated_field = "07BE9745C82BF289CF0AD44776115D67")

    public static final int RIL_CDMA_T53_CLIR_INFO_REC = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "A1507DACB83FAE887315D44F364E3B76", hash_generated_field = "12BE36023C341FCE2FA754564FF325D3")

    public static final int RIL_CDMA_T53_RELEASE_INFO_REC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.666 -0400", hash_original_field = "91CE6AA483A4E470FBE26831AB6A17D6", hash_generated_field = "D8136FAFE78425A58150838DEE3E42DE")

    public static final int RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC = 10;
}

