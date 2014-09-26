package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintStream;

import libcore.util.EmptyArray;

public class Logger {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.194 -0500", hash_original_method = "D4B2CBF47D8E9A1B445D77283A531F6E", hash_generated_method = "7EAFF6B3B6EDB4B9629F65757D303AD2")
    
public static Stream getStream(String name) {
        for (int i=0; i<names.length; i++) {
            if (names[i].equals(name)) {
                return new Stream(name);
            }
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.191 -0500", hash_original_field = "111AE7964AF24B253E7924F33761BE69", hash_generated_field = "8B709FD8D963B8653EBAE16DA6B1F60B")

    private static String[] names;
    
    public static class Stream extends PrintStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.163 -0500", hash_original_field = "472440F4277CF14A117E9F03066DCFEC", hash_generated_field = "CC16B6CC34CB003B39D25C6316DD75BD")

        private static int indent = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.161 -0500", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

        private  String prefix;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.166 -0500", hash_original_method = "5B47239B5174F6EBCA9E4F35C8BFA346", hash_generated_method = "1A8D5791845DD452B36B4C1C126A1CCB")
        
public Stream(String name) {
            super(System.err);
            prefix = name + "["+Thread.currentThread().getName()+"] ";
        }

        @DSSink({DSSinkKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.169 -0500", hash_original_method = "D4FE33DE2CA80BB3708E6A0E802F0C32", hash_generated_method = "857DBBAAF7E6696751028A99F26E908E")
        
@Override
        public void print(String msg) {
            for (int i=0; i<indent; i++) {
                super.print("  ");
            }
            super.print(msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.171 -0500", hash_original_method = "330ED05F95D8039149C4EE202C44E32C", hash_generated_method = "0C6F01AFADEDE73EEDF2F426E9AB3047")
        
public void newIndent() {
            indent ++;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.174 -0500", hash_original_method = "85AD8C1F1AFBCA83430C30D8B2614DB0", hash_generated_method = "B7421E911A1EED512FC46DE58E2C2332")
        
public void endIndent() {
            indent --;
        }

        @DSSpec(DSCat.IO)
        @DSSink({DSSinkKind.IO})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.176 -0500", hash_original_method = "9FCCAC1E0D29D125BE9308EF391306A0", hash_generated_method = "66209703A73C9C9B32D7E53D6814B02B")
        
@Override
        public void println(String msg) {
            print(prefix);
            super.println(msg);
        }

        @DSSink({DSSinkKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.179 -0500", hash_original_method = "8FD37FA4B52BC22F9117E57A4C975FCE", hash_generated_method = "B120231928A524A0791E32CFA6701F46")
        
public void print(byte[] data) {
            printAsHex(16, " ", "", data, 0, data.length);
        }

        @DSSink({DSSinkKind.IO})
        @DSSpec(DSCat.IO)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.181 -0500", hash_original_method = "97F4A1EEA64A5AE021D275219F0FBD08", hash_generated_method = "1ED33B0A8BDB500B341EEF394C8E5882")
        
public void print(byte[] data, int offset, int len) {
            printAsHex(16, " ", "", data, offset, len);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.183 -0500", hash_original_method = "6BD913AAA4D9B14F7C28D0536E7C7B24", hash_generated_method = "FFD78DAEE8DE16F49AC817E469AAA3FD")
        
public void printAsHex(int perLine, String prefix, String delimiter, byte[] data) {
            printAsHex(perLine, prefix, delimiter, data, 0, data.length);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:07.186 -0500", hash_original_method = "FDE1B5B6670F726EAB891149ED6137F5", hash_generated_method = "DAE773C20D9A20F35CA0F019A3F8755C")
        
public void printAsHex(int perLine, String prefix, String delimiter,
                byte[] data, int offset, int len) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < len; i++) {
                line.append(prefix);
                line.append(Byte.toHexString(data[i+offset], false));
                line.append(delimiter);

                if (((i+1)%perLine) == 0) {
                    super.println(line.toString());
                    line = new StringBuilder();
                }
            }
            super.println(line.toString());
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.666 -0400", hash_original_method = "E12CB5567684A77D5AAB00FDDBE756D7", hash_generated_method = "E12CB5567684A77D5AAB00FDDBE756D7")
    public Logger ()
    {
        //Synthesized constructor
    }
    static {
        try {
            names = System.getProperty("jsse", "").split(",");
        } catch (Exception e) {
            names = EmptyArray.STRING;
        }
    }
    
}

