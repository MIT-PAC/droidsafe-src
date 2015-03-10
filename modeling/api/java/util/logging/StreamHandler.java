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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.logging;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * A {@code StreamHandler} object writes log messages to an output stream, that
 * is, objects of the class {@link java.io.OutputStream}.
 * <p>
 * A {@code StreamHandler} object reads the following properties from the log
 * manager to initialize itself. A default value will be used if a property is
 * not found or has an invalid value.
 * <ul>
 * <li>java.util.logging.StreamHandler.encoding specifies the encoding this
 * handler will use to encode log messages. Default is the encoding used by the
 * current platform.
 * <li>java.util.logging.StreamHandler.filter specifies the name of the filter
 * class to be associated with this handler. No <code>Filter</code> is used by
 * default.
 * <li>java.util.logging.StreamHandler.formatter specifies the name of the
 * formatter class to be associated with this handler. Default is
 * {@code java.util.logging.SimpleFormatter}.
 * <li>java.util.logging.StreamHandler.level specifies the logging level.
 * Defaults is {@code Level.INFO}.
 * </ul>
 * <p>
 * This class is not thread-safe.
 */
public class StreamHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.026 -0400", hash_original_field = "6516E64974FF88B82386745392C5E14B", hash_generated_field = "BFEC39E15FADDFA148ED8D3CE22EABA4")

    private OutputStream os;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.026 -0400", hash_original_field = "2893095D821727F8868345026D6906A1", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.027 -0400", hash_original_field = "D7E8DBF0D5880A27907E4256003C29E1", hash_generated_field = "D8A65C094302856DEAF9B055EB9E95B4")

    private boolean writerNotInitialized;

    /**
     * Constructs a {@code StreamHandler} object. The new stream handler
     * does not have an associated output stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.027 -0400", hash_original_method = "2429E8119F0D198DDD5626A2FF6BA8A9", hash_generated_method = "0CAF3C1C53F5DFC0F71E61FB6A80C260")
    
public StreamHandler() {
        initProperties("INFO", null, "java.util.logging.SimpleFormatter", null);
        this.os = null;
        this.writer = null;
        this.writerNotInitialized = true;
    }

    /**
     * Constructs a {@code StreamHandler} object with the supplied output
     * stream. Default properties are read.
     *
     * @param os
     *            the output stream this handler writes to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.027 -0400", hash_original_method = "7A1D97CB8599BBD4B5FC932E4F94087D", hash_generated_method = "7A1D97CB8599BBD4B5FC932E4F94087D")
    
StreamHandler(OutputStream os) {
        this();
        this.os = os;
    }

    /**
     * Constructs a {@code StreamHandler} object. The specified default values
     * will be used if the corresponding properties are not found in the log
     * manager's properties.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.028 -0400", hash_original_method = "ED192AD4A486B0F2EBE2F52D766908EA", hash_generated_method = "ED192AD4A486B0F2EBE2F52D766908EA")
    
StreamHandler(String defaultLevel, String defaultFilter,
            String defaultFormatter, String defaultEncoding) {
        initProperties(defaultLevel, defaultFilter, defaultFormatter,
                defaultEncoding);
        this.os = null;
        this.writer = null;
        this.writerNotInitialized = true;
    }

    /**
     * Constructs a {@code StreamHandler} object with the supplied output stream
     * and formatter.
     *
     * @param os
     *            the output stream this handler writes to.
     * @param formatter
     *            the formatter this handler uses to format the output.
     * @throws NullPointerException
     *             if {@code os} or {@code formatter} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.028 -0400", hash_original_method = "DF11AC6D9876850E03E3A4E3585BD0E9", hash_generated_method = "8F0A20EF195DB9B6A7DC13D3246AEB2D")
    
public StreamHandler(OutputStream os, Formatter formatter) {
        this();
        if (os == null) {
            throw new NullPointerException("os == null");
        }
        if (formatter == null) {
            throw new NullPointerException("formatter == null");
        }
        this.os = os;
        internalSetFormatter(formatter);
    }

    // initialize the writer
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.029 -0400", hash_original_method = "DF74EC0900BC1C4278ABA1D3B511E38D", hash_generated_method = "D82702F7BF1CD4D36E830048E80E49D0")
    
private void initializeWriter() {
        this.writerNotInitialized = false;
        if (getEncoding() == null) {
            this.writer = new OutputStreamWriter(this.os);
        } else {
            try {
                this.writer = new OutputStreamWriter(this.os, getEncoding());
            } catch (UnsupportedEncodingException e) {
                /*
                 * Should not happen because it's checked in
                 * super.initProperties().
                 */
            }
        }
        write(getFormatter().getHead(this));
    }

    // Write a string to the output stream.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.029 -0400", hash_original_method = "042FE52C24B074211C3D40C8929F5945", hash_generated_method = "49E9B6834AFFDC8A143C3B2E2B99DE51")
    
private void write(String s) {
        try {
            this.writer.write(s);
        } catch (Exception e) {
            getErrorManager().error("Exception occurred when writing to the output stream", e,
                    ErrorManager.WRITE_FAILURE);
        }
    }

    /**
     * Sets the output stream this handler writes to. Note it does nothing else.
     *
     * @param newOs
     *            the new output stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.030 -0400", hash_original_method = "2051B5906EFEBE63267D8445598B8C2A", hash_generated_method = "2051B5906EFEBE63267D8445598B8C2A")
    
void internalSetOutputStream(OutputStream newOs) {
        this.os = newOs;
    }

    /**
     * Sets the output stream this handler writes to. If there's an existing
     * output stream, the tail string of the associated formatter will be
     * written to it. Then it will be flushed, closed and replaced with
     * {@code os}.
     *
     * @param os
     *            the new output stream.
     * @throws NullPointerException
     *             if {@code os} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.030 -0400", hash_original_method = "C14B6833BD884D9CA83BBE80AA1935F4", hash_generated_method = "526A89954B3384A8880AA35FD9713D6D")
    
protected void setOutputStream(OutputStream os) {
        if (os == null) {
            throw new NullPointerException("os == null");
        }
        LogManager.getLogManager().checkAccess();
        close(true);
        this.writer = null;
        this.os = os;
        this.writerNotInitialized = true;
    }

    /**
     * Sets the character encoding used by this handler. A {@code null} value
     * indicates that the default encoding should be used.
     *
     * @throws UnsupportedEncodingException if {@code charsetName} is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.031 -0400", hash_original_method = "78CC87D49DE2F3A8CDA2E4EC1D9A8D9F", hash_generated_method = "38FB8B0573DECBC644FFB610D9BDF930")
    
@Override
    public void setEncoding(String charsetName) throws UnsupportedEncodingException {
        // Flush any existing data first.
        this.flush();
        super.setEncoding(charsetName);
        // renew writer only if the writer exists
        if (this.writer != null) {
            if (getEncoding() == null) {
                this.writer = new OutputStreamWriter(this.os);
            } else {
                try {
                    this.writer = new OutputStreamWriter(this.os, getEncoding());
                } catch (UnsupportedEncodingException e) {
                    /*
                     * Should not happen because it's checked in
                     * super.initProperties().
                     */
                    throw new AssertionError(e);
                }
            }
        }
    }

    /**
     * Closes this handler, but the underlying output stream is only closed if
     * {@code closeStream} is {@code true}. Security is not checked.
     *
     * @param closeStream
     *            whether to close the underlying output stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.031 -0400", hash_original_method = "D11EF6CCEAC35155740FFC5F71AEECF6", hash_generated_method = "D11EF6CCEAC35155740FFC5F71AEECF6")
    
void close(boolean closeStream) {
        if (this.os != null) {
            if (this.writerNotInitialized) {
                initializeWriter();
            }
            write(getFormatter().getTail(this));
            try {
                this.writer.flush();
                if (closeStream) {
                    this.writer.close();
                    this.writer = null;
                    this.os = null;
                }
            } catch (Exception e) {
                getErrorManager().error("Exception occurred when closing the output stream", e,
                        ErrorManager.CLOSE_FAILURE);
            }
        }
    }

    /**
     * Closes this handler. The tail string of the formatter associated with
     * this handler is written out. A flush operation and a subsequent close
     * operation is then performed upon the output stream. Client applications
     * should not use a handler after closing it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.032 -0400", hash_original_method = "A84AA1CA81AD20017BBC601763D2C567", hash_generated_method = "ABF3F14F4312B496F2A647148A8C95FE")
    
@Override
    public void close() {
        LogManager.getLogManager().checkAccess();
        close(true);
    }

    /**
     * Flushes any buffered output.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.032 -0400", hash_original_method = "27C4960199EA96FF5815C63B3264D107", hash_generated_method = "FDC56AD90C69FF26B7A4600FDFE5832B")
    
@Override
    public void flush() {
        if (this.os != null) {
            try {
                if (this.writer != null) {
                    this.writer.flush();
                } else {
                    this.os.flush();
                }
            } catch (Exception e) {
                getErrorManager().error("Exception occurred when flushing the output stream",
                        e, ErrorManager.FLUSH_FAILURE);
            }
        }
    }

    /**
     * Accepts a logging request. The log record is formatted and written to the
     * output stream if the following three conditions are met:
     * <ul>
     * <li>the supplied log record has at least the required logging level;
     * <li>the supplied log record passes the filter associated with this
     * handler, if any;
     * <li>the output stream associated with this handler is not {@code null}.
     * </ul>
     * If it is the first time a log record is written out, the head string of
     * the formatter associated with this handler is written out first.
     *
     * @param record
     *            the log record to be logged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.033 -0400", hash_original_method = "D2FE1318C33F8DED0F2D5CFFB72E13E5", hash_generated_method = "8D863563F4A4E360A0EE896BB5F6E3A8")
    
@Override
    public synchronized void publish(LogRecord record) {
        try {
            if (this.isLoggable(record)) {
                if (this.writerNotInitialized) {
                    initializeWriter();
                }
                String msg = null;
                try {
                    msg = getFormatter().format(record);
                } catch (Exception e) {
                    getErrorManager().error("Exception occurred when formatting the log record",
                            e, ErrorManager.FORMAT_FAILURE);
                }
                write(msg);
            }
        } catch (Exception e) {
            getErrorManager().error("Exception occurred when logging the record", e,
                    ErrorManager.GENERIC_FAILURE);
        }
    }

    /**
     * Determines whether the supplied log record needs to be logged. The
     * logging levels are checked as well as the filter. The output stream of
     * this handler is also checked. If it is {@code null}, this method returns
     * {@code false}.
     * <p>
     * Notice : Case of no output stream will return {@code false}.
     *
     * @param record
     *            the log record to be checked.
     * @return {@code true} if {@code record} needs to be logged, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.034 -0400", hash_original_method = "FEE50185861CB87DE3673131B11C74D1", hash_generated_method = "28E9D585FF791398B0553635AFF2FDEA")
    
@Override
    public boolean isLoggable(LogRecord record) {
        if (record == null) {
            return false;
        }
        if (this.os != null && super.isLoggable(record)) {
            return true;
        }
        return false;
    }
}
