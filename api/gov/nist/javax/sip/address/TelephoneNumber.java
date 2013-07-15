package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import java.util.Iterator;

public class TelephoneNumber extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.402 -0400", hash_original_field = "9B54CF4C9AEF2A42C8430B43936B405A", hash_generated_field = "F0F600057F56A09C7F67C507D581D80D")

    protected boolean isglobal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.402 -0400", hash_original_field = "C9AA10B21BC611B05B1D8E0C01E5D397", hash_generated_field = "A5887F206856305D82FC53512CE55D3B")

    protected String phoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.403 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.403 -0400", hash_original_method = "C2E661A0F0E8603FDB28C1E5F6957C6B", hash_generated_method = "ED4544B8D5B014FCD0F73770D6821934")
    public  TelephoneNumber() {
        parameters = new NameValueList();
        // ---------- Original Method ----------
        //parameters = new NameValueList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.404 -0400", hash_original_method = "482E6E79DCAAF2107BA2BF4B499737C2", hash_generated_method = "48C19343A0131F1E66141B9CC0D4F92D")
    public void deleteParm(String name) {
        addTaint(name.getTaint());
        parameters.delete(name);
        // ---------- Original Method ----------
        //parameters.delete(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.404 -0400", hash_original_method = "52800C2C905EEB817404225ADBC057C1", hash_generated_method = "4484A473ABBA7C2FF7EB60D42D1094F1")
    public String getPhoneNumber() {
String var80A2B48412D7084FC222C283D090147C_728733360 =         phoneNumber;
        var80A2B48412D7084FC222C283D090147C_728733360.addTaint(taint);
        return var80A2B48412D7084FC222C283D090147C_728733360;
        // ---------- Original Method ----------
        //return phoneNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.404 -0400", hash_original_method = "46AF8366350CE91B864B76E1571FD560", hash_generated_method = "68A1BA9274062473F2E1E1D0EF46CF27")
    public String getPostDial() {
String var20554D397FE5E8F2150B90C3AA71E78F_1395004569 =         (String) parameters.getValue(POSTDIAL);
        var20554D397FE5E8F2150B90C3AA71E78F_1395004569.addTaint(taint);
        return var20554D397FE5E8F2150B90C3AA71E78F_1395004569;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(POSTDIAL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.405 -0400", hash_original_method = "E5D57B503B0E16A000773FA057D6B1B7", hash_generated_method = "80EE3958E5DE01DB8821528466E515D5")
    public String getIsdnSubaddress() {
String var23F8BF1FB6A7308B9399BFF22EC6904A_586391808 =         (String) parameters.getValue(ISUB);
        var23F8BF1FB6A7308B9399BFF22EC6904A_586391808.addTaint(taint);
        return var23F8BF1FB6A7308B9399BFF22EC6904A_586391808;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ISUB);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.405 -0400", hash_original_method = "E1FFD425535E2D30F5D43A147688D9A7", hash_generated_method = "FB540EC7F0E95516D1AD7EE20175C842")
    public boolean hasPostDial() {
        boolean varE1117CDCB20029A12F63BB2ADF343795_347368831 = (parameters.getValue(POSTDIAL) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966876054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966876054;
        // ---------- Original Method ----------
        //return parameters.getValue(POSTDIAL) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.405 -0400", hash_original_method = "588E30C769F46315FA0899538D14C7E2", hash_generated_method = "E36137CB8B78829A8665158B3EBA9AE3")
    public boolean hasParm(String pname) {
        addTaint(pname.getTaint());
        boolean varD1302D9B5617A73E54BC129EAC80D745_1614012241 = (parameters.hasNameValue(pname));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624314958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624314958;
        // ---------- Original Method ----------
        //return parameters.hasNameValue(pname);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.405 -0400", hash_original_method = "647E85AB615972325C277E376A221EF0", hash_generated_method = "74AF6E800556FCB078270D0F83112E42")
    public boolean hasIsdnSubaddress() {
        boolean var59ED3957C6975DF5FF09F89EF049125E_1921936700 = (hasParm(ISUB));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232594925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232594925;
        // ---------- Original Method ----------
        //return hasParm(ISUB);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.406 -0400", hash_original_method = "26808293282132329FBEA070B2AD722D", hash_generated_method = "A4C93D832A0AB9E0D43296169C851AA4")
    public boolean isGlobal() {
        boolean var9B54CF4C9AEF2A42C8430B43936B405A_1674181996 = (isglobal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898143235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898143235;
        // ---------- Original Method ----------
        //return isglobal;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.406 -0400", hash_original_method = "872EACB97AA4D13F74BE9616D4416942", hash_generated_method = "E8F7D5A33418C1A5618069298CBCDFC0")
    public void removePostDial() {
        parameters.delete(POSTDIAL);
        // ---------- Original Method ----------
        //parameters.delete(POSTDIAL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.407 -0400", hash_original_method = "C4A054C6DC361788E8A02206DAB97797", hash_generated_method = "57EE5CD2FBB1671F10B9A34884F9DD7B")
    public void removeIsdnSubaddress() {
        deleteParm(ISUB);
        // ---------- Original Method ----------
        //deleteParm(ISUB);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.407 -0400", hash_original_method = "779B73549EB95AA1112D17D4BD37698F", hash_generated_method = "959236CB1F720298C9BF15740EF84153")
    public void setParameters(NameValueList p) {
        parameters = p;
        // ---------- Original Method ----------
        //parameters = p;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.407 -0400", hash_original_method = "AC69D7A5F7431BD993B4E02357C1C328", hash_generated_method = "8AE7A45CDBFC0F972181147E0F3ACDEE")
    public void setGlobal(boolean g) {
        isglobal = g;
        // ---------- Original Method ----------
        //isglobal = g;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.408 -0400", hash_original_method = "3187783A98FD3EF3CF221F591C928162", hash_generated_method = "7E210E4C658D3845E2DC6E5D27076404")
    public void setPostDial(String p) {
        addTaint(p.getTaint());
        NameValue nv = new NameValue(POSTDIAL, p);
        parameters.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(POSTDIAL, p);
        //parameters.set(nv);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.408 -0400", hash_original_method = "1017383CE0C4E09E719151FC1E532DF6", hash_generated_method = "51B636B907A8DA608DDE917CB607FB33")
    public void setParm(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = new NameValue(name, value);
        parameters.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //parameters.set(nv);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.408 -0400", hash_original_method = "2C7FD6CD1F9BBF926548B29323136AA0", hash_generated_method = "4594961801471F90EEC6A4AE271221F7")
    public void setIsdnSubaddress(String isub) {
        addTaint(isub.getTaint());
        setParm(ISUB, isub);
        // ---------- Original Method ----------
        //setParm(ISUB, isub);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.409 -0400", hash_original_method = "0D906AA6E6C51748158DF0E26B379B98", hash_generated_method = "5792C7D29465A82AFE011B3B06F20683")
    public void setPhoneNumber(String num) {
        phoneNumber = num;
        // ---------- Original Method ----------
        //phoneNumber = num;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.409 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "4B20CC368911A809E6441A200E3C113D")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_712663924 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_712663924.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_712663924;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.409 -0400", hash_original_method = "4745D56EA907C8F5BA4F4E737AF3537A", hash_generated_method = "A1B729214C6C213C54F5BF14505C74E5")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(isglobal)        
        buffer.append('+');
        buffer.append(phoneNumber);
    if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_237647649 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_237647649.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_237647649;
        // ---------- Original Method ----------
        //if (isglobal)
            //buffer.append('+');
        //buffer.append(phoneNumber);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.410 -0400", hash_original_method = "6A189D1F37381970473560C000F9F148", hash_generated_method = "97F42750C3C708635B4C3588023F3740")
    public String getParameter(String name) {
        addTaint(name.getTaint());
        Object val = parameters.getValue(name);
    if(val == null)        
        {
String var540C13E9E156B687226421B24F2DF178_52494562 =         null;
        var540C13E9E156B687226421B24F2DF178_52494562.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_52494562;
        }
    if(val instanceof GenericObject)        
        {
String varF1B6C72F38290E3B9280610078FC772A_1257692615 =         ((GenericObject) val).encode();
        varF1B6C72F38290E3B9280610078FC772A_1257692615.addTaint(taint);
        return varF1B6C72F38290E3B9280610078FC772A_1257692615;
        }
        else
        {
String var38570108501B3BE2AC163FA564B07985_1801791259 =         val.toString();
        var38570108501B3BE2AC163FA564B07985_1801791259.addTaint(taint);
        return var38570108501B3BE2AC163FA564B07985_1801791259;
        }
        // ---------- Original Method ----------
        //Object val = parameters.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.410 -0400", hash_original_method = "CB48E75FADF5A296C71C66E8605F8AA2", hash_generated_method = "1091589BD9C95104CB67E3278F334A46")
    public Iterator<String> getParameterNames() {
Iterator<String> varEC2D17FE1BD134F71B123F3C13B598E1_612976442 =         this.parameters.getNames();
        varEC2D17FE1BD134F71B123F3C13B598E1_612976442.addTaint(taint);
        return varEC2D17FE1BD134F71B123F3C13B598E1_612976442;
        // ---------- Original Method ----------
        //return this.parameters.getNames();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.410 -0400", hash_original_method = "B7E395B29F4AF7C2E05F5A2CCFC8AF7A", hash_generated_method = "F810B1BDB6F7D498F364DD8FD78DEFDB")
    public void removeParameter(String parameter) {
        addTaint(parameter.getTaint());
        this.parameters.delete(parameter);
        // ---------- Original Method ----------
        //this.parameters.delete(parameter);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.411 -0400", hash_original_method = "EF9A54632618F205C3C318D3100361E8", hash_generated_method = "592F28761A0A6F93BE6EB47034A4929F")
    public void setParameter(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = new NameValue(name, value);
        this.parameters.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //this.parameters.set(nv);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.411 -0400", hash_original_method = "459B956E59E9D185995D481A4A763AF3", hash_generated_method = "DDFCF150DF2884F7D9030C640173D8E1")
    public Object clone() {
        TelephoneNumber retval = (TelephoneNumber) super.clone();
    if(this.parameters != null)        
        retval.parameters = (NameValueList) this.parameters.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1468287433 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1468287433.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1468287433;
        // ---------- Original Method ----------
        //TelephoneNumber retval = (TelephoneNumber) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.411 -0400", hash_original_method = "3F9E254F8A6DAF7B33BDD77A0CAB2530", hash_generated_method = "2C029CEE635EE6307790CD0D5FFABFEC")
    public NameValueList getParameters() {
NameValueList varD57264E6000D50A1BD4C397379615A33_1021951601 =         this.parameters;
        varD57264E6000D50A1BD4C397379615A33_1021951601.addTaint(taint);
        return varD57264E6000D50A1BD4C397379615A33_1021951601;
        // ---------- Original Method ----------
        //return this.parameters;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.411 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.411 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.411 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.412 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

