package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Map;
import java.util.TreeMap;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public final class DOMConfigurationImpl implements DOMConfiguration {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "88667684FBB30FAC95A75D39520ACEEF", hash_generated_field = "5ED7B0BC2D04FF583BB30F785E29E32B")

    private boolean cdataSections = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "AC6CB9F900E4AC822CC7D7503C4FB949", hash_generated_field = "CDB6C8A59587D4B38723E8D62E318D78")

    private boolean comments = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "DEFBCF7EA9D0ED7B3379095476F4AB13", hash_generated_field = "B4FFAE981AB95B3BAB64727BA2BE14B8")

    private boolean datatypeNormalization = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "DB0E754A3DBCB0D9242079E6551B6F07", hash_generated_field = "0899F7E4099371810DFD0ED4613D56AF")

    private boolean entities = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "C593DE14B1A4C8EDDB3A2D02ECCEAC59")

    private DOMErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "312A8D34A10A42AF3135F707FD689CB4", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")

    private boolean namespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "5B05AC4441A4449CBA0DFDBA2688DC56", hash_generated_field = "4E5247B7654703F0DC11D1A6647320E7")

    private String schemaLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "95683761337FDA3D94293B79FEDD4046", hash_generated_field = "8BB5B57F71ABC60D10B8C43C61B09782")

    private String schemaType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.565 -0400", hash_original_field = "63E63286318457EDDE538415EB66AE23", hash_generated_field = "252D4DD458506543FA976A984A9E322B")

    private boolean splitCdataSections = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.566 -0400", hash_original_field = "6AB193C06927C8434BA70FB40E80FC09", hash_generated_field = "BB829D4F8EE6AEB873AE518F7EBB8303")

    private boolean validate = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.566 -0400", hash_original_field = "5C017D12AF213FE0B9E33CC2EFDD8EA5", hash_generated_field = "5203D1AF6935072C8F57FB747FAEF7C6")

    private boolean wellFormed = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.566 -0400", hash_original_method = "4D153F5051BE9FB53ACB86332ED9FE59", hash_generated_method = "4D153F5051BE9FB53ACB86332ED9FE59")
    public DOMConfigurationImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.566 -0400", hash_original_method = "5F5EB2ABC8B048DBE9223C434320CDED", hash_generated_method = "5D276B16447BC4A0D878C757F9D336AE")
    public boolean canSetParameter(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Parameter parameter = PARAMETERS.get(name);
        boolean varDE4955B5C276D9630638EBE81C6CA37F_1911151106 = (parameter != null && parameter.canSet(this, value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915259357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_915259357;
        // ---------- Original Method ----------
        //Parameter parameter = PARAMETERS.get(name);
        //return parameter != null && parameter.canSet(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.567 -0400", hash_original_method = "F200B80DD8F3D3ABFAA5C6CAA3AC3079", hash_generated_method = "8FB06C26146E1352BE09EF6D611B964A")
    public void setParameter(String name, Object value) throws DOMException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Parameter parameter = PARAMETERS.get(name);
    if(parameter == null)        
        {
            DOMException var71A5B61A6431DEE25EBCC9F1E15A0B58_417814983 = new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
            var71A5B61A6431DEE25EBCC9F1E15A0B58_417814983.addTaint(taint);
            throw var71A5B61A6431DEE25EBCC9F1E15A0B58_417814983;
        } //End block
        try 
        {
            parameter.set(this, value);
        } //End block
        catch (NullPointerException e)
        {
            DOMException var87913FEAB2C3B3E4890327D059A6541A_501778659 = new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    "Null not allowed for " + name);
            var87913FEAB2C3B3E4890327D059A6541A_501778659.addTaint(taint);
            throw var87913FEAB2C3B3E4890327D059A6541A_501778659;
        } //End block
        catch (ClassCastException e)
        {
            DOMException var157E6D93D819AC8FD03817E8D9FE5267_2107730106 = new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    "Invalid type for " + name + ": " + value.getClass());
            var157E6D93D819AC8FD03817E8D9FE5267_2107730106.addTaint(taint);
            throw var157E6D93D819AC8FD03817E8D9FE5267_2107730106;
        } //End block
        // ---------- Original Method ----------
        //Parameter parameter = PARAMETERS.get(name);
        //if (parameter == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        //}
        //try {
            //parameter.set(this, value);
        //} catch (NullPointerException e) {
            //throw new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    //"Null not allowed for " + name);
        //} catch (ClassCastException e) {
            //throw new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    //"Invalid type for " + name + ": " + value.getClass());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.567 -0400", hash_original_method = "4C81A8ACD622F0BCFE1551B59FC6CCCF", hash_generated_method = "E7B63CC93AF8A3B5BE480F0BD7CE01D6")
    public Object getParameter(String name) throws DOMException {
        addTaint(name.getTaint());
        Parameter parameter = PARAMETERS.get(name);
    if(parameter == null)        
        {
            DOMException var71A5B61A6431DEE25EBCC9F1E15A0B58_890079401 = new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
            var71A5B61A6431DEE25EBCC9F1E15A0B58_890079401.addTaint(taint);
            throw var71A5B61A6431DEE25EBCC9F1E15A0B58_890079401;
        } //End block
Object var0EAAC7645F5587606C0588245A4E7970_1817879637 =         parameter.get(this);
        var0EAAC7645F5587606C0588245A4E7970_1817879637.addTaint(taint);
        return var0EAAC7645F5587606C0588245A4E7970_1817879637;
        // ---------- Original Method ----------
        //Parameter parameter = PARAMETERS.get(name);
        //if (parameter == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        //}
        //return parameter.get(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.568 -0400", hash_original_method = "95541708528899B2117FFEEED54CDAAC", hash_generated_method = "853966A7A011C65EDD52A1BE8338C604")
    public DOMStringList getParameterNames() {
        final String[] result = PARAMETERS.keySet().toArray(new String[PARAMETERS.size()]);
DOMStringList var9B6CCEF068B7E2A79BF34F3884E2DB87_2037869808 =         new DOMStringList() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.568 -0400", hash_original_method = "89D990F7DE98879C5B89FDF545A404DB", hash_generated_method = "7877708928E444F4242475D158FBA1D8")
        public String item(int index) {
            addTaint(index);
String var8B86B58A1D201135241D02A154815742_475016507 =             index < result.length ? result[index] : null;
            var8B86B58A1D201135241D02A154815742_475016507.addTaint(taint);
            return var8B86B58A1D201135241D02A154815742_475016507;
            // ---------- Original Method ----------
            //return index < result.length ? result[index] : null;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.568 -0400", hash_original_method = "06707F305D31A2CABCFF2283107B42B1", hash_generated_method = "CB28CAB666A9ECDF65687D4016633B36")
        public int getLength() {
            int var2D39DD8114D4D52B4FCCCB213F36F556_1479946418 = (result.length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571999109 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571999109;
            // ---------- Original Method ----------
            //return result.length;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.568 -0400", hash_original_method = "03E28D9EA8E8F482AC5FF26FBE062BE8", hash_generated_method = "651516FCC231C0668ABBBC14DAE13011")
        public boolean contains(String str) {
            addTaint(str.getTaint());
            boolean var8B4CD14A4E0AD8013C6701A735233C4B_879488271 = (PARAMETERS.containsKey(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548437160 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_548437160;
            // ---------- Original Method ----------
            //return PARAMETERS.containsKey(str);
        }
};
        var9B6CCEF068B7E2A79BF34F3884E2DB87_2037869808.addTaint(taint);
        return var9B6CCEF068B7E2A79BF34F3884E2DB87_2037869808;
        // ---------- Original Method ----------
        //final String[] result = PARAMETERS.keySet().toArray(new String[PARAMETERS.size()]);
        //return new DOMStringList() {
            //public String item(int index) {
                //return index < result.length ? result[index] : null;
            //}
            //public int getLength() {
                //return result.length;
            //}
            //public boolean contains(String str) {
                //return PARAMETERS.containsKey(str); 
            //}
        //};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.570 -0400", hash_original_method = "89B49C7AFC8106B5DCE888AAFD47AF2F", hash_generated_method = "0B09283003DF3DBF9E892E9775C41DB0")
    public void normalize(Node node) {
        addTaint(node.getTaint());
switch(node.getNodeType()){
        case Node.CDATA_SECTION_NODE:
        CDATASectionImpl cdata = (CDATASectionImpl) node;
    if(cdataSections)        
        {
    if(cdata.needsSplitting())            
            {
    if(splitCdataSections)                
                {
                    cdata.split();
                    report(DOMError.SEVERITY_WARNING, "cdata-sections-splitted");
                } //End block
                else
                {
                    report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
                } //End block
            } //End block
            checkTextValidity(cdata.buffer);
            break;
        } //End block
        node = cdata.replaceWithText();
        case Node.TEXT_NODE:
        TextImpl text = (TextImpl) node;
        text = text.minimize();
    if(text != null)        
        {
            checkTextValidity(text.buffer);
        } //End block
        break;
        case Node.COMMENT_NODE:
        CommentImpl comment = (CommentImpl) node;
    if(!comments)        
        {
            comment.getParentNode().removeChild(comment);
            break;
        } //End block
    if(comment.containsDashDash())        
        {
            report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
        } //End block
        checkTextValidity(comment.buffer);
        break;
        case Node.PROCESSING_INSTRUCTION_NODE:
        checkTextValidity(((ProcessingInstructionImpl) node).getData());
        break;
        case Node.ATTRIBUTE_NODE:
        checkTextValidity(((AttrImpl) node).getValue());
        break;
        case Node.ELEMENT_NODE:
        ElementImpl element = (ElementImpl) node;
        NamedNodeMap attributes = element.getAttributes();
for(int i = 0;i < attributes.getLength();i++)
        {
            normalize(attributes.item(i));
        } //End block
        case Node.DOCUMENT_NODE:
        case Node.DOCUMENT_FRAGMENT_NODE:
        Node next;
for(Node child = node.getFirstChild();child != null;child = next)
        {
            next = child.getNextSibling();
            normalize(child);
        } //End block
        break;
        case Node.NOTATION_NODE:
        case Node.DOCUMENT_TYPE_NODE:
        case Node.ENTITY_NODE:
        case Node.ENTITY_REFERENCE_NODE:
        break;
        default:
        DOMException var96E7F93A47E198E550B071124DD8FDC7_27381325 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
        var96E7F93A47E198E550B071124DD8FDC7_27381325.addTaint(taint);
        throw var96E7F93A47E198E550B071124DD8FDC7_27381325;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.570 -0400", hash_original_method = "1D4ECB40573303902DF99E5874724C46", hash_generated_method = "7B6E916C431389D1A9FD76554D2B17B8")
    private void checkTextValidity(CharSequence s) {
        addTaint(s.getTaint());
    if(wellFormed && !isValid(s))        
        {
            report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
        } //End block
        // ---------- Original Method ----------
        //if (wellFormed && !isValid(s)) {
            //report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.571 -0400", hash_original_method = "E3663B8D897962AAB4126247F22D681E", hash_generated_method = "E49FD1D9382C3BEB4BF928E55ADF76DC")
    private boolean isValid(CharSequence text) {
        addTaint(text.getTaint());
for(int i = 0;i < text.length();i++)
        {
            char c = text.charAt(i);
            boolean valid = c == 0x9 || c == 0xA || c == 0xD
                    || (c >= 0x20 && c <= 0xd7ff)
                    || (c >= 0xe000 && c <= 0xfffd);
    if(!valid)            
            {
                boolean var68934A3E9455FA72420237EB05902327_722033567 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355473367 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355473367;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1483021576 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406281736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406281736;
        // ---------- Original Method ----------
        //for (int i = 0; i < text.length(); i++) {
            //char c = text.charAt(i);
            //boolean valid = c == 0x9 || c == 0xA || c == 0xD
                    //|| (c >= 0x20 && c <= 0xd7ff)
                    //|| (c >= 0xe000 && c <= 0xfffd);
            //if (!valid) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.571 -0400", hash_original_method = "9DB2BD31AEB3F11512B5C9ACC16D052B", hash_generated_method = "355AB46A8D338DFEAEB5C7C641BFB08A")
    private void report(short severity, String type) {
        addTaint(type.getTaint());
        addTaint(severity);
    if(errorHandler != null)        
        {
            errorHandler.handleError(new DOMErrorImpl(severity, type));
        } //End block
        // ---------- Original Method ----------
        //if (errorHandler != null) {
            //errorHandler.handleError(new DOMErrorImpl(severity, type));
        //}
    }

    
    static class FixedParameter implements Parameter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.572 -0400", hash_original_field = "D5CCF1C24409E8FF388AC557FA1C3923", hash_generated_field = "95587A84CAA85CC05C4823B1B5D207DB")

        Object onlyValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.572 -0400", hash_original_method = "4AEE734B1EFD8A5D4A3557C383752F00", hash_generated_method = "A506FC59BBF6CC43F79B603F40D6503D")
          FixedParameter(Object onlyValue) {
            this.onlyValue = onlyValue;
            // ---------- Original Method ----------
            //this.onlyValue = onlyValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.572 -0400", hash_original_method = "580583282F0D57EA1D5F8BCC7DFB7226", hash_generated_method = "123291D451A9C2BAB60954D94F929010")
        public Object get(DOMConfigurationImpl config) {
            addTaint(config.getTaint());
Object varFC3D10A8FDF8879F7F22227809F81A9D_851641338 =             onlyValue;
            varFC3D10A8FDF8879F7F22227809F81A9D_851641338.addTaint(taint);
            return varFC3D10A8FDF8879F7F22227809F81A9D_851641338;
            // ---------- Original Method ----------
            //return onlyValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.572 -0400", hash_original_method = "403AFB4EBDC51E40E976B1F523409C3A", hash_generated_method = "5A439661C9F3BD5821F8495B51A22615")
        public void set(DOMConfigurationImpl config, Object value) {
            addTaint(value.getTaint());
            addTaint(config.getTaint());
    if(!onlyValue.equals(value))            
            {
                DOMException varEE672A4BB0A998CAE86879AB2B2C08BF_82868007 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported value: " + value);
                varEE672A4BB0A998CAE86879AB2B2C08BF_82868007.addTaint(taint);
                throw varEE672A4BB0A998CAE86879AB2B2C08BF_82868007;
            } //End block
            // ---------- Original Method ----------
            //if (!onlyValue.equals(value)) {
                //throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        //"Unsupported value: " + value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.573 -0400", hash_original_method = "94364F826E7659C79EA0A17708890F8B", hash_generated_method = "3250461773930035A1BEB3CFEF8CCACB")
        public boolean canSet(DOMConfigurationImpl config, Object value) {
            addTaint(value.getTaint());
            addTaint(config.getTaint());
            boolean var1E53FF2769031082D7B7C29B8058DF0B_1816476320 = (onlyValue.equals(value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953045332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953045332;
            // ---------- Original Method ----------
            //return onlyValue.equals(value);
        }

        
    }


    
    static abstract class BooleanParameter implements Parameter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.573 -0400", hash_original_method = "51C6AD17F5451D33F04DE00B4C815245", hash_generated_method = "51C6AD17F5451D33F04DE00B4C815245")
        public BooleanParameter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.573 -0400", hash_original_method = "BF6F151915BB667F3BD2F9A011756FE4", hash_generated_method = "7A29732A253211BD808DB685CCF1B48A")
        public boolean canSet(DOMConfigurationImpl config, Object value) {
            addTaint(value.getTaint());
            addTaint(config.getTaint());
            boolean var97D11A7D49548BFFEEBC999A9A8C4E66_1555165522 = (value instanceof Boolean);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874531476 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_874531476;
            // ---------- Original Method ----------
            //return value instanceof Boolean;
        }

        
    }


    
    interface Parameter {
        Object get(DOMConfigurationImpl config);
        void set(DOMConfigurationImpl config, Object value);
        boolean canSet(DOMConfigurationImpl config, Object value);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.573 -0400", hash_original_field = "FE2A13E70A5AD5AD7A8D43D91F2FE2FF", hash_generated_field = "065E0D5987C6C8DDABEBC55E7E479C3F")

    private static final Map<String, Parameter> PARAMETERS = new TreeMap<String, Parameter>(String.CASE_INSENSITIVE_ORDER);
    static {
        PARAMETERS.put("canonical-form", new FixedParameter(false));
        PARAMETERS.put("cdata-sections", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.cdataSections;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.cdataSections = (Boolean) value;
            }
        });
        PARAMETERS.put("check-character-normalization", new FixedParameter(false));
        PARAMETERS.put("comments", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.comments;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.comments = (Boolean) value;
            }
        });
        PARAMETERS.put("datatype-normalization", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.datatypeNormalization;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                if ((Boolean) value) {
                    config.datatypeNormalization = true;
                    config.validate = true;
                } else {
                    config.datatypeNormalization = false;
                }
            }
        });
        PARAMETERS.put("element-content-whitespace", new FixedParameter(true));
        PARAMETERS.put("entities", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.entities;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.entities = (Boolean) value;
            }
        });
        PARAMETERS.put("error-handler", new Parameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.errorHandler;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.errorHandler = (DOMErrorHandler) value;
            }
            public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof DOMErrorHandler;
            }
        });
        PARAMETERS.put("infoset", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return !config.entities
                        && !config.datatypeNormalization
                        && !config.cdataSections
                        && config.wellFormed
                        && config.comments
                        && config.namespaces;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                if ((Boolean) value) {
                    config.entities = false;
                    config.datatypeNormalization = false;
                    config.cdataSections = false;
                    config.wellFormed = true;
                    config.comments = true;
                    config.namespaces = true;
                }
            }
        });
        PARAMETERS.put("namespaces", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.namespaces;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.namespaces = (Boolean) value;
            }
        });
        PARAMETERS.put("namespace-declarations", new FixedParameter(true));
        PARAMETERS.put("normalize-characters", new FixedParameter(false));
        PARAMETERS.put("schema-location", new Parameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.schemaLocation;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.schemaLocation = (String) value;
            }
            public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof String;
            }
        });
        PARAMETERS.put("schema-type", new Parameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.schemaType;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.schemaType = (String) value;
            }
            public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof String;
            }
        });
        PARAMETERS.put("split-cdata-sections", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.splitCdataSections;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.splitCdataSections = (Boolean) value;
            }
        });
        PARAMETERS.put("validate", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.validate;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.validate = (Boolean) value;
            }
        });
        PARAMETERS.put("validate-if-schema", new FixedParameter(false));
        PARAMETERS.put("well-formed", new BooleanParameter() {
            public Object get(DOMConfigurationImpl config) {
                return config.wellFormed;
            }
            public void set(DOMConfigurationImpl config, Object value) {
                config.wellFormed = (Boolean) value;
            }
        });
    }
    
    // orphaned legacy method
    public void set(DOMConfigurationImpl config, Object value) {
                config.wellFormed = (Boolean) value;
            }
    
    // orphaned legacy method
    public Object get(DOMConfigurationImpl config) {
                return config.wellFormed;
            }
    
    // orphaned legacy method
    public boolean contains(String str) {
                return PARAMETERS.containsKey(str); 
            }
    
    // orphaned legacy method
    public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof String;
            }
    
}

