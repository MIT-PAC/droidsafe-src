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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.ESPIPE;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.SEEK_CUR;

import java.nio.NioUtils;
import java.nio.channels.FileChannel;

import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.Streams;
import dalvik.system.CloseGuard;

public class FileInputStream extends InputStream implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.101 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.103 -0500", hash_original_field = "58BD5E983B42D5DA1EAF3358ED6D6916", hash_generated_field = "84D2D8F04948CA1C168D3A3584462F87")

    private  boolean shouldClose;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.106 -0500", hash_original_field = "606E91E177C017AB22115E5BAB9B1D1A", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.108 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    /**
     * Constructs a new {@code FileInputStream} that reads from {@code file}.
     *
     * @param file
     *            the file from which this stream reads.
     * @throws FileNotFoundException
     *             if {@code file} does not exist.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.110 -0500", hash_original_method = "1BD49D518996D312C80F5CC2297619D7", hash_generated_method = "B658BDC677171B3FEE9047C0F1943C54")
    
public FileInputStream(File file) throws FileNotFoundException {
   /*     if (file == null) {
            throw new NullPointerException("file == null");
        }
        this.fd = IoBridge.open(file.getAbsolutePath(), O_RDONLY);
        this.shouldClose = true;
        guard.open("close");*/
        addTaint(file.getTaint());
    }

    /**
     * Constructs a new {@code FileInputStream} that reads from {@code fd}.
     *
     * @param fd
     *            the FileDescriptor from which this stream reads.
     * @throws NullPointerException
     *             if {@code fd} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.113 -0500", hash_original_method = "9A99F3F0C17344BC7A4198604236E89C", hash_generated_method = "6FFB9E5503B5FFEBF02470C9DA7622BF")
    
public FileInputStream(FileDescriptor fd) {
        if (fd == null) {
            throw new NullPointerException("fd == null");
        }
        addTaint(fd.getTaint());
        this.fd = fd;
        this.shouldClose = false;
        // Note that we do not call guard.open here because the
        // FileDescriptor is not owned by the stream.
    }

    /**
     * Equivalent to {@code new FileInputStream(new File(path))}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.116 -0500", hash_original_method = "3B135756B4C06BFF0359EE9E41EEDC20", hash_generated_method = "A45CB9BBA620FFB20A4C2B7E074F5E66")
    
public FileInputStream(String path) throws FileNotFoundException {
        this(new File(path));
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public FileInputStream(DSOnlyType dontcare) {
    }

    @DSComment("File Input Stream")
    @DSSafe(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.119 -0500", hash_original_method = "EBD7B964937B6AA7FA3657DA1AAC30BC", hash_generated_method = "ADA0D7075AE3399605E425074EC4F63B")
    
@Override
    public int available() throws IOException {
        //return IoBridge.available(fd);
        return droidsafeAvailable();
    }

    @DSComment("File Input Stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.122 -0500", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "0DF0B8874963515CB2F09EA5F083FA85")
    
@Override
    public void close() throws IOException {
        /*guard.close();
        synchronized (this) {
            if (channel != null) {
                channel.close();
            }
            if (shouldClose) {
                IoUtils.close(fd);
            } else {
                // An owned fd has been invalidated by IoUtils.close, but
                // we need to explicitly stop using an unowned fd (http://b/4361076).
                fd = new FileDescriptor();
            }
        }*/
    }

    /**
     * Ensures that all resources for this stream are released when it is about
     * to be garbage collected.
     *
     * @throws IOException
     *             if an error occurs attempting to finalize this stream.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.124 -0500", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "D1DCB3056D2414B4C27AA873251B546E")
    
@Override protected void finalize() throws IOException {
       /* try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            close();
        } finally {
            try {
                super.finalize();
            } catch (Throwable t) {
                // for consistency with the RI, we must override Object.finalize() to
                // remove the 'throws Throwable' clause.
                throw new AssertionError(t);
            }
        }*/
    }

    /**
     * Returns a read-only {@link FileChannel} that shares its position with
     * this stream.
     */
    
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.127 -0500", hash_original_method = "BB4E25A77FBA5E31003F6019B5643EE2", hash_generated_method = "2FB2F921FF08661F63F300CEEF489872")
    
public FileChannel getChannel() {
        synchronized (this) {
            if (channel == null) {
                channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            }
            return channel;
        }
    }

    /**
     * Returns the underlying file descriptor.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.129 -0500", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "BF99A80A25EF13693DBEFA2A53118A0A")
    
public final FileDescriptor getFD() throws IOException {
        return fd;
    }

    @DSSource({DSSourceKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.132 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "259E44B8B64C1FF49A2A2EC42CFB5CBE")
    
@Override public int read() throws IOException {
        //return Streams.readSingleByte(this);
        return droidsafeRead();
    }

    @DSSource({DSSourceKind.IO})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.135 -0500", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "E85E2815A9A684302F2788213CC7C71B")
    
@Override public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
        return super.read(buffer, byteOffset, byteCount);
    }

    @DSComment("File Input Stream")
    @DSSafe(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.137 -0500", hash_original_method = "4138A4F75DA401A9AB2AB0F0CF384113", hash_generated_method = "E06C26822D1847D5403C294FF6E5D395")
    
@Override
    public long skip(long byteCount) throws IOException {
        /*if (byteCount < 0) {
            throw new IOException("byteCount < 0: " + byteCount);
        }
        try {
            // Try lseek(2). That returns the new offset, but we'll throw an
            // exception if it couldn't perform exactly the seek we asked for.
            Libcore.os.lseek(fd, byteCount, SEEK_CUR);
            return byteCount;
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == ESPIPE) {
                // You can't seek on a pipe, so fall back to the superclass' implementation.
                return super.skip(byteCount);
            }
            throw errnoException.rethrowAsIOException();
        }*/
        addTaint(byteCount);
        return getTaintLong();
    }
    
}

