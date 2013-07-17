package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.551 -0400", hash_original_method = "2F2ACF3B9ABB2D0DAB5827DF665B4EAD", hash_generated_method = "ADD15A2FAC24AC8EC07A888A2F0772A0")
      ReadOnlyHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        addTaint(arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    static ReadOnlyHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadOnlyHeapByteBuffer buf =
                new ReadOnlyHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.551 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "1F51D7A1DFAB4F2F9B4AFF9069586A05")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer varCA612679CD85B02158BA6D776D286658_1036016310 =         ReadOnlyHeapByteBuffer.copy(this, mark);
        varCA612679CD85B02158BA6D776D286658_1036016310.addTaint(taint);
        return varCA612679CD85B02158BA6D776D286658_1036016310;
        // ---------- Original Method ----------
        //return ReadOnlyHeapByteBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.551 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "06279BE8F94B6F52A28F5990549AB183")
    @Override
    public ByteBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1606291872 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1606291872.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1606291872;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.552 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "C4774FC962CEA90BAAE4371097651CC8")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_847653909 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_847653909.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_847653909;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.552 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1B9D7BFFFF8B44FBBD41FF1B352CD537")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1997359203 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236223264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236223264;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.552 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "DB24D547F00E39E5E8098F8C0F73F0F3")
    @Override
    protected byte[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1198529951 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1198529951.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1198529951;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.553 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "CE4F46DC521E56568D0FF7C10C26C988")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_694397442 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_694397442.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_694397442;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.553 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "9914782B4A47C6A7D1AD9FA0C7701B88")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1832429447 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356382135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356382135;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.553 -0400", hash_original_method = "F6BE9BC005619EB0DCAA2A874D1401FC", hash_generated_method = "DE3E77CA6A7851C799454368DE659A20")
    @Override
    public ByteBuffer put(byte b) {
        addTaint(b);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1703097658 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1703097658.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1703097658;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.554 -0400", hash_original_method = "3C5952D8FAADE293E2AA7CAEA3FBDFDE", hash_generated_method = "A020C29649822118B6325FA05B4F38EE")
    @Override
    public ByteBuffer put(int index, byte b) {
        addTaint(b);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1598935428 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1598935428.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1598935428;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.554 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "774752A128123EC4B96E03858F8EFD23")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_767419459 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_767419459.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_767419459;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.554 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "DA1A8C1A6778BAC9DEAB7617AFFD8C78")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1265846140 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1265846140.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1265846140;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.555 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "3E93B847D921412C457C139DAC105052")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1237489722 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1237489722.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1237489722;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.555 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "65FB06674ACFAF134D2296B6CC86E124")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1664513758 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1664513758.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1664513758;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.555 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "F5CD09337DC6CA4162C17D655893EA68")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1819271793 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1819271793.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1819271793;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.556 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "7CE40577422923F61F02F69FBE61F7DF")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2113639325 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2113639325.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2113639325;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.556 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "7FFD4984CC3D8A6C199269ED01F44EBF")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_769481103 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_769481103.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_769481103;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.556 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "623A0A093ED11F8245E5177704D770D6")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_31523022 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_31523022.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_31523022;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.557 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "A7E58276FB785C7B3F7ED5AD0CA0FFD7")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_903854759 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_903854759.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_903854759;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.557 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "5EE5819B12E77E81D670FE5707F4CC7E")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2067472447 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2067472447.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2067472447;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.557 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "59E0C56B4DD9EB3D8786FB13F7586B55")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_857338574 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_857338574.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_857338574;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.558 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "C244D7B9B9C83DCDF29ED3BDA2761E37")
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1016554338 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1016554338.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1016554338;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.558 -0400", hash_original_method = "6FE9FDD30B055D5D0C17F2FBAA978884", hash_generated_method = "8D7A0DFFDB37636CD09B0E6452E27AD6")
    @Override
    public ByteBuffer slice() {
ByteBuffer varEAEC2CB07F6584710EFB1E4523BCE8EA_1707786844 =         new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
        varEAEC2CB07F6584710EFB1E4523BCE8EA_1707786844.addTaint(taint);
        return varEAEC2CB07F6584710EFB1E4523BCE8EA_1707786844;
        // ---------- Original Method ----------
        //return new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
    }

    
}

