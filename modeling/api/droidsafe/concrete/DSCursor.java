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
 */

/*
 * Copyright (C) 2009 The Android Open Source Project
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

package droidsafe.concrete;
//Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.DSOnlyType;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/**
 * <P>
 * A mock {@link android.database.Cursor} class that isolates the test code from real
 * Cursor implementation.
 * </P>
 * <P>
 * All methods including ones related to querying the state of the cursor are
 * are non-functional and throw {@link java.lang.UnsupportedOperationException}.
 * </P>
 */
public class DSCursor implements Cursor {
	/**/
	
	@DSSafe(DSCat.SAFE_OTHERS)
	public DSCursor(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		addTaint(uri.getTaint());
		addTaint(projection.toString().getTaint());
		addTaint(selection.getTaint());
		addTaint(selectionArgs.toString().getTaint());
		addTaint(sortOrder.getTaint());
	}
	

	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public DSCursor(DSOnlyType dontcare) {
		
	}

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    
    public int getColumnCount() {
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    
    public int getColumnIndex(String columnName) {
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    
    public int getColumnIndexOrThrow(String columnName) {
        return getTaintInt();
    }
    
    @DSSafe(DSCat.DB_CURSOR)
    
    public String getColumnName(int columnIndex) {
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }

    @DSSafe(DSCat.DB_CURSOR)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    public String[] getColumnNames() {
        throw new UnsupportedOperationException("unimplemented mock method");
    }

    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)    
    public int getCount() {
        return getTaintInt();
    }

    @DSSafe(DSCat.SAFE_LIST)
    public boolean isNull(int columnIndex) {
        throw new UnsupportedOperationException("unimplemented mock method");
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    public int getInt(int columnIndex) {
        return getTaintInt();
    }

    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    public long getLong(int columnIndex) {
        return getTaintInt();
    }

    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource(DSSourceKind.DATABASE_INFORMATION)
    public short getShort(int columnIndex) {
        return (short)getTaintInt();
    }

    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource(DSSourceKind.DATABASE_INFORMATION)
    public float getFloat(int columnIndex) {
        return (float)getTaintDouble();
    }

    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    public double getDouble(int columnIndex) {
        return (float)getTaintDouble();
    }

    @DSSafe(DSCat.DB_CURSOR)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    public byte[] getBlob(int columnIndex) {
        byte[] blob = new byte[1];
        blob[0] = (byte)getTaintInt();
        return blob;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    public String getString(int columnIndex) {
        String ret = new String();
        ret.addTaint(this.getTaint());
        return ret;
    }
    
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSafe(DSCat.SAFE_LIST)
    public Bundle getExtras() {
        //let fallback modeling handle
        return null;
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    public int getPosition() {
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    
    public boolean isAfterLast() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    public boolean isBeforeFirst() {
        return false;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    //@DSSource(DSSourceKind.DATABASE_INFORMATION)
    public boolean isFirst() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    public boolean isLast() {
        return false;
    }

    @DSSafe(DSCat.DB_CURSOR)
    public boolean move(int offset) {
        return true;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    public boolean moveToFirst() {
        return true;
    }

    @DSSafe(DSCat.DB_CURSOR)
    public boolean moveToLast() {
        return true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    public boolean moveToNext() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public boolean moveToPrevious() {
        return false;
    }

    @DSSafe(DSCat.DB_CURSOR)
    public boolean moveToPosition(int position) {
        return false;
    }

    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        //TODO: need to add taint to the buffer, but cannot
        buffer.data[0] = (char)getTaintInt();
    }

    @DSSafe(DSCat.SAFE_LIST)
    public void deactivate() {

    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    public void close() {
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.DB_CURSOR)
    public boolean isClosed() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public boolean requery() {
        return false;
    }

    @DSSafe(DSCat.DB_CURSOR)
    public void registerContentObserver(ContentObserver observer) {
        observer.onChange(false);
    }
    
    @DSSafe(DSCat.DB_CURSOR)
    public void registerDataSetObserver(DataSetObserver observer) {
        observer.onChanged();
        observer.onInvalidated();
    }

    public Bundle respond(Bundle extras) {
        throw new UnsupportedOperationException("unimplemented mock method");
    }

    @DSSafe(DSCat.SAFE_LIST)
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @SuppressWarnings("deprecation")
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        //?? what to model here??
    }

    @DSSafe(DSCat.DB_CURSOR)
    @SuppressWarnings("deprecation")
    public void unregisterContentObserver(ContentObserver observer) {
        
    }

    @DSSafe(DSCat.DB_CURSOR)
    @SuppressWarnings("deprecation")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        
    }

    @DSSafe(DSCat.DB_CURSOR)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    public int getType(int columnIndex) {
        return 0;
    }
}
