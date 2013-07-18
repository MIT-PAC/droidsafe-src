package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface PUserDatabaseHeader extends Parameters,Header
{
    public final static String NAME = "P-User-Database";

    public String getDatabaseName();

    public void setDatabaseName(String name);



}
