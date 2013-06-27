package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public abstract class DirectoryWalker<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.735 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "99CA10E96EFA6F1D261832BBFF205E7D")

    private FileFilter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.736 -0400", hash_original_field = "CB91D77B714E2A14A69EC04A3FA045FB", hash_generated_field = "BEDF8E33C7F5027E6B66B04F2462022E")

    private int depthLimit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.736 -0400", hash_original_method = "4CB8AA7B1D906B7A66A8C8C627A8AF2C", hash_generated_method = "C72A0F0AA2498CC0E4292DF7CB834848")
    protected  DirectoryWalker() {
        this(null, -1);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.736 -0400", hash_original_method = "82DC254ACBE8F57C2B6FDC88A49B1DD4", hash_generated_method = "1867C8B2800EA85F0A2B38524C8EC669")
    protected  DirectoryWalker(FileFilter filter, int depthLimit) {
        this.filter = filter;
        this.depthLimit = depthLimit;
        // ---------- Original Method ----------
        //this.filter = filter;
        //this.depthLimit = depthLimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.737 -0400", hash_original_method = "3BB61858CDEA03D3F86868A10AE4C489", hash_generated_method = "84AD20BBBDED43420B65FBA972A51F42")
    protected  DirectoryWalker(IOFileFilter directoryFilter, IOFileFilter fileFilter, int depthLimit) {
        {
            this.filter = null;
        } //End block
        {
            directoryFilter = directoryFilter != null ? directoryFilter : TrueFileFilter.TRUE;
            fileFilter = fileFilter != null ? fileFilter : TrueFileFilter.TRUE;
            directoryFilter = FileFilterUtils.makeDirectoryOnly(directoryFilter);
            fileFilter = FileFilterUtils.makeFileOnly(fileFilter);
            this.filter = FileFilterUtils.or(directoryFilter, fileFilter);
        } //End block
        this.depthLimit = depthLimit;
        // ---------- Original Method ----------
        //if (directoryFilter == null && fileFilter == null) {
            //this.filter = null;
        //} else {
            //directoryFilter = directoryFilter != null ? directoryFilter : TrueFileFilter.TRUE;
            //fileFilter = fileFilter != null ? fileFilter : TrueFileFilter.TRUE;
            //directoryFilter = FileFilterUtils.makeDirectoryOnly(directoryFilter);
            //fileFilter = FileFilterUtils.makeFileOnly(fileFilter);
            //this.filter = FileFilterUtils.or(directoryFilter, fileFilter);
        //}
        //this.depthLimit = depthLimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.749 -0400", hash_original_method = "F784C612153192C56AC61297D2700D20", hash_generated_method = "A558D7E03367ABCBB09177786F45543E")
    protected final void walk(File startDirectory, Collection<T> results) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Start Directory is null");
        } //End block
        try 
        {
            handleStart(startDirectory, results);
            walk(startDirectory, 0, results);
            handleEnd(results);
        } //End block
        catch (CancelException cancel)
        {
            handleCancelled(startDirectory, results, cancel);
        } //End block
        addTaint(startDirectory.getTaint());
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        //if (startDirectory == null) {
            //throw new NullPointerException("Start Directory is null");
        //}
        //try {
            //handleStart(startDirectory, results);
            //walk(startDirectory, 0, results);
            //handleEnd(results);
        //} catch(CancelException cancel) {
            //handleCancelled(startDirectory, results, cancel);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.798 -0400", hash_original_method = "25CA2BBAEF47FC63779AD366F2A04877", hash_generated_method = "189D88E94F864045AD0550B327ECE8D9")
    private void walk(File directory, int depth, Collection<T> results) throws IOException {
        checkIfCancelled(directory, depth, results);
        {
            boolean var8841E816DCE8E352539EFE2763F7CD93_734965050 = (handleDirectory(directory, depth, results));
            {
                handleDirectoryStart(directory, depth, results);
                int childDepth;
                childDepth = depth + 1;
                {
                    checkIfCancelled(directory, depth, results);
                    File[] childFiles;
                    childFiles = directory.listFiles();
                    childFiles = directory.listFiles(filter);
                    childFiles = filterDirectoryContents(directory, depth, childFiles);
                    {
                        handleRestricted(directory, childDepth, results);
                    } //End block
                    {
                        {
                            File childFile = childFiles[0];
                            {
                                {
                                    boolean varCDB10281E8DDA99847490DB7D79939DB_831067763 = (childFile.isDirectory());
                                    {
                                        walk(childFile, childDepth, results);
                                    } //End block
                                    {
                                        checkIfCancelled(childFile, childDepth, results);
                                        handleFile(childFile, childDepth, results);
                                        checkIfCancelled(childFile, childDepth, results);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                handleDirectoryEnd(directory, depth, results);
            } //End block
        } //End collapsed parenthetic
        checkIfCancelled(directory, depth, results);
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.804 -0400", hash_original_method = "23FD1F1CF1FEA3D76F80B75877CCE06C", hash_generated_method = "22A2655F5CF7CC808782B9AD1FB4DB45")
    protected final void checkIfCancelled(File file, int depth, Collection<T> results) throws IOException {
        {
            boolean varF6899E830889C17B3087A92F71B54042_178115909 = (handleIsCancelled(file, depth, results));
            {
                if (DroidSafeAndroidRuntime.control) throw new CancelException(file, depth);
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        //if (handleIsCancelled(file, depth, results)) {
            //throw new CancelException(file, depth);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.806 -0400", hash_original_method = "65843051E5485209D2DEE1AE215FA6E7", hash_generated_method = "55D016E36720FAB62DD545D66FE87F4E")
    protected boolean handleIsCancelled(
            File file, int depth, Collection<T> results) throws IOException {
        addTaint(file.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_716408421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_716408421;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.815 -0400", hash_original_method = "5C3DB0DDE704B8C64C60715CDC6A77C7", hash_generated_method = "9601C56A729EA30581DA3CD47E4D16AE")
    protected void handleCancelled(File startDirectory, Collection<T> results,
                       CancelException cancel) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw cancel;
        addTaint(startDirectory.getTaint());
        addTaint(results.getTaint());
        addTaint(cancel.getTaint());
        // ---------- Original Method ----------
        //throw cancel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.815 -0400", hash_original_method = "537A66F5B0B2BE829DDB6F4F77A4F783", hash_generated_method = "05DB49881661A300AB5386DA8C53AD2D")
    protected void handleStart(File startDirectory, Collection<T> results) throws IOException {
        addTaint(startDirectory.getTaint());
        addTaint(results.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.816 -0400", hash_original_method = "4574F00D09202C3C6CB0980878ED0B22", hash_generated_method = "43EE7A73A4EA05ABBA447613B43EB28A")
    protected boolean handleDirectory(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867062914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867062914;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.816 -0400", hash_original_method = "20DCFBDA8ADF6765BDFDC314C97D8395", hash_generated_method = "D66A356B60A5414B1A52B8F33A55438A")
    protected void handleDirectoryStart(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.816 -0400", hash_original_method = "5A37259F0EF0B23F2917794B45619826", hash_generated_method = "D6A78FDA8E9B24592E8AD89C203ED618")
    protected File[] filterDirectoryContents(File directory, int depth, File[] files) throws IOException {
        File[] varB4EAC82CA7396A68D541C85D26508E83_1083553180 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1083553180 = files;
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(files[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1083553180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1083553180;
        // ---------- Original Method ----------
        //return files;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.816 -0400", hash_original_method = "487F0A93B3380B56B2E4D4D610050EF1", hash_generated_method = "AD2834367275F0445AB9D00150E55049")
    protected void handleFile(File file, int depth, Collection<T> results) throws IOException {
        addTaint(file.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.817 -0400", hash_original_method = "2285F4C7A21413E552915C4BCF96FB35", hash_generated_method = "5DAF57301400D9DFE84F4C70531D4338")
    protected void handleRestricted(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.817 -0400", hash_original_method = "754F09391C9F58E67CB8193278068D67", hash_generated_method = "DCE0819BDD442375DC466B9C0CE3479C")
    protected void handleDirectoryEnd(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.817 -0400", hash_original_method = "EB432720F1C4A1499C3914FA0FDC8415", hash_generated_method = "941371C919AF2BBAC1229F7C5FD5A147")
    protected void handleEnd(Collection<T> results) throws IOException {
        addTaint(results.getTaint());
        // ---------- Original Method ----------
    }

    
    public static class CancelException extends IOException {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.817 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

        private File file;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.817 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

        private int depth;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.817 -0400", hash_original_method = "79398B5B5BBC055C54453900C8BC0BEE", hash_generated_method = "9039B295B501570B007DF7BD160227E2")
        public  CancelException(File file, int depth) {
            this("Operation Cancelled", file, depth);
            addTaint(file.getTaint());
            addTaint(depth);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.822 -0400", hash_original_method = "F780A988130671754B895961F74E12C5", hash_generated_method = "03164F8731A07A667293563FCC2A5127")
        public  CancelException(String message, File file, int depth) {
            super(message);
            this.file = file;
            this.depth = depth;
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            //this.file = file;
            //this.depth = depth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.831 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "7549991B0F505AFF0A2D7D18C91EC84D")
        public File getFile() {
            File varB4EAC82CA7396A68D541C85D26508E83_180325440 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_180325440 = file;
            varB4EAC82CA7396A68D541C85D26508E83_180325440.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_180325440;
            // ---------- Original Method ----------
            //return file;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.831 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "BE9A1B40BC567BB4D67602CB665B07C2")
        public int getDepth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460563800 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460563800;
            // ---------- Original Method ----------
            //return depth;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.831 -0400", hash_original_field = "510E8163FB8DD438FED70520753861A9", hash_generated_field = "D832B9DB6019FCF2A25C952116E33886")

        private static long serialVersionUID = 1347339620135041008L;
    }


    
}

