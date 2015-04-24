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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Copyright (C) 2008 The Android Open Source Project
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


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants._SC_NPROCESSORS_ONLN;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.FinalizerReference;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import libcore.io.Libcore;
import dalvik.system.VMDebug;
import dalvik.system.VMStack;

public class Runtime {

    /**
     * Returns the single {@code Runtime} instance.
     *
     * @return the {@code Runtime} object for the current application.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.119 -0500", hash_original_method = "CF79B4C7AE45CC6197E4369ECF161253", hash_generated_method = "7F8C2B8A85E75003A22377212FF0E3F4")
    
public static Runtime getRuntime() {
        return mRuntime;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeExit(int code, boolean isExit) {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String nativeLoad(String filename, ClassLoader loader) {
		String ret = new String();
		ret.addTaint(filename.getTaint());
		ret.addTaint(loader.getTaint());
		return ret;
	}

    /**
     * Sets the flag that indicates whether all objects are finalized when the
     * VM is about to exit. Note that all finalization which occurs
     * when the system is exiting is performed after all running threads have
     * been terminated.
     *
     * @param run
     *            {@code true} to enable finalization on exit, {@code false} to
     *            disable it.
     * @deprecated This method is unsafe.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.143 -0500", hash_original_method = "6FEED072B476DF683299871B82C2E47E", hash_generated_method = "D1C8F57605DACB183A09E1BEE2EA4F5E")
    
@Deprecated
    public static void runFinalizersOnExit(boolean run) {
        finalizeOnExit = run;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.073 -0500", hash_original_field = "EFECDD24AD3974397A026C5BB7CFCF48", hash_generated_field = "BCF5878BF465442984A343ACEC428E44")

    private static final Runtime mRuntime = new Runtime();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.082 -0500", hash_original_field = "5BD75F7169EE0BB74134919D2507D939", hash_generated_field = "1AEBD11A773D78919BD6052F0FCA4C19")

    private static boolean finalizeOnExit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.076 -0500", hash_original_field = "EA8C1532071098B5DC417C67FC5B8163", hash_generated_field = "873422259A0094C2F3A569B7BBF35F19")

    private  String[] mLibPaths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.078 -0500", hash_original_field = "89B8C3340806330D20E0543C26D7539F", hash_generated_field = "8FF982D34AB52E579D2BCD2486CCEB28")

    private List<Thread> shutdownHooks = new ArrayList<Thread>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.084 -0500", hash_original_field = "4D7297ABA5C67559AF546FA23F798F9C", hash_generated_field = "7D744FBAE3A0077A4F980F9B4BD97716")

    private boolean shuttingDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.087 -0500", hash_original_field = "3F8A47ECFA104BE2E201CDC30AF34A9C", hash_generated_field = "C37DB832480F2E52014FFDC3AABF7287")

    private boolean tracingMethods;

    /**
     * Prevent this class from being instantiated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.090 -0500", hash_original_method = "F82AC05B2B9BDA560435929D86D5DD16", hash_generated_method = "D0C87865D7155E0AC8B85527D192C72C")
    
private Runtime(){
        String pathList = System.getProperty("java.library.path", ".");
        String pathSep = System.getProperty("path.separator", ":");
        String fileSep = System.getProperty("file.separator", "/");

        mLibPaths = pathList.split(pathSep);

        // Add a '/' to the end so we don't have to do the property lookup
        // and concatenation later.
        for (int i = 0; i < mLibPaths.length; i++) {
            if (!mLibPaths[i].endsWith(fileSep)) {
                mLibPaths[i] += fileSep;
            }
        }
    }

    /**
     * Executes the specified command and its arguments in a separate native
     * process. The new process inherits the environment of the caller. Calling
     * this method is equivalent to calling {@code exec(progArray, null, null)}.
     *
     * @param progArray
     *            the array containing the program to execute as well as any
     *            arguments to the program.
     * @return the new {@code Process} object that represents the native
     *         process.
     * @throws IOException
     *             if the requested program can not be executed.
     */
    @DSSink({DSSinkKind.PROCESS})
    @DSComment("From safe class list")
    @DSSpec(DSCat.EXEC)
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.092 -0500", hash_original_method = "CFCE84E7C9BE3630A08A3A7BB73629F7", hash_generated_method = "EC26FFA88B4CEA2BA30D31207670970A")
    
public Process exec(String[] progArray) throws java.io.IOException {
        return exec(progArray, null, null);
    }

    /**
     * Executes the specified command and its arguments in a separate native
     * process. The new process uses the environment provided in {@code envp}.
     * Calling this method is equivalent to calling
     * {@code exec(progArray, envp, null)}.
     *
     * @param progArray
     *            the array containing the program to execute as well as any
     *            arguments to the program.
     * @param envp
     *            the array containing the environment to start the new process
     *            in.
     * @return the new {@code Process} object that represents the native
     *         process.
     * @throws IOException
     *             if the requested program can not be executed.
     */
    @DSSink({DSSinkKind.PROCESS})
    @DSComment("From safe class list")
    @DSSpec(DSCat.EXEC)
    @DSSource({DSSourceKind.OS_PROCESS})    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.095 -0500", hash_original_method = "DBDF96D0DD01BF3A81297C1A77D3788B", hash_generated_method = "012ED451F3EDE6F4898BE91C42133BD1")
    
public Process exec(String[] progArray, String[] envp) throws java.io.IOException {
        return exec(progArray, envp, null);
    }

    /**
     * Executes the specified command and its arguments in a separate native
     * process. The new process uses the environment provided in {@code envp}
     * and the working directory specified by {@code directory}.
     *
     * @param progArray
     *            the array containing the program to execute as well as any
     *            arguments to the program.
     * @param envp
     *            the array containing the environment to start the new process
     *            in.
     * @param directory
     *            the directory in which to execute the program. If {@code null},
     *            execute if in the same directory as the parent process.
     * @return the new {@code Process} object that represents the native
     *         process.
     * @throws IOException
     *             if the requested program can not be executed.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.EXEC)
    @DSSink({DSSinkKind.PROCESS})
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.097 -0500", hash_original_method = "CA3870F83BC3F7A92215C18375ED76A3", hash_generated_method = "221BC57B8B66088A1C3F3396280CB7B6")
    
public Process exec(String[] progArray, String[] envp, File directory) throws IOException {
        // ProcessManager is responsible for all argument checking.
        return ProcessManager.getInstance().exec(progArray, envp, directory, false);
    }

    /**
     * Executes the specified program in a separate native process. The new
     * process inherits the environment of the caller. Calling this method is
     * equivalent to calling {@code exec(prog, null, null)}.
     *
     * @param prog
     *            the name of the program to execute.
     * @return the new {@code Process} object that represents the native
     *         process.
     * @throws IOException
     *             if the requested program can not be executed.
     */
    @DSSink({DSSinkKind.PROCESS})
    @DSComment("From safe class list")
    @DSSpec(DSCat.EXEC)
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.100 -0500", hash_original_method = "06266E096A96F3360CE9E0923017372F", hash_generated_method = "69302971750C4DE1739C01F52A54BD9E")
    
public Process exec(String prog) throws java.io.IOException {
        return exec(prog, null, null);
    }

    /**
     * Executes the specified program in a separate native process. The new
     * process uses the environment provided in {@code envp}. Calling this
     * method is equivalent to calling {@code exec(prog, envp, null)}.
     *
     * @param prog
     *            the name of the program to execute.
     * @param envp
     *            the array containing the environment to start the new process
     *            in.
     * @return the new {@code Process} object that represents the native
     *         process.
     * @throws IOException
     *             if the requested program can not be executed.
     */
    @DSSink({DSSinkKind.PROCESS})
    @DSComment("From safe class list")
    @DSSpec(DSCat.EXEC)
    @DSSource({DSSourceKind.OS_PROCESS})    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.102 -0500", hash_original_method = "7285BF96BB6399D281A4BE01B5D250F8", hash_generated_method = "E3A3C574ABCA0B9301B70808DA5891D3")
    
public Process exec(String prog, String[] envp) throws java.io.IOException {
        return exec(prog, envp, null);
    }

    /**
     * Executes the specified program in a separate native process. The new
     * process uses the environment provided in {@code envp} and the working
     * directory specified by {@code directory}.
     *
     * @param prog
     *            the name of the program to execute.
     * @param envp
     *            the array containing the environment to start the new process
     *            in.
     * @param directory
     *            the directory in which to execute the program. If {@code null},
     *            execute if in the same directory as the parent process.
     * @return the new {@code Process} object that represents the native
     *         process.
     * @throws IOException
     *             if the requested program can not be executed.
     */
    @DSSink({DSSinkKind.PROCESS})
    @DSComment("From safe class list")
    @DSSpec(DSCat.EXEC)
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.105 -0500", hash_original_method = "D63330F96D8E34D6A893E8125BEC80CB", hash_generated_method = "F14BCCFE800317A310D614C37E2F80A1")
    
public Process exec(String prog, String[] envp, File directory) throws java.io.IOException {
        // Sanity checks
        if (prog == null) {
            throw new NullPointerException();
        } else if (prog.length() == 0) {
            throw new IllegalArgumentException();
        }

        // Break down into tokens, as described in Java docs
        StringTokenizer tokenizer = new StringTokenizer(prog);
        int length = tokenizer.countTokens();
        String[] progArray = new String[length];
        for (int i = 0; i < length; i++) {
            progArray[i] = tokenizer.nextToken();
        }

        // Delegate
        return exec(progArray, envp, directory);
    }

    /**
     * Causes the VM to stop running and the program to exit. If
     * {@link #runFinalizersOnExit(boolean)} has been previously invoked with a
     * {@code true} argument, then all objects will be properly
     * garbage-collected and finalized first.
     *
     * @param code
     *            the return code. By convention, non-zero return codes indicate
     *            abnormal terminations.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.108 -0500", hash_original_method = "06E9B7958C64599C6A29BDE55862BAAD", hash_generated_method = "849CF09FE771298F8364E356A2F1C2ED")
    
public void exit(int code) {
        // Make sure we don't try this several times
        synchronized(this) {
            if (!shuttingDown) {
                shuttingDown = true;

                Thread[] hooks;
                synchronized (shutdownHooks) {
                    // create a copy of the hooks
                    hooks = new Thread[shutdownHooks.size()];
                    shutdownHooks.toArray(hooks);
                }

                // Start all shutdown hooks concurrently
                for (Thread hook : hooks) {
                    hook.start();
                }

                // Wait for all shutdown hooks to finish
                for (Thread hook : hooks) {
                    try {
                        hook.join();
                    } catch (InterruptedException ex) {
                        // Ignore, since we are at VM shutdown.
                    }
                }

                // Ensure finalization on exit, if requested
                if (finalizeOnExit) {
                    runFinalization();
                }

                // Get out of here finally...
                nativeExit(code, true);
            }
        }
    }

    /**
     * Returns the amount of free memory resources which are available to the
     * running program.
     *
     * @return the approximate amount of free memory, measured in bytes.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.113 -0500", hash_original_method = "67196F5597F9CC48251D355499CA1423", hash_generated_method = "03B1D8FA42088D9DFFDBC0D65350C21D")
    
    public long freeMemory(){
    	//Formerly a native method
    	return getTaintLong();
    }

    /**
     * Indicates to the VM that it would be a good time to run the
     * garbage collector. Note that this is a hint only. There is no guarantee
     * that the garbage collector will actually be run.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.116 -0500", hash_original_method = "D5E9C32F4CCF731A5E6B245C708DE511", hash_generated_method = "7CAFCB792CC3B4196FB5C37A1486828D")
    
    public void gc(){
    	//Formerly a native method
    }

    /**
     * Loads and links the dynamic library that is identified through the
     * specified path. This method is similar to {@link #loadLibrary(String)},
     * but it accepts a full path specification whereas {@code loadLibrary} just
     * accepts the name of the library to load.
     *
     * @param pathName
     *            the absolute (platform dependent) path to the library to load.
     * @throws UnsatisfiedLinkError
     *             if the library can not be loaded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.121 -0500", hash_original_method = "D4CBB36D8902BC048F224692FC6F0770", hash_generated_method = "B724131873CD57EFCB8673E6D06D13C3")
    
public void load(String pathName) {
        load(pathName, VMStack.getCallingClassLoader());
    }

    /*
     * Loads and links a library without security checks.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.123 -0500", hash_original_method = "93CD7EAF10A1B837C6D2761A80025550", hash_generated_method = "93CD7EAF10A1B837C6D2761A80025550")
    
void load(String filename, ClassLoader loader) {
        if (filename == null) {
            throw new NullPointerException("library path was null.");
        }
        String error = nativeLoad(filename, loader);
        if (error != null) {
            throw new UnsatisfiedLinkError(error);
        }
    }

    /**
     * Loads and links the library with the specified name. The mapping of the
     * specified library name to the full path for loading the library is
     * implementation-dependent.
     *
     * @param libName
     *            the name of the library to load.
     * @throws UnsatisfiedLinkError
     *             if the library can not be loaded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.126 -0500", hash_original_method = "552217161A043147D154E437EB4B14C4", hash_generated_method = "1F4F734C1780E7BC04FB653B2CE957E6")
    
public void loadLibrary(String libName) {
        loadLibrary(libName, VMStack.getCallingClassLoader());
    }

    /*
     * Loads and links a library without security checks.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.129 -0500", hash_original_method = "5EE816C9B41613E4D79FD41D836C9458", hash_generated_method = "7353395E9663C30CCFFD8479E2CC9BF3")
    
void loadLibrary(String libraryName, ClassLoader loader) {
        if (loader != null) {
            String filename = loader.findLibrary(libraryName);
            if (filename == null) {
                throw new UnsatisfiedLinkError("Couldn't load " + libraryName + ": " +
                        "findLibrary returned null");
            }
            String error = nativeLoad(filename, loader);
            if (error != null) {
                throw new UnsatisfiedLinkError(error);
            }
            return;
        }

        String filename = System.mapLibraryName(libraryName);
        List<String> candidates = new ArrayList<String>();
        String lastError = null;
        for (String directory : mLibPaths) {
            String candidate = directory + filename;
            candidates.add(candidate);
            if (new File(candidate).exists()) {
                String error = nativeLoad(candidate, loader);
                if (error == null) {
                    return; // We successfully loaded the library. Job done.
                }
                lastError = error;
            }
        }

        if (lastError != null) {
            throw new UnsatisfiedLinkError(lastError);
        }
        throw new UnsatisfiedLinkError("Library " + libraryName + " not found; tried " + candidates);
    }

    /**
     * Provides a hint to the VM that it would be useful to attempt
     * to perform any outstanding object finalization.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.141 -0500", hash_original_method = "D97B4D8E5C3471916B8248342E55C9E3", hash_generated_method = "490DC7CEB8477FD06E9F6667162C59A4")
    
public void runFinalization() {
        try {
            FinalizerReference.finalizeAllEnqueued();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Returns the total amount of memory which is available to the running
     * program.
     *
     * @return the total amount of memory, measured in bytes.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.147 -0500", hash_original_method = "4EB2522F808EA94D0A66B66F863EF421", hash_generated_method = "02A74D4A84EFA9230F4E805F6BC04E85")
    
    public long totalMemory(){
    	//Formerly a native method
    	return getTaintLong();
    }

    /**
     * Switches the output of debug information for instructions on or off.
     * On Android, this method does nothing.
     *
     * @param enable
     *            {@code true} to switch tracing on, {@code false} to switch it
     *            off.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.149 -0500", hash_original_method = "53798D26DA92803B5299289F1912C9D0", hash_generated_method = "FEA64DAEE719055E865CD3E5F5BD0AB2")
    
public void traceInstructions(boolean enable) {
    }

    /**
     * Switches the output of debug information for methods on or off.
     *
     * @param enable
     *            {@code true} to switch tracing on, {@code false} to switch it
     *            off.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.151 -0500", hash_original_method = "047BFF8451D039E49AAF4D452A82FBF3", hash_generated_method = "60686E421DC4531B6272F4C57506CB55")
    
public void traceMethodCalls(boolean enable) {
        if (enable != tracingMethods) {
            if (enable) {
                VMDebug.startMethodTracing();
            } else {
                VMDebug.stopMethodTracing();
            }
            tracingMethods = enable;
        }
    }

    /**
     * Returns the localized version of the specified input stream. The input
     * stream that is returned automatically converts all characters from the
     * local character set to Unicode after reading them from the underlying
     * stream.
     *
     * @param stream
     *            the input stream to localize.
     * @return the localized input stream.
     * @deprecated Use {@link InputStreamReader}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.154 -0500", hash_original_method = "4DD488C3A0CAA7F2473CD0DE597FBF5E", hash_generated_method = "6B953C9928DDF293F7CA3841743D37B9")
    
@Deprecated
    public InputStream getLocalizedInputStream(InputStream stream) {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        if (!encoding.equals("UTF-8")) {
            throw new UnsupportedOperationException("Cannot localize " + encoding);
        }
        return stream;
    }

    /**
     * Returns the localized version of the specified output stream. The output
     * stream that is returned automatically converts all characters from
     * Unicode to the local character set before writing them to the underlying
     * stream.
     *
     * @param stream
     *            the output stream to localize.
     * @return the localized output stream.
     * @deprecated Use {@link OutputStreamWriter}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.157 -0500", hash_original_method = "E706425DACD57D6DD3EDF96DBA8FB92E", hash_generated_method = "5B2EE3BA978AE131C6801B8B781364A3")
    
@Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream stream) {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        if (!encoding.equals("UTF-8")) {
            throw new UnsupportedOperationException("Cannot localize " + encoding);
        }
        return stream;
    }

    /**
     * Registers a VM shutdown hook. A shutdown hook is a
     * {@code Thread} that is ready to run, but has not yet been started. All
     * registered shutdown hooks will be executed when the VM
     * terminates normally (typically when the {@link #exit(int)} method is called).
     *
     * <p><i>Note that on Android, the application lifecycle does not include VM termination,
     * so calling this method will not ensure that your code is run</i>. Instead, you should
     * use the most appropriate lifecycle notification ({@code Activity.onPause}, say).
     *
     * <p>Shutdown hooks are run concurrently and in an unspecified order. Hooks
     * failing due to an unhandled exception are not a problem, but the stack
     * trace might be printed to the console. Once initiated, the whole shutdown
     * process can only be terminated by calling {@code halt()}.
     *
     * <p>If {@link #runFinalizersOnExit(boolean)} has been called with a {@code
     * true} argument, garbage collection and finalization will take place after
     * all hooks are either finished or have failed. Then the VM
     * terminates.
     *
     * <p>It is recommended that shutdown hooks do not do any time-consuming
     * activities, in order to not hold up the shutdown process longer than
     * necessary.
     *
     * @param hook
     *            the shutdown hook to register.
     * @throws IllegalArgumentException
     *             if the hook has already been started or if it has already
     *             been registered.
     * @throws IllegalStateException
     *             if the VM is already shutting down.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.161 -0500", hash_original_method = "4A60C315F45CCAAE039020003BF5AFDA", hash_generated_method = "0CB2C0DD3FA775AC9C9F386D313E0205")
    
public void addShutdownHook(Thread hook) {
        // Sanity checks
        if (hook == null) {
            throw new NullPointerException("Hook may not be null.");
        }

        if (shuttingDown) {
            throw new IllegalStateException("VM already shutting down");
        }

        if (hook.hasBeenStarted) {
            throw new IllegalArgumentException("Hook has already been started");
        }

        synchronized (shutdownHooks) {
            if (shutdownHooks.contains(hook)) {
                throw new IllegalArgumentException("Hook already registered.");
            }

            shutdownHooks.add(hook);
        }
    }

    /**
     * Unregisters a previously registered VM shutdown hook.
     *
     * @param hook
     *            the shutdown hook to remove.
     * @return {@code true} if the hook has been removed successfully; {@code
     *         false} otherwise.
     * @throws IllegalStateException
     *             if the VM is already shutting down.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.163 -0500", hash_original_method = "402CE948C1020CDD411F4962B0A96E04", hash_generated_method = "FB34F21E38C960E2AA3188CC7A171CE2")
    
public boolean removeShutdownHook(Thread hook) {
        // Sanity checks
        if (hook == null) {
            throw new NullPointerException("Hook may not be null.");
        }

        if (shuttingDown) {
            throw new IllegalStateException("VM already shutting down");
        }

        synchronized (shutdownHooks) {
            return shutdownHooks.remove(hook);
        }
    }

    /**
     * Causes the VM to stop running, and the program to exit.
     * Neither shutdown hooks nor finalizers are run before.
     *
     * @param code
     *            the return code. By convention, non-zero return codes indicate
     *            abnormal terminations.
     * @see #addShutdownHook(Thread)
     * @see #removeShutdownHook(Thread)
     * @see #runFinalizersOnExit(boolean)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.166 -0500", hash_original_method = "9A4EA06F4CB88B6269FED18A769E865A", hash_generated_method = "02773E578A171A0923FD2ACFD6F04C35")
    
public void halt(int code) {
        // Get out of here...
        nativeExit(code, false);
    }

    /**
     * Returns the number of processors available to the VM, at least 1.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.168 -0500", hash_original_method = "1DA5795546617F35E1E74BDB5F5DDD58", hash_generated_method = "878D85E66666C4CA6A7F7C1FFC6D09CD")
    
public int availableProcessors() {
        return (int) Libcore.os.sysconf(_SC_NPROCESSORS_ONLN);
    }

    /**
     * Returns the maximum amount of memory that may be used by the virtual
     * machine, or {@code Long.MAX_VALUE} if there is no such limit.
     *
     * @return the maximum amount of memory that the VM will try to
     *         allocate, measured in bytes.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.172 -0500", hash_original_method = "2D7CF54D0F59DA12C2E5D19C64B23A09", hash_generated_method = "64D18F4F671EB170201CCA8A1F55D3C5")
    
    public long maxMemory(){
    	//Formerly a native method
    	return getTaintLong();
    }

}

