package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class BaseByteBuffer extends ByteBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.880 -0400", hash_original_method = "ACB8CCD9F99597647E3D3BC8A43B28AD", hash_generated_method = "C94DE637A62A36C14B152011F022CD27")
    protected  BaseByteBuffer(int capacity, MemoryBlock block) {
        super(capacity, block);
        addTaint(block.getTaint());
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.881 -0400", hash_original_method = "80EFC3A1779CF131380EFF26FCE5482E", hash_generated_method = "D347CC57A7499074D0F8E379BFA924FA")
    @Override
    public final CharBuffer asCharBuffer() {
CharBuffer var8836A77A7336DD27455DAB59231CE481_190768117 =         CharToByteBufferAdapter.asCharBuffer(this);
        var8836A77A7336DD27455DAB59231CE481_190768117.addTaint(taint);
        return var8836A77A7336DD27455DAB59231CE481_190768117;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.881 -0400", hash_original_method = "676CABDBD56BBA6DBE1153112316712F", hash_generated_method = "AB3FA38B0F6706E57E20EA2852E4CFEC")
    @Override
    public final DoubleBuffer asDoubleBuffer() {
DoubleBuffer varD58C0872CB52590D14B11DAC2BE6F18B_1919488493 =         DoubleToByteBufferAdapter.asDoubleBuffer(this);
        varD58C0872CB52590D14B11DAC2BE6F18B_1919488493.addTaint(taint);
        return varD58C0872CB52590D14B11DAC2BE6F18B_1919488493;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.881 -0400", hash_original_method = "E6E0734AE3CA82DC17ABAD04A18A214C", hash_generated_method = "8EF677B6B06120822D21D678C5ADA041")
    @Override
    public final FloatBuffer asFloatBuffer() {
FloatBuffer var6FE30EC196CEEF16DE99C41319A74BF2_1538342715 =         FloatToByteBufferAdapter.asFloatBuffer(this);
        var6FE30EC196CEEF16DE99C41319A74BF2_1538342715.addTaint(taint);
        return var6FE30EC196CEEF16DE99C41319A74BF2_1538342715;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.882 -0400", hash_original_method = "75D241C3AC04B03A5C5326F3F52D5EBD", hash_generated_method = "52008CFDDD9E725C6232D757D9D9ED25")
    @Override
    public final IntBuffer asIntBuffer() {
IntBuffer varAAED8CC346FF3890C81EAB9F2D4AD468_698466179 =         IntToByteBufferAdapter.asIntBuffer(this);
        varAAED8CC346FF3890C81EAB9F2D4AD468_698466179.addTaint(taint);
        return varAAED8CC346FF3890C81EAB9F2D4AD468_698466179;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.882 -0400", hash_original_method = "C2685C128BEE4B4F2F0C5CCB69376C4A", hash_generated_method = "4A0C6960C7B08C9A86E6D6A808EE664E")
    @Override
    public final LongBuffer asLongBuffer() {
LongBuffer var88E8C1C9830041B480F23CB027EC9464_1684984134 =         LongToByteBufferAdapter.asLongBuffer(this);
        var88E8C1C9830041B480F23CB027EC9464_1684984134.addTaint(taint);
        return var88E8C1C9830041B480F23CB027EC9464_1684984134;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.882 -0400", hash_original_method = "8367A215E740624E7DE96EAA789F4593", hash_generated_method = "B92042FCC6276B1CF0FDA7A7001273A0")
    @Override
    public final ShortBuffer asShortBuffer() {
ShortBuffer var918B7E64FE8B7D24C3B986BF52E35CF9_729633176 =         ShortToByteBufferAdapter.asShortBuffer(this);
        var918B7E64FE8B7D24C3B986BF52E35CF9_729633176.addTaint(taint);
        return var918B7E64FE8B7D24C3B986BF52E35CF9_729633176;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.883 -0400", hash_original_method = "306435823B7F4BDA0B79FE4AAC38458D", hash_generated_method = "770897E18419FE39B7C2BABD30CE7461")
    @Override
    public char getChar() {
        char var817CCDD1C7A82FB42EF4611B7F81A17C_1889061416 = ((char) getShort());
                char varA87DEB01C5F539E6BDA34829C8EF2368_1068419093 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1068419093;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.883 -0400", hash_original_method = "DB5974BF42C2F1DAF0453A45ABD3A97B", hash_generated_method = "9E63299CCAB561F0191681BC4C993EC0")
    @Override
    public char getChar(int index) {
        addTaint(index);
        char varADB0B12E8C8BA86A0519ED194585CC64_1616081724 = ((char) getShort(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_536042400 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_536042400;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.884 -0400", hash_original_method = "11E610FEEDDA6595692D69FA56D6E79E", hash_generated_method = "A1FEEB222CBFC84525073273587024B6")
    @Override
    public ByteBuffer putChar(char value) {
        addTaint(value);
ByteBuffer var3CE57628C879294E83EF38D6A4813D5E_856274243 =         putShort((short) value);
        var3CE57628C879294E83EF38D6A4813D5E_856274243.addTaint(taint);
        return var3CE57628C879294E83EF38D6A4813D5E_856274243;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.884 -0400", hash_original_method = "7A936B8362BD945536C67F821DC17E9C", hash_generated_method = "F0B57BA675C763583F98152E544324CC")
    @Override
    public ByteBuffer putChar(int index, char value) {
        addTaint(value);
        addTaint(index);
ByteBuffer varA2347224BC969B6D5818F398107E8ADD_1553210869 =         putShort(index, (short) value);
        varA2347224BC969B6D5818F398107E8ADD_1553210869.addTaint(taint);
        return varA2347224BC969B6D5818F398107E8ADD_1553210869;
        
        
    }

    
}

