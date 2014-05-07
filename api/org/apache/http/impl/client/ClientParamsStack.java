package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;

public class ClientParamsStack extends AbstractHttpParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.611 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.614 -0500", hash_original_field = "9066914C0B371C99A27A479B399ED204", hash_generated_field = "32F39C15B73E9C028569FCAD17E48131")

    protected  HttpParams applicationParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.616 -0500", hash_original_field = "F8DD5F67154F9A5C096C451588BE1350", hash_generated_field = "B6902EA3DF78F5E3948D83F83F61C305")

    protected  HttpParams clientParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.619 -0500", hash_original_field = "37D0187BDBADA60599300FEB83C86084", hash_generated_field = "D0B3BB526219F8C4CF831BDBA8B2E8F9")

    protected  HttpParams requestParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.621 -0500", hash_original_field = "4C35D80FDBD0E6A9EB04CFC579F3F39E", hash_generated_field = "0F3FDC4D6C99FE0F422F50FAC4EC37BE")

    protected  HttpParams overrideParams;

    /**
     * Creates a new parameter stack from elements.
     * The arguments will be stored as-is, there is no copying to
     * prevent modification.
     *
     * @param aparams   application parameters, or <code>null</code>
     * @param cparams   client parameters, or <code>null</code>
     * @param rparams   request parameters, or <code>null</code>
     * @param oparams   override parameters, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.624 -0500", hash_original_method = "C6D32BE942F9C5459143EF4AC85BAF30", hash_generated_method = "78E448BC19E90CE4BEF7D2000846B9F2")
    
public ClientParamsStack(HttpParams aparams, HttpParams cparams,
                             HttpParams rparams, HttpParams oparams) {
        applicationParams = aparams;
        clientParams      = cparams;
        requestParams     = rparams;
        overrideParams    = oparams;
    }

    /**
     * Creates a copy of a parameter stack.
     * The new stack will have the exact same entries as the argument stack.
     * There is no copying of parameters.
     *
     * @param stack     the stack to copy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.626 -0500", hash_original_method = "7E64926BBCDB13033B63B7A286DDA4C5", hash_generated_method = "4C554BF7EB92A812EF13DC2BDAEC2069")
    
public ClientParamsStack(ClientParamsStack stack) {
        this(stack.getApplicationParams(),
             stack.getClientParams(),
             stack.getRequestParams(),
             stack.getOverrideParams());
    }

    /**
     * Creates a modified copy of a parameter stack.
     * The new stack will contain the explicitly passed elements.
     * For elements where the explicit argument is <code>null</code>,
     * the corresponding element from the argument stack is used.
     * There is no copying of parameters.
     *
     * @param stack     the stack to modify
     * @param aparams   application parameters, or <code>null</code>
     * @param cparams   client parameters, or <code>null</code>
     * @param rparams   request parameters, or <code>null</code>
     * @param oparams   override parameters, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.629 -0500", hash_original_method = "C87A48D0B50CCC317A58E3CCEC0DEAA5", hash_generated_method = "81AC029FBAFBE2C7A7DBE98659F6CBF4")
    
public ClientParamsStack(ClientParamsStack stack,
                             HttpParams aparams, HttpParams cparams,
                             HttpParams rparams, HttpParams oparams) {
        this((aparams != null) ? aparams : stack.getApplicationParams(),
             (cparams != null) ? cparams : stack.getClientParams(),
             (rparams != null) ? rparams : stack.getRequestParams(),
             (oparams != null) ? oparams : stack.getOverrideParams());
    }

    /**
     * Obtains the application parameters of this stack.
     *
     * @return  the application parameters, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.631 -0500", hash_original_method = "411C2E82696B2A098C8F744317385115", hash_generated_method = "909EF3DFF82EE1B83E4BF4D734BA39A7")
    
public final HttpParams getApplicationParams() {
        return applicationParams;
    }

    /**
     * Obtains the client parameters of this stack.
     *
     * @return  the client parameters, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.634 -0500", hash_original_method = "15DA57CD4E641FF95D2F8640F98E0183", hash_generated_method = "D7328670B646B0FBBA50CBB6250EAA77")
    
public final HttpParams getClientParams() {
        return clientParams;
    }

    /**
     * Obtains the request parameters of this stack.
     *
     * @return  the request parameters, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.636 -0500", hash_original_method = "93598125634F09E7FC66E3A21BBB5179", hash_generated_method = "E4ABB26903311610D97CC681F0C51655")
    
public final HttpParams getRequestParams() {
        return requestParams;
    }

    /**
     * Obtains the override parameters of this stack.
     *
     * @return  the override parameters, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.638 -0500", hash_original_method = "571781B35D1F87CE8D980CD8A67BB691", hash_generated_method = "E9959B1DB27920CF93E4D4B4A13D037C")
    
public final HttpParams getOverrideParams() {
        return overrideParams;
    }

    /**
     * Obtains a parameter from this stack.
     * See class comment for search order.
     *
     * @param name      the name of the parameter to obtain
     *
     * @return  the highest-priority value for that parameter, or
     *          <code>null</code> if it is not set anywhere in this stack
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.642 -0500", hash_original_method = "4085DCEEB969FCACB974F3F758D65674", hash_generated_method = "3B60B51B2857886AD1ED76AD74C35A76")
    
public Object getParameter(String name) {
        if (name == null) {
            throw new IllegalArgumentException
                ("Parameter name must not be null.");
        }

        Object result = null;

        if (overrideParams != null) {
            result = overrideParams.getParameter(name);
        }
        if ((result == null) && (requestParams != null)) {
            result = requestParams.getParameter(name);
        }
        if ((result == null) && (clientParams != null)) {
            result = clientParams.getParameter(name);
        }
        if ((result == null) && (applicationParams != null)) {
            result = applicationParams.getParameter(name);
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("'" + name + "': " + result);
        }

        return result;
    }

    /**
     * Does <i>not</i> set a parameter.
     * Parameter stacks are read-only. It is possible, though discouraged,
     * to access and modify specific stack entries.
     * Derived classes may change this behavior.
     *
     * @param name      ignored
     * @param value     ignored
     *
     * @return  nothing
     *
     * @throws UnsupportedOperationException    always
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.644 -0500", hash_original_method = "2A511DFE1F081488F4D79D3E78FD00A2", hash_generated_method = "77532EA3067990EF30FF1BCA5CE9C991")
    
public HttpParams setParameter(String name, Object value)
        throws UnsupportedOperationException {

        throw new UnsupportedOperationException
            ("Setting parameters in a stack is not supported.");
    }

    /**
     * Does <i>not</i> remove a parameter.
     * Parameter stacks are read-only. It is possible, though discouraged,
     * to access and modify specific stack entries.
     * Derived classes may change this behavior.
     *
     * @param name      ignored
     *
     * @return  nothing
     *
     * @throws UnsupportedOperationException    always
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.646 -0500", hash_original_method = "91EEF8AA1623C8BE2C536A6D8B3A0F15", hash_generated_method = "8F86C0D5E5F61D0CDA67404F7AD0D4E7")
    
public boolean removeParameter(String name) {
        throw new UnsupportedOperationException
        ("Removing parameters in a stack is not supported.");
    }

    /**
     * Does <i>not</i> copy parameters.
     * Parameter stacks are lightweight objects, expected to be instantiated
     * as needed and to be used only in a very specific context. On top of
     * that, they are read-only. The typical copy operation to prevent
     * accidental modification of parameters passed by the application to
     * a framework object is therefore pointless and disabled.
     * Create a new stack if you really need a copy.
     * <br/>
     * Derived classes may change this behavior.
     *
     * @return <code>this</code> parameter stack
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.648 -0500", hash_original_method = "EA9D71906AA8F5EAFC46BDFADD14632A", hash_generated_method = "8E0909FC1BE211C52A82B36CE39A28C7")
    
public HttpParams copy() {
        return this;
    }
    
}

