package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.VMStack;
import sun.misc.Unsafe;
import java.lang.reflect.*;

public abstract class AtomicLongFieldUpdater<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.522 -0400", hash_original_method = "BA7F0F8CC0F2CFF6E035F4AABDB58BFC", hash_generated_method = "62F6218EF261DD24445A14F0CE964A46")
    protected  AtomicLongFieldUpdater() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static <U> AtomicLongFieldUpdater<U> newUpdater(Class<U> tclass, String fieldName) {
        if (AtomicLong.VM_SUPPORTS_LONG_CAS)
            return new CASUpdater<U>(tclass, fieldName);
        else
            return new LockedUpdater<U>(tclass, fieldName);
    }

    
    public abstract boolean compareAndSet(T obj, long expect, long update);

    
    public abstract boolean weakCompareAndSet(T obj, long expect, long update);

    
    public abstract void set(T obj, long newValue);

    
    public abstract void lazySet(T obj, long newValue);

    
    public abstract long get(T obj);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.523 -0400", hash_original_method = "073A4CF50E22F9EE4C4340BA9014F29C", hash_generated_method = "06331A022A7F8A52C561671A8C6912C8")
    public long getAndSet(T obj, long newValue) {
        {
            long current = get(obj);
            {
                boolean varEF6F11C12EB2BCFEFD370C9B71CA9D76_222320655 = (compareAndSet(obj, current, newValue));
            } 
        } 
        addTaint(obj.getTaint());
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_516436927 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_516436927;
        
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.523 -0400", hash_original_method = "FFCFE702F404925FF472694110925E69", hash_generated_method = "690D16C5CDEACC4BDF53BBB535A84B2F")
    public long getAndIncrement(T obj) {
        {
            long current = get(obj);
            long next = current + 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_397865788 = (compareAndSet(obj, current, next));
            } 
        } 
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1798054509 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1798054509;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.524 -0400", hash_original_method = "9CAF92F1F2494CDDDA53F7B31DDB70AC", hash_generated_method = "42532B2A697D37285BFEDA098FB731F8")
    public long getAndDecrement(T obj) {
        {
            long current = get(obj);
            long next = current - 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_207833308 = (compareAndSet(obj, current, next));
            } 
        } 
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_796922369 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_796922369;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.524 -0400", hash_original_method = "3764C955A48CF6808C45F475DCFC56BA", hash_generated_method = "9BC40E2EA0458DED61AF538B045CA447")
    public long getAndAdd(T obj, long delta) {
        {
            long current = get(obj);
            long next = current + delta;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1953851498 = (compareAndSet(obj, current, next));
            } 
        } 
        addTaint(obj.getTaint());
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1825155034 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1825155034;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.524 -0400", hash_original_method = "1591AE6B0EAC64083036B0657AF8C8E8", hash_generated_method = "27C066C313E3DB3819A9EC13740C4427")
    public long incrementAndGet(T obj) {
        {
            long current = get(obj);
            long next = current + 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_127178696 = (compareAndSet(obj, current, next));
            } 
        } 
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_310247351 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_310247351;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.525 -0400", hash_original_method = "F278D43CE5D7C7A4E3E54A0A47080CD8", hash_generated_method = "7775D3BEEEC9C28A4FDD68B464028073")
    public long decrementAndGet(T obj) {
        {
            long current = get(obj);
            long next = current - 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1453631731 = (compareAndSet(obj, current, next));
            } 
        } 
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1314431423 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1314431423;
        
        
            
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.526 -0400", hash_original_method = "7BA11FC3A8E7EFFF8D5EBE339E5290E0", hash_generated_method = "4B60D7482F78BEE569802680FBDA5EC9")
    public long addAndGet(T obj, long delta) {
        {
            long current = get(obj);
            long next = current + delta;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_175077495 = (compareAndSet(obj, current, next));
            } 
        } 
        addTaint(obj.getTaint());
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_124400311 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_124400311;
        
        
            
            
            
                
        
    }

    
    private static class CASUpdater<T> extends AtomicLongFieldUpdater<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.526 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private long offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.526 -0400", hash_original_field = "53171F971C64AB072B4CC14815B91ED9", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private Class<T> tclass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.526 -0400", hash_original_field = "DFC2701C4FD938B2EFC3EE0D85BEEE97", hash_generated_field = "EF93B5BCFAF7F06AB9E1923720793677")

        private Class cclass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.527 -0400", hash_original_method = "3C60415DB6C3E1541F6CE2F79F2229C7", hash_generated_method = "3FAF18D41990A90CBB3999EB2BD98F39")
          CASUpdater(Class<T> tclass, String fieldName) {
            Field field = null;
            Class caller = null;
            int modifiers = 0;
            try 
            {
                field = tclass.getDeclaredField(fieldName);
                caller = VMStack.getStackClass2();
                modifiers = field.getModifiers();
            } 
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } 
            Class fieldt = field.getType();
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be long type");
            {
                boolean var60B416625B50ACEF1DA4DA2F835A2BDA_1224491939 = (!Modifier.isVolatile(modifiers));
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be volatile type");
            } 
            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
            addTaint(fieldName.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.528 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "3FC110296E14E9B3D8B9B47568261F0F")
        private void fullCheck(T obj) {
            {
                boolean var08A757AC16599EE9FA86D0ACCDFB617F_220885925 = (!tclass.isInstance(obj));
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException();
            } 
            ensureProtectedAccess(obj);
            addTaint(obj.getTaint());
            
            
                
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.528 -0400", hash_original_method = "0B1B8A08B80DC3AD108753B0AFE3A4E8", hash_generated_method = "FD6040A1796C9E6C85EB6870012B274F")
        public boolean compareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_2030329528 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            boolean var4D1224EBF8FF0DF75D7E6D4DE35B1DC6_440534765 = (unsafe.compareAndSwapLong(obj, offset, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99101762 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_99101762;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.528 -0400", hash_original_method = "FA5ECB357D30254C8585479D53202326", hash_generated_method = "1D1E08C5BC43A009CB50C8F67FB4860F")
        public boolean weakCompareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_417408747 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            boolean var4D1224EBF8FF0DF75D7E6D4DE35B1DC6_646632881 = (unsafe.compareAndSwapLong(obj, offset, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832157513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832157513;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.529 -0400", hash_original_method = "71897CED5F2740E2249B4A6609AE4D6E", hash_generated_method = "A03B0C28F8E1868C20AA93B0D8AC524D")
        public void set(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_226531468 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            unsafe.putLongVolatile(obj, offset, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.529 -0400", hash_original_method = "51078ADC8C79D48D4C02CCADFB4A4445", hash_generated_method = "FB245E18D456A376DCB1E6EACADF345A")
        public void lazySet(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1338985412 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            unsafe.putOrderedLong(obj, offset, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.529 -0400", hash_original_method = "DD571ADDCD61186BA82D3AD7916B61C6", hash_generated_method = "9284D59D4DFEA0D7F005B5A62B0154E6")
        public long get(T obj) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1041148899 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            long var6976292DBE2A2878DD246D6DAC256FC7_149368487 = (unsafe.getLongVolatile(obj, offset));
            addTaint(obj.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1340034201 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1340034201;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.530 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "A04410BD4BDBD8FF6F4B0207DB0B2977")
        private void ensureProtectedAccess(T obj) {
            {
                boolean var76354D080B43280F16DDC78A61CBBC1D_1137877797 = (cclass.isInstance(obj));
            } 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                new IllegalAccessException("Class " +
                    cclass.getName() +
                    " can not access a protected member of class " +
                    tclass.getName() +
                    " using an instance of " +
                    obj.getClass().getName()
                )
            );
            addTaint(obj.getTaint());
            
            
                
            
            
                
                    
                    
                    
                    
                    
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.530 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

        private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    }


    
    private static class LockedUpdater<T> extends AtomicLongFieldUpdater<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.530 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private long offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.530 -0400", hash_original_field = "53171F971C64AB072B4CC14815B91ED9", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private Class<T> tclass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.530 -0400", hash_original_field = "DFC2701C4FD938B2EFC3EE0D85BEEE97", hash_generated_field = "EF93B5BCFAF7F06AB9E1923720793677")

        private Class cclass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.531 -0400", hash_original_method = "C5B75212C8FC0ABD1ADCFDBA1ED5609A", hash_generated_method = "6AD2486930DC97DBADE65E980D385EB0")
          LockedUpdater(Class<T> tclass, String fieldName) {
            Field field = null;
            Class caller = null;
            int modifiers = 0;
            try 
            {
                field = tclass.getDeclaredField(fieldName);
                caller = VMStack.getStackClass2();
                modifiers = field.getModifiers();
            } 
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } 
            Class fieldt = field.getType();
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be long type");
            {
                boolean var60B416625B50ACEF1DA4DA2F835A2BDA_907636641 = (!Modifier.isVolatile(modifiers));
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be volatile type");
            } 
            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
            addTaint(fieldName.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.531 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "C8A6B75B410C692421A8F2C11BB93DCB")
        private void fullCheck(T obj) {
            {
                boolean var08A757AC16599EE9FA86D0ACCDFB617F_1612352909 = (!tclass.isInstance(obj));
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException();
            } 
            ensureProtectedAccess(obj);
            addTaint(obj.getTaint());
            
            
                
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.531 -0400", hash_original_method = "F28EEE820E0CC0A4DFB94FC74A5AFE78", hash_generated_method = "FACB71A8041ADF3E1D1D1F059834EBD6")
        public boolean compareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_226340912 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            {
                long v = unsafe.getLong(obj, offset);
                unsafe.putLong(obj, offset, update);
            } 
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436840217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436840217;
            
            
            
                
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.532 -0400", hash_original_method = "14B3E8CFE4FC936117A23CCF5649E4AE", hash_generated_method = "C92AB90DBF8B4CEF6FBB77183B4180B1")
        public boolean weakCompareAndSet(T obj, long expect, long update) {
            boolean varC09D6F22E92EA7FB90F428B4D65C123E_2041919990 = (compareAndSet(obj, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063431213 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063431213;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.532 -0400", hash_original_method = "669ED1C08689C1E7A362C28D2C445452", hash_generated_method = "52950221E6BE99BE83562888D0E5277A")
        public void set(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1045778295 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            {
                unsafe.putLong(obj, offset, newValue);
            } 
            addTaint(obj.getTaint());
            addTaint(newValue);
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.532 -0400", hash_original_method = "B254126A5A9A310CC60672857EFE3992", hash_generated_method = "B62C496D9EB6825C176445B9581CB8A3")
        public void lazySet(T obj, long newValue) {
            set(obj, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.538 -0400", hash_original_method = "DD3CDDB3808B9B1B599C95B5AE839523", hash_generated_method = "D4C161FBC612125054B4D9A110C236D8")
        public long get(T obj) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_774087822 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } 
            {
                long var7FA8DBAEF21C12A0B494ECC88AF219DF_921625234 = (unsafe.getLong(obj, offset));
            } 
            addTaint(obj.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1709568908 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1709568908;
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.538 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "A99BBB955D76E7365B250322E60D4EFB")
        private void ensureProtectedAccess(T obj) {
            {
                boolean var76354D080B43280F16DDC78A61CBBC1D_10547639 = (cclass.isInstance(obj));
            } 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                new IllegalAccessException("Class " +
                    cclass.getName() +
                    " can not access a protected member of class " +
                    tclass.getName() +
                    " using an instance of " +
                    obj.getClass().getName()
                )
            );
            addTaint(obj.getTaint());
            
            
                
            
            
                
                    
                    
                    
                    
                    
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.538 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

        private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    }


    
}

