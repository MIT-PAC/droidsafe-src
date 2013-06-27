package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

public class DelegateFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.563 -0400", hash_original_field = "0B21892525E827C717C0BF1B97DB1F53", hash_generated_field = "3508DB9A679B391304D72C5E2F8C7ED4")

    private FilenameFilter filenameFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.563 -0400", hash_original_field = "DD3C21767F834808110E982822401857", hash_generated_field = "C458D0AE68C90865AFA5E634223F0231")

    private FileFilter fileFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.568 -0400", hash_original_method = "06A6660F6D4FB6BA3833CB3AAC8DFB22", hash_generated_method = "DDA3AFF55F22E2FCEFF7085646460E05")
    public  DelegateFileFilter(FilenameFilter filter) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The FilenameFilter must not be null");
        } //End block
        this.filenameFilter = filter;
        this.fileFilter = null;
        // ---------- Original Method ----------
        //if (filter == null) {
            //throw new IllegalArgumentException("The FilenameFilter must not be null");
        //}
        //this.filenameFilter = filter;
        //this.fileFilter = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.569 -0400", hash_original_method = "D78E0EE5BCA43F28DAC7F37C22E8C1C2", hash_generated_method = "67F844875D43E8DF04666B31093B2758")
    public  DelegateFileFilter(FileFilter filter) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The FileFilter must not be null");
        } //End block
        this.fileFilter = filter;
        this.filenameFilter = null;
        // ---------- Original Method ----------
        //if (filter == null) {
            //throw new IllegalArgumentException("The FileFilter must not be null");
        //}
        //this.fileFilter = filter;
        //this.filenameFilter = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.569 -0400", hash_original_method = "66B0B66E42A219E5BE68409D81797981", hash_generated_method = "203F815476A0D0AC82245655E0B2AD8D")
    @Override
    public boolean accept(File file) {
        {
            boolean var2B418F20FFEE7D76673E383CB25ACBD3_43047417 = (fileFilter.accept(file));
        } //End block
        {
            boolean varCDFF85CE41A2DAC29FF41B261822C377_1942587888 = (super.accept(file));
        } //End block
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556672665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556672665;
        // ---------- Original Method ----------
        //if (fileFilter != null) {
            //return fileFilter.accept(file);
        //} else {
            //return super.accept(file);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.573 -0400", hash_original_method = "49013355B881E412B579D906E9AC6664", hash_generated_method = "7ACFDE2C57145AB597E17FC94789DADC")
    @Override
    public boolean accept(File dir, String name) {
        {
            boolean var845564FB8B8D666082E9C4D6C1DC5970_1002852077 = (filenameFilter.accept(dir, name));
        } //End block
        {
            boolean var5E8120C1715727F7D44E792F61CF882A_298755828 = (super.accept(dir, name));
        } //End block
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973806034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973806034;
        // ---------- Original Method ----------
        //if (filenameFilter != null) {
            //return filenameFilter.accept(dir, name);
        //} else {
            //return super.accept(dir, name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.575 -0400", hash_original_method = "91D8A9301108FBA1FFC97CB499D3FAE9", hash_generated_method = "19F2321203C3DBDE158F8AB78587B958")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_18448776 = null; //Variable for return #1
        String delegate;
        delegate = fileFilter.toString();
        delegate = filenameFilter.toString();
        varB4EAC82CA7396A68D541C85D26508E83_18448776 = super.toString() + "(" + delegate + ")";
        varB4EAC82CA7396A68D541C85D26508E83_18448776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_18448776;
        // ---------- Original Method ----------
        //String delegate = fileFilter != null ? fileFilter.toString() : filenameFilter.toString();
        //return super.toString() + "(" + delegate + ")";
    }

    
}

