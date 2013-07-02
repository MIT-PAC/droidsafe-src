package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;
import javax.sip.InvalidArgumentException;

public class MaxForwards extends SIPHeader implements MaxForwardsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.775 -0400", hash_original_field = "B54B7D92B744D1F21DF5EE4E44903B54", hash_generated_field = "A7FC64164120C43082DBAEB73DE730FA")

    protected int maxForwards;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.775 -0400", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "04D96CD1DE0F0679DECA6B600CDA4279")
    public  MaxForwards() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.775 -0400", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "943657D160DC718FE7AEE0800BC88187")
    public  MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        this.setMaxForwards( m );
        addTaint(m);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.776 -0400", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "DAB0444BCC2429A797EEB8C0A519BA55")
    public int getMaxForwards() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968545441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968545441;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.776 -0400", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "F01F65F3349C966DFD50EBF45EF9783C")
    public void setMaxForwards(int maxForwards) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        this.maxForwards = maxForwards;
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.777 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "D0C76A19333D901E3D452A67FB733A81")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_339772733 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_339772733 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_339772733.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_339772733;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.779 -0400", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "67693ADBD13FBF1979EB69653FD55764")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1927995142 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1927995142 = buffer.append(maxForwards);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1927995142.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1927995142;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.779 -0400", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "D01FAE9617F1D879513B5CC4D78A0D1F")
    public boolean hasReachedZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951288386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951288386;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.780 -0400", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "68E687119F536C73F51B32EEC65D4BBB")
    public void decrementMaxForwards() throws TooManyHopsException {
        if (DroidSafeAndroidRuntime.control) throw new TooManyHopsException ("has already reached 0!");
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.782 -0400", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "2D8F3D24E7BCE8516F4390856C937512")
    public boolean equals(Object other) {
        {
            final MaxForwardsHeader o = (MaxForwardsHeader) other;
            boolean var21BF6D3D60EF72E8992E53F7A93EB3D4_945287282 = (this.getMaxForwards() == o.getMaxForwards());
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488071515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488071515;
        
        
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.782 -0400", hash_original_field = "A3BB09F5637A7FA02606816157C94C5C", hash_generated_field = "A999D5831FAE9A2CB5D83E10B325A89A")

    private static final long serialVersionUID = -3096874323347175943L;
}

