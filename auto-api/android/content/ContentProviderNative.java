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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.248 -0400", hash_original_method = "AF85EE1D14BCBAFA210CD4FE8D0D0EAA", hash_generated_method = "5B89B81546A27F738FE867A18D587122")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderNative() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.260 -0400", hash_original_method = "0A95D8923EFA335F625BF0735B390C42", hash_generated_method = "3C372A6D68E77D9C218FF725836EF92A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_184907646 = (super.onTransact(code, data, reply, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.262 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "1992535F0C7EB8757F965477F5292EC0")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    private static final String TAG = "ContentProvider";
}

final class ContentProviderProxy implements IContentProvider {
    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.264 -0400", hash_original_method = "EBB42AB6A7E6F2E0E7C721E0ED401456", hash_generated_method = "01F65B35CD6FE1A14A4AD664FBF19C4E")
    @DSModeled(DSC.SAFE)
    public ContentProviderProxy(IBinder remote) {
        dsTaint.addTaint(remote.dsTaint);
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.265 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "DD6FDB77557F0A5920AFCE061E8D4085")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.267 -0400", hash_original_method = "E2AF136D03A7F093E9BB31072F6BF55F", hash_generated_method = "160D2A08801B7731473A595F60061185")
    @DSModeled(DSC.SPEC)
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection[0]);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(url.dsTaint);
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
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.269 -0400", hash_original_method = "53511528A81FA80D8FEA51649EBDE31C", hash_generated_method = "67DEF0134BF8280C4273576A2F7C2B11")
    @DSModeled(DSC.SPEC)
    public String getType(Uri url) throws RemoteException {
        dsTaint.addTaint(url.dsTaint);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.270 -0400", hash_original_method = "357B46C024ADAE1E71A2CDEC64307714", hash_generated_method = "6E259F819D569388248716FFDBBA4877")
    @DSModeled(DSC.SPEC)
    public Uri insert(Uri url, ContentValues values) throws RemoteException {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(url.dsTaint);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (Uri)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.271 -0400", hash_original_method = "C992EC82CACE6E59D7619DBD9F314166", hash_generated_method = "EBEE8CFC869BC8A41B2F0DEFFAA67E3C")
    @DSModeled(DSC.SPEC)
    public int bulkInsert(Uri url, ContentValues[] values) throws RemoteException {
        dsTaint.addTaint(values[0].dsTaint);
        dsTaint.addTaint(url.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.294 -0400", hash_original_method = "4CFA8AC0349C29482D059E42163688C7", hash_generated_method = "70BC5EF4D8B29DF02DE3F049B0E5C6B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        dsTaint.addTaint(operations.dsTaint);
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeInt(operations.size());
            {
                Iterator<ContentProviderOperation> varE9602D9F0CB9F920ADAA80E0AEDB4F89_1417742020 = (operations).iterator();
                varE9602D9F0CB9F920ADAA80E0AEDB4F89_1417742020.hasNext();
                ContentProviderOperation operation = varE9602D9F0CB9F920ADAA80E0AEDB4F89_1417742020.next();
                {
                    operation.writeToParcel(data, 0);
                } //End block
            } //End collapsed parenthetic
            mRemote.transact(IContentProvider.APPLY_BATCH_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(reply);
            ContentProviderResult[] results;
            results = reply.createTypedArray(ContentProviderResult.CREATOR);
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (ContentProviderResult[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.295 -0400", hash_original_method = "171153BCF0A5412C89BF2E4EC609D033", hash_generated_method = "AC5017E6EF2BC6C94729447327CC63FD")
    @DSModeled(DSC.SPEC)
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(url.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.310 -0400", hash_original_method = "7CDD92EB66B20F5C2AB905C31B15C465", hash_generated_method = "B87B8B26E4D176DA9B0AAB407F5A5431")
    @DSModeled(DSC.SPEC)
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(url.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.322 -0400", hash_original_method = "D396B7AA54F286AF30F0B787DF60D2FE", hash_generated_method = "3E4BEC4F10B6DAA6D2D60860E69A3C49")
    @DSModeled(DSC.SPEC)
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(mode);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (ParcelFileDescriptor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.325 -0400", hash_original_method = "FE6B9D37BFC5622E35633D8C501B06FF", hash_generated_method = "1CD7740078ACEF304B5611B6CE0CFB81")
    @DSModeled(DSC.SPEC)
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(mode);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (AssetFileDescriptor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.326 -0400", hash_original_method = "EF6BE11399C3C767419E53090230088A", hash_generated_method = "2C1BE38C181212AC58833D9713D7F43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle call(String method, String request, Bundle args) throws RemoteException {
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(request);
        dsTaint.addTaint(method);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (Bundle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.327 -0400", hash_original_method = "395B2F944828CBA26EF4C9D4B93255E5", hash_generated_method = "CD5F6C1B0BA95F1A9047ED4405E350C9")
    @DSModeled(DSC.SPEC)
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        dsTaint.addTaint(mimeTypeFilter);
        dsTaint.addTaint(url.dsTaint);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.328 -0400", hash_original_method = "9C6FC6B0610E79E726A369C065C9DA4C", hash_generated_method = "DEF1F005E9592236901B2F7A85E5D9C6")
    @DSModeled(DSC.SPEC)
    public AssetFileDescriptor openTypedAssetFile(Uri url, String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        dsTaint.addTaint(opts.dsTaint);
        dsTaint.addTaint(mimeType);
        dsTaint.addTaint(url.dsTaint);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (AssetFileDescriptor)dsTaint.getTaint();
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

