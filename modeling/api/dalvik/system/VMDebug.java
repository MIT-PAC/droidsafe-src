/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;

import droidsafe.helpers.DSUtils;

public final class VMDebug {
    
    public static long lastDebuggerActivity() {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1326805405 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1326805405;
    }
    
    public static boolean isDebuggingEnabled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936903779 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936903779;
    }
    
    public static boolean isDebuggerConnected() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362108739 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362108739;
    }
    
    public static String[] getVmFeatureList() {
    	String[] ret = new String[0];
    	return ret;
    }

    /**
     * Start method tracing with default name, size, and with <code>0</code>
     * flags.
     *
     * @deprecated not used, not needed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.676 -0500", hash_original_method = "840870BB0412797A5F6A599B61D1A09E", hash_generated_method = "392B5DDB1E404545881718EFE88BA53A")
    
@Deprecated
    public static void startMethodTracing() {
        //startMethodTracing(DEFAULT_METHOD_TRACE_FILE_NAME, 0, 0);
    }

    /**
     * Start method tracing, specifying a file name as well as a default
     * buffer size. See <a
     * href="{@docRoot}guide/developing/tools/traceview.html"> Running the
     * Traceview Debugging Program</a> for information about reading
     * trace files.
     *
     * <p>You can use either a fully qualified path and
     * name, or just a name. If only a name is specified, the file will
     * be created under the /sdcard/ directory. If a name is not given,
     * the default is /sdcard/dmtrace.trace.</p>
     *
     * @param traceFileName name to give the trace file
     * @param bufferSize the maximum size of both files combined. If passed
     * as <code>0</code>, it defaults to 8MB.
     * @param flags flags to control method tracing. The only one that
     * is currently defined is {@link #TRACE_COUNT_ALLOCS}.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.679 -0500", hash_original_method = "FCB90ED5C4F694A91B5F73A6370D7475", hash_generated_method = "D9E3D381FDB97F35571E3CB3F0A7D758")
    
public static void startMethodTracing(String traceFileName,
        int bufferSize, int flags) {

        if (traceFileName == null) {
            throw new NullPointerException();
        }

        startMethodTracingNative(traceFileName, null, bufferSize, flags);
    }

    /**
     * Like startMethodTracing(String, int, int), but taking an already-opened
     * FileDescriptor in which the trace is written.  The file name is also
     * supplied simply for logging.  Makes a dup of the file descriptor.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.681 -0500", hash_original_method = "97B591DF3562D946C70A1ECBD633B498", hash_generated_method = "D7F2004FFCF007261665F99CF411A189")
    
public static void startMethodTracing(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags)
    {
        if (traceFileName == null || fd == null) {
            throw new NullPointerException();
        }

        startMethodTracingNative(traceFileName, fd, bufferSize, flags);
    }

    /**
     * Starts method tracing without a backing file.  When stopMethodTracing
     * is called, the result is sent directly to DDMS.  (If DDMS is not
     * attached when tracing ends, the profiling data will be discarded.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.684 -0500", hash_original_method = "5F549E6AF9CCE63195F783E8262D413B", hash_generated_method = "E2A829C575CE61DD8A74E19EBF149E4F")
    
public static void startMethodTracingDdms(int bufferSize, int flags) {
        startMethodTracingNative(null, null, bufferSize, flags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void startMethodTracingNative(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
    }
    
    public static boolean isMethodTracingActive() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236083031 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236083031;
    }
    
    public static void stopMethodTracing() {
    }
    
    public static void startEmulatorTracing() {
    }
    
    public static void stopEmulatorTracing() {
    }
    
    public static long threadCpuTimeNanos() {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1349091814 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1349091814;
    }
    
    public static void startAllocCounting() {
    }
    
    public static void stopAllocCounting() {
    }
    
    public static int getAllocCount(int kind) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006668567 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006668567;
    }
    
    public static void resetAllocCount(int kinds) {
    }

    /**
     * This method exists for binary compatibility.  It was part of
     * the allocation limits API which was removed in Honeycomb.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.727 -0500", hash_original_method = "F2D92EF76A0504EC51F795A2E7A55E9D", hash_generated_method = "F063C387E4EDD819F25EEF1A67F4ADDA")
    
@Deprecated
    public static int setAllocationLimit(int limit) {
        return -1;
    }

    /**
     * This method exists for binary compatibility.  It was part of
     * the allocation limits API which was removed in Honeycomb.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.729 -0500", hash_original_method = "85E92A7E48E83667B7FCFEA41481A251", hash_generated_method = "F4543BDF3A8B7BCDADE595D4009E334A")
    
@Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        return -1;
    }
    
    public static void startInstructionCounting() {
    }
    
    public static void stopInstructionCounting() {
    }
    
    public static void getInstructionCount(int[] counts) {
    }
    
    public static void resetInstructionCount() {
    }
    
    public static void printLoadedClasses(int flags) {
    }
    
    public static int getLoadedClassCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368515312 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368515312;
    }

    /**
     * Dumps "hprof" data to the specified file.  This may cause a GC.
     *
     * The VM may create a temporary file in the same directory.
     *
     * @param fileName Full pathname of output file (e.g. "/sdcard/dump.hprof").
     * @throws UnsupportedOperationException if the VM was built without
     *         HPROF support.
     * @throws IOException if an error occurs while opening or writing files.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.757 -0500", hash_original_method = "D9BC0395AD15FA7E073090B68C8CD68C", hash_generated_method = "A1470DF6E91C2DDFFED0E9A70B2A0C17")
    
public static void dumpHprofData(String fileName) throws IOException {
        if (fileName == null)
            throw new NullPointerException();
        dumpHprofData(fileName, null);
    }
    
    public static void dumpHprofDataDdms() {
    }
    
    public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
    }
    
    public static boolean cacheRegisterMap(String classAndMethodDesc) {
        return (classAndMethodDesc.getTaintBoolean());
    }
    
    public static void dumpReferenceTables() {
    }
    
    public static void crash() {
    }
    
    public static void infopoint(int id) {
    }

    /*
     * Fake method, inserted into dmtrace output when the garbage collector
     * runs.  Not actually called.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.783 -0500", hash_original_method = "0FFE1B94F846E01BB31691717104A15E", hash_generated_method = "0DC425E9BF88C99ABA0565551A773C86")
    
private static void startGC() {}

    /*
     * Fake method, inserted into dmtrace output during class preparation
     * (loading and linking, but not verification or initialization).  Not
     * actually called.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.785 -0500", hash_original_method = "3D3C946F00763A2C63D10BF2042F540D", hash_generated_method = "6853C859C696ECCC5EC2C4AAF7CF7134")
    
private static void startClassPrep() {}
    
    public static long countInstancesOfClass(Class klass, boolean assignable) {
        long temp = 0;
        if (assignable)
            temp = 1;
        return (klass.getTaintInt()  + temp);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.564 -0500", hash_original_field = "103A7AD49C9023AE1D12A98CE8B6B3EC", hash_generated_field = "0A342A62DC379FC9FAD1F478C502DC74")

    @Deprecated
    static public final String DEFAULT_METHOD_TRACE_FILE_NAME = "/sdcard/dmtrace.trace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.567 -0500", hash_original_field = "B9DC14CB3BA80C9691F317F5895778D0", hash_generated_field = "99037F5ED2CF2B022DAC983B822A6D8E")

    public static final int TRACE_COUNT_ALLOCS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.569 -0500", hash_original_field = "C117C2342C56196138F36730206083BA", hash_generated_field = "86FED411FE88F9EFB8800AB4B85C0266")

    private static final int KIND_ALLOCATED_OBJECTS     = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.573 -0500", hash_original_field = "6E2850518D69AD1D3E08880CAACEF860", hash_generated_field = "AE798AFDC7624027F8AC3A9393058CD6")

    private static final int KIND_ALLOCATED_BYTES       = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.575 -0500", hash_original_field = "5D581614BEA2287700D9174F57DE30E8", hash_generated_field = "239F31017FDCDE5F27734B27DBAE2F8F")

    private static final int KIND_FREED_OBJECTS         = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.578 -0500", hash_original_field = "4B9401E02571CBA2C39F6A2B0D6F2737", hash_generated_field = "029D367FADD799EA31FDCA861D46BECB")

    private static final int KIND_FREED_BYTES           = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.580 -0500", hash_original_field = "814F8016FE8ECDB654F7D7132B461E68", hash_generated_field = "11B26BFA05C3F0FCC28297096831CE60")

    private static final int KIND_GC_INVOCATIONS        = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.583 -0500", hash_original_field = "D1A3D82B2F395803B4A21059B5635C8D", hash_generated_field = "3011931253F4527CF82FA30A5BE4110D")

    private static final int KIND_CLASS_INIT_COUNT      = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.586 -0500", hash_original_field = "0C2E2C750D82C3A9E078C4ED62886785", hash_generated_field = "A1034C52B93B9926471C2230F02D8C6A")

    private static final int KIND_CLASS_INIT_TIME       = 1<<6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.588 -0500", hash_original_field = "DB4E7E0B855B02B658765E81C09E0E3E", hash_generated_field = "61741F67E4C62824BFFE0BB58D7D43A6")

    private static final int KIND_EXT_ALLOCATED_OBJECTS = 1<<12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.590 -0500", hash_original_field = "6DA657EA35741970CF8C3630AC7EF559", hash_generated_field = "9E651C88405C67AB0367F5CA90BFD7D0")

    private static final int KIND_EXT_ALLOCATED_BYTES   = 1<<13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.593 -0500", hash_original_field = "653391C9897172C2F00EE931ED953C02", hash_generated_field = "8F0D266204B0236E4AAE6E20DAD3A2FA")

    private static final int KIND_EXT_FREED_OBJECTS     = 1<<14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.595 -0500", hash_original_field = "37B6BC8A244FCEF8402924A87120241F", hash_generated_field = "56ECC8DE5F83F50D7DD9F4B3327B65B2")

    private static final int KIND_EXT_FREED_BYTES       = 1<<15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.597 -0500", hash_original_field = "1E7AED118655CE65026DF9557326DFC9", hash_generated_field = "01DD6A64304611F641DBC73979499342")

    public static final int KIND_GLOBAL_ALLOCATED_OBJECTS =
        KIND_ALLOCATED_OBJECTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.601 -0500", hash_original_field = "8ABC638C18E33A6234E58D12518C6F5A", hash_generated_field = "B0538E2EC9C30F44158DF7E8197388A7")

    public static final int KIND_GLOBAL_ALLOCATED_BYTES =
        KIND_ALLOCATED_BYTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.603 -0500", hash_original_field = "0C8BE0BB426E64AFA5D51C27B39FE104", hash_generated_field = "B02FFC580FE36900E1D1B9824BB07A0E")

    public static final int KIND_GLOBAL_FREED_OBJECTS =
        KIND_FREED_OBJECTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.606 -0500", hash_original_field = "7512B70FB927465F766675BE3BCAD499", hash_generated_field = "4EBB8ED5D0CE2E0F85DE44C6135E3118")

    public static final int KIND_GLOBAL_FREED_BYTES =
        KIND_FREED_BYTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.608 -0500", hash_original_field = "D54AFB0EC7784E22A178CFB94C14ED57", hash_generated_field = "A34E5D6246239D7F63CAE56A26E8737C")

    public static final int KIND_GLOBAL_GC_INVOCATIONS =
        KIND_GC_INVOCATIONS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.611 -0500", hash_original_field = "1972B7A5F247B815C2DDE6BF43F29797", hash_generated_field = "0D34800C2E7B2E8F0A0FCBAC2CFA5AC4")

    public static final int KIND_GLOBAL_CLASS_INIT_COUNT =
        KIND_CLASS_INIT_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.613 -0500", hash_original_field = "4A9B7CDC6A6DD759FDC012F2AC41C613", hash_generated_field = "1223568735910A5EDE25EF8A1EC8AA8B")

    public static final int KIND_GLOBAL_CLASS_INIT_TIME =
        KIND_CLASS_INIT_TIME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.616 -0500", hash_original_field = "8A98249350D7C4E6AE9999BD1F4C2B7F", hash_generated_field = "310468A4FAFD75111A7864C21D5A8531")

    public static final int KIND_GLOBAL_EXT_ALLOCATED_OBJECTS =
        KIND_EXT_ALLOCATED_OBJECTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.618 -0500", hash_original_field = "8E786D7174D2A0730FF882E242D3C8C8", hash_generated_field = "F328EEF0A70CB365B7CAC8525F5C4588")

    public static final int KIND_GLOBAL_EXT_ALLOCATED_BYTES =
        KIND_EXT_ALLOCATED_BYTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.621 -0500", hash_original_field = "505C019F03F799B6CE280B5BE1A21F8C", hash_generated_field = "1E73062203F6160EFD53D951E919A380")

    public static final int KIND_GLOBAL_EXT_FREED_OBJECTS =
        KIND_EXT_FREED_OBJECTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.624 -0500", hash_original_field = "961CA871E1CD28B540D2ACE5AF8A65F6", hash_generated_field = "13AE72B64FAC31FCDD3E1C6E3F3367F7")

    public static final int KIND_GLOBAL_EXT_FREED_BYTES =
        KIND_EXT_FREED_BYTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.627 -0500", hash_original_field = "D64254E18C3944D426EE94A802C8663D", hash_generated_field = "424759D05E77D84C2A794371AE6B6879")

    public static final int KIND_THREAD_ALLOCATED_OBJECTS =
        KIND_ALLOCATED_OBJECTS << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.630 -0500", hash_original_field = "DD88DAAB259BFB1F8FBC599528BA9A9C", hash_generated_field = "748DF77E77AF56B519099249BCFD5482")

    public static final int KIND_THREAD_ALLOCATED_BYTES =
        KIND_ALLOCATED_BYTES << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.632 -0500", hash_original_field = "D4D7D5796F90D6AA51CFA87D9DAB1099", hash_generated_field = "79E2812444D05F0DF0A1E5198A434E06")

    public static final int KIND_THREAD_FREED_OBJECTS =
        KIND_FREED_OBJECTS << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.635 -0500", hash_original_field = "0C1D132E7AFA6B54BEE4C5EE072DB47A", hash_generated_field = "EDF82A7E59EA6F4749F87FAEFCC136C3")

    public static final int KIND_THREAD_FREED_BYTES =
        KIND_FREED_BYTES << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.637 -0500", hash_original_field = "90920B55139684A3B1C67E4AD1247043", hash_generated_field = "7797EC1BBB51BB191D5BC64768D9B618")

    public static final int KIND_THREAD_GC_INVOCATIONS =
        KIND_GC_INVOCATIONS << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.640 -0500", hash_original_field = "E0FC4429F79421A0CC37FCC41390FB88", hash_generated_field = "0B3220B3B62972A9BF33BD88FA50FA26")

    public static final int KIND_THREAD_CLASS_INIT_COUNT =
        KIND_CLASS_INIT_COUNT << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.642 -0500", hash_original_field = "32C48FF48736861626F92E3B4BEC65B8", hash_generated_field = "4E28D64EB868F9DC4031CFD336DE5ED3")

    public static final int KIND_THREAD_CLASS_INIT_TIME =
        KIND_CLASS_INIT_TIME << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.644 -0500", hash_original_field = "A00CCCBBF508E502F5F2F5F557AE7CF5", hash_generated_field = "AE1724098F85F60AB8C2BC32951E695C")

    public static final int KIND_THREAD_EXT_ALLOCATED_OBJECTS =
        KIND_EXT_ALLOCATED_OBJECTS << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.647 -0500", hash_original_field = "65E8857168596445BE6FD4329B9CABCC", hash_generated_field = "4BD820B68DD1142C6DF3898A24958EC8")

    public static final int KIND_THREAD_EXT_ALLOCATED_BYTES =
        KIND_EXT_ALLOCATED_BYTES << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.650 -0500", hash_original_field = "0825E42381D9ABB51B726FEA88B0C75B", hash_generated_field = "241413982F565E99692AD980FCDC7878")

    public static final int KIND_THREAD_EXT_FREED_OBJECTS =
        KIND_EXT_FREED_OBJECTS << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.652 -0500", hash_original_field = "79577D0F2DB6AE53F2C8134079AF8FEC", hash_generated_field = "146A7ED952720730F0474D575DC662DD")

    public static final int KIND_THREAD_EXT_FREED_BYTES =
        KIND_EXT_FREED_BYTES << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.655 -0500", hash_original_field = "C6BFB6917610FFE932616B456C3B5384", hash_generated_field = "D19857A092C4D22B54BA0D5CF6245D5A")

    public static final int KIND_ALL_COUNTS = 0xffffffff;

    /* all methods are static */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.658 -0500", hash_original_method = "90647D9537BEB374A6D0146E2B562497", hash_generated_method = "06310B4CCC08A42F2E40F4A0691EC434")
    
private VMDebug() {}
}

