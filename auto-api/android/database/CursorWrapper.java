package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper implements Cursor {
    protected Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.098 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "23C8AC46FEA8E9321B1D6961F6A8003E")
    @DSModeled(DSC.SAFE)
    public CursorWrapper(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        // ---------- Original Method ----------
        //mCursor = cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.098 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "20133E86BCC1640AAD639F03406832B7")
    @DSModeled(DSC.SAFE)
    public Cursor getWrappedCursor() {
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.098 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "B1AD05790457C8898701464AAE0F0B72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mCursor.close();
        // ---------- Original Method ----------
        //mCursor.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.098 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "F6A9A221710B5F2F4704616EF70E42D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isClosed() {
        boolean varD253E499C6C962FE6520ABAFDC2DFA3A_1051849508 = (mCursor.isClosed());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.099 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "D2781A66D2F840AB194B078C2D6A1BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        int var633E90A13E59B5C21FDD84E62359C432_963693550 = (mCursor.getCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.099 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "0BCE346B7C70E5CAD483677FDAD72A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deactivate() {
        mCursor.deactivate();
        // ---------- Original Method ----------
        //mCursor.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.099 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "19C2EF2A291E3EC59F8E2AEE23353147")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToFirst() {
        boolean var6553B635E7C5FD1A4088E45B0A641971_2112137848 = (mCursor.moveToFirst());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.099 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "9C4705A412059AB8591C0AC6C52420E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnCount() {
        int var8D2C0EF2974275827688921832503CE9_803320748 = (mCursor.getColumnCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getColumnCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.100 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "B27AEDCD72A8C8FA8665C878E37214C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndex(String columnName) {
        dsTaint.addTaint(columnName);
        int var3D36C88EE2306414617596C46D011D1B_364291559 = (mCursor.getColumnIndex(columnName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getColumnIndex(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.100 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "8D86D44668F964CE8E0875FBF6E5178C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        dsTaint.addTaint(columnName);
        int varA27C403EFFBA82728364FC68A3881162_445101856 = (mCursor.getColumnIndexOrThrow(columnName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getColumnIndexOrThrow(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.100 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "00399F443EC8A6EB2ED05090DE519FF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getColumnName(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        String var2A1C007830E2E529BD111D0439AFE107_1195832225 = (mCursor.getColumnName(columnIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCursor.getColumnName(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.100 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "E5738285E6F111D3AB31729A24241EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getColumnNames() {
        String[] varCD9922709FDA409F0930AB857F403CC7_631100506 = (mCursor.getColumnNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mCursor.getColumnNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.101 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "F9D51437FF37BDB0F2950F03DADF1002")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        double var1EBB2DC726B4ACFAFD58BAD7DE69C13B_1988006092 = (mCursor.getDouble(columnIndex));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mCursor.getDouble(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.101 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "F0D2B6E9F22E34818DEAAD4936CC551A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getExtras() {
        Bundle var976D7ED60AB95311F7422A2F25A23214_1992222015 = (mCursor.getExtras());
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor.getExtras();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.101 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "587494B82D4E54D6D21E8CE31CCC79DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        float varEDBAB80B3F7EB49500830BBEC30048D5_1969304168 = (mCursor.getFloat(columnIndex));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCursor.getFloat(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.101 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "F10B268B4EA4152C0D3A6B3948C70455")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        int var983E50BA69B81975B003C59D826EB416_1976405846 = (mCursor.getInt(columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getInt(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.101 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "7673A3C05D76A86C455D0DBB19C92CE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        long varFCD531CA53DCF0ED4AA4BFCC635D69F2_439187613 = (mCursor.getLong(columnIndex));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCursor.getLong(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.102 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "5B2F8AE61A0541D2A627DCA211893062")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        short varCFB1DCF76D3CB94ADAEF38883853A9F7_912994943 = (mCursor.getShort(columnIndex));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mCursor.getShort(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.102 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "45CE071A9A5619974F6A67763CFEC4E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        String var9E1326DF22B27A23241E81F6F326EDCA_1515251243 = (mCursor.getString(columnIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCursor.getString(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.102 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "B1B8588E654177DCC5A8271A0D966F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(columnIndex);
        mCursor.copyStringToBuffer(columnIndex, buffer);
        // ---------- Original Method ----------
        //mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.102 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "5F7EA8074F3D0A19D20645B93C3DC718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBlob(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        byte[] var39847011BEE5629BB83F9D055F06426E_142933702 = (mCursor.getBlob(columnIndex));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mCursor.getBlob(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.103 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "BAC3170A6BA77C940D3095C36E1D06EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getWantsAllOnMoveCalls() {
        boolean varB847E6B2CAC91DD66B8CA3491BEEAC14_976537713 = (mCursor.getWantsAllOnMoveCalls());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.getWantsAllOnMoveCalls();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.103 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "CC80D303E003752CE3D94F1C1E351B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAfterLast() {
        boolean var1AEEB2F8CBE8C12DA28D76897F1CDC26_1791497036 = (mCursor.isAfterLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.103 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "5D84D389AD537719AFF2113A6E33640A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBeforeFirst() {
        boolean varCF818189B76A8E5C529E15D4A358318D_2040135014 = (mCursor.isBeforeFirst());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isBeforeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.103 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "C035ACFBAAE9F7E205E7597BA76D63F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFirst() {
        boolean var42B5D9A2F4526C834A0F6F6FAF6F6C31_1573164546 = (mCursor.isFirst());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.104 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "9352BEAA9D123579240C1D1DB2BB6FB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLast() {
        boolean var637A705C5FBD923FC8FF4A9499366CF9_1476402160 = (mCursor.isLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.104 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "27A1BEBE282B4AD678B154D7EBCC7DE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getType(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        int var3261092579FE97F016CB6C6C690233F6_1177090552 = (mCursor.getType(columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getType(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.104 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "42403FFCD9C5E3880FBE2FA2C15DA6CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNull(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var3747DFCCBE8241FBFD30A41D55BA7853_2119811502 = (mCursor.isNull(columnIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isNull(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.104 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "17244D42BE5FA6B452C609B4304B5F11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToLast() {
        boolean var338BBB800254AF67336E1C3D4D5E1179_923496878 = (mCursor.moveToLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.104 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "61AAF692A000AC26827573FF5B73226A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean move(int offset) {
        dsTaint.addTaint(offset);
        boolean varEEDC81F148299D2DE604C4560AE5EF44_9231870 = (mCursor.move(offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.move(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.105 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "FCA2264017E1045544BD61E4CC45F0EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToPosition(int position) {
        dsTaint.addTaint(position);
        boolean varBA4DCCC943083F7ACB7C7426B2B9222A_1904918808 = (mCursor.moveToPosition(position));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.105 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "16EE6B643B95069E878CECB86A4A7863")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToNext() {
        boolean varE6C0DAC6CD5134BB1AD83C31436A9B39_1746655286 = (mCursor.moveToNext());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.105 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "C61C49A0C10A62842B67CC563EEAAD81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPosition() {
        int varF885A18917AF028639FF4CD81472E706_1307202252 = (mCursor.getPosition());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.105 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "C40C7B3CB637B7EBCE69AEA72CF93418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToPrevious() {
        boolean varF3ABFC2344333960F5FB9C4CBDC41C19_275285336 = (mCursor.moveToPrevious());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToPrevious();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.105 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "12B47FB2E9D1A9318E860EE8D4C7E542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mCursor.registerContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.106 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "2DB1D106960F51745266FA0FFB085939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mCursor.registerDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerDataSetObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.106 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "63EBDF26F14CFBD90BDB139FB78E70A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requery() {
        boolean var77ED8C51772FFB766AF47CA67C514663_571311298 = (mCursor.requery());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.requery();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.106 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "A83C421ADDA0B9CD214575059208373F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        Bundle var8CBE324FA76AE02013A5CB26A22A63F4_1976032142 = (mCursor.respond(extras));
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor.respond(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.106 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "6214AE74D05C0F12EA2D924219251CCD")
    @DSModeled(DSC.SPEC)
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        dsTaint.addTaint(cr.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        mCursor.setNotificationUri(cr, uri);
        // ---------- Original Method ----------
        //mCursor.setNotificationUri(cr, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.107 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "39BED69B938EB279A37193BF5D3803F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterContentObserver(ContentObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        mCursor.unregisterContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.107 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "38C3E72D25B623F0C4AF6DC7D47E5C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterDataSetObserver(DataSetObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        mCursor.unregisterDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterDataSetObserver(observer);
    }

    
}

