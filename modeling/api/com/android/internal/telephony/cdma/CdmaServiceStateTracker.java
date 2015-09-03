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
 * Copyright (C) 2012 The Android Open Source Project
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.app.AlarmManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Telephony.Intents;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.TimeUtils;

import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.telephony.TelephonyProperties;

public class CdmaServiceStateTracker extends ServiceStateTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.395 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.403 -0500", hash_original_field = "535CAC5262F15A4B4744ED2F769E6AC0", hash_generated_field = "67F82722D9B3E1632BEE93AB01A1C764")

    private static final String UNACTIVATED_MIN2_VALUE = "000000";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.406 -0500", hash_original_field = "362C31D88043B483EBF07427CB11CFF4", hash_generated_field = "E8B0DB0F253EC257370D59DB09E2FF20")

    private static final String UNACTIVATED_MIN_VALUE = "1111110111";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.412 -0500", hash_original_field = "B95FFC131B36C07689DD43FAB5F414EC", hash_generated_field = "74B7D3939018D54D4AE0C659740B1204")

    private static final int NITZ_UPDATE_SPACING_DEFAULT = 1000 * 60 * 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.416 -0500", hash_original_field = "08F9049C97D18F0B66E1714767F2B203", hash_generated_field = "D671D393E86B81C1C1E262CE0658A52F")

    private static final int NITZ_UPDATE_DIFF_DEFAULT = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.466 -0500", hash_original_field = "0F876ACCEEC633A27C8C9455ACA51A42", hash_generated_field = "3E784668308EA1C4770734C39504B13F")

    private static final String WAKELOCK_TAG = "ServiceStateTracker";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.397 -0500", hash_original_field = "F2FC592D71DA2BCBED04F0F797B7B907", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.399 -0500", hash_original_field = "1A281DAC68E94EBC3C9265E4C6804ABC", hash_generated_field = "1A281DAC68E94EBC3C9265E4C6804ABC")

    CdmaCellLocation cellLoc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.401 -0500", hash_original_field = "112CC4F0BCF75AC193E83D25A1A12E28", hash_generated_field = "112CC4F0BCF75AC193E83D25A1A12E28")

    CdmaCellLocation newCellLoc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.408 -0500", hash_original_field = "C268A03E211A935F68CB30F65DE990CF", hash_generated_field = "C268A03E211A935F68CB30F65DE990CF")

    int mCurrentOtaspMode = OTASP_UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.414 -0500", hash_original_field = "AEEAB531EE90E7D3EA6BE0998F37FE65", hash_generated_field = "8FA8A33F6DDC8D75DBA6EFF5836E7BA6")

    private int mNitzUpdateSpacing = SystemProperties.getInt("ro.nitz_update_spacing",
            NITZ_UPDATE_SPACING_DEFAULT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.419 -0500", hash_original_field = "64ADF9A0AC681940C385D1D052FDEB0A", hash_generated_field = "A819537E3CEB6132C6CD534B4324860B")

    private int mNitzUpdateDiff = SystemProperties.getInt("ro.nitz_update_diff",
            NITZ_UPDATE_DIFF_DEFAULT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.421 -0500", hash_original_field = "D1A690B4C2963894269B8988EC69259E", hash_generated_field = "2254D45123DBAABDA74A70C8825DF7C5")

    protected int networkType = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.423 -0500", hash_original_field = "D0FD1424D30CCBA174A4E14E08D62946", hash_generated_field = "09A6CDB7CC734BA27C3A1ED81C96ED19")

    protected int newNetworkType = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.425 -0500", hash_original_field = "D158F8D61C2C829B4D18E614B1356A2E", hash_generated_field = "608A719DA0321C304B26B483F08AA8A5")

    private boolean mCdmaRoaming = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.428 -0500", hash_original_field = "6B45D71C85146A160D302F25109C9229", hash_generated_field = "08036C3C13314229BA2FC25470511F82")

    private int mRoamingIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.430 -0500", hash_original_field = "AB6B819F4504C5A21FFA8331C6AD293D", hash_generated_field = "4EA0EC8E3E2882B499B7BDCFF794E5F5")

    private boolean mIsInPrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.432 -0500", hash_original_field = "379888F67374A96D9828BC0E26879B98", hash_generated_field = "78D9E7B3C682DFCD1DCE797D9FCC238E")

    private int mDefaultRoamingIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.435 -0500", hash_original_field = "AB76C50DC7F4F5269960D79C66F69967", hash_generated_field = "FE2191FF26651B4CE149D535F21B2DAC")

    protected int mDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.437 -0500", hash_original_field = "77B0A218C795CD7ECDEFC8CC232C1E12", hash_generated_field = "54950431EC1A81B46E3B586A8FF192E6")

    protected int mNewDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.439 -0500", hash_original_field = "2AA77916AD049017D84CF85605DA11BA", hash_generated_field = "6833B331C88851685D637C397C325D06")

    protected int mRegistrationState = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.441 -0500", hash_original_field = "A017027FCA4060A5D7BA13A91BCCBEB4", hash_generated_field = "DA7A96044F3831CDD3E9F5AB50677517")

    protected RegistrantList cdmaForSubscriptionInfoReadyRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.443 -0500", hash_original_field = "94B5B9AC89B232E32297041934866E02", hash_generated_field = "15E4D1DE2B58A497BF813FB4D9666469")

    protected boolean mNeedFixZone = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.445 -0500", hash_original_field = "DC1A5CAE762F1B565AB4AF08E4221FD7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.448 -0500", hash_original_field = "1DBF7B28B2EC0A77610B942EE7357647", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.451 -0500", hash_original_field = "D1947C20B8C2350EE6EF3BB9DCA678E9", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.453 -0500", hash_original_field = "287A0704804B91F0A9E2C49E33166DCA", hash_generated_field = "4E375AF9C401CE06580F194AE87749C8")

    protected boolean mGotCountryCode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.455 -0500", hash_original_field = "30A17FCDED9983DC17E4B0241936D019", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.457 -0500", hash_original_field = "56DFA99AB6C2048EFF6A2B28FFEF5620", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.459 -0500", hash_original_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.462 -0500", hash_original_field = "45914F86AD7F1B132512F8115ACF9117", hash_generated_field = "CCE24EE182EA5616F66D6BDEF1A52E90")

    private boolean mNeedToRegForRuimLoaded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.464 -0500", hash_original_field = "87068C2348540A5517D7F6F40E0F6E43", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.468 -0500", hash_original_field = "5F503B9090E295FAFA26274CB8794AEC", hash_generated_field = "1DC5D4A83EC6372807837FD2589E7AC2")

    protected String mCurPlmn = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.471 -0500", hash_original_field = "F939B70A20B3468E438996CCAF7003FB", hash_generated_field = "B709DEC8C3A1F430EB7B11AA6EE2EC2C")

    protected String mMdn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.473 -0500", hash_original_field = "4EE910A79952F9BBA4D8D5717133AD29", hash_generated_field = "9E7F4F352D9BD51BA557A4D6106F3396")

    protected int mHomeSystemId[] = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.475 -0500", hash_original_field = "9532FEB064A80B962A796CDEC480B497", hash_generated_field = "FFCC16392D86F43DB3487C9739E54F95")

    protected int mHomeNetworkId[] = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.477 -0500", hash_original_field = "E44A760A77DC0C3CB0AE7F76163013F3", hash_generated_field = "08259C9A6FC8D318A401FBBE53AFEB88")

    protected String mMin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.480 -0500", hash_original_field = "775B97E2DA5E3B7BF3E02721DEBBB726", hash_generated_field = "750BD22734A2BF0B542BDCBA0D5DD4FA")

    protected String mPrlVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.483 -0500", hash_original_field = "8BA08194B6257B9D404019B421B869DE", hash_generated_field = "F9833AA7D1D680BFE701856BF633E8CF")

    protected boolean mIsMinInfoReady = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.485 -0500", hash_original_field = "E1AB6AC5AF5D528FBDB49F75729E1E0C", hash_generated_field = "D6E8E3B7AD5D24A742CC13AA70A64F63")

    private boolean isEriTextLoaded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.487 -0500", hash_original_field = "6E8D6E0E3221FE67C705760F8E221A5A", hash_generated_field = "EBB4A27CD6CDA92F928E719D02425A52")

    protected boolean isSubscriptionFromRuim = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.489 -0500", hash_original_field = "D9D3D1AFC2DA9380A1F016875140F7F4", hash_generated_field = "B4AF510D630F6D0ABA0DA5E3978D4F1B")

    private String mRegistrationDeniedReason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.491 -0500", hash_original_field = "00C84AE608A40C700303777F958158E6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.493 -0500", hash_original_field = "7446650635EB4A76D52B07A96F8B248F", hash_generated_field = "7317EA2E3861B648BD5D2085310B5F7A")

    private String currentCarrier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_field = "11E7010812F1C4E8B149974C6F93DD15", hash_generated_field = "3DB856DB274FA4CFDAF726CF9C6DE586")

    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_method = "6B8D04F75A24E09E038AB230F1FA031E", hash_generated_method = "172CE0A53ECBD305539544F2E56D2E30")
        @Override
        public void onChange(boolean selfChange) {
            
            log("Auto time state changed");
            revertToNitzTime();
            addTaint(selfChange);
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.330 -0400", hash_original_field = "5FB03C4834787FF054B0ABAC3DB94EDA", hash_generated_field = "46087C315DFAC870959E9567F3E3929A")

    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.330 -0400", hash_original_method = "8FD17110C48D1CBE2477FC41B8E67E94", hash_generated_method = "937331EFFBE00AA83A94C8B5D850F5AD")
        @Override
        public void onChange(boolean selfChange) {
            
            log("Auto time zone state changed");
            revertToNitzTimeZone();
            addTaint(selfChange);
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.516 -0500", hash_original_method = "FF3701A2004D17249B7B4B59CF4365CF", hash_generated_method = "4628074FDA0E812DBA33BCE642B72D7F")
    
public CdmaServiceStateTracker(CDMAPhone phone) {
        super();

        this.phone = phone;
        cr = phone.getContext().getContentResolver();
        cm = phone.mCM;
        ss = new ServiceState();
        newSS = new ServiceState();
        cellLoc = new CdmaCellLocation();
        newCellLoc = new CdmaCellLocation();
        mSignalStrength = new SignalStrength();

        PowerManager powerManager =
                (PowerManager)phone.getContext().getSystemService(Context.POWER_SERVICE);
        mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, WAKELOCK_TAG);

        cm.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForRadioStateChanged(this, EVENT_RADIO_STATE_CHANGED, null);

        cm.registerForVoiceNetworkStateChanged(this, EVENT_NETWORK_STATE_CHANGED_CDMA, null);
        cm.setOnNITZTime(this, EVENT_NITZ_TIME, null);
        cm.setOnSignalStrengthUpdate(this, EVENT_SIGNAL_STRENGTH_UPDATE, null);

        cm.registerForRUIMReady(this, EVENT_RUIM_READY, null);

        cm.registerForNVReady(this, EVENT_NV_READY, null);
        phone.registerForEriFileLoaded(this, EVENT_ERI_FILE_LOADED, null);
        cm.registerForCdmaOtaProvision(this,EVENT_OTA_PROVISION_STATUS_CHANGE, null);

        // System setting property AIRPLANE_MODE_ON is set in Settings.
        int airplaneMode = Settings.System.getInt(cr, Settings.System.AIRPLANE_MODE_ON, 0);
        mDesiredPowerState = ! (airplaneMode > 0);

        cr.registerContentObserver(
                Settings.System.getUriFor(Settings.System.AUTO_TIME), true,
                mAutoTimeObserver);
        cr.registerContentObserver(
            Settings.System.getUriFor(Settings.System.AUTO_TIME_ZONE), true,
            mAutoTimeZoneObserver);
        setSignalStrengthDefaultValues();

        mNeedToRegForRuimLoaded = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.519 -0500", hash_original_method = "4D5D490C37798965D77553069E20CD07", hash_generated_method = "880FD5C634273DF78A1A23594F1D886D")
    
public void dispose() {
        // Unregister for all events.
        cm.unregisterForAvailable(this);
        cm.unregisterForRadioStateChanged(this);
        cm.unregisterForVoiceNetworkStateChanged(this);
        cm.unregisterForRUIMReady(this);
        cm.unregisterForNVReady(this);
        cm.unregisterForCdmaOtaProvision(this);
        phone.unregisterForEriFileLoaded(this);
        phone.mIccRecords.unregisterForRecordsLoaded(this);
        cm.unSetOnSignalStrengthUpdate(this);
        cm.unSetOnNITZTime(this);
        cr.unregisterContentObserver(mAutoTimeObserver);
        cr.unregisterContentObserver(mAutoTimeZoneObserver);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.521 -0500", hash_original_method = "BA9FDB49D0B6CB52D4E369B5C2B6B17A", hash_generated_method = "DA3CD7D1AB48FA88096B8E363EFA84BC")
    
@Override
    protected void finalize() {
        if (DBG) log("CdmaServiceStateTracker finalized");
    }

    /**
     * Registration point for subscription info ready
     * @param h handler to notify
     * @param what what code of message when delivered
     * @param obj placed in Message.obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.524 -0500", hash_original_method = "70290EDA16C74DFE014583BB384DB8B5", hash_generated_method = "D006D022DAB7BE66F8C47C3ADEED93D6")
    
public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        Registrant r = new Registrant(h, what, obj);
        cdmaForSubscriptionInfoReadyRegistrants.add(r);

        if (isMinInfoReady()) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.527 -0500", hash_original_method = "19125607721EAC24124C4D5516B60F75", hash_generated_method = "66BD5A1E7B1D52441B4DD22D6BC883C8")
    
public void unregisterForSubscriptionInfoReady(Handler h) {
        cdmaForSubscriptionInfoReadyRegistrants.remove(h);
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.532 -0500", hash_original_method = "754E8D2400977D5A28AAECFFE4ABD510", hash_generated_method = "A5071E1E917C254C16D2A3D3379166BF")
    
@Override
    public void handleMessage (Message msg) {
        AsyncResult ar;
        int[] ints;
        String[] strings;

        switch (msg.what) {
        case EVENT_RADIO_AVAILABLE:
            if (DBG) log("handleMessage: EVENT_RADIO_AVAILABLE");
            break;

        case EVENT_RUIM_READY:
            // TODO: Consider calling setCurrentPreferredNetworkType as we do in GsmSST.
            // cm.setCurrentPreferredNetworkType();

            // The RUIM is now ready i.e if it was locked it has been
            // unlocked. At this stage, the radio is already powered on.
            isSubscriptionFromRuim = true;
            if (mNeedToRegForRuimLoaded) {
                phone.mIccRecords.registerForRecordsLoaded(this,
                        EVENT_RUIM_RECORDS_LOADED, null);
                mNeedToRegForRuimLoaded = false;
            }

            cm.getCDMASubscription(obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
            if (DBG) log("handleMessage: EVENT_RUIM_READY, Send Request getCDMASubscription.");

            // Restore the previous network selection.
            pollState();

            // Signal strength polling stops when radio is off.
            queueNextSignalStrengthPoll();
            break;

        case EVENT_NV_READY:
            // TODO: Consider calling setCurrentPreferredNetworkType as we do in GsmSST.
            // cm.setCurrentPreferredNetworkType();

            isSubscriptionFromRuim = false;
            // For Non-RUIM phones, the subscription information is stored in
            // Non Volatile. Here when Non-Volatile is ready, we can poll the CDMA
            // subscription info.
            if (DBG) log("handleMessage: EVENT_NV_READY, Send Request getCDMASubscription.");
            cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
            pollState();
            // Signal strength polling stops when radio is off.
            queueNextSignalStrengthPoll();
            break;

        case EVENT_RADIO_STATE_CHANGED:
            // This will do nothing in the 'radio not available' case.
            setPowerStateToDesired();
            pollState();
            break;

        case EVENT_NETWORK_STATE_CHANGED_CDMA:
            pollState();
            break;

        case EVENT_GET_SIGNAL_STRENGTH:
            // This callback is called when signal strength is polled
            // all by itself.

            if (!(cm.getRadioState().isOn()) || (cm.getRadioState().isGsm())) {
                // Polling will continue when radio turns back on.
                return;
            }
            ar = (AsyncResult) msg.obj;
            onSignalStrengthResult(ar);
            queueNextSignalStrengthPoll();

            break;

        case EVENT_GET_LOC_DONE_CDMA:
            ar = (AsyncResult) msg.obj;

            if (ar.exception == null) {
                String states[] = (String[])ar.result;
                int baseStationId = -1;
                int baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
                int baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                int systemId = -1;
                int networkId = -1;

                if (states.length > 9) {
                    try {
                        if (states[4] != null) {
                            baseStationId = Integer.parseInt(states[4]);
                        }
                        if (states[5] != null) {
                            baseStationLatitude = Integer.parseInt(states[5]);
                        }
                        if (states[6] != null) {
                            baseStationLongitude = Integer.parseInt(states[6]);
                        }
                        // Some carriers only return lat-lngs of 0,0
                        if (baseStationLatitude == 0 && baseStationLongitude == 0) {
                            baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                            baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                        }
                        if (states[8] != null) {
                            systemId = Integer.parseInt(states[8]);
                        }
                        if (states[9] != null) {
                            networkId = Integer.parseInt(states[9]);
                        }
                    } catch (NumberFormatException ex) {
                        loge("error parsing cell location data: " + ex);
                    }
                }

                cellLoc.setCellLocationData(baseStationId, baseStationLatitude,
                        baseStationLongitude, systemId, networkId);
                phone.notifyLocationChanged();
            }

            // Release any temporary cell lock, which could have been
            // acquired to allow a single-shot location update.
            disableSingleLocationUpdate();
            break;

        case EVENT_POLL_STATE_REGISTRATION_CDMA:
        case EVENT_POLL_STATE_OPERATOR_CDMA:
            ar = (AsyncResult) msg.obj;
            handlePollStateResult(msg.what, ar);
            break;

        case EVENT_POLL_STATE_CDMA_SUBSCRIPTION: // Handle RIL_CDMA_SUBSCRIPTION
            ar = (AsyncResult) msg.obj;

            if (ar.exception == null) {
                String cdmaSubscription[] = (String[])ar.result;
                if (cdmaSubscription != null && cdmaSubscription.length >= 5) {
                    mMdn = cdmaSubscription[0];
                    parseSidNid(cdmaSubscription[1], cdmaSubscription[2]);

                    mMin = cdmaSubscription[3];
                    mPrlVersion = cdmaSubscription[4];
                    if (DBG) log("GET_CDMA_SUBSCRIPTION: MDN=" + mMdn);

                    mIsMinInfoReady = true;

                    updateOtaspState();
                    phone.getIccCard().broadcastIccStateChangedIntent(IccCard.INTENT_VALUE_ICC_IMSI,
                            null);
                } else {
                    if (DBG) {
                        log("GET_CDMA_SUBSCRIPTION: error parsing cdmaSubscription params num="
                            + cdmaSubscription.length);
                    }
                }
            }
            break;

        case EVENT_POLL_SIGNAL_STRENGTH:
            // Just poll signal strength...not part of pollState()

            cm.getSignalStrength(obtainMessage(EVENT_GET_SIGNAL_STRENGTH));
            break;

        case EVENT_NITZ_TIME:
            ar = (AsyncResult) msg.obj;

            String nitzString = (String)((Object[])ar.result)[0];
            long nitzReceiveTime = ((Long)((Object[])ar.result)[1]).longValue();

            setTimeFromNITZString(nitzString, nitzReceiveTime);
            break;

        case EVENT_SIGNAL_STRENGTH_UPDATE:
            // This is a notification from CommandsInterface.setOnSignalStrengthUpdate.

            ar = (AsyncResult) msg.obj;

            // The radio is telling us about signal strength changes,
            // so we don't have to ask it.
            dontPollSignalStrength = true;

            onSignalStrengthResult(ar);
            break;

        case EVENT_RUIM_RECORDS_LOADED:
            updateSpnDisplay();
            break;

        case EVENT_LOCATION_UPDATES_ENABLED:
            ar = (AsyncResult) msg.obj;

            if (ar.exception == null) {
                cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE_CDMA, null));
            }
            break;

        case EVENT_ERI_FILE_LOADED:
            // Repoll the state once the ERI file has been loaded.
            if (DBG) log("[CdmaServiceStateTracker] ERI file has been loaded, repolling.");
            pollState();
            break;

        case EVENT_OTA_PROVISION_STATUS_CHANGE:
            ar = (AsyncResult)msg.obj;
            if (ar.exception == null) {
                ints = (int[]) ar.result;
                int otaStatus = ints[0];
                if (otaStatus == Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED
                    || otaStatus == Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED) {
                    if (DBG) log("EVENT_OTA_PROVISION_STATUS_CHANGE: Complete, Reload MDN");
                    cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
                }
            }
            break;

        default:
            super.handleMessage(msg);
        break;
        }
    }

    //***** Private Instance Methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.535 -0500", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "0873B6EA4B620F51FBFEC977103F8350")
    
@Override
    protected void setPowerStateToDesired() {
        // If we want it on and it's off, turn it on
        if (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF) {
            cm.setRadioPower(true, null);
        } else if (!mDesiredPowerState && cm.getRadioState().isOn()) {
            DataConnectionTracker dcTracker = phone.mDataConnectionTracker;

            // If it's on and available and we want it off gracefully
            powerOffRadioSafely(dcTracker);
        } // Otherwise, we're in the desired state
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.537 -0500", hash_original_method = "BDCA4E41D3AB74048D93171255E149A7", hash_generated_method = "4F9F4F4EA1131FE7C3FB81C1A0F7B190")
    
@Override
    protected void updateSpnDisplay() {
        // TODO RUIM SPN is not implemented, EF_SPN has to be read and Display Condition
        //   Character Encoding, Language Indicator and SPN has to be set, something like below:
        // if (cm.getRadioState().isRUIMReady()) {
        //     rule = phone.mRuimRecords.getDisplayRule(ss.getOperatorNumeric());
        //     spn = phone.mSIMRecords.getServiceProvideName();
        // }

        // mOperatorAlphaLong contains the ERI text
        String plmn = ss.getOperatorAlphaLong();
        if (!TextUtils.equals(plmn, mCurPlmn)) {
            // Allow A blank plmn, "" to set showPlmn to true. Previously, we
            // would set showPlmn to true only if plmn was not empty, i.e. was not
            // null and not blank. But this would cause us to incorrectly display
            // "No Service". Now showPlmn is set to true for any non null string.
            boolean showPlmn = plmn != null;
            if (DBG) {
                log(String.format("updateSpnDisplay: changed sending intent" +
                            " showPlmn='%b' plmn='%s'", showPlmn, plmn));
            }
            Intent intent = new Intent(Intents.SPN_STRINGS_UPDATED_ACTION);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
            intent.putExtra(Intents.EXTRA_SHOW_SPN, false);
            intent.putExtra(Intents.EXTRA_SPN, "");
            intent.putExtra(Intents.EXTRA_SHOW_PLMN, showPlmn);
            intent.putExtra(Intents.EXTRA_PLMN, plmn);
            phone.getContext().sendStickyBroadcast(intent);
        }

        mCurPlmn = plmn;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.540 -0500", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "7FA214E5FB8E9E7053C952EA5299E35F")
    
@Override
    protected Phone getPhone() {
        return phone;
    }

    /**
    * Determine data network type based on radio technology.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.542 -0500", hash_original_method = "E924685B280F7636BB1194CB1DB8B328", hash_generated_method = "FC63ADA75F60198194FA0996E438D1D9")
    
protected void setCdmaTechnology(int radioTechnology){
        mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        newNetworkType = radioTechnology;
    }

    /**
    * Hanlde the PollStateResult message
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.548 -0500", hash_original_method = "BE829AA0C3B19F93CC8F98530D925AC3", hash_generated_method = "212B8C2BBD0F15A133396784EADE7D4B")
    
protected void handlePollStateResultMessage(int what, AsyncResult ar){
        int ints[];
        String states[];
        switch (what) {
        case EVENT_POLL_STATE_REGISTRATION_CDMA: // Handle RIL_REQUEST_REGISTRATION_STATE.
            states = (String[])ar.result;

            int registrationState = 4;     //[0] registrationState
            int radioTechnology = -1;      //[3] radioTechnology
            int baseStationId = -1;        //[4] baseStationId
            //[5] baseStationLatitude
            int baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
            //[6] baseStationLongitude
            int baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
            int cssIndicator = 0;          //[7] init with 0, because it is treated as a boolean
            int systemId = 0;              //[8] systemId
            int networkId = 0;             //[9] networkId
            int roamingIndicator = -1;     //[10] Roaming indicator
            int systemIsInPrl = 0;         //[11] Indicates if current system is in PRL
            int defaultRoamingIndicator = 0;  //[12] Is default roaming indicator from PRL
            int reasonForDenial = 0;       //[13] Denial reason if registrationState = 3

            if (states.length >= 14) {
                try {
                    if (states[0] != null) {
                        registrationState = Integer.parseInt(states[0]);
                    }
                    if (states[3] != null) {
                        radioTechnology = Integer.parseInt(states[3]);
                    }
                    if (states[4] != null) {
                        baseStationId = Integer.parseInt(states[4]);
                    }
                    if (states[5] != null) {
                        baseStationLatitude = Integer.parseInt(states[5]);
                    }
                    if (states[6] != null) {
                        baseStationLongitude = Integer.parseInt(states[6]);
                    }
                    // Some carriers only return lat-lngs of 0,0
                    if (baseStationLatitude == 0 && baseStationLongitude == 0) {
                        baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                        baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                    }
                    if (states[7] != null) {
                        cssIndicator = Integer.parseInt(states[7]);
                    }
                    if (states[8] != null) {
                        systemId = Integer.parseInt(states[8]);
                    }
                    if (states[9] != null) {
                        networkId = Integer.parseInt(states[9]);
                    }
                    if (states[10] != null) {
                        roamingIndicator = Integer.parseInt(states[10]);
                    }
                    if (states[11] != null) {
                        systemIsInPrl = Integer.parseInt(states[11]);
                    }
                    if (states[12] != null) {
                        defaultRoamingIndicator = Integer.parseInt(states[12]);
                    }
                    if (states[13] != null) {
                        reasonForDenial = Integer.parseInt(states[13]);
                    }
                } catch (NumberFormatException ex) {
                    loge("EVENT_POLL_STATE_REGISTRATION_CDMA: error parsing: " + ex);
                }
            } else {
                throw new RuntimeException("Warning! Wrong number of parameters returned from "
                                     + "RIL_REQUEST_REGISTRATION_STATE: expected 14 or more "
                                     + "strings and got " + states.length + " strings");
            }

            mRegistrationState = registrationState;
            // When registration state is roaming and TSB58
            // roaming indicator is not in the carrier-specified
            // list of ERIs for home system, mCdmaRoaming is true.
            mCdmaRoaming =
                    regCodeIsRoaming(registrationState) && !isRoamIndForHomeSystem(states[10]);
            newSS.setState (regCodeToServiceState(registrationState));

            setCdmaTechnology(radioTechnology);

            newSS.setCssIndicator(cssIndicator);
            newSS.setSystemAndNetworkId(systemId, networkId);
            mRoamingIndicator = roamingIndicator;
            mIsInPrl = (systemIsInPrl == 0) ? false : true;
            mDefaultRoamingIndicator = defaultRoamingIndicator;

            // Values are -1 if not available.
            newCellLoc.setCellLocationData(baseStationId, baseStationLatitude,
                    baseStationLongitude, systemId, networkId);

            if (reasonForDenial == 0) {
                mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_GEN;
            } else if (reasonForDenial == 1) {
                mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_AUTH;
            } else {
                mRegistrationDeniedReason = "";
            }

            if (mRegistrationState == 3) {
                if (DBG) log("Registration denied, " + mRegistrationDeniedReason);
            }
            break;

        case EVENT_POLL_STATE_OPERATOR_CDMA: // Handle RIL_REQUEST_OPERATOR
            String opNames[] = (String[])ar.result;

            if (opNames != null && opNames.length >= 3) {
                // If the NUMERIC field isn't valid use PROPERTY_CDMA_HOME_OPERATOR_NUMERIC
                if ((opNames[2] == null) || (opNames[2].length() < 5)
                        || ("00000".equals(opNames[2]))) {
                    opNames[2] = SystemProperties.get(
                            CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC, "00000");
                    if (DBG) {
                        log("RIL_REQUEST_OPERATOR.response[2], the numeric, " +
                                " is bad. Using SystemProperties '" +
                                        CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC +
                                "'= " + opNames[2]);
                    }
                }
                if (cm.getNvState().isNVReady()) {
                    // In CDMA in case on NV, the ss.mOperatorAlphaLong is set later with the
                    // ERI text, so here it is ignored what is coming from the modem.
                    newSS.setOperatorName(null, opNames[1], opNames[2]);
                } else {
                    newSS.setOperatorName(opNames[0], opNames[1], opNames[2]);
                }
            } else {
                if (DBG) log("EVENT_POLL_STATE_OPERATOR_CDMA: error parsing opNames");
            }
            break;
        default:
            loge("handlePollStateResultMessage: RIL response handle in wrong phone!"
                    + " Expected CDMA RIL request and get GSM RIL request.");
        break;
        }
    }

    /**
     * Handle the result of one of the pollState() - related requests
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.552 -0500", hash_original_method = "1B5F4BD94220D105FC0E737C13196363", hash_generated_method = "D572663DB0E9861E86A86CD824369BE6")
    
@Override
    protected void handlePollStateResult(int what, AsyncResult ar) {
        // Ignore stale requests from last poll.
        if (ar.userObj != pollingContext) return;

        if (ar.exception != null) {
            CommandException.Error err=null;

            if (ar.exception instanceof CommandException) {
                err = ((CommandException)(ar.exception)).getCommandError();
            }

            if (err == CommandException.Error.RADIO_NOT_AVAILABLE) {
                // Radio has crashed or turned off.
                cancelPollState();
                return;
            }

            if (!cm.getRadioState().isOn()) {
                // Radio has crashed or turned off.
                cancelPollState();
                return;
            }

            if (err != CommandException.Error.OP_NOT_ALLOWED_BEFORE_REG_NW) {
                loge("handlePollStateResult: RIL returned an error where it must succeed"
                        + ar.exception);
            }
        } else try {
            handlePollStateResultMessage(what, ar);
        } catch (RuntimeException ex) {
            loge("handlePollStateResult: Exception while polling service state. "
                    + "Probably malformed RIL response." + ex);
        }

        pollingContext[0]--;

        if (pollingContext[0] == 0) {
            boolean namMatch = false;
            if (!isSidsAllZeros() && isHomeSid(newSS.getSystemId())) {
                namMatch = true;
            }

            // Setting SS Roaming (general)
            if (isSubscriptionFromRuim) {
                newSS.setRoaming(isRoamingBetweenOperators(mCdmaRoaming, newSS));
            } else {
                newSS.setRoaming(mCdmaRoaming);
            }

            // Setting SS CdmaRoamingIndicator and CdmaDefaultRoamingIndicator
            newSS.setCdmaDefaultRoamingIndicator(mDefaultRoamingIndicator);
            newSS.setCdmaRoamingIndicator(mRoamingIndicator);
            boolean isPrlLoaded = true;
            if (TextUtils.isEmpty(mPrlVersion)) {
                isPrlLoaded = false;
            }
            if (!isPrlLoaded) {
                newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
            } else if (!isSidsAllZeros()) {
                if (!namMatch && !mIsInPrl) {
                    // Use default
                    newSS.setCdmaRoamingIndicator(mDefaultRoamingIndicator);
                } else if (namMatch && !mIsInPrl) {
                    newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_FLASH);
                } else if (!namMatch && mIsInPrl) {
                    // Use the one from PRL/ERI
                    newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                } else {
                    // It means namMatch && mIsInPrl
                    if ((mRoamingIndicator <= 2)) {
                        newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
                    } else {
                        // Use the one from PRL/ERI
                        newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                    }
                }
            }

            int roamingIndicator = newSS.getCdmaRoamingIndicator();
            newSS.setCdmaEriIconIndex(phone.mEriManager.getCdmaEriIconIndex(roamingIndicator,
                    mDefaultRoamingIndicator));
            newSS.setCdmaEriIconMode(phone.mEriManager.getCdmaEriIconMode(roamingIndicator,
                    mDefaultRoamingIndicator));

            // NOTE: Some operator may require overriding mCdmaRoaming
            // (set by the modem), depending on the mRoamingIndicator.

            if (DBG) {
                log("Set CDMA Roaming Indicator to: " + newSS.getCdmaRoamingIndicator()
                    + ". mCdmaRoaming = " + mCdmaRoaming + ", isPrlLoaded = " + isPrlLoaded
                    + ". namMatch = " + namMatch + " , mIsInPrl = " + mIsInPrl
                    + ", mRoamingIndicator = " + mRoamingIndicator
                    + ", mDefaultRoamingIndicator= " + mDefaultRoamingIndicator);
            }
            pollStateDone();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.555 -0500", hash_original_method = "6C8071E15167CEBD3E2C13FCDC5BEC69", hash_generated_method = "B1109D0CF24D87A1E199E121D7C8CD4F")
    
protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
    }

    /**
     * A complete "service state" from our perspective is
     * composed of a handful of separate requests to the radio.
     *
     * We make all of these requests at once, but then abandon them
     * and start over again if the radio notifies us that some
     * event has changed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.557 -0500", hash_original_method = "518F03C8AA7D2E41BBC9B0EF8F2349B8", hash_generated_method = "5A7552EC791FF4AAA30DF294A908AC9F")
    
protected void
    pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;

        switch (cm.getRadioState()) {
        case RADIO_UNAVAILABLE:
            newSS.setStateOutOfService();
            newCellLoc.setStateInvalid();
            setSignalStrengthDefaultValues();
            mGotCountryCode = false;

            pollStateDone();
            break;

        case RADIO_OFF:
            newSS.setStateOff();
            newCellLoc.setStateInvalid();
            setSignalStrengthDefaultValues();
            mGotCountryCode = false;

            pollStateDone();
            break;

        case SIM_NOT_READY:
        case SIM_LOCKED_OR_ABSENT:
        case SIM_READY:
            if (DBG) log("Radio Technology Change ongoing, setting SS to off");
            newSS.setStateOff();
            newCellLoc.setStateInvalid();
            setSignalStrengthDefaultValues();
            mGotCountryCode = false;

            // NOTE: pollStateDone() is not needed in this case
            break;

        default:
            // Issue all poll-related commands at once, then count
            // down the responses which are allowed to arrive
            // out-of-order.

            pollingContext[0]++;
            // RIL_REQUEST_OPERATOR is necessary for CDMA
            cm.getOperator(
                    obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));

            pollingContext[0]++;
            // RIL_REQUEST_VOICE_REGISTRATION_STATE is necessary for CDMA
            cm.getVoiceRegistrationState(
                    obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA, pollingContext));

            break;
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.561 -0500", hash_original_method = "E69BA838DECF1BB5E62D048E955B2CB0", hash_generated_method = "D0E1FD49E7000B511C47ACF7A9BBA81E")
    
protected void fixTimeZone(String isoCountryCode) {
        TimeZone zone = null;
        // If the offset is (0, false) and the time zone property
        // is set, use the time zone property rather than GMT.
        String zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
        if ((mZoneOffset == 0) && (mZoneDst == false) && (zoneName != null)
                && (zoneName.length() > 0)
                && (Arrays.binarySearch(GMT_COUNTRY_CODES, isoCountryCode) < 0)) {
            // For NITZ string without time zone,
            // need adjust time to reflect default time zone setting
            zone = TimeZone.getDefault();
            long tzOffset;
            tzOffset = zone.getOffset(System.currentTimeMillis());
            if (getAutoTime()) {
                setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
            } else {
                // Adjust the saved NITZ time to account for tzOffset.
                mSavedTime = mSavedTime - tzOffset;
            }
        } else if (isoCountryCode.equals("")) {
            // Country code not found. This is likely a test network.
            // Get a TimeZone based only on the NITZ parameters (best guess).
            zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
        } else {
            zone = TimeUtils.getTimeZone(mZoneOffset, mZoneDst, mZoneTime, isoCountryCode);
        }

        mNeedFixZone = false;

        if (zone != null) {
            if (getAutoTimeZone()) {
                setAndBroadcastNetworkSetTimeZone(zone.getID());
            }
            saveNitzTimeZone(zone.getID());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.566 -0500", hash_original_method = "0FA304F04B86F76391D3D9DA6F1DEA62", hash_generated_method = "6C169B9C2BB0BD2D80905FDBFE3CF1B6")
    
protected void pollStateDone() {
        if (DBG) log("pollStateDone: oldSS=[" + ss + "] newSS=[" + newSS + "]");

        boolean hasRegistered =
            ss.getState() != ServiceState.STATE_IN_SERVICE
            && newSS.getState() == ServiceState.STATE_IN_SERVICE;

        boolean hasDeregistered =
            ss.getState() == ServiceState.STATE_IN_SERVICE
            && newSS.getState() != ServiceState.STATE_IN_SERVICE;

        boolean hasCdmaDataConnectionAttached =
            mDataConnectionState != ServiceState.STATE_IN_SERVICE
            && mNewDataConnectionState == ServiceState.STATE_IN_SERVICE;

        boolean hasCdmaDataConnectionDetached =
            mDataConnectionState == ServiceState.STATE_IN_SERVICE
            && mNewDataConnectionState != ServiceState.STATE_IN_SERVICE;

        boolean hasCdmaDataConnectionChanged =
                       mDataConnectionState != mNewDataConnectionState;

        boolean hasNetworkTypeChanged = networkType != newNetworkType;

        boolean hasChanged = !newSS.equals(ss);

        boolean hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();

        boolean hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();

        boolean hasLocationChanged = !newCellLoc.equals(cellLoc);

        // Add an event log when connection state changes
        if (ss.getState() != newSS.getState() ||
                mDataConnectionState != mNewDataConnectionState) {
            EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE,
                    ss.getState(), mDataConnectionState,
                    newSS.getState(), mNewDataConnectionState);
        }

        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        // clean slate for next time
        newSS.setStateOutOfService();

        CdmaCellLocation tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;

        mDataConnectionState = mNewDataConnectionState;
        networkType = newNetworkType;
        // this new state has been applied - forget it until we get a new new state
        newNetworkType = 0;

        newSS.setStateOutOfService(); // clean slate for next time

        if (hasNetworkTypeChanged) {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        }

        if (hasRegistered) {
            mNetworkAttachedRegistrants.notifyRegistrants();
        }

        if (hasChanged) {
            if (cm.getRadioState().isNVReady()) {
                String eriText;
                // Now the CDMAPhone sees the new ServiceState so it can get the new ERI text
                if (ss.getState() == ServiceState.STATE_IN_SERVICE) {
                    eriText = phone.getCdmaEriText();
                } else {
                    // Note that ServiceState.STATE_OUT_OF_SERVICE is valid used for
                    // mRegistrationState 0,2,3 and 4
                    eriText = phone.getContext().getText(
                            com.android.internal.R.string.roamingTextSearching).toString();
                }
                ss.setOperatorAlphaLong(eriText);
            }

            String operatorNumeric;

            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());

            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);

            if (operatorNumeric == null) {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } else {
                String isoCountryCode = "";
                try{
                    isoCountryCode = MccTable.countryCodeForMcc(Integer.parseInt(
                            operatorNumeric.substring(0,3)));
                } catch ( NumberFormatException ex){
                    loge("pollStateDone: countryCodeForMcc error" + ex);
                } catch ( StringIndexOutOfBoundsException ex) {
                    loge("pollStateDone: countryCodeForMcc error" + ex);
                }

                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY,
                        isoCountryCode);
                mGotCountryCode = true;
                if (mNeedFixZone) {
                    fixTimeZone(isoCountryCode);
                }
            }

            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");

            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        }

        if (hasCdmaDataConnectionAttached) {
            mAttachedRegistrants.notifyRegistrants();
        }

        if (hasCdmaDataConnectionDetached) {
            mDetachedRegistrants.notifyRegistrants();
        }

        if (hasCdmaDataConnectionChanged || hasNetworkTypeChanged) {
            phone.notifyDataConnection(null);
        }

        if (hasRoamingOn) {
            mRoamingOnRegistrants.notifyRegistrants();
        }

        if (hasRoamingOff) {
            mRoamingOffRegistrants.notifyRegistrants();
        }

        if (hasLocationChanged) {
            phone.notifyLocationChanged();
        }
    }

    /**
     * Returns a TimeZone object based only on parameters from the NITZ string.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.569 -0500", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "BAD67707D674CDAD94F26509AB9FCB24")
    
private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        TimeZone guess = findTimeZone(offset, dst, when);
        if (guess == null) {
            // Couldn't find a proper timezone.  Perhaps the DST data is wrong.
            guess = findTimeZone(offset, !dst, when);
        }
        if (DBG) log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        return guess;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.571 -0500", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "049809E0CCBF5A32DA8C3BF574D8B5BF")
    
private TimeZone findTimeZone(int offset, boolean dst, long when) {
        int rawOffset = offset;
        if (dst) {
            rawOffset -= 3600000;
        }
        String[] zones = TimeZone.getAvailableIDs(rawOffset);
        TimeZone guess = null;
        Date d = new Date(when);
        for (String zone : zones) {
            TimeZone tz = TimeZone.getTimeZone(zone);
            if (tz.getOffset(when) == offset &&
                    tz.inDaylightTime(d) == dst) {
                guess = tz;
                break;
            }
        }

        return guess;
    }

    /**
     * TODO: This code is exactly the same as in GsmServiceStateTracker
     * and has a TODO to not poll signal strength if screen is off.
     * This code should probably be hoisted to the base class so
     * the fix, when added, works for both.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.574 -0500", hash_original_method = "75DB599AC418C41475672A1B4451EF2E", hash_generated_method = "D78DA0B30534EA4E14CCF1B283BF2E88")
    
protected void
    queueNextSignalStrengthPoll() {
        if (dontPollSignalStrength || (cm.getRadioState().isGsm())) {
            // The radio is telling us about signal strength changes
            // we don't have to ask it
            return;
        }

        Message msg;

        msg = obtainMessage();
        msg.what = EVENT_POLL_SIGNAL_STRENGTH;

        // TODO Don't poll signal strength if screen is off
        sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
    }

    /**
     *  send signal-strength-changed notification if changed
     *  Called both for solicited and unsolicited signal strength updates
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.577 -0500", hash_original_method = "76CDF956056DDB53150BD0C17057AE41", hash_generated_method = "EF384F15E69216FA548C14063E1F1D22")
    
protected void
    onSignalStrengthResult(AsyncResult ar) {
        SignalStrength oldSignalStrength = mSignalStrength;

        if (ar.exception != null) {
            // Most likely radio is resetting/disconnected change to default values.
            setSignalStrengthDefaultValues();
        } else {
            int[] ints = (int[])ar.result;
            int offset = 2;
            int cdmaDbm = (ints[offset] > 0) ? -ints[offset] : -120;
            int cdmaEcio = (ints[offset+1] > 0) ? -ints[offset+1] : -160;
            int evdoRssi = (ints[offset+2] > 0) ? -ints[offset+2] : -120;
            int evdoEcio = (ints[offset+3] > 0) ? -ints[offset+3] : -1;
            int evdoSnr  = ((ints[offset+4] > 0) && (ints[offset+4] <= 8)) ? ints[offset+4] : -1;

            //log(String.format("onSignalStrengthResult cdmaDbm=%d cdmaEcio=%d evdoRssi=%d evdoEcio=%d evdoSnr=%d",
            //        cdmaDbm, cdmaEcio, evdoRssi, evdoEcio, evdoSnr));
            mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio,
                    evdoRssi, evdoEcio, evdoSnr, false);
        }

        try {
            phone.notifySignalStrength();
        } catch (NullPointerException ex) {
            loge("onSignalStrengthResult() Phone already destroyed: " + ex
                    + "SignalStrength not notified");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.579 -0500", hash_original_method = "DF77DC7CB442AC6CF875159BD0FE26E0", hash_generated_method = "027838B01D156C7FE146C47532DEE3FD")
    
protected int radioTechnologyToDataServiceState(int code) {
        int retVal = ServiceState.STATE_OUT_OF_SERVICE;
        switch(code) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            break;
        case 6: // RADIO_TECHNOLOGY_1xRTT
        case 7: // RADIO_TECHNOLOGY_EVDO_0
        case 8: // RADIO_TECHNOLOGY_EVDO_A
        case 12: // RADIO_TECHNOLOGY_EVDO_B
        case 13: // RADIO_TECHNOLOGY_EHRPD
            retVal = ServiceState.STATE_IN_SERVICE;
            break;
        default:
            loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
        break;
        }
        return(retVal);
    }

    /** code is registration state 0-5 from TS 27.007 7.2 */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.581 -0500", hash_original_method = "DA573DADA483FE1143660303AA3E0D9F", hash_generated_method = "3300E7531D33224452AC62CE66C92E9A")
    
protected int
    regCodeToServiceState(int code) {
        switch (code) {
        case 0: // Not searching and not registered
            return ServiceState.STATE_OUT_OF_SERVICE;
        case 1:
            return ServiceState.STATE_IN_SERVICE;
        case 2: // 2 is "searching", fall through
        case 3: // 3 is "registration denied", fall through
        case 4: // 4 is "unknown", not valid in current baseband
            return ServiceState.STATE_OUT_OF_SERVICE;
        case 5:// 5 is "Registered, roaming"
            return ServiceState.STATE_IN_SERVICE;

        default:
            loge("regCodeToServiceState: unexpected service state " + code);
        return ServiceState.STATE_OUT_OF_SERVICE;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.584 -0500", hash_original_method = "2F7466C178280C26D6BC47DE1AFB7432", hash_generated_method = "217989B846BC1E6D9596FA84326A7747")
    
public int getCurrentDataConnectionState() {
        return mDataConnectionState;
    }

    /**
     * code is registration state 0-5 from TS 27.007 7.2
     * returns true if registered roam, false otherwise
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.587 -0500", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "6C0E3EFDD2ACA49FF7AF90314964240F")
    
private boolean
    regCodeIsRoaming (int code) {
        // 5 is  "in service -- roam"
        return 5 == code;
    }

    /**
     * Determine whether a roaming indicator is in the carrier-specified list of ERIs for
     * home system
     *
     * @param roamInd roaming indicator in String
     * @return true if the roamInd is in the carrier-specified list of ERIs for home network
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.589 -0500", hash_original_method = "B4323D2F9A07343D2462A4D59ED08046", hash_generated_method = "3B2E7C0A64E67E03198E98AAACE24392")
    
private boolean isRoamIndForHomeSystem(String roamInd) {
        // retrieve the carrier-specified list of ERIs for home system
        String homeRoamIndicators = SystemProperties.get("ro.cdma.homesystem");

        if (!TextUtils.isEmpty(homeRoamIndicators)) {
            // searches through the comma-separated list for a match,
            // return true if one is found.
            for (String homeRoamInd : homeRoamIndicators.split(",")) {
                if (homeRoamInd.equals(roamInd)) {
                    return true;
                }
            }
            // no matches found against the list!
            return false;
        }

        // no system property found for the roaming indicators for home system
        return false;
    }

    /**
     * Set roaming state when cdmaRoaming is true and ons is different from spn
     * @param cdmaRoaming TS 27.007 7.2 CREG registered roaming
     * @param s ServiceState hold current ons
     * @return true for roaming state set
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.592 -0500", hash_original_method = "011C4920ECDF4CF24EF92E838B11DA6F", hash_generated_method = "42F59445F2ECAFD3199C656771D73CB2")
    
private
    boolean isRoamingBetweenOperators(boolean cdmaRoaming, ServiceState s) {
        String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");

        // NOTE: in case of RUIM we should completely ignore the ERI data file and
        // mOperatorAlphaLong is set from RIL_REQUEST_OPERATOR response 0 (alpha ONS)
        String onsl = s.getOperatorAlphaLong();
        String onss = s.getOperatorAlphaShort();

        boolean equalsOnsl = onsl != null && spn.equals(onsl);
        boolean equalsOnss = onss != null && spn.equals(onss);

        return cdmaRoaming && !(equalsOnsl || equalsOnss);
    }

    /**
     * nitzReceiveTime is time_t that the NITZ time was posted
     */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.597 -0500", hash_original_method = "7ADA939B474B339ADDF025B993055C9A", hash_generated_method = "984E693ACA3DDAA73BDE3E3021953437")
    
private
    void setTimeFromNITZString (String nitz, long nitzReceiveTime)
    {
        // "yy/mm/dd,hh:mm:ss(+/-)tz"
        // tz is in number of quarter-hours

        long start = SystemClock.elapsedRealtime();
        if (DBG) {
            log("NITZ: " + nitz + "," + nitzReceiveTime +
                        " start=" + start + " delay=" + (start - nitzReceiveTime));
        }

        try {
            /* NITZ time (hour:min:sec) will be in UTC but it supplies the timezone
             * offset as well (which we won't worry about until later) */
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

            c.clear();
            c.set(Calendar.DST_OFFSET, 0);

            String[] nitzSubs = nitz.split("[/:,+-]");

            int year = 2000 + Integer.parseInt(nitzSubs[0]);
            c.set(Calendar.YEAR, year);

            // month is 0 based!
            int month = Integer.parseInt(nitzSubs[1]) - 1;
            c.set(Calendar.MONTH, month);

            int date = Integer.parseInt(nitzSubs[2]);
            c.set(Calendar.DATE, date);

            int hour = Integer.parseInt(nitzSubs[3]);
            c.set(Calendar.HOUR, hour);

            int minute = Integer.parseInt(nitzSubs[4]);
            c.set(Calendar.MINUTE, minute);

            int second = Integer.parseInt(nitzSubs[5]);
            c.set(Calendar.SECOND, second);

            boolean sign = (nitz.indexOf('-') == -1);

            int tzOffset = Integer.parseInt(nitzSubs[6]);

            int dst = (nitzSubs.length >= 8 ) ? Integer.parseInt(nitzSubs[7])
                                              : 0;

            // The zone offset received from NITZ is for current local time,
            // so DST correction is already applied.  Don't add it again.
            //
            // tzOffset += dst * 4;
            //
            // We could unapply it if we wanted the raw offset.

            tzOffset = (sign ? 1 : -1) * tzOffset * 15 * 60 * 1000;

            TimeZone    zone = null;

            // As a special extension, the Android emulator appends the name of
            // the host computer's timezone to the nitz string. this is zoneinfo
            // timezone name of the form Area!Location or Area!Location!SubLocation
            // so we need to convert the ! into /
            if (nitzSubs.length >= 9) {
                String  tzname = nitzSubs[8].replace('!','/');
                zone = TimeZone.getTimeZone( tzname );
            }

            String iso = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);

            if (zone == null) {

                if (mGotCountryCode) {
                    if (iso != null && iso.length() > 0) {
                        zone = TimeUtils.getTimeZone(tzOffset, dst != 0,
                                c.getTimeInMillis(),
                                iso);
                    } else {
                        // We don't have a valid iso country code.  This is
                        // most likely because we're on a test network that's
                        // using a bogus MCC (eg, "001"), so get a TimeZone
                        // based only on the NITZ parameters.
                        zone = getNitzTimeZone(tzOffset, (dst != 0), c.getTimeInMillis());
                    }
                }
            }

            if (zone == null) {
                // We got the time before the country, so we don't know
                // how to identify the DST rules yet.  Save the information
                // and hope to fix it up later.

                mNeedFixZone = true;
                mZoneOffset  = tzOffset;
                mZoneDst     = dst != 0;
                mZoneTime    = c.getTimeInMillis();
            }

            if (zone != null) {
                if (getAutoTimeZone()) {
                    setAndBroadcastNetworkSetTimeZone(zone.getID());
                }
                saveNitzTimeZone(zone.getID());
            }

            String ignore = SystemProperties.get("gsm.ignore-nitz");
            if (ignore != null && ignore.equals("yes")) {
                if (DBG) log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                return;
            }

            try {
                mWakeLock.acquire();

                /**
                 * Correct the NITZ time by how long its taken to get here.
                 */
                long millisSinceNitzReceived
                        = SystemClock.elapsedRealtime() - nitzReceiveTime;

                if (millisSinceNitzReceived < 0) {
                    // Sanity check: something is wrong
                    if (DBG) {
                        log("NITZ: not setting time, clock has rolled "
                                        + "backwards since NITZ time was received, "
                                        + nitz);
                    }
                    return;
                }

                if (millisSinceNitzReceived > Integer.MAX_VALUE) {
                    // If the time is this far off, something is wrong > 24 days!
                    if (DBG) {
                        log("NITZ: not setting time, processing has taken "
                                    + (millisSinceNitzReceived / (1000 * 60 * 60 * 24))
                                    + " days");
                    }
                    return;
                }

                // Note: with range checks above, cast to int is safe
                c.add(Calendar.MILLISECOND, (int)millisSinceNitzReceived);

                if (getAutoTime()) {
                    /**
                     * Update system time automatically
                     */
                    long gained = c.getTimeInMillis() - System.currentTimeMillis();
                    long timeSinceLastUpdate = SystemClock.elapsedRealtime() - mSavedAtTime;
                    int nitzUpdateSpacing = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_SPACING, mNitzUpdateSpacing);
                    int nitzUpdateDiff = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_DIFF, mNitzUpdateDiff);

                    if ((mSavedAtTime == 0) || (timeSinceLastUpdate > nitzUpdateSpacing)
                            || (Math.abs(gained) > nitzUpdateDiff)) {
                        if (DBG) {
                            log("NITZ: Auto updating time of day to " + c.getTime()
                                + " NITZ receive delay=" + millisSinceNitzReceived
                                + "ms gained=" + gained + "ms from " + nitz);
                        }

                        setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                    } else {
                        if (DBG) {
                            log("NITZ: ignore, a previous update was "
                                + timeSinceLastUpdate + "ms ago and gained=" + gained + "ms");
                        }
                        return;
                    }
                }

                /**
                 * Update properties and save the time we did the update
                 */
                if (DBG) log("NITZ: update nitz time property");
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                mSavedTime = c.getTimeInMillis();
                mSavedAtTime = SystemClock.elapsedRealtime();
            } finally {
                long end = SystemClock.elapsedRealtime();
                if (DBG) log("NITZ: end=" + end + " dur=" + (end - start));
                mWakeLock.release();
            }
        } catch (RuntimeException ex) {
            loge("NITZ: Parsing NITZ time " + nitz + " ex=" + ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.600 -0500", hash_original_method = "606CF17A4D40300EAFFE0BD67B82E0B6", hash_generated_method = "7CA45260AD3533375D42B40B52005E16")
    
private boolean getAutoTime() {
        try {
            return Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0;
        } catch (SettingNotFoundException snfe) {
            return true;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.602 -0500", hash_original_method = "46A307C7AC0E208B22907DFB9CC04F45", hash_generated_method = "09AD958D51EAC7A5D33093B552765A49")
    
private boolean getAutoTimeZone() {
        try {
            return Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0;
        } catch (SettingNotFoundException snfe) {
            return true;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.604 -0500", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "95607A7DB8A17A71A53B4FD9E4217C6A")
    
private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
    }

    /**
     * Set the timezone and send out a sticky broadcast so the system can
     * determine if the timezone was set by the carrier.
     *
     * @param zoneId timezone set by carrier
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.607 -0500", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "0B5EAB3B98BE4495A7BB1CF24837488F")
    
private void setAndBroadcastNetworkSetTimeZone(String zoneId) {
        AlarmManager alarm =
            (AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        alarm.setTimeZone(zoneId);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time-zone", zoneId);
        phone.getContext().sendStickyBroadcast(intent);
    }

    /**
     * Set the time and Send out a sticky broadcast so the system can determine
     * if the time was set by the carrier.
     *
     * @param time time set by network
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.609 -0500", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "292B45AEF44DD01DD907E884EEAFFEA9")
    
private void setAndBroadcastNetworkSetTime(long time) {
        SystemClock.setCurrentTimeMillis(time);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time", time);
        phone.getContext().sendStickyBroadcast(intent);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.613 -0500", hash_original_method = "FAE09FD02085B2FF4E1D8E37B65790F8", hash_generated_method = "688F6BE267C20F8134B140A9F647E2D7")
    
private void revertToNitzTime() {
        if (Settings.System.getInt(cr, Settings.System.AUTO_TIME, 0) == 0) {
            return;
        }
        if (DBG) {
            log("revertToNitzTime: mSavedTime=" + mSavedTime + " mSavedAtTime=" + mSavedAtTime);
        }
        if (mSavedTime != 0 && mSavedAtTime != 0) {
            setAndBroadcastNetworkSetTime(mSavedTime
                    + (SystemClock.elapsedRealtime() - mSavedAtTime));
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.617 -0500", hash_original_method = "72156026C5CBDDA4CCFB821F20D0E263", hash_generated_method = "36AC0AF73F6D01D0A213B6774D93860E")
    
private void revertToNitzTimeZone() {
        if (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0) {
            return;
        }
        if (DBG) log("revertToNitzTimeZone: tz='" + mSavedTimeZone);
        if (mSavedTimeZone != null) {
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.621 -0500", hash_original_method = "32C0C58A5E03F7E404DD21382316ACEF", hash_generated_method = "5BA8BF7A58404AE705D0BD01904D6246")
    
protected boolean isSidsAllZeros() {
        if (mHomeSystemId != null) {
            for (int i=0; i < mHomeSystemId.length; i++) {
                if (mHomeSystemId[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check whether a specified system ID that matches one of the home system IDs.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.625 -0500", hash_original_method = "D3D57AE588662EF8725CB60FCA1C3072", hash_generated_method = "2B75B99AF9634D353514986B6026DE94")
    
private boolean isHomeSid(int sid) {
        if (mHomeSystemId != null) {
            for (int i=0; i < mHomeSystemId.length; i++) {
                if (sid == mHomeSystemId[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return true if phone is camping on a technology
     * that could support voice and data simultaneously.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.628 -0500", hash_original_method = "5C4C41F870A905A307BF05376EE79383", hash_generated_method = "5B6000207EE73E75F47694899BADBA0D")
    
public boolean isConcurrentVoiceAndDataAllowed() {
        // Note: it needs to be confirmed which CDMA network types
        // can support voice and data calls concurrently.
        // For the time-being, the return value will be false.
        return false;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.631 -0500", hash_original_method = "A5028D79B927656E45CDFA536F16F5AB", hash_generated_method = "CE380CEB9E020089119AC26C1416B42D")
    
public String getMdnNumber() {
        return mMdn;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.634 -0500", hash_original_method = "133C132C72A1734541959456CF27FF0A", hash_generated_method = "8F59A7ACCE96A294389A5DCD933FC017")
    
public String getCdmaMin() {
         return mMin;
    }

    /** Returns null if NV is not yet ready */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.636 -0500", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "7DD390FA72255EC2B3B0362AC1AB9654")
    
public String getPrlVersion() {
        return mPrlVersion;
    }

    /**
     * Returns IMSI as MCC + MNC + MIN
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.640 -0500", hash_original_method = "B26D3610EF4478BB5ED2ADA9EDE43E3B", hash_generated_method = "8C7D47A97C60077F792C3402BD9CD63E")
    
String getImsi() {
        // TODO: When RUIM is enabled, IMSI will come from RUIM not build-time props.
        String operatorNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");

        if (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null) {
            return (operatorNumeric + getCdmaMin());
        } else {
            return null;
        }
    }

    /**
     * Check if subscription data has been assigned to mMin
     *
     * return true if MIN info is ready; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.642 -0500", hash_original_method = "8F0255C2E086694196AF7CFC36B7EF43", hash_generated_method = "7E35C8E7189C135682BC48CACE7EFA68")
    
public boolean isMinInfoReady() {
        return mIsMinInfoReady;
    }

    /**
     * Returns OTASP_UNKNOWN, OTASP_NEEDED or OTASP_NOT_NEEDED
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.648 -0500", hash_original_method = "0E452BF490F5457F3887197BA13C1AF4", hash_generated_method = "0E452BF490F5457F3887197BA13C1AF4")
    
int getOtasp() {
        int provisioningState;
        if (mMin == null || (mMin.length() < 6)) {
            if (DBG) log("getOtasp: bad mMin='" + mMin + "'");
            provisioningState = OTASP_UNKNOWN;
        } else {
            if ((mMin.equals(UNACTIVATED_MIN_VALUE)
                    || mMin.substring(0,6).equals(UNACTIVATED_MIN2_VALUE))
                    || SystemProperties.getBoolean("test_cdma_setup", false)) {
                provisioningState = OTASP_NEEDED;
            } else {
                provisioningState = OTASP_NOT_NEEDED;
            }
        }
        if (DBG) log("getOtasp: state=" + provisioningState);
        return provisioningState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.657 -0500", hash_original_method = "99845E4FDDAE6236D8C7F396E4374533", hash_generated_method = "633D11AB98BF0FCFF49928DCBDD284AA")
    
@Override
    protected void hangupAndPowerOff() {
        // hang up all active voice calls
        phone.mCT.ringingCall.hangupIfAlive();
        phone.mCT.backgroundCall.hangupIfAlive();
        phone.mCT.foregroundCall.hangupIfAlive();
        cm.setRadioPower(false, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.660 -0500", hash_original_method = "B2E611749AA45590CADF6B42B9066FE3", hash_generated_method = "65228175D4D6163C78007C8B775279DD")
    
protected void parseSidNid (String sidStr, String nidStr) {
        if (sidStr != null) {
            String[] sid = sidStr.split(",");
            mHomeSystemId = new int[sid.length];
            for (int i = 0; i < sid.length; i++) {
                try {
                    mHomeSystemId[i] = Integer.parseInt(sid[i]);
                } catch (NumberFormatException ex) {
                    loge("error parsing system id: " + ex);
                }
            }
        }
        if (DBG) log("CDMA_SUBSCRIPTION: SID=" + sidStr);

        if (nidStr != null) {
            String[] nid = nidStr.split(",");
            mHomeNetworkId = new int[nid.length];
            for (int i = 0; i < nid.length; i++) {
                try {
                    mHomeNetworkId[i] = Integer.parseInt(nid[i]);
                } catch (NumberFormatException ex) {
                    loge("CDMA_SUBSCRIPTION: error parsing network id: " + ex);
                }
            }
        }
        if (DBG) log("CDMA_SUBSCRIPTION: NID=" + nidStr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.664 -0500", hash_original_method = "610B4A562CE77C76E210E506F221FC8A", hash_generated_method = "171908BD7F9350BB8A2D58E50179AC51")
    
protected void updateOtaspState() {
        int otaspMode = getOtasp();
        int oldOtaspMode = mCurrentOtaspMode;
        mCurrentOtaspMode = otaspMode;

        // Notify apps subscription info is ready
        if (cdmaForSubscriptionInfoReadyRegistrants != null) {
            if (DBG) log("CDMA_SUBSCRIPTION: call notifyRegistrants()");
            cdmaForSubscriptionInfoReadyRegistrants.notifyRegistrants();
        }
        if (oldOtaspMode != mCurrentOtaspMode) {
            if (DBG) {
                log("CDMA_SUBSCRIPTION: call notifyOtaspChanged old otaspMode=" +
                    oldOtaspMode + " new otaspMode=" + mCurrentOtaspMode);
            }
            phone.notifyOtaspChanged(mCurrentOtaspMode);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.667 -0500", hash_original_method = "F8EA3CF0B7D491A29C0D20E35CC8F967", hash_generated_method = "858EF38D3726E0E254013A5A33A1DC1E")
    
@Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaSST] " + s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:53.669 -0500", hash_original_method = "385CD47B6889905FF3482AEA1E26688E", hash_generated_method = "C065FC09FEAB1DA8F54746874AB7EE05")
    
@Override
    protected void loge(String s) {
        Log.e(LOG_TAG, "[CdmaSST] " + s);
    }
}

