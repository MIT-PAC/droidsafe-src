package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.*;

public final class HostPort extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.398 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "3F747A9CA45D9CE9ECDEEB5F7454A2D3")

    protected Host host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.398 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.398 -0400", hash_original_method = "53C1CBAC5F64E6F014615AADE272B0C0", hash_generated_method = "A8DA055BA683C65FA6DCC1F530F578DA")
    public  HostPort() {
        host = null;
        port = -1;
        // ---------- Original Method ----------
        //host = null;
        //port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.399 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "13D0441D700E769475ADC72356E6DF83")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_71727298 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_71727298.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_71727298;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.399 -0400", hash_original_method = "9895EDF602B81195878A0876FA0B4C29", hash_generated_method = "8549A6B651AF9A3F5A9E531BAC12818C")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        host.encode(buffer);
    if(port != -1)        
        buffer.append(COLON).append(port);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_371984496 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_371984496.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_371984496;
        // ---------- Original Method ----------
        //host.encode(buffer);
        //if (port != -1)
            //buffer.append(COLON).append(port);
        //return buffer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.400 -0400", hash_original_method = "86C54BFDD185E9407C74F8F297BEF1D3", hash_generated_method = "720DAFFD9007E105D45B60F1C70F47A1")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_74236003 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975527848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975527848;
        }
    if(getClass () != other.getClass ())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1440869210 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072997013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072997013;
        } //End block
        HostPort that = (HostPort) other;
        boolean var6DCE11B07A196EACB02A824781B9C289_967822674 = (port == that.port && host.equals(that.host));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_878982775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_878982775;
        // ---------- Original Method ----------
        //if (other == null) return false;
        //if (getClass () != other.getClass ()) {
            //return false;
        //}
        //HostPort that = (HostPort) other;
        //return port == that.port && host.equals(that.host);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.400 -0400", hash_original_method = "46CD61CB12D2C2108CCC2BF62B36641B", hash_generated_method = "DCDC3723A415ABCA5EF6F527DDC08BE5")
    public Host getHost() {
Host var872E07117C05F1A34EC24B57B694B8E3_1045325222 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1045325222.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1045325222;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.400 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "9570FCB9E4E9C74150468A7AB6497FE7")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1484673038 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834286089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834286089;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.400 -0400", hash_original_method = "B050407BAA043C3F798F83BEFE766D07", hash_generated_method = "0A84F7E4263DB5B2A23F9F92B776E31F")
    public boolean hasPort() {
        boolean varBEEBC2490D100190731ECB9D39CCD5B5_1416318420 = (port != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19723038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19723038;
        // ---------- Original Method ----------
        //return port != -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.401 -0400", hash_original_method = "7FD66A68FF224A3837669EDD9AB43DAE", hash_generated_method = "A49641C3828C7BB69086DC31891642EB")
    public void removePort() {
        port = -1;
        // ---------- Original Method ----------
        //port = -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.401 -0400", hash_original_method = "7261FADCCAAD2D84DAF8700A574E33AD", hash_generated_method = "249F4BE40025E097F2B0AD1D7907074A")
    public void setHost(Host h) {
        host = h;
        // ---------- Original Method ----------
        //host = h;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.402 -0400", hash_original_method = "77F84B839458179E7DBAF505404F4852", hash_generated_method = "5F6FC0322C192F3D12450D7AA899E4D1")
    public void setPort(int p) {
        port = p;
        // ---------- Original Method ----------
        //port = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.402 -0400", hash_original_method = "1454562F409CD451F70F3E17F975E5B5", hash_generated_method = "03B1B228144C122113E23F61685F6DEE")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
    if(host == null)        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_140690427 =         null;
        var540C13E9E156B687226421B24F2DF178_140690427.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_140690427;
        }
        else
        {
InetAddress varB3B22EAEBFEA1B2A7E7F002D7A469FED_1230687323 =         host.getInetAddress();
        varB3B22EAEBFEA1B2A7E7F002D7A469FED_1230687323.addTaint(taint);
        return varB3B22EAEBFEA1B2A7E7F002D7A469FED_1230687323;
        }
        // ---------- Original Method ----------
        //if (host == null)
            //return null;
        //else
            //return host.getInetAddress();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.402 -0400", hash_original_method = "02B5610089173D5B9ACA58E6AEBD3C51", hash_generated_method = "ADE6764771763942DC0D7B2671CD480C")
    public void merge(Object mergeObject) {
        super.merge (mergeObject);
    if(port == -1)        
        port = ((HostPort) mergeObject).port;
        // ---------- Original Method ----------
        //super.merge (mergeObject);
        //if (port == -1)
            //port = ((HostPort) mergeObject).port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.403 -0400", hash_original_method = "723102D689B5DB9C81F9B317715D80D3", hash_generated_method = "742B129511106AAC97B04E5BA1269165")
    public Object clone() {
        HostPort retval = (HostPort) super.clone();
    if(this.host != null)        
        retval.host = (Host) this.host.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_417962750 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_417962750.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_417962750;
        // ---------- Original Method ----------
        //HostPort retval = (HostPort) super.clone();
        //if (this.host != null)
            //retval.host = (Host) this.host.clone();
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.403 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "E8234790C166BB6FF1B10B7547052E6F")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_653192666 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_653192666.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_653192666;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.403 -0400", hash_original_method = "576865B2F50CE751C00A8F417860D16A", hash_generated_method = "5FEAD8DEDC96CED0070C0F2A25730158")
    @Override
    public int hashCode() {
        int var7AC17209CDA040E9D2D81CC88C0AF0FA_1581262083 = (this.host.hashCode() + this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110346464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110346464;
        // ---------- Original Method ----------
        //return this.host.hashCode() + this.port;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.403 -0400", hash_original_field = "781BF342E6E71829A1551C1951B9151A", hash_generated_field = "7CD9CF316407E65EA07641A462BD6002")

    private static final long serialVersionUID = -7103412227431884523L;
}

