package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadOnlyFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.532 -0400", hash_original_method = "E7687DEEE2349AEC9B3D116E5F0447AE", hash_generated_method = "F1FDDBC1DC6E66DE50AD36F6C9E8ACB4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.532 -0400", hash_original_method = "950AD5330FDA6C397B84663FB836B7AC", hash_generated_method = "3A6676C396EC21D822655B530FBC5D85")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
FloatBuffer var398C146492D42068C7FF67EDC7FA3DFF_20640747 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_20640747.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_20640747;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.533 -0400", hash_original_method = "3651F4075426ACE9E47115ABCBF7340C", hash_generated_method = "A6D2AE88A249EF1B74E8A0F146D258C8")
    @Override
    public FloatBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1773654204 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1773654204.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1773654204;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.533 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "277005006D2AFA880116F358B9818F98")
    @Override
    public FloatBuffer duplicate() {
FloatBuffer var6ED4708F04CD11720ECFFDBFD927116F_2088974421 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_2088974421.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_2088974421;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.533 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "C39966DAEDA688BC272D4F5174D7A8ED")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1501124959 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985979592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985979592;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.533 -0400", hash_original_method = "C411BFEF69C342422C56A1A8A49A766C", hash_generated_method = "2808584AC92A68F31A7C60F4870AA401")
    @Override
    protected float[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1692578941 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1692578941.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1692578941;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.534 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "DB989A573C1FC56F578F94D4FC1D3A81")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_463216265 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_463216265.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_463216265;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.534 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "B38787C3C9371A905C26F167093189C4")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_769295254 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382969004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382969004;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.534 -0400", hash_original_method = "4648A9FB9F6674DFF187FD22874B4264", hash_generated_method = "BED20DFD80AD6CA91168D93BEC0A2121")
    @Override
    public FloatBuffer put(float c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1466869251 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1466869251.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1466869251;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.535 -0400", hash_original_method = "2F3AA3FAE455D6D3597D42F3669BC144", hash_generated_method = "12C0DB8CC4E07272470830AC626B6A19")
    @Override
    public FloatBuffer put(int index, float c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_379754280 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_379754280.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_379754280;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.535 -0400", hash_original_method = "4593D163A029E48A7BF09387C27B8D4B", hash_generated_method = "9741353966524CF60972C66DBDE58DCE")
    @Override
    public FloatBuffer put(FloatBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1156248396 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1156248396.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1156248396;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.535 -0400", hash_original_method = "B855D58A55D1A37F7BFB3C60ACA0157A", hash_generated_method = "68D7B78CE2103766A9E2C9420CDC493F")
    @Override
    public final FloatBuffer put(float[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_248431489 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_248431489.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_248431489;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.536 -0400", hash_original_method = "CBF8325EDBAF150278EE67A0E06067DF", hash_generated_method = "5D79787A100C991F1EDFDFD2E6E70002")
    @Override
    public FloatBuffer slice() {
FloatBuffer varBF58F1AA27ED4AAA7D28D5573C3BECFD_1688023154 =         new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
        varBF58F1AA27ED4AAA7D28D5573C3BECFD_1688023154.addTaint(taint);
        return varBF58F1AA27ED4AAA7D28D5573C3BECFD_1688023154;
        // ---------- Original Method ----------
        //return new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

