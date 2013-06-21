package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.PrintStream;
import java.util.Locale;
import java.security.AccessController;
import java.security.PrivilegedAction;
import libcore.util.EmptyArray;

public class Logger {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.808 -0400", hash_original_method = "0283E2D1EB22E357EAA4AC3312F98F74", hash_generated_method = "0283E2D1EB22E357EAA4AC3312F98F74")
        public Logger ()
    {
    }


        public static Stream getStream(String name) {
        for (int i=0; i<names.length; i++) {
            if (names[i].equals(name)) {
                return new Stream(name);
            }
        }
        return null;
    }

    
    public static class Stream extends PrintStream {
        private String prefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.809 -0400", hash_original_method = "5B47239B5174F6EBCA9E4F35C8BFA346", hash_generated_method = "C405A5578418A8025DB987DAC3B1A46E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Stream(String name) {
            super(System.err);
            dsTaint.addTaint(name);
            prefix = name + "["+Thread.currentThread().getName()+"] ";
            // ---------- Original Method ----------
            //prefix = name + "["+Thread.currentThread().getName()+"] ";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.809 -0400", hash_original_method = "D4FE33DE2CA80BB3708E6A0E802F0C32", hash_generated_method = "B40D679F595834B41FEF88A256C911CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void print(String msg) {
            dsTaint.addTaint(msg);
            {
                int i;
                i = 0;
                {
                    super.print("  ");
                } //End block
            } //End collapsed parenthetic
            super.print(msg);
            // ---------- Original Method ----------
            //for (int i=0; i<indent; i++) {
                //super.print("  ");
            //}
            //super.print(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.809 -0400", hash_original_method = "330ED05F95D8039149C4EE202C44E32C", hash_generated_method = "13E6B0A7ED2046F68EA1958C76857BC1")
        @DSModeled(DSC.SAFE)
        public void newIndent() {
            // ---------- Original Method ----------
            //indent ++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.809 -0400", hash_original_method = "85AD8C1F1AFBCA83430C30D8B2614DB0", hash_generated_method = "949118FCC724942B9B24B51D90111D34")
        @DSModeled(DSC.SAFE)
        public void endIndent() {
            // ---------- Original Method ----------
            //indent --;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.810 -0400", hash_original_method = "9FCCAC1E0D29D125BE9308EF391306A0", hash_generated_method = "9CA9967AF807ED7E1A2E7AAA5D95CE39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void println(String msg) {
            dsTaint.addTaint(msg);
            print(prefix);
            super.println(msg);
            // ---------- Original Method ----------
            //print(prefix);
            //super.println(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.810 -0400", hash_original_method = "8FD37FA4B52BC22F9117E57A4C975FCE", hash_generated_method = "797DF19FA54594127C4711DE6564E2BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void print(byte[] data) {
            dsTaint.addTaint(data[0]);
            printAsHex(16, " ", "", data, 0, data.length);
            // ---------- Original Method ----------
            //printAsHex(16, " ", "", data, 0, data.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.810 -0400", hash_original_method = "97F4A1EEA64A5AE021D275219F0FBD08", hash_generated_method = "FA215FAD4FC42069B206A0E8CFC18940")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void print(byte[] data, int offset, int len) {
            dsTaint.addTaint(data[0]);
            dsTaint.addTaint(len);
            dsTaint.addTaint(offset);
            printAsHex(16, " ", "", data, offset, len);
            // ---------- Original Method ----------
            //printAsHex(16, " ", "", data, offset, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.810 -0400", hash_original_method = "6BD913AAA4D9B14F7C28D0536E7C7B24", hash_generated_method = "363BC46CD9F0F143A0915DCAE7BCEC6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void printAsHex(int perLine, String prefix, String delimiter, byte[] data) {
            dsTaint.addTaint(delimiter);
            dsTaint.addTaint(perLine);
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(data[0]);
            printAsHex(perLine, prefix, delimiter, data, 0, data.length);
            // ---------- Original Method ----------
            //printAsHex(perLine, prefix, delimiter, data, 0, data.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.810 -0400", hash_original_method = "FDE1B5B6670F726EAB891149ED6137F5", hash_generated_method = "450D0C6649F197427A80944F3F63D1BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void printAsHex(int perLine, String prefix, String delimiter,
                byte[] data, int offset, int len) {
            dsTaint.addTaint(delimiter);
            dsTaint.addTaint(perLine);
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(data[0]);
            dsTaint.addTaint(len);
            dsTaint.addTaint(offset);
            StringBuilder line;
            line = new StringBuilder();
            {
                int i;
                i = 0;
                {
                    line.append(prefix);
                    line.append(Byte.toHexString(data[i+offset], false));
                    line.append(delimiter);
                    {
                        super.println(line.toString());
                        line = new StringBuilder();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            super.println(line.toString());
            // ---------- Original Method ----------
            //StringBuilder line = new StringBuilder();
            //for (int i = 0; i < len; i++) {
                //line.append(prefix);
                //line.append(Byte.toHexString(data[i+offset], false));
                //line.append(delimiter);
                //if (((i+1)%perLine) == 0) {
                    //super.println(line.toString());
                    //line = new StringBuilder();
                //}
            //}
            //super.println(line.toString());
        }

        
        private static int indent = 0;
    }


    
    private static String[] names;
    static {
        try {
            names = System.getProperty("jsse", "").split(",");
        } catch (Exception e) {
            names = EmptyArray.STRING;
        }
    }
    
}

