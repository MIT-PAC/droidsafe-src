package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.os.AsyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.ServiceState;
import android.text.TextUtils;

import com.android.internal.R;
import com.android.internal.telephony.DataConnection.FailCause;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;

public abstract class DataConnectionTracker extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.480 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.482 -0500", hash_original_field = "F8CE2FA6EEC177FA658AF7AF6580B765", hash_generated_field = "9627AE94D7940D7E187DD2B77A194FB7")

    protected static final boolean VDBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.489 -0500", hash_original_field = "29F7FBC6F2FCA909B09244B49044FD18", hash_generated_field = "33A74D16876315708A9BD8BD04E30FC7")

    public static String ACTION_DATA_CONNECTION_TRACKER_MESSENGER =
        "com.android.internal.telephony";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.491 -0500", hash_original_field = "D6BD82A7405124CCF5FF3D90D50E770D", hash_generated_field = "26F3AF3552BC4649D0937B13E6BC7CF8")

    public static String EXTRA_MESSENGER = "EXTRA_MESSENGER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.493 -0500", hash_original_field = "E00265F6BBC091AAD0DD49A0166882E2", hash_generated_field = "578AE35EE98E3DDD5EEAF2CBED5ACB45")

    protected static final int BASE = Protocol.BASE_DATA_CONNECTION_TRACKER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.497 -0500", hash_original_field = "00F7DCD1278A88CC2543CA2A43E77E16", hash_generated_field = "57E86604562BA2CD352710B284D46B74")

    protected static final int EVENT_DATA_SETUP_COMPLETE = BASE + 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.499 -0500", hash_original_field = "C5A7E1CC37E1C8672FC1CF7B54590DBA", hash_generated_field = "918C2E0C3F0B773EB57002039E5ADDF8")

    protected static final int EVENT_RADIO_AVAILABLE = BASE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.502 -0500", hash_original_field = "2F5C8BCDB712761E66D8F58906BBF30F", hash_generated_field = "9B5C18CFAB1EB82B998D3AC095B58265")

    protected static final int EVENT_RECORDS_LOADED = BASE + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.504 -0500", hash_original_field = "55A2BB850A60D43AA7C4FBFFD4FFC79F", hash_generated_field = "A0525720B88653F55BA065E6AA892DC1")

    protected static final int EVENT_TRY_SETUP_DATA = BASE + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.507 -0500", hash_original_field = "A431A7071C6BEDFB138B0FAD16D8E953", hash_generated_field = "F6570C1A0821C4AB0BE35C147D368628")

    protected static final int EVENT_DATA_STATE_CHANGED = BASE + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.510 -0500", hash_original_field = "F58632D4479B790E981EA4F2A2E4F0C2", hash_generated_field = "FBFDC491608A17124A17D3452F208088")

    protected static final int EVENT_POLL_PDP = BASE + 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.512 -0500", hash_original_field = "7F1DC7123A6EE5425B8AE452F847E8C9", hash_generated_field = "27116C6686CAE7B4E6DC721A8CBA4151")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = BASE + 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.515 -0500", hash_original_field = "EF240217B1CE1A35B62E95F4757D439F", hash_generated_field = "7961EC29589D615AB66085BBDDF16352")

    protected static final int EVENT_VOICE_CALL_STARTED = BASE + 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.517 -0500", hash_original_field = "31C2FEB538A17D7F5B5A2C196FB3CEC3", hash_generated_field = "4E3DEF92CAD4F30419EB5EB31D45E012")

    protected static final int EVENT_VOICE_CALL_ENDED = BASE + 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.519 -0500", hash_original_field = "AE9568F02DA2DE783C9E8D99248A9A4D", hash_generated_field = "EA6E60EE7ECE546BDE71D93811BB9270")

    protected static final int EVENT_DATA_CONNECTION_DETACHED = BASE + 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.523 -0500", hash_original_field = "B08CEA809B443FEAF04EC4BFE48BD4F8", hash_generated_field = "D603A46CFC57F5E3579D3275D14987B9")

    protected static final int EVENT_LINK_STATE_CHANGED = BASE + 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.525 -0500", hash_original_field = "898DE29E32E70E91BE82A8A7F87E9357", hash_generated_field = "37C4B29B403735591BA4637FD7F07300")

    protected static final int EVENT_ROAMING_ON = BASE + 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.528 -0500", hash_original_field = "0ACDD275A0E3ADB030A201442145F4B3", hash_generated_field = "AC2E0D687697D630951043F63F8B55EF")

    protected static final int EVENT_ROAMING_OFF = BASE + 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.530 -0500", hash_original_field = "83BD4E4EE42A419F21DCE70C7AA67695", hash_generated_field = "56ED200F83206D8C2B8AEEC777D92808")

    protected static final int EVENT_ENABLE_NEW_APN = BASE + 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.533 -0500", hash_original_field = "924AD435D3B7C1154C89F12AC26E8C03", hash_generated_field = "699A01D28FE3B5BA2F9DBE2E14C16720")

    protected static final int EVENT_RESTORE_DEFAULT_APN = BASE + 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.535 -0500", hash_original_field = "C39B03FFB7F7F4E5F9D92F2875362968", hash_generated_field = "8CB78322EFEEA6081C6B4812D06CDE2F")

    protected static final int EVENT_DISCONNECT_DONE = BASE + 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.537 -0500", hash_original_field = "740EFC1C1763BB9D5447FA2C40F8377E", hash_generated_field = "706DAFBB316C33FB3681D6E45AF16EC5")

    protected static final int EVENT_DATA_CONNECTION_ATTACHED = BASE + 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.540 -0500", hash_original_field = "A85D726ED0665815AFE8F4B5CFA333BB", hash_generated_field = "524270489D97E868640177C02C87FAEF")

    protected static final int EVENT_DATA_STALL_ALARM = BASE + 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.543 -0500", hash_original_field = "0D001520E58C156B82EF3116C44FD497", hash_generated_field = "E6A154D47B9FDA448EB2D6ECA54E9044")

    protected static final int EVENT_DO_RECOVERY = BASE + 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.545 -0500", hash_original_field = "19E53D56F654A115731AB3AA23226C8E", hash_generated_field = "C64987752373EDCE104AC55BCE584A2E")

    protected static final int EVENT_APN_CHANGED = BASE + 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.549 -0500", hash_original_field = "E808A1704598BB3127C12B0DEB0CCCDD", hash_generated_field = "732BEB3FAC1202A7DAB02A4D73A7407D")

    protected static final int EVENT_CDMA_DATA_DETACHED = BASE + 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.551 -0500", hash_original_field = "AF857AD14137483A7EFB36272DB2743C", hash_generated_field = "8909A780334573F8F694B9A1EBC29A1A")

    protected static final int EVENT_NV_READY = BASE + 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.554 -0500", hash_original_field = "2E7A59166384E3E6630577F992ED1F6F", hash_generated_field = "2D0CA6675E7E5DF0AC5D6499149EBCAB")

    protected static final int EVENT_PS_RESTRICT_ENABLED = BASE + 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.556 -0500", hash_original_field = "3879463B516FF90D8E125E6C3EDE532E", hash_generated_field = "E117070A96CD4C5C470336E4EE845528")

    protected static final int EVENT_PS_RESTRICT_DISABLED = BASE + 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.559 -0500", hash_original_field = "E964E97A7E5ACBB5F020665B643D6890", hash_generated_field = "AD86F18DB896FF32B9ABB648D3BE3614")

    public static final int EVENT_CLEAN_UP_CONNECTION = BASE + 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.561 -0500", hash_original_field = "5553B946BBC849AB29573CFEA1AACE21", hash_generated_field = "9FC0CEF9DBBD9CDD60A47E3B572DEE11")

    protected static final int EVENT_CDMA_OTA_PROVISION = BASE + 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.563 -0500", hash_original_field = "BDEE4280DFCB1E71CA46EBFC01A12EC2", hash_generated_field = "2E113365E66D355FEDAB98A7D37D81A7")

    protected static final int EVENT_RESTART_RADIO = BASE + 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.567 -0500", hash_original_field = "86F5E0B25186D3A133994C70AFEEBD5B", hash_generated_field = "EBD7235096B041C0C308DD944A3704E2")

    protected static final int EVENT_SET_INTERNAL_DATA_ENABLE = BASE + 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.569 -0500", hash_original_field = "AC6CB71FA5866BC58CEC303889E163D1", hash_generated_field = "5034595773C1BED896C3513B3B07EC9E")

    protected static final int EVENT_RESET_DONE = BASE + 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.572 -0500", hash_original_field = "BC6ECD9EA97DDD786369E755FFE7079A", hash_generated_field = "F77450C54EDD06E9C95E2653ED0EECF1")

    public static final int CMD_SET_USER_DATA_ENABLE = BASE + 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.574 -0500", hash_original_field = "525F9FECB542C7D8F37A9DFA91CB8596", hash_generated_field = "B4E9A3F75E31EBF0819A14E7CE2FE65B")

    public static final int EVENT_CLEAN_UP_ALL_CONNECTIONS = BASE + 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.577 -0500", hash_original_field = "77FD7FCAED67A043A53D84C89D467948", hash_generated_field = "D8C9AD1D6E5CBD85074BECAA38E31518")

    public static final int CMD_SET_DEPENDENCY_MET = BASE + 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.579 -0500", hash_original_field = "5EB1A59073FF3F9F4109B0D01A6A43C8", hash_generated_field = "3254C5957AFFF539FD79B974BB823F2E")

    public static final int CMD_SET_POLICY_DATA_ENABLE = BASE + 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.582 -0500", hash_original_field = "8482E3B95A5B0CB1701308573ADDEA05", hash_generated_field = "07F46E413C8B3F3559740A56D5842AD9")

    protected static final int APN_INVALID_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.584 -0500", hash_original_field = "F1FC7C56411BD39919A4E4E6BAFA5FAB", hash_generated_field = "0E77FDDEFB918A35BF053E79F738F079")

    protected static final int APN_DEFAULT_ID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.587 -0500", hash_original_field = "57CAEC2DA653586D266645DB9189175E", hash_generated_field = "3ADA7B63B367F670A9CD841236C2E69E")

    protected static final int APN_MMS_ID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.589 -0500", hash_original_field = "53354837BB8BE654DF04B5A912C5E94B", hash_generated_field = "52A680E6667112D0AD515B82C22E851A")

    protected static final int APN_SUPL_ID = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.592 -0500", hash_original_field = "A262BEE6B310A6FF375CEF8D63BB40D2", hash_generated_field = "E098D6D391DC0AB0F915C3106B1695EE")

    protected static final int APN_DUN_ID = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.595 -0500", hash_original_field = "0D62FEF906BEB89FA509E961F0D8629D", hash_generated_field = "4EFC758C61F82DD345E0F30EFFBD676B")

    protected static final int APN_HIPRI_ID = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.598 -0500", hash_original_field = "2C86323031261715DE91471E8A66F3C9", hash_generated_field = "A8AD07F881EB2DE54A81F6EF15DCAC2C")

    protected static final int APN_IMS_ID = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.600 -0500", hash_original_field = "97A96072F2580592E5618C38803B58F2", hash_generated_field = "E8CEDAD872DD75AEF65EC837AB693137")

    protected static final int APN_FOTA_ID = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.603 -0500", hash_original_field = "6E9D994018F8983086DFA962B5BA4BB1", hash_generated_field = "2B316B7447F9D669311A7A19EECFEA03")

    protected static final int APN_CBS_ID = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.605 -0500", hash_original_field = "6231E6F40BD314DBDAB2715A0273BDA2", hash_generated_field = "964D3223C076E2C626C417466FDE0286")

    protected static final int APN_NUM_TYPES = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.607 -0500", hash_original_field = "6F7E0F80EF74FD3232989FC9E75E1B32", hash_generated_field = "6F8C6ECFCCFDEEF8A111FB82FE45C371")

    public static final int DISABLED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.610 -0500", hash_original_field = "7AC26F0BB6690D4CA2BE4FF85238F324", hash_generated_field = "BBC106514DA50C961AB6371075708621")

    public static final int ENABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.613 -0500", hash_original_field = "70A43666909770466184618CED5B6CA3", hash_generated_field = "26D79596132C0495F601BE108CF49667")

    public static final String APN_TYPE_KEY = "apnType";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.616 -0500", hash_original_field = "56484626D21EC6D023DAF997BD2ED4CD", hash_generated_field = "A249C37DD807D068C9799A3714E5C4B5")

    protected static final int APN_DELAY_MILLIS =
                                SystemProperties.getInt("persist.radio.apn_delay", 5000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.625 -0500", hash_original_field = "D22754E51EC1114A2BBDEA01773A6D60", hash_generated_field = "F1D5EAD411587599450F20AD6F0FCBFE")

    protected static boolean sPolicyDataEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.635 -0500", hash_original_field = "7980590A87EB11CA0B768C3CA2DFD921", hash_generated_field = "C8ABD15820F1BC36B2FC6FA2C5BBD57E")

    protected static final String DEFAULT_DATA_RETRY_CONFIG = "default_randomization=2000,"
        + "5000,10000,20000,40000,80000:5000,160000:5000,"
        + "320000:5000,640000:5000,1280000:5000,1800000:5000";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.637 -0500", hash_original_field = "A2458DEBAC99CA2EA22CC92AEF33A4FD", hash_generated_field = "93ECBE2CB5D3FA004037332587C4234E")

    protected static final String SECONDARY_DATA_RETRY_CONFIG =
            "max_retries=3, 5000, 5000, 5000";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.640 -0500", hash_original_field = "C406FA167B98F1B3355F9F8E7D90B358", hash_generated_field = "3E24F8F476066918BB2F3B6D1406C0E2")

    protected static final int POLL_NETSTAT_SLOW_MILLIS = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.643 -0500", hash_original_field = "97D748EBDE0FA250BED710ABB98CE7B9", hash_generated_field = "1A0EC6E0BA46F24B4A2694596B6E436D")

    protected static final int DEFAULT_MAX_PDP_RESET_FAIL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.645 -0500", hash_original_field = "26C6F2C7EBEA2057C32FFA1318D716C1", hash_generated_field = "1FE39315059532779489F940B44B4D66")

    protected static final int NO_RECV_POLL_LIMIT = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.648 -0500", hash_original_field = "385C768E921516161B2DCE2476130AF9", hash_generated_field = "0D9BF9729BE1A27BBD1BF62B3384AB80")

    protected static final int POLL_NETSTAT_MILLIS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.650 -0500", hash_original_field = "CBB7B942AA5969DFB1EA9F965C89DE4A", hash_generated_field = "D7453C2438D87CC283C407D0E80A8104")

    protected static final int POLL_NETSTAT_SCREEN_OFF_MILLIS = 1000*60*10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.653 -0500", hash_original_field = "F691D1E2BA96C40E4E002916FC211546", hash_generated_field = "142733920ADC648E7F33CA58E902D9A6")

    protected static final int POLL_LONGEST_RTT = 120 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.656 -0500", hash_original_field = "751822C7E6BD66F844812AF1EC720121", hash_generated_field = "71AF96CD56F561EBA0B98AD3621CFF6F")

    protected static final int NUMBER_SENT_PACKETS_OF_HANG = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.659 -0500", hash_original_field = "9AFF94826BE4E464889DD0F4921E857A", hash_generated_field = "AC35FDCED05C1F4EE3D61BE8C1BC35EC")

    protected static final int RESTORE_DEFAULT_APN_DELAY = 1 * 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.661 -0500", hash_original_field = "329D65119200873102F8D6A2C084142A", hash_generated_field = "2B8A79ACDC0B6FBDAD775768D652C83F")

    protected static final String APN_RESTORE_DELAY_PROP_NAME = "android.telephony.apn-restore";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.664 -0500", hash_original_field = "05C3564F4310DD43CD9568F5E3092392", hash_generated_field = "13B653D205F77F7600F4F13DC999F8B9")

    protected static final String NULL_IP = "0.0.0.0";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.667 -0500", hash_original_field = "77A1B0F78B99E61A668BB4077467EB32", hash_generated_field = "0411F8BF5642AECCB6A41EFE99C246EE")

    protected static final int DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT = 1000 * 60 * 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.669 -0500", hash_original_field = "5E442494DFCED48BC6A020FC6A52C358", hash_generated_field = "A2AEF5834159105DB4F070F129F7D147")

    protected static final int DATA_STALL_NO_RECV_POLL_LIMIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.672 -0500", hash_original_field = "1DC9B35FCF87FCBA12298C5DE3235414", hash_generated_field = "D4EDDFEB958C1B822CA1719D4CF16D54")

    protected static final String DATA_STALL_ALARM_TAG_EXTRA = "data.stall.alram.tag";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.674 -0500", hash_original_field = "E14AC789B5DA35C645C94AC5F4A8C18D", hash_generated_field = "D133E1F307D274CB4D21FDCA5174E3B3")

    //       having to have different values for GSM and
    //       CDMA. If so we can then remove the need for
    //       getActionIntentReconnectAlarm.
    protected static final String INTENT_RECONNECT_ALARM_EXTRA_REASON = "reason";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.677 -0500", hash_original_field = "8A7DE7D669E6C5F5FB920992F4C555DB", hash_generated_field = "B7E7CA5E4631735BF26D88701BD61023")

    // of times the setup is to fail before succeeding. If the counter isn't passed the
    // setup will fail once. Example fail two times with FailCause.SIGNAL_LOST(-3)
    // adb shell am broadcast \
    //  -a com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter \
    //  --ei fail_data_setup_counter 3 --ei fail_data_setup_fail_cause -3
    protected static final String INTENT_SET_FAIL_DATA_SETUP_COUNTER =
        "com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.679 -0500", hash_original_field = "D1FDD6AEB62D940D1C15FF0D8A353926", hash_generated_field = "3B5E09F30CCEFBA257FF0FFD68EEC79D")

    protected static final String FAIL_DATA_SETUP_COUNTER = "fail_data_setup_counter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.684 -0500", hash_original_field = "5DF7E3869249DC8DF17A442860F83ECE", hash_generated_field = "E2E42CE52C5DCFF5C5FC00CE54B6B5F4")

    protected static final String FAIL_DATA_SETUP_FAIL_CAUSE = "fail_data_setup_fail_cause";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.689 -0500", hash_original_field = "25CF4A283DCD2C315B62D9D5E96D80A2", hash_generated_field = "1A4684138A98FC97EFDBFAB38A208838")

    protected static final String DEFALUT_DATA_ON_BOOT_PROP = "net.def_data_on_boot";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.618 -0500", hash_original_field = "5963D6DF572A3990DB76F0E016083E84", hash_generated_field = "35FA5A91B80F269D1DB9B36DE1EC65CA")

    protected Object mDataEnabledLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.620 -0500", hash_original_field = "B4753475C7A908A5C2698825CCCB21D4", hash_generated_field = "A91650204E4017AE2AE6A13FB8D2A9FB")

    // for example during emergency calls
    protected boolean mInternalDataEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.623 -0500", hash_original_field = "D718BCD281CB9DCF86577D86056FC24A", hash_generated_field = "A7740DC4F5C8AFDB0DF50988F4D5C254")

    // independent of mInternalDataEnabled and requests for APN access
    // persisted
    protected boolean mUserDataEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.628 -0500", hash_original_field = "D92494BCB77A2CDC157953A0F604B988", hash_generated_field = "F49B5B07667CCB529520831482D9BAB1")

    private boolean[] dataEnabled = new boolean[APN_NUM_TYPES];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.630 -0500", hash_original_field = "DAE2C829A0358BE6B2277E2CDD4A9EF3", hash_generated_field = "8420FF89B70ED10465A38AC8B70D9095")

    private int enabledCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.632 -0500", hash_original_field = "9A8DD0A7DCE9B8EFB5C4F910DDC9A006", hash_generated_field = "4C2B2DCF407C9F63C855A59D9F29A37A")

    protected String mRequestedApnType = Phone.APN_TYPE_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.681 -0500", hash_original_field = "3EB2A603924EE7E06686B4524F309816", hash_generated_field = "1894211C4C78CAACE34F0DC8EE3A13C1")

    protected int mFailDataSetupCounter = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.687 -0500", hash_original_field = "5E0BFF5F25394E50519E43873B9D8262", hash_generated_field = "EC29A5CA55085C10657861453E10B11C")

    protected FailCause mFailDataSetupFailCause = FailCause.ERROR_UNSPECIFIED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.692 -0500", hash_original_field = "B504049739EC0253F0006BF183324917", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.695 -0500", hash_original_field = "D3003593180170C15136C506BABD4BD3", hash_generated_field = "5CE7295912ACD2604E7762D907339691")

    protected Activity mActivity = Activity.NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.697 -0500", hash_original_field = "D90BD28ACBB5A7FF21C1D22DFB88E93E", hash_generated_field = "CEA309476306FEF09638ED5ED829D6A1")

    protected State mState = State.IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.700 -0500", hash_original_field = "1913A16142175D6DE29BF14BA9768D50", hash_generated_field = "963D8F7E00CCB73CD43AA6DA0AE9DF2A")

    protected Handler mDataConnectionTracker = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.703 -0500", hash_original_field = "A497A89C1F9913407DAB4F8AA8A5693D", hash_generated_field = "C066AA046467E6BBB3EA5DDB129B3DB8")

    protected long mTxPkts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.705 -0500", hash_original_field = "58616AB4D584FE4E91ECB80FE36E1390", hash_generated_field = "F031B0AD358C38347F225F90F75B03E4")

    protected long mRxPkts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.708 -0500", hash_original_field = "988C93F7C947F446DBF6169A0B63C85D", hash_generated_field = "D9D10A2C69888D907D9D54771B7DB2A5")

    protected int mNetStatPollPeriod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.710 -0500", hash_original_field = "AFCE3094975098E3A6A42E077C7B0505", hash_generated_field = "8AEC394E7895B11DB0C1B86A5A82BE9C")

    protected boolean mNetStatPollEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.713 -0500", hash_original_field = "6B56573E62EC2E29CC84A12408F3C1E3", hash_generated_field = "B4F64D56417D37A4C51A5C74706E778F")

    protected TxRxSum mDataStallTxRxSum = new TxRxSum(0, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.716 -0500", hash_original_field = "F36378879EA961AAA3247A55F66F7878", hash_generated_field = "922642510706D7E1F40906A8E67562E6")

    protected int mDataStallAlarmTag = (int) SystemClock.elapsedRealtime();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.719 -0500", hash_original_field = "96AF1195061360F8D1DE931778329ECF", hash_generated_field = "3964C7D016D96B23E8A4F338B71B706B")

    protected PendingIntent mDataStallAlarmIntent = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.721 -0500", hash_original_field = "2ABE90978209214FDA8364E236E93422", hash_generated_field = "6467835C9ADB216F54C7DD6564D528DC")

    protected long mSentSinceLastRecv;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.723 -0500", hash_original_field = "EBE9A2978431FACC5BB2333C18CBF7CB", hash_generated_field = "34A070F678DFA34A23ADEF39527A564C")

    protected int mNoRecvPollCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.725 -0500", hash_original_field = "2D877AF8B567C0FF03FF08716DCA1849", hash_generated_field = "9A8B10322BB7B36EE6E7CC8062CC1FBF")

    protected boolean mIsWifiConnected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.728 -0500", hash_original_field = "43EA75A8E40D96F1FE9644BAABB59B27", hash_generated_field = "12A1D0ED5463C3F1D91D57D8EA6A8B7B")

    protected PendingIntent mReconnectIntent = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.731 -0500", hash_original_field = "5F0C1CC908481BAA1DC7FD09A68B1182", hash_generated_field = "D5A8886EAF52251545AC3AD33951BCDD")

    protected int mCidActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.734 -0500", hash_original_field = "9804ABD30C37981B11AC229CA949A7E7", hash_generated_field = "520BD7D1996D720DF52FDD45FFE94136")

    protected boolean mAutoAttachOnCreation = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.736 -0500", hash_original_field = "BFD2F69E597C59B4D1EF243BAD42EF45", hash_generated_field = "27B6BC94522FC90D648A32070636C6CD")

    // (TODO: Reconsider tying directly to screen, maybe this is
    //        really a lower power mode")
    protected boolean mIsScreenOn = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.739 -0500", hash_original_field = "442D866D9A5B75F9B9EBCC188B42F180", hash_generated_field = "E7C2C970E82ACEA7CAE10990548181FE")

    protected AtomicInteger mUniqueIdGenerator = new AtomicInteger(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.741 -0500", hash_original_field = "CA91CCBBE4FEADF14344511D9A6BFF42", hash_generated_field = "F773E5340FE87B52017BDABC34CF0248")

    protected HashMap<Integer, DataConnection> mDataConnections =
        new HashMap<Integer, DataConnection>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.744 -0500", hash_original_field = "5E28CA37EBD4E67C8589CB6D56FB2A1A", hash_generated_field = "22F5DEEB14FFD2F3D69D57FCCF0F9FB1")

    protected HashMap<Integer, DataConnectionAc> mDataConnectionAsyncChannels =
        new HashMap<Integer, DataConnectionAc>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.747 -0500", hash_original_field = "1114796ECB354FB8133603D04C6663BB", hash_generated_field = "E1D4371B7D81B0ADAB75212C0682A1E6")

    protected HashMap<String, Integer> mApnToDataConnectionId =
                                    new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.750 -0500", hash_original_field = "10CEA09B3F39117C24724886ACB3AAC3", hash_generated_field = "941E5870BFAF3D02817684E802B4207E")

    protected ConcurrentHashMap<String, ApnContext> mApnContexts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.752 -0500", hash_original_field = "620B27B5F01A8DDC56E70E8E7220D2AD", hash_generated_field = "910D7E883F89F3141D476B143EF29779")

    protected ApnSetting mActiveApn;
    
    public enum State {
        IDLE,
        INITING,
        CONNECTING,
        SCANNING,
        CONNECTED,
        DISCONNECTING,
        FAILED
    }
    
    public enum Activity {
        NONE,
        DATAIN,
        DATAOUT,
        DATAINANDOUT,
        DORMANT
    }
    
    private class DataRoamingSettingObserver extends ContentObserver {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.776 -0500", hash_original_method = "BA61ACB3318576C64C09DAC113E0795F", hash_generated_method = "7D3CE92A8D35A5442F42570A361253C9")
        
public DataRoamingSettingObserver(Handler handler) {
            super(handler);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.779 -0500", hash_original_method = "B90ABFF6DE01DDCB354DDF92EE51905A", hash_generated_method = "8868E3F2C934B27A85CF6DBD989F850A")
        
public void register(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            resolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.782 -0500", hash_original_method = "A96EEB9B30A252CB5EDDDA8B92E0867E", hash_generated_method = "E1B50F04A46121DF797385C72BBA45D1")
        
public void unregister(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            resolver.unregisterContentObserver(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.784 -0500", hash_original_method = "169C7D81EE3F2154C9E94D652CC4F700", hash_generated_method = "002E7048168B64D654377757DC2AB741")
        
@Override
        public void onChange(boolean selfChange) {
            // already running on mPhone handler thread
            handleDataOnRoamingChange();
        }
        
    }
    
    public class TxRxSum {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.789 -0500", hash_original_field = "C3C93998FC50AF936715836E1BB49D42", hash_generated_field = "31EBFEDBE9880286CAB65EBD7356F689")

        public long txPkts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.792 -0500", hash_original_field = "BFFE555AE4034AADC56FE3CAEC20A034", hash_generated_field = "FFD759E6497E1FB8FF7E9F7E8C351B73")

        public long rxPkts;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.795 -0500", hash_original_method = "A9FFC39802399C2580CE69B9ED52FB70", hash_generated_method = "D3FFCEBCE8E7D14DAEE8776A2B88F313")
        
public TxRxSum() {
            reset();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.798 -0500", hash_original_method = "CBCCCAC9E5E65AD1C4A36F84309761F3", hash_generated_method = "826A761F9784A84D6F41D0BF745B3F56")
        
public TxRxSum(long txPkts, long rxPkts) {
            this.txPkts = txPkts;
            this.rxPkts = rxPkts;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.801 -0500", hash_original_method = "AD3F4A8C32B5AB82EFF11F34262CA97C", hash_generated_method = "D42EB5641E461870144C7609AAC48B01")
        
public TxRxSum(TxRxSum sum) {
            txPkts = sum.txPkts;
            rxPkts = sum.rxPkts;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.803 -0500", hash_original_method = "AC7E7693FF46B721A881337A05B09C85", hash_generated_method = "2F928DBE2508DA471087EEA2F5B12AB7")
        
public void reset() {
            txPkts = -1;
            rxPkts = -1;
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.806 -0500", hash_original_method = "1CA3D86B2E80A8520E2DD65A646FFF96", hash_generated_method = "F4BC7C3DD0DC1F5D553327EA4D599FD6")
        
public String toString() {
            return "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.809 -0500", hash_original_method = "4A3A2BC6E4110C10924DC1B1F4DD1644", hash_generated_method = "45D2CA9D821ABED0EB416FECF21BD2C8")
        
public void updateTxRxSum() {
            boolean txUpdated = false, rxUpdated = false;
            long txSum = 0, rxSum = 0;
            for (ApnContext apnContext : mApnContexts.values()) {
                if (apnContext.getState() == State.CONNECTED) {
                    DataConnectionAc dcac = apnContext.getDataConnectionAc();
                    if (dcac == null) continue;

                    LinkProperties linkProp = dcac.getLinkPropertiesSync();
                    if (linkProp == null) continue;

                    String iface = linkProp.getInterfaceName();

                    if (iface != null) {
                        long stats = TrafficStats.getTxPackets(iface);
                        if (stats > 0) {
                            txUpdated = true;
                            txSum += stats;
                        }
                        stats = TrafficStats.getRxPackets(iface);
                        if (stats > 0) {
                            rxUpdated = true;
                            rxSum += stats;
                        }
                    }
                }
            }
            if (txUpdated) this.txPkts = txSum;
            if (rxUpdated) this.rxPkts = rxSum;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.754 -0500", hash_original_field = "AB7FAD359F47B9107F8FDDF019964E3C", hash_generated_field = "D877191FC5F094158A904672156AA8C5")

    protected ArrayList<ApnSetting> mAllApns = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.757 -0500", hash_original_field = "86BBE37C3E79E1AA9175DF357ED5FF39", hash_generated_field = "FC9CCB9D49A758A95E153C604DAFC1C3")

    protected ApnSetting mPreferredApn = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.759 -0500", hash_original_field = "8D5CC288A9A91C63CC14AB61D726E43D", hash_generated_field = "B458E88DEC049EDD2472BF239226E4CB")

    protected boolean mIsPsRestricted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.762 -0500", hash_original_field = "61530119F3EC643B94F1E4D30FE717D1", hash_generated_field = "0421A765569015D55BB5FDAB22E936EA")

    protected boolean mIsDisposed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.972 -0400", hash_original_field = "3DC9FC0A8AC52E83B9299E90E867B385", hash_generated_field = "50B61350598B45B5FA16B7596B8B9FD4")

    protected BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.972 -0400", hash_original_method = "1961A46761D2A74B4BBC61E9BCC43068", hash_generated_method = "0252BFECBC373E4A0BFABE33F7D5DC8C")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            String action = intent.getAction();
            log("onReceive: action=" + action);
            {
                boolean var96145FA3EA33578069DB26D54E8F101D_86358011 = (action.equals(Intent.ACTION_SCREEN_ON));
                {
                    mIsScreenOn = true;
                    stopNetStatPoll();
                    startNetStatPoll();
                } 
                {
                    boolean var767BEBC8FC1BF29BC19AA771B91C30DC_893184092 = (action.equals(Intent.ACTION_SCREEN_OFF));
                    {
                        mIsScreenOn = false;
                        stopNetStatPoll();
                        startNetStatPoll();
                    } 
                    {
                        boolean var657B0255569FEE532E29E31650D4768F_414353654 = (action.startsWith(getActionIntentReconnectAlarm()));
                        {
                            log("Reconnect alarm. Previous state was " + mState);
                            onActionIntentReconnectAlarm(intent);
                        } 
                        {
                            boolean var36F8FFF0AF59FF54D7904599A20B6C27_201922250 = (action.equals(getActionIntentDataStallAlarm()));
                            {
                                onActionIntentDataStallAlarm(intent);
                            } 
                            {
                                boolean varAEED26211C259A659D32D3D5886FD918_605196215 = (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION));
                                {
                                    final android.net.NetworkInfo networkInfo = (NetworkInfo)
                        intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                                    mIsWifiConnected = (networkInfo != null && networkInfo.isConnected());
                                } 
                                {
                                    boolean var63C3653546FDFD746F5A5E4F5D93A7DF_1402023471 = (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION));
                                    {
                                        final boolean enabled = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                        WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_ENABLED;
                                        {
                                            mIsWifiConnected = false;
                                        } 
                                    } 
                                    {
                                        boolean varC1CD06FA6A7988C248E9A4EC09E1418D_1720769185 = (action.equals(INTENT_SET_FAIL_DATA_SETUP_COUNTER));
                                        {
                                            mFailDataSetupCounter = intent.getIntExtra(FAIL_DATA_SETUP_COUNTER, 1);
                                            mFailDataSetupFailCause = FailCause.fromInt(
                        intent.getIntExtra(FAIL_DATA_SETUP_FAIL_CAUSE,
                                                    FailCause.ERROR_UNSPECIFIED.getErrorCode()));
                                            log("set mFailDataSetupCounter=" + mFailDataSetupCounter +
                        " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.772 -0500", hash_original_field = "FD89FF4870F32C249FEC9C1DBC690F01", hash_generated_field = "6D8A2CC8A7E85CEA15EFEA2E663FA6FC")

    private  DataRoamingSettingObserver mDataRoamingSettingObserver;

    /**
     * Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.823 -0500", hash_original_method = "3BD12FD7917DD1B6F1FA4984E09C99CB", hash_generated_method = "03AB8C45C17BCDBEFF712CED5C5E5B29")
    
protected DataConnectionTracker(PhoneBase phone) {
        super();
        mPhone = phone;

        IntentFilter filter = new IntentFilter();
        filter.addAction(getActionIntentReconnectAlarm());
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(INTENT_SET_FAIL_DATA_SETUP_COUNTER);

        mUserDataEnabled = Settings.Secure.getInt(
                mPhone.getContext().getContentResolver(), Settings.Secure.MOBILE_DATA, 1) == 1;

        // TODO: Why is this registering the phone as the receiver of the intent
        //       and not its own handler?
        mPhone.getContext().registerReceiver(mIntentReceiver, filter, null, mPhone);

        // This preference tells us 1) initial condition for "dataEnabled",
        // and 2) whether the RIL will setup the baseband to auto-PS attach.

        dataEnabled[APN_DEFAULT_ID] = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP,
                                                                  true);
        if (dataEnabled[APN_DEFAULT_ID]) {
            enabledCount++;
        }

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mPhone.getContext());
        mAutoAttachOnCreation = sp.getBoolean(PhoneBase.DATA_DISABLED_ON_BOOT_KEY, false);

        // watch for changes to Settings.Secure.DATA_ROAMING
        mDataRoamingSettingObserver = new DataRoamingSettingObserver(mPhone);
        mDataRoamingSettingObserver.register(mPhone.getContext());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.814 -0500", hash_original_method = "C16C211E95AFFD72D353E5EF5692A650", hash_generated_method = "58383279ADF261C01FB5569EE52D78B4")
    
protected boolean isDataSetupCompleteOk(AsyncResult ar) {
        if (ar.exception != null) {
            if (DBG) log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
            return false;
        }
        if (mFailDataSetupCounter <= 0) {
            if (DBG) log("isDataSetupCompleteOk return true");
            return true;
        }
        ar.result = mFailDataSetupFailCause;
        if (DBG) {
            log("isDataSetupCompleteOk return false" +
                    " mFailDataSetupCounter=" + mFailDataSetupCounter +
                    " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        }
        mFailDataSetupCounter -= 1;
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.816 -0500", hash_original_method = "838D9E0EFB087A153045FCBAD3FD613D", hash_generated_method = "8BCD50D3EA4627687C1C3909353C128B")
    
protected void onActionIntentReconnectAlarm(Intent intent) {
        String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        if (mState == State.FAILED) {
            Message msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            msg.arg1 = 0; // tearDown is false
            msg.arg2 = 0;
            msg.obj = reason;
            sendMessage(msg);
        }
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.819 -0500", hash_original_method = "A1F89C02319CA5D605879D459A1AC731", hash_generated_method = "B9BD52F42A59F0B4D4065AFD82408CD2")
    
protected void onActionIntentDataStallAlarm(Intent intent) {
        if (VDBG) log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        Message msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.825 -0500", hash_original_method = "D3ED6AC13F3F749DE4F1E160957198B8", hash_generated_method = "FEF335DC681D0FDF939F1F62E7DA93F4")
    
public void dispose() {
        for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            dcac.disconnect();
        }
        mDataConnectionAsyncChannels.clear();
        mIsDisposed = true;
        mPhone.getContext().unregisterReceiver(this.mIntentReceiver);
        mDataRoamingSettingObserver.unregister(mPhone.getContext());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.828 -0500", hash_original_method = "DDDDA1A5545DB0A17ACC18101B011287", hash_generated_method = "FB03AD141D8F10627EC1D539DF9AA249")
    
protected void broadcastMessenger() {
        Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        mPhone.getContext().sendBroadcast(intent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.830 -0500", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "6154C0C66EEAB7E63B19849EC009D22A")
    
public Activity getActivity() {
        return mActivity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.832 -0500", hash_original_method = "125099B58F8163C25EB6B1F0707923F4", hash_generated_method = "9B7B27939C20988783E7FD520724271B")
    
public boolean isApnTypeActive(String type) {
        // TODO: support simultaneous with List instead
        if (Phone.APN_TYPE_DUN.equals(type)) {
            ApnSetting dunApn = fetchDunApn();
            if (dunApn != null) {
                return ((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString())));
            }
        }
        return mActiveApn != null && mActiveApn.canHandleType(type);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.835 -0500", hash_original_method = "616B5B126FC289B3EB6BE1030B710468", hash_generated_method = "299CCFAA2BEFF1DFA7967A06BC92135D")
    
protected ApnSetting fetchDunApn() {
        Context c = mPhone.getContext();
        String apnData = Settings.Secure.getString(c.getContentResolver(),
                Settings.Secure.TETHER_DUN_APN);
        ApnSetting dunSetting = ApnSetting.fromString(apnData);
        if (dunSetting != null) return dunSetting;

        apnData = c.getResources().getString(R.string.config_tether_apndata);
        return ApnSetting.fromString(apnData);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.838 -0500", hash_original_method = "F0E40F922DBB5D19CCBEC497FB284EC5", hash_generated_method = "3C8630F9C9501F1AB2804AB7F541036B")
    
public String[] getActiveApnTypes() {
        String[] result;
        if (mActiveApn != null) {
            result = mActiveApn.types;
        } else {
            result = new String[1];
            result[0] = Phone.APN_TYPE_DEFAULT;
        }
        return result;
    }

    /** TODO: See if we can remove */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.840 -0500", hash_original_method = "8A278F7563F3F2CC899D3E200DD135CD", hash_generated_method = "FB991663E13AFA443E16119C0A065FA9")
    
public String getActiveApnString(String apnType) {
        String result = null;
        if (mActiveApn != null) {
            result = mActiveApn.apn;
        }
        return result;
    }

    /**
     * Modify {@link Settings.Secure#DATA_ROAMING} value.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.843 -0500", hash_original_method = "B18C74BBD4D71B87D6CD20822DAEB60C", hash_generated_method = "909C89967B5674477BE95216DC03A2D4")
    
public void setDataOnRoamingEnabled(boolean enabled) {
        if (getDataOnRoamingEnabled() != enabled) {
            final ContentResolver resolver = mPhone.getContext().getContentResolver();
            Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
            // will trigger handleDataOnRoamingChange() through observer
        }
    }

    /**
     * Return current {@link Settings.Secure#DATA_ROAMING} value.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.846 -0500", hash_original_method = "CA847DB1E96260749F912EC65B12A685", hash_generated_method = "1E692CEF67BA5E81F641FF67AFC4C082")
    
public boolean getDataOnRoamingEnabled() {
        try {
            final ContentResolver resolver = mPhone.getContext().getContentResolver();
            return Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0;
        } catch (SettingNotFoundException snfe) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.848 -0500", hash_original_method = "D53421F789432FAA1BE4F347AFB92C88", hash_generated_method = "531F0996271BFD729AA050224A6C62AF")
    
private void handleDataOnRoamingChange() {
        if (mPhone.getServiceState().getRoaming()) {
            if (getDataOnRoamingEnabled()) {
                resetAllRetryCounts();
            }
            sendMessage(obtainMessage(EVENT_ROAMING_ON));
        }
    }

    // abstract methods
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.851 -0500", hash_original_method = "2012020E588CEEA07B7EB708DEEEB1B9", hash_generated_method = "07DFE59F4E7B16364F9B5C79F690A587")
    
protected abstract String getActionIntentReconnectAlarm();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.853 -0500", hash_original_method = "1CB8EB5211B5F886D7B8EBB8EC22CD57", hash_generated_method = "B65918E13AFF9CC61F1A55D3EFC582B1")
    
protected abstract String getActionIntentDataStallAlarm();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.855 -0500", hash_original_method = "A44B84207D5FEA00852D820EA7B21A45", hash_generated_method = "B20D244AB51B62F9597DBFFDA31BA1C2")
    
protected abstract void startNetStatPoll();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.857 -0500", hash_original_method = "602FDBF457BE376E81403052D70BA305", hash_generated_method = "F218368821D052E29DD1C347E02778D0")
    
protected abstract void stopNetStatPoll();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.860 -0500", hash_original_method = "C77812435437F76A99F0752F61D7BD78", hash_generated_method = "4FC764802937F30C0E464633A21EE8BA")
    
protected abstract void restartRadio();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.862 -0500", hash_original_method = "48DBEBE9679DD6022C78E9B6D9D15841", hash_generated_method = "43827D28600B8F0847D532E80E30A990")
    
protected abstract void log(String s);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.864 -0500", hash_original_method = "8503C48BD28DECE909202E8D31B4BECE", hash_generated_method = "98998146AAEFC08A350487078A6888FB")
    
protected abstract void loge(String s);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.867 -0500", hash_original_method = "F6B78C14D197B513C8850E81B32E4262", hash_generated_method = "F05E24CF43DD0B4B12DC95652E89F958")
    
protected abstract boolean isDataAllowed();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.870 -0500", hash_original_method = "130D29CE493449FEC0FB75884B98F60C", hash_generated_method = "7C87DED4CF1C92B358B340108C501B01")
    
protected abstract boolean isApnTypeAvailable(String type);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.872 -0500", hash_original_method = "19F1795E8E0DB5C064C787124E4EE9FA", hash_generated_method = "47A20D8ABEED8DFE4F78FE68119F4B2B")
    
public    abstract State getState(String apnType);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.874 -0500", hash_original_method = "81F6B0782CAB75D9D6FEDF3792241E41", hash_generated_method = "D87F31D184D451CDFD0B3B3975A5863A")
    
protected abstract void setState(State s);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.877 -0500", hash_original_method = "DA6DD81F7FC526F28D624059F15206A3", hash_generated_method = "82128E3CB3CB2C303349E9B7F6425951")
    
protected abstract void gotoIdleAndNotifyDataConnection(String reason);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.879 -0500", hash_original_method = "EB097F677BCBED6EB86237833DEBC082", hash_generated_method = "6294D54DB550784B4E3C6FE24618688A")
    
protected abstract boolean onTrySetupData(String reason);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.882 -0500", hash_original_method = "8C9FE2ADB7F5A6C04946E60BC019D8B1", hash_generated_method = "0E773087A1A27144193FA2A2637C51A6")
    
protected abstract void onRoamingOff();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.884 -0500", hash_original_method = "2CFEDAD2A9C9E9A45E26A2D960DF9585", hash_generated_method = "F4A42EAA276640EFC5165CC6E8E81037")
    
protected abstract void onRoamingOn();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.887 -0500", hash_original_method = "F9A16E21EA7FC200AAB1B517843F3C6D", hash_generated_method = "085FFDD9C2BB46C3C88388D91EFF45E8")
    
protected abstract void onRadioAvailable();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.890 -0500", hash_original_method = "758F039A900656878509DDA234D7AEB8", hash_generated_method = "6BEE21FF2E8E14B94D8570914FC779E5")
    
protected abstract void onRadioOffOrNotAvailable();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.892 -0500", hash_original_method = "D73C9FE8C0314CBFE7A866786A4386C4", hash_generated_method = "2D6B5A13482EDD09AFB2746AB6EEBB4F")
    
protected abstract void onDataSetupComplete(AsyncResult ar);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.895 -0500", hash_original_method = "DE6E41DB2D3F1B9CDCDBA4138489278B", hash_generated_method = "2CC33001AC5C84D02F1C79C18E0EEB17")
    
protected abstract void onDisconnectDone(int connId, AsyncResult ar);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.897 -0500", hash_original_method = "424D67D7BCD8750992A0192EFA72CB95", hash_generated_method = "FAE9C7BEAB57AF6470CC7CC8841ABF52")
    
protected abstract void onVoiceCallStarted();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.899 -0500", hash_original_method = "F179B8ED631B30ABC684D5439D815095", hash_generated_method = "5B734EBF19059E8B112B67AE2F0EC75C")
    
protected abstract void onVoiceCallEnded();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.902 -0500", hash_original_method = "1C3E8D0AB9D5543BD1D549743FC04882", hash_generated_method = "6F85799D039DCA082F8B958F3B0273BF")
    
protected abstract void onCleanUpConnection(boolean tearDown, int apnId, String reason);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.904 -0500", hash_original_method = "05E72BAF77148F4BECF5D3BD8DF7EAC3", hash_generated_method = "9C5B9CD8A59D5B61F8CB89B46C58281B")
    
protected abstract void onCleanUpAllConnections(String cause);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.906 -0500", hash_original_method = "C1E7EC6E282382B45C353ECA53713605", hash_generated_method = "6F08FF359CEE4D9E6C7CCCBC6E0D2ED4")
    
protected abstract boolean isDataPossible(String apnType);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.908 -0500", hash_original_method = "664FE2A04A36F386D94369A328F3D0AD", hash_generated_method = "C8A7AAB66E0885168547D3F6475BA69D")
    
protected void onDataStallAlarm(int tag) {
        loge("onDataStallAlarm: not impleted tag=" + tag);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.914 -0500", hash_original_method = "F3EE7F03AAF60471D3A97F562455D5DC", hash_generated_method = "BCFC1DBBA7474F43F9FCBD6F645E4BB7")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case AsyncChannel.CMD_CHANNEL_DISCONNECTED: {
                log("DISCONNECTED_CONNECTED: msg=" + msg);
                DataConnectionAc dcac = (DataConnectionAc) msg.obj;
                mDataConnectionAsyncChannels.remove(dcac.dataConnection.getDataConnectionId());
                dcac.disconnected();
                break;
            }
            case EVENT_ENABLE_NEW_APN:
                onEnableApn(msg.arg1, msg.arg2);
                break;

            case EVENT_TRY_SETUP_DATA:
                String reason = null;
                if (msg.obj instanceof String) {
                    reason = (String) msg.obj;
                }
                onTrySetupData(reason);
                break;

            case EVENT_DATA_STALL_ALARM:
                onDataStallAlarm(msg.arg1);
                break;

            case EVENT_ROAMING_OFF:
                if (getDataOnRoamingEnabled() == false) {
                    resetAllRetryCounts();
                }
                onRoamingOff();
                break;

            case EVENT_ROAMING_ON:
                onRoamingOn();
                break;

            case EVENT_RADIO_AVAILABLE:
                onRadioAvailable();
                break;

            case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
                onRadioOffOrNotAvailable();
                break;

            case EVENT_DATA_SETUP_COMPLETE:
                mCidActive = msg.arg1;
                onDataSetupComplete((AsyncResult) msg.obj);
                break;

            case EVENT_DISCONNECT_DONE:
                log("DataConnectoinTracker.handleMessage: EVENT_DISCONNECT_DONE msg=" + msg);
                onDisconnectDone(msg.arg1, (AsyncResult) msg.obj);
                break;

            case EVENT_VOICE_CALL_STARTED:
                onVoiceCallStarted();
                break;

            case EVENT_VOICE_CALL_ENDED:
                onVoiceCallEnded();
                break;

            case EVENT_CLEAN_UP_ALL_CONNECTIONS: {
                onCleanUpAllConnections((String) msg.obj);
                break;
            }
            case EVENT_CLEAN_UP_CONNECTION: {
                boolean tearDown = (msg.arg1 == 0) ? false : true;
                onCleanUpConnection(tearDown, msg.arg2, (String) msg.obj);
                break;
            }
            case EVENT_SET_INTERNAL_DATA_ENABLE: {
                boolean enabled = (msg.arg1 == ENABLED) ? true : false;
                onSetInternalDataEnabled(enabled);
                break;
            }
            case EVENT_RESET_DONE: {
                if (DBG) log("EVENT_RESET_DONE");
                onResetDone((AsyncResult) msg.obj);
                break;
            }
            case CMD_SET_USER_DATA_ENABLE: {
                final boolean enabled = (msg.arg1 == ENABLED) ? true : false;
                if (DBG) log("CMD_SET_USER_DATA_ENABLE enabled=" + enabled);
                onSetUserDataEnabled(enabled);
                break;
            }
            case CMD_SET_DEPENDENCY_MET: {
                boolean met = (msg.arg1 == ENABLED) ? true : false;
                if (DBG) log("CMD_SET_DEPENDENCY_MET met=" + met);
                Bundle bundle = msg.getData();
                if (bundle != null) {
                    String apnType = (String)bundle.get(APN_TYPE_KEY);
                    if (apnType != null) {
                        onSetDependencyMet(apnType, met);
                    }
                }
                break;
            }
            case CMD_SET_POLICY_DATA_ENABLE: {
                final boolean enabled = (msg.arg1 == ENABLED) ? true : false;
                onSetPolicyDataEnabled(enabled);
                break;
            }
            default:
                Log.e("DATA", "Unidentified event msg=" + msg);
                break;
        }
    }

    /**
     * Report on whether data connectivity is enabled
     *
     * @return {@code false} if data connectivity has been explicitly disabled,
     *         {@code true} otherwise.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.917 -0500", hash_original_method = "8F4FE806494E709DA803471FC4054850", hash_generated_method = "F16624BDA1D8D1C06F3D63584DD8A331")
    
public boolean getAnyDataEnabled() {
        final boolean result;
        synchronized (mDataEnabledLock) {
            result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    && (enabledCount != 0));
        }
        if (!result && DBG) log("getAnyDataEnabled " + result);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.919 -0500", hash_original_method = "01BBE084CAD104CD5BF824EF92BD879D", hash_generated_method = "1E8173B141205083721B2C0AB34B5B62")
    
protected boolean isEmergency() {
        final boolean result;
        synchronized (mDataEnabledLock) {
            result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        }
        log("isEmergency: result=" + result);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.922 -0500", hash_original_method = "5D23D8F3C80DDDEC0087C53C5035314E", hash_generated_method = "A50C601BC407BA45178DC11C2FDA4C8E")
    
protected int apnTypeToId(String type) {
        if (TextUtils.equals(type, Phone.APN_TYPE_DEFAULT)) {
            return APN_DEFAULT_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_MMS)) {
            return APN_MMS_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_SUPL)) {
            return APN_SUPL_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_DUN)) {
            return APN_DUN_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_HIPRI)) {
            return APN_HIPRI_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_IMS)) {
            return APN_IMS_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_FOTA)) {
            return APN_FOTA_ID;
        } else if (TextUtils.equals(type, Phone.APN_TYPE_CBS)) {
            return APN_CBS_ID;
        } else {
            return APN_INVALID_ID;
        }
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.925 -0500", hash_original_method = "C8FDA5A0B2174A5D621C26D6E6AEF75F", hash_generated_method = "A6AB7D90EA889D37DD9A9B62722F5640")
    
protected String apnIdToType(int id) {
        switch (id) {
        case APN_DEFAULT_ID:
            return Phone.APN_TYPE_DEFAULT;
        case APN_MMS_ID:
            return Phone.APN_TYPE_MMS;
        case APN_SUPL_ID:
            return Phone.APN_TYPE_SUPL;
        case APN_DUN_ID:
            return Phone.APN_TYPE_DUN;
        case APN_HIPRI_ID:
            return Phone.APN_TYPE_HIPRI;
        case APN_IMS_ID:
            return Phone.APN_TYPE_IMS;
        case APN_FOTA_ID:
            return Phone.APN_TYPE_FOTA;
        case APN_CBS_ID:
            return Phone.APN_TYPE_CBS;
        default:
            log("Unknown id (" + id + ") in apnIdToType");
            return Phone.APN_TYPE_DEFAULT;
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.927 -0500", hash_original_method = "C93C3112872052D96A1B607494195947", hash_generated_method = "DF4A3F4258C880868F1D9CBAD1C757A3")
    
protected LinkProperties getLinkProperties(String apnType) {
        int id = apnTypeToId(apnType);

        if (isApnIdEnabled(id)) {
            // TODO - remove this cdma-only hack and support multiple DCs.
            DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            return dcac.getLinkPropertiesSync();
        } else {
            return new LinkProperties();
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.930 -0500", hash_original_method = "8B34AF8E1FD52F7524E0692F560388F1", hash_generated_method = "A8F5DB61D1D001922CBFEA75CF730C31")
    
protected LinkCapabilities getLinkCapabilities(String apnType) {
        int id = apnTypeToId(apnType);
        if (isApnIdEnabled(id)) {
            // TODO - remove this cdma-only hack and support multiple DCs.
            DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            return dcac.getLinkCapabilitiesSync();
        } else {
            return new LinkCapabilities();
        }
    }

    // tell all active apns of the current condition
    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.932 -0500", hash_original_method = "EA8A5478D5AABF3FA098569BF99381B3", hash_generated_method = "17DAD7B11EAF3934C5AF8231D55EF480")
    
protected void notifyDataConnection(String reason) {
        for (int id = 0; id < APN_NUM_TYPES; id++) {
            if (dataEnabled[id]) {
                mPhone.notifyDataConnection(reason, apnIdToType(id));
            }
        }
        notifyOffApnsOfAvailability(reason);
    }

    // a new APN has gone active and needs to send events to catch up with the
    // current condition
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.936 -0500", hash_original_method = "0EE2FD1B724C501D31FB7072BBECFF7B", hash_generated_method = "C39D3E723CA8E2DEA4773792403C16C0")
    
private void notifyApnIdUpToCurrent(String reason, int apnId) {
        switch (mState) {
            case IDLE:
            case INITING:
                break;
            case CONNECTING:
            case SCANNING:
                mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
                break;
            case CONNECTED:
            case DISCONNECTING:
                mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
                mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
                break;
        }
    }

    // since we normally don't send info to a disconnected APN, we need to do this specially
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.938 -0500", hash_original_method = "D45BD11E51C479A3FCCFFBAFE72F463B", hash_generated_method = "E83C7FAC143A3674F29F4186CCE707F3")
    
private void notifyApnIdDisconnected(String reason, int apnId) {
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
    }

    // disabled apn's still need avail/unavail notificiations - send them out
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.941 -0500", hash_original_method = "AD67DC7D8E779758CC2EF151B8EB9A25", hash_generated_method = "8E8449F656E32CF7B18CEDF297BD2FD1")
    
protected void notifyOffApnsOfAvailability(String reason) {
        if (DBG) log("notifyOffApnsOfAvailability - reason= " + reason);
        for (int id = 0; id < APN_NUM_TYPES; id++) {
            if (!isApnIdEnabled(id)) {
                notifyApnIdDisconnected(reason, id);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.943 -0500", hash_original_method = "8B5C5B568EA76224959243C3FA291570", hash_generated_method = "6520CD642D6CC9F0720B5B604EFF39C9")
    
public boolean isApnTypeEnabled(String apnType) {
        if (apnType == null) {
            return false;
        } else {
            return isApnIdEnabled(apnTypeToId(apnType));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.945 -0500", hash_original_method = "453A43A7EADEB97159250F7F1E9B04E5", hash_generated_method = "57A16508B57E83D8551041FFD9FFAD4D")
    
protected synchronized boolean isApnIdEnabled(int id) {
        if (id != APN_INVALID_ID) {
            return dataEnabled[id];
        }
        return false;
    }

    /**
     * Ensure that we are connected to an APN of the specified type.
     *
     * @param type the APN type (currently the only valid values are
     *            {@link Phone#APN_TYPE_MMS} and {@link Phone#APN_TYPE_SUPL})
     * @return Success is indicated by {@code Phone.APN_ALREADY_ACTIVE} or
     *         {@code Phone.APN_REQUEST_STARTED}. In the latter case, a
     *         broadcast will be sent by the ConnectivityManager when a
     *         connection to the APN has been established.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.948 -0500", hash_original_method = "B518CE0EFC616BFFCBE5135F2BCA33B7", hash_generated_method = "F23C0276FD7C81D8145BD4E7D03B13AE")
    
public synchronized int enableApnType(String type) {
        int id = apnTypeToId(type);
        if (id == APN_INVALID_ID) {
            return Phone.APN_REQUEST_FAILED;
        }

        if (DBG) {
            log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    + ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        }

        if (!isApnTypeAvailable(type)) {
            if (DBG) log("type not available");
            return Phone.APN_TYPE_NOT_AVAILABLE;
        }

        if (isApnIdEnabled(id)) {
            return Phone.APN_ALREADY_ACTIVE;
        } else {
            setEnabled(id, true);
        }
        return Phone.APN_REQUEST_STARTED;
    }

    /**
     * The APN of the specified type is no longer needed. Ensure that if use of
     * the default APN has not been explicitly disabled, we are connected to the
     * default APN.
     *
     * @param type the APN type. The only valid values are currently
     *            {@link Phone#APN_TYPE_MMS} and {@link Phone#APN_TYPE_SUPL}.
     * @return Success is indicated by {@code Phone.APN_ALREADY_ACTIVE} or
     *         {@code Phone.APN_REQUEST_STARTED}. In the latter case, a
     *         broadcast will be sent by the ConnectivityManager when a
     *         connection to the APN has been disconnected. A {@code
     *         Phone.APN_REQUEST_FAILED} is returned if the type parameter is
     *         invalid or if the apn wasn't enabled.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.951 -0500", hash_original_method = "A5E4EE0A9C6812357B5B6B8F3C042D82", hash_generated_method = "0FD9713F86DC4B2F192AEF2B9CD40B8A")
    
public synchronized int disableApnType(String type) {
        if (DBG) log("disableApnType(" + type + ")");
        int id = apnTypeToId(type);
        if (id == APN_INVALID_ID) {
            return Phone.APN_REQUEST_FAILED;
        }
        if (isApnIdEnabled(id)) {
            setEnabled(id, false);
            if (isApnTypeActive(Phone.APN_TYPE_DEFAULT)) {
                if (dataEnabled[APN_DEFAULT_ID]) {
                    return Phone.APN_ALREADY_ACTIVE;
                } else {
                    return Phone.APN_REQUEST_STARTED;
                }
            } else {
                return Phone.APN_REQUEST_STARTED;
            }
        } else {
            return Phone.APN_REQUEST_FAILED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.953 -0500", hash_original_method = "25F13BA52E496C8972985CBEE5B69F23", hash_generated_method = "9D9C575DA48560A10746AE1B3DDA292C")
    
protected void setEnabled(int id, boolean enable) {
        if (DBG) {
            log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    + " and enabledCount = " + enabledCount);
        }
        Message msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        msg.arg1 = id;
        msg.arg2 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.957 -0500", hash_original_method = "6346C217AE811F98B5143DCE05848411", hash_generated_method = "864F7BD80C1B84B12FB192F8B5D5E7F4")
    
protected void onEnableApn(int apnId, int enabled) {
        if (DBG) {
            log("EVENT_APN_ENABLE_REQUEST apnId=" + apnId + ", apnType=" + apnIdToType(apnId) +
                    ", enabled=" + enabled + ", dataEnabled = " + dataEnabled[apnId] +
                    ", enabledCount = " + enabledCount + ", isApnTypeActive = " +
                    isApnTypeActive(apnIdToType(apnId)));
        }
        if (enabled == ENABLED) {
            synchronized (this) {
                if (!dataEnabled[apnId]) {
                    dataEnabled[apnId] = true;
                    enabledCount++;
                }
            }
            String type = apnIdToType(apnId);
            if (!isApnTypeActive(type)) {
                mRequestedApnType = type;
                onEnableNewApn();
            } else {
                notifyApnIdUpToCurrent(Phone.REASON_APN_SWITCHED, apnId);
            }
        } else {
            // disable
            boolean didDisable = false;
            synchronized (this) {
                if (dataEnabled[apnId]) {
                    dataEnabled[apnId] = false;
                    enabledCount--;
                    didDisable = true;
                }
            }
            if (didDisable && enabledCount == 0) {
                onCleanUpConnection(true, apnId, Phone.REASON_DATA_DISABLED);

                // send the disconnect msg manually, since the normal route wont send
                // it (it's not enabled)
                notifyApnIdDisconnected(Phone.REASON_DATA_DISABLED, apnId);
                if (dataEnabled[APN_DEFAULT_ID] == true
                        && !isApnTypeActive(Phone.APN_TYPE_DEFAULT)) {
                    // TODO - this is an ugly way to restore the default conn - should be done
                    // by a real contention manager and policy that disconnects the lower pri
                    // stuff as enable requests come in and pops them back on as we disable back
                    // down to the lower pri stuff
                    mRequestedApnType = Phone.APN_TYPE_DEFAULT;
                    onEnableNewApn();
                }
            }
        }
    }

    /**
     * Called when we switch APNs.
     *
     * mRequestedApnType is set prior to call
     * To be overridden.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.959 -0500", hash_original_method = "FBAA4A80E4538BA497646C5AED60D911", hash_generated_method = "B35568080AC16DFF200086D1895FB73F")
    
protected void onEnableNewApn() {
    }

    /**
     * Called when EVENT_RESET_DONE is received so goto
     * IDLE state and send notifications to those interested.
     *
     * TODO - currently unused.  Needs to be hooked into DataConnection cleanup
     * TODO - needs to pass some notion of which connection is reset..
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.961 -0500", hash_original_method = "58B3A2A4D2FF1B49B3A412CB94198F76", hash_generated_method = "684A1A87FEDCBA5B787C5CBDC3635AA2")
    
protected void onResetDone(AsyncResult ar) {
        if (DBG) log("EVENT_RESET_DONE");
        String reason = null;
        if (ar.userObj instanceof String) {
            reason = (String) ar.userObj;
        }
        gotoIdleAndNotifyDataConnection(reason);
    }

    /**
     * Prevent mobile data connections from being established, or once again
     * allow mobile data connections. If the state toggles, then either tear
     * down or set up data, as appropriate to match the new state.
     *
     * @param enable indicates whether to enable ({@code true}) or disable (
     *            {@code false}) data
     * @return {@code true} if the operation succeeded
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.965 -0500", hash_original_method = "DE9C8D1FA305A86440711210D5CC0DFB", hash_generated_method = "3CED643382D55E933A448CE5F114064C")
    
public boolean setInternalDataEnabled(boolean enable) {
        if (DBG)
            log("setInternalDataEnabled(" + enable + ")");

        Message msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        msg.arg1 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.967 -0500", hash_original_method = "2FFC27FC9820E2F3BAEE3098A222A5B3", hash_generated_method = "BF7AA120AE65ED9BB72BC1273C58E6BB")
    
protected void onSetInternalDataEnabled(boolean enabled) {
        synchronized (mDataEnabledLock) {
            mInternalDataEnabled = enabled;
            if (enabled) {
                log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                resetAllRetryCounts();
                onTrySetupData(Phone.REASON_DATA_ENABLED);
            } else {
                log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
                cleanUpAllConnections(null);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.970 -0500", hash_original_method = "68E67092B4266000A5BC48E8C37B6ED2", hash_generated_method = "7C6D63DE5D12C2D76BBF25B4F3FCE938")
    
public void cleanUpAllConnections(String cause) {
        Message msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        msg.obj = cause;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.972 -0500", hash_original_method = "1352E38507CB0330D4BD0958B3487B84", hash_generated_method = "8FFFA0D97EDED5974C1DF739D7AC1BC8")
    
public abstract boolean isDisconnected();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.975 -0500", hash_original_method = "49C3C07E31C3EAA572D4F39FF0B691FA", hash_generated_method = "E92B9B92D693C26C40E5BC686BE5D972")
    
protected void onSetUserDataEnabled(boolean enabled) {
        synchronized (mDataEnabledLock) {
            final boolean prevEnabled = getAnyDataEnabled();
            if (mUserDataEnabled != enabled) {
                mUserDataEnabled = enabled;
                Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
                if (prevEnabled != getAnyDataEnabled()) {
                    if (!prevEnabled) {
                        resetAllRetryCounts();
                        onTrySetupData(Phone.REASON_DATA_ENABLED);
                    } else {
                        onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    }
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.977 -0500", hash_original_method = "CE2949FE6361D634BBA79ED70CC5EAE2", hash_generated_method = "3CDB37A5D6BB4501D75957488F7AFF72")
    
protected void onSetDependencyMet(String apnType, boolean met) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.980 -0500", hash_original_method = "5C2A966CAC36731C633B25393BAF4799", hash_generated_method = "828F5C6DEEE6834C114AEB7196718117")
    
protected void onSetPolicyDataEnabled(boolean enabled) {
        synchronized (mDataEnabledLock) {
            final boolean prevEnabled = getAnyDataEnabled();
            if (sPolicyDataEnabled != enabled) {
                sPolicyDataEnabled = enabled;
                if (prevEnabled != getAnyDataEnabled()) {
                    if (!prevEnabled) {
                        resetAllRetryCounts();
                        onTrySetupData(Phone.REASON_DATA_ENABLED);
                    } else {
                        onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    }
                }
            }
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.982 -0500", hash_original_method = "E5EFA23236CE13ACC69B88C6F16F1B0C", hash_generated_method = "CBDD5A06106BF60AA4986B2114C5BD24")
    
protected String getReryConfig(boolean forDefault) {
        int rt = mPhone.getServiceState().getRadioTechnology();

        if ((rt == ServiceState.RADIO_TECHNOLOGY_IS95A) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_IS95B) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_1xRTT) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EVDO_0) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EVDO_A) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EVDO_B) ||
            (rt == ServiceState.RADIO_TECHNOLOGY_EHRPD)) {
            // CDMA variant
            return SystemProperties.get("ro.cdma.data_retry_config");
        } else {
            // Use GSM varient for all others.
            if (forDefault) {
                return SystemProperties.get("ro.gsm.data_retry_config");
            } else {
                return SystemProperties.get("ro.gsm.2nd_data_retry_config");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:43.985 -0500", hash_original_method = "0FD4DA1D85F6AEE253925BB7FDB228BD", hash_generated_method = "1A70596CA84310976773227690EF4E85")
    
protected void resetAllRetryCounts() {
        for (DataConnection dc : mDataConnections.values()) {
            dc.resetRetryCount();
        }
    }
}

