package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

abstract class BaseByteBuffer extends ByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.177 -0400", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "C94DE637A62A36C14B152011F022CD27")
    protected  BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
        addTaint(block.getTaint());
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.177 -0400", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "4D0A6901437F9C2423FCBF911C73A6AB")
    @Override
    public final CharBuffer asCharBuffer() {
CharBuffer var8836A77A7336DD27455DAB59231CE481_1021825264 =         CharToByteBufferAdapter.asCharBuffer(this);
        var8836A77A7336DD27455DAB59231CE481_1021825264.addTaint(taint);
        return var8836A77A7336DD27455DAB59231CE481_1021825264;
        // ---------- Original Method ----------
        //return CharToByteBufferAdapter.asCharBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.177 -0400", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "5A1AED3C954C9DBD4472D0AB2C07B3F5")
    @Override
    public final DoubleBuffer asDoubleBuffer() {
DoubleBuffer varD58C0872CB52590D14B11DAC2BE6F18B_1732918000 =         DoubleToByteBufferAdapter.asDoubleBuffer(this);
        varD58C0872CB52590D14B11DAC2BE6F18B_1732918000.addTaint(taint);
        return varD58C0872CB52590D14B11DAC2BE6F18B_1732918000;
        // ---------- Original Method ----------
        //return DoubleToByteBufferAdapter.asDoubleBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.178 -0400", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "B5198DE7F718DDD047994F1FDF8F85B4")
    @Override
    public final FloatBuffer asFloatBuffer() {
FloatBuffer var6FE30EC196CEEF16DE99C41319A74BF2_1492613504 =         FloatToByteBufferAdapter.asFloatBuffer(this);
        var6FE30EC196CEEF16DE99C41319A74BF2_1492613504.addTaint(taint);
        return var6FE30EC196CEEF16DE99C41319A74BF2_1492613504;
        // ---------- Original Method ----------
        //return FloatToByteBufferAdapter.asFloatBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.178 -0400", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "3D7AA51F41654558A83870D6F02BE117")
    @Override
    public final IntBuffer asIntBuffer() {
IntBuffer varAAED8CC346FF3890C81EAB9F2D4AD468_2025592939 =         IntToByteBufferAdapter.asIntBuffer(this);
        varAAED8CC346FF3890C81EAB9F2D4AD468_2025592939.addTaint(taint);
        return varAAED8CC346FF3890C81EAB9F2D4AD468_2025592939;
        // ---------- Original Method ----------
        //return IntToByteBufferAdapter.asIntBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.178 -0400", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "61FD7E16ECB6ED0CFC8EDE07FE5EA5CD")
    @Override
    public final LongBuffer asLongBuffer() {
LongBuffer var88E8C1C9830041B480F23CB027EC9464_213770033 =         LongToByteBufferAdapter.asLongBuffer(this);
        var88E8C1C9830041B480F23CB027EC9464_213770033.addTaint(taint);
        return var88E8C1C9830041B480F23CB027EC9464_213770033;
        // ---------- Original Method ----------
        //return LongToByteBufferAdapter.asLongBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.178 -0400", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "DB9D9F4AF27DF6B1F07D1DABC0694F5B")
    @Override
    public final ShortBuffer asShortBuffer() {
ShortBuffer var918B7E64FE8B7D24C3B986BF52E35CF9_2009669422 =         ShortToByteBufferAdapter.asShortBuffer(this);
        var918B7E64FE8B7D24C3B986BF52E35CF9_2009669422.addTaint(taint);
        return var918B7E64FE8B7D24C3B986BF52E35CF9_2009669422;
        // ---------- Original Method ----------
        //return ShortToByteBufferAdapter.asShortBuffer(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.179 -0400", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "550CBD10E7434E558A528A943CC23161")
    @Override
    public char getChar() {
        char var817CCDD1C7A82FB42EF4611B7F81A17C_1178761213 = ((char) getShort());
                char varA87DEB01C5F539E6BDA34829C8EF2368_587359197 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_587359197;
        // ---------- Original Method ----------
        //return (char) getShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.179 -0400", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "75ADCDA29EF61830C7E8C71B3345671F")
    @Override
    public char getChar(int index) {
        addTaint(index);
        char varADB0B12E8C8BA86A0519ED194585CC64_19453137 = ((char) getShort(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_101348174 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_101348174;
        // ---------- Original Method ----------
        //return (char) getShort(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.179 -0400", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "12497E3089CAA51C5C815EFF9F62A0D2")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
ByteBuffer var3CE57628C879294E83EF38D6A4813D5E_1122739100 =         putShort((short) value);
        var3CE57628C879294E83EF38D6A4813D5E_1122739100.addTaint(taint);
        return var3CE57628C879294E83EF38D6A4813D5E_1122739100;
        // ---------- Original Method ----------
        //return putShort((short) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.180 -0400", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "023F83936849030622B90356589B7907")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
ByteBuffer varA2347224BC969B6D5818F398107E8ADD_2070359088 =         putShort(index, (short) value);
        varA2347224BC969B6D5818F398107E8ADD_2070359088.addTaint(taint);
        return varA2347224BC969B6D5818F398107E8ADD_2070359088;
        // ---------- Original Method ----------
        //return putShort(index, (short) value);
    }

    
}

