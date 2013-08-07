package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;






public final class ContentDisposition extends ParametersHeader implements javax.sip.header.ContentDispositionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.221 -0400", hash_original_field = "86E632F72B9E07ED6667FBC88CAC9E93", hash_generated_field = "3DCB42D88F9099A5D16D2C3D4422D6B7")

    protected String dispositionType;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.222 -0400", hash_original_method = "43E6E51171C31AE017D057FA4552D811", hash_generated_method = "30697E61C2A62E132F1F2ECEC533B294")
    public  ContentDisposition() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.223 -0400", hash_original_method = "A77142351A28E594907776BE9B73073E", hash_generated_method = "62E37B3209A0EAABE8BD68EE09F97C2F")
    public String encodeBody() {
        StringBuffer encoding = new StringBuffer(dispositionType);
        if(!this.parameters.isEmpty())        
        {
            encoding.append(SEMICOLON).append(parameters.encode());
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_240188270 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_240188270.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_240188270;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer(dispositionType);
        //if (!this.parameters.isEmpty()) {
            //encoding.append(SEMICOLON).append(parameters.encode());
        //}
        //return encoding.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.223 -0400", hash_original_method = "BC30AB325A2FD01EDD0A547607B8E8A1", hash_generated_method = "09847130BEBBFC95F4B3084444718347")
    public void setDispositionType(String dispositionType) throws ParseException {
        if(dispositionType == null)        
        {
        NullPointerException var2EED8D9C2B8FBB1B732CEAD90CDEA293_1079284805 = new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        var2EED8D9C2B8FBB1B732CEAD90CDEA293_1079284805.addTaint(taint);
        throw var2EED8D9C2B8FBB1B732CEAD90CDEA293_1079284805;
        }
        this.dispositionType = dispositionType;
        // ---------- Original Method ----------
        //if (dispositionType == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        //this.dispositionType = dispositionType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.224 -0400", hash_original_method = "D3ED1AFB699417969621FE1884F8C7FE", hash_generated_method = "F2037F90A0B40145ECC934E6B8795171")
    public String getDispositionType() {
String varDF8BFF844B0C824F8A45CA808AD8A3B8_1663070943 =         this.dispositionType;
        varDF8BFF844B0C824F8A45CA808AD8A3B8_1663070943.addTaint(taint);
        return varDF8BFF844B0C824F8A45CA808AD8A3B8_1663070943;
        // ---------- Original Method ----------
        //return this.dispositionType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.224 -0400", hash_original_method = "0297698DA62A584BC408978A78677ED8", hash_generated_method = "B81B4537ABE60898599A84629DB63846")
    public String getHandling() {
String var6388C6605C2B24F018472B02E4927E84_984948861 =         this.getParameter("handling");
        var6388C6605C2B24F018472B02E4927E84_984948861.addTaint(taint);
        return var6388C6605C2B24F018472B02E4927E84_984948861;
        // ---------- Original Method ----------
        //return this.getParameter("handling");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.224 -0400", hash_original_method = "B6C4C36D7665EDCFABC9BF782D2AADE0", hash_generated_method = "14313B23ECC4D20A2F15C009A53A9FCA")
    public void setHandling(String handling) throws ParseException {
        addTaint(handling.getTaint());
        if(handling == null)        
        {
        NullPointerException varCA259554B20E4015D3247FC459983887_734119166 = new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setHandling(), the handling parameter is null");
        varCA259554B20E4015D3247FC459983887_734119166.addTaint(taint);
        throw varCA259554B20E4015D3247FC459983887_734119166;
        }
        this.setParameter("handling", handling);
        // ---------- Original Method ----------
        //if (handling == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", ContentDisposition, setHandling(), the handling parameter is null");
        //this.setParameter("handling", handling);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.224 -0400", hash_original_method = "C2FDE3A2DBDC43C0B4279ABCAA53BEFB", hash_generated_method = "816D8C99E5B11F2A6CA883D0013BD407")
    public String getContentDisposition() {
String varC32A0959BF3FBBB1F055BAFAA3BABC6F_1308439861 =         this.encodeBody();
        varC32A0959BF3FBBB1F055BAFAA3BABC6F_1308439861.addTaint(taint);
        return varC32A0959BF3FBBB1F055BAFAA3BABC6F_1308439861;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.225 -0400", hash_original_field = "BEA47888ED57494C760553D19E44266B", hash_generated_field = "1A47D47195A65F4F581EF3E849861302")

    private static final long serialVersionUID = 835596496276127003L;
}

