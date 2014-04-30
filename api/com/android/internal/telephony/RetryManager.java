package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Random;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

public class RetryManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.926 -0500", hash_original_field = "16E20B3652E3AE24507B42FF6157DF9C", hash_generated_field = "3ABD7D9314FBBFD996D5BF26C38898E4")

    static public final String LOG_TAG = "RetryManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.928 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1310DF57561ADBC3BA33C25A70D2B921")

    static public final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.940 -0500", hash_original_field = "F6F0D142443ABC79053070B163CBC3C7", hash_generated_field = "0ED5B73174BD3FCD5BC5EB44EEEF6D87")

    private ArrayList<RetryRec> mRetryArray = new ArrayList<RetryRec>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.942 -0500", hash_original_field = "D2168581F1D08AC1237AD2F3B1F19A5F", hash_generated_field = "9E34B87B35118AE94524B85915CDB198")

    private boolean mRetryForever;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.945 -0500", hash_original_field = "9EA34BE5777D0686212578EB39D234F6", hash_generated_field = "2F11E5AFDC6B938E3D8809B57FB2F2EA")

    private int mMaxRetryCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.947 -0500", hash_original_field = "C9DACFBCA3237D1498F6E789EE3E7536", hash_generated_field = "60ECA19125F229E91963A33A8DDAFECC")

    private int mRetryCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.949 -0500", hash_original_field = "E56B84EF4D4C35564DDD4910B1DABB3C", hash_generated_field = "E519BF5B95192C435E2868E19E00F387")

    private Random rng = new Random();

    /** Constructor */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.953 -0500", hash_original_method = "86AB11F27A0B5AC38FB55D7069405F57", hash_generated_method = "C83CF8A9D7F1E339DB21D2990562C126")
    
public RetryManager() {
        if (DBG) log("constructor");
    }

    /**
     * Configure for a simple linear sequence of times plus
     * a random value.
     *
     * @param maxRetryCount is the maximum number of retries
     *        before isRetryNeeded returns false.
     * @param retryTime is a time that will be returned by getRetryTime.
     * @param randomizationTime a random value between 0 and
     *        randomizationTime will be added to retryTime. this
     *        parameter may be 0.
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.955 -0500", hash_original_method = "1CB950BCC9F48EB334FE7B6B837F3DD2", hash_generated_method = "56A10454E423802DFCEB87CE6A3A5098")
    
public boolean configure(int maxRetryCount, int retryTime, int randomizationTime) {
        Pair<Boolean, Integer> value;

        if (DBG) log("configure: " + maxRetryCount + ", " + retryTime + "," + randomizationTime);

        if (!validateNonNegativeInt("maxRetryCount", maxRetryCount)) {
            return false;
        }

        if (!validateNonNegativeInt("retryTime", retryTime)) {
            return false;
        }

        if (!validateNonNegativeInt("randomizationTime", randomizationTime)) {
            return false;
        }

        mMaxRetryCount = maxRetryCount;
        resetRetryCount();
        mRetryArray.clear();
        mRetryArray.add(new RetryRec(retryTime, randomizationTime));

        return true;
    }

    /**
     * Configure for using string which allow arbitrary
     * sequences of times. See class comments for the
     * string format.
     *
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.959 -0500", hash_original_method = "C6612F6F1694E17ABFCC353841B58B91", hash_generated_method = "D60DF57A701B9F02CF3A00D9399911F1")
    
public boolean configure(String configStr) {
        // Strip quotes if present.
        if ((configStr.startsWith("\"") && configStr.endsWith("\""))) {
            configStr = configStr.substring(1, configStr.length()-1);
        }
        if (DBG) log("configure: '" + configStr + "'");

        if (!TextUtils.isEmpty(configStr)) {
            int defaultRandomization = 0;

            if (DBG) log("configure: not empty");

            mMaxRetryCount = 0;
            resetRetryCount();
            mRetryArray.clear();

            String strArray[] = configStr.split(",");
            for (int i = 0; i < strArray.length; i++) {
                if (DBG) log("configure: strArray[" + i + "]='" + strArray[i] + "'");
                Pair<Boolean, Integer> value;
                String splitStr[] = strArray[i].split("=", 2);
                splitStr[0] = splitStr[0].trim();
                if (DBG) log("configure: splitStr[0]='" + splitStr[0] + "'");
                if (splitStr.length > 1) {
                    splitStr[1] = splitStr[1].trim();
                    if (DBG) log("configure: splitStr[1]='" + splitStr[1] + "'");
                    if (TextUtils.equals(splitStr[0], "default_randomization")) {
                        value = parseNonNegativeInt(splitStr[0], splitStr[1]);
                        if (!value.first) return false;
                        defaultRandomization = value.second;
                    } else if (TextUtils.equals(splitStr[0], "max_retries")) {
                        if (TextUtils.equals("infinite",splitStr[1])) {
                            mRetryForever = true;
                        } else {
                            value = parseNonNegativeInt(splitStr[0], splitStr[1]);
                            if (!value.first) return false;
                            mMaxRetryCount = value.second;
                        }
                    } else {
                        Log.e(LOG_TAG, "Unrecognized configuration name value pair: "
                                        + strArray[i]);
                        return false;
                    }
                } else {
                    /**
                     * Assume a retry time with an optional randomization value
                     * following a ":"
                     */
                    splitStr = strArray[i].split(":", 2);
                    splitStr[0] = splitStr[0].trim();
                    RetryRec rr = new RetryRec(0, 0);
                    value = parseNonNegativeInt("delayTime", splitStr[0]);
                    if (!value.first) return false;
                    rr.mDelayTime = value.second;

                    // Check if optional randomization value present
                    if (splitStr.length > 1) {
                        splitStr[1] = splitStr[1].trim();
                        if (DBG) log("configure: splitStr[1]='" + splitStr[1] + "'");
                        value = parseNonNegativeInt("randomizationTime", splitStr[1]);
                        if (!value.first) return false;
                        rr.mRandomizationTime = value.second;
                    } else {
                        rr.mRandomizationTime = defaultRandomization;
                    }
                    mRetryArray.add(rr);
                }
            }
            if (mRetryArray.size() > mMaxRetryCount) {
                mMaxRetryCount = mRetryArray.size();
                if (DBG) log("configure: setting mMaxRetryCount=" + mMaxRetryCount);
            }
            if (DBG) log("configure: true");
            return true;
        } else {
            if (DBG) log("configure: false it's empty");
            return false;
        }
    }

    /**
     * Report whether data reconnection should be retried
     *
     * @return {@code true} if the max retries has not been reached. {@code
     *         false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.962 -0500", hash_original_method = "74B9CFC0074F7A248036F63581582633", hash_generated_method = "076330BA7A41AC303F0CDDB0218DD374")
    
public boolean isRetryNeeded() {
        boolean retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
        if (DBG) log("isRetryNeeded: " + retVal);
        return retVal;
    }

    /**
     * Return the timer that should be used to trigger the data reconnection
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.965 -0500", hash_original_method = "FDEB093A88716C2A22E1A70262EC26E6", hash_generated_method = "CEDDFEBEC8D9728456D728063F197A7C")
    
public int getRetryTimer() {
        int index;
        if (mRetryCount < mRetryArray.size()) {
            index = mRetryCount;
        } else {
            index = mRetryArray.size() - 1;
        }

        int retVal;
        if ((index >= 0) && (index < mRetryArray.size())) {
            retVal = mRetryArray.get(index).mDelayTime + nextRandomizationTime(index);
        } else {
            retVal = 0;
        }

        if (DBG) log("getRetryTimer: " + retVal);
        return retVal;
    }

    /**
     * @return retry count
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.967 -0500", hash_original_method = "7864A3188C49B1562B5127F41B9781EB", hash_generated_method = "326DE1F25DCF12CC873B034629E47978")
    
public int getRetryCount() {
        if (DBG) log("getRetryCount: " + mRetryCount);
        return mRetryCount;
    }

    /**
     * Increase the retry counter, does not change retry forever.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.970 -0500", hash_original_method = "BFFEAAE12F87E8C46DFE1D4E07480604", hash_generated_method = "334A04C7A877D8F80032EA2843B99838")
    
public void increaseRetryCount() {
        mRetryCount++;
        if (mRetryCount > mMaxRetryCount) {
            mRetryCount = mMaxRetryCount;
        }
        if (DBG) log("increaseRetryCount: " + mRetryCount);
    }

    /**
     * Set retry count to the specified value
     * and turns off retrying forever.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.972 -0500", hash_original_method = "A052AF31F22F35CA9E6DDD61D99CA6EF", hash_generated_method = "14E0069AAC06D3BBD4517021802920AC")
    
public void setRetryCount(int count) {
        mRetryCount = count;
        if (mRetryCount > mMaxRetryCount) {
            mRetryCount = mMaxRetryCount;
        }

        if (mRetryCount < 0) {
            mRetryCount = 0;
        }

        mRetryForever = false;
        if (DBG) log("setRetryCount: " + mRetryCount);
    }

    /**
     * Clear the data-retry counter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.975 -0500", hash_original_method = "17739E86F508FAF2AC931D73653ADB87", hash_generated_method = "4EFB9055EDEFBA920DC4D386DCB3CCF7")
    
public void resetRetryCount() {
        mRetryCount = 0;
        if (DBG) log("resetRetryCount: " + mRetryCount);
    }

    /**
     * Retry forever using last timeout time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.977 -0500", hash_original_method = "28FA3A141006A5A6B2A507757230F8F2", hash_generated_method = "D9F14D5D8B0B46ED2E68775F26CEFAB0")
    
public void retryForeverUsingLastTimeout() {
        mRetryCount = mMaxRetryCount;
        mRetryForever = true;
        if (DBG) log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
    }

    /**
     * @return true if retrying forever
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.980 -0500", hash_original_method = "A096FCFC79F5CC1E2EDA08CBC5F004E8", hash_generated_method = "DE635E7C2E56A419B65908EDD9850ECB")
    
public boolean isRetryForever() {
        if (DBG) log("isRetryForever: " + mRetryForever);
        return mRetryForever;
    }

    /**
     * Parse an integer validating the value is not negative.
     *
     * @param name
     * @param stringValue
     * @return Pair.first == true if stringValue an integer >= 0
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.983 -0500", hash_original_method = "CFEE2F1AF91E2D86FFF14B5518822AC3", hash_generated_method = "D5E254F3A93CF7A3613CF09D7CC6B653")
    
private Pair<Boolean, Integer> parseNonNegativeInt(String name, String stringValue) {
        int value;
        Pair<Boolean, Integer> retVal;
        try {
            value = Integer.parseInt(stringValue);
            retVal = new Pair<Boolean, Integer>(validateNonNegativeInt(name, value), value);
        } catch (NumberFormatException e) {
            Log.e(LOG_TAG, name + " bad value: " + stringValue, e);
            retVal = new Pair<Boolean, Integer>(false, 0);
        }
        if (DBG) log("parseNonNetativeInt: " + name + ", " + stringValue + ", "
                    + retVal.first + ", " + retVal.second);
        return retVal;
    }

    /**
     * Validate an integer is >= 0 and logs an error if not
     *
     * @param name
     * @param value
     * @return Pair.first
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.985 -0500", hash_original_method = "732CF49E361007DEE3B2FC2D605BF87E", hash_generated_method = "3DA719908B1BF7B8EB9660CF8C565B13")
    
private boolean validateNonNegativeInt(String name, int value) {
        boolean retVal;
        if (value < 0) {
            Log.e(LOG_TAG, name + " bad value: is < 0");
            retVal = false;
        } else {
            retVal = true;
        }
        if (DBG) log("validateNonNegative: " + name + ", " + value + ", " + retVal);
        return retVal;
    }
    
    private static class RetryRec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.934 -0500", hash_original_field = "913DCF5FCF05A4BC45E2B52ED338322E", hash_generated_field = "913DCF5FCF05A4BC45E2B52ED338322E")

        int mDelayTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.937 -0500", hash_original_field = "C0F0244DB495C4F7A8A1EB5174BBEC44", hash_generated_field = "C0F0244DB495C4F7A8A1EB5174BBEC44")

        int mRandomizationTime;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.932 -0500", hash_original_method = "69C230B0D836032F36CE6DFB69101575", hash_generated_method = "69C230B0D836032F36CE6DFB69101575")
        
RetryRec(int delayTime, int randomizationTime) {
            mDelayTime = delayTime;
            mRandomizationTime = randomizationTime;
        }
        
    }

    /**
     * Return next random number for the index
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.002 -0500", hash_original_method = "C6100D6542DA0DEE21E22A63B7A19544", hash_generated_method = "55FA424116E7841B7C28D4B140F935FD")
    
private int nextRandomizationTime(int index) {
        int randomTime = mRetryArray.get(index).mRandomizationTime;
        if (randomTime == 0) {
            return 0;
        } else {
            return rng.nextInt(randomTime);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.004 -0500", hash_original_method = "4CC3EDAC8B8BC9B5E954A182C692136C", hash_generated_method = "912C89BCFAD1DF26D1F99BBC8BBEC4F2")
    
private void log(String s) {
        Log.d(LOG_TAG, s);
    }
}

