package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.113 -0400", hash_original_method = "2057C70024BF253BE1820FDFE7216E44", hash_generated_method = "CEC0EF1C9C14E821D3D42B954D6BD596")
    private  Debug() {
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static boolean waitingForDebugger() {
        return mWaiting;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDebuggerConnected() {
        return VMDebug.isDebuggerConnected();
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getVmFeatureList() {
        return VMDebug.getVmFeatureList();
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void changeDebugPort(int port) {
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void enableEmulatorTraceOutput() {
        VMDebug.startEmulatorTracing();
    }

    
    @DSModeled(DSC.SAFE)
    public static void startMethodTracing() {
        VMDebug.startMethodTracing(DEFAULT_TRACE_FILE_PATH, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startMethodTracing(String traceName) {
        startMethodTracing(traceName, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startMethodTracing(String traceName, int bufferSize) {
        startMethodTracing(traceName, bufferSize, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startMethodTracing(String traceName, int bufferSize,
        int flags) {
        String pathName = traceName;
        if (pathName.charAt(0) != '/')
            pathName = DEFAULT_TRACE_PATH_PREFIX + pathName;
        if (!pathName.endsWith(DEFAULT_TRACE_EXTENSION))
            pathName = pathName + DEFAULT_TRACE_EXTENSION;
        VMDebug.startMethodTracing(pathName, bufferSize, flags);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startMethodTracing(String traceName, FileDescriptor fd,
        int bufferSize, int flags) {
        VMDebug.startMethodTracing(traceName, fd, bufferSize, flags);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startMethodTracingDdms(int bufferSize, int flags) {
        VMDebug.startMethodTracingDdms(bufferSize, flags);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isMethodTracingActive() {
        return VMDebug.isMethodTracingActive();
    }

    
    @DSModeled(DSC.SAFE)
    public static void stopMethodTracing() {
        VMDebug.stopMethodTracing();
    }

    
    @DSModeled(DSC.SAFE)
    public static long threadCpuTimeNanos() {
        return VMDebug.threadCpuTimeNanos();
    }

    
    @DSModeled(DSC.SAFE)
    public static void startAllocCounting() {
        VMDebug.startAllocCounting();
    }

    
    @DSModeled(DSC.SAFE)
    public static void stopAllocCounting() {
        VMDebug.stopAllocCounting();
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalFreedCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalFreedSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalClassInitCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalClassInitTime() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getGlobalExternalAllocCount() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getGlobalExternalAllocSize() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getGlobalExternalFreedCount() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getGlobalExternalFreedSize() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getGlobalGcInvocationCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getThreadAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getThreadAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getThreadExternalAllocCount() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int getThreadExternalAllocSize() {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getThreadGcInvocationCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalFreedCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalFreedSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalClassInitCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalClassInitTime() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void resetGlobalExternalAllocCount() {
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void resetGlobalExternalAllocSize() {
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void resetGlobalExternalFreedCount() {
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void resetGlobalExternalFreedSize() {
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetGlobalGcInvocationCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetThreadAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetThreadAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void resetThreadExternalAllocCount() {
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void resetThreadExternalAllocSize() {
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetThreadGcInvocationCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetAllCounts() {
        VMDebug.resetAllocCount(VMDebug.KIND_ALL_COUNTS);
    }

    
    @DSModeled(DSC.SAFE)
    public static long getNativeHeapSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getNativeHeapAllocatedSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getNativeHeapFreeSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static void getMemoryInfo(MemoryInfo memoryInfo) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void getMemoryInfo(int pid, MemoryInfo memoryInfo) {
    }

    
    @DSModeled(DSC.SAFE)
    public static long getPss() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long getPss(int pid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int setAllocationLimit(int limit) {
        return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        return -1;
    }

    
    @DSModeled(DSC.SAFE)
    public static void printLoadedClasses(int flags) {
        VMDebug.printLoadedClasses(flags);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getLoadedClassCount() {
        return VMDebug.getLoadedClassCount();
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpHprofData(String fileName) throws IOException {
        VMDebug.dumpHprofData(fileName);
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
        VMDebug.dumpHprofData(fileName, fd);
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpHprofDataDdms() {
        VMDebug.dumpHprofDataDdms();
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpNativeHeap(FileDescriptor fd) {
    }

    
    @DSModeled(DSC.SAFE)
    public static long countInstancesOfClass(Class cls) {
        return VMDebug.countInstancesOfClass(cls, true);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getBinderSentTransactions() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void setFieldsOn(Class<?> cl) {
        setFieldsOn(cl, false);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "98F66450AF89756BF87E5534AF9C2D14", hash_generated_field = "E77238136A622AAF0ED6F3D37CC9FF1B")

        public int dalvikPss;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "D117EB7A88750B2C70A349D466EDF86F", hash_generated_field = "33D4311D6A9BBFAAB58E541DF2012236")

        public int dalvikPrivateDirty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "7C822238FD7387C5F0D3D5DEB4AA81EB", hash_generated_field = "FDF5E4BB072D7AF9419CF36E0FA9A95B")

        public int dalvikSharedDirty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "F8B66B2C470DA886438BC1C88E717188", hash_generated_field = "2194949D909E3886F365A0CE92ABB11F")

        public int nativePss;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "24B0F5F7005C3E0702B1B1A3867EB212", hash_generated_field = "4151FDAF6831E5A1C9C7BB75F9F0334B")

        public int nativePrivateDirty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "D1CB36069DE3437D33ECCFCD3F8B5158", hash_generated_field = "D69D6BF47BFFE8E073898562793D15D0")

        public int nativeSharedDirty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.124 -0400", hash_original_field = "84A56FF37A661935BFA6B1178AF6D789", hash_generated_field = "42B6A257B6E0D4C33EACAEEDCBD9EE83")

        public int otherPss;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.125 -0400", hash_original_field = "36DDF3065ED47973B6FE3282029B788E", hash_generated_field = "1AC34AC5DA50ED2DC11E013FB382AEA4")

        public int otherPrivateDirty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.125 -0400", hash_original_field = "CAD58A3AC1CD7BF569CC56D2DACD1615", hash_generated_field = "C380E10B138C6974D039AFFA2B3E8984")

        public int otherSharedDirty;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.125 -0400", hash_original_field = "13BBA968AF776979CA7FF4A4111A4F4B", hash_generated_field = "A5B0CBFEF61DBB07B6E8C5D2F1ECFDA9")

        private int[] otherStats = new int[NUM_OTHER_STATS*3];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.125 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "FF74B0D10914F28AB3E573FB192E254D")
        public  MemoryInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.125 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "D931D7EDEB60DF8546056BCA530CF0B7")
        private  MemoryInfo(Parcel source) {
            readFromParcel(source);
            addTaint(source.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.126 -0400", hash_original_method = "0F7876D4F39A60F2060DE34A3D4B321B", hash_generated_method = "2A9B4359E63769F5AB7C40C5BD61B797")
        public int getTotalPss() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973116109 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973116109;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.126 -0400", hash_original_method = "5F6AFDC3B733846B095E6E612D37EF25", hash_generated_method = "B116089C543746CDAD3FF2F45D0941C1")
        public int getTotalPrivateDirty() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216688076 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216688076;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.127 -0400", hash_original_method = "DD332BDFA0A32D6562D4D066F36B1807", hash_generated_method = "06D7EA76AA488C9740D24BDF8BD949E4")
        public int getTotalSharedDirty() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662059289 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662059289;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.128 -0400", hash_original_method = "8C545D479EA5CCAA2D5CE5956250CE73", hash_generated_method = "3C0406FDFD081F72CA6ACD2CFC49935F")
        public int getOtherPss(int which) {
            addTaint(which);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828136260 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828136260;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.129 -0400", hash_original_method = "45A31C2AA910C3CDA42EF94E68B5E963", hash_generated_method = "A14282199098D4FE0ACE3976DDA9AE97")
        public int getOtherPrivateDirty(int which) {
            addTaint(which);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005166789 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1005166789;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.129 -0400", hash_original_method = "1FF35BC5D0D80C168B4EDFE5B23B6F0A", hash_generated_method = "77348A605B71BB848DF7B1D4AD95DC58")
        public int getOtherSharedDirty(int which) {
            addTaint(which);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497052032 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497052032;
            
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.130 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6A5D1839CC8F35D3219B61FDF83030B0")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685100035 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685100035;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.130 -0400", hash_original_method = "D2FBA6C4AE93947F6ACE85B65AE77863", hash_generated_method = "58E5F4BC78D246E1A417BA89DDADE908")
        public void writeToParcel(Parcel dest, int flags) {
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
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.130 -0400", hash_original_method = "3814E1A02C58284E12D5ED0E53DE29C9", hash_generated_method = "B59CAD56B8683A7B77C9659536173B0C")
        public void readFromParcel(Parcel source) {
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
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.131 -0400", hash_original_field = "A7D745E9E0F1052F6E18CD9A2B2917F8", hash_generated_field = "BE882405B287754DCA85D85E2C8781E8")

        public static final int NUM_OTHER_STATS = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.131 -0400", hash_original_field = "7B937244499DDD6DE8E8DD078A54CA42", hash_generated_field = "8D5A5BE61EBADDE649E9CD81EA9451BA")

        public static final Creator<MemoryInfo> CREATOR = new Creator<MemoryInfo>() {
            public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
            public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        };
        
        public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
        
        
        public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        
    }


    
    public static class InstructionCount {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.131 -0400", hash_original_field = "E557F1D7AD6097F5E5BDCA59960FF307", hash_generated_field = "49E4B6FD194C81A543C4A6FC8DB4D611")

        private int[] mCounts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.131 -0400", hash_original_method = "409452CAAA99AF062D1B45C0A8D86C97", hash_generated_method = "5D14DE560AC6781B6BEDE1D45CC48926")
        public  InstructionCount() {
            mCounts = new int[NUM_INSTR];
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.132 -0400", hash_original_method = "B55CA2C4A856CEE2241376D780EDBADA", hash_generated_method = "C9E309CCAF7CDC760DBB056275EDCDB8")
        public boolean resetAndStart() {
            try 
            {
                VMDebug.startInstructionCounting();
                VMDebug.resetInstructionCount();
            } 
            catch (UnsupportedOperationException uoe)
            { }
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528418029 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_528418029;
            
            
                
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.132 -0400", hash_original_method = "5FCC8E6F7C9E5A23FBCB0A1615F5BC2D", hash_generated_method = "1A6FC1E14159B5FF21BB2B812BCB5FA4")
        public boolean collect() {
            try 
            {
                VMDebug.stopInstructionCounting();
                VMDebug.getInstructionCount(mCounts);
            } 
            catch (UnsupportedOperationException uoe)
            { }
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787934188 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_787934188;
            
            
                
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.132 -0400", hash_original_method = "51D086FA18F9CD076FA7BBB430E7197D", hash_generated_method = "25A1A882B579067A716EF84F71EED978")
        public int globalTotal() {
            int count = 0;
            {
                int i = 0;
                {
                    count += mCounts[i];
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857030832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1857030832;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_method = "6746067FD45AAE4025CD0901FF5AA3FC", hash_generated_method = "EEC1BD4ADD70D777EFDB223EBF13D45B")
        public int globalMethodInvocations() {
            int count = 0;
            {
                int i = 0;
                {
                    {
                        boolean varFAC684486A37EF13CBC51E3B4F00C0A2_1181691854 = (OpcodeInfo.isInvoke(i));
                        {
                            count += mCounts[i];
                        } 
                    } 
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742044153 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742044153;
            
            
            
                
                    
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "C4113EEC14DE24FCA999D07EA7F5D23D", hash_generated_field = "7A22C579A39E22551B4E74531C1864CF")

        private static final int NUM_INSTR = OpcodeInfo.MAXIMUM_PACKED_VALUE + 1;
    }


    
    @Target({ ElementType.FIELD }) @Retention(RetentionPolicy.RUNTIME) public @interface DebugProperty {
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "9E36A4C8BD9B422B45787FFC15A494EE", hash_generated_field = "389377F3F689781EB2D3F49236B9D2AF")

    private static final String TAG = "Debug";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "4340C9C9DE44B97AB33F05A304C04EFB", hash_generated_field = "10D28A5A9C48BBAA5DC8C2CB09A08B6D")

    public static final int TRACE_COUNT_ALLOCS  = VMDebug.TRACE_COUNT_ALLOCS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "696FDC3AE925D9EB3A110EE74F35D757", hash_generated_field = "E63C1BEA9E5320C4CDD4B43587127B9C")

    public static final int SHOW_FULL_DETAIL    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "A1362AEC18849AC49CC4247F1F4867AE", hash_generated_field = "9415B3064505E8BD5A92127E1C805476")

    public static final int SHOW_CLASSLOADER    = (1 << 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "2F4155F1E93B23E964C53B9305CFCB1A", hash_generated_field = "E4385EA72DE6689F6653D4026B310DF2")

    public static final int SHOW_INITIALIZED    = (1 << 2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "AD47794642B39ECB9B97CC950218E8E2", hash_generated_field = "64A21F9D05164630E7E61CDF96B7B8A7")

    private static volatile boolean mWaiting = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "6C41C63888C6F8E1FF45C21735253BA8", hash_generated_field = "66B43CE3763349D2B54EA8982B2006D9")

    private static final int MIN_DEBUGGER_IDLE = 1300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "8947596A92B354F905D0FD9CA0B55D90", hash_generated_field = "01843DCAA5DD4EB19923FD34C60C5424")

    private static final int SPIN_DELAY = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "4E0C979BEAD545B03C9A256D740DABD5", hash_generated_field = "06907C49898C9C46B0EB6E4FBDDBC5A1")

    private static final String DEFAULT_TRACE_PATH_PREFIX = Environment.getExternalStorageDirectory().getPath() + "/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "4F384F48D31A685D10CD9C73AA452B96", hash_generated_field = "30AB7EECF814DF81F2966E19E130C077")

    private static final String DEFAULT_TRACE_BODY = "dmtrace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "71BE63DD030BB669E5CD222B2A1A338F", hash_generated_field = "ED4CA4EE9F56B6F19C6999554694B9A9")

    private static final String DEFAULT_TRACE_EXTENSION = ".trace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "ACB1E2DA49F7FC5D19642CA21798D3A7", hash_generated_field = "AB39124180A027611E9E95F06D056ADD")

    private static final String DEFAULT_TRACE_FILE_PATH = DEFAULT_TRACE_PATH_PREFIX + DEFAULT_TRACE_BODY
        + DEFAULT_TRACE_EXTENSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "BA40AC77017B679DAD47CCC41D9A135F", hash_generated_field = "C5F5DE18A5A9896FF8DDF8699243F549")

    private static final String SYSFS_QEMU_TRACE_STATE = "/sys/qemu_trace/state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.133 -0400", hash_original_field = "B06FC31B3377E5E92FEEC081DD714041", hash_generated_field = "922B1BD051CFB951F0D00B5AB192FF0F")

    private static TypedProperties debugProperties;
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

