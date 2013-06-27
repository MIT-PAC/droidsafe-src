package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.897 -0400", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "4AC7A4214CE2689D43A9E5A40E330204")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.898 -0400", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "CED741B2401A976D206C309F3DFB6F74")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1953079279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1953079279 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1953079279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1953079279;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.899 -0400", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "B7B6949530B843CAC56ED08A96607A4D")
    @Override
    public DoubleBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.905 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "1CE95288B5F353697B88B9B7FD74E875")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1738676480 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1738676480 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1738676480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1738676480;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.906 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "4FE411597CE47BE537AE866C05AA7311")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301200042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301200042;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.906 -0400", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "341F697113B3D64A4958B3AEC1782386")
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        double[] var74D44D7D9EE6FE6C3433D694F869E521_176782041 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_176782041;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.906 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "C9C4CDB3AEB782CEBD8FD92C1F451D8F")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107312406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107312406;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.906 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "EB01ECD1EBCF3EF87C5FB61A9E7D691A")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206839336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206839336;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.907 -0400", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "E1F74B0E5953E5238A127FA14A91B416")
    @Override
    public DoubleBuffer put(double c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.917 -0400", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "BD0556756292DDFDA09ECAEA42440CCF")
    @Override
    public DoubleBuffer put(int index, double c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.920 -0400", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "9551BF5C45E8866E8CEC1F30C2E78E1C")
    @Override
    public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.921 -0400", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "76B6A5374B6AE5A0CD574F3F2408582B")
    @Override
    public final DoubleBuffer put(DoubleBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.921 -0400", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "2CD149CBEB242581024202038CB3D7B6")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_681247513 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_681247513 = new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_681247513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_681247513;
        // ---------- Original Method ----------
        //return new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

