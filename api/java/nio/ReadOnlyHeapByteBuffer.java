package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyHeapByteBuffer extends HeapByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.985 -0400", hash_original_method = "2F2ACF3B9ABB2D0DAB5827DF665B4EAD", hash_generated_method = "ADD15A2FAC24AC8EC07A888A2F0772A0")
      ReadOnlyHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
        super(backingArray, capacity, arrayOffset);
        addTaint(arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        
    }

    
        static ReadOnlyHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
        ReadOnlyHeapByteBuffer buf =
                new ReadOnlyHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.986 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "23EF37092A2ED46F6CF0AC85D8810913")
    @Override
    public ByteBuffer asReadOnlyBuffer() {
ByteBuffer varCA612679CD85B02158BA6D776D286658_618817504 =         ReadOnlyHeapByteBuffer.copy(this, mark);
        varCA612679CD85B02158BA6D776D286658_618817504.addTaint(taint);
        return varCA612679CD85B02158BA6D776D286658_618817504;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.986 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "21D797FDB8137FA1E5BB243FDE13F3A9")
    @Override
    public ByteBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_625874900 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_625874900.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_625874900;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.987 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "752E7587421FBBC2C22F52385154B256")
    @Override
    public ByteBuffer duplicate() {
ByteBuffer var6ED4708F04CD11720ECFFDBFD927116F_1073320571 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1073320571.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1073320571;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.987 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "53E69673D3059AD94111388B72AAC256")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1107175462 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_189810966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_189810966;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.987 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "FA90F0D6B9A944CCA46F3C74609C3AE3")
    @Override
    protected byte[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1737841614 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1737841614.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1737841614;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.988 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "DAB705F4ECC92170009936BA0A0A9166")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1111860052 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1111860052.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1111860052;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.988 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "BDE56401CF801E67E08C9666D573C21A")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_357334968 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361137963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361137963;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.988 -0400", hash_original_method = "F6BE9BC005619EB0DCAA2A874D1401FC", hash_generated_method = "3D79FCEEE130D01A130E37EBD77C098F")
    @Override
    public ByteBuffer put(byte b) {
        addTaint(b);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_432160019 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_432160019.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_432160019;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.989 -0400", hash_original_method = "3C5952D8FAADE293E2AA7CAEA3FBDFDE", hash_generated_method = "357EEA80D979C5BCEAD2C158807C98CA")
    @Override
    public ByteBuffer put(int index, byte b) {
        addTaint(b);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2067986576 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2067986576.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2067986576;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.989 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "5B3B58BD5A7BAA2CB1ED49EEA3353896")
    @Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_661343888 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_661343888.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_661343888;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.989 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "D1CDFDD5716C91F199A4868C03F27556")
    @Override
    public ByteBuffer putDouble(double value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1486599937 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1486599937.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1486599937;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.990 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "20BAB5DAEC93DAA04C67BB5667E986F7")
    @Override
    public ByteBuffer putDouble(int index, double value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1392456147 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1392456147.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1392456147;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.990 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "6CE07008C95F80EB36E0E5DB78E399D6")
    @Override
    public ByteBuffer putFloat(float value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1477955871 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1477955871.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1477955871;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.991 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "2605FAC223C496643086994225F2FBBC")
    @Override
    public ByteBuffer putFloat(int index, float value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1531502675 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1531502675.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1531502675;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.991 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "748FF2AE49BA3D437674633DA04B43F7")
    @Override
    public ByteBuffer putInt(int value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_537475062 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_537475062.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_537475062;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.991 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "EC93578690CEC89C3F622F9935991211")
    @Override
    public ByteBuffer putInt(int index, int value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_841344990 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_841344990.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_841344990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.992 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "80F79F37C13D520C0AA3659ED45AC548")
    @Override
    public ByteBuffer putLong(int index, long value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2132700737 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2132700737.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2132700737;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.992 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "D6987862B7D5C9787499B68DDD623E0D")
    @Override
    public ByteBuffer putLong(long value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_380392116 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_380392116.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_380392116;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.992 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "11E8C48A82CCAA3F5ABC9B74602E622C")
    @Override
    public ByteBuffer putShort(int index, short value) {
        addTaint(value);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1874475338 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1874475338.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1874475338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.993 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "381768A769DE76C50CD6E3FD0615EDEE")
    @Override
    public ByteBuffer putShort(short value) {
        addTaint(value);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1404155018 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1404155018.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1404155018;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.993 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "0592AB66CD274BA6E8F510B79ECE7D2C")
    @Override
    public ByteBuffer put(ByteBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1403018952 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1403018952.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1403018952;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.993 -0400", hash_original_method = "6FE9FDD30B055D5D0C17F2FBAA978884", hash_generated_method = "7EE3923CDEA4E8506EBC3D4FB273DEC7")
    @Override
    public ByteBuffer slice() {
ByteBuffer varEAEC2CB07F6584710EFB1E4523BCE8EA_916057738 =         new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
        varEAEC2CB07F6584710EFB1E4523BCE8EA_916057738.addTaint(taint);
        return varEAEC2CB07F6584710EFB1E4523BCE8EA_916057738;
        
        
    }

    
}

