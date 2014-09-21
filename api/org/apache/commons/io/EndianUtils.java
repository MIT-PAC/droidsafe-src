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
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Utility code for dealing with different endian systems.
 * <p>
 * Different computer architectures adopt different conventions for
 * byte ordering. In so-called "Little Endian" architectures (eg Intel),
 * the low-order byte is stored in memory at the lowest address, and
 * subsequent bytes at higher addresses. For "Big Endian" architectures
 * (eg Motorola), the situation is reversed.
 * This class helps you solve this incompatability.
 * <p>
 * Origin of code: Excalibur
 *
 * @version $Id: EndianUtils.java 1302056 2012-03-18 03:03:38Z ggregory $
 * @see org.apache.commons.io.input.SwappedDataInputStream
 */
public class EndianUtils {

    // ========================================== Swapping routines

    /**
     * Converts a "short" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.403 -0400", hash_original_method = "4E469C45AD70E4716E0D37D29FDC47F3", hash_generated_method = "A005D34A97B1CA136B8FF5C7DD161832")
    
public static short swapShort(short value) {
        return (short) ( ( ( ( value >> 0 ) & 0xff ) << 8 ) +
            ( ( ( value >> 8 ) & 0xff ) << 0 ) );
    }

    /**
     * Converts a "int" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.403 -0400", hash_original_method = "6E266F7886D6B5A2425ED73C34F43FE1", hash_generated_method = "96052107A34B7CD5A389B5F1DF090657")
    
public static int swapInteger(int value) {
        return
            ( ( ( value >> 0 ) & 0xff ) << 24 ) +
            ( ( ( value >> 8 ) & 0xff ) << 16 ) +
            ( ( ( value >> 16 ) & 0xff ) << 8 ) +
            ( ( ( value >> 24 ) & 0xff ) << 0 );
    }

    /**
     * Converts a "long" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.404 -0400", hash_original_method = "62386991685EFA23920441655B819944", hash_generated_method = "5BBB9FC117A95CDC8E04F751688B781F")
    
public static long swapLong(long value) {
        return
            ( ( ( value >> 0 ) & 0xff ) << 56 ) +
            ( ( ( value >> 8 ) & 0xff ) << 48 ) +
            ( ( ( value >> 16 ) & 0xff ) << 40 ) +
            ( ( ( value >> 24 ) & 0xff ) << 32 ) +
            ( ( ( value >> 32 ) & 0xff ) << 24 ) +
            ( ( ( value >> 40 ) & 0xff ) << 16 ) +
            ( ( ( value >> 48 ) & 0xff ) << 8 ) +
            ( ( ( value >> 56 ) & 0xff ) << 0 );
    }

    /**
     * Converts a "float" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.404 -0400", hash_original_method = "EBD3AE305BBE8ACEE25AF0014FD6CB2C", hash_generated_method = "435068850F62FAE0A1527107415332CF")
    
public static float swapFloat(float value) {
        return Float.intBitsToFloat( swapInteger( Float.floatToIntBits( value ) ) );
    }

    /**
     * Converts a "double" value between endian systems.
     * @param value value to convert
     * @return the converted value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.406 -0400", hash_original_method = "AB85C83155191F24DD5BC1E499AE0545", hash_generated_method = "CEB4A3A30D6617C5F33591A887E0825C")
    
public static double swapDouble(double value) {
        return Double.longBitsToDouble( swapLong( Double.doubleToLongBits( value ) ) );
    }

    // ========================================== Swapping read/write routines

    /**
     * Writes a "short" value to a byte array at a given offset. The value is
     * converted to the opposed endian system while writing.
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.406 -0400", hash_original_method = "2BD035C73A838BB41D1FD62BFA454098", hash_generated_method = "6C6045864E93EA335BA6A9445DBF5B1D")
    
public static void writeSwappedShort(byte[] data, int offset, short value) {
        data[ offset + 0 ] = (byte)( ( value >> 0 ) & 0xff );
        data[ offset + 1 ] = (byte)( ( value >> 8 ) & 0xff );
    }

    /**
     * Reads a "short" value from a byte array at a given offset. The value is
     * converted to the opposed endian system while reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.407 -0400", hash_original_method = "43BF27BC739D1713ADFA799FFFBC5AF3", hash_generated_method = "C32EF07222AD72865E861229065BF230")
    
public static short readSwappedShort(byte[] data, int offset) {
        return (short)( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) );
    }

    /**
     * Reads an unsigned short (16-bit) value from a byte array at a given
     * offset. The value is converted to the opposed endian system while
     * reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.408 -0400", hash_original_method = "B1BA8670604DCF1D4886449B3C294726", hash_generated_method = "E04D922422F30AD07F42B2235C4CFBCA")
    
public static int readSwappedUnsignedShort(byte[] data, int offset) {
        return ( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) );
    }

    /**
     * Writes a "int" value to a byte array at a given offset. The value is
     * converted to the opposed endian system while writing.
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.408 -0400", hash_original_method = "3F3AC95312B5654C0814A8467CCF30BD", hash_generated_method = "D4FF79C88CCE8D165C3E5C57E5D65683")
    
public static void writeSwappedInteger(byte[] data, int offset, int value) {
        data[ offset + 0 ] = (byte)( ( value >> 0 ) & 0xff );
        data[ offset + 1 ] = (byte)( ( value >> 8 ) & 0xff );
        data[ offset + 2 ] = (byte)( ( value >> 16 ) & 0xff );
        data[ offset + 3 ] = (byte)( ( value >> 24 ) & 0xff );
    }

    /**
     * Reads a "int" value from a byte array at a given offset. The value is
     * converted to the opposed endian system while reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.409 -0400", hash_original_method = "D5771A4493620FED5A8C5A9531CB0933", hash_generated_method = "3D45C8864AD6079E5AF3C14F66077866")
    
public static int readSwappedInteger(byte[] data, int offset) {
        return ( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) +
            ( ( data[ offset + 2 ] & 0xff ) << 16 ) +
            ( ( data[ offset + 3 ] & 0xff ) << 24 ) );
    }

    /**
     * Reads an unsigned integer (32-bit) value from a byte array at a given
     * offset. The value is converted to the opposed endian system while
     * reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.410 -0400", hash_original_method = "43F1953459ED4A6D7CC6DB0D2AF14731", hash_generated_method = "92A00B9BBBAE9E5C3293B909A1EA1F62")
    
public static long readSwappedUnsignedInteger(byte[] data, int offset) {
        long low = ( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
                     ( ( data[ offset + 1 ] & 0xff ) << 8 ) +
                     ( ( data[ offset + 2 ] & 0xff ) << 16 ) );

        long high = data[ offset + 3 ] & 0xff;

        return (high << 24) + (0xffffffffL & low); 
    }

    /**
     * Writes a "long" value to a byte array at a given offset. The value is
     * converted to the opposed endian system while writing.
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.411 -0400", hash_original_method = "7B78B92713305FD45D6A88A896E4A765", hash_generated_method = "8837BF786557AE42A48C911BA674FCC4")
    
public static void writeSwappedLong(byte[] data, int offset, long value) {
        data[ offset + 0 ] = (byte)( ( value >> 0 ) & 0xff );
        data[ offset + 1 ] = (byte)( ( value >> 8 ) & 0xff );
        data[ offset + 2 ] = (byte)( ( value >> 16 ) & 0xff );
        data[ offset + 3 ] = (byte)( ( value >> 24 ) & 0xff );
        data[ offset + 4 ] = (byte)( ( value >> 32 ) & 0xff );
        data[ offset + 5 ] = (byte)( ( value >> 40 ) & 0xff );
        data[ offset + 6 ] = (byte)( ( value >> 48 ) & 0xff );
        data[ offset + 7 ] = (byte)( ( value >> 56 ) & 0xff );
    }

    /**
     * Reads a "long" value from a byte array at a given offset. The value is
     * converted to the opposed endian system while reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.412 -0400", hash_original_method = "3B768B07815D1E82B9DA9F72D26C51EF", hash_generated_method = "81FC492D08B09F484F4EBFF8AC21C02E")
    
public static long readSwappedLong(byte[] data, int offset) {
        long low = 
            ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) +
            ( ( data[ offset + 2 ] & 0xff ) << 16 ) +
            ( ( data[ offset + 3 ] & 0xff ) << 24 );
        long high = 
            ( ( data[ offset + 4 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 5 ] & 0xff ) << 8 ) +
            ( ( data[ offset + 6 ] & 0xff ) << 16 ) +
            ( ( data[ offset + 7 ] & 0xff ) << 24 );
        return (high << 32) + (0xffffffffL & low); 
    }

    /**
     * Writes a "float" value to a byte array at a given offset. The value is
     * converted to the opposed endian system while writing.
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.412 -0400", hash_original_method = "751857C5E4D69A99F28EE0FD9CDE7C37", hash_generated_method = "5FC4A9C28D48F4F0E1301A6AFFA6475D")
    
public static void writeSwappedFloat(byte[] data, int offset, float value) {
        writeSwappedInteger( data, offset, Float.floatToIntBits( value ) );
    }

    /**
     * Reads a "float" value from a byte array at a given offset. The value is
     * converted to the opposed endian system while reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.413 -0400", hash_original_method = "6FE2119F7B8AFCCC639C0C89F4C2E725", hash_generated_method = "F20B5F67B150930B74BEA51952901832")
    
public static float readSwappedFloat(byte[] data, int offset) {
        return Float.intBitsToFloat( readSwappedInteger( data, offset ) );
    }

    /**
     * Writes a "double" value to a byte array at a given offset. The value is
     * converted to the opposed endian system while writing.
     * @param data target byte array
     * @param offset starting offset in the byte array
     * @param value value to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.413 -0400", hash_original_method = "20EC3E86A407C3B8FA8EE95F9E9C09C0", hash_generated_method = "3338CD5330875F583AAAA6E85E3FE299")
    
public static void writeSwappedDouble(byte[] data, int offset, double value) {
        writeSwappedLong( data, offset, Double.doubleToLongBits( value ) );
    }

    /**
     * Reads a "double" value from a byte array at a given offset. The value is
     * converted to the opposed endian system while reading.
     * @param data source byte array
     * @param offset starting offset in the byte array
     * @return the value read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.414 -0400", hash_original_method = "E6497FA27977EC00587BFBAE76B9237E", hash_generated_method = "4C99B6D22E2FA056CE1CF6A787BB67FC")
    
public static double readSwappedDouble(byte[] data, int offset) {
        return Double.longBitsToDouble( readSwappedLong( data, offset ) );
    }

    /**
     * Writes a "short" value to an OutputStream. The value is
     * converted to the opposed endian system while writing.
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.415 -0400", hash_original_method = "1D18D807780183D4643AA5D10B7CFA5F", hash_generated_method = "BB35A38A349491C1FEC1B265BE8A69F8")
    
public static void writeSwappedShort(OutputStream output, short value)
        throws IOException
    {
        output.write( (byte)( ( value >> 0 ) & 0xff ) );
        output.write( (byte)( ( value >> 8 ) & 0xff ) );
    }

    /**
     * Reads a "short" value from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.415 -0400", hash_original_method = "70816BBE88934E80A9FA9B28D3E71A31", hash_generated_method = "434A6A3A5B1D27FDF9235E0D88DA2EF7")
    
public static short readSwappedShort(InputStream input)
        throws IOException
    {
        return (short)( ( ( read( input ) & 0xff ) << 0 ) +
            ( ( read( input ) & 0xff ) << 8 ) );
    }

    /**
     * Reads a unsigned short (16-bit) from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.416 -0400", hash_original_method = "82AABA56BCAF4EA117FD967EA0C801E1", hash_generated_method = "45823FC2302E3887DFCEFEED7BEB9398")
    
public static int readSwappedUnsignedShort(InputStream input)
        throws IOException
    {
        int value1 = read( input );
        int value2 = read( input );

        return ( ( ( value1 & 0xff ) << 0 ) +
            ( ( value2 & 0xff ) << 8 ) );
    }

    /**
     * Writes a "int" value to an OutputStream. The value is
     * converted to the opposed endian system while writing.
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.417 -0400", hash_original_method = "585F53C650C5C9F5A62C5141A6DD9F48", hash_generated_method = "C07F213AFCA9E908CF85DDFB8E610724")
    
public static void writeSwappedInteger(OutputStream output, int value)
        throws IOException
    {
        output.write( (byte)( ( value >> 0 ) & 0xff ) );
        output.write( (byte)( ( value >> 8 ) & 0xff ) );
        output.write( (byte)( ( value >> 16 ) & 0xff ) );
        output.write( (byte)( ( value >> 24 ) & 0xff ) );
    }

    /**
     * Reads a "int" value from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.417 -0400", hash_original_method = "399FD48625B469905478587F05C86457", hash_generated_method = "F966BFD96A459D6C96FDF4FB8616DC0C")
    
public static int readSwappedInteger(InputStream input)
        throws IOException
    {
        int value1 = read( input );
        int value2 = read( input );
        int value3 = read( input );
        int value4 = read( input );

        return ( ( value1 & 0xff ) << 0 ) +
            ( ( value2 & 0xff ) << 8 ) +
            ( ( value3 & 0xff ) << 16 ) +
            ( ( value4 & 0xff ) << 24 );
    }

    /**
     * Reads a unsigned integer (32-bit) from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.418 -0400", hash_original_method = "ACA20742F9E22A6D5539033955270B30", hash_generated_method = "617FEADF89CAB1A9DD7AEACA6F0D2EF6")
    
public static long readSwappedUnsignedInteger(InputStream input)
        throws IOException
    {
        int value1 = read( input );
        int value2 = read( input );
        int value3 = read( input );
        int value4 = read( input );

        long low = ( ( ( value1 & 0xff ) << 0 ) +
                     ( ( value2 & 0xff ) << 8 ) +
                     ( ( value3 & 0xff ) << 16 ) );

        long high = value4 & 0xff;

        return (high << 24) + (0xffffffffL & low); 
    }

    /**
     * Writes a "long" value to an OutputStream. The value is
     * converted to the opposed endian system while writing.
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.419 -0400", hash_original_method = "7EB6640C142FD363FDD2396F8FB791BB", hash_generated_method = "E0B5ADE15D1426EC62B5FC3B9C060AB2")
    
public static void writeSwappedLong(OutputStream output, long value)
        throws IOException
    {
        output.write( (byte)( ( value >> 0 ) & 0xff ) );
        output.write( (byte)( ( value >> 8 ) & 0xff ) );
        output.write( (byte)( ( value >> 16 ) & 0xff ) );
        output.write( (byte)( ( value >> 24 ) & 0xff ) );
        output.write( (byte)( ( value >> 32 ) & 0xff ) );
        output.write( (byte)( ( value >> 40 ) & 0xff ) );
        output.write( (byte)( ( value >> 48 ) & 0xff ) );
        output.write( (byte)( ( value >> 56 ) & 0xff ) );
    }

    /**
     * Reads a "long" value from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.419 -0400", hash_original_method = "579088CE1A9EFB8794C68173F5B284BE", hash_generated_method = "1198FBA4330043A6BECAF73039B77310")
    
public static long readSwappedLong(InputStream input)
        throws IOException
    {
        byte[] bytes = new byte[8];
        for ( int i=0; i<8; i++ ) {
            bytes[i] = (byte) read( input );
        }
        return readSwappedLong( bytes, 0 );
    }

    /**
     * Writes a "float" value to an OutputStream. The value is
     * converted to the opposed endian system while writing.
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.420 -0400", hash_original_method = "056CD22080557022C880836C779D064A", hash_generated_method = "7D893911D2500F8BD7B8B956EC82284E")
    
public static void writeSwappedFloat(OutputStream output, float value)
        throws IOException
    {
        writeSwappedInteger( output, Float.floatToIntBits( value ) );
    }

    /**
     * Reads a "float" value from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.420 -0400", hash_original_method = "7C45A482387B2B2D8B9E8C359B519B1D", hash_generated_method = "712972C9606AAB3F46E99D327614741D")
    
public static float readSwappedFloat(InputStream input)
        throws IOException
    {
        return Float.intBitsToFloat( readSwappedInteger( input ) );
    }

    /**
     * Writes a "double" value to an OutputStream. The value is
     * converted to the opposed endian system while writing.
     * @param output target OutputStream
     * @param value value to write
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.421 -0400", hash_original_method = "B680B124D15C27AFF7F59A1FAD367143", hash_generated_method = "81CA5C06312B19E2D21605AD81FEA398")
    
public static void writeSwappedDouble(OutputStream output, double value)
        throws IOException
    {
        writeSwappedLong( output, Double.doubleToLongBits( value ) );
    }

    /**
     * Reads a "double" value from an InputStream. The value is
     * converted to the opposed endian system while reading.
     * @param input source InputStream
     * @return the value just read
     * @throws IOException in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.421 -0400", hash_original_method = "D21560F654817031C7E92ABFF69D8B08", hash_generated_method = "8FF32A06A9E656804B8A2BD50378219C")
    
public static double readSwappedDouble(InputStream input)
        throws IOException
    {
        return Double.longBitsToDouble( readSwappedLong( input ) );
    }

    /**
     * Reads the next byte from the input stream.
     * @param input  the stream
     * @return the byte
     * @throws IOException if the end of file is reached
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.422 -0400", hash_original_method = "CBA24EA576157137E32DA1145EF01444", hash_generated_method = "82753090EFFFF124CE51E97E6B51903C")
    
private static int read(InputStream input)
        throws IOException
    {
        int value = input.read();

        if( -1 == value ) {
            throw new EOFException( "Unexpected EOF reached" );
        }

        return value;
    }

    /**
     * Instances should NOT be constructed in standard programming.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.402 -0400", hash_original_method = "4B733419E920224AADA57540D2C30FA6", hash_generated_method = "D1E98BD3B8DD9BF412C8B2B41A7C435A")
    
public EndianUtils() {
        super();
    }
}
