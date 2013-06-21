package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PChargingVectorHeader extends Header, Parameters {

    
    public final static String NAME = "P-Charging-Vector";


    
    public String getICID();


    
    public void setICID(String icid) throws ParseException;

    
    public String getICIDGeneratedAt();


    
    public void setICIDGeneratedAt(String host) throws ParseException;


    
    public String getOriginatingIOI();


    
    public void setOriginatingIOI(String origIOI) throws ParseException;


    
    public String getTerminatingIOI();


    
    public void setTerminatingIOI(String termIOI) throws ParseException;






}
