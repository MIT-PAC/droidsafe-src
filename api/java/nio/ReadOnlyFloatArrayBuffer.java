package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.972 -0400", hash_original_method = "E7687DEEE2349AEC9B3D116E5F0447AE", hash_generated_method = "F1FDDBC1DC6E66DE50AD36F6C9E8ACB4")
      ReadOnlyFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyFloatArrayBuffer copy(FloatArrayBuffer other, int markOfOther) {
        ReadOnlyFloatArrayBuffer buf =
                new ReadOnlyFloatArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.973 -0400", hash_original_method = "950AD5330FDA6C397B84663FB836B7AC", hash_generated_method = "F913BC7374157B41C1DE812598C43F8E")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
FloatBuffer var398C146492D42068C7FF67EDC7FA3DFF_1978213029 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1978213029.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1978213029;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.973 -0400", hash_original_method = "3651F4075426ACE9E47115ABCBF7340C", hash_generated_method = "4564C800E85D76FF89831D0610240042")
    @Override
    public FloatBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2127117676 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2127117676.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2127117676;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.973 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "F34BC09E7FFF2D606BE4AB963D54C3DA")
    @Override
    public FloatBuffer duplicate() {
FloatBuffer var6ED4708F04CD11720ECFFDBFD927116F_566204798 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_566204798.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_566204798;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.974 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "FB0C449796A9E696E4E2A0877DB4E6CF")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_274597996 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690942784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690942784;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.974 -0400", hash_original_method = "C411BFEF69C342422C56A1A8A49A766C", hash_generated_method = "8139A4D614A7D2373200BAE455998FF2")
    @Override
    protected float[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1751301025 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1751301025.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1751301025;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.974 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "D03D717D199EA05D1B534F753BFD58A0")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_383562795 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_383562795.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_383562795;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.975 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "BFF5E7359464B4346805A9CE3974E40D")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1539230603 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283169211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_283169211;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.975 -0400", hash_original_method = "4648A9FB9F6674DFF187FD22874B4264", hash_generated_method = "D2C1D2531EE72F306EE232EFD33E2858")
    @Override
    public FloatBuffer put(float c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_920360706 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_920360706.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_920360706;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.975 -0400", hash_original_method = "2F3AA3FAE455D6D3597D42F3669BC144", hash_generated_method = "61831099F1CCB78781E0CB36CAE206B1")
    @Override
    public FloatBuffer put(int index, float c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_360088175 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_360088175.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_360088175;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.976 -0400", hash_original_method = "4593D163A029E48A7BF09387C27B8D4B", hash_generated_method = "67D243182F8A430709DF700D1A1A7A8B")
    @Override
    public FloatBuffer put(FloatBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_525807201 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_525807201.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_525807201;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.976 -0400", hash_original_method = "B855D58A55D1A37F7BFB3C60ACA0157A", hash_generated_method = "487601E67B7C144FFF801A263D71A385")
    @Override
    public final FloatBuffer put(float[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1112494353 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1112494353.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1112494353;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.977 -0400", hash_original_method = "CBF8325EDBAF150278EE67A0E06067DF", hash_generated_method = "54CF340C506E953610F8689919AABE1B")
    @Override
    public FloatBuffer slice() {
FloatBuffer varBF58F1AA27ED4AAA7D28D5573C3BECFD_1169862839 =         new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
        varBF58F1AA27ED4AAA7D28D5573C3BECFD_1169862839.addTaint(taint);
        return varBF58F1AA27ED4AAA7D28D5573C3BECFD_1169862839;
        // ---------- Original Method ----------
        //return new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

