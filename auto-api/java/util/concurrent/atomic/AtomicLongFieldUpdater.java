package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.VMStack;
import sun.misc.Unsafe;
import java.lang.reflect.*;

public abstract class AtomicLongFieldUpdater<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.068 -0400", hash_original_method = "BA7F0F8CC0F2CFF6E035F4AABDB58BFC", hash_generated_method = "62F6218EF261DD24445A14F0CE964A46")
    protected  AtomicLongFieldUpdater() {
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.069 -0400", hash_original_method = "073A4CF50E22F9EE4C4340BA9014F29C", hash_generated_method = "BAC4BB26F06A67DC8F7B10DFED64CBC1")
    public long getAndSet(T obj, long newValue) {
        {
            long current;
            current = get(obj);
            {
                boolean varEF6F11C12EB2BCFEFD370C9B71CA9D76_1539758111 = (compareAndSet(obj, current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_738806832 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_738806832;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //if (compareAndSet(obj, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.079 -0400", hash_original_method = "FFCFE702F404925FF472694110925E69", hash_generated_method = "8342A027CA3EB699C29F840184CD4151")
    public long getAndIncrement(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_999759713 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1763285769 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1763285769;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + 1;
            //if (compareAndSet(obj, current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.079 -0400", hash_original_method = "9CAF92F1F2494CDDDA53F7B31DDB70AC", hash_generated_method = "C968CD23E3FCF304AA1766FE0674F151")
    public long getAndDecrement(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current - 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_2142389427 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_551758963 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_551758963;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current - 1;
            //if (compareAndSet(obj, current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.079 -0400", hash_original_method = "3764C955A48CF6808C45F475DCFC56BA", hash_generated_method = "FC0D76F7F616CF7FC966E800FCFAF962")
    public long getAndAdd(T obj, long delta) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + delta;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1834364176 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1547864935 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1547864935;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + delta;
            //if (compareAndSet(obj, current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.080 -0400", hash_original_method = "1591AE6B0EAC64083036B0657AF8C8E8", hash_generated_method = "A21761B880D7B8BF8CAB4AFD8EE69F21")
    public long incrementAndGet(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1180624691 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_467644572 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_467644572;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + 1;
            //if (compareAndSet(obj, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.080 -0400", hash_original_method = "F278D43CE5D7C7A4E3E54A0A47080CD8", hash_generated_method = "CBE2CBD793D706782F9F5586058ACF03")
    public long decrementAndGet(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current - 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_934539929 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1524961826 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1524961826;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current - 1;
            //if (compareAndSet(obj, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.080 -0400", hash_original_method = "7BA11FC3A8E7EFFF8D5EBE339E5290E0", hash_generated_method = "72F1E5F4FBC0FDA5A61E2C7BB7C17939")
    public long addAndGet(T obj, long delta) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + delta;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1637541929 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1409196189 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1409196189;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + delta;
            //if (compareAndSet(obj, current, next))
                //return next;
        //}
    }

    
    private static class CASUpdater<T> extends AtomicLongFieldUpdater<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.081 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private long offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.081 -0400", hash_original_field = "53171F971C64AB072B4CC14815B91ED9", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private Class<T> tclass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.081 -0400", hash_original_field = "DFC2701C4FD938B2EFC3EE0D85BEEE97", hash_generated_field = "EF93B5BCFAF7F06AB9E1923720793677")

        private Class cclass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.082 -0400", hash_original_method = "3C60415DB6C3E1541F6CE2F79F2229C7", hash_generated_method = "CF470E78D8B0AD89D72295F7F5CE46D3")
          CASUpdater(Class<T> tclass, String fieldName) {
            Field field;
            field = null;
            Class caller;
            caller = null;
            int modifiers;
            modifiers = 0;
            try 
            {
                field = tclass.getDeclaredField(fieldName);
                caller = VMStack.getStackClass2();
                modifiers = field.getModifiers();
            } //End block
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            Class fieldt;
            fieldt = field.getType();
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be long type");
            {
                boolean var60B416625B50ACEF1DA4DA2F835A2BDA_1680510798 = (!Modifier.isVolatile(modifiers));
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be volatile type");
            } //End collapsed parenthetic
            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.083 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "56382CE55AE0DDB901493879A16E0E24")
        private void fullCheck(T obj) {
            {
                boolean var08A757AC16599EE9FA86D0ACCDFB617F_1674787476 = (!tclass.isInstance(obj));
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException();
            } //End collapsed parenthetic
            ensureProtectedAccess(obj);
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //if (!tclass.isInstance(obj))
                //throw new ClassCastException();
            //if (cclass != null)
                //ensureProtectedAccess(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.083 -0400", hash_original_method = "0B1B8A08B80DC3AD108753B0AFE3A4E8", hash_generated_method = "5896914FD28E59FC4DABE2EA99D61548")
        public boolean compareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_957326073 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            boolean var4D1224EBF8FF0DF75D7E6D4DE35B1DC6_1612218212 = (unsafe.compareAndSwapLong(obj, offset, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471840980 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_471840980;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //return unsafe.compareAndSwapLong(obj, offset, expect, update);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.090 -0400", hash_original_method = "FA5ECB357D30254C8585479D53202326", hash_generated_method = "2B89A61A618F43D04875B6A528DB991D")
        public boolean weakCompareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1272659182 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            boolean var4D1224EBF8FF0DF75D7E6D4DE35B1DC6_1198518010 = (unsafe.compareAndSwapLong(obj, offset, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424416779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_424416779;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //return unsafe.compareAndSwapLong(obj, offset, expect, update);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.094 -0400", hash_original_method = "71897CED5F2740E2249B4A6609AE4D6E", hash_generated_method = "FB0AA59262C40D637589FF502D7D35FD")
        public void set(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1494269667 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            unsafe.putLongVolatile(obj, offset, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //unsafe.putLongVolatile(obj, offset, newValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.103 -0400", hash_original_method = "51078ADC8C79D48D4C02CCADFB4A4445", hash_generated_method = "032B24F880DEE8ACB8DDD5B33A0F5D34")
        public void lazySet(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_187359276 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            unsafe.putOrderedLong(obj, offset, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //unsafe.putOrderedLong(obj, offset, newValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.103 -0400", hash_original_method = "DD571ADDCD61186BA82D3AD7916B61C6", hash_generated_method = "FF28C1BDB95689262CA808CA08488A8F")
        public long get(T obj) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1111029684 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            long var6976292DBE2A2878DD246D6DAC256FC7_117889381 = (unsafe.getLongVolatile(obj, offset));
            addTaint(obj.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1502139363 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1502139363;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //return unsafe.getLongVolatile(obj, offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.107 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "472895F9E8891E069594EFBBBF410625")
        private void ensureProtectedAccess(T obj) {
            {
                boolean var76354D080B43280F16DDC78A61CBBC1D_107282767 = (cclass.isInstance(obj));
            } //End collapsed parenthetic
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
            // ---------- Original Method ----------
            //if (cclass.isInstance(obj)) {
                //return;
            //}
            //throw new RuntimeException(
                //new IllegalAccessException("Class " +
                    //cclass.getName() +
                    //" can not access a protected member of class " +
                    //tclass.getName() +
                    //" using an instance of " +
                    //obj.getClass().getName()
                //)
            //);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.107 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

        private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    }


    
    private static class LockedUpdater<T> extends AtomicLongFieldUpdater<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.107 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private long offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.107 -0400", hash_original_field = "53171F971C64AB072B4CC14815B91ED9", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private Class<T> tclass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.107 -0400", hash_original_field = "DFC2701C4FD938B2EFC3EE0D85BEEE97", hash_generated_field = "EF93B5BCFAF7F06AB9E1923720793677")

        private Class cclass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.109 -0400", hash_original_method = "C5B75212C8FC0ABD1ADCFDBA1ED5609A", hash_generated_method = "223290DA95F5486673BBB0FCF13E174B")
          LockedUpdater(Class<T> tclass, String fieldName) {
            Field field;
            field = null;
            Class caller;
            caller = null;
            int modifiers;
            modifiers = 0;
            try 
            {
                field = tclass.getDeclaredField(fieldName);
                caller = VMStack.getStackClass2();
                modifiers = field.getModifiers();
            } //End block
            catch (Exception ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            Class fieldt;
            fieldt = field.getType();
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be long type");
            {
                boolean var60B416625B50ACEF1DA4DA2F835A2BDA_1158442359 = (!Modifier.isVolatile(modifiers));
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must be volatile type");
            } //End collapsed parenthetic
            this.cclass = (Modifier.isProtected(modifiers) &&
                           caller != tclass) ? caller : null;
            this.tclass = tclass;
            offset = unsafe.objectFieldOffset(field);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.109 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "F15AC7A42810821EC2FE628ADC9D1717")
        private void fullCheck(T obj) {
            {
                boolean var08A757AC16599EE9FA86D0ACCDFB617F_902653198 = (!tclass.isInstance(obj));
                if (DroidSafeAndroidRuntime.control) throw new ClassCastException();
            } //End collapsed parenthetic
            ensureProtectedAccess(obj);
            addTaint(obj.getTaint());
            // ---------- Original Method ----------
            //if (!tclass.isInstance(obj))
                //throw new ClassCastException();
            //if (cclass != null)
                //ensureProtectedAccess(obj);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.116 -0400", hash_original_method = "F28EEE820E0CC0A4DFB94FC74A5AFE78", hash_generated_method = "AB708E2ECBFE821E7B174BE3CD074CD5")
        public boolean compareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1595832285 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            {
                long v;
                v = unsafe.getLong(obj, offset);
                unsafe.putLong(obj, offset, update);
            } //End block
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479586332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479586332;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //synchronized (this) {
                //long v = unsafe.getLong(obj, offset);
                //if (v != expect)
                    //return false;
                //unsafe.putLong(obj, offset, update);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.116 -0400", hash_original_method = "14B3E8CFE4FC936117A23CCF5649E4AE", hash_generated_method = "84D492D7A2076BB88DD025FC57E74AFA")
        public boolean weakCompareAndSet(T obj, long expect, long update) {
            boolean varC09D6F22E92EA7FB90F428B4D65C123E_1620061993 = (compareAndSet(obj, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005868092 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005868092;
            // ---------- Original Method ----------
            //return compareAndSet(obj, expect, update);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.142 -0400", hash_original_method = "669ED1C08689C1E7A362C28D2C445452", hash_generated_method = "1C4ABFA9F64A7EAB85CC5B194547E1B6")
        public void set(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1490401742 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            {
                unsafe.putLong(obj, offset, newValue);
            } //End block
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //synchronized (this) {
                //unsafe.putLong(obj, offset, newValue);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.142 -0400", hash_original_method = "B254126A5A9A310CC60672857EFE3992", hash_generated_method = "B62C496D9EB6825C176445B9581CB8A3")
        public void lazySet(T obj, long newValue) {
            set(obj, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //set(obj, newValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.142 -0400", hash_original_method = "DD3CDDB3808B9B1B599C95B5AE839523", hash_generated_method = "2C5E7A90E5B1F94B8CA291D943EC6FDF")
        public long get(T obj) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1571729080 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            {
                long var7FA8DBAEF21C12A0B494ECC88AF219DF_151471154 = (unsafe.getLong(obj, offset));
            } //End block
            addTaint(obj.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1586620464 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1586620464;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //synchronized (this) {
                //return unsafe.getLong(obj, offset);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.143 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "50E0ED853F3D66824087293439C64A0A")
        private void ensureProtectedAccess(T obj) {
            {
                boolean var76354D080B43280F16DDC78A61CBBC1D_1617674898 = (cclass.isInstance(obj));
            } //End collapsed parenthetic
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
            // ---------- Original Method ----------
            //if (cclass.isInstance(obj)) {
                //return;
            //}
            //throw new RuntimeException(
                //new IllegalAccessException("Class " +
                    //cclass.getName() +
                    //" can not access a protected member of class " +
                    //tclass.getName() +
                    //" using an instance of " +
                    //obj.getClass().getName()
                //)
            //);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.143 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

        private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    }


    
}

