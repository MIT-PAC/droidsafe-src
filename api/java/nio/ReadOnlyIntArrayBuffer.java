package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;




final class ReadOnlyIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.570 -0400", hash_original_method = "01590DEAE9E3D05BD420F8A41610BAB0", hash_generated_method = "9E4CCD8200AB132BC870BCD093CFC10B")
      ReadOnlyIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    static ReadOnlyIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadOnlyIntArrayBuffer buf =
                new ReadOnlyIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.572 -0400", hash_original_method = "6813C80E6F33BB643F69D9471CD54ED3", hash_generated_method = "D14A1A22BC37AF560FB914E7729DBEEB")
    @Override
    public IntBuffer asReadOnlyBuffer() {
IntBuffer var398C146492D42068C7FF67EDC7FA3DFF_1444535938 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1444535938.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1444535938;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.573 -0400", hash_original_method = "95709EC066A435B9AA3687E160003D5F", hash_generated_method = "D9EA505F63D140BBEDCB42F3C5F11A0B")
    @Override
    public IntBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1155782658 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1155782658.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1155782658;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.574 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "12FE51CC3C49F097D9DF64B576F96B22")
    @Override
    public IntBuffer duplicate() {
IntBuffer var6ED4708F04CD11720ECFFDBFD927116F_1894694411 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1894694411.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1894694411;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.574 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "CC574505213D37B92FDEE95491F8FAEB")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_794056817 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1643586225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1643586225;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.575 -0400", hash_original_method = "0A06910467E88EE62CDFBCBE0CB802DA", hash_generated_method = "D774CB27771B1516DA8CE4E82E0C6C0F")
    @Override
    protected int[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_491870350 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_491870350.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_491870350;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.575 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "8D0F35BB4769A77519D39410E85B88B3")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_351865518 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_351865518.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_351865518;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.576 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "901264FCA2B6DAF7C18D1DD5399AB943")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_2029857720 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611396110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_611396110;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.576 -0400", hash_original_method = "09ED0F57CBC06365DA988C0313F02515", hash_generated_method = "65906CF54A01808CD6DE9841898D5530")
    @Override
    public IntBuffer put(int c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1590814240 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1590814240.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1590814240;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.577 -0400", hash_original_method = "72974DF4DE68C45A0CAEDB3056BAFC34", hash_generated_method = "F2B50AB0F9693BC0B5E632AF948E3872")
    @Override
    public IntBuffer put(int index, int c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_662665215 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_662665215.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_662665215;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.577 -0400", hash_original_method = "0AE015769B07B9A1C6447FCD87483B4D", hash_generated_method = "761A95365B51E39BD38213D01AAF6281")
    @Override
    public IntBuffer put(IntBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2069813445 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2069813445.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2069813445;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.577 -0400", hash_original_method = "4CDCCEB43894118BDB0755D2BC3EFD49", hash_generated_method = "55532B9B20D31A4A90841B3C097C1E2E")
    @Override
    public final IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_545445853 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_545445853.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_545445853;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.578 -0400", hash_original_method = "7D836F4D3C901F2E02BB73C6A2A966F7", hash_generated_method = "73F96C035414E46237D5244B53C4E698")
    @Override
    public IntBuffer slice() {
IntBuffer var2A94422B18402EF611EE29714D6538D4_295654093 =         new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
        var2A94422B18402EF611EE29714D6538D4_295654093.addTaint(taint);
        return var2A94422B18402EF611EE29714D6538D4_295654093;
        // ---------- Original Method ----------
        //return new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

