package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.InvokeExpr;


import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;

import droidsafe.analyses.CallGraphFromEntryPoints;
import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.Layout.View;


/**
 * Representation of the Android Application as a whole.  Also contains
 * processing routines for DroidSafe (these should perhaps be elsewhere)
 */
@SuppressWarnings("all")
public class Application {

	private final static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public final static String ACTIVITY_CLASS = "android.app.Activity";

	/** Base directory of the application **/
	File application_base = null;

	/** Android Manifest of Application **/
	AndroidManifest manifest = null;

	/** Layouts in the Application **/
	List<Layout> layouts = new ArrayList<Layout>();

	/** Application base package name **/
	String package_name;

	/** Map of resources ids to their corresponding names in R **/
	HashBiMap<Integer,String> resource_info;

	/** Map of all onclick handlers registered in the xml and source,
	 *  layout id -> view -> method sig 
	 */
	HashMap<Layout, HashMap<View, SootMethod>> handlers 
	= new LinkedHashMap<Layout, HashMap<View, SootMethod>>();

	static String[] activity_entry_points = {"onCreate", "onStart", "OnResume",
		"onPause", "onStop", "onDestroy",
	"onRestart"};
	
	/** did we successfully run this pass */
	private boolean resolved = false;
	
	static String blanks = "                                               ";

	private static boolean already_read_activity_subclasses = false;
	private static HashSet activity_subclasses = new HashSet(); // Filled from config-files/activity_subclasses.txt 
	// Entries look like "android.app.ActivityGroup"

	private static Application v;
	
	public static Application v() {
		return v;
	}
	
	public static void resolveManifest(String rootDir)  {
		try {
			v = new Application (new File (rootDir));

			// Dump manifest information
			AndroidManifest am = v.manifest;
			logger.info ("Manifest = %s\n", am.manifest);
			logger.info ("appliction = %s\n", am.application);
			logger.info ("Activities: \n");
			for (Activity a : am.activities) {
				logger.info ("  %s\n", a);
			}

			// Dump layout information
			logger.info ("\nLayouts:\n");
			for (Layout l : v.layouts) {
				logger.info ("  layout %s: %s\n", l.name, l.view);
			}

			String package_name = am.manifest.package_name;

			// Process the activities of the application
			for (Activity a : v.manifest.activities)
				v.process_activity (a);

			// Process all of the layouts
			for (Layout l : v.layouts) {
				logger.info ("  Processing layout %s\n", l.name);
				v.process_view (l, l.view);
			} 
			v.resolved = true;
		} catch (Exception e) {
			logger.error("Error resolving resources and manifest: ", e);
		}
	}

	/** Processes the application located in the specified directory **/
	public Application (File application_base) throws Exception {

		this.application_base = application_base;

		resource_info = HashBiMap.create();

		// Get the manifest and read it
		File manifest_file = new File (application_base, "AndroidManifest.xml");
		manifest = new AndroidManifest (manifest_file);
		package_name = manifest.manifest.package_name;

		// Get all of the layout files and read them.
		File layout_dir = new File (application_base, "res/layout");
		for (File layout_source : layout_dir.listFiles()) {
			// logger.info ("considering layout file %s", layout_source);
			String name = layout_source.getName();
			String[] name_ext = name.split ("[.]", 2);
			// logger.info ("name/ext = %s/%s", name_ext[0], name_ext[1]);
			if (name_ext[1].equals ("xml"))
				layouts.add (new Layout (layout_source));
		}

		// Read in the resource id to name map
		read_resources();
	}


	/** 
	 * Reads all of the resources ids defined in R and adds them 
	 * to resource info.  The map is from the resource id to the
	 * name of the resource (eg, 0x7F030000 -> layout.main)
	 **/
	void read_resources () throws Exception {

		//find all classes that start with R$ and assume they are 
		//generated resource classes
		for (SootClass clz : Scene.v().getClasses()) {
			if (clz.isApplicationClass() & clz.getName().startsWith("R$")) {
				String component = clz.getName().substring(2);
				for (SootField field : clz.getFields()) {
					field.
				}
			}
		}

		for (String f : layout_dir.list()) {
			logger.info ("considering resource class file %s", f);
			if (f.startsWith ("R$") && f.endsWith (".class")) {
				String component = f.substring (2, f.length()-6);
				MyClassNode cn = get_class (package_name, f.replace (".class", ""));
				for (int ii = 0; ii < cn.fields.size(); ii++) {
					FieldNode field = (FieldNode) cn.fields.get(ii);
					logger.info ("field %s.%s = %s", component, field.name, field.value);
					resource_info.put ((Integer) field.value, 
							component + "." + field.name);
				}
			}
		}
	}


	/** 
	 * Process all of the entry points for an activity.  For now, we just
	 * process all of the methods in the class
	 **/
	void process_activity (Activity activity) throws Exception {
		// Get the class.  Normally classes relative to the package base start
		// with dot (.), but sometimes they don't.  So if we don't find it with
		// the fully qualified name, we search for those using the pcackage base
		// as well.
		final SootClass cn = Scene.v().getSootClass(package_name + "." + activity.name);
		if (cn == null) {
			logger.info ("Warning: No class file found for manifest activity '%s' "
					+ "(package %s)", activity.name, package_name);
			return;
		}
		logger.info ("read in class file " + cn.getName());

		// Process methods of cn only if cn is an "Activity" or inherits Activity
		if (classNodeIsAnAndroidActivity(cn)) {
			for (SootMethod m : cn.getMethods()) {
				logger.info ("  processing method %s", m.getName());
				process_method(activity, cn, m);
			}
		} else {
			logger.info ("Class %s not processed, it is not an Activity "
					+ " or subclass of Activity.", cn);
		}
	}

	/** Processes an entry point **/
	// full_classname looks like: "com.example.helladroid.HelloAndroid"
	private void process_entry (SootClass cn, String methSubSig) 
			throws UnsupportedIdiomException, MissingElementException {

		SootMethod m = cn.getMethod(methSubSig);
		if (m == null) 
			throw new MissingElementException ("Method " + methSubSig 
					+ " not found in class " + cn);
		logger.info ("process entry %s.%s()", cn, m);
		process_method (null, cn, m);
	}

	/**
	 * Processes any entry points (onClick attributes) specified in this
	 * view or any of its children
	 */
	void process_view (Layout layout, View view) throws Exception {

		logger.info ("  processing view %s.%s", layout.name, view.name);
		if ((view.on_click != null) && (layout.activity == null)) {
			// It seems reasonable that apps may have unused layout files
			logger.info ("Warning: on click handler %s in layout %s ignored, "
					+ "%s is not inflated anywhere", view.on_click,
					layout.name, layout.name);
			// bad_idiom ("No Activity associated with layout '%s'", layout.name);
		} else if (view.on_click != null) {
			if (layout.activity == null) 
				// bad_idiom ("No Activity associated with layout '%s'", layout.name);
				if (layout.cn ==  null)
					bad_idiom ("No class associated with layout '%s'", layout.name);
			logger.info ("Found on_click entry point %s.%s for view %s " +
					"in layout %s, resource name %s", 
					layout.cn, view.on_click,
					view.name, layout.name, view.get_resource_name());

			//build the method signature in the soot format
			List<RefType> viewArg = new LinkedList<RefType>();
			viewArg.add(RefType.v("android.view.View"));
			SootMethod method = layout.cn.getMethod(view.on_click, viewArg);
			
			//record the handler in the map for the layout
			//for the entire application there could be multiple layouts, and multiple
			//handler per layout
			if (!handlers.containsKey(layout)) 
				handlers.put(layout, new HashMap<View, SootMethod>());

			logger.info("Putting: %s %s %s\n", layout, view, method);
			handlers.get(layout).put(view, method);	 	

			// Its not entirely clear why we are processing the on_click entry
			// point itself.  What are we looking for here?
			try {
				process_entry (layout.cn, view.on_click);
			} catch (MissingElementException mee) {
				logger.info ("Warning, Error processing on click handler %s in "
						+ "layout %s: %s", view.on_click, layout.name, 
						mee.getMessage());
			}
		}
		for (View child : view.children)
			process_view (layout, child);
	}


	/**
	 * Processes a method.  If the method is in an activity, activity should
	 * reference that activity.
	 */
	private void process_method (Activity activity, SootClass cn, SootMethod m) 
			throws UnsupportedIdiomException {

		//find all invoke calls in method...
		
	}


	// Returns true if cn is class android/app/Activity or is a class
	// that inherits from android/app/Activity
	private boolean classNodeIsAnAndroidActivity(final SootClass cn) {
		return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, Scene.v().getSootClass(ACTIVITY_CLASS));
	}


	/** 
	 * Process an invoke opcode.  This is responsible for method call
	 * specific processing 
	 **/
	private void process_invoke (SootClass cn, SootMethod m, InvokeExpr expr,
			Activity activity) throws UnsupportedIdiomException {
		

		logger.info ("process_invoke [%s] %s.%s calling %s", cn.getSuperclass(),
				cn, m, expr);

		// If calling setContentView, remember the layout file associated with
		// this activity
		if (method_inst.name.equals ("setContentView")&&
				method_inst.desc.equals ("(I)V")) {

			int resource_id = (Integer) ldc.cst;
			
			// This can happen.  We should probably change content_view to a list
			if (activity.content_view != 0)
				bad_idiom (cn, m, "Multiple setContentView calls in one Activity");

			activity.content_view = resource_id;
			logger.info ("  setContentView (%08X -> %s)", resource_id, 
					resource_info.get(resource_id));
			String resource_name = resource_info.get(resource_id);
			if (resource_name == null) 
				bad_idiom (cn, m, "Resource id %08X not found", resource_id);
			String layout_name = resource_name.replace ("layout.", "");
			Layout layout = find_layout_by_name (layout_name);
			if (layout == null) 
				bad_idiom (cn, m, "No layout named %s", layout);
			layout.activity = activity;

			// Remember the class that instantiated this view/layout
			layout.cn = cn;
			logger.info ("Found activity/class %s/%s for layout %s\n", activity, 
					cn, layout.name);
		}
	}


	/**
	 * Throws an UnsupportedIdiomException for the current class/method/line
	 */
	private static void bad_idiom (SootClass class_node,
			SootMethod method_node,
			String format,  Object... args) 
					throws UnsupportedIdiomException {

		String msg = String.format (format, args);
		throw new UnsupportedIdiomException (class_node, method_node,
				msg);
	}


	/**
	 * Throws an UnsupportedIdiomException for the current class/method/line
	 */
	private static void bad_idiom (String format,  Object... args) 
			throws UnsupportedIdiomException {

		String msg = String.format (format, args);
		throw new UnsupportedIdiomException (msg);
	}


	/**
	 * Returns the layout named layout_name.  Returns null if there is none
	 */
	Layout find_layout_by_name (String layout_name) {

		for (Layout l : layouts) {
			//System.out.println(l.name);
			if (layout_name.equals (l.name))
				return l;
		}

		return null;
	}

	
	/**
	 * Given the integer id of a view or layout in the resource class,
	 * return the String identifier from the source xml file.
	 * 
	 * @param i Integer constant used in compiled resource class
	 * @return String ID from source xml
	 */
	public String findLayoutName(Integer i) {
		if (resolved) {
			String ret = resource_info.get(i); 
			return (ret == null ? "" : ret);
		}
		else 
			return "";
	}
	
	/**
	 * Find the ID of a layout.
	 * 
	 * @param l The layout object
	 * @return The ID
	 */
	public Integer findViewID(String l) {
		if (resolved) {
			return resource_info.inverse().get(l);
		} else
			return null;
	}
	
	public boolean isResolved() {
		return resolved;
	}
	
	/**
	 * Given the id of a layout called by setContentView(int), return 
	 * the handlers in a map of button (view) -> methog signature.
	 * 
	 * @param i The view ID that is the arg to setContentView
	 */
	public Map<Layout.View, SootMethod> getOnClickHandlers(Integer i) {
		if (resolved) {
			//find the layout
			String fullname = findLayoutName(i);
			
			//in the resource_info of application, entries are stored by component.name
			//we just want the name when searching for a layout
			String[] name_ext = fullname.split ("[.]", 2);
		    String name = name_ext[1];
		    
			if (name == null || name.equals("")) {
				logger.info("Warning: name of layout null when analyzing setContentView()");
				return null;
			}
				
			Layout layout = find_layout_by_name(name);
			if (layout == null) {
				logger.info("Warning: cannot find layout when analyzing setContentView()");
				return null;
			}
			
			HashMap<Layout.View, SootMethod> ret = handlers.get(layout);
			if (ret == null) 
				return new HashMap<Layout.View, SootMethod>();
			return ret;
			
		} else  {
			//Messages.print("Unresolved!");
			return null;
		}
	}


	static void dump_node (Node n, int indent) {

		String tab = blanks.substring (0, indent);

		if (n.getNodeType() == Node.TEXT_NODE) {
			// text nodes appear to be any text that occurs between real nodes.
			// This is pretty uninteresting, so just skip them
			// logger.info ("%sText Node %s, %s\n", tab, n.getNodeValue(), 
			//                   n.getTextContent());
		} else {
			logger.info ("%sNode %s [%s]\n", tab, n.getNodeName(), 
					node_type(n));
		}

		// Print out the attributes (if any)
		NamedNodeMap attributes = n.getAttributes();
		if (attributes != null) {
			for (int ii = 0; ii < attributes.getLength(); ii++) {
				Node attr = attributes.item (ii);
				logger.info ("%s  attribute %s = %s\n", tab, attr.getNodeName(), 
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
	
	
}
