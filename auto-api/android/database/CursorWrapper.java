package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper implements Cursor {
    protected /* final */ Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.619 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "E5E2B855372F1B0BE79DB757C03C7DED")
    @DSModeled(DSC.SAFE)
    public CursorWrapper(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        // ---------- Original Method ----------
        //mCursor = cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.619 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "42FDC0F95FE381ABC09407656B5D7DCE")
    @DSModeled(DSC.SAFE)
    public Cursor getWrappedCursor() {
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.619 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "40C0DBEBD05DCFCF45D334C9AD47978E")
    @DSModeled(DSC.SAFE)
    public void close() {
        mCursor.close();
        // ---------- Original Method ----------
        //mCursor.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.620 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "43F3873F97232E474ED8C0AF10BAFDB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isClosed() {
        boolean varD253E499C6C962FE6520ABAFDC2DFA3A_1555124493 = (mCursor.isClosed());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.620 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "D7F71C094905C50EDE8B0AAD616C5CC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        int var633E90A13E59B5C21FDD84E62359C432_328602464 = (mCursor.getCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.620 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "DB31F137A663F1404F925EEB6F679D51")
    @DSModeled(DSC.SAFE)
    public void deactivate() {
        mCursor.deactivate();
        // ---------- Original Method ----------
        //mCursor.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.620 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "5C7FAC273CAAD2567D13AE046F873C27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToFirst() {
        boolean var6553B635E7C5FD1A4088E45B0A641971_1884784483 = (mCursor.moveToFirst());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.620 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "E0BBE3D4E5E33DC9FD76F94B15FB3F92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnCount() {
        int var8D2C0EF2974275827688921832503CE9_1528277703 = (mCursor.getColumnCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getColumnCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.621 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "F08C2AB7627C401FD000195049CB97C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndex(String columnName) {
        dsTaint.addTaint(columnName);
        int var3D36C88EE2306414617596C46D011D1B_2127699902 = (mCursor.getColumnIndex(columnName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getColumnIndex(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.621 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "B0447D9D61A9161D98F59EE16F067ACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        dsTaint.addTaint(columnName);
        int varA27C403EFFBA82728364FC68A3881162_1798080458 = (mCursor.getColumnIndexOrThrow(columnName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getColumnIndexOrThrow(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.621 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "2A6BD200D0A9642A919EFB9D94F1491A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getColumnName(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        String var2A1C007830E2E529BD111D0439AFE107_2101350151 = (mCursor.getColumnName(columnIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCursor.getColumnName(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.621 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "A0C6C12003F23476C08DDF5BAFED1F73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getColumnNames() {
        String[] varCD9922709FDA409F0930AB857F403CC7_162654562 = (mCursor.getColumnNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mCursor.getColumnNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.621 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "87E2B736ACFC1EACE616350A11EE526C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        double var1EBB2DC726B4ACFAFD58BAD7DE69C13B_157648021 = (mCursor.getDouble(columnIndex));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mCursor.getDouble(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.622 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "C9CC10568406C54617BD0FD5C6C70AF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getExtras() {
        Bundle var976D7ED60AB95311F7422A2F25A23214_1329671464 = (mCursor.getExtras());
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor.getExtras();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.622 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "509B551785ECF6C9CBEF3210564A2C1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        float varEDBAB80B3F7EB49500830BBEC30048D5_557621580 = (mCursor.getFloat(columnIndex));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCursor.getFloat(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.622 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "6078E54C14E31B7A76991578909F4F49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        int var983E50BA69B81975B003C59D826EB416_2062319921 = (mCursor.getInt(columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getInt(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.622 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "6355C0F6BFBD5BB34C99D4457C9C2349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        long varFCD531CA53DCF0ED4AA4BFCC635D69F2_1225319846 = (mCursor.getLong(columnIndex));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCursor.getLong(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.622 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "BC9B34BF85814DD57C9E99C9E237C37E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        short varCFB1DCF76D3CB94ADAEF38883853A9F7_128355525 = (mCursor.getShort(columnIndex));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mCursor.getShort(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.623 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "8BD1F129DCBC1658722FACA251AA20C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        String var9E1326DF22B27A23241E81F6F326EDCA_1245687076 = (mCursor.getString(columnIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCursor.getString(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.623 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "0C04B75473609FA25583C4B49ED4616E")
    @DSModeled(DSC.SAFE)
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(columnIndex);
        mCursor.copyStringToBuffer(columnIndex, buffer);
        // ---------- Original Method ----------
        //mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.623 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "F1C161DB2E51FE454EC3773B43378774")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBlob(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        byte[] var39847011BEE5629BB83F9D055F06426E_1966534119 = (mCursor.getBlob(columnIndex));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mCursor.getBlob(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.623 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "C6739CB2EE6AD11B0DB4B844EADF01E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getWantsAllOnMoveCalls() {
        boolean varB847E6B2CAC91DD66B8CA3491BEEAC14_148483333 = (mCursor.getWantsAllOnMoveCalls());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.getWantsAllOnMoveCalls();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.623 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "18A1E270BE9F603F46FF1B522A92AF80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAfterLast() {
        boolean var1AEEB2F8CBE8C12DA28D76897F1CDC26_1034579262 = (mCursor.isAfterLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.624 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "ECB3B75F25E20F99BEC9B3C1DF40ABEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBeforeFirst() {
        boolean varCF818189B76A8E5C529E15D4A358318D_1434523509 = (mCursor.isBeforeFirst());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isBeforeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.624 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "807E7B0526B9E9B88ED6F7AF48CF11A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFirst() {
        boolean var42B5D9A2F4526C834A0F6F6FAF6F6C31_2120655152 = (mCursor.isFirst());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.624 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "E0AE9E97165A1378B231686B1C29027F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLast() {
        boolean var637A705C5FBD923FC8FF4A9499366CF9_836341504 = (mCursor.isLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.624 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "BBC7DFFEC064FF79A397019E36C7E58F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getType(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        int var3261092579FE97F016CB6C6C690233F6_1340260034 = (mCursor.getType(columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getType(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.624 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "4D06EE60A7FD69329D906A6466CA9681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNull(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var3747DFCCBE8241FBFD30A41D55BA7853_1383702835 = (mCursor.isNull(columnIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.isNull(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.624 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "AEA4E0E3899CD98B1FED1F6E924991D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToLast() {
        boolean var338BBB800254AF67336E1C3D4D5E1179_916017333 = (mCursor.moveToLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.625 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "D25EDC1907D8385342B813F5EADACF2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean move(int offset) {
        dsTaint.addTaint(offset);
        boolean varEEDC81F148299D2DE604C4560AE5EF44_1534125087 = (mCursor.move(offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.move(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.625 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "33FBA2E53B2FCCEBA169D721DF6F266B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToPosition(int position) {
        dsTaint.addTaint(position);
        boolean varBA4DCCC943083F7ACB7C7426B2B9222A_1763399001 = (mCursor.moveToPosition(position));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.625 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "01F74B47BA255040BDD9CC052740B075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToNext() {
        boolean varE6C0DAC6CD5134BB1AD83C31436A9B39_508920824 = (mCursor.moveToNext());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.625 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "081C90BD5A871A1AE8261826FBD2FB4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPosition() {
        int varF885A18917AF028639FF4CD81472E706_1977970155 = (mCursor.getPosition());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCursor.getPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.625 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "7EC3BD26381A4CE67387F8DC77BB0CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveToPrevious() {
        boolean varF3ABFC2344333960F5FB9C4CBDC41C19_2129479900 = (mCursor.moveToPrevious());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.moveToPrevious();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.626 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "7F8A13B98517C9C4BFA8DF7A02C99E3B")
    @DSModeled(DSC.SAFE)
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mCursor.registerContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.626 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "F5DCD811E44748B28EBC853043B6E706")
    @DSModeled(DSC.SAFE)
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mCursor.registerDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerDataSetObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.626 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "E65A2BA354FFEAEB0E6FEA718568ECBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requery() {
        boolean var77ED8C51772FFB766AF47CA67C514663_1149027941 = (mCursor.requery());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCursor.requery();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.626 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "CDA02ADEA95893650FD0D24ED4A9E2D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle respond(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        Bundle var8CBE324FA76AE02013A5CB26A22A63F4_1336932167 = (mCursor.respond(extras));
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCursor.respond(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.626 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "9BC8B70206CCEC65DAC8C1F28F782B14")
    @DSModeled(DSC.SPEC)
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cr.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        mCursor.setNotificationUri(cr, uri);
        // ---------- Original Method ----------
        //mCursor.setNotificationUri(cr, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.626 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "C96401C6261979D58DBC67818DECBF8B")
    @DSModeled(DSC.SAFE)
    public void unregisterContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mCursor.unregisterContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.627 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "882214B87282D2B35153DABE0F04D6D9")
    @DSModeled(DSC.SAFE)
    public void unregisterDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mCursor.unregisterDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterDataSetObserver(observer);
    }

    
}


