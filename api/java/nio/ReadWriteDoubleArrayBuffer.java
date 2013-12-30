package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.157 -0500", hash_original_method = "B4DD23FAC6B45B9B9799273EFF44AF97", hash_generated_method = "326975168A77573ABC68823CF7C3D9FE")
    
static ReadWriteDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadWriteDoubleArrayBuffer buf =
                new ReadWriteDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.159 -0500", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "B4E24CEABED532340C057028C27A20CE")
    
ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.162 -0500", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "7B955F583014E9C4E7246DF4D4A38AFC")
    
ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.164 -0500", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "070D24C1E4BB222D9665C788C08CE160")
    
ReadWriteDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.167 -0500", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "F139BBAEEEAA7D500FF50F9A086BDEE6")
    
@Override
    public DoubleBuffer asReadOnlyBuffer() {
        return ReadOnlyDoubleArrayBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.169 -0500", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "235637EA773C4656222201668B487414")
    
@Override
    public DoubleBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.172 -0500", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "E1F7F130092CB18A0E883959C7AF36FC")
    
@Override
    public DoubleBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.174 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.177 -0500", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "465E5C1D8B17B7ABC2C103A4C723BBA0")
    
@Override
    protected double[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.179 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    
@Override
    protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.181 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    
@Override
    protected boolean protectedHasArray() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.184 -0500", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "11A91784CBC57F02458B3428DD11573D")
    
@Override
    public DoubleBuffer put(double c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.186 -0500", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "BC5DD6548F971F3674C355FF0995EB7E")
    
@Override
    public DoubleBuffer put(int index, double c) {
        checkIndex(index);
        backingArray[offset + index] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.189 -0500", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "24DE8C05901F96A7F4C2C7189F79E5E8")
    
@Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        if (doubleCount > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:06.191 -0500", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "65EA31BBF7A92177116983D3EB485175")
    
@Override
    public DoubleBuffer slice() {
        return new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

