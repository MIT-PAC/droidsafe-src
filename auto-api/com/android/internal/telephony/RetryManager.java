package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import android.util.Pair;
import android.text.TextUtils;
import java.util.Random;
import java.util.ArrayList;

public class RetryManager {
    private ArrayList<RetryRec> mRetryArray = new ArrayList<RetryRec>();
    private boolean mRetryForever;
    private int mMaxRetryCount;
    private int mRetryCount;
    private Random rng = new Random();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.268 -0400", hash_original_method = "86AB11F27A0B5AC38FB55D7069405F57", hash_generated_method = "31503892F4B7E34419F3D4D728BC5E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RetryManager() {
        log("constructor");
        // ---------- Original Method ----------
        //if (DBG) log("constructor");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.268 -0400", hash_original_method = "1CB950BCC9F48EB334FE7B6B837F3DD2", hash_generated_method = "DEABA9E31ADE94B74AC692F17EC5AEE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean configure(int maxRetryCount, int retryTime, int randomizationTime) {
        dsTaint.addTaint(retryTime);
        dsTaint.addTaint(maxRetryCount);
        dsTaint.addTaint(randomizationTime);
        Pair<Boolean, Integer> value;
        log("configure: " + maxRetryCount + ", " + retryTime + "," + randomizationTime);
        {
            boolean var3AB49D41D5C68F939ED37DA095899566_1200901870 = (!validateNonNegativeInt("maxRetryCount", maxRetryCount));
        } //End collapsed parenthetic
        {
            boolean varA02666B4CAFE9E2A985E3D1741546F93_1598694413 = (!validateNonNegativeInt("retryTime", retryTime));
        } //End collapsed parenthetic
        {
            boolean varD4B44DACFD7F64EFBE5121C449B77625_1625473684 = (!validateNonNegativeInt("randomizationTime", randomizationTime));
        } //End collapsed parenthetic
        resetRetryCount();
        mRetryArray.clear();
        mRetryArray.add(new RetryRec(retryTime, randomizationTime));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Pair<Boolean, Integer> value;
        //if (DBG) log("configure: " + maxRetryCount + ", " + retryTime + "," + randomizationTime);
        //if (!validateNonNegativeInt("maxRetryCount", maxRetryCount)) {
            //return false;
        //}
        //if (!validateNonNegativeInt("retryTime", retryTime)) {
            //return false;
        //}
        //if (!validateNonNegativeInt("randomizationTime", randomizationTime)) {
            //return false;
        //}
        //mMaxRetryCount = maxRetryCount;
        //resetRetryCount();
        //mRetryArray.clear();
        //mRetryArray.add(new RetryRec(retryTime, randomizationTime));
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.278 -0400", hash_original_method = "C6612F6F1694E17ABFCC353841B58B91", hash_generated_method = "422D03BA306C9E486427EB778B9BC4C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean configure(String configStr) {
        dsTaint.addTaint(configStr);
        {
            boolean varB77B781AB61A2D0934A557751D613CB0_1932064200 = ((configStr.startsWith("\"") && configStr.endsWith("\"")));
            {
                configStr = configStr.substring(1, configStr.length()-1);
            } //End block
        } //End collapsed parenthetic
        log("configure: '" + configStr + "'");
        {
            boolean varAE24BB49F679C9F0E60523674D56178C_632068772 = (!TextUtils.isEmpty(configStr));
            {
                int defaultRandomization;
                defaultRandomization = 0;
                log("configure: not empty");
                mMaxRetryCount = 0;
                resetRetryCount();
                mRetryArray.clear();
                String strArray[];
                strArray = configStr.split(",");
                {
                    int i;
                    i = 0;
                    {
                        log("configure: strArray[" + i + "]='" + strArray[i] + "'");
                        Pair<Boolean, Integer> value;
                        String splitStr[];
                        splitStr = strArray[i].split("=", 2);
                        splitStr[0] = splitStr[0].trim();
                        log("configure: splitStr[0]='" + splitStr[0] + "'");
                        {
                            splitStr[1] = splitStr[1].trim();
                            log("configure: splitStr[1]='" + splitStr[1] + "'");
                            {
                                boolean varC1D745AEBD64942CBD34E8074246D382_1637207684 = (TextUtils.equals(splitStr[0], "default_randomization"));
                                {
                                    value = parseNonNegativeInt(splitStr[0], splitStr[1]);
                                    defaultRandomization = value.second;
                                } //End block
                                {
                                    boolean varBD7E65A08CA7CD1BFAC5AE33816EFFCB_1749264159 = (TextUtils.equals(splitStr[0], "max_retries"));
                                    {
                                        {
                                            boolean varF130CEA657D458113F1796B1DA49E963_1398185569 = (TextUtils.equals("infinite",splitStr[1]));
                                            {
                                                mRetryForever = true;
                                            } //End block
                                            {
                                                value = parseNonNegativeInt(splitStr[0], splitStr[1]);
                                                mMaxRetryCount = value.second;
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        {
                            splitStr = strArray[i].split(":", 2);
                            splitStr[0] = splitStr[0].trim();
                            RetryRec rr;
                            rr = new RetryRec(0, 0);
                            value = parseNonNegativeInt("delayTime", splitStr[0]);
                            rr.mDelayTime = value.second;
                            {
                                splitStr[1] = splitStr[1].trim();
                                log("configure: splitStr[1]='" + splitStr[1] + "'");
                                value = parseNonNegativeInt("randomizationTime", splitStr[1]);
                                rr.mRandomizationTime = value.second;
                            } //End block
                            {
                                rr.mRandomizationTime = defaultRandomization;
                            } //End block
                            mRetryArray.add(rr);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var11069FDB4409494C12B4B638811AF818_1962202822 = (mRetryArray.size() > mMaxRetryCount);
                    {
                        mMaxRetryCount = mRetryArray.size();
                        log("configure: setting mMaxRetryCount=" + mMaxRetryCount);
                    } //End block
                } //End collapsed parenthetic
                log("configure: true");
            } //End block
            {
                log("configure: false it's empty");
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.279 -0400", hash_original_method = "74B9CFC0074F7A248036F63581582633", hash_generated_method = "1345407C4FE770CB8EAC90B0A5AB8EBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRetryNeeded() {
        boolean retVal;
        retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
        log("isRetryNeeded: " + retVal);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
        //if (DBG) log("isRetryNeeded: " + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.279 -0400", hash_original_method = "FDEB093A88716C2A22E1A70262EC26E6", hash_generated_method = "6E71C08212BC18F2C74179C4B87C0E36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRetryTimer() {
        int index;
        {
            boolean var023AA468A6FDC6E9547246DC56EE6D00_581709188 = (mRetryCount < mRetryArray.size());
            {
                index = mRetryCount;
            } //End block
            {
                index = mRetryArray.size() - 1;
            } //End block
        } //End collapsed parenthetic
        int retVal;
        {
            boolean var23724F18A85DA0EAAC9ADB5644A0B1CA_1925215445 = ((index >= 0) && (index < mRetryArray.size()));
            {
                retVal = mRetryArray.get(index).mDelayTime + nextRandomizationTime(index);
            } //End block
            {
                retVal = 0;
            } //End block
        } //End collapsed parenthetic
        log("getRetryTimer: " + retVal);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index;
        //if (mRetryCount < mRetryArray.size()) {
            //index = mRetryCount;
        //} else {
            //index = mRetryArray.size() - 1;
        //}
        //int retVal;
        //if ((index >= 0) && (index < mRetryArray.size())) {
            //retVal = mRetryArray.get(index).mDelayTime + nextRandomizationTime(index);
        //} else {
            //retVal = 0;
        //}
        //if (DBG) log("getRetryTimer: " + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.280 -0400", hash_original_method = "7864A3188C49B1562B5127F41B9781EB", hash_generated_method = "C3B51CB0D06DCF202140D73661E0C247")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRetryCount() {
        log("getRetryCount: " + mRetryCount);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("getRetryCount: " + mRetryCount);
        //return mRetryCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.280 -0400", hash_original_method = "BFFEAAE12F87E8C46DFE1D4E07480604", hash_generated_method = "513E87EF89BD62C1D7581FD8F0315BAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void increaseRetryCount() {
        {
            mRetryCount = mMaxRetryCount;
        } //End block
        log("increaseRetryCount: " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount++;
        //if (mRetryCount > mMaxRetryCount) {
            //mRetryCount = mMaxRetryCount;
        //}
        //if (DBG) log("increaseRetryCount: " + mRetryCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.280 -0400", hash_original_method = "A052AF31F22F35CA9E6DDD61D99CA6EF", hash_generated_method = "11A0192A724A82B4D02D9D26FF152EDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRetryCount(int count) {
        dsTaint.addTaint(count);
        {
            mRetryCount = mMaxRetryCount;
        } //End block
        {
            mRetryCount = 0;
        } //End block
        mRetryForever = false;
        log("setRetryCount: " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = count;
        //if (mRetryCount > mMaxRetryCount) {
            //mRetryCount = mMaxRetryCount;
        //}
        //if (mRetryCount < 0) {
            //mRetryCount = 0;
        //}
        //mRetryForever = false;
        //if (DBG) log("setRetryCount: " + mRetryCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.280 -0400", hash_original_method = "17739E86F508FAF2AC931D73653ADB87", hash_generated_method = "A474A3FF7ED71869BD513B625B6A6532")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resetRetryCount() {
        mRetryCount = 0;
        log("resetRetryCount: " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = 0;
        //if (DBG) log("resetRetryCount: " + mRetryCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.281 -0400", hash_original_method = "28FA3A141006A5A6B2A507757230F8F2", hash_generated_method = "E66F8E8B1014C2C9C269FF7B86BB85A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void retryForeverUsingLastTimeout() {
        mRetryCount = mMaxRetryCount;
        mRetryForever = true;
        log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = mMaxRetryCount;
        //mRetryForever = true;
        //if (DBG) log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.281 -0400", hash_original_method = "A096FCFC79F5CC1E2EDA08CBC5F004E8", hash_generated_method = "03A5B18B1BE1842067FBA774958DC776")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRetryForever() {
        log("isRetryForever: " + mRetryForever);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("isRetryForever: " + mRetryForever);
        //return mRetryForever;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.281 -0400", hash_original_method = "CFEE2F1AF91E2D86FFF14B5518822AC3", hash_generated_method = "961B09F0C134008A091502465E8460DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Pair<Boolean, Integer> parseNonNegativeInt(String name, String stringValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(stringValue);
        int value;
        Pair<Boolean, Integer> retVal;
        try 
        {
            value = Integer.parseInt(stringValue);
            retVal = new Pair<Boolean, Integer>(validateNonNegativeInt(name, value), value);
        } //End block
        catch (NumberFormatException e)
        {
            retVal = new Pair<Boolean, Integer>(false, 0);
        } //End block
        log("parseNonNetativeInt: " + name + ", " + stringValue + ", "
                    + retVal.first + ", " + retVal.second);
        return (Pair<Boolean, Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int value;
        //Pair<Boolean, Integer> retVal;
        //try {
            //value = Integer.parseInt(stringValue);
            //retVal = new Pair<Boolean, Integer>(validateNonNegativeInt(name, value), value);
        //} catch (NumberFormatException e) {
            //Log.e(LOG_TAG, name + " bad value: " + stringValue, e);
            //retVal = new Pair<Boolean, Integer>(false, 0);
        //}
        //if (DBG) log("parseNonNetativeInt: " + name + ", " + stringValue + ", "
                    //+ retVal.first + ", " + retVal.second);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.282 -0400", hash_original_method = "732CF49E361007DEE3B2FC2D605BF87E", hash_generated_method = "146D84ADC3A7EA49630E964772C7B4D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean validateNonNegativeInt(String name, int value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        boolean retVal;
        {
            retVal = false;
        } //End block
        {
            retVal = true;
        } //End block
        log("validateNonNegative: " + name + ", " + value + ", " + retVal);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retVal;
        //if (value < 0) {
            //Log.e(LOG_TAG, name + " bad value: is < 0");
            //retVal = false;
        //} else {
            //retVal = true;
        //}
        //if (DBG) log("validateNonNegative: " + name + ", " + value + ", " + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.282 -0400", hash_original_method = "C6100D6542DA0DEE21E22A63B7A19544", hash_generated_method = "3DEAC2593FAAF1CBDDF0851B39D9F2C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nextRandomizationTime(int index) {
        dsTaint.addTaint(index);
        int randomTime;
        randomTime = mRetryArray.get(index).mRandomizationTime;
        {
            int var92D084210DFBA05FD8C63FE672D2846B_1909494415 = (rng.nextInt(randomTime));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int randomTime = mRetryArray.get(index).mRandomizationTime;
        //if (randomTime == 0) {
            //return 0;
        //} else {
            //return rng.nextInt(randomTime);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.282 -0400", hash_original_method = "4CC3EDAC8B8BC9B5E954A182C692136C", hash_generated_method = "1ABB0B2EDEDA91C8A80F5DB7BDF51645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, s);
    }

    
    private static class RetryRec {
        int mDelayTime;
        int mRandomizationTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.282 -0400", hash_original_method = "69C230B0D836032F36CE6DFB69101575", hash_generated_method = "86CAD7D8B48A2B9E0ECBD6724A2DE59E")
        @DSModeled(DSC.SAFE)
         RetryRec(int delayTime, int randomizationTime) {
            dsTaint.addTaint(delayTime);
            dsTaint.addTaint(randomizationTime);
            // ---------- Original Method ----------
            //mDelayTime = delayTime;
            //mRandomizationTime = randomizationTime;
        }

        
    }


    
    static public final String LOG_TAG = "RetryManager";
    static public final boolean DBG = false;
}

