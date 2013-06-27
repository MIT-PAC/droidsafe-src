package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.AssetFileDescriptor;
import android.database.BulkCursorNative;
import android.database.BulkCursorToCursorAdaptor;
import android.database.Cursor;
import android.database.CursorToBulkCursorAdaptor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.IBulkCursor;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.FileNotFoundException;
import java.util.ArrayList;

abstract public class ContentProviderNative extends Binder implements IContentProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.570 -0400", hash_original_method = "AF85EE1D14BCBAFA210CD4FE8D0D0EAA", hash_generated_method = "5B89B81546A27F738FE867A18D587122")
    public  ContentProviderNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
        static public IContentProvider asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IContentProvider in =
            (IContentProvider)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }
        return new ContentProviderProxy(obj);
    }

    
    public abstract String getProviderName();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.655 -0400", hash_original_method = "0A95D8923EFA335F625BF0735B390C42", hash_generated_method = "7048ECC8B156C23A59828ECCC4130269")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            //Begin case QUERY_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                int num;
                num = data.readInt();
                String[] projection;
                projection = null;
                {
                    projection = new String[num];
                    {
                        int i;
                        i = 0;
                        {
                            projection[i] = data.readString();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                String selection;
                selection = data.readString();
                num = data.readInt();
                String[] selectionArgs;
                selectionArgs = null;
                {
                    selectionArgs = new String[num];
                    {
                        int i;
                        i = 0;
                        {
                            selectionArgs[i] = data.readString();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                String sortOrder;
                sortOrder = data.readString();
                IContentObserver observer;
                observer = IContentObserver.Stub.asInterface(
                            data.readStrongBinder());
                Cursor cursor;
                cursor = query(url, projection, selection, selectionArgs, sortOrder);
                {
                    CursorToBulkCursorAdaptor adaptor;
                    adaptor = new CursorToBulkCursorAdaptor(
                                cursor, observer, getProviderName());
                    IBinder binder;
                    binder = adaptor.asBinder();
                    int count;
                    count = adaptor.count();
                    int index;
                    index = BulkCursorToCursorAdaptor.findRowIdColumnIndex(
                                adaptor.getColumnNames());
                    boolean wantsAllOnMoveCalls;
                    wantsAllOnMoveCalls = adaptor.getWantsAllOnMoveCalls();
                    reply.writeNoException();
                    reply.writeStrongBinder(binder);
                    reply.writeInt(count);
                    reply.writeInt(index);
                    reply.writeInt(wantsAllOnMoveCalls ? 1 : 0);
                } //End block
                {
                    reply.writeNoException();
                    reply.writeStrongBinder(null);
                } //End block
            } //End block
            //End case QUERY_TRANSACTION 
            //Begin case GET_TYPE_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                String type;
                type = getType(url);
                reply.writeNoException();
                reply.writeString(type);
            } //End block
            //End case GET_TYPE_TRANSACTION 
            //Begin case INSERT_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                ContentValues values;
                values = ContentValues.CREATOR.createFromParcel(data);
                Uri out;
                out = insert(url, values);
                reply.writeNoException();
                Uri.writeToParcel(reply, out);
            } //End block
            //End case INSERT_TRANSACTION 
            //Begin case BULK_INSERT_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                ContentValues[] values;
                values = data.createTypedArray(ContentValues.CREATOR);
                int count;
                count = bulkInsert(url, values);
                reply.writeNoException();
                reply.writeInt(count);
            } //End block
            //End case BULK_INSERT_TRANSACTION 
            //Begin case APPLY_BATCH_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                int numOperations;
                numOperations = data.readInt();
                ArrayList<ContentProviderOperation> operations;
                operations = new ArrayList<ContentProviderOperation>(numOperations);
                {
                    int i;
                    i = 0;
                    {
                        operations.add(i, ContentProviderOperation.CREATOR.createFromParcel(data));
                    } //End block
                } //End collapsed parenthetic
                ContentProviderResult[] results;
                results = applyBatch(operations);
                reply.writeNoException();
                reply.writeTypedArray(results, 0);
            } //End block
            //End case APPLY_BATCH_TRANSACTION 
            //Begin case DELETE_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                String selection;
                selection = data.readString();
                String[] selectionArgs;
                selectionArgs = data.readStringArray();
                int count;
                count = delete(url, selection, selectionArgs);
                reply.writeNoException();
                reply.writeInt(count);
            } //End block
            //End case DELETE_TRANSACTION 
            //Begin case UPDATE_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                ContentValues values;
                values = ContentValues.CREATOR.createFromParcel(data);
                String selection;
                selection = data.readString();
                String[] selectionArgs;
                selectionArgs = data.readStringArray();
                int count;
                count = update(url, values, selection, selectionArgs);
                reply.writeNoException();
                reply.writeInt(count);
            } //End block
            //End case UPDATE_TRANSACTION 
            //Begin case OPEN_FILE_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                String mode;
                mode = data.readString();
                ParcelFileDescriptor fd;
                fd = openFile(url, mode);
                reply.writeNoException();
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                {
                    reply.writeInt(0);
                } //End block
            } //End block
            //End case OPEN_FILE_TRANSACTION 
            //Begin case OPEN_ASSET_FILE_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                String mode;
                mode = data.readString();
                AssetFileDescriptor fd;
                fd = openAssetFile(url, mode);
                reply.writeNoException();
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                {
                    reply.writeInt(0);
                } //End block
            } //End block
            //End case OPEN_ASSET_FILE_TRANSACTION 
            //Begin case CALL_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                String method;
                method = data.readString();
                String stringArg;
                stringArg = data.readString();
                Bundle args;
                args = data.readBundle();
                Bundle responseBundle;
                responseBundle = call(method, stringArg, args);
                reply.writeNoException();
                reply.writeBundle(responseBundle);
            } //End block
            //End case CALL_TRANSACTION 
            //Begin case GET_STREAM_TYPES_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                String mimeTypeFilter;
                mimeTypeFilter = data.readString();
                String[] types;
                types = getStreamTypes(url, mimeTypeFilter);
                reply.writeNoException();
                reply.writeStringArray(types);
            } //End block
            //End case GET_STREAM_TYPES_TRANSACTION 
            //Begin case OPEN_TYPED_ASSET_FILE_TRANSACTION 
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url;
                url = Uri.CREATOR.createFromParcel(data);
                String mimeType;
                mimeType = data.readString();
                Bundle opts;
                opts = data.readBundle();
                AssetFileDescriptor fd;
                fd = openTypedAssetFile(url, mimeType, opts);
                reply.writeNoException();
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                {
                    reply.writeInt(0);
                } //End block
            } //End block
            //End case OPEN_TYPED_ASSET_FILE_TRANSACTION 
        } //End block
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
        } //End block
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_710774512 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263336787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_263336787;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.672 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "0882616CD855E5870D7E189BCA12C064")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_310669893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_310669893 = this;
        varB4EAC82CA7396A68D541C85D26508E83_310669893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310669893;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.673 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "F9B6CF50A3968BFD24779BA47C347A53")

    private static String TAG = "ContentProvider";
}

final class ContentProviderProxy implements IContentProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.673 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.674 -0400", hash_original_method = "EBB42AB6A7E6F2E0E7C721E0ED401456", hash_generated_method = "2C21C5B1CBD217E3A4D6464EEDE37554")
    public  ContentProviderProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.699 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "A4FE6634BD5D3A520B61249ADC05011A")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_62473488 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_62473488 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_62473488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_62473488;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.711 -0400", hash_original_method = "E2AF136D03A7F093E9BB31072F6BF55F", hash_generated_method = "3102950FC8F8B7373358A20F4F33BB4F")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1338062707 = null; //Variable for return #1
        BulkCursorToCursorAdaptor adaptor;
        adaptor = new BulkCursorToCursorAdaptor();
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            int length;
            length = 0;
            {
                length = projection.length;
            } //End block
            data.writeInt(length);
            {
                int i;
                i = 0;
                {
                    data.writeString(projection[i]);
                } //End block
            } //End collapsed parenthetic
            data.writeString(selection);
            {
                length = selectionArgs.length;
            } //End block
            {
                length = 0;
            } //End block
            data.writeInt(length);
            {
                int i;
                i = 0;
                {
                    data.writeString(selectionArgs[i]);
                } //End block
            } //End collapsed parenthetic
            data.writeString(sortOrder);
            data.writeStrongBinder(adaptor.getObserver().asBinder());
            mRemote.transact(IContentProvider.QUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            IBulkCursor bulkCursor;
            bulkCursor = BulkCursorNative.asInterface(reply.readStrongBinder());
            {
                int rowCount;
                rowCount = reply.readInt();
                int idColumnPosition;
                idColumnPosition = reply.readInt();
                boolean wantsAllOnMoveCalls;
                wantsAllOnMoveCalls = reply.readInt() != 0;
                adaptor.initialize(bulkCursor, rowCount, idColumnPosition, wantsAllOnMoveCalls);
            } //End block
            {
                adaptor.close();
                adaptor = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1338062707 = adaptor;
        } //End block
        catch (RemoteException ex)
        {
            adaptor.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (RuntimeException ex)
        {
            adaptor.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1338062707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1338062707;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.716 -0400", hash_original_method = "53511528A81FA80D8FEA51649EBDE31C", hash_generated_method = "401355E36599FC72990D1BAC33F375F6")
    public String getType(Uri url) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_355763616 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            mRemote.transact(IContentProvider.GET_TYPE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String out;
            out = reply.readString();
            varB4EAC82CA7396A68D541C85D26508E83_355763616 = out;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_355763616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_355763616;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //mRemote.transact(IContentProvider.GET_TYPE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //String out = reply.readString();
            //return out;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.743 -0400", hash_original_method = "357B46C024ADAE1E71A2CDEC64307714", hash_generated_method = "C44E0AE0F2289423B02D2B4F9ADB1C0A")
    public Uri insert(Uri url, ContentValues values) throws RemoteException {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1577046748 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            values.writeToParcel(data, 0);
            mRemote.transact(IContentProvider.INSERT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Uri out;
            out = Uri.CREATOR.createFromParcel(reply);
            varB4EAC82CA7396A68D541C85D26508E83_1577046748 = out;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1577046748.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1577046748;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //values.writeToParcel(data, 0);
            //mRemote.transact(IContentProvider.INSERT_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //Uri out = Uri.CREATOR.createFromParcel(reply);
            //return out;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.752 -0400", hash_original_method = "C992EC82CACE6E59D7619DBD9F314166", hash_generated_method = "20556374C47A5659AD7ED8E1F0126651")
    public int bulkInsert(Uri url, ContentValues[] values) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeTypedArray(values, 0);
            mRemote.transact(IContentProvider.BULK_INSERT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            count = reply.readInt();
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(values[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237492821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237492821;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //data.writeTypedArray(values, 0);
            //mRemote.transact(IContentProvider.BULK_INSERT_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int count = reply.readInt();
            //return count;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.982 -0400", hash_original_method = "4CFA8AC0349C29482D059E42163688C7", hash_generated_method = "BB654477D9C0AC5DE2FE30CF2DFBD4CA")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_255774806 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeInt(operations.size());
            {
                Iterator<ContentProviderOperation> varE9602D9F0CB9F920ADAA80E0AEDB4F89_1679780462 = (operations).iterator();
                varE9602D9F0CB9F920ADAA80E0AEDB4F89_1679780462.hasNext();
                ContentProviderOperation operation = varE9602D9F0CB9F920ADAA80E0AEDB4F89_1679780462.next();
                {
                    operation.writeToParcel(data, 0);
                } //End block
            } //End collapsed parenthetic
            mRemote.transact(IContentProvider.APPLY_BATCH_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(reply);
            ContentProviderResult[] results;
            results = reply.createTypedArray(ContentProviderResult.CREATOR);
            varB4EAC82CA7396A68D541C85D26508E83_255774806 = results;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_255774806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255774806;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //data.writeInt(operations.size());
            //for (ContentProviderOperation operation : operations) {
                //operation.writeToParcel(data, 0);
            //}
            //mRemote.transact(IContentProvider.APPLY_BATCH_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(reply);
            //final ContentProviderResult[] results =
                    //reply.createTypedArray(ContentProviderResult.CREATOR);
            //return results;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.984 -0400", hash_original_method = "171153BCF0A5412C89BF2E4EC609D033", hash_generated_method = "BDBD594409E67E5FE366C388F25EA4DD")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(selection);
            data.writeStringArray(selectionArgs);
            mRemote.transact(IContentProvider.DELETE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            count = reply.readInt();
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569131531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569131531;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //data.writeString(selection);
            //data.writeStringArray(selectionArgs);
            //mRemote.transact(IContentProvider.DELETE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int count = reply.readInt();
            //return count;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.997 -0400", hash_original_method = "7CDD92EB66B20F5C2AB905C31B15C465", hash_generated_method = "4257DC9E220270387C1E1DAF6EF567FD")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            values.writeToParcel(data, 0);
            data.writeString(selection);
            data.writeStringArray(selectionArgs);
            mRemote.transact(IContentProvider.UPDATE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            count = reply.readInt();
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536975533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536975533;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //values.writeToParcel(data, 0);
            //data.writeString(selection);
            //data.writeStringArray(selectionArgs);
            //mRemote.transact(IContentProvider.UPDATE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int count = reply.readInt();
            //return count;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.999 -0400", hash_original_method = "D396B7AA54F286AF30F0B787DF60D2FE", hash_generated_method = "774632284E0455C4770E1CBED0E15460")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_224132249 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mode);
            mRemote.transact(IContentProvider.OPEN_FILE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            int has;
            has = reply.readInt();
            ParcelFileDescriptor fd;
            fd = reply.readFileDescriptor();
            fd = null;
            varB4EAC82CA7396A68D541C85D26508E83_224132249 = fd;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_224132249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224132249;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //data.writeString(mode);
            //mRemote.transact(IContentProvider.OPEN_FILE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            //int has = reply.readInt();
            //ParcelFileDescriptor fd = has != 0 ? reply.readFileDescriptor() : null;
            //return fd;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.016 -0400", hash_original_method = "FE6B9D37BFC5622E35633D8C501B06FF", hash_generated_method = "C7EC2675F8A91960662267485B9538EA")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1759545404 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mode);
            mRemote.transact(IContentProvider.OPEN_ASSET_FILE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            int has;
            has = reply.readInt();
            AssetFileDescriptor fd;
            fd = AssetFileDescriptor.CREATOR.createFromParcel(reply);
            fd = null;
            varB4EAC82CA7396A68D541C85D26508E83_1759545404 = fd;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1759545404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1759545404;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //data.writeString(mode);
            //mRemote.transact(IContentProvider.OPEN_ASSET_FILE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            //int has = reply.readInt();
            //AssetFileDescriptor fd = has != 0
                    //? AssetFileDescriptor.CREATOR.createFromParcel(reply) : null;
            //return fd;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.044 -0400", hash_original_method = "EF6BE11399C3C767419E53090230088A", hash_generated_method = "C3EFE6716E82B568818922C9EB81D491")
    public Bundle call(String method, String request, Bundle args) throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_306138419 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeString(method);
            data.writeString(request);
            data.writeBundle(args);
            mRemote.transact(IContentProvider.CALL_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Bundle bundle;
            bundle = reply.readBundle();
            varB4EAC82CA7396A68D541C85D26508E83_306138419 = bundle;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(method.getTaint());
        addTaint(request.getTaint());
        addTaint(args.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_306138419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_306138419;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //data.writeString(method);
            //data.writeString(request);
            //data.writeBundle(args);
            //mRemote.transact(IContentProvider.CALL_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //Bundle bundle = reply.readBundle();
            //return bundle;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.068 -0400", hash_original_method = "395B2F944828CBA26EF4C9D4B93255E5", hash_generated_method = "6C3A7C94F5600E311BA5B976CC71C970")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1347723563 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mimeTypeFilter);
            mRemote.transact(IContentProvider.GET_STREAM_TYPES_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String[] out;
            out = reply.createStringArray();
            varB4EAC82CA7396A68D541C85D26508E83_1347723563 = out;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1347723563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347723563;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //data.writeString(mimeTypeFilter);
            //mRemote.transact(IContentProvider.GET_STREAM_TYPES_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //String[] out = reply.createStringArray();
            //return out;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.070 -0400", hash_original_method = "9C6FC6B0610E79E726A369C065C9DA4C", hash_generated_method = "0D9993D5AC4AA7B1125A8B490E2E9C73")
    public AssetFileDescriptor openTypedAssetFile(Uri url, String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1990445587 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mimeType);
            data.writeBundle(opts);
            mRemote.transact(IContentProvider.OPEN_TYPED_ASSET_FILE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            int has;
            has = reply.readInt();
            AssetFileDescriptor fd;
            fd = AssetFileDescriptor.CREATOR.createFromParcel(reply);
            fd = null;
            varB4EAC82CA7396A68D541C85D26508E83_1990445587 = fd;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1990445587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1990445587;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IContentProvider.descriptor);
            //url.writeToParcel(data, 0);
            //data.writeString(mimeType);
            //data.writeBundle(opts);
            //mRemote.transact(IContentProvider.OPEN_TYPED_ASSET_FILE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            //int has = reply.readInt();
            //AssetFileDescriptor fd = has != 0
                    //? AssetFileDescriptor.CREATOR.createFromParcel(reply) : null;
            //return fd;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
}

