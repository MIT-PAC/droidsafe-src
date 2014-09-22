/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * General File System utilities.
 * <p>
 * This class provides static utility methods for general file system
 * functions not provided via the JDK {@link java.io.File File} class.
 * <p>
 * The current functions provided are:
 * <ul>
 * <li>Get the free space on a drive
 * </ul>
 *
 * @version $Id: FileSystemUtils.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 1.1
 */
public class FileSystemUtils {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.408 -0400", hash_original_field = "3BED8B3A95781C5E3F4CBDD4D7B16A72", hash_generated_field = "BAF34ABE3892E356385919733AA31352")

    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.408 -0400", hash_original_field = "1A0DF69D07651EB10827DCF8D799A5C7", hash_generated_field = "159C5E222AE5F1D573330719AA6704B7")

    private static final int INIT_PROBLEM = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.409 -0400", hash_original_field = "FD8EA0C421F4CC5A4B4D9E3D60703940", hash_generated_field = "4EBDBE8CCBB57AB35C91B02D6D0A395B")

    private static final int OTHER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.409 -0400", hash_original_field = "F1B439A149497C6CB5D9CF3FC9757468", hash_generated_field = "55DCE7BC6C8E724781CB8B3E7AEFDAE9")

    private static final int WINDOWS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.410 -0400", hash_original_field = "1FBF6E79D3E1FCD7E60902678B2B5212", hash_generated_field = "DA99129C168565D6461F34E68BC7022F")

    private static final int UNIX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.410 -0400", hash_original_field = "6ABCDF9AA84FE24A4A08D3C7B906748E", hash_generated_field = "9C7D05AE2AE7C3FCBCC5BF99E78D2A1E")

    private static final int POSIX_UNIX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.411 -0400", hash_original_field = "917AF1B33DA01DA18CC3A38418186F7D", hash_generated_field = "8D349094D13E25F9D974BE01EA3B69CE")

    private static  int OS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.411 -0400", hash_original_field = "D5486DD7D7F3A57FA5C52A2A7A2F9F50", hash_generated_field = "958156933CCF5CFEF728004182F39BA7")

    private static  String DF;

    static {
        int os = OTHER;
        String dfPath = "df";
        try {
            String osName = System.getProperty("os.name");
            if (osName == null) {
                throw new IOException("os.name not found");
            }
            osName = osName.toLowerCase(Locale.ENGLISH);
            // match
            if (osName.indexOf("windows") != -1) {
                os = WINDOWS;
            } else if (osName.indexOf("linux") != -1 ||
                osName.indexOf("mpe/ix") != -1 ||
                osName.indexOf("freebsd") != -1 ||
                osName.indexOf("irix") != -1 ||
                osName.indexOf("digital unix") != -1 ||
                osName.indexOf("unix") != -1 ||
                osName.indexOf("mac os x") != -1) {
                os = UNIX;
            } else if (osName.indexOf("sun os") != -1 ||
                osName.indexOf("sunos") != -1 ||
                osName.indexOf("solaris") != -1) {
                os = POSIX_UNIX;
                dfPath = "/usr/xpg4/bin/df";
            } else if (osName.indexOf("hp-ux") != -1 ||
                osName.indexOf("aix") != -1) {
                os = POSIX_UNIX;
            } else {
                os = OTHER;
            }

        } catch (Exception ex) {
            os = INIT_PROBLEM;
        }
        OS = os;
        DF = dfPath;
    }

    //-----------------------------------------------------------------------
    /**
     * Returns the free space on a drive or volume by invoking
     * the command line.
     * This method does not normalize the result, and typically returns
     * bytes on Windows, 512 byte units on OS X and kilobytes on Unix.
     * As this is not very useful, this method is deprecated in favour
     * of {@link #freeSpaceKb(String)} which returns a result in kilobytes.
     * <p>
     * Note that some OS's are NOT currently supported, including OS/390,
     * OpenVMS. 
     * <pre>
     * FileSystemUtils.freeSpace("C:");       // Windows
     * FileSystemUtils.freeSpace("/volume");  // *nix
     * </pre>
     * The free space is calculated via the command line.
     * It uses 'dir /-c' on Windows and 'df' on *nix.
     *
     * @param path  the path to get free space for, not null, not empty on Unix
     * @return the amount of free drive space on the drive or volume
     * @throws IllegalArgumentException if the path is invalid
     * @throws IllegalStateException if an error occurred in initialisation
     * @throws IOException if an error occurs when finding the free space
     * @since 1.1, enhanced OS support in 1.2 and 1.3
     * @deprecated Use freeSpaceKb(String)
     *  Deprecated from 1.3, may be removed in 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.412 -0400", hash_original_method = "E6ECC7D8AF211E919D46EA4C46CCFA3E", hash_generated_method = "B9871FD72E33D701E4BD57F68EFBFD22")
    
@Deprecated
    public static long freeSpace(String path) throws IOException {
        return INSTANCE.freeSpaceOS(path, OS, false, -1);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns the free space on a drive or volume in kilobytes by invoking
     * the command line.
     * <pre>
     * FileSystemUtils.freeSpaceKb("C:");       // Windows
     * FileSystemUtils.freeSpaceKb("/volume");  // *nix
     * </pre>
     * The free space is calculated via the command line.
     * It uses 'dir /-c' on Windows, 'df -kP' on AIX/HP-UX and 'df -k' on other Unix.
     * <p>
     * In order to work, you must be running Windows, or have a implementation of
     * Unix df that supports GNU format when passed -k (or -kP). If you are going
     * to rely on this code, please check that it works on your OS by running
     * some simple tests to compare the command line with the output from this class.
     * If your operating system isn't supported, please raise a JIRA call detailing
     * the exact result from df -k and as much other detail as possible, thanks.
     *
     * @param path  the path to get free space for, not null, not empty on Unix
     * @return the amount of free drive space on the drive or volume in kilobytes
     * @throws IllegalArgumentException if the path is invalid
     * @throws IllegalStateException if an error occurred in initialisation
     * @throws IOException if an error occurs when finding the free space
     * @since 1.2, enhanced OS support in 1.3
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.413 -0400", hash_original_method = "0D0D2FAADAF548F2FF72661A7907F188", hash_generated_method = "3A8E4EF20CBB7F065F94A974E4FB0BA2")
    
public static long freeSpaceKb(String path) throws IOException {
        return freeSpaceKb(path, -1);
    }
    /**
     * Returns the free space on a drive or volume in kilobytes by invoking
     * the command line.
     * <pre>
     * FileSystemUtils.freeSpaceKb("C:");       // Windows
     * FileSystemUtils.freeSpaceKb("/volume");  // *nix
     * </pre>
     * The free space is calculated via the command line.
     * It uses 'dir /-c' on Windows, 'df -kP' on AIX/HP-UX and 'df -k' on other Unix.
     * <p>
     * In order to work, you must be running Windows, or have a implementation of
     * Unix df that supports GNU format when passed -k (or -kP). If you are going
     * to rely on this code, please check that it works on your OS by running
     * some simple tests to compare the command line with the output from this class.
     * If your operating system isn't supported, please raise a JIRA call detailing
     * the exact result from df -k and as much other detail as possible, thanks.
     *
     * @param path  the path to get free space for, not null, not empty on Unix
     * @param timeout The timout amount in milliseconds or no timeout if the value
     *  is zero or less
     * @return the amount of free drive space on the drive or volume in kilobytes
     * @throws IllegalArgumentException if the path is invalid
     * @throws IllegalStateException if an error occurred in initialisation
     * @throws IOException if an error occurs when finding the free space
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.414 -0400", hash_original_method = "5423FB8AFED9E1B5F3184B921E9E3F36", hash_generated_method = "B7194734D9D643F6B9A3D4773FBE051B")
    
public static long freeSpaceKb(String path, long timeout) throws IOException {
        return INSTANCE.freeSpaceOS(path, OS, true, timeout);
    }

    /**
     * Returns the disk size of the volume which holds the working directory.
     * <p>
     * Identical to:
     * <pre>
     * freeSpaceKb(new File(".").getAbsolutePath())
     * </pre>
     * @return the amount of free drive space on the drive or volume in kilobytes
     * @throws IllegalStateException if an error occurred in initialisation
     * @throws IOException if an error occurs when finding the free space
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.415 -0400", hash_original_method = "D9A32E80E4ED59FA929BDC4209C2457F", hash_generated_method = "75A3CE2AB5EBCE7A4F263D9790321343")
    
public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1); 
    }

    /**
     * Returns the disk size of the volume which holds the working directory.
     * <p>
     * Identical to:
     * <pre>
     * freeSpaceKb(new File(".").getAbsolutePath())
     * </pre>
     * @param timeout The timout amount in milliseconds or no timeout if the value
     *  is zero or less
     * @return the amount of free drive space on the drive or volume in kilobytes
     * @throws IllegalStateException if an error occurred in initialisation
     * @throws IOException if an error occurs when finding the free space
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.415 -0400", hash_original_method = "8F587A01B80DDA3C7D203EBD5F10C9EB", hash_generated_method = "0558DDE90C7DCDD03DD215D98F170BBD")
    
public static long freeSpaceKb(long timeout) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), timeout); 
    }

    /**
     * Instances should NOT be constructed in standard programming.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.412 -0400", hash_original_method = "B29D45870A29045F43463B3631BB6C4B", hash_generated_method = "B7A5FDF561F20A03F1B3A4E23BF2116F")
    
public FileSystemUtils() {
        super();
    }
    
    //-----------------------------------------------------------------------
    /**
     * Returns the free space on a drive or volume in a cross-platform manner.
     * Note that some OS's are NOT currently supported, including OS/390.
     * <pre>
     * FileSystemUtils.freeSpace("C:");  // Windows
     * FileSystemUtils.freeSpace("/volume");  // *nix
     * </pre>
     * The free space is calculated via the command line.
     * It uses 'dir /-c' on Windows and 'df' on *nix.
     *
     * @param path  the path to get free space for, not null, not empty on Unix
     * @param os  the operating system code
     * @param kb  whether to normalize to kilobytes
     * @param timeout The timout amount in milliseconds or no timeout if the value
     *  is zero or less
     * @return the amount of free drive space on the drive or volume
     * @throws IllegalArgumentException if the path is invalid
     * @throws IllegalStateException if an error occurred in initialisation
     * @throws IOException if an error occurs when finding the free space
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.416 -0400", hash_original_method = "E0E33A53BF06D22C0B2157AB1696B99E", hash_generated_method = "E0E33A53BF06D22C0B2157AB1696B99E")
    
long freeSpaceOS(String path, int os, boolean kb, long timeout) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        switch (os) {
            case WINDOWS:
                return kb ? freeSpaceWindows(path, timeout) / FileUtils.ONE_KB : freeSpaceWindows(path, timeout);
            case UNIX:
                return freeSpaceUnix(path, kb, false, timeout);
            case POSIX_UNIX:
                return freeSpaceUnix(path, kb, true, timeout);
            case OTHER:
                throw new IllegalStateException("Unsupported operating system");
            default:
                throw new IllegalStateException(
                  "Exception caught when determining operating system");
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Find free space on the Windows platform using the 'dir' command.
     *
     * @param path  the path to get free space for, including the colon
     * @param timeout The timout amount in milliseconds or no timeout if the value
     *  is zero or less
     * @return the amount of free drive space on the drive
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.417 -0400", hash_original_method = "97DC8BEF6DA4F2C77A7C47140A7E5DBB", hash_generated_method = "E5C9BEB5C08CF7BC7E37FD9017B6D1B3")
    
long freeSpaceWindows(String path, long timeout) throws IOException {
        path = FilenameUtils.normalize(path, false);
        if (path.length() > 0 && path.charAt(0) != '"') {
            path = "\"" + path + "\"";
        }
        
        // build and run the 'dir' command
        String[] cmdAttribs = new String[] {"cmd.exe", "/C", "dir /a /-c " + path};
        
        // read in the output of the command to an ArrayList
        List<String> lines = performCommand(cmdAttribs, Integer.MAX_VALUE, timeout);
        
        // now iterate over the lines we just read and find the LAST
        // non-empty line (the free space bytes should be in the last element
        // of the ArrayList anyway, but this will ensure it works even if it's
        // not, still assuming it is on the last non-blank line)
        for (int i = lines.size() - 1; i >= 0; i--) {
            String line = lines.get(i);
            if (line.length() > 0) {
                return parseDir(line, path);
            }
        }
        // all lines are blank
        throw new IOException(
                "Command line 'dir /-c' did not return any info " +
                "for path '" + path + "'");
    }

    /**
     * Parses the Windows dir response last line
     *
     * @param line  the line to parse
     * @param path  the path that was sent
     * @return the number of bytes
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.418 -0400", hash_original_method = "BF05C25EF740B0B2989A55D0BCB5E47A", hash_generated_method = "41BBD58874EB33676CAB5C7BF3C43288")
    
long parseDir(String line, String path) throws IOException {
        // read from the end of the line to find the last numeric
        // character on the line, then continue until we find the first
        // non-numeric character, and everything between that and the last
        // numeric character inclusive is our free space bytes count
        int bytesStart = 0;
        int bytesEnd = 0;
        int j = line.length() - 1;
        innerLoop1: while (j >= 0) {
            char c = line.charAt(j);
            if (Character.isDigit(c)) {
              // found the last numeric character, this is the end of
              // the free space bytes count
              bytesEnd = j + 1;
              break innerLoop1;
            }
            j--;
        }
        innerLoop2: while (j >= 0) {
            char c = line.charAt(j);
            if (!Character.isDigit(c) && c != ',' && c != '.') {
              // found the next non-numeric character, this is the
              // beginning of the free space bytes count
              bytesStart = j + 1;
              break innerLoop2;
            }
            j--;
        }
        if (j < 0) {
            throw new IOException(
                    "Command line 'dir /-c' did not return valid info " +
                    "for path '" + path + "'");
        }
        
        // remove commas and dots in the bytes count
        StringBuilder buf = new StringBuilder(line.substring(bytesStart, bytesEnd));
        for (int k = 0; k < buf.length(); k++) {
            if (buf.charAt(k) == ',' || buf.charAt(k) == '.') {
                buf.deleteCharAt(k--);
            }
        }
        return parseBytes(buf.toString(), path);
    }

    //-----------------------------------------------------------------------
    /**
     * Find free space on the *nix platform using the 'df' command.
     *
     * @param path  the path to get free space for
     * @param kb  whether to normalize to kilobytes
     * @param posix  whether to use the posix standard format flag
     * @param timeout The timout amount in milliseconds or no timeout if the value
     *  is zero or less
     * @return the amount of free drive space on the volume
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.420 -0400", hash_original_method = "63A1B9B4037D6BF474EA6B9864F43D94", hash_generated_method = "8A13DD19DB7ACD966234278F3277EF5F")
    
long freeSpaceUnix(String path, boolean kb, boolean posix, long timeout) throws IOException {
        if (path.length() == 0) {
            throw new IllegalArgumentException("Path must not be empty");
        }

        // build and run the 'dir' command
        String flags = "-";
        if (kb) {
            flags += "k";
        }
        if (posix) {
            flags += "P";
        }
        String[] cmdAttribs = 
            flags.length() > 1 ? new String[] {DF, flags, path} : new String[] {DF, path};
        
        // perform the command, asking for up to 3 lines (header, interesting, overflow)
        List<String> lines = performCommand(cmdAttribs, 3, timeout);
        if (lines.size() < 2) {
            // unknown problem, throw exception
            throw new IOException(
                    "Command line '" + DF + "' did not return info as expected " +
                    "for path '" + path + "'- response was " + lines);
        }
        String line2 = lines.get(1); // the line we're interested in
        
        // Now, we tokenize the string. The fourth element is what we want.
        StringTokenizer tok = new StringTokenizer(line2, " ");
        if (tok.countTokens() < 4) {
            // could be long Filesystem, thus data on third line
            if (tok.countTokens() == 1 && lines.size() >= 3) {
                String line3 = lines.get(2); // the line may be interested in
                tok = new StringTokenizer(line3, " ");
            } else {
                throw new IOException(
                        "Command line '" + DF + "' did not return data as expected " +
                        "for path '" + path + "'- check path is valid");
            }
        } else {
            tok.nextToken(); // Ignore Filesystem
        }
        tok.nextToken(); // Ignore 1K-blocks
        tok.nextToken(); // Ignore Used
        String freeSpace = tok.nextToken();
        return parseBytes(freeSpace, path);
    }

    //-----------------------------------------------------------------------
    /**
     * Parses the bytes from a string.
     * 
     * @param freeSpace  the free space string
     * @param path  the path
     * @return the number of bytes
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.420 -0400", hash_original_method = "9B456979926FBEBDCE0D7990B1D4EAD2", hash_generated_method = "9B456979926FBEBDCE0D7990B1D4EAD2")
    
long parseBytes(String freeSpace, String path) throws IOException {
        try {
            long bytes = Long.parseLong(freeSpace);
            if (bytes < 0) {
                throw new IOException(
                        "Command line '" + DF + "' did not find free space in response " +
                        "for path '" + path + "'- check path is valid");
            }
            return bytes;
            
        } catch (NumberFormatException ex) {
            throw new IOExceptionWithCause(
                    "Command line '" + DF + "' did not return numeric data as expected " +
                    "for path '" + path + "'- check path is valid", ex);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Performs the os command.
     *
     * @param cmdAttribs  the command line parameters
     * @param max The maximum limit for the lines returned
     * @param timeout The timout amount in milliseconds or no timeout if the value
     *  is zero or less
     * @return the parsed data
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.422 -0400", hash_original_method = "33C4C2C18C24F6A9AB6F6705D1C4986B", hash_generated_method = "F21A2971278C3B7FBBB3A74CBAFEF3A2")
    
List<String> performCommand(String[] cmdAttribs, int max, long timeout) throws IOException {
        // this method does what it can to avoid the 'Too many open files' error
        // based on trial and error and these links:
        // http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4784692
        // http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4801027
        // http://forum.java.sun.com/thread.jspa?threadID=533029&messageID=2572018
        // however, its still not perfect as the JDK support is so poor
        // (see commond-exec or ant for a better multi-threaded multi-os solution)
        
        List<String> lines = new ArrayList<String>(20);
        Process proc = null;
        InputStream in = null;
        OutputStream out = null;
        InputStream err = null;
        BufferedReader inr = null;
        try {

            Thread monitor = ThreadMonitor.start(timeout);

            proc = openProcess(cmdAttribs);
            in = proc.getInputStream();
            out = proc.getOutputStream();
            err = proc.getErrorStream();
            inr = new BufferedReader(new InputStreamReader(in));
            String line = inr.readLine();
            while (line != null && lines.size() < max) {
                line = line.toLowerCase(Locale.ENGLISH).trim();
                lines.add(line);
                line = inr.readLine();
            }
            
            proc.waitFor();

            ThreadMonitor.stop(monitor);

            if (proc.exitValue() != 0) {
                // os command problem, throw exception
                throw new IOException(
                        "Command line returned OS error code '" + proc.exitValue() +
                        "' for command " + Arrays.asList(cmdAttribs));
            }
            if (lines.isEmpty()) {
                // unknown problem, throw exception
                throw new IOException(
                        "Command line did not return any info " +
                        "for command " + Arrays.asList(cmdAttribs));
            }
            return lines;
            
        } catch (InterruptedException ex) {
            throw new IOExceptionWithCause(
                    "Command line threw an InterruptedException " +
                    "for command " + Arrays.asList(cmdAttribs) + " timeout=" + timeout, ex);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(err);
            IOUtils.closeQuietly(inr);
            if (proc != null) {
                proc.destroy();
            }
        }
    }

    /**
     * Opens the process to the operating system.
     *
     * @param cmdAttribs  the command line parameters
     * @return the process
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:56.423 -0400", hash_original_method = "7DECE044380D73BAC819BD07020B1534", hash_generated_method = "7DECE044380D73BAC819BD07020B1534")
    
Process openProcess(String[] cmdAttribs) throws IOException {
        return Runtime.getRuntime().exec(cmdAttribs);
    }

}
