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
    private ListOfTypes extendsBound, superBound;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.839 -0400", hash_original_method = "377AE596AF1F05D61C997E0097B90D78", hash_generated_method = "6324158F077182251E1DEC57A4D33CF2")
    @DSModeled(DSC.SAFE)
    public ImplForWildcard(ListOfTypes extendsBound, ListOfTypes superBound) {
        dsTaint.addTaint(extendsBound.dsTaint);
        dsTaint.addTaint(superBound.dsTaint);
        // ---------- Original Method ----------
        //this.extendsBound = extendsBound;
        //this.superBound = superBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.839 -0400", hash_original_method = "0E02033FF7243902E994038D555D1587", hash_generated_method = "0B5FEEA275CECB25A0C45818697D937F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getLowerBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] varA04D35A4B42F92A9F2BA6E6E448A4710_1312425979 = (superBound.getResolvedTypes().clone());
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return superBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.840 -0400", hash_original_method = "F21086AF3EFC8DD73AF90E899FA34F74", hash_generated_method = "D6FA78D3F8AED2413BA61CBDF95CAD06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getUpperBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
        Type[] var091682CB890DCA2E078AC475BB507411_884935691 = (extendsBound.getResolvedTypes().clone());
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return extendsBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.840 -0400", hash_original_method = "4E6CE2D91E2326D588B30852F56501A7", hash_generated_method = "7A79361C676AE58861A63FF86303380A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        WildcardType that;
        that = (WildcardType) o;
        boolean var9B61140A4264915007DB38BC28E703CD_1437467107 = (Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                Arrays.equals(getUpperBounds(), that.getUpperBounds()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if(!(o instanceof WildcardType)) {
            //return false;
        //}
        //WildcardType that = (WildcardType) o;
        //return Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                //Arrays.equals(getUpperBounds(), that.getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.840 -0400", hash_original_method = "336948550805F35B42E4F5770BA4CC44", hash_generated_method = "6FC5537CAD096502240EC1D045533B8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var05992490AB8166BE5DC4E5A256FAFCD9_1862183579 = (31 * Arrays.hashCode(getLowerBounds()) +
                Arrays.hashCode(getUpperBounds()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 31 * Arrays.hashCode(getLowerBounds()) +
                //Arrays.hashCode(getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.840 -0400", hash_original_method = "93865AC448C11A5C9C4A3B3F15C62698", hash_generated_method = "FFCF9D14B6675188D2C32D4A41818E53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder("?");
        {
            boolean varA3577B98AFF67C83AB66FF69CEE5F1BF_370338420 = ((extendsBound.length() == 1 && extendsBound.getResolvedTypes()[0] != Object.class)
                || extendsBound.length() > 1);
            {
                sb.append(" extends ").append(extendsBound);
            } //End block
            {
                boolean var9C6EFA4256F2038BF750324FCAADBCE2_1548466230 = (superBound.length() > 0);
                {
                    sb.append(" super ").append(superBound);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_327568817 = (sb.toString());
        return dsTaint.getTaintString();
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

