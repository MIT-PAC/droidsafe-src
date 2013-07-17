package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.515 -0400", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "D2FBEA8E33057244FE09DC34C619F152")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.515 -0400", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "37A6CF1F36E9C829A7A5FEBE7B42532A")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
DoubleBuffer var398C146492D42068C7FF67EDC7FA3DFF_1046689781 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1046689781.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1046689781;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.516 -0400", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "2534EB99DBC3EE99BF5507781A64BF65")
    @Override
    public DoubleBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_75284993 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_75284993.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_75284993;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.516 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "BE82600099AED57E9F8C05585FA33B7D")
    @Override
    public DoubleBuffer duplicate() {
DoubleBuffer var6ED4708F04CD11720ECFFDBFD927116F_1184983983 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1184983983.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1184983983;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.516 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "28B44717882F0267421328C227DBE144")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1655713940 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664725115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664725115;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.517 -0400", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "BC8261273E5E5C60A8CEDA0DD629655D")
    @Override
    protected double[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1782127 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1782127.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1782127;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.517 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "07596BBA18CBCE089134DB8576EE51A4")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_961007578 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_961007578.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_961007578;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.518 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "E47BBB5EA3489783C9B8057977C4CEFF")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_472114627 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137236565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137236565;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.518 -0400", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "6E66DC68A31642BD807B3B657208337C")
    @Override
    public DoubleBuffer put(double c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_539176464 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_539176464.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_539176464;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.518 -0400", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "27E90D9DFF841A3BE4DDB52AAE43E3F0")
    @Override
    public DoubleBuffer put(int index, double c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_137171738 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_137171738.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_137171738;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.519 -0400", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "7AD5804478E9667E46F2DE330A2AB08E")
    @Override
    public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1429449048 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1429449048.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1429449048;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.519 -0400", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "C85DD8407385E020AB5DCE9D5C2243B9")
    @Override
    public final DoubleBuffer put(DoubleBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_716194397 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_716194397.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_716194397;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.520 -0400", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "7A272FBAA6263282D155FF63932D859F")
    @Override
    public DoubleBuffer slice() {
DoubleBuffer var0A8D30E00BC161CDCC2BCAC9D9ACF238_448447672 =         new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
        var0A8D30E00BC161CDCC2BCAC9D9ACF238_448447672.addTaint(taint);
        return var0A8D30E00BC161CDCC2BCAC9D9ACF238_448447672;
        // ---------- Original Method ----------
        //return new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

