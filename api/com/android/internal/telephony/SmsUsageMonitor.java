package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SmsUsageMonitor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.536 -0400", hash_original_field = "7D2C0C2BF475877740FC4F4370379B27", hash_generated_field = "8251D8E7267A3EFD6EC445592CA97E50")

    private int mCheckPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.536 -0400", hash_original_field = "9975895F9DB80EFF35D4CCBB757209DA", hash_generated_field = "88D310A8EA39C1E84390420AD9B4808A")

    private int mMaxAllowed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.536 -0400", hash_original_field = "C43BF27E7C4A474A450E53DD288AFA67", hash_generated_field = "DFE168BFE7372EC4F2AF98D6A5D9F6B4")

    private final HashMap<String, ArrayList<Long>> mSmsStamp = new HashMap<String, ArrayList<Long>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.537 -0400", hash_original_method = "AA58276D63D2163182FD805D073EE67C", hash_generated_method = "41E1494827BFC473DCA67AF4C2849C94")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.537 -0400", hash_original_method = "7B2C29F4698952FF45E2699BBB5DEB62", hash_generated_method = "F5020B67D30B77B9A0B8E7C878C54BF3")
     void dispose() {
        mSmsStamp.clear();
        // ---------- Original Method ----------
        //mSmsStamp.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.538 -0400", hash_original_method = "EA1BFE3566BC11C4D089155AC6363183", hash_generated_method = "85DB4E0F9F1DA54FC570B3C68A8BF3A8")
    public boolean check(String appName, int smsWaiting) {
        addTaint(smsWaiting);
        addTaint(appName.getTaint());
        synchronized
(mSmsStamp)        {
            removeExpiredTimestamps();
            ArrayList<Long> sentList = mSmsStamp.get(appName);
    if(sentList == null)            
            {
                sentList = new ArrayList<Long>();
                mSmsStamp.put(appName, sentList);
            } //End block
            boolean varB953ECC0AAC1AB2A01BD129D0D595F46_1544824929 = (isUnderLimit(sentList, smsWaiting));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856846276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_856846276;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.538 -0400", hash_original_method = "0C89C3F43D481EBAFC32AEEAE6183BD3", hash_generated_method = "22A7CA82B7C0B6DA7E9E6D6BE6F1D6C9")
    private void removeExpiredTimestamps() {
        long beginCheckPeriod = System.currentTimeMillis() - mCheckPeriod;
        synchronized
(mSmsStamp)        {
            Iterator<Map.Entry<String, ArrayList<Long>>> iter = mSmsStamp.entrySet().iterator();
            while
(iter.hasNext())            
            {
                Map.Entry<String, ArrayList<Long>> entry = iter.next();
                ArrayList<Long> oldList = entry.getValue();
    if(oldList.isEmpty() || oldList.get(oldList.size() - 1) < beginCheckPeriod)                
                {
                    iter.remove();
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.539 -0400", hash_original_method = "FED252455D0F59F9866280B84F72F407", hash_generated_method = "9A8E24FF5C1B509929450CDE77154176")
    private boolean isUnderLimit(ArrayList<Long> sent, int smsWaiting) {
        addTaint(smsWaiting);
        addTaint(sent.getTaint());
        Long ct = System.currentTimeMillis();
        long beginCheckPeriod = ct - mCheckPeriod;
        Log.d(TAG, "SMS send size=" + sent.size() + " time=" + ct);
        while
(!sent.isEmpty() && sent.get(0) < beginCheckPeriod)        
        {
            sent.remove(0);
        } //End block
    if((sent.size() + smsWaiting) <= mMaxAllowed)        
        {
for(int i = 0;i < smsWaiting;i++)
            {
                sent.add(ct);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1214178195 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351469195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351469195;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1815841235 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105038834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105038834;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.539 -0400", hash_original_field = "35B10AB3CDA09F3B2F3131AD6DBAA325", hash_generated_field = "ADC819F4640257478A9F0F8C0177ED0F")

    private static final String TAG = "SmsStorageMonitor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.539 -0400", hash_original_field = "86C04E306979E0A3ED6C10E477ABFEDA", hash_generated_field = "D184D1254BA3A87EB9E381BB216E30EE")

    private static final int DEFAULT_SMS_CHECK_PERIOD = 3600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.540 -0400", hash_original_field = "5B383FE3921C2BBCDC2AD6E7B1F1197C", hash_generated_field = "E11F7FB3C4CB97EA2BC23371FE5A5E5F")

    private static final int DEFAULT_SMS_MAX_COUNT = 100;
}

