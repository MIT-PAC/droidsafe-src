package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyDirectByteBuffer extends DirectByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.942 -0400", hash_original_method = "1715B2F560D367598620CD9007B078BC", hash_generated_method = "426B36C41F046723EB3E8E02520E14CD")
    protected  ReadOnlyDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        addTaint(offset);
        addTaint(capacity);
        addTaint(block.getTaint());
        // ---------- Original Method ----------
    }

    
        static ReadOnlyDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadOnlyDirectByteBuffer buf = new ReadOnlyDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.943 -0400", hash_original_method = "2BD76B330996D00438E1C4822CA878DE", hash_generated_method = "0A6F2840EBEE8A4CA823E34091096035")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_125911657 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_125911657.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_125911657;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.943 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "B3D28EC64DA2C0AD2E4F0EA299B167A4")
    @Override
    public ByteBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_984986720 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_984986720.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_984986720;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.944 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "9AC76C4D4C1A55256C8A8CD1A529C9F3")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_1548155088 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1548155088.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1548155088;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.944 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "BEEE091F17D73114CD48B38190A4C11E")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1854661016 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734809856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734809856;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.944 -0400", hash_original_method = "7260EDFD38A12D119BC6271ED3EA27DF", hash_generated_method = "38D27ED8ABF1370105384F9DD828A47A")
    @Override
    public ByteBuffer put(byte value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1520551770 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1520551770.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1520551770;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.945 -0400", hash_original_method = "1C2CBE90B4E9D1A3B1F660933A2EE69D", hash_generated_method = "D35F9A089A2BC58A06F982CAF3508FAF")
    @Override
    public ByteBuffer put(int index, byte value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1213243333 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1213243333.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1213243333;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.945 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "6AE43BBC66C3AA6E6EF79ADD6EB13BD8")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_604384715 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_604384715.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_604384715;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.946 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "3B559C7B6B98B18808056531BC50EE08")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1512324897 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1512324897.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1512324897;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.947 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "7852930C3FAD9978C0380701167AE60B")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1264835346 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1264835346.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1264835346;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.947 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "129B592838DF04BC2A80A8A41D2824F4")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_297655733 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_297655733.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_297655733;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.948 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "7D26C7CA72AB977FF12B2C895CBE2297")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_89180459 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_89180459.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_89180459;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.948 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "075D2B7DFCC8C90BE86B08ACDCF99C85")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_892597111 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_892597111.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_892597111;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.949 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "B16832CFD5B93D08E6BDC2AE27E2C164")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1795682312 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1795682312.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1795682312;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.949 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "004431D6E8EF19425CC6FA797A6FF11B")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1864209211 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1864209211.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1864209211;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.950 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "7F822B6BD0C04F6BC7900009FA20802B")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_745476570 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_745476570.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_745476570;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.951 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "900B2D30672E271CDA8AF382AEC34461")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1801129759 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1801129759.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1801129759;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.952 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "F9AAE2BC32F7DD582D0F3A777F999DFC")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1110173185 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1110173185.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1110173185;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.952 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "E3C6156619DAD97ADAAEF69519C9AE79")
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1578315139 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1578315139.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1578315139;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.953 -0400", hash_original_method = "A324C872B4E541735F8503145991A120", hash_generated_method = "4AA94A4AE8BD5D0A1E97C1CB50DA1F2B")
    @Override
    public ByteBuffer slice() {
ByteBuffer var39B8EAA049368B4AC6DC05DE5D64DE8F_196194382 =         new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
        var39B8EAA049368B4AC6DC05DE5D64DE8F_196194382.addTaint(taint);
        return var39B8EAA049368B4AC6DC05DE5D64DE8F_196194382;
        // ---------- Original Method ----------
        //return new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.953 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "19A0FECD0F07B4F82DB038F0E15EFAE0")
    @Override
    protected byte[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_35436850 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_35436850.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_35436850;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.954 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "166D1BF40F0E203DD2FA394C2A358303")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_231703071 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_231703071.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_231703071;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.954 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "57133FCBAE8C3D42313028AB3787F897")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_854292300 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156138932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156138932;
        // ---------- Original Method ----------
        //return false;
    }

    
}

