package com.android.internal.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashSet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;





public abstract class PackageMonitor extends android.content.BroadcastReceiver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "B09C448CB58F076C1DFDB1CB05D17B0F", hash_generated_field = "3EFEE6E30F796A9234094824403FC953")

    final HashSet<String> mUpdatingPackages = new HashSet<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "96F776CB2425CF2151700EBD6F59DD96", hash_generated_field = "B1FD6A03CA5DD472B118BDCF0E45CD8B")

    Context mRegisteredContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "7CF62E51F014B8ED2623551D7B093816", hash_generated_field = "B67CEBC1AF1D5EACC126D5234F158FB7")

    String[] mDisappearingPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "13B241196AAA8A067420A0EF5E59E8C0", hash_generated_field = "21E477742D97A7915E72E243DDD41277")

    String[] mAppearingPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "C93E85DD1086A81F6514D0A92B726D6A", hash_generated_field = "88C89D953D7E71C399160532B6A13FB5")

    String[] mModifiedPackages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "D88B5B0B76618E5C3152D4A18CBED4B2", hash_generated_field = "C19D1DDBEE9BCF07700D01399B1C0E55")

    int mChangeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "E80D2081992A1973A838D39262ECFFF4", hash_generated_field = "4D5ED9C037D8228AD58ABE76C369C35D")

    boolean mSomePackagesChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_field = "C7A99A8EA0DA3E6AC71B259324B1C8CD", hash_generated_field = "2062FD0DE539271A0379A79E22B23E21")

    String[] mTempArray = new String[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_method = "F34C1916D9BDCE721C31545D6BFA0910", hash_generated_method = "F34C1916D9BDCE721C31545D6BFA0910")
    public PackageMonitor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.103 -0400", hash_original_method = "683B22F5B66473FA3FFAF05FD8D82D9B", hash_generated_method = "7AD4455115D4880CE24C5F1BB19BDA5E")
    public void register(Context context, boolean externalStorage) {
        addTaint(externalStorage);
        if(mRegisteredContext != null)        
        {
            IllegalStateException varEE4E2AF3CC61AB70E92D7670CE6AF04C_937630056 = new IllegalStateException("Already registered");
            varEE4E2AF3CC61AB70E92D7670CE6AF04C_937630056.addTaint(taint);
            throw varEE4E2AF3CC61AB70E92D7670CE6AF04C_937630056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.103 -0400", hash_original_method = "9518C25377E9F8A7716E17A7EA7A7E2F", hash_generated_method = "9E2F2DF4190AC72609488C65A826A79F")
    public void unregister() {
        if(mRegisteredContext == null)        
        {
            IllegalStateException varBE9F7366567D798FEA888775B93D2EA9_735746199 = new IllegalStateException("Not registered");
            varBE9F7366567D798FEA888775B93D2EA9_735746199.addTaint(taint);
            throw varBE9F7366567D798FEA888775B93D2EA9_735746199;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.104 -0400", hash_original_method = "3A1B53F551F3FC9600BD1567B19D5B62", hash_generated_method = "998CE33CDEAE7C6003ED6882B9224190")
     boolean isPackageUpdating(String packageName) {
        addTaint(packageName.getTaint());
        synchronized
(mUpdatingPackages)        {
            boolean var0245DDCEE8B38F28563119FFBFAE91DE_1651889501 = (mUpdatingPackages.contains(packageName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32289970 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_32289970;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mUpdatingPackages) {
            //return mUpdatingPackages.contains(packageName);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.104 -0400", hash_original_method = "C94BFF970D5BE6329B9B5E73EF9CE16C", hash_generated_method = "7D32BBC899657F96CB528A1D4FA46DA2")
    public void onBeginPackageChanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.104 -0400", hash_original_method = "39FE58D26F24B4456BFC90B3786DCD61", hash_generated_method = "7ECD4A972FE75068926C4180C3CCDCC4")
    public void onPackageAdded(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.105 -0400", hash_original_method = "0F3AB92CAC2DECB3AF2CEF56E76BE513", hash_generated_method = "F7380700A9CFEA8F839D59BFFDE6F60A")
    public void onPackageRemoved(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.105 -0400", hash_original_method = "70B1555D02BCE21F5F249AB3232813C5", hash_generated_method = "57DB3EAD7B6EB42F6618322145309AC4")
    public void onPackageUpdateStarted(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.105 -0400", hash_original_method = "C1124FA7C0A54DF3B3E313F6E0508E79", hash_generated_method = "D17E4730CF6954AA817A1635CEAD1923")
    public void onPackageUpdateFinished(String packageName, int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.105 -0400", hash_original_method = "030682B94A5C17B98C68812D78EDA104", hash_generated_method = "036871A49A46FCFF9A0BED458FDB1D83")
    public void onPackageChanged(String packageName, int uid, String[] components) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(components[0].getTaint());
        addTaint(uid);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.106 -0400", hash_original_method = "EBFD761C242ABE2AA3537B2F7610A65A", hash_generated_method = "5984B152B4B9BD9F7523BDD39E1003FF")
    public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(doit);
        addTaint(uid);
        addTaint(packages[0].getTaint());
        addTaint(intent.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_369055719 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570372746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570372746;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.106 -0400", hash_original_method = "D388436436DCC67D6B4275E67E6BEBD2", hash_generated_method = "84A0A7F7B06BF4C473C3A66F3411B8F7")
    public void onUidRemoved(int uid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(uid);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.107 -0400", hash_original_method = "D0F5545F1CBA52AD5FDF8554424C6F7F", hash_generated_method = "89A934AA220D3884C367BD1A28FA7388")
    public void onPackagesAvailable(String[] packages) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.107 -0400", hash_original_method = "95C573D28E0FE5F1DA6F2C482B3FAE76", hash_generated_method = "F9811E999DE5495E50FB1FFF6D83955E")
    public void onPackagesUnavailable(String[] packages) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.107 -0400", hash_original_method = "981D6CDBB84DA6444001057EF6BAA725", hash_generated_method = "A6F4FB46A89C98B2783EC7D24DBBA9CA")
    public void onPackageDisappeared(String packageName, int reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.108 -0400", hash_original_method = "12BAED38AA9047ADF8438C1D2386A99B", hash_generated_method = "28B3074F784624F96CCC06436D72D10D")
    public void onPackageAppeared(String packageName, int reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason);
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.108 -0400", hash_original_method = "6245D80E856A5A5ACA0034EE7540D8FF", hash_generated_method = "3D568DB3448DF91ECDF0CACCD1B88248")
    public void onPackageModified(String packageName) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.109 -0400", hash_original_method = "17B0E80ECA0F203595AB08C03E582A6E", hash_generated_method = "12CC596DD68E317087CEC3C387664EAE")
    public boolean didSomePackagesChange() {
        boolean varE80D2081992A1973A838D39262ECFFF4_1626692021 = (mSomePackagesChanged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879151911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879151911;
        // ---------- Original Method ----------
        //return mSomePackagesChanged;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.110 -0400", hash_original_method = "67A9BEE4E526E413ED94D619C7BC0AAE", hash_generated_method = "9087010D82AACE0EBA610E69770177F2")
    public int isPackageAppearing(String packageName) {
        addTaint(packageName.getTaint());
        if(mAppearingPackages != null)        
        {
for(int i=mAppearingPackages.length-1;i>=0;i--)
            {
                if(packageName.equals(mAppearingPackages[i]))                
                {
                    int varD88B5B0B76618E5C3152D4A18CBED4B2_1695609855 = (mChangeType);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558311047 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558311047;
                } //End block
            } //End block
        } //End block
        int varC595B62E75F9E7F21A8E072B8C756EDA_2077671563 = (PACKAGE_UNCHANGED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922817345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922817345;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.110 -0400", hash_original_method = "C232E85354F8FADEB8DAF25E13A8A2B6", hash_generated_method = "649E048E5D401F640C0F8B5978DE277E")
    public boolean anyPackagesAppearing() {
        boolean var41354D86D539CBF1D2EE3A366A04301D_253069097 = (mAppearingPackages != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368416763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368416763;
        // ---------- Original Method ----------
        //return mAppearingPackages != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.111 -0400", hash_original_method = "FFC1DE947346082A84A8C685D6562A3C", hash_generated_method = "77A8D43B4A1D45394ACA6F8056A1470F")
    public int isPackageDisappearing(String packageName) {
        addTaint(packageName.getTaint());
        if(mDisappearingPackages != null)        
        {
for(int i=mDisappearingPackages.length-1;i>=0;i--)
            {
                if(packageName.equals(mDisappearingPackages[i]))                
                {
                    int varD88B5B0B76618E5C3152D4A18CBED4B2_936924746 = (mChangeType);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273733213 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273733213;
                } //End block
            } //End block
        } //End block
        int varC595B62E75F9E7F21A8E072B8C756EDA_1610963409 = (PACKAGE_UNCHANGED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960942115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960942115;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.112 -0400", hash_original_method = "732AD1F656A41076D7320338ABFAAB0C", hash_generated_method = "77C85E7847DB2BE842B5CEE00542047E")
    public boolean anyPackagesDisappearing() {
        boolean var298048D7FF0BE80321649CBD3F3FCDAA_2139128502 = (mDisappearingPackages != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104253579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104253579;
        // ---------- Original Method ----------
        //return mDisappearingPackages != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.112 -0400", hash_original_method = "1770EA26CD96789C8DEBC22C8B3E1D5A", hash_generated_method = "BEA33DEB98EF23DE4C77404ACD7AF1D4")
    public boolean isPackageModified(String packageName) {
        addTaint(packageName.getTaint());
        if(mModifiedPackages != null)        
        {
for(int i=mModifiedPackages.length-1;i>=0;i--)
            {
                if(packageName.equals(mModifiedPackages[i]))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_467794085 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600820168 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600820168;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_136201489 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577316653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577316653;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.113 -0400", hash_original_method = "D5490034D4EF09CAB3BC7334BE26E552", hash_generated_method = "81CC0669B4A9021B8C9A7811BCBA1FD5")
    public void onSomePackagesChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.113 -0400", hash_original_method = "D8E0B204F7DD735407D0D5971428B1D2", hash_generated_method = "A04E6D7AE177AD771BA1E65021AB70B5")
    public void onFinishPackageChanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.113 -0400", hash_original_method = "19E02459BAFEB1E910E6AB68B93B5860", hash_generated_method = "A73BE5D8BD50BA3ED44CD13703347F8B")
     String getPackageName(Intent intent) {
        addTaint(intent.getTaint());
        Uri uri = intent.getData();
        String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
String varED674789E18B51C56C5496E452A560E9_1800361121 =         pkg;
        varED674789E18B51C56C5496E452A560E9_1800361121.addTaint(taint);
        return varED674789E18B51C56C5496E452A560E9_1800361121;
        // ---------- Original Method ----------
        //Uri uri = intent.getData();
        //String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
        //return pkg;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.118 -0400", hash_original_method = "B895BCFF247B459848C20BC8F667143B", hash_generated_method = "BE59E34A05D1E7EE17A0959277EF8A6B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "ADD687010810F378AC1172262214F72B", hash_generated_field = "56A19F93A3F7255DA0A5F6B04E15448B")

    static final IntentFilter sPackageFilt = new IntentFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "7BFEDAAA7769D5E2B9820798BC4671A6", hash_generated_field = "F83F98EDC0D60A397BA8B3F999BC338C")

    static final IntentFilter sNonDataFilt = new IntentFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "79CC67D7B228B7485B505FF576042DB6", hash_generated_field = "4EE8A796BAE0F230C425C58D258C864E")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "0A2A1D7AE35F2478E185C5CBAE3E74E3", hash_generated_field = "8232CD067D5F85E52993832A4B17BC33")

    public static final int PACKAGE_UNCHANGED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "AD80D82CE1FF27E6FA135FB972B8D1D8", hash_generated_field = "88CE097186BDA0F0E034E77CD2A1A59F")

    public static final int PACKAGE_UPDATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "4FB4EF0F3E3BB49087BD6AC6CFA97028", hash_generated_field = "FCC47572D8C8CADDCCAAF03ABBD81FDE")

    public static final int PACKAGE_TEMPORARY_CHANGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.120 -0400", hash_original_field = "812D3F2E689D83894895868AFE56BA85", hash_generated_field = "B0ACEEAA3E4BD42CD194F3CE24202F4E")

    public static final int PACKAGE_PERMANENT_CHANGE = 3;
}

