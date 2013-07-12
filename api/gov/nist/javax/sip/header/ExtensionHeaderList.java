package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ListIterator;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Header;

public class ExtensionHeaderList extends SIPHeaderList<ExtensionHeaderImpl> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.397 -0400", hash_original_method = "9F1BA104827E0F2F29324BDDE3EB0EE9", hash_generated_method = "3D5B61862F27E9137B1BDBC12BD22287")
    public  ExtensionHeaderList(String hName) {
        super( ExtensionHeaderImpl.class, hName);
        addTaint(hName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.398 -0400", hash_original_method = "52FAE424BADAAEF22385083D45DE9281", hash_generated_method = "B4759EE8D9DB6DE8172FBD3EF60E4182")
    public  ExtensionHeaderList() {
        super(ExtensionHeaderImpl.class,null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.399 -0400", hash_original_method = "C859D426E02BE595D55C2FAA9CB97225", hash_generated_method = "225686674E8AB59729BA6C67C424523F")
    public Object clone() {
        ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1620161768 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1620161768.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1620161768;
        // ---------- Original Method ----------
        //ExtensionHeaderList retval = new ExtensionHeaderList(headerName);
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.399 -0400", hash_original_method = "05F9E55197B7F8BF967FE19D758EB1FB", hash_generated_method = "FBF4C815C4762BA05F166EA7F31ADCB5")
    public String encode() {
        StringBuffer retval = new StringBuffer();
        ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        while
(it.hasNext())        
        {
            ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
            retval.append(eh.encode());
        } //End block
String var1B324365A764C077A55854483509F4AB_1320486952 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1320486952.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1320486952;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //ListIterator<ExtensionHeaderImpl> it = this.listIterator();
        //while(it.hasNext()) {
           //ExtensionHeaderImpl eh = (ExtensionHeaderImpl) it.next();
           //retval.append(eh.encode());
        //}
        //return retval.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.399 -0400", hash_original_field = "49645EF719FC8343E1DC5FC8240E0CF5", hash_generated_field = "C901BD677804F800F6B013B6AE6500C8")

    private static final long serialVersionUID = 4681326807149890197L;
}

