package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.961 -0400", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "D2FBEA8E33057244FE09DC34C619F152")
      ReadOnlyDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadOnlyDoubleArrayBuffer buf =
                new ReadOnlyDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.962 -0400", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "7572E76D1584F7A2DCC839BF2469B18A")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
DoubleBuffer var398C146492D42068C7FF67EDC7FA3DFF_1834223378 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1834223378.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1834223378;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.962 -0400", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "73F4901BCDFD5DD441939CEE1B7C7002")
    @Override
    public DoubleBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_686243669 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_686243669.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_686243669;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.962 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "B739965BBF21320AFBDC0E49BFE532BA")
    @Override
    public DoubleBuffer duplicate() {
DoubleBuffer var6ED4708F04CD11720ECFFDBFD927116F_550827447 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_550827447.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_550827447;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.963 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "6F7BCE0428A91D903FDD6C00A793E348")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1128098402 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627892111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_627892111;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.963 -0400", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "54685BF2D900AB3AB35B77F57024B165")
    @Override
    protected double[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1197535890 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1197535890.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1197535890;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.963 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "3D68170E359FB21B0D177DD806C435DF")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1632673720 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1632673720.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1632673720;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.964 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "040DF96B7349E0D3064069373D568D8C")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_405498201 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085210926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085210926;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.964 -0400", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "777D299BBB647922D0EA023EC4E256DC")
    @Override
    public DoubleBuffer put(double c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1203183329 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1203183329.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1203183329;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.964 -0400", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "E2D9B57DAE532A1DA15ED37EA77F1663")
    @Override
    public DoubleBuffer put(int index, double c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_336687814 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_336687814.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_336687814;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.965 -0400", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "CA23D9862F75B04553513678338D8C74")
    @Override
    public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_6718589 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_6718589.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_6718589;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.965 -0400", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "C1B3A43F45B678DACA0547F1A3161FEF")
    @Override
    public final DoubleBuffer put(DoubleBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_418843715 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_418843715.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_418843715;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.966 -0400", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "BCEBEAA730C2E512D600E872F6AB1BD6")
    @Override
    public DoubleBuffer slice() {
DoubleBuffer var0A8D30E00BC161CDCC2BCAC9D9ACF238_127127691 =         new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
        var0A8D30E00BC161CDCC2BCAC9D9ACF238_127127691.addTaint(taint);
        return var0A8D30E00BC161CDCC2BCAC9D9ACF238_127127691;
        // ---------- Original Method ----------
        //return new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

