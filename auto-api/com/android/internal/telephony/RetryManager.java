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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.995 -0400", hash_original_field = "9AE04FB9BF9CA85B9BAF44A0EE7AC74C", hash_generated_field = "0ED5B73174BD3FCD5BC5EB44EEEF6D87")

    private ArrayList<RetryRec> mRetryArray = new ArrayList<RetryRec>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.995 -0400", hash_original_field = "D57A5D2E2BB4C619441FBAA4CD14BD93", hash_generated_field = "9E34B87B35118AE94524B85915CDB198")

    private boolean mRetryForever;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.995 -0400", hash_original_field = "11852E5FD8B8E40A939D0467A1A013B0", hash_generated_field = "2F11E5AFDC6B938E3D8809B57FB2F2EA")

    private int mMaxRetryCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.995 -0400", hash_original_field = "4487E295EC45E6A32AAF433A1E157001", hash_generated_field = "60ECA19125F229E91963A33A8DDAFECC")

    private int mRetryCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.995 -0400", hash_original_field = "400847CAA021BAB7067CB5799A35133E", hash_generated_field = "E519BF5B95192C435E2868E19E00F387")

    private Random rng = new Random();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.015 -0400", hash_original_method = "86AB11F27A0B5AC38FB55D7069405F57", hash_generated_method = "31503892F4B7E34419F3D4D728BC5E52")
    public  RetryManager() {
        log("constructor");
        // ---------- Original Method ----------
        //if (DBG) log("constructor");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.029 -0400", hash_original_method = "1CB950BCC9F48EB334FE7B6B837F3DD2", hash_generated_method = "D66AE661DDF29BEFF47658B0E8D54BF2")
    public boolean configure(int maxRetryCount, int retryTime, int randomizationTime) {
        Pair<Boolean, Integer> value;
        log("configure: " + maxRetryCount + ", " + retryTime + "," + randomizationTime);
        {
            boolean var3AB49D41D5C68F939ED37DA095899566_1217584574 = (!validateNonNegativeInt("maxRetryCount", maxRetryCount));
        } //End collapsed parenthetic
        {
            boolean varA02666B4CAFE9E2A985E3D1741546F93_1951967246 = (!validateNonNegativeInt("retryTime", retryTime));
        } //End collapsed parenthetic
        {
            boolean varD4B44DACFD7F64EFBE5121C449B77625_848647112 = (!validateNonNegativeInt("randomizationTime", randomizationTime));
        } //End collapsed parenthetic
        mMaxRetryCount = maxRetryCount;
        resetRetryCount();
        mRetryArray.clear();
        mRetryArray.add(new RetryRec(retryTime, randomizationTime));
        addTaint(retryTime);
        addTaint(randomizationTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939684573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939684573;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.033 -0400", hash_original_method = "C6612F6F1694E17ABFCC353841B58B91", hash_generated_method = "880B32E35E284ED0FF339E115B702ECC")
    public boolean configure(String configStr) {
        {
            boolean varB77B781AB61A2D0934A557751D613CB0_832379804 = ((configStr.startsWith("\"") && configStr.endsWith("\"")));
            {
                configStr = configStr.substring(1, configStr.length()-1);
            } //End block
        } //End collapsed parenthetic
        log("configure: '" + configStr + "'");
        {
            boolean varAE24BB49F679C9F0E60523674D56178C_1579190399 = (!TextUtils.isEmpty(configStr));
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
                                boolean varC1D745AEBD64942CBD34E8074246D382_1984090670 = (TextUtils.equals(splitStr[0], "default_randomization"));
                                {
                                    value = parseNonNegativeInt(splitStr[0], splitStr[1]);
                                    defaultRandomization = value.second;
                                } //End block
                                {
                                    boolean varBD7E65A08CA7CD1BFAC5AE33816EFFCB_1279154891 = (TextUtils.equals(splitStr[0], "max_retries"));
                                    {
                                        {
                                            boolean varF130CEA657D458113F1796B1DA49E963_181963365 = (TextUtils.equals("infinite",splitStr[1]));
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
                    boolean var11069FDB4409494C12B4B638811AF818_575008043 = (mRetryArray.size() > mMaxRetryCount);
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
        addTaint(configStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898728605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898728605;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.034 -0400", hash_original_method = "74B9CFC0074F7A248036F63581582633", hash_generated_method = "5D30CE77DE50F607BAA6B60A6C59D67D")
    public boolean isRetryNeeded() {
        boolean retVal;
        retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
        log("isRetryNeeded: " + retVal);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435911792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_435911792;
        // ---------- Original Method ----------
        //boolean retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
        //if (DBG) log("isRetryNeeded: " + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.034 -0400", hash_original_method = "FDEB093A88716C2A22E1A70262EC26E6", hash_generated_method = "DF1649BD93C9FE5CAEAD437FC2D7B734")
    public int getRetryTimer() {
        int index;
        {
            boolean var023AA468A6FDC6E9547246DC56EE6D00_777259693 = (mRetryCount < mRetryArray.size());
            {
                index = mRetryCount;
            } //End block
            {
                index = mRetryArray.size() - 1;
            } //End block
        } //End collapsed parenthetic
        int retVal;
        {
            boolean var23724F18A85DA0EAAC9ADB5644A0B1CA_1379707882 = ((index >= 0) && (index < mRetryArray.size()));
            {
                retVal = mRetryArray.get(index).mDelayTime + nextRandomizationTime(index);
            } //End block
            {
                retVal = 0;
            } //End block
        } //End collapsed parenthetic
        log("getRetryTimer: " + retVal);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323835082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323835082;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.034 -0400", hash_original_method = "7864A3188C49B1562B5127F41B9781EB", hash_generated_method = "32A22DB7DCD3E3A4A4A54B77C14496EE")
    public int getRetryCount() {
        log("getRetryCount: " + mRetryCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127327853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127327853;
        // ---------- Original Method ----------
        //if (DBG) log("getRetryCount: " + mRetryCount);
        //return mRetryCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.035 -0400", hash_original_method = "BFFEAAE12F87E8C46DFE1D4E07480604", hash_generated_method = "513E87EF89BD62C1D7581FD8F0315BAB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.035 -0400", hash_original_method = "A052AF31F22F35CA9E6DDD61D99CA6EF", hash_generated_method = "EEEEC2462540C8289BB533E286F508F9")
    public void setRetryCount(int count) {
        mRetryCount = count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.043 -0400", hash_original_method = "17739E86F508FAF2AC931D73653ADB87", hash_generated_method = "A474A3FF7ED71869BD513B625B6A6532")
    public void resetRetryCount() {
        mRetryCount = 0;
        log("resetRetryCount: " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = 0;
        //if (DBG) log("resetRetryCount: " + mRetryCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.043 -0400", hash_original_method = "28FA3A141006A5A6B2A507757230F8F2", hash_generated_method = "E66F8E8B1014C2C9C269FF7B86BB85A4")
    public void retryForeverUsingLastTimeout() {
        mRetryCount = mMaxRetryCount;
        mRetryForever = true;
        log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = mMaxRetryCount;
        //mRetryForever = true;
        //if (DBG) log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.043 -0400", hash_original_method = "A096FCFC79F5CC1E2EDA08CBC5F004E8", hash_generated_method = "094DB0C86FB6E30E7655B76FC656A617")
    public boolean isRetryForever() {
        log("isRetryForever: " + mRetryForever);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704011878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704011878;
        // ---------- Original Method ----------
        //if (DBG) log("isRetryForever: " + mRetryForever);
        //return mRetryForever;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.058 -0400", hash_original_method = "CFEE2F1AF91E2D86FFF14B5518822AC3", hash_generated_method = "BA840A98D758C1D5B30CF8C1EF12ACBF")
    private Pair<Boolean, Integer> parseNonNegativeInt(String name, String stringValue) {
        Pair<Boolean, Integer> varB4EAC82CA7396A68D541C85D26508E83_1342272725 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1342272725 = retVal;
        addTaint(name.getTaint());
        addTaint(stringValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1342272725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342272725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.063 -0400", hash_original_method = "732CF49E361007DEE3B2FC2D605BF87E", hash_generated_method = "9F27E0A13744781C1AEE6CA63CC1789B")
    private boolean validateNonNegativeInt(String name, int value) {
        boolean retVal;
        {
            retVal = false;
        } //End block
        {
            retVal = true;
        } //End block
        log("validateNonNegative: " + name + ", " + value + ", " + retVal);
        addTaint(name.getTaint());
        addTaint(value);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662270075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662270075;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_method = "C6100D6542DA0DEE21E22A63B7A19544", hash_generated_method = "CE17EE3AF99DC1B8E6166010971D6A75")
    private int nextRandomizationTime(int index) {
        int randomTime;
        randomTime = mRetryArray.get(index).mRandomizationTime;
        {
            int var92D084210DFBA05FD8C63FE672D2846B_2021355261 = (rng.nextInt(randomTime));
        } //End block
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833681902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833681902;
        // ---------- Original Method ----------
        //int randomTime = mRetryArray.get(index).mRandomizationTime;
        //if (randomTime == 0) {
            //return 0;
        //} else {
            //return rng.nextInt(randomTime);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_method = "4CC3EDAC8B8BC9B5E954A182C692136C", hash_generated_method = "033EF182C46627DE0D2B8D331155EB2B")
    private void log(String s) {
        Log.d(LOG_TAG, s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, s);
    }

    
    private static class RetryRec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_field = "764EF233E383FBF12DA59FF2DD43392C", hash_generated_field = "913DCF5FCF05A4BC45E2B52ED338322E")

        int mDelayTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_field = "BD127CA4F9074A6E2E221CB1F56B86F1", hash_generated_field = "C0F0244DB495C4F7A8A1EB5174BBEC44")

        int mRandomizationTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_method = "69C230B0D836032F36CE6DFB69101575", hash_generated_method = "5000A7EE46494ABC4A714F9925EB7B34")
          RetryRec(int delayTime, int randomizationTime) {
            mDelayTime = delayTime;
            mRandomizationTime = randomizationTime;
            // ---------- Original Method ----------
            //mDelayTime = delayTime;
            //mRandomizationTime = randomizationTime;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_field = "DEDEF0FC136CE349C44387AA9D5BC054", hash_generated_field = "3ABD7D9314FBBFD996D5BF26C38898E4")

    static public final String LOG_TAG = "RetryManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.064 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1310DF57561ADBC3BA33C25A70D2B921")

    static public final boolean DBG = false;
}

