package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public class CopyUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.217 -0400", hash_original_method = "1212272BD01F83C868E797A5AC3981E4", hash_generated_method = "84A2CF188DB904FA9BBABD4289B541CA")
    public  CopyUtils() {
        // ---------- Original Method ----------
    }

    
    public static void copy(byte[] input, OutputStream output) throws IOException {
        output.write(input);
    }

    
    public static void copy(byte[] input, Writer output) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        copy(in, output);
    }

    
    public static void copy(
            byte[] input,
            Writer output,
            String encoding) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        copy(in, output, encoding);
    }

    
    public static int copy(
            InputStream input,
            OutputStream output) throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    
    public static int copy(
            Reader input,
            Writer output) throws IOException {
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    
    public static void copy(
            InputStream input,
            Writer output) throws IOException {
        InputStreamReader in = new InputStreamReader(input);
        copy(in, output);
    }

    
    public static void copy(
            InputStream input,
            Writer output,
            String encoding) throws IOException {
        InputStreamReader in = new InputStreamReader(input, encoding);
        copy(in, output);
    }

    
    public static void copy(
            Reader input,
            OutputStream output) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(input, out);
        out.flush();
    }

    
    public static void copy(
            String input,
            OutputStream output) throws IOException {
        StringReader in = new StringReader(input);
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(in, out);
        out.flush();
    }

    
    public static void copy(String input, Writer output) throws IOException {
        output.write(input);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.220 -0400", hash_original_field = "0756DBB6429486B34418EA788076E36E", hash_generated_field = "AD1955EA27A1323BB99B1EE414E7EB17")

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
}

