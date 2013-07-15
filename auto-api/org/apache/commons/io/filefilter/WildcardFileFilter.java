package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class WildcardFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.989 -0400", hash_original_field = "F3D504DE7AA56D35C26D94923C10A3E5", hash_generated_field = "6C7DD8A76D73FE93C97BF4100E50ABE2")

    private String[] wildcards;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.989 -0400", hash_original_field = "9AE1535F968174A45A688181FD26E8A9", hash_generated_field = "21450A3017D0D6122C0877D57300E67A")

    private IOCase caseSensitivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.989 -0400", hash_original_method = "0DC8B11301EF3C498C2ABB05D6DC182D", hash_generated_method = "319629C00ACC43C9F16F898B3E80F8FF")
    public  WildcardFileFilter(String wildcard) {
        this(wildcard, null);
        addTaint(wildcard.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.990 -0400", hash_original_method = "48E5C7007F85482990B2FBCD68749192", hash_generated_method = "4C1A707BD701775106DD30DE95965715")
    public  WildcardFileFilter(String wildcard, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The wildcard must not be null");
        } 
        this.wildcards = new String[] { wildcard };
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        addTaint(wildcard.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.990 -0400", hash_original_method = "B6C58B18880B584ACFA73AD5A7B51AB0", hash_generated_method = "96731BD9C5F350839972030E234CB118")
    public  WildcardFileFilter(String[] wildcards) {
        this(wildcards, null);
        addTaint(wildcards[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.990 -0400", hash_original_method = "B52C3DB451FF68ED0A74295B989A7EE9", hash_generated_method = "0D99B40B5BC67C4BBA538D50D2BEF35D")
    public  WildcardFileFilter(String[] wildcards, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The wildcard array must not be null");
        } 
        this.wildcards = new String[wildcards.length];
        System.arraycopy(wildcards, 0, this.wildcards, 0, wildcards.length);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.991 -0400", hash_original_method = "074E489B2A417933ABDEFACED52DF48F", hash_generated_method = "3CD5A5A8A5B7B4DB4DC5E6D4493E922E")
    public  WildcardFileFilter(List<String> wildcards) {
        this(wildcards, null);
        addTaint(wildcards.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.991 -0400", hash_original_method = "20DEFBD5799CE860E02C4A46D8229CF6", hash_generated_method = "E724E90C41E562A8294F36B6FDBD727D")
    public  WildcardFileFilter(List<String> wildcards, IOCase caseSensitivity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The wildcard list must not be null");
        } 
        this.wildcards = wildcards.toArray(new String[wildcards.size()]);
        this.caseSensitivity = caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.994 -0400", hash_original_method = "0D7E6F981525F2AA16F60F5ED0631F0E", hash_generated_method = "E63FDF2D2F697CF64C4B6F68EB745B33")
    @Override
    public boolean accept(File dir, String name) {
        {
            String wildcard = wildcards[0];
            {
                {
                    boolean var0572AA10CB9D5F2CACE237F100D1C60A_495789377 = (FilenameUtils.wildcardMatch(name, wildcard, caseSensitivity));
                } 
            } 
        } 
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705684877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705684877;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.997 -0400", hash_original_method = "C244C034F5D60E2DBFF912D07EE9EFE9", hash_generated_method = "9135741CC67F8151506F454F32213EF3")
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        {
            String wildcard = wildcards[0];
            {
                {
                    boolean var0572AA10CB9D5F2CACE237F100D1C60A_1054376873 = (FilenameUtils.wildcardMatch(name, wildcard, caseSensitivity));
                } 
            } 
        } 
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386552908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_386552908;
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.999 -0400", hash_original_method = "54924678DCA60F174F0C38EC41ACEED7", hash_generated_method = "4F44835E41C61A869782983CF4D52A48")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1155510112 = null; 
        StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        {
            {
                int i = 0;
                {
                    {
                        buffer.append(",");
                    } 
                    buffer.append(wildcards[i]);
                } 
            } 
        } 
        buffer.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_1155510112 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1155510112.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1155510112;
        
        
        
        
        
            
                
                    
                
                
            
        
        
        
    }

    
}

