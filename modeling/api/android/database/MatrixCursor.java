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
 * Copyright (C) 2007 The Android Open Source Project
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
import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.727 -0500", hash_original_field = "6F6E37586C2DA7E268D812D09F34D2FE", hash_generated_field = "E79D10B9148CF1E07E28DC9A748C915B")

    private  String[] columnNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.730 -0500", hash_original_field = "24DCDE757C4239BA31902159E7305DA8", hash_generated_field = "87FB4EC33D38D4927074FCDA32A55471")

    private Object[] data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.733 -0500", hash_original_field = "3F9125B32E55F916B398762BC1BAAF2A", hash_generated_field = "810BFDF75806195B8CA1DAC6D50D1648")

    private int rowCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.735 -0500", hash_original_field = "2C1F287678DEEA09C53124BFFA9B4B72", hash_generated_field = "AC3D45A4623161E9CCA649A2C8BB13FE")

    private  int columnCount;

    /**
     * Constructs a new cursor with the given initial capacity.
     *
     * @param columnNames names of the columns, the ordering of which
     *  determines column ordering elsewhere in this cursor
     * @param initialCapacity in rows
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.738 -0500", hash_original_method = "2D581361992135FCD53B75EF54E93588", hash_generated_method = "B1E537B79598D41770319712D233687F")
    
public MatrixCursor(String[] columnNames, int initialCapacity) {
        this.columnNames = columnNames;
        this.columnCount = columnNames.length;

        if (initialCapacity < 1) {
            initialCapacity = 1;
        }

        this.data = new Object[columnCount * initialCapacity];
    }

    /**
     * Constructs a new cursor.
     *
     * @param columnNames names of the columns, the ordering of which
     *  determines column ordering elsewhere in this cursor
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.740 -0500", hash_original_method = "520E9D572328080C8A52E1417D8346F4", hash_generated_method = "139E9284A654A258F94B9F29AED42E95")
    
public MatrixCursor(String[] columnNames) {
        this(columnNames, 16);
    }

    /**
     * Gets value at the given column for the current row.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.743 -0500", hash_original_method = "A7EF9562410A67389E3E61A73FDE647E", hash_generated_method = "83BF9D0907825A7CE7604E80DF04F695")
    
private Object get(int column) {
        if (column < 0 || column >= columnCount) {
            throw new CursorIndexOutOfBoundsException("Requested column: "
                    + column + ", # of columns: " +  columnCount);
        }
        if (mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (mPos >= rowCount) {
            throw new CursorIndexOutOfBoundsException("After last row.");
        }
        return data[mPos * columnCount + column];
    }

    /**
     * Adds a new row to the end and returns a builder for that row. Not safe
     * for concurrent use.
     *
     * @return builder which can be used to set the column values for the new
     *  row
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.746 -0500", hash_original_method = "4585CF8720D3AF6A9C9A961267CD63E3", hash_generated_method = "6EEB78248D64DADEC516E022EE391724")
    
public RowBuilder newRow() {
        rowCount++;
        int endIndex = rowCount * columnCount;
        ensureCapacity(endIndex);
        int start = endIndex - columnCount;
        return new RowBuilder(start, endIndex);
    }

    /**
     * Adds a new row to the end with the given column values. Not safe
     * for concurrent use.
     *
     * @throws IllegalArgumentException if {@code columnValues.length !=
     *  columnNames.length}
     * @param columnValues in the same order as the the column names specified
     *  at cursor construction time
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.748 -0500", hash_original_method = "48B10D52D633E686D99B492C35189F09", hash_generated_method = "87F3E7DEB331588F9FEE85FE0B266C4D")
    
public void addRow(Object[] columnValues) {
        this.addTaint(columnValues[0].toString().getTaint());
        this.addTaint(columnValues[0].getTaint());
        
        if (columnValues.length != columnCount) {
            throw new IllegalArgumentException();
        }

        int start = rowCount++ * columnCount;
        ensureCapacity(start + columnCount);
        System.arraycopy(columnValues, 0, data, start, columnCount);
    }

    /**
     * Adds a new row to the end with the given column values. Not safe
     * for concurrent use.
     *
     * @throws IllegalArgumentException if {@code columnValues.size() !=
     *  columnNames.length}
     * @param columnValues in the same order as the the column names specified
     *  at cursor construction time
     */
    @DSComment("MatrixCursor is array backed data structure")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.751 -0500", hash_original_method = "30233D359459EB079BFCFD374250902B", hash_generated_method = "56703011C0300D55CE4BB4F75D9CA356")
    
public void addRow(Iterable<?> columnValues) {
        int start = rowCount * columnCount;
        int end = start + columnCount;
        ensureCapacity(end);

        if (columnValues instanceof ArrayList<?>) {
            addRow((ArrayList<?>) columnValues, start);
            return;
        }

        int current = start;
        Object[] localData = data;
        for (Object columnValue : columnValues) {
            this.addTaint(columnValue.getTaint());
            this.addTaint(columnValue.toString().getTaint());
            if (current == end) {
                // TODO: null out row?
                throw new IllegalArgumentException(
                        "columnValues.size() > columnNames.length");
            }
            localData[current++] = columnValue;
        }

        if (current != end) {
            // TODO: null out row?
            throw new IllegalArgumentException(
                    "columnValues.size() < columnNames.length");
        }

        // Increase row count here in case we encounter an exception.
        rowCount++;
    }

    /** Optimization for {@link ArrayList}. */
    @DSComment("Private Method")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.753 -0500", hash_original_method = "F5D0F3FA334A37A2680A290D6DEEBDBE", hash_generated_method = "4542ED27461748289DDD7AF553420831")
    
private void addRow(ArrayList<?> columnValues, int start) {
        int size = columnValues.size();
        if (size != columnCount) {
            throw new IllegalArgumentException("columnNames.length = "
                    + columnCount + ", columnValues.size() = " + size);
        }

        rowCount++;
        Object[] localData = data;
        for (int i = 0; i < size; i++) {
            localData[start + i] = columnValues.get(i);
            this.addTaint(columnValues.get(i).toString().getTaint());
            this.addTaint(columnValues.get(i).getTaint());
        }
    }

    /** Ensures that this cursor has enough capacity. */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.756 -0500", hash_original_method = "0FD21978EF299D1119588B65FAE6C3BE", hash_generated_method = "F9728CB00BE91D5A5FC0C8091EAAA7DA")
    
private void ensureCapacity(int size) {

    }

    // AbstractCursor implementation.

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.771 -0500", hash_original_method = "3C738FD66B9E4F046395F2884F1D431C", hash_generated_method = "BD4A1874539187257611830A3697A34B")
    
@Override
    public int getCount() {
        return rowCount;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.774 -0500", hash_original_method = "438CBE048C14BFF65A950EB22F18A5DC", hash_generated_method = "CB5FA49AB8B8C47EBAACD85747BB62B4")
    
@Override
    public String[] getColumnNames() {
        return columnNames;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.777 -0500", hash_original_method = "FF3178260B85D85D43C7EA714D59B46B", hash_generated_method = "2DBB0A17A3D1D018DA998CC6AF1F85E3")    
    @Override
    public String getString(int column) {
        String ret = new String();
        ret.addTaint(this.getTaint());
        return ret;
        /*Object value = get(column);
        if (value == null) return null;
        return new String(value.toString());*/
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.779 -0500", hash_original_method = "60FD43E3A8DF3780BF7590D38393B65C", hash_generated_method = "21D6C413E6B369027128722715946B85")
    
@Override
    public short getShort(int column) {
        return (short)this.getTaintInt();
        /*  Object value = get(column);
        if (value == null) return 0;
        if (value instanceof Number) return ((Number) value).shortValue();
        return Short.parseShort(value.toString());*/
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.781 -0500", hash_original_method = "20798CD66C6EBCBDA86BE86A1F5C23AA", hash_generated_method = "DA727E8C1F17999E71962CC302754E6C")
    
@Override
    public int getInt(int column) {
        return this.getTaintInt();
        /*
        Object value = get(column);
        if (value == null) return 0;
        if (value instanceof Number) return ((Number) value).intValue();
        return Integer.parseInt(value.toString());
        */
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.784 -0500", hash_original_method = "95E2F837C77BDD8697A8850547DFE4D6", hash_generated_method = "CF9F9B512084A7D31A508D7C70439556")
    
@Override
    public long getLong(int column) {
        return (long)this.getTaintInt();
        /*
        Object value = get(column);
        if (value == null) return 0;
        if (value instanceof Number) return ((Number) value).longValue();
        return Long.parseLong(value.toString());
        */
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.786 -0500", hash_original_method = "5F37DCAACCAC42556DC41D90A8D016BB", hash_generated_method = "FA4FCD5C3B1FF317413F4A6444B074A7")
    
@Override
    public float getFloat(int column) {
        return (float)getTaintDouble();
        /*
        Object value = get(column);
        if (value == null) return 0.0f;
        if (value instanceof Number) return ((Number) value).floatValue();
        return Float.parseFloat(value.toString());
        */
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.789 -0500", hash_original_method = "C2298AFC87949D13E5DEC28EBEE5D1A6", hash_generated_method = "FFFC7AAB2B4B38FEADFBD27BD10D8573")
    
@Override
    public double getDouble(int column) {
        return getTaintDouble();
        /*
        Object value = get(column);
        if (value == null) return 0.0d;
        if (value instanceof Number) return ((Number) value).doubleValue();
        return Double.parseDouble(value.toString());
        */
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.791 -0500", hash_original_method = "9C5D46FB06759EAD0808F8E5E3B27C37", hash_generated_method = "88D622D24B64CFBE5969609A61CBC5C2")
    
@Override
    public byte[] getBlob(int column) {
        byte[] ret = new byte[1];
        ret[0] = (byte)getTaintInt();
        return ret;
        /*
        Object value = get(column);
        return (byte[]) value;
        */
    }

    @DSSafe(DSCat.DB_CURSOR)
    //@DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.794 -0500", hash_original_method = "8CE769D01E691B0A57CC7218B148D0E1", hash_generated_method = "562EF6FFF116C251F53E5B67BBE56B11")    
@Override
    public int getType(int column) {
        return DatabaseUtils.getTypeOfObject(get(column));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.796 -0500", hash_original_method = "8D2032D2DB514B96136D4116CF16B3F3", hash_generated_method = "B81C70EFA0BC591581342770CC218C3A")
    
@Override
    public boolean isNull(int column) {
        return get(column) == null;
    }
    
    public class RowBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.759 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

        private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.761 -0500", hash_original_field = "6D7F0689BD6688D0B2099E339DAE197D", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

        private  int endIndex;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.765 -0500", hash_original_method = "5B64B028890135457EF6EA7D7258F6D8", hash_generated_method = "5B64B028890135457EF6EA7D7258F6D8")
        
            RowBuilder(int index, int endIndex) {
            this.index = index;
            this.endIndex = endIndex;
        }

        /**
         * Sets the next column value in this row.
         *
         * @throws CursorIndexOutOfBoundsException if you try to add too many
         *  values
         * @return this builder to support chaining
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.768 -0500", hash_original_method = "2C7305D6C3442E9FCBF185523D5AEB72", hash_generated_method = "84DFB7AAE1500AF170EDF98A6AEE0A26")
        
public RowBuilder add(Object columnValue) {
            this.addTaint(columnValue.getTaint());
            this.addTaint(columnValue.toString().getTaint());
            if (index == endIndex) {
                throw new CursorIndexOutOfBoundsException(
                        "No more columns left.");
            }

            data[index++] = columnValue;
            return this;
        }
        
    }
    
}

