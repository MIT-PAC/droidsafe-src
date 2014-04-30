package com.android.internal.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashSet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;

public abstract class PackageMonitor extends android.content.BroadcastReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.539 -0500", hash_original_field = "23048AC18AB04B887013EC8849A530D3", hash_generated_field = "56A19F93A3F7255DA0A5F6B04E15448B")

    static final IntentFilter sPackageFilt = new IntentFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.542 -0500", hash_original_field = "B51DB84AF9812C591261806B58C38124", hash_generated_field = "F83F98EDC0D60A397BA8B3F999BC338C")

    static final IntentFilter sNonDataFilt = new IntentFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.544 -0500", hash_original_field = "B82EB8E764393303AAC4AEBC8B8721FD", hash_generated_field = "4EE8A796BAE0F230C425C58D258C864E")

    static final IntentFilter sExternalFilt = new IntentFilter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.592 -0500", hash_original_field = "0933F023446D3345869435957C85B5C9", hash_generated_field = "8232CD067D5F85E52993832A4B17BC33")
    
    public static final int PACKAGE_UNCHANGED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.595 -0500", hash_original_field = "13CC11EAB5598B3EF622FDCE4DC660AA", hash_generated_field = "88CE097186BDA0F0E034E77CD2A1A59F")

    public static final int PACKAGE_UPDATING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.598 -0500", hash_original_field = "CBA79CD4D3C4BA619458F5E537053AA8", hash_generated_field = "FCC47572D8C8CADDCCAAF03ABBD81FDE")

    public static final int PACKAGE_TEMPORARY_CHANGE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.600 -0500", hash_original_field = "598409B9F8FFB477419FADB11879A176", hash_generated_field = "B0ACEEAA3E4BD42CD194F3CE24202F4E")

    public static final int PACKAGE_PERMANENT_CHANGE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.546 -0500", hash_original_field = "327872E9D71A4FBB076B68AEC4DC350D", hash_generated_field = "3EFEE6E30F796A9234094824403FC953")
    
    final HashSet<String> mUpdatingPackages = new HashSet<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.548 -0500", hash_original_field = "B1FD6A03CA5DD472B118BDCF0E45CD8B", hash_generated_field = "B1FD6A03CA5DD472B118BDCF0E45CD8B")
    
    Context mRegisteredContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.551 -0500", hash_original_field = "B67CEBC1AF1D5EACC126D5234F158FB7", hash_generated_field = "B67CEBC1AF1D5EACC126D5234F158FB7")

    String[] mDisappearingPackages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.553 -0500", hash_original_field = "21E477742D97A7915E72E243DDD41277", hash_generated_field = "21E477742D97A7915E72E243DDD41277")

    String[] mAppearingPackages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.556 -0500", hash_original_field = "88C89D953D7E71C399160532B6A13FB5", hash_generated_field = "88C89D953D7E71C399160532B6A13FB5")

    String[] mModifiedPackages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.558 -0500", hash_original_field = "C19D1DDBEE9BCF07700D01399B1C0E55", hash_generated_field = "C19D1DDBEE9BCF07700D01399B1C0E55")

    int mChangeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.560 -0500", hash_original_field = "4D5ED9C037D8228AD58ABE76C369C35D", hash_generated_field = "4D5ED9C037D8228AD58ABE76C369C35D")

    boolean mSomePackagesChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.562 -0500", hash_original_field = "2062FD0DE539271A0379A79E22B23E21", hash_generated_field = "2062FD0DE539271A0379A79E22B23E21")
    
    String[] mTempArray = new String[1];
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.102 -0400", hash_original_method = "F34C1916D9BDCE721C31545D6BFA0910", hash_generated_method = "F34C1916D9BDCE721C31545D6BFA0910")
    public PackageMonitor ()
    {
        //Synthesized constructor
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.564 -0500", hash_original_method = "683B22F5B66473FA3FFAF05FD8D82D9B", hash_generated_method = "744D268B07BCA17493FD815DE9A43307")
    
public void register(Context context, boolean externalStorage) {
        if (mRegisteredContext != null) {
            throw new IllegalStateException("Already registered");
        }
        mRegisteredContext = context;
        context.registerReceiver(this, sPackageFilt);
        context.registerReceiver(this, sNonDataFilt);
        if (externalStorage) {
            context.registerReceiver(this, sExternalFilt);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.566 -0500", hash_original_method = "9518C25377E9F8A7716E17A7EA7A7E2F", hash_generated_method = "4674E01DE2C83A29877A6D2E951639CB")
    
public void unregister() {
        if (mRegisteredContext == null) {
            throw new IllegalStateException("Not registered");
        }
        mRegisteredContext.unregisterReceiver(this);
        mRegisteredContext = null;
    }
    
    //not yet implemented
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.568 -0500", hash_original_method = "3A1B53F551F3FC9600BD1567B19D5B62", hash_generated_method = "3A1B53F551F3FC9600BD1567B19D5B62")
    
boolean isPackageUpdating(String packageName) {
        synchronized (mUpdatingPackages) {
            return mUpdatingPackages.contains(packageName);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.570 -0500", hash_original_method = "C94BFF970D5BE6329B9B5E73EF9CE16C", hash_generated_method = "CB2D7D018BA4CF52189F3E73E4FF146B")
    
public void onBeginPackageChanges() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.573 -0500", hash_original_method = "39FE58D26F24B4456BFC90B3786DCD61", hash_generated_method = "CA5135720D5C77F127BFB55926153B0C")
    
public void onPackageAdded(String packageName, int uid) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.575 -0500", hash_original_method = "0F3AB92CAC2DECB3AF2CEF56E76BE513", hash_generated_method = "ECA293D6E4A8915D99765C541D88D706")
    
public void onPackageRemoved(String packageName, int uid) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.577 -0500", hash_original_method = "70B1555D02BCE21F5F249AB3232813C5", hash_generated_method = "308F6F7E5343E35E1E1813D7683C9002")
    
public void onPackageUpdateStarted(String packageName, int uid) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.579 -0500", hash_original_method = "C1124FA7C0A54DF3B3E313F6E0508E79", hash_generated_method = "EBBC42FF5CB14A99B6E14D63BC22D426")
    
public void onPackageUpdateFinished(String packageName, int uid) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.581 -0500", hash_original_method = "030682B94A5C17B98C68812D78EDA104", hash_generated_method = "D6405C60FD97BC15C4AA5467D93738BF")
    
public void onPackageChanged(String packageName, int uid, String[] components) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.583 -0500", hash_original_method = "EBFD761C242ABE2AA3537B2F7610A65A", hash_generated_method = "E5BF8DF53FDB2AD411DE83C3E39717E1")
    
public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
        return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.585 -0500", hash_original_method = "D388436436DCC67D6B4275E67E6BEBD2", hash_generated_method = "E0D2233E2AFB706D00CD9D4A4FA74CE7")
    
public void onUidRemoved(int uid) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.587 -0500", hash_original_method = "D0F5545F1CBA52AD5FDF8554424C6F7F", hash_generated_method = "71F2430256B16924476CF84B1EDD234B")
    
public void onPackagesAvailable(String[] packages) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.589 -0500", hash_original_method = "95C573D28E0FE5F1DA6F2C482B3FAE76", hash_generated_method = "384C3DE97F651CEF638275B187C71BB5")
    
public void onPackagesUnavailable(String[] packages) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.602 -0500", hash_original_method = "981D6CDBB84DA6444001057EF6BAA725", hash_generated_method = "10C7E2E9E7DC84036436D402AD78077E")
    
public void onPackageDisappeared(String packageName, int reason) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.605 -0500", hash_original_method = "12BAED38AA9047ADF8438C1D2386A99B", hash_generated_method = "0151D428780016968A435103069C5EB2")
    
public void onPackageAppeared(String packageName, int reason) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.607 -0500", hash_original_method = "6245D80E856A5A5ACA0034EE7540D8FF", hash_generated_method = "8F8FE4878A22C230481F9E10A26EE20C")
    
public void onPackageModified(String packageName) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.609 -0500", hash_original_method = "17B0E80ECA0F203595AB08C03E582A6E", hash_generated_method = "30DABBCE8D77D60EEAE7CCDD7FCA273C")
    
public boolean didSomePackagesChange() {
        return mSomePackagesChanged;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.611 -0500", hash_original_method = "67A9BEE4E526E413ED94D619C7BC0AAE", hash_generated_method = "E368374B92AF0C66BB46EE7092A682B4")
    
public int isPackageAppearing(String packageName) {
        if (mAppearingPackages != null) {
            for (int i=mAppearingPackages.length-1; i>=0; i--) {
                if (packageName.equals(mAppearingPackages[i])) {
                    return mChangeType;
                }
            }
        }
        return PACKAGE_UNCHANGED;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.613 -0500", hash_original_method = "C232E85354F8FADEB8DAF25E13A8A2B6", hash_generated_method = "C9DB53921A0CD4D5E7BDECD02E4C3EA4")
    
public boolean anyPackagesAppearing() {
        return mAppearingPackages != null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.616 -0500", hash_original_method = "FFC1DE947346082A84A8C685D6562A3C", hash_generated_method = "42D2DC9EB7E7706549D503F49C517141")
    
public int isPackageDisappearing(String packageName) {
        if (mDisappearingPackages != null) {
            for (int i=mDisappearingPackages.length-1; i>=0; i--) {
                if (packageName.equals(mDisappearingPackages[i])) {
                    return mChangeType;
                }
            }
        }
        return PACKAGE_UNCHANGED;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.618 -0500", hash_original_method = "732AD1F656A41076D7320338ABFAAB0C", hash_generated_method = "B65B636846CB688CC89FA10617CA8C8B")
    
public boolean anyPackagesDisappearing() {
        return mDisappearingPackages != null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.620 -0500", hash_original_method = "1770EA26CD96789C8DEBC22C8B3E1D5A", hash_generated_method = "ED0C49AE9DBDB5E1C06F4FE110C2FB84")
    
public boolean isPackageModified(String packageName) {
        if (mModifiedPackages != null) {
            for (int i=mModifiedPackages.length-1; i>=0; i--) {
                if (packageName.equals(mModifiedPackages[i])) {
                    return true;
                }
            }
        }
        return false;
    }
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.622 -0500", hash_original_method = "D5490034D4EF09CAB3BC7334BE26E552", hash_generated_method = "8E851FBDC8DC1515C7B1657771EB0892")
    
public void onSomePackagesChanged() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.624 -0500", hash_original_method = "D8E0B204F7DD735407D0D5971428B1D2", hash_generated_method = "51E1BBEB253836387369215F2F05C65F")
    
public void onFinishPackageChanges() {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.627 -0500", hash_original_method = "19E02459BAFEB1E910E6AB68B93B5860", hash_generated_method = "19E02459BAFEB1E910E6AB68B93B5860")
    
String getPackageName(Intent intent) {
        Uri uri = intent.getData();
        String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
        return pkg;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:55.631 -0500", hash_original_method = "B895BCFF247B459848C20BC8F667143B", hash_generated_method = "6066F150CB1E54BDC7FF24B442D3234B")
    
@Override
    public void onReceive(Context context, Intent intent) {
        onBeginPackageChanges();
        
        mDisappearingPackages = mAppearingPackages = null;
        mSomePackagesChanged = false;
        
        String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            String pkg = getPackageName(intent);
            int uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
            // We consider something to have changed regardless of whether
            // this is just an update, because the update is now finished
            // and the contents of the package may have changed.
            mSomePackagesChanged = true;
            if (pkg != null) {
                mAppearingPackages = mTempArray;
                mTempArray[0] = pkg;
                if (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
                    mModifiedPackages = mTempArray;
                    mChangeType = PACKAGE_UPDATING;
                    onPackageUpdateFinished(pkg, uid);
                    onPackageModified(pkg);
                } else {
                    mChangeType = PACKAGE_PERMANENT_CHANGE;
                    onPackageAdded(pkg, uid);
                }
                onPackageAppeared(pkg, mChangeType);
                if (mChangeType == PACKAGE_UPDATING) {
                    synchronized (mUpdatingPackages) {
                        mUpdatingPackages.remove(pkg);
                    }
                }
            }
        } else if (Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
            String pkg = getPackageName(intent);
            int uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
            if (pkg != null) {
                mDisappearingPackages = mTempArray;
                mTempArray[0] = pkg;
                if (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
                    mChangeType = PACKAGE_UPDATING;
                    synchronized (mUpdatingPackages) {
                        //not used for now
                        //mUpdatingPackages.add(pkg);
                    }
                    onPackageUpdateStarted(pkg, uid);
                } else {
                    mChangeType = PACKAGE_PERMANENT_CHANGE;
                    // We only consider something to have changed if this is
                    // not a replace; for a replace, we just need to consider
                    // it when it is re-added.
                    mSomePackagesChanged = true;
                    onPackageRemoved(pkg, uid);
                }
                onPackageDisappeared(pkg, mChangeType);
            }
        } else if (Intent.ACTION_PACKAGE_CHANGED.equals(action)) {
            String pkg = getPackageName(intent);
            int uid = intent.getIntExtra(Intent.EXTRA_UID, 0);
            String[] components = intent.getStringArrayExtra(
                    Intent.EXTRA_CHANGED_COMPONENT_NAME_LIST);
            if (pkg != null) {
                mModifiedPackages = mTempArray;
                mTempArray[0] = pkg;
                onPackageChanged(pkg, uid, components);
                // XXX Don't want this to always cause mSomePackagesChanged,
                // since it can happen a fair amount.
                onPackageModified(pkg);
            }
        } else if (Intent.ACTION_QUERY_PACKAGE_RESTART.equals(action)) {
            mDisappearingPackages = intent.getStringArrayExtra(Intent.EXTRA_PACKAGES);
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            boolean canRestart = onHandleForceStop(intent,
                    mDisappearingPackages,
                    intent.getIntExtra(Intent.EXTRA_UID, 0), false);
            if (canRestart) setResultCode(Activity.RESULT_OK);
        } else if (Intent.ACTION_PACKAGE_RESTARTED.equals(action)) {
            mDisappearingPackages = new String[] {getPackageName(intent)};
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            onHandleForceStop(intent, mDisappearingPackages,
                    intent.getIntExtra(Intent.EXTRA_UID, 0), true);
        } else if (Intent.ACTION_UID_REMOVED.equals(action)) {
            onUidRemoved(intent.getIntExtra(Intent.EXTRA_UID, 0));
        } else if (Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action)) {
            String[] pkgList = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            mAppearingPackages = pkgList;
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            mSomePackagesChanged = true;
            if (pkgList != null) {
                onPackagesAvailable(pkgList);
                for (int i=0; i<pkgList.length; i++) {
                    onPackageAppeared(pkgList[i], PACKAGE_TEMPORARY_CHANGE);
                }
            }
        } else if (Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action)) {
            String[] pkgList = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            mDisappearingPackages = pkgList;
            mChangeType = PACKAGE_TEMPORARY_CHANGE;
            mSomePackagesChanged = true;
            if (pkgList != null) {
                onPackagesUnavailable(pkgList);
                for (int i=0; i<pkgList.length; i++) {
                    onPackageDisappeared(pkgList[i], PACKAGE_TEMPORARY_CHANGE);
                }
            }
        }
        
        if (mSomePackagesChanged) {
            onSomePackagesChanged();
        }
        
        onFinishPackageChanges();
    }
}

