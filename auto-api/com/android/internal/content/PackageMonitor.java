package com.android.internal.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import java.util.HashSet;

public abstract class PackageMonitor extends android.content.BroadcastReceiver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.810 -0400", hash_original_field = "B09C448CB58F076C1DFDB1CB05D17B0F", hash_generated_field = "327872E9D71A4FBB076B68AEC4DC350D")

    HashSet<String> mUpdatingPackages = new HashSet<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "96F776CB2425CF2151700EBD6F59DD96", hash_generated_field = "B1FD6A03CA5DD472B118BDCF0E45CD8B")

    Context mRegisteredContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "7CF62E51F014B8ED2623551D7B093816", hash_generated_field = "B67CEBC1AF1D5EACC126D5234F158FB7")

    String[] mDisappearingPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "13B241196AAA8A067420A0EF5E59E8C0", hash_generated_field = "21E477742D97A7915E72E243DDD41277")

    String[] mAppearingPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "C93E85DD1086A81F6514D0A92B726D6A", hash_generated_field = "88C89D953D7E71C399160532B6A13FB5")

    String[] mModifiedPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "D88B5B0B76618E5C3152D4A18CBED4B2", hash_generated_field = "C19D1DDBEE9BCF07700D01399B1C0E55")

    int mChangeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "E80D2081992A1973A838D39262ECFFF4", hash_generated_field = "4D5ED9C037D8228AD58ABE76C369C35D")

    boolean mSomePackagesChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_field = "C7A99A8EA0DA3E6AC71B259324B1C8CD", hash_generated_field = "2062FD0DE539271A0379A79E22B23E21")

    String[] mTempArray = new String[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.811 -0400", hash_original_method = "F34C1916D9BDCE721C31545D6BFA0910", hash_generated_method = "F34C1916D9BDCE721C31545D6BFA0910")
    public PackageMonitor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.819 -0400", hash_original_method = "683B22F5B66473FA3FFAF05FD8D82D9B", hash_generated_method = "0EEF2B74AAED9962A089B8BB342FE11F")
    public void register(Context context, boolean externalStorage) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already registered");
        } //End block
        mRegisteredContext = context;
        context.registerReceiver(this, sPackageFilt);
        context.registerReceiver(this, sNonDataFilt);
        {
            context.registerReceiver(this, sExternalFilt);
        } //End block
        addTaint(externalStorage);
        // ---------- Original Method ----------
        //if (mRegisteredContext != null) {
            //throw new IllegalStateException("Already registered");
        //}
        //mRegisteredContext = context;
        //context.registerReceiver(this, sPackageFilt);
        //context.registerReceiver(this, sNonDataFilt);
        //if (externalStorage) {
            //context.registerReceiver(this, sExternalFilt);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.820 -0400", hash_original_method = "9518C25377E9F8A7716E17A7EA7A7E2F", hash_generated_method = "5F39F2AEC27195A60D9FF97380CA83FB")
    public void unregister() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Not registered");
        } //End block
        mRegisteredContext.unregisterReceiver(this);
        mRegisteredContext = null;
        // ---------- Original Method ----------
        //if (mRegisteredContext == null) {
            //throw new IllegalStateException("Not registered");
        //}
        //mRegisteredContext.unregisterReceiver(this);
        //mRegisteredContext = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.820 -0400", hash_original_method = "3A1B53F551F3FC9600BD1567B19D5B62", hash_generated_method = "20511128A2C3CDFA02EE93E904170E8F")
     boolean isPackageUpdating(String packageName) {
        {
            boolean var1C6EEE82839E4B40DD9D3814D4CD898D_505525747 = (mUpdatingPackages.contains(packageName));
        } //End block
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729533881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729533881;
        // ---------- Original Method ----------
        //synchronized (mUpdatingPackages) {
            //return mUpdatingPackages.contains(packageName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.821 -0400", hash_original_method = "C94BFF970D5BE6329B9B5E73EF9CE16C", hash_generated_method = "7D32BBC899657F96CB528A1D4FA46DA2")
    public void onBeginPackageChanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.822 -0400", hash_original_method = "39FE58D26F24B4456BFC90B3786DCD61", hash_generated_method = "89E81C6729E29ED21D65892232C174F7")
    public void onPackageAdded(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.822 -0400", hash_original_method = "0F3AB92CAC2DECB3AF2CEF56E76BE513", hash_generated_method = "EC7EEAB856BF7E5B806B904A9D198D4E")
    public void onPackageRemoved(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.822 -0400", hash_original_method = "70B1555D02BCE21F5F249AB3232813C5", hash_generated_method = "3081F49472F6EB4752CE9AFBF0867DC6")
    public void onPackageUpdateStarted(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.822 -0400", hash_original_method = "C1124FA7C0A54DF3B3E313F6E0508E79", hash_generated_method = "0D6786336F49DB1118663729EBEEED06")
    public void onPackageUpdateFinished(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.823 -0400", hash_original_method = "030682B94A5C17B98C68812D78EDA104", hash_generated_method = "859CCC8705BA7356F09B56CF06ED17F7")
    public void onPackageChanged(String packageName, int uid, String[] components) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(uid);
        addTaint(components[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.823 -0400", hash_original_method = "EBFD761C242ABE2AA3537B2F7610A65A", hash_generated_method = "40DA90E14D3A8B4678275F119B5C99B9")
    public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(packages[0].getTaint());
        addTaint(uid);
        addTaint(doit);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468762601 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468762601;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.823 -0400", hash_original_method = "D388436436DCC67D6B4275E67E6BEBD2", hash_generated_method = "84A0A7F7B06BF4C473C3A66F3411B8F7")
    public void onUidRemoved(int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.824 -0400", hash_original_method = "D0F5545F1CBA52AD5FDF8554424C6F7F", hash_generated_method = "89A934AA220D3884C367BD1A28FA7388")
    public void onPackagesAvailable(String[] packages) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.824 -0400", hash_original_method = "95C573D28E0FE5F1DA6F2C482B3FAE76", hash_generated_method = "F9811E999DE5495E50FB1FFF6D83955E")
    public void onPackagesUnavailable(String[] packages) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.824 -0400", hash_original_method = "981D6CDBB84DA6444001057EF6BAA725", hash_generated_method = "08DDE20E43C9004875543CD37A539552")
    public void onPackageDisappeared(String packageName, int reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.838 -0400", hash_original_method = "12BAED38AA9047ADF8438C1D2386A99B", hash_generated_method = "315FBFFF58D513B709DEB43F973A7AEC")
    public void onPackageAppeared(String packageName, int reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.839 -0400", hash_original_method = "6245D80E856A5A5ACA0034EE7540D8FF", hash_generated_method = "3D568DB3448DF91ECDF0CACCD1B88248")
    public void onPackageModified(String packageName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.839 -0400", hash_original_method = "17B0E80ECA0F203595AB08C03E582A6E", hash_generated_method = "AAEFB55985FEC39451BB179AA7661164")
    public boolean didSomePackagesChange() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001142271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001142271;
        // ---------- Original Method ----------
        //return mSomePackagesChanged;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.843 -0400", hash_original_method = "67A9BEE4E526E413ED94D619C7BC0AAE", hash_generated_method = "87D38A71176370423ECD3359C2E1C96A")
    public int isPackageAppearing(String packageName) {
        {
            {
                int i;
                i = mAppearingPackages.length-1;
                {
                    {
                        boolean var73CECB124A21C13384E11AE38774A9C2_1649957758 = (packageName.equals(mAppearingPackages[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676268365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676268365;
        // ---------- Original Method ----------
        //if (mAppearingPackages != null) {
            //for (int i=mAppearingPackages.length-1; i>=0; i--) {
                //if (packageName.equals(mAppearingPackages[i])) {
                    //return mChangeType;
                //}
            //}
        //}
        //return PACKAGE_UNCHANGED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.843 -0400", hash_original_method = "C232E85354F8FADEB8DAF25E13A8A2B6", hash_generated_method = "62B9655D0B407EA5C30F8C98F2F5FC8B")
    public boolean anyPackagesAppearing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765313404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765313404;
        // ---------- Original Method ----------
        //return mAppearingPackages != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.846 -0400", hash_original_method = "FFC1DE947346082A84A8C685D6562A3C", hash_generated_method = "14BFBCEB16B374CF4EC9590A9E2629CE")
    public int isPackageDisappearing(String packageName) {
        {
            {
                int i;
                i = mDisappearingPackages.length-1;
                {
                    {
                        boolean var98C28E4581365DDDA64CCA70AD94D1CF_853523112 = (packageName.equals(mDisappearingPackages[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041359702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041359702;
        // ---------- Original Method ----------
        //if (mDisappearingPackages != null) {
            //for (int i=mDisappearingPackages.length-1; i>=0; i--) {
                //if (packageName.equals(mDisappearingPackages[i])) {
                    //return mChangeType;
                //}
            //}
        //}
        //return PACKAGE_UNCHANGED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.847 -0400", hash_original_method = "732AD1F656A41076D7320338ABFAAB0C", hash_generated_method = "3764F0F72B2F0D5ED7F0DC48997A6B66")
    public boolean anyPackagesDisappearing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726835036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726835036;
        // ---------- Original Method ----------
        //return mDisappearingPackages != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.847 -0400", hash_original_method = "1770EA26CD96789C8DEBC22C8B3E1D5A", hash_generated_method = "BD0D65C14F5B777400FA5A749EE2C832")
    public boolean isPackageModified(String packageName) {
        {
            {
                int i;
                i = mModifiedPackages.length-1;
                {
                    {
                        boolean varD7563A7BA33AD647E680AB77A2BB353A_308583579 = (packageName.equals(mModifiedPackages[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108536399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_108536399;
        // ---------- Original Method ----------
        //if (mModifiedPackages != null) {
            //for (int i=mModifiedPackages.length-1; i>=0; i--) {
                //if (packageName.equals(mModifiedPackages[i])) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.848 -0400", hash_original_method = "D5490034D4EF09CAB3BC7334BE26E552", hash_generated_method = "81CC0669B4A9021B8C9A7811BCBA1FD5")
    public void onSomePackagesChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.848 -0400", hash_original_method = "D8E0B204F7DD735407D0D5971428B1D2", hash_generated_method = "A04E6D7AE177AD771BA1E65021AB70B5")
    public void onFinishPackageChanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.851 -0400", hash_original_method = "19E02459BAFEB1E910E6AB68B93B5860", hash_generated_method = "6D1DE1395A7F69A32062141C36216E8C")
     String getPackageName(Intent intent) {
        String varB4EAC82CA7396A68D541C85D26508E83_725420366 = null; //Variable for return #1
        Uri uri;
        uri = intent.getData();
        String pkg;
        pkg = uri.getSchemeSpecificPart();
        pkg = null;
        varB4EAC82CA7396A68D541C85D26508E83_725420366 = pkg;
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_725420366.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725420366;
        // ---------- Original Method ----------
        //Uri uri = intent.getData();
        //String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
        //return pkg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_method = "B895BCFF247B459848C20BC8F667143B", hash_generated_method = "269FF889B949615D3AD5D3B1C0B59D05")
    @Override
    public void onReceive(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onBeginPackageChanges();
        mDisappearingPackages = mAppearingPackages = null;
        mSomePackagesChanged = false;
        String action;
        action = intent.getAction();
        {
            boolean varC758E0B42D3DD3050E20E05A51E62C88_659062825 = (Intent.ACTION_PACKAGE_ADDED.equals(action));
            {
                String pkg;
                pkg = getPackageName(intent);
                int uid;
                uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
                mSomePackagesChanged = true;
                {
                    mAppearingPackages = mTempArray;
                    mTempArray[0] = pkg;
                    {
                        boolean var7BE332234F92C72D5D8E83A7069C054D_169065780 = (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false));
                        {
                            mModifiedPackages = mTempArray;
                            mChangeType = PACKAGE_UPDATING;
                            onPackageUpdateFinished(pkg, uid);
                            onPackageModified(pkg);
                        } //End block
                        {
                            mChangeType = PACKAGE_PERMANENT_CHANGE;
                            onPackageAdded(pkg, uid);
                        } //End block
                    } //End collapsed parenthetic
                    onPackageAppeared(pkg, mChangeType);
                    {
                        {
                            mUpdatingPackages.remove(pkg);
                        } //End block
                    } //End block
                } //End block
            } //End block
            {
                boolean var7FE8F03ED5A57A646466A782EE8A7678_954249567 = (Intent.ACTION_PACKAGE_REMOVED.equals(action));
                {
                    String pkg;
                    pkg = getPackageName(intent);
                    int uid;
                    uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
                    {
                        mDisappearingPackages = mTempArray;
                        mTempArray[0] = pkg;
                        {
                            boolean varD96614F08400F12676EB97B123F098C8_853818151 = (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false));
                            {
                                mChangeType = PACKAGE_UPDATING;
                                onPackageUpdateStarted(pkg, uid);
                            } //End block
                            {
                                mChangeType = PACKAGE_PERMANENT_CHANGE;
                                mSomePackagesChanged = true;
                                onPackageRemoved(pkg, uid);
                            } //End block
                        } //End collapsed parenthetic
                        onPackageDisappeared(pkg, mChangeType);
                    } //End block
                } //End block
                {
                    boolean var4B374F8DCC748CA652C704B98E2EAC26_1503990196 = (Intent.ACTION_PACKAGE_CHANGED.equals(action));
                    {
                        String pkg;
                        pkg = getPackageName(intent);
                        int uid;
                        uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
                        String[] components;
                        components = intent.getStringArrayExtra(
                    Intent.EXTRA_CHANGED_COMPONENT_NAME_LIST);
                        {
                            mModifiedPackages = mTempArray;
                            mTempArray[0] = pkg;
                            onPackageChanged(pkg, uid, components);
                            onPackageModified(pkg);
                        } //End block
                    } //End block
                    {
                        boolean var01CB92245BEA95F00B8BFAF2FC70D5E9_332095392 = (Intent.ACTION_QUERY_PACKAGE_RESTART.equals(action));
                        {
                            mDisappearingPackages = intent.getStringArrayExtra(Intent.EXTRA_PACKAGES);
                            mChangeType = PACKAGE_TEMPORARY_CHANGE;
                            boolean canRestart;
                            canRestart = onHandleForceStop(intent,
                    mDisappearingPackages,
                    intent.getIntExtra(Intent.EXTRA_UID, 0), false);
                            setResultCode(Activity.RESULT_OK);
                        } //End block
                        {
                            boolean varA511A63D55554313B83F88FDB7E57B20_2012189533 = (Intent.ACTION_PACKAGE_RESTARTED.equals(action));
                            {
                                mDisappearingPackages = new String[] {getPackageName(intent)};
                                mChangeType = PACKAGE_TEMPORARY_CHANGE;
                                onHandleForceStop(intent, mDisappearingPackages,
                    intent.getIntExtra(Intent.EXTRA_UID, 0), true);
                            } //End block
                            {
                                boolean var2DADC886119177CD822FB435CFFE1B9C_5333415 = (Intent.ACTION_UID_REMOVED.equals(action));
                                {
                                    onUidRemoved(intent.getIntExtra(Intent.EXTRA_UID, 0));
                                } //End block
                                {
                                    boolean var08DAE7171E67029B9F1AA8F3C515A39B_1592263418 = (Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action));
                                    {
                                        String[] pkgList;
                                        pkgList = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
                                        mAppearingPackages = pkgList;
                                        mChangeType = PACKAGE_TEMPORARY_CHANGE;
                                        mSomePackagesChanged = true;
                                        {
                                            onPackagesAvailable(pkgList);
                                            {
                                                int i;
                                                i = 0;
                                                {
                                                    onPackageAppeared(pkgList[i], PACKAGE_TEMPORARY_CHANGE);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End block
                                    {
                                        boolean var6B70FE5E5601D0C934CE3B9D6EE08A32_1564714519 = (Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action));
                                        {
                                            String[] pkgList;
                                            pkgList = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
                                            mDisappearingPackages = pkgList;
                                            mChangeType = PACKAGE_TEMPORARY_CHANGE;
                                            mSomePackagesChanged = true;
                                            {
                                                onPackagesUnavailable(pkgList);
                                                {
                                                    int i;
                                                    i = 0;
                                                    {
                                                        onPackageDisappeared(pkgList[i], PACKAGE_TEMPORARY_CHANGE);
                                                    } //End block
                                                } //End collapsed parenthetic
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            onSomePackagesChanged();
        } //End block
        onFinishPackageChanges();
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "ADD687010810F378AC1172262214F72B", hash_generated_field = "155D728CB80F4F3E1301C57A675B8FAA")

    static IntentFilter sPackageFilt = new IntentFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "7BFEDAAA7769D5E2B9820798BC4671A6", hash_generated_field = "F5D2889FDA48A2E0C11FDFF0920B197B")

    static IntentFilter sNonDataFilt = new IntentFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "79CC67D7B228B7485B505FF576042DB6", hash_generated_field = "3D1DF2E10807A52B3926AC4FEB63E65F")

    static IntentFilter sExternalFilt = new IntentFilter();
    static {
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_ADDED);
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_REMOVED);
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_CHANGED);
        sPackageFilt.addAction(Intent.ACTION_QUERY_PACKAGE_RESTART);
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_RESTARTED);
        sPackageFilt.addAction(Intent.ACTION_UID_REMOVED);
        sPackageFilt.addDataScheme("package");
        sNonDataFilt.addAction(Intent.ACTION_UID_REMOVED);
        sExternalFilt.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        sExternalFilt.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "0A2A1D7AE35F2478E185C5CBAE3E74E3", hash_generated_field = "8232CD067D5F85E52993832A4B17BC33")

    public static final int PACKAGE_UNCHANGED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "AD80D82CE1FF27E6FA135FB972B8D1D8", hash_generated_field = "88CE097186BDA0F0E034E77CD2A1A59F")

    public static final int PACKAGE_UPDATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "4FB4EF0F3E3BB49087BD6AC6CFA97028", hash_generated_field = "FCC47572D8C8CADDCCAAF03ABBD81FDE")

    public static final int PACKAGE_TEMPORARY_CHANGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:11.859 -0400", hash_original_field = "812D3F2E689D83894895868AFE56BA85", hash_generated_field = "B0ACEEAA3E4BD42CD194F3CE24202F4E")

    public static final int PACKAGE_PERMANENT_CHANGE = 3;
}

