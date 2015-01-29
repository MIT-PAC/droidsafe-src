package droidsafe.android.app.resources;


import droidsafe.android.app.resources.BaseElement;
import droidsafe.android.app.resources.XmlFile;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Node;


public class RStringArray extends BaseElement {
	
  private final static Logger logger = LoggerFactory.getLogger(Layout.class);	
 
  @Attribute public String name;

  // source XML file this string was read from
  public XmlFile  source;
  public List<String> value;

  public RStringArray(Node n, XmlFile source, List<String> value) throws InvalidPropertiesFormatException {
    super(n, null);
    get_attributes(this);
    
    this.source = source;
    this.value = value;
  }
}
