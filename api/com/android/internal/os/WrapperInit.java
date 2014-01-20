package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

import libcore.io.IoUtils;
import android.os.Process;
import android.util.Slog;
import dalvik.system.Zygote;

public class WrapperInit {

    /**
     * The main function called when starting a runtime application through a
     * wrapper process instead of by forking Zygote.
     *
     * The first argument specifies the file descriptor for a pipe that should receive
     * the pid of this process, or 0 if none.
     *
     * The second argument is the target SDK version for the app.
     *
     * The remaining arguments are passed to the runtime.
     *
     * @param args The command-line arguments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.071 -0500", hash_original_method = "B2636DC4FA80F4D909AE07B0C60C2BBA", hash_generated_method = "E82A8FDB08BA4347DA20CDD2BE0740E7")
    
public static void main(String[] args) {
        try {
            // Parse our mandatory arguments.
            int fdNum = Integer.parseInt(args[0], 10);
            int targetSdkVersion = Integer.parseInt(args[1], 10);

            // Tell the Zygote what our actual PID is (since it only knows about the
            // wrapper that it directly forked).
            if (fdNum != 0) {
                try {
                    FileDescriptor fd = ZygoteInit.createFileDescriptor(fdNum);
                    DataOutputStream os = new DataOutputStream(new FileOutputStream(fd));
                    os.writeInt(Process.myPid());
                    os.close();
                    IoUtils.closeQuietly(fd);
                } catch (IOException ex) {
                    Slog.d(TAG, "Could not write pid of wrapped process to Zygote pipe.", ex);
                }
            }

            // Mimic Zygote preloading.
            ZygoteInit.preload();

            // Launch the application.
            String[] runtimeArgs = new String[args.length - 2];
            System.arraycopy(args, 2, runtimeArgs, 0, runtimeArgs.length);
            RuntimeInit.wrapperInit(targetSdkVersion, runtimeArgs);
        } catch (ZygoteInit.MethodAndArgsCaller caller) {
            caller.run();
        }
    }

    /**
     * Executes a runtime application with a wrapper command.
     * This method never returns.
     *
     * @param invokeWith The wrapper command.
     * @param niceName The nice name for the application, or null if none.
     * @param targetSdkVersion The target SDK version for the app.
     * @param pipeFd The pipe to which the application's pid should be written, or null if none.
     * @param args Arguments for {@link RuntimeInit.main}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.074 -0500", hash_original_method = "804828DF863853F51815A92894A43F8E", hash_generated_method = "D2E7F82E0337CABE39D19F6537A91C59")
    
public static void execApplication(String invokeWith, String niceName,
            int targetSdkVersion, FileDescriptor pipeFd, String[] args) {
        StringBuilder command = new StringBuilder(invokeWith);
        command.append(" /system/bin/app_process /system/bin --application");
        if (niceName != null) {
            command.append(" '--nice-name=").append(niceName).append("'");
        }
        command.append(" com.android.internal.os.WrapperInit ");
        command.append(pipeFd != null ? pipeFd.getInt$() : 0);
        command.append(' ');
        command.append(targetSdkVersion);
        Zygote.appendQuotedShellArgs(command, args);
        Zygote.execShell(command.toString());
    }

    /**
     * Executes a standalone application with a wrapper command.
     * This method never returns.
     *
     * @param invokeWith The wrapper command.
     * @param classPath The class path.
     * @param className The class name to invoke.
     * @param args Arguments for the main() method of the specified class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.076 -0500", hash_original_method = "728EB40B22AAC8E4A2D49FB71329AFF3", hash_generated_method = "5CF2AA5256F4CD377A4E608FDA938439")
    
public static void execStandalone(String invokeWith, String classPath, String className,
            String[] args) {
        StringBuilder command = new StringBuilder(invokeWith);
        command.append(" /system/bin/dalvikvm -classpath '").append(classPath);
        command.append("' ").append(className);
        Zygote.appendQuotedShellArgs(command, args);
        Zygote.execShell(command.toString());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.066 -0500", hash_original_field = "C73D9F25E5F6CAFECCE98CB85C10D990", hash_generated_field = "527BFEF4E332EB2DD2EA4CFDB3D09D89")

    private final static String TAG = "AndroidRuntime";

    /**
     * Class not instantiable.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.068 -0500", hash_original_method = "14AE6538EB86DCD6EBFC0019A87B65D0", hash_generated_method = "E422BC2875F034EC395ED434A5EE1290")
    
private WrapperInit() {
    }
}

