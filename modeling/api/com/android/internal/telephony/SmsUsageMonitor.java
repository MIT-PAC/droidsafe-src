package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;

public class SmsUsageMonitor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.914 -0500", hash_original_field = "FB7DBAB3BD99ADAD6D2F0065DB8C554C", hash_generated_field = "ADC819F4640257478A9F0F8C0177ED0F")

    private static final String TAG = "SmsStorageMonitor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.918 -0500", hash_original_field = "4CFB9434A7916FB3AF90D8BE0D403599", hash_generated_field = "D184D1254BA3A87EB9E381BB216E30EE")

    private static final int DEFAULT_SMS_CHECK_PERIOD = 3600000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.920 -0500", hash_original_field = "927CFB8EAD30E606AEF84C29C24BE1AD", hash_generated_field = "E11F7FB3C4CB97EA2BC23371FE5A5E5F")

    private static final int DEFAULT_SMS_MAX_COUNT = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.923 -0500", hash_original_field = "2E7035184047E27C930D9D586C42D9C1", hash_generated_field = "8251D8E7267A3EFD6EC445592CA97E50")

    private  int mCheckPeriod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.925 -0500", hash_original_field = "363C0D837ADCDE4C2E113B6BDE1F2122", hash_generated_field = "88D310A8EA39C1E84390420AD9B4808A")

    private  int mMaxAllowed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.928 -0500", hash_original_field = "35E15E9675A7623236637CF0566A4BAE", hash_generated_field = "DFE168BFE7372EC4F2AF98D6A5D9F6B4")

    private final HashMap<String, ArrayList<Long>> mSmsStamp =
            new HashMap<String, ArrayList<Long>>();

    /**
     * Create SMS usage monitor.
     * @param resolver the ContentResolver to use to load from secure settings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.930 -0500", hash_original_method = "AA58276D63D2163182FD805D073EE67C", hash_generated_method = "1ADD652A9B8E3EA16019BB5E0F7C4636")
    
public SmsUsageMonitor(ContentResolver resolver) {
        mMaxAllowed = Settings.Secure.getInt(resolver,
                Settings.Secure.SMS_OUTGOING_CHECK_MAX_COUNT,
                DEFAULT_SMS_MAX_COUNT);

        mCheckPeriod = Settings.Secure.getInt(resolver,
                Settings.Secure.SMS_OUTGOING_CHECK_INTERVAL_MS,
                DEFAULT_SMS_CHECK_PERIOD);
    }

    /** Clear the SMS application list for disposal. */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.932 -0500", hash_original_method = "7B2C29F4698952FF45E2699BBB5DEB62", hash_generated_method = "7B2C29F4698952FF45E2699BBB5DEB62")
    
void dispose() {
        mSmsStamp.clear();
    }

    /**
     * Check to see if an application is allowed to send new SMS messages.
     *
     * @param appName the application sending sms
     * @param smsWaiting the number of new messages desired to send
     * @return true if application is allowed to send the requested number
     *  of new sms messages
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.935 -0500", hash_original_method = "EA1BFE3566BC11C4D089155AC6363183", hash_generated_method = "016ADFC455C529B040F4A548F2E62497")
    
public boolean check(String appName, int smsWaiting) {
        synchronized (mSmsStamp) {
            removeExpiredTimestamps();

            ArrayList<Long> sentList = mSmsStamp.get(appName);
            if (sentList == null) {
                sentList = new ArrayList<Long>();
                mSmsStamp.put(appName, sentList);
            }

            return isUnderLimit(sentList, smsWaiting);
        }
    }

    /**
     * Remove keys containing only old timestamps. This can happen if an SMS app is used
     * to send messages and then uninstalled.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.938 -0500", hash_original_method = "0C89C3F43D481EBAFC32AEEAE6183BD3", hash_generated_method = "C6765A4C1D0FFCCF53B54DBAA06615CD")
    
private void removeExpiredTimestamps() {
        long beginCheckPeriod = System.currentTimeMillis() - mCheckPeriod;

        synchronized (mSmsStamp) {
            Iterator<Map.Entry<String, ArrayList<Long>>> iter = mSmsStamp.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, ArrayList<Long>> entry = iter.next();
                ArrayList<Long> oldList = entry.getValue();
                if (oldList.isEmpty() || oldList.get(oldList.size() - 1) < beginCheckPeriod) {
                    iter.remove();
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:47.940 -0500", hash_original_method = "FED252455D0F59F9866280B84F72F407", hash_generated_method = "75E2A84C55B38A039F4E0FD1EBFCDEE1")
    
private boolean isUnderLimit(ArrayList<Long> sent, int smsWaiting) {
        Long ct = System.currentTimeMillis();
        long beginCheckPeriod = ct - mCheckPeriod;

        Log.d(TAG, "SMS send size=" + sent.size() + " time=" + ct);

        while (!sent.isEmpty() && sent.get(0) < beginCheckPeriod) {
            sent.remove(0);
        }

        if ((sent.size() + smsWaiting) <= mMaxAllowed) {
            for (int i = 0; i < smsWaiting; i++ ) {
                sent.add(ct);
            }
            return true;
        }
        return false;
    }
}

