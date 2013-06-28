package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class PrefixFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.911 -0400", hash_original_field = "735E5189FAD047C92AC9F292E73ED303", hash_generated_field = "9B3455D756A1FBC6C82117FF303199E2")

    private String[] prefixes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.912 -0400", hash_original_field = "9AE1535F968174A45A688181FD26E8A9", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private IOCase caseSensitivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.912 -0400", hash_original_method = "0F22F1E3EA36EA07744483A876CD465E", hash_generated_method = "A661BA3693F1A1F72ED4AF99FDE88179")
    public  PrefixFileFilter(String prefix) {
        this(prefix, IOCase.SENSITIVE);
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.916 -0400", hash_original_method = "9637A33C3A7BEA20E1ACB7D7F032CE22", hash_generated_method = "F1E7C9490AD16322618EBEE81E717239")
    public  PrefixFileFilter(String prefix, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The prefix must not be null");
        } //End block
        this.prefixes = new String[] {prefix};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //if (prefix == null) {
            //throw new IllegalArgumentException("The prefix must not be null");
        //}
        //this.prefixes = new String[] {prefix};
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.917 -0400", hash_original_method = "CAEC80FD980017DE24EC23E6474A88F7", hash_generated_method = "4401A0A0636B51EAC25ADE9EB9BD53C6")
    public  PrefixFileFilter(String[] prefixes) {
        this(prefixes, IOCase.SENSITIVE);
        addTaint(prefixes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.917 -0400", hash_original_method = "5F192DCF259BEB4C8D9ED2CF41E6957A", hash_generated_method = "AC24B04D32035685BF27ECCCCA0EF5A8")
    public  PrefixFileFilter(String[] prefixes, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The array of prefixes must not be null");
        } //End block
        this.prefixes = new String[prefixes.length];
        System.arraycopy(prefixes, 0, this.prefixes, 0, prefixes.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //if (prefixes == null) {
            //throw new IllegalArgumentException("The array of prefixes must not be null");
        //}
        //this.prefixes = new String[prefixes.length];
        //System.arraycopy(prefixes, 0, this.prefixes, 0, prefixes.length);
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.917 -0400", hash_original_method = "2B4329C45C54F0B405A84480F694219F", hash_generated_method = "BFE1D0660ED49E183A736107D660FC08")
    public  PrefixFileFilter(List<String> prefixes) {
        this(prefixes, IOCase.SENSITIVE);
        addTaint(prefixes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.918 -0400", hash_original_method = "ACDB1E0F1106ED25DED903F3FAD064F0", hash_generated_method = "E20F8B84A2C6D87A371D6569DA0D4199")
    public  PrefixFileFilter(List<String> prefixes, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The list of prefixes must not be null");
        } //End block
        this.prefixes = prefixes.toArray(new String[prefixes.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //if (prefixes == null) {
            //throw new IllegalArgumentException("The list of prefixes must not be null");
        //}
        //this.prefixes = prefixes.toArray(new String[prefixes.size()]);
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.921 -0400", hash_original_method = "78167C09373DD6928792D289D7DC6BD6", hash_generated_method = "860A2EE9DE5A9F239835421ABE143CB6")
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        {
            Iterator<String> var98C669A857944B4526CB9DC2FE1EC119_1607582392 = (this.prefixes).iterator();
            var98C669A857944B4526CB9DC2FE1EC119_1607582392.hasNext();
            String prefix = var98C669A857944B4526CB9DC2FE1EC119_1607582392.next();
            {
                {
                    boolean var112396BEC915222BC05CB4EFD4DD6376_788313734 = (caseSensitivity.checkStartsWith(name, prefix));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312946744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312946744;
        // ---------- Original Method ----------
        //String name = file.getName();
        //for (String prefix : this.prefixes) {
            //if (caseSensitivity.checkStartsWith(name, prefix)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.924 -0400", hash_original_method = "45A7DB6D0E51F61500372E7D66178EF3", hash_generated_method = "0A85295E1387D9DC1A64B94C70A1F3FA")
    @Override
    public boolean accept(File file, String name) {
        {
            Iterator<String> var00D98A86401AE6211A371DB8CDF5D96D_1295123264 = (prefixes).iterator();
            var00D98A86401AE6211A371DB8CDF5D96D_1295123264.hasNext();
            String prefix = var00D98A86401AE6211A371DB8CDF5D96D_1295123264.next();
            {
                {
                    boolean var112396BEC915222BC05CB4EFD4DD6376_1012003643 = (caseSensitivity.checkStartsWith(name, prefix));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594620099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_594620099;
        // ---------- Original Method ----------
        //for (String prefix : prefixes) {
            //if (caseSensitivity.checkStartsWith(name, prefix)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.925 -0400", hash_original_method = "93C8E32B6EE68EAE0C3BFC84A4183EBE", hash_generated_method = "C6B4C1A13DA537F7ADB50843877E4667")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1996461178 = null; //Variable for return #1
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i = 0;
                {
                    {
                        buffer.append(",");
                    } //End block
                    buffer.append(prefixes[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        buffer.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_1996461178 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1996461178.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1996461178;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append(super.toString());
        //buffer.append("(");
        //if (prefixes != null) {
            //for (int i = 0; i < prefixes.length; i++) {
                //if (i > 0) {
                    //buffer.append(",");
                //}
                //buffer.append(prefixes[i]);
            //}
        //}
        //buffer.append(")");
        //return buffer.toString();
    }

    
}

