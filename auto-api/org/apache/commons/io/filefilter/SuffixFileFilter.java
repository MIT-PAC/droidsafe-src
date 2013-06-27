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

public class SuffixFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.799 -0400", hash_original_field = "AA1FB6808A200D35FFFC21ECB13CFDD7", hash_generated_field = "2F80320574B22A6AB3C8EF150A4751E0")

    private String[] suffixes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.799 -0400", hash_original_field = "9AE1535F968174A45A688181FD26E8A9", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private IOCase caseSensitivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.801 -0400", hash_original_method = "26ECE614E5AA8C4631792CFFDE54B2CE", hash_generated_method = "8242C30713D280FC963E2E35216FE1EC")
    public  SuffixFileFilter(String suffix) {
        this(suffix, IOCase.SENSITIVE);
        addTaint(suffix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.806 -0400", hash_original_method = "18E79F17CEA62402EC9F3F15F922D012", hash_generated_method = "80E18B7DF7339FB812103496E490A6F4")
    public  SuffixFileFilter(String suffix, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The suffix must not be null");
        } //End block
        this.suffixes = new String[] {suffix};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        addTaint(suffix.getTaint());
        // ---------- Original Method ----------
        //if (suffix == null) {
            //throw new IllegalArgumentException("The suffix must not be null");
        //}
        //this.suffixes = new String[] {suffix};
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.806 -0400", hash_original_method = "27ADFB4EAA62C71913507B549D4CAC10", hash_generated_method = "50F1D8ACB5F3EC8C3A01C149328D569B")
    public  SuffixFileFilter(String[] suffixes) {
        this(suffixes, IOCase.SENSITIVE);
        addTaint(suffixes[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.807 -0400", hash_original_method = "9EF81A5837AC6374818AE9B0FFBE4DBD", hash_generated_method = "094F153436B4C77C4FD22392668AF97D")
    public  SuffixFileFilter(String[] suffixes, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The array of suffixes must not be null");
        } //End block
        this.suffixes = new String[suffixes.length];
        System.arraycopy(suffixes, 0, this.suffixes, 0, suffixes.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //if (suffixes == null) {
            //throw new IllegalArgumentException("The array of suffixes must not be null");
        //}
        //this.suffixes = new String[suffixes.length];
        //System.arraycopy(suffixes, 0, this.suffixes, 0, suffixes.length);
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.807 -0400", hash_original_method = "B0EA15F3C965ED431DBF52EB2A883915", hash_generated_method = "CC265F24F6B134DB7902C94EAFF4DD58")
    public  SuffixFileFilter(List<String> suffixes) {
        this(suffixes, IOCase.SENSITIVE);
        addTaint(suffixes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.808 -0400", hash_original_method = "CEC383E8BE8AD02DFB1E0F8E166802C6", hash_generated_method = "88F850F7548775D1861A5399FA7AEA4A")
    public  SuffixFileFilter(List<String> suffixes, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The list of suffixes must not be null");
        } //End block
        this.suffixes = suffixes.toArray(new String[suffixes.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //if (suffixes == null) {
            //throw new IllegalArgumentException("The list of suffixes must not be null");
        //}
        //this.suffixes = suffixes.toArray(new String[suffixes.size()]);
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.831 -0400", hash_original_method = "5E16E41D2D30710800B0664BA6AD31F5", hash_generated_method = "3DFC9E8BB41EA4904BE269292983C846")
    @Override
    public boolean accept(File file) {
        String name;
        name = file.getName();
        {
            String suffix = this.suffixes[0];
            {
                {
                    boolean var22B2758D82567F3246F8B222D166600F_420285979 = (caseSensitivity.checkEndsWith(name, suffix));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304631263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304631263;
        // ---------- Original Method ----------
        //String name = file.getName();
        //for (String suffix : this.suffixes) {
            //if (caseSensitivity.checkEndsWith(name, suffix)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.871 -0400", hash_original_method = "850FABEC2D0BD7FBD751AF5978866C44", hash_generated_method = "5EFA9C61E688C1ADC3EABDF99153301C")
    @Override
    public boolean accept(File file, String name) {
        {
            Iterator<String> var9046116BDA63CCD0C4F42BB25A52E91B_1668771044 = (this.suffixes).iterator();
            var9046116BDA63CCD0C4F42BB25A52E91B_1668771044.hasNext();
            String suffix = var9046116BDA63CCD0C4F42BB25A52E91B_1668771044.next();
            {
                {
                    boolean var22B2758D82567F3246F8B222D166600F_36288311 = (caseSensitivity.checkEndsWith(name, suffix));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221782649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221782649;
        // ---------- Original Method ----------
        //for (String suffix : this.suffixes) {
            //if (caseSensitivity.checkEndsWith(name, suffix)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.872 -0400", hash_original_method = "A7E4D946C38615EB73B14A44B4632E34", hash_generated_method = "08D3CF20B280BE86A2C82B00FA9BDA97")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1342253505 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i;
                i = 0;
                {
                    {
                        buffer.append(",");
                    } //End block
                    buffer.append(suffixes[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        buffer.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_1342253505 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1342253505.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342253505;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append(super.toString());
        //buffer.append("(");
        //if (suffixes != null) {
            //for (int i = 0; i < suffixes.length; i++) {
                //if (i > 0) {
                    //buffer.append(",");
                //}
                //buffer.append(suffixes[i]);
            //}
        //}
        //buffer.append(")");
        //return buffer.toString();
    }

    
}

