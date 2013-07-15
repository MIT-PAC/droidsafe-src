package com.android.internal.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import java.util.HashSet;

public abstract class PackageMonitor extends android.content.BroadcastReceiver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.549 -0400", hash_original_field = "B09C448CB58F076C1DFDB1CB05D17B0F", hash_generated_field = "3EFEE6E30F796A9234094824403FC953")

    final HashSet<String> mUpdatingPackages = new HashSet<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.549 -0400", hash_original_field = "96F776CB2425CF2151700EBD6F59DD96", hash_generated_field = "B1FD6A03CA5DD472B118BDCF0E45CD8B")

    Context mRegisteredContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_field = "7CF62E51F014B8ED2623551D7B093816", hash_generated_field = "B67CEBC1AF1D5EACC126D5234F158FB7")

    String[] mDisappearingPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_field = "13B241196AAA8A067420A0EF5E59E8C0", hash_generated_field = "21E477742D97A7915E72E243DDD41277")

    String[] mAppearingPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_field = "C93E85DD1086A81F6514D0A92B726D6A", hash_generated_field = "88C89D953D7E71C399160532B6A13FB5")

    String[] mModifiedPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_field = "D88B5B0B76618E5C3152D4A18CBED4B2", hash_generated_field = "C19D1DDBEE9BCF07700D01399B1C0E55")

    int mChangeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_field = "E80D2081992A1973A838D39262ECFFF4", hash_generated_field = "4D5ED9C037D8228AD58ABE76C369C35D")

    boolean mSomePackagesChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_field = "C7A99A8EA0DA3E6AC71B259324B1C8CD", hash_generated_field = "2062FD0DE539271A0379A79E22B23E21")

    String[] mTempArray = new String[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.550 -0400", hash_original_method = "F34C1916D9BDCE721C31545D6BFA0910", hash_generated_method = "F34C1916D9BDCE721C31545D6BFA0910")
    public PackageMonitor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.551 -0400", hash_original_method = "683B22F5B66473FA3FFAF05FD8D82D9B", hash_generated_method = "6FC607827A104D8C5AB6CE5C4CF22A3E")
    public void register(Context context, boolean externalStorage) {
        addTaint(externalStorage);
    if(mRegisteredContext != null)        
        {
            IllegalStateException varEE4E2AF3CC61AB70E92D7670CE6AF04C_601717172 = new IllegalStateException("Already registered");
            varEE4E2AF3CC61AB70E92D7670CE6AF04C_601717172.addTaint(taint);
            throw varEE4E2AF3CC61AB70E92D7670CE6AF04C_601717172;
        } //End block
        mRegisteredContext = context;
        context.registerReceiver(this, sPackageFilt);
        context.registerReceiver(this, sNonDataFilt);
    if(externalStorage)        
        {
            context.registerReceiver(this, sExternalFilt);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.552 -0400", hash_original_method = "9518C25377E9F8A7716E17A7EA7A7E2F", hash_generated_method = "227B23B7183039BD58797A080D8ED4D9")
    public void unregister() {
    if(mRegisteredContext == null)        
        {
            IllegalStateException varBE9F7366567D798FEA888775B93D2EA9_32073336 = new IllegalStateException("Not registered");
            varBE9F7366567D798FEA888775B93D2EA9_32073336.addTaint(taint);
            throw varBE9F7366567D798FEA888775B93D2EA9_32073336;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.552 -0400", hash_original_method = "3A1B53F551F3FC9600BD1567B19D5B62", hash_generated_method = "52309C2C3668978895037EF5D2617746")
     boolean isPackageUpdating(String packageName) {
        addTaint(packageName.getTaint());
        synchronized
(mUpdatingPackages)        {
            boolean var0245DDCEE8B38F28563119FFBFAE91DE_1783907372 = (mUpdatingPackages.contains(packageName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128417856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128417856;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mUpdatingPackages) {
            //return mUpdatingPackages.contains(packageName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.552 -0400", hash_original_method = "C94BFF970D5BE6329B9B5E73EF9CE16C", hash_generated_method = "7D32BBC899657F96CB528A1D4FA46DA2")
    public void onBeginPackageChanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.553 -0400", hash_original_method = "39FE58D26F24B4456BFC90B3786DCD61", hash_generated_method = "7ECD4A972FE75068926C4180C3CCDCC4")
    public void onPackageAdded(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.553 -0400", hash_original_method = "0F3AB92CAC2DECB3AF2CEF56E76BE513", hash_generated_method = "F7380700A9CFEA8F839D59BFFDE6F60A")
    public void onPackageRemoved(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.553 -0400", hash_original_method = "70B1555D02BCE21F5F249AB3232813C5", hash_generated_method = "57DB3EAD7B6EB42F6618322145309AC4")
    public void onPackageUpdateStarted(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.554 -0400", hash_original_method = "C1124FA7C0A54DF3B3E313F6E0508E79", hash_generated_method = "D17E4730CF6954AA817A1635CEAD1923")
    public void onPackageUpdateFinished(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.554 -0400", hash_original_method = "030682B94A5C17B98C68812D78EDA104", hash_generated_method = "036871A49A46FCFF9A0BED458FDB1D83")
    public void onPackageChanged(String packageName, int uid, String[] components) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(components[0].getTaint());
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.554 -0400", hash_original_method = "EBFD761C242ABE2AA3537B2F7610A65A", hash_generated_method = "CF4E89F501A862AF8C694FF98BE7C0A9")
    public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(doit);
        addTaint(uid);
        addTaint(packages[0].getTaint());
        addTaint(intent.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_552285166 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681793244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681793244;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.555 -0400", hash_original_method = "D388436436DCC67D6B4275E67E6BEBD2", hash_generated_method = "84A0A7F7B06BF4C473C3A66F3411B8F7")
    public void onUidRemoved(int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.555 -0400", hash_original_method = "D0F5545F1CBA52AD5FDF8554424C6F7F", hash_generated_method = "89A934AA220D3884C367BD1A28FA7388")
    public void onPackagesAvailable(String[] packages) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.555 -0400", hash_original_method = "95C573D28E0FE5F1DA6F2C482B3FAE76", hash_generated_method = "F9811E999DE5495E50FB1FFF6D83955E")
    public void onPackagesUnavailable(String[] packages) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.555 -0400", hash_original_method = "981D6CDBB84DA6444001057EF6BAA725", hash_generated_method = "A6F4FB46A89C98B2783EC7D24DBBA9CA")
    public void onPackageDisappeared(String packageName, int reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.555 -0400", hash_original_method = "12BAED38AA9047ADF8438C1D2386A99B", hash_generated_method = "28B3074F784624F96CCC06436D72D10D")
    public void onPackageAppeared(String packageName, int reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.556 -0400", hash_original_method = "6245D80E856A5A5ACA0034EE7540D8FF", hash_generated_method = "3D568DB3448DF91ECDF0CACCD1B88248")
    public void onPackageModified(String packageName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.556 -0400", hash_original_method = "17B0E80ECA0F203595AB08C03E582A6E", hash_generated_method = "C1ACCCECC2127E1B9A699872CEA2B327")
    public boolean didSomePackagesChange() {
        boolean varE80D2081992A1973A838D39262ECFFF4_772230599 = (mSomePackagesChanged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174425461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174425461;
        // ---------- Original Method ----------
        //return mSomePackagesChanged;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.556 -0400", hash_original_method = "67A9BEE4E526E413ED94D619C7BC0AAE", hash_generated_method = "7B9C02DCD6C13DF0E8174155A7B0B3D1")
    public int isPackageAppearing(String packageName) {
        addTaint(packageName.getTaint());
    if(mAppearingPackages != null)        
        {
for(int i=mAppearingPackages.length-1;i>=0;i--)
            {
    if(packageName.equals(mAppearingPackages[i]))                
                {
                    int varD88B5B0B76618E5C3152D4A18CBED4B2_1069057132 = (mChangeType);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1470244396 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1470244396;
                } //End block
            } //End block
        } //End block
        int varC595B62E75F9E7F21A8E072B8C756EDA_1336562202 = (PACKAGE_UNCHANGED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420819774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420819774;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.557 -0400", hash_original_method = "C232E85354F8FADEB8DAF25E13A8A2B6", hash_generated_method = "B4469FA4EDDBAB9C4117CF293F89E62E")
    public boolean anyPackagesAppearing() {
        boolean var41354D86D539CBF1D2EE3A366A04301D_1180317190 = (mAppearingPackages != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1266185342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1266185342;
        // ---------- Original Method ----------
        //return mAppearingPackages != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.557 -0400", hash_original_method = "FFC1DE947346082A84A8C685D6562A3C", hash_generated_method = "45832A4E54B2D730AB9606654E1AB74A")
    public int isPackageDisappearing(String packageName) {
        addTaint(packageName.getTaint());
    if(mDisappearingPackages != null)        
        {
for(int i=mDisappearingPackages.length-1;i>=0;i--)
            {
    if(packageName.equals(mDisappearingPackages[i]))                
                {
                    int varD88B5B0B76618E5C3152D4A18CBED4B2_393496969 = (mChangeType);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607034082 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607034082;
                } //End block
            } //End block
        } //End block
        int varC595B62E75F9E7F21A8E072B8C756EDA_1464215459 = (PACKAGE_UNCHANGED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254011629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254011629;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.557 -0400", hash_original_method = "732AD1F656A41076D7320338ABFAAB0C", hash_generated_method = "1078835866EEE87AB5012DF632930BDC")
    public boolean anyPackagesDisappearing() {
        boolean var298048D7FF0BE80321649CBD3F3FCDAA_1111236996 = (mDisappearingPackages != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061526218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061526218;
        // ---------- Original Method ----------
        //return mDisappearingPackages != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.558 -0400", hash_original_method = "1770EA26CD96789C8DEBC22C8B3E1D5A", hash_generated_method = "1BFC88098440D4BA3E5647E9D29E011F")
    public boolean isPackageModified(String packageName) {
        addTaint(packageName.getTaint());
    if(mModifiedPackages != null)        
        {
for(int i=mModifiedPackages.length-1;i>=0;i--)
            {
    if(packageName.equals(mModifiedPackages[i]))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_30720684 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980201264 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_980201264;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_510515437 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275271147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275271147;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.558 -0400", hash_original_method = "D5490034D4EF09CAB3BC7334BE26E552", hash_generated_method = "81CC0669B4A9021B8C9A7811BCBA1FD5")
    public void onSomePackagesChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.558 -0400", hash_original_method = "D8E0B204F7DD735407D0D5971428B1D2", hash_generated_method = "A04E6D7AE177AD771BA1E65021AB70B5")
    public void onFinishPackageChanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.558 -0400", hash_original_method = "19E02459BAFEB1E910E6AB68B93B5860", hash_generated_method = "D0ED95611D82DA1946DE561EEA946FA1")
     String getPackageName(Intent intent) {
        addTaint(intent.getTaint());
        Uri uri = intent.getData();
        String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
String varED674789E18B51C56C5496E452A560E9_1673431944 =         pkg;
        varED674789E18B51C56C5496E452A560E9_1673431944.addTaint(taint);
        return varED674789E18B51C56C5496E452A560E9_1673431944;
        // ---------- Original Method ----------
        //Uri uri = intent.getData();
        //String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
        //return pkg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.562 -0400", hash_original_method = "B895BCFF247B459848C20BC8F667143B", hash_generated_method = "BE59E34A05D1E7EE17A0959277EF8A6B")
    @Override
    public void onReceive(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(context.getTaint());
        onBeginPackageChanges();
        mDisappearingPackages = mAppearingPackages = null;
        mSomePackagesChanged = false;
        String action = intent.getAction();
    if(Intent.ACTION_PACKAGE_ADDED.equals(action))        
        {
            String pkg = getPackageName(intent);
            int uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
            mSomePackagesChanged = true;
    if(pkg != null)            
            {
                mAppearingPackages = mTempArray;
                mTempArray[0] = pkg;
    if(intent.getBooleanExtra(Intent.EXTRA_REPLACING, false))                
                {
                    mModifiedPackages = mTempArray;
                    mChangeType = PACKAGE_UPDATING;
                    onPackageUpdateFinished(pkg, uid);
                    onPackageModified(pkg);
                } //End block
                else
                {
                    mChangeType = PACKAGE_PERMANENT_CHANGE;
                    onPackageAdded(pkg, uid);
                } //End block
                onPackageAppeared(pkg, mChangeType);
    if(mChangeType == PACKAGE_UPDATING)                
                {
                    synchronized
(mUpdatingPackages)                    {
                        mUpdatingPackages.remove(pkg);
                    } //End block
                } //End block
            } //End block
        } //End block
        else
    if(Intent.ACTION_PACKAGE_REMOVED.equals(action))        
        {
            String pkg = getPackageName(intent);
            int uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
    if(pkg != null)            
            {
                mDisappearingPackages = mTempArray;
                mTempArray[0] = pkg;
    if(intent.getBooleanExtra(Intent.EXTRA_REPLACING, false))                
                {
                    mChangeType = PACKAGE_UPDATING;
                    synchronized
(mUpdatingPackages)                    {
                    } //End block
                    onPackageUpdateStarted(pkg, uid);
                } //End block
                else
                {
                    mChangeType = PACKAGE_PERMANENT_CHANGE;
                    mSomePackagesChanged = true;
                    onPackageRemoved(pkg, uid);
                } //End block
                onPackageDisappeared(pkg, mChangeType);
            } //End block
        } //End block
        else
    if(Intent.ACTION_PACKAGE_CHANGED.equals(action))        
        {
            String pkg = getPackageName(intent);
            int uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
            String[] components = intent.getStringArrayExtra(
                    Intent.EXTRA_CHANGED_COMPONENT_NAME_LIST);
    if(pkg != null)            
            {
                mModifiedPackages = mTempArray;
                mTempArray[0] = pkg;
                onPackageChanged(pkg, uid, components);
                onPackageModified(pkg);
            } //End block
        } //End block
        else
    if(Intent.ACTION_QUERY_PACKAGE_RESTART.equals(action))        
        {
            mDisappearingPackages = intent.getStringArrayExtra(Intent.EXTRA_PACKAGES);
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            boolean canRestart = onHandleForceStop(intent,
                    mDisappearingPackages,
                    intent.getIntExtra(Intent.EXTRA_UID, 0), false);
    if(canRestart)            
            setResultCode(Activity.RESULT_OK);
        } //End block
        else
    if(Intent.ACTION_PACKAGE_RESTARTED.equals(action))        
        {
            mDisappearingPackages = new String[] {getPackageName(intent)};
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            onHandleForceStop(intent, mDisappearingPackages,
                    intent.getIntExtra(Intent.EXTRA_UID, 0), true);
        } //End block
        else
    if(Intent.ACTION_UID_REMOVED.equals(action))        
        {
            onUidRemoved(intent.getIntExtra(Intent.EXTRA_UID, 0));
        } //End block
        else
    if(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action))        
        {
            String[] pkgList = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            mAppearingPackages = pkgList;
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            mSomePackagesChanged = true;
    if(pkgList != null)            
            {
                onPackagesAvailable(pkgList);
for(int i=0;i<pkgList.length;i++)
                {
                    onPackageAppeared(pkgList[i], PACKAGE_TEMPORARY_CHANGE);
                } //End block
            } //End block
        } //End block
        else
    if(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action))        
        {
            String[] pkgList = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            mDisappearingPackages = pkgList;
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            mSomePackagesChanged = true;
    if(pkgList != null)            
            {
                onPackagesUnavailable(pkgList);
for(int i=0;i<pkgList.length;i++)
                {
                    onPackageDisappeared(pkgList[i], PACKAGE_TEMPORARY_CHANGE);
                } //End block
            } //End block
        } //End block
    if(mSomePackagesChanged)        
        {
            onSomePackagesChanged();
        } //End block
        onFinishPackageChanges();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.563 -0400", hash_original_field = "ADD687010810F378AC1172262214F72B", hash_generated_field = "56A19F93A3F7255DA0A5F6B04E15448B")

    static final IntentFilter sPackageFilt = new IntentFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.563 -0400", hash_original_field = "7BFEDAAA7769D5E2B9820798BC4671A6", hash_generated_field = "F83F98EDC0D60A397BA8B3F999BC338C")

    static final IntentFilter sNonDataFilt = new IntentFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.563 -0400", hash_original_field = "79CC67D7B228B7485B505FF576042DB6", hash_generated_field = "4EE8A796BAE0F230C425C58D258C864E")

    static final IntentFilter sExternalFilt = new IntentFilter();
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.563 -0400", hash_original_field = "0A2A1D7AE35F2478E185C5CBAE3E74E3", hash_generated_field = "8232CD067D5F85E52993832A4B17BC33")

    public static final int PACKAGE_UNCHANGED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.563 -0400", hash_original_field = "AD80D82CE1FF27E6FA135FB972B8D1D8", hash_generated_field = "88CE097186BDA0F0E034E77CD2A1A59F")

    public static final int PACKAGE_UPDATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.564 -0400", hash_original_field = "4FB4EF0F3E3BB49087BD6AC6CFA97028", hash_generated_field = "FCC47572D8C8CADDCCAAF03ABBD81FDE")

    public static final int PACKAGE_TEMPORARY_CHANGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.564 -0400", hash_original_field = "812D3F2E689D83894895868AFE56BA85", hash_generated_field = "B0ACEEAA3E4BD42CD194F3CE24202F4E")

    public static final int PACKAGE_PERMANENT_CHANGE = 3;
}

