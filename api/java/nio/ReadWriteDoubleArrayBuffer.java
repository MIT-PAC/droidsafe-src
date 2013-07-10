package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadWriteDoubleArrayBuffer extends DoubleArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.076 -0400", hash_original_method = "B4E24CEABED532340C057028C27A20CE", hash_generated_method = "94E77AA6E102F947FEF29D19E50CF5F5")
      ReadWriteDoubleArrayBuffer(double[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.076 -0400", hash_original_method = "7B955F583014E9C4E7246DF4D4A38AFC", hash_generated_method = "EB41EA5E489DBFB3334B7D9D360186C1")
      ReadWriteDoubleArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.077 -0400", hash_original_method = "070D24C1E4BB222D9665C788C08CE160", hash_generated_method = "8085B051200964852A719C69ED07330E")
      ReadWriteDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
        ReadWriteDoubleArrayBuffer buf =
                new ReadWriteDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.078 -0400", hash_original_method = "5AAFDD62868C036C158BF06CDC5CBF15", hash_generated_method = "066D4D1766ECEE112D471D7A29ACD079")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_648586360 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_648586360 = ReadOnlyDoubleArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_648586360.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_648586360;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.078 -0400", hash_original_method = "335CB60FAB792A2A62A6EF4754C454D6", hash_generated_method = "A9D9313E827DE27904701F0550BF3BB9")
    @Override
    public DoubleBuffer compact() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_426565699 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_426565699 = this;
        varB4EAC82CA7396A68D541C85D26508E83_426565699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_426565699;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.079 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "7F86F1AFF91C9990935F08380BC37F4F")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1485309383 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1485309383 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1485309383.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1485309383;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.080 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "4EEC0F521C97A9E475C107B89B1294DF")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592877894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592877894;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.080 -0400", hash_original_method = "B39E44D51BEA2E7F8F320F30D5A69080", hash_generated_method = "24DF253CFD9B20298FA59400E1E5A5AB")
    @Override
    protected double[] protectedArray() {
        double[] var74D44D7D9EE6FE6C3433D694F869E521_424385498 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_424385498;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.080 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "9F01B043536949DE7580FA35FE6AAB78")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400220159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400220159;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.081 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "A6D65349C2BF6B13E97CA7593632471F")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200494214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_200494214;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.083 -0400", hash_original_method = "3ABE5CDAB9C61826E50F217BC06E7CD8", hash_generated_method = "906AD9F5E7733ADEC437C5AB45645E2C")
    @Override
    public DoubleBuffer put(double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_2071673566 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2071673566 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2071673566.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2071673566;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.085 -0400", hash_original_method = "C8225EBC0979909DB9C4BC520342492D", hash_generated_method = "B1CCC8E6D81D8DB0A94A6808E7C929FD")
    @Override
    public DoubleBuffer put(int index, double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_218193427 = null; 
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_218193427 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_218193427.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_218193427;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.086 -0400", hash_original_method = "DCC0A3236B3D19199252F779E8F302AC", hash_generated_method = "B347124F086B0A1ABC19D21A1D6AD5AF")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_492741270 = null; 
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_988072355 = (doubleCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, doubleCount);
        position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_492741270 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_492741270.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_492741270;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.087 -0400", hash_original_method = "34292390282C3C5B07F994751AC72ECC", hash_generated_method = "03DA5EE3DA9A8875C0637F548E4C5668")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_201662576 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_201662576 = new ReadWriteDoubleArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_201662576.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_201662576;
        
        
    }

    
}

