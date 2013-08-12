package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;




final class ReadOnlyShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.598 -0400", hash_original_method = "DA0F6B028B84C196FFD1459A256816D4", hash_generated_method = "454E5A3621DF347039693C3E4C8E5644")
      ReadOnlyShortArrayBuffer(int capacity, short[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    static ReadOnlyShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadOnlyShortArrayBuffer buf =
                new ReadOnlyShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.599 -0400", hash_original_method = "293D70534F08F1337102FFA8FF94EA93", hash_generated_method = "4A11CB52DA9622A3642336D955F092DF")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
ShortBuffer var398C146492D42068C7FF67EDC7FA3DFF_1567205792 =         duplicate();
        var398C146492D42068C7FF67EDC7FA3DFF_1567205792.addTaint(taint);
        return var398C146492D42068C7FF67EDC7FA3DFF_1567205792;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.599 -0400", hash_original_method = "1358DD6DB518D15E9F2A390375DC21ED", hash_generated_method = "21F705D5C629140FB81BB3FCB4F4817F")
    @Override
    public ShortBuffer compact() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1154028327 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1154028327.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1154028327;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.599 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "64DC678BB14C365745AEC83CFE03A2C6")
    @Override
    public ShortBuffer duplicate() {
ShortBuffer var6ED4708F04CD11720ECFFDBFD927116F_623199441 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_623199441.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_623199441;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.599 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "982DEF020D978A780F0D0D10FA92F9D5")
    @Override
    public boolean isReadOnly() {
        boolean varB326B5062B2F0E69046810717534CB09_1807518127 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943118854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943118854;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.600 -0400", hash_original_method = "AFBE97926DC7C5B917D9DD29C0718A4F", hash_generated_method = "1172E9EA4AAD3B3B5383CB69A9F200AC")
    @Override
    protected short[] protectedArray() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_808129713 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_808129713.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_808129713;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.600 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "A1252189758C248205E7775627C6743B")
    @Override
    protected int protectedArrayOffset() {
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_632825444 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_632825444.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_632825444;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.600 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "BDD717AB0E5A0E14180FEED6B3025D7B")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_348778016 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179867357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179867357;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.600 -0400", hash_original_method = "5592BDB3AAC352212C254B47F1811E27", hash_generated_method = "4C997E67C5E24CBB6D5E7F4D1755415D")
    @Override
    public ShortBuffer put(ShortBuffer buf) {
        addTaint(buf.getTaint());
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1584461568 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1584461568.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1584461568;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.601 -0400", hash_original_method = "499D2BB8AE90111A3249031C62268D84", hash_generated_method = "9F0646F42E18A0630A38FF904EA04FF7")
    @Override
    public ShortBuffer put(short c) {
        addTaint(c);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2062055849 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_2062055849.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_2062055849;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.601 -0400", hash_original_method = "617A2BE3714A70A7C820CD4B75072087", hash_generated_method = "545AC4D4390540DB59E1C65D9E6B6E48")
    @Override
    public ShortBuffer put(int index, short c) {
        addTaint(c);
        addTaint(index);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_493236171 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_493236171.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_493236171;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.601 -0400", hash_original_method = "1E52CD3CC46ECF6ADC15EFA5E594FA46", hash_generated_method = "3595F80F34F182A172A477D5E8D23F45")
    @Override
    public final ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1619085689 = new ReadOnlyBufferException();
        varA14F16C43B102D90B34008C8FF8087F8_1619085689.addTaint(taint);
        throw varA14F16C43B102D90B34008C8FF8087F8_1619085689;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.602 -0400", hash_original_method = "1014849B0415FF72B64D3271FAB61336", hash_generated_method = "EAE1CC82478C1B58C4519B692FC8E1A7")
    @Override
    public ShortBuffer slice() {
ShortBuffer var2B68010FE5CFA7FF8F1E053D5E7F4EF8_434048364 =         new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
        var2B68010FE5CFA7FF8F1E053D5E7F4EF8_434048364.addTaint(taint);
        return var2B68010FE5CFA7FF8F1E053D5E7F4EF8_434048364;
        // ---------- Original Method ----------
        //return new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

