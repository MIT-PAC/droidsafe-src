package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;




final class ReadOnlyDirectByteBuffer extends DirectByteBuffer {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.488 -0400", hash_original_method = "1715B2F560D367598620CD9007B078BC", hash_generated_method = "426B36C41F046723EB3E8E02520E14CD")
    protected  ReadOnlyDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
        addTaint(offset);
        addTaint(capacity);
        addTaint(block.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    static ReadOnlyDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadOnlyDirectByteBuffer buf = new ReadOnlyDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.488 -0400", hash_original_method = "2BD76B330996D00438E1C4822CA878DE", hash_generated_method = "8AFFFBB8FB05A993D2B9C2B54E1E2D7C")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_603648087 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_603648087.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_603648087;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.489 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "40AD5D56A57D6D9CC543DE3E367395DB")
    @Override
    public ByteBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_865274151 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_865274151.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_865274151;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.489 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "441920AC874BC0E16297E0A327E2E94C")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_1093398128 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1093398128.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1093398128;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.489 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "5929F76E72B5CA98492B0554166AB2C1")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_364030233 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912115242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912115242;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.490 -0400", hash_original_method = "7260EDFD38A12D119BC6271ED3EA27DF", hash_generated_method = "C8F2123AF48F06706D8D32FFF175544C")
    @Override
    public ByteBuffer put(byte value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1945110958 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1945110958.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1945110958;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.491 -0400", hash_original_method = "1C2CBE90B4E9D1A3B1F660933A2EE69D", hash_generated_method = "86F7B69B58710B60651EA8017E5D4F00")
    @Override
    public ByteBuffer put(int index, byte value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_816542089 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_816542089.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_816542089;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.492 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "498E2E58F392A1D9AC885D8915110A95")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1476534787 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1476534787.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1476534787;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.492 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "BBF528FA8B41C6448BCBBB60863B79BC")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_224149080 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_224149080.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_224149080;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.493 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "22CD9B3A5098A8DF933B0FD08AD2FEA2")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_269012788 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_269012788.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_269012788;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.493 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "921EA6CB0F41EA9EA5FFDD7D4D4FD94A")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_279932650 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_279932650.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_279932650;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.493 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "D767C7FD10FF669F004F17583D099677")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_718343620 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_718343620.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_718343620;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.494 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "1E39BE4199319AB4D1E95E60FEE8279B")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_479723604 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_479723604.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_479723604;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.494 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "3EF049B54C83EE970B171874C11EF1F9")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1021707035 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1021707035.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1021707035;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.494 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "FF4B68F5EE0A64A774BA3C6043EEBADE")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1771186608 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1771186608.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1771186608;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.495 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "E8F5AB58AE74FBADE30328A93C386698")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_833966143 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_833966143.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_833966143;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.495 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "C42D26234C1A3134D5378414C20B5346")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_270263102 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_270263102.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_270263102;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.495 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "9C414BFD87DF57417FF27512D52EA798")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1924011119 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1924011119.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1924011119;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.496 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "77D06201D8BE429DE626094A2D614F44")
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1295766117 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1295766117.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1295766117;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.496 -0400", hash_original_method = "A324C872B4E541735F8503145991A120", hash_generated_method = "AD0D4252514D0C09E0166D2798BFF6AA")
    @Override
    public ByteBuffer slice() {
ByteBuffer var39B8EAA049368B4AC6DC05DE5D64DE8F_343479248 =         new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
        var39B8EAA049368B4AC6DC05DE5D64DE8F_343479248.addTaint(taint);
        return var39B8EAA049368B4AC6DC05DE5D64DE8F_343479248;
        // ---------- Original Method ----------
        //return new ReadOnlyDirectByteBuffer(block, remaining(), offset + position);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.497 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "4BD7B560F77B8C13245CFDD5DD445D95")
    @Override
    protected byte[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1147906292 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1147906292.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1147906292;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.497 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "B4212CEE08EBF3D1A4CD29FFCEABC188")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_797050500 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_797050500.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_797050500;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.498 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "41778FD9B8468B3FF83611AB1C09E36F")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1048472245 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688362149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688362149;
        // ---------- Original Method ----------
        //return false;
    }

    
}

