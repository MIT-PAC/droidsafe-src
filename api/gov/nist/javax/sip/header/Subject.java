package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class Subject extends SIPHeader implements SubjectHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.467 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "FCF19B41C65ED3C233A6175A0183A3FB")

    protected String subject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.467 -0400", hash_original_method = "D63809B6DE8F5F47E85D84EB99E1AE5D", hash_generated_method = "FC1BF9AC217CC58F50D5E1F25B779F09")
    public  Subject() {
        super(SUBJECT);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.467 -0400", hash_original_method = "3C6B7893125DF6EE8816C7C8DB5CA48D", hash_generated_method = "F0C0118E7BB05A0BDF6912EC6122A209")
    public String encodeBody() {
    if(subject != null)        
        {
String varC07EC1407326EABEF2FB6D781FE48674_977391002 =             subject;
            varC07EC1407326EABEF2FB6D781FE48674_977391002.addTaint(taint);
            return varC07EC1407326EABEF2FB6D781FE48674_977391002;
        } //End block
        else
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_474047050 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_474047050.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_474047050;
        } //End block
        // ---------- Original Method ----------
        //if (subject != null) {
            //return subject;
        //} else {
            //return "";
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.468 -0400", hash_original_method = "6F21748266641C905516C66889D7570C", hash_generated_method = "A262BF94F2C843E94C9F0EB76C76DB2F")
    public void setSubject(String subject) throws ParseException {
    if(subject == null)        
        {
        NullPointerException var13137744AD19720D56B5B3D816DDCAEE_1809498514 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Subject, setSubject(), the subject parameter is null");
        var13137744AD19720D56B5B3D816DDCAEE_1809498514.addTaint(taint);
        throw var13137744AD19720D56B5B3D816DDCAEE_1809498514;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.468 -0400", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "505F8570AE778E05841762EC27CEC827")
    public String getSubject() {
String varC07EC1407326EABEF2FB6D781FE48674_1507426581 =         subject;
        varC07EC1407326EABEF2FB6D781FE48674_1507426581.addTaint(taint);
        return varC07EC1407326EABEF2FB6D781FE48674_1507426581;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.468 -0400", hash_original_field = "3D06F226553D3F5C6F20075141F7D3D9", hash_generated_field = "5A108BF1E2A98855AB05AF0A50CEDCDE")

    private static final long serialVersionUID = -6479220126758862528L;
}

