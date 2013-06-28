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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.394 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

    private IContentProvider mContentProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.394 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private ContentResolver mContentResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.394 -0400", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "D8DC233695476928F6285214EE8BBA5F")
      ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
        // ---------- Original Method ----------
        //mContentProvider = contentProvider;
        //mContentResolver = contentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.395 -0400", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "DC7D51971B0EE4257828397EB3BA7643")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2015774367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2015774367 = mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
        addTaint(url.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2015774367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015774367;
        // ---------- Original Method ----------
        //return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.396 -0400", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "A34E196A18253A9B9BAD35DDD65A036D")
    public String getType(Uri url) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_1167962414 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1167962414 = mContentProvider.getType(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1167962414.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167962414;
        // ---------- Original Method ----------
        //return mContentProvider.getType(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.398 -0400", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "A1F87D633A5357BA2D75637EC4AB133D")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2127401500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2127401500 = mContentProvider.getStreamTypes(url, mimeTypeFilter);
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2127401500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2127401500;
        // ---------- Original Method ----------
        //return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.399 -0400", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "2756FFBC17B9A1534D9E84D77B53600A")
    public Uri insert(Uri url, ContentValues initialValues) throws RemoteException {
        Uri varB4EAC82CA7396A68D541C85D26508E83_254156930 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_254156930 = mContentProvider.insert(url, initialValues);
        addTaint(url.getTaint());
        addTaint(initialValues.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_254156930.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_254156930;
        // ---------- Original Method ----------
        //return mContentProvider.insert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.399 -0400", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "42281ED6492C5473059612141CDA10E8")
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        int varB9AA1288A8ADB06CF2F2BD082A565998_371483839 = (mContentProvider.bulkInsert(url, initialValues));
        addTaint(url.getTaint());
        addTaint(initialValues[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399467827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399467827;
        // ---------- Original Method ----------
        //return mContentProvider.bulkInsert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.400 -0400", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "990B122ED29C57BA8109D62AF69FBA34")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        int var3994FDF7C8F3B39D467FB71FB5AAEFD8_1387047672 = (mContentProvider.delete(url, selection, selectionArgs));
        addTaint(url.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227732178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227732178;
        // ---------- Original Method ----------
        //return mContentProvider.delete(url, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.400 -0400", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "5BF6B92FC62CB07B633FCA4ECA0DA0CB")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        int var8F66677E12A515313284C88C85D764A5_721777244 = (mContentProvider.update(url, values, selection, selectionArgs));
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618857833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618857833;
        // ---------- Original Method ----------
        //return mContentProvider.update(url, values, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.401 -0400", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "5D322FC283D956DB73334393969724D4")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_548298244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_548298244 = mContentProvider.openFile(url, mode);
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_548298244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_548298244;
        // ---------- Original Method ----------
        //return mContentProvider.openFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.401 -0400", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "8F511BFA62205E0BABCD293DF0C82020")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1009016946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1009016946 = mContentProvider.openAssetFile(url, mode);
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1009016946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1009016946;
        // ---------- Original Method ----------
        //return mContentProvider.openAssetFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.402 -0400", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "EEED0D592F770D797BC01744A9465F88")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_2120480638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2120480638 = mContentProvider.openTypedAssetFile(uri, mimeType, opts);
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2120480638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2120480638;
        // ---------- Original Method ----------
        //return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.403 -0400", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "7F2927CD712ED9587DFAD7217FDC0914")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_135957832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_135957832 = mContentProvider.applyBatch(operations);
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_135957832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_135957832;
        // ---------- Original Method ----------
        //return mContentProvider.applyBatch(operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.403 -0400", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "38B10927F3D19F4E7D8701C1A2766AE2")
    public boolean release() {
        boolean var5EDBA573BE7F2FB9A39AE889B481742E_1519162752 = (mContentResolver.releaseProvider(mContentProvider));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704065687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704065687;
        // ---------- Original Method ----------
        //return mContentResolver.releaseProvider(mContentProvider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.404 -0400", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "046ACDBC6FF0F470054A33C1FBF01821")
    public ContentProvider getLocalContentProvider() {
        ContentProvider varB4EAC82CA7396A68D541C85D26508E83_1141093977 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1141093977 = ContentProvider.coerceToLocalContentProvider(mContentProvider);
        varB4EAC82CA7396A68D541C85D26508E83_1141093977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141093977;
        // ---------- Original Method ----------
        //return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}

