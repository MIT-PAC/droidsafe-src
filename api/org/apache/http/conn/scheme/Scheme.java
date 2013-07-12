package org.apache.http.conn.scheme;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public final class Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.645 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.645 -0400", hash_original_field = "29ADE661BC5B8F8B761C72AAE89589BE", hash_generated_field = "EE0A679D7069D3BF51EFF346308E2FC4")

    private SocketFactory socketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.645 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.645 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "656433D6E22132E512C250C9ABEE8490")

    private boolean layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.645 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.646 -0400", hash_original_method = "FC3EBEAFEA712CD3115701A02487AC2E", hash_generated_method = "B8526E8DA6D19B6AA73F2B332C17F013")
    public  Scheme(final String name,
                  final SocketFactory factory,
                  final int port) {
    if(name == null)        
        {
            IllegalArgumentException var26F09FCBF829A9D3C835C855E3B31338_2080713753 = new IllegalArgumentException
                ("Scheme name may not be null");
            var26F09FCBF829A9D3C835C855E3B31338_2080713753.addTaint(taint);
            throw var26F09FCBF829A9D3C835C855E3B31338_2080713753;
        } 
    if(factory == null)        
        {
            IllegalArgumentException var60AC56733F2C924490E04DC9545D82BA_1690548119 = new IllegalArgumentException
                ("Socket factory may not be null");
            var60AC56733F2C924490E04DC9545D82BA_1690548119.addTaint(taint);
            throw var60AC56733F2C924490E04DC9545D82BA_1690548119;
        } 
    if((port <= 0) || (port > 0xffff))        
        {
            IllegalArgumentException var3AE56AA76B273526918767A2B3927377_419941033 = new IllegalArgumentException
                ("Port is invalid: " + port);
            var3AE56AA76B273526918767A2B3927377_419941033.addTaint(taint);
            throw var3AE56AA76B273526918767A2B3927377_419941033;
        } 
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.socketFactory = factory;
        this.defaultPort = port;
        this.layered = (factory instanceof LayeredSocketFactory);
        
        
            
                
        
        
            
                
        
        
            
                
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.647 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "A33986E984C20E9D67948BE97E889DD2")
    public final int getDefaultPort() {
        int varAD9869ADBCCEEFF5A73F8163B0777153_1372266882 = (defaultPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310763655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310763655;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.647 -0400", hash_original_method = "8D53BDBBDB5B8DACC183C2C5A3A2FE13", hash_generated_method = "A9F3AD93BF5AD6B87FC52AB8799E44EA")
    public final SocketFactory getSocketFactory() {
SocketFactory varCAA2E01CECD165A7D5546943D524E87F_793420594 =         socketFactory;
        varCAA2E01CECD165A7D5546943D524E87F_793420594.addTaint(taint);
        return varCAA2E01CECD165A7D5546943D524E87F_793420594;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.647 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "E7D4EBDAB3A9F5FF95708589D3CC073C")
    public final String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_316973939 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_316973939.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_316973939;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.648 -0400", hash_original_method = "9614A7277DEC14D06C0E4E046469A079", hash_generated_method = "393748F3229505683B0A8765C3A5339A")
    public final boolean isLayered() {
        boolean var9442E6482C63DEF4C35BC13B704C52E2_1488700194 = (layered);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982204765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_982204765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.648 -0400", hash_original_method = "64F6A6BD8BE8E9634AE7594AC6F06F64", hash_generated_method = "C18CB3C829EF067FD17ADEF2187F4A00")
    public final int resolvePort(int port) {
        addTaint(port);
        int var502DD7EACA4DAB0D16CCB11CCA9B7B44_1470358627 = (((port <= 0) || (port > 0xffff)) ? defaultPort : port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583795213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583795213;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.648 -0400", hash_original_method = "DC9B71D58EF4666028CCB60CC7379DF5", hash_generated_method = "F0BDFD9BFF7E9C9B0A67906FE3E61534")
    @Override
    public final String toString() {
    if(stringRep == null)        
        {
            StringBuilder buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append(':');
            buffer.append(Integer.toString(this.defaultPort));
            stringRep = buffer.toString();
        } 
String varBB173740B3F06857085CC2C58DFBA675_1155911150 =         stringRep;
        varBB173740B3F06857085CC2C58DFBA675_1155911150.addTaint(taint);
        return varBB173740B3F06857085CC2C58DFBA675_1155911150;
        
        
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.649 -0400", hash_original_method = "62FA4DFF9313BF5A320239E33F35F300", hash_generated_method = "F8E1EE82EE78D7EF42DA28995FF5DE26")
    @Override
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1266821966 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772837532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772837532;
        }
    if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2086202578 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570637200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570637200;
        }
    if(!(obj instanceof Scheme))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1434394228 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240620273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240620273;
        }
        Scheme s = (Scheme) obj;
        boolean var7E20ABCE14EE124439EB083940444C4F_762422407 = ((name.equals(s.name) &&
                defaultPort == s.defaultPort &&
                layered == s.layered &&
                socketFactory.equals(s.socketFactory)
                ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920370446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920370446;
        
        
        
        
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.650 -0400", hash_original_method = "D2A22011D07817D724D5F16905D145B4", hash_generated_method = "16945F740E14F0E350F638D609E6BAA8")
    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.defaultPort);
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.layered);
        hash = LangUtils.hashCode(hash, this.socketFactory);
        int var0800FC577294C34E0B28AD2839435945_885159567 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158130255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158130255;
        
        
        
        
        
        
        
    }

    
}

