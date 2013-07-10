package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.671 -0400", hash_original_field = "C95DE119A9D7CC261D04483175B7F514", hash_generated_field = "A093E0C3DE9323A661D0712F28EF5BF8")

    private List<IOFileFilter> fileFilters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.672 -0400", hash_original_method = "D69D2D85CE24AE2BFF71755854F84C3E", hash_generated_method = "61CB779675A1BA263D4BCBA5421BDD83")
    public  AndFileFilter() {
        this.fileFilters = new ArrayList<IOFileFilter>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.672 -0400", hash_original_method = "EACF8E2DE294FEF43D3A3F18958358BB", hash_generated_method = "19750EF1B050CA89C91501941DAF05B6")
    public  AndFileFilter(final List<IOFileFilter> fileFilters) {
        {
            this.fileFilters = new ArrayList<IOFileFilter>();
        } 
        {
            this.fileFilters = new ArrayList<IOFileFilter>(fileFilters);
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.672 -0400", hash_original_method = "83B5DD90D38611D3F0D0ED1F1E9B5BE5", hash_generated_method = "6DF05AAD611A8B129C8C0D85E7944C21")
    public  AndFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The filters must not be null");
        } 
        this.fileFilters = new ArrayList<IOFileFilter>(2);
        addFileFilter(filter1);
        addFileFilter(filter2);
        addTaint(filter1.getTaint());
        addTaint(filter2.getTaint());
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.673 -0400", hash_original_method = "82CBDB26DBAE7C3928EFB659443DD094", hash_generated_method = "1CF1223491D3857853FCF10C53D34B21")
    public void addFileFilter(final IOFileFilter ioFileFilter) {
        this.fileFilters.add(ioFileFilter);
        addTaint(ioFileFilter.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.673 -0400", hash_original_method = "C6000DDE181BCE52214EEFCE5C901DFA", hash_generated_method = "C5DEC8E592EB61D373F06F90E4C50254")
    public List<IOFileFilter> getFileFilters() {
        List<IOFileFilter> varB4EAC82CA7396A68D541C85D26508E83_1323913557 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1323913557 = Collections.unmodifiableList(this.fileFilters);
        varB4EAC82CA7396A68D541C85D26508E83_1323913557.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1323913557;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.673 -0400", hash_original_method = "4066AB1778964D409D441B7FA60F3C00", hash_generated_method = "A2BFB74F6CB9AA56D65FA64405C2FC15")
    public boolean removeFileFilter(final IOFileFilter ioFileFilter) {
        boolean varE103009338EBD181485E8675A8D57039_1356005118 = (this.fileFilters.remove(ioFileFilter));
        addTaint(ioFileFilter.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765271114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_765271114;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.674 -0400", hash_original_method = "0158A95A6585441E62C5077FBAB9C8FC", hash_generated_method = "89912E898016EDE9BA9409B351819F40")
    public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(fileFilters);
        addTaint(fileFilters.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.680 -0400", hash_original_method = "15185D73968973515F4C212ED777AF75", hash_generated_method = "33654F31E692E882D98A13BAFD52AAE9")
    @Override
    public boolean accept(final File file) {
        {
            boolean var0F1814634DF0E889B3B852FD645DFD0F_917192150 = (this.fileFilters.isEmpty());
        } 
        {
            Iterator<IOFileFilter> var1EDDB116E6641788BC97486276A968AE_1439202282 = (fileFilters).iterator();
            var1EDDB116E6641788BC97486276A968AE_1439202282.hasNext();
            IOFileFilter fileFilter = var1EDDB116E6641788BC97486276A968AE_1439202282.next();
            {
                {
                    boolean var7821E8DEAA5CB187F3CA68AB6A2A7FCE_352428980 = (!fileFilter.accept(file));
                } 
            } 
        } 
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418006630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418006630;
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.683 -0400", hash_original_method = "A3F03C923F515CB961B8B37439B16718", hash_generated_method = "E81F71FC3C3DE67B36A14E2C4E9CE9AB")
    @Override
    public boolean accept(final File file, final String name) {
        {
            boolean var0F1814634DF0E889B3B852FD645DFD0F_2015135251 = (this.fileFilters.isEmpty());
        } 
        {
            IOFileFilter fileFilter = fileFilters.get(0);
            {
                {
                    boolean varAC95C767A281C040EA6170F478ED5974_1397743470 = (!fileFilter.accept(file, name));
                } 
            } 
        } 
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850558663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850558663;
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.684 -0400", hash_original_method = "1E761CCD4DDE3C2CB8242721D590B88B", hash_generated_method = "56E45F6D03E13CCE43C7D2B4BF9139FF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1500389820 = null; 
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i = 0;
                boolean varC239B24573C764056AE5C6C034C160DB_2083468552 = (i < fileFilters.size());
                {
                    {
                        buffer.append(",");
                    } 
                    Object filter = fileFilters.get(i);
                    buffer.append(filter == null ? "null" : filter.toString());
                } 
            } 
        } 
        buffer.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_1500389820 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1500389820.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1500389820;
        
        
        
        
        
            
                
                    
                
                
                
            
        
        
        
    }

    
}

