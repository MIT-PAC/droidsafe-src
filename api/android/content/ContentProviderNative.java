package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.content.res.AssetFileDescriptor;
import android.database.BulkCursorNative;
import android.database.BulkCursorToCursorAdaptor;
import android.database.Cursor;
import android.database.CursorToBulkCursorAdaptor;
import android.database.DatabaseUtils;
import android.database.IBulkCursor;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;





abstract public class ContentProviderNative extends Binder implements IContentProvider {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.912 -0400", hash_original_method = "AF85EE1D14BCBAFA210CD4FE8D0D0EAA", hash_generated_method = "5B89B81546A27F738FE867A18D587122")
    public  ContentProviderNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    public abstract String getProviderName();

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.920 -0400", hash_original_method = "0A95D8923EFA335F625BF0735B390C42", hash_generated_method = "4FC0EA6F74435C7EF78C3DEB6C7BF7B0")
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
                boolean varB326B5062B2F0E69046810717534CB09_1376289432 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146496552 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146496552;
            } //End block
            case GET_TYPE_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String type = getType(url);
                reply.writeNoException();
                reply.writeString(type);
                boolean varB326B5062B2F0E69046810717534CB09_1561151596 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199195985 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199195985;
            } //End block
            case INSERT_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues values = ContentValues.CREATOR.createFromParcel(data);
                Uri out = insert(url, values);
                reply.writeNoException();
                Uri.writeToParcel(reply, out);
                boolean varB326B5062B2F0E69046810717534CB09_2034199380 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182871876 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182871876;
            } //End block
            case BULK_INSERT_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                ContentValues[] values = data.createTypedArray(ContentValues.CREATOR);
                int count = bulkInsert(url, values);
                reply.writeNoException();
                reply.writeInt(count);
                boolean varB326B5062B2F0E69046810717534CB09_543240721 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_189402111 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_189402111;
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
                boolean varB326B5062B2F0E69046810717534CB09_2122674401 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104263313 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104263313;
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
                boolean varB326B5062B2F0E69046810717534CB09_2072539570 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261912941 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_261912941;
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
                boolean varB326B5062B2F0E69046810717534CB09_1195095243 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249980258 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249980258;
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
                boolean varB326B5062B2F0E69046810717534CB09_1176051695 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716491852 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716491852;
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
                boolean varB326B5062B2F0E69046810717534CB09_197019876 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156352306 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156352306;
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
                boolean varB326B5062B2F0E69046810717534CB09_916777394 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077293652 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077293652;
            } //End block
            case GET_STREAM_TYPES_TRANSACTION:
            {
                data.enforceInterface(IContentProvider.descriptor);
                Uri url = Uri.CREATOR.createFromParcel(data);
                String mimeTypeFilter = data.readString();
                String[] types = getStreamTypes(url, mimeTypeFilter);
                reply.writeNoException();
                reply.writeStringArray(types);
                boolean varB326B5062B2F0E69046810717534CB09_742481689 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471673826 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_471673826;
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
                boolean varB326B5062B2F0E69046810717534CB09_1313860324 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665494761 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665494761;
            } //End block
}
        } //End block
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
            boolean varB326B5062B2F0E69046810717534CB09_1101000336 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186855526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186855526;
        } //End block
        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_1020477722 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279904748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_279904748;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.924 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "9C283933AEA953AABDC77F3FBE2B0401")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_1864939486 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1864939486.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1864939486;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.924 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
}

final class ContentProviderProxy implements IContentProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.924 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.925 -0400", hash_original_method = "EBB42AB6A7E6F2E0E7C721E0ED401456", hash_generated_method = "2C21C5B1CBD217E3A4D6464EEDE37554")
    public  ContentProviderProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.926 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "254F942AFBF5A5476BEF28377BC55F40")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1435617513 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1435617513.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1435617513;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.929 -0400", hash_original_method = "E2AF136D03A7F093E9BB31072F6BF55F", hash_generated_method = "D2A5090E9CEA394C9393A843CEDADDE0")
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
Cursor var587335BAB376E50F62275F23778E8BFD_677962420 =             adaptor;
            var587335BAB376E50F62275F23778E8BFD_677962420.addTaint(taint);
            return var587335BAB376E50F62275F23778E8BFD_677962420;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.932 -0400", hash_original_method = "53511528A81FA80D8FEA51649EBDE31C", hash_generated_method = "F13E68D5368112B64512DD0DED3BDA8A")
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
String varFE81D892BE5757A0E16305825903D324_1754644948 =             out;
            varFE81D892BE5757A0E16305825903D324_1754644948.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_1754644948;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.934 -0400", hash_original_method = "357B46C024ADAE1E71A2CDEC64307714", hash_generated_method = "F7E0A9014654924146A053B62205CCB8")
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
Uri varFE81D892BE5757A0E16305825903D324_1306846479 =             out;
            varFE81D892BE5757A0E16305825903D324_1306846479.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_1306846479;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.935 -0400", hash_original_method = "C992EC82CACE6E59D7619DBD9F314166", hash_generated_method = "ADC2B74EE0BE1FB83B264F37C6883842")
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
            int varE2942A04780E223B215EB8B663CF5353_957610852 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983475838 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983475838;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.937 -0400", hash_original_method = "4CFA8AC0349C29482D059E42163688C7", hash_generated_method = "738D584AAA34252C3985A77868CBF516")
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
ContentProviderResult[] var238ECCC9872FFCA0B3C3DB83598FF044_602576263 =             results;
            var238ECCC9872FFCA0B3C3DB83598FF044_602576263.addTaint(taint);
            return var238ECCC9872FFCA0B3C3DB83598FF044_602576263;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.939 -0400", hash_original_method = "171153BCF0A5412C89BF2E4EC609D033", hash_generated_method = "B7BD519CEC8647EB236822E445139684")
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
            int varE2942A04780E223B215EB8B663CF5353_1427791529 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1518401832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1518401832;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.941 -0400", hash_original_method = "7CDD92EB66B20F5C2AB905C31B15C465", hash_generated_method = "112599FCDA3C1D8C96620C8478E025A6")
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
            int varE2942A04780E223B215EB8B663CF5353_858856111 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901144910 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901144910;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.943 -0400", hash_original_method = "D396B7AA54F286AF30F0B787DF60D2FE", hash_generated_method = "57A9E89999698EAE8061088FBB556E7C")
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
ParcelFileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1853787930 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1853787930.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1853787930;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.945 -0400", hash_original_method = "FE6B9D37BFC5622E35633D8C501B06FF", hash_generated_method = "D386474F2D206E660FA6FBC8217A4590")
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
AssetFileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1792760399 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1792760399.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1792760399;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.946 -0400", hash_original_method = "EF6BE11399C3C767419E53090230088A", hash_generated_method = "7A7BA54CFE2989CBCF0C095D48BEC9A0")
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
Bundle var7B2862195409742DCA365D8C6330AB92_1553084680 =             bundle;
            var7B2862195409742DCA365D8C6330AB92_1553084680.addTaint(taint);
            return var7B2862195409742DCA365D8C6330AB92_1553084680;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.948 -0400", hash_original_method = "395B2F944828CBA26EF4C9D4B93255E5", hash_generated_method = "8B10F0A23EBBF4EF9F7B7CFD1F153C82")
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
String[] varFE81D892BE5757A0E16305825903D324_238961094 =             out;
            varFE81D892BE5757A0E16305825903D324_238961094.addTaint(taint);
            return varFE81D892BE5757A0E16305825903D324_238961094;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.949 -0400", hash_original_method = "9C6FC6B0610E79E726A369C065C9DA4C", hash_generated_method = "A684C9544481522EDE42A4EA7C55A18A")
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
AssetFileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1265784303 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1265784303.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1265784303;
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

