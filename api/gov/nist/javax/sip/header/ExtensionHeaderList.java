package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ListIterator;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Header;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.399 -0400", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "3D5B61862F27E9137B1BDBC12BD22287")
    public  ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
        addTaint(hName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.399 -0400", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "B4759EE8D9DB6DE8172FBD3EF60E4182")
    public  ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.399 -0400", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "09CE9906E61D54F1F8A86FBDF2FCF3EC")
    public Object clone() {
        ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_98641870 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_98641870.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_98641870;
        // ---------- Original Method ----------
        //ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.400 -0400", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "045C483F1B5875D4F1C9D763A53C76D9")
    public String encode() {
        StringBuffer retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        while
(it.hasNext())        
        {
            ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
            retval.append(eh.encode());
        } //End block
String var1B324365A764C077A55854483509F4AB_5124688 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_5124688.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_5124688;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        //while(it.hasNext()) {
           //ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
           //retval.append(eh.encode());
        //}
        //return retval.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.400 -0400", hash_original_field = "49645EF719FC8343E1DC5FC8240E0CF5", hash_generated_field = "C901BD677804F800F6B013B6AE6500C8")

    private static final long serialVersionUID = 4681326807149890197L;
}

