/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;

public final class CdmaInformationRecords {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.946 -0500", hash_original_method = "363E4156AB88CDD83A91DE74603E128C", hash_generated_method = "8DA8FEC259A14D77E7FD5FE1B1750291")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.915 -0500", hash_original_field = "28EFE18BD2095A0806EB255973DB3AC1", hash_generated_field = "D58CC7EE04EC01B8C2610AF2C51563EA")

    public static final int RIL_CDMA_DISPLAY_INFO_REC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.917 -0500", hash_original_field = "983F5AB58F39B7278574F3C217433452", hash_generated_field = "77CF7299DA136D5486F92438975FB303")

    public static final int RIL_CDMA_CALLED_PARTY_NUMBER_INFO_REC = 1;
    
    public static class CdmaSignalInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.950 -0500", hash_original_field = "3321AC69DCE73708970F1C1826BE015F", hash_generated_field = "766EEFBCBBC32A8B09E311AB27FDF552")

        public boolean isPresent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.952 -0500", hash_original_field = "A7F8333C04D4B78D9A25D4EEA7C47571", hash_generated_field = "C3DBA856A516B712CA372B9887F75527")

        public int signalType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.954 -0500", hash_original_field = "B5FD2F7A32A62542FB2D4084C94A28CB", hash_generated_field = "644C4013AC325045134F2A1D3FE944BE")

        public int alertPitch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.957 -0500", hash_original_field = "DAA2F29379835141E933977E23497056", hash_generated_field = "EA292986602D36792255D5DBC38A5C75")

        public int signal;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.959 -0500", hash_original_method = "65C1B1FAB01F8320C332C9AE75D3022E", hash_generated_method = "99F202DFC34ECCBCEA7364DF4F361D84")
        
public CdmaSignalInfoRec() {}

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.962 -0500", hash_original_method = "086C7141CE5438F46B273808409370D3", hash_generated_method = "875AC605C985995FB673FDC2845F75EC")
        
public CdmaSignalInfoRec(int isPresent, int signalType, int alertPitch, int signal) {
            this.isPresent = isPresent != 0;
            this.signalType = signalType;
            this.alertPitch = alertPitch;
            this.signal = signal;
        }

        @DSSource({DSSourceKind.NETWORK})
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.966 -0500", hash_original_method = "7B06985E180C621ECAFE7B9C193EA068", hash_generated_method = "5C339CA1E8F0EBB79F84F1AB79639F79")
        
@Override
        public String toString() {
            return "CdmaSignalInfo: {" +
                    " isPresent: " + isPresent +
                    ", signalType: " + signalType +
                    ", alertPitch: " + alertPitch +
                    ", signal: " + signal +
                    " }";
        }
        
    }
    
    public static class CdmaDisplayInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.970 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.972 -0500", hash_original_field = "603429B364809DE7480ED2BD5BA1DDD6", hash_generated_field = "8B80A8499BEE1CECC8CC54BE2313A487")

        public String alpha;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.975 -0500", hash_original_method = "57D8FEC1FF8A1AEABF24ABAE12007FFA", hash_generated_method = "C405E532BB1DBF76B4AC0A00EE6F434C")
        
public CdmaDisplayInfoRec(int id, String alpha) {
            this.id = id;
            this.alpha = alpha;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.978 -0500", hash_original_method = "CF7F6486CAA3B052EADF0380EBB958B2", hash_generated_method = "451189ED53A4E395D93D554D05A436D1")
        
@Override
        public String toString() {
            return "CdmaDisplayInfoRec: {" +
                    " id: " + CdmaInformationRecords.idToString(id) +
                    ", alpha: " + alpha +
                    " }";
        }
        
    }
    
    public static class CdmaNumberInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.982 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.984 -0500", hash_original_field = "F0C1D0D479817313A0A5D4AB9BD9FA68", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

        public String number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.986 -0500", hash_original_field = "A73B3F85C357113527B6D4C78650976E", hash_generated_field = "CB3EAF3D5F0A0A8019887D94BD69E2CF")

        public byte numberType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.988 -0500", hash_original_field = "A4CC1D734F04864B678EFA85BA17673B", hash_generated_field = "A686DB57205923FB5B2D36D67D5CBD81")

        public byte numberPlan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.992 -0500", hash_original_field = "872313780CF83E217811B1E8CB1F81B0", hash_generated_field = "7FC700614E6544C130C161B9A5C9632E")

        public byte pi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.995 -0500", hash_original_field = "B82FEEFEF310437905B1E581950C8CA1", hash_generated_field = "C6891584B2AAB055A74385EF80945343")

        public byte si;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.997 -0500", hash_original_method = "30901569B1879A594122A889E080532A", hash_generated_method = "C09B0E24DCACE1819AD01CA1F869BE9D")
        
public CdmaNumberInfoRec(int id, String number, int numberType, int numberPlan, int pi,
                int si) {
            this.number = number;
            this.numberType = (byte)numberType;
            this.numberPlan = (byte)numberPlan;
            this.pi = (byte)pi;
            this.si = (byte)si;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.000 -0500", hash_original_method = "AA45E08965936A74DE899E6F859B6FCB", hash_generated_method = "5E4393BA0A95D6EF08F9C4EE1F671FD7")
        
@Override
        public String toString() {
            return "CdmaNumberInfoRec: {" +
                    " id: " + CdmaInformationRecords.idToString(id) +
                    ", number: " + number +
                    ", numberType: " + numberType +
                    ", numberPlan: " + numberPlan +
                    ", pi: " + pi +
                    ", si: " + si +
                    " }";
        }
        
    }
    
    public static class CdmaRedirectingNumberInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.005 -0500", hash_original_field = "467703D37CFFFBC2FB1AC9EE489F4A33", hash_generated_field = "277DB1ED9D8523A313B00F353F323926")

        public static final int REASON_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.008 -0500", hash_original_field = "149EBC5B64D5818EF968D5CE5B3E83FD", hash_generated_field = "BFECBF2F322B080474B18D52C3763171")

        public static final int REASON_CALL_FORWARDING_BUSY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.011 -0500", hash_original_field = "49C1404D204690C91169F6E995808F9B", hash_generated_field = "3A378579595DC0A8A2A183210D309EE2")

        public static final int REASON_CALL_FORWARDING_NO_REPLY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.013 -0500", hash_original_field = "FD18B013A9762973B70CC19CEA5F61AD", hash_generated_field = "F305C42B924390152DB31E2F978F6DE2")

        public static final int REASON_CALLED_DTE_OUT_OF_ORDER = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.016 -0500", hash_original_field = "916727AF8526D9CA894D8E18BF12FA53", hash_generated_field = "2B3D0D1CAAE1F9CAB91B5CE3508AE59F")

        public static final int REASON_CALL_FORWARDING_BY_THE_CALLED_DTE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.019 -0500", hash_original_field = "98814081328D6E511FD1DFAB83D43866", hash_generated_field = "50F39F32B6D0C02AD7AE5CD226E74F32")

        public static final int REASON_CALL_FORWARDING_UNCONDITIONAL = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.021 -0500", hash_original_field = "0E45AF5C5FE766E622184F54082550C1", hash_generated_field = "99633BDA8A94484B44D1C34D187B3B50")

        public CdmaNumberInfoRec numberInfoRec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.024 -0500", hash_original_field = "CA7ED3323C32B3B1A05349A72DBEDD7E", hash_generated_field = "9FE98E978C471B60CAECFC7C3520403D")

        public int redirectingReason;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.026 -0500", hash_original_method = "7CFE91613E5CCC29F21B49D48FA73AF0", hash_generated_method = "42EBB22D8D1B1C93C76FF272F7940505")
        
public CdmaRedirectingNumberInfoRec(String number, int numberType, int numberPlan,
                int pi, int si, int reason) {
            numberInfoRec = new CdmaNumberInfoRec(RIL_CDMA_REDIRECTING_NUMBER_INFO_REC,
                                                  number, numberType, numberPlan, pi, si);
            redirectingReason = reason;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.029 -0500", hash_original_method = "D87DB983AB005EF9C7C06219E3B89A0C", hash_generated_method = "67D5BAAA3DCBBB45937C4AFCEE8BAB4D")
        
@Override
        public String toString() {
            return "CdmaNumberInfoRec: {" +
                    " numberInfoRec: " + numberInfoRec +
                    ", redirectingReason: " + redirectingReason +
                    " }";
        }
    }
    
    public static class CdmaLineControlInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.033 -0500", hash_original_field = "4ADA3AB0EBE2F18AEA7A9AAC49C88223", hash_generated_field = "AB56D4429F407E23BE97E22B04B26614")

        public byte lineCtrlPolarityIncluded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.036 -0500", hash_original_field = "1DB8690EA3ED556E35B0E3AD2A3D61B6", hash_generated_field = "4A2666C41EAEED4AED61B59638861893")

        public byte lineCtrlToggle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.039 -0500", hash_original_field = "D77FF70DA050E7EBE975815DFCA38D78", hash_generated_field = "CA6BFBA917641BED860E222D7FBB7EA9")

        public byte lineCtrlReverse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.041 -0500", hash_original_field = "9008BA9379A75A786ABB5B9D35BA4BA8", hash_generated_field = "5CC1C9B9C9C711F0F6DB72D7CBDA44CD")

        public byte lineCtrlPowerDenial;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.044 -0500", hash_original_method = "CD5D73B58C4B4B187F005CD1226E94E1", hash_generated_method = "050F3086C6609D92F70134E8F85F01C0")
        
public CdmaLineControlInfoRec(int lineCtrlPolarityIncluded, int lineCtrlToggle,
                int lineCtrlReverse, int lineCtrlPowerDenial) {
            this.lineCtrlPolarityIncluded = (byte)lineCtrlPolarityIncluded;
            this.lineCtrlToggle = (byte)lineCtrlToggle;
            this.lineCtrlReverse = (byte)lineCtrlReverse;
            this.lineCtrlPowerDenial = (byte)lineCtrlPowerDenial;
        }

        @DSSource({DSSourceKind.NETWORK})
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.047 -0500", hash_original_method = "31B594EC48675C621293EE1C64F7F9A1", hash_generated_method = "DA5C71EAC058B2D0333678E3B04881B5")
        
@Override
        public String toString() {
            return "CdmaLineControlInfoRec: {" +
                    " lineCtrlPolarityIncluded: " + lineCtrlPolarityIncluded +
                    " lineCtrlToggle: " + lineCtrlToggle +
                    " lineCtrlReverse: " + lineCtrlReverse +
                    " lineCtrlPowerDenial: " + lineCtrlPowerDenial +
                    " }";
        }
        
    }
    
    public static class CdmaT53ClirInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.051 -0500", hash_original_field = "2F2FD2B8046C188025549F8833026A30", hash_generated_field = "5AFE3443E8650E50C762D52B5A87BAB6")

        public byte cause;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.054 -0500", hash_original_method = "7027858F3A41904E7AAC3077331910E1", hash_generated_method = "A4A9C74B85677F170896968D2CFE553D")
        
public CdmaT53ClirInfoRec(int cause) {
            this.cause = (byte)cause;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.056 -0500", hash_original_method = "74C570B6C9610C7A851D818E47741A96", hash_generated_method = "EB2EFDB3C941DD4C7C940AFBD19CADEB")
        
@Override
        public String toString() {
            return "CdmaT53ClirInfoRec: {" +
                    " cause: " + cause +
                    " }";
        }
        
    }
    
    public static class CdmaT53AudioControlInfoRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.061 -0500", hash_original_field = "6269D71D744481E12C5B76B75B116882", hash_generated_field = "9F199F8EB7C7978BE968369E879DA5EF")

        public byte uplink;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.063 -0500", hash_original_field = "51DA3A4EB01CCCC43585DA3468B6D134", hash_generated_field = "4A6E9F7B5738F6C5F1F886C571587FA7")

        public byte downlink;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.066 -0500", hash_original_method = "50F8C49F080380C1715EB0BA46949181", hash_generated_method = "2537A97E7151CBF651447EE3B084FC84")
        
public CdmaT53AudioControlInfoRec(int uplink, int downlink) {
            this.uplink = (byte) uplink;
            this.downlink = (byte) downlink;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:00.068 -0500", hash_original_method = "2D0051C7D271A045193565807D73F90A", hash_generated_method = "3143D86DD5E33593B7ACD5FC8D7913F3")
        
@Override
        public String toString() {
            return "CdmaT53AudioControlInfoRec: {" +
                    " uplink: " + uplink +
                    " downlink: " + downlink +
                    " }";
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.920 -0500", hash_original_field = "160598A9D8F01D129A355F2D697E72B1", hash_generated_field = "6A383AB2E2A2D5C8791774FF4E731FCA")

    public static final int RIL_CDMA_CALLING_PARTY_NUMBER_INFO_REC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.922 -0500", hash_original_field = "6EACCFE74367A4DFC319AEFEAE5D3760", hash_generated_field = "5304006DFD5A984FD958B01E360D4BEB")

    public static final int RIL_CDMA_CONNECTED_NUMBER_INFO_REC = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.925 -0500", hash_original_field = "406D12DC3550A1D45DF56E8BFDDAB696", hash_generated_field = "FE3402021EBBE593405377DF31763AA9")

    public static final int RIL_CDMA_SIGNAL_INFO_REC = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.927 -0500", hash_original_field = "754275E98454EF62BEEE02EEBF3CF9A7", hash_generated_field = "EA81C11EFDCA8CA107CEC699BDEB2F68")

    public static final int RIL_CDMA_REDIRECTING_NUMBER_INFO_REC = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.930 -0500", hash_original_field = "D2D4F16C95964E4135AFD07019A67C45", hash_generated_field = "FF8AB1FAC5CAADCA6EC088533EB9E2FB")

    public static final int RIL_CDMA_LINE_CONTROL_INFO_REC = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.933 -0500", hash_original_field = "7B345965D6A0FF2B9FACA1E1738E8D6F", hash_generated_field = "0909FC4977E8F961F49349A83270C779")

    public static final int RIL_CDMA_EXTENDED_DISPLAY_INFO_REC = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.935 -0500", hash_original_field = "71145A8BA96F80E03B4B066594CA69C8", hash_generated_field = "07BE9745C82BF289CF0AD44776115D67")

    public static final int RIL_CDMA_T53_CLIR_INFO_REC = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.937 -0500", hash_original_field = "8F47490BA2417108147EC8A4330BA22D", hash_generated_field = "12BE36023C341FCE2FA754564FF325D3")

    public static final int RIL_CDMA_T53_RELEASE_INFO_REC = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.940 -0500", hash_original_field = "7B56893A3502DC8F3EAD336876781DCE", hash_generated_field = "D8136FAFE78425A58150838DEE3E42DE")

    public static final int RIL_CDMA_T53_AUDIO_CONTROL_INFO_REC = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.912 -0500", hash_original_field = "869F64B8C7031583B62C007DF0EAF28E", hash_generated_field = "946952F9E0B02B6DCE06B7EC0F5CF726")

    public Object record;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.943 -0500", hash_original_method = "71E05E964ADC392142B0BD4E6150C714", hash_generated_method = "782FD9AF37B1BF0E31E3253BBE602ECC")
    
public CdmaInformationRecords(Parcel p) {
        int id = p.readInt();
        switch (id) {
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
                // TODO: WHAT to do, for now fall through and throw exception
            default:
                throw new RuntimeException("RIL_UNSOL_CDMA_INFO_REC: unsupported record. Got "
                                            + CdmaInformationRecords.idToString(id) + " ");

        }
    }
}

