package android.database;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class MergeCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.034 -0400", hash_original_field = "FA2BE9015D45FC980588BB7AE26DD67B", hash_generated_field = "B973D0B16972B08EE0EC04C0BE89E3D7")

    private DataSetObserver mObserver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.032 -0400", hash_original_method = "F00E20B7880C90825F84FA73002A8738", hash_generated_method = "E84AFD080C6F2A7124E647128DDF036E")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.033 -0400", hash_original_method = "4CD83AD480AFA6CEDD96BF4385EF1A22", hash_generated_method = "567541AA29BE5959C655A66397E71654")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mPos = -1;
            // ---------- Original Method ----------
            //mPos = -1;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.034 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.034 -0400", hash_original_field = "9F592E8964994995C4E8DF2F59FC8B27", hash_generated_field = "0942DA24BE4E32B4E9FADB0B3647107E")

    private Cursor[] mCursors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.036 -0400", hash_original_method = "2995FF0D63D655B99F24232D11D6842D", hash_generated_method = "DD43E70BC9C36405B5A1CC41DE38DBC2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.037 -0400", hash_original_method = "C94247264BA1143A8EFEBC4EA367BD4C", hash_generated_method = "AAC5BFEBA4CF77B900320295447F3E7A")
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
        int varE2942A04780E223B215EB8B663CF5353_1137954664 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76256243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76256243;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.038 -0400", hash_original_method = "2E36F9108221D554FB6CCFC9204351EF", hash_generated_method = "0887FD39C10DCE74E4B483675B08EA4B")
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
            boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_975231667 = (ret);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073043415 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073043415;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1114871140 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844123161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844123161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.039 -0400", hash_original_method = "3CE824B95C82F11BF58FC21A90C6596E", hash_generated_method = "139DAAC6A4D87FBF2F20BA3C08650E7F")
    @Override
    public String getString(int column) {
        addTaint(column);
String varBF070AA93B429966B971F1DEC6945F8B_1721898706 =         mCursor.getString(column);
        varBF070AA93B429966B971F1DEC6945F8B_1721898706.addTaint(taint);
        return varBF070AA93B429966B971F1DEC6945F8B_1721898706;
        // ---------- Original Method ----------
        //return mCursor.getString(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.040 -0400", hash_original_method = "E017157A16B41C5A1732268363B588AE", hash_generated_method = "D0F6304B7CEC5424189D6B52058C8D89")
    @Override
    public short getShort(int column) {
        addTaint(column);
        short varCF39ED121EBE45D3D2DC5918BE5E01F5_1950324143 = (mCursor.getShort(column));
                short var4F09DAA9D95BCB166A302407A0E0BABE_396515560 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_396515560;
        // ---------- Original Method ----------
        //return mCursor.getShort(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.040 -0400", hash_original_method = "196BE6610F391149CB98C678C09840A9", hash_generated_method = "A10B86612A7F1A2BDB8AED406FB07D85")
    @Override
    public int getInt(int column) {
        addTaint(column);
        int var2E07EF4470929EC8B6F136BFA91B860A_1290579001 = (mCursor.getInt(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357839626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357839626;
        // ---------- Original Method ----------
        //return mCursor.getInt(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.041 -0400", hash_original_method = "F9F66E8E22111A5FD3479C47D664F15E", hash_generated_method = "A3AF1DB04ACE7057DD6BF899A8D9B4D4")
    @Override
    public long getLong(int column) {
        addTaint(column);
        long var771B739BF5A02FA05A73BCB0054D98D5_1160420892 = (mCursor.getLong(column));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_760702510 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_760702510;
        // ---------- Original Method ----------
        //return mCursor.getLong(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.043 -0400", hash_original_method = "67B17E1A8809B30C69BA5C708B2EF661", hash_generated_method = "554EB3C8296DC6B401116995D502FC08")
    @Override
    public float getFloat(int column) {
        addTaint(column);
        float var848ACA0CA9C00651ACC23CAEA64B6535_732483616 = (mCursor.getFloat(column));
                float var546ADE640B6EDFBC8A086EF31347E768_1821754414 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1821754414;
        // ---------- Original Method ----------
        //return mCursor.getFloat(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.044 -0400", hash_original_method = "977D6BDEB2B1108A87BD2446DF855014", hash_generated_method = "363732985967FE94186A1DA611E01789")
    @Override
    public double getDouble(int column) {
        addTaint(column);
        double var3ECDC303791021B0ABF6510DCFD995F2_1498550152 = (mCursor.getDouble(column));
                double varE8CD7DA078A86726031AD64F35F5A6C0_609266698 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_609266698;
        // ---------- Original Method ----------
        //return mCursor.getDouble(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.045 -0400", hash_original_method = "EA5E8A29C1728085016D3A247FDA0EC9", hash_generated_method = "8F1D7ACD85C8038F4D6A0BCC202A249F")
    @Override
    public int getType(int column) {
        addTaint(column);
        int var309B5A67BFA317E363B4314879AC9AD4_976671547 = (mCursor.getType(column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804429819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804429819;
        // ---------- Original Method ----------
        //return mCursor.getType(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.046 -0400", hash_original_method = "A230025A9AF792B73F7279DEAF8B2408", hash_generated_method = "F205F2D49662C8AD923865E9601C5375")
    @Override
    public boolean isNull(int column) {
        addTaint(column);
        boolean var1088A1081C6173A5FD1F3233B0A3611C_429085106 = (mCursor.isNull(column));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207021882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207021882;
        // ---------- Original Method ----------
        //return mCursor.isNull(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.046 -0400", hash_original_method = "9D3EADEAB6620E0607DB05CBA4EF5895", hash_generated_method = "413FCABF23D1C8E2E54261C7900E7A21")
    @Override
    public byte[] getBlob(int column) {
        addTaint(column);
        byte[] var0E5AB00079F8E51D240AB21E2A09AC74_608514996 = (mCursor.getBlob(column));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1969003575 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1969003575;
        // ---------- Original Method ----------
        //return mCursor.getBlob(column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.047 -0400", hash_original_method = "EAE2D1400909F2A5DEAF3F19FC10B4CB", hash_generated_method = "0870CB3B9AC128E987B8174F94A92194")
    @Override
    public String[] getColumnNames() {
        if(mCursor != null)        
        {
String[] varF8FF07705E74C2344D2EF0339BC7BE26_1516378239 =             mCursor.getColumnNames();
            varF8FF07705E74C2344D2EF0339BC7BE26_1516378239.addTaint(taint);
            return varF8FF07705E74C2344D2EF0339BC7BE26_1516378239;
        } //End block
        else
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_214265413 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_214265413.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_214265413;
        } //End block
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //return mCursor.getColumnNames();
        //} else {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.047 -0400", hash_original_method = "48B51AF9DDDB4824C213FEDC18251646", hash_generated_method = "D579405E094C0B96BEA52BE8AC63D035")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.048 -0400", hash_original_method = "1ACEC7472EA47D5758C352132E064427", hash_generated_method = "1CE325C8FD7F1BFAD232026E50F408C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.049 -0400", hash_original_method = "9B33826E9FF931F2B698CFF4E2E845A6", hash_generated_method = "9D1BFE7F548FAD5B4E9849E2C78560CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.050 -0400", hash_original_method = "CAE2DD1D134D44BF9E6E60CE9B9708BE", hash_generated_method = "A34C0E46D55AFFA8B8E82FFD205E33A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.050 -0400", hash_original_method = "3D4B0E24965017562B726DF84968F4EF", hash_generated_method = "C7510007050BE162AA6B2F6945600829")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.051 -0400", hash_original_method = "E4FB1F85847F60D07EB9DA8ACAD3FA45", hash_generated_method = "BEB572F1375F809C63C4BADFFEBCCD89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.052 -0400", hash_original_method = "9EE537B6DD7ADECF245A94C8CF7C44F2", hash_generated_method = "B85EF876086D9EBD82E40977C16EB69C")
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
                boolean var68934A3E9455FA72420237EB05902327_334903646 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035660367 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035660367;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1834017125 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678875856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678875856;
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

