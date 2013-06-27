package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public class FileSystemUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.358 -0400", hash_original_method = "B29D45870A29045F43463B3631BB6C4B", hash_generated_method = "77C130172B07123077929EDABB0B76D2")
    public  FileSystemUtils() {
        super();
        // ---------- Original Method ----------
    }

    
        @Deprecated
    public static long freeSpace(String path) throws IOException {
        return INSTANCE.freeSpaceOS(path, OS, false, -1);
    }

    
        public static long freeSpaceKb(String path) throws IOException {
        return freeSpaceKb(path, -1);
    }

    
        public static long freeSpaceKb(String path, long timeout) throws IOException {
        return INSTANCE.freeSpaceOS(path, OS, true, timeout);
    }

    
        public static long freeSpaceKb() throws IOException {
        return freeSpaceKb(-1);
    }

    
        public static long freeSpaceKb(long timeout) throws IOException {
        return freeSpaceKb(new File(".").getAbsolutePath(), timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.362 -0400", hash_original_method = "E0E33A53BF06D22C0B2157AB1696B99E", hash_generated_method = "5C8B83EEEE541DE7E52590666ED9510B")
     long freeSpaceOS(String path, int os, boolean kb, long timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Path must not be empty");
        } //End block
        //Begin case WINDOWS 
        {
            Object var64A6DDA4A3A13214A1EE5DEB77F38112_1082682403 = (freeSpaceWindows(path, timeout) / FileUtils.ONE_KB);
            Object varFB40B2A71E44805555B421BF4DEB554B_1080892447 = (freeSpaceWindows(path, timeout));
        } //End flattened ternary
        //End case WINDOWS 
        //Begin case UNIX 
        long varA5B1F2661FED54CA2F0E636FFECF4C19_1730820738 = (freeSpaceUnix(path, kb, false, timeout));
        //End case UNIX 
        //Begin case POSIX_UNIX 
        long varFA962F2DFB58CBEC6049E801BE5DEFB6_1755288034 = (freeSpaceUnix(path, kb, true, timeout));
        //End case POSIX_UNIX 
        //Begin case OTHER 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unsupported operating system");
        //End case OTHER 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                  "Exception caught when determining operating system");
        //End case default 
        addTaint(path.getTaint());
        addTaint(os);
        addTaint(kb);
        addTaint(timeout);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_910416860 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_910416860;
        // ---------- Original Method ----------
        //if (path == null) {
            //throw new IllegalArgumentException("Path must not be empty");
        //}
        //switch (os) {
            //case WINDOWS:
                //return kb ? freeSpaceWindows(path, timeout) / FileUtils.ONE_KB : freeSpaceWindows(path, timeout);
            //case UNIX:
                //return freeSpaceUnix(path, kb, false, timeout);
            //case POSIX_UNIX:
                //return freeSpaceUnix(path, kb, true, timeout);
            //case OTHER:
                //throw new IllegalStateException("Unsupported operating system");
            //default:
                //throw new IllegalStateException(
                  //"Exception caught when determining operating system");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.362 -0400", hash_original_method = "97DC8BEF6DA4F2C77A7C47140A7E5DBB", hash_generated_method = "E764F59DB10155F0E2DB670E70D4378E")
     long freeSpaceWindows(String path, long timeout) throws IOException {
        path = FilenameUtils.normalize(path, false);
        {
            boolean varB3448C20D897D834FCB08D738002F045_406046976 = (path.length() > 0 && path.charAt(0) != '"');
            {
                path = "\"" + path + "\"";
            } //End block
        } //End collapsed parenthetic
        String[] cmdAttribs;
        cmdAttribs = new String[] {"cmd.exe", "/C", "dir /a /-c " + path};
        List<String> lines;
        lines = performCommand(cmdAttribs, Integer.MAX_VALUE, timeout);
        {
            int i;
            i = lines.size() - 1;
            {
                String line;
                line = lines.get(i);
                {
                    boolean var45D098D040C15A220E23E5A20EED74D9_1196540876 = (line.length() > 0);
                    {
                        long varB7765E1CCFB5D4FBEB4AF61B06D25572_658705350 = (parseDir(line, path));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IOException(
                "Command line 'dir /-c' did not return any info " +
                "for path '" + path + "'");
        addTaint(path.getTaint());
        addTaint(timeout);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_491612421 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_491612421;
        // ---------- Original Method ----------
        //path = FilenameUtils.normalize(path, false);
        //if (path.length() > 0 && path.charAt(0) != '"') {
            //path = "\"" + path + "\"";
        //}
        //String[] cmdAttribs = new String[] {"cmd.exe", "/C", "dir /a /-c " + path};
        //List<String> lines = performCommand(cmdAttribs, Integer.MAX_VALUE, timeout);
        //for (int i = lines.size() - 1; i >= 0; i--) {
            //String line = lines.get(i);
            //if (line.length() > 0) {
                //return parseDir(line, path);
            //}
        //}
        //throw new IOException(
                //"Command line 'dir /-c' did not return any info " +
                //"for path '" + path + "'");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.363 -0400", hash_original_method = "BF05C25EF740B0B2989A55D0BCB5E47A", hash_generated_method = "BEFB56650A72B3C59E28743FB13B66AF")
     long parseDir(String line, String path) throws IOException {
        int bytesStart;
        bytesStart = 0;
        int bytesEnd;
        bytesEnd = 0;
        int j;
        j = line.length() - 1;
        {
            char c;
            c = line.charAt(j);
            {
                boolean varDB900FCAF741B8D9AE87D5FB6F43E2E8_1905676148 = (Character.isDigit(c));
                {
                    bytesEnd = j + 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            char c;
            c = line.charAt(j);
            {
                boolean var674D8F473F2D50D8919D78EEF2825B8C_415178757 = (!Character.isDigit(c) && c != ',' && c != '.');
                {
                    bytesStart = j + 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(
                    "Command line 'dir /-c' did not return valid info " +
                    "for path '" + path + "'");
        } //End block
        StringBuilder buf;
        buf = new StringBuilder(line.substring(bytesStart, bytesEnd));
        {
            int k;
            k = 0;
            boolean varBAC9B8781D77C4B72BA529368A4C60E6_532278179 = (k < buf.length());
            {
                {
                    boolean varCAD00E60677017DAE9F9FAC80AECD80B_1174633183 = (buf.charAt(k) == ',' || buf.charAt(k) == '.');
                    {
                        buf.deleteCharAt(k--);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        long varDCD07AE8C219895712F194DCD80CA85C_434085691 = (parseBytes(buf.toString(), path));
        addTaint(line.getTaint());
        addTaint(path.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1540653343 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1540653343;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.366 -0400", hash_original_method = "63A1B9B4037D6BF474EA6B9864F43D94", hash_generated_method = "7A424301A9D268827231B6237B6C19E0")
     long freeSpaceUnix(String path, boolean kb, boolean posix, long timeout) throws IOException {
        {
            boolean varC42BD8E106697B013A46B50B4483B2B8_1005847526 = (path.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Path must not be empty");
            } //End block
        } //End collapsed parenthetic
        String flags;
        flags = "-";
        {
            flags += "k";
        } //End block
        {
            flags += "P";
        } //End block
        String[] cmdAttribs;
        boolean var610ACEF19E29918B13CFE343252AF7D5_1828516546 = (flags.length() > 1);
        cmdAttribs = new String[] {DF, flags, path};
        cmdAttribs = new String[] {DF, path};
        List<String> lines;
        lines = performCommand(cmdAttribs, 3, timeout);
        {
            boolean var323AEF250AC4F948E1486DCCF4AC4B65_1564109087 = (lines.size() < 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(
                    "Command line '" + DF + "' did not return info as expected " +
                    "for path '" + path + "'- response was " + lines);
            } //End block
        } //End collapsed parenthetic
        String line2;
        line2 = lines.get(1);
        StringTokenizer tok;
        tok = new StringTokenizer(line2, " ");
        {
            boolean var2EEE20FB2E97674066054D8ACE17286E_1794454867 = (tok.countTokens() < 4);
            {
                {
                    boolean varA3B3AB4969523230FB194C8B7E388C27_1815413140 = (tok.countTokens() == 1 && lines.size() >= 3);
                    {
                        String line3;
                        line3 = lines.get(2);
                        tok = new StringTokenizer(line3, " ");
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException(
                        "Command line '" + DF + "' did not return data as expected " +
                        "for path '" + path + "'- check path is valid");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                tok.nextToken();
            } //End block
        } //End collapsed parenthetic
        tok.nextToken();
        tok.nextToken();
        String freeSpace;
        freeSpace = tok.nextToken();
        long var91DD552B86C111394787813C22B121DF_982485151 = (parseBytes(freeSpace, path));
        addTaint(path.getTaint());
        addTaint(kb);
        addTaint(posix);
        addTaint(timeout);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_283037907 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_283037907;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.366 -0400", hash_original_method = "9B456979926FBEBDCE0D7990B1D4EAD2", hash_generated_method = "A7CD91BFED6874C744E803962538E7AA")
     long parseBytes(String freeSpace, String path) throws IOException {
        try 
        {
            long bytes;
            bytes = Long.parseLong(freeSpace);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(
                        "Command line '" + DF + "' did not find free space in response " +
                        "for path '" + path + "'- check path is valid");
            } //End block
        } //End block
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOExceptionWithCause(
                    "Command line '" + DF + "' did not return numeric data as expected " +
                    "for path '" + path + "'- check path is valid", ex);
        } //End block
        addTaint(freeSpace.getTaint());
        addTaint(path.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1695698391 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1695698391;
        // ---------- Original Method ----------
        //try {
            //long bytes = Long.parseLong(freeSpace);
            //if (bytes < 0) {
                //throw new IOException(
                        //"Command line '" + DF + "' did not find free space in response " +
                        //"for path '" + path + "'- check path is valid");
            //}
            //return bytes;
        //} catch (NumberFormatException ex) {
            //throw new IOExceptionWithCause(
                    //"Command line '" + DF + "' did not return numeric data as expected " +
                    //"for path '" + path + "'- check path is valid", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.389 -0400", hash_original_method = "33C4C2C18C24F6A9AB6F6705D1C4986B", hash_generated_method = "A321B7B017191A5D2F800858061135CD")
     List<String> performCommand(String[] cmdAttribs, int max, long timeout) throws IOException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_744577094 = null; //Variable for return #1
        List<String> lines;
        lines = new ArrayList<String>(20);
        Process proc;
        proc = null;
        InputStream in;
        in = null;
        OutputStream out;
        out = null;
        InputStream err;
        err = null;
        BufferedReader inr;
        inr = null;
        try 
        {
            Thread monitor;
            monitor = ThreadMonitor.start(timeout);
            proc = openProcess(cmdAttribs);
            in = proc.getInputStream();
            out = proc.getOutputStream();
            err = proc.getErrorStream();
            inr = new BufferedReader(new InputStreamReader(in));
            String line;
            line = inr.readLine();
            {
                boolean var61A8FE819340D0193B3BE5AD8C251DD4_1094295349 = (line != null && lines.size() < max);
                {
                    line = line.toLowerCase(Locale.ENGLISH).trim();
                    lines.add(line);
                    line = inr.readLine();
                } //End block
            } //End collapsed parenthetic
            proc.waitFor();
            ThreadMonitor.stop(monitor);
            {
                boolean var4344C35E425220862944F661EB9130CB_2061332772 = (proc.exitValue() != 0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(
                        "Command line returned OS error code '" + proc.exitValue() +
                        "' for command " + Arrays.asList(cmdAttribs));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var4FA3D21C5CD4F100013BCD2AB54C5E2C_968512333 = (lines.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(
                        "Command line did not return any info " +
                        "for command " + Arrays.asList(cmdAttribs));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_744577094 = lines;
        } //End block
        catch (InterruptedException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOExceptionWithCause(
                    "Command line threw an InterruptedException " +
                    "for command " + Arrays.asList(cmdAttribs) + " timeout=" + timeout, ex);
        } //End block
        finally 
        {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(err);
            IOUtils.closeQuietly(inr);
            {
                proc.destroy();
            } //End block
        } //End block
        addTaint(cmdAttribs[0].getTaint());
        addTaint(max);
        addTaint(timeout);
        varB4EAC82CA7396A68D541C85D26508E83_744577094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_744577094;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.390 -0400", hash_original_method = "7DECE044380D73BAC819BD07020B1534", hash_generated_method = "143FF4794361E051C06FCBDCBEC48F20")
     Process openProcess(String[] cmdAttribs) throws IOException {
        Process varB4EAC82CA7396A68D541C85D26508E83_904085826 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_904085826 = Runtime.getRuntime().exec(cmdAttribs);
        addTaint(cmdAttribs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_904085826.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_904085826;
        // ---------- Original Method ----------
        //return Runtime.getRuntime().exec(cmdAttribs);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "3A82226BFF787E1F4E22724E615F9890", hash_generated_field = "0505E048814DD0F539583535ADFF56FD")

    private static FileSystemUtils INSTANCE = new FileSystemUtils();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "ADEC1459226F468F8CAC0A8189A0C82A", hash_generated_field = "43C6E6B00152CC7FEFFAE5DF2A7F62AD")

    private static int INIT_PROBLEM = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "79A8A1F63E6E1D1CBCD0FF0830EFF895", hash_generated_field = "7478C1ACF626FD32FF58AFB9B3640381")

    private static int OTHER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "2EFE77337209C3C7A788E1D397651CDE", hash_generated_field = "738D247328A16D99F10FD161E1F73C66")

    private static int WINDOWS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "08E056D91A36E8DF5B1169E45447B077", hash_generated_field = "1838CE2F48E8938020854CEA2E68D1B3")

    private static int UNIX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "12BCED90399C32A8C2569DD0A68DF4D4", hash_generated_field = "D99429C9DD1859EABA65E49E5FADC422")

    private static int POSIX_UNIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "17BC10091293FDC562A6DB69940EE924", hash_generated_field = "8D349094D13E25F9D974BE01EA3B69CE")

    private static int OS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.391 -0400", hash_original_field = "B98F83032F6E8CA0C8F5A38BCA1E3D75", hash_generated_field = "958156933CCF5CFEF728004182F39BA7")

    private static String DF;
    static {
        int os = OTHER;
        String dfPath = "df";
        try {
            String osName = System.getProperty("os.name");
            if (osName == null) {
                throw new IOException("os.name not found");
            }
            osName = osName.toLowerCase(Locale.ENGLISH);
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
    
}

