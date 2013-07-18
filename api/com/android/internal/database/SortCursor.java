package com.android.internal.database;

// Droidsafe Imports
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.DataSetObserver;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class SortCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "9F592E8964994995C4E8DF2F59FC8B27", hash_generated_field = "0942DA24BE4E32B4E9FADB0B3647107E")

    private Cursor[] mCursors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "16D55DE6ED5CBDD94F1CAB887722BE29", hash_generated_field = "6D5DF8C8DEA35609A5360D89C13E26BF")

    private int [] mSortColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "FB5BCDA5591D66A63513F604CBC30E4A", hash_generated_field = "2E5513FA4ED58574F469A99A551852C8")

    private final int ROWCACHESIZE = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "B34495432FA7DF0964A269D0BB026A5C", hash_generated_field = "BA2C3C517B65A42073A469041F1236B3")

    private int mRowNumCache[] = new int[ROWCACHESIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "4EDECD32E7CA2D5E0287954C8DA696D1", hash_generated_field = "6AFA154E6AAB3B01C4D4DD70762095F0")

    private int mCursorCache[] = new int[ROWCACHESIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "55A8A48675EEB0C18AB869AA10E4847D", hash_generated_field = "5F9A00FA72E61382BFC46ECE8BC96174")

    private int mCurRowNumCache[][];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_field = "4AF1B8E237E67EC883F088E573ADE6BB", hash_generated_field = "E17346E94ED9C398F5D9E40D8CEFB2B0")

    private int mLastCacheHit = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.153 -0400", hash_original_field = "FA2BE9015D45FC980588BB7AE26DD67B", hash_generated_field = "048753E2CDF770795AC102E0124AD2AB")

    private DataSetObserver mObserver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.152 -0400", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "E84AFD080C6F2A7124E647128DDF036E")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.153 -0400", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "567541AA29BE5959C655A66397E71654")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.156 -0400", hash_original_method = "64551E04019BE286A932EE113C90B39D", hash_generated_method = "3A00652D1CE984E3985D24D80C1DFE72")
    public  SortCursor(Cursor[] cursors, String sortcolumn) {
        mCursors = cursors;
        int length = mCursors.length;
        mSortColumns = new int[length];
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] == null)            
            continue;
            mCursors[i].registerDataSetObserver(mObserver);
            mCursors[i].moveToFirst();
            mSortColumns[i] = mCursors[i].getColumnIndexOrThrow(sortcolumn);
        } //End block
        mCursor = null;
        String smallest = "";
for(int j = 0;j < length;j++)
        {
            if(mCursors[j] == null || mCursors[j].isAfterLast())            
            continue;
            String current = mCursors[j].getString(mSortColumns[j]);
            if(mCursor == null || current.compareToIgnoreCase(smallest) < 0)            
            {
                smallest = current;
                mCursor = mCursors[j];
            } //End block
        } //End block
for(int i = mRowNumCache.length - 1;i >= 0;i--)
        {
            mRowNumCache[i] = -2;
        } //End block
        mCurRowNumCache = new int[ROWCACHESIZE][length];
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.157 -0400", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "7C4EE038D1FA22839ED9D0FD52488E74")
    @Override
    public int getCount() {
        int count = 0;
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] != null)            
            {
                count += mCursors[i].getCount();
            } //End block
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_991210609 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1458580170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1458580170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.161 -0400", hash_original_method = "84C72ACE5D5A745A5633B3A38CCC072D", hash_generated_method = "1DAC1F75EE9D412FF3BD735FFD89E518")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldPosition);
        if(oldPosition == newPosition)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_916877268 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817722490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817722490;
        }
        int cache_entry = newPosition % ROWCACHESIZE;
        if(mRowNumCache[cache_entry] == newPosition)        
        {
            int which = mCursorCache[cache_entry];
            mCursor = mCursors[which];
            if(mCursor == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1782506997 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_381881579 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_381881579;
            } //End block
            mCursor.moveToPosition(mCurRowNumCache[cache_entry][which]);
            mLastCacheHit = cache_entry;
            boolean varB326B5062B2F0E69046810717534CB09_1289381716 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924507950 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_924507950;
        } //End block
        mCursor = null;
        int length = mCursors.length;
        if(mLastCacheHit >= 0)        
        {
for(int i = 0;i < length;i++)
            {
                if(mCursors[i] == null)                
                continue;
                mCursors[i].moveToPosition(mCurRowNumCache[mLastCacheHit][i]);
            } //End block
        } //End block
        if(newPosition < oldPosition || oldPosition == -1)        
        {
for(int i = 0;i < length;i++)
            {
                if(mCursors[i] == null)                
                continue;
                mCursors[i].moveToFirst();
            } //End block
            oldPosition = 0;
        } //End block
        if(oldPosition < 0)        
        {
            oldPosition = 0;
        } //End block
        int smallestIdx = -1;
for(int i = oldPosition;i <= newPosition;i++)
        {
            String smallest = "";
            smallestIdx = -1;
for(int j = 0;j < length;j++)
            {
                if(mCursors[j] == null || mCursors[j].isAfterLast())                
                {
                    continue;
                } //End block
                String current = mCursors[j].getString(mSortColumns[j]);
                if(smallestIdx < 0 || current.compareToIgnoreCase(smallest) < 0)                
                {
                    smallest = current;
                    smallestIdx = j;
                } //End block
            } //End block
            if(i == newPosition)            
            break;
            if(mCursors[smallestIdx] != null)            
            {
                mCursors[smallestIdx].moveToNext();
            } //End block
        } //End block
        mCursor = mCursors[smallestIdx];
        mRowNumCache[cache_entry] = newPosition;
        mCursorCache[cache_entry] = smallestIdx;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] != null)            
            {
                mCurRowNumCache[cache_entry][i] = mCursors[i].getPosition();
            } //End block
        } //End block
        mLastCacheHit = -1;
        boolean varB326B5062B2F0E69046810717534CB09_1019248594 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1358305402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1358305402;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.162 -0400", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "344BBED34FC4584E3DD219A7A10A0574")
    @Override
    public String getString(int column) {
        addTaint(column);
String varBF070AA93B429966B971F1DEC6945F8B_499523437 =         mCursor.getString(column);
        varBF070AA93B429966B971F1DEC6945F8B_499523437.addTaint(taint);
        return varBF070AA93B429966B971F1DEC6945F8B_499523437;
        // ---------- Original Method ----------
        //return mCursor.getString(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.163 -0400", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "95F9075DD31CE20EC4B832F6B084231F")
    @Override
    public short getShort(int column) {
        addTaint(column);
        short varCF39ED121EBE45D3D2DC5918BE5E01F5_511737641 = (mCursor.getShort(column));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1127181246 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1127181246;
        // ---------- Original Method ----------
        //return mCursor.getShort(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.164 -0400", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "710582D1E91A17BA7A2AF788D2EBE19E")
    @Override
    public int getInt(int column) {
        addTaint(column);
        int var2E07EF4470929EC8B6F136BFA91B860A_1546231506 = (mCursor.getInt(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131798877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131798877;
        // ---------- Original Method ----------
        //return mCursor.getInt(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.164 -0400", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "A53844568071FDD3AA3B9C8E967757BE")
    @Override
    public long getLong(int column) {
        addTaint(column);
        long var771B739BF5A02FA05A73BCB0054D98D5_2112310587 = (mCursor.getLong(column));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1385114150 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1385114150;
        // ---------- Original Method ----------
        //return mCursor.getLong(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.165 -0400", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "42B377F7413F484C4EAFB754007DE3A8")
    @Override
    public float getFloat(int column) {
        addTaint(column);
        float var848ACA0CA9C00651ACC23CAEA64B6535_1991661772 = (mCursor.getFloat(column));
                float var546ADE640B6EDFBC8A086EF31347E768_871732243 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_871732243;
        // ---------- Original Method ----------
        //return mCursor.getFloat(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.165 -0400", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "69DD2083D9ED597DF3548BFAFBF32E5D")
    @Override
    public double getDouble(int column) {
        addTaint(column);
        double var3ECDC303791021B0ABF6510DCFD995F2_48812718 = (mCursor.getDouble(column));
                double varE8CD7DA078A86726031AD64F35F5A6C0_326163236 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_326163236;
        // ---------- Original Method ----------
        //return mCursor.getDouble(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.166 -0400", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "3A0405D99E93364BE044B8A1C6022F9D")
    @Override
    public int getType(int column) {
        addTaint(column);
        int var309B5A67BFA317E363B4314879AC9AD4_452965789 = (mCursor.getType(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421807742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421807742;
        // ---------- Original Method ----------
        //return mCursor.getType(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.166 -0400", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "873C9731DB900CF673ED8DC2601FCF35")
    @Override
    public boolean isNull(int column) {
        addTaint(column);
        boolean var1088A1081C6173A5FD1F3233B0A3611C_322831741 = (mCursor.isNull(column));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468103558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_468103558;
        // ---------- Original Method ----------
        //return mCursor.isNull(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.166 -0400", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "F1D3DAD56645CDF6CA1212DB11AE6A71")
    @Override
    public byte[] getBlob(int column) {
        addTaint(column);
        byte[] var0E5AB00079F8E51D240AB21E2A09AC74_396651985 = (mCursor.getBlob(column));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_163761804 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_163761804;
        // ---------- Original Method ----------
        //return mCursor.getBlob(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.167 -0400", hash_original_method = "FABBE77F00A0F54771EB01C7CA2B1BF3", hash_generated_method = "D552EE75542F6BC4434C2552E18AFE50")
    @Override
    public String[] getColumnNames() {
        if(mCursor != null)        
        {
String[] varF8FF07705E74C2344D2EF0339BC7BE26_588269112 =             mCursor.getColumnNames();
            varF8FF07705E74C2344D2EF0339BC7BE26_588269112.addTaint(taint);
            return varF8FF07705E74C2344D2EF0339BC7BE26_588269112;
        } //End block
        else
        {
            int length = mCursors.length;
for(int i = 0;i < length;i++)
            {
                if(mCursors[i] != null)                
                {
String[] var90D18CEB9F718E94701547140114F98C_1768208105 =                     mCursors[i].getColumnNames();
                    var90D18CEB9F718E94701547140114F98C_1768208105.addTaint(taint);
                    return var90D18CEB9F718E94701547140114F98C_1768208105;
                } //End block
            } //End block
            IllegalStateException var4DD288F0D5A057C1622FA17A2BEFA85F_1744113370 = new IllegalStateException("No cursor that can return names");
            var4DD288F0D5A057C1622FA17A2BEFA85F_1744113370.addTaint(taint);
            throw var4DD288F0D5A057C1622FA17A2BEFA85F_1744113370;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.167 -0400", hash_original_method = "151ECE452A0E4CEB4F2D2BADB62BF062", hash_generated_method = "D7769FD46931296AEC9859857CC03261")
    @Override
    public void deactivate() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] == null)            
            continue;
            mCursors[i].deactivate();
        } //End block
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) continue;
            //mCursors[i].deactivate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.168 -0400", hash_original_method = "78F095A0FFEE3E0B5C15F16DE0B8AED8", hash_generated_method = "C82D4A2631FF84B7666B9E2E7B42C16F")
    @Override
    public void close() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] == null)            
            continue;
            mCursors[i].close();
        } //End block
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) continue;
            //mCursors[i].close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.168 -0400", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "C7510007050BE162AA6B2F6945600829")
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] != null)            
            {
                mCursors[i].registerDataSetObserver(observer);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].registerDataSetObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.169 -0400", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "BEB572F1375F809C63C4BADFFEBCCD89")
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] != null)            
            {
                mCursors[i].unregisterDataSetObserver(observer);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].unregisterDataSetObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.170 -0400", hash_original_method = "3BA588146C61870E37BC59410D39661D", hash_generated_method = "0689F56BA38B81A90CD9C1C62ECBBC90")
    @Override
    public boolean requery() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
            if(mCursors[i] == null)            
            continue;
            if(mCursors[i].requery() == false)            
            {
                boolean var68934A3E9455FA72420237EB05902327_923921256 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581845892 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_581845892;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1581859856 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530090507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530090507;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.170 -0400", hash_original_field = "24A837F593F74F837D16B2A7D21F60CA", hash_generated_field = "724293D7D77BA8225464183EA8F32F1E")

    private static final String TAG = "SortCursor";
}

