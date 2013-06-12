package com.android.internal.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.util.Log;

public class SortCursor extends AbstractCursor {
    private static String TAG = "SortCursor";
    private Cursor mCursor;
    private Cursor[] mCursors;
    private int [] mSortColumns;
    private int ROWCACHESIZE = 64;
    private int mRowNumCache[] = new int[ROWCACHESIZE];
    private int mCursorCache[] = new int[ROWCACHESIZE];
    private int mCurRowNumCache[][];
    private int mLastCacheHit = -1;
    private DataSetObserver mObserver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.220 -0400", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "6797C1DC01A9B079691DB15E9037268D")
        @DSModeled(DSC.SAFE)
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.279 -0400", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "F5223AAC72736FB497B67DFFB9CEB15B")
        @DSModeled(DSC.SAFE)
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.339 -0400", hash_original_method = "64551E04019BE286A932EE113C90B39D", hash_generated_method = "DA279E33C245FA38986D700A8DBF7F84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SortCursor(Cursor[] cursors, String sortcolumn) {
        dsTaint.addTaint(sortcolumn);
        dsTaint.addTaint(cursors[0].dsTaint);
        int length;
        length = mCursors.length;
        mSortColumns = new int[length];
        {
            int i;
            i = 0;
            {
                mCursors[i].registerDataSetObserver(mObserver);
                mCursors[i].moveToFirst();
                mSortColumns[i] = mCursors[i].getColumnIndexOrThrow(sortcolumn);
            } //End block
        } //End collapsed parenthetic
        mCursor = null;
        String smallest;
        smallest = "";
        {
            int j;
            j = 0;
            {
                {
                    boolean varA9466E4394C65D9A7DB17A286B5DE5F6_2040722724 = (mCursors[j] == null || mCursors[j].isAfterLast());
                } //End collapsed parenthetic
                String current;
                current = mCursors[j].getString(mSortColumns[j]);
                {
                    boolean varAB045318DC4FBFE552DAACB65AA14FB1_1588278410 = (mCursor == null || current.compareToIgnoreCase(smallest) < 0);
                    {
                        smallest = current;
                        mCursor = mCursors[j];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = mRowNumCache.length - 1;
            {
                mRowNumCache[i] = -2;
            } //End block
        } //End collapsed parenthetic
        mCurRowNumCache = new int[ROWCACHESIZE][length];
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.398 -0400", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "A7D56B4A0D80CD9953075074D429296B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCount() {
        int count;
        count = 0;
        int length;
        length = mCursors.length;
        {
            int i;
            i = 0;
            {
                {
                    count += mCursors[i].getCount();
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = 0;
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //count += mCursors[i].getCount();
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.497 -0400", hash_original_method = "84C72ACE5D5A745A5633B3A38CCC072D", hash_generated_method = "B0640B3304C58FF804EFAA14F984F93A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        dsTaint.addTaint(oldPosition);
        int cache_entry;
        cache_entry = newPosition % ROWCACHESIZE;
        {
            int which;
            which = mCursorCache[cache_entry];
            mCursor = mCursors[which];
            mCursor.moveToPosition(mCurRowNumCache[cache_entry][which]);
            mLastCacheHit = cache_entry;
        } //End block
        mCursor = null;
        int length;
        length = mCursors.length;
        {
            {
                int i;
                i = 0;
                {
                    mCursors[i].moveToPosition(mCurRowNumCache[mLastCacheHit][i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    mCursors[i].moveToFirst();
                } //End block
            } //End collapsed parenthetic
            oldPosition = 0;
        } //End block
        {
            oldPosition = 0;
        } //End block
        int smallestIdx;
        smallestIdx = -1;
        {
            int i;
            i = oldPosition;
            {
                String smallest;
                smallest = "";
                smallestIdx = -1;
                {
                    int j;
                    j = 0;
                    {
                        {
                            boolean var5209BA3D7BBC41B1D8B90214BA5CA0CD_95082528 = (mCursors[j] == null || mCursors[j].isAfterLast());
                        } //End collapsed parenthetic
                        String current;
                        current = mCursors[j].getString(mSortColumns[j]);
                        {
                            boolean var0DDC49D47444A552BA1607991F6BF246_1517093410 = (smallestIdx < 0 || current.compareToIgnoreCase(smallest) < 0);
                            {
                                smallest = current;
                                smallestIdx = j;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    mCursors[smallestIdx].moveToNext();
                } //End block
            } //End block
        } //End collapsed parenthetic
        mCursor = mCursors[smallestIdx];
        mRowNumCache[cache_entry] = newPosition;
        mCursorCache[cache_entry] = smallestIdx;
        {
            int i;
            i = 0;
            {
                {
                    mCurRowNumCache[cache_entry][i] = mCursors[i].getPosition();
                } //End block
            } //End block
        } //End collapsed parenthetic
        mLastCacheHit = -1;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.538 -0400", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "FCD0C9687CA2BEDDEC44EB247E1DB5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getString(int column) {
        dsTaint.addTaint(column);
        String varDA29D5DF8E9422C47281972F09C7A299_779490206 = (mCursor.getString(column));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCursor.getString(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.547 -0400", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "AF53F9CC6DF95268D16E1DD298857567")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short getShort(int column) {
        dsTaint.addTaint(column);
        short var482088C8CBC8B13C9BCDE64446F053F2_1870730351 = (mCursor.getShort(column));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mCursor.getShort(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.566 -0400", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "7E2842BF63E470FF5D1BF8723EA1E401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getInt(int column) {
        dsTaint.addTaint(column);
        int var29097A02C3DAA488C041A02B1AAECF01_638793130 = (mCursor.getInt(column));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getInt(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.584 -0400", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "2776A4799474308E8F561EB2B36C4FBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLong(int column) {
        dsTaint.addTaint(column);
        long var10FBC10E1B8A77C92D7029C038829111_1900155041 = (mCursor.getLong(column));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCursor.getLong(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.603 -0400", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "377235E7CB6C3EC7E4C05F833215885C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float getFloat(int column) {
        dsTaint.addTaint(column);
        float varF047161646623DEED36A087E8AE02ED9_1450676531 = (mCursor.getFloat(column));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCursor.getFloat(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.621 -0400", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "28DF4C42EA0E9A6BF674041CE615C08D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double getDouble(int column) {
        dsTaint.addTaint(column);
        double var07BE23823C471CCBAE60C4004C7DD52E_891833939 = (mCursor.getDouble(column));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mCursor.getDouble(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.626 -0400", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "A1471EE610166802F4E1D4DD7B4FB1E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getType(int column) {
        dsTaint.addTaint(column);
        int varF1D78DF3F546642BF146493DA8E9220B_1572526524 = (mCursor.getType(column));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getType(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.651 -0400", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "8106D9DFCB92082C8EE5CEE5DC9351A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isNull(int column) {
        dsTaint.addTaint(column);
        boolean var7B9A7C74ED324F6753A1AF8A637F7B79_1943317500 = (mCursor.isNull(column));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isNull(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.659 -0400", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "00CC849861E93713A9BF082A5714E016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getBlob(int column) {
        dsTaint.addTaint(column);
        byte[] var6C25EFC723BCAEF220C3A70C50922D71_307650988 = (mCursor.getBlob(column));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mCursor.getBlob(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.688 -0400", hash_original_method = "FABBE77F00A0F54771EB01C7CA2B1BF3", hash_generated_method = "F0890A7043848A74C77676702D9467EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getColumnNames() {
        {
            String[] varC7830ACD2DB98FB85D5A2F4CC0B549B0_1228475661 = (mCursor.getColumnNames());
        } //End block
        {
            int length;
            length = mCursors.length;
            {
                int i;
                i = 0;
                {
                    {
                        String[] var253D05F592129B05666C09A376551002_1152962637 = (mCursors[i].getColumnNames());
                    } //End block
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No cursor that can return names");
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //return mCursor.getColumnNames();
        //} else {
            //int length = mCursors.length;
            //for (int i = 0 ; i < length ; i++) {
                //if (mCursors[i] != null) {
                    //return mCursors[i].getColumnNames();
                //}
            //}
            //throw new IllegalStateException("No cursor that can return names");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.714 -0400", hash_original_method = "151ECE452A0E4CEB4F2D2BADB62BF062", hash_generated_method = "ECAC28DDEFD0D381CED81DA55916B364")
    @DSModeled(DSC.SAFE)
    @Override
    public void deactivate() {
        int length;
        length = mCursors.length;
        {
            int i;
            i = 0;
            {
                mCursors[i].deactivate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) continue;
            //mCursors[i].deactivate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.739 -0400", hash_original_method = "78F095A0FFEE3E0B5C15F16DE0B8AED8", hash_generated_method = "7903FE6B96642D63179348312CC4DF95")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        int length;
        length = mCursors.length;
        {
            int i;
            i = 0;
            {
                mCursors[i].close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) continue;
            //mCursors[i].close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.765 -0400", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "25C668B11570E85885FAFE9DA924F41A")
    @DSModeled(DSC.SAFE)
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        int length;
        length = mCursors.length;
        {
            int i;
            i = 0;
            {
                {
                    mCursors[i].registerDataSetObserver(observer);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].registerDataSetObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.789 -0400", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "5C1AD30F80EECEC4F8BD2070C675F8ED")
    @DSModeled(DSC.SAFE)
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        int length;
        length = mCursors.length;
        {
            int i;
            i = 0;
            {
                {
                    mCursors[i].unregisterDataSetObserver(observer);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].unregisterDataSetObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:44.816 -0400", hash_original_method = "3BA588146C61870E37BC59410D39661D", hash_generated_method = "5EE7A77644F1FAFBC717726966D96F17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requery() {
        int length;
        length = mCursors.length;
        {
            int i;
            i = 0;
            {
                {
                    boolean varCC9C4B5DBC63969D74560FBC7DF097D9_840127707 = (mCursors[i].requery() == false);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) continue;
            //if (mCursors[i].requery() == false) {
                //return false;
            //}
        //}
        //return true;
    }

    
}


