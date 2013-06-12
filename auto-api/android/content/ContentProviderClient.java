package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final IContentProvider mContentProvider;
    private final ContentResolver mContentResolver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.320 -0400", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "A76C09A0C6BD222511A5C0875EBA269A")
    @DSModeled(DSC.SAFE)
     ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        dsTaint.addTaint(contentResolver.dsTaint);
        dsTaint.addTaint(contentProvider.dsTaint);
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
        // ---------- Original Method ----------
        //mContentProvider = contentProvider;
        //mContentResolver = contentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.320 -0400", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "EDF3F115E3B7ACB98CA1A84FE5544CC4")
    @DSModeled(DSC.SPEC)
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(selection);
        Cursor var2D2EC69BBFE9E900387E7AC2E4FFA0B0_510071327 = (mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.321 -0400", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "50F80E635A5E7F49C4077B78DA583D04")
    @DSModeled(DSC.SPEC)
    public String getType(Uri url) throws RemoteException {
        dsTaint.addTaint(url.dsTaint);
        String varD825F615B1F056316702B665E1806D8B_432007270 = (mContentProvider.getType(url));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentProvider.getType(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.321 -0400", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "BDFD31EE46DB4B9EF844D13CB35A2F71")
    @DSModeled(DSC.SPEC)
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        dsTaint.addTaint(mimeTypeFilter);
        dsTaint.addTaint(url.dsTaint);
        String[] var68971553BC83917D81B8E8B8D7F6336E_1779192621 = (mContentProvider.getStreamTypes(url, mimeTypeFilter));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.321 -0400", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "73746FD6422B5B4DEA1134083C03951D")
    @DSModeled(DSC.SPEC)
    public Uri insert(Uri url, ContentValues initialValues) throws RemoteException {
        dsTaint.addTaint(initialValues.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        Uri var1A49A913424CA0798031EF25402AF767_397370616 = (mContentProvider.insert(url, initialValues));
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentProvider.insert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.322 -0400", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "087C4CCDBE3AD727347EE9093A57DC83")
    @DSModeled(DSC.SPEC)
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        dsTaint.addTaint(initialValues[0].dsTaint);
        dsTaint.addTaint(url.dsTaint);
        int varB9AA1288A8ADB06CF2F2BD082A565998_1031380337 = (mContentProvider.bulkInsert(url, initialValues));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentProvider.bulkInsert(url, initialValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.322 -0400", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "A922C70EC9CDF03564ACFAFB3D7B248F")
    @DSModeled(DSC.SPEC)
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(selection);
        int var3994FDF7C8F3B39D467FB71FB5AAEFD8_1971506583 = (mContentProvider.delete(url, selection, selectionArgs));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentProvider.delete(url, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.322 -0400", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "8BBDA678F3425EFC542BA111ED5C20A1")
    @DSModeled(DSC.SPEC)
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(selection);
        int var8F66677E12A515313284C88C85D764A5_1929042864 = (mContentProvider.update(url, values, selection, selectionArgs));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentProvider.update(url, values, selection, selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.322 -0400", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "937C6EE7826E677008F354FCE2BCEF7F")
    @DSModeled(DSC.SPEC)
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(mode);
        ParcelFileDescriptor var1346A6F2CB2CEDA12014F70A933CD330_816805870 = (mContentProvider.openFile(url, mode));
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentProvider.openFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.323 -0400", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "3E265CED2221ECDF4CF1D7DE16410DB4")
    @DSModeled(DSC.SPEC)
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(mode);
        AssetFileDescriptor varCA82E9E9CF55CDAD3EB81CBF91E87EA6_517493809 = (mContentProvider.openAssetFile(url, mode));
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentProvider.openAssetFile(url, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.323 -0400", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "F2F919C1486D73B53CB8666E270F407F")
    @DSModeled(DSC.SPEC)
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        dsTaint.addTaint(opts.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mimeType);
        AssetFileDescriptor var9A28FD8F9367437213809FE32363B310_1834378252 = (mContentProvider.openTypedAssetFile(uri, mimeType, opts));
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.323 -0400", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "EE212A2122DCA46F326B9D3BB3AED48D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        dsTaint.addTaint(operations.dsTaint);
        ContentProviderResult[] varD28C5007D7621AE26598087EAC741CB0_66006091 = (mContentProvider.applyBatch(operations));
        return (ContentProviderResult[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentProvider.applyBatch(operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.324 -0400", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "5183C735DBF8ECE0E5AA2D55D65AAC32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean release() {
        boolean var5EDBA573BE7F2FB9A39AE889B481742E_1683133628 = (mContentResolver.releaseProvider(mContentProvider));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mContentResolver.releaseProvider(mContentProvider);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.324 -0400", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "916B3690D649AA9EB6D25F1286692B70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProvider getLocalContentProvider() {
        ContentProvider varC32BC5C110A68DE6ADC60289C0C37132_1435108480 = (ContentProvider.coerceToLocalContentProvider(mContentProvider));
        return (ContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}


