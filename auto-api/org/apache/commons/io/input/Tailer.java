package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Tailer implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.087 -0400", hash_original_field = "D501E5F612132F85C1B227E02D16D316", hash_generated_field = "4FA79A157E51B91A8E83AD7C4AB74E2F")

    private byte inbuf[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.087 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

    private File file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.087 -0400", hash_original_field = "EC56633406A472715781AFB23A5AAB99", hash_generated_field = "BB9E3CEB5FC6C48F33AA1AB56B3738AC")

    private long delayMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.087 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "165EBAA3E49FF2963DF3E0842864DDEA")

    private boolean end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.087 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "E048D6C9CDAD7DC027FC8CB2A005BA02")

    private TailerListener listener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.087 -0400", hash_original_field = "384042276D51B353D7DD2CD6D38F6FF9", hash_generated_field = "47FDC46191A53245A20DE62B2429C99D")

    private boolean reOpen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.096 -0400", hash_original_field = "F54A01A0A239D26C194EA7EAA771ED25", hash_generated_field = "17FB020FBEF0F1CE3E941B0D1BC9976A")

    private volatile boolean run = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.097 -0400", hash_original_method = "A2F044E1F91B3619E7A224DE41EBBC75", hash_generated_method = "45EE3F03659ACF0682187DEA152DA344")
    public  Tailer(File file, TailerListener listener) {
        this(file, listener, DEFAULT_DELAY_MILLIS);
        addTaint(file.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.098 -0400", hash_original_method = "C5D886AD22E328503E0353CA28EDA453", hash_generated_method = "BD5FA43398F18A6086AF920D8A6857B4")
    public  Tailer(File file, TailerListener listener, long delayMillis) {
        this(file, listener, delayMillis, false);
        addTaint(file.getTaint());
        addTaint(listener.getTaint());
        addTaint(delayMillis);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.098 -0400", hash_original_method = "9AA6A50D6F693D552F5EA103BA14E042", hash_generated_method = "2F21631A3FC537B0C4107689AFD80799")
    public  Tailer(File file, TailerListener listener, long delayMillis, boolean end) {
        this(file, listener, delayMillis, end, DEFAULT_BUFSIZE);
        addTaint(file.getTaint());
        addTaint(listener.getTaint());
        addTaint(delayMillis);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.098 -0400", hash_original_method = "397BCE7F7F1AA9D4B191595A6D0C7181", hash_generated_method = "64D0E7A4B5A476A5AD473ADEEB968C74")
    public  Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen) {
        this(file, listener, delayMillis, end, reOpen, DEFAULT_BUFSIZE);
        addTaint(file.getTaint());
        addTaint(listener.getTaint());
        addTaint(delayMillis);
        addTaint(end);
        addTaint(reOpen);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.098 -0400", hash_original_method = "64379275E477684BC8BE083C929F3957", hash_generated_method = "95EE19522E3DAC5BF07FC634EC75FF66")
    public  Tailer(File file, TailerListener listener, long delayMillis, boolean end, int bufSize) {
        this(file, listener, delayMillis, end, false, bufSize);
        addTaint(file.getTaint());
        addTaint(listener.getTaint());
        addTaint(delayMillis);
        addTaint(end);
        addTaint(bufSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.099 -0400", hash_original_method = "4BA394E13A782A88CA2C4709DA19FD56", hash_generated_method = "733501C129EC85C53A1DC92D7A478C77")
    public  Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize) {
        this.file = file;
        this.delayMillis = delayMillis;
        this.end = end;
        this.inbuf = new byte[bufSize];
        this.listener = listener;
        listener.init(this);
        this.reOpen = reOpen;
        addTaint(bufSize);
        // ---------- Original Method ----------
        //this.file = file;
        //this.delayMillis = delayMillis;
        //this.end = end;
        //this.inbuf = new byte[bufSize];
        //this.listener = listener;
        //listener.init(this);
        //this.reOpen = reOpen;
    }

    
        public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, int bufSize) {
        Tailer tailer = new Tailer(file, listener, delayMillis, end, bufSize);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    
        public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, 
            int bufSize) {
        Tailer tailer = new Tailer(file, listener, delayMillis, end, reOpen, bufSize);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    
        public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end) {
        return create(file, listener, delayMillis, end, DEFAULT_BUFSIZE);
    }

    
        public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen) {
        return create(file, listener, delayMillis, end, reOpen, DEFAULT_BUFSIZE);
    }

    
        public static Tailer create(File file, TailerListener listener, long delayMillis) {
        return create(file, listener, delayMillis, false);
    }

    
        public static Tailer create(File file, TailerListener listener) {
        return create(file, listener, DEFAULT_DELAY_MILLIS, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.100 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "45BE0A7AC1D97575265DE00F315C6F6A")
    public File getFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_2080599335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2080599335 = file;
        varB4EAC82CA7396A68D541C85D26508E83_2080599335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2080599335;
        // ---------- Original Method ----------
        //return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.110 -0400", hash_original_method = "585B2EFA3032D4C482695ACE1752FB74", hash_generated_method = "C28304589F54F6EC678555F4EFFC5AC6")
    public long getDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2090380705 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2090380705;
        // ---------- Original Method ----------
        //return delayMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.122 -0400", hash_original_method = "FBA32DA5B44CA2DA8EFD603946A54B03", hash_generated_method = "1DBE6327936368C6A736B57D6E23D92A")
    public void run() {
        RandomAccessFile reader;
        reader = null;
        try 
        {
            long last;
            last = 0;
            long position;
            position = 0;
            {
                try 
                {
                    reader = new RandomAccessFile(file, RAF_MODE);
                } //End block
                catch (FileNotFoundException e)
                {
                    listener.fileNotFound();
                } //End block
                {
                    try 
                    {
                        Thread.sleep(delayMillis);
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
                {
                    position = end ? file.length() : 0;
                    last = System.currentTimeMillis();
                    reader.seek(position);
                } //End block
            } //End block
            {
                boolean newer;
                newer = FileUtils.isFileNewer(file, last);
                long length;
                length = file.length();
                {
                    listener.fileRotated();
                    try 
                    {
                        RandomAccessFile save;
                        save = reader;
                        reader = new RandomAccessFile(file, RAF_MODE);
                        position = 0;
                        IOUtils.closeQuietly(save);
                    } //End block
                    catch (FileNotFoundException e)
                    {
                        listener.fileNotFound();
                    } //End block
                } //End block
                {
                    {
                        position = readLines(reader);
                        last = System.currentTimeMillis();
                    } //End block
                    {
                        position = 0;
                        reader.seek(position);
                        position = readLines(reader);
                        last = System.currentTimeMillis();
                    } //End block
                } //End block
                {
                    IOUtils.closeQuietly(reader);
                } //End block
                try 
                {
                    Thread.sleep(delayMillis);
                } //End block
                catch (InterruptedException e)
                { }
                {
                    reader = new RandomAccessFile(file, RAF_MODE);
                    reader.seek(position);
                } //End block
            } //End block
        } //End block
        catch (Exception e)
        {
            listener.handle(e);
        } //End block
        finally 
        {
            IOUtils.closeQuietly(reader);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.123 -0400", hash_original_method = "51D98BC23EDBD98D3C1A640CAE368CF4", hash_generated_method = "A99E9D9E7028B77DB889D68C21A6F480")
    public void stop() {
        this.run = false;
        // ---------- Original Method ----------
        //this.run = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.124 -0400", hash_original_method = "BAA3ED875E19911C3E75F2F82717033E", hash_generated_method = "C276E7DC04C2D4D709ECB39A02F55127")
    private long readLines(RandomAccessFile reader) throws IOException {
        StringBuilder sb;
        sb = new StringBuilder();
        long pos;
        pos = reader.getFilePointer();
        long rePos;
        rePos = pos;
        int num;
        boolean seenCR;
        seenCR = false;
        {
            boolean varBFC337348827F24656461C370C538ECF_280228456 = (run && ((num = reader.read(inbuf)) != -1));
            {
                {
                    int i;
                    i = 0;
                    {
                        byte ch;
                        ch = inbuf[i];
                        //Begin case '\n' 
                        seenCR = false;
                        //End case '\n' 
                        //Begin case '\n' 
                        listener.handle(sb.toString());
                        //End case '\n' 
                        //Begin case '\n' 
                        sb.setLength(0);
                        //End case '\n' 
                        //Begin case '\n' 
                        rePos = pos + i + 1;
                        //End case '\n' 
                        //Begin case '\r' 
                        {
                            sb.append('\r');
                        } //End block
                        //End case '\r' 
                        //Begin case '\r' 
                        seenCR = true;
                        //End case '\r' 
                        //Begin case default 
                        {
                            seenCR = false;
                            listener.handle(sb.toString());
                            sb.setLength(0);
                            rePos = pos + i + 1;
                        } //End block
                        //End case default 
                        //Begin case default 
                        sb.append((char) ch);
                        //End case default 
                    } //End block
                } //End collapsed parenthetic
                pos = reader.getFilePointer();
            } //End block
        } //End collapsed parenthetic
        reader.seek(rePos);
        addTaint(reader.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_820979655 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_820979655;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.124 -0400", hash_original_field = "7C6FD57E7084011109D80405DCB6BF31", hash_generated_field = "A36C83AFFB89E024DFB4B33E56C9A1BC")

    private static int DEFAULT_DELAY_MILLIS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.124 -0400", hash_original_field = "12EEA497F6390F2E03089DDDCC1909E3", hash_generated_field = "726A04CFF3B2BD19EA43CFB481032153")

    private static String RAF_MODE = "r";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.124 -0400", hash_original_field = "8E14F38E8601DC226582549919E4927C", hash_generated_field = "969D93282C9B18A5A46B067412916C94")

    private static int DEFAULT_BUFSIZE = 4096;
}

