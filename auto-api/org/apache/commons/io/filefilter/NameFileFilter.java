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

public class NameFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.834 -0400", hash_original_field = "A8998C31A141924D06220074FCDC6925", hash_generated_field = "E3509315482C60EE65D446B55C371238")

    private String[] names;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.834 -0400", hash_original_field = "9AE1535F968174A45A688181FD26E8A9", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private IOCase caseSensitivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.834 -0400", hash_original_method = "EB84086797A3D4C584C92992867C0467", hash_generated_method = "9278E5A1B7A63E340447F8E33A5B5AA2")
    public  NameFileFilter(String name) {
        this(name, null);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.835 -0400", hash_original_method = "82856C516978904D9C3EC48D06DD6903", hash_generated_method = "BCE5A3C59B80A18D2A8FE8B7057706A8")
    public  NameFileFilter(String name, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The wildcard must not be null");
        } //End block
        this.names = new String[] {name};
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("The wildcard must not be null");
        //}
        //this.names = new String[] {name};
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.835 -0400", hash_original_method = "A9F98BACB414F0E2CFCA50969D92D7AA", hash_generated_method = "094BF929B7A3CD0A64240BE80D390419")
    public  NameFileFilter(String[] names) {
        this(names, null);
        addTaint(names[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.836 -0400", hash_original_method = "B607BACF1FB1DD166EC9657B6585798A", hash_generated_method = "D6E05F7F91BBDDA2AC57F2B1D68F3B51")
    public  NameFileFilter(String[] names, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The array of names must not be null");
        } //End block
        this.names = new String[names.length];
        System.arraycopy(names, 0, this.names, 0, names.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //if (names == null) {
            //throw new IllegalArgumentException("The array of names must not be null");
        //}
        //this.names = new String[names.length];
        //System.arraycopy(names, 0, this.names, 0, names.length);
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.836 -0400", hash_original_method = "5611293ED2F0C7E4748ECD14A3071E4F", hash_generated_method = "2377BBB56587AD665777C068431A441A")
    public  NameFileFilter(List<String> names) {
        this(names, null);
        addTaint(names.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.836 -0400", hash_original_method = "B917B9DB396BA061BB753C77FE6102E8", hash_generated_method = "C3EF8CD28A084D70B686AF99A9DD9D8F")
    public  NameFileFilter(List<String> names, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The list of names must not be null");
        } //End block
        this.names = names.toArray(new String[names.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        // ---------- Original Method ----------
        //if (names == null) {
            //throw new IllegalArgumentException("The list of names must not be null");
        //}
        //this.names = names.toArray(new String[names.size()]);
        //this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.842 -0400", hash_original_method = "8143C5E13483113836748794199B1228", hash_generated_method = "F59C85F1E6F53BA4E75ACD4227978AD2")
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        {
            Iterator<String> var191FF989E4EF127CFFBFFEAAE33FDB9D_1699131717 = (this.names).iterator();
            var191FF989E4EF127CFFBFFEAAE33FDB9D_1699131717.hasNext();
            String name2 = var191FF989E4EF127CFFBFFEAAE33FDB9D_1699131717.next();
            {
                {
                    boolean varC3DF969BB52F0D3A0B24B0EAC1A92D53_672560223 = (caseSensitivity.checkEquals(name, name2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492081753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_492081753;
        // ---------- Original Method ----------
        //String name = file.getName();
        //for (String name2 : this.names) {
            //if (caseSensitivity.checkEquals(name, name2)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.845 -0400", hash_original_method = "F0ECCB0CC9BF3CE73728CA922CC18037", hash_generated_method = "EA08E233E624A1EF8721A4A4DAF94C87")
    @Override
    public boolean accept(File dir, String name) {
        {
            Iterator<String> var06CC19F24C2393D64DAD0F5C7DBD3B96_519227717 = (names).iterator();
            var06CC19F24C2393D64DAD0F5C7DBD3B96_519227717.hasNext();
            String name2 = var06CC19F24C2393D64DAD0F5C7DBD3B96_519227717.next();
            {
                {
                    boolean varC3DF969BB52F0D3A0B24B0EAC1A92D53_299781609 = (caseSensitivity.checkEquals(name, name2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163838144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_163838144;
        // ---------- Original Method ----------
        //for (String name2 : names) {
            //if (caseSensitivity.checkEquals(name, name2)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.846 -0400", hash_original_method = "2C08B488ADA93371BD5A437FB37025E7", hash_generated_method = "42A273A6A42EEC3ED13D41446CA24463")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_608051250 = null; //Variable for return #1
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
                    buffer.append(names[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        buffer.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_608051250 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_608051250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_608051250;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append(super.toString());
        //buffer.append("(");
        //if (names != null) {
            //for (int i = 0; i < names.length; i++) {
                //if (i > 0) {
                    //buffer.append(",");
                //}
                //buffer.append(names[i]);
            //}
        //}
        //buffer.append(")");
        //return buffer.toString();
    }

    
}

