package org.apache.commons.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public abstract class DirectoryWalker<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.241 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "99CA10E96EFA6F1D261832BBFF205E7D")

    private FileFilter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.241 -0400", hash_original_field = "CB91D77B714E2A14A69EC04A3FA045FB", hash_generated_field = "BEDF8E33C7F5027E6B66B04F2462022E")

    private int depthLimit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.241 -0400", hash_original_method = "4CB8AA7B1D906B7A66A8C8C627A8AF2C", hash_generated_method = "C72A0F0AA2498CC0E4292DF7CB834848")
    protected  DirectoryWalker() {
        this(null, -1);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.242 -0400", hash_original_method = "82DC254ACBE8F57C2B6FDC88A49B1DD4", hash_generated_method = "1867C8B2800EA85F0A2B38524C8EC669")
    protected  DirectoryWalker(FileFilter filter, int depthLimit) {
        this.filter = filter;
        this.depthLimit = depthLimit;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.242 -0400", hash_original_method = "3BB61858CDEA03D3F86868A10AE4C489", hash_generated_method = "84AD20BBBDED43420B65FBA972A51F42")
    protected  DirectoryWalker(IOFileFilter directoryFilter, IOFileFilter fileFilter, int depthLimit) {
        {
            this.filter = null;
        } 
        {
            directoryFilter = directoryFilter != null ? directoryFilter : TrueFileFilter.TRUE;
            fileFilter = fileFilter != null ? fileFilter : TrueFileFilter.TRUE;
            directoryFilter = FileFilterUtils.makeDirectoryOnly(directoryFilter);
            fileFilter = FileFilterUtils.makeFileOnly(fileFilter);
            this.filter = FileFilterUtils.or(directoryFilter, fileFilter);
        } 
        this.depthLimit = depthLimit;
        
        
            
        
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.243 -0400", hash_original_method = "F784C612153192C56AC61297D2700D20", hash_generated_method = "A558D7E03367ABCBB09177786F45543E")
    protected final void walk(File startDirectory, Collection<T> results) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Start Directory is null");
        } 
        try 
        {
            handleStart(startDirectory, results);
            walk(startDirectory, 0, results);
            handleEnd(results);
        } 
        catch (CancelException cancel)
        {
            handleCancelled(startDirectory, results, cancel);
        } 
        addTaint(startDirectory.getTaint());
        addTaint(results.getTaint());
        
        
            
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.249 -0400", hash_original_method = "25CA2BBAEF47FC63779AD366F2A04877", hash_generated_method = "5C51E5C4AC899686CA3A4F20B89A0788")
    private void walk(File directory, int depth, Collection<T> results) throws IOException {
        checkIfCancelled(directory, depth, results);
        {
            boolean var8841E816DCE8E352539EFE2763F7CD93_1542766142 = (handleDirectory(directory, depth, results));
            {
                handleDirectoryStart(directory, depth, results);
                int childDepth = depth + 1;
                {
                    checkIfCancelled(directory, depth, results);
                    File[] childFiles;
                    childFiles = directory.listFiles();
                    childFiles = directory.listFiles(filter);
                    childFiles = filterDirectoryContents(directory, depth, childFiles);
                    {
                        handleRestricted(directory, childDepth, results);
                    } 
                    {
                        {
                            File childFile = childFiles[0];
                            {
                                {
                                    boolean varCDB10281E8DDA99847490DB7D79939DB_774896618 = (childFile.isDirectory());
                                    {
                                        walk(childFile, childDepth, results);
                                    } 
                                    {
                                        checkIfCancelled(childFile, childDepth, results);
                                        handleFile(childFile, childDepth, results);
                                        checkIfCancelled(childFile, childDepth, results);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                handleDirectoryEnd(directory, depth, results);
            } 
        } 
        checkIfCancelled(directory, depth, results);
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.249 -0400", hash_original_method = "23FD1F1CF1FEA3D76F80B75877CCE06C", hash_generated_method = "C52C5F37F4FF1F0C7A66ACD96BD40B7D")
    protected final void checkIfCancelled(File file, int depth, Collection<T> results) throws IOException {
        {
            boolean varF6899E830889C17B3087A92F71B54042_1741418089 = (handleIsCancelled(file, depth, results));
            {
                if (DroidSafeAndroidRuntime.control) throw new CancelException(file, depth);
            } 
        } 
        addTaint(file.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.250 -0400", hash_original_method = "65843051E5485209D2DEE1AE215FA6E7", hash_generated_method = "9937940271C6E68A6571DF8398FA04B8")
    protected boolean handleIsCancelled(
            File file, int depth, Collection<T> results) throws IOException {
        addTaint(file.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128736358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128736358;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.250 -0400", hash_original_method = "5C3DB0DDE704B8C64C60715CDC6A77C7", hash_generated_method = "9601C56A729EA30581DA3CD47E4D16AE")
    protected void handleCancelled(File startDirectory, Collection<T> results,
                       CancelException cancel) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw cancel;
        addTaint(startDirectory.getTaint());
        addTaint(results.getTaint());
        addTaint(cancel.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.250 -0400", hash_original_method = "537A66F5B0B2BE829DDB6F4F77A4F783", hash_generated_method = "05DB49881661A300AB5386DA8C53AD2D")
    protected void handleStart(File startDirectory, Collection<T> results) throws IOException {
        addTaint(startDirectory.getTaint());
        addTaint(results.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.250 -0400", hash_original_method = "4574F00D09202C3C6CB0980878ED0B22", hash_generated_method = "2A4C1171CB8CB6BCC2620F1596479D56")
    protected boolean handleDirectory(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668998752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668998752;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.251 -0400", hash_original_method = "20DCFBDA8ADF6765BDFDC314C97D8395", hash_generated_method = "D66A356B60A5414B1A52B8F33A55438A")
    protected void handleDirectoryStart(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.251 -0400", hash_original_method = "5A37259F0EF0B23F2917794B45619826", hash_generated_method = "A0ED270B169D58883ECA2B1BDEDF1A2D")
    protected File[] filterDirectoryContents(File directory, int depth, File[] files) throws IOException {
        File[] varB4EAC82CA7396A68D541C85D26508E83_1710624276 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1710624276 = files;
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(files[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1710624276.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1710624276;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.251 -0400", hash_original_method = "487F0A93B3380B56B2E4D4D610050EF1", hash_generated_method = "AD2834367275F0445AB9D00150E55049")
    protected void handleFile(File file, int depth, Collection<T> results) throws IOException {
        addTaint(file.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.251 -0400", hash_original_method = "2285F4C7A21413E552915C4BCF96FB35", hash_generated_method = "5DAF57301400D9DFE84F4C70531D4338")
    protected void handleRestricted(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.252 -0400", hash_original_method = "754F09391C9F58E67CB8193278068D67", hash_generated_method = "DCE0819BDD442375DC466B9C0CE3479C")
    protected void handleDirectoryEnd(File directory, int depth, Collection<T> results) throws IOException {
        addTaint(directory.getTaint());
        addTaint(depth);
        addTaint(results.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.252 -0400", hash_original_method = "EB432720F1C4A1499C3914FA0FDC8415", hash_generated_method = "941371C919AF2BBAC1229F7C5FD5A147")
    protected void handleEnd(Collection<T> results) throws IOException {
        addTaint(results.getTaint());
        
    }

    
    public static class CancelException extends IOException {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.252 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

        private File file;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.252 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

        private int depth;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.252 -0400", hash_original_method = "79398B5B5BBC055C54453900C8BC0BEE", hash_generated_method = "9039B295B501570B007DF7BD160227E2")
        public  CancelException(File file, int depth) {
            this("Operation Cancelled", file, depth);
            addTaint(file.getTaint());
            addTaint(depth);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.252 -0400", hash_original_method = "F780A988130671754B895961F74E12C5", hash_generated_method = "03164F8731A07A667293563FCC2A5127")
        public  CancelException(String message, File file, int depth) {
            super(message);
            this.file = file;
            this.depth = depth;
            addTaint(message.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.253 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "112117E7609CC82D10412331FA79D64F")
        public File getFile() {
            File varB4EAC82CA7396A68D541C85D26508E83_1174943673 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1174943673 = file;
            varB4EAC82CA7396A68D541C85D26508E83_1174943673.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1174943673;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.254 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "40AE4AA119C7A8A26530E3673207A2BC")
        public int getDepth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140355782 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140355782;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:30.254 -0400", hash_original_field = "510E8163FB8DD438FED70520753861A9", hash_generated_field = "B3CBF0B8DBDBC6A43D0D72C82A083AAF")

        private static final long serialVersionUID = 1347339620135041008L;
    }


    
}

