package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.*;

public final class HostPort extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.390 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "3F747A9CA45D9CE9ECDEEB5F7454A2D3")

    protected Host host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.390 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.391 -0400", hash_original_method = "53C1CBAC5F64E6F014615AADE272B0C0", hash_generated_method = "A8DA055BA683C65FA6DCC1F530F578DA")
    public  HostPort() {
        host = null;
        port = -1;
        // ---------- Original Method ----------
        //host = null;
        //port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.391 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "A382DEE829A2CE27BC57E57BD513EBEE")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1009216447 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1009216447.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1009216447;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.391 -0400", hash_original_method = "9895EDF602B81195878A0876FA0B4C29", hash_generated_method = "3C5B2976B4BCD862C22F09EBBA65733B")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        host.encode(buffer);
        if(port != -1)        
        buffer.append(COLON).append(port);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1177939336 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1177939336.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1177939336;
        // ---------- Original Method ----------
        //host.encode(buffer);
        //if (port != -1)
            //buffer.append(COLON).append(port);
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.392 -0400", hash_original_method = "86C54BFDD185E9407C74F8F297BEF1D3", hash_generated_method = "76062C7F967BFF05B98282724451DFBE")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1209779508 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587664787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_587664787;
        }
        if(getClass () != other.getClass ())        
        {
            boolean var68934A3E9455FA72420237EB05902327_364353716 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799112304 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799112304;
        } //End block
        HostPort that = (HostPort) other;
        boolean var6DCE11B07A196EACB02A824781B9C289_777024684 = (port == that.port && host.equals(that.host));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302412125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302412125;
        // ---------- Original Method ----------
        //if (other == null) return false;
        //if (getClass () != other.getClass ()) {
            //return false;
        //}
        //HostPort that = (HostPort) other;
        //return port == that.port && host.equals(that.host);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.392 -0400", hash_original_method = "46CD61CB12D2C2108CCC2BF62B36641B", hash_generated_method = "192EFCE6C8B53F94DB29D60A177B5433")
    public Host getHost() {
Host var872E07117C05F1A34EC24B57B694B8E3_810632837 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_810632837.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_810632837;
        // ---------- Original Method ----------
        //return host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.392 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "2698F412ACA2B8C685391A1BD80CC576")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1782084791 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549473467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549473467;
        // ---------- Original Method ----------
        //return port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.393 -0400", hash_original_method = "B050407BAA043C3F798F83BEFE766D07", hash_generated_method = "C0E99A78863CCACA14008D2C02653F64")
    public boolean hasPort() {
        boolean varBEEBC2490D100190731ECB9D39CCD5B5_1521617902 = (port != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916408814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916408814;
        // ---------- Original Method ----------
        //return port != -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.393 -0400", hash_original_method = "7FD66A68FF224A3837669EDD9AB43DAE", hash_generated_method = "A49641C3828C7BB69086DC31891642EB")
    public void removePort() {
        port = -1;
        // ---------- Original Method ----------
        //port = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.394 -0400", hash_original_method = "7261FADCCAAD2D84DAF8700A574E33AD", hash_generated_method = "249F4BE40025E097F2B0AD1D7907074A")
    public void setHost(Host h) {
        host = h;
        // ---------- Original Method ----------
        //host = h;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.394 -0400", hash_original_method = "77F84B839458179E7DBAF505404F4852", hash_generated_method = "5F6FC0322C192F3D12450D7AA899E4D1")
    public void setPort(int p) {
        port = p;
        // ---------- Original Method ----------
        //port = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.394 -0400", hash_original_method = "1454562F409CD451F70F3E17F975E5B5", hash_generated_method = "A5C6FF8F9D4DBC2F4737CF0EED7AE7E1")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        if(host == null)        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_1311038715 =         null;
        var540C13E9E156B687226421B24F2DF178_1311038715.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1311038715;
        }
        else
        {
InetAddress varB3B22EAEBFEA1B2A7E7F002D7A469FED_1773897393 =         host.getInetAddress();
        varB3B22EAEBFEA1B2A7E7F002D7A469FED_1773897393.addTaint(taint);
        return varB3B22EAEBFEA1B2A7E7F002D7A469FED_1773897393;
        }
        // ---------- Original Method ----------
        //if (host == null)
            //return null;
        //else
            //return host.getInetAddress();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.395 -0400", hash_original_method = "02B5610089173D5B9ACA58E6AEBD3C51", hash_generated_method = "ADE6764771763942DC0D7B2671CD480C")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.395 -0400", hash_original_method = "723102D689B5DB9C81F9B317715D80D3", hash_generated_method = "0D83C76683AA552081FDC05A9AAB6BB1")
    public Object clone() {
        HostPort retval = (HostPort) super.clone();
        if(this.host != null)        
        retval.host = (Host) this.host.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_262093213 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_262093213.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_262093213;
        // ---------- Original Method ----------
        //HostPort retval = (HostPort) super.clone();
        //if (this.host != null)
            //retval.host = (Host) this.host.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.396 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "05E817CD82448A891A3775D2D382101D")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_1551097101 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1551097101.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1551097101;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.396 -0400", hash_original_method = "576865B2F50CE751C00A8F417860D16A", hash_generated_method = "16537A9F52BEE81920C8D6B9C17C36E9")
    @Override
    public int hashCode() {
        int var7AC17209CDA040E9D2D81CC88C0AF0FA_197956979 = (this.host.hashCode() + this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422036337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422036337;
        // ---------- Original Method ----------
        //return this.host.hashCode() + this.port;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.396 -0400", hash_original_field = "781BF342E6E71829A1551C1951B9151A", hash_generated_field = "7CD9CF316407E65EA07641A462BD6002")

    private static final long serialVersionUID = -7103412227431884523L;
}

