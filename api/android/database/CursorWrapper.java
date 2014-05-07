package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper implements Cursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.623 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected  Cursor mCursor;

    /**
     * Creates a cursor wrapper.
     * @param cursor The underlying cursor to wrap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.625 -0500", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "42989D1D068EE582A6D8BA8313235CA1")
    
public CursorWrapper(Cursor cursor) {
        mCursor = cursor;
    }

    /**
     * Gets the underlying cursor that is wrapped by this instance.
     *
     * @return The wrapped cursor.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.628 -0500", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "3376CC06F4DA3FC683DA00248DFE6196")
    
public Cursor getWrappedCursor() {
        return mCursor;
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.630 -0500", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "720E7ACAFC70926E25D574B6002AF184")
    
public void close() {
        mCursor.close(); 
    }
 
    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.632 -0500", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "9628F01910A14D0DE5D01EF9DD871921")
    
public boolean isClosed() {
        return mCursor.isClosed();
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.635 -0500", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "46272F6E8792008A185D594A6B6D2780")
    
public int getCount() {
        return mCursor.getCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.637 -0500", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "2D017E1303A1A568209FE463A5ABE8BF")
    
public void deactivate() {
        mCursor.deactivate();
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.639 -0500", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "330A9E2E0BCE286FCA11BEEAC702AFD4")
    
public boolean moveToFirst() {
        return mCursor.moveToFirst();
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.641 -0500", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "E8C3082E2638204479494EC3454A9DBB")
    
public int getColumnCount() {
        return mCursor.getColumnCount();
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.644 -0500", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "EB1A46E098911D4440B6230B22AA55E4")
    
public int getColumnIndex(String columnName) {
        return mCursor.getColumnIndex(columnName);
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.646 -0500", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "F3DD6F35132B6BD369AF142F0CFC13BF")
    
public int getColumnIndexOrThrow(String columnName)
            throws IllegalArgumentException {
        return mCursor.getColumnIndexOrThrow(columnName);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.648 -0500", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "E0505428F90727E47FADD31A422193BB")
    
public String getColumnName(int columnIndex) {
         return mCursor.getColumnName(columnIndex);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.652 -0500", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "5FA4F455D72F70F9DFE28FC6BD6D59CD")
    
public String[] getColumnNames() {
        return mCursor.getColumnNames();
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.654 -0500", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "0E7C32B1B23D26DA56B6F4387793574E")
    
public double getDouble(int columnIndex) {
        return mCursor.getDouble(columnIndex);
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.656 -0500", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "35E6293B68750FE14E1C5CEDD88BB425")
    
public Bundle getExtras() {
        return mCursor.getExtras();
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.658 -0500", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "38D8597361DA0DC84F0AABB738C334B4")
    
public float getFloat(int columnIndex) {
        return mCursor.getFloat(columnIndex);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.661 -0500", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "0C6E14097AF12068399A97B9BDA0E532")
    
public int getInt(int columnIndex) {
        return mCursor.getInt(columnIndex);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.663 -0500", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "A456373B16F20268DCDC0A3F60F86BA8")
    
public long getLong(int columnIndex) {
        return mCursor.getLong(columnIndex);
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.666 -0500", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "91D6A5C6705A6849503FABC38751467F")
    
public short getShort(int columnIndex) {
        return mCursor.getShort(columnIndex);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.669 -0500", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "68DA2DB1F406D103086EB9C007AAF780")
    
public String getString(int columnIndex) {
        return mCursor.getString(columnIndex);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.671 -0500", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "B3CEC2FFAFF8BDDE1DA69D2C0DA76507")
    
public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.673 -0500", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "5E077195EF36E4512DEB95B19A4B65C2")
    
public byte[] getBlob(int columnIndex) {
        return mCursor.getBlob(columnIndex);
    }
    
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.676 -0500", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "AA4533144336BCD49D3A12C47BBD1AAB")
    
public boolean getWantsAllOnMoveCalls() {
        return mCursor.getWantsAllOnMoveCalls();
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.678 -0500", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "69B71F7B4B238099598CA18252B542E8")
    
public boolean isAfterLast() {
        return mCursor.isAfterLast();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.680 -0500", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "33111A942E00DC67C6B0B3604B27BDC2")
    
public boolean isBeforeFirst() {
        return mCursor.isBeforeFirst();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.683 -0500", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "8DCC2BB23D7B63CBE2004DC07C145B7C")
    
public boolean isFirst() {
        return mCursor.isFirst();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.685 -0500", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "97865968C9BA321FC4248000D38719BB")
    
public boolean isLast() {
        return mCursor.isLast();
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource(DSSourceKind.DATABASE_INFORMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.687 -0500", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "186C4C1AEED0786A2DA7810563D9B0B0")
    
public int getType(int columnIndex) {
        return mCursor.getType(columnIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.689 -0500", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "CF0F3EA509177B0928AF1A44A8115B28")
    
public boolean isNull(int columnIndex) {
        return mCursor.isNull(columnIndex);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.693 -0500", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "6998B59A657FA11F0B1EE1E52F6C45A9")
    
public boolean moveToLast() {
        return mCursor.moveToLast();
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.695 -0500", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "FB44AD6A98A08AF27EFA45F3FF20D7C0")
    
public boolean move(int offset) {
        return mCursor.move(offset);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.697 -0500", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "AB6AB467FA5787AE5A154ED6BB16B4EF")
    
public boolean moveToPosition(int position) {
        return mCursor.moveToPosition(position);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.700 -0500", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "1E6B01E0B977827B282FDD1BAF705E9D")
    
public boolean moveToNext() {
        return mCursor.moveToNext();
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.702 -0500", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "869C851C3A8FA9B55F117A8B0FB11DFF")
    
public int getPosition() {
        return mCursor.getPosition();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.704 -0500", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "CE022ED10D6D246D3D0A138D6CE4AFB7")
    
public boolean moveToPrevious() {
        return mCursor.moveToPrevious();
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.706 -0500", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "41285738004CC92DBFFF34841A873316")
    
public void registerContentObserver(ContentObserver observer) {
        mCursor.registerContentObserver(observer);   
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.708 -0500", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "23A18B5837E64076B845A6CECBC8A3F9")
    
public void registerDataSetObserver(DataSetObserver observer) {
        mCursor.registerDataSetObserver(observer);   
    }

    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.711 -0500", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "0FA5253426D86A2EF20B579620E97E04")
    
public boolean requery() {
        return mCursor.requery();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.713 -0500", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "2BDA544A766CC8F197331BC9615C1A2A")
    
public Bundle respond(Bundle extras) {
        return mCursor.respond(extras);
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.716 -0500", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "50E2244F41DC50ACE68ABA6F98D2A127")
    
public void setNotificationUri(ContentResolver cr, Uri uri) {
        mCursor.setNotificationUri(cr, uri);        
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.718 -0500", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "350CD144B64E9C84A340BC5B9F4E6AED")
    
public void unregisterContentObserver(ContentObserver observer) {
        mCursor.unregisterContentObserver(observer);        
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.720 -0500", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "0C4AE2003158EF511A8153427266C0CD")
    
public void unregisterDataSetObserver(DataSetObserver observer) {
        mCursor.unregisterDataSetObserver(observer);
    }
    
}

