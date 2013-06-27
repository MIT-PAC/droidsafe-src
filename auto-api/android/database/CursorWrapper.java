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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.879 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.881 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "5D389837C2CC65DEC4287272473DF588")
    public  CursorWrapper(Cursor cursor) {
        mCursor = cursor;
        // ---------- Original Method ----------
        //mCursor = cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.897 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "6C975F890789DC7EF87D1C443DCFAABC")
    public Cursor getWrappedCursor() {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1494206123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1494206123 = mCursor;
        varB4EAC82CA7396A68D541C85D26508E83_1494206123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1494206123;
        // ---------- Original Method ----------
        //return mCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.900 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "B1AD05790457C8898701464AAE0F0B72")
    public void close() {
        mCursor.close();
        // ---------- Original Method ----------
        //mCursor.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.901 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "1568D8DE3441787084579390471D9C88")
    public boolean isClosed() {
        boolean varD253E499C6C962FE6520ABAFDC2DFA3A_904560512 = (mCursor.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662004231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662004231;
        // ---------- Original Method ----------
        //return mCursor.isClosed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.907 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "92C819CDC1B0249D61DCF1F8351862B4")
    public int getCount() {
        int var633E90A13E59B5C21FDD84E62359C432_486085815 = (mCursor.getCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623717927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623717927;
        // ---------- Original Method ----------
        //return mCursor.getCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.918 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "0BCE346B7C70E5CAD483677FDAD72A36")
    public void deactivate() {
        mCursor.deactivate();
        // ---------- Original Method ----------
        //mCursor.deactivate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.925 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "269E7DBDA73FFBAEAF681DE48B4FA71A")
    public boolean moveToFirst() {
        boolean var6553B635E7C5FD1A4088E45B0A641971_1655034231 = (mCursor.moveToFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108422653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108422653;
        // ---------- Original Method ----------
        //return mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.930 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "343599E4A00963C2F45BF9F498623F3A")
    public int getColumnCount() {
        int var8D2C0EF2974275827688921832503CE9_1096837830 = (mCursor.getColumnCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888035888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888035888;
        // ---------- Original Method ----------
        //return mCursor.getColumnCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.937 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "9BA1259B2ACDCB314B3D0C6B0FD2BD39")
    public int getColumnIndex(String columnName) {
        int var3D36C88EE2306414617596C46D011D1B_2044456736 = (mCursor.getColumnIndex(columnName));
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885254488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885254488;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndex(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.961 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "08C329967A74DA8E60148FBD6184C60B")
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        int varA27C403EFFBA82728364FC68A3881162_304512507 = (mCursor.getColumnIndexOrThrow(columnName));
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820344942 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820344942;
        // ---------- Original Method ----------
        //return mCursor.getColumnIndexOrThrow(columnName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.963 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "3EE73C3A364FC28BF143880879B5A424")
    public String getColumnName(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1272859819 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1272859819 = mCursor.getColumnName(columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1272859819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1272859819;
        // ---------- Original Method ----------
        //return mCursor.getColumnName(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.974 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "A6541C32255B01BD902879FEBA42CB2B")
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_849075981 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_849075981 = mCursor.getColumnNames();
        varB4EAC82CA7396A68D541C85D26508E83_849075981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_849075981;
        // ---------- Original Method ----------
        //return mCursor.getColumnNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.975 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "27CF02426D1273FAB76049A26F740D34")
    public double getDouble(int columnIndex) {
        double var1EBB2DC726B4ACFAFD58BAD7DE69C13B_2002424445 = (mCursor.getDouble(columnIndex));
        addTaint(columnIndex);
        double varE8CD7DA078A86726031AD64F35F5A6C0_124651339 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_124651339;
        // ---------- Original Method ----------
        //return mCursor.getDouble(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.976 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "E4FDD653507314E58B223E59907CCC90")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1542755361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1542755361 = mCursor.getExtras();
        varB4EAC82CA7396A68D541C85D26508E83_1542755361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542755361;
        // ---------- Original Method ----------
        //return mCursor.getExtras();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.981 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "71BAA2F74D51B98F171620EA667AF122")
    public float getFloat(int columnIndex) {
        float varEDBAB80B3F7EB49500830BBEC30048D5_438387519 = (mCursor.getFloat(columnIndex));
        addTaint(columnIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_253890654 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_253890654;
        // ---------- Original Method ----------
        //return mCursor.getFloat(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.002 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "69CD45E7461E66EF542C323EFC9D8317")
    public int getInt(int columnIndex) {
        int var983E50BA69B81975B003C59D826EB416_1523427366 = (mCursor.getInt(columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742877579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742877579;
        // ---------- Original Method ----------
        //return mCursor.getInt(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.003 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "8B62483824E6E2CEAE7C05550B9BDF64")
    public long getLong(int columnIndex) {
        long varFCD531CA53DCF0ED4AA4BFCC635D69F2_1882838833 = (mCursor.getLong(columnIndex));
        addTaint(columnIndex);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1939059045 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1939059045;
        // ---------- Original Method ----------
        //return mCursor.getLong(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.004 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "3CA7EECA1EFE6D3FC67C175BE87FC220")
    public short getShort(int columnIndex) {
        short varCFB1DCF76D3CB94ADAEF38883853A9F7_753422052 = (mCursor.getShort(columnIndex));
        addTaint(columnIndex);
        short var4F09DAA9D95BCB166A302407A0E0BABE_617774709 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_617774709;
        // ---------- Original Method ----------
        //return mCursor.getShort(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.019 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "EE8D2CAEB6F22D031C13D73B9D43577F")
    public String getString(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1162509952 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1162509952 = mCursor.getString(columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1162509952.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1162509952;
        // ---------- Original Method ----------
        //return mCursor.getString(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.020 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "AFE847F5E45976046413605448233195")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        mCursor.copyStringToBuffer(columnIndex, buffer);
        addTaint(columnIndex);
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //mCursor.copyStringToBuffer(columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.021 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "EF8B2F8FCC41C8AE7333373F14E7675C")
    public byte[] getBlob(int columnIndex) {
        byte[] var39847011BEE5629BB83F9D055F06426E_1304154411 = (mCursor.getBlob(columnIndex));
        addTaint(columnIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_249015305 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_249015305;
        // ---------- Original Method ----------
        //return mCursor.getBlob(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.022 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "CA77571BCAEA680D129633E5E0215F4C")
    public boolean getWantsAllOnMoveCalls() {
        boolean varB847E6B2CAC91DD66B8CA3491BEEAC14_1478317895 = (mCursor.getWantsAllOnMoveCalls());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227105163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227105163;
        // ---------- Original Method ----------
        //return mCursor.getWantsAllOnMoveCalls();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.023 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "0FEF1E9D84F0880BA6405AE96D21A3AF")
    public boolean isAfterLast() {
        boolean var1AEEB2F8CBE8C12DA28D76897F1CDC26_598323782 = (mCursor.isAfterLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_786997493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_786997493;
        // ---------- Original Method ----------
        //return mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.038 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "451171ABEB118B00E20683B7DE3DFDB9")
    public boolean isBeforeFirst() {
        boolean varCF818189B76A8E5C529E15D4A358318D_1454339743 = (mCursor.isBeforeFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619374386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_619374386;
        // ---------- Original Method ----------
        //return mCursor.isBeforeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.039 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "1F432F378B0EC970795D16971D00D056")
    public boolean isFirst() {
        boolean var42B5D9A2F4526C834A0F6F6FAF6F6C31_1887760137 = (mCursor.isFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123236385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123236385;
        // ---------- Original Method ----------
        //return mCursor.isFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.040 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "E64D9876E03153E8877160058B925745")
    public boolean isLast() {
        boolean var637A705C5FBD923FC8FF4A9499366CF9_445680724 = (mCursor.isLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54438468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_54438468;
        // ---------- Original Method ----------
        //return mCursor.isLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.041 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "FD12AF54169F641D7B590A8C0D8D8915")
    public int getType(int columnIndex) {
        int var3261092579FE97F016CB6C6C690233F6_750228722 = (mCursor.getType(columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271338084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1271338084;
        // ---------- Original Method ----------
        //return mCursor.getType(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.061 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "42A6CC30FDC67E28237EB91BE2EBF848")
    public boolean isNull(int columnIndex) {
        boolean var3747DFCCBE8241FBFD30A41D55BA7853_1312676505 = (mCursor.isNull(columnIndex));
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972171013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972171013;
        // ---------- Original Method ----------
        //return mCursor.isNull(columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.062 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "4127528635990A5A9A5AC6DBA86458DA")
    public boolean moveToLast() {
        boolean var338BBB800254AF67336E1C3D4D5E1179_1746996646 = (mCursor.moveToLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677128886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677128886;
        // ---------- Original Method ----------
        //return mCursor.moveToLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.063 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "DE5835F6003147C14FF2E39A74B44E4D")
    public boolean move(int offset) {
        boolean varEEDC81F148299D2DE604C4560AE5EF44_989893666 = (mCursor.move(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106015186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106015186;
        // ---------- Original Method ----------
        //return mCursor.move(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.063 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "3E484A9FBB6887B0B43F41369F8714C4")
    public boolean moveToPosition(int position) {
        boolean varBA4DCCC943083F7ACB7C7426B2B9222A_425294511 = (mCursor.moveToPosition(position));
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510388480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510388480;
        // ---------- Original Method ----------
        //return mCursor.moveToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.076 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "A8EA863EF479DEE7213484F3FEE86D50")
    public boolean moveToNext() {
        boolean varE6C0DAC6CD5134BB1AD83C31436A9B39_2018666162 = (mCursor.moveToNext());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942589147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942589147;
        // ---------- Original Method ----------
        //return mCursor.moveToNext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.077 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "417969673D4211B641C08C171B10F587")
    public int getPosition() {
        int varF885A18917AF028639FF4CD81472E706_176629566 = (mCursor.getPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870734780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870734780;
        // ---------- Original Method ----------
        //return mCursor.getPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.078 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "6311E6A6C14A01C07EF99633F0312995")
    public boolean moveToPrevious() {
        boolean varF3ABFC2344333960F5FB9C4CBDC41C19_1057998140 = (mCursor.moveToPrevious());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902432069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_902432069;
        // ---------- Original Method ----------
        //return mCursor.moveToPrevious();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.078 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "21D185709F3C90AD37548DB49AE5F801")
    public void registerContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCursor.registerContentObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.registerContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.094 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "8B93B1E84A8D61BABC59AFD2EBF37BB0")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCursor.registerDataSetObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.registerDataSetObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.095 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "942E8FCB6829D4C5C3F02A100D1CAA5C")
    public boolean requery() {
        boolean var77ED8C51772FFB766AF47CA67C514663_1341562002 = (mCursor.requery());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328645172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328645172;
        // ---------- Original Method ----------
        //return mCursor.requery();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.096 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "5242681195B9A91368324D0B7BB8D754")
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_411480017 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_411480017 = mCursor.respond(extras);
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_411480017.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_411480017;
        // ---------- Original Method ----------
        //return mCursor.respond(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.097 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "8FF659515F22BAC8456B990797806EF1")
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        mCursor.setNotificationUri(cr, uri);
        addTaint(cr.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //mCursor.setNotificationUri(cr, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.111 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "0714002F976F0E81B009ED6AE3D8F628")
    public void unregisterContentObserver(ContentObserver observer) {
        mCursor.unregisterContentObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.unregisterContentObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.112 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "29BE63706C0D69313A1BB8DA1E79BF4D")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mCursor.unregisterDataSetObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mCursor.unregisterDataSetObserver(observer);
    }

    
}

