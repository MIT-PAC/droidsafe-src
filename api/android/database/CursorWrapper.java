package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;





public class CursorWrapper implements Cursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.779 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.781 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "5D389837C2CC65DEC4287272473DF588")
    public  CursorWrapper(Cursor cursor) {
        mCursor = cursor;
        // ---------- Original Method ----------
        //mCursor = cursor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.783 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "66F94762E7EDE78F3254C1EF51DA5650")
    public Cursor getWrappedCursor() {
Cursor var2D697C95C6440211C70889796F0139B0_1418826980 =         mCursor;
        var2D697C95C6440211C70889796F0139B0_1418826980.addTaint(taint);
        return var2D697C95C6440211C70889796F0139B0_1418826980;
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.784 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "B1AD05790457C8898701464AAE0F0B72")
    public void close() {
        mCursor.close();
        // ---------- Original Method ----------
        //mCursor.close();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.785 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "9044F7F9A7FB085E715A7B31C2AC720F")
    public boolean isClosed() {
        boolean var5BB654069CEE2CCE2484330B0B21C697_1973973019 = (mCursor.isClosed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056319562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056319562;
        // ---------- Original Method ----------
        //return mCursor.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.786 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "5C2E4F0F056230907461450821EA183C")
    public int getCount() {
        int var75D1A080281180206349E970682A62F2_157319116 = (mCursor.getCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183343323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183343323;
        // ---------- Original Method ----------
        //return mCursor.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.787 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "0BCE346B7C70E5CAD483677FDAD72A36")
    public void deactivate() {
        mCursor.deactivate();
        // ---------- Original Method ----------
        //mCursor.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.788 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "BB69D53B4A6DD3EEEBC9356511F86489")
    public boolean moveToFirst() {
        boolean varAE1A32886B21AC13493DC172F2CDC33E_375202838 = (mCursor.moveToFirst());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221685962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221685962;
        // ---------- Original Method ----------
        //return mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.789 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "5A85C05374C41A2B1F2946039AF52F11")
    public int getColumnCount() {
        int varF5FB34995ED03DB5B47BF8A4518BF861_341897177 = (mCursor.getColumnCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17911240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17911240;
        // ---------- Original Method ----------
        //return mCursor.getColumnCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.789 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "7432CEBBB1AA6471105E620738AB0927")
    public int getColumnIndex(String columnName) {
        addTaint(columnName.getTaint());
        int var0EE1B7284018D043DA2194D462757B8C_927328012 = (mCursor.getColumnIndex(columnName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374417066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374417066;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndex(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.791 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "366BE77B56CC92FD32DF23CD3394F885")
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        addTaint(columnName.getTaint());
        int varFA7FFC9E67A4555D07D43820EBA103A0_1542331014 = (mCursor.getColumnIndexOrThrow(columnName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200039305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200039305;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndexOrThrow(columnName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.792 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "9DF453F777F42973CA2FB1EB2F48C12D")
    public String getColumnName(int columnIndex) {
        addTaint(columnIndex);
String varAC3D7F17C6AC4A9FA44C31336E8C2A2E_312006354 =         mCursor.getColumnName(columnIndex);
        varAC3D7F17C6AC4A9FA44C31336E8C2A2E_312006354.addTaint(taint);
        return varAC3D7F17C6AC4A9FA44C31336E8C2A2E_312006354;
        // ---------- Original Method ----------
        //return mCursor.getColumnName(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.792 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "60D39EFA751EF8301EDA7831D540FCB6")
    public String[] getColumnNames() {
String[] varF8FF07705E74C2344D2EF0339BC7BE26_48776169 =         mCursor.getColumnNames();
        varF8FF07705E74C2344D2EF0339BC7BE26_48776169.addTaint(taint);
        return varF8FF07705E74C2344D2EF0339BC7BE26_48776169;
        // ---------- Original Method ----------
        //return mCursor.getColumnNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.793 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "46C81CE01B68402AC37CB449442EE666")
    public double getDouble(int columnIndex) {
        addTaint(columnIndex);
        double var93617EE2B7BAC1B4E85437E1206E9737_1663301910 = (mCursor.getDouble(columnIndex));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1404014224 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1404014224;
        // ---------- Original Method ----------
        //return mCursor.getDouble(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.793 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "27B4C1BD2C6CE4998F7A87BFA67986D4")
    public Bundle getExtras() {
Bundle var9F26218347A1E5FAB3EDA37346898AB0_1681361059 =         mCursor.getExtras();
        var9F26218347A1E5FAB3EDA37346898AB0_1681361059.addTaint(taint);
        return var9F26218347A1E5FAB3EDA37346898AB0_1681361059;
        // ---------- Original Method ----------
        //return mCursor.getExtras();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.794 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "FCB727CF0AA47745266783BD2298BFBA")
    public float getFloat(int columnIndex) {
        addTaint(columnIndex);
        float var205D9C4E4E526658E9749D3AACCD4D9B_1691782041 = (mCursor.getFloat(columnIndex));
                float var546ADE640B6EDFBC8A086EF31347E768_1012146260 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1012146260;
        // ---------- Original Method ----------
        //return mCursor.getFloat(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.795 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "BAEEB44C4CC105A3340DEB3085921D3C")
    public int getInt(int columnIndex) {
        addTaint(columnIndex);
        int var16C53861B904EEB353EFEC5F890B946D_2047568925 = (mCursor.getInt(columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330990048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330990048;
        // ---------- Original Method ----------
        //return mCursor.getInt(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.795 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "862960AE6B296831FD45FE4E4A85E420")
    public long getLong(int columnIndex) {
        addTaint(columnIndex);
        long varFC16BF54740B28C3D7A16DDD1DAA646C_1377823910 = (mCursor.getLong(columnIndex));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1099454528 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1099454528;
        // ---------- Original Method ----------
        //return mCursor.getLong(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.796 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "3E8667B381A42D32251462ED5F12F796")
    public short getShort(int columnIndex) {
        addTaint(columnIndex);
        short varB1DC8F1EAFEEF486EBC3A4CFA89C1D03_1468479919 = (mCursor.getShort(columnIndex));
                short var4F09DAA9D95BCB166A302407A0E0BABE_340959608 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_340959608;
        // ---------- Original Method ----------
        //return mCursor.getShort(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.797 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "397982AA796CAAF33100D4CB34328272")
    public String getString(int columnIndex) {
        addTaint(columnIndex);
String varEF1ACDA367BEBCC92D54F674D542FDC0_819065491 =         mCursor.getString(columnIndex);
        varEF1ACDA367BEBCC92D54F674D542FDC0_819065491.addTaint(taint);
        return varEF1ACDA367BEBCC92D54F674D542FDC0_819065491;
        // ---------- Original Method ----------
        //return mCursor.getString(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.798 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "C4993F0C241DEB2EF55967F6FC3D8F8C")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        addTaint(columnIndex);
        mCursor.copyStringToBuffer(columnIndex, buffer);
        // ---------- Original Method ----------
        //mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.798 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "CA22D62510604706B761B921C7990C53")
    public byte[] getBlob(int columnIndex) {
        addTaint(columnIndex);
        byte[] varE224B09D2B43EC45D5EA198E5BC0DDE1_102549357 = (mCursor.getBlob(columnIndex));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1756166217 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1756166217;
        // ---------- Original Method ----------
        //return mCursor.getBlob(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.799 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "CDFAE23163EED09C8A7EA5B302E22970")
    public boolean getWantsAllOnMoveCalls() {
        boolean varF2AEC4C640284983322BCF08D912C7EE_215535433 = (mCursor.getWantsAllOnMoveCalls());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573201682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573201682;
        // ---------- Original Method ----------
        //return mCursor.getWantsAllOnMoveCalls();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.800 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "1E0244F26D68EC08380E221FC3272BC2")
    public boolean isAfterLast() {
        boolean var16B3F8AEBA565D044DBA89FD0C2439F4_981371136 = (mCursor.isAfterLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475415951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475415951;
        // ---------- Original Method ----------
        //return mCursor.isAfterLast();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.800 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "B2752424730C6F94B091B69F33F41166")
    public boolean isBeforeFirst() {
        boolean var13861B88C26287BDE8FCB1F8332147C7_985384253 = (mCursor.isBeforeFirst());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682444143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682444143;
        // ---------- Original Method ----------
        //return mCursor.isBeforeFirst();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.801 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "8AAF734C71002BEF3CAEC333FA59D50E")
    public boolean isFirst() {
        boolean var68FCBD8CD4A87CA22669DFCC9C29594B_1881028676 = (mCursor.isFirst());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604312234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604312234;
        // ---------- Original Method ----------
        //return mCursor.isFirst();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.802 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "2888B6D3BAB67F5CE3464EB60A2F44B3")
    public boolean isLast() {
        boolean var74F7DE1E8C77377342FFF3D15C5D0D4A_1446759969 = (mCursor.isLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955934009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955934009;
        // ---------- Original Method ----------
        //return mCursor.isLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.803 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "6701C6BA489F86532B66FDA297A0C3E1")
    public int getType(int columnIndex) {
        addTaint(columnIndex);
        int varBC220ED4E3F6FEE984B8F6B03D57E447_1730167872 = (mCursor.getType(columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178390773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178390773;
        // ---------- Original Method ----------
        //return mCursor.getType(columnIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.803 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "F49B17864486D82352A447FF90C33876")
    public boolean isNull(int columnIndex) {
        addTaint(columnIndex);
        boolean varA096D85C19C415B3D598571DA8FF125F_133818812 = (mCursor.isNull(columnIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150166294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_150166294;
        // ---------- Original Method ----------
        //return mCursor.isNull(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.804 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "54E32C6BF70AE392873BC67064033C10")
    public boolean moveToLast() {
        boolean var53240D8A9128AE11629EF42882A451D2_617898931 = (mCursor.moveToLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576086778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_576086778;
        // ---------- Original Method ----------
        //return mCursor.moveToLast();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.805 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "F8DD36C15981274973787D960456B321")
    public boolean move(int offset) {
        addTaint(offset);
        boolean var90504068A4D0A28937A99BAA90A3AF75_1514072532 = (mCursor.move(offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12295201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_12295201;
        // ---------- Original Method ----------
        //return mCursor.move(offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.806 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "DE9734D797EA52614E3092C197B716FC")
    public boolean moveToPosition(int position) {
        addTaint(position);
        boolean var738747ABADBB9ECC72707A1206126BEB_490071344 = (mCursor.moveToPosition(position));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371528715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371528715;
        // ---------- Original Method ----------
        //return mCursor.moveToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.808 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "F7B22216FAA67CC37E9EBE1C279F0EAC")
    public boolean moveToNext() {
        boolean varA3ACD2537D4B243F02FC5094F8394E0B_1931738360 = (mCursor.moveToNext());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221654998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221654998;
        // ---------- Original Method ----------
        //return mCursor.moveToNext();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.809 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "6ACECF4D702F34E50D61FEC01C68B3C5")
    public int getPosition() {
        int var2AB512E1448AAD95C03AA319C16E6A62_1749789511 = (mCursor.getPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202074395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202074395;
        // ---------- Original Method ----------
        //return mCursor.getPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.809 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "B53F0592AD7188B4E13229C93A65D931")
    public boolean moveToPrevious() {
        boolean var58AECBF713497924206D60D17589D1D2_1533385132 = (mCursor.moveToPrevious());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937148543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937148543;
        // ---------- Original Method ----------
        //return mCursor.moveToPrevious();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.810 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "58A8A641027A7FAB0CBC2E35639DDB12")
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mCursor.registerContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.811 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "01999277C8BE3B05C18263010C044DFF")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mCursor.registerDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerDataSetObserver(observer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.812 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "6DE173C309D7CAB368684F627528F597")
    public boolean requery() {
        boolean var336CC4CF5DA9DC6B1F9493F4DC3B6094_1346882237 = (mCursor.requery());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592990831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592990831;
        // ---------- Original Method ----------
        //return mCursor.requery();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.812 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "2C1EDA0141FE569D249D8AD67ACB4361")
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
Bundle varB44D2A19DAE9C7C11B872C4BE3A24267_1474776928 =         mCursor.respond(extras);
        varB44D2A19DAE9C7C11B872C4BE3A24267_1474776928.addTaint(taint);
        return varB44D2A19DAE9C7C11B872C4BE3A24267_1474776928;
        // ---------- Original Method ----------
        //return mCursor.respond(extras);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.813 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "D2ACF28A4B5BC1969EEE34D1BAC1A949")
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(cr.getTaint());
        mCursor.setNotificationUri(cr, uri);
        // ---------- Original Method ----------
        //mCursor.setNotificationUri(cr, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.813 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "9CF55D7396C59572B37D144E6ACC73F5")
    public void unregisterContentObserver(ContentObserver observer) {
        addTaint(observer.getTaint());
        mCursor.unregisterContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.814 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "3538547BFAB226CE9432036DDAB09DAB")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mCursor.unregisterDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterDataSetObserver(observer);
    }

    
}

