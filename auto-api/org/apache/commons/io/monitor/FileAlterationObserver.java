package org.apache.commons.io.monitor;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.NameFileComparator;

public class FileAlterationObserver implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.528 -0400", hash_original_field = "600F106BDB0AB955D79DA95F845D3F81", hash_generated_field = "436A14A63A25ADE4D46FD57CDC506FA0")

    private final List<FileAlterationListener> listeners = new CopyOnWriteArrayList<FileAlterationListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.528 -0400", hash_original_field = "A854F3EE9A56B8FAE23747F3F458A0F2", hash_generated_field = "D4E9B8247C7F7B78EC9C2DA270FD3257")

    private FileEntry rootEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.528 -0400", hash_original_field = "DD3C21767F834808110E982822401857", hash_generated_field = "C458D0AE68C90865AFA5E634223F0231")

    private FileFilter fileFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.528 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "FC15902F9B4E6313D228A429CAFF0464")

    private Comparator<File> comparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.529 -0400", hash_original_method = "85142D2E9E15EB93CC97B3004876EC03", hash_generated_method = "50F095BD0A7998744329877641CADE45")
    public  FileAlterationObserver(String directoryName) {
        this(new File(directoryName));
        addTaint(directoryName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.529 -0400", hash_original_method = "F892F249392A40C312747AD59BC47A28", hash_generated_method = "44E7A575CD58A3319B41BBF3FF3774D9")
    public  FileAlterationObserver(String directoryName, FileFilter fileFilter) {
        this(new File(directoryName), fileFilter);
        addTaint(directoryName.getTaint());
        addTaint(fileFilter.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.529 -0400", hash_original_method = "9E22246A2C5798ECAD21C20531550DBC", hash_generated_method = "76DDD76E1B093F0996D22F8233694B10")
    public  FileAlterationObserver(String directoryName, FileFilter fileFilter, IOCase caseSensitivity) {
        this(new File(directoryName), fileFilter, caseSensitivity);
        addTaint(directoryName.getTaint());
        addTaint(fileFilter.getTaint());
        addTaint(caseSensitivity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.530 -0400", hash_original_method = "DEF389DDBAFE974EA51118829F85145D", hash_generated_method = "D546A0286087570584EA3DE1EF59D506")
    public  FileAlterationObserver(File directory) {
        this(directory, (FileFilter)null);
        addTaint(directory.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.530 -0400", hash_original_method = "02DF7858712779AF42E2C656508DDF5D", hash_generated_method = "796153EB32F20280517A1AFA5801D08A")
    public  FileAlterationObserver(File directory, FileFilter fileFilter) {
        this(directory, fileFilter, (IOCase)null);
        addTaint(directory.getTaint());
        addTaint(fileFilter.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.530 -0400", hash_original_method = "333A7F04CF3A5003336C33F84636E75C", hash_generated_method = "8EC13386351E1A2A225ECA40FF5E9F4E")
    public  FileAlterationObserver(File directory, FileFilter fileFilter, IOCase caseSensitivity) {
        this(new FileEntry(directory), fileFilter, caseSensitivity);
        addTaint(directory.getTaint());
        addTaint(fileFilter.getTaint());
        addTaint(caseSensitivity.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.531 -0400", hash_original_method = "70863C8791AB5339C3CC7588D2279663", hash_generated_method = "24778EDF6695E7B37E9902F1D6ABA7FF")
    protected  FileAlterationObserver(FileEntry rootEntry, FileFilter fileFilter, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Root entry is missing");
        } //End block
        {
            boolean var27BE18B80E8F0D102B1E6E7E98BABBE7_1326020215 = (rootEntry.getFile() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Root directory is missing");
            } //End block
        } //End collapsed parenthetic
        this.rootEntry = rootEntry;
        this.fileFilter = fileFilter;
        {
            boolean var600CCB7F82076DA43694DA3FF80D166E_690877955 = (caseSensitivity == null || caseSensitivity.equals(IOCase.SYSTEM));
            {
                this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
            } //End block
            {
                boolean varD4783CEBAE788DBFFAFFC05E56E459BC_1907023935 = (caseSensitivity.equals(IOCase.INSENSITIVE));
                {
                    this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
                } //End block
                {
                    this.comparator = NameFileComparator.NAME_COMPARATOR;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(caseSensitivity.getTaint());
        // ---------- Original Method ----------
        //if (rootEntry == null) {
            //throw new IllegalArgumentException("Root entry is missing");
        //}
        //if (rootEntry.getFile() == null) {
            //throw new IllegalArgumentException("Root directory is missing");
        //}
        //this.rootEntry = rootEntry;
        //this.fileFilter = fileFilter;
        //if (caseSensitivity == null || caseSensitivity.equals(IOCase.SYSTEM)) {
            //this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
        //} else if (caseSensitivity.equals(IOCase.INSENSITIVE)) {
            //this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
        //} else {
            //this.comparator = NameFileComparator.NAME_COMPARATOR;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.533 -0400", hash_original_method = "F73AEFE1AB5323ED9772F8703FAEA777", hash_generated_method = "B7B3BA0F29D935E5171F9782F52CFD1F")
    public File getDirectory() {
        File varB4EAC82CA7396A68D541C85D26508E83_509830816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_509830816 = rootEntry.getFile();
        varB4EAC82CA7396A68D541C85D26508E83_509830816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_509830816;
        // ---------- Original Method ----------
        //return rootEntry.getFile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.535 -0400", hash_original_method = "43FBDA01B5178A1D9F1E040192C2235F", hash_generated_method = "4923DDAC4AADC9BCCC46DD9D90B8020D")
    public FileFilter getFileFilter() {
        FileFilter varB4EAC82CA7396A68D541C85D26508E83_1689338310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1689338310 = fileFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1689338310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689338310;
        // ---------- Original Method ----------
        //return fileFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.535 -0400", hash_original_method = "73C8C648F9EEF7928CF4A988A690F21C", hash_generated_method = "8FD1B0D135378F9EE876A78AFAC85AF6")
    public void addListener(final FileAlterationListener listener) {
        {
            listeners.add(listener);
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener != null) {
            //listeners.add(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.536 -0400", hash_original_method = "337F97E355478FB0C577C0667066B06F", hash_generated_method = "FCFD474DD9B11CFC1A477786C91A8B10")
    public void removeListener(final FileAlterationListener listener) {
        {
            {
                boolean var9C0AAB17B0196A7AA0288F72D83D9EA6_631107428 = (listeners.remove(listener));
            } //End collapsed parenthetic
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener != null) {
            //while (listeners.remove(listener)) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.536 -0400", hash_original_method = "741BFB949D17995C1AB7AD1C5062B240", hash_generated_method = "2E814221C03E67061A733AC79A544054")
    public Iterable<FileAlterationListener> getListeners() {
        Iterable<FileAlterationListener> varB4EAC82CA7396A68D541C85D26508E83_94521064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_94521064 = listeners;
        varB4EAC82CA7396A68D541C85D26508E83_94521064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_94521064;
        // ---------- Original Method ----------
        //return listeners;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.537 -0400", hash_original_method = "65389FBCC8B0D4443CC183F594B0559D", hash_generated_method = "7D5F7859E60D95C25D83DC50E93FF173")
    public void initialize() throws Exception {
        rootEntry.refresh(rootEntry.getFile());
        File[] files = listFiles(rootEntry.getFile());
        FileEntry[] children;
        children = new FileEntry[files.length];
        children = FileEntry.EMPTY_ENTRIES;
        {
            int i = 0;
            {
                children[i] = createFileEntry(rootEntry, files[i]);
            } //End block
        } //End collapsed parenthetic
        rootEntry.setChildren(children);
        // ---------- Original Method ----------
        //rootEntry.refresh(rootEntry.getFile());
        //File[] files = listFiles(rootEntry.getFile());
        //FileEntry[] children = files.length > 0 ? new FileEntry[files.length] : FileEntry.EMPTY_ENTRIES;
        //for (int i = 0; i < files.length; i++) {
            //children[i] = createFileEntry(rootEntry, files[i]);
        //}
        //rootEntry.setChildren(children);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.537 -0400", hash_original_method = "19B94458987093A18E35F94275820DB1", hash_generated_method = "1115C0CC7FE1CA407486B58CF2D14679")
    public void destroy() throws Exception {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.539 -0400", hash_original_method = "28C4BDB6A5F83B4A2D726F32ED4863B2", hash_generated_method = "E8C818808BCFF07167B8AD8683BBAAD8")
    public void checkAndNotify() {
        {
            Iterator<FileAlterationListener> var8E104C34412D5B8AE6CD5EB2F6F9669A_15405628 = (listeners).iterator();
            var8E104C34412D5B8AE6CD5EB2F6F9669A_15405628.hasNext();
            FileAlterationListener listener = var8E104C34412D5B8AE6CD5EB2F6F9669A_15405628.next();
            {
                listener.onStart(this);
            } //End block
        } //End collapsed parenthetic
        File rootFile = rootEntry.getFile();
        {
            boolean var34F7C2D1458DCEC4DEADCFD9E5B36F27_335780466 = (rootFile.exists());
            {
                checkAndNotify(rootEntry, rootEntry.getChildren(), listFiles(rootFile));
            } //End block
            {
                boolean var86729E4CD65667DE3FB6B042A27CDE64_1206283459 = (rootEntry.isExists());
                {
                    checkAndNotify(rootEntry, rootEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            Iterator<FileAlterationListener> var8E104C34412D5B8AE6CD5EB2F6F9669A_1987009770 = (listeners).iterator();
            var8E104C34412D5B8AE6CD5EB2F6F9669A_1987009770.hasNext();
            FileAlterationListener listener = var8E104C34412D5B8AE6CD5EB2F6F9669A_1987009770.next();
            {
                listener.onStop(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (FileAlterationListener listener : listeners) {
            //listener.onStart(this);
        //}
        //File rootFile = rootEntry.getFile();
        //if (rootFile.exists()) {
            //checkAndNotify(rootEntry, rootEntry.getChildren(), listFiles(rootFile));
        //} else if (rootEntry.isExists()) {
            //checkAndNotify(rootEntry, rootEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        //} else {
        //}
        //for (FileAlterationListener listener : listeners) {
            //listener.onStop(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.540 -0400", hash_original_method = "14229043FF7E6DA90FB3DBFED2A622C0", hash_generated_method = "0D67C75F13D0177C967A6437A9E5C900")
    private void checkAndNotify(FileEntry parent, FileEntry[] previous, File[] files) {
        int c = 0;
        FileEntry[] current;
        current = new FileEntry[files.length];
        current = FileEntry.EMPTY_ENTRIES;
        {
            Iterator<FileEntry> var32EAF1A205A6B67AE57CE0126E90A48C_1823607417 = (previous).iterator();
            var32EAF1A205A6B67AE57CE0126E90A48C_1823607417.hasNext();
            FileEntry entry = var32EAF1A205A6B67AE57CE0126E90A48C_1823607417.next();
            {
                {
                    boolean varE9BD51A50E572F7B05CDD34D98F98C4D_1286497990 = (c < files.length && comparator.compare(entry.getFile(), files[c]) > 0);
                    {
                        current[c] = createFileEntry(parent, files[c]);
                        doCreate(current[c]);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var6C3CDED720024D71CC404F74F924C7C4_1003117784 = (c < files.length && comparator.compare(entry.getFile(), files[c]) == 0);
                    {
                        doMatch(entry, files[c]);
                        checkAndNotify(entry, entry.getChildren(), listFiles(files[c]));
                        current[c] = entry;
                    } //End block
                    {
                        checkAndNotify(entry, entry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
                        doDelete(entry);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            current[c] = createFileEntry(parent, files[c]);
            doCreate(current[c]);
        } //End block
        parent.setChildren(current);
        addTaint(parent.getTaint());
        addTaint(previous[0].getTaint());
        addTaint(files[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.541 -0400", hash_original_method = "9FB34A64AFD23F37DE49FF2A86984A48", hash_generated_method = "3FB8D96012C40ACB9D601AF082A00065")
    private FileEntry createFileEntry(FileEntry parent, File file) {
        FileEntry varB4EAC82CA7396A68D541C85D26508E83_2063743778 = null; //Variable for return #1
        FileEntry entry = parent.newChildInstance(file);
        entry.refresh(file);
        File[] files = listFiles(file);
        FileEntry[] children;
        children = new FileEntry[files.length];
        children = FileEntry.EMPTY_ENTRIES;
        {
            int i = 0;
            {
                children[i] = createFileEntry(entry, files[i]);
            } //End block
        } //End collapsed parenthetic
        entry.setChildren(children);
        varB4EAC82CA7396A68D541C85D26508E83_2063743778 = entry;
        addTaint(parent.getTaint());
        addTaint(file.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2063743778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2063743778;
        // ---------- Original Method ----------
        //FileEntry entry = parent.newChildInstance(file);
        //entry.refresh(file);
        //File[] files = listFiles(file);
        //FileEntry[] children = files.length > 0 ? new FileEntry[files.length] : FileEntry.EMPTY_ENTRIES;
        //for (int i = 0; i < files.length; i++) {
            //children[i] = createFileEntry(entry, files[i]);
        //}
        //entry.setChildren(children);
        //return entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.543 -0400", hash_original_method = "C0CBB028B302FA13274EDDF227B1F519", hash_generated_method = "DBE82C999FBCF58222586EA18881415E")
    private void doCreate(FileEntry entry) {
        {
            Iterator<FileAlterationListener> var8E104C34412D5B8AE6CD5EB2F6F9669A_193747540 = (listeners).iterator();
            var8E104C34412D5B8AE6CD5EB2F6F9669A_193747540.hasNext();
            FileAlterationListener listener = var8E104C34412D5B8AE6CD5EB2F6F9669A_193747540.next();
            {
                {
                    boolean var60598B904650B99D6E3C566B25F582B1_1195990910 = (entry.isDirectory());
                    {
                        listener.onDirectoryCreate(entry.getFile());
                    } //End block
                    {
                        listener.onFileCreate(entry.getFile());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        FileEntry[] children = entry.getChildren();
        {
            Iterator<FileEntry> varC6D88E1ACDE979EF8C38B0DDE799528E_940966673 = (children).iterator();
            varC6D88E1ACDE979EF8C38B0DDE799528E_940966673.hasNext();
            FileEntry aChildren = varC6D88E1ACDE979EF8C38B0DDE799528E_940966673.next();
            {
                doCreate(aChildren);
            } //End block
        } //End collapsed parenthetic
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
        //for (FileAlterationListener listener : listeners) {
            //if (entry.isDirectory()) {
                //listener.onDirectoryCreate(entry.getFile());
            //} else {
                //listener.onFileCreate(entry.getFile());
            //}
        //}
        //FileEntry[] children = entry.getChildren();
        //for (FileEntry aChildren : children) {
            //doCreate(aChildren);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.546 -0400", hash_original_method = "D3512EAF0EBFD0769AB6296F9B118176", hash_generated_method = "FE14B2FE10052F571D41E641E5AFC2D3")
    private void doMatch(FileEntry entry, File file) {
        {
            boolean var945EDB2E62FE6D251D07853B01F40E99_529925288 = (entry.refresh(file));
            {
                {
                    Iterator<FileAlterationListener> var8E104C34412D5B8AE6CD5EB2F6F9669A_1138392894 = (listeners).iterator();
                    var8E104C34412D5B8AE6CD5EB2F6F9669A_1138392894.hasNext();
                    FileAlterationListener listener = var8E104C34412D5B8AE6CD5EB2F6F9669A_1138392894.next();
                    {
                        {
                            boolean var7853AEDEECF514D4BB8301BEC2530283_1652735182 = (entry.isDirectory());
                            {
                                listener.onDirectoryChange(file);
                            } //End block
                            {
                                listener.onFileChange(file);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(entry.getTaint());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
        //if (entry.refresh(file)) {
            //for (FileAlterationListener listener : listeners) {
                //if (entry.isDirectory()) {
                    //listener.onDirectoryChange(file);
                //} else {
                    //listener.onFileChange(file);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.547 -0400", hash_original_method = "DDAF62E14AD15FA9537A3140BB7EB191", hash_generated_method = "F0B9371D57ED039F76A550179FD6015F")
    private void doDelete(FileEntry entry) {
        {
            Iterator<FileAlterationListener> var8E104C34412D5B8AE6CD5EB2F6F9669A_2013103202 = (listeners).iterator();
            var8E104C34412D5B8AE6CD5EB2F6F9669A_2013103202.hasNext();
            FileAlterationListener listener = var8E104C34412D5B8AE6CD5EB2F6F9669A_2013103202.next();
            {
                {
                    boolean var60598B904650B99D6E3C566B25F582B1_1827099358 = (entry.isDirectory());
                    {
                        listener.onDirectoryDelete(entry.getFile());
                    } //End block
                    {
                        listener.onFileDelete(entry.getFile());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
        //for (FileAlterationListener listener : listeners) {
            //if (entry.isDirectory()) {
                //listener.onDirectoryDelete(entry.getFile());
            //} else {
                //listener.onFileDelete(entry.getFile());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.548 -0400", hash_original_method = "0F27C92B37DFB10D975FFB8810CF21BD", hash_generated_method = "BBD00EDA239C1C2272D1B6BA81458298")
    private File[] listFiles(File file) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_592675555 = null; //Variable for return #1
        File[] children = null;
        {
            boolean varB4EF7A82C29897D1EBAB65E15CCB5408_1299601291 = (file.isDirectory());
            {
                children = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            } //End block
        } //End collapsed parenthetic
        {
            children = FileUtils.EMPTY_FILE_ARRAY;
        } //End block
        {
            Arrays.sort(children, comparator);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_592675555 = children;
        addTaint(file.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_592675555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592675555;
        // ---------- Original Method ----------
        //File[] children = null;
        //if (file.isDirectory()) {
            //children = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        //}
        //if (children == null) {
            //children = FileUtils.EMPTY_FILE_ARRAY;
        //}
        //if (comparator != null && children.length > 1) {
            //Arrays.sort(children, comparator);
        //}
        //return children;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.549 -0400", hash_original_method = "B829940FDDA83108C12ADCFE12967B77", hash_generated_method = "F0D514FE8A552B1F3AA773B303174B41")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_228436652 = null; //Variable for return #1
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append("[file='");
        builder.append(getDirectory().getPath());
        builder.append('\'');
        {
            builder.append(", ");
            builder.append(fileFilter.toString());
        } //End block
        builder.append(", listeners=");
        builder.append(listeners.size());
        builder.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_228436652 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_228436652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_228436652;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append(getClass().getSimpleName());
        //builder.append("[file='");
        //builder.append(getDirectory().getPath());
        //builder.append('\'');
        //if (fileFilter != null) {
            //builder.append(", ");
            //builder.append(fileFilter.toString());
        //}
        //builder.append(", listeners=");
        //builder.append(listeners.size());
        //builder.append("]");
        //return builder.toString();
    }

    
}

