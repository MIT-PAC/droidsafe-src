package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper implements Cursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.824 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "B2F25E19BD844FCC3F1C8464C0B5BC23")

    protected Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.825 -0400", hash_original_method = "978CECAE21C2C2AADE050CB638E188D1", hash_generated_method = "5D389837C2CC65DEC4287272473DF588")
    public  CursorWrapper(Cursor cursor) {
        mCursor = cursor;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.826 -0400", hash_original_method = "316180AD618802065A1D51DA27AEB312", hash_generated_method = "AA1808E093CA4F09C9F5DB32139D7DC7")
    public Cursor getWrappedCursor() {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1879271703 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1879271703 = mCursor;
        varB4EAC82CA7396A68D541C85D26508E83_1879271703.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1879271703;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.827 -0400", hash_original_method = "A32297B2451395D36A70F03B3EF856B3", hash_generated_method = "B1AD05790457C8898701464AAE0F0B72")
    public void close() {
        mCursor.close();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.827 -0400", hash_original_method = "5DEC02E8332222A3B22751694FFC9CA1", hash_generated_method = "412DB08F7A054797C4D7C622D6DD301D")
    public boolean isClosed() {
        boolean varD253E499C6C962FE6520ABAFDC2DFA3A_2053215098 = (mCursor.isClosed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815781938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815781938;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.827 -0400", hash_original_method = "4FB48481E85DFE4DF2798ECB6EF0EBA3", hash_generated_method = "E945BB7F3B804A8621D64A6D2A5F838C")
    public int getCount() {
        int var633E90A13E59B5C21FDD84E62359C432_1626485667 = (mCursor.getCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313940069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313940069;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.828 -0400", hash_original_method = "93C3C298C44E28085902C4719EB89C5C", hash_generated_method = "0BCE346B7C70E5CAD483677FDAD72A36")
    public void deactivate() {
        mCursor.deactivate();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.828 -0400", hash_original_method = "06CE118A44B1EB36107893954A961568", hash_generated_method = "0D06EBD84A5DDA0EEB3BE911BF84410F")
    public boolean moveToFirst() {
        boolean var6553B635E7C5FD1A4088E45B0A641971_179516476 = (mCursor.moveToFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594741709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594741709;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.828 -0400", hash_original_method = "C4C5B8EA665B1F1B5035911D9DA414D1", hash_generated_method = "DE11B2C35E2B21CBA3AB335AAC20DA85")
    public int getColumnCount() {
        int var8D2C0EF2974275827688921832503CE9_143146643 = (mCursor.getColumnCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347285176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347285176;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.829 -0400", hash_original_method = "06516133B49C0C5A6C5AFB16F4A895DA", hash_generated_method = "193CD85F94AA56B86B40367DEB51A093")
    public int getColumnIndex(String columnName) {
        int var3D36C88EE2306414617596C46D011D1B_2069821699 = (mCursor.getColumnIndex(columnName));
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577915456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577915456;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.829 -0400", hash_original_method = "183DEEA59B2C5C3992AF879729130A44", hash_generated_method = "27DA555101FE0F810CBC142434C25394")
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        int varA27C403EFFBA82728364FC68A3881162_1313559434 = (mCursor.getColumnIndexOrThrow(columnName));
        addTaint(columnName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52959113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52959113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.830 -0400", hash_original_method = "44F4FED765CC72811EDC0508C80F64F0", hash_generated_method = "884765D937ED5FFB7ADCE59C880EF99B")
    public String getColumnName(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1339747668 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1339747668 = mCursor.getColumnName(columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_1339747668.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1339747668;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.831 -0400", hash_original_method = "142DD845520BC77B0415FE801987F673", hash_generated_method = "5CA2C48480CF63B42F6BB8840C36818B")
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1628001303 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1628001303 = mCursor.getColumnNames();
        varB4EAC82CA7396A68D541C85D26508E83_1628001303.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1628001303;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.831 -0400", hash_original_method = "9F7F0A57CF5F3A48DAAE9F30716DB422", hash_generated_method = "5B2550A448CCE76A5184E80B8B10544D")
    public double getDouble(int columnIndex) {
        double var1EBB2DC726B4ACFAFD58BAD7DE69C13B_1355694106 = (mCursor.getDouble(columnIndex));
        addTaint(columnIndex);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1137118959 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1137118959;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.831 -0400", hash_original_method = "E184C1E71949207A685F28F7AC8C3646", hash_generated_method = "F22998FCCA6D2D67601F9C8AA6B065CA")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1862993564 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1862993564 = mCursor.getExtras();
        varB4EAC82CA7396A68D541C85D26508E83_1862993564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1862993564;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.832 -0400", hash_original_method = "F5DCA7E84D61E5F6349F91894570619B", hash_generated_method = "F962CD1A3444399BA958A88447CEFF87")
    public float getFloat(int columnIndex) {
        float varEDBAB80B3F7EB49500830BBEC30048D5_1216969414 = (mCursor.getFloat(columnIndex));
        addTaint(columnIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1368005424 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1368005424;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.832 -0400", hash_original_method = "D5F704BE358AD76E0F36741C42927811", hash_generated_method = "E946BA435C7A7182D606BD9AA10FFD9E")
    public int getInt(int columnIndex) {
        int var983E50BA69B81975B003C59D826EB416_1849948415 = (mCursor.getInt(columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648303508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648303508;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.833 -0400", hash_original_method = "DBAEB8314692255BFDFEDFF2F8F2444F", hash_generated_method = "38FE788B9EDADF489C035D28D89FEC0F")
    public long getLong(int columnIndex) {
        long varFCD531CA53DCF0ED4AA4BFCC635D69F2_362510272 = (mCursor.getLong(columnIndex));
        addTaint(columnIndex);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1058635722 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1058635722;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.833 -0400", hash_original_method = "8A1862CAD8BC46E04F7A4A0E15FEBED8", hash_generated_method = "60B4175B6E0C8F6B59B7AA893198287F")
    public short getShort(int columnIndex) {
        short varCFB1DCF76D3CB94ADAEF38883853A9F7_315466334 = (mCursor.getShort(columnIndex));
        addTaint(columnIndex);
        short var4F09DAA9D95BCB166A302407A0E0BABE_221130200 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_221130200;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.834 -0400", hash_original_method = "A917FB9A6F4271AAEA85DB37049994B7", hash_generated_method = "2E0C68929682ABF1609307D5910A8860")
    public String getString(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_990651189 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_990651189 = mCursor.getString(columnIndex);
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_990651189.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_990651189;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.834 -0400", hash_original_method = "02F346D4D3A26C5C11BF930F7BAB9BCB", hash_generated_method = "AFE847F5E45976046413605448233195")
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        mCursor.copyStringToBuffer(columnIndex, buffer);
        addTaint(columnIndex);
        addTaint(buffer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.835 -0400", hash_original_method = "8A5315F98F575EC2DBE296FDFC892823", hash_generated_method = "6B8A90B9E471EB3399CFBBD9BBDF65FD")
    public byte[] getBlob(int columnIndex) {
        byte[] var39847011BEE5629BB83F9D055F06426E_1921137135 = (mCursor.getBlob(columnIndex));
        addTaint(columnIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_264310466 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_264310466;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.835 -0400", hash_original_method = "202148D6DFB69703DB83E4D657686D7A", hash_generated_method = "F034F3DE2A8AC42D2520986A6C414FE9")
    public boolean getWantsAllOnMoveCalls() {
        boolean varB847E6B2CAC91DD66B8CA3491BEEAC14_793102593 = (mCursor.getWantsAllOnMoveCalls());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1917735028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1917735028;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.836 -0400", hash_original_method = "6CEAAB581364F2242F0510BD20864F0A", hash_generated_method = "ED7097EB36DBD75B2E504CC0C5970832")
    public boolean isAfterLast() {
        boolean var1AEEB2F8CBE8C12DA28D76897F1CDC26_1380411938 = (mCursor.isAfterLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557879230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_557879230;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.837 -0400", hash_original_method = "9724A911B02F8EEE299930C41A938B35", hash_generated_method = "BE2053609231E798C6E77E983606296F")
    public boolean isBeforeFirst() {
        boolean varCF818189B76A8E5C529E15D4A358318D_41898400 = (mCursor.isBeforeFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991181025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991181025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.837 -0400", hash_original_method = "AE369C1E746453E8FDB978D423AA468D", hash_generated_method = "AAE2CFE6E3D5154F1065E56E6E65C710")
    public boolean isFirst() {
        boolean var42B5D9A2F4526C834A0F6F6FAF6F6C31_1278283998 = (mCursor.isFirst());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652741996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652741996;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.838 -0400", hash_original_method = "85178A9F90BC671A8327CD0DCBCFC22F", hash_generated_method = "C752DD6B9948BC49EA74C6D00D98DB9C")
    public boolean isLast() {
        boolean var637A705C5FBD923FC8FF4A9499366CF9_1087172051 = (mCursor.isLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969216583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969216583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.838 -0400", hash_original_method = "5A8E2D5ED8A7C02D6DE5EB672DC6B0F6", hash_generated_method = "B5029BCC497E59F57D905C6632C0D647")
    public int getType(int columnIndex) {
        int var3261092579FE97F016CB6C6C690233F6_876848218 = (mCursor.getType(columnIndex));
        addTaint(columnIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936883930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936883930;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.839 -0400", hash_original_method = "1190037F31ED82403F2DEAD37B1DC820", hash_generated_method = "40779DCCDC77D3C7D0D6B7854C66E6CC")
    public boolean isNull(int columnIndex) {
        boolean var3747DFCCBE8241FBFD30A41D55BA7853_421957297 = (mCursor.isNull(columnIndex));
        addTaint(columnIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671740880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_671740880;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.839 -0400", hash_original_method = "347262A632C8F04E94685CE61DC31CB9", hash_generated_method = "02626B4A0DDB3FF43DCD16816DE060AB")
    public boolean moveToLast() {
        boolean var338BBB800254AF67336E1C3D4D5E1179_330759110 = (mCursor.moveToLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17290821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_17290821;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.839 -0400", hash_original_method = "681CB7A15AB6E4D99994A16A8D62CA1B", hash_generated_method = "39F3783EA61CEF00C1117CC5820CEF40")
    public boolean move(int offset) {
        boolean varEEDC81F148299D2DE604C4560AE5EF44_441188290 = (mCursor.move(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_760227453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_760227453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.840 -0400", hash_original_method = "E96208B3363A366F1157461AED6DEFE6", hash_generated_method = "9C3B4E05BA5FF9277147A7FA5A05C3D6")
    public boolean moveToPosition(int position) {
        boolean varBA4DCCC943083F7ACB7C7426B2B9222A_467616913 = (mCursor.moveToPosition(position));
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650388753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650388753;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.840 -0400", hash_original_method = "61AD5F99CAC7AA88894F37D4F04385DE", hash_generated_method = "A6F1FF9C50AD8FD6AECCA4C3F71EB57B")
    public boolean moveToNext() {
        boolean varE6C0DAC6CD5134BB1AD83C31436A9B39_1965552939 = (mCursor.moveToNext());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460883118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_460883118;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.840 -0400", hash_original_method = "F334605A0394588BA27C8173FC6583D2", hash_generated_method = "5229407B696D6DEF249F20411469F64B")
    public int getPosition() {
        int varF885A18917AF028639FF4CD81472E706_1344946400 = (mCursor.getPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111934385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111934385;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.841 -0400", hash_original_method = "9DCA0D28086B67B8460553C230FFD999", hash_generated_method = "CA7C8FCDD60F13E49FBC9974B083CEBC")
    public boolean moveToPrevious() {
        boolean varF3ABFC2344333960F5FB9C4CBDC41C19_900268692 = (mCursor.moveToPrevious());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501353825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501353825;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.841 -0400", hash_original_method = "5A8FF5438803408ADF8327CD33517673", hash_generated_method = "21D185709F3C90AD37548DB49AE5F801")
    public void registerContentObserver(ContentObserver observer) {
        
        mCursor.registerContentObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.842 -0400", hash_original_method = "1A519BACFE68557E172B555F0410D9EB", hash_generated_method = "8B93B1E84A8D61BABC59AFD2EBF37BB0")
    public void registerDataSetObserver(DataSetObserver observer) {
        
        mCursor.registerDataSetObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.842 -0400", hash_original_method = "913F5AF57DF0A93E7786005DA9809F4B", hash_generated_method = "F6E7469EBF8E63639D1B3F30F9C91A87")
    public boolean requery() {
        boolean var77ED8C51772FFB766AF47CA67C514663_1088398494 = (mCursor.requery());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396421025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396421025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.843 -0400", hash_original_method = "3363FE24C95CAC66FEDAAD7C15293549", hash_generated_method = "CDD37336827C1736CD0DE16EAD727F7B")
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1319398182 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1319398182 = mCursor.respond(extras);
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1319398182.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1319398182;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.843 -0400", hash_original_method = "EE868502A4046B2104E93564DA0F8447", hash_generated_method = "8FF659515F22BAC8456B990797806EF1")
    public void setNotificationUri(ContentResolver cr, Uri uri) {
        mCursor.setNotificationUri(cr, uri);
        addTaint(cr.getTaint());
        addTaint(uri.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.843 -0400", hash_original_method = "18E3DACEB476AA178948B9F95BF27A70", hash_generated_method = "0714002F976F0E81B009ED6AE3D8F628")
    public void unregisterContentObserver(ContentObserver observer) {
        mCursor.unregisterContentObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.844 -0400", hash_original_method = "81F4645F170671B34D8F1F059DABD812", hash_generated_method = "29BE63706C0D69313A1BB8DA1E79BF4D")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mCursor.unregisterDataSetObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
}

