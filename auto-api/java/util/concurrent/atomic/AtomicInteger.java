package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import sun.misc.Unsafe;

public class AtomicInteger extends Number implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.378 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "AACF1191CE0421BEFC63226B2561E15D")

    private volatile int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.378 -0400", hash_original_method = "A3EEEE607FBEBD432F4111F47BB23345", hash_generated_method = "C1B1444E172E49708F3A7562ABBF445D")
    public  AtomicInteger(int initialValue) {
        value = initialValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.379 -0400", hash_original_method = "3B74ED36698F9901BA50127D104C26DE", hash_generated_method = "3FC2676712951E4C0961989AC4A65B09")
    public  AtomicInteger() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.379 -0400", hash_original_method = "2C5A1089E8025181868581E48D922F38", hash_generated_method = "A6037AF60F467A25344DA569304E4766")
    public final int get() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630117056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630117056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.379 -0400", hash_original_method = "E51FD8A91C159D9D3ED3BF52073569AD", hash_generated_method = "046E83718895B73384C8E1C3323B55FE")
    public final void set(int newValue) {
        value = newValue;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.380 -0400", hash_original_method = "77EB9E59BE67AA43485FF3A0F0492CB7", hash_generated_method = "953B5CAC3CE05682D98FD3CDB8C68AF2")
    public final void lazySet(int newValue) {
        unsafe.putOrderedInt(this, valueOffset, newValue);
        addTaint(newValue);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.380 -0400", hash_original_method = "EFF79965BA8CD7578F2A5616273687C7", hash_generated_method = "DEDE4FC6139CED19CC187B8EC7B068D4")
    public final int getAndSet(int newValue) {
        {
            int current = get();
            {
                boolean var1BF0B39916F57DCB46753C3922743628_1239188176 = (compareAndSet(current, newValue));
            } 
        } 
        addTaint(newValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141719831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141719831;
        
        
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.380 -0400", hash_original_method = "3CF6D7A3DD4EDBE8D1648E756B160F53", hash_generated_method = "AE5CA278AF24C1BD6CFA065A32A1773E")
    public final boolean compareAndSet(int expect, int update) {
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_275204740 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944813809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944813809;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.381 -0400", hash_original_method = "22EC2300FEC70C46ECF009D542FC9430", hash_generated_method = "C0E181B32DD4ABADD42B57B33613DA95")
    public final boolean weakCompareAndSet(int expect, int update) {
        boolean varA219EEBEFD3FA4DCBF9D61615A3EEAA5_217333049 = (unsafe.compareAndSwapInt(this, valueOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556923473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_556923473;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.381 -0400", hash_original_method = "621C33BC86CD3122044A53600F895B29", hash_generated_method = "B8FBE17D7DEDD67DE2A482CA53F31017")
    public final int getAndIncrement() {
        {
            int current = get();
            int next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_943211075 = (compareAndSet(current, next));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2133222215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2133222215;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.381 -0400", hash_original_method = "D5257E8A410056D1BB1DB7447390EAE5", hash_generated_method = "5EE6995202270E7579AB76953B3D3191")
    public final int getAndDecrement() {
        {
            int current = get();
            int next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_647111174 = (compareAndSet(current, next));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276445976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276445976;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.382 -0400", hash_original_method = "4B803B85C89B0C062A735FA86D4518AE", hash_generated_method = "4C00839E11669A28A779C37D39F7A7E8")
    public final int getAndAdd(int delta) {
        {
            int current = get();
            int next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1770341228 = (compareAndSet(current, next));
            } 
        } 
        addTaint(delta);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805807208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805807208;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.382 -0400", hash_original_method = "6DC45C427ABFB1C3B7D74803EAAF22FF", hash_generated_method = "39644C68412F77F918DDBC746A6E32C1")
    public final int incrementAndGet() {
        {
            int current = get();
            int next = current + 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_49937641 = (compareAndSet(current, next));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595598057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595598057;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.383 -0400", hash_original_method = "4357F9DD6725F5F393683EE2EA89C677", hash_generated_method = "E7260DE99768CAFCFABCF718E446C8D5")
    public final int decrementAndGet() {
        {
            int current = get();
            int next = current - 1;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_1219841959 = (compareAndSet(current, next));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659394156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659394156;
        
        
            
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.383 -0400", hash_original_method = "5280B98EAB69F2A556138E3D06C4D0D3", hash_generated_method = "D64118D5EE047AB7DCC7177A730BC8D5")
    public final int addAndGet(int delta) {
        {
            int current = get();
            int next = current + delta;
            {
                boolean var510DE07D8218F2470E372FDE313DC536_363874159 = (compareAndSet(current, next));
            } 
        } 
        addTaint(delta);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465873048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465873048;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.384 -0400", hash_original_method = "0CBFF056CB46F189F8DC45AFB469D5F9", hash_generated_method = "8B63E2B6BB841A0E34D1EA3B2976722A")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851293522 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1851293522 = Integer.toString(get());
        varB4EAC82CA7396A68D541C85D26508E83_1851293522.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1851293522;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.385 -0400", hash_original_method = "B90EC926C8275C97256DF1E0AD9FC076", hash_generated_method = "279F306BA6E4016C20ED136A84175BE5")
    public int intValue() {
        int varA3899375788C01929C876C11142E44FF_66875884 = (get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409949291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409949291;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.385 -0400", hash_original_method = "41D936CCD9A9D16949AE3FD60738B8AD", hash_generated_method = "20427D6821725BAB70B8DDEA144869DF")
    public long longValue() {
        long var3647B297BC29A3BA088BCA1543A8629B_765265941 = ((long)get());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1529222957 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1529222957;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.385 -0400", hash_original_method = "F8181329F165428C51D2197BB97797EF", hash_generated_method = "700A1EBC9A51CF5D6951672185C1B44D")
    public float floatValue() {
        float varACA887607DBB4E1678238A769AA68C60_361326755 = ((float)get());
        float var546ADE640B6EDFBC8A086EF31347E768_1504348261 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1504348261;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.386 -0400", hash_original_method = "486C42E34E3619D90E05BCBEDA3844AE", hash_generated_method = "572806EB7C188DADD6AF28DDEB00256F")
    public double doubleValue() {
        double var1116C2BD9A20FF0A436A87C6D78A46AB_46281465 = ((double)get());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1859597676 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1859597676;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.386 -0400", hash_original_field = "B183F0A1B10C2484948F6B1EC8551E73", hash_generated_field = "BC575BADA52C64A5C5C6ADD1B81BACA0")

    private static final long serialVersionUID = 6214790243416807050L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.386 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.386 -0400", hash_original_field = "E4002F6831845B0AFA359DE89C6BBA04", hash_generated_field = "3ACE806C2A776E8F67FFC072288734E8")

    private static long valueOffset;
    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (AtomicInteger.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
}

