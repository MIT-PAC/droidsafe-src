package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.003 -0400", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "94E77AA6E102F947FEF29D19E50CF5F5")
      ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.003 -0400", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "EB41EA5E489DBFB3334B7D9D360186C1")
      ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.004 -0400", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "8085B051200964852A719C69ED07330E")
      ReadWriteDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadWriteDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadWriteDoubleArrayBuffer buf =
                new ReadWriteDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.009 -0400", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "E997F1FA1312783511C322BDDE4E3968")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1485327534 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1485327534 = ReadOnlyDoubleArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1485327534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1485327534;
        // ---------- Original Method ----------
        //return ReadOnlyDoubleArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.009 -0400", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "3F6CFCD68E0AE0F499D7F72D934B78EE")
    @Override
    public DoubleBuffer compact() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1922484927 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1922484927 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1922484927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1922484927;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.010 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "30BC640465554A577FF8489C85CDAD62")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_447395120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_447395120 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_447395120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_447395120;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.011 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "41AC62D34969E5DFB930C02BABDC3476")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682672459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682672459;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.032 -0400", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "99CAE249F664E800DFC8C7E48E725A96")
    @Override
    protected double[] protectedArray() {
        double[] var74D44D7D9EE6FE6C3433D694F869E521_1788908544 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1788908544;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.032 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "3AC005D0C405F17B349F8A1BEA4C9517")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844780488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844780488;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.033 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F85F9EE9029B625F04AAFC632FCC310C")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_802449103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_802449103;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.040 -0400", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "D80881D2453D7E711C0A9AD5A4A1DA7D")
    @Override
    public DoubleBuffer put(double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_2083929684 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2083929684 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2083929684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2083929684;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.040 -0400", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "38B0E953F55DD7AE6256B57FEE39EFE2")
    @Override
    public DoubleBuffer put(int index, double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_2072232447 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2072232447 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2072232447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072232447;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.044 -0400", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "87B0580020725AAB880D3FDC39C62B47")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_858028820 = null; //Variable for return #1
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_2137627455 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_858028820 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_858028820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_858028820;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.045 -0400", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "151582B09B12D96B594EB80B83263E0B")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1000331731 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1000331731 = new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1000331731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1000331731;
        // ---------- Original Method ----------
        //return new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

