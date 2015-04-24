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


package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IBulkCursor extends IInterface  {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CursorWindow getWindow(int startPos) throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void onMove(int position) throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int count() throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String[] getColumnNames() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void deactivate() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void close() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int requery(IContentObserver observer) throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean getWantsAllOnMoveCalls() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Bundle getExtras() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Bundle respond(Bundle extras) throws RemoteException;
    
    static final String descriptor = "android.content.IBulkCursor";

    static final int GET_CURSOR_WINDOW_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION;
    static final int COUNT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 1;
    static final int GET_COLUMN_NAMES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 2;
    static final int DEACTIVATE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 5;
    static final int REQUERY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 6;
    static final int ON_MOVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 7;
    static final int WANTS_ON_MOVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 8;
    static final int GET_EXTRAS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 9;
    static final int RESPOND_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 10;
    static final int CLOSE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 11;
}
