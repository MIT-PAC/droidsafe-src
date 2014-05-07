package com.android.internal.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.DataSetObserver;

public class SortCursor extends AbstractCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.127 -0500", hash_original_field = "9863E31CC2BF85E7B9BD485B71FAF6FD", hash_generated_field = "724293D7D77BA8225464183EA8F32F1E")

    private static final String TAG = "SortCursor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.129 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.132 -0500", hash_original_field = "BFC46F58E76AA74F65A9C26229E79F96", hash_generated_field = "0942DA24BE4E32B4E9FADB0B3647107E")

    private Cursor[] mCursors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.135 -0500", hash_original_field = "B1A8A0E91C1EFC31160B80CBCD4ACE7E", hash_generated_field = "6D5DF8C8DEA35609A5360D89C13E26BF")

    private int [] mSortColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.137 -0500", hash_original_field = "E7F2DD199CD8AB4C9B0D4765A2D3C0F7", hash_generated_field = "2E5513FA4ED58574F469A99A551852C8")

    private final int ROWCACHESIZE = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.139 -0500", hash_original_field = "CC08B5D1188DB79EF78A0776D1554A14", hash_generated_field = "BA2C3C517B65A42073A469041F1236B3")

    private int mRowNumCache[] = new int[ROWCACHESIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.141 -0500", hash_original_field = "3F8F11250ECE1184FB5BB2762224537A", hash_generated_field = "6AFA154E6AAB3B01C4D4DD70762095F0")

    private int mCursorCache[] = new int[ROWCACHESIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.144 -0500", hash_original_field = "B5F13E26F0779DDCBC2E194B27F514EE", hash_generated_field = "5F9A00FA72E61382BFC46ECE8BC96174")

    private int mCurRowNumCache[][];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.146 -0500", hash_original_field = "2EBB6F0453C294C0936CFA563608D0D4", hash_generated_field = "E17346E94ED9C398F5D9E40D8CEFB2B0")

    private int mLastCacheHit = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.153 -0400", hash_original_field = "FA2BE9015D45FC980588BB7AE26DD67B", hash_generated_field = "048753E2CDF770795AC102E0124AD2AB")

    private DataSetObserver mObserver = new DataSetObserver() {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.149 -0500", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "AE1F091769F4914FA814B6CB3FCBC73F")
        
@Override
        public void onChanged() {
            // Reset our position so the optimizations in move-related code
            // don't screw us over
            mPos = -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.152 -0500", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "64D28911E57466DBCD10697DB3A6E99B")
        
@Override
        public void onInvalidated() {
            mPos = -1;
        }
        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.158 -0500", hash_original_method = "64551E04019BE286A932EE113C90B39D", hash_generated_method = "9000F9D25747B54CE37C1854CC21001F")
    
public SortCursor(Cursor[] cursors, String sortcolumn)
    {
        mCursors = cursors;

        int length = mCursors.length;
        mSortColumns = new int[length];
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] == null) continue;
            
            // Register ourself as a data set observer
            mCursors[i].registerDataSetObserver(mObserver);
            
            mCursors[i].moveToFirst();

            // We don't catch the exception
            mSortColumns[i] = mCursors[i].getColumnIndexOrThrow(sortcolumn);
        }
        mCursor = null;
        String smallest = "";
        for (int j = 0 ; j < length; j++) {
            if (mCursors[j] == null || mCursors[j].isAfterLast())
                continue;
            String current = mCursors[j].getString(mSortColumns[j]);
            if (mCursor == null || current.compareToIgnoreCase(smallest) < 0) {
                smallest = current;
                mCursor = mCursors[j];
            }
        }

        for (int i = mRowNumCache.length - 1; i >= 0; i--) {
            mRowNumCache[i] = -2;
        }
        mCurRowNumCache = new int[ROWCACHESIZE][length];
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.161 -0500", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "E2DA0373B706ED60B98BB7FB33055AE0")
    
@Override
    public int getCount()
    {
        int count = 0;
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                count += mCursors[i].getCount();
            }
        }
        return count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.164 -0500", hash_original_method = "84C72ACE5D5A745A5633B3A38CCC072D", hash_generated_method = "E0D83424343495B41FAD26F02CD74CBA")
    
@Override
    public boolean onMove(int oldPosition, int newPosition)
    {
        if (oldPosition == newPosition)
            return true;

        /* Find the right cursor
         * Because the client of this cursor (the listadapter/view) tends
         * to jump around in the cursor somewhat, a simple cache strategy
         * is used to avoid having to search all cursors from the start.
         * TODO: investigate strategies for optimizing random access and
         * reverse-order access.
         */

        int cache_entry = newPosition % ROWCACHESIZE;

        if (mRowNumCache[cache_entry] == newPosition) {
            int which = mCursorCache[cache_entry];
            mCursor = mCursors[which];
            if (mCursor == null) {
                Log.w(TAG, "onMove: cache results in a null cursor.");
                return false;
            }
            mCursor.moveToPosition(mCurRowNumCache[cache_entry][which]);
            mLastCacheHit = cache_entry;
            return true;
        }

        mCursor = null;
        int length = mCursors.length;

        if (mLastCacheHit >= 0) {
            for (int i = 0; i < length; i++) {
                if (mCursors[i] == null) continue;
                mCursors[i].moveToPosition(mCurRowNumCache[mLastCacheHit][i]);
            }
        }

        if (newPosition < oldPosition || oldPosition == -1) {
            for (int i = 0 ; i < length; i++) {
                if (mCursors[i] == null) continue;
                mCursors[i].moveToFirst();
            }
            oldPosition = 0;
        }
        if (oldPosition < 0) {
            oldPosition = 0;
        }

        // search forward to the new position
        int smallestIdx = -1;
        for(int i = oldPosition; i <= newPosition; i++) {
            String smallest = "";
            smallestIdx = -1;
            for (int j = 0 ; j < length; j++) {
                if (mCursors[j] == null || mCursors[j].isAfterLast()) {
                    continue;
                }
                String current = mCursors[j].getString(mSortColumns[j]);
                if (smallestIdx < 0 || current.compareToIgnoreCase(smallest) < 0) {
                    smallest = current;
                    smallestIdx = j;
                }
            }
            if (i == newPosition) break;
            if (mCursors[smallestIdx] != null) {
                mCursors[smallestIdx].moveToNext();
            }
        }
        mCursor = mCursors[smallestIdx];
        mRowNumCache[cache_entry] = newPosition;
        mCursorCache[cache_entry] = smallestIdx;
        for (int i = 0; i < length; i++) {
            if (mCursors[i] != null) {
                mCurRowNumCache[cache_entry][i] = mCursors[i].getPosition();
            }
        }
        mLastCacheHit = -1;
        return true;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.166 -0500", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "ED07F326C66A892800FB63C8FCD37B48")
    
@Override
    public String getString(int column)
    {
        return mCursor.getString(column);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.169 -0500", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "7EEB726C0B341CEB5DDFEAB5EBA9B598")
    
@Override
    public short getShort(int column)
    {
        return mCursor.getShort(column);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.171 -0500", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "C28D8796BE04004FA31D5BCAE54426AF")
    
@Override
    public int getInt(int column)
    {
        return mCursor.getInt(column);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.173 -0500", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "9237FC8AD54C22425AC591AF532E0CF4")
    
@Override
    public long getLong(int column)
    {
        return mCursor.getLong(column);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.176 -0500", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "CA828043A5B9695000514DFE1A935D65")
    
@Override
    public float getFloat(int column)
    {
        return mCursor.getFloat(column);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.178 -0500", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "9FE0CB8D8CA2F42105E397AC4001F939")
    
@Override
    public double getDouble(int column)
    {
        return mCursor.getDouble(column);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.181 -0500", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "77FBE8C5B4CFC8958A0D479BC66DDA83")
    
@Override
    public int getType(int column) {
        return mCursor.getType(column);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.184 -0500", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "0E700442205B809B3ED3313970769265")
    
@Override
    public boolean isNull(int column)
    {
        return mCursor.isNull(column);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.186 -0500", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "8C73EB5E7F8882B29B28A306EBBD8727")
    
@Override
    public byte[] getBlob(int column)
    {
        return mCursor.getBlob(column);   
    }
    
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.189 -0500", hash_original_method = "FABBE77F00A0F54771EB01C7CA2B1BF3", hash_generated_method = "E2505EC0B33F98A1EFCA150436ED4A1F")
    
@Override
    public String[] getColumnNames()
    {
        if (mCursor != null) {
            return mCursor.getColumnNames();
        } else {
            // All of the cursors may be empty, but they can still return
            // this information.
            int length = mCursors.length;
            for (int i = 0 ; i < length ; i++) {
                if (mCursors[i] != null) {
                    return mCursors[i].getColumnNames();
                }
            }
            throw new IllegalStateException("No cursor that can return names");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.191 -0500", hash_original_method = "151ECE452A0E4CEB4F2D2BADB62BF062", hash_generated_method = "23EFC5DD0D03F7C0D195B0035B8920BA")
    
@Override
    public void deactivate()
    {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] == null) continue;
            mCursors[i].deactivate();
        }
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.194 -0500", hash_original_method = "78F095A0FFEE3E0B5C15F16DE0B8AED8", hash_generated_method = "CF1FC83A1950C2FD403ADF9C35390EB8")
    
@Override
    public void close() {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] == null) continue;
            mCursors[i].close();
        }
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.196 -0500", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "9F371C5FA059F5D78543BB6E762EC5D8")
    
@Override
    public void registerDataSetObserver(DataSetObserver observer) {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].registerDataSetObserver(observer);
            }
        }
    }
    
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.199 -0500", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "36BE971EF7BD55D636EF54D72E480F3A")
    
@Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] != null) {
                mCursors[i].unregisterDataSetObserver(observer);
            }
        }
    }
    
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:28.201 -0500", hash_original_method = "3BA588146C61870E37BC59410D39661D", hash_generated_method = "86AA6A890F714127B29E4F8CED4FED83")
    
@Override
    public boolean requery()
    {
        int length = mCursors.length;
        for (int i = 0 ; i < length ; i++) {
            if (mCursors[i] == null) continue;
            
            if (mCursors[i].requery() == false) {
                return false;
            }
        }

        return true;
    }
}

