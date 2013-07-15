package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper implements Cursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.203 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.203 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "5D389837C2CC65DEC4287272473DF588")
    public  CursorWrapper(Cursor cursor) {
        mCursor = cursor;
        // ---------- Original Method ----------
        //mCursor = cursor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.204 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "09C2A21C64721C509146B0BDFDABD4C6")
    public Cursor getWrappedCursor() {
Cursor var2D697C95C6440211C70889796F0139B0_1179096072 =         mCursor;
        var2D697C95C6440211C70889796F0139B0_1179096072.addTaint(taint);
        return var2D697C95C6440211C70889796F0139B0_1179096072;
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.204 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "B1AD05790457C8898701464AAE0F0B72")
    public void close() {
        mCursor.close();
        // ---------- Original Method ----------
        //mCursor.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.204 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "05249267B7F442595F4AF1674E706518")
    public boolean isClosed() {
        boolean var5BB654069CEE2CCE2484330B0B21C697_665234273 = (mCursor.isClosed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314710912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314710912;
        // ---------- Original Method ----------
        //return mCursor.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.205 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "64D128211C1B440031C0FF2A8CFD1D63")
    public int getCount() {
        int var75D1A080281180206349E970682A62F2_1834185271 = (mCursor.getCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615890261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615890261;
        // ---------- Original Method ----------
        //return mCursor.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.205 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "0BCE346B7C70E5CAD483677FDAD72A36")
    public void deactivate() {
        mCursor.deactivate();
        // ---------- Original Method ----------
        //mCursor.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.205 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "6C62DFF18B73EA10B8B0DD1899E364AE")
    public boolean moveToFirst() {
        boolean varAE1A32886B21AC13493DC172F2CDC33E_1335720539 = (mCursor.moveToFirst());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817981198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817981198;
        // ---------- Original Method ----------
        //return mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.206 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "C91864661FF33A7BE4E136B40606A4BC")
    public int getColumnCount() {
        int varF5FB34995ED03DB5B47BF8A4518BF861_375423493 = (mCursor.getColumnCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605958015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605958015;
        // ---------- Original Method ----------
        //return mCursor.getColumnCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.206 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "6FFEC36E44FF1E0C56FD471027D45491")
    public int getColumnIndex(String columnName) {
        addTaint(columnName.getTaint());
        int var0EE1B7284018D043DA2194D462757B8C_37077023 = (mCursor.getColumnIndex(columnName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556810813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556810813;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndex(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.206 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "1978A5ADEEF3DB0F41044726684E4651")
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        addTaint(columnName.getTaint());
        int varFA7FFC9E67A4555D07D43820EBA103A0_1999087902 = (mCursor.getColumnIndexOrThrow(columnName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1967450088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1967450088;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndexOrThrow(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.207 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "003C46EACBDFAA116DD97D1ED8452385")
    public String getColumnName(int columnIndex) {
        addTaint(columnIndex);
String varAC3D7F17C6AC4A9FA44C31336E8C2A2E_671579330 =         mCursor.getColumnName(columnIndex);
        varAC3D7F17C6AC4A9FA44C31336E8C2A2E_671579330.addTaint(taint);
        return varAC3D7F17C6AC4A9FA44C31336E8C2A2E_671579330;
        // ---------- Original Method ----------
        //return mCursor.getColumnName(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.207 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "31A7D00D02653DD878884BD24462FFB4")
    public String[] getColumnNames() {
String[] varF8FF07705E74C2344D2EF0339BC7BE26_675002138 =         mCursor.getColumnNames();
        varF8FF07705E74C2344D2EF0339BC7BE26_675002138.addTaint(taint);
        return varF8FF07705E74C2344D2EF0339BC7BE26_675002138;
        // ---------- Original Method ----------
        //return mCursor.getColumnNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.208 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "689516FE26D99FD9444D427DAB2948F7")
    public double getDouble(int columnIndex) {
        addTaint(columnIndex);
        double var93617EE2B7BAC1B4E85437E1206E9737_895385046 = (mCursor.getDouble(columnIndex));
                double varE8CD7DA078A86726031AD64F35F5A6C0_36224638 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_36224638;
        // ---------- Original Method ----------
        //return mCursor.getDouble(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.208 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "70C0ED6984336AD4E538055332A24EA7")
    public Bundle getExtras() {
Bundle var9F26218347A1E5FAB3EDA37346898AB0_856457704 =         mCursor.getExtras();
        var9F26218347A1E5FAB3EDA37346898AB0_856457704.addTaint(taint);
        return var9F26218347A1E5FAB3EDA37346898AB0_856457704;
        // ---------- Original Method ----------
        //return mCursor.getExtras();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.208 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "67FA6D293D8645FCFDBD5BED1FCAB2C4")
    public float getFloat(int columnIndex) {
        addTaint(columnIndex);
        float var205D9C4E4E526658E9749D3AACCD4D9B_255754435 = (mCursor.getFloat(columnIndex));
                float var546ADE640B6EDFBC8A086EF31347E768_1538770647 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1538770647;
        // ---------- Original Method ----------
        //return mCursor.getFloat(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.209 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "16003669F24729E517F71D2B73FFE287")
    public int getInt(int columnIndex) {
        addTaint(columnIndex);
        int var16C53861B904EEB353EFEC5F890B946D_727923710 = (mCursor.getInt(columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836698065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836698065;
        // ---------- Original Method ----------
        //return mCursor.getInt(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.209 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "18C1D7C6BC9254CE4AB02D1FDD1CF7ED")
    public long getLong(int columnIndex) {
        addTaint(columnIndex);
        long varFC16BF54740B28C3D7A16DDD1DAA646C_263392281 = (mCursor.getLong(columnIndex));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_566641699 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_566641699;
        // ---------- Original Method ----------
        //return mCursor.getLong(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.210 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "39845C72A9572B0AAD33853CAA9453EB")
    public short getShort(int columnIndex) {
        addTaint(columnIndex);
        short varB1DC8F1EAFEEF486EBC3A4CFA89C1D03_174436978 = (mCursor.getShort(columnIndex));
                short var4F09DAA9D95BCB166A302407A0E0BABE_708590091 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_708590091;
        // ---------- Original Method ----------
        //return mCursor.getShort(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.210 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "7B48BFCF1596FD285241307B0EB62A53")
    public String getString(int columnIndex) {
        addTaint(columnIndex);
String varEF1ACDA367BEBCC92D54F674D542FDC0_1828710508 =         mCursor.getString(columnIndex);
        varEF1ACDA367BEBCC92D54F674D542FDC0_1828710508.addTaint(taint);
        return varEF1ACDA367BEBCC92D54F674D542FDC0_1828710508;
        // ---------- Original Method ----------
        //return mCursor.getString(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.210 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "C4993F0C241DEB2EF55967F6FC3D8F8C")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        addTaint(columnIndex);
        mCursor.copyStringToBuffer(columnIndex, buffer);
        // ---------- Original Method ----------
        //mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.211 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "E1AD21FA5EDA3161CB003A378348AED1")
    public byte[] getBlob(int columnIndex) {
        addTaint(columnIndex);
        byte[] varE224B09D2B43EC45D5EA198E5BC0DDE1_579396609 = (mCursor.getBlob(columnIndex));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1514225857 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1514225857;
        // ---------- Original Method ----------
        //return mCursor.getBlob(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.211 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "3FCECEA68BFE8D480C8263BBC2CCAD06")
    public boolean getWantsAllOnMoveCalls() {
        boolean varF2AEC4C640284983322BCF08D912C7EE_1095774936 = (mCursor.getWantsAllOnMoveCalls());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456025127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456025127;
        // ---------- Original Method ----------
        //return mCursor.getWantsAllOnMoveCalls();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.212 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "4093FB3F74EB707148DAD8A28986884B")
    public boolean isAfterLast() {
        boolean var16B3F8AEBA565D044DBA89FD0C2439F4_1555963974 = (mCursor.isAfterLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440954055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440954055;
        // ---------- Original Method ----------
        //return mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.212 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "AA5E346782430F9D1694005D34BA68CA")
    public boolean isBeforeFirst() {
        boolean var13861B88C26287BDE8FCB1F8332147C7_1621817343 = (mCursor.isBeforeFirst());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895579539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895579539;
        // ---------- Original Method ----------
        //return mCursor.isBeforeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.212 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "EF8AFEB15BC51D170A128A758CD394F5")
    public boolean isFirst() {
        boolean var68FCBD8CD4A87CA22669DFCC9C29594B_278224867 = (mCursor.isFirst());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877259144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877259144;
        // ---------- Original Method ----------
        //return mCursor.isFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.213 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "C62665D803275841280518B41010535C")
    public boolean isLast() {
        boolean var74F7DE1E8C77377342FFF3D15C5D0D4A_140369871 = (mCursor.isLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924032896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_924032896;
        // ---------- Original Method ----------
        //return mCursor.isLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.213 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "FCD891249F6E2C7ACEF675CC68981A9C")
    public int getType(int columnIndex) {
        addTaint(columnIndex);
        int varBC220ED4E3F6FEE984B8F6B03D57E447_1840296528 = (mCursor.getType(columnIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138931624 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138931624;
        // ---------- Original Method ----------
        //return mCursor.getType(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.214 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "EEBE5047C00E64D53A1031245A8BD3F3")
    public boolean isNull(int columnIndex) {
        addTaint(columnIndex);
        boolean varA096D85C19C415B3D598571DA8FF125F_591157781 = (mCursor.isNull(columnIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996922235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996922235;
        // ---------- Original Method ----------
        //return mCursor.isNull(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.214 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "D3757604C7B524F39E549D81FB961432")
    public boolean moveToLast() {
        boolean var53240D8A9128AE11629EF42882A451D2_2037292877 = (mCursor.moveToLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400368850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400368850;
        // ---------- Original Method ----------
        //return mCursor.moveToLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.214 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "8824EF5BD7EC1B53E41BD3732EEFAAFF")
    public boolean move(int offset) {
        addTaint(offset);
        boolean var90504068A4D0A28937A99BAA90A3AF75_1392398720 = (mCursor.move(offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383375620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383375620;
        // ---------- Original Method ----------
        //return mCursor.move(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.215 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "8BA2872174695364355EF3F0EA0F04EF")
    public boolean moveToPosition(int position) {
        addTaint(position);
        boolean var738747ABADBB9ECC72707A1206126BEB_1568635689 = (mCursor.moveToPosition(position));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721784585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721784585;
        // ---------- Original Method ----------
        //return mCursor.moveToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.215 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "D64B48965F937AC27AB1ED4DDD891734")
    public boolean moveToNext() {
        boolean varA3ACD2537D4B243F02FC5094F8394E0B_944161976 = (mCursor.moveToNext());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265498450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265498450;
        // ---------- Original Method ----------
        //return mCursor.moveToNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.216 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "28596917D1FC59E6D046C5C222D1806A")
    public int getPosition() {
        int var2AB512E1448AAD95C03AA319C16E6A62_566573888 = (mCursor.getPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090963683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090963683;
        // ---------- Original Method ----------
        //return mCursor.getPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.216 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "CA65E63632A2059E48272796EAE44C99")
    public boolean moveToPrevious() {
        boolean var58AECBF713497924206D60D17589D1D2_1910952504 = (mCursor.moveToPrevious());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481931342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481931342;
        // ---------- Original Method ----------
        //return mCursor.moveToPrevious();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.217 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "58A8A641027A7FAB0CBC2E35639DDB12")
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mCursor.registerContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.217 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "01999277C8BE3B05C18263010C044DFF")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mCursor.registerDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.registerDataSetObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.218 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "7C37CABAF43A64333EAA5ECA14157A39")
    public boolean requery() {
        boolean var336CC4CF5DA9DC6B1F9493F4DC3B6094_155349308 = (mCursor.requery());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739753960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739753960;
        // ---------- Original Method ----------
        //return mCursor.requery();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.219 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "8C084B5BCEDA9BB34B135222793D7798")
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
Bundle varB44D2A19DAE9C7C11B872C4BE3A24267_1560513007 =         mCursor.respond(extras);
        varB44D2A19DAE9C7C11B872C4BE3A24267_1560513007.addTaint(taint);
        return varB44D2A19DAE9C7C11B872C4BE3A24267_1560513007;
        // ---------- Original Method ----------
        //return mCursor.respond(extras);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.219 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "D2ACF28A4B5BC1969EEE34D1BAC1A949")
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(cr.getTaint());
        mCursor.setNotificationUri(cr, uri);
        // ---------- Original Method ----------
        //mCursor.setNotificationUri(cr, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.220 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "9CF55D7396C59572B37D144E6ACC73F5")
    public void unregisterContentObserver(ContentObserver observer) {
        addTaint(observer.getTaint());
        mCursor.unregisterContentObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.220 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "3538547BFAB226CE9432036DDAB09DAB")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mCursor.unregisterDataSetObserver(observer);
        // ---------- Original Method ----------
        //mCursor.unregisterDataSetObserver(observer);
    }

    
}

