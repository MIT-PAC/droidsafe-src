package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadOnlyShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.027 -0400", hash_original_method = "DA0F6B028B84C196FFD1459A256816D4", hash_generated_method = "454E5A3621DF347039693C3E4C8E5644")
      ReadOnlyShortArrayBuffer(int capacity, short[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadOnlyShortArrayBuffer buf =
                new ReadOnlyShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.028 -0400", hash_original_method = "293D70534F08F1337102FFA8FF94EA93", hash_generated_method = "A8C72ACC227D1C1ACBC83D81CB3F81BF")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
ShortBuffer var398C146492D42068C7FF67EDC7FA3DFF_1458452961 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1458452961.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1458452961;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.028 -0400", hash_original_method = "1358DD6DB518D15E9F2A390375DC21ED", hash_generated_method = "BDBE772237CC9E1467CE79FB352A696A")
    @Override
    public ShortBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_449098190 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_449098190.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_449098190;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.029 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "1614BBBA7146D2FFFA5AEA7CB74AD9DC")
    @Override
    public ShortBuffer duplicate() {
ShortBuffer var6ED4708F04CD11720ECFFDBFD927116F_1643959366 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_1643959366.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_1643959366;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.029 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "958330C10937881D97CEEA844B230D7C")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_530418337 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87738249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_87738249;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.029 -0400", hash_original_method = "AFBE97926DC7C5B917D9DD29C0718A4F", hash_generated_method = "E35151DC794DF40557970D14B7F2FEC9")
    @Override
    protected short[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_968654939 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_968654939.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_968654939;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.030 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "0B11AB1AB9358C25F0BA25402ECBB02B")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1000519589 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1000519589.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1000519589;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.030 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "A31A02FB67CA603AD3A7F648C8B2976A")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_643129009 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_980643087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_980643087;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.030 -0400", hash_original_method = "5592BDB3AAC352212C254B47F1811E27", hash_generated_method = "B64B93774F97CAC9328813035207F8E1")
    @Override
    public ShortBuffer put(ShortBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1633408281 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1633408281.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1633408281;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.031 -0400", hash_original_method = "499D2BB8AE90111A3249031C62268D84", hash_generated_method = "1440E8E8214AAD23215BA44C1C510810")
    @Override
    public ShortBuffer put(short c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1298415100 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1298415100.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1298415100;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.031 -0400", hash_original_method = "617A2BE3714A70A7C820CD4B75072087", hash_generated_method = "F5E0025FF48576F30F88AAD6A5E71F9B")
    @Override
    public ShortBuffer put(int index, short c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_385611357 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_385611357.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_385611357;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.031 -0400", hash_original_method = "1E52CD3CC46ECF6ADC15EFA5E594FA46", hash_generated_method = "501815A0F98559334B7F13E2981102A1")
    @Override
    public final ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1223634386 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1223634386.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1223634386;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.032 -0400", hash_original_method = "1014849B0415FF72B64D3271FAB61336", hash_generated_method = "4E1F303224236586CA567BF360AF4D67")
    @Override
    public ShortBuffer slice() {
ShortBuffer var2B68010FE5CFA7FF8F1E053D5E7F4EF8_1478539400 =         new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
        var2B68010FE5CFA7FF8F1E053D5E7F4EF8_1478539400.addTaint(taint);
        return var2B68010FE5CFA7FF8F1E053D5E7F4EF8_1478539400;
        // ---------- Original Method ----------
        //return new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

