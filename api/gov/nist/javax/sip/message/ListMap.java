package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.Accept;
import gov.nist.javax.sip.header.AcceptEncoding;
import gov.nist.javax.sip.header.AcceptEncodingList;
import gov.nist.javax.sip.header.AcceptLanguage;
import gov.nist.javax.sip.header.AcceptLanguageList;
import gov.nist.javax.sip.header.AcceptList;
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.AlertInfoList;
import gov.nist.javax.sip.header.Allow;
import gov.nist.javax.sip.header.AllowList;
import gov.nist.javax.sip.header.Authorization;
import gov.nist.javax.sip.header.AuthorizationList;
import gov.nist.javax.sip.header.CallInfo;
import gov.nist.javax.sip.header.CallInfoList;
import gov.nist.javax.sip.header.Contact;
import gov.nist.javax.sip.header.ContactList;
import gov.nist.javax.sip.header.ContentEncoding;
import gov.nist.javax.sip.header.ContentEncodingList;
import gov.nist.javax.sip.header.ContentLanguage;
import gov.nist.javax.sip.header.ContentLanguageList;
import gov.nist.javax.sip.header.ErrorInfo;
import gov.nist.javax.sip.header.ErrorInfoList;
import gov.nist.javax.sip.header.ExtensionHeaderImpl;
import gov.nist.javax.sip.header.ExtensionHeaderList;
import gov.nist.javax.sip.header.InReplyTo;
import gov.nist.javax.sip.header.InReplyToList;
import gov.nist.javax.sip.header.ProxyAuthenticate;
import gov.nist.javax.sip.header.ProxyAuthenticateList;
import gov.nist.javax.sip.header.ProxyAuthorization;
import gov.nist.javax.sip.header.ProxyAuthorizationList;
import gov.nist.javax.sip.header.ProxyRequire;
import gov.nist.javax.sip.header.ProxyRequireList;
import gov.nist.javax.sip.header.RecordRoute;
import gov.nist.javax.sip.header.RecordRouteList;
import gov.nist.javax.sip.header.Require;
import gov.nist.javax.sip.header.RequireList;
import gov.nist.javax.sip.header.Route;
import gov.nist.javax.sip.header.RouteList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.Supported;
import gov.nist.javax.sip.header.SupportedList;
import gov.nist.javax.sip.header.Unsupported;
import gov.nist.javax.sip.header.UnsupportedList;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.header.ViaList;
import gov.nist.javax.sip.header.WWWAuthenticate;
import gov.nist.javax.sip.header.WWWAuthenticateList;
import gov.nist.javax.sip.header.Warning;
import gov.nist.javax.sip.header.WarningList;
import gov.nist.javax.sip.header.ims.PAssertedIdentity;
import gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import gov.nist.javax.sip.header.ims.PAssociatedURI;
import gov.nist.javax.sip.header.ims.PAssociatedURIList;
import gov.nist.javax.sip.header.ims.PMediaAuthorization;
import gov.nist.javax.sip.header.ims.PMediaAuthorizationList;
import gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDList;
import gov.nist.javax.sip.header.ims.Path;
import gov.nist.javax.sip.header.ims.PathList;
import gov.nist.javax.sip.header.ims.Privacy;
import gov.nist.javax.sip.header.ims.PrivacyList;
import gov.nist.javax.sip.header.ims.SecurityClient;
import gov.nist.javax.sip.header.ims.SecurityClientList;
import gov.nist.javax.sip.header.ims.SecurityServer;
import gov.nist.javax.sip.header.ims.SecurityServerList;
import gov.nist.javax.sip.header.ims.SecurityVerify;
import gov.nist.javax.sip.header.ims.SecurityVerifyList;
import gov.nist.javax.sip.header.ims.ServiceRoute;
import gov.nist.javax.sip.header.ims.ServiceRouteList;

import java.util.Hashtable;






class ListMap {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.653 -0500", hash_original_method = "432E67B4E78CD4BF646DB4DECA89550C", hash_generated_method = "641992C365D9538BCC35E3D72A986433")
    static private void initializeListMap() {
        /*
         * Build a table mapping between objects that have a list form and the
         * class of such objects.
         */
        headerListTable = new Hashtable<Class<?>, Class<?>>();
        headerListTable.put(ExtensionHeaderImpl.class, ExtensionHeaderList.class);

        headerListTable.put(Contact.class, ContactList.class);

        headerListTable.put(ContentEncoding.class, ContentEncodingList.class);

        headerListTable.put(Via.class, ViaList.class);

        headerListTable.put(WWWAuthenticate.class, WWWAuthenticateList.class);

        headerListTable.put(Accept.class, AcceptList.class);

        headerListTable.put(AcceptEncoding.class, AcceptEncodingList.class);

        headerListTable.put(AcceptLanguage.class, AcceptLanguageList.class);

        headerListTable.put(ProxyRequire.class, ProxyRequireList.class);

        headerListTable.put(Route.class, RouteList.class);

        headerListTable.put(Require.class, RequireList.class);

        headerListTable.put(Warning.class, WarningList.class);

        headerListTable.put(Unsupported.class, UnsupportedList.class);

        headerListTable.put(AlertInfo.class, AlertInfoList.class);

        headerListTable.put(CallInfo.class, CallInfoList.class);

        headerListTable.put(ProxyAuthenticate.class,ProxyAuthenticateList.class);

        headerListTable.put(ProxyAuthorization.class, ProxyAuthorizationList.class);

        headerListTable.put(Authorization.class, AuthorizationList.class);

        headerListTable.put(Allow.class, AllowList.class);

        headerListTable.put(RecordRoute.class, RecordRouteList.class);

        headerListTable.put(ContentLanguage.class, ContentLanguageList.class);

        headerListTable.put(ErrorInfo.class, ErrorInfoList.class);

        headerListTable.put(Supported.class, SupportedList.class);

        headerListTable.put(InReplyTo.class,InReplyToList.class);

        // IMS headers.

        headerListTable.put(PAssociatedURI.class, PAssociatedURIList.class);

        headerListTable.put(PMediaAuthorization.class, PMediaAuthorizationList.class);

        headerListTable.put(Path.class, PathList.class);

        headerListTable.put(Privacy.class,PrivacyList.class);

        headerListTable.put(ServiceRoute.class, ServiceRouteList.class);

        headerListTable.put(PVisitedNetworkID.class, PVisitedNetworkIDList.class);

        headerListTable.put(SecurityClient.class, SecurityClientList.class);

        headerListTable.put(SecurityServer.class, SecurityServerList.class);

        headerListTable.put(SecurityVerify.class, SecurityVerifyList.class);

        headerListTable.put(PAssertedIdentity.class, PAssertedIdentityList.class);

        initialized = true;

    }

    /**
     * return true if this has an associated list object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.654 -0500", hash_original_method = "C0BF7A54D71A4DAEEC772A3C3067C193", hash_generated_method = "F1B883FF392B1F42E1D10C00B65D9580")
    static protected boolean hasList(SIPHeader sipHeader) {
        if (sipHeader instanceof SIPHeaderList)
            return false;
        else {
            Class<?> headerClass = sipHeader.getClass();
            return headerListTable.get(headerClass) != null;
        }
    }

    /**
     * Return true if this has an associated list object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.655 -0500", hash_original_method = "B0E12E7D32AA325023C77D5BAE46A99F", hash_generated_method = "46AAB543916B79A7A87F80E188ACB237")
    static protected boolean hasList(Class<?> sipHdrClass) {
        if (!initialized)
            initializeListMap();
        return headerListTable.get(sipHdrClass) != null;
    }

    /**
     * Get the associated list class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.656 -0500", hash_original_method = "1E10617861814F17C4CB7AD5EF34291D", hash_generated_method = "C3459A907149B3CB6C44B5BF0F15D406")
    static protected Class<?> getListClass(Class<?> sipHdrClass) {
        if (!initialized)
            initializeListMap();
        return (Class<?>) headerListTable.get(sipHdrClass);
    }

    /**
     * Return a list object for this header if it has an associated list object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.657 -0500", hash_original_method = "4F2A6D49F6C7C93E5FFFA8D8E9F78F48", hash_generated_method = "10A047F8AE9B9218BF8786EE4DDA5BBB")
    @SuppressWarnings("unchecked")
static protected SIPHeaderList<SIPHeader> getList(SIPHeader sipHeader) {
        if (!initialized)
            initializeListMap();
        try {
            Class<?> headerClass = sipHeader.getClass();
            Class<?> listClass =  headerListTable.get(headerClass);
            SIPHeaderList<SIPHeader> shl = (SIPHeaderList<SIPHeader>) listClass.newInstance();
            shl.setHeaderName(sipHeader.getName());
            return shl;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.651 -0500", hash_original_field = "6AB4F5875830EF73416723C09E17F867", hash_generated_field = "647D4299D29E4453A0CFEF9913ED3729")

    // not (to catch adding of the non-list form when a list exists.)
    // Entries in this table allow you to look up the list form of a header
    // (provided it has a list form). Note that under JAVA-5 we have
    // typed collections which would render such a list obsolete. However,
    // we are not using java 5.
    private static Hashtable<Class<?>,Class<?>> headerListTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:05.652 -0500", hash_original_field = "6FBE6536E7CE204510C4979FD7989151", hash_generated_field = "9FD51B35B9E2224AA107F59D57389A34")


    private static boolean initialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.584 -0400", hash_original_method = "3B4FA022548893E6C8E65FE681D24699", hash_generated_method = "3B4FA022548893E6C8E65FE681D24699")
    public ListMap ()
    {
        //Synthesized constructor
    }
    static {
        initializeListMap();
    }
    
}

