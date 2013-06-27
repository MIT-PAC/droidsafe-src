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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.010 -0400", hash_original_method = "AF85EE1D14BCBAFA210CD4FE8D0D0EAA", hash_generated_method = "5B89B81546A27F738FE867A18D587122")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.031 -0400", hash_original_method = "0A95D8923EFA335F625BF0735B390C42", hash_generated_method = "972FF6D55C13293176E190376D40C5CA")
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_3912213 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_786254170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_786254170;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.062 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5FB5F2D87EF510DDCFAFD4CF60C74F39")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1513913462 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1513913462 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1513913462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513913462;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.063 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "F9B6CF50A3968BFD24779BA47C347A53")

    private static String TAG = "ContentProvider";
}

final class ContentProviderProxy implements IContentProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.063 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.085 -0400", hash_original_method = "EBB42AB6A7E6F2E0E7C721E0ED401456", hash_generated_method = "2C21C5B1CBD217E3A4D6464EEDE37554")
    public  ContentProviderProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.086 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "5E514A795508F64436A90DAE15B6EBE3")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_555797678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_555797678 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_555797678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_555797678;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.107 -0400", hash_original_method = "E2AF136D03A7F093E9BB31072F6BF55F", hash_generated_method = "62F67F5904AA5D5809C07A6381F8445A")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1145708103 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1145708103 = adaptor;
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
        varB4EAC82CA7396A68D541C85D26508E83_1145708103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1145708103;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.134 -0400", hash_original_method = "53511528A81FA80D8FEA51649EBDE31C", hash_generated_method = "95BA586AD8315AD5AE01A46B5CC52F49")
    public String getType(Uri url) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_605484006 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_605484006 = out;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_605484006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605484006;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.153 -0400", hash_original_method = "357B46C024ADAE1E71A2CDEC64307714", hash_generated_method = "C408F45EB4233BF78DFAC7F885E656C1")
    public Uri insert(Uri url, ContentValues values) throws RemoteException {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1549517393 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1549517393 = out;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1549517393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1549517393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.155 -0400", hash_original_method = "C992EC82CACE6E59D7619DBD9F314166", hash_generated_method = "FB0BCED6CA0E75E2E73DCD276E6289CD")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596378311 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596378311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.438 -0400", hash_original_method = "4CFA8AC0349C29482D059E42163688C7", hash_generated_method = "3C3A2C359989DC375D9EEF660D7B18B4")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1510875582 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeInt(operations.size());
            {
                Iterator<ContentProviderOperation> varE9602D9F0CB9F920ADAA80E0AEDB4F89_884153785 = (operations).iterator();
                varE9602D9F0CB9F920ADAA80E0AEDB4F89_884153785.hasNext();
                ContentProviderOperation operation = varE9602D9F0CB9F920ADAA80E0AEDB4F89_884153785.next();
                {
                    operation.writeToParcel(data, 0);
                } //End block
            } //End collapsed parenthetic
            mRemote.transact(IContentProvider.APPLY_BATCH_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(reply);
            ContentProviderResult[] results;
            results = reply.createTypedArray(ContentProviderResult.CREATOR);
            varB4EAC82CA7396A68D541C85D26508E83_1510875582 = results;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1510875582.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1510875582;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.440 -0400", hash_original_method = "171153BCF0A5412C89BF2E4EC609D033", hash_generated_method = "3E1095C2AC7B8183C97D83E0978E2E6C")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342382188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342382188;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.442 -0400", hash_original_method = "7CDD92EB66B20F5C2AB905C31B15C465", hash_generated_method = "D0184F551EDBB6B6138527E48C4860C2")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241415717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241415717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.469 -0400", hash_original_method = "D396B7AA54F286AF30F0B787DF60D2FE", hash_generated_method = "E649D74FF99A259EA900F02E472DA1AE")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_449901514 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_449901514 = fd;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_449901514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_449901514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.481 -0400", hash_original_method = "FE6B9D37BFC5622E35633D8C501B06FF", hash_generated_method = "7036ED4C94CADE112A90C3C36E2AD049")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_785595936 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_785595936 = fd;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_785595936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_785595936;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.492 -0400", hash_original_method = "EF6BE11399C3C767419E53090230088A", hash_generated_method = "A72F977DB3D17EE3A2F35EBCA1792956")
    public Bundle call(String method, String request, Bundle args) throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_748416887 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_748416887 = bundle;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(method.getTaint());
        addTaint(request.getTaint());
        addTaint(args.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_748416887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_748416887;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.502 -0400", hash_original_method = "395B2F944828CBA26EF4C9D4B93255E5", hash_generated_method = "F366E7D6F811CF8B8A6181C67B109444")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_457638522 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_457638522 = out;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_457638522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_457638522;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.524 -0400", hash_original_method = "9C6FC6B0610E79E726A369C065C9DA4C", hash_generated_method = "C52BA12543A33DBAC5629C923F4BDF4C")
    public AssetFileDescriptor openTypedAssetFile(Uri url, String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1933700391 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1933700391 = fd;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(url.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1933700391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1933700391;
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

