package android.content;

// Droidsafe Imports
import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContentProviderClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.847 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

    private IContentProvider mContentProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.848 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private ContentResolver mContentResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.849 -0400", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "D8DC233695476928F6285214EE8BBA5F")
      ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
        // ---------- Original Method ----------
        //mContentProvider = contentProvider;
        //mContentResolver = contentResolver;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.850 -0400", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "525D85A2113C637D1C7B5BA4B556A342")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(url.getTaint());
Cursor var18540D6B41070F14F5FE0EB78359FBB4_943263678 =         mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
        var18540D6B41070F14F5FE0EB78359FBB4_943263678.addTaint(taint);
        return var18540D6B41070F14F5FE0EB78359FBB4_943263678;
        // ---------- Original Method ----------
        //return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.851 -0400", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "162CFA83C9FDC570393DC34914BD71B6")
    public String getType(Uri url) throws RemoteException {
        addTaint(url.getTaint());
String var82195E878B3E82B3A02094B1850982F7_1277992680 =         mContentProvider.getType(url);
        var82195E878B3E82B3A02094B1850982F7_1277992680.addTaint(taint);
        return var82195E878B3E82B3A02094B1850982F7_1277992680;
        // ---------- Original Method ----------
        //return mContentProvider.getType(url);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.852 -0400", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "5CAFF17D8CD11353DD9BA5384CA0BC2B")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(url.getTaint());
String[] varD261B285689E343EB631D71BFEB7913C_371297051 =         mContentProvider.getStreamTypes(url, mimeTypeFilter);
        varD261B285689E343EB631D71BFEB7913C_371297051.addTaint(taint);
        return varD261B285689E343EB631D71BFEB7913C_371297051;
        // ---------- Original Method ----------
        //return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.854 -0400", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "235BCCA14BF8FD9054F42C8F983D23E6")
    public Uri insert(Uri url, ContentValues initialValues) throws RemoteException {
        addTaint(initialValues.getTaint());
        addTaint(url.getTaint());
Uri varA3DC35E25A52C8D59F81F238CA85622E_94887255 =         mContentProvider.insert(url, initialValues);
        varA3DC35E25A52C8D59F81F238CA85622E_94887255.addTaint(taint);
        return varA3DC35E25A52C8D59F81F238CA85622E_94887255;
        // ---------- Original Method ----------
        //return mContentProvider.insert(url, initialValues);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.855 -0400", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "A1C1BFD84FA7B49731704282B3D6D1A7")
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        addTaint(initialValues[0].getTaint());
        addTaint(url.getTaint());
        int varA1FFB1730511F96417DDBE4F3A115195_896078390 = (mContentProvider.bulkInsert(url, initialValues));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293547929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293547929;
        // ---------- Original Method ----------
        //return mContentProvider.bulkInsert(url, initialValues);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.856 -0400", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "D0DC48D26DA852CFF2048BF146D37667")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(url.getTaint());
        int var4CA324A8309DA8F5B423808EA003B536_1337321086 = (mContentProvider.delete(url, selection, selectionArgs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118995225 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118995225;
        // ---------- Original Method ----------
        //return mContentProvider.delete(url, selection, selectionArgs);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.858 -0400", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "A441BE686DD5B72D52CC6446E034C1E0")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(values.getTaint());
        addTaint(url.getTaint());
        int var5095CBB790E3F609A465B84D1666B18C_110776306 = (mContentProvider.update(url, values, selection, selectionArgs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856361889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856361889;
        // ---------- Original Method ----------
        //return mContentProvider.update(url, values, selection, selectionArgs);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.859 -0400", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "B8799290DF9090F67A3E2864AA067071")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(url.getTaint());
ParcelFileDescriptor varBB4FE6E865172683939A18CA8BB37357_1644882154 =         mContentProvider.openFile(url, mode);
        varBB4FE6E865172683939A18CA8BB37357_1644882154.addTaint(taint);
        return varBB4FE6E865172683939A18CA8BB37357_1644882154;
        // ---------- Original Method ----------
        //return mContentProvider.openFile(url, mode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.860 -0400", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "0204F2E63D7A6993446D342C9FCBA5DA")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(url.getTaint());
AssetFileDescriptor var3E8AB6117448C893939DA92355B04E2A_1191743236 =         mContentProvider.openAssetFile(url, mode);
        var3E8AB6117448C893939DA92355B04E2A_1191743236.addTaint(taint);
        return var3E8AB6117448C893939DA92355B04E2A_1191743236;
        // ---------- Original Method ----------
        //return mContentProvider.openAssetFile(url, mode);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.861 -0400", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "A01386C2FECD005D4B9263128274432C")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(uri.getTaint());
AssetFileDescriptor varB6754F03B30642F022141EA5AEAF37E0_23593673 =         mContentProvider.openTypedAssetFile(uri, mimeType, opts);
        varB6754F03B30642F022141EA5AEAF37E0_23593673.addTaint(taint);
        return varB6754F03B30642F022141EA5AEAF37E0_23593673;
        // ---------- Original Method ----------
        //return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.862 -0400", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "4E9A509A8711C86A25CF013D6C2BBBC1")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        addTaint(operations.getTaint());
ContentProviderResult[] varA5792D8F2DF3492C001E17A78FA6D47B_135450640 =         mContentProvider.applyBatch(operations);
        varA5792D8F2DF3492C001E17A78FA6D47B_135450640.addTaint(taint);
        return varA5792D8F2DF3492C001E17A78FA6D47B_135450640;
        // ---------- Original Method ----------
        //return mContentProvider.applyBatch(operations);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.862 -0400", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "4A393CF0BE663855A9B04AD1345729B3")
    public boolean release() {
        boolean var0E13907596B373C827F95A0D4B9A5F8F_638155931 = (mContentResolver.releaseProvider(mContentProvider));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1702429559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1702429559;
        // ---------- Original Method ----------
        //return mContentResolver.releaseProvider(mContentProvider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.863 -0400", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "105234CB34E923A779C46BC392B49503")
    public ContentProvider getLocalContentProvider() {
ContentProvider var240B8D085C8DCA342CD42B9D339190A2_1939896573 =         ContentProvider.coerceToLocalContentProvider(mContentProvider);
        var240B8D085C8DCA342CD42B9D339190A2_1939896573.addTaint(taint);
        return var240B8D085C8DCA342CD42B9D339190A2_1939896573;
        // ---------- Original Method ----------
        //return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}

