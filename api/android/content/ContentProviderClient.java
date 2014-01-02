package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;





public class ContentProviderClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.178 -0500", hash_original_field = "07B30FADFA6E4AFA7D12BE53D83FAFCA", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

    private  IContentProvider mContentProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.181 -0500", hash_original_field = "2F8368DC52699508898EF0A5902F2BFA", hash_generated_field = "14C84D443235CBD3C5067A704A7ECFF5")

    private  ContentResolver mContentResolver;

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.184 -0500", hash_original_method = "32816B4E573FF44675D42EE607DD365B", hash_generated_method = "32816B4E573FF44675D42EE607DD365B")
    
ContentProviderClient(ContentResolver contentResolver, IContentProvider contentProvider) {
        mContentProvider = contentProvider;
        mContentResolver = contentResolver;
    }

    /** See {@link ContentProvider#query ContentProvider.query} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.186 -0500", hash_original_method = "4948470E164D98D1C187E8F0772E2690", hash_generated_method = "E86B9E0F44812AC9B40F980309A73492")
    
public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        return mContentProvider.query(url, projection, selection,  selectionArgs, sortOrder);
    }

    /** See {@link ContentProvider#getType ContentProvider.getType} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.188 -0500", hash_original_method = "4D009E8B711C29FD69591B2F9B4F00E0", hash_generated_method = "3E71355EFCEDE306613FA0B240C80FDD")
    
public String getType(Uri url) throws RemoteException {
        return mContentProvider.getType(url);
    }

    /** See {@link ContentProvider#getStreamTypes ContentProvider.getStreamTypes} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.190 -0500", hash_original_method = "FB59FC7223A39B6B6F90441FA7E5A170", hash_generated_method = "16FA7E8564F6D91FA1DE3487C66594DE")
    
public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        return mContentProvider.getStreamTypes(url, mimeTypeFilter);
    }

    /** See {@link ContentProvider#insert ContentProvider.insert} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.192 -0500", hash_original_method = "DCF792BA3D706C57D023C460ED11C34C", hash_generated_method = "C8C374393429951A54DCEE7E6858D073")
    
public Uri insert(Uri url, ContentValues initialValues)
            throws RemoteException {
        return mContentProvider.insert(url, initialValues);
    }

    /** See {@link ContentProvider#bulkInsert ContentProvider.bulkInsert} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.194 -0500", hash_original_method = "610F9CD05A6F00083AB860F680EDE10F", hash_generated_method = "D2B85928A0C4F179AE292E1C94BFF031")
    
public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException {
        return mContentProvider.bulkInsert(url, initialValues);
    }

    /** See {@link ContentProvider#delete ContentProvider.delete} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.196 -0500", hash_original_method = "55FA237DF4BFD41E9E08436F090DA85B", hash_generated_method = "27D5DC60B53A435636C68EEE1CDC87B9")
    
public int delete(Uri url, String selection, String[] selectionArgs)
            throws RemoteException {
        return mContentProvider.delete(url, selection, selectionArgs);
    }

    /** See {@link ContentProvider#update ContentProvider.update} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.199 -0500", hash_original_method = "BCCAE42CFD50D64D397E399DC9FED070", hash_generated_method = "9AB69F174FF0F02550F6E78C8C377114")
    
public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        return mContentProvider.update(url, values, selection, selectionArgs);
    }

    /**
     * See {@link ContentProvider#openFile ContentProvider.openFile}.  Note that
     * this <em>does not</em>
     * take care of non-content: URIs such as file:.  It is strongly recommended
     * you use the {@link ContentResolver#openFileDescriptor
     * ContentResolver.openFileDescriptor} API instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.201 -0500", hash_original_method = "D4D68B8D1E5B48A554790DFA92374EAF", hash_generated_method = "B08AA533BDFC857405D94699FA199050")
    
public ParcelFileDescriptor openFile(Uri url, String mode)
            throws RemoteException, FileNotFoundException {
        return mContentProvider.openFile(url, mode);
    }

    /**
     * See {@link ContentProvider#openAssetFile ContentProvider.openAssetFile}.
     * Note that this <em>does not</em>
     * take care of non-content: URIs such as file:.  It is strongly recommended
     * you use the {@link ContentResolver#openAssetFileDescriptor
     * ContentResolver.openAssetFileDescriptor} API instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.203 -0500", hash_original_method = "0F83F3227BB34A0F16879E1472F99C94", hash_generated_method = "868DAB1C8D12F42BAEF1D1C627C4606C")
    
public AssetFileDescriptor openAssetFile(Uri url, String mode)
            throws RemoteException, FileNotFoundException {
        return mContentProvider.openAssetFile(url, mode);
    }

    /** See {@link ContentProvider#openTypedAssetFile ContentProvider.openTypedAssetFile} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.205 -0500", hash_original_method = "BE665D47389B6568CACD4F1C34360A55", hash_generated_method = "608B886B7E06FFE498D4683BBEE277C2")
    
public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts)
            throws RemoteException, FileNotFoundException {
        return mContentProvider.openTypedAssetFile(uri, mimeType, opts);
    }

    /** See {@link ContentProvider#applyBatch ContentProvider.applyBatch} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.207 -0500", hash_original_method = "4E4137D928F990D7ECC67380DB9AD1AA", hash_generated_method = "DC41985E770CE429D6BD224B44E1602A")
    
public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations)
            throws RemoteException, OperationApplicationException {
        return mContentProvider.applyBatch(operations);
    }

    /**
     * Call this to indicate to the system that the associated {@link ContentProvider} is no
     * longer needed by this {@link ContentProviderClient}.
     * @return true if this was release, false if it was already released
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.210 -0500", hash_original_method = "6D0FD87E467E88469A71D9D6FF407FC5", hash_generated_method = "C7FAF5C3E2664AE4E8F5BE8EE55C25B8")
    
public boolean release() {
        return mContentResolver.releaseProvider(mContentProvider);
    }

    /**
     * Get a reference to the {@link ContentProvider} that is associated with this
     * client. If the {@link ContentProvider} is running in a different process then
     * null will be returned. This can be used if you know you are running in the same
     * process as a provider, and want to get direct access to its implementation details.
     *
     * @return If the associated {@link ContentProvider} is local, returns it.
     * Otherwise returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:38.213 -0500", hash_original_method = "50EB5374A057DC07A98B18D14BEE701F", hash_generated_method = "17F4323B120E66BE3CBAFB397569796A")
    
public ContentProvider getLocalContentProvider() {
        return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    
}

