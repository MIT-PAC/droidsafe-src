/*
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

package android.net.wifi;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pDevice;
import android.util.Log;

import java.io.InputStream;
import java.lang.Process;
import java.util.ArrayList;
import java.util.List;

/**
 * Native calls for sending requests to the supplicant daemon, and for
 * receiving asynchronous events. All methods of the form "xxxxCommand()"
 * must be single-threaded, to avoid requests and responses initiated
 * from multiple threads from being intermingled.
 * <p/>
 * Note that methods whose names are not of the form "xxxCommand()" do
 * not talk to the supplicant daemon.
 * Also, note that all WifiNative calls should happen in the
 * WifiStateTracker class except for waitForEvent() call which is
 * on a separate monitor channel for WifiMonitor
 *
 * TODO: clean up the API and move the functionality from JNI to here. We should
 * be able to get everything done with doBooleanCommand, doIntCommand and
 * doStringCommand native commands
 *
 * {@hide}
 */
public class WifiNative {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.609 -0400", hash_original_field = "D491FAC8AFA55800E880CE4BDF844E4F", hash_generated_field = "196842DE634A857B79C7A27754006F40")


    static final int BLUETOOTH_COEXISTENCE_MODE_ENABLED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.611 -0400", hash_original_field = "5D2EBAB0126511AB5153AA94C559A2BE", hash_generated_field = "2EAAD2054DEB313FE2D24C128BAAEDD1")

    static final int BLUETOOTH_COEXISTENCE_MODE_DISABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.612 -0400", hash_original_field = "37BC409B0F7AEC435B00D92E4C3E43B5", hash_generated_field = "3DBC7584AA96D18E32C7F5DDF1B2AE47")

    static final int BLUETOOTH_COEXISTENCE_MODE_SENSE = 2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.469 -0400", hash_original_method = "D1B8F575AC734282ABB979C20EC6B537", hash_generated_method = "BFEE1A7165C05BCE7710145BAB73FE2E")
    
    public static String getErrorString(int errorCode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += errorCode;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.374 -0400", hash_original_method = "39DCFC1582517FA4E303D5BE244931DB", hash_generated_method = "8BE1689918F7031C416EACC24E00B6C4")
    
    public static boolean loadDriver(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.377 -0400", hash_original_method = "88A5F2FF82493D52EB9119CA317D3580", hash_generated_method = "9D01F5D917174F43A47160216A82653A")
    
    public static boolean isDriverLoaded(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.379 -0400", hash_original_method = "AA9956729CDDEA75EF3CDA9B48AC7516", hash_generated_method = "A1C0583673DED01556F86A0826E69463")
    
    public static boolean unloadDriver(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.382 -0400", hash_original_method = "65C602B599F92E5ADD878013A9F7BBB1", hash_generated_method = "5F9E494B1283DBF2B118508DCA034E91")
    
    public static boolean startSupplicant(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.384 -0400", hash_original_method = "09A9A868580C52FC56B9C7375E36198B", hash_generated_method = "29A77EAD0DDBADCC56DE4C7F131D35B1")
    
    public static boolean startP2pSupplicant(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    /* Does a graceful shutdown of supplicant. Is a common stop function for both p2p and sta.
     *
     * Note that underneath we use a harsh-sounding "terminate" supplicant command
     * for a graceful stop and a mild-sounding "stop" interface
     * to kill the process
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.386 -0400", hash_original_method = "F3C876DD74F33E9CECF242C89ED82239", hash_generated_method = "3907ACD5B181E10767044019512143D3")
    
    public static boolean stopSupplicant(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    /* Sends a kill signal to supplicant. To be used when we have lost connection
       or when the supplicant is hung */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.390 -0400", hash_original_method = "FDBC430C1B6660E61654ED3753DA4474", hash_generated_method = "3E83CEFA60CCC9B6AC847229B4E47BDB")
    
    public static boolean killSupplicant(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.392 -0400", hash_original_method = "A08E67D255841067B3F35F55844EB68A", hash_generated_method = "A24C6CC15E92DDB51210D5F314E426E4")
    
    public static boolean connectToSupplicant(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }






    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.635 -0400", hash_original_method = "0561F1244FBCC9805D1AE0BB60B97B01", hash_generated_method = "0DCFBFD22CC66A3CE57FC05CFE303286")
    
    public static void closeSupplicantConnection(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.397 -0400", hash_original_method = "FC9A66B03EDC591DD9B38410E60AAA0B", hash_generated_method = "575EBCA96DF418DE2A7F2DFD0BCD9A9A")
    
    public static boolean pingCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:04.267 -0400", hash_original_method = "72AA0749EB72637CFB3A4B9EB2F826FD", hash_generated_method = "79412C44C5EBC96089ED825481F0892D")
    
    public static boolean scanCommand(boolean forceActive){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((forceActive) ? 1 : 0);
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:04.270 -0400", hash_original_method = "2F38A905A5E86814C35EEB65CB438D5E", hash_generated_method = "0D0B5F174678A92F10985B712A6C7215")
    
    public static boolean setScanModeCommand(boolean setActive){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((setActive) ? 1 : 0);
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.405 -0400", hash_original_method = "C104A4ABFB47F8E0F75F8F0A91711B00", hash_generated_method = "8A49CBD82C599405157BC1A982CD7B40")
    
    public static String listNetworksCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.408 -0400", hash_original_method = "8ABDCCC5068BBB22F5779016DCEFED65", hash_generated_method = "91F574D72510D6B9566E94434C348BDE")
    
    public static int addNetworkCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.528 -0400", hash_original_method = "62C469AB2099DB2DDDEDE0E4E915570A", hash_generated_method = "53DEBA88E6B48B553A63824E1A4CB7A9")
    
    public static boolean setNetworkVariableCommand(int netId, String name, String value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += netId;
    	taintDouble += name.getTaintInt();
    	taintDouble += value.getTaintInt();
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.532 -0400", hash_original_method = "20E6FA949E812E59820FE7A0261ACF46", hash_generated_method = "E8AA6FB377CCDE04AD82ADA08326A697")
    
    public static String getNetworkVariableCommand(int netId, String name){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += netId;
    	taintDouble += name.getTaintInt();
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.535 -0400", hash_original_method = "40E2857B88A00DD8870F1A19BA56D550", hash_generated_method = "6432931124376EBB104E9B98EF1CF591")
    
    public static boolean removeNetworkCommand(int netId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += netId;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:04.286 -0400", hash_original_method = "4DFC85118F05814AB27D9083EFBC6940", hash_generated_method = "7DCBB2910A81E776757970F711CCDB28")
    
    public static boolean enableNetworkCommand(int netId, boolean disableOthers){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += netId;
    	taintDouble += ((disableOthers) ? 1 : 0);
    
    	return ((taintDouble) == 1);
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.543 -0400", hash_original_method = "4307E51DC423CE1BAC6B97E15C5D1C4A", hash_generated_method = "9877899ED403165DDF0C45CDE0153220")
    
    public static boolean disableNetworkCommand(int netId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += netId;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.425 -0400", hash_original_method = "1FD932A179999665DABCE38CECB75BAA", hash_generated_method = "5409B7E260D2EFF5BB62F9C967BABDFF")
    
    public static boolean reconnectCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.427 -0400", hash_original_method = "68B95C89E867212A4A8009D3C4904C53", hash_generated_method = "E2DBEA1DC60D471EE38FC58CEC7D5771")
    
    public static boolean reassociateCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.429 -0400", hash_original_method = "CF640EE72943F14AB767D880DA6571A7", hash_generated_method = "B0648D52AD8998096DD88F35C1D4153C")
    
    public static boolean disconnectCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.432 -0400", hash_original_method = "33E79C141DA6BAC5AB89BF248B2B71FA", hash_generated_method = "E65225020E4ABF61E62BA1FB15CFE2E8")
    
    public static String statusCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.435 -0400", hash_original_method = "69DFE6488E4E1095ED955C498CAF3E20", hash_generated_method = "26A15C1C765EE269E3F8338945CC3FE4")
    
    public static String getMacAddressCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.438 -0400", hash_original_method = "FB10554031D1BCD284B50199483C1FBD", hash_generated_method = "FEDA725AF6571E04608EDC1D440697C2")
    
    public static String scanResultsCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.441 -0400", hash_original_method = "1010518D3DB50B5D3F092DFF8F5EA0A4", hash_generated_method = "654DD58672DC42C6BDE5C6ADE3A22CF1")
    
    public static boolean startDriverCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.443 -0400", hash_original_method = "785B6669B1EBFDF364345CEACA41D1F4", hash_generated_method = "DECFBB1984C3825B5C4818DFF9F65011")
    
    public static boolean stopDriverCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }



    /**
     * Start filtering out Multicast V4 packets
     * @return {@code true} if the operation succeeded, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.446 -0400", hash_original_method = "F49684A75109FDCC32824B1251106CA5", hash_generated_method = "B334C1BCE41B7EA41FEBDF2AFAE499EF")
    
    public static boolean startFilteringMulticastV4Packets(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    /**
     * Stop filtering out Multicast V4 packets.
     * @return {@code true} if the operation succeeded, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.448 -0400", hash_original_method = "6B1695BB3639B4DC9DF8C7FE916CF44D", hash_generated_method = "7868EEA8931B795FB4B15250D9317781")
    
    public static boolean stopFilteringMulticastV4Packets(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    /**
     * Start filtering out Multicast V6 packets
     * @return {@code true} if the operation succeeded, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.451 -0400", hash_original_method = "D583F34426D06300D408364E03C0042E", hash_generated_method = "218FD4CC6F97D8074ED8850635651530")
    
    public static boolean startFilteringMulticastV6Packets(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    /**
     * Stop filtering out Multicast V6 packets.
     * @return {@code true} if the operation succeeded, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.453 -0400", hash_original_method = "E01A9375EF3E05D6840F4E3FB44E9B7F", hash_generated_method = "1610E441C16EF19AF21A1F0C5706B95F")
    
    public static boolean stopFilteringMulticastV6Packets(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.594 -0400", hash_original_method = "45C4A93D9DB00E5177EB1AA33C0FC790", hash_generated_method = "A67AFB0821ABBDFC1442B7AD04AF9F51")
    
    public static boolean setPowerModeCommand(int mode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += mode;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.459 -0400", hash_original_method = "83F3538632BF73896EB15A683899A7FF", hash_generated_method = "EA5B209910E5170099228440681166CF")
    
    public static int getBandCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.602 -0400", hash_original_method = "2C13F5CAE2C3F5ED8EB78A310FFF5923", hash_generated_method = "63CAA9B4D44623D32629ABB156F7399E")
    
    public static boolean setBandCommand(int band){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += band;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.465 -0400", hash_original_method = "9CC8B120186AE03A9FB33A49510BBC39", hash_generated_method = "619EFEB69CAA8FB75912A1F41AF553B4")
    
    public static int getPowerModeCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }




    /**
     * Sets the bluetooth coexistence mode.
     *
     * @param mode One of {@link #BLUETOOTH_COEXISTENCE_MODE_DISABLED},
     *            {@link #BLUETOOTH_COEXISTENCE_MODE_ENABLED}, or
     *            {@link #BLUETOOTH_COEXISTENCE_MODE_SENSE}.
     * @return Whether the mode was successfully set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.609 -0400", hash_original_method = "DFE54105E8001C1E3B6420D01EDFF512", hash_generated_method = "13FCB488EDCCF2CA3F79B94327907F73")
    
    public static boolean setBluetoothCoexistenceModeCommand(int mode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += mode;
    
    	return ((taintDouble) == 1);
    }

    /**
     * Enable or disable Bluetooth coexistence scan mode. When this mode is on,
     * some of the low-level scan parameters used by the driver are changed to
     * reduce interference with A2DP streaming.
     *
     * @param isSet whether to enable or disable this mode
     * @return {@code true} if the command succeeded, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:04.336 -0400", hash_original_method = "B5C77B564C22F256B45BF15884EBA767", hash_generated_method = "756FAFD3079502B82AD701BA5C5E4B99")
    
    public static boolean setBluetoothCoexistenceScanModeCommand(boolean setCoexScanMode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((setCoexScanMode) ? 1 : 0);
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.472 -0400", hash_original_method = "313E1346BB4C2A661F225A135DCC1B61", hash_generated_method = "5E27901655B27A16747212CDEEA7F56E")
    
    public static boolean saveConfigCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.475 -0400", hash_original_method = "B63840930B6626D35472386FC24C2FE8", hash_generated_method = "781867B7E3168F50871545BB74185B63")
    
    public static boolean reloadConfigCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.625 -0400", hash_original_method = "50195E0ECC284C69A333E6DB10A393A7", hash_generated_method = "AE169DE1E9798E1BE92F6E28DC194B3F")
    
    public static boolean setScanResultHandlingCommand(int mode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += mode;
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.628 -0400", hash_original_method = "640D2755ED806484D55C588F11F80004", hash_generated_method = "C727CA6A408327EA311C09973186FF62")
    
    public static boolean addToBlacklistCommand(String bssid){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bssid.getTaintInt();
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.483 -0400", hash_original_method = "E78BE117D2BFD149ECDA4C37949EB819", hash_generated_method = "42AD052F23E4D7B232B6640352218870")
    
    public static boolean clearBlacklistCommand(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }




    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.635 -0400", hash_original_method = "B9EBE7457CA29780A2B9346CFF144EEE", hash_generated_method = "57431188275611CE6B0587B5D9A69574")
    
    public static boolean startWpsPbcCommand(String bssid){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bssid.getTaintInt();
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.640 -0400", hash_original_method = "9FB61C8A86E193C57D9F227225502DE9", hash_generated_method = "5F0D405B9D59E6C813CF461E0C821AC6")
    
    public static boolean startWpsWithPinFromAccessPointCommand(String bssid, String apPin){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bssid.getTaintInt();
    	taintDouble += apPin.getTaintInt();
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.644 -0400", hash_original_method = "5F72BEC8B6356C9BAF2AEACA3DC3ABDB", hash_generated_method = "7A08DA674E952A1D86D89EFFEF55C3C7")
    
    public static String startWpsWithPinFromDeviceCommand(String bssid){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += bssid.getTaintInt();
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:04.360 -0400", hash_original_method = "43D61D7324B728BB328C9BAEC9DE09DD", hash_generated_method = "0799008F617B5F3041A89AAF0A445C69")
    
    public static boolean setSuspendOptimizationsCommand(boolean enabled){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((enabled) ? 1 : 0);
    
    	return ((taintDouble) == 1);
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.652 -0400", hash_original_method = "323D3A6C48A6D472DDFE2721C7FED43F", hash_generated_method = "9B8474327C39F7658DB849B205974B0F")
    
    public static boolean setCountryCodeCommand(String countryCode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += countryCode.getTaintInt();
    
    	return ((taintDouble) == 1);
    }

    /**
     * Wait for the supplicant to send an event, returning the event string.
     * @return the event string sent by the supplicant.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:54.500 -0400", hash_original_method = "31B90A45F9451B6FAB059CF68DCF26BD", hash_generated_method = "8CE24A3E847DEC6B396A5F750249816F")
    
    public static String waitForEvent(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }





    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:56.528 -0400", hash_original_method = "F89A34D713842A86D7D2FE41C9EFB947", hash_generated_method = "1FA3B218840BDA2911BD57E9C8F26C68")
    
    public static void enableBackgroundScanCommand(boolean enable){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:06:56.532 -0400", hash_original_method = "5B1409DBB9819BF8679BCBE8060A95EA", hash_generated_method = "924377A029EEC40E018C4405169438D9")
    
    public static void setScanIntervalCommand(int scanInterval){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.668 -0400", hash_original_method = "3572479FA0526880B7682F89388F5ECA", hash_generated_method = "39C716F918385A9F3482EB744B20B2BC")
    
    private static boolean doBooleanCommand(String command){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += command.getTaintInt();
    
    	return ((taintDouble) == 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.672 -0400", hash_original_method = "8474BAED7558CBF89B1F1938F5BA33D0", hash_generated_method = "0472702462C31BB608AA62D1A05BF39E")
    
    private static int doIntCommand(String command){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += command.getTaintInt();
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:32.675 -0400", hash_original_method = "5D47FC4B54A45FEF7ECD67C2781450B0", hash_generated_method = "F13E6B03F6B2AE7B86953CE558B1893F")
    
    private static String doStringCommand(String command){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += command.getTaintInt();
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }




    /** Example output:
     * RSSI=-65
     * LINKSPEED=48
     * NOISE=9999
     * FREQUENCY=0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.737 -0400", hash_original_method = "92AD08E60042E3A3AB4EAFAA413A4446", hash_generated_method = "98747B73D26BF7E8C67C5D40BBA28F1C")
    
public static String signalPoll() {
        return doStringCommand("SIGNAL_POLL");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.738 -0400", hash_original_method = "674F3220A027F664E3CC769513EB6159", hash_generated_method = "3E4EC4DD0ED24AF2DEE6FEBB26DA4694")
    
public static boolean wpsPbc() {
        return doBooleanCommand("WPS_PBC");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.740 -0400", hash_original_method = "22576B7CB4CBDD2F29125ADAF4FBDB9D", hash_generated_method = "D46C08549DD0CE6A371715304FAC40E2")
    
public static boolean wpsPin(String pin) {
        return doBooleanCommand("WPS_PIN any " + pin);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.741 -0400", hash_original_method = "D5FCA41ECB7C27515F83AC06E3FCD264", hash_generated_method = "27B1316801A522DD95238AA581B31B72")
    
public static boolean setPersistentReconnect(boolean enabled) {
        int value = (enabled == true) ? 1 : 0;
        return WifiNative.doBooleanCommand("SET persistent_reconnect " + value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.743 -0400", hash_original_method = "4293246E740DB8C629A2D3EBFE0428C6", hash_generated_method = "E3438CE2704878651CDCCDDCB712817F")
    
public static boolean setDeviceName(String name) {
        return WifiNative.doBooleanCommand("SET device_name " + name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.745 -0400", hash_original_method = "DB774CE438E3FAA953563B69E01B505A", hash_generated_method = "3F7EE21AF5BBBACA411762F6FB06015A")
    
public static boolean setDeviceType(String type) {
        return WifiNative.doBooleanCommand("SET device_type " + type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.747 -0400", hash_original_method = "A8E4B2A136E2E3E73482420CF93F3C7B", hash_generated_method = "132D426D0012345C5F363A05245B72F6")
    
public static boolean p2pFind() {
        return doBooleanCommand("P2P_FIND");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.748 -0400", hash_original_method = "D2848B1AEF9394A2FF6636ED858AA657", hash_generated_method = "C2947C3EF5CA7C51920E62D424AA5102")
    
public static boolean p2pFind(int timeout) {
        if (timeout <= 0) {
            return p2pFind();
        }
        return doBooleanCommand("P2P_FIND " + timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.750 -0400", hash_original_method = "D4F2DBBEF79EED8C5792042C82D0B53B", hash_generated_method = "0DFEC934B72C277E4BF26E8D646E3574")
    
public static boolean p2pListen() {
        return doBooleanCommand("P2P_LISTEN");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.752 -0400", hash_original_method = "5C8CD70BE62D521B24A9A3631679258A", hash_generated_method = "97702F96842904162B431B1ADAE7BC37")
    
public static boolean p2pListen(int timeout) {
        if (timeout <= 0) {
            return p2pListen();
        }
        return doBooleanCommand("P2P_LISTEN " + timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.753 -0400", hash_original_method = "53C9E871BD5421E69AACFA7BA1200BC1", hash_generated_method = "03BA14E674E8C6A20F53E4BFE07705D6")
    
public static boolean p2pFlush() {
        return doBooleanCommand("P2P_FLUSH");
    }

    /* p2p_connect <peer device address> <pbc|pin|PIN#> [label|display|keypad]
        [persistent] [join|auth] [go_intent=<0..15>] [freq=<in MHz>] */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.755 -0400", hash_original_method = "6CE719C205449F0EA4502B7666A015C0", hash_generated_method = "598EFFAE1DD0E9452464135FF7EE1426")
    
public static String p2pConnect(WifiP2pConfig config, boolean joinExistingGroup) {
        if (config == null) return null;
        List<String> args = new ArrayList<String>();
        WpsInfo wps = config.wps;
        args.add(config.deviceAddress);

        switch (wps.setup) {
            case WpsInfo.PBC:
                args.add("pbc");
                break;
            case WpsInfo.DISPLAY:
                //TODO: pass the pin back for display
                args.add("pin");
                args.add("display");
                break;
            case WpsInfo.KEYPAD:
                args.add(wps.pin);
                args.add("keypad");
                break;
            case WpsInfo.LABEL:
                args.add(wps.pin);
                args.add("label");
            default:
                break;
        }

        //TODO: Add persist behavior once the supplicant interaction is fixed for both
        // group and client scenarios
        /* Persist unless there is an explicit request to not do so*/
        //if (config.persist != WifiP2pConfig.Persist.NO) args.add("persistent");

        if (joinExistingGroup) args.add("join");

        int groupOwnerIntent = config.groupOwnerIntent;
        if (groupOwnerIntent < 0 || groupOwnerIntent > 15) {
            groupOwnerIntent = 3; //default value
        }
        args.add("go_intent=" + groupOwnerIntent);

        String command = "P2P_CONNECT ";
        for (String s : args) command += s + " ";

        return doStringCommand(command);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.757 -0400", hash_original_method = "5C4A28D52E6A1FCAEF248852AD9098B4", hash_generated_method = "053CEB2A50DF7205F7DB40C08EDFA7D8")
    
public static boolean p2pCancelConnect() {
        return doBooleanCommand("P2P_CANCEL");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.759 -0400", hash_original_method = "6761C0FD850C22DC2CA5EA8C4E288FC0", hash_generated_method = "79132CFFCE1485E559C26CD03790D1AF")
    
public static boolean p2pGroupAdd() {
        return doBooleanCommand("P2P_GROUP_ADD");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.760 -0400", hash_original_method = "C9565CEBA82AF4DE2BA6754D37FE62BA", hash_generated_method = "DFD0D84753E6E6D4A1047E836018FE0F")
    
public static boolean p2pGroupRemove(String iface) {
        if (iface == null) return false;
        return doBooleanCommand("P2P_GROUP_REMOVE " + iface);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.762 -0400", hash_original_method = "914EA4A8E991D8264ED28E04E9470D70", hash_generated_method = "97C5298B7C6AAA52DE539A109CB9F77B")
    
public static boolean p2pReject(String deviceAddress) {
        return doBooleanCommand("P2P_REJECT " + deviceAddress);
    }

    /* Invite a peer to a group */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.764 -0400", hash_original_method = "125C9FCB48CFB302EC02E50FAFEC89ED", hash_generated_method = "5DD52EF1CA3D1FA1987B53DA941623F2")
    
public static boolean p2pInvite(WifiP2pGroup group, String deviceAddress) {
        if (deviceAddress == null) return false;

        if (group == null) {
            return doBooleanCommand("P2P_INVITE peer=" + deviceAddress);
        } else {
            return doBooleanCommand("P2P_INVITE group=" + group.getInterface()
                    + " peer=" + deviceAddress + " go_dev_addr=" + group.getOwner().deviceAddress);
        }
    }

    /* Reinvoke a persistent connection */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.765 -0400", hash_original_method = "333132ED929A42A001D72A5CABDECB0D", hash_generated_method = "83E11547AB034F739098DE0B03C0B808")
    
public static boolean p2pReinvoke(int netId, String deviceAddress) {
        if (deviceAddress == null || netId < 0) return false;

        return doBooleanCommand("P2P_INVITE persistent=" + netId + " peer=" + deviceAddress);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.767 -0400", hash_original_method = "1658E52C53470E8302B0743420909EB5", hash_generated_method = "719E7D5EE697ECE522D6BCE6BA055ADC")
    
public static String p2pGetInterfaceAddress(String deviceAddress) {
        if (deviceAddress == null) return null;

        //  "p2p_peer deviceAddress" returns a multi-line result containing
        //      intended_addr=fa:7b:7a:42:82:13
        String peerInfo = p2pPeer(deviceAddress);
        if (peerInfo == null) return null;
        String[] tokens= peerInfo.split("\n");

        for (String token : tokens) {
            //TODO: update from interface_addr when wpa_supplicant implementation is fixed
            if (token.startsWith("intended_addr=")) {
                String[] nameValue = token.split("=");
                if (nameValue.length != 2) break;
                return nameValue[1];
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.769 -0400", hash_original_method = "9FF05757CE6DD20F76179D4C2EC884D7", hash_generated_method = "C8A6940B97DA8E4160CF83CF091E1F79")
    
public static String p2pGetDeviceAddress() {
        String status = statusCommand();
        if (status == null) return "";

        String[] tokens = status.split("\n");
        for (String token : tokens) {
            if (token.startsWith("p2p_device_address=")) {
                String[] nameValue = token.split("=");
                if (nameValue.length != 2) break;
                return nameValue[1];
            }
        }
        return "";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.771 -0400", hash_original_method = "68B474E3F1F19628AE4EA133A84164B6", hash_generated_method = "D5E11FFCBA9A6E0F825D057FD8A7FD71")
    
public static String p2pPeer(String deviceAddress) {
        return doStringCommand("P2P_PEER " + deviceAddress);
    }
}
