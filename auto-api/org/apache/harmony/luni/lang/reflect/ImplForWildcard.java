package org.apache.harmony.luni.lang.reflect;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

public final class ImplForWildcard implements WildcardType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.191 -0400", hash_original_field = "F46925D3540A6CF061C3B56DAECD636F", hash_generated_field = "09ECEF7959A04D8A2E7315F105554DF2")

    private ListOfTypes extendsBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.191 -0400", hash_original_field = "A91DCB3D1DA33DA1DB1124AD9DBFEA92", hash_generated_field = "DC1616B3F5683830A9032F213015D66B")

    private ListOfTypes superBound;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.192 -0400", hash_original_method = "377AE596AF1F05D61C997E0097B90D78", hash_generated_method = "A362119BE9B074D6701B8CAD31C3A22C")
    public  ImplForWildcard(ListOfTypes extendsBound, ListOfTypes superBound) {
        this.extendsBound = extendsBound;
        this.superBound = superBound;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.194 -0400", hash_original_method = "0E02033FF7243902E994038D555D1587", hash_generated_method = "FBDCDBBE42A1B3E4910A3A1354FEB125")
    public Type[] getLowerBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1660600514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1660600514 = superBound.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_1660600514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1660600514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.194 -0400", hash_original_method = "F21086AF3EFC8DD73AF90E899FA34F74", hash_generated_method = "8908FB8C58D8CC732C974006EB08F38D")
    public Type[] getUpperBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1617119260 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1617119260 = extendsBound.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_1617119260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1617119260;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.195 -0400", hash_original_method = "4E6CE2D91E2326D588B30852F56501A7", hash_generated_method = "689E0B9829D033733EA5DF23CD4BEFAE")
    @Override
    public boolean equals(Object o) {
        WildcardType that = (WildcardType) o;
        boolean var9B61140A4264915007DB38BC28E703CD_388308084 = (Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                Arrays.equals(getUpperBounds(), that.getUpperBounds()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764011816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764011816;
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.195 -0400", hash_original_method = "336948550805F35B42E4F5770BA4CC44", hash_generated_method = "07B0B8100B6ED22BD4225521278698B7")
    @Override
    public int hashCode() {
        int var05992490AB8166BE5DC4E5A256FAFCD9_1595027229 = (31 * Arrays.hashCode(getLowerBounds()) +
                Arrays.hashCode(getUpperBounds()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030906445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030906445;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.196 -0400", hash_original_method = "93865AC448C11A5C9C4A3B3F15C62698", hash_generated_method = "17D04E4AACC06E749E3FE64B0EB99C2E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1072558959 = null; 
        StringBuilder sb = new StringBuilder("?");
        {
            boolean varA3577B98AFF67C83AB66FF69CEE5F1BF_438739358 = ((extendsBound.length() == 1 && extendsBound.getResolvedTypes()[0] != Object.class)
                || extendsBound.length() > 1);
            {
                sb.append(" extends ").append(extendsBound);
            } 
            {
                boolean var9C6EFA4256F2038BF750324FCAADBCE2_1744144739 = (superBound.length() > 0);
                {
                    sb.append(" super ").append(superBound);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1072558959 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1072558959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1072558959;
        
        
        
                
            
        
            
        
        
    }

    
}

