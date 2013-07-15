package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetFileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ContentProviderClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.515 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

    private IContentProvider mContentProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.515 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private ContentResolver mContentResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.516 -0400", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "D8DC233695476928F6285214EE8BBA5F")
      ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
        // ---------- Original Method ----------
        //mContentProvider = contentProvider;
        //mContentResolver = contentResolver;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.516 -0400", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "E7D9F48DABE18518AC4ECC0D079A970E")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(url.getTaint());
Cursor var18540D6B41070F14F5FE0EB78359FBB4_841101773 =         mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
        var18540D6B41070F14F5FE0EB78359FBB4_841101773.addTaint(taint);
        return var18540D6B41070F14F5FE0EB78359FBB4_841101773;
        // ---------- Original Method ----------
        //return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.517 -0400", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "C78B25FE87BE47193B49A3229BC43D5C")
    public String getType(Uri url) throws RemoteException {
        addTaint(url.getTaint());
String var82195E878B3E82B3A02094B1850982F7_1528076568 =         mContentProvider.getType(url);
        var82195E878B3E82B3A02094B1850982F7_1528076568.addTaint(taint);
        return var82195E878B3E82B3A02094B1850982F7_1528076568;
        // ---------- Original Method ----------
        //return mContentProvider.getType(url);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.517 -0400", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "55DBC5EA97630201C5C69653E56ED614")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(url.getTaint());
String[] varD261B285689E343EB631D71BFEB7913C_548996935 =         mContentProvider.getStreamTypes(url, mimeTypeFilter);
        varD261B285689E343EB631D71BFEB7913C_548996935.addTaint(taint);
        return varD261B285689E343EB631D71BFEB7913C_548996935;
        // ---------- Original Method ----------
        //return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.518 -0400", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "FB2C12FA1D813532271A2EE9D05FED9E")
    public Uri insert(Uri url, ContentValues initialValues) throws RemoteException {
        addTaint(initialValues.getTaint());
        addTaint(url.getTaint());
Uri varA3DC35E25A52C8D59F81F238CA85622E_1443705380 =         mContentProvider.insert(url, initialValues);
        varA3DC35E25A52C8D59F81F238CA85622E_1443705380.addTaint(taint);
        return varA3DC35E25A52C8D59F81F238CA85622E_1443705380;
        // ---------- Original Method ----------
        //return mContentProvider.insert(url, initialValues);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.518 -0400", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "A755E66F3A64C23FB85526BD09C9A262")
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        addTaint(initialValues[0].getTaint());
        addTaint(url.getTaint());
        int varA1FFB1730511F96417DDBE4F3A115195_846861100 = (mContentProvider.bulkInsert(url, initialValues));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24195771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24195771;
        // ---------- Original Method ----------
        //return mContentProvider.bulkInsert(url, initialValues);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.519 -0400", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "432EF29B0F8AF13C80CC42825E73EB07")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(url.getTaint());
        int var4CA324A8309DA8F5B423808EA003B536_922808150 = (mContentProvider.delete(url, selection, selectionArgs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991098274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991098274;
        // ---------- Original Method ----------
        //return mContentProvider.delete(url, selection, selectionArgs);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.520 -0400", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "221BC950A2E02A80C53E64E1DA68FE12")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(values.getTaint());
        addTaint(url.getTaint());
        int var5095CBB790E3F609A465B84D1666B18C_945730169 = (mContentProvider.update(url, values, selection, selectionArgs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2010687489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2010687489;
        // ---------- Original Method ----------
        //return mContentProvider.update(url, values, selection, selectionArgs);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.520 -0400", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "2F9B02214D0A7EDCC92A935120EA30C9")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(url.getTaint());
ParcelFileDescriptor varBB4FE6E865172683939A18CA8BB37357_1150793433 =         mContentProvider.openFile(url, mode);
        varBB4FE6E865172683939A18CA8BB37357_1150793433.addTaint(taint);
        return varBB4FE6E865172683939A18CA8BB37357_1150793433;
        // ---------- Original Method ----------
        //return mContentProvider.openFile(url, mode);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.521 -0400", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "558F51BB20ACDB4EAD99D01D6B5FD3DB")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(url.getTaint());
AssetFileDescriptor var3E8AB6117448C893939DA92355B04E2A_1404274833 =         mContentProvider.openAssetFile(url, mode);
        var3E8AB6117448C893939DA92355B04E2A_1404274833.addTaint(taint);
        return var3E8AB6117448C893939DA92355B04E2A_1404274833;
        // ---------- Original Method ----------
        //return mContentProvider.openAssetFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.522 -0400", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "D8D94CFB02F01A162AABEE556A656ED4")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(uri.getTaint());
AssetFileDescriptor varB6754F03B30642F022141EA5AEAF37E0_1959971900 =         mContentProvider.openTypedAssetFile(uri, mimeType, opts);
        varB6754F03B30642F022141EA5AEAF37E0_1959971900.addTaint(taint);
        return varB6754F03B30642F022141EA5AEAF37E0_1959971900;
        // ---------- Original Method ----------
        //return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.522 -0400", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "9FEA59D035BEEB0A06ECC096FFAC5648")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        addTaint(operations.getTaint());
ContentProviderResult[] varA5792D8F2DF3492C001E17A78FA6D47B_260042163 =         mContentProvider.applyBatch(operations);
        varA5792D8F2DF3492C001E17A78FA6D47B_260042163.addTaint(taint);
        return varA5792D8F2DF3492C001E17A78FA6D47B_260042163;
        // ---------- Original Method ----------
        //return mContentProvider.applyBatch(operations);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.523 -0400", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "AE6A7F72DD553C9C3DD3834D6FB6C00B")
    public boolean release() {
        boolean var0E13907596B373C827F95A0D4B9A5F8F_18114100 = (mContentResolver.releaseProvider(mContentProvider));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795716199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795716199;
        // ---------- Original Method ----------
        //return mContentResolver.releaseProvider(mContentProvider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.523 -0400", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "127C3A3692CAF63B700009534FDA34D8")
    public ContentProvider getLocalContentProvider() {
ContentProvider var240B8D085C8DCA342CD42B9D339190A2_657429572 =         ContentProvider.coerceToLocalContentProvider(mContentProvider);
        var240B8D085C8DCA342CD42B9D339190A2_657429572.addTaint(taint);
        return var240B8D085C8DCA342CD42B9D339190A2_657429572;
        // ---------- Original Method ----------
        //return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}

