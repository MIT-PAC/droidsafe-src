package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.946 -0400", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "4AC7A4214CE2689D43A9E5A40E330204")
      ReadOnlyDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.958 -0400", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "DE7F600F91445011D5EC3D4DBE4CD9C5")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1385038938 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385038938 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1385038938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385038938;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.959 -0400", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "B7B6949530B843CAC56ED08A96607A4D")
    @Override
    public DoubleBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.959 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "EE97FA74867F8703CC239F3CF9A17A5A")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1938309461 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1938309461 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1938309461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1938309461;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.959 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "80E5D1209C594B5BDA9B74B200DFAAC4")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3491728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_3491728;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.959 -0400", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "617520AC2BD1889AC47ED7B26C244E84")
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        double[] var74D44D7D9EE6FE6C3433D694F869E521_645908751 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_645908751;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.968 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "D8BE4BF33A4280EE7CDCE860A8A4E89D")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790563966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790563966;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.969 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "B92A64C81EF8E3C80F781E1E264E465C")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606468451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606468451;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.969 -0400", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "E1F74B0E5953E5238A127FA14A91B416")
    @Override
    public DoubleBuffer put(double c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.970 -0400", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "BD0556756292DDFDA09ECAEA42440CCF")
    @Override
    public DoubleBuffer put(int index, double c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.970 -0400", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "9551BF5C45E8866E8CEC1F30C2E78E1C")
    @Override
    public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.971 -0400", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "76B6A5374B6AE5A0CD574F3F2408582B")
    @Override
    public final DoubleBuffer put(DoubleBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.971 -0400", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "BF6239E22BE33B692F2609B9A1C7B6E8")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_547816474 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_547816474 = new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_547816474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_547816474;
        // ---------- Original Method ----------
        //return new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

