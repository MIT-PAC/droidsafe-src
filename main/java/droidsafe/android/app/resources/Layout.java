package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;
import org.w3c.dom.*;

import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.RString;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootClass;

import droidsafe.android.app.resources.ResourcesSoot;

/**
 * Reads layout XML files  and creates a matching java tree.
 */
public class Layout {
	  private final static Logger logger = LoggerFactory.getLogger(Layout.class);	

  /** source XML file this layout is read from **/
  File  source;

  /** name of the layout (R.layout.XXX), the terminal file in source path **/
  String name;

  /** The top level view specified in the layout file **/
  public View view;

  /** The activity (if any) associated with this layout **/
  Set<Activity> activities = new LinkedHashSet<Activity>();

  /** The classes (if any) that instantiates this view (with setContentView) **/
  Set<SootClass> classes = new LinkedHashSet<SootClass>();

  public Layout (File layout_source) throws Exception {

    source = layout_source;
    logger.info("**** " + source.getName());
    String[] name_ext = source.getName().split ("[.]", 2);
    name = name_ext[0];

    DocumentBuilderFactory docBuilderFactory 
      = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse (source);    
    doc.normalize();
    Element e = doc.getDocumentElement();
 
    view = new View(e);

  }


  /*
  * Internal version to build UIobjects of all views recursively
  */
  private void buildUIObjects(View myView, HashMap<String, RString> stringMap) {
	  logger.debug("====================");
	  logger.debug("buidUIObjects for Layout ");
	  logger.debug("View " + view);
	  logger.debug("====================");
	  logger.debug("");

	  for (View cview: myView.children) { 
		  logger.debug("cview: " + cview); 
		  String id = cview.get_attr("id");
		  logger.debug("cview.name <{}>, id={}" , cview.name, id);

		  String text = cview.get_attr("text");
		  String idName = null;

		  if (id != null) {
			  id = id.replace("@android:", "");
			  idName = id.substring(id.indexOf("+") + 1);
			  idName = idName.replace('/', '.');
			  logger.debug("  id {}:{} " ,id, idName);
		  }

		  if (text != null) {
			  logger.debug("  text -  " + text);
			  int index = text.indexOf("/");
			  if (text.startsWith("@") && index > 0) {
				  RString rString = stringMap.get(text.substring(index + 1));
				  if (rString != null) {
					  logger.debug("  value=" + rString.value);
					  text = rString.value;
				  }
			  }
		  }

		  if (idName != null && cview.name != null) {
			  logger.debug("addTextView({}, {}, {})", cview.name, idName, text);
			  ResourcesSoot.v().addTextView(cview.name,  idName, text);
		  }

		  buildUIObjects(cview, stringMap);
	  }
  }

  /**
  * buildUIObjects:
  *		
  */
  public void buildUIObjects(HashMap<String, RString> stringMap) {
	  buildUIObjects(view, stringMap);
  }

  public class View extends BaseElement {

    /** Type of view (eg, LinearLayout or ToggleButon) **/
    String name;
    /** The ID of the view **/
    String id;
    /** OnClick method (if any) **/
    String on_click;
    /** Children of this view **/
    List<View> children = new ArrayList<View>();

    public View (Node n) {

      super (n, null);
      
      name = n.getNodeName();
      id = get_attr("id");
      
      on_click = get_attr ("onClick");
      for (Node cnode : gather_children()) {
        children.add (new View(cnode));
      }

    }

    /**
     * are we interested in onClick only ???
     */
    public String toString() {
      String out = name;
      if (id != null)
        out += " id=" + id;
      if (on_click != null)
        out += " onClick=" + on_click;
      return out + " " + children;
    }
    
    public String getID() {
    	return id;
    } 

    /** Return the resource name that corresponds to the ID **/
    public String get_resource_name() {
      if (id == null)
        return null;
      String name = id.replaceFirst ("[@+]*", "");
      return name.replace ("/", ".");
    }

    public String getName() {
    	return name;
    }

	public void dump() {
		logger.warn("Dumping Layout.view info ");
		logger.warn("View " + view);
		for (View cview: children) { 
			logger.warn("cview: " + cview);
		}
	}
  }
}
