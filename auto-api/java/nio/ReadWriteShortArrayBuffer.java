package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.962 -0400", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "95C20A4A565849EDC7CFFBCE9393F706")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteShortArrayBuffer(short[] array) {
        super(array);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.962 -0400", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "D927A3D790C41F14276B658A321B5652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.963 -0400", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "B0841489C29F8CA452DCF5533963E9DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteShortArrayBuffer(int capacity, short[] backingArray,
            int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadWriteShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadWriteShortArrayBuffer buf =
                new ReadWriteShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.963 -0400", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "550E69C86DDB3D26C08EF34D17ACD022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer var9D6B3C5EF8423F479C04F6C671475BAE_2089652274 = (ReadOnlyShortArrayBuffer.copy(this, mark));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyShortArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.963 -0400", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "DE0EDC90C740F9D49D72C48625253E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.963 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "644D3FE8A0F12B7132539CB1DA644427")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer var8C82ED9E4FDE12C9486E1252174918B6_1035747533 = (copy(this, mark));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.963 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.964 -0400", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "30163DFDBE9D06F477EFE62760B360CA")
    @DSModeled(DSC.SAFE)
    @Override
    protected short[] protectedArray() {
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.964 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.964 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.964 -0400", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "B9E04AEFFBA72568BF3BE9191C432B29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(short c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.964 -0400", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "99CEB24A344EE58A7D0A8F464990605B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(int index, short c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        backingArray[offset + index] = c;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.965 -0400", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "2AFF7AAAFF47F432EF82DFBCD571B6A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        dsTaint.addTaint(shortCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        {
            boolean varD727A1D2181C264BA4333582F807AE27_1520261932 = (shortCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.965 -0400", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "D8CADB800EDBD6526D3BDCB802E6BE49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ShortBuffer slice() {
        ShortBuffer var7887B4CC6185633856B4CA1CC8B4F85E_126451609 = (new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position));
        return (ShortBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

