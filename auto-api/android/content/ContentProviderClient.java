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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.852 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

    private IContentProvider mContentProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.853 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private ContentResolver mContentResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.863 -0400", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "D8DC233695476928F6285214EE8BBA5F")
      ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
        // ---------- Original Method ----------
        //mContentProvider = contentProvider;
        //mContentResolver = contentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.869 -0400", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "34672BAE6702FC1AD6B29227FD8E600B")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1606226052 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1606226052 = mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
        addTaint(url.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1606226052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1606226052;
        // ---------- Original Method ----------
        //return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.882 -0400", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "AFB8F3B8396B8F49F3B05A2E4D5F5536")
    public String getType(Uri url) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_409600082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_409600082 = mContentProvider.getType(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_409600082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409600082;
        // ---------- Original Method ----------
        //return mContentProvider.getType(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.887 -0400", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "BC9178D3BF0819BC9340950208AF77F5")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1871072105 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1871072105 = mContentProvider.getStreamTypes(url, mimeTypeFilter);
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1871072105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1871072105;
        // ---------- Original Method ----------
        //return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.904 -0400", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "D82CB79CCE71EBB382329210EF09116E")
    public Uri insert(Uri url, ContentValues initialValues) throws RemoteException {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1777059834 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1777059834 = mContentProvider.insert(url, initialValues);
        addTaint(url.getTaint());
        addTaint(initialValues.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1777059834.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1777059834;
        // ---------- Original Method ----------
        //return mContentProvider.insert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.906 -0400", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "30DB8CAA1661E573D660940ED1AC08F3")
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        int varB9AA1288A8ADB06CF2F2BD082A565998_770875205 = (mContentProvider.bulkInsert(url, initialValues));
        addTaint(url.getTaint());
        addTaint(initialValues[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732421122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732421122;
        // ---------- Original Method ----------
        //return mContentProvider.bulkInsert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.907 -0400", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "5986382DAA48DAA0354FDCA3B98C57B7")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        int var3994FDF7C8F3B39D467FB71FB5AAEFD8_1417418773 = (mContentProvider.delete(url, selection, selectionArgs));
        addTaint(url.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950383194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950383194;
        // ---------- Original Method ----------
        //return mContentProvider.delete(url, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.931 -0400", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "C5FD762CBFDCC56E0D4BA4D23ACD8C5C")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        int var8F66677E12A515313284C88C85D764A5_1427539526 = (mContentProvider.update(url, values, selection, selectionArgs));
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031498354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031498354;
        // ---------- Original Method ----------
        //return mContentProvider.update(url, values, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.932 -0400", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "622FAAB61BF6C4F6D969E80C13ABE989")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1811355710 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1811355710 = mContentProvider.openFile(url, mode);
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1811355710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1811355710;
        // ---------- Original Method ----------
        //return mContentProvider.openFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.934 -0400", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "0D4D913546CF2E308A948B1462BDB3AF")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1643689378 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1643689378 = mContentProvider.openAssetFile(url, mode);
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1643689378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1643689378;
        // ---------- Original Method ----------
        //return mContentProvider.openAssetFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.956 -0400", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "F0BD998345C84006100AC6A15942CCEF")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1539982093 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1539982093 = mContentProvider.openTypedAssetFile(uri, mimeType, opts);
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1539982093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539982093;
        // ---------- Original Method ----------
        //return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.958 -0400", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "19DE1800100410FFCC1F74E09C29A021")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1802602862 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1802602862 = mContentProvider.applyBatch(operations);
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1802602862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802602862;
        // ---------- Original Method ----------
        //return mContentProvider.applyBatch(operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.959 -0400", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "0E73F82A907A88BF3BB2E36E94547D22")
    public boolean release() {
        boolean var5EDBA573BE7F2FB9A39AE889B481742E_1377293163 = (mContentResolver.releaseProvider(mContentProvider));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166960457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166960457;
        // ---------- Original Method ----------
        //return mContentResolver.releaseProvider(mContentProvider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.964 -0400", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "7DD5FE9883F728361250386F2AB2D1FC")
    public ContentProvider getLocalContentProvider() {
        ContentProvider varB4EAC82CA7396A68D541C85D26508E83_1552814295 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1552814295 = ContentProvider.coerceToLocalContentProvider(mContentProvider);
        varB4EAC82CA7396A68D541C85D26508E83_1552814295.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1552814295;
        // ---------- Original Method ----------
        //return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}

