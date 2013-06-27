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

public class AndFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.535 -0400", hash_original_field = "C95DE119A9D7CC261D04483175B7F514", hash_generated_field = "A093E0C3DE9323A661D0712F28EF5BF8")

    private List<IOFileFilter> fileFilters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.541 -0400", hash_original_method = "D69D2D85CE24AE2BFF71755854F84C3E", hash_generated_method = "61CB779675A1BA263D4BCBA5421BDD83")
    public  AndFileFilter() {
        this.fileFilters = new ArrayList<IOFileFilter>();
        // ---------- Original Method ----------
        //this.fileFilters = new ArrayList<IOFileFilter>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.541 -0400", hash_original_method = "EACF8E2DE294FEF43D3A3F18958358BB", hash_generated_method = "19750EF1B050CA89C91501941DAF05B6")
    public  AndFileFilter(final List<IOFileFilter> fileFilters) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.542 -0400", hash_original_method = "83B5DD90D38611D3F0D0ED1F1E9B5BE5", hash_generated_method = "6DF05AAD611A8B129C8C0D85E7944C21")
    public  AndFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.543 -0400", hash_original_method = "82CBDB26DBAE7C3928EFB659443DD094", hash_generated_method = "1CF1223491D3857853FCF10C53D34B21")
    public void addFileFilter(final IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
        addTaint(ioFileFilter.getTaint());
        // ---------- Original Method ----------
        //this.fileFilters.add(ioFileFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.548 -0400", hash_original_method = "C6000DDE181BCE52214EEFCE5C901DFA", hash_generated_method = "456675ED0D97BB422D863119D3E68149")
    public List<IOFileFilter> getFileFilters() {
        List<IOFileFilter> varB4EAC82CA7396A68D541C85D26508E83_1987826974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1987826974 = Collections.unmodifiableList(this.fileFilters);
        varB4EAC82CA7396A68D541C85D26508E83_1987826974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1987826974;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(this.fileFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.548 -0400", hash_original_method = "4066AB1778964D409D441B7FA60F3C00", hash_generated_method = "19AA00A259E27F58FB6B5E07523B8A27")
    public boolean removeFileFilter(final IOFileFilter ioFileFilter) {
        boolean varE103009338EBD181485E8675A8D57039_1283679892 = (this.fileFilters.remove(ioFileFilter));
        addTaint(ioFileFilter.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121366003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121366003;
        // ---------- Original Method ----------
        //return this.fileFilters.remove(ioFileFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.549 -0400", hash_original_method = "0158A95A6585441E62C5077FBAB9C8FC", hash_generated_method = "89912E898016EDE9BA9409B351819F40")
    public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
        addTaint(fileFilters.getTaint());
        // ---------- Original Method ----------
        //this.fileFilters.clear();
        //this.fileFilters.addAll(fileFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.567 -0400", hash_original_method = "15185D73968973515F4C212ED777AF75", hash_generated_method = "F796067BBB38B7C6E66B3AC2F8F73C87")
    @Override
    public boolean accept(final File file) {
        {
            boolean var0F1814634DF0E889B3B852FD645DFD0F_277800302 = (this.fileFilters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_594327717 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_594327717.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_594327717.next();
            {
                {
                    boolean var7821E8DEAA5CB187F3CA68AB6A2A7FCE_362122610 = (!fileFilter.accept(file));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839087783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_839087783;
        // ---------- Original Method ----------
        //if (this.fileFilters.isEmpty()) {
            //return false;
        //}
        //for (IOFileFilter fileFilter : fileFilters) {
            //if (!fileFilter.accept(file)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.602 -0400", hash_original_method = "A3F03C923F515CB961B8B37439B16718", hash_generated_method = "3C1C17E96B282E64AC176A69F1BEB58E")
    @Override
    public boolean accept(final File file, final String name) {
        {
            boolean var0F1814634DF0E889B3B852FD645DFD0F_2081522675 = (this.fileFilters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_1624074866 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_1624074866.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_1624074866.next();
            {
                {
                    boolean varAC95C767A281C040EA6170F478ED5974_1056327513 = (!fileFilter.accept(file, name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369784122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369784122;
        // ---------- Original Method ----------
        //if (this.fileFilters.isEmpty()) {
            //return false;
        //}
        //for (IOFileFilter fileFilter : fileFilters) {
            //if (!fileFilter.accept(file, name)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.603 -0400", hash_original_method = "1E761CCD4DDE3C2CB8242721D590B88B", hash_generated_method = "A6637B6DB3B6CC551DF397DE28C36AE4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1365059745 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i;
                i = 0;
                boolean varC239B24573C764056AE5C6C034C160DB_2064538307 = (i < fileFilters.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_1365059745 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1365059745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1365059745;
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

