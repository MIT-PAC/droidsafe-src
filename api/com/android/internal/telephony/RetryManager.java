package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import android.util.Pair;
import android.text.TextUtils;
import java.util.Random;
import java.util.ArrayList;

public class RetryManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.054 -0400", hash_original_field = "9AE04FB9BF9CA85B9BAF44A0EE7AC74C", hash_generated_field = "0ED5B73174BD3FCD5BC5EB44EEEF6D87")

    private ArrayList<RetryRec> mRetryArray = new ArrayList<RetryRec>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.054 -0400", hash_original_field = "D57A5D2E2BB4C619441FBAA4CD14BD93", hash_generated_field = "9E34B87B35118AE94524B85915CDB198")

    private boolean mRetryForever;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.054 -0400", hash_original_field = "11852E5FD8B8E40A939D0467A1A013B0", hash_generated_field = "2F11E5AFDC6B938E3D8809B57FB2F2EA")

    private int mMaxRetryCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.054 -0400", hash_original_field = "4487E295EC45E6A32AAF433A1E157001", hash_generated_field = "60ECA19125F229E91963A33A8DDAFECC")

    private int mRetryCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.054 -0400", hash_original_field = "400847CAA021BAB7067CB5799A35133E", hash_generated_field = "E519BF5B95192C435E2868E19E00F387")

    private Random rng = new Random();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.054 -0400", hash_original_method = "86AB11F27A0B5AC38FB55D7069405F57", hash_generated_method = "BF2773EF307CA3DE0093B4E57C466DD8")
    public  RetryManager() {
    if(DBG)        
        log("constructor");
        // ---------- Original Method ----------
        //if (DBG) log("constructor");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.055 -0400", hash_original_method = "1CB950BCC9F48EB334FE7B6B837F3DD2", hash_generated_method = "80F1A398BACD38E9B607E3511F6E760D")
    public boolean configure(int maxRetryCount, int retryTime, int randomizationTime) {
        addTaint(randomizationTime);
        addTaint(retryTime);
        Pair<Boolean, Integer> value;
    if(DBG)        
        log("configure: " + maxRetryCount + ", " + retryTime + "," + randomizationTime);
    if(!validateNonNegativeInt("maxRetryCount", maxRetryCount))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2082447126 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655585080 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655585080;
        } //End block
    if(!validateNonNegativeInt("retryTime", retryTime))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1205824292 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270420506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_270420506;
        } //End block
    if(!validateNonNegativeInt("randomizationTime", randomizationTime))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1183848097 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811156974 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_811156974;
        } //End block
        mMaxRetryCount = maxRetryCount;
        resetRetryCount();
        mRetryArray.clear();
        mRetryArray.add(new RetryRec(retryTime, randomizationTime));
        boolean varB326B5062B2F0E69046810717534CB09_1636828291 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210204427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_210204427;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.059 -0400", hash_original_method = "C6612F6F1694E17ABFCC353841B58B91", hash_generated_method = "825587467A98D7CE9CE39072875F856A")
    public boolean configure(String configStr) {
        addTaint(configStr.getTaint());
    if((configStr.startsWith("\"") && configStr.endsWith("\"")))        
        {
            configStr = configStr.substring(1, configStr.length()-1);
        } //End block
    if(DBG)        
        log("configure: '" + configStr + "'");
    if(!TextUtils.isEmpty(configStr))        
        {
            int defaultRandomization = 0;
    if(DBG)            
            log("configure: not empty");
            mMaxRetryCount = 0;
            resetRetryCount();
            mRetryArray.clear();
            String strArray[] = configStr.split(",");
for(int i = 0;i < strArray.length;i++)
            {
    if(DBG)                
                log("configure: strArray[" + i + "]='" + strArray[i] + "'");
                Pair<Boolean, Integer> value;
                String splitStr[] = strArray[i].split("=", 2);
                splitStr[0] = splitStr[0].trim();
    if(DBG)                
                log("configure: splitStr[0]='" + splitStr[0] + "'");
    if(splitStr.length > 1)                
                {
                    splitStr[1] = splitStr[1].trim();
    if(DBG)                    
                    log("configure: splitStr[1]='" + splitStr[1] + "'");
    if(TextUtils.equals(splitStr[0], "default_randomization"))                    
                    {
                        value = parseNonNegativeInt(splitStr[0], splitStr[1]);
    if(!value.first)                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_135649570 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419906883 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419906883;
                        }
                        defaultRandomization = value.second;
                    } //End block
                    else
    if(TextUtils.equals(splitStr[0], "max_retries"))                    
                    {
    if(TextUtils.equals("infinite",splitStr[1]))                        
                        {
                            mRetryForever = true;
                        } //End block
                        else
                        {
                            value = parseNonNegativeInt(splitStr[0], splitStr[1]);
    if(!value.first)                            
                            {
                            boolean var68934A3E9455FA72420237EB05902327_383665118 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256476863 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256476863;
                            }
                            mMaxRetryCount = value.second;
                        } //End block
                    } //End block
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_190545445 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835577109 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835577109;
                    } //End block
                } //End block
                else
                {
                    splitStr = strArray[i].split(":", 2);
                    splitStr[0] = splitStr[0].trim();
                    RetryRec rr = new RetryRec(0, 0);
                    value = parseNonNegativeInt("delayTime", splitStr[0]);
    if(!value.first)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1678967451 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043096054 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043096054;
                    }
                    rr.mDelayTime = value.second;
    if(splitStr.length > 1)                    
                    {
                        splitStr[1] = splitStr[1].trim();
    if(DBG)                        
                        log("configure: splitStr[1]='" + splitStr[1] + "'");
                        value = parseNonNegativeInt("randomizationTime", splitStr[1]);
    if(!value.first)                        
                        {
                        boolean var68934A3E9455FA72420237EB05902327_1534399483 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879971651 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_879971651;
                        }
                        rr.mRandomizationTime = value.second;
                    } //End block
                    else
                    {
                        rr.mRandomizationTime = defaultRandomization;
                    } //End block
                    mRetryArray.add(rr);
                } //End block
            } //End block
    if(mRetryArray.size() > mMaxRetryCount)            
            {
                mMaxRetryCount = mRetryArray.size();
    if(DBG)                
                log("configure: setting mMaxRetryCount=" + mMaxRetryCount);
            } //End block
    if(DBG)            
            log("configure: true");
            boolean varB326B5062B2F0E69046810717534CB09_339464329 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070564824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070564824;
        } //End block
        else
        {
    if(DBG)            
            log("configure: false it's empty");
            boolean var68934A3E9455FA72420237EB05902327_1828099056 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925900038 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925900038;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.061 -0400", hash_original_method = "74B9CFC0074F7A248036F63581582633", hash_generated_method = "9D305FDB184DCC81936A5772588F61E5")
    public boolean isRetryNeeded() {
        boolean retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
    if(DBG)        
        log("isRetryNeeded: " + retVal);
        boolean var1E6151782509B2C92750CFF962B742CD_1107730238 = (retVal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045926532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045926532;
        // ---------- Original Method ----------
        //boolean retVal = mRetryForever || (mRetryCount < mMaxRetryCount);
        //if (DBG) log("isRetryNeeded: " + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.061 -0400", hash_original_method = "FDEB093A88716C2A22E1A70262EC26E6", hash_generated_method = "D9585DAE16A20A53B8DB08F8C5D54955")
    public int getRetryTimer() {
        int index;
    if(mRetryCount < mRetryArray.size())        
        {
            index = mRetryCount;
        } //End block
        else
        {
            index = mRetryArray.size() - 1;
        } //End block
        int retVal;
    if((index >= 0) && (index < mRetryArray.size()))        
        {
            retVal = mRetryArray.get(index).mDelayTime + nextRandomizationTime(index);
        } //End block
        else
        {
            retVal = 0;
        } //End block
    if(DBG)        
        log("getRetryTimer: " + retVal);
        int var1E6151782509B2C92750CFF962B742CD_1877567086 = (retVal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819506045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819506045;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.062 -0400", hash_original_method = "7864A3188C49B1562B5127F41B9781EB", hash_generated_method = "06795BF4146A93153EC577B50E1F9663")
    public int getRetryCount() {
    if(DBG)        
        log("getRetryCount: " + mRetryCount);
        int var4487E295EC45E6A32AAF433A1E157001_1003190437 = (mRetryCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799229910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799229910;
        // ---------- Original Method ----------
        //if (DBG) log("getRetryCount: " + mRetryCount);
        //return mRetryCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.062 -0400", hash_original_method = "BFFEAAE12F87E8C46DFE1D4E07480604", hash_generated_method = "974F315906E5ADCC7ABF2C3C9C5657C1")
    public void increaseRetryCount() {
        mRetryCount++;
    if(mRetryCount > mMaxRetryCount)        
        {
            mRetryCount = mMaxRetryCount;
        } //End block
    if(DBG)        
        log("increaseRetryCount: " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount++;
        //if (mRetryCount > mMaxRetryCount) {
            //mRetryCount = mMaxRetryCount;
        //}
        //if (DBG) log("increaseRetryCount: " + mRetryCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.063 -0400", hash_original_method = "A052AF31F22F35CA9E6DDD61D99CA6EF", hash_generated_method = "7DE42C7DA7113CBBEBADB0E25395BD76")
    public void setRetryCount(int count) {
        mRetryCount = count;
    if(mRetryCount > mMaxRetryCount)        
        {
            mRetryCount = mMaxRetryCount;
        } //End block
    if(mRetryCount < 0)        
        {
            mRetryCount = 0;
        } //End block
        mRetryForever = false;
    if(DBG)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.063 -0400", hash_original_method = "17739E86F508FAF2AC931D73653ADB87", hash_generated_method = "D36F3260FDC760F7AD5172F592EFFFD9")
    public void resetRetryCount() {
        mRetryCount = 0;
    if(DBG)        
        log("resetRetryCount: " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = 0;
        //if (DBG) log("resetRetryCount: " + mRetryCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.063 -0400", hash_original_method = "28FA3A141006A5A6B2A507757230F8F2", hash_generated_method = "58E62390435641786CCC4B6740F6DE8A")
    public void retryForeverUsingLastTimeout() {
        mRetryCount = mMaxRetryCount;
        mRetryForever = true;
    if(DBG)        
        log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
        // ---------- Original Method ----------
        //mRetryCount = mMaxRetryCount;
        //mRetryForever = true;
        //if (DBG) log("retryForeverUsingLastTimeout: " + mRetryForever + ", " + mRetryCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.064 -0400", hash_original_method = "A096FCFC79F5CC1E2EDA08CBC5F004E8", hash_generated_method = "D45EA95DFD634FE46733F852226AFAFC")
    public boolean isRetryForever() {
    if(DBG)        
        log("isRetryForever: " + mRetryForever);
        boolean varD57A5D2E2BB4C619441FBAA4CD14BD93_78815858 = (mRetryForever);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855939548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_855939548;
        // ---------- Original Method ----------
        //if (DBG) log("isRetryForever: " + mRetryForever);
        //return mRetryForever;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.064 -0400", hash_original_method = "CFEE2F1AF91E2D86FFF14B5518822AC3", hash_generated_method = "098506C197F80D9A52E90C7FEAE8B42A")
    private Pair<Boolean, Integer> parseNonNegativeInt(String name, String stringValue) {
        addTaint(stringValue.getTaint());
        addTaint(name.getTaint());
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
    if(DBG)        
        log("parseNonNetativeInt: " + name + ", " + stringValue + ", "
                    + retVal.first + ", " + retVal.second);
Pair<Boolean, Integer> var906583DF257E5B26DD99AC8582D137B0_737535008 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_737535008.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_737535008;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.065 -0400", hash_original_method = "732CF49E361007DEE3B2FC2D605BF87E", hash_generated_method = "AF462CB333E8F7345AA03042C5ADD7ED")
    private boolean validateNonNegativeInt(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        boolean retVal;
    if(value < 0)        
        {
            retVal = false;
        } //End block
        else
        {
            retVal = true;
        } //End block
    if(DBG)        
        log("validateNonNegative: " + name + ", " + value + ", " + retVal);
        boolean var1E6151782509B2C92750CFF962B742CD_776859223 = (retVal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015252237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015252237;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.066 -0400", hash_original_method = "C6100D6542DA0DEE21E22A63B7A19544", hash_generated_method = "F9157DCDA88F81604E481DB80BF65D8C")
    private int nextRandomizationTime(int index) {
        addTaint(index);
        int randomTime = mRetryArray.get(index).mRandomizationTime;
    if(randomTime == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1581476894 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49681871 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49681871;
        } //End block
        else
        {
            int varEAA8242B5954B27B82F0D6D703D89F8A_897126278 = (rng.nextInt(randomTime));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605637910 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605637910;
        } //End block
        // ---------- Original Method ----------
        //int randomTime = mRetryArray.get(index).mRandomizationTime;
        //if (randomTime == 0) {
            //return 0;
        //} else {
            //return rng.nextInt(randomTime);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.066 -0400", hash_original_method = "4CC3EDAC8B8BC9B5E954A182C692136C", hash_generated_method = "596DE089A32992B8B311A32C70116B6F")
    private void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, s);
    }

    
    private static class RetryRec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.066 -0400", hash_original_field = "764EF233E383FBF12DA59FF2DD43392C", hash_generated_field = "913DCF5FCF05A4BC45E2B52ED338322E")

        int mDelayTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.066 -0400", hash_original_field = "BD127CA4F9074A6E2E221CB1F56B86F1", hash_generated_field = "C0F0244DB495C4F7A8A1EB5174BBEC44")

        int mRandomizationTime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.067 -0400", hash_original_method = "69C230B0D836032F36CE6DFB69101575", hash_generated_method = "5000A7EE46494ABC4A714F9925EB7B34")
          RetryRec(int delayTime, int randomizationTime) {
            mDelayTime = delayTime;
            mRandomizationTime = randomizationTime;
            // ---------- Original Method ----------
            //mDelayTime = delayTime;
            //mRandomizationTime = randomizationTime;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.067 -0400", hash_original_field = "DEDEF0FC136CE349C44387AA9D5BC054", hash_generated_field = "3ABD7D9314FBBFD996D5BF26C38898E4")

    static public final String LOG_TAG = "RetryManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.067 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1310DF57561ADBC3BA33C25A70D2B921")

    static public final boolean DBG = false;
}

