package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

/**
 * Provides generic XML element routines
 */
public class BaseElement {
	private final static Logger logger = LoggerFactory.getLogger(BaseElement.class);	
	
  /** Throws exceptions on all errors if true.  If false log must be set **/
  public boolean errors_are_exceptions = true;

  /** Destination for error messages if errors_are_exceptions is false **/
  public PrintStream log = null;

  BaseElement parent;
  public List<BaseElement> children= new ArrayList<BaseElement>();

  NamedNodeMap attributes = null;
  Node node;

  static String blanks = "                                               ";

  /** Create a new XML element.  Children inherit settings from their parent **/
  public BaseElement (Node n, BaseElement parent) {
	  
	  
    node = n;
    attributes = n.getAttributes();
    if (parent != null) {
      this.parent = parent;
      parent.children.add (this);
      errors_are_exceptions = parent.errors_are_exceptions;
      log = parent.log;
    }
  }

  /** 
   * Returns the attribute with the specified name.  Name can either be
   * fully specified (eg, android:icon) or just the local name (eg, icon)
   **/
  public String get_attr (String name) {

    if (attributes == null)
      return null;

    logger.info("getting attribute '{}'", name);
    Node n = attributes.getNamedItem (name);
    if (n == null)
      n = attributes.getNamedItem ("android:" + name);
    if (n == null)
      return null;
    else
      return n.getNodeValue();
  }

  public boolean attr_exists (String name) {

    return (get_attr (name) != null);
  }

  /**
   * Returns an Integer value for the specified attribute.  Returns null
   * if the attribute does not exist.  Throws an exception if the value of
   * the attribute is not a valid integer
   */
  public Integer integer_attribute (String name) throws
    InvalidPropertiesFormatException {

    String val = get_attr (name);
    if (val == null)
      return null;
    try {
      return Integer.parseInt (val);
    } catch (NumberFormatException e) {
      throw new InvalidPropertiesFormatException (e);
    }
  }

  /** Returns a Boolean value for the specified attribute.  Returns null
   *  if the attribute does not exist.  Throws an exception if the value of
   *  the attribute is not true or false.
   */
  public Boolean boolean_attribute (String name) throws 
    InvalidPropertiesFormatException {

    String val = get_attr (name);
    if (val == null)
      return null;
    if (val.equalsIgnoreCase ("true"))
      return Boolean.TRUE;
    else if (val.equalsIgnoreCase ("false"))
      return Boolean.FALSE;
    else { // unexpected value
      xml_error ("boolean_attribute: bad boolean value '%s' for attr '%s'", 
                 val, name);
      return null;
    }
  }

  /**
   * Returns the boolean value of an attribute.  If the attribute does not
   * exist the default_val is returned.
   */
  public boolean boolean_attribute (String name, boolean default_val) 
    throws InvalidPropertiesFormatException {
    
    Boolean val = boolean_attribute (name);
    if (val == null)
      return default_val;
    else
      return val;
  }

  /**
   * Sets all of the fields in e that are marked with the Attribute
   * annotation
   */
  public void get_attributes (BaseElement e) 
    throws InvalidPropertiesFormatException {

    try {
      Field[] fields = e.getClass().getDeclaredFields();
      for (Field f : fields) {
        Attribute a = f.getAnnotation (Attribute.class);
        logger.info ("Field {}, annotation {}", f.getName(), a);
        if (a == null)
          continue;
        String name = f.getName();
        Class<?> type = f.getType();
        if (type.equals (boolean.class)) {
          Boolean val = boolean_attribute (name);
          if (val != null)
            f.setBoolean (e, val);
        } else if (type.equals (Boolean.class)) {
          f.set (e, boolean_attribute (name));
        } else if (type.equals (String.class)) {
          f.set (e, get_attr (name));
        } else if (type.equals (Integer.class)) {
          f.set (e, integer_attribute (name));
        } else { // not a supported type
          throw new IllegalArgumentException ("field " + name + " type " 
                                              + type);
        }
      }
    } catch (IllegalAccessException exception) {
      // There is nothing a caller can do about this
      throw new RuntimeException (exception);
    }
  }


  /** 
   * Returns the attribute with the specified name.  Name can either be
   * fully specified (eg, android:icon) or just the local name (eg, icon)
   **/
  static String get_attr (Node n, String name) {

    NamedNodeMap attributes = n.getAttributes();
    if (attributes == null)
      return null;

    Node att = attributes.getNamedItem (name);
    if (att == null)
      att = attributes.getNamedItem ("android:" + name);
    if (att == null)
      return null;
    else
      return att.getNodeValue();
  }


  static void dump_node (Node n, int indent) {

    String tab = blanks.substring (0, indent);

    if (n.getNodeType() == Node.TEXT_NODE) {
      // text nodes appear to be any text that occurs between real nodes.
      // This is pretty uninteresting, so just skip them
      // Messages.print ("%sText Node %s, %s\n", tab, n.getNodeValue(), 
      //                   n.getTextContent());
    } else {
      logger.info ("{}Node {} [{}]\n", tab, n.getNodeName(), 
                         node_type(n));
    }

    // Print out the attributes (if any)
    NamedNodeMap attributes = n.getAttributes();
    if (attributes != null) {
      for (int ii = 0; ii < attributes.getLength(); ii++) {
        Node attr = attributes.item (ii);
        logger.info ("{}  attribute {} = {}\n", tab, attr.getNodeName(), 
                           attr.getNodeValue());
      }
    }

    // Handle any child nodes
    NodeList children = n.getChildNodes();
    if (children != null) {
      for (int ii = 0; ii < children.getLength(); ii++) {
        Node child = children.item(ii);
        dump_node (child, indent+2);
      }
    }
  }

  /** Returns a textual representation of a node type **/
  static String node_type (Node n) {

    switch (n.getNodeType()) {
    case Node.DOCUMENT_NODE: return ("Document");
    case Node.DOCUMENT_TYPE_NODE: return ("Document type");
    case Node.ELEMENT_NODE: return ("Element");
    case Node.ENTITY_NODE: return ("Entity");
    case Node.TEXT_NODE: return ("Text");
    default: return String.format ("node type %d", n.getNodeType());
    }
  }

  /** 
   * Gather all of the children of this node, silently ignoring any 
   * nodes that are not elements.  Returns an empty list (not NULL) if
   * there are no children.
   */
  public List<Node> gather_children() {
    
    List<Node> child_list = new ArrayList<Node>();

    NodeList children = node.getChildNodes();
    if (children != null) {
      for (int ii = 0; ii < children.getLength(); ii++) {
        Node child = children.item(ii);
        if (child.getNodeType() == Node.ELEMENT_NODE) {
          child_list.add (child);
        }
      }
    }
    return child_list;
  }    
    
  /**
   * Handles any errors in parsing the XML file.  Throws an exception if
   * errors_are_exceptions is true, otherwise prints messages to log
   */
  public void xml_error (String format, Object... args) 
    throws InvalidPropertiesFormatException {

    if (errors_are_exceptions) {
      String msg = String.format (format, args);
      throw new InvalidPropertiesFormatException (msg);
    } else {
      log.printf (format + "\n", args);
    }
  }


}
