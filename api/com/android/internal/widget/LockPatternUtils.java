package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import com.android.internal.R;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.content.Intent;
import java.security.SecureRandom;
import android.telephony.TelephonyManager;
import java.io.RandomAccessFile;
import android.app.admin.DevicePolicyManager;
import com.google.android.collect.Lists;
import android.content.ContentResolver;
import android.os.storage.IMountService;
import android.os.FileObserver;
import android.os.IBinder;
import java.security.MessageDigest;
import java.util.List;
import android.provider.Settings;
import com.android.internal.telephony.ITelephony;
import android.text.TextUtils;
import android.widget.Button;
import android.security.KeyStore;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.util.Arrays;
import android.content.pm.PackageManager;
import java.io.FileNotFoundException;
public class LockPatternUtils {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.625 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.625 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private ContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.626 -0400", hash_original_field = "529F56E72B0EEFC766FFCC9E4AC8760B", hash_generated_field = "B157C1253C008BF30259C90E080DBD00")

    private DevicePolicyManager mDevicePolicyManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.626 -0400", hash_original_method = "183C2344EC2818DFC798B6911AECA24F", hash_generated_method = "56DD45C611D19AEFBDD52568B3170522")
    public  LockPatternUtils(Context context) {
        addTaint(context.getTaint());
mContext=contextmContentResolver=context.getContentResolver()        if(sLockPatternFilename==null)        
        {
            String dataSystemDirectory = android.os.Environment.getDataDirectory().getAbsolutePath() +
                    SYSTEM_DIRECTORY;
sLockPatternFilename=dataSystemDirectory+LOCK_PATTERN_FILEsLockPasswordFilename=dataSystemDirectory+LOCK_PASSWORD_FILEsHaveNonZeroPatternFile.set(new File(sLockPatternFilename).length()>0)sHaveNonZeroPasswordFile.set(new File(sLockPasswordFilename).length()>0)            int fileObserverMask = FileObserver.CLOSE_WRITE | FileObserver.DELETE |
                    FileObserver.MOVED_TO | FileObserver.CREATE;
sPasswordObserver=new PasswordFileObserver(dataSystemDirectory, fileObserverMask)sPasswordObserver.startWatching()
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.628 -0400", hash_original_method = "452A70B2DBDD61905951FF799359AC2C", hash_generated_method = "8A00F6D128C7BCF9E8134B72C927321B")
    public DevicePolicyManager getDevicePolicyManager() {
        if(mDevicePolicyManager==null)        
        {
mDevicePolicyManager=(DevicePolicyManager) mContext.getSystemService(Context.DEVICE_POLICY_SERVICE)            if(mDevicePolicyManager==null)            
            {
            } //End block
        } //End block
DevicePolicyManager varFCB7E4D856186B1D76ED2F024F22820E_1149960512 = mDevicePolicyManager        varFCB7E4D856186B1D76ED2F024F22820E_1149960512.addTaint(taint);
        return varFCB7E4D856186B1D76ED2F024F22820E_1149960512;
        // ---------- Original Method ----------
        //if (mDevicePolicyManager == null) {
            //mDevicePolicyManager =
                //(DevicePolicyManager)mContext.getSystemService(Context.DEVICE_POLICY_SERVICE);
            //if (mDevicePolicyManager == null) {
                //Log.e(TAG, "Can't get DevicePolicyManagerService: is it running?",
                        //new IllegalStateException("Stack trace:"));
            //}
        //}
        //return mDevicePolicyManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.628 -0400", hash_original_method = "071D431ED4D91FB08E38AB568C891054", hash_generated_method = "4B64869D124B03A0F7A2D5B6BA3E5EEA")
    public int getRequestedMinimumPasswordLength() {
        int varF75E161EBA471E27B2114AEE1D114755_473109141 = (getDevicePolicyManager().getPasswordMinimumLength(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531219893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531219893;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumLength(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.629 -0400", hash_original_method = "370339E5EAC04FAA2B63A7E0A96FB9B7", hash_generated_method = "E964A6DEEA692AE1214E4F25A645D61E")
    public int getRequestedPasswordQuality() {
        int var90A1AEB21AF2E9078BD497CCFB739541_816274222 = (getDevicePolicyManager().getPasswordQuality(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32982863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32982863;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordQuality(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.630 -0400", hash_original_method = "962B2A503AFD89BCE4F13C03F13134A4", hash_generated_method = "E031EC7814461A41EE32EB217B089FE7")
    public int getRequestedPasswordHistoryLength() {
        int var481FBAEE3ACF60E82CD034BC36E4B6AB_1223535050 = (getDevicePolicyManager().getPasswordHistoryLength(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631134523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631134523;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordHistoryLength(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.630 -0400", hash_original_method = "1EB5E5045E4A88E3A128A8E8D09566B6", hash_generated_method = "AEE20F126D5FD25709A3E09F445D8AE0")
    public int getRequestedPasswordMinimumLetters() {
        int varA2B6DB6C8799E3BBF7EA07A32EF29788_1496458462 = (getDevicePolicyManager().getPasswordMinimumLetters(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644819377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644819377;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumLetters(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.630 -0400", hash_original_method = "7F101E78F64240FB2E3829549AF8FB2B", hash_generated_method = "DB4542725A1C6854F21CB716E6C4C798")
    public int getRequestedPasswordMinimumUpperCase() {
        int var585C682B769B5FF1706F3D77AB248730_1972074683 = (getDevicePolicyManager().getPasswordMinimumUpperCase(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220109848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220109848;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumUpperCase(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.631 -0400", hash_original_method = "D3AE6AF69877DDEF74A4A24716DA4178", hash_generated_method = "232E515046C52A7568A1B2E808334646")
    public int getRequestedPasswordMinimumLowerCase() {
        int var860A8C7D84B614177CF8BAE393320CDE_1878079946 = (getDevicePolicyManager().getPasswordMinimumLowerCase(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951551368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951551368;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumLowerCase(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.631 -0400", hash_original_method = "7F5F621E7ABF55EE27EF40CF0789DCDA", hash_generated_method = "0E3C7DEDEB855B672113D70B3903BE86")
    public int getRequestedPasswordMinimumNumeric() {
        int varC2761F1434B3C890D2B1DCBDB03F1F92_2060939672 = (getDevicePolicyManager().getPasswordMinimumNumeric(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96207998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96207998;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumNumeric(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.632 -0400", hash_original_method = "9B66F205A5A5F019BAE309811923D6E8", hash_generated_method = "FBC059F15B21C5EC1CD7C52E937AF5D9")
    public int getRequestedPasswordMinimumSymbols() {
        int var71DF2860B00E9943A4FAB4CC9D978789_861368870 = (getDevicePolicyManager().getPasswordMinimumSymbols(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470748464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470748464;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumSymbols(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.632 -0400", hash_original_method = "9D752C5048FEB6D8F3B296409C1E0CBD", hash_generated_method = "C11A071FEA155DBDF4EBA8FD776C23CA")
    public int getRequestedPasswordMinimumNonLetter() {
        int varE3636C0875797059D172664B9D34DE48_2060353903 = (getDevicePolicyManager().getPasswordMinimumNonLetter(null));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463686037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463686037;
        // ---------- Original Method ----------
        //return getDevicePolicyManager().getPasswordMinimumNonLetter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.633 -0400", hash_original_method = "C9556A283BCD81FCFF615D9A4435C9C9", hash_generated_method = "57DF9D21EB15252167F441B9281B131E")
    public void reportFailedPasswordAttempt() {
getDevicePolicyManager().reportFailedPasswordAttempt()
        // ---------- Original Method ----------
        //getDevicePolicyManager().reportFailedPasswordAttempt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.633 -0400", hash_original_method = "D4E3B7C952A28A15B99AD0C9263EE0F0", hash_generated_method = "DCCF2B690D1AAC051427E24BF08E244E")
    public void reportSuccessfulPasswordAttempt() {
getDevicePolicyManager().reportSuccessfulPasswordAttempt()
        // ---------- Original Method ----------
        //getDevicePolicyManager().reportSuccessfulPasswordAttempt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.635 -0400", hash_original_method = "A153D5A8DE064A796317F051828658E0", hash_generated_method = "0604CDE0969D84B1BE5410ADD5E8541B")
    public boolean checkPattern(List<LockPatternView.Cell> pattern) {
        addTaint(pattern.getTaint());
        try 
        {
            RandomAccessFile raf = new RandomAccessFile(sLockPatternFilename, "r");
            final byte[] stored = new byte[(int) raf.length()];
            int got = raf.read(stored, 0, stored.length);
raf.close()            if(got<=0)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1546556911 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844356360 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844356360;
            } //End block
            boolean var3A5C2FC112CA15B8722D9A56E4043D6A_1444795427 = (Arrays.equals(stored, LockPatternUtils.patternToHash(pattern)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576652654 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_576652654;
        } //End block
        catch (FileNotFoundException fnfe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_923396684 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311106251 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311106251;
        } //End block
        catch (IOException ioe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_2086663147 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676902675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_676902675;
        } //End block
        // ---------- Original Method ----------
        //try {
            //RandomAccessFile raf = new RandomAccessFile(sLockPatternFilename, "r");
            //final byte[] stored = new byte[(int) raf.length()];
            //int got = raf.read(stored, 0, stored.length);
            //raf.close();
            //if (got <= 0) {
                //return true;
            //}
            //return Arrays.equals(stored, LockPatternUtils.patternToHash(pattern));
        //} catch (FileNotFoundException fnfe) {
            //return true;
        //} catch (IOException ioe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.636 -0400", hash_original_method = "89BDC84BD65EA1F5015165A014BA29B0", hash_generated_method = "F760C99CB61831F02B766B1B55BD8616")
    public boolean checkPassword(String password) {
        addTaint(password.getTaint());
        try 
        {
            RandomAccessFile raf = new RandomAccessFile(sLockPasswordFilename, "r");
            final byte[] stored = new byte[(int) raf.length()];
            int got = raf.read(stored, 0, stored.length);
raf.close()            if(got<=0)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_467214299 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999110945 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999110945;
            } //End block
            boolean var6D7B9C1A2B6F14A5853A87E4418A3C6D_102737516 = (Arrays.equals(stored, passwordToHash(password)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514265925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_514265925;
        } //End block
        catch (FileNotFoundException fnfe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1561219091 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217305973 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_217305973;
        } //End block
        catch (IOException ioe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1864414873 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825549682 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825549682;
        } //End block
        // ---------- Original Method ----------
        //try {
            //RandomAccessFile raf = new RandomAccessFile(sLockPasswordFilename, "r");
            //final byte[] stored = new byte[(int) raf.length()];
            //int got = raf.read(stored, 0, stored.length);
            //raf.close();
            //if (got <= 0) {
                //return true;
            //}
            //return Arrays.equals(stored, passwordToHash(password));
        //} catch (FileNotFoundException fnfe) {
            //return true;
        //} catch (IOException ioe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.638 -0400", hash_original_method = "436E2310FC226D159367D0AACD5EC3AD", hash_generated_method = "25E48DBD37B8CC1E1B308DACC259272B")
    public boolean checkPasswordHistory(String password) {
        addTaint(password.getTaint());
        String passwordHashString = new String(passwordToHash(password));
        String passwordHistory = getString(PASSWORD_HISTORY_KEY);
        if(passwordHistory==null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_195480484 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533541832 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533541832;
        } //End block
        int passwordHashLength = passwordHashString.length();
        int passwordHistoryLength = getRequestedPasswordHistoryLength();
        if(passwordHistoryLength==0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1264236386 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_558502997 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_558502997;
        } //End block
        int neededPasswordHistoryLength = passwordHashLength * passwordHistoryLength
                + passwordHistoryLength - 1;
        if(passwordHistory.length()>neededPasswordHistoryLength)        
        {
passwordHistory=passwordHistory.substring(0, neededPasswordHistoryLength)
        } //End block
        boolean varAED68F377D2105CCDCCAC368640D4C18_586354243 = (passwordHistory.contains(passwordHashString));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563873596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563873596;
        // ---------- Original Method ----------
        //String passwordHashString = new String(passwordToHash(password));
        //String passwordHistory = getString(PASSWORD_HISTORY_KEY);
        //if (passwordHistory == null) {
            //return false;
        //}
        //int passwordHashLength = passwordHashString.length();
        //int passwordHistoryLength = getRequestedPasswordHistoryLength();
        //if(passwordHistoryLength == 0) {
            //return false;
        //}
        //int neededPasswordHistoryLength = passwordHashLength * passwordHistoryLength
                //+ passwordHistoryLength - 1;
        //if (passwordHistory.length() > neededPasswordHistoryLength) {
            //passwordHistory = passwordHistory.substring(0, neededPasswordHistoryLength);
        //}
        //return passwordHistory.contains(passwordHashString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.639 -0400", hash_original_method = "0F71A2BB993E0F1B4A25103BEB651680", hash_generated_method = "FE1E751BAC5CE028597E605CE34AAD23")
    public boolean savedPatternExists() {
        boolean var3B76F17177AD3D30167972B55A70676B_1064382866 = (sHaveNonZeroPatternFile.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683012012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683012012;
        // ---------- Original Method ----------
        //return sHaveNonZeroPatternFile.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.639 -0400", hash_original_method = "6A5587249C6EBED88C7E8997F19D7F30", hash_generated_method = "C67D4E10D00B782E1500B71C48372660")
    public boolean savedPasswordExists() {
        boolean var474EE0288C657651D63423F88F4460AA_1313162993 = (sHaveNonZeroPasswordFile.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354381789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354381789;
        // ---------- Original Method ----------
        //return sHaveNonZeroPasswordFile.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.640 -0400", hash_original_method = "E9B3533B10B8CEC2ED54126015B27381", hash_generated_method = "1E49A031E9B49E0E782169B77802CFAF")
    public boolean isPatternEverChosen() {
        boolean varCFDF46C3F37C4D4C56D4DD44FDA173EC_262185312 = (getBoolean(PATTERN_EVER_CHOSEN_KEY));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325820029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325820029;
        // ---------- Original Method ----------
        //return getBoolean(PATTERN_EVER_CHOSEN_KEY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.641 -0400", hash_original_method = "DA3DF0DD6E2D2E5ADCCA098342407A26", hash_generated_method = "37457D1CF5A39B2C55E04762D162E8FA")
    public boolean isBiometricWeakEverChosen() {
        boolean var3AAAA7D261AF845C42B37007FD40642A_997317662 = (getBoolean(BIOMETRIC_WEAK_EVER_CHOSEN_KEY));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082544815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082544815;
        // ---------- Original Method ----------
        //return getBoolean(BIOMETRIC_WEAK_EVER_CHOSEN_KEY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.641 -0400", hash_original_method = "E75BB324E2F86B3732900E39952FAD2D", hash_generated_method = "6EB71306F41CD9CBC0425E3F4C996E78")
    public int getActivePasswordQuality() {
        int activePasswordQuality = DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED;
        int quality = (int) getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        switch(quality){
        case DevicePolicyManager.PASSWORD_QUALITY_SOMETHING:
        if(isLockPatternEnabled())        
        {
activePasswordQuality=DevicePolicyManager.PASSWORD_QUALITY_SOMETHING
        } //End block
        break;
        case DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK:
        if(isBiometricWeakInstalled())        
        {
activePasswordQuality=DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK
        } //End block
        break;
        case DevicePolicyManager.PASSWORD_QUALITY_NUMERIC:
        if(isLockPasswordEnabled())        
        {
activePasswordQuality=DevicePolicyManager.PASSWORD_QUALITY_NUMERIC
        } //End block
        break;
        case DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC:
        if(isLockPasswordEnabled())        
        {
activePasswordQuality=DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC
        } //End block
        break;
        case DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC:
        if(isLockPasswordEnabled())        
        {
activePasswordQuality=DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC
        } //End block
        break;
        case DevicePolicyManager.PASSWORD_QUALITY_COMPLEX:
        if(isLockPasswordEnabled())        
        {
activePasswordQuality=DevicePolicyManager.PASSWORD_QUALITY_COMPLEX
        } //End block
        break;
}        int var8E1446D2AE41FF71FE1E0C3189501BAF_303249760 = (activePasswordQuality);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206619838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206619838;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.642 -0400", hash_original_method = "43CB063CFEC3A3B732CB2A24CFCC8C46", hash_generated_method = "37DF0C8846685A872C02CB2DDA82A58D")
    public void clearLock(boolean isFallback) {
        addTaint(isFallback);
        if(!isFallback)        
deleteGallery()
saveLockPassword(null, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)setLockPatternEnabled(false)saveLockPattern(null)setLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)setLong(PASSWORD_TYPE_ALTERNATE_KEY, DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED)
        // ---------- Original Method ----------
        //if(!isFallback) deleteGallery();
        //saveLockPassword(null, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        //setLockPatternEnabled(false);
        //saveLockPattern(null);
        //setLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        //setLong(PASSWORD_TYPE_ALTERNATE_KEY, DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.642 -0400", hash_original_method = "823C0A1C66E84A08EA50E1FE5C651AC5", hash_generated_method = "A96DD81AF1D93864287353C2CF9B14BE")
    public void setLockScreenDisabled(boolean disable) {
        addTaint(disable);
setLong(DISABLE_LOCKSCREEN_KEY, disable?1:1)
        // ---------- Original Method ----------
        //setLong(DISABLE_LOCKSCREEN_KEY, disable ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.643 -0400", hash_original_method = "F91A52B864743D1DB2BBB3CE04052A5E", hash_generated_method = "29EB2D58531F16EAF7AED465AAA29203")
    public boolean isLockScreenDisabled() {
        boolean varFDF0DA50EA0B9FC653841BA93BB1C8AF_1396761797 = (!isSecure()&&getLong(DISABLE_LOCKSCREEN_KEY, 0)!=0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400626608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400626608;
        // ---------- Original Method ----------
        //return !isSecure() && getLong(DISABLE_LOCKSCREEN_KEY, 0) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.643 -0400", hash_original_method = "6E141300FB87680C6AF97F8ED460E55D", hash_generated_method = "DE62B56CB71B0B337EF905EFE5AE0C08")
    public void saveLockPattern(List<LockPatternView.Cell> pattern) {
        addTaint(pattern.getTaint());
this.saveLockPattern(pattern, false)
        // ---------- Original Method ----------
        //this.saveLockPattern(pattern, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.643 -0400", hash_original_method = "FF7193298D087863609AABF5449F010C", hash_generated_method = "291AB94495184139440D7DE66CD326CA")
    public void deleteTempGallery() {
        Intent intent = new Intent().setClassName("com.android.facelock",
                "com.android.facelock.SetupFaceLock");
intent.putExtra("deleteTempGallery", true)mContext.startActivity(intent)
        // ---------- Original Method ----------
        //Intent intent = new Intent().setClassName("com.android.facelock",
                //"com.android.facelock.SetupFaceLock");
        //intent.putExtra("deleteTempGallery", true);
        //mContext.startActivity(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.644 -0400", hash_original_method = "3AE4D178F44FDCCDC8B04AE87702C9C3", hash_generated_method = "07427324968FF5D30E1B8E8B676ED4A6")
     void deleteGallery() {
        if(usingBiometricWeak())        
        {
            Intent intent = new Intent().setClassName("com.android.facelock",
                    "com.android.facelock.SetupFaceLock");
intent.putExtra("deleteGallery", true)mContext.startActivity(intent)
        } //End block
        // ---------- Original Method ----------
        //if(usingBiometricWeak()) {
            //Intent intent = new Intent().setClassName("com.android.facelock",
                    //"com.android.facelock.SetupFaceLock");
            //intent.putExtra("deleteGallery", true);
            //mContext.startActivity(intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.645 -0400", hash_original_method = "7C9737ABC1B0BEEAED30475702E79611", hash_generated_method = "6FECCA59E5B5925AB3ECDCCBA5E95BF6")
    public void saveLockPattern(List<LockPatternView.Cell> pattern, boolean isFallback) {
        addTaint(isFallback);
        addTaint(pattern.getTaint());
        final byte[] hash = LockPatternUtils.patternToHash(pattern);
        try 
        {
            RandomAccessFile raf = new RandomAccessFile(sLockPatternFilename, "rw");
            if(pattern==null)            
            {
raf.setLength(0)
            } //End block
            else
            {
raf.write(hash, 0, hash.length)
            } //End block
raf.close()            DevicePolicyManager dpm = getDevicePolicyManager();
            KeyStore keyStore = KeyStore.getInstance();
            if(pattern!=null)            
            {
keyStore.password(patternToString(pattern))setBoolean(PATTERN_EVER_CHOSEN_KEY, true)                if(!isFallback)                
                {
deleteGallery()setLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)
                } //End block
                else
                {
setLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK)setLong(PASSWORD_TYPE_ALTERNATE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)finishBiometricWeak()
                } //End block
dpm.setActivePasswordState(DevicePolicyManager.PASSWORD_QUALITY_SOMETHING, pattern.size(), 0, 0, 0, 0, 0, 0)
            } //End block
            else
            {
                if(keyStore.isEmpty())                
                {
keyStore.reset()
                } //End block
dpm.setActivePasswordState(DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED, 0, 0, 0, 0, 0, 0, 0)
            } //End block
        } //End block
        catch (FileNotFoundException fnfe)
        {
        } //End block
        catch (IOException ioe)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static public int computePasswordQuality(String password) {
        boolean hasDigit = false;
        boolean hasNonDigit = false;
        final int len = password.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            } else {
                hasNonDigit = true;
            }
        }
        if (hasNonDigit && hasDigit) {
            return DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC;
        }
        if (hasNonDigit) {
            return DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC;
        }
        if (hasDigit) {
            return DevicePolicyManager.PASSWORD_QUALITY_NUMERIC;
        }
        return DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.646 -0400", hash_original_method = "4BCF1881E1B65C9B00169F1F21DF0E92", hash_generated_method = "3AF3838EFD53D532A178190551653566")
    private void updateEncryptionPassword(String password) {
        addTaint(password.getTaint());
        DevicePolicyManager dpm = getDevicePolicyManager();
        if(dpm.getStorageEncryptionStatus()!=DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE)        
        {
            return;
        } //End block
        IBinder service = ServiceManager.getService("mount");
        if(service==null)        
        {
            return;
        } //End block
        IMountService mountService = IMountService.Stub.asInterface(service);
        try 
        {
mountService.changeEncryptionPassword(password)
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //DevicePolicyManager dpm = getDevicePolicyManager();
        //if (dpm.getStorageEncryptionStatus() != DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE) {
            //return;
        //}
        //IBinder service = ServiceManager.getService("mount");
        //if (service == null) {
            //Log.e(TAG, "Could not find the mount service to update the encryption password");
            //return;
        //}
        //IMountService mountService = IMountService.Stub.asInterface(service);
        //try {
            //mountService.changeEncryptionPassword(password);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Error changing encryption password", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.647 -0400", hash_original_method = "E6B9D66152AD34AAD5F65F4C928F6622", hash_generated_method = "FA047444A2B50BD57D6DD340A11E242C")
    public void saveLockPassword(String password, int quality) {
        addTaint(quality);
        addTaint(password.getTaint());
this.saveLockPassword(password, quality, false)
        // ---------- Original Method ----------
        //this.saveLockPassword(password, quality, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.649 -0400", hash_original_method = "B6D1A15E01CA684E3B440746087E0C45", hash_generated_method = "AFC170BAE950DFE1D23DD435A7E6AC60")
    public void saveLockPassword(String password, int quality, boolean isFallback) {
        addTaint(isFallback);
        addTaint(quality);
        addTaint(password.getTaint());
        final byte[] hash = passwordToHash(password);
        try 
        {
            RandomAccessFile raf = new RandomAccessFile(sLockPasswordFilename, "rw");
            if(password==null)            
            {
raf.setLength(0)
            } //End block
            else
            {
raf.write(hash, 0, hash.length)
            } //End block
raf.close()            DevicePolicyManager dpm = getDevicePolicyManager();
            KeyStore keyStore = KeyStore.getInstance();
            if(password!=null)            
            {
updateEncryptionPassword(password)keyStore.password(password)                int computedQuality = computePasswordQuality(password);
                if(!isFallback)                
                {
deleteGallery()setLong(PASSWORD_TYPE_KEY, Math.max(quality, computedQuality))
                } //End block
                else
                {
setLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK)setLong(PASSWORD_TYPE_ALTERNATE_KEY, Math.max(quality, computedQuality))finishBiometricWeak()
                } //End block
                if(computedQuality!=DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED)                
                {
                    int letters = 0;
                    int uppercase = 0;
                    int lowercase = 0;
                    int numbers = 0;
                    int symbols = 0;
                    int nonletter = 0;
for(int i = 0;i<password.length();i)
                    {
                        char c = password.charAt(i);
                        if(c>='A'&&c<='Z')                        
                        {
lettersuppercase
                        } //End block
                        else
                        if(c>='a'&&c<='z')                        
                        {
letterslowercase
                        } //End block
                        else
                        if(c>='0'&&c<='9')                        
                        {
numbersnonletter
                        } //End block
                        else
                        {
symbolsnonletter
                        } //End block
                    } //End block
dpm.setActivePasswordState(Math.max(quality, computedQuality), password.length(), letters, uppercase, lowercase, numbers, symbols, nonletter)
                } //End block
                else
                {
dpm.setActivePasswordState(DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED, 0, 0, 0, 0, 0, 0, 0)
                } //End block
                String passwordHistory = getString(PASSWORD_HISTORY_KEY);
                if(passwordHistory==null)                
                {
passwordHistory=new String()
                } //End block
                int passwordHistoryLength = getRequestedPasswordHistoryLength();
                if(passwordHistoryLength==0)                
                {
passwordHistory=""
                } //End block
                else
                {
passwordHistory=new String(hash)+","+passwordHistorypasswordHistory=passwordHistory.substring(0, Math.min(hash.length*passwordHistoryLength+passwordHistoryLength-1, passwordHistory.length()))
                } //End block
setString(PASSWORD_HISTORY_KEY, passwordHistory)
            } //End block
            else
            {
                if(keyStore.isEmpty())                
                {
keyStore.reset()
                } //End block
dpm.setActivePasswordState(DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED, 0, 0, 0, 0, 0, 0, 0)
            } //End block
        } //End block
        catch (FileNotFoundException fnfe)
        {
        } //End block
        catch (IOException ioe)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.650 -0400", hash_original_method = "ABEAD86574FE58C7A8C40AB4D18D9568", hash_generated_method = "96C6A8C61EE20BF8FE95FAB47603FEF5")
    public int getKeyguardStoredPasswordQuality() {
        int quality = (int) getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        if(quality==DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK)        
        {
quality=(int) getLong(PASSWORD_TYPE_ALTERNATE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)
        } //End block
        int varD66636B253CB346DBB6240E30DEF3618_377768876 = (quality);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89277172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89277172;
        // ---------- Original Method ----------
        //int quality =
                //(int) getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        //if (quality == DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK) {
            //quality =
                //(int) getLong(PASSWORD_TYPE_ALTERNATE_KEY,
                        //DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        //}
        //return quality;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.650 -0400", hash_original_method = "0C4DF7E11274EAC1D36C3B437D8AD46F", hash_generated_method = "AFE0C0A58717119C3A5872656D7880A4")
    public boolean usingBiometricWeak() {
        int quality = (int) getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        boolean var199ABB955CCD9D82DDB2F6F2A3BB76D2_379303197 = (quality==DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224015653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224015653;
        // ---------- Original Method ----------
        //int quality =
                //(int) getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
        //return quality == DevicePolicyManager.PASSWORD_QUALITY_BIOMETRIC_WEAK;
    }

    
        public static List<LockPatternView.Cell> stringToPattern(String string) {
        List<LockPatternView.Cell> result = Lists.newArrayList();
        final byte[] bytes = string.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            result.add(LockPatternView.Cell.of(b / 3, b % 3));
        }
        return result;
    }

    
        public static String patternToString(List<LockPatternView.Cell> pattern) {
        if (pattern == null) {
            return "";
        }
        final int patternSize = pattern.size();
        byte[] res = new byte[patternSize];
        for (int i = 0; i < patternSize; i++) {
            LockPatternView.Cell cell = pattern.get(i);
            res[i] = (byte) (cell.getRow() * 3 + cell.getColumn());
        }
        return new String(res);
    }

    
        private static byte[] patternToHash(List<LockPatternView.Cell> pattern) {
        if (pattern == null) {
            return null;
        }
        final int patternSize = pattern.size();
        byte[] res = new byte[patternSize];
        for (int i = 0; i < patternSize; i++) {
            LockPatternView.Cell cell = pattern.get(i);
            res[i] = (byte) (cell.getRow() * 3 + cell.getColumn());
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(res);
            return hash;
        } catch (NoSuchAlgorithmException nsa) {
            return res;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.654 -0400", hash_original_method = "E3BABD2F856E7730A291A7417BD13F73", hash_generated_method = "2A75A2E2215605A4DC21EA15440B371E")
    private String getSalt() {
        long salt = getLong(LOCK_PASSWORD_SALT_KEY, 0);
        if(salt==0)        
        {
            try 
            {
salt=SecureRandom.getInstance("SHA1PRNG").nextLong()setLong(LOCK_PASSWORD_SALT_KEY, salt)
            } //End block
            catch (NoSuchAlgorithmException e)
            {
                IllegalStateException var9C5FB08F846F7C096913C664621561E1_1847562480 = new IllegalStateException("Couldn't get SecureRandom number", e);
                var9C5FB08F846F7C096913C664621561E1_1847562480.addTaint(taint);
                throw var9C5FB08F846F7C096913C664621561E1_1847562480;
            } //End block
        } //End block
String var62E9B63DC2595B78BE19AB3D02AF5FC9_1016565247 = Long.toHexString(salt)        var62E9B63DC2595B78BE19AB3D02AF5FC9_1016565247.addTaint(taint);
        return var62E9B63DC2595B78BE19AB3D02AF5FC9_1016565247;
        // ---------- Original Method ----------
        //long salt = getLong(LOCK_PASSWORD_SALT_KEY, 0);
        //if (salt == 0) {
            //try {
                //salt = SecureRandom.getInstance("SHA1PRNG").nextLong();
                //setLong(LOCK_PASSWORD_SALT_KEY, salt);
                //Log.v(TAG, "Initialized lock password salt");
            //} catch (NoSuchAlgorithmException e) {
                //throw new IllegalStateException("Couldn't get SecureRandom number", e);
            //}
        //}
        //return Long.toHexString(salt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.655 -0400", hash_original_method = "C524AA3C3FF810658D9D83A53190E501", hash_generated_method = "73DCB7039C15BDDAD66FF10930479FBC")
    public byte[] passwordToHash(String password) {
        addTaint(password.getTaint());
        if(password==null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1721830510 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_405551054 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_405551054;
        } //End block
        String algo = null;
        byte[] hashed = null;
        try 
        {
            byte[] saltedPassword = (password + getSalt()).getBytes();
            byte[] sha1 = MessageDigest.getInstance(algo = "SHA-1").digest(saltedPassword);
            byte[] md5 = MessageDigest.getInstance(algo = "MD5").digest(saltedPassword);
hashed=(toHex(sha1)+toHex(md5)).getBytes()
        } //End block
        catch (NoSuchAlgorithmException e)
        {
        } //End block
        byte[] varDF9F7C813FDC72029B41758EF8DBB528_161080328 = (hashed);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_910668525 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_910668525;
        // ---------- Original Method ----------
        //if (password == null) {
            //return null;
        //}
        //String algo = null;
        //byte[] hashed = null;
        //try {
            //byte[] saltedPassword = (password + getSalt()).getBytes();
            //byte[] sha1 = MessageDigest.getInstance(algo = "SHA-1").digest(saltedPassword);
            //byte[] md5 = MessageDigest.getInstance(algo = "MD5").digest(saltedPassword);
            //hashed = (toHex(sha1) + toHex(md5)).getBytes();
        //} catch (NoSuchAlgorithmException e) {
            //Log.w(TAG, "Failed to encode string because of missing algorithm: " + algo);
        //}
        //return hashed;
    }

    
        private static String toHex(byte[] ary) {
        final String hex = "0123456789ABCDEF";
        String ret = "";
        for (int i = 0; i < ary.length; i++) {
            ret += hex.charAt((ary[i] >> 4) & 0xf);
            ret += hex.charAt(ary[i] & 0xf);
        }
        return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.656 -0400", hash_original_method = "7DD8150C77FC2A05BF9A518CF302304C", hash_generated_method = "84BA09C3C5EBB790E51FDFAF2C42A08E")
    public boolean isLockPasswordEnabled() {
        long mode = getLong(PASSWORD_TYPE_KEY, 0);
        long backupMode = getLong(PASSWORD_TYPE_ALTERNATE_KEY, 0);
        final boolean passwordEnabled = mode == DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC
                || mode == DevicePolicyManager.PASSWORD_QUALITY_NUMERIC
                || mode == DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC
                || mode == DevicePolicyManager.PASSWORD_QUALITY_COMPLEX;
        final boolean backupEnabled = backupMode == DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC
                || backupMode == DevicePolicyManager.PASSWORD_QUALITY_NUMERIC
                || backupMode == DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC
                || backupMode == DevicePolicyManager.PASSWORD_QUALITY_COMPLEX;
        boolean var70B6A0DE1F488BFDB389EDEFF6355615_1269348567 = (savedPasswordExists()&&(passwordEnabled||(usingBiometricWeak()&&backupEnabled)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625061060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625061060;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.657 -0400", hash_original_method = "0070B6E45ABBA51CAC40BABCC9F6A9FB", hash_generated_method = "24631207BE6F2BE26CA22FA176892857")
    public boolean isLockPatternEnabled() {
        final boolean backupEnabled = getLong(PASSWORD_TYPE_ALTERNATE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)
                == DevicePolicyManager.PASSWORD_QUALITY_SOMETHING;
        boolean varF772301D92783CAE0779235F1A641AB9_1924701530 = (getBoolean(Settings.Secure.LOCK_PATTERN_ENABLED)&&(getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)==DevicePolicyManager.PASSWORD_QUALITY_SOMETHING||(usingBiometricWeak()&&backupEnabled)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609083922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609083922;
        // ---------- Original Method ----------
        //final boolean backupEnabled =
                //getLong(PASSWORD_TYPE_ALTERNATE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)
                //== DevicePolicyManager.PASSWORD_QUALITY_SOMETHING;
        //return getBoolean(Settings.Secure.LOCK_PATTERN_ENABLED)
                //&& (getLong(PASSWORD_TYPE_KEY, DevicePolicyManager.PASSWORD_QUALITY_SOMETHING)
                        //== DevicePolicyManager.PASSWORD_QUALITY_SOMETHING ||
                        //(usingBiometricWeak() && backupEnabled));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.658 -0400", hash_original_method = "F57397145CA0B1CF46000613C5FE9E83", hash_generated_method = "12701C7A87853465009812C9295BFE33")
    public boolean isBiometricWeakInstalled() {
        if(!OPTION_ENABLE_FACELOCK.equals(getString(LOCKSCREEN_OPTIONS)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1666413420 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324611585 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324611585;
        } //End block
        PackageManager pm = mContext.getPackageManager();
        try 
        {
pm.getPackageInfo("com.android.facelock", PackageManager.GET_ACTIVITIES)
        } //End block
        catch (PackageManager.NameNotFoundException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1833228259 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304981783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_304981783;
        } //End block
        if(!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1824509943 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305385106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_305385106;
        } //End block
        if(getDevicePolicyManager().getCameraDisabled(null))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1871623843 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_84696626 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_84696626;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1571526520 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412122290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412122290;
        // ---------- Original Method ----------
        //if (!OPTION_ENABLE_FACELOCK.equals(getString(LOCKSCREEN_OPTIONS))) {
            //return false;
        //}
        //PackageManager pm = mContext.getPackageManager();
        //try {
            //pm.getPackageInfo("com.android.facelock", PackageManager.GET_ACTIVITIES);
        //} catch (PackageManager.NameNotFoundException e) {
            //return false;
        //}
        //if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
            //return false;
        //}
        //if (getDevicePolicyManager().getCameraDisabled(null)) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.659 -0400", hash_original_method = "C47EB24AD57C262D1844A48478A03634", hash_generated_method = "97E54D9D1474CF92AA326D79937EAD87")
    public void setLockPatternEnabled(boolean enabled) {
        addTaint(enabled);
setBoolean(Settings.Secure.LOCK_PATTERN_ENABLED, enabled)
        // ---------- Original Method ----------
        //setBoolean(Settings.Secure.LOCK_PATTERN_ENABLED, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.660 -0400", hash_original_method = "60BCB97607E2D29CE951A7F0A1B56C22", hash_generated_method = "47B1FF509083D7123DC9D99A49D8AA9C")
    public boolean isVisiblePatternEnabled() {
        boolean var9F3DBD9D52C8D059D9A47CE44B3E4361_590952055 = (getBoolean(Settings.Secure.LOCK_PATTERN_VISIBLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_53616355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_53616355;
        // ---------- Original Method ----------
        //return getBoolean(Settings.Secure.LOCK_PATTERN_VISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.660 -0400", hash_original_method = "52B02F29F189A084BFC2C8A2BA1AB928", hash_generated_method = "549EEB52DBBD498D013EBC91D3782117")
    public void setVisiblePatternEnabled(boolean enabled) {
        addTaint(enabled);
setBoolean(Settings.Secure.LOCK_PATTERN_VISIBLE, enabled)
        // ---------- Original Method ----------
        //setBoolean(Settings.Secure.LOCK_PATTERN_VISIBLE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.661 -0400", hash_original_method = "F3AFBC6933781230DA7B5A013541673E", hash_generated_method = "E33DAA91426DC9F5212774FB50EFF1D4")
    public boolean isTactileFeedbackEnabled() {
        boolean varD884828399537CA716B6616C31043C18_411224713 = (getBoolean(Settings.Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613880944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_613880944;
        // ---------- Original Method ----------
        //return getBoolean(Settings.Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.661 -0400", hash_original_method = "BBA19F99453E3E410D4FBBB88E551A2F", hash_generated_method = "364D5A3EE221A0BE04BBE4520FFDDB9C")
    public void setTactileFeedbackEnabled(boolean enabled) {
        addTaint(enabled);
setBoolean(Settings.Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED, enabled)
        // ---------- Original Method ----------
        //setBoolean(Settings.Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.661 -0400", hash_original_method = "8AEEFFBE3C04727F80581FF3E6EC3A1C", hash_generated_method = "95F7D01766DF7A56E913D7B71712D3B7")
    public long setLockoutAttemptDeadline() {
        final long deadline = SystemClock.elapsedRealtime() + FAILED_ATTEMPT_TIMEOUT_MS;
setLong(LOCKOUT_ATTEMPT_DEADLINE, deadline)        long var30E482A8AB57CFC19075DECE53B0A56B_1180449850 = (deadline);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1986638375 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1986638375;
        // ---------- Original Method ----------
        //final long deadline = SystemClock.elapsedRealtime() + FAILED_ATTEMPT_TIMEOUT_MS;
        //setLong(LOCKOUT_ATTEMPT_DEADLINE, deadline);
        //return deadline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.662 -0400", hash_original_method = "B24E4BEE244DA38BDF8BD8A5EC4E3396", hash_generated_method = "5FC97B67CECB6EDBE0E3B199497E1113")
    public long getLockoutAttemptDeadline() {
        final long deadline = getLong(LOCKOUT_ATTEMPT_DEADLINE, 0L);
        final long now = SystemClock.elapsedRealtime();
        if(deadline<now||deadline>(now+FAILED_ATTEMPT_TIMEOUT_MS))        
        {
            long var13523495F4BD0DD346A922F207C20B0A_2006760972 = (0L);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1801743501 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1801743501;
        } //End block
        long var30E482A8AB57CFC19075DECE53B0A56B_54665642 = (deadline);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1095096613 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1095096613;
        // ---------- Original Method ----------
        //final long deadline = getLong(LOCKOUT_ATTEMPT_DEADLINE, 0L);
        //final long now = SystemClock.elapsedRealtime();
        //if (deadline < now || deadline > (now + FAILED_ATTEMPT_TIMEOUT_MS)) {
            //return 0L;
        //}
        //return deadline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.662 -0400", hash_original_method = "A02DF5BE5A506A45D1E287E9668EC400", hash_generated_method = "8F73DCCD8A9FF0292456839CC0B53114")
    public boolean isPermanentlyLocked() {
        boolean varE15E23835C635882EBC1A654DB6EDBBD_120966315 = (getBoolean(LOCKOUT_PERMANENT_KEY));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42971562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42971562;
        // ---------- Original Method ----------
        //return getBoolean(LOCKOUT_PERMANENT_KEY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.663 -0400", hash_original_method = "DD551FC2550CC7FA4860602E5FF4DF43", hash_generated_method = "12E3D852D93DB518966BB1422CEB7EC0")
    public void setPermanentlyLocked(boolean locked) {
        addTaint(locked);
setBoolean(LOCKOUT_PERMANENT_KEY, locked)
        // ---------- Original Method ----------
        //setBoolean(LOCKOUT_PERMANENT_KEY, locked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.663 -0400", hash_original_method = "371877250A17DAE0ACD9EB8105D01BAB", hash_generated_method = "11BF834643D777EBB3EDEE6FA3315751")
    public boolean isEmergencyCallCapable() {
        boolean varEADFE9E6CC365B06965184B9883196FD_131704092 = (mContext.getResources().getBoolean(com.android.internal.R.bool.config_voice_capable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853566141 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853566141;
        // ---------- Original Method ----------
        //return mContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_voice_capable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.663 -0400", hash_original_method = "04E9417A907802D4CE660FC5A31891DA", hash_generated_method = "8E2B0A6895D02D06254BF226CEFFEDCE")
    public boolean isPukUnlockScreenEnable() {
        boolean var5F3D9EE2900A0614EE4353EF4E5DCF88_1061565773 = (mContext.getResources().getBoolean(com.android.internal.R.bool.config_enable_puk_unlock_screen));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906421854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906421854;
        // ---------- Original Method ----------
        //return mContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_enable_puk_unlock_screen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.664 -0400", hash_original_method = "8CDABD97F365FED8D554D7193A947974", hash_generated_method = "63D5FB13DFD0D05E838855226046C92C")
    public boolean isEmergencyCallEnabledWhileSimLocked() {
        boolean var8AB2D4579B2E82BD08D5BCFFCB56DBEC_2117621792 = (mContext.getResources().getBoolean(com.android.internal.R.bool.config_enable_emergency_call_while_sim_locked));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589678419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589678419;
        // ---------- Original Method ----------
        //return mContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_enable_emergency_call_while_sim_locked);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.664 -0400", hash_original_method = "BE2697BCC8B716CA9E0ED37CF394EBA9", hash_generated_method = "87297F81F6FF6DC242A6B8A80CCFF3E1")
    public String getNextAlarm() {
        String nextAlarm = Settings.System.getString(mContentResolver,
                Settings.System.NEXT_ALARM_FORMATTED);
        if(nextAlarm==null||TextUtils.isEmpty(nextAlarm))        
        {
String var540C13E9E156B687226421B24F2DF178_1736797064 = null            var540C13E9E156B687226421B24F2DF178_1736797064.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1736797064;
        } //End block
String var8A9A7366900F181FAD5A6AE281B889BA_2100270796 = nextAlarm        var8A9A7366900F181FAD5A6AE281B889BA_2100270796.addTaint(taint);
        return var8A9A7366900F181FAD5A6AE281B889BA_2100270796;
        // ---------- Original Method ----------
        //String nextAlarm = Settings.System.getString(mContentResolver,
                //Settings.System.NEXT_ALARM_FORMATTED);
        //if (nextAlarm == null || TextUtils.isEmpty(nextAlarm)) {
            //return null;
        //}
        //return nextAlarm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.665 -0400", hash_original_method = "F5CA165E20C9180CA87F6C469F96B4FE", hash_generated_method = "27413ADFA750FA151952500BF603F106")
    private boolean getBoolean(String secureSettingKey) {
        addTaint(secureSettingKey.getTaint());
        boolean var754E8846FBF917AC6C8C12C094CEAFE6_1607395186 = (1==android.provider.Settings.Secure.getInt(mContentResolver, secureSettingKey, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666239922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666239922;
        // ---------- Original Method ----------
        //return 1 ==
                //android.provider.Settings.Secure.getInt(mContentResolver, secureSettingKey, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.665 -0400", hash_original_method = "F697610B08404ED28695F01CEEFD8801", hash_generated_method = "859A56FBAF7055D15736F48D83A881F1")
    private void setBoolean(String secureSettingKey, boolean enabled) {
        addTaint(enabled);
        addTaint(secureSettingKey.getTaint());
android.provider.Settings.Secure.putInt(mContentResolver, secureSettingKey, enabled?1:1)
        // ---------- Original Method ----------
        //android.provider.Settings.Secure.putInt(mContentResolver, secureSettingKey,
                                                //enabled ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.666 -0400", hash_original_method = "A486CEBB01B0C34F1252EDA9374F0CD3", hash_generated_method = "2F40D6186CA0743B7099ED3EBF9ED22A")
    private long getLong(String secureSettingKey, long def) {
        addTaint(def);
        addTaint(secureSettingKey.getTaint());
        long varEDB6077348993C6863E961AE672BFC59_2040134609 = (android.provider.Settings.Secure.getLong(mContentResolver, secureSettingKey, def));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1009959963 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1009959963;
        // ---------- Original Method ----------
        //return android.provider.Settings.Secure.getLong(mContentResolver, secureSettingKey, def);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.666 -0400", hash_original_method = "EEE4C0EFA10CC05215FFFB5055996EB2", hash_generated_method = "7B50963EF7BBFD1C52D74E23CCCD32AA")
    private void setLong(String secureSettingKey, long value) {
        addTaint(value);
        addTaint(secureSettingKey.getTaint());
android.provider.Settings.Secure.putLong(mContentResolver, secureSettingKey, value)
        // ---------- Original Method ----------
        //android.provider.Settings.Secure.putLong(mContentResolver, secureSettingKey, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.667 -0400", hash_original_method = "5ED3B0C8FCD871F95DF16D57118ECE0E", hash_generated_method = "7FE06B1BCCF287D4396443A159A05819")
    private String getString(String secureSettingKey) {
        addTaint(secureSettingKey.getTaint());
String var9878F8C17FF747ADA680FBCE07E691E8_1861918053 = android.provider.Settings.Secure.getString(mContentResolver, secureSettingKey)        var9878F8C17FF747ADA680FBCE07E691E8_1861918053.addTaint(taint);
        return var9878F8C17FF747ADA680FBCE07E691E8_1861918053;
        // ---------- Original Method ----------
        //return android.provider.Settings.Secure.getString(mContentResolver, secureSettingKey);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.667 -0400", hash_original_method = "5DD4F4F842A08E836CC3DB2138FAA4FC", hash_generated_method = "FA4F14C10747CA9B6E057ABCD4E8017B")
    private void setString(String secureSettingKey, String value) {
        addTaint(value.getTaint());
        addTaint(secureSettingKey.getTaint());
android.provider.Settings.Secure.putString(mContentResolver, secureSettingKey, value)
        // ---------- Original Method ----------
        //android.provider.Settings.Secure.putString(mContentResolver, secureSettingKey, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.667 -0400", hash_original_method = "DDF96D6E8E195BC43C2128555A2A6A7B", hash_generated_method = "9954CC1EA03A5347BFB4ECE0836C18FF")
    public boolean isSecure() {
        long mode = getKeyguardStoredPasswordQuality();
        final boolean isPattern = mode == DevicePolicyManager.PASSWORD_QUALITY_SOMETHING;
        final boolean isPassword = mode == DevicePolicyManager.PASSWORD_QUALITY_NUMERIC
                || mode == DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC
                || mode == DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC
                || mode == DevicePolicyManager.PASSWORD_QUALITY_COMPLEX;
        final boolean secure = isPattern && isLockPatternEnabled() && savedPatternExists()
                || isPassword && savedPasswordExists();
        boolean var1C0B76FCE779F78F51BE339C49445C49_1749506373 = (secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779663916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779663916;
        // ---------- Original Method ----------
        //long mode = getKeyguardStoredPasswordQuality();
        //final boolean isPattern = mode == DevicePolicyManager.PASSWORD_QUALITY_SOMETHING;
        //final boolean isPassword = mode == DevicePolicyManager.PASSWORD_QUALITY_NUMERIC
                //|| mode == DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC
                //|| mode == DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC
                //|| mode == DevicePolicyManager.PASSWORD_QUALITY_COMPLEX;
        //final boolean secure = isPattern && isLockPatternEnabled() && savedPatternExists()
                //|| isPassword && savedPasswordExists();
        //return secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.668 -0400", hash_original_method = "F72A669A593CED0F30581A74C3BB603B", hash_generated_method = "07A0A3DF5112CCD0123303BBFD09C739")
    public void updateEmergencyCallButtonState(Button button, int  phoneState, boolean shown) {
        addTaint(shown);
        addTaint(phoneState);
        addTaint(button.getTaint());
        if(isEmergencyCallCapable()&&shown)        
        {
button.setVisibility(View.VISIBLE)
        } //End block
        else
        {
button.setVisibility(View.GONE)            return;
        } //End block
        int textId;
        if(phoneState==TelephonyManager.CALL_STATE_OFFHOOK)        
        {
textId=R.string.lockscreen_return_to_call            int phoneCallIcon = R.drawable.stat_sys_phone_call;
button.setCompoundDrawablesWithIntrinsicBounds(phoneCallIcon, 0, 0, 0)
        } //End block
        else
        {
textId=R.string.lockscreen_emergency_call            int emergencyIcon = R.drawable.ic_emergency;
button.setCompoundDrawablesWithIntrinsicBounds(emergencyIcon, 0, 0, 0)
        } //End block
button.setText(textId)
        // ---------- Original Method ----------
        //if (isEmergencyCallCapable() && shown) {
            //button.setVisibility(View.VISIBLE);
        //} else {
            //button.setVisibility(View.GONE);
            //return;
        //}
        //int textId;
        //if (phoneState == TelephonyManager.CALL_STATE_OFFHOOK) {
            //textId = R.string.lockscreen_return_to_call;
            //int phoneCallIcon = R.drawable.stat_sys_phone_call;
            //button.setCompoundDrawablesWithIntrinsicBounds(phoneCallIcon, 0, 0, 0);
        //} else {
            //textId = R.string.lockscreen_emergency_call;
            //int emergencyIcon = R.drawable.ic_emergency;
            //button.setCompoundDrawablesWithIntrinsicBounds(emergencyIcon, 0, 0, 0);
        //}
        //button.setText(textId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.668 -0400", hash_original_method = "0FF45837F3321E38753D9E227318757B", hash_generated_method = "A324C3B00E710FC47FEA29352A58F6CB")
    public boolean resumeCall() {
        ITelephony phone = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        try 
        {
            if(phone!=null&&phone.showCallScreen())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_396927452 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281077775 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281077775;
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1466205382 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839884708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839884708;
        // ---------- Original Method ----------
        //ITelephony phone = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        //try {
            //if (phone != null && phone.showCallScreen()) {
                //return true;
            //}
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.669 -0400", hash_original_method = "605D687E4C322BCDEFA0BA9DCCAA4F3A", hash_generated_method = "CCBC232EA3E7BFEB6EC068FDF3896E4F")
    private void finishBiometricWeak() {
setBoolean(BIOMETRIC_WEAK_EVER_CHOSEN_KEY, true)        Intent intent = new Intent();
intent.setClassName("com.android.facelock", "com.android.facelock.SetupEndScreen")mContext.startActivity(intent)
        // ---------- Original Method ----------
        //setBoolean(BIOMETRIC_WEAK_EVER_CHOSEN_KEY, true);
        //Intent intent = new Intent();
        //intent.setClassName("com.android.facelock",
                //"com.android.facelock.SetupEndScreen");
        //mContext.startActivity(intent);
    }

    
    private static class PasswordFileObserver extends FileObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.669 -0400", hash_original_method = "BE70D317CF9ED679778D1B79BD9B8E46", hash_generated_method = "D0ACA6F91C2E75B770459530EE34C7B6")
        public  PasswordFileObserver(String path, int mask) {
            super(path, mask);
            addTaint(mask);
            addTaint(path.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.670 -0400", hash_original_method = "BB86CC28F37A903CCC6B6CE26B919801", hash_generated_method = "87DAC4B42FECB888C32D15703C265821")
        @Override
        public void onEvent(int event, String path) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(path.getTaint());
            addTaint(event);
            if(LOCK_PATTERN_FILE.equals(path))            
            {
Log.d(TAG, "lock pattern file changed")sHaveNonZeroPatternFile.set(new File(sLockPatternFilename).length()>0)
            } //End block
            else
            if(LOCK_PASSWORD_FILE.equals(path))            
            {
Log.d(TAG, "lock password file changed")sHaveNonZeroPasswordFile.set(new File(sLockPasswordFilename).length()>0)
            } //End block
            // ---------- Original Method ----------
            //if (LOCK_PATTERN_FILE.equals(path)) {
                //Log.d(TAG, "lock pattern file changed");
                //sHaveNonZeroPatternFile.set(new File(sLockPatternFilename).length() > 0);
            //} else if (LOCK_PASSWORD_FILE.equals(path)) {
                //Log.d(TAG, "lock password file changed");
                //sHaveNonZeroPasswordFile.set(new File(sLockPasswordFilename).length() > 0);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.670 -0400", hash_original_field = "D869CCC65E6DED7CBC0E1575070B50A9", hash_generated_field = "10F6C15D9493BF814AF6D0CC10037508")

    private static final String OPTION_ENABLE_FACELOCK = "enable_facelock";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.670 -0400", hash_original_field = "0050AAB8669D5BA316FF189325F404F5", hash_generated_field = "126C5858D00301138EA9C7CFC9643248")

    private static final String TAG = "LockPatternUtils";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.670 -0400", hash_original_field = "04D61A3CF275A3CE7BACE41684E16E1A", hash_generated_field = "CE81D9B8F33E93C8372564035A4C3434")

    private static final String SYSTEM_DIRECTORY = "/system/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.671 -0400", hash_original_field = "981A92F570500DA4470D92D2518AFF5F", hash_generated_field = "0105CF9913F9C67057CA422A777847A0")

    private static final String LOCK_PATTERN_FILE = "gesture.key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.671 -0400", hash_original_field = "19CA373958F88354405863CD434BF8C0", hash_generated_field = "F9B7F11AABC715076CDA5D1998C49748")

    private static final String LOCK_PASSWORD_FILE = "password.key";

