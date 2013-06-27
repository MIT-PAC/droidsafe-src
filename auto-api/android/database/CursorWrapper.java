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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.180 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.181 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "5D389837C2CC65DEC4287272473DF588")
    public  CursorWrapper(Cursor cursor) {
        mCursor = cursor;
        // ---------- Original Method ----------
        //mCursor = cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.182 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "ADB97C824CF26E38847A63939D6F69F0")
    public Cursor getWrappedCursor() {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_645661463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_645661463 = mCursor;
        varB4EAC82CA7396A68D541C85D26508E83_645661463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_645661463;
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.182 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "B1AD05790457C8898701464AAE0F0B72")
    public void close() {
        mCursor.close();
        // ---------- Original Method ----------
        //mCursor.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.190 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "1FFB9A78832617C3A892B1A762164167")
    public boolean isClosed() {
        boolean varD253E499C6C962FE6520ABAFDC2DFA3A_267046832 = (mCursor.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308511121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308511121;
        // ---------- Original Method ----------
        //return mCursor.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.191 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "F49E8B047765D855F4D6A1F34DB2E936")
    public int getCount() {
        int var633E90A13E59B5C21FDD84E62359C432_1491760370 = (mCursor.getCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148854917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148854917;
        // ---------- Original Method ----------
        //return mCursor.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.192 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "0BCE346B7C70E5CAD483677FDAD72A36")
    public void deactivate() {
        mCursor.deactivate();
        // ---------- Original Method ----------
        //mCursor.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.211 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "FFDA08DA36E91AAEE1290FA0A128FE21")
    public boolean moveToFirst() {
        boolean var6553B635E7C5FD1A4088E45B0A641971_1201842418 = (mCursor.moveToFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695739936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695739936;
        // ---------- Original Method ----------
        //return mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.212 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "B82914848A8A41742FDE1EDA0B3213DC")
    public int getColumnCount() {
        int var8D2C0EF2974275827688921832503CE9_432688348 = (mCursor.getColumnCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141373534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141373534;
        // ---------- Original Method ----------
        //return mCursor.getColumnCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.213 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "4971CB62B154711EC40810DE1608A54D")
    public int getColumnIndex(String columnName) {
        int var3D36C88EE2306414617596C46D011D1B_1558893571 = (mCursor.getColumnIndex(columnName));
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577241718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577241718;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndex(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.213 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "3BFF2B5B0389244787744C50C7F349A0")
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        int varA27C403EFFBA82728364FC68A3881162_1093525849 = (mCursor.getColumnIndexOrThrow(columnName));
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048536702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048536702;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndexOrThrow(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.214 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "C6D9EB180E1638256CAFF38FF49E6709")
    public String getColumnName(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_319336910 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_319336910 = mCursor.getColumnName(columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_319336910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_319336910;
        // ---------- Original Method ----------
        //return mCursor.getColumnName(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.224 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "F2F13C6BD401DAFBF9924E7EB087983A")
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_975684579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_975684579 = mCursor.getColumnNames();
        varB4EAC82CA7396A68D541C85D26508E83_975684579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_975684579;
        // ---------- Original Method ----------
        //return mCursor.getColumnNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.240 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "2190FDBB78B06AE7B9F046D9C4539E51")
    public double getDouble(int columnIndex) {
        double var1EBB2DC726B4ACFAFD58BAD7DE69C13B_97573545 = (mCursor.getDouble(columnIndex));
        addTaint(columnIndex);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1267214164 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1267214164;
        // ---------- Original Method ----------
        //return mCursor.getDouble(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.241 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "CA755EF19A905966C48500FBB6DEB962")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_991019866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_991019866 = mCursor.getExtras();
        varB4EAC82CA7396A68D541C85D26508E83_991019866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_991019866;
        // ---------- Original Method ----------
        //return mCursor.getExtras();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.243 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "235ED7BF8A537727C78CF113036A2B02")
    public float getFloat(int columnIndex) {
        float varEDBAB80B3F7EB49500830BBEC30048D5_2066930228 = (mCursor.getFloat(columnIndex));
        addTaint(columnIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1748380693 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1748380693;
        // ---------- Original Method ----------
        //return mCursor.getFloat(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.244 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "604BACDA2D4863347F311D875B2AEA67")
    public int getInt(int columnIndex) {
        int var983E50BA69B81975B003C59D826EB416_1908222469 = (mCursor.getInt(columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438984024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438984024;
        // ---------- Original Method ----------
        //return mCursor.getInt(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.254 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "188738E27939FAC353D392DE773902F7")
    public long getLong(int columnIndex) {
        long varFCD531CA53DCF0ED4AA4BFCC635D69F2_1875714361 = (mCursor.getLong(columnIndex));
        addTaint(columnIndex);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1196898404 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1196898404;
        // ---------- Original Method ----------
        //return mCursor.getLong(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.254 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "1412AAFB4017DCF1F582EE27197F5C9D")
    public short getShort(int columnIndex) {
        short varCFB1DCF76D3CB94ADAEF38883853A9F7_1902191200 = (mCursor.getShort(columnIndex));
        addTaint(columnIndex);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1558342131 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1558342131;
        // ---------- Original Method ----------
        //return mCursor.getShort(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.278 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "97E4D22D3F8BC7CAEA82FD094C4D65D5")
    public String getString(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_2123188314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2123188314 = mCursor.getString(columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_2123188314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2123188314;
        // ---------- Original Method ----------
        //return mCursor.getString(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.279 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "AFE847F5E45976046413605448233195")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        mCursor.copyStringToBuffer(columnIndex, buffer);
        addTaint(columnIndex);
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.281 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "AB17D36D7BA13C6CF83A44201FAC8DCD")
    public byte[] getBlob(int columnIndex) {
        byte[] var39847011BEE5629BB83F9D055F06426E_1968046954 = (mCursor.getBlob(columnIndex));
        addTaint(columnIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_934451233 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_934451233;
        // ---------- Original Method ----------
        //return mCursor.getBlob(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.281 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "7047D98849DFCB227BA9C0509ACC822A")
    public boolean getWantsAllOnMoveCalls() {
        boolean varB847E6B2CAC91DD66B8CA3491BEEAC14_301208914 = (mCursor.getWantsAllOnMoveCalls());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531144031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531144031;
        // ---------- Original Method ----------
        //return mCursor.getWantsAllOnMoveCalls();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.285 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "3619C617749F0578AD608C5F86E6ABF8")
    public boolean isAfterLast() {
        boolean var1AEEB2F8CBE8C12DA28D76897F1CDC26_1846436854 = (mCursor.isAfterLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719383171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719383171;
        // ---------- Original Method ----------
        //return mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.312 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "F2BF73D6EFB3872D9BD9BF28FDB6934E")
    public boolean isBeforeFirst() {
        boolean varCF818189B76A8E5C529E15D4A358318D_878300906 = (mCursor.isBeforeFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415510158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415510158;
        // ---------- Original Method ----------
        //return mCursor.isBeforeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.313 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "D203133028587E9F908B55C427195CD6")
    public boolean isFirst() {
        boolean var42B5D9A2F4526C834A0F6F6FAF6F6C31_1130611557 = (mCursor.isFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296216233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296216233;
        // ---------- Original Method ----------
        //return mCursor.isFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.313 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "21B5861BDAEF257F6AC170F472EA36F0")
    public boolean isLast() {
        boolean var637A705C5FBD923FC8FF4A9499366CF9_458182789 = (mCursor.isLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369829069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369829069;
        // ---------- Original Method ----------
        //return mCursor.isLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.314 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "16A7137D212386402F3D10F644FB5B93")
    public int getType(int columnIndex) {
        int var3261092579FE97F016CB6C6C690233F6_755570843 = (mCursor.getType(columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686225516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686225516;
        // ---------- Original Method ----------
        //return mCursor.getType(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.314 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "6416E5D397245D5CBA223ECBD3736D9E")
    public boolean isNull(int columnIndex) {
        boolean var3747DFCCBE8241FBFD30A41D55BA7853_1091531094 = (mCursor.isNull(columnIndex));
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2065715907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2065715907;
        // ---------- Original Method ----------
        //return mCursor.isNull(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.321 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "4C1BB8F5C98A733944D3A412F0950F29")
    public boolean moveToLast() {
        boolean var338BBB800254AF67336E1C3D4D5E1179_1455046221 = (mCursor.moveToLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314093153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314093153;
        // ---------- Original Method ----------
        //return mCursor.moveToLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.325 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "FD50FEDC5962F97DE92285AF53285DBF")
    public boolean move(int offset) {
        boolean varEEDC81F148299D2DE604C4560AE5EF44_1274598887 = (mCursor.move(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249249617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249249617;
        // ---------- Original Method ----------
        //return mCursor.move(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.326 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "6F8C0535AA69AF02E6319461C493771A")
    public boolean moveToPosition(int position) {
        boolean varBA4DCCC943083F7ACB7C7426B2B9222A_1649174695 = (mCursor.moveToPosition(position));
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31038936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_31038936;
        // ---------- Original Method ----------
        //return mCursor.moveToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.326 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "EE46529A08868A02EA67BE5343DC9E09")
    public boolean moveToNext() {
        boolean varE6C0DAC6CD5134BB1AD83C31436A9B39_911763689 = (mCursor.moveToNext());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795846825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795846825;
        // ---------- Original Method ----------
        //return mCursor.moveToNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.335 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "75E6A1A6238ECC7D68180102FC1DE0BD")
    public int getPosition() {
        int varF885A18917AF028639FF4CD81472E706_393045166 = (mCursor.getPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302365363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302365363;
        // ---------- Original Method ----------
        //return mCursor.getPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.351 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "2113DD58BF01583DEC3849C664DC1225")
    public boolean moveToPrevious() {
        boolean varF3ABFC2344333960F5FB9C4CBDC41C19_1254672974 = (mCursor.moveToPrevious());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_440412576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_440412576;
        // ---------- Original Method ----------
        //return mCursor.moveToPrevious();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.352 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "21D185709F3C90AD37548DB49AE5F801")
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCursor.registerContentObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.registerContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.352 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "8B93B1E84A8D61BABC59AFD2EBF37BB0")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCursor.registerDataSetObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.registerDataSetObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.353 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "FE5DF7F42DE92A69BA93B04EA9EB1E6B")
    public boolean requery() {
        boolean var77ED8C51772FFB766AF47CA67C514663_2081171975 = (mCursor.requery());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013487703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013487703;
        // ---------- Original Method ----------
        //return mCursor.requery();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.355 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "84D2AD29BE4F97B345815CC56C260129")
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1921953325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1921953325 = mCursor.respond(extras);
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1921953325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1921953325;
        // ---------- Original Method ----------
        //return mCursor.respond(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.452 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "8FF659515F22BAC8456B990797806EF1")
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        mCursor.setNotificationUri(cr, uri);
        addTaint(cr.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //mCursor.setNotificationUri(cr, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.453 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "0714002F976F0E81B009ED6AE3D8F628")
    public void unregisterContentObserver(ContentObserver observer) {
        mCursor.unregisterContentObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.unregisterContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.453 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "29BE63706C0D69313A1BB8DA1E79BF4D")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mCursor.unregisterDataSetObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.unregisterDataSetObserver(observer);
    }

    
}

