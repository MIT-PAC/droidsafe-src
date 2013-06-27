package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EndianUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.771 -0400", hash_original_method = "4B733419E920224AADA57540D2C30FA6", hash_generated_method = "E488AF8E03869E4C02B403C6E6593ADC")
    public  EndianUtils() {
        super();
        // ---------- Original Method ----------
    }

    
        public static short swapShort(short value) {
        return (short) ( ( ( ( value >> 0 ) & 0xff ) << 8 ) +
            ( ( ( value >> 8 ) & 0xff ) << 0 ) );
    }

    
        public static int swapInteger(int value) {
        return
            ( ( ( value >> 0 ) & 0xff ) << 24 ) +
            ( ( ( value >> 8 ) & 0xff ) << 16 ) +
            ( ( ( value >> 16 ) & 0xff ) << 8 ) +
            ( ( ( value >> 24 ) & 0xff ) << 0 );
    }

    
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

    
        public static float swapFloat(float value) {
        return Float.intBitsToFloat( swapInteger( Float.floatToIntBits( value ) ) );
    }

    
        public static double swapDouble(double value) {
        return Double.longBitsToDouble( swapLong( Double.doubleToLongBits( value ) ) );
    }

    
        public static void writeSwappedShort(byte[] data, int offset, short value) {
        data[ offset + 0 ] = (byte)( ( value >> 0 ) & 0xff );
        data[ offset + 1 ] = (byte)( ( value >> 8 ) & 0xff );
    }

    
        public static short readSwappedShort(byte[] data, int offset) {
        return (short)( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) );
    }

    
        public static int readSwappedUnsignedShort(byte[] data, int offset) {
        return ( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) );
    }

    
        public static void writeSwappedInteger(byte[] data, int offset, int value) {
        data[ offset + 0 ] = (byte)( ( value >> 0 ) & 0xff );
        data[ offset + 1 ] = (byte)( ( value >> 8 ) & 0xff );
        data[ offset + 2 ] = (byte)( ( value >> 16 ) & 0xff );
        data[ offset + 3 ] = (byte)( ( value >> 24 ) & 0xff );
    }

    
        public static int readSwappedInteger(byte[] data, int offset) {
        return ( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
            ( ( data[ offset + 1 ] & 0xff ) << 8 ) +
            ( ( data[ offset + 2 ] & 0xff ) << 16 ) +
            ( ( data[ offset + 3 ] & 0xff ) << 24 ) );
    }

    
        public static long readSwappedUnsignedInteger(byte[] data, int offset) {
        long low = ( ( ( data[ offset + 0 ] & 0xff ) << 0 ) +
                     ( ( data[ offset + 1 ] & 0xff ) << 8 ) +
                     ( ( data[ offset + 2 ] & 0xff ) << 16 ) );
        long high = data[ offset + 3 ] & 0xff;
        return (high << 24) + (0xffffffffL & low);
    }

    
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

    
        public static void writeSwappedFloat(byte[] data, int offset, float value) {
        writeSwappedInteger( data, offset, Float.floatToIntBits( value ) );
    }

    
        public static float readSwappedFloat(byte[] data, int offset) {
        return Float.intBitsToFloat( readSwappedInteger( data, offset ) );
    }

    
        public static void writeSwappedDouble(byte[] data, int offset, double value) {
        writeSwappedLong( data, offset, Double.doubleToLongBits( value ) );
    }

    
        public static double readSwappedDouble(byte[] data, int offset) {
        return Double.longBitsToDouble( readSwappedLong( data, offset ) );
    }

    
        public static void writeSwappedShort(OutputStream output, short value) throws IOException {
        output.write( (byte)( ( value >> 0 ) & 0xff ) );
        output.write( (byte)( ( value >> 8 ) & 0xff ) );
    }

    
        public static short readSwappedShort(InputStream input) throws IOException {
        return (short)( ( ( read( input ) & 0xff ) << 0 ) +
            ( ( read( input ) & 0xff ) << 8 ) );
    }

    
        public static int readSwappedUnsignedShort(InputStream input) throws IOException {
        int value1 = read( input );
        int value2 = read( input );
        return ( ( ( value1 & 0xff ) << 0 ) +
            ( ( value2 & 0xff ) << 8 ) );
    }

    
        public static void writeSwappedInteger(OutputStream output, int value) throws IOException {
        output.write( (byte)( ( value >> 0 ) & 0xff ) );
        output.write( (byte)( ( value >> 8 ) & 0xff ) );
        output.write( (byte)( ( value >> 16 ) & 0xff ) );
        output.write( (byte)( ( value >> 24 ) & 0xff ) );
    }

    
        public static int readSwappedInteger(InputStream input) throws IOException {
        int value1 = read( input );
        int value2 = read( input );
        int value3 = read( input );
        int value4 = read( input );
        return ( ( value1 & 0xff ) << 0 ) +
            ( ( value2 & 0xff ) << 8 ) +
            ( ( value3 & 0xff ) << 16 ) +
            ( ( value4 & 0xff ) << 24 );
    }

    
        public static long readSwappedUnsignedInteger(InputStream input) throws IOException {
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

    
        public static void writeSwappedLong(OutputStream output, long value) throws IOException {
        output.write( (byte)( ( value >> 0 ) & 0xff ) );
        output.write( (byte)( ( value >> 8 ) & 0xff ) );
        output.write( (byte)( ( value >> 16 ) & 0xff ) );
        output.write( (byte)( ( value >> 24 ) & 0xff ) );
        output.write( (byte)( ( value >> 32 ) & 0xff ) );
        output.write( (byte)( ( value >> 40 ) & 0xff ) );
        output.write( (byte)( ( value >> 48 ) & 0xff ) );
        output.write( (byte)( ( value >> 56 ) & 0xff ) );
    }

    
        public static long readSwappedLong(InputStream input) throws IOException {
        byte[] bytes = new byte[8];
        for ( int i=0; i<8; i++ ) {
            bytes[i] = (byte) read( input );
        }
        return readSwappedLong( bytes, 0 );
    }

    
        public static void writeSwappedFloat(OutputStream output, float value) throws IOException {
        writeSwappedInteger( output, Float.floatToIntBits( value ) );
    }

    
        public static float readSwappedFloat(InputStream input) throws IOException {
        return Float.intBitsToFloat( readSwappedInteger( input ) );
    }

    
        public static void writeSwappedDouble(OutputStream output, double value) throws IOException {
        writeSwappedLong( output, Double.doubleToLongBits( value ) );
    }

    
        public static double readSwappedDouble(InputStream input) throws IOException {
        return Double.longBitsToDouble( readSwappedLong( input ) );
    }

    
        private static int read(InputStream input) throws IOException {
        int value = input.read();
        if( -1 == value ) {
            throw new EOFException( "Unexpected EOF reached" );
        }
        return value;
    }

    
}

