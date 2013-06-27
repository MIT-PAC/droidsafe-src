package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetFileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ContentProviderClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.359 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

    private IContentProvider mContentProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.359 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private ContentResolver mContentResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.360 -0400", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "D8DC233695476928F6285214EE8BBA5F")
      ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
        // ---------- Original Method ----------
        //mContentProvider = contentProvider;
        //mContentResolver = contentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.362 -0400", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "66FC34486F88CB38B345A96AD700AF07")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_819919324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_819919324 = mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
        addTaint(url.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_819919324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819919324;
        // ---------- Original Method ----------
        //return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.363 -0400", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "92270153AFB875B41DCEDAC70540469F")
    public String getType(Uri url) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_1954570088 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1954570088 = mContentProvider.getType(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1954570088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1954570088;
        // ---------- Original Method ----------
        //return mContentProvider.getType(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.378 -0400", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "46028B6B2BDB28DF1999FA031CE133C1")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_36883854 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_36883854 = mContentProvider.getStreamTypes(url, mimeTypeFilter);
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_36883854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_36883854;
        // ---------- Original Method ----------
        //return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.379 -0400", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "64F26B4F5F6EFC7FC88DD7EF1EA35E66")
    public Uri insert(Uri url, ContentValues initialValues) throws RemoteException {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1703108051 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1703108051 = mContentProvider.insert(url, initialValues);
        addTaint(url.getTaint());
        addTaint(initialValues.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1703108051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703108051;
        // ---------- Original Method ----------
        //return mContentProvider.insert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.386 -0400", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "27E760D3680A3FAC166D4BC597B4E7EB")
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        int varB9AA1288A8ADB06CF2F2BD082A565998_602362617 = (mContentProvider.bulkInsert(url, initialValues));
        addTaint(url.getTaint());
        addTaint(initialValues[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199403930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199403930;
        // ---------- Original Method ----------
        //return mContentProvider.bulkInsert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.407 -0400", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "5C79D78175EC9814E4854DB53DFB619E")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        int var3994FDF7C8F3B39D467FB71FB5AAEFD8_2062947505 = (mContentProvider.delete(url, selection, selectionArgs));
        addTaint(url.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878684510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878684510;
        // ---------- Original Method ----------
        //return mContentProvider.delete(url, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.408 -0400", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "CAA6CF8580AB3CCB03BD7C2CDFFA2182")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        int var8F66677E12A515313284C88C85D764A5_483164799 = (mContentProvider.update(url, values, selection, selectionArgs));
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363811278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363811278;
        // ---------- Original Method ----------
        //return mContentProvider.update(url, values, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.429 -0400", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "6FBC596F30199C6EF06587D0AF9FB0AC")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_129952288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_129952288 = mContentProvider.openFile(url, mode);
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_129952288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_129952288;
        // ---------- Original Method ----------
        //return mContentProvider.openFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.430 -0400", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "37B39D6A1F3445EFD044C02BF8529308")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1215887950 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1215887950 = mContentProvider.openAssetFile(url, mode);
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1215887950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1215887950;
        // ---------- Original Method ----------
        //return mContentProvider.openAssetFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.432 -0400", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "A512E408DB8F3481FD00E06741CF747B")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1763163126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1763163126 = mContentProvider.openTypedAssetFile(uri, mimeType, opts);
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1763163126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763163126;
        // ---------- Original Method ----------
        //return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.448 -0400", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "42BE66D3388AA928031D87D02BBE1EE4")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_664099982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_664099982 = mContentProvider.applyBatch(operations);
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_664099982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_664099982;
        // ---------- Original Method ----------
        //return mContentProvider.applyBatch(operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.449 -0400", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "0562A25EC8CF58047C22848B7A20401A")
    public boolean release() {
        boolean var5EDBA573BE7F2FB9A39AE889B481742E_300017377 = (mContentResolver.releaseProvider(mContentProvider));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043053002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043053002;
        // ---------- Original Method ----------
        //return mContentResolver.releaseProvider(mContentProvider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.466 -0400", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "D7C0846D1F05D2B551C38154FE760646")
    public ContentProvider getLocalContentProvider() {
        ContentProvider varB4EAC82CA7396A68D541C85D26508E83_840412666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_840412666 = ContentProvider.coerceToLocalContentProvider(mContentProvider);
        varB4EAC82CA7396A68D541C85D26508E83_840412666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_840412666;
        // ---------- Original Method ----------
        //return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}

