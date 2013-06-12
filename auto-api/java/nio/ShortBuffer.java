package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.634 -0400", hash_original_method = "EAB92A092C9FEE1EEAB86C6A6FABA79C", hash_generated_method = "C2BF4FDA15AC88187A030F4A7FCE9573")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ShortBuffer(int capacity) {
        super(1, capacity, null);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.638 -0400", hash_original_method = "EBFF8E9D938EEAC173B69FFFF0E788F4", hash_generated_method = "6F0E3EBA0D404FB0AFCEEAE1582B0585")
    public static ShortBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteShortArrayBuffer(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.649 -0400", hash_original_method = "8B4AACC8CC10C13D135A06929763BDF6", hash_generated_method = "509E98722C673CDBAA01B76811FD1BC5")
    public static ShortBuffer wrap(short[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.651 -0400", hash_original_method = "72F1175C01A5143461DE3CE030C68996", hash_generated_method = "40F2E483DA1BD0B0688E5E89D7125496")
    public static ShortBuffer wrap(short[] array, int start, int shortCount) {
        Arrays.checkOffsetAndCount(array.length, start, shortCount);
        ShortBuffer buf = new ReadWriteShortArrayBuffer(array);
        buf.position = start;
        buf.limit = start + shortCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.652 -0400", hash_original_method = "0A1B03C776C1004F61482923BC618EF6", hash_generated_method = "13540C67AC2DD32F237CC7BC66E489FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short[] array() {
        short[] varEA57FBC16B997AC0E679F048893AC79C_1925999128 = (protectedArray());
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.657 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "6358D4EE3D5BF04DD5F0495F84466C91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1676381828 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract ShortBuffer asReadOnlyBuffer();

    
    public abstract ShortBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.669 -0400", hash_original_method = "F5228E310614FF7F70EC616A5A8F6CEB", hash_generated_method = "CD878C0CF72F3EE686BA3248A9263DF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(ShortBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1455401877 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        short thisByte, otherByte;
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1319597617 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //short thisByte, otherByte;
        //while (compareRemaining > 0) {
            //thisByte = get(thisPos);
            //otherByte = otherBuffer.get(otherPos);
            //if (thisByte != otherByte) {
                //return thisByte < otherByte ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract ShortBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.682 -0400", hash_original_method = "5B31F4285E964D7BDABED3BB847D41AA", hash_generated_method = "5C76E54A8164E1ABB33445A238750149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        ShortBuffer otherBuffer;
        otherBuffer = (ShortBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1290736847 = (remaining() != otherBuffer.remaining());
        } //End collapsed parenthetic
        int myPosition;
        myPosition = position;
        int otherPosition;
        otherPosition = otherBuffer.position;
        boolean equalSoFar;
        equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(other instanceof ShortBuffer)) {
            //return false;
        //}
        //ShortBuffer otherBuffer = (ShortBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        //}
        //return equalSoFar;
    }

    
    public abstract short get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.696 -0400", hash_original_method = "68406DA953A1F3530F74FC6FE1C452A7", hash_generated_method = "44460B17C8E7B25B9513A85184FB529E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShortBuffer get(short[] dst) {
        dsTaint.addTaint(dst);
        ShortBuffer var54C52896C1D21D17FF99C7DFE6939F7B_587398819 = (get(dst, 0, dst.length));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.706 -0400", hash_original_method = "DE4C5284FF189AE8B07194EE8C193F03", hash_generated_method = "B5AD06C690B98559114BD360ABFA16C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        {
            boolean varD727A1D2181C264BA4333582F807AE27_487388530 = (shortCount > remaining());
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
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        //if (shortCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + shortCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract short get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.709 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "EF437534F291CCDAC5F5E4BB47E43695")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_702485217 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.712 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "363034E27E0AFE4833C7CE1DB3D1C651")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract short[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract ShortBuffer put(short s);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.732 -0400", hash_original_method = "47A309F7D8F6DC58E14B9D901E5CA4EB", hash_generated_method = "D0539C9803880F9BB002B129556F36C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ShortBuffer put(short[] src) {
        dsTaint.addTaint(src);
        ShortBuffer var974D367CEDA780433BF9CC5389A430C6_1543730025 = (put(src, 0, src.length));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.735 -0400", hash_original_method = "F4EA1FDC39DA95E004DECB204CC15A47", hash_generated_method = "DFF9890573EA903D92097F6394E440B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        {
            boolean varD727A1D2181C264BA4333582F807AE27_560811318 = (shortCount > remaining());
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
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + shortCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.745 -0400", hash_original_method = "1D8FC7647B57D46D94B3AA0BA31269DF", hash_generated_method = "D3A624C90A4A8C04B3185DDCD4774567")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShortBuffer put(ShortBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_418285348 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        short[] contents;
        contents = new short[src.remaining()];
        src.get(contents);
        put(contents);
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //short[] contents = new short[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    public abstract ShortBuffer put(int index, short s);

    
    public abstract ShortBuffer slice();

    
}


