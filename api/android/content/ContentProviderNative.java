package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.564 -0400", hash_original_method = "AF85EE1D14BCBAFA210CD4FE8D0D0EAA", hash_generated_method = "5B89B81546A27F738FE867A18D587122")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.573 -0400", hash_original_method = "0A95D8923EFA335F625BF0735B390C42", hash_generated_method = "1F5CDCF2BA121C7E4CAA12953271FD12")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
        try 
        {
switch(code){
            case QUERY_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                int num = data.readInt();
                String[] projection = null;
    if(num > 0)                
                {
                    projection = new String[num];
for(int i = 0;i < num;i++)
                    {
                        projection[i] = data.readString();
                    } //End block
                } //End block
                String selection = data.readString();
                num = data.readInt();
                String[] selectionArgs = null;
    if(num > 0)                
                {
                    selectionArgs = new String[num];
for(int i = 0;i < num;i++)
                    {
                        selectionArgs[i] = data.readString();
                    } //End block
                } //End block
                String sortOrder = data.readString();
                IContentObserver observer = IContentObserver.Stub.asInterface(
                            data.readStrongBinder());
                Cursor cursor = query(url, projection, selection, selectionArgs, sortOrder);
    if(cursor != null)                
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
                } //End block
                else
                {
                    reply.writeNoException();
                    reply.writeStrongBinder(null);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1386435529 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1710431731 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1710431731;
            } //End block
            case GET_TYPE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String type = getType(url);
                reply.writeNoException();
                reply.writeString(type);
                boolean varB326B5062B2F0E69046810717534CB09_1360498102 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923804985 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_923804985;
            } //End block
            case INSERT_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues values = ContentValues.CREATOR.createFromParcel(data);
                Uri out = insert(url, values);
                reply.writeNoException();
                Uri.writeToParcel(reply, out);
                boolean varB326B5062B2F0E69046810717534CB09_1449599362 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515432938 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_515432938;
            } //End block
            case BULK_INSERT_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues[] values = data.createTypedArray(ContentValues.CREATOR);
                int count = bulkInsert(url, values);
                reply.writeNoException();
                reply.writeInt(count);
                boolean varB326B5062B2F0E69046810717534CB09_460082008 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672912767 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672912767;
            } //End block
            case APPLY_BATCH_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                final int numOperations = data.readInt();
                final ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>(numOperations);
for(int i = 0;i < numOperations;i++)
                {
                    operations.add(i, ContentProviderOperation.CREATOR.createFromParcel(data));
                } //End block
                final ContentProviderResult[] results = applyBatch(operations);
                reply.writeNoException();
                reply.writeTypedArray(results, 0);
                boolean varB326B5062B2F0E69046810717534CB09_446293795 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005373818 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005373818;
            } //End block
            case DELETE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String selection = data.readString();
                String[] selectionArgs = data.readStringArray();
                int count = delete(url, selection, selectionArgs);
                reply.writeNoException();
                reply.writeInt(count);
                boolean varB326B5062B2F0E69046810717534CB09_1074170289 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650304362 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650304362;
            } //End block
            case UPDATE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues values = ContentValues.CREATOR.createFromParcel(data);
                String selection = data.readString();
                String[] selectionArgs = data.readStringArray();
                int count = update(url, values, selection, selectionArgs);
                reply.writeNoException();
                reply.writeInt(count);
                boolean varB326B5062B2F0E69046810717534CB09_388030892 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426449709 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_426449709;
            } //End block
            case OPEN_FILE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mode = data.readString();
                ParcelFileDescriptor fd;
                fd = openFile(url, mode);
                reply.writeNoException();
    if(fd != null)                
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                else
                {
                    reply.writeInt(0);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_578557089 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551088233 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_551088233;
            } //End block
            case OPEN_ASSET_FILE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mode = data.readString();
                AssetFileDescriptor fd;
                fd = openAssetFile(url, mode);
                reply.writeNoException();
    if(fd != null)                
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                else
                {
                    reply.writeInt(0);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1252296799 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174103773 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_174103773;
            } //End block
            case CALL_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                String method = data.readString();
                String stringArg = data.readString();
                Bundle args = data.readBundle();
                Bundle responseBundle = call(method, stringArg, args);
                reply.writeNoException();
                reply.writeBundle(responseBundle);
                boolean varB326B5062B2F0E69046810717534CB09_605385802 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346559838 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_346559838;
            } //End block
            case GET_STREAM_TYPES_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mimeTypeFilter = data.readString();
                String[] types = getStreamTypes(url, mimeTypeFilter);
                reply.writeNoException();
                reply.writeStringArray(types);
                boolean varB326B5062B2F0E69046810717534CB09_1845567977 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538404134 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538404134;
            } //End block
            case OPEN_TYPED_ASSET_FILE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mimeType = data.readString();
                Bundle opts = data.readBundle();
                AssetFileDescriptor fd;
                fd = openTypedAssetFile(url, mimeType, opts);
                reply.writeNoException();
    if(fd != null)                
                {
                    reply.writeInt(1);
                    fd.writeToParcel(reply,
                                Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                else
                {
                    reply.writeInt(0);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1670897997 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182516993 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182516993;
            } //End block
}
        } //End block
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
            boolean varB326B5062B2F0E69046810717534CB09_214374901 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926025732 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_926025732;
        } //End block
        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_539953140 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172901146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_172901146;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.575 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5F5F7A8FFB31A032FC78D29D5D69B1A2")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_1036009341 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1036009341.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1036009341;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.576 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
}

final class ContentProviderProxy implements IContentProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.576 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.577 -0400", hash_original_method = "EBB42AB6A7E6F2E0E7C721E0ED401456", hash_generated_method = "2C21C5B1CBD217E3A4D6464EEDE37554")
    public  ContentProviderProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.578 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "B8D4B53477016003E7F2CC8BC29420F6")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1589169149 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1589169149.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1589169149;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.581 -0400", hash_original_method = "E2AF136D03A7F093E9BB31072F6BF55F", hash_generated_method = "46CEEF169A94358A74D4C55FF7CA24E7")
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(url.getTaint());
        BulkCursorToCursorAdaptor adaptor = new BulkCursorToCursorAdaptor();
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            int length = 0;
    if(projection != null)            
            {
                length = projection.length;
            } //End block
            data.writeInt(length);
for(int i = 0;i < length;i++)
            {
                data.writeString(projection[i]);
            } //End block
            data.writeString(selection);
    if(selectionArgs != null)            
            {
                length = selectionArgs.length;
            } //End block
            else
            {
                length = 0;
            } //End block
            data.writeInt(length);
for(int i = 0;i < length;i++)
            {
                data.writeString(selectionArgs[i]);
            } //End block
            data.writeString(sortOrder);
            data.writeStrongBinder(adaptor.getObserver().asBinder());
            mRemote.transact(IContentProvider.QUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            IBulkCursor bulkCursor = BulkCursorNative.asInterface(reply.readStrongBinder());
    if(bulkCursor != null)            
            {
                int rowCount = reply.readInt();
                int idColumnPosition = reply.readInt();
                boolean wantsAllOnMoveCalls = reply.readInt() != 0;
                adaptor.initialize(bulkCursor, rowCount, idColumnPosition, wantsAllOnMoveCalls);
            } //End block
            else
            {
                adaptor.close();
                adaptor = null;
            } //End block
Cursor var587335BAB376E50F62275F23778E8BFD_1310651850 =             adaptor;
            var587335BAB376E50F62275F23778E8BFD_1310651850.addTaint(taint);
            return var587335BAB376E50F62275F23778E8BFD_1310651850;
        } //End block
        catch (RemoteException ex)
        {
            adaptor.close();
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (RuntimeException ex)
        {
            adaptor.close();
            ex.addTaint(taint);
            throw ex;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.584 -0400", hash_original_method = "53511528A81FA80D8FEA51649EBDE31C", hash_generated_method = "D9190443C3C6D1014331B57C4E9266B9")
    public String getType(Uri url) throws RemoteException {
        addTaint(url.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            url.writeToParcel(data, 0);
            mRemote.transact(IContentProvider.GET_TYPE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String out = reply.readString();
String varFE81D892BE5757A0E16305825903D324_473592092 =             out;
            varFE81D892BE5757A0E16305825903D324_473592092.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_473592092;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.585 -0400", hash_original_method = "357B46C024ADAE1E71A2CDEC64307714", hash_generated_method = "05401AA670555E264638F9952B306E90")
    public Uri insert(Uri url, ContentValues values) throws RemoteException {
        addTaint(values.getTaint());
        addTaint(url.getTaint());
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
Uri varFE81D892BE5757A0E16305825903D324_1717951063 =             out;
            varFE81D892BE5757A0E16305825903D324_1717951063.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_1717951063;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.587 -0400", hash_original_method = "C992EC82CACE6E59D7619DBD9F314166", hash_generated_method = "4767E0DD4B9F528851B855E8904B0555")
    public int bulkInsert(Uri url, ContentValues[] values) throws RemoteException {
        addTaint(values[0].getTaint());
        addTaint(url.getTaint());
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
            int varE2942A04780E223B215EB8B663CF5353_327728280 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925769164 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925769164;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.589 -0400", hash_original_method = "4CFA8AC0349C29482D059E42163688C7", hash_generated_method = "9672DABFAC179BB55A327D68F26912AB")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        addTaint(operations.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IContentProvider.descriptor);
            data.writeInt(operations.size());
for(ContentProviderOperation operation : operations)
            {
                operation.writeToParcel(data, 0);
            } //End block
            mRemote.transact(IContentProvider.APPLY_BATCH_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(reply);
            final ContentProviderResult[] results = reply.createTypedArray(ContentProviderResult.CREATOR);
ContentProviderResult[] var238ECCC9872FFCA0B3C3DB83598FF044_856104215 =             results;
            var238ECCC9872FFCA0B3C3DB83598FF044_856104215.addTaint(taint);
            return var238ECCC9872FFCA0B3C3DB83598FF044_856104215;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.590 -0400", hash_original_method = "171153BCF0A5412C89BF2E4EC609D033", hash_generated_method = "F2062FA121AA33EED26B1E650D87F8D8")
    public int delete(Uri url, String selection, String[] selectionArgs) throws RemoteException {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(url.getTaint());
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
            int varE2942A04780E223B215EB8B663CF5353_1726243172 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806591574 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806591574;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.591 -0400", hash_original_method = "7CDD92EB66B20F5C2AB905C31B15C465", hash_generated_method = "279D22FCE8BD3061CB401C9606044FAE")
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException {
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(values.getTaint());
        addTaint(url.getTaint());
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
            int varE2942A04780E223B215EB8B663CF5353_353728587 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127201522 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127201522;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.592 -0400", hash_original_method = "D396B7AA54F286AF30F0B787DF60D2FE", hash_generated_method = "B6D414272F3C40CDB2722B8B7588871B")
    public ParcelFileDescriptor openFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(url.getTaint());
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
            ParcelFileDescriptor fd = has != 0 ? reply.readFileDescriptor() : null;
ParcelFileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_2009884490 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_2009884490.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_2009884490;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.594 -0400", hash_original_method = "FE6B9D37BFC5622E35633D8C501B06FF", hash_generated_method = "DD8650613A568135D821310E1D6FE6DF")
    public AssetFileDescriptor openAssetFile(Uri url, String mode) throws RemoteException, FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(url.getTaint());
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
            AssetFileDescriptor fd = has != 0
                    ? AssetFileDescriptor.CREATOR.createFromParcel(reply) : null;
AssetFileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_404642370 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_404642370.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_404642370;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.595 -0400", hash_original_method = "EF6BE11399C3C767419E53090230088A", hash_generated_method = "DB5FB8BC8C08F14A42DF083819CC031A")
    public Bundle call(String method, String request, Bundle args) throws RemoteException {
        addTaint(args.getTaint());
        addTaint(request.getTaint());
        addTaint(method.getTaint());
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
Bundle var7B2862195409742DCA365D8C6330AB92_535044906 =             bundle;
            var7B2862195409742DCA365D8C6330AB92_535044906.addTaint(taint);
            return var7B2862195409742DCA365D8C6330AB92_535044906;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.597 -0400", hash_original_method = "395B2F944828CBA26EF4C9D4B93255E5", hash_generated_method = "6829B12D9CCBC84C69D6538BCCEC3733")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(url.getTaint());
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
String[] varFE81D892BE5757A0E16305825903D324_78739129 =             out;
            varFE81D892BE5757A0E16305825903D324_78739129.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_78739129;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.599 -0400", hash_original_method = "9C6FC6B0610E79E726A369C065C9DA4C", hash_generated_method = "EE986A7A956E3403FE9F43F4395FE589")
    public AssetFileDescriptor openTypedAssetFile(Uri url, String mimeType, Bundle opts) throws RemoteException, FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(url.getTaint());
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
            AssetFileDescriptor fd = has != 0
                    ? AssetFileDescriptor.CREATOR.createFromParcel(reply) : null;
AssetFileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1179276837 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1179276837.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1179276837;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
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

