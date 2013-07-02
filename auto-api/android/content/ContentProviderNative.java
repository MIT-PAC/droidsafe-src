package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.465 -0400", hash_original_method = "AF85EE1D14BCBAFA210CD4FE8D0D0EAA", hash_generated_method = "5B89B81546A27F738FE867A18D587122")
    public  ContentProviderNative() {
        attachInterface(this, descriptor);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.469 -0400", hash_original_method = "0A95D8923EFA335F625BF0735B390C42", hash_generated_method = "9ADEDA57E061CB3A8B03F34271A85B57")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        
        try 
        {
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                int num = data.readInt();
                String[] projection = null;
                {
                    projection = new String[num];
                    {
                        int i = 0;
                        {
                            projection[i] = data.readString();
                        } 
                    } 
                } 
                String selection = data.readString();
                num = data.readInt();
                String[] selectionArgs = null;
                {
                    selectionArgs = new String[num];
                    {
                        int i = 0;
                        {
                            selectionArgs[i] = data.readString();
                        } 
                    } 
                } 
                String sortOrder = data.readString();
                IContentObserver observer = IContentObserver.Stub.asInterface(
                            data.readStrongBinder());
                Cursor cursor = query(url, projection, selection, selectionArgs, sortOrder);
                {
                    CursorToBulkCursorAdaptor adaptor = new CursorToBulkCursorAdaptor(
                                cursor, observer, getProviderName());
                    final IBinder binder = adaptor.asBinder();
                    final int count = adaptor.count();
                    final int index = BulkCursorToCursorAdaptor.findRowIdColumnIndex(
                                adaptor.getColumnNames());
                    final boolean wantsAllOnMoveCalls = adaptor.getWantsAllOnMoveCalls();
                    reply.writeNoException();
                    reply.writeStrongBinder(binder);
                    reply.writeInt(count);
                    reply.writeInt(index);
                    reply.writeInt(wantsAllOnMoveCalls ? 1 : 0);
                } 
                {
                    reply.writeNoException();
                    reply.writeStrongBinder(null);
                } 
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String type = getType(url);
                reply.writeNoException();
                reply.writeString(type);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues values = ContentValues.CREATOR.createFromParcel(data);
                Uri out = insert(url, values);
                reply.writeNoException();
                Uri.writeToParcel(reply, out);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues[] values = data.createTypedArray(ContentValues.CREATOR);
                int count = bulkInsert(url, values);
                reply.writeNoException();
                reply.writeInt(count);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                final int numOperations = data.readInt();
                final ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>(numOperations);
                {
                    int i = 0;
                    {
                        operations.add(i, ContentProviderOperation.CREATOR.createFromParcel(data));
                    } 
                } 
                final ContentProviderResult[] results = applyBatch(operations);
                reply.writeNoException();
                reply.writeTypedArray(results, 0);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String selection = data.readString();
                String[] selectionArgs = data.readStringArray();
                int count = delete(url, selection, selectionArgs);
                reply.writeNoException();
                reply.writeInt(count);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues values = ContentValues.CREATOR.createFromParcel(data);
                String selection = data.readString();
                String[] selectionArgs = data.readStringArray();
                int count = update(url, values, selection, selectionArgs);
                reply.writeNoException();
                reply.writeInt(count);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mode = data.readString();
                ParcelFileDescriptor fd;
                fd = openFile(url, mode);
                reply.writeNoException();
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } 
                {
                    reply.writeInt(0);
                } 
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mode = data.readString();
                AssetFileDescriptor fd;
                fd = openAssetFile(url, mode);
                reply.writeNoException();
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } 
                {
                    reply.writeInt(0);
                } 
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                String method = data.readString();
                String stringArg = data.readString();
                Bundle args = data.readBundle();
                Bundle responseBundle = call(method, stringArg, args);
                reply.writeNoException();
                reply.writeBundle(responseBundle);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mimeTypeFilter = data.readString();
                String[] types = getStreamTypes(url, mimeTypeFilter);
                reply.writeNoException();
                reply.writeStringArray(types);
            } 
            
            
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mimeType = data.readString();
                Bundle opts = data.readBundle();
                AssetFileDescriptor fd;
                fd = openTypedAssetFile(url, mimeType, opts);
                reply.writeNoException();
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } 
                {
                    reply.writeInt(0);
                } 
            } 
            
        } 
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
        } 
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_678755487 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049740935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049740935;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.470 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "153BEFFB183AE626B86E971892F0EC51")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1824970526 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1824970526 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1824970526.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1824970526;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.470 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
}

final class ContentProviderProxy implements IContentProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.470 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.471 -0400", hash_original_method = "EBB42AB6A7E6F2E0E7C721E0ED401456", hash_generated_method = "2C21C5B1CBD217E3A4D6464EEDE37554")
    public  ContentProviderProxy(IBinder remote) {
        mRemote = remote;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.472 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "8CDA5669F86D45D7FA560C328BAFC589")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1430763592 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1430763592 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_1430763592.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1430763592;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.474 -0400", hash_original_method = "E2AF136D03A7F093E9BB31072F6BF55F", hash_generated_method = "3B6C750BC6169E31556D3776E4A3A000")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_486716008 = null; 
        BulkCursorToCursorAdaptor adaptor = new BulkCursorToCursorAdaptor();
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            int length = 0;
            {
                length = projection.length;
            } 
            data.writeInt(length);
            {
                int i = 0;
                {
                    data.writeString(projection[i]);
                } 
            } 
            data.writeString(selection);
            {
                length = selectionArgs.length;
            } 
            {
                length = 0;
            } 
            data.writeInt(length);
            {
                int i = 0;
                {
                    data.writeString(selectionArgs[i]);
                } 
            } 
            data.writeString(sortOrder);
            data.writeStrongBinder(adaptor.getObserver().asBinder());
            mRemote.transact(IContentProvider.QUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            IBulkCursor bulkCursor = BulkCursorNative.asInterface(reply.readStrongBinder());
            {
                int rowCount = reply.readInt();
                int idColumnPosition = reply.readInt();
                boolean wantsAllOnMoveCalls = reply.readInt() != 0;
                adaptor.initialize(bulkCursor, rowCount, idColumnPosition, wantsAllOnMoveCalls);
            } 
            {
                adaptor.close();
                adaptor = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_486716008 = adaptor;
        } 
        catch (RemoteException ex)
        {
            adaptor.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (RuntimeException ex)
        {
            adaptor.close();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_486716008.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_486716008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.475 -0400", hash_original_method = "53511528A81FA80D8FEA51649EBDE31C", hash_generated_method = "9A83DB00A696365FCC1CEA6F57CD734C")
    public String getType(Uri url) throws RemoteException {
        String varB4EAC82CA7396A68D541C85D26508E83_967634378 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            mRemote.transact(IContentProvider.GET_TYPE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String out = reply.readString();
            varB4EAC82CA7396A68D541C85D26508E83_967634378 = out;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_967634378.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_967634378;
        
        
        
        
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.476 -0400", hash_original_method = "357B46C024ADAE1E71A2CDEC64307714", hash_generated_method = "F79B9DAF001468C3DB6B06B67404FC48")
    public Uri insert(Uri url, ContentValues values) throws RemoteException {
        Uri varB4EAC82CA7396A68D541C85D26508E83_316061821 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            values.writeToParcel(data, 0);
            mRemote.transact(IContentProvider.INSERT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Uri out = Uri.CREATOR.createFromParcel(reply);
            varB4EAC82CA7396A68D541C85D26508E83_316061821 = out;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_316061821.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_316061821;
        
        
        
        
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.476 -0400", hash_original_method = "C992EC82CACE6E59D7619DBD9F314166", hash_generated_method = "58B042C0D0F392B1F4E6BFC85F46173C")
    public int bulkInsert(Uri url, ContentValues[] values) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeTypedArray(values, 0);
            mRemote.transact(IContentProvider.BULK_INSERT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count = reply.readInt();
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(values[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754318950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754318950;
        
        
        
        
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.490 -0400", hash_original_method = "4CFA8AC0349C29482D059E42163688C7", hash_generated_method = "68C5F4AD4BBD011A76D00AA966127B0C")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1170917264 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeInt(operations.size());
            {
                Iterator<ContentProviderOperation> varE9602D9F0CB9F920ADAA80E0AEDB4F89_252708152 = (operations).iterator();
                varE9602D9F0CB9F920ADAA80E0AEDB4F89_252708152.hasNext();
                ContentProviderOperation operation = varE9602D9F0CB9F920ADAA80E0AEDB4F89_252708152.next();
                {
                    operation.writeToParcel(data, 0);
                } 
            } 
            mRemote.transact(IContentProvider.APPLY_BATCH_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(reply);
            final ContentProviderResult[] results = reply.createTypedArray(ContentProviderResult.CREATOR);
            varB4EAC82CA7396A68D541C85D26508E83_1170917264 = results;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1170917264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1170917264;
        
        
        
        
            
            
            
                
            
            
            
            
                    
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.491 -0400", hash_original_method = "171153BCF0A5412C89BF2E4EC609D033", hash_generated_method = "7AC6520224AF133AF675AC97A4F49583")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(selection);
            data.writeStringArray(selectionArgs);
            mRemote.transact(IContentProvider.DELETE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count = reply.readInt();
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952722547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952722547;
        
        
        
        
            
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.491 -0400", hash_original_method = "7CDD92EB66B20F5C2AB905C31B15C465", hash_generated_method = "5E82BF1FA3884BD75CE7D0C084E501CD")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            values.writeToParcel(data, 0);
            data.writeString(selection);
            data.writeStringArray(selectionArgs);
            mRemote.transact(IContentProvider.UPDATE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count = reply.readInt();
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038994386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038994386;
        
        
        
        
            
            
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.493 -0400", hash_original_method = "D396B7AA54F286AF30F0B787DF60D2FE", hash_generated_method = "4FB5D5563398000471ABF53B7BE3E842")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_169028878 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mode);
            mRemote.transact(IContentProvider.OPEN_FILE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            int has = reply.readInt();
            ParcelFileDescriptor fd;
            fd = reply.readFileDescriptor();
            fd = null;
            varB4EAC82CA7396A68D541C85D26508E83_169028878 = fd;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_169028878.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_169028878;
        
        
        
        
            
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.495 -0400", hash_original_method = "FE6B9D37BFC5622E35633D8C501B06FF", hash_generated_method = "5DFC1FF7AB0AD5F93D7FDBA6FD171400")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1596928196 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mode);
            mRemote.transact(IContentProvider.OPEN_ASSET_FILE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            int has = reply.readInt();
            AssetFileDescriptor fd;
            fd = AssetFileDescriptor.CREATOR.createFromParcel(reply);
            fd = null;
            varB4EAC82CA7396A68D541C85D26508E83_1596928196 = fd;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1596928196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1596928196;
        
        
        
        
            
            
            
            
            
            
            
                    
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.496 -0400", hash_original_method = "EF6BE11399C3C767419E53090230088A", hash_generated_method = "5AB5C13D337334A0C9EBCD3A2224F30B")
    public Bundle call(String method, String request, Bundle args) throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_712151736 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeString(method);
            data.writeString(request);
            data.writeBundle(args);
            mRemote.transact(IContentProvider.CALL_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Bundle bundle = reply.readBundle();
            varB4EAC82CA7396A68D541C85D26508E83_712151736 = bundle;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(method.getTaint());
        addTaint(request.getTaint());
        addTaint(args.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_712151736.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_712151736;
        
        
        
        
            
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.498 -0400", hash_original_method = "395B2F944828CBA26EF4C9D4B93255E5", hash_generated_method = "8E45A8D6D6CEB98B00DEFD9A18492ED0")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1292235272 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mimeTypeFilter);
            mRemote.transact(IContentProvider.GET_STREAM_TYPES_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String[] out = reply.createStringArray();
            varB4EAC82CA7396A68D541C85D26508E83_1292235272 = out;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1292235272.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1292235272;
        
        
        
        
            
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.499 -0400", hash_original_method = "9C6FC6B0610E79E726A369C065C9DA4C", hash_generated_method = "D2CA52E30938FE06A10B7ECFDA92E819")
    public AssetFileDescriptor openTypedAssetFile(Uri url, String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_869646776 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            data.writeString(mimeType);
            data.writeBundle(opts);
            mRemote.transact(IContentProvider.OPEN_TYPED_ASSET_FILE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(reply);
            int has = reply.readInt();
            AssetFileDescriptor fd;
            fd = AssetFileDescriptor.CREATOR.createFromParcel(reply);
            fd = null;
            varB4EAC82CA7396A68D541C85D26508E83_869646776 = fd;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(url.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_869646776.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_869646776;
        
        
        
        
            
            
            
            
            
            
            
            
                    
            
        
            
            
        
    }

    
}

