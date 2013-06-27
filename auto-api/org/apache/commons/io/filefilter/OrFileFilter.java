package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.814 -0400", hash_original_field = "C95DE119A9D7CC261D04483175B7F514", hash_generated_field = "A093E0C3DE9323A661D0712F28EF5BF8")

    private List<IOFileFilter> fileFilters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.816 -0400", hash_original_method = "261B8A78A48F018A582463F22AA23698", hash_generated_method = "7D485639331927B9A3A6F58F24829C08")
    public  OrFileFilter() {
        this.fileFilters = new ArrayList<IOFileFilter>();
        // ---------- Original Method ----------
        //this.fileFilters = new ArrayList<IOFileFilter>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.823 -0400", hash_original_method = "EF6E00E126C186B440F3A1423802E998", hash_generated_method = "6AC5BC7752A729FDDB36BDCDF10DF551")
    public  OrFileFilter(final List<IOFileFilter> fileFilters) {
        {
            this.fileFilters = new ArrayList<IOFileFilter>();
        } //End block
        {
            this.fileFilters = new ArrayList<IOFileFilter>(fileFilters);
        } //End block
        // ---------- Original Method ----------
        //if (fileFilters == null) {
            //this.fileFilters = new ArrayList<IOFileFilter>();
        //} else {
            //this.fileFilters = new ArrayList<IOFileFilter>(fileFilters);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.824 -0400", hash_original_method = "B7ADCE9A3D3A09F26DDD24599D7121FB", hash_generated_method = "DF62D0B98E783AE2B17A9035E94FC6B0")
    public  OrFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The filters must not be null");
        } //End block
        this.fileFilters = new ArrayList<IOFileFilter>(2);
        addFileFilter(filter1);
        addFileFilter(filter2);
        addTaint(filter1.getTaint());
        addTaint(filter2.getTaint());
        // ---------- Original Method ----------
        //if (filter1 == null || filter2 == null) {
            //throw new IllegalArgumentException("The filters must not be null");
        //}
        //this.fileFilters = new ArrayList<IOFileFilter>(2);
        //addFileFilter(filter1);
        //addFileFilter(filter2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.840 -0400", hash_original_method = "82CBDB26DBAE7C3928EFB659443DD094", hash_generated_method = "1CF1223491D3857853FCF10C53D34B21")
    public void addFileFilter(final IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
        addTaint(ioFileFilter.getTaint());
        // ---------- Original Method ----------
        //this.fileFilters.add(ioFileFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.841 -0400", hash_original_method = "C6000DDE181BCE52214EEFCE5C901DFA", hash_generated_method = "0721BC65C15B4D87F3ADCB105D35EE5E")
    public List<IOFileFilter> getFileFilters() {
        List<IOFileFilter> varB4EAC82CA7396A68D541C85D26508E83_1589925576 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1589925576 = Collections.unmodifiableList(this.fileFilters);
        varB4EAC82CA7396A68D541C85D26508E83_1589925576.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589925576;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(this.fileFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.841 -0400", hash_original_method = "116FFFDA4CB65AECB7B5B648545FB2AD", hash_generated_method = "5900C5830B5437F6FDABCC82780D7B67")
    public boolean removeFileFilter(IOFileFilter ioFileFilter) {
        boolean varE103009338EBD181485E8675A8D57039_729288849 = (this.fileFilters.remove(ioFileFilter));
        addTaint(ioFileFilter.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1604851405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1604851405;
        // ---------- Original Method ----------
        //return this.fileFilters.remove(ioFileFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.841 -0400", hash_original_method = "0158A95A6585441E62C5077FBAB9C8FC", hash_generated_method = "89912E898016EDE9BA9409B351819F40")
    public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
        addTaint(fileFilters.getTaint());
        // ---------- Original Method ----------
        //this.fileFilters.clear();
        //this.fileFilters.addAll(fileFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.858 -0400", hash_original_method = "6C2FE5C9E9DD4CA7904EFF10D5A5AFDA", hash_generated_method = "653218C55646198585B01959A8AF75A7")
    @Override
    public boolean accept(final File file) {
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_64414551 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_64414551.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_64414551.next();
            {
                {
                    boolean varA44DD0887845936DDFD2FE7BA55D365F_1317788446 = (fileFilter.accept(file));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_825772605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_825772605;
        // ---------- Original Method ----------
        //for (IOFileFilter fileFilter : fileFilters) {
            //if (fileFilter.accept(file)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.879 -0400", hash_original_method = "FB679BDE148C743BEAFFC23053AC09E1", hash_generated_method = "0E8C185AB479DE61E8509DE92132F7B5")
    @Override
    public boolean accept(final File file, final String name) {
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_72995192 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_72995192.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_72995192.next();
            {
                {
                    boolean var03651AB236C81D98D3C0234D83404CD5_1988614954 = (fileFilter.accept(file, name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872329798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872329798;
        // ---------- Original Method ----------
        //for (IOFileFilter fileFilter : fileFilters) {
            //if (fileFilter.accept(file, name)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.879 -0400", hash_original_method = "1E761CCD4DDE3C2CB8242721D590B88B", hash_generated_method = "6B38DA40C912B5D608362462FADBB313")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_674294731 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i;
                i = 0;
                boolean varC239B24573C764056AE5C6C034C160DB_1287799722 = (i < fileFilters.size());
                {
                    {
                        buffer.append(",");
                    } //End block
                    Object filter;
                    filter = fileFilters.get(i);
                    buffer.append(filter == null ? "null" : filter.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        buffer.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_674294731 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_674294731.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_674294731;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append(super.toString());
        //buffer.append("(");
        //if (fileFilters != null) {
            //for (int i = 0; i < fileFilters.size(); i++) {
                //if (i > 0) {
                    //buffer.append(",");
                //}
                //Object filter = fileFilters.get(i);
                //buffer.append(filter == null ? "null" : filter.toString());
            //}
        //}
        //buffer.append(")");
        //return buffer.toString();
    }

    
}

