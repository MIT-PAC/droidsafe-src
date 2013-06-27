package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.051 -0400", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "94E77AA6E102F947FEF29D19E50CF5F5")
      ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.060 -0400", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "EB41EA5E489DBFB3334B7D9D360186C1")
      ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.061 -0400", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "8085B051200964852A719C69ED07330E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.063 -0400", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "27D8F5D593FE2AE057207C264527782E")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_136944121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_136944121 = ReadOnlyDoubleArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_136944121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136944121;
        // ---------- Original Method ----------
        //return ReadOnlyDoubleArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.096 -0400", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "D1DEFA1E49CD882BED0FB0D78B8AAC7D")
    @Override
    public DoubleBuffer compact() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_135794460 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_135794460 = this;
        varB4EAC82CA7396A68D541C85D26508E83_135794460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_135794460;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.097 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "BDB94D0F92C701A85486B1F5D19BABE8")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1910981955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1910981955 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1910981955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1910981955;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.097 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "A7F63EA3337D2652FD30D3B1DDC03EDB")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745299946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745299946;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.098 -0400", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "FD2B835CE826237F8D2BB43CBA45B0D2")
    @Override
    protected double[] protectedArray() {
        double[] var74D44D7D9EE6FE6C3433D694F869E521_624680091 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_624680091;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.102 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "E3327D29C61B8F8781AC0D8B46880C91")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915712059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915712059;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.102 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F812FF614C4EF3BA730DB9A54FEEC508")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084436901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084436901;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.103 -0400", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "7F236A6CA1BF060C38439A736FCB7C43")
    @Override
    public DoubleBuffer put(double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1778551737 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1778551737 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1778551737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1778551737;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.106 -0400", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "CB69C927965945C96A2B055586264B2D")
    @Override
    public DoubleBuffer put(int index, double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_159289 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_159289 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_159289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_159289;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.150 -0400", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "9A5A4E7D852519A69C156505915C8F20")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1786492150 = null; //Variable for return #1
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1419086569 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_1786492150 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1786492150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1786492150;
        // ---------- Original Method ----------
        //if (doubleCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        //position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.151 -0400", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "D12C630DE9C293F78E4164F7F4231C5F")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_830793958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_830793958 = new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_830793958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_830793958;
        // ---------- Original Method ----------
        //return new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

