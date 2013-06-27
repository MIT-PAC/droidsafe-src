package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

public final class ImplForWildcard implements WildcardType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.878 -0400", hash_original_field = "F46925D3540A6CF061C3B56DAECD636F", hash_generated_field = "09ECEF7959A04D8A2E7315F105554DF2")

    private ListOfTypes extendsBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.927 -0400", hash_original_field = "A91DCB3D1DA33DA1DB1124AD9DBFEA92", hash_generated_field = "DC1616B3F5683830A9032F213015D66B")

    private ListOfTypes superBound;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.928 -0400", hash_original_method = "377AE596AF1F05D61C997E0097B90D78", hash_generated_method = "A362119BE9B074D6701B8CAD31C3A22C")
    public  ImplForWildcard(ListOfTypes extendsBound, ListOfTypes superBound) {
        this.extendsBound = extendsBound;
        this.superBound = superBound;
        // ---------- Original Method ----------
        //this.extendsBound = extendsBound;
        //this.superBound = superBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.928 -0400", hash_original_method = "0E02033FF7243902E994038D555D1587", hash_generated_method = "C1305EB3B4FF1A29F480FDCCDEAF810C")
    public Type[] getLowerBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1407498422 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1407498422 = superBound.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_1407498422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1407498422;
        // ---------- Original Method ----------
        //return superBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.928 -0400", hash_original_method = "F21086AF3EFC8DD73AF90E899FA34F74", hash_generated_method = "5795FCEBEB90A691A91D8892E6CEE125")
    public Type[] getUpperBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_605641517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_605641517 = extendsBound.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_605641517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605641517;
        // ---------- Original Method ----------
        //return extendsBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.929 -0400", hash_original_method = "4E6CE2D91E2326D588B30852F56501A7", hash_generated_method = "B8DEA9C758B2A6D9800514E2569C757E")
    @Override
    public boolean equals(Object o) {
        WildcardType that;
        that = (WildcardType) o;
        boolean var9B61140A4264915007DB38BC28E703CD_633114437 = (Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                Arrays.equals(getUpperBounds(), that.getUpperBounds()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_947413866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_947413866;
        // ---------- Original Method ----------
        //if(!(o instanceof WildcardType)) {
            //return false;
        //}
        //WildcardType that = (WildcardType) o;
        //return Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                //Arrays.equals(getUpperBounds(), that.getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.929 -0400", hash_original_method = "336948550805F35B42E4F5770BA4CC44", hash_generated_method = "F76A366F86D81B5397C1C3EEE6BA946F")
    @Override
    public int hashCode() {
        int var05992490AB8166BE5DC4E5A256FAFCD9_2145427415 = (31 * Arrays.hashCode(getLowerBounds()) +
                Arrays.hashCode(getUpperBounds()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403230852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403230852;
        // ---------- Original Method ----------
        //return 31 * Arrays.hashCode(getLowerBounds()) +
                //Arrays.hashCode(getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.930 -0400", hash_original_method = "93865AC448C11A5C9C4A3B3F15C62698", hash_generated_method = "8B06E687BC06C9D820856D3DFFC625DE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1082978254 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder("?");
        {
            boolean varA3577B98AFF67C83AB66FF69CEE5F1BF_841664059 = ((extendsBound.length() == 1 && extendsBound.getResolvedTypes()[0] != Object.class)
                || extendsBound.length() > 1);
            {
                sb.append(" extends ").append(extendsBound);
            } //End block
            {
                boolean var9C6EFA4256F2038BF750324FCAADBCE2_33257660 = (superBound.length() > 0);
                {
                    sb.append(" super ").append(superBound);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1082978254 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1082978254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1082978254;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder("?");
        //if ((extendsBound.length() == 1 && extendsBound.getResolvedTypes()[0] != Object.class)
                //|| extendsBound.length() > 1) {
            //sb.append(" extends ").append(extendsBound);
        //} else if (superBound.length() > 0) {
            //sb.append(" super ").append(superBound);
        //}
        //return sb.toString();
    }

    
}

