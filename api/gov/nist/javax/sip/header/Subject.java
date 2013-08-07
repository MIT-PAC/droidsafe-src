package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.SubjectHeader;






public class Subject extends SIPHeader implements SubjectHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.530 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "FCF19B41C65ED3C233A6175A0183A3FB")

    protected String subject;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.531 -0400", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "FC1BF9AC217CC58F50D5E1F25B779F09")
    public  Subject() {
        super(SUBJECT);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.531 -0400", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "2C9E85F4972033EC6CB50750D4686E17")
    public String encodeBody() {
        if(subject != null)        
        {
String varC07EC1407326EABEF2FB6D781FE48674_792278481 =             subject;
            varC07EC1407326EABEF2FB6D781FE48674_792278481.addTaint(taint);
            return varC07EC1407326EABEF2FB6D781FE48674_792278481;
        } //End block
        else
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_294534337 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_294534337.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_294534337;
        } //End block
        // ---------- Original Method ----------
        //if (subject != null) {
            //return subject;
        //} else {
            //return "";
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.532 -0400", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "ED05BB9E2157479BA0FC88DE65314C91")
    public void setSubject(String subject) throws ParseException {
        if(subject == null)        
        {
        NullPointerException var13137744AD19720D56B5B3D816DDCAEE_418566743 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        var13137744AD19720D56B5B3D816DDCAEE_418566743.addTaint(taint);
        throw var13137744AD19720D56B5B3D816DDCAEE_418566743;
        }
        this.subject = subject;
        // ---------- Original Method ----------
        //if (subject == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Subject, setSubject(), the subject parameter is null");
        //this.subject = subject;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.532 -0400", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "CAE2D46F031643CEDD032E6D1856F3BC")
    public String getSubject() {
String varC07EC1407326EABEF2FB6D781FE48674_942854945 =         subject;
        varC07EC1407326EABEF2FB6D781FE48674_942854945.addTaint(taint);
        return varC07EC1407326EABEF2FB6D781FE48674_942854945;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.532 -0400", hash_original_field = "3D06F226553D3F5C6F20075141F7D3D9", hash_generated_field = "5A108BF1E2A98855AB05AF0A50CEDCDE")

    private static final long serialVersionUID = -6479220126758862528L;
}

