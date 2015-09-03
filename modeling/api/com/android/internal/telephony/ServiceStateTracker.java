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
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

public abstract class ServiceStateTracker extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.163 -0500", hash_original_field = "30D0F379595D6DC02E55F0AA6F32B639", hash_generated_field = "5FE34011A6194BC6286A035D997282EE")

    static public final int OTASP_UNINITIALIZED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.165 -0500", hash_original_field = "59CB8C7D216CC24881EE4564AE7C912F", hash_generated_field = "061A5F4CDB2510482DF40014FA069CCD")

    static public final int OTASP_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.168 -0500", hash_original_field = "5B5FBDBABCB4A9A0199698CA84F7751F", hash_generated_field = "6654A3F1BBBF982EA7C9094DDBE96306")

    static public final int OTASP_NEEDED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.172 -0500", hash_original_field = "6F31DB593F1EFDEDD953BF14627E46F7", hash_generated_field = "8614A164E69549BC084DFCFF1DBAF5E0")

    static public final int OTASP_NOT_NEEDED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.208 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected  static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.210 -0500", hash_original_field = "F6266A1AC6DFEDEA4DB00E3ACF6E41AA", hash_generated_field = "600CA2D504BDCE1FC8FF6ACEDB6B81F2")

    protected static final int POLL_PERIOD_MILLIS = 20 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.213 -0500", hash_original_field = "CD8623FD90A7024AF28C6B3221113ED6", hash_generated_field = "CAFDA3BCC51A0F86441922B04B913066")

    public static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.216 -0500", hash_original_field = "33F592A3196DF0BF929E83EF42EA8120", hash_generated_field = "84F69B7023F3359922BD3CC5318F83C8")

    protected static final int EVENT_RADIO_STATE_CHANGED               = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.219 -0500", hash_original_field = "C3AA2CF7F56F6434F9301B71C3323E72", hash_generated_field = "A203F2C8F335EED40920E45E27930517")

    protected static final int EVENT_NETWORK_STATE_CHANGED             = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.222 -0500", hash_original_field = "0CAA0F3A6D068686874E705EB05DA2EB", hash_generated_field = "0F5187904AB494740610933B7B24E098")

    protected static final int EVENT_GET_SIGNAL_STRENGTH               = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.224 -0500", hash_original_field = "608037A18426B90AADA4F479585E23CC", hash_generated_field = "6DC87F88388E9F34877717BC87290432")

    protected static final int EVENT_POLL_STATE_REGISTRATION           = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.227 -0500", hash_original_field = "EEC651D31436E83E7D890F3454A64BDA", hash_generated_field = "CFA1BF7A01F64321D84160EE0DD20193")

    protected static final int EVENT_POLL_STATE_GPRS                   = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.230 -0500", hash_original_field = "042B662E17E4C738D8A34BDF6E6EBA7B", hash_generated_field = "125C9CAF2F3F289BCA2D6EB5BC0CCC27")

    protected static final int EVENT_POLL_STATE_OPERATOR               = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.232 -0500", hash_original_field = "5B5EA733A83B6A8D3591BFC19D6154B8", hash_generated_field = "7434403186731242CE130CD89185F174")

    protected static final int EVENT_POLL_SIGNAL_STRENGTH              = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.235 -0500", hash_original_field = "38A47CE90E30B514087D0E8A15612989", hash_generated_field = "C6D65E6A3263D9BB61F378BADEB0C31D")

    protected static final int EVENT_NITZ_TIME                         = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.237 -0500", hash_original_field = "15AF1CEC936F9A0661DEC533ABC22DD3", hash_generated_field = "BF0DF9DD10925CCA481DD852B565D16D")

    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE            = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.240 -0500", hash_original_field = "89A245CBC6CD2E5557E6D151985AE74B", hash_generated_field = "859D0C28ED4D9909418342822317EB13")

    protected static final int EVENT_RADIO_AVAILABLE                   = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.242 -0500", hash_original_field = "29DC06FF9710C4D5D6F4397F97E567D4", hash_generated_field = "F0CD5A6BC9F15EC8D4EF87A1E926AA24")

    protected static final int EVENT_POLL_STATE_NETWORK_SELECTION_MODE = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.245 -0500", hash_original_field = "DFA0B68B92703608A5353AA844D151E3", hash_generated_field = "D1B8A022CD444D16ED15A87ACB0D8953")

    protected static final int EVENT_GET_LOC_DONE                      = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.248 -0500", hash_original_field = "4B2EA2078FF6F01ED87B167A03E472BD", hash_generated_field = "C8CC37BBD393478378E5DB64A00D9694")

    protected static final int EVENT_SIM_RECORDS_LOADED                = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.250 -0500", hash_original_field = "6B9A6ABDCEB6BAF73A4C6044D9FD8DD8", hash_generated_field = "6114AB1E66A6A5EF4B51D860608C43C1")

    protected static final int EVENT_SIM_READY                         = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.253 -0500", hash_original_field = "6CE66BBC07EDBA602FFA2E1EF38EC0A2", hash_generated_field = "ACA75011B0DF066527FB8285BC14A82E")

    protected static final int EVENT_LOCATION_UPDATES_ENABLED          = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.255 -0500", hash_original_field = "1348E960A4022DAC7FE014CFF70C5AAC", hash_generated_field = "DA6739779A294821F19D69B1209C859D")

    protected static final int EVENT_GET_PREFERRED_NETWORK_TYPE        = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.258 -0500", hash_original_field = "73CE009D494521F1B690976F14BDE053", hash_generated_field = "DBA80FBEBF820852D812B9F21CA6C757")

    protected static final int EVENT_SET_PREFERRED_NETWORK_TYPE        = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.261 -0500", hash_original_field = "BAC302BCDE140D349CC402235FD523FF", hash_generated_field = "3688983F97AF1690FB74520E416D9D00")

    protected static final int EVENT_RESET_PREFERRED_NETWORK_TYPE      = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.264 -0500", hash_original_field = "E44697D0199E3449A7F3F32F4BD060D4", hash_generated_field = "7ABE32AA461749D2ACE4ED0BAC995178")

    protected static final int EVENT_CHECK_REPORT_GPRS                 = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.267 -0500", hash_original_field = "AF1FC7072273892FA51FC896EDE2C42A", hash_generated_field = "13EA2B3AA7DECD0D61B6256F92C98577")

    protected static final int EVENT_RESTRICTED_STATE_CHANGED          = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.269 -0500", hash_original_field = "D60DBEEC9D18C2C32B7C9720D0C36195", hash_generated_field = "518D4C82ADF07EC2A7D85DAC04FBA81A")

    protected static final int EVENT_POLL_STATE_REGISTRATION_CDMA      = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.272 -0500", hash_original_field = "09C0F765DA75A53F5DA31736662DD9B4", hash_generated_field = "F063B5ADC5AE2DBDCDB9E1C910F75628")

    protected static final int EVENT_POLL_STATE_OPERATOR_CDMA          = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.275 -0500", hash_original_field = "2DB4BF5E1DAB271FB7926E112B4C30BD", hash_generated_field = "76F1DF043AB5BCCD7071F11CD4B3AC88")

    protected static final int EVENT_RUIM_READY                        = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.277 -0500", hash_original_field = "A0FB14C6BC8C00501DF1D920D5CE4A25", hash_generated_field = "70D8F3A7C3F69F2A3505963EDC584DC0")

    protected static final int EVENT_RUIM_RECORDS_LOADED               = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.280 -0500", hash_original_field = "3A8B7950601DC1BD0DD712A2A49B7C55", hash_generated_field = "1D235673840F2B8537332AF8A9067118")

    protected static final int EVENT_POLL_SIGNAL_STRENGTH_CDMA         = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.282 -0500", hash_original_field = "56ED83110992BE3E4C4B9611A5C2EA78", hash_generated_field = "AE453819021BE93009DE15E100B55C9F")

    protected static final int EVENT_GET_SIGNAL_STRENGTH_CDMA          = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.285 -0500", hash_original_field = "3E2ECE2630C8F179CF8C0A2877A3CCE3", hash_generated_field = "31A9EA70B75498FCE50AAA182FBE8697")

    protected static final int EVENT_NETWORK_STATE_CHANGED_CDMA        = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.288 -0500", hash_original_field = "5AC0F4DC11373C4B20C583629422A698", hash_generated_field = "C6F07CD8E10392E467160421C286E913")

    protected static final int EVENT_GET_LOC_DONE_CDMA                 = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.291 -0500", hash_original_field = "F735885008645496E2C470738CB17EBA", hash_generated_field = "9242A030126539BF7414AD7D2C54FB4D")

    protected static final int EVENT_SIGNAL_STRENGTH_UPDATE_CDMA       = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.293 -0500", hash_original_field = "B630CF8FBB6B4C049BAD97DE93908178", hash_generated_field = "2714AE73CD2DE6067C276393254A4F49")

    protected static final int EVENT_NV_LOADED                         = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.296 -0500", hash_original_field = "4EA16C43EE90319FF5D296D0F99BD7E7", hash_generated_field = "77107C8CD65F04BDC51A0240BBB6C584")

    protected static final int EVENT_POLL_STATE_CDMA_SUBSCRIPTION      = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.298 -0500", hash_original_field = "8C073906971DA4AAE6E6CB7672AF908C", hash_generated_field = "97BF373F74AA7E6EF39F07CAC5B107C6")

    protected static final int EVENT_NV_READY                          = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.301 -0500", hash_original_field = "F315110756C793B66CF021173991CCA8", hash_generated_field = "1FA37EFA5B59783A4CA17CBE2EB53364")

    protected static final int EVENT_ERI_FILE_LOADED                   = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.303 -0500", hash_original_field = "DAA819251A77DFE8BBFFE7C107CDA1F6", hash_generated_field = "38B46743C5C80444E6BF77B51381C7DB")

    protected static final int EVENT_OTA_PROVISION_STATUS_CHANGE       = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.307 -0500", hash_original_field = "A8E034E0D2DFA7B30423891CD64262F9", hash_generated_field = "E7ED1B06C237E08C2D6170BEBC38359D")

    protected static final int EVENT_SET_RADIO_POWER_OFF               = 38;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.309 -0500", hash_original_field = "2E9B45C12471AB6A67F1A47B6DAF8FDD", hash_generated_field = "9741BEB9C7E685D363E6CB738BA59228")

    protected static final String TIMEZONE_PROPERTY = "persist.sys.timezone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.312 -0500", hash_original_field = "1994A0AE0F101D9E533F7404EE96CA71", hash_generated_field = "F73E2C2B2366E68D4B92159CD24006B1")

    protected static final String[] GMT_COUNTRY_CODES = {
        "bf", // Burkina Faso
        "ci", // Cote d'Ivoire
        "eh", // Western Sahara
        "fo", // Faroe Islands, Denmark
        "gh", // Ghana
        "gm", // Gambia
        "gn", // Guinea
        "gw", // Guinea Bissau
        "ie", // Ireland
        "lr", // Liberia
        "is", // Iceland
        "ma", // Morocco
        "ml", // Mali
        "mr", // Mauritania
        "pt", // Portugal
        "sl", // Sierra Leone
        "sn", // Senegal
        "st", // Sao Tome and Principe
        "tg", // Togo
        "uk", // U.K
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.315 -0500", hash_original_field = "95F06705C5F47A845F328E58A31309D0", hash_generated_field = "944ED8C68A3508C953CED23EE840EF9B")

    protected static final String REGISTRATION_DENIED_GEN  = "General";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.317 -0500", hash_original_field = "037AA751A4FB8ED132FEF50D7F3A7E2C", hash_generated_field = "268AF97C81B9E7D55F2E3C79FB200A3E")

    protected static final String REGISTRATION_DENIED_AUTH = "Authentication Failure";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.151 -0500", hash_original_field = "AD2081CF4152C993ABD262358732E864", hash_generated_field = "EDF057DBE0A02042DBF83073757034E9")

    protected CommandsInterface cm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.154 -0500", hash_original_field = "771F16AC824726F2F9EC6A46190C24E9", hash_generated_field = "D607C471A1606B559A4F0C28A47BFD3A")

    public ServiceState ss;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.156 -0500", hash_original_field = "F766E2B01D46CFEF1359F131A72544E7", hash_generated_field = "37638718D876F5421AD103383236AD22")

    protected ServiceState newSS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.158 -0500", hash_original_field = "E9D457B2016609C6DD19200851D3F47A", hash_generated_field = "6D9902C068708E16DB7D3B6602B19CEF")

    public SignalStrength mSignalStrength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.161 -0500", hash_original_field = "CA67AEC23BD3AA97A8C09403F3889385", hash_generated_field = "F7D70BE82B631DDA8C3B56EF51FC91C4")

    public RestrictedState mRestrictedState = new RestrictedState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.174 -0500", hash_original_field = "41B779D71A5D386681D9F7A81D4ECE86", hash_generated_field = "971B063549A1138EC166910CD0B92E16")

    protected int[] pollingContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.177 -0500", hash_original_field = "77E71F1B4CB54BA95AC47E4FF4F3567C", hash_generated_field = "6E0D0EEFBE55BC60F19FC7A47D2CF7A7")

    protected boolean mDesiredPowerState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.179 -0500", hash_original_field = "FC7F389235E013EB3817F48BA2E14C65", hash_generated_field = "0A6EAD8C7AE319D00ACC22C825C0E499")

    protected int mRadioTechnology = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.181 -0500", hash_original_field = "E5A7DFB13439E03EB038ABBB6ECBB214", hash_generated_field = "F7B2E1EBB85BC053B9BECA60685DE78D")

    protected int mNewRadioTechnology = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.184 -0500", hash_original_field = "8A583BBA4A20285E81D1FD2091199B04", hash_generated_field = "5F48A53F7B00B7BD0B14FCC83E25F1EC")

    protected boolean dontPollSignalStrength = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.186 -0500", hash_original_field = "16753A8E70329359BB70958304E8CB4B", hash_generated_field = "3AD1304D1BA317277BBEE277F670A472")

    protected RegistrantList mRoamingOnRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.188 -0500", hash_original_field = "9132F761B07FFE4C68ADC5EB4596503B", hash_generated_field = "7819DA14832792F71F719B742BCE9053")

    protected RegistrantList mRoamingOffRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.190 -0500", hash_original_field = "22EAEC09C075598A3CA1343A4E2C1BCF", hash_generated_field = "43D459080479D457B519BE0CE58EC773")

    protected RegistrantList mAttachedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.193 -0500", hash_original_field = "4779B05EC6BA9FF2093ADCC3C2FEEDC7", hash_generated_field = "B91229A5B50E80471AB407D94A8C22E0")

    protected RegistrantList mDetachedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.195 -0500", hash_original_field = "02AEA65D0E41143CC4FDE7B9B51F136F", hash_generated_field = "EC72819D10D4558220CC871EE1200506")

    protected RegistrantList mNetworkAttachedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.197 -0500", hash_original_field = "3E17775FA50C7F058C9644817EA953C3", hash_generated_field = "177DDA8A6143F9FC217FCFE37BE4DE91")

    protected RegistrantList mPsRestrictEnabledRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.200 -0500", hash_original_field = "AE3E7FD84C91018F1FBAE54B117DD314", hash_generated_field = "405B74B0B32B65F041BDD15D3756D948")

    protected RegistrantList mPsRestrictDisabledRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.203 -0500", hash_original_field = "2EF77F4795D98C814BE6BC7F6438F891", hash_generated_field = "F73F9BC9D0BE82CE2BBEA28FFA11B4CC")

    private boolean mPendingRadioPowerOffAfterDataOff = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.205 -0500", hash_original_field = "463909DF3F17FA5127EF4FE0EEB6AF16", hash_generated_field = "B8B4B877F9363010C47672B0C1475CA5")

    private int mPendingRadioPowerOffAfterDataOffTag = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.340 -0500", hash_original_field = "4A97EEFFD48A08BFCAB1748C351B6846", hash_generated_field = "AFC29418D745D3A6E97E0A67D746937B")

    private boolean mWantContinuousLocationUpdates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.342 -0500", hash_original_field = "D05C341A4DFDEB7388513343C7BF2F8F", hash_generated_field = "F3EAD7378CDAA1419A8D11AA1EFE6677")

    private boolean mWantSingleLocationUpdate;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.320 -0500", hash_original_method = "9FCBDF2ED872770289A466CFAFBF2272", hash_generated_method = "E4D781633E934366A825EA47602B9CE2")
    
public ServiceStateTracker() {
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.322 -0500", hash_original_method = "34F755352C02DF9FD9E8CDE125547BA1", hash_generated_method = "9832B7CED06102AA9B2EEE16EC427320")
    
public boolean getDesiredPowerState() {
        return mDesiredPowerState;
    }

    /**
     * Registration point for combined roaming on
     * combined roaming is true when roaming is true and ONS differs SPN
     *
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.325 -0500", hash_original_method = "37CB7B52ED49DF56B69CEDC0A8B6FEA7", hash_generated_method = "1A9D3F8106A3C7824973AC46A467B157")
    
public  void registerForRoamingOn(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        mRoamingOnRegistrants.add(r);

        if (ss.getRoaming()) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.327 -0500", hash_original_method = "14E5206D7B7C852E20FD1241EAC246C6", hash_generated_method = "17E3E50AB04B354D680E7AB270489C90")
    
public  void unregisterForRoamingOn(Handler h) {
        mRoamingOnRegistrants.remove(h);
    }

    /**
     * Registration point for combined roaming off
     * combined roaming is true when roaming is true and ONS differs SPN
     *
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.330 -0500", hash_original_method = "13A5A77104C9ACCD9C28F87D910D95FA", hash_generated_method = "946F0CEE9F5313C6D3DEC4A27FAC264D")
    
public  void registerForRoamingOff(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        mRoamingOffRegistrants.add(r);

        if (!ss.getRoaming()) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.332 -0500", hash_original_method = "D1DD4EA819F10675CB2C3CAADBABF939", hash_generated_method = "5207588714308B0AA2D20EB5D7D7EB9F")
    
public  void unregisterForRoamingOff(Handler h) {
        mRoamingOffRegistrants.remove(h);
    }

    /**
     * Re-register network by toggling preferred network type.
     * This is a work-around to deregister and register network since there is
     * no ril api to set COPS=2 (deregister) only.
     *
     * @param onComplete is dispatched when this is complete.  it will be
     * an AsyncResult, and onComplete.obj.exception will be non-null
     * on failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.335 -0500", hash_original_method = "7FC24E85162575F4AD0EC1D2B7D4DA9A", hash_generated_method = "B6234145BD763AEEFC801E5B1E641B10")
    
public void reRegisterNetwork(Message onComplete) {
        cm.getPreferredNetworkType(
                obtainMessage(EVENT_GET_PREFERRED_NETWORK_TYPE, onComplete));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.338 -0500", hash_original_method = "58B5CA04F87B88A9C6B403E745D26733", hash_generated_method = "CA9BA1FD8B2826C24CDA9DB2FE15CC7A")
    
public void
    setRadioPower(boolean power) {
        mDesiredPowerState = power;

        setPowerStateToDesired();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.344 -0500", hash_original_method = "7C68C47F455301AB5237FB081DD87707", hash_generated_method = "83A43E243A2EF95DB17BB752C5EB8664")
    
public void enableSingleLocationUpdate() {
        if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        mWantSingleLocationUpdate = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.347 -0500", hash_original_method = "5E0DE008FDA53D6E066E09E5FF8905A8", hash_generated_method = "596A7D4889A7435A716B0F6D2842A235")
    
public void enableLocationUpdates() {
        if (mWantSingleLocationUpdate || mWantContinuousLocationUpdates) return;
        mWantContinuousLocationUpdates = true;
        cm.setLocationUpdates(true, obtainMessage(EVENT_LOCATION_UPDATES_ENABLED));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.349 -0500", hash_original_method = "F0181FD0DF80A6AAF51E269E67B33EC8", hash_generated_method = "4AD841BC21C1C6EF2D2E6A87D7914F59")
    
protected void disableSingleLocationUpdate() {
        mWantSingleLocationUpdate = false;
        if (!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            cm.setLocationUpdates(false, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.352 -0500", hash_original_method = "70DFFFF4880D84ACE04FFF62B87B40F7", hash_generated_method = "8E3A3D8FD2183F3F1124C2E4F14AFD37")
    
public void disableLocationUpdates() {
        mWantContinuousLocationUpdates = false;
        if (!mWantSingleLocationUpdate && !mWantContinuousLocationUpdates) {
            cm.setLocationUpdates(false, null);
        }
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.355 -0500", hash_original_method = "85B887C2BDF2CF10C0119B00ACC95929", hash_generated_method = "E38A6677E5F5446B21C6D585D9C43939")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case EVENT_SET_RADIO_POWER_OFF:
                synchronized(this) {
                    if (mPendingRadioPowerOffAfterDataOff &&
                            (msg.arg1 == mPendingRadioPowerOffAfterDataOffTag)) {
                        if (DBG) log("EVENT_SET_RADIO_OFF, turn radio off now.");
                        hangupAndPowerOff();
                        mPendingRadioPowerOffAfterDataOffTag += 1;
                        mPendingRadioPowerOffAfterDataOff = false;
                    } else {
                        log("EVENT_SET_RADIO_OFF is stale arg1=" + msg.arg1 +
                                "!= tag=" + mPendingRadioPowerOffAfterDataOffTag);
                    }
                }
                break;

            default:
                log("Unhandled message with number: " + msg.what);
                break;
        }
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.358 -0500", hash_original_method = "2934325051523620DCD2F62BF84383AD", hash_generated_method = "E0532074FC3B4F0149E2689F81019F86")
    
protected abstract Phone getPhone();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.360 -0500", hash_original_method = "B097733BE8D514FB5F11D7AA78EE34CE", hash_generated_method = "4E7BFD117830BE223287A0E288E7EC63")
    
protected abstract void handlePollStateResult(int what, AsyncResult ar);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.363 -0500", hash_original_method = "EFBE9729B803BEF3FD67A09A5D9AC457", hash_generated_method = "980C643B3137A5B5A2226B23ECA6597F")
    
protected abstract void updateSpnDisplay();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.366 -0500", hash_original_method = "3548185448D01443F6FACDAD06992FAA", hash_generated_method = "8543D43A716450CF356B3CB4BAABEE35")
    
protected abstract void setPowerStateToDesired();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.368 -0500", hash_original_method = "48DBEBE9679DD6022C78E9B6D9D15841", hash_generated_method = "43827D28600B8F0847D532E80E30A990")
    
protected abstract void log(String s);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.371 -0500", hash_original_method = "8503C48BD28DECE909202E8D31B4BECE", hash_generated_method = "98998146AAEFC08A350487078A6888FB")
    
protected abstract void loge(String s);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.373 -0500", hash_original_method = "BEDDA24545C3772B08260481D5178989", hash_generated_method = "1BF694F6D4200D916F4713993884C472")
    
public abstract int getCurrentDataConnectionState();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.375 -0500", hash_original_method = "132CC79318588C72D1FB6728C65197B0", hash_generated_method = "97782144A3870C79ACF31279FE387829")
    
public abstract boolean isConcurrentVoiceAndDataAllowed();

    /**
     * Registration point for transition into DataConnection attached.
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.378 -0500", hash_original_method = "1B39DC11812BAED5F6DBE7D3309539B9", hash_generated_method = "9E895223B42BB1C684E780E83D28AF2D")
    
public void registerForDataConnectionAttached(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        mAttachedRegistrants.add(r);

        if (getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE) {
            r.notifyRegistrant();
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.381 -0500", hash_original_method = "522E6F692E8A34CBC0692BA5B00B104A", hash_generated_method = "BE463904F57B8714BC13C634AD73B37F")
    
public void unregisterForDataConnectionAttached(Handler h) {
        mAttachedRegistrants.remove(h);
    }

    /**
     * Registration point for transition into DataConnection detached.
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.383 -0500", hash_original_method = "77B8D4D5781330742D00786669C25585", hash_generated_method = "14C6CE0C0F517A059CFA3567E0AC359F")
    
public void registerForDataConnectionDetached(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        mDetachedRegistrants.add(r);

        if (getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE) {
            r.notifyRegistrant();
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.385 -0500", hash_original_method = "EDB8FFB895F180442CD81D10E9DCB320", hash_generated_method = "506C5C497AFEAFB39C42A279762119EA")
    
public void unregisterForDataConnectionDetached(Handler h) {
        mDetachedRegistrants.remove(h);
    }

    /**
     * Registration point for transition into network attached.
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.388 -0500", hash_original_method = "076CF7EAC62798919AFD2DB28A5B16ED", hash_generated_method = "203B37528905E958FEF9201DE14623B9")
    
public void registerForNetworkAttached(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);

        mNetworkAttachedRegistrants.add(r);
        if (ss.getState() == ServiceState.STATE_IN_SERVICE) {
            r.notifyRegistrant();
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.390 -0500", hash_original_method = "724BCD9A17C4DC5B22474701A65D5E92", hash_generated_method = "1DB5870414BC6CB0AFD9E5D29F418176")
    
public void unregisterForNetworkAttached(Handler h) {
        mNetworkAttachedRegistrants.remove(h);
    }

    /**
     * Registration point for transition into packet service restricted zone.
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.392 -0500", hash_original_method = "32627558F162EE4DAA643B6ABADEA2AE", hash_generated_method = "B5E3BDF9BA5813B07A71A3D330AE88FF")
    
public void registerForPsRestrictedEnabled(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        mPsRestrictEnabledRegistrants.add(r);

        if (mRestrictedState.isPsRestricted()) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.395 -0500", hash_original_method = "9066DA15695A4B8D83C2DCD56A112C2B", hash_generated_method = "FEB97FB41A69F9F03ABC123373573B26")
    
public void unregisterForPsRestrictedEnabled(Handler h) {
        mPsRestrictEnabledRegistrants.remove(h);
    }

    /**
     * Registration point for transition out of packet service restricted zone.
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.398 -0500", hash_original_method = "80FC2224C82FF97B7F6C95DA27C6509B", hash_generated_method = "49CB9398BACF8E64B2E7259943180BF1")
    
public void registerForPsRestrictedDisabled(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        mPsRestrictDisabledRegistrants.add(r);

        if (mRestrictedState.isPsRestricted()) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.400 -0500", hash_original_method = "3E796B0EF9A5478F633347EEDEC69A91", hash_generated_method = "92B8C7191ABF681F1788C3F76385781C")
    
public void unregisterForPsRestrictedDisabled(Handler h) {
        mPsRestrictDisabledRegistrants.remove(h);
    }

    /**
     * Clean up existing voice and data connection then turn off radio power.
     *
     * Hang up the existing voice calls to decrease call drop rate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.404 -0500", hash_original_method = "4017CCA25B6B957B00970913316AB84B", hash_generated_method = "FFC2870F01FF8AAA21875AC77F095D61")
    
public void powerOffRadioSafely(DataConnectionTracker dcTracker) {
        synchronized (this) {
            if (!mPendingRadioPowerOffAfterDataOff) {
                // To minimize race conditions we call cleanUpAllConnections on
                // both if else paths instead of before this isDisconnected test.
                if (dcTracker.isDisconnected()) {
                    // To minimize race conditions we do this after isDisconnected
                    dcTracker.cleanUpAllConnections(Phone.REASON_RADIO_TURNED_OFF);
                    if (DBG) log("Data disconnected, turn off radio right away.");
                    hangupAndPowerOff();
                } else {
                    dcTracker.cleanUpAllConnections(Phone.REASON_RADIO_TURNED_OFF);
                    Message msg = Message.obtain(this);
                    msg.what = EVENT_SET_RADIO_POWER_OFF;
                    msg.arg1 = ++mPendingRadioPowerOffAfterDataOffTag;
                    if (sendMessageDelayed(msg, 30000)) {
                        if (DBG) log("Wait upto 30s for data to disconnect, then turn off radio.");
                        mPendingRadioPowerOffAfterDataOff = true;
                    } else {
                        log("Cannot send delayed Msg, turn off radio right away.");
                        hangupAndPowerOff();
                    }
                }
            }
        }
    }

    /**
     * process the pending request to turn radio off after data is disconnected
     *
     * return true if there is pending request to process; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.406 -0500", hash_original_method = "67059C8AF83909E1964C0331470598CC", hash_generated_method = "92ED0B3F0A1F2DF6AEBB02F9D02A269B")
    
public boolean processPendingRadioPowerOffAfterDataOff() {
        synchronized(this) {
            if (mPendingRadioPowerOffAfterDataOff) {
                if (DBG) log("Process pending request to turn radio off.");
                mPendingRadioPowerOffAfterDataOffTag += 1;
                hangupAndPowerOff();
                mPendingRadioPowerOffAfterDataOff = false;
                return true;
            }
            return false;
        }
    }

    /**
     * Hang up all voice call and turn off radio. Implemented by derived class.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.409 -0500", hash_original_method = "3BB44C3DD2061253679203D4D7C2D279", hash_generated_method = "A83935CB33234D2F29A0F21AA05246AD")
    
protected abstract void hangupAndPowerOff();

    /** Cancel a pending (if any) pollState() operation */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.411 -0500", hash_original_method = "CCBC34A7562606F2023BFC5649B6E19A", hash_generated_method = "7DE0A8390D83202A43696BB6CC1F90EC")
    
protected void cancelPollState() {
        // This will effectively cancel the rest of the poll requests.
        pollingContext = new int[1];
    }
}

