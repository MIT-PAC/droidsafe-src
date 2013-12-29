package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.208 -0500", hash_original_method = "E3456167139738CE5D2A1FA4F9C0A044", hash_generated_method = "BAE0DF152F3B27576EF75FF67D613804")
    static ReadOnlyDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadOnlyDoubleArrayBuffer buf =
                new ReadOnlyDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.209 -0500", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "3FFC117F0906E795E350A76B08676C14")
    ReadOnlyDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.210 -0500", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "1B9C6C69660A337673A3D297AAB238DB")
    @Override
public DoubleBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.211 -0500", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "1858EF0337B8CF3628D749FEC009D8EB")
    @Override
public DoubleBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.212 -0500", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "E1F7F130092CB18A0E883959C7AF36FC")
    @Override
public DoubleBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.213 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    @Override
public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.214 -0500", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "AA90038A6CD7EF67D87377AE5BA553E7")
    @Override
protected double[] protectedArray() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.215 -0500", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "74EBBCBD37A62C7AD6A8876E571480EF")
    @Override
protected int protectedArrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.216 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    @Override
protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.216 -0500", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "22A581B49DBD210C614C0D2BE4478F19")
    @Override
public DoubleBuffer put(double c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.217 -0500", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "C948FA47550B9039778421D6860E0DC5")
    @Override
public DoubleBuffer put(int index, double c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.218 -0500", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "2C7D8F6DB95F7E3353ED8DEC19C7B027")
    @Override
public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.219 -0500", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "6DCFA10935B5E32C90241E5655E81009")
    @Override
public final DoubleBuffer put(DoubleBuffer buf) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.220 -0500", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "D0EDD6CC954B918D5655BE97BB86A825")
    @Override
public DoubleBuffer slice() {
        return new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

