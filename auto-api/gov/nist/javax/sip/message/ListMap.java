package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.ims.*;
import java.util.Hashtable;

class ListMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.689 -0400", hash_original_method = "570DA50C51CA910AC1BA48DF3926EDA5", hash_generated_method = "570DA50C51CA910AC1BA48DF3926EDA5")
        public ListMap ()
    {
    }


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

    
        static protected boolean hasList(SIPHeader sipHeader) {
        if (sipHeader instanceof SIPHeaderList)
            return false;
        else {
            Class<?> headerClass = sipHeader.getClass();
            return headerListTable.get(headerClass) != null;
        }
    }

    
        static protected boolean hasList(Class<?> sipHdrClass) {
        if (!initialized)
            initializeListMap();
        return headerListTable.get(sipHdrClass) != null;
    }

    
        static protected Class<?> getListClass(Class<?> sipHdrClass) {
        if (!initialized)
            initializeListMap();
        return (Class<?>) headerListTable.get(sipHdrClass);
    }

    
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

    
    private static Hashtable<Class<?>,Class<?>> headerListTable;
    private static boolean initialized;
    static {
        initializeListMap();
    }
    
}

