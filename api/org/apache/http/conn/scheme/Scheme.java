package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.util.LangUtils;

public final class Scheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.981 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.981 -0400", hash_original_field = "29ADE661BC5B8F8B761C72AAE89589BE", hash_generated_field = "EE0A679D7069D3BF51EFF346308E2FC4")

    private SocketFactory socketFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.982 -0400", hash_original_field = "AD9869ADBCCEEFF5A73F8163B0777153", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private int defaultPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.982 -0400", hash_original_field = "9442E6482C63DEF4C35BC13B704C52E2", hash_generated_field = "656433D6E22132E512C250C9ABEE8490")

    private boolean layered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.982 -0400", hash_original_field = "40419C36198E2BF68491607F3BBDC619", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.983 -0400", hash_original_method = "FC3EBEAFEA712CD3115701A02487AC2E", hash_generated_method = "03FC8FFF8B51D798755E6B085E631E17")
    public  Scheme(final String name,
                  final SocketFactory factory,
                  final int port) {
        if(name == null)        
        {
            IllegalArgumentException var26F09FCBF829A9D3C835C855E3B31338_539835470 = new IllegalArgumentException
                ("Scheme name may not be null");
            var26F09FCBF829A9D3C835C855E3B31338_539835470.addTaint(taint);
            throw var26F09FCBF829A9D3C835C855E3B31338_539835470;
        } //End block
        if(factory == null)        
        {
            IllegalArgumentException var60AC56733F2C924490E04DC9545D82BA_221128946 = new IllegalArgumentException
                ("Socket factory may not be null");
            var60AC56733F2C924490E04DC9545D82BA_221128946.addTaint(taint);
            throw var60AC56733F2C924490E04DC9545D82BA_221128946;
        } //End block
        if((port <= 0) || (port > 0xffff))        
        {
            IllegalArgumentException var3AE56AA76B273526918767A2B3927377_1146620418 = new IllegalArgumentException
                ("Port is invalid: " + port);
            var3AE56AA76B273526918767A2B3927377_1146620418.addTaint(taint);
            throw var3AE56AA76B273526918767A2B3927377_1146620418;
        } //End block
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.socketFactory = factory;
        this.defaultPort = port;
        this.layered = (factory instanceof LayeredSocketFactory);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException
                //("Scheme name may not be null");
        //}
        //if (factory == null) {
            //throw new IllegalArgumentException
                //("Socket factory may not be null");
        //}
        //if ((port <= 0) || (port > 0xffff)) {
            //throw new IllegalArgumentException
                //("Port is invalid: " + port);
        //}
        //this.name = name.toLowerCase(Locale.ENGLISH);
        //this.socketFactory = factory;
        //this.defaultPort = port;
        //this.layered = (factory instanceof LayeredSocketFactory);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.983 -0400", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "E4A86969BDCD6994E2B0A1CAA0F90191")
    public final int getDefaultPort() {
        int varAD9869ADBCCEEFF5A73F8163B0777153_144172361 = (defaultPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481425758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481425758;
        // ---------- Original Method ----------
        //return defaultPort;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.983 -0400", hash_original_method = "8D53BDBBDB5B8DACC183C2C5A3A2FE13", hash_generated_method = "CA0368CA6FC0C2C3A9B0F66599A30F09")
    public final SocketFactory getSocketFactory() {
SocketFactory varCAA2E01CECD165A7D5546943D524E87F_1883153220 =         socketFactory;
        varCAA2E01CECD165A7D5546943D524E87F_1883153220.addTaint(taint);
        return varCAA2E01CECD165A7D5546943D524E87F_1883153220;
        // ---------- Original Method ----------
        //return socketFactory;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.984 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "58552318E799BF92A6971460AE049C7E")
    public final String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1482962945 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1482962945.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1482962945;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.984 -0400", hash_original_method = "9614A7277DEC14D06C0E4E046469A079", hash_generated_method = "2AF9AF52F80443F228046614C7E61D4B")
    public final boolean isLayered() {
        boolean var9442E6482C63DEF4C35BC13B704C52E2_1901247012 = (layered);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341799991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341799991;
        // ---------- Original Method ----------
        //return layered;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.984 -0400", hash_original_method = "64F6A6BD8BE8E9634AE7594AC6F06F64", hash_generated_method = "F1B971D865B633DBC7AFC7FAEF837F6F")
    public final int resolvePort(int port) {
        addTaint(port);
        int var502DD7EACA4DAB0D16CCB11CCA9B7B44_2086603157 = (((port <= 0) || (port > 0xffff)) ? defaultPort : port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262333485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262333485;
        // ---------- Original Method ----------
        //return ((port <= 0) || (port > 0xffff)) ? defaultPort : port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.985 -0400", hash_original_method = "DC9B71D58EF4666028CCB60CC7379DF5", hash_generated_method = "9B835D854B21D775853AED2E47598E75")
    @Override
    public final String toString() {
        if(stringRep == null)        
        {
            StringBuilder buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append(':');
            buffer.append(Integer.toString(this.defaultPort));
            stringRep = buffer.toString();
        } //End block
String varBB173740B3F06857085CC2C58DFBA675_700620276 =         stringRep;
        varBB173740B3F06857085CC2C58DFBA675_700620276.addTaint(taint);
        return varBB173740B3F06857085CC2C58DFBA675_700620276;
        // ---------- Original Method ----------
        //if (stringRep == null) {
            //StringBuilder buffer = new StringBuilder();
            //buffer.append(this.name);
            //buffer.append(':');
            //buffer.append(Integer.toString(this.defaultPort));
            //stringRep = buffer.toString();
        //}
        //return stringRep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.985 -0400", hash_original_method = "62FA4DFF9313BF5A320239E33F35F300", hash_generated_method = "7EAB5021E628BE5D91FDD46A61B4C198")
    @Override
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_785363084 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81271093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81271093;
        }
        if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2014550940 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322619178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322619178;
        }
        if(!(obj instanceof Scheme))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2136961579 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467286489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467286489;
        }
        Scheme s = (Scheme) obj;
        boolean var7E20ABCE14EE124439EB083940444C4F_1946300242 = ((name.equals(s.name) &&
                defaultPort == s.defaultPort &&
                layered == s.layered &&
                socketFactory.equals(s.socketFactory)
                ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457296105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457296105;
        // ---------- Original Method ----------
        //if (obj == null) return false;
        //if (this == obj) return true;
        //if (!(obj instanceof Scheme)) return false;
        //Scheme s = (Scheme) obj;
        //return (name.equals(s.name) &&
                //defaultPort == s.defaultPort &&
                //layered == s.layered &&
                //socketFactory.equals(s.socketFactory)
                //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.987 -0400", hash_original_method = "D2A22011D07817D724D5F16905D145B4", hash_generated_method = "4E754B3310FBCCBD0A59AF4BA1D16345")
    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.defaultPort);
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.layered);
        hash = LangUtils.hashCode(hash, this.socketFactory);
        int var0800FC577294C34E0B28AD2839435945_989554094 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881422407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881422407;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.defaultPort);
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.layered);
        //hash = LangUtils.hashCode(hash, this.socketFactory);
        //return hash;
    }

    
}

