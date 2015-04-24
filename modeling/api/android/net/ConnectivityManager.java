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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.util.Preconditions.checkNotNull;

import java.net.InetAddress;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.Binder;
import android.os.RemoteException;

public class ConnectivityManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.975 -0500", hash_original_method = "671D0D7730B85BC5935321406BD74923", hash_generated_method = "11074B2D42E47FAF0F3700968E303606")
    
public static boolean isNetworkTypeValid(int networkType) {
        return networkType >= 0 && networkType <= MAX_NETWORK_TYPE;
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.978 -0500", hash_original_method = "57160226B4CF0D42C9F7F57B79505FFE", hash_generated_method = "0247A70DED0CC0A01F33D476BB55F870")
    
public static String getNetworkTypeName(int type) {
        switch (type) {
            case TYPE_MOBILE:
                return "MOBILE";
            case TYPE_WIFI:
                return "WIFI";
            case TYPE_MOBILE_MMS:
                return "MOBILE_MMS";
            case TYPE_MOBILE_SUPL:
                return "MOBILE_SUPL";
            case TYPE_MOBILE_DUN:
                return "MOBILE_DUN";
            case TYPE_MOBILE_HIPRI:
                return "MOBILE_HIPRI";
            case TYPE_WIMAX:
                return "WIMAX";
            case TYPE_BLUETOOTH:
                return "BLUETOOTH";
            case TYPE_DUMMY:
                return "DUMMY";
            case TYPE_ETHERNET:
                return "ETHERNET";
            case TYPE_MOBILE_FOTA:
                return "MOBILE_FOTA";
            case TYPE_MOBILE_IMS:
                return "MOBILE_IMS";
            case TYPE_MOBILE_CBS:
                return "MOBILE_CBS";
            case TYPE_WIFI_P2P:
                return "WIFI_P2P";
            default:
                return Integer.toString(type);
        }
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.980 -0500", hash_original_method = "2EC5513CB708A6E25C2C940D3332D84B", hash_generated_method = "CDFB39553308CFA822EB8281CC44E959")
    
public static boolean isNetworkTypeMobile(int networkType) {
        switch (networkType) {
            case TYPE_MOBILE:
            case TYPE_MOBILE_MMS:
            case TYPE_MOBILE_SUPL:
            case TYPE_MOBILE_DUN:
            case TYPE_MOBILE_HIPRI:
            case TYPE_MOBILE_FOTA:
            case TYPE_MOBILE_IMS:
            case TYPE_MOBILE_CBS:
                return true;
            default:
                return false;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.891 -0500", hash_original_field = "BD4FBE844134C3FBBB0F5F875F6F7CC0", hash_generated_field = "F201A0F81F13052259E82D44CCBC8735")

    private static final String TAG = "ConnectivityManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.894 -0500", hash_original_field = "934C2868249377B0D943B9BAC22DE66C", hash_generated_field = "D74478E2CAA048320F4ED7DCDC0267DE")

    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.896 -0500", hash_original_field = "1B710780A44D2FBC7C93BC17D1984669", hash_generated_field = "0C9BA7409106298885F98D4DB9A7BA61")

    public static final String CONNECTIVITY_ACTION_IMMEDIATE =
            "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.898 -0500", hash_original_field = "921B5A99469139AF646DB6EF6429D0F0", hash_generated_field = "5C154E9E8533DCDF3E6DC4E5322ABCE1")

    @Deprecated
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.901 -0500", hash_original_field = "7D5546B77E406C67B644D94DFAE6748B", hash_generated_field = "B68430B9EDED794774E47F6FA9FA85E8")

    public static final String EXTRA_IS_FAILOVER = "isFailover";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.903 -0500", hash_original_field = "B81BEB7C0BBE138EB34E8121FC38B6FE", hash_generated_field = "38491437E03D8F52518B778972D56CD8")

    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.905 -0500", hash_original_field = "BF8032790BCACEA592BDAF915F94CA07", hash_generated_field = "BF4C8084C31E77ECEC6D5E1A7C4B100F")

    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.908 -0500", hash_original_field = "5363D3794B9721ED1CAEC55ED5B3FD93", hash_generated_field = "F4AF3469CA1920E05896824A0F13F189")

    public static final String EXTRA_REASON = "reason";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.911 -0500", hash_original_field = "A6F85648C65E15D642E5A2F3306F99C2", hash_generated_field = "C2A1F543AB7E1673850281E0F6B73AA4")

    public static final String EXTRA_EXTRA_INFO = "extraInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.913 -0500", hash_original_field = "C0FC36DD5DAFB1D097286B54FD8BB56B", hash_generated_field = "84A4E2B243A3B918B60966208E2EF600")

    public static final String EXTRA_INET_CONDITION = "inetCondition";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.916 -0500", hash_original_field = "FFAFD51EDEC62F76720D88F0BE1EA7DA", hash_generated_field = "7CC0C8005490856A2BC847B1E0AA4532")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED =
            "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.918 -0500", hash_original_field = "39EB8D103B6AB17B474AB2405AF2A368", hash_generated_field = "929E54EDEA98710E57039E6175F5F1AB")

    public static final String INET_CONDITION_ACTION =
            "android.net.conn.INET_CONDITION_ACTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.920 -0500", hash_original_field = "91C0AD77C54B6DF2A5D36FDF198EAE3F", hash_generated_field = "15608AF081DDD375FA2123C2469F75CE")

    public static final String ACTION_TETHER_STATE_CHANGED =
            "android.net.conn.TETHER_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.923 -0500", hash_original_field = "7C5BC54BE8B8934ADA2F5D3B385A6755", hash_generated_field = "5FD0830638BAEF1B21B12EF8569D3DFD")

    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.925 -0500", hash_original_field = "FA2330F8006245868B51788852E63C26", hash_generated_field = "F15A2DC595B40FF3DA55E3CB05B0C76E")

    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.927 -0500", hash_original_field = "E0882689B7D40FD14516FEFA715FC902", hash_generated_field = "C4FB23C86207DA0754B9BB6EA60CB4E1")

    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.930 -0500", hash_original_field = "1B69763949253D0F5708E1F4FB87C745", hash_generated_field = "93641F6D636E423068CBD0F7A429454B")

    public static final int TYPE_NONE        = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.933 -0500", hash_original_field = "C2690882501F357FF0445ABEDAC32C7E", hash_generated_field = "C9C37D3486815251D1CD39C5BE1F3D12")

    public static final int TYPE_MOBILE      = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.935 -0500", hash_original_field = "7AEFF42D9A631133ACF12A4F6796F98D", hash_generated_field = "AC65BD7D5FC33F670E90ACDF591214B3")

    public static final int TYPE_WIFI        = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.937 -0500", hash_original_field = "DFE941C34DE5F24F509BCFBA08CA2B22", hash_generated_field = "CFFD550B064A8A8F08DFF2A1CA39B65C")

    public static final int TYPE_MOBILE_MMS  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.940 -0500", hash_original_field = "F18378996E273BF774041497B147CB25", hash_generated_field = "9F57AC6327FA6A9B5FA8D268FA065E2F")

    public static final int TYPE_MOBILE_SUPL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.942 -0500", hash_original_field = "FECFE40FBC9CD8C4CA4939282D035F34", hash_generated_field = "E58E8F46709C4195B87AD88D79419D50")

    public static final int TYPE_MOBILE_DUN  = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.944 -0500", hash_original_field = "77E3DE3BA93B1CBF36A600C46AAD5247", hash_generated_field = "0621333417ED999CFE5293A09D2BECCB")

    public static final int TYPE_MOBILE_HIPRI = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.947 -0500", hash_original_field = "3405200B03D976F2BDE672A170AFB964", hash_generated_field = "BAA1818BB1192483D8B52B8F786077C0")

    public static final int TYPE_WIMAX       = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.949 -0500", hash_original_field = "E9D248DC03AC712B13D62C44851D0006", hash_generated_field = "CD355E6AC2221CCE2CCDAE49A283C8ED")

    public static final int TYPE_BLUETOOTH   = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.951 -0500", hash_original_field = "FCCBA5F4E49F4788F9729FF5BAE04A4C", hash_generated_field = "ABE0A738884F28B1356F01138B1EB213")

    public static final int TYPE_DUMMY       = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.953 -0500", hash_original_field = "76FA758025B04F0CE82C49EB36558126", hash_generated_field = "ACFC541BB1EF72643D27FBCAC2F80E92")

    public static final int TYPE_ETHERNET    = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.956 -0500", hash_original_field = "40DA5421394F73174B867959BB096EC4", hash_generated_field = "C217790CC7405EE35B93FDCCBB7C8140")

    public static final int TYPE_MOBILE_FOTA = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.958 -0500", hash_original_field = "5CFA227EAEC1350298343E5FAD12674B", hash_generated_field = "6D9B79B5DD49C3171F158817B3061CDF")

    public static final int TYPE_MOBILE_IMS  = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.961 -0500", hash_original_field = "0EC831B49AF1CEEA849868A28911CFD3", hash_generated_field = "70BC4329B6D7C6986B2212F6DB3B92A0")

    public static final int TYPE_MOBILE_CBS  = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.963 -0500", hash_original_field = "4BC18305F9C41A781BECF20C4C6014AD", hash_generated_field = "92581ADB158A1116848D6CC3361396A8")

    public static final int TYPE_WIFI_P2P    = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.965 -0500", hash_original_field = "92986C1129AC540673F348DB71831E37", hash_generated_field = "EFA11F2732F8BA0E99360E32BB64687E")

    public static final int MAX_RADIO_TYPE   = TYPE_WIFI_P2P;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.968 -0500", hash_original_field = "CBCEE0E9F027D5FD5F0887750B6B100D", hash_generated_field = "1E3DEA2E494B778E3E4DC09D24507EBC")

    public static final int MAX_NETWORK_TYPE = TYPE_WIFI_P2P;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.970 -0500", hash_original_field = "A591864212287B0F4C2623B6941E302B", hash_generated_field = "693728286830CEC17980B2770B246B92")

    public static final int DEFAULT_NETWORK_PREFERENCE = TYPE_WIFI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.050 -0500", hash_original_field = "8C9AEFD4AA83DE991C5D77C913B19CBF", hash_generated_field = "27C649E4F5C0896362843DA1D4CCC9B3")

    public static final int TETHER_ERROR_NO_ERROR           = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.053 -0500", hash_original_field = "F46A8DFA661DDD348214DCAEDD91212E", hash_generated_field = "07524C9E5C0A6E14423C5AA3A0BCF933")

    public static final int TETHER_ERROR_UNKNOWN_IFACE      = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.055 -0500", hash_original_field = "53DE159609D64030D0A8359B492DB4FC", hash_generated_field = "6A20D3B74D9781CEFE362C2F0E6C1ACB")

    public static final int TETHER_ERROR_SERVICE_UNAVAIL    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.057 -0500", hash_original_field = "EF8C4FF364F57338A254AB6282B0E180", hash_generated_field = "6DBA0A44F83AE28B03C80500322E7C88")

    public static final int TETHER_ERROR_UNSUPPORTED        = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.060 -0500", hash_original_field = "570D229C7EE5B7D074173410BBC11E65", hash_generated_field = "39FD0B36B98E04AAD8EEAF19046A06B2")

    public static final int TETHER_ERROR_UNAVAIL_IFACE      = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.062 -0500", hash_original_field = "18E40FF16FA7E9678CE1077B6472152F", hash_generated_field = "5A077B24861F547F9496BEBC8EFA8136")

    public static final int TETHER_ERROR_MASTER_ERROR       = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.065 -0500", hash_original_field = "CF255951F80909B28C9A087741504A7F", hash_generated_field = "FFAEC6C250B0EF0B5C941FCD72B78F03")

    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.067 -0500", hash_original_field = "45E7FE223381DDB2D7683D47C9C5B220", hash_generated_field = "E28AFC063D621B0867BDDEB59FAF30D1")

    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.069 -0500", hash_original_field = "E0AD6C29F5CB806B7A1B47ED9CEFD894", hash_generated_field = "F6682A4AE0D5B2CE3CDD81FB1BE1FF0F")

    public static final int TETHER_ERROR_ENABLE_NAT_ERROR     = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.071 -0500", hash_original_field = "69EE1A3A76EC0923202449B798FBD6E1", hash_generated_field = "8F0E5817C52CE45A45E797BAE8358F6C")

    public static final int TETHER_ERROR_DISABLE_NAT_ERROR    = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.073 -0500", hash_original_field = "C5B04CAEE7441D6A1F7CB7CF19955BFD", hash_generated_field = "6F017CF59453C65348D1F7CD3994589B")

    public static final int TETHER_ERROR_IFACE_CFG_ERROR      = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.972 -0500", hash_original_field = "D5507596E1C2AEF6056A5DA433C8FD30", hash_generated_field = "91FD67C0243C9CAC51474C01D9540196")

    private  IConnectivityManager mService;

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.026 -0500", hash_original_method = "6A60C197741333EAEC6E0EA679C6387D", hash_generated_method = "FB6A15582C02AA066C7FFFF9BD814C66")
    
public ConnectivityManager(IConnectivityManager service) {
        mService = checkNotNull(service, "missing IConnectivityManager");
    }
    
    //added for Modeling
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public ConnectivityManager(){
        
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.982 -0500", hash_original_method = "20C5B9DE2E49D07D506F0D5479D46C57", hash_generated_method = "705016F11B9CF1B00FA6D0B84A4A127D")
    
public void setNetworkPreference(int preference) {
        try {
            mService.setNetworkPreference(preference);
        } catch (RemoteException e) {
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.985 -0500", hash_original_method = "900E5DCCFD12B740A82ADA5294C949B0", hash_generated_method = "759169DAD21DE8D0E16EBF66531F9DDE")
    
public int getNetworkPreference() {
        try {
            return mService.getNetworkPreference();
        } catch (RemoteException e) {
            return -1;
        }
    }

    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.987 -0500", hash_original_method = "5E96294DED8896A900AADA5BAA807536", hash_generated_method = "41EC2EBBFB0A8E61C4899BD3B725AE62")
    
public NetworkInfo getActiveNetworkInfo() {
        try {
            return mService.getActiveNetworkInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.989 -0500", hash_original_method = "EA020BF9EC9A5FD5A107F43E91D20C3E", hash_generated_method = "F217E7BAAF7FC4B1325894C5EC16AA72")
    
public NetworkInfo getActiveNetworkInfoForUid(int uid) {
        try {
            return mService.getActiveNetworkInfoForUid(uid);
        } catch (RemoteException e) {
            return null;
        }
    }

    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.991 -0500", hash_original_method = "96564B6A49DFD6F7048AD1538B907A96", hash_generated_method = "F71292CA1D9F31586813A24788C5814B")
    
public NetworkInfo getNetworkInfo(int networkType) {
        try {
            return mService.getNetworkInfo(networkType);
        } catch (RemoteException e) {
            return null;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.993 -0500", hash_original_method = "394CF6797F6D312CB8F1ED596C180D8F", hash_generated_method = "33BE518378535A949350F5A4A4146652")
    
public NetworkInfo[] getAllNetworkInfo() {
        try {
            return mService.getAllNetworkInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.995 -0500", hash_original_method = "D6D4DA92D9064C06A48DA2C5EB8FF9D2", hash_generated_method = "8635E571CCE927831735F710D9313227")
    
public LinkProperties getActiveLinkProperties() {
        try {
            return mService.getActiveLinkProperties();
        } catch (RemoteException e) {
            return null;
        }
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.997 -0500", hash_original_method = "C7AAA0ED9F7BD2D04E30B8A62557C00D", hash_generated_method = "77862D1F6036B72D3773EF80967CA162")
    
public LinkProperties getLinkProperties(int networkType) {
        try {
            return mService.getLinkProperties(networkType);
        } catch (RemoteException e) {
            return null;
        }
    }

    /** {@hide} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.999 -0500", hash_original_method = "8773F3976862F74C7E8795673CF57A3F", hash_generated_method = "81730442DE198C93F00AD5357E15482A")
    
public boolean setRadios(boolean turnOn) {
        try {
            return mService.setRadios(turnOn);
        } catch (RemoteException e) {
            return false;
        }
    }

    /** {@hide} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.002 -0500", hash_original_method = "F4DEFED01E737220B0A84C9B3C165EA1", hash_generated_method = "514001308D74667C857CA35F320B4989")
    
public boolean setRadio(int networkType, boolean turnOn) {
        try {
            return mService.setRadio(networkType, turnOn);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Tells the underlying networking system that the caller wants to
     * begin using the named feature. The interpretation of {@code feature}
     * is completely up to each networking implementation.
     * @param networkType specifies which network the request pertains to
     * @param feature the name of the feature to be used
     * @return an integer value representing the outcome of the request.
     * The interpretation of this value is specific to each networking
     * implementation+feature combination, except that the value {@code -1}
     * always indicates failure.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.004 -0500", hash_original_method = "709E7052A14C2A0D29C9219C00073F31", hash_generated_method = "B8D07777FB958A74015C5CF7BC03DA3C")
    
public int startUsingNetworkFeature(int networkType, String feature) {
        try {
            return mService.startUsingNetworkFeature(networkType, feature,
                    new Binder());
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * Tells the underlying networking system that the caller is finished
     * using the named feature. The interpretation of {@code feature}
     * is completely up to each networking implementation.
     * @param networkType specifies which network the request pertains to
     * @param feature the name of the feature that is no longer needed
     * @return an integer value representing the outcome of the request.
     * The interpretation of this value is specific to each networking
     * implementation+feature combination, except that the value {@code -1}
     * always indicates failure.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.006 -0500", hash_original_method = "60EB71F5D3B7B41111FE02ED36065292", hash_generated_method = "660B44F86D05392C9D1712D13B2470A7")
    
public int stopUsingNetworkFeature(int networkType, String feature) {
        try {
            return mService.stopUsingNetworkFeature(networkType, feature);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * Ensure that a network route exists to deliver traffic to the specified
     * host via the specified network interface. An attempt to add a route that
     * already exists is ignored, but treated as successful.
     * @param networkType the type of the network over which traffic to the specified
     * host is to be routed
     * @param hostAddress the IP address of the host to which the route is desired
     * @return {@code true} on success, {@code false} on failure
     */
    @DSSpec(DSCat.NETWORK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.009 -0500", hash_original_method = "C11FA4279C0A187DA118461D9F53788F", hash_generated_method = "A59DF0CDA78CA80C163B11A00636E787")
    
public boolean requestRouteToHost(int networkType, int hostAddress) {
        InetAddress inetAddress = NetworkUtils.intToInetAddress(hostAddress);

        if (inetAddress == null) {
            return false;
        }

        return requestRouteToHostAddress(networkType, inetAddress);
    }

    /**
     * Ensure that a network route exists to deliver traffic to the specified
     * host via the specified network interface. An attempt to add a route that
     * already exists is ignored, but treated as successful.
     * @param networkType the type of the network over which traffic to the specified
     * host is to be routed
     * @param hostAddress the IP address of the host to which the route is desired
     * @return {@code true} on success, {@code false} on failure
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.012 -0500", hash_original_method = "EFA83347B3FFE38EB6FE081BBE35835E", hash_generated_method = "FCD9C39A9786A78D9C1132E53F2081D2")
    
public boolean requestRouteToHostAddress(int networkType, InetAddress hostAddress) {
        byte[] address = hostAddress.getAddress();
        try {
            return mService.requestRouteToHostAddress(networkType, address);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Returns the value of the setting for background data usage. If false,
     * applications should not use the network if the application is not in the
     * foreground. Developers should respect this setting, and check the value
     * of this before performing any background data operations.
     * <p>
     * All applications that have background services that use the network
     * should listen to {@link #ACTION_BACKGROUND_DATA_SETTING_CHANGED}.
     * <p>
     * @deprecated As of {@link VERSION_CODES#ICE_CREAM_SANDWICH}, availability of
     * background data depends on several combined factors, and this method will
     * always return {@code true}. Instead, when background data is unavailable,
     * {@link #getActiveNetworkInfo()} will now appear disconnected.
     *
     * @return Whether background data usage is allowed.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.014 -0500", hash_original_method = "6498894EA2E4C7DBE6A13B3BD05F6504", hash_generated_method = "AAEBF5ACBF892053B714FA4BBD54B26A")
    
@Deprecated
    public boolean getBackgroundDataSetting() {
        // assume that background data is allowed; final authority is
        // NetworkInfo which may be blocked.
        return true;
    }

    /**
     * Sets the value of the setting for background data usage.
     *
     * @param allowBackgroundData Whether an application should use data while
     *            it is in the background.
     *
     * @attr ref android.Manifest.permission#CHANGE_BACKGROUND_DATA_SETTING
     * @see #getBackgroundDataSetting()
     * @hide
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.016 -0500", hash_original_method = "C7D66D7319A6F772837F5FAC4582BCF2", hash_generated_method = "AC4F316907C6A856C123A7790060ED3D")
    
@Deprecated
    public void setBackgroundDataSetting(boolean allowBackgroundData) {
        // ignored
    }

    /**
     * Return quota status for the current active network, or {@code null} if no
     * network is active. Quota status can change rapidly, so these values
     * shouldn't be cached.
     *
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.018 -0500", hash_original_method = "2A17F1CC768C6D56971308D1A367AB75", hash_generated_method = "1B8ED4CA714DDB042712317BD3C2D6CC")
    
public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        try {
            return mService.getActiveNetworkQuotaInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Gets the value of the setting for enabling Mobile data.
     *
     * @return Whether mobile data is enabled.
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.021 -0500", hash_original_method = "4787FEDAB977985506F4394396606391", hash_generated_method = "58A8EAFE078160517ACBD7DA92AB164F")
    
public boolean getMobileDataEnabled() {
        try {
            return mService.getMobileDataEnabled();
        } catch (RemoteException e) {
            return true;
        }
    }

    /**
     * Sets the persisted value for enabling/disabling Mobile data.
     *
     * @param enabled Whether the mobile data connection should be
     *            used or not.
     * @hide
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.023 -0500", hash_original_method = "03BF638942F758314C38E6E89D590F06", hash_generated_method = "261DF7B0ED76F52E39B217245232E798")
    
public void setMobileDataEnabled(boolean enabled) {
        try {
            mService.setMobileDataEnabled(enabled);
        } catch (RemoteException e) {
        }
    }

    /**
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.028 -0500", hash_original_method = "65586E40689502E42674D85C93789ED5", hash_generated_method = "1524A1C6889FA407CD7898036794577E")
    
public String[] getTetherableIfaces() {
        try {
            return mService.getTetherableIfaces();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    /**
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.031 -0500", hash_original_method = "1A1AB0AA8E53EB2A72A3BB78A36F79E1", hash_generated_method = "9D347932FEA778AD58444359C24661A5")
    
public String[] getTetheredIfaces() {
        try {
            return mService.getTetheredIfaces();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    /**
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.033 -0500", hash_original_method = "B4F0365B2F0B873A76FA3BA63C88578F", hash_generated_method = "081CB592E791F9A009E27E780AA940EA")
    
public String[] getTetheringErroredIfaces() {
        try {
            return mService.getTetheringErroredIfaces();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    /**
     * @return error A TETHER_ERROR value indicating success or failure type
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.035 -0500", hash_original_method = "88DA982A0D8C00E6CF08BAB9F849E24F", hash_generated_method = "8DB12DF8511773F1A6926E2F58A20399")
    
public int tether(String iface) {
        try {
            return mService.tether(iface);
        } catch (RemoteException e) {
            return TETHER_ERROR_SERVICE_UNAVAIL;
        }
    }

    /**
     * @return error A TETHER_ERROR value indicating success or failure type
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.037 -0500", hash_original_method = "A16CE7410015543313DA1C15EBE8B863", hash_generated_method = "09CE1873E335A9849718E1C737BEE0DA")
    
public int untether(String iface) {
        try {
            return mService.untether(iface);
        } catch (RemoteException e) {
            return TETHER_ERROR_SERVICE_UNAVAIL;
        }
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.039 -0500", hash_original_method = "457F62D672DCD1BF7CAF2342EBCF7BE3", hash_generated_method = "166196EAC6443CCF5C7D81B7928D6502")
    
public boolean isTetheringSupported() {
        try {
            return mService.isTetheringSupported();
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.041 -0500", hash_original_method = "DC0367A904D99268D94A314F1CB55B9B", hash_generated_method = "1D22ECDF187484958B6A6894CE6090CC")
    
public String[] getTetherableUsbRegexs() {
        try {
            return mService.getTetherableUsbRegexs();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    /**
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.043 -0500", hash_original_method = "8DD288EE3D6933895D6454F488DECB73", hash_generated_method = "8746646E29D66BEFF48A0D43327DB8F6")
    
public String[] getTetherableWifiRegexs() {
        try {
            return mService.getTetherableWifiRegexs();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    /**
     * {@hide}
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.046 -0500", hash_original_method = "83E2E43D24B9648666006A701F93D599", hash_generated_method = "2EFF0592C6AB09E9EC8609E4BBE3F10D")
    
public String[] getTetherableBluetoothRegexs() {
        try {
            return mService.getTetherableBluetoothRegexs();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    /**
     * {@hide}
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.048 -0500", hash_original_method = "952ADB6A2A3AEF46E275F5FA17E284ED", hash_generated_method = "2C41EFBAB494353AB09ACFCBFAE7765F")
    
public int setUsbTethering(boolean enable) {
        try {
            return mService.setUsbTethering(enable);
        } catch (RemoteException e) {
            return TETHER_ERROR_SERVICE_UNAVAIL;
        }
    }

    /**
     * @param iface The name of the interface we're interested in
     * @return error The error code of the last error tethering or untethering the named
     *               interface
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.077 -0500", hash_original_method = "A91E88C74DCBFDB505B1B5012FAE30D1", hash_generated_method = "B7FA9633C21B661F3672DE0D8F69EEC2")
    
public int getLastTetherError(String iface) {
        try {
            return mService.getLastTetherError(iface);
        } catch (RemoteException e) {
            return TETHER_ERROR_SERVICE_UNAVAIL;
        }
    }

    /**
     * Ensure the device stays awake until we connect with the next network
     * @param forWhome The name of the network going down for logging purposes
     * @return {@code true} on success, {@code false} on failure
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.079 -0500", hash_original_method = "400BD091D4CACB3FCA76B3A275DD11D5", hash_generated_method = "A3F5C278F78163852F760D51592A04F2")
    
public boolean requestNetworkTransitionWakelock(String forWhom) {
        try {
            mService.requestNetworkTransitionWakelock(forWhom);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * @param networkType The type of network you want to report on
     * @param percentage The quality of the connection 0 is bad, 100 is good
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.081 -0500", hash_original_method = "37DB5DE823B5870FA290320C99B5BB07", hash_generated_method = "D821D100BA6D0619225EF799F5768E03")
    
public void reportInetCondition(int networkType, int percentage) {
        try {
            mService.reportInetCondition(networkType, percentage);
        } catch (RemoteException e) {
        }
    }

    /**
     * @param proxyProperties The definition for the new global http proxy
     * {@hide}
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.083 -0500", hash_original_method = "0F41E571577973AB5A169120A0CDA859", hash_generated_method = "E1760C896E349F468C2A1BB16793804D")
    
public void setGlobalProxy(ProxyProperties p) {
        try {
            mService.setGlobalProxy(p);
        } catch (RemoteException e) {
        }
    }

    /**
     * @return proxyProperties for the current global proxy
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.085 -0500", hash_original_method = "7F5BD964F39855F539616DAFB8170A5C", hash_generated_method = "5F3090D7457841318036240AF5DE45DB")
    
public ProxyProperties getGlobalProxy() {
        try {
            return mService.getGlobalProxy();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * @return proxyProperties for the current proxy (global if set, network specific if not)
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.087 -0500", hash_original_method = "C61C105C2967FBAB6E5B43A96F13A0DE", hash_generated_method = "2E9AF9C87FAA87A74544BCA5583989C2")
    
public ProxyProperties getProxy() {
        try {
            return mService.getProxy();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * @param networkType The network who's dependence has changed
     * @param met Boolean - true if network use is ok, false if not
     * {@hide}
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.089 -0500", hash_original_method = "9D2F7B8AE7DD2651562BD08E17F617DF", hash_generated_method = "46CF3D7367153193ED8E5B3A5F3ECEAE")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void setDataDependency(int networkType, boolean met) {
        try {
            mService.setDataDependency(networkType, met);
        } catch (RemoteException e) {
        }
    }

    /**
     * Returns true if the hardware supports the given network type
     * else it returns false.  This doesn't indicate we have coverage
     * or are authorized onto a network, just whether or not the
     * hardware supports it.  For example a gsm phone without a sim
     * should still return true for mobile data, but a wifi only tablet
     * would return false.
     * @param networkType The nework type we'd like to check
     * @return true if supported, else false
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.091 -0500", hash_original_method = "A6B9FE53FCB83D066C3DAD2A2CD2AA6D", hash_generated_method = "4A0CA3D82DAD09F68F1F4B54C3FB9B45")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean isNetworkSupported(int networkType) {
        try {
            return mService.isNetworkSupported(networkType);
        } catch (RemoteException e) {}
        return false;
    }
    @DSVerified
    @DSSpec(DSCat.NETWORK)
    public boolean isActiveNetworkMetered() {
        return getTaintBoolean();
    }
        
}

