package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.ims.*;
import java.util.Hashtable;

class ListMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.290 -0400", hash_original_method = "3B4FA022548893E6C8E65FE681D24699", hash_generated_method = "3B4FA022548893E6C8E65FE681D24699")
    public ListMap ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
    static private void initializeListMap() {
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

    
        @DSModeled(DSC.SAFE)
    static protected boolean hasList(SIPHeader sipHeader) {
        if (sipHeader instanceof SIPHeaderList)
            return false;
        else {
            Class<?> headerClass = sipHeader.getClass();
            return headerListTable.get(headerClass) != null;
        }
    }

    
        @DSModeled(DSC.SAFE)
    static protected boolean hasList(Class<?> sipHdrClass) {
        if (!initialized)
            initializeListMap();
        return headerListTable.get(sipHdrClass) != null;
    }

    
        @DSModeled(DSC.SAFE)
    static protected Class<?> getListClass(Class<?> sipHdrClass) {
        if (!initialized)
            initializeListMap();
        return (Class<?>) headerListTable.get(sipHdrClass);
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.292 -0400", hash_original_field = "1B2224DE52334EF5CB80B405CB11D33A", hash_generated_field = "62CC7C40693B8912372FB3323E83E945")

    private static Hashtable<Class<?>,Class<?>> headerListTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.292 -0400", hash_original_field = "84D10A1ED612E61DBF6880F6E3EE533A", hash_generated_field = "9FD51B35B9E2224AA107F59D57389A34")

    private static boolean initialized;
    static {
        initializeListMap();
    }
    
}

