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
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * FileWriter that will create and honor lock files to allow simple
 * cross thread file lock handling.
 * <p>
 * This class provides a simple alternative to <code>FileWriter</code>
 * that will use a lock file to prevent duplicate writes.
 * <p>
 * <b>N.B.</b> the lock file is deleted when {@link #close()} is called
 * - or if the main file cannot be opened initially.
 * In the (unlikely) event that the lockfile cannot be deleted, 
 * this is not reported, and subsequent requests using
 * the same lockfile will fail.
 * <p>
 * By default, the file will be overwritten, but this may be changed to append.
 * The lock directory may be specified, but defaults to the system property
 * <code>java.io.tmpdir</code>.
 * The encoding may also be specified, and defaults to the platform default.
 *
 * @version $Id: LockableFileWriter.java 1347574 2012-06-07 11:20:39Z sebb $
 */
public class LockableFileWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.197 -0400", hash_original_field = "D805C14B284996FBAD805FEA1E64A96E", hash_generated_field = "F8BD6012803F4F96E05A05FFD02E75B3")

    // known when super() is called

    /** The extension for the lock file. */
    private static final String LCK = ".lck";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.198 -0400", hash_original_field = "EBCE22DD0E30FF0E4040ABB2E7F29C97", hash_generated_field = "0251D9C19BD1379B95D6A9A5D4A8C80D")

    private  Writer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.199 -0400", hash_original_field = "9F5A4BB1DED327A0B956C3FE8363C634", hash_generated_field = "AC90E37DC00D195823505C62C62EC14B")

    private  File lockFile;

    /**
     * Constructs a LockableFileWriter.
     * If the file exists, it is overwritten.
     *
     * @param fileName  the file to write to, not null
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.200 -0400", hash_original_method = "E4DF2692D09657C937667960DF2A3C67", hash_generated_method = "C9CAC4A74FFB71E8D02E271FD0FD1900")
    
public LockableFileWriter(String fileName) throws IOException {
        this(fileName, false, null);
    }

    /**
     * Constructs a LockableFileWriter.
     *
     * @param fileName  file to write to, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.200 -0400", hash_original_method = "FC93D084C129233C65899CC07B40F7F6", hash_generated_method = "A7160D8EBDF0300F5521F7DDE1FA928A")
    
public LockableFileWriter(String fileName, boolean append) throws IOException {
        this(fileName, append, null);
    }

    /**
     * Constructs a LockableFileWriter.
     *
     * @param fileName  the file to write to, not null
     * @param append  true if content should be appended, false to overwrite
     * @param lockDir  the directory in which the lock file should be held
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.201 -0400", hash_original_method = "B7233EF33CE1581A472B9379DD0E229A", hash_generated_method = "FBDACD334E4F67A4E4971FE6304D9050")
    
public LockableFileWriter(String fileName, boolean append, String lockDir) throws IOException {
        this(new File(fileName), append, lockDir);
    }

    /**
     * Constructs a LockableFileWriter.
     * If the file exists, it is overwritten.
     *
     * @param file  the file to write to, not null
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.201 -0400", hash_original_method = "6ED4CA4A5697FDAC39D30ACE5ED4B1F3", hash_generated_method = "1DF065C3FE4B389B4DE429CB66411112")
    
public LockableFileWriter(File file) throws IOException {
        this(file, false, null);
    }

    /**
     * Constructs a LockableFileWriter.
     *
     * @param file  the file to write to, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.202 -0400", hash_original_method = "4EF9EE3D70949EF568D3A2DBCC1401FD", hash_generated_method = "AAD85570F2499962FDE019677025A7FB")
    
public LockableFileWriter(File file, boolean append) throws IOException {
        this(file, append, null);
    }

    /**
     * Constructs a LockableFileWriter.
     *
     * @param file  the file to write to, not null
     * @param append  true if content should be appended, false to overwrite
     * @param lockDir  the directory in which the lock file should be held
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.202 -0400", hash_original_method = "E6D05E7A8E7A53A0497829DD15335921", hash_generated_method = "F908A4CDEFE38FCEB9EC84DBE28F2C05")
    
public LockableFileWriter(File file, boolean append, String lockDir) throws IOException {
        this(file, Charset.defaultCharset(), append, lockDir);
    }

    /**
     * Constructs a LockableFileWriter with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, null means platform default
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     * @since 2.3
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.203 -0400", hash_original_method = "70DFCFEBCCB528E3905963CAD4603A5C", hash_generated_method = "42EA5C8AAAFF1F3AB5CACEB7AC4E580A")
    
public LockableFileWriter(File file, Charset encoding) throws IOException {
        this(file, encoding, false, null);
    }

    /**
     * Constructs a LockableFileWriter with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, null means platform default
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     * @throws UnsupportedCharsetException
     *             thrown instead of {@link UnsupportedEncodingException} in version 2.2 if the encoding is not
     *             supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.203 -0400", hash_original_method = "51199DDDF4151039B212F3260E0B0706", hash_generated_method = "DE7AD0E6623CC0642C95B9F1FB992791")
    
public LockableFileWriter(File file, String encoding) throws IOException {
        this(file, encoding, false, null);
    }

    /**
     * Constructs a LockableFileWriter with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, null means platform default
     * @param append  true if content should be appended, false to overwrite
     * @param lockDir  the directory in which the lock file should be held
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     * @since 2.3
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.204 -0400", hash_original_method = "44AD202744E75D3A75FDD22C341BBAC5", hash_generated_method = "8FA66FB42ADD23257C58DADD7E309985")
    
public LockableFileWriter(File file, Charset encoding, boolean append,
            String lockDir) throws IOException {
        super();
        // init file to create/append
        file = file.getAbsoluteFile();
        if (file.getParentFile() != null) {
            FileUtils.forceMkdir(file.getParentFile());
        }
        if (file.isDirectory()) {
            throw new IOException("File specified is a directory");
        }
        
        // init lock file
        if (lockDir == null) {
            lockDir = System.getProperty("java.io.tmpdir");
        }
        File lockDirFile = new File(lockDir);
        FileUtils.forceMkdir(lockDirFile);
        testLockDir(lockDirFile);
        lockFile = new File(lockDirFile, file.getName() + LCK);
        
        // check if locked
        createLock();
        
        // init wrapped writer
        out = initWriter(file, encoding, append);
    }

    /**
     * Constructs a LockableFileWriter with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, null means platform default
     * @param append  true if content should be appended, false to overwrite
     * @param lockDir  the directory in which the lock file should be held
     * @throws NullPointerException if the file is null
     * @throws IOException in case of an I/O error
     * @throws UnsupportedCharsetException
     *             thrown instead of {@link UnsupportedEncodingException} in version 2.2 if the encoding is not
     *             supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.205 -0400", hash_original_method = "7CC795373BAAA161D6C74B697A2C20C3", hash_generated_method = "A16FA759FDFFBE5E34A3BB7282B982DE")
    
public LockableFileWriter(File file, String encoding, boolean append,
            String lockDir) throws IOException {
        this(file, Charsets.toCharset(encoding), append, lockDir);
    }

    //-----------------------------------------------------------------------
    /**
     * Tests that we can write to the lock directory.
     *
     * @param lockDir  the File representing the lock directory
     * @throws IOException if we cannot write to the lock directory
     * @throws IOException if we cannot find the lock file
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.206 -0400", hash_original_method = "8D77B36F2D36A74D4D1D738F1EFBDA2C", hash_generated_method = "4620A2CDFB3A98C06BE97E0FD7C340C9")
    
private void testLockDir(File lockDir) throws IOException {
        if (!lockDir.exists()) {
            throw new IOException(
                    "Could not find lockDir: " + lockDir.getAbsolutePath());
        }
        if (!lockDir.canWrite()) {
            throw new IOException(
                    "Could not write to lockDir: " + lockDir.getAbsolutePath());
        }
    }

    /**
     * Creates the lock file.
     *
     * @throws IOException if we cannot create the file
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.206 -0400", hash_original_method = "17CDBB829EF4B0C5B4419966B6F98CAD", hash_generated_method = "B2C0A16B9210CECCBFAD8AF862BFDD23")
    
private void createLock() throws IOException {
        synchronized (LockableFileWriter.class) {
            if (!lockFile.createNewFile()) {
                throw new IOException("Can't write file, lock " +
                        lockFile.getAbsolutePath() + " exists");
            }
            lockFile.deleteOnExit();
        }
    }

    /**
     * Initialise the wrapped file writer.
     * Ensure that a cleanup occurs if the writer creation fails.
     *
     * @param file  the file to be accessed
     * @param encoding  the encoding to use
     * @param append  true to append
     * @return The initialised writer
     * @throws IOException if an error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.207 -0400", hash_original_method = "9026BE33E3D40906CA316E83E271B1B8", hash_generated_method = "CFB1D0EEE0FAD6485D92FB638ECDBAE6")
    
private Writer initWriter(File file, Charset encoding, boolean append) throws IOException {
        boolean fileExistedAlready = file.exists();
        OutputStream stream = null;
        Writer writer = null;
        try {
            stream = new FileOutputStream(file.getAbsolutePath(), append);
            writer = new OutputStreamWriter(stream, Charsets.toCharset(encoding));
        } catch (IOException ex) {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            FileUtils.deleteQuietly(lockFile);
            if (fileExistedAlready == false) {
                FileUtils.deleteQuietly(file);
            }
            throw ex;
        } catch (RuntimeException ex) {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            FileUtils.deleteQuietly(lockFile);
            if (fileExistedAlready == false) {
                FileUtils.deleteQuietly(file);
            }
            throw ex;
        }
        return writer;
    }

    //-----------------------------------------------------------------------
    /**
     * Closes the file writer and deletes the lockfile (if possible).
     *
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.208 -0400", hash_original_method = "C9C28C6746F703FA832F2D42517AD4AE", hash_generated_method = "E4489D78CDBD00142F0F3684C9949816")
    
@Override
    public void close() throws IOException {
        try {
            out.close();
        } finally {
            lockFile.delete();
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Write a character.
     * @param idx the character to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.208 -0400", hash_original_method = "EE30809419C042C9133DA321A16F7DFD", hash_generated_method = "108A0CC68AF0F1C128B1F7C2EFE7950F")
    
@Override
    public void write(int idx) throws IOException {
        out.write(idx);
    }

    /**
     * Write the characters from an array.
     * @param chr the characters to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.209 -0400", hash_original_method = "46EC5EF747261262EAD8ED1BD4879967", hash_generated_method = "2CB0A7EEA30A4F8FDF3B216777E92993")
    
@Override
    public void write(char[] chr) throws IOException {
        out.write(chr);
    }

    /**
     * Write the specified characters from an array.
     * @param chr the characters to write
     * @param st The start offset
     * @param end The number of characters to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.209 -0400", hash_original_method = "4007BD37B56F652F2DD863D7816336D0", hash_generated_method = "2024B0D60D55840B17528B87EB493ED5")
    
@Override
    public void write(char[] chr, int st, int end) throws IOException {
        out.write(chr, st, end);
    }

    /**
     * Write the characters from a string.
     * @param str the string to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.210 -0400", hash_original_method = "570C1378326063600110CB3D156C7691", hash_generated_method = "11531F2C7D6991750845B0705120981E")
    
@Override
    public void write(String str) throws IOException {
        out.write(str);
    }

    /**
     * Write the specified characters from a string.
     * @param str the string to write
     * @param st The start offset
     * @param end The number of characters to write
     * @throws IOException if an I/O error occurs
     */
    @DSSink({DSSinkKind.FILE})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.210 -0400", hash_original_method = "694B238FF5AB1AB4441171CB6DC98A7A", hash_generated_method = "BD1C54C575DC051B66557980241D013D")
    
@Override
    public void write(String str, int st, int end) throws IOException {
        out.write(str, st, end);
    }

    /**
     * Flush the stream.
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.211 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "5CE80A6225762CA51E516040755CB8E9")
    
@Override
    public void flush() throws IOException {
        out.flush();
    }

}
