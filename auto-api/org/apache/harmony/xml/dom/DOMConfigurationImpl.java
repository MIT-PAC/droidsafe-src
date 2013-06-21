package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private boolean cdataSections = true;
    private boolean comments = true;
    private boolean datatypeNormalization = false;
    private boolean entities = true;
    private DOMErrorHandler errorHandler;
    private boolean namespaces = true;
    private String schemaLocation;
    private String schemaType;
    private boolean splitCdataSections = true;
    private boolean validate = false;
    private boolean wellFormed = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.148 -0400", hash_original_method = "8FD5A5E975BF8AE5860E9CEDC87CFF12", hash_generated_method = "8FD5A5E975BF8AE5860E9CEDC87CFF12")
        public DOMConfigurationImpl ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.148 -0400", hash_original_method = "5F5EB2ABC8B048DBE9223C434320CDED", hash_generated_method = "28F36387AB2631BB70F7234A19601779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canSetParameter(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        Parameter parameter;
        parameter = PARAMETERS.get(name);
        boolean var59F2D60379DF79AEFF6AEA7982825E2A_976732909 = (parameter != null && parameter.canSet(this, value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Parameter parameter = PARAMETERS.get(name);
        //return parameter != null && parameter.canSet(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.149 -0400", hash_original_method = "F200B80DD8F3D3ABFAA5C6CAA3AC3079", hash_generated_method = "7B6545463FF8BA4D65E4F992CEECCBE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, Object value) throws DOMException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        Parameter parameter;
        parameter = PARAMETERS.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        } //End block
        try 
        {
            parameter.set(this, value);
        } //End block
        catch (NullPointerException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    "Null not allowed for " + name);
        } //End block
        catch (ClassCastException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    "Invalid type for " + name + ": " + value.getClass());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.149 -0400", hash_original_method = "4C81A8ACD622F0BCFE1551B59FC6CCCF", hash_generated_method = "F18DFC9697C6E6CB4826A47F3D72A9B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getParameter(String name) throws DOMException {
        dsTaint.addTaint(name);
        Parameter parameter;
        parameter = PARAMETERS.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        } //End block
        Object var5E89686F675740724D8E25382FEDF8A7_1454043135 = (parameter.get(this));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parameter parameter = PARAMETERS.get(name);
        //if (parameter == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        //}
        //return parameter.get(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.154 -0400", hash_original_method = "95541708528899B2117FFEEED54CDAAC", hash_generated_method = "68B7AC98EDF8C9D791AF742DE427E0DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DOMStringList getParameterNames() {
        String[] result;
        result = PARAMETERS.keySet().toArray(new String[PARAMETERS.size()]);
        DOMStringList var482C3043DF6B1C403984F013A9236B40_715632310 = (new DOMStringList() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.151 -0400", hash_original_method = "89D990F7DE98879C5B89FDF545A404DB", hash_generated_method = "AC80C7870B015360F201646F92DEC9CB")
            @DSModeled(DSC.SAFE)
            public String item(int index) {
                dsTaint.addTaint(index);
                return dsTaint.getTaintString();
                // ---------- Original Method ----------
                //return index < result.length ? result[index] : null;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.152 -0400", hash_original_method = "06707F305D31A2CABCFF2283107B42B1", hash_generated_method = "8B20F4A90593845A31F55145888C234F")
            @DSModeled(DSC.SAFE)
            public int getLength() {
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return result.length;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.153 -0400", hash_original_method = "03E28D9EA8E8F482AC5FF26FBE062BE8", hash_generated_method = "813EBD16A32B7E9C749306EF1126A772")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean contains(String str) {
                dsTaint.addTaint(str);
                boolean varE6E8554BD849E05CBFEA239F10BDEAD9_931588094 = (PARAMETERS.containsKey(str));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return PARAMETERS.containsKey(str);
            }
});
        return (DOMStringList)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.155 -0400", hash_original_method = "89B49C7AFC8106B5DCE888AAFD47AF2F", hash_generated_method = "DAA6C152AB9F3087DF85E8527807E1F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void normalize(Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            Object var09E3B15CD8604B5CA0883ABFA37862BC_731553136 = (node.getNodeType());
            //Begin case Node.CDATA_SECTION_NODE 
            CDATASectionImpl cdata;
            cdata = (CDATASectionImpl) node;
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.CDATA_SECTION_NODE 
            {
                {
                    boolean varF53537D16E4DE2BC176C0CE1403CCB89_1027383557 = (cdata.needsSplitting());
                    {
                        {
                            cdata.split();
                            report(DOMError.SEVERITY_WARNING, "cdata-sections-splitted");
                        } //End block
                        {
                            report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                checkTextValidity(cdata.buffer);
            } //End block
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.CDATA_SECTION_NODE 
            node = cdata.replaceWithText();
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.TEXT_NODE 
            TextImpl text;
            text = (TextImpl) node;
            //End case Node.TEXT_NODE 
            //Begin case Node.TEXT_NODE 
            text = text.minimize();
            //End case Node.TEXT_NODE 
            //Begin case Node.TEXT_NODE 
            {
                checkTextValidity(text.buffer);
            } //End block
            //End case Node.TEXT_NODE 
            //Begin case Node.COMMENT_NODE 
            CommentImpl comment;
            comment = (CommentImpl) node;
            //End case Node.COMMENT_NODE 
            //Begin case Node.COMMENT_NODE 
            {
                comment.getParentNode().removeChild(comment);
            } //End block
            //End case Node.COMMENT_NODE 
            //Begin case Node.COMMENT_NODE 
            {
                boolean varBA396D41C31642F943B18CB50D39518A_1743932622 = (comment.containsDashDash());
                {
                    report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
                } //End block
            } //End collapsed parenthetic
            //End case Node.COMMENT_NODE 
            //Begin case Node.COMMENT_NODE 
            checkTextValidity(comment.buffer);
            //End case Node.COMMENT_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            checkTextValidity(((ProcessingInstructionImpl) node).getData());
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.ATTRIBUTE_NODE 
            checkTextValidity(((AttrImpl) node).getValue());
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.ELEMENT_NODE 
            ElementImpl element;
            element = (ElementImpl) node;
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            NamedNodeMap attributes;
            attributes = element.getAttributes();
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            {
                int i;
                i = 0;
                boolean varB52A5F5C76706054FE03857094E040A4_2004009644 = (i < attributes.getLength());
                {
                    normalize(attributes.item(i));
                } //End block
            } //End collapsed parenthetic
            //End case Node.ELEMENT_NODE 
            //Begin case Node.DOCUMENT_NODE Node.DOCUMENT_FRAGMENT_NODE 
            Node next;
            //End case Node.DOCUMENT_NODE Node.DOCUMENT_FRAGMENT_NODE 
            //Begin case Node.DOCUMENT_NODE Node.DOCUMENT_FRAGMENT_NODE 
            {
                Node child;
                child = node.getFirstChild();
                child = next;
                {
                    next = child.getNextSibling();
                    normalize(child);
                } //End block
            } //End collapsed parenthetic
            //End case Node.DOCUMENT_NODE Node.DOCUMENT_FRAGMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.156 -0400", hash_original_method = "1D4ECB40573303902DF99E5874724C46", hash_generated_method = "F389A12052FCDA98EDBA9FF15B2EFA15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkTextValidity(CharSequence s) {
        dsTaint.addTaint(s);
        {
            boolean varDE0C170823F5DE2F72932472C20834E2_1451054843 = (wellFormed && !isValid(s));
            {
                report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (wellFormed && !isValid(s)) {
            //report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.156 -0400", hash_original_method = "E3663B8D897962AAB4126247F22D681E", hash_generated_method = "5CDD1B3C68738E9B5E34315C1C41E6BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValid(CharSequence text) {
        dsTaint.addTaint(text);
        {
            int i;
            i = 0;
            boolean var09A513B6E63B388E1018609860421E92_2113054443 = (i < text.length());
            {
                char c;
                c = text.charAt(i);
                boolean valid;
                valid = c == 0x9 || c == 0xA || c == 0xD
                    || (c >= 0x20 && c <= 0xd7ff)
                    || (c >= 0xe000 && c <= 0xfffd);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.156 -0400", hash_original_method = "9DB2BD31AEB3F11512B5C9ACC16D052B", hash_generated_method = "0506B4C4580A7C52A1C437D5F709E292")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void report(short severity, String type) {
        dsTaint.addTaint(severity);
        dsTaint.addTaint(type);
        {
            errorHandler.handleError(new DOMErrorImpl(severity, type));
        } //End block
        // ---------- Original Method ----------
        //if (errorHandler != null) {
            //errorHandler.handleError(new DOMErrorImpl(severity, type));
        //}
    }

    
    static class FixedParameter implements Parameter {
        Object onlyValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.156 -0400", hash_original_method = "4AEE734B1EFD8A5D4A3557C383752F00", hash_generated_method = "16D1D2E9890E2F013E7288F2F952D56A")
        @DSModeled(DSC.SAFE)
         FixedParameter(Object onlyValue) {
            dsTaint.addTaint(onlyValue.dsTaint);
            // ---------- Original Method ----------
            //this.onlyValue = onlyValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.157 -0400", hash_original_method = "580583282F0D57EA1D5F8BCC7DFB7226", hash_generated_method = "BE1A1E4549A53C68831FD4D05B568A8C")
        @DSModeled(DSC.SAFE)
        public Object get(DOMConfigurationImpl config) {
            dsTaint.addTaint(config.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return onlyValue;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.157 -0400", hash_original_method = "403AFB4EBDC51E40E976B1F523409C3A", hash_generated_method = "C511244891AFC3474EEBC61FCB1F55A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void set(DOMConfigurationImpl config, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(config.dsTaint);
            {
                boolean var84D9E80B9B225BB6F3DE78B8079DA4A9_693879316 = (!onlyValue.equals(value));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported value: " + value);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!onlyValue.equals(value)) {
                //throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        //"Unsupported value: " + value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.157 -0400", hash_original_method = "94364F826E7659C79EA0A17708890F8B", hash_generated_method = "461C819814C5B52BABAC1FDC030B6194")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean canSet(DOMConfigurationImpl config, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(config.dsTaint);
            boolean var433AF86F19244B8241FCFE7BDE982C20_1145538265 = (onlyValue.equals(value));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return onlyValue.equals(value);
        }

        
    }


    
    static abstract class BooleanParameter implements Parameter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.157 -0400", hash_original_method = "6757984C930CE4204735415AEDBE1274", hash_generated_method = "6757984C930CE4204735415AEDBE1274")
                public BooleanParameter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.157 -0400", hash_original_method = "BF6F151915BB667F3BD2F9A011756FE4", hash_generated_method = "E00E4CB10DD56B06B0B0154EE0C4E119")
        @DSModeled(DSC.SAFE)
        public boolean canSet(DOMConfigurationImpl config, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(config.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return value instanceof Boolean;
        }

        
    }


    
    interface Parameter {
        Object get(DOMConfigurationImpl config);
        void set(DOMConfigurationImpl config, Object value);
        boolean canSet(DOMConfigurationImpl config, Object value);
    }
    
    private static final Map<String, Parameter> PARAMETERS
            = new TreeMap<String, Parameter>(String.CASE_INSENSITIVE_ORDER);
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
    
}

