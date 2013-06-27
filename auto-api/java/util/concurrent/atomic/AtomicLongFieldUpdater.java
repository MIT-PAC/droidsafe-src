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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.180 -0400", hash_original_method = "BA7F0F8CC0F2CFF6E035F4AABDB58BFC", hash_generated_method = "62F6218EF261DD24445A14F0CE964A46")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.182 -0400", hash_original_method = "073A4CF50E22F9EE4C4340BA9014F29C", hash_generated_method = "E6180CB5F253BD8F0D01B5325B5268FB")
    public long getAndSet(T obj, long newValue) {
        {
            long current;
            current = get(obj);
            {
                boolean varEF6F11C12EB2BCFEFD370C9B71CA9D76_911065374 = (compareAndSet(obj, current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1393978980 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1393978980;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //if (compareAndSet(obj, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.182 -0400", hash_original_method = "FFCFE702F404925FF472694110925E69", hash_generated_method = "F11F9A7B2590E7D64CF0CB139128FD8D")
    public long getAndIncrement(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1118980645 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_810529708 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_810529708;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + 1;
            //if (compareAndSet(obj, current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.183 -0400", hash_original_method = "9CAF92F1F2494CDDDA53F7B31DDB70AC", hash_generated_method = "38A31F43DC8331977587D5FAD25206A0")
    public long getAndDecrement(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current - 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1579919684 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1842545389 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1842545389;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current - 1;
            //if (compareAndSet(obj, current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.184 -0400", hash_original_method = "3764C955A48CF6808C45F475DCFC56BA", hash_generated_method = "64DB79B37A0FCD8D439F7D239BED13B0")
    public long getAndAdd(T obj, long delta) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + delta;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_768099664 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1067415814 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1067415814;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + delta;
            //if (compareAndSet(obj, current, next))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.197 -0400", hash_original_method = "1591AE6B0EAC64083036B0657AF8C8E8", hash_generated_method = "A3C1509DDBD5ACB57B25CC33864143F4")
    public long incrementAndGet(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_318419155 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_647731351 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_647731351;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + 1;
            //if (compareAndSet(obj, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.197 -0400", hash_original_method = "F278D43CE5D7C7A4E3E54A0A47080CD8", hash_generated_method = "899B4E0C3595117562D49E6A2999347B")
    public long decrementAndGet(T obj) {
        {
            long current;
            current = get(obj);
            long next;
            next = current - 1;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1056335860 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1494709409 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1494709409;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current - 1;
            //if (compareAndSet(obj, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.198 -0400", hash_original_method = "7BA11FC3A8E7EFFF8D5EBE339E5290E0", hash_generated_method = "813DC311585D5DBB23759A5F25F39E20")
    public long addAndGet(T obj, long delta) {
        {
            long current;
            current = get(obj);
            long next;
            next = current + delta;
            {
                boolean var39F790C2B1085E7CF87DB5C3D24D0ADD_1900966930 = (compareAndSet(obj, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(obj.getTaint());
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_930828851 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_930828851;
        // ---------- Original Method ----------
        //for (;;) {
            //long current = get(obj);
            //long next = current + delta;
            //if (compareAndSet(obj, current, next))
                //return next;
        //}
    }

    
    private static class CASUpdater<T> extends AtomicLongFieldUpdater<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.198 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private long offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.198 -0400", hash_original_field = "53171F971C64AB072B4CC14815B91ED9", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private Class<T> tclass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.198 -0400", hash_original_field = "DFC2701C4FD938B2EFC3EE0D85BEEE97", hash_generated_field = "EF93B5BCFAF7F06AB9E1923720793677")

        private Class cclass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.213 -0400", hash_original_method = "3C60415DB6C3E1541F6CE2F79F2229C7", hash_generated_method = "CA4E91AD51F4B87FB11A61BCD951C3E0")
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
                boolean var60B416625B50ACEF1DA4DA2F835A2BDA_703664881 = (!Modifier.isVolatile(modifiers));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.214 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "BBD26F695F6D10C49CD26791B0B4951A")
        private void fullCheck(T obj) {
            {
                boolean var08A757AC16599EE9FA86D0ACCDFB617F_2091000573 = (!tclass.isInstance(obj));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.215 -0400", hash_original_method = "0B1B8A08B80DC3AD108753B0AFE3A4E8", hash_generated_method = "75A12E872176C44C21922852A5FDAE12")
        public boolean compareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1157975401 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            boolean var4D1224EBF8FF0DF75D7E6D4DE35B1DC6_1569353285 = (unsafe.compareAndSwapLong(obj, offset, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685847108 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_685847108;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //return unsafe.compareAndSwapLong(obj, offset, expect, update);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.216 -0400", hash_original_method = "FA5ECB357D30254C8585479D53202326", hash_generated_method = "D92A98AE71755A708F9617385BFCF251")
        public boolean weakCompareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1589725258 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            boolean var4D1224EBF8FF0DF75D7E6D4DE35B1DC6_1297953732 = (unsafe.compareAndSwapLong(obj, offset, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975449626 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975449626;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //return unsafe.compareAndSwapLong(obj, offset, expect, update);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.217 -0400", hash_original_method = "71897CED5F2740E2249B4A6609AE4D6E", hash_generated_method = "41856C4375F592B2750972AD5C515DF7")
        public void set(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_931609699 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            unsafe.putLongVolatile(obj, offset, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //unsafe.putLongVolatile(obj, offset, newValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.221 -0400", hash_original_method = "51078ADC8C79D48D4C02CCADFB4A4445", hash_generated_method = "B932B3A7928070BBE817CC0BF47A3B6E")
        public void lazySet(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1177872607 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            unsafe.putOrderedLong(obj, offset, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //unsafe.putOrderedLong(obj, offset, newValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.238 -0400", hash_original_method = "DD571ADDCD61186BA82D3AD7916B61C6", hash_generated_method = "9B19DFCC322CA42DCE45E6361AF13097")
        public long get(T obj) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_39324329 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            long var6976292DBE2A2878DD246D6DAC256FC7_638592481 = (unsafe.getLongVolatile(obj, offset));
            addTaint(obj.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_435426000 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_435426000;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //return unsafe.getLongVolatile(obj, offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.239 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "C32211D32E24E08FA9259E950D007902")
        private void ensureProtectedAccess(T obj) {
            {
                boolean var76354D080B43280F16DDC78A61CBBC1D_511754876 = (cclass.isInstance(obj));
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.240 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

        private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    }


    
    private static class LockedUpdater<T> extends AtomicLongFieldUpdater<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.240 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "72D7DAA3F4E10A36C8D7D11B414E5D04")

        private long offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.240 -0400", hash_original_field = "53171F971C64AB072B4CC14815B91ED9", hash_generated_field = "0450F005DE31D500992E091D0E59F118")

        private Class<T> tclass;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.240 -0400", hash_original_field = "DFC2701C4FD938B2EFC3EE0D85BEEE97", hash_generated_field = "EF93B5BCFAF7F06AB9E1923720793677")

        private Class cclass;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.242 -0400", hash_original_method = "C5B75212C8FC0ABD1ADCFDBA1ED5609A", hash_generated_method = "E8ADD7A86C3DD29E8318BBB2ABC13F02")
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
                boolean var60B416625B50ACEF1DA4DA2F835A2BDA_1621426936 = (!Modifier.isVolatile(modifiers));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.242 -0400", hash_original_method = "0DF68968C49F6A8B54F04E52C7A3B928", hash_generated_method = "F8BB577466871B0D9B65819BDD8322EC")
        private void fullCheck(T obj) {
            {
                boolean var08A757AC16599EE9FA86D0ACCDFB617F_479505670 = (!tclass.isInstance(obj));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.258 -0400", hash_original_method = "F28EEE820E0CC0A4DFB94FC74A5AFE78", hash_generated_method = "84F5023C4127CF214438ECCF977AD0FE")
        public boolean compareAndSet(T obj, long expect, long update) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_1976738667 = (obj == null || obj.getClass() != tclass || cclass != null);
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972513222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972513222;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.259 -0400", hash_original_method = "14B3E8CFE4FC936117A23CCF5649E4AE", hash_generated_method = "31B15FCBAD51B42124ADC26A24789606")
        public boolean weakCompareAndSet(T obj, long expect, long update) {
            boolean varC09D6F22E92EA7FB90F428B4D65C123E_2123163290 = (compareAndSet(obj, expect, update));
            addTaint(obj.getTaint());
            addTaint(expect);
            addTaint(update);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104622868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104622868;
            // ---------- Original Method ----------
            //return compareAndSet(obj, expect, update);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.260 -0400", hash_original_method = "669ED1C08689C1E7A362C28D2C445452", hash_generated_method = "2F28A1B7FE219932CCBDF248C15F727C")
        public void set(T obj, long newValue) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_250362367 = (obj == null || obj.getClass() != tclass || cclass != null);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.260 -0400", hash_original_method = "B254126A5A9A310CC60672857EFE3992", hash_generated_method = "B62C496D9EB6825C176445B9581CB8A3")
        public void lazySet(T obj, long newValue) {
            set(obj, newValue);
            addTaint(obj.getTaint());
            addTaint(newValue);
            // ---------- Original Method ----------
            //set(obj, newValue);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.261 -0400", hash_original_method = "DD3CDDB3808B9B1B599C95B5AE839523", hash_generated_method = "B6BC28D6469895798373D9B5484B33EB")
        public long get(T obj) {
            {
                boolean varF632C662F50CD55BC2A79D282BA126B0_195073142 = (obj == null || obj.getClass() != tclass || cclass != null);
                fullCheck(obj);
            } //End collapsed parenthetic
            {
                long var7FA8DBAEF21C12A0B494ECC88AF219DF_1806828716 = (unsafe.getLong(obj, offset));
            } //End block
            addTaint(obj.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_944097253 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_944097253;
            // ---------- Original Method ----------
            //if (obj == null || obj.getClass() != tclass || cclass != null) fullCheck(obj);
            //synchronized (this) {
                //return unsafe.getLong(obj, offset);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.281 -0400", hash_original_method = "9D11BBB4695C9E411934FC937C6FB3CE", hash_generated_method = "BC1ED69ECF2F4C9273AE3C91443CFD9B")
        private void ensureProtectedAccess(T obj) {
            {
                boolean var76354D080B43280F16DDC78A61CBBC1D_1722854698 = (cclass.isInstance(obj));
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.282 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

        private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    }


    
}

