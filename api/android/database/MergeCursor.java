package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MergeCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.422 -0400", hash_original_field = "FA2BE9015D45FC980588BB7AE26DD67B", hash_generated_field = "C705E652159B9179EDC61663E0FF6CEE")

    private DataSetObserver mObserver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.422 -0400", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "E84AFD080C6F2A7124E647128DDF036E")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.422 -0400", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "567541AA29BE5959C655A66397E71654")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.423 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.423 -0400", hash_original_field = "9F592E8964994995C4E8DF2F59FC8B27", hash_generated_field = "0942DA24BE4E32B4E9FADB0B3647107E")

    private Cursor[] mCursors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.424 -0400", hash_original_method = "2995FF0D63D655B99F24232D11D6842D", hash_generated_method = "DD43E70BC9C36405B5A1CC41DE38DBC2")
    public  MergeCursor(Cursor[] cursors) {
        mCursors = cursors;
        mCursor = cursors[0];
for(int i = 0;i < mCursors.length;i++)
        {
    if(mCursors[i] == null)            
            continue;
            mCursors[i].registerDataSetObserver(mObserver);
        } //End block
        // ---------- Original Method ----------
        //mCursors = cursors;
        //mCursor = cursors[0];
        //for (int i = 0; i < mCursors.length; i++) {
            //if (mCursors[i] == null) continue;
            //mCursors[i].registerDataSetObserver(mObserver);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.425 -0400", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "3556920A0BF9F547438E3E45C48BFEE3")
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
        int varE2942A04780E223B215EB8B663CF5353_1722288860 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616701116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616701116;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.427 -0400", hash_original_method = "2E36F9108221D554FB6CCFC9204351EF", hash_generated_method = "0B0E4A1FC140ECBC3D66C7309CA0907A")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newPosition);
        addTaint(oldPosition);
        mCursor = null;
        int cursorStartPos = 0;
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] == null)            
            {
                continue;
            } //End block
    if(newPosition < (cursorStartPos + mCursors[i].getCount()))            
            {
                mCursor = mCursors[i];
                break;
            } //End block
            cursorStartPos += mCursors[i].getCount();
        } //End block
    if(mCursor != null)        
        {
            boolean ret = mCursor.moveToPosition(newPosition - cursorStartPos);
            boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_601165544 = (ret);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188148412 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188148412;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_528990106 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145053051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_145053051;
        // ---------- Original Method ----------
        //mCursor = null;
        //int cursorStartPos = 0;
        //int length = mCursors.length;
        //for (int i = 0 ; i < length; i++) {
            //if (mCursors[i] == null) {
                //continue;
            //}
            //if (newPosition < (cursorStartPos + mCursors[i].getCount())) {
                //mCursor = mCursors[i];
                //break;
            //}
            //cursorStartPos += mCursors[i].getCount();
        //}
        //if (mCursor != null) {
            //boolean ret = mCursor.moveToPosition(newPosition - cursorStartPos);
            //return ret;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.428 -0400", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "204C46C5462EF85CB302CDF0BB7D3474")
    @Override
    public String getString(int column) {
        addTaint(column);
String varBF070AA93B429966B971F1DEC6945F8B_1824370407 =         mCursor.getString(column);
        varBF070AA93B429966B971F1DEC6945F8B_1824370407.addTaint(taint);
        return varBF070AA93B429966B971F1DEC6945F8B_1824370407;
        // ---------- Original Method ----------
        //return mCursor.getString(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.428 -0400", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "9D7D7F439E56A35A034AA8F4B0687990")
    @Override
    public short getShort(int column) {
        addTaint(column);
        short varCF39ED121EBE45D3D2DC5918BE5E01F5_1423809036 = (mCursor.getShort(column));
                short var4F09DAA9D95BCB166A302407A0E0BABE_985892849 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_985892849;
        // ---------- Original Method ----------
        //return mCursor.getShort(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.429 -0400", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "072284C89DD08F487A97DBBA4B331800")
    @Override
    public int getInt(int column) {
        addTaint(column);
        int var2E07EF4470929EC8B6F136BFA91B860A_1347054733 = (mCursor.getInt(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053803859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053803859;
        // ---------- Original Method ----------
        //return mCursor.getInt(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.429 -0400", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "477E84494887B10D02DFEC6C09C1E124")
    @Override
    public long getLong(int column) {
        addTaint(column);
        long var771B739BF5A02FA05A73BCB0054D98D5_586122448 = (mCursor.getLong(column));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1448024190 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1448024190;
        // ---------- Original Method ----------
        //return mCursor.getLong(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.430 -0400", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "BEC2BC1B5929E4D9CCEE51C57709F3E0")
    @Override
    public float getFloat(int column) {
        addTaint(column);
        float var848ACA0CA9C00651ACC23CAEA64B6535_236889281 = (mCursor.getFloat(column));
                float var546ADE640B6EDFBC8A086EF31347E768_1760394032 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1760394032;
        // ---------- Original Method ----------
        //return mCursor.getFloat(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.430 -0400", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "C05F2E90033BE9FD210DEB97CE5A5559")
    @Override
    public double getDouble(int column) {
        addTaint(column);
        double var3ECDC303791021B0ABF6510DCFD995F2_105732140 = (mCursor.getDouble(column));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1819380685 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1819380685;
        // ---------- Original Method ----------
        //return mCursor.getDouble(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.430 -0400", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "E439F3F96F9B4E45D9FB969E52701F5F")
    @Override
    public int getType(int column) {
        addTaint(column);
        int var309B5A67BFA317E363B4314879AC9AD4_344912889 = (mCursor.getType(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732630639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732630639;
        // ---------- Original Method ----------
        //return mCursor.getType(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.431 -0400", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "1F6485C13DE6FFDA5FDE5286A14D82B1")
    @Override
    public boolean isNull(int column) {
        addTaint(column);
        boolean var1088A1081C6173A5FD1F3233B0A3611C_1922101171 = (mCursor.isNull(column));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486546030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486546030;
        // ---------- Original Method ----------
        //return mCursor.isNull(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.431 -0400", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "33F380ACFA3A569B3808C5124ED64674")
    @Override
    public byte[] getBlob(int column) {
        addTaint(column);
        byte[] var0E5AB00079F8E51D240AB21E2A09AC74_1724581772 = (mCursor.getBlob(column));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_837452486 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_837452486;
        // ---------- Original Method ----------
        //return mCursor.getBlob(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.432 -0400", hash_original_method = "EAE2D1400909F2A5DEAF3F19FC10B4CB", hash_generated_method = "2200497BB274F49283C40165FC2FA034")
    @Override
    public String[] getColumnNames() {
    if(mCursor != null)        
        {
String[] varF8FF07705E74C2344D2EF0339BC7BE26_1457238483 =             mCursor.getColumnNames();
            varF8FF07705E74C2344D2EF0339BC7BE26_1457238483.addTaint(taint);
            return varF8FF07705E74C2344D2EF0339BC7BE26_1457238483;
        } //End block
        else
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1315335848 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1315335848.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1315335848;
        } //End block
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //return mCursor.getColumnNames();
        //} else {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.432 -0400", hash_original_method = "48B51AF9DDDB4824C213FEDC18251646", hash_generated_method = "D579405E094C0B96BEA52BE8AC63D035")
    @Override
    public void deactivate() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                mCursors[i].deactivate();
            } //End block
        } //End block
        super.deactivate();
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].deactivate();
            //}
        //}
        //super.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.432 -0400", hash_original_method = "1ACEC7472EA47D5758C352132E064427", hash_generated_method = "1CE325C8FD7F1BFAD232026E50F408C3")
    @Override
    public void close() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] == null)            
            continue;
            mCursors[i].close();
        } //End block
        super.close();
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) continue;
            //mCursors[i].close();
        //}
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.433 -0400", hash_original_method = "9B33826E9FF931F2B698CFF4E2E845A6", hash_generated_method = "9D1BFE7F548FAD5B4E9849E2C78560CF")
    @Override
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                mCursors[i].registerContentObserver(observer);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].registerContentObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.433 -0400", hash_original_method = "CAE2DD1D134D44BF9E6E60CE9B9708BE", hash_generated_method = "A34C0E46D55AFFA8B8E82FFD205E33A5")
    @Override
    public void unregisterContentObserver(ContentObserver observer) {
        addTaint(observer.getTaint());
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] != null)            
            {
                mCursors[i].unregisterContentObserver(observer);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] != null) {
                //mCursors[i].unregisterContentObserver(observer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.434 -0400", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "C7510007050BE162AA6B2F6945600829")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.436 -0400", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "BEB572F1375F809C63C4BADFFEBCCD89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.437 -0400", hash_original_method = "9EE537B6DD7ADECF245A94C8CF7C44F2", hash_generated_method = "01099FD90569D0F73CB3861AA3463073")
    @Override
    public boolean requery() {
        int length = mCursors.length;
for(int i = 0;i < length;i++)
        {
    if(mCursors[i] == null)            
            {
                continue;
            } //End block
    if(mCursors[i].requery() == false)            
            {
                boolean var68934A3E9455FA72420237EB05902327_193097185 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_582850174 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_582850174;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1685359463 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270572426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270572426;
        // ---------- Original Method ----------
        //int length = mCursors.length;
        //for (int i = 0 ; i < length ; i++) {
            //if (mCursors[i] == null) {
                //continue;
            //}
            //if (mCursors[i].requery() == false) {
                //return false;
            //}
        //}
        //return true;
    }

    
}

