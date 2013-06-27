package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SmsUsageMonitor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.093 -0400", hash_original_field = "7D2C0C2BF475877740FC4F4370379B27", hash_generated_field = "8251D8E7267A3EFD6EC445592CA97E50")

    private int mCheckPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.093 -0400", hash_original_field = "9975895F9DB80EFF35D4CCBB757209DA", hash_generated_field = "88D310A8EA39C1E84390420AD9B4808A")

    private int mMaxAllowed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.093 -0400", hash_original_field = "C43BF27E7C4A474A450E53DD288AFA67", hash_generated_field = "344057D2A728653FEC86F60CEF36E56B")

    private HashMap<String, ArrayList<Long>> mSmsStamp = new HashMap<String, ArrayList<Long>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.094 -0400", hash_original_method = "AA58276D63D2163182FD805D073EE67C", hash_generated_method = "41E1494827BFC473DCA67AF4C2849C94")
    public  SmsUsageMonitor(ContentResolver resolver) {
        mMaxAllowed = Settings.Secure.getInt(resolver,
                Settings.Secure.SMS_OUTGOING_CHECK_MAX_COUNT,
                DEFAULT_SMS_MAX_COUNT);
        mCheckPeriod = Settings.Secure.getInt(resolver,
                Settings.Secure.SMS_OUTGOING_CHECK_INTERVAL_MS,
                DEFAULT_SMS_CHECK_PERIOD);
        // ---------- Original Method ----------
        //mMaxAllowed = Settings.Secure.getInt(resolver,
                //Settings.Secure.SMS_OUTGOING_CHECK_MAX_COUNT,
                //DEFAULT_SMS_MAX_COUNT);
        //mCheckPeriod = Settings.Secure.getInt(resolver,
                //Settings.Secure.SMS_OUTGOING_CHECK_INTERVAL_MS,
                //DEFAULT_SMS_CHECK_PERIOD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.095 -0400", hash_original_method = "7B2C29F4698952FF45E2699BBB5DEB62", hash_generated_method = "F5020B67D30B77B9A0B8E7C878C54BF3")
     void dispose() {
        mSmsStamp.clear();
        // ---------- Original Method ----------
        //mSmsStamp.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.095 -0400", hash_original_method = "EA1BFE3566BC11C4D089155AC6363183", hash_generated_method = "11EF0C7F1EAC289A2CCC48CA0A4AAD06")
    public boolean check(String appName, int smsWaiting) {
        {
            removeExpiredTimestamps();
            ArrayList<Long> sentList;
            sentList = mSmsStamp.get(appName);
            {
                sentList = new ArrayList<Long>();
                mSmsStamp.put(appName, sentList);
            } //End block
            boolean var091A67795636C5B7E20E47F6F889C23B_573973362 = (isUnderLimit(sentList, smsWaiting));
        } //End block
        addTaint(appName.getTaint());
        addTaint(smsWaiting);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719964114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719964114;
        // ---------- Original Method ----------
        //synchronized (mSmsStamp) {
            //removeExpiredTimestamps();
            //ArrayList<Long> sentList = mSmsStamp.get(appName);
            //if (sentList == null) {
                //sentList = new ArrayList<Long>();
                //mSmsStamp.put(appName, sentList);
            //}
            //return isUnderLimit(sentList, smsWaiting);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.101 -0400", hash_original_method = "0C89C3F43D481EBAFC32AEEAE6183BD3", hash_generated_method = "8C4C74C969ADEFB3A0CE5FA10386D455")
    private void removeExpiredTimestamps() {
        long beginCheckPeriod;
        beginCheckPeriod = System.currentTimeMillis() - mCheckPeriod;
        {
            Iterator<Map.Entry<String, ArrayList<Long>>> iter;
            iter = mSmsStamp.entrySet().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1356651579 = (iter.hasNext());
                {
                    Map.Entry<String, ArrayList<Long>> entry;
                    entry = iter.next();
                    ArrayList<Long> oldList;
                    oldList = entry.getValue();
                    {
                        boolean var6B058BCE74663B8CCC2D65D7403CD832_993819913 = (oldList.isEmpty() || oldList.get(oldList.size() - 1) < beginCheckPeriod);
                        {
                            iter.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //long beginCheckPeriod = System.currentTimeMillis() - mCheckPeriod;
        //synchronized (mSmsStamp) {
            //Iterator<Map.Entry<String, ArrayList<Long>>> iter = mSmsStamp.entrySet().iterator();
            //while (iter.hasNext()) {
                //Map.Entry<String, ArrayList<Long>> entry = iter.next();
                //ArrayList<Long> oldList = entry.getValue();
                //if (oldList.isEmpty() || oldList.get(oldList.size() - 1) < beginCheckPeriod) {
                    //iter.remove();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.102 -0400", hash_original_method = "FED252455D0F59F9866280B84F72F407", hash_generated_method = "43233381937D6BDF44E3A84348323F53")
    private boolean isUnderLimit(ArrayList<Long> sent, int smsWaiting) {
        Long ct;
        ct = System.currentTimeMillis();
        long beginCheckPeriod;
        beginCheckPeriod = ct - mCheckPeriod;
        Log.d(TAG, "SMS send size=" + sent.size() + " time=" + ct);
        {
            boolean var5667D581C2F5DFCA02DEFCCDFE1CFB02_986386392 = (!sent.isEmpty() && sent.get(0) < beginCheckPeriod);
            {
                sent.remove(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDFD6A4FA9327973346539BB265A37305_1475394462 = ((sent.size() + smsWaiting) <= mMaxAllowed);
            {
                {
                    int i;
                    i = 0;
                    {
                        sent.add(ct);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(sent.getTaint());
        addTaint(smsWaiting);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_947544342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_947544342;
        // ---------- Original Method ----------
        //Long ct = System.currentTimeMillis();
        //long beginCheckPeriod = ct - mCheckPeriod;
        //Log.d(TAG, "SMS send size=" + sent.size() + " time=" + ct);
        //while (!sent.isEmpty() && sent.get(0) < beginCheckPeriod) {
            //sent.remove(0);
        //}
        //if ((sent.size() + smsWaiting) <= mMaxAllowed) {
            //for (int i = 0; i < smsWaiting; i++ ) {
                //sent.add(ct);
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.102 -0400", hash_original_field = "35B10AB3CDA09F3B2F3131AD6DBAA325", hash_generated_field = "3D20442FA204AFA6A0E06C1C02874F18")

    private static String TAG = "SmsStorageMonitor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.102 -0400", hash_original_field = "86C04E306979E0A3ED6C10E477ABFEDA", hash_generated_field = "5185F3B2E79B05237C76E54CB8486A17")

    private static int DEFAULT_SMS_CHECK_PERIOD = 3600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:18.102 -0400", hash_original_field = "5B383FE3921C2BBCDC2AD6E7B1F1197C", hash_generated_field = "19B0A01E258D04139A95054354C2C76B")

    private static int DEFAULT_SMS_MAX_COUNT = 100;
}

