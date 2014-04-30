package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.878 -0500", hash_original_field = "81E77AC834CC33428AACE986453E2606", hash_generated_field = "065E0D5987C6C8DDABEBC55E7E479C3F")

    private static final Map<String, Parameter> PARAMETERS
            = new TreeMap<String, Parameter>(String.CASE_INSENSITIVE_ORDER);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.954 -0500", hash_original_field = "F14375A0C51FA8D5489EB309E8275F75", hash_generated_field = "5ED7B0BC2D04FF583BB30F785E29E32B")

    private boolean cdataSections = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.956 -0500", hash_original_field = "5C0899110D911F86C55495DBF01FA9B5", hash_generated_field = "CDB6C8A59587D4B38723E8D62E318D78")

    private boolean comments = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.958 -0500", hash_original_field = "CC9FBEBB9EEBFA99D156092AE0469519", hash_generated_field = "B4FFAE981AB95B3BAB64727BA2BE14B8")

    private boolean datatypeNormalization = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.960 -0500", hash_original_field = "31C20C4EFB2B133C1B93D43BC2BD2567", hash_generated_field = "0899F7E4099371810DFD0ED4613D56AF")

    private boolean entities = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.963 -0500", hash_original_field = "1FDA1724FBC52FD97F826C7DAC108B0B", hash_generated_field = "C593DE14B1A4C8EDDB3A2D02ECCEAC59")

    private DOMErrorHandler errorHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.965 -0500", hash_original_field = "487D36470CC197CE32401A3EEE7C0D76", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")

    private boolean namespaces = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.968 -0500", hash_original_field = "318098130B09B08A9E057D22C3C2C57E", hash_generated_field = "4E5247B7654703F0DC11D1A6647320E7")

    private String schemaLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.970 -0500", hash_original_field = "927C01E1FC154DF3187F074519EC5D4C", hash_generated_field = "8BB5B57F71ABC60D10B8C43C61B09782")

    private String schemaType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.972 -0500", hash_original_field = "C7697F0FA4908776FC55F6039346DF12", hash_generated_field = "252D4DD458506543FA976A984A9E322B")

    private boolean splitCdataSections = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.974 -0500", hash_original_field = "800ED6F8E003A8CD39D0894E68B2C617", hash_generated_field = "BB829D4F8EE6AEB873AE518F7EBB8303")

    private boolean validate = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.976 -0500", hash_original_field = "A17C24EEC0B386CE1FF39ECBF2764B56", hash_generated_field = "5203D1AF6935072C8F57FB747FAEF7C6")

    private boolean wellFormed = true;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.235 -0400", hash_original_method = "4D153F5051BE9FB53ACB86332ED9FE59", hash_generated_method = "4D153F5051BE9FB53ACB86332ED9FE59")
    public DOMConfigurationImpl ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.999 -0500", hash_original_method = "5F5EB2ABC8B048DBE9223C434320CDED", hash_generated_method = "14950943F15128687FB01464A229AEE6")
    
public boolean canSetParameter(String name, Object value) {
        Parameter parameter = PARAMETERS.get(name);
        return parameter != null && parameter.canSet(this, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.002 -0500", hash_original_method = "F200B80DD8F3D3ABFAA5C6CAA3AC3079", hash_generated_method = "D1142CCE466E66D11DBB2DEA53862560")
    
public void setParameter(String name, Object value) throws DOMException {
        Parameter parameter = PARAMETERS.get(name);
        if (parameter == null) {
            throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        }
        try {
            parameter.set(this, value);
        } catch (NullPointerException e) {
            throw new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    "Null not allowed for " + name);
        } catch (ClassCastException e) {
            throw new DOMException(DOMException.TYPE_MISMATCH_ERR,
                    "Invalid type for " + name + ": " + value.getClass());
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.004 -0500", hash_original_method = "4C81A8ACD622F0BCFE1551B59FC6CCCF", hash_generated_method = "A4C90376F2D5A414FFA1AD6995970380")
    
public Object getParameter(String name) throws DOMException {
        Parameter parameter = PARAMETERS.get(name);
        if (parameter == null) {
            throw new DOMException(DOMException.NOT_FOUND_ERR, "No such parameter: " + name);
        }
        return parameter.get(this);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.014 -0500", hash_original_method = "95541708528899B2117FFEEED54CDAAC", hash_generated_method = "F9099A47125D0D267BAFB3DACE7898C0")
    
public DOMStringList getParameterNames() {
        final String[] result = PARAMETERS.keySet().toArray(new String[PARAMETERS.size()]);
        return new DOMStringList() {
            public String item(int index) {
                return index < result.length ? result[index] : null;
            }
            public int getLength() {
                return result.length;
            }
            public boolean contains(String str) {
                return PARAMETERS.containsKey(str); // case-insensitive.
            }
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.018 -0500", hash_original_method = "89B49C7AFC8106B5DCE888AAFD47AF2F", hash_generated_method = "A50C7DD27C138082834C3028CEFB02F1")
    
public void normalize(Node node) {
        /*
         * Since we don't validate, this code doesn't take into account the
         * following "supported" parameters: datatype-normalization, entities,
         * schema-location, schema-type, or validate.
         *
         * TODO: normalize namespaces
         */

        switch (node.getNodeType()) {
            case Node.CDATA_SECTION_NODE:
                CDATASectionImpl cdata = (CDATASectionImpl) node;
                if (cdataSections) {
                    if (cdata.needsSplitting()) {
                        if (splitCdataSections) {
                            cdata.split();
                            report(DOMError.SEVERITY_WARNING, "cdata-sections-splitted");
                        } else {
                            report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
                        }
                    }
                    checkTextValidity(cdata.buffer);
                    break;
                }
                node = cdata.replaceWithText();
                // fall through

            case Node.TEXT_NODE:
                TextImpl text = (TextImpl) node;
                text = text.minimize();
                if (text != null) {
                    checkTextValidity(text.buffer);
                }
                break;

            case Node.COMMENT_NODE:
                CommentImpl comment = (CommentImpl) node;
                if (!comments) {
                    comment.getParentNode().removeChild(comment);
                    break;
                }
                if (comment.containsDashDash()) {
                    report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
                }
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
                for (int i = 0; i < attributes.getLength(); i++) {
                    normalize(attributes.item(i));
                }
                // fall through

            case Node.DOCUMENT_NODE:
            case Node.DOCUMENT_FRAGMENT_NODE:
                Node next;
                for (Node child = node.getFirstChild(); child != null; child = next) {
                    // lookup next eagerly because normalize() may remove its subject
                    next = child.getNextSibling();
                    normalize(child);
                }
                break;

            case Node.NOTATION_NODE:
            case Node.DOCUMENT_TYPE_NODE:
            case Node.ENTITY_NODE:
            case Node.ENTITY_REFERENCE_NODE:
                break;

            default:
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.020 -0500", hash_original_method = "1D4ECB40573303902DF99E5874724C46", hash_generated_method = "565129E004A72D5DA2E8147F4A584366")
    
private void checkTextValidity(CharSequence s) {
        if (wellFormed && !isValid(s)) {
            report(DOMError.SEVERITY_ERROR, "wf-invalid-character");
        }
    }

    /**
     * Returns true if all of the characters in the text are permitted for use
     * in XML documents.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.022 -0500", hash_original_method = "E3663B8D897962AAB4126247F22D681E", hash_generated_method = "1FB2D8CD3CD9C88EFF52AC3F772C9E31")
    
private boolean isValid(CharSequence text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // as defined by http://www.w3.org/TR/REC-xml/#charsets.
            boolean valid = c == 0x9 || c == 0xA || c == 0xD
                    || (c >= 0x20 && c <= 0xd7ff)
                    || (c >= 0xe000 && c <= 0xfffd);
            if (!valid) {
                return false;
            }
        }
        return true;
    }
    
    static class FixedParameter implements Parameter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.981 -0500", hash_original_field = "95587A84CAA85CC05C4823B1B5D207DB", hash_generated_field = "95587A84CAA85CC05C4823B1B5D207DB")

         Object onlyValue;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.984 -0500", hash_original_method = "4AEE734B1EFD8A5D4A3557C383752F00", hash_generated_method = "4AEE734B1EFD8A5D4A3557C383752F00")
        
FixedParameter(Object onlyValue) {
            this.onlyValue = onlyValue;
        }
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.986 -0500", hash_original_method = "580583282F0D57EA1D5F8BCC7DFB7226", hash_generated_method = "A9037462912764062385D01826C899CD")
        
public Object get(DOMConfigurationImpl config) {
            return onlyValue;
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.988 -0500", hash_original_method = "403AFB4EBDC51E40E976B1F523409C3A", hash_generated_method = "70A654478E166BE7FFDBA600188660B7")
        
public void set(DOMConfigurationImpl config, Object value) {
            if (!onlyValue.equals(value)) {
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported value: " + value);
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.990 -0500", hash_original_method = "94364F826E7659C79EA0A17708890F8B", hash_generated_method = "FC4556122344B287A403222F9215E4DC")
        
public boolean canSet(DOMConfigurationImpl config, Object value) {
            return onlyValue.equals(value);
        }
        
    }
    
    static abstract class BooleanParameter implements Parameter {
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.250 -0400", hash_original_method = "51C6AD17F5451D33F04DE00B4C815245", hash_generated_method = "51C6AD17F5451D33F04DE00B4C815245")
        public BooleanParameter ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.995 -0500", hash_original_method = "BF6F151915BB667F3BD2F9A011756FE4", hash_generated_method = "4B1B8D017EF955E4B8E3F2EA301955EB")
        
public boolean canSet(DOMConfigurationImpl config, Object value) {
            return value instanceof Boolean;
        }
        
    }
    
    interface Parameter {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Object get(DOMConfigurationImpl config);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void set(DOMConfigurationImpl config, Object value);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean canSet(DOMConfigurationImpl config, Object value);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.024 -0500", hash_original_method = "9DB2BD31AEB3F11512B5C9ACC16D052B", hash_generated_method = "9835E83AB346EBCE0155E1FE40DC3A55")
    
private void report(short severity, String type) {
        if (errorHandler != null) {
            // TODO: abort if handleError returns false
            errorHandler.handleError(new DOMErrorImpl(severity, type));
        }
    }
    static {
        PARAMETERS.put("canonical-form", new FixedParameter(false));
        PARAMETERS.put("cdata-sections", new BooleanParameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.880 -0500", hash_original_method = "3A5A96B3676E66B330A45A840239BDBA", hash_generated_method = "FCE7FB127BBFDBF34B86B850311D629E")
            
public Object get(DOMConfigurationImpl config) {
                return config.cdataSections;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.883 -0500", hash_original_method = "B9C81D72BFD5282E9CCD60E4010A0115", hash_generated_method = "8F91899D8AC853A741286D3D0A222F9C")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.cdataSections = (Boolean) value;
            }
        });
        PARAMETERS.put("check-character-normalization", new FixedParameter(false));
        PARAMETERS.put("comments", new BooleanParameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.886 -0500", hash_original_method = "F1D18B11117E62CFC92C9244E52B282C", hash_generated_method = "6FC3D419796F85ABA4EAB25EFBF2F91D")
            
public Object get(DOMConfigurationImpl config) {
                return config.comments;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.889 -0500", hash_original_method = "6346E50557E2D2369BDD4A7C089A2945", hash_generated_method = "FFCA08DA22FD1C23F3273905807EB831")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.comments = (Boolean) value;
            }
        });
        PARAMETERS.put("datatype-normalization", new BooleanParameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.892 -0500", hash_original_method = "985EBF949571B479B04193AF03B2FA4B", hash_generated_method = "8B0087742455AB7C66A46DC10A6B0B50")
            
public Object get(DOMConfigurationImpl config) {
                return config.datatypeNormalization;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.895 -0500", hash_original_method = "98C94396C151D1B52652505836093F99", hash_generated_method = "61F275A6C467056C1008D7F6FABD478F")
            
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
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.897 -0500", hash_original_method = "91B7377EC53FF18E752558FB4BB5DBB6", hash_generated_method = "E00B437A851AEC04C9FAB022369A9A34")
            
public Object get(DOMConfigurationImpl config) {
                return config.entities;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.900 -0500", hash_original_method = "A099E8C41A8CF9DACB56DAC5B4BEFBB7", hash_generated_method = "2AE6F44C9DE1C4AEEB570B5E80E8F151")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.entities = (Boolean) value;
            }
        });
        PARAMETERS.put("error-handler", new Parameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.902 -0500", hash_original_method = "AF89E3F1787F195BB4752172071B5443", hash_generated_method = "B944C71D454E35F5317AE8EC5FD98317")
            
public Object get(DOMConfigurationImpl config) {
                return config.errorHandler;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.905 -0500", hash_original_method = "EF73E874F9C2C693F331C0ECF0D7748E", hash_generated_method = "C2E9ED1E76D48B49DC8DC254A1E26E06")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.errorHandler = (DOMErrorHandler) value;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.908 -0500", hash_original_method = "6C252C2FA31E60E2515DAE2CF202BD0E", hash_generated_method = "48A494665063E227EF2E4C900D6D538B")
            
public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof DOMErrorHandler;
            }
        });
        PARAMETERS.put("infoset", new BooleanParameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.911 -0500", hash_original_method = "D8FC0D342AC511619314A2885BA15CD2", hash_generated_method = "A563320C0AE48D44AE75AF4D78BAF62E")
            
public Object get(DOMConfigurationImpl config) {
                // validate-if-schema is always false
                // element-content-whitespace is always true
                // namespace-declarations is always true
                return !config.entities
                        && !config.datatypeNormalization
                        && !config.cdataSections
                        && config.wellFormed
                        && config.comments
                        && config.namespaces;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.913 -0500", hash_original_method = "E5B606973A6C519301A0F3BF50725AE7", hash_generated_method = "753957AC55868D029CAF37EFAF6A036B")
            
public void set(DOMConfigurationImpl config, Object value) {
                if ((Boolean) value) {
                    // validate-if-schema is always false
                    // element-content-whitespace is always true
                    // namespace-declarations is always true
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
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.916 -0500", hash_original_method = "8234F9A67307B7D8DCBE95F53CE7FB8B", hash_generated_method = "81687DFF70F2A2E37F41E3917247A21C")
            
public Object get(DOMConfigurationImpl config) {
                return config.namespaces;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.919 -0500", hash_original_method = "A59D9940F30374E25C3AABE10E20F9A3", hash_generated_method = "7F3CAC4C2B1525437BA9F2F0420EE809")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.namespaces = (Boolean) value;
            }
        });
        PARAMETERS.put("namespace-declarations", new FixedParameter(true));
        PARAMETERS.put("normalize-characters", new FixedParameter(false));
        PARAMETERS.put("schema-location", new Parameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.923 -0500", hash_original_method = "6764E060CDCE24D9CAC3796C82C3113E", hash_generated_method = "796A20EDB714F52A6619AC961DBE220B")
            
public Object get(DOMConfigurationImpl config) {
                return config.schemaLocation;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.925 -0500", hash_original_method = "F17605E13E0F40278E59DE81956030E5", hash_generated_method = "B858CCA2A7667F4BA3A1E2C5CC3E4329")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.schemaLocation = (String) value;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.935 -0500", hash_original_method = "867C636DB00382820CE3F0E6571CD207", hash_generated_method = "5B50D411A71ADE95BC0E8280B034012B")
            
public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof String;
            }
        });
        PARAMETERS.put("schema-type", new Parameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.930 -0500", hash_original_method = "FF3D5FCDAC75FADA9A828C13A57700D1", hash_generated_method = "6222E651613B0AAEBDC6FF5B96DCB506")
            
public Object get(DOMConfigurationImpl config) {
                return config.schemaType;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.932 -0500", hash_original_method = "C6CF0DE3786425427859E4002168AC7D", hash_generated_method = "0FF43BD9A576647B47A2FF307DAA4F15")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.schemaType = (String) value;
            }
            
        public boolean canSet(DOMConfigurationImpl config, Object value) {
                return value == null || value instanceof String;
            }
        });
        PARAMETERS.put("split-cdata-sections", new BooleanParameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.938 -0500", hash_original_method = "DC04461ABC77629550A95C612A79F3EF", hash_generated_method = "868B8F62E5B114808488C7F8A64A1303")
            
public Object get(DOMConfigurationImpl config) {
                return config.splitCdataSections;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.941 -0500", hash_original_method = "294F612C0E1988E64E8F75C1867B3730", hash_generated_method = "1DB477B384B0719DF910A007BFF7ADF2")
            
public void set(DOMConfigurationImpl config, Object value) {
                config.splitCdataSections = (Boolean) value;
            }
        });
        PARAMETERS.put("validate", new BooleanParameter() {
            @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.944 -0500", hash_original_method = "AEEFEBC0123142901425D13D61687371", hash_generated_method = "3FF707EC2939E05B9C4F3D8F33D33939")
            
public Object get(DOMConfigurationImpl config) {
                return config.validate;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.946 -0500", hash_original_method = "6B8DD4C7BA6494D0099A0AB97B3B9302", hash_generated_method = "E4965F66335D94A843C17171B842C263")
            
public void set(DOMConfigurationImpl config, Object value) {
                // validate-if-schema is always false
                config.validate = (Boolean) value;
            }
        });
        PARAMETERS.put("validate-if-schema", new FixedParameter(false));
        PARAMETERS.put("well-formed", new BooleanParameter() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.949 -0500", hash_original_method = "4BD654AFD3698466DEC6A99BFAC24CDF", hash_generated_method = "6EE15FF4EBAAD13F5CF20518B04EDA9D")
            
public Object get(DOMConfigurationImpl config) {
                return config.wellFormed;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.951 -0500", hash_original_method = "CA64594B0CCFEF10770D26BF0EEF1900", hash_generated_method = "A6A101CE6A4028043D9F6A22B4963179")
            
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

