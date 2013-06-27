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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.967 -0400", hash_original_field = "F46925D3540A6CF061C3B56DAECD636F", hash_generated_field = "09ECEF7959A04D8A2E7315F105554DF2")

    private ListOfTypes extendsBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.967 -0400", hash_original_field = "A91DCB3D1DA33DA1DB1124AD9DBFEA92", hash_generated_field = "DC1616B3F5683830A9032F213015D66B")

    private ListOfTypes superBound;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.968 -0400", hash_original_method = "377AE596AF1F05D61C997E0097B90D78", hash_generated_method = "A362119BE9B074D6701B8CAD31C3A22C")
    public  ImplForWildcard(ListOfTypes extendsBound, ListOfTypes superBound) {
        this.extendsBound = extendsBound;
        this.superBound = superBound;
        // ---------- Original Method ----------
        //this.extendsBound = extendsBound;
        //this.superBound = superBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.981 -0400", hash_original_method = "0E02033FF7243902E994038D555D1587", hash_generated_method = "AA5AF92BFE7267C5647003CA09F1A754")
    public Type[] getLowerBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_828718389 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_828718389 = superBound.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_828718389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828718389;
        // ---------- Original Method ----------
        //return superBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.981 -0400", hash_original_method = "F21086AF3EFC8DD73AF90E899FA34F74", hash_generated_method = "9C62E3535144F47DAD8D66056BDAF600")
    public Type[] getUpperBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1743539379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1743539379 = extendsBound.getResolvedTypes().clone();
        varB4EAC82CA7396A68D541C85D26508E83_1743539379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1743539379;
        // ---------- Original Method ----------
        //return extendsBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.982 -0400", hash_original_method = "4E6CE2D91E2326D588B30852F56501A7", hash_generated_method = "8A264ED3D49129ACEFA148C670811BB9")
    @Override
    public boolean equals(Object o) {
        WildcardType that;
        that = (WildcardType) o;
        boolean var9B61140A4264915007DB38BC28E703CD_614925077 = (Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                Arrays.equals(getUpperBounds(), that.getUpperBounds()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682174796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682174796;
        // ---------- Original Method ----------
        //if(!(o instanceof WildcardType)) {
            //return false;
        //}
        //WildcardType that = (WildcardType) o;
        //return Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                //Arrays.equals(getUpperBounds(), that.getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.983 -0400", hash_original_method = "336948550805F35B42E4F5770BA4CC44", hash_generated_method = "C85434F1A404E72B02CA51543B7F0262")
    @Override
    public int hashCode() {
        int var05992490AB8166BE5DC4E5A256FAFCD9_1524671050 = (31 * Arrays.hashCode(getLowerBounds()) +
                Arrays.hashCode(getUpperBounds()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1405337167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1405337167;
        // ---------- Original Method ----------
        //return 31 * Arrays.hashCode(getLowerBounds()) +
                //Arrays.hashCode(getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.995 -0400", hash_original_method = "93865AC448C11A5C9C4A3B3F15C62698", hash_generated_method = "C5626F8A2FD3A8184018F42FACE20742")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1012131620 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder("?");
        {
            boolean varA3577B98AFF67C83AB66FF69CEE5F1BF_948458743 = ((extendsBound.length() == 1 && extendsBound.getResolvedTypes()[0] != Object.class)
                || extendsBound.length() > 1);
            {
                sb.append(" extends ").append(extendsBound);
            } //End block
            {
                boolean var9C6EFA4256F2038BF750324FCAADBCE2_1968808115 = (superBound.length() > 0);
                {
                    sb.append(" super ").append(superBound);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1012131620 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1012131620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1012131620;
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

