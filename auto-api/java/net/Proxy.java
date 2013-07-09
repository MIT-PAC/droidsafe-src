package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Proxy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.659 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "0493BBFB1288023B7B163197BF9857A6")

    private Proxy.Type type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.659 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "E0A43CBF82D512E62F9819C96F9107F8")

    private SocketAddress address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.659 -0400", hash_original_method = "16752A487C0930093F66EAD9AA8B14F8", hash_generated_method = "FDF58E2224DDF08DBCA6DF9A12000661")
    public  Proxy(Proxy.Type type, SocketAddress sa) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        } 
        this.type = type;
        address = sa;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.660 -0400", hash_original_method = "D66A32319FBF400033B05D10E8B8C304", hash_generated_method = "3B8506530C1D1E82DA5460F730015C73")
    private  Proxy() {
        type = Type.DIRECT;
        address = null;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.660 -0400", hash_original_method = "78A2D2ADD0266F75C3E71E2673988A41", hash_generated_method = "311BBE421E277D64A3E1ED54EF67FE81")
    public Proxy.Type type() {
        Proxy.Type varB4EAC82CA7396A68D541C85D26508E83_1378392362 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1378392362 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1378392362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1378392362;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.661 -0400", hash_original_method = "9D457D33A5E2F2EF090CABC1273126C2", hash_generated_method = "3C4A40EFE0F51C68456C13F9533F0F1B")
    public SocketAddress address() {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_1241199309 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1241199309 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1241199309.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1241199309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.662 -0400", hash_original_method = "15D85DA96A49804E7A6DD9EB58950877", hash_generated_method = "51E9057FC9AAE164A659B46DBCF766F9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_287331643 = null; 
        StringBuilder builder = new StringBuilder();
        {
            builder.append(type.toString());
        } 
        builder.append("@");
        {
            builder.append(address.toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_287331643 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_287331643.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_287331643;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.662 -0400", hash_original_method = "0AADE3011667515449A8CD7BE7CB43B7", hash_generated_method = "5434CAEAB842317C9384FF066A76C277")
    @Override
    public final boolean equals(Object obj) {
        Proxy another = (Proxy) obj;
        boolean varEAB7084851FAECD7616BC770C9D68717_1590348211 = ((type == another.type) && address.equals(another.address));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433328695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433328695;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.663 -0400", hash_original_method = "AFEB3E9B74402AACB68FC4AD63CE261F", hash_generated_method = "DE484624E2C776BA2FD2A6A1F0D09E19")
    @Override
    public final int hashCode() {
        int ret = 0;
        ret += type.hashCode();
        {
            ret += address.hashCode();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232699561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232699561;
        
        
        
        
            
        
        
    }

    
    public enum Type {
        DIRECT,
        HTTP,
        SOCKS
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.663 -0400", hash_original_field = "00F7D85B1963E3DD128AB25CE9CD2640", hash_generated_field = "CFAF9C7805E2D3759922DBF914F8A204")

    public static final Proxy NO_PROXY = new Proxy();
}

