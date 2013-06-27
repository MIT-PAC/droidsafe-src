package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.250 -0400", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "E632E4EC7764C222EF3E3833B184A64D")
      DoubleBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static DoubleBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDoubleArrayBuffer(capacity);
    }

    
        public static DoubleBuffer wrap(double[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static DoubleBuffer wrap(double[] array, int start, int doubleCount) {
        Arrays.checkOffsetAndCount(array.length, start, doubleCount);
        DoubleBuffer buf = new ReadWriteDoubleArrayBuffer(array);
        buf.position = start;
        buf.limit = start + doubleCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.251 -0400", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "76E56D3689F9FBC0B1903937A0ABA769")
    public final double[] array() {
        double[] varEA57FBC16B997AC0E679F048893AC79C_964442238 = (protectedArray());
        double[] var74D44D7D9EE6FE6C3433D694F869E521_456862840 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_456862840;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.264 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "334CF711EA702312184FB3FC305B7BE3")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1849185814 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561120199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561120199;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract DoubleBuffer asReadOnlyBuffer();

    
    public abstract DoubleBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.265 -0400", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "E875C4CA7D585F5205F1EF1CD944C91A")
    public int compareTo(DoubleBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1637821304 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        double thisDouble, otherDouble;
        {
            thisDouble = get(thisPos);
            otherDouble = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1264386796 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718913881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718913881;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //double thisDouble, otherDouble;
        //while (compareRemaining > 0) {
            //thisDouble = get(thisPos);
            //otherDouble = otherBuffer.get(otherPos);
            //if ((thisDouble != otherDouble)
                    //&& ((thisDouble == thisDouble) || (otherDouble == otherDouble))) {
                //return thisDouble < otherDouble ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract DoubleBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.266 -0400", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "51287A0AFCE9367771B82E7E39014A9A")
    @Override
    public boolean equals(Object other) {
        DoubleBuffer otherBuffer;
        otherBuffer = (DoubleBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1494392270 = (remaining() != otherBuffer.remaining());
        } //End collapsed parenthetic
        int myPosition;
        myPosition = position;
        int otherPosition;
        otherPosition = otherBuffer.position;
        boolean equalSoFar;
        equalSoFar = true;
        {
            double a;
            a = get(myPosition++);
            double b;
            b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313908502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313908502;
        // ---------- Original Method ----------
        //if (!(other instanceof DoubleBuffer)) {
            //return false;
        //}
        //DoubleBuffer otherBuffer = (DoubleBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //double a = get(myPosition++);
            //double b = otherBuffer.get(otherPosition++);
            //equalSoFar = a == b || (a != a && b != b);
        //}
        //return equalSoFar;
    }

    
    public abstract double get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.266 -0400", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "B3D0DB9C495D05AF546667D711339A91")
    public DoubleBuffer get(double[] dst) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_827632331 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_827632331 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_827632331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827632331;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.267 -0400", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "668740C8253BE84E7E4CAB5A4A49A67A")
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1091219921 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1131849027 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = dstOffset;
            {
                dst[i] = get();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1091219921 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1091219921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1091219921;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        //if (doubleCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + doubleCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract double get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.272 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "82BC3436A4DEF06A06A6345CB4955B08")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_833892731 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655567762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_655567762;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.285 -0400", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "0AF2CAB046C0315DC0A94A6AD9DD64FC")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        long l;
        {
            l = Double.doubleToLongBits(get(myPosition++));
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347796528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347796528;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //long l;
        //while (myPosition < limit) {
            //l = Double.doubleToLongBits(get(myPosition++));
            //hash = hash + ((int) l) ^ ((int) (l >> 32));
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract double[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract DoubleBuffer put(double d);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.287 -0400", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "6680A819464B89B0AC211E3411E3057A")
    public final DoubleBuffer put(double[] src) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1436624296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1436624296 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1436624296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1436624296;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.297 -0400", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "9BEF9593398165515B70C425EE49F15C")
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_843275319 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_896920673 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = srcOffset;
            {
                put(src[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_843275319 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_843275319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843275319;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + doubleCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.298 -0400", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "C49CA83114C3D8205082231E7EFF477D")
    public DoubleBuffer put(DoubleBuffer src) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1757134151 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1714294832 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1262633151 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        double[] doubles;
        doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
        varB4EAC82CA7396A68D541C85D26508E83_1757134151 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1757134151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757134151;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //double[] doubles = new double[src.remaining()];
        //src.get(doubles);
        //put(doubles);
        //return this;
    }

    
    public abstract DoubleBuffer put(int index, double d);

    
    public abstract DoubleBuffer slice();

    
}

