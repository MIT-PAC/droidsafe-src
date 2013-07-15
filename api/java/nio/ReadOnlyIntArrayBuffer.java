package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.000 -0400", hash_original_method = "01590DEAE9E3D05BD420F8A41610BAB0", hash_generated_method = "9E4CCD8200AB132BC870BCD093CFC10B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.001 -0400", hash_original_method = "6813C80E6F33BB643F69D9471CD54ED3", hash_generated_method = "6EF224861896A53848A130E1492B2ACE")
    @Override
    public IntBuffer asReadOnlyBuffer() {
IntBuffer var398C146492D42068C7FF67EDC7FA3DFF_304792484 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_304792484.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_304792484;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.001 -0400", hash_original_method = "95709EC066A435B9AA3687E160003D5F", hash_generated_method = "A5F506BBF48EF714971A78769BE70FBC")
    @Override
    public IntBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_495446782 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_495446782.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_495446782;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.002 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "D0C1126B27E403CD3CFA11E97BBF1705")
    @Override
    public IntBuffer duplicate() {
IntBuffer var6ED4708F04CD11720ECFFDBFD927116F_683933633 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_683933633.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_683933633;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.002 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "481BFA1F6D2893F1EF3FC72057047793")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_715578189 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1814143612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1814143612;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.002 -0400", hash_original_method = "0A06910467E88EE62CDFBCBE0CB802DA", hash_generated_method = "A61F25516FC52C6A1A313708D4E43524")
    @Override
    protected int[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_605857964 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_605857964.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_605857964;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.003 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "641A2B96C485A590AD54C2ECCA43EFDD")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_54458042 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_54458042.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_54458042;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.003 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4AE63B3486F70343E32C49EFAF92D8ED")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1387792997 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081873357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081873357;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.003 -0400", hash_original_method = "09ED0F57CBC06365DA988C0313F02515", hash_generated_method = "010A443E03D0D0553DED99D73C8C958D")
    @Override
    public IntBuffer put(int c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1226304991 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1226304991.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1226304991;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.004 -0400", hash_original_method = "72974DF4DE68C45A0CAEDB3056BAFC34", hash_generated_method = "6C143C0AAC537E3D413599DF9C438918")
    @Override
    public IntBuffer put(int index, int c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1712727214 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1712727214.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1712727214;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.004 -0400", hash_original_method = "0AE015769B07B9A1C6447FCD87483B4D", hash_generated_method = "8A3AE5EE75C04CFF328C37C0893E635F")
    @Override
    public IntBuffer put(IntBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_741445101 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_741445101.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_741445101;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.010 -0400", hash_original_method = "4CDCCEB43894118BDB0755D2BC3EFD49", hash_generated_method = "152A49849946A64CA4F1B43D4859D01F")
    @Override
    public final IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1471047644 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1471047644.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1471047644;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.010 -0400", hash_original_method = "7D836F4D3C901F2E02BB73C6A2A966F7", hash_generated_method = "A65261D00716887FB8131626FC1BD6F4")
    @Override
    public IntBuffer slice() {
IntBuffer var2A94422B18402EF611EE29714D6538D4_1982590104 =         new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
        var2A94422B18402EF611EE29714D6538D4_1982590104.addTaint(taint);
        return var2A94422B18402EF611EE29714D6538D4_1982590104;
        // ---------- Original Method ----------
        //return new ReadOnlyIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

