package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.010 -0400", hash_original_method = "DA0F6B028B84C196FFD1459A256816D4", hash_generated_method = "134581DF985FFA24DA1D30A000FEF3BC")
      ReadOnlyShortArrayBuffer(int capacity, short[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.010 -0400", hash_original_method = "293D70534F08F1337102FFA8FF94EA93", hash_generated_method = "84FF06EE0B56C2F504D754501BBF1607")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_35622645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_35622645 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_35622645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_35622645;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.011 -0400", hash_original_method = "1358DD6DB518D15E9F2A390375DC21ED", hash_generated_method = "8D0E7500E2D35F547F51C4E71BEB149D")
    @Override
    public ShortBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.011 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "3A27D0EF160336D9A4AAC15D52382B7E")
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1082016041 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1082016041 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1082016041.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1082016041;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.015 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "6AD4D02CEC0577688B5CB781F03DBB43")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26867382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_26867382;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.015 -0400", hash_original_method = "AFBE97926DC7C5B917D9DD29C0718A4F", hash_generated_method = "9182A3A47B4FD55FCCA77BAA2D363DFD")
    @Override
    protected short[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        short[] var48EE7E2DDF8A83602BC526873BD0F875_1334748305 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1334748305;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.025 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "FD740A4473ABE2D24711AFAA3C196134")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464632924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464632924;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.025 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "C49DD4094B409FBFD6AECE0045CBAE74")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479662719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479662719;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.025 -0400", hash_original_method = "5592BDB3AAC352212C254B47F1811E27", hash_generated_method = "F82A9C50CFDA54831EB0DF140921035E")
    @Override
    public ShortBuffer put(ShortBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.026 -0400", hash_original_method = "499D2BB8AE90111A3249031C62268D84", hash_generated_method = "51B9CA180C6AF81C985217BAD95CFFFF")
    @Override
    public ShortBuffer put(short c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.026 -0400", hash_original_method = "617A2BE3714A70A7C820CD4B75072087", hash_generated_method = "1E52073E7F4D4E6FE16A8BA407381D4D")
    @Override
    public ShortBuffer put(int index, short c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.026 -0400", hash_original_method = "1E52CD3CC46ECF6ADC15EFA5E594FA46", hash_generated_method = "C809EB7A141BFD58278CB8300166F96E")
    @Override
    public final ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.027 -0400", hash_original_method = "1014849B0415FF72B64D3271FAB61336", hash_generated_method = "E4D565D7222D8B1EB43FAB7C2E5410C7")
    @Override
    public ShortBuffer slice() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1229738780 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1229738780 = new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1229738780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1229738780;
        // ---------- Original Method ----------
        //return new ReadOnlyShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

