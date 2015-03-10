/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


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
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public interface IContentProvider extends IInterface {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Cursor query(Uri url, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getType(Uri url) throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Uri insert(Uri url, ContentValues initialValues)
            throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int bulkInsert(Uri url, ContentValues[] initialValues) throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int delete(Uri url, String selection, String[] selectionArgs)
            throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int update(Uri url, ContentValues values, String selection,
            String[] selectionArgs) throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ParcelFileDescriptor openFile(Uri url, String mode)
            throws RemoteException, FileNotFoundException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public AssetFileDescriptor openAssetFile(Uri url, String mode)
            throws RemoteException, FileNotFoundException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations)
            throws RemoteException, OperationApplicationException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Bundle call(String method, String arg, Bundle extras) throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) throws RemoteException;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public AssetFileDescriptor openTypedAssetFile(Uri url, String mimeType, Bundle opts)
            throws RemoteException, FileNotFoundException;
    
    static final String descriptor = "android.content.IContentProvider";

    static final int QUERY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION;
    static final int GET_TYPE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 1;
    static final int INSERT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 2;
    static final int DELETE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 3;
    static final int UPDATE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 9;
    static final int BULK_INSERT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 12;
    static final int OPEN_FILE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 13;
    static final int OPEN_ASSET_FILE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 14;
    static final int APPLY_BATCH_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 19;
    static final int CALL_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 20;
    static final int GET_STREAM_TYPES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 21;
    static final int OPEN_TYPED_ASSET_FILE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 22;
}
