package droidsafe.android.app.resources;

import java.util.*;
import java.util.LinkedList;
import java.io.*;
import org.w3c.dom.*;

import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.RString;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.SootClass;
import soot.SootMethod;

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
  
  /** map to keep frequency of ID usage within the layout */
  static Map<String, Integer> idFreqMap = new HashMap<String, Integer>();
  
  private final String NONAME = "NoName";

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

  /** get full Id that matches with resource parsing of R.java */
  private String getFullName() {
      return "layout." + name;
  }
  
  private void buildOneView(View cview) {
      logger.debug("====================");
	  logger.debug("buidOneView ");
	  logger.debug("View " + cview);
	  logger.debug("====================");
	  logger.debug("");
	  
	  if (name == null || cview.name == null) {
	      logger.info("buildOneView: layout/cviewname is NULL {}/{} !!! ", name, cview.name);
	      return;
	  }

	  if (cview.id != null) {
	     logger.info("Normalizing cview.id {}", cview.id);
	     
	     cview.id = cview.id.replace("@+android:", "");
	     cview.id = cview.id.replace("@android:", "");
	     cview.id = cview.id.replace("@+id:", "");
	     cview.id = cview.id.replace("@id:", "");
	     
	     if (cview.id.contains("/")) {
	    	 cview.id = cview.id.substring(cview.id.indexOf("/") + 1);
	     }
	     
	     if (!cview.id.startsWith("id."))
	         cview.id = String.format("id.%s", cview.id);
	     
	     logger.info("cview id {} ", cview.id);
	  }

	  Integer count = 0;
	  if (cview.id == null) {
	      
	      String nonameKey =  String.format("%s_%s", name, NONAME);
	      //setting frequency key
	      if (!idFreqMap.containsKey(nonameKey)) {
	          idFreqMap.put(nonameKey, Integer.valueOf(0));;
	      }
	      count = idFreqMap.get(nonameKey);
	      count++;
	      
	      idFreqMap.put(nonameKey,  count);
	      
	      String newId = String.format("%s_%03d", nonameKey, count);
	      cview.id = newId;
	      
	      logger.info("cview {} is no ID, create a new One {} ", cview.name, cview.id);
	      
	      ResourcesSoot.v().addNewNumberToStringEntry(newId);
	  } 
	  else if (idFreqMap.containsKey(cview.id)) {
	      count = idFreqMap.get(cview.id);
	      count++;
	      idFreqMap.put(cview.id,  count);
	      
	      String newId = String.format("%s_%s_Dup%03d", name, cview.id, count);
	      
	      logger.info("cview id {} is a duplicate create a new One {} ", cview.name, newId);
	      cview.id = newId;
	      // add entry to allow id lookup later
	      ResourcesSoot.v().addNewNumberToStringEntry(newId);
	  }
	  
	  if (!idFreqMap.containsKey(cview.id))
	      idFreqMap.put(cview.id, Integer.valueOf(0));
	      
	  Map<String, String> attrs = cview.getAttributes();

	  if (cview.id != null && cview.name != null && attrs != null) {
		  logger.debug("addView({}, {} ", cview.name, cview.id);
		  ResourcesSoot.v().addView(cview.name,  cview.id, attrs);
	  }
  }


  /*
  * Internal version to build UIobjects of all views recursively
  */
  private void buildViews(View myView, HashMap<String, Set<RString>> stringListMap) {
	  
	  for (View cview: myView.children) { 
		  buildViews(cview, stringListMap);
	  }
	  
	  if (myView.getAttributes().size() > 0) {
	      buildOneView(myView);
	  }
  }

  /**
  * build UI views
  *		
  */
  public void buildViews(HashMap<String, Set<RString>> stringListMap) {
      idFreqMap.put(NONAME, Integer.valueOf(0));
	  buildViews(view, stringListMap);
  }
  
  
  /**
   * buildLayoutInit
   */
  public void buildInitLayout() {
      ResourcesSoot.v().createInitLayout_ID(getFullName());
      buildInitLayout(view);
      addCallOnClickToInitLayout_ID(view);
      ResourcesSoot.v().addReturnToInitLayout_ID();
  }
  
  /**
   * recursively LayoutInit
   * @param myView
   */
  private void buildInitLayout(View myView) {
       for (View cview: myView.children) { 
		  buildInitLayout(cview);
	  } 
       
	  if (myView.getAttributes().size() > 0) {
	      logger.info("Trying to add view {} ", myView.id);
	      logger.debug("myView: {}", myView);
	      ResourcesSoot.v().addViewAllocToInitLayout_ID(myView.id);
	  }
  }
  
  
  /**
   * add the onclick callback to callLayoutOnClicks
   * @param myView
   */
  private void addCallOnClickToInitLayout_ID(View myView) {
      for (View cview: myView.children) { 
     	  addCallOnClickToInitLayout_ID(cview);
	  } 
      
      if (myView.on_click != null) {
          logger.info("Trying to add onClic {} ", myView.id);
          logger.debug("-------");
          logger.debug("myView: {}", myView);
          logger.debug("-------");
          ResourcesSoot.v().addCallOnClickToInitLayout_ID(myView.id, myView.on_click);
      }
  }

  public class View extends BaseElement {

    /** Type of view (eg, LinearLayout or ToggleButon) **/
    String name;
    /** The ID of the view **/
    String id;
    /** OnClick method (if any) **/
    String on_click;
    /** Children of this view.  When a view has children, it is a ViewGroup/LinearLayout**/
    List<View> children = new ArrayList<View>();

    /**
     * private constructor
     */
    private View() {
        super();
    }
    /**
     * constructor
     * @param n
     */
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
    
    /** get Id of the view */
    public String getID() {
    	return id;
    } 
    
    /** set new Id */
    public void setID(String newId) {
        id = newId;
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
	
	@Override
	/**
	 * overide cloneable
	 */
	public Object clone() {
	    View copy = new View(); 
	    cloneTo(copy);
	    copy.id   = this.id;
	    copy.name = this.name;
	    copy.on_click = this.on_click;
	    return copy;
	}
  }
}
