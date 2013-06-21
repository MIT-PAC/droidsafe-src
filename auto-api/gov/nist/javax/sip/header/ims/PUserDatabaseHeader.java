package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PUserDatabaseHeader extends Parameters,Header
{
    public final static String NAME = "P-User-Database";

    public String getDatabaseName();

    public void setDatabaseName(String name);



}
