package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.911 -0400", hash_original_method = "E7687DEEE2349AEC9B3D116E5F0447AE", hash_generated_method = "AD6E72DDE9E9B4DE4FAEA6B0D707A9A3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.912 -0400", hash_original_method = "950AD5330FDA6C397B84663FB836B7AC", hash_generated_method = "06FD4E13CFD7BF41A061CDAC57ACE48B")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_925243015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_925243015 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_925243015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_925243015;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.912 -0400", hash_original_method = "3651F4075426ACE9E47115ABCBF7340C", hash_generated_method = "298DE6CEC122913EDF045B07FAA12A43")
    @Override
    public FloatBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.912 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "B765036458FA4A4787D99EECCF6066A4")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1772737740 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1772737740 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1772737740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1772737740;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.913 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "14C4C9162723EA3CE9AF64ACF70951B6")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504264645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504264645;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.913 -0400", hash_original_method = "C411BFEF69C342422C56A1A8A49A766C", hash_generated_method = "1C8B521AA889738ABE7E4DAD4ACA625E")
    @Override
    protected float[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        float[] varB2C245003BAB9224CFB496218F7DAFE0_1072638539 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1072638539;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.913 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "B78978D8AD65D51CC2E7DEDF8E48421F")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349723017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349723017;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.934 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "275CA3FBA1A3B1C6F2E2EA27F464A9CF")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91629742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_91629742;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.935 -0400", hash_original_method = "4648A9FB9F6674DFF187FD22874B4264", hash_generated_method = "4380269F1CAD5D1F0585AEAB8935FDA1")
    @Override
    public FloatBuffer put(float c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.936 -0400", hash_original_method = "2F3AA3FAE455D6D3597D42F3669BC144", hash_generated_method = "7CDFDF5F7DD44C08936FA66E9A396D3B")
    @Override
    public FloatBuffer put(int index, float c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.936 -0400", hash_original_method = "4593D163A029E48A7BF09387C27B8D4B", hash_generated_method = "0B5E2C94C4E433281EC131CF6A94BED9")
    @Override
    public FloatBuffer put(FloatBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.937 -0400", hash_original_method = "B855D58A55D1A37F7BFB3C60ACA0157A", hash_generated_method = "F6DDFD46E66529E62C5B4674CD558FFF")
    @Override
    public final FloatBuffer put(float[] src, int srcOffset, int byteCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.938 -0400", hash_original_method = "CBF8325EDBAF150278EE67A0E06067DF", hash_generated_method = "F16FDD39D1BA72373AB78EBFD96D1E4F")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_237601915 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_237601915 = new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_237601915.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_237601915;
        // ---------- Original Method ----------
        //return new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

