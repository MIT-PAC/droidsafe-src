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
 * Copyright (C) 2006 The Android Open Source Project
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


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.telephony.PhoneNumberUtils;
import android.util.Log;

public class DriverCall implements Comparable {

    /** returns null on error */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.062 -0500", hash_original_method = "FB47DF2BD8B60DCEADAB62594508D31A", hash_generated_method = "EC1E7FBAF6E2ADD28D11FCB3F1467F43")
    
static DriverCall
    fromCLCCLine(String line) {
        DriverCall ret = new DriverCall();

        //+CLCC: 1,0,2,0,0,\"+18005551212\",145
        //     index,isMT,state,mode,isMpty(,number,TOA)?
        ATResponseParser p = new ATResponseParser(line);

        try {
            ret.index = p.nextInt();
            ret.isMT = p.nextBoolean();
            ret.state = stateFromCLCC(p.nextInt());

            ret.isVoice = (0 == p.nextInt());
            ret.isMpty = p.nextBoolean();

            // use ALLOWED as default presentation while parsing CLCC
            ret.numberPresentation = Connection.PRESENTATION_ALLOWED;

            if (p.hasMore()) {
                // Some lame implementations return strings
                // like "NOT AVAILABLE" in the CLCC line
                ret.number = PhoneNumberUtils.extractNetworkPortionAlt(p.nextString());

                if (ret.number.length() == 0) {
                    ret.number = null;
                }

                ret.TOA = p.nextInt();

                // Make sure there's a leading + on addresses with a TOA
                // of 145

                ret.number = PhoneNumberUtils.stringFromStringAndTOA(
                                ret.number, ret.TOA);

            }
        } catch (ATParseEx ex) {
            Log.e(LOG_TAG,"Invalid CLCC line: '" + line + "'");
            return null;
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.070 -0500", hash_original_method = "C84AEB625FEE8BBEED4F43C5F9EA73A1", hash_generated_method = "CABBA7E8DB968B429178D6D6DB7CACD9")
    
public static State
    stateFromCLCC(int state) throws ATParseEx {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.072 -0500", hash_original_method = "C88E48E4C6B4766CB7B0CE61AA5B046B", hash_generated_method = "850AC8BA169C70E76AC186047AD3712A")
    
public static int
    presentationFromCLIP(int cli) throws ATParseEx
    {
        switch(cli) {
            case 0: return Connection.PRESENTATION_ALLOWED;
            case 1: return Connection.PRESENTATION_RESTRICTED;
            case 2: return Connection.PRESENTATION_UNKNOWN;
            case 3: return Connection.PRESENTATION_PAYPHONE;
            default:
                throw new ATParseEx("illegal presentation " + cli);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.027 -0500", hash_original_field = "C59531DE2B387E78A8D03FA621876C23", hash_generated_field = "DB7A35D86E816F9CDE58D28E944FC412")

    static final String LOG_TAG = "RILB";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.031 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "AE1343475DB0F2C28979E182E3B11BCC")

    public int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.034 -0500", hash_original_field = "D11CC60C9BF73D8A7B7D7E1236C8B280", hash_generated_field = "1A0B53EAA247DC6719F4EC7AD9624134")

    public boolean isMT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.036 -0500", hash_original_field = "05D925C5BEC5275A59607FB5FAF72E84", hash_generated_field = "B721BC48DDB182AF0928FEBCA7FA4E6F")

    public State state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.038 -0500", hash_original_field = "E47D5496C676F40E7046A485A8FFA12F", hash_generated_field = "5597A2BC6D4A0BF542E9B87403689D72")

    public boolean isMpty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.040 -0500", hash_original_field = "F0C1D0D479817313A0A5D4AB9BD9FA68", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

    public String number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.043 -0500", hash_original_field = "CA3A6D09CCB573156EFB8B50AA020CBC", hash_generated_field = "195906E00D55E129634D3DD1275757F6")

    public int TOA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.045 -0500", hash_original_field = "48620144D30B689E0309E4B21D81E098", hash_generated_field = "8B156B469FEE8F94B916262DE52D2D33")

    public boolean isVoice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.047 -0500", hash_original_field = "4496E6BD3FF6A60D63CE6C53F840D5B2", hash_generated_field = "97DCB49DD9336A67AD545FC983BB6020")

    public boolean isVoicePrivacy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.050 -0500", hash_original_field = "50D22184C6B9134B2FC9910D89E4BDC4", hash_generated_field = "1646A9C49DEAD15E3295B8D01B9977F8")

    public int als;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.052 -0500", hash_original_field = "091FFF931E0CD34BE4923BA987466B67", hash_generated_field = "6CB3D906347F781338EC2DA9AF9D3365")

    public int numberPresentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.054 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.056 -0500", hash_original_field = "721EAC59B6591E31E8992E203B2B56AC", hash_generated_field = "7E759DEFD9070D930A5C3E6F52204FE3")

    public int namePresentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.059 -0500", hash_original_field = "34C14CFE94A5D0F7C643E2D0DC23FCE9", hash_generated_field = "AD0525E103DB38F174D56C60CB9BD86E")

    public UUSInfo uusInfo;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.065 -0500", hash_original_method = "DF91F81E80FDB939BBEABFE9635EC975", hash_generated_method = "4D9CB9EAF629F81486ABF5AA58FF9D42")
    
public
    DriverCall() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.067 -0500", hash_original_method = "7AA84AC8F947102F8EF05D3C97C1753D", hash_generated_method = "25758D42FA7052B410176A40010A8A87")
    
public String
    toString() {
        return "id=" + index + ","
                + state + ","
                + "toa=" + TOA + ","
                + (isMpty ? "conf" : "norm") + ","
                + (isMT ? "mt" : "mo") + ","
                + als + ","
                + (isVoice ? "voc" : "nonvoc") + ","
                + (isVoicePrivacy ? "evp" : "noevp") + ","
                /*+ "number=" + number */ + ",cli=" + numberPresentation + ","
                /*+ "name="+ name */ + "," + namePresentation;
    }
    
    public enum State {
        ACTIVE,
        HOLDING,
        DIALING,    
        ALERTING,   
        INCOMING,   
        WAITING;    
    }

    //***** Comparable Implementation

    /** For sorting by index */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.075 -0500", hash_original_method = "7A57313C9AA4F0F08ECFF99E7B6FC0B1", hash_generated_method = "7FC8F5683070E7BCE8C028220B925CA2")
    
public int
    compareTo (Object o) {
        DriverCall dc;

        dc = (DriverCall)o;

        if (index < dc.index) {
            return -1;
        } else if (index == dc.index) {
            return 0;
        } else { /*index > dc.index*/
            return 1;
        }
    }
}

