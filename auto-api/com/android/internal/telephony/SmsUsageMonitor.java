package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SmsUsageMonitor {
    private static final String TAG = "SmsStorageMonitor";
    private static final int DEFAULT_SMS_CHECK_PERIOD = 3600000;
    private static final int DEFAULT_SMS_MAX_COUNT = 100;
    private final int mCheckPeriod;
    private final int mMaxAllowed;
    private final HashMap<String, ArrayList<Long>> mSmsStamp =
            new HashMap<String, ArrayList<Long>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.595 -0400", hash_original_method = "AA58276D63D2163182FD805D073EE67C", hash_generated_method = "1A8134C88E994DA1566C0208CECF2814")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SmsUsageMonitor(ContentResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.595 -0400", hash_original_method = "7B2C29F4698952FF45E2699BBB5DEB62", hash_generated_method = "AD9A05079138BC0E0B5E9B3CAB0C660C")
    @DSModeled(DSC.SAFE)
     void dispose() {
        mSmsStamp.clear();
        // ---------- Original Method ----------
        //mSmsStamp.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.595 -0400", hash_original_method = "EA1BFE3566BC11C4D089155AC6363183", hash_generated_method = "FC9114E55A6EF29689E744DBD3705835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean check(String appName, int smsWaiting) {
        dsTaint.addTaint(appName);
        dsTaint.addTaint(smsWaiting);
        {
            removeExpiredTimestamps();
            ArrayList<Long> sentList;
            sentList = mSmsStamp.get(appName);
            {
                sentList = new ArrayList<Long>();
                mSmsStamp.put(appName, sentList);
            } //End block
            boolean var091A67795636C5B7E20E47F6F889C23B_1743756311 = (isUnderLimit(sentList, smsWaiting));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.595 -0400", hash_original_method = "0C89C3F43D481EBAFC32AEEAE6183BD3", hash_generated_method = "7C4CEC7A08A86A2982A89D7C679B12AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeExpiredTimestamps() {
        long beginCheckPeriod;
        beginCheckPeriod = System.currentTimeMillis() - mCheckPeriod;
        {
            Iterator<Map.Entry<String, ArrayList<Long>>> iter;
            iter = mSmsStamp.entrySet().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_383899134 = (iter.hasNext());
                {
                    Map.Entry<String, ArrayList<Long>> entry;
                    entry = iter.next();
                    ArrayList<Long> oldList;
                    oldList = entry.getValue();
                    {
                        boolean var6B058BCE74663B8CCC2D65D7403CD832_681874426 = (oldList.isEmpty() || oldList.get(oldList.size() - 1) < beginCheckPeriod);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.596 -0400", hash_original_method = "FED252455D0F59F9866280B84F72F407", hash_generated_method = "825814E56E6E762D954A46D3F5AFA7C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isUnderLimit(ArrayList<Long> sent, int smsWaiting) {
        dsTaint.addTaint(sent.dsTaint);
        dsTaint.addTaint(smsWaiting);
        Long ct;
        ct = System.currentTimeMillis();
        long beginCheckPeriod;
        beginCheckPeriod = ct - mCheckPeriod;
        Log.d(TAG, "SMS send size=" + sent.size() + " time=" + ct);
        {
            boolean var5667D581C2F5DFCA02DEFCCDFE1CFB02_121696633 = (!sent.isEmpty() && sent.get(0) < beginCheckPeriod);
            {
                sent.remove(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDFD6A4FA9327973346539BB265A37305_693243515 = ((sent.size() + smsWaiting) <= mMaxAllowed);
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
        return dsTaint.getTaintBoolean();
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

    
}


