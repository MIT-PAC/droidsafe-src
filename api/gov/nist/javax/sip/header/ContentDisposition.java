package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.*;

public final class ContentDisposition extends ParametersHeader implements javax.sip.header.ContentDispositionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.224 -0400", hash_original_field = "86E632F72B9E07ED6667FBC88CAC9E93", hash_generated_field = "3DCB42D88F9099A5D16D2C3D4422D6B7")

    protected String dispositionType;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.225 -0400", hash_original_method = "43E6E51171C31AE017D057FA4552D811", hash_generated_method = "30697E61C2A62E132F1F2ECEC533B294")
    public  ContentDisposition() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.225 -0400", hash_original_method = "A77142351A28E594907776BE9B73073E", hash_generated_method = "0AF0E2918D88376B62382DC2BB98C5D5")
    public String encodeBody() {
        StringBuffer encoding = new StringBuffer(dispositionType);
    if(!this.parameters.isEmpty())        
        {
            encoding.append(SEMICOLON).append(parameters.encode());
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_1220286826 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1220286826.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1220286826;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer(dispositionType);
        //if (!this.parameters.isEmpty()) {
            //encoding.append(SEMICOLON).append(parameters.encode());
        //}
        //return encoding.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.226 -0400", hash_original_method = "BC30AB325A2FD01EDD0A547607B8E8A1", hash_generated_method = "331655E3188477F953BF80BB4F66C010")
    public void setDispositionType(String dispositionType) throws ParseException {
    if(dispositionType == null)        
        {
        NullPointerException var2EED8D9C2B8FBB1B732CEAD90CDEA293_1526886066 = new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        var2EED8D9C2B8FBB1B732CEAD90CDEA293_1526886066.addTaint(taint);
        throw var2EED8D9C2B8FBB1B732CEAD90CDEA293_1526886066;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.227 -0400", hash_original_method = "D3ED1AFB699417969621FE1884F8C7FE", hash_generated_method = "2736253D1898268949894378C98D5786")
    public String getDispositionType() {
String varDF8BFF844B0C824F8A45CA808AD8A3B8_1547137136 =         this.dispositionType;
        varDF8BFF844B0C824F8A45CA808AD8A3B8_1547137136.addTaint(taint);
        return varDF8BFF844B0C824F8A45CA808AD8A3B8_1547137136;
        // ---------- Original Method ----------
        //return this.dispositionType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.227 -0400", hash_original_method = "0297698DA62A584BC408978A78677ED8", hash_generated_method = "70A1AE47B85F7227D3DFB76FA7D5E3DF")
    public String getHandling() {
String var6388C6605C2B24F018472B02E4927E84_274137428 =         this.getParameter("handling");
        var6388C6605C2B24F018472B02E4927E84_274137428.addTaint(taint);
        return var6388C6605C2B24F018472B02E4927E84_274137428;
        // ---------- Original Method ----------
        //return this.getParameter("handling");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.228 -0400", hash_original_method = "B6C4C36D7665EDCFABC9BF782D2AADE0", hash_generated_method = "C926111E44EFB6BCBE40998FCB808739")
    public void setHandling(String handling) throws ParseException {
        addTaint(handling.getTaint());
    if(handling == null)        
        {
        NullPointerException varCA259554B20E4015D3247FC459983887_2027622845 = new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setHandling(), the handling parameter is null");
        varCA259554B20E4015D3247FC459983887_2027622845.addTaint(taint);
        throw varCA259554B20E4015D3247FC459983887_2027622845;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.243 -0400", hash_original_method = "C2FDE3A2DBDC43C0B4279ABCAA53BEFB", hash_generated_method = "8A06244B9C9FB50130A7AEF56E24C0DC")
    public String getContentDisposition() {
String varC32A0959BF3FBBB1F055BAFAA3BABC6F_1032989769 =         this.encodeBody();
        varC32A0959BF3FBBB1F055BAFAA3BABC6F_1032989769.addTaint(taint);
        return varC32A0959BF3FBBB1F055BAFAA3BABC6F_1032989769;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.243 -0400", hash_original_field = "BEA47888ED57494C760553D19E44266B", hash_generated_field = "1A47D47195A65F4F581EF3E849861302")

    private static final long serialVersionUID = 835596496276127003L;
}

