package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.TypedProperties;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import dalvik.bytecode.OpcodeInfo;
import dalvik.bytecode.Opcodes;
import dalvik.system.VMDebug;

public final class Debug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.444 -0400", hash_original_method = "2057C70024BF253BE1820FDFE7216E44", hash_generated_method = "CEC0EF1C9C14E821D3D42B954D6BD596")
    @DSModeled(DSC.SAFE)
    private Debug() {
        // ---------- Original Method ----------
    }

    
        public static void waitForDebugger() {
        if (!VMDebug.isDebuggingEnabled()) {
            return;
        }
        if (isDebuggerConnected())
            return;
        System.out.println("Sending WAIT chunk");
        byte[] data = new byte[] { 0 };
        Chunk waitChunk = new Chunk(ChunkHandler.type("WAIT"), data, 0, 1);
        DdmServer.sendChunk(waitChunk);
        mWaiting = true;
        while (!isDebuggerConnected()) {
            try { Thread.sleep(SPIN_DELAY); }
            catch (InterruptedException ie) {}
        }
        mWaiting = false;
        System.out.println("Debugger has connected");
        while (true) {
            long delta = VMDebug.lastDebuggerActivity();
            if (delta < 0) {
                System.out.println("debugger detached?");
                break;
            }
            if (delta < MIN_DEBUGGER_IDLE) {
                System.out.println("waiting for debugger to settle...");
                try { Thread.sleep(SPIN_DELAY); }
                catch (InterruptedException ie) {}
            } else {
                System.out.println("debugger has settled (" + delta + ")");
                break;
            }
        }
    }

    
        public static boolean waitingForDebugger() {
        return mWaiting;
    }

    
        public static boolean isDebuggerConnected() {
        return VMDebug.isDebuggerConnected();
    }

    
        public static String[] getVmFeatureList() {
        return VMDebug.getVmFeatureList();
    }

    
        @Deprecated
    public static void changeDebugPort(int port) {
    }

    
        public static void startNativeTracing() {
        PrintWriter outStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(SYSFS_QEMU_TRACE_STATE);
            outStream = new PrintWriter(new OutputStreamWriter(fos));
            outStream.println("1");
        } catch (Exception e) {
        } finally {
            if (outStream != null)
                outStream.close();
        }
        VMDebug.startEmulatorTracing();
    }

    
        public static void stopNativeTracing() {
        VMDebug.stopEmulatorTracing();
        PrintWriter outStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(SYSFS_QEMU_TRACE_STATE);
            outStream = new PrintWriter(new OutputStreamWriter(fos));
            outStream.println("0");
        } catch (Exception e) {
        } finally {
            if (outStream != null)
                outStream.close();
        }
    }

    
        public static void enableEmulatorTraceOutput() {
        VMDebug.startEmulatorTracing();
    }

    
        public static void startMethodTracing() {
        VMDebug.startMethodTracing(DEFAULT_TRACE_FILE_PATH, 0, 0);
    }

    
        public static void startMethodTracing(String traceName) {
        startMethodTracing(traceName, 0, 0);
    }

    
        public static void startMethodTracing(String traceName, int bufferSize) {
        startMethodTracing(traceName, bufferSize, 0);
    }

    
        public static void startMethodTracing(String traceName, int bufferSize,
        int flags) {
        String pathName = traceName;
        if (pathName.charAt(0) != '/')
            pathName = DEFAULT_TRACE_PATH_PREFIX + pathName;
        if (!pathName.endsWith(DEFAULT_TRACE_EXTENSION))
            pathName = pathName + DEFAULT_TRACE_EXTENSION;
        VMDebug.startMethodTracing(pathName, bufferSize, flags);
    }

    
        public static void startMethodTracing(String traceName, FileDescriptor fd,
        int bufferSize, int flags) {
        VMDebug.startMethodTracing(traceName, fd, bufferSize, flags);
    }

    
        public static void startMethodTracingDdms(int bufferSize, int flags) {
        VMDebug.startMethodTracingDdms(bufferSize, flags);
    }

    
        public static boolean isMethodTracingActive() {
        return VMDebug.isMethodTracingActive();
    }

    
        public static void stopMethodTracing() {
        VMDebug.stopMethodTracing();
    }

    
        public static long threadCpuTimeNanos() {
        return VMDebug.threadCpuTimeNanos();
    }

    
        public static void startAllocCounting() {
        VMDebug.startAllocCounting();
    }

    
        public static void stopAllocCounting() {
        VMDebug.stopAllocCounting();
    }

    
        public static int getGlobalAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }

    
        public static int getGlobalAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }

    
        public static int getGlobalFreedCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }

    
        public static int getGlobalFreedSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }

    
        public static int getGlobalClassInitCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }

    
        public static int getGlobalClassInitTime() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    
        @Deprecated
    public static int getGlobalExternalAllocCount() {
        return 0;
    }

    
        @Deprecated
    public static int getGlobalExternalAllocSize() {
        return 0;
    }

    
        @Deprecated
    public static int getGlobalExternalFreedCount() {
        return 0;
    }

    
        @Deprecated
    public static int getGlobalExternalFreedSize() {
        return 0;
    }

    
        public static int getGlobalGcInvocationCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }

    
        public static int getThreadAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }

    
        public static int getThreadAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    
        @Deprecated
    public static int getThreadExternalAllocCount() {
        return 0;
    }

    
        @Deprecated
    public static int getThreadExternalAllocSize() {
        return 0;
    }

    
        public static int getThreadGcInvocationCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    
        public static void resetGlobalAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }

    
        public static void resetGlobalAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }

    
        public static void resetGlobalFreedCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }

    
        public static void resetGlobalFreedSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }

    
        public static void resetGlobalClassInitCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }

    
        public static void resetGlobalClassInitTime() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    
        @Deprecated
    public static void resetGlobalExternalAllocCount() {
    }

    
        @Deprecated
    public static void resetGlobalExternalAllocSize() {
    }

    
        @Deprecated
    public static void resetGlobalExternalFreedCount() {
    }

    
        @Deprecated
    public static void resetGlobalExternalFreedSize() {
    }

    
        public static void resetGlobalGcInvocationCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }

    
        public static void resetThreadAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }

    
        public static void resetThreadAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    
        @Deprecated
    public static void resetThreadExternalAllocCount() {
    }

    
        @Deprecated
    public static void resetThreadExternalAllocSize() {
    }

    
        public static void resetThreadGcInvocationCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    
        public static void resetAllCounts() {
        VMDebug.resetAllocCount(VMDebug.KIND_ALL_COUNTS);
    }

    
        public static long getNativeHeapSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getNativeHeapAllocatedSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getNativeHeapFreeSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static void getMemoryInfo(MemoryInfo memoryInfo) {
    }

    
        public static void getMemoryInfo(int pid, MemoryInfo memoryInfo) {
    }

    
        public static long getPss() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getPss(int pid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        @Deprecated
    public static int setAllocationLimit(int limit) {
        return -1;
    }

    
        @Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        return -1;
    }

    
        public static void printLoadedClasses(int flags) {
        VMDebug.printLoadedClasses(flags);
    }

    
        public static int getLoadedClassCount() {
        return VMDebug.getLoadedClassCount();
    }

    
        public static void dumpHprofData(String fileName) throws IOException {
        VMDebug.dumpHprofData(fileName);
    }

    
        public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
        VMDebug.dumpHprofData(fileName, fd);
    }

    
        public static void dumpHprofDataDdms() {
        VMDebug.dumpHprofDataDdms();
    }

    
        public static void dumpNativeHeap(FileDescriptor fd) {
    }

    
        public static long countInstancesOfClass(Class cls) {
        return VMDebug.countInstancesOfClass(cls, true);
    }

    
        public static int getBinderSentTransactions() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getBinderReceivedTransactions() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getBinderLocalObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getBinderProxyObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getBinderDeathObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final boolean cacheRegisterMap(String classAndMethodDesc) {
        return VMDebug.cacheRegisterMap(classAndMethodDesc);
    }

    
        public static final void dumpReferenceTables() {
        VMDebug.dumpReferenceTables();
    }

    
        private static boolean fieldTypeMatches(Field field, Class<?> cl) {
        Class<?> fieldClass = field.getType();
        if (fieldClass == cl) {
            return true;
        }
        Field primitiveTypeField;
        try {
            primitiveTypeField = cl.getField("TYPE");
        } catch (NoSuchFieldException ex) {
            return false;
        }
        try {
            return fieldClass == (Class<?>) primitiveTypeField.get(null);
        } catch (IllegalAccessException ex) {
            return false;
        }
    }

    
        private static void modifyFieldIfSet(final Field field, final TypedProperties properties,
                                         final String propertyName) {
        if (field.getType() == java.lang.String.class) {
            int stringInfo = properties.getStringInfo(propertyName);
            switch (stringInfo) {
                case TypedProperties.STRING_SET:
                    break;
                case TypedProperties.STRING_NULL:
                    try {
                        field.set(null, null);  
                    } catch (IllegalAccessException ex) {
                        throw new IllegalArgumentException(
                            "Cannot set field for " + propertyName, ex);
                    }
                    return;
                case TypedProperties.STRING_NOT_SET:
                    return;
                case TypedProperties.STRING_TYPE_MISMATCH:
                    throw new IllegalArgumentException(
                        "Type of " + propertyName + " " +
                        " does not match field type (" + field.getType() + ")");
                default:
                    throw new IllegalStateException(
                        "Unexpected getStringInfo(" + propertyName + ") return value " +
                        stringInfo);
            }
        }
        Object value = properties.get(propertyName);
        if (value != null) {
            if (!fieldTypeMatches(field, value.getClass())) {
                throw new IllegalArgumentException(
                    "Type of " + propertyName + " (" + value.getClass() + ") " +
                    " does not match field type (" + field.getType() + ")");
            }
            try {
                field.set(null, value);  
            } catch (IllegalAccessException ex) {
                throw new IllegalArgumentException(
                    "Cannot set field for " + propertyName, ex);
            }
        }
    }

    
        public static void setFieldsOn(Class<?> cl) {
        setFieldsOn(cl, false);
    }

    
        public static void setFieldsOn(Class<?> cl, boolean partial) {
        if (false) {
            if (debugProperties != null) {
                for (Field field : cl.getDeclaredFields()) {
                    if (!partial || field.getAnnotation(DebugProperty.class) != null) {
                        final String propertyName = cl.getName() + "." + field.getName();
                        boolean isStatic = Modifier.isStatic(field.getModifiers());
                        boolean isFinal = Modifier.isFinal(field.getModifiers());
                        if (!isStatic || isFinal) {
                            throw new IllegalArgumentException(propertyName +
                                " must be static and non-final");
                        }
                        modifyFieldIfSet(field, debugProperties, propertyName);
                    }
                }
            }
        } else {
            Log.wtf(TAG,
                  "setFieldsOn(" + (cl == null ? "null" : cl.getName()) +
                  ") called in non-DEBUG build");
        }
    }

    
        public static boolean dumpService(String name, FileDescriptor fd, String[] args) {
        IBinder service = ServiceManager.getService(name);
        if (service == null) {
            Log.e(TAG, "Can't find service to dump: " + name);
            return false;
        }
        try {
            service.dump(fd, args);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Can't dump service: " + name, e);
            return false;
        }
    }

    
    public static class MemoryInfo implements Parcelable {
        public int dalvikPss;
        public int dalvikPrivateDirty;
        public int dalvikSharedDirty;
        public int nativePss;
        public int nativePrivateDirty;
        public int nativeSharedDirty;
        public int otherPss;
        public int otherPrivateDirty;
        public int otherSharedDirty;
        private int[] otherStats = new int[NUM_OTHER_STATS*3];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.463 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "FF74B0D10914F28AB3E573FB192E254D")
        @DSModeled(DSC.SAFE)
        public MemoryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.463 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "59177374CF85231EEAEF1DAD1A5EE39A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private MemoryInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.463 -0400", hash_original_method = "0F7876D4F39A60F2060DE34A3D4B321B", hash_generated_method = "1F4B518D3772C36AC9DD248A113E2D1F")
        @DSModeled(DSC.SAFE)
        public int getTotalPss() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return dalvikPss + nativePss + otherPss;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.463 -0400", hash_original_method = "5F6AFDC3B733846B095E6E612D37EF25", hash_generated_method = "D73D5B27A6FC183A625883F2A7480250")
        @DSModeled(DSC.SAFE)
        public int getTotalPrivateDirty() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return dalvikPrivateDirty + nativePrivateDirty + otherPrivateDirty;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.463 -0400", hash_original_method = "DD332BDFA0A32D6562D4D066F36B1807", hash_generated_method = "F57F1F886C2DB6447225B5BF2595EE7E")
        @DSModeled(DSC.SAFE)
        public int getTotalSharedDirty() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return dalvikSharedDirty + nativeSharedDirty + otherSharedDirty;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.464 -0400", hash_original_method = "8C545D479EA5CCAA2D5CE5956250CE73", hash_generated_method = "3621A71A77E7159BD837E8DA754E037B")
        @DSModeled(DSC.SAFE)
        public int getOtherPss(int which) {
            dsTaint.addTaint(which);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return otherStats[which*3];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.464 -0400", hash_original_method = "45A31C2AA910C3CDA42EF94E68B5E963", hash_generated_method = "E1402F8479960E51AFFB72E4B787D2DC")
        @DSModeled(DSC.SAFE)
        public int getOtherPrivateDirty(int which) {
            dsTaint.addTaint(which);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return otherStats[which*3 + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.464 -0400", hash_original_method = "1FF35BC5D0D80C168B4EDFE5B23B6F0A", hash_generated_method = "E646AFB60460A1179F4E18CA7943F213")
        @DSModeled(DSC.SAFE)
        public int getOtherSharedDirty(int which) {
            dsTaint.addTaint(which);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return otherStats[which*3 + 2];
        }

        
                public static String getOtherLabel(int which) {
            switch (which) {
                case 0: return "Cursor";
                case 1: return "Ashmem";
                case 2: return "Other dev";
                case 3: return ".so mmap";
                case 4: return ".jar mmap";
                case 5: return ".apk mmap";
                case 6: return ".ttf mmap";
                case 7: return ".dex mmap";
                case 8: return "Other mmap";
                default: return "????";
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.465 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.465 -0400", hash_original_method = "D2FBA6C4AE93947F6ACE85B65AE77863", hash_generated_method = "ECBDD76680AF6BEEF43934BFD5EE8383")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(dalvikPss);
            dest.writeInt(dalvikPrivateDirty);
            dest.writeInt(dalvikSharedDirty);
            dest.writeInt(nativePss);
            dest.writeInt(nativePrivateDirty);
            dest.writeInt(nativeSharedDirty);
            dest.writeInt(otherPss);
            dest.writeInt(otherPrivateDirty);
            dest.writeInt(otherSharedDirty);
            dest.writeIntArray(otherStats);
            // ---------- Original Method ----------
            //dest.writeInt(dalvikPss);
            //dest.writeInt(dalvikPrivateDirty);
            //dest.writeInt(dalvikSharedDirty);
            //dest.writeInt(nativePss);
            //dest.writeInt(nativePrivateDirty);
            //dest.writeInt(nativeSharedDirty);
            //dest.writeInt(otherPss);
            //dest.writeInt(otherPrivateDirty);
            //dest.writeInt(otherSharedDirty);
            //dest.writeIntArray(otherStats);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.465 -0400", hash_original_method = "3814E1A02C58284E12D5ED0E53DE29C9", hash_generated_method = "0787B375CF15858AB71C4AB2EE3F79DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            dalvikPss = source.readInt();
            dalvikPrivateDirty = source.readInt();
            dalvikSharedDirty = source.readInt();
            nativePss = source.readInt();
            nativePrivateDirty = source.readInt();
            nativeSharedDirty = source.readInt();
            otherPss = source.readInt();
            otherPrivateDirty = source.readInt();
            otherSharedDirty = source.readInt();
            otherStats = source.createIntArray();
            // ---------- Original Method ----------
            //dalvikPss = source.readInt();
            //dalvikPrivateDirty = source.readInt();
            //dalvikSharedDirty = source.readInt();
            //nativePss = source.readInt();
            //nativePrivateDirty = source.readInt();
            //nativeSharedDirty = source.readInt();
            //otherPss = source.readInt();
            //otherPrivateDirty = source.readInt();
            //otherSharedDirty = source.readInt();
            //otherStats = source.createIntArray();
        }

        
        public static final int NUM_OTHER_STATS = 9;
        public static final Creator<MemoryInfo> CREATOR = new Creator<MemoryInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.466 -0400", hash_original_method = "83921F47BB880779DC0FD4AB57F3B1E1", hash_generated_method = "1345FCBDDCBB0A7D1769B75713B03715")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public MemoryInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                MemoryInfo varB2BE3C5741554A81AA92EC3CD868A516_2100688194 = (new MemoryInfo(source));
                return (MemoryInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.466 -0400", hash_original_method = "15F51E1DA13C1BB1AA9F8A3C297A7987", hash_generated_method = "CF39F54C5F11392D847F43DD77899F63")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public MemoryInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                MemoryInfo[] var83C4D7A2FE00961CCE7E750BDC9FCD35_784190365 = (new MemoryInfo[size]);
                return (MemoryInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo[size];
            }

            
}; //Transformed anonymous class
    }


    
    public static class InstructionCount {
        private int[] mCounts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.466 -0400", hash_original_method = "409452CAAA99AF062D1B45C0A8D86C97", hash_generated_method = "5D14DE560AC6781B6BEDE1D45CC48926")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstructionCount() {
            mCounts = new int[NUM_INSTR];
            // ---------- Original Method ----------
            //mCounts = new int[NUM_INSTR];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.467 -0400", hash_original_method = "B55CA2C4A856CEE2241376D780EDBADA", hash_generated_method = "4ED45F91516F247CC88667E979ADB67F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean resetAndStart() {
            try 
            {
                VMDebug.startInstructionCounting();
                VMDebug.resetInstructionCount();
            } //End block
            catch (UnsupportedOperationException uoe)
            { }
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
                //VMDebug.startInstructionCounting();
                //VMDebug.resetInstructionCount();
            //} catch (UnsupportedOperationException uoe) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.467 -0400", hash_original_method = "5FCC8E6F7C9E5A23FBCB0A1615F5BC2D", hash_generated_method = "EC8399B3EAA010C6998B6E601A2F0E54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean collect() {
            try 
            {
                VMDebug.stopInstructionCounting();
                VMDebug.getInstructionCount(mCounts);
            } //End block
            catch (UnsupportedOperationException uoe)
            { }
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
                //VMDebug.stopInstructionCounting();
                //VMDebug.getInstructionCount(mCounts);
            //} catch (UnsupportedOperationException uoe) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.467 -0400", hash_original_method = "51D086FA18F9CD076FA7BBB430E7197D", hash_generated_method = "E6F39993B47D203654E25D8B75930FD9")
        @DSModeled(DSC.SAFE)
        public int globalTotal() {
            int count;
            count = 0;
            {
                int i;
                i = 0;
                {
                    count += mCounts[i];
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int count = 0;
            //for (int i = 0; i < NUM_INSTR; i++) {
                //count += mCounts[i];
            //}
            //return count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.468 -0400", hash_original_method = "6746067FD45AAE4025CD0901FF5AA3FC", hash_generated_method = "F0AA47A84A3F92EFE8AB737BD7B3DD14")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int globalMethodInvocations() {
            int count;
            count = 0;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varFAC684486A37EF13CBC51E3B4F00C0A2_2125115079 = (OpcodeInfo.isInvoke(i));
                        {
                            count += mCounts[i];
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int count = 0;
            //for (int i = 0; i < NUM_INSTR; i++) {
                //if (OpcodeInfo.isInvoke(i)) {
                    //count += mCounts[i];
                //}
            //}
            //return count;
        }

        
        private static final int NUM_INSTR =
            OpcodeInfo.MAXIMUM_PACKED_VALUE + 1;
    }


    
    @Target({ ElementType.FIELD }) @Retention(RetentionPolicy.RUNTIME) public @interface DebugProperty {
    }
    
    private static final String TAG = "Debug";
    public static final int TRACE_COUNT_ALLOCS  = VMDebug.TRACE_COUNT_ALLOCS;
    public static final int SHOW_FULL_DETAIL    = 1;
    public static final int SHOW_CLASSLOADER    = (1 << 1);
    public static final int SHOW_INITIALIZED    = (1 << 2);
    private static volatile boolean mWaiting = false;
    private static final int MIN_DEBUGGER_IDLE = 1300;
    private static final int SPIN_DELAY = 200;
    private static final String DEFAULT_TRACE_PATH_PREFIX =
        Environment.getExternalStorageDirectory().getPath() + "/";
    private static final String DEFAULT_TRACE_BODY = "dmtrace";
    private static final String DEFAULT_TRACE_EXTENSION = ".trace";
    private static final String DEFAULT_TRACE_FILE_PATH =
        DEFAULT_TRACE_PATH_PREFIX + DEFAULT_TRACE_BODY
        + DEFAULT_TRACE_EXTENSION;
    private static final String SYSFS_QEMU_TRACE_STATE = "/sys/qemu_trace/state";
    private static final TypedProperties debugProperties;
    static {
        if (false) {
            final String TAG = "DebugProperties";
            final String[] files = { "/system/debug.prop", "/debug.prop", "/data/debug.prop" };
            final TypedProperties tp = new TypedProperties();
            for (String file : files) {
                Reader r;
                try {
                    r = new FileReader(file);
                } catch (FileNotFoundException ex) {
                    continue;
                }
                try {
                    tp.load(r);
                } catch (Exception ex) {
                    throw new RuntimeException("Problem loading " + file, ex);
                } finally {
                    try {
                        r.close();
                    } catch (IOException ex) {
                    }
                }
            }
            debugProperties = tp.isEmpty() ? null : tp;
        } else {
            debugProperties = null;
        }
    }
    
}

