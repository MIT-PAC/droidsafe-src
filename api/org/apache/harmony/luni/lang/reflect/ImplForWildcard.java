package org.apache.harmony.luni.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;




public final class ImplForWildcard implements WildcardType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.980 -0400", hash_original_field = "F46925D3540A6CF061C3B56DAECD636F", hash_generated_field = "09ECEF7959A04D8A2E7315F105554DF2")

    private ListOfTypes extendsBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.980 -0400", hash_original_field = "A91DCB3D1DA33DA1DB1124AD9DBFEA92", hash_generated_field = "DC1616B3F5683830A9032F213015D66B")

    private ListOfTypes superBound;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.981 -0400", hash_original_method = "377AE596AF1F05D61C997E0097B90D78", hash_generated_method = "A362119BE9B074D6701B8CAD31C3A22C")
    public  ImplForWildcard(ListOfTypes extendsBound, ListOfTypes superBound) {
        this.extendsBound = extendsBound;
        this.superBound = superBound;
        // ---------- Original Method ----------
        //this.extendsBound = extendsBound;
        //this.superBound = superBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.982 -0400", hash_original_method = "0E02033FF7243902E994038D555D1587", hash_generated_method = "60E013B00FE3F97648A8201A2262CC51")
    public Type[] getLowerBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
Type[] var8E000A8FFB2D6EE4356348D63AD03C33_487163159 =         superBound.getResolvedTypes().clone();
        var8E000A8FFB2D6EE4356348D63AD03C33_487163159.addTaint(taint);
        return var8E000A8FFB2D6EE4356348D63AD03C33_487163159;
        // ---------- Original Method ----------
        //return superBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.982 -0400", hash_original_method = "F21086AF3EFC8DD73AF90E899FA34F74", hash_generated_method = "368681DEE51D1283DFE0FC42722B8178")
    public Type[] getUpperBounds() throws TypeNotPresentException,
            MalformedParameterizedTypeException {
Type[] var2FB75AED8F019A8332F7B6FA9015FCE6_1196800001 =         extendsBound.getResolvedTypes().clone();
        var2FB75AED8F019A8332F7B6FA9015FCE6_1196800001.addTaint(taint);
        return var2FB75AED8F019A8332F7B6FA9015FCE6_1196800001;
        // ---------- Original Method ----------
        //return extendsBound.getResolvedTypes().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.982 -0400", hash_original_method = "4E6CE2D91E2326D588B30852F56501A7", hash_generated_method = "9FF4616E8FD733E8F8262F064AA39C00")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof WildcardType))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1834309857 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030414056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030414056;
        } //End block
        WildcardType that = (WildcardType) o;
        boolean var7F74412AACA7984A3FE6EB19D38617AF_146689312 = (Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                Arrays.equals(getUpperBounds(), that.getUpperBounds()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472487511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472487511;
        // ---------- Original Method ----------
        //if(!(o instanceof WildcardType)) {
            //return false;
        //}
        //WildcardType that = (WildcardType) o;
        //return Arrays.equals(getLowerBounds(), that.getLowerBounds()) &&
                //Arrays.equals(getUpperBounds(), that.getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.983 -0400", hash_original_method = "336948550805F35B42E4F5770BA4CC44", hash_generated_method = "423CCCD969D279AB37F00C59C2653CFE")
    @Override
    public int hashCode() {
        int var66FB75D7A40899C73E8085C507B05DFA_795101109 = (31 * Arrays.hashCode(getLowerBounds()) +
                Arrays.hashCode(getUpperBounds()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084578117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084578117;
        // ---------- Original Method ----------
        //return 31 * Arrays.hashCode(getLowerBounds()) +
                //Arrays.hashCode(getUpperBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.983 -0400", hash_original_method = "93865AC448C11A5C9C4A3B3F15C62698", hash_generated_method = "38F56C06CA3A981F123C60B3E0B8D972")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("?");
        if((extendsBound.length() == 1 && extendsBound.getResolvedTypes()[0] != Object.class)
                || extendsBound.length() > 1)        
        {
            sb.append(" extends ").append(extendsBound);
        } //End block
        else
        if(superBound.length() > 0)        
        {
            sb.append(" super ").append(superBound);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_683769114 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_683769114.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_683769114;
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

