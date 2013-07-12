package com.android.internal.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.util.Log;

public class SortCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.590 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.590 -0400", hash_original_field = "9F592E8964994995C4E8DF2F59FC8B27", hash_generated_field = "0942DA24BE4E32B4E9FADB0B3647107E")

    private Cursor[] mCursors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.590 -0400", hash_original_field = "16D55DE6ED5CBDD94F1CAB887722BE29", hash_generated_field = "6D5DF8C8DEA35609A5360D89C13E26BF")

    private int [] mSortColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.590 -0400", hash_original_field = "FB5BCDA5591D66A63513F604CBC30E4A", hash_generated_field = "2E5513FA4ED58574F469A99A551852C8")

    private final int ROWCACHESIZE = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_field = "B34495432FA7DF0964A269D0BB026A5C", hash_generated_field = "BA2C3C517B65A42073A469041F1236B3")

    private int mRowNumCache[] = new int[ROWCACHESIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_field = "4EDECD32E7CA2D5E0287954C8DA696D1", hash_generated_field = "6AFA154E6AAB3B01C4D4DD70762095F0")

    private int mCursorCache[] = new int[ROWCACHESIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_field = "55A8A48675EEB0C18AB869AA10E4847D", hash_generated_field = "5F9A00FA72E61382BFC46ECE8BC96174")

    private int mCurRowNumCache[][];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_field = "4AF1B8E237E67EC883F088E573ADE6BB", hash_generated_field = "E17346E94ED9C398F5D9E40D8CEFB2B0")

    private int mLastCacheHit = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_field = "FA2BE9015D45FC980588BB7AE26DD67B", hash_generated_field = "B660F69AD5EE0F8B3C3B8A26F52257C5")

    private DataSetObserver mObserver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "E84AFD080C6F2A7124E647128DDF036E")
        @Override
        public void onChanged() {
            
            mPos = -1;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.591 -0400", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "567541AA29BE5959C655A66397E71654")
        @Override
        public void onInvalidated() {
            
            mPos = -1;
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.592 -0400", hash_original_method = "64551E04019BE286A932EE113C90B39D", hash_generated_method = "3A00652D1CE984E3985D24D80C1DFE72")
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
        } 
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
            } 
        } 
for(int i = mRowNumCache.length - 1;i >= 0;i--)
        {
            mRowNumCache[i] = -2;
        } 
        mCurRowNumCache = new int[ROWCACHESIZE][length];
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.593 -0400", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "C0FECAEAA1A651ED25404BE0894F30A6")
    @Override
    public int getCount() {
        int count = 0;
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                count += mCursors[i].getCount();
            } 
        } 
        int varE2942A04780E223B215EB8B663CF5353_1786469091 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661618724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661618724;
        
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.595 -0400", hash_original_method = "84C72ACE5D5A745A5633B3A38CCC072D", hash_generated_method = "CC2E0B77EB093BD280043C417A56DF2E")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        
        addTaint(oldPosition);
    if(oldPosition == newPosition)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2034201421 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1569193930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1569193930;
        }
        int cache_entry = newPosition % ROWCACHESIZE;
    if(mRowNumCache[cache_entry] == newPosition)        
        {
            int which = mCursorCache[cache_entry];
            mCursor = mCursors[which];
    if(mCursor == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_67452183 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247375834 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247375834;
            } 
            mCursor.moveToPosition(mCurRowNumCache[cache_entry][which]);
            mLastCacheHit = cache_entry;
            boolean varB326B5062B2F0E69046810717534CB09_1747077295 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884235118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884235118;
        } 
        mCursor = null;
        int length = mCursors.length;
    if(mLastCacheHit >= 0)        
        {
for(int i = 0;i < length;i++)
            {
    if(mCursors[i] == null)                
                continue;
                mCursors[i].moveToPosition(mCurRowNumCache[mLastCacheHit][i]);
            } 
        } 
    if(newPosition < oldPosition || oldPosition == -1)        
        {
for(int i = 0;i < length;i++)
            {
    if(mCursors[i] == null)                
                continue;
                mCursors[i].moveToFirst();
            } 
            oldPosition = 0;
        } 
    if(oldPosition < 0)        
        {
            oldPosition = 0;
        } 
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
                } 
                String current = mCursors[j].getString(mSortColumns[j]);
    if(smallestIdx < 0 || current.compareToIgnoreCase(smallest) < 0)                
                {
                    smallest = current;
                    smallestIdx = j;
                } 
            } 
    if(i == newPosition)            
            break;
    if(mCursors[smallestIdx] != null)            
            {
                mCursors[smallestIdx].moveToNext();
            } 
        } 
        mCursor = mCursors[smallestIdx];
        mRowNumCache[cache_entry] = newPosition;
        mCursorCache[cache_entry] = smallestIdx;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                mCurRowNumCache[cache_entry][i] = mCursors[i].getPosition();
            } 
        } 
        mLastCacheHit = -1;
        boolean varB326B5062B2F0E69046810717534CB09_698843707 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612526183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_612526183;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.595 -0400", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "EB477696709546C53C2F9C3AE1F3D588")
    @Override
    public String getString(int column) {
        addTaint(column);
String varBF070AA93B429966B971F1DEC6945F8B_836995961 =         mCursor.getString(column);
        varBF070AA93B429966B971F1DEC6945F8B_836995961.addTaint(taint);
        return varBF070AA93B429966B971F1DEC6945F8B_836995961;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.596 -0400", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "39C02B1270209C9BB1724FEEAA5A2BB6")
    @Override
    public short getShort(int column) {
        addTaint(column);
        short varCF39ED121EBE45D3D2DC5918BE5E01F5_934181263 = (mCursor.getShort(column));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1705794300 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1705794300;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.596 -0400", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "5A44EE205CC4DD8F21D7FA656F0CC2F0")
    @Override
    public int getInt(int column) {
        addTaint(column);
        int var2E07EF4470929EC8B6F136BFA91B860A_1879582766 = (mCursor.getInt(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439338812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439338812;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.596 -0400", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "244DD0012D9F05CB1F5334D60D8B0E6A")
    @Override
    public long getLong(int column) {
        addTaint(column);
        long var771B739BF5A02FA05A73BCB0054D98D5_141758846 = (mCursor.getLong(column));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1482220514 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1482220514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.597 -0400", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "1A965E2D8D074FEB90061FB410890C06")
    @Override
    public float getFloat(int column) {
        addTaint(column);
        float var848ACA0CA9C00651ACC23CAEA64B6535_888095896 = (mCursor.getFloat(column));
                float var546ADE640B6EDFBC8A086EF31347E768_1887602438 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1887602438;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.597 -0400", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "E6CB8D0986CAF535363A9EBC5B12DF91")
    @Override
    public double getDouble(int column) {
        addTaint(column);
        double var3ECDC303791021B0ABF6510DCFD995F2_445982448 = (mCursor.getDouble(column));
                double varE8CD7DA078A86726031AD64F35F5A6C0_601684795 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_601684795;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.597 -0400", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "865D08259C3F26284DF0BEAE3144BE2D")
    @Override
    public int getType(int column) {
        addTaint(column);
        int var309B5A67BFA317E363B4314879AC9AD4_942396365 = (mCursor.getType(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2934775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2934775;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.597 -0400", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "BC3158CE0FB9E81AC5CEB4057C6E7D69")
    @Override
    public boolean isNull(int column) {
        addTaint(column);
        boolean var1088A1081C6173A5FD1F3233B0A3611C_1651461967 = (mCursor.isNull(column));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022873623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022873623;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.598 -0400", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "0348FF7835FCCAA1BF720390EB8FDBA1")
    @Override
    public byte[] getBlob(int column) {
        addTaint(column);
        byte[] var0E5AB00079F8E51D240AB21E2A09AC74_1395126875 = (mCursor.getBlob(column));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1656193300 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1656193300;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.598 -0400", hash_original_method = "FABBE77F00A0F54771EB01C7CA2B1BF3", hash_generated_method = "05842634558A37E74ADB588198F722F9")
    @Override
    public String[] getColumnNames() {
    if(mCursor != null)        
        {
String[] varF8FF07705E74C2344D2EF0339BC7BE26_1502379554 =             mCursor.getColumnNames();
            varF8FF07705E74C2344D2EF0339BC7BE26_1502379554.addTaint(taint);
            return varF8FF07705E74C2344D2EF0339BC7BE26_1502379554;
        } 
        else
        {
            int length = mCursors.length;
for(int i = 0;i < length;i++)
            {
    if(mCursors[i] != null)                
                {
String[] var90D18CEB9F718E94701547140114F98C_861234187 =                     mCursors[i].getColumnNames();
                    var90D18CEB9F718E94701547140114F98C_861234187.addTaint(taint);
                    return var90D18CEB9F718E94701547140114F98C_861234187;
                } 
            } 
            IllegalStateException var4DD288F0D5A057C1622FA17A2BEFA85F_1430255192 = new IllegalStateException("No cursor that can return names");
            var4DD288F0D5A057C1622FA17A2BEFA85F_1430255192.addTaint(taint);
            throw var4DD288F0D5A057C1622FA17A2BEFA85F_1430255192;
        } 
        
        
            
        
            
            
                
                    
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.598 -0400", hash_original_method = "151ECE452A0E4CEB4F2D2BADB62BF062", hash_generated_method = "D7769FD46931296AEC9859857CC03261")
    @Override
    public void deactivate() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] == null)            
            continue;
            mCursors[i].deactivate();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.598 -0400", hash_original_method = "78F095A0FFEE3E0B5C15F16DE0B8AED8", hash_generated_method = "C82D4A2631FF84B7666B9E2E7B42C16F")
    @Override
    public void close() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] == null)            
            continue;
            mCursors[i].close();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.599 -0400", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "C7510007050BE162AA6B2F6945600829")
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        
        addTaint(observer.getTaint());
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                mCursors[i].registerDataSetObserver(observer);
            } 
        } 
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.599 -0400", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "BEB572F1375F809C63C4BADFFEBCCD89")
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                mCursors[i].unregisterDataSetObserver(observer);
            } 
        } 
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.599 -0400", hash_original_method = "3BA588146C61870E37BC59410D39661D", hash_generated_method = "30A365C2C2873BBBEE5DB19052078EF3")
    @Override
    public boolean requery() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] == null)            
            continue;
    if(mCursors[i].requery() == false)            
            {
                boolean var68934A3E9455FA72420237EB05902327_314157990 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396007567 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396007567;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_138296531 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959567308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959567308;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.599 -0400", hash_original_field = "24A837F593F74F837D16B2A7D21F60CA", hash_generated_field = "724293D7D77BA8225464183EA8F32F1E")

    private static final String TAG = "SortCursor";
}

