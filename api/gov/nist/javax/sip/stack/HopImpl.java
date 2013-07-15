package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.StringTokenizer;

public final class HopImpl extends Object implements javax.sip.address.Hop, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.458 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.458 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.458 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.458 -0400", hash_original_field = "F35E88995B01DD639351EFA9D1C5FAAA", hash_generated_field = "507947F99EFE636A32340E3AA843BB3D")

    protected boolean defaultRoute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.458 -0400", hash_original_field = "177A6DC537A1CE75A7A6EEB2280E832A", hash_generated_field = "F6D3A083A27E3AA80C885284DEF016AB")

    protected boolean uriRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.459 -0400", hash_original_method = "0B5C776E3038172CE320CE66ECCB4725", hash_generated_method = "5A8FB8B738B5DB9AC744FFEE7DE4B832")
    public  HopImpl(String hostName, int portNumber, String trans) {
        host = hostName;
    if(host.indexOf(":") >= 0)        
    if(host.indexOf("[") < 0)        
        host = "[" + host + "]";
        port = portNumber;
        transport = trans;
        // ---------- Original Method ----------
        //host = hostName;
        //if(host.indexOf(":") >= 0)
            //if(host.indexOf("[") < 0)
                //host = "[" + host + "]";
        //port = portNumber;
        //transport = trans;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.462 -0400", hash_original_method = "54879B5E9B62042FEEDC1EE4ADCFBB66", hash_generated_method = "93150EA02FF9141C5E51C217FCBCFA9E")
      HopImpl(String hop) throws IllegalArgumentException {
    if(hop == null)        
        {
        IllegalArgumentException var394C931F9C085D222FFF886F8D79CBFB_2057080064 = new IllegalArgumentException("Null arg!");
        var394C931F9C085D222FFF886F8D79CBFB_2057080064.addTaint(taint);
        throw var394C931F9C085D222FFF886F8D79CBFB_2057080064;
        }
        int brack = hop.indexOf(']');
        int colon = hop.indexOf(':',brack);
        int slash = hop.indexOf('/',colon);
    if(colon>0)        
        {
            this.host = hop.substring(0,colon);
            String portstr;
    if(slash>0)            
            {
                portstr = hop.substring(colon+1,slash);
                this.transport = hop.substring(slash+1);
            } //End block
            else
            {
                portstr = hop.substring(colon+1);
                this.transport = "UDP";
            } //End block
            try 
            {
                port = Integer.parseInt(portstr);
            } //End block
            catch (NumberFormatException ex)
            {
                IllegalArgumentException varEA6557E584B89B4716CA1E5EE85B96CC_12456242 = new IllegalArgumentException("Bad port spec");
                varEA6557E584B89B4716CA1E5EE85B96CC_12456242.addTaint(taint);
                throw varEA6557E584B89B4716CA1E5EE85B96CC_12456242;
            } //End block
        } //End block
        else
        {
    if(slash>0)            
            {
                this.host = hop.substring(0,slash);
                this.transport = hop.substring(slash+1);
                this.port = transport.equalsIgnoreCase("TLS") ? 5061 : 5060;
            } //End block
            else
            {
                this.host = hop;
                this.transport = "UDP";
                this.port = 5060;
            } //End block
        } //End block
    if(host == null || host.length() == 0)        
        {
        IllegalArgumentException var81C819C46CBF493B7DCBC5424425EB3F_589180462 = new IllegalArgumentException("no host!");
        var81C819C46CBF493B7DCBC5424425EB3F_589180462.addTaint(taint);
        throw var81C819C46CBF493B7DCBC5424425EB3F_589180462;
        }
        this.host = this.host.trim();
        this.transport = this.transport.trim();
    if((brack>0) && host.charAt(0)!='[')        
        {
            IllegalArgumentException var298141578FE404B0D2D46386C7D75A3D_852361641 = new IllegalArgumentException("Bad IPv6 reference spec");
            var298141578FE404B0D2D46386C7D75A3D_852361641.addTaint(taint);
            throw var298141578FE404B0D2D46386C7D75A3D_852361641;
        } //End block
    if(transport.compareToIgnoreCase("UDP") != 0
            && transport.compareToIgnoreCase("TLS") != 0
            && transport.compareToIgnoreCase("TCP") != 0)        
        {
            System.err.println("Bad transport string " + transport);
            IllegalArgumentException var8CB33DA4B4021B20931AEF5D6CA1B510_650750798 = new IllegalArgumentException(hop);
            var8CB33DA4B4021B20931AEF5D6CA1B510_650750798.addTaint(taint);
            throw var8CB33DA4B4021B20931AEF5D6CA1B510_650750798;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.463 -0400", hash_original_method = "E930BE940ED709A9E92F64EC28520C28", hash_generated_method = "5980C3ADD7C4CB167ABB1F7E73B394D7")
    public String toString() {
String var3CEA0CD315D0C4FE374BE8056D2D2CE1_428880565 =         host + ":" + port + "/" + transport;
        var3CEA0CD315D0C4FE374BE8056D2D2CE1_428880565.addTaint(taint);
        return var3CEA0CD315D0C4FE374BE8056D2D2CE1_428880565;
        // ---------- Original Method ----------
        //return host + ":" + port + "/" + transport;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.464 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "7E262AFB7BB5138FEF96F22028228046")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_717499807 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_717499807.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_717499807;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.464 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "5AD944CDF3ADC1A634FC0B76BDB4E71C")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1379896399 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830803457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830803457;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.464 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "249818802AF632BB352459BD380E4B69")
    public String getTransport() {
String var6D37A12806110C538EDC9272068F264D_768636121 =         transport;
        var6D37A12806110C538EDC9272068F264D_768636121.addTaint(taint);
        return var6D37A12806110C538EDC9272068F264D_768636121;
        // ---------- Original Method ----------
        //return transport;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.464 -0400", hash_original_method = "7B7F5CA7C760A6206185BE96F86E54F2", hash_generated_method = "87D49A2719A450070417970B9B059D2C")
    public boolean isURIRoute() {
        boolean var177A6DC537A1CE75A7A6EEB2280E832A_1453834759 = (uriRoute);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32241792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32241792;
        // ---------- Original Method ----------
        //return uriRoute;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.465 -0400", hash_original_method = "4D177A2C7A5E9A8C62FF46DC5D4CFB65", hash_generated_method = "B3EF0D7F68E6E1C436677D2677199934")
    public void setURIRouteFlag() {
        uriRoute = true;
        // ---------- Original Method ----------
        //uriRoute = true;
    }

    
}

