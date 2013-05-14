package droidsafe.android.app.resources;


import droidsafe.android.app.resources.BaseElement;
import droidsafe.android.app.resources.XmlFile;

import java.util.InvalidPropertiesFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Node;


public class RString extends BaseElement {
	
  private final static Logger logger = LoggerFactory.getLogger(RString.class);	
 
  @Attribute public String name;

  // source XML file this string was read from
  public XmlFile  source;
  public String value;

  public RString(Node n, XmlFile source, String value) throws InvalidPropertiesFormatException {
    super(n, null);
    get_attributes(this);
    
    this.source = source;
    this.value = value;
  }
}
