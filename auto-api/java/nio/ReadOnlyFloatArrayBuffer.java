package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.950 -0400", hash_original_method = "E7687DEEE2349AEC9B3D116E5F0447AE", hash_generated_method = "AD6E72DDE9E9B4DE4FAEA6B0D707A9A3")
      ReadOnlyFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.950 -0400", hash_original_method = "950AD5330FDA6C397B84663FB836B7AC", hash_generated_method = "51256753BEAED7871222940D7F332DFA")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1160308974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1160308974 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1160308974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1160308974;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.951 -0400", hash_original_method = "3651F4075426ACE9E47115ABCBF7340C", hash_generated_method = "298DE6CEC122913EDF045B07FAA12A43")
    @Override
    public FloatBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.951 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "71BAC891B39744953DB0D81F50CA7007")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_738530808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_738530808 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_738530808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_738530808;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.965 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "71BEA3C6E3A041FAEAB77C0145E44D1D")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631811867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631811867;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.966 -0400", hash_original_method = "C411BFEF69C342422C56A1A8A49A766C", hash_generated_method = "406CDBBA5357E636375E70846EC4DD5A")
    @Override
    protected float[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        float[] varB2C245003BAB9224CFB496218F7DAFE0_1358076493 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1358076493;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.967 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "708F867ED9223EB8335EE37C26C830B0")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602758660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_602758660;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.968 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "E6D74924A39BE76B70567428DFC0D50C")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912883968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912883968;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.990 -0400", hash_original_method = "4648A9FB9F6674DFF187FD22874B4264", hash_generated_method = "4380269F1CAD5D1F0585AEAB8935FDA1")
    @Override
    public FloatBuffer put(float c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.990 -0400", hash_original_method = "2F3AA3FAE455D6D3597D42F3669BC144", hash_generated_method = "7CDFDF5F7DD44C08936FA66E9A396D3B")
    @Override
    public FloatBuffer put(int index, float c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.991 -0400", hash_original_method = "4593D163A029E48A7BF09387C27B8D4B", hash_generated_method = "0B5E2C94C4E433281EC131CF6A94BED9")
    @Override
    public FloatBuffer put(FloatBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.992 -0400", hash_original_method = "B855D58A55D1A37F7BFB3C60ACA0157A", hash_generated_method = "F6DDFD46E66529E62C5B4674CD558FFF")
    @Override
    public final FloatBuffer put(float[] src, int srcOffset, int byteCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.004 -0400", hash_original_method = "CBF8325EDBAF150278EE67A0E06067DF", hash_generated_method = "7A38EC50ED97D64988ACF96D2B092016")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1348554858 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1348554858 = new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1348554858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1348554858;
        // ---------- Original Method ----------
        //return new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

