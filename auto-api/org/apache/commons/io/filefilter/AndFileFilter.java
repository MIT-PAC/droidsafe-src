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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.484 -0400", hash_original_field = "C95DE119A9D7CC261D04483175B7F514", hash_generated_field = "A093E0C3DE9323A661D0712F28EF5BF8")

    private List<IOFileFilter> fileFilters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.485 -0400", hash_original_method = "D69D2D85CE24AE2BFF71755854F84C3E", hash_generated_method = "61CB779675A1BA263D4BCBA5421BDD83")
    public  AndFileFilter() {
        this.fileFilters = new ArrayList<IOFileFilter>();
        // ---------- Original Method ----------
        //this.fileFilters = new ArrayList<IOFileFilter>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.516 -0400", hash_original_method = "EACF8E2DE294FEF43D3A3F18958358BB", hash_generated_method = "19750EF1B050CA89C91501941DAF05B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.516 -0400", hash_original_method = "83B5DD90D38611D3F0D0ED1F1E9B5BE5", hash_generated_method = "6DF05AAD611A8B129C8C0D85E7944C21")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.517 -0400", hash_original_method = "82CBDB26DBAE7C3928EFB659443DD094", hash_generated_method = "1CF1223491D3857853FCF10C53D34B21")
    public void addFileFilter(final IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
        addTaint(ioFileFilter.getTaint());
        // ---------- Original Method ----------
        //this.fileFilters.add(ioFileFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.518 -0400", hash_original_method = "C6000DDE181BCE52214EEFCE5C901DFA", hash_generated_method = "987D908355CF2EDBD6B051C2D1EFF4FC")
    public List<IOFileFilter> getFileFilters() {
        List<IOFileFilter> varB4EAC82CA7396A68D541C85D26508E83_867811221 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_867811221 = Collections.unmodifiableList(this.fileFilters);
        varB4EAC82CA7396A68D541C85D26508E83_867811221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_867811221;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(this.fileFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.519 -0400", hash_original_method = "4066AB1778964D409D441B7FA60F3C00", hash_generated_method = "E0E3074EA468369CC657E0E440577297")
    public boolean removeFileFilter(final IOFileFilter ioFileFilter) {
        boolean varE103009338EBD181485E8675A8D57039_518166265 = (this.fileFilters.remove(ioFileFilter));
        addTaint(ioFileFilter.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372870214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372870214;
        // ---------- Original Method ----------
        //return this.fileFilters.remove(ioFileFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.530 -0400", hash_original_method = "0158A95A6585441E62C5077FBAB9C8FC", hash_generated_method = "89912E898016EDE9BA9409B351819F40")
    public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
        addTaint(fileFilters.getTaint());
        // ---------- Original Method ----------
        //this.fileFilters.clear();
        //this.fileFilters.addAll(fileFilters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.551 -0400", hash_original_method = "15185D73968973515F4C212ED777AF75", hash_generated_method = "E90E8B5E119A56C10FB40DB92C8A12CB")
    @Override
    public boolean accept(final File file) {
        {
            boolean var0F1814634DF0E889B3B852FD645DFD0F_1027214875 = (this.fileFilters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_1873417916 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_1873417916.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_1873417916.next();
            {
                {
                    boolean var7821E8DEAA5CB187F3CA68AB6A2A7FCE_1950348498 = (!fileFilter.accept(file));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361085628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361085628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.581 -0400", hash_original_method = "A3F03C923F515CB961B8B37439B16718", hash_generated_method = "23E700FFB729658B97F7FAB5F71E8AAD")
    @Override
    public boolean accept(final File file, final String name) {
        {
            boolean var0F1814634DF0E889B3B852FD645DFD0F_219162698 = (this.fileFilters.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_431586647 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_431586647.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_431586647.next();
            {
                {
                    boolean varAC95C767A281C040EA6170F478ED5974_141876975 = (!fileFilter.accept(file, name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254609348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254609348;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.582 -0400", hash_original_method = "1E761CCD4DDE3C2CB8242721D590B88B", hash_generated_method = "391BEF1C92A0638D6B29EF06402F8B48")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2055616345 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i;
                i = 0;
                boolean varC239B24573C764056AE5C6C034C160DB_2004869138 = (i < fileFilters.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_2055616345 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2055616345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055616345;
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

