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
package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * A decorating input stream that counts the number of bytes that have passed
 * through the stream so far.
 * <p>
 * A typical use case would be during debugging, to ensure that data is being
 * read as expected.
 *
 * @version $Id: CountingInputStream.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public class CountingInputStream extends ProxyInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.735 -0400", hash_original_field = "D14481EA9CDAD366F91417FC5AF5E134", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

    private long count;

    /**
     * Constructs a new CountingInputStream.
     *
     * @param in  the InputStream to delegate to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.736 -0400", hash_original_method = "F0667AD48C8EC6D7BA0EADD31D490B3C", hash_generated_method = "7341911836A1026854834701FA6BF03F")
    
public CountingInputStream(InputStream in) {
        super(in);
    }

    //-----------------------------------------------------------------------

    /**
     * Skips the stream over the specified number of bytes, adding the skipped
     * amount to the count.
     *
     * @param length  the number of bytes to skip
     * @return the actual number of bytes skipped
     * @throws IOException if an I/O error occurs
     * @see java.io.InputStream#skip(long)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.736 -0400", hash_original_method = "132500B6DBD3ECFEDBE720096796962F", hash_generated_method = "BD0A7FA2DE3D20C4B8C67471E576A5F6")
    
@Override
    public synchronized long skip(final long length) throws IOException {
        final long skip = super.skip(length);
        this.count += skip;
        return skip;
    }

    /**
     * Adds the number of read bytes to the count.
     *
     * @param n number of bytes read, or -1 if no more bytes are available
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.737 -0400", hash_original_method = "90EDC96C8584B0F7C76A1BA2408C4520", hash_generated_method = "EB18E9706549C82526146922C7D5B933")
    
@Override
    protected synchronized void afterRead(int n) {
        if (n != -1) {
            this.count += n;
        }
    }

    //-----------------------------------------------------------------------
    /**
     * The number of bytes that have passed through this stream.
     * <p>
     * NOTE: From v1.3 this method throws an ArithmeticException if the
     * count is greater than can be expressed by an <code>int</code>.
     * See {@link #getByteCount()} for a method using a <code>long</code>.
     *
     * @return the number of bytes accumulated
     * @throws ArithmeticException if the byte count is too large
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.738 -0400", hash_original_method = "C00FD02DE13770738E0B8BA4159C30F2", hash_generated_method = "430987FA62A0966875A62EFB32902E5F")
    
public int getCount() {
        long result = getByteCount();
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        }
        return (int) result;
    }

    /** 
     * Set the byte count back to 0. 
     * <p>
     * NOTE: From v1.3 this method throws an ArithmeticException if the
     * count is greater than can be expressed by an <code>int</code>.
     * See {@link #resetByteCount()} for a method using a <code>long</code>.
     *
     * @return the count previous to resetting
     * @throws ArithmeticException if the byte count is too large
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.738 -0400", hash_original_method = "F5B53F118A4CD127E2B80EC107F6232B", hash_generated_method = "0A6F5852DC9260AFE190B76FC54E6E94")
    
public int resetCount() {
        long result = resetByteCount();
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("The byte count " + result + " is too large to be converted to an int");
        }
        return (int) result;
    }

    /**
     * The number of bytes that have passed through this stream.
     * <p>
     * NOTE: This method is an alternative for <code>getCount()</code>
     * and was added because that method returns an integer which will
     * result in incorrect count for files over 2GB.
     *
     * @return the number of bytes accumulated
     * @since 1.3
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.739 -0400", hash_original_method = "D4B641936093CD491A905A89AC9170C1", hash_generated_method = "0B2C938D13BA6DA3FD429D302C917749")
    
public synchronized long getByteCount() {
        return this.count;
    }

    /** 
     * Set the byte count back to 0. 
     * <p>
     * NOTE: This method is an alternative for <code>resetCount()</code>
     * and was added because that method returns an integer which will
     * result in incorrect count for files over 2GB.
     *
     * @return the count previous to resetting
     * @since 1.3
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.740 -0400", hash_original_method = "B4FA3AE06204AB7289DB84225F541AF1", hash_generated_method = "ADC309CA8828389521AD207F87DEF6F3")
    
public synchronized long resetByteCount() {
        long tmp = this.count;
        this.count = 0;
        return tmp;
    }

}
