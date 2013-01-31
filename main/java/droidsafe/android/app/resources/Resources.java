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
import soot.jimple.AbstractStmtSwitch;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.internal.JAssignStmt;
import soot.tagkit.ConstantValueTag;
import soot.tagkit.IntegerConstantValueTag;
import soot.tagkit.Tag;
import soot.util.Chain;


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
import droidsafe.android.system.Components;


/**
 * Representation of the Android Resources and Manifest file.  Also contains
 * processing routines for DroidSafe (these should perhaps be elsewhere)
 * 
 * 1. Read in AndroidManifest and save its info in AndroidManifest
 * 2. Read all R*.java generated classes to find the id's of the layouts
 * 3. Find all invokes of setContentView(id) to determine the layouts an activity
 *    can inflate, and remember onclick handlers defined in the layout
 */
@SuppressWarnings("all")
public class Resources {
	private final static Logger logger = LoggerFactory.getLogger(Resources.class);

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
	
	Set<SootMethod> allHandlers = new LinkedHashSet<SootMethod>();

	/** did we successfully run this pass */
	private boolean resolved = false;
	
	static String blanks = "                                               ";

	private static boolean already_read_activity_subclasses = false;
	private static HashSet activity_subclasses = new HashSet(); // Filled from config-files/activity_subclasses.txt 
	// Entries look like "android.app.ActivityGroup"

	private static Resources v;
	
	public static Resources v() {
		return v;
	}
	
	public static void resolveManifest(String rootDir)  {
		try {
			v = new Resources (new File (rootDir));

			// Dump manifest information
			AndroidManifest am = v.manifest;
			logger.info ("Manifest = {}\n", am.manifest);
			logger.info ("appliction = {}\n", am.application);
			logger.info ("Activities: \n");
			for (Activity a : am.activities) {
				logger.info ("  {}\n", a);
			}

			// Dump layout information
			logger.info ("\nLayouts:\n");
			for (Layout l : v.layouts) {
				logger.info ("  layout {}: {}\n", l.name, l.view);
			}

			String package_name = am.manifest.package_name;

			// Process the activities of the application
			for (Activity a : v.manifest.activities)
				v.process_activity (a);

			// Process all of the layouts
			for (Layout l : v.layouts) {
				logger.info ("  Processing layout {}\n", l.name);
				v.process_view (l, l.view);
			} 
			v.resolved = true;
		} catch (Exception e) {
			logger.error("Error resolving resources and manifest: ", e);
		}
	}

	public boolean isResourceClass(SootClass clz) {
		return clz.getShortName().equals("R") ||
				clz.getShortName().startsWith("R$") ||
				clz.getShortName().equals("BuildConfig");
	}
	
	/** Processes the application located in the specified directory **/
	public Resources (File application_base) throws Exception {

		this.application_base = application_base;

		resource_info = HashBiMap.create();

		// Get the manifest and read it
		File manifest_file = new File (application_base, "AndroidManifest.xml");
		manifest = new AndroidManifest (manifest_file);
		package_name = manifest.manifest.package_name;

		// Get all of the layout files and read them.
		File layout_dir = new File (application_base, "res/layout");
		for (File layout_source : layout_dir.listFiles()) {
			// logger.info ("considering layout file {}", layout_source);
			String name = layout_source.getName();
			String[] name_ext = name.split ("[.]", 2);
			// logger.info ("name/ext = {}/{}", name_ext[0], name_ext[1]);
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
			if (clz.isApplicationClass() & clz.getShortName().startsWith("R$")) {
				String component = clz.getShortName().substring(2);
				for (SootField field : clz.getFields()) {
					Integer value = new Integer(0);
					
					Tag tag = field.getTag("IntegerConstantValueTag");
					//ug, the initializer value is stored in a tag
					//not documented anywhere...except a mailing list post from years ago
					if (tag instanceof IntegerConstantValueTag) {
						value = new Integer(((IntegerConstantValueTag)tag).getIntValue());
						logger.info ("field {}.{} = {}", component, field, String.format("%08X", value));
						resource_info.put ((Integer) value, 
							component + "." + field.getName());
					}
					else {
						logger.info("Unknown initial value for field of resource class: {} ()", field.getName(), tag);
						//hopefully we will not need this resource value in analysis, if so we will die
						//when we try to search for this...
					}
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
		String className;
		if (activity.name.startsWith("."))
			className = package_name + activity.name;
		else 
			className = activity.name;
		
		final SootClass cn = Scene.v().getSootClass(className);
		if (!Scene.v().containsClass(className) || cn == null) {
			logger.error ("No class file found for manifest activity '{}' "
					+ "(package {})", activity.name, package_name);
			System.exit(1);
		}
		
		logger.info ("read in class file " + cn.getName());

		// Process methods of cn only if cn is an "Activity" or inherits Activity
		if (classNodeIsAnAndroidActivity(cn)) {
			for (SootMethod m : cn.getMethods()) {
				logger.info ("  processing method {}", m.getName());
				process_method(activity, cn, m);
			}
		} else {
			logger.info ("Class {} not processed, it is not an Activity "
					+ " or subclass of Activity.", cn);
		}
	}

	/** Processes an entry point **/
	// full_classname looks like: "com.example.helladroid.HelloAndroid"
	private void process_entry (SootClass cn, String methSubSig) 
			throws UnsupportedIdiomException, MissingElementException {
		SootMethod m = cn.getMethod(methSubSig);
		
		if (!cn.declaresMethod(methSubSig) || m == null) 
			throw new MissingElementException ("Method " + methSubSig 
					+ " not found in class " + cn);
		logger.info ("process entry {}.{}()", cn, m);
		process_method (null, cn, m);
	}

	/**
	 * Processes any entry points (onClick attributes) specified in this
	 * view or any of its children
	 */
	void process_view (Layout layout, View view) throws Exception {

		logger.info ("  processing view {}.{}", layout.name, view.name);
		if ((view.on_click != null) && (layout.activities.isEmpty())) {
			// It seems reasonable that apps may have unused layout files
			logger.info ("Warning: on click handler {} in layout {} ignored, "
					+ "{} is not inflated anywhere", view.on_click,
					layout.name, layout.name);
			// bad_idiom ("No Activity associated with layout '{}'", layout.name);
		} else if (view.on_click != null) {
			for (SootClass cn : layout.classes) {
				logger.info ("Found on_click entry point {}.{} for view {} " +
						"in layout {}, resource name {}", 
						cn, view.on_click,
						view.name, layout.name, view.get_resource_name());
				//build the method signature in the soot format
				List<RefType> viewArg = new LinkedList<RefType>();
				viewArg.add(RefType.v("android.view.View"));
				SootMethod method = cn.getMethod(view.on_click, viewArg);

				//record the handler in the map for the layout
				//for the entire application there could be multiple layouts, and multiple
				//handler per layout
				if (!handlers.containsKey(layout)) { 
					handlers.put(layout, new HashMap<View, SootMethod>());
				}

				logger.info("Putting: {} {} {}\n", layout, view, method);
				handlers.get(layout).put(view, method);	
				allHandlers.add(method);

				// Its not entirely clear why we are processing the on_click entry
				// point itself.  What are we looking for here?
				try {
					process_entry (cn, method.getSubSignature());
				} catch (MissingElementException mee) {
					logger.info ("Warning, Error processing on click handler {} in "
							+ "layout {}: {}", view.on_click, layout.name, 
							mee.getMessage());
				}
			}
		}
		for (View child : view.children)
			process_view (layout, child);
	}


	/**
	 * Processes a method.  If the method is in an activity, activity should
	 * reference that activity.
	 */
	private void process_method (final Activity activity, final SootClass cn, final SootMethod m) 
			throws UnsupportedIdiomException {
		//find all invoke calls in method...

		StmtBody stmtBody = (StmtBody)m.retrieveActiveBody();
		for( Iterator stmtIt = stmtBody.getUnits().iterator(); stmtIt.hasNext(); ) {
			final Stmt stmt = (Stmt) stmtIt.next();
			if (stmt.containsInvokeExpr()) {
				InvokeExpr expr = stmt.getInvokeExpr();
				if (expr instanceof VirtualInvokeExpr)
					v.process_invoke(cn, m, (VirtualInvokeExpr)expr, activity);
			}
		}
	}


	// Returns true if cn is class android/app/Activity or is a class
	// that inherits from android/app/Activity
	private boolean classNodeIsAnAndroidActivity(final SootClass cn) {
		return Scene.v().getActiveHierarchy().isClassSubclassOfIncluding(cn, Scene.v().getSootClass(Components.ACTIVITY_CLASS));
	}


	/** 
	 * Process an invoke opcode.  This is responsible for method call
	 * specific processing 
	 **/
	private void process_invoke (SootClass cn, SootMethod m, VirtualInvokeExpr expr,
			Activity activity) throws UnsupportedIdiomException {
		//logger.info ("process_invoke [{}] {}.{} calling {}", cn.getSuperclass(),
		//		cn, m, expr);
		
		//if we don't have a reference, return
		if (!(expr.getBase().getType() instanceof RefType))
			return;
		
		//cannot possibly be a call to setContentView with another name...
		if (!expr.getMethod().getName().equals("setContentView"))
			return;
		
		SootMethod calling = 
				Scene.v().getActiveHierarchy().resolveConcreteDispatch(((RefType)expr.getBase().getType()).getSootClass(), expr.getMethod());
		
		SootMethod setContentView = Scene.v().getMethod("<android.app.Activity: void setContentView(int)>");
		
		if (calling.equals(setContentView)) {
			//now check if the single argument is a constant
						
			if (!(expr.getArgs().get(0) instanceof IntConstant)) {
				logger.error("Found call to setContentView(int) with non-constant argument: {}", expr.getArgs().get(0));
				System.exit(1);
				return;
			}
			
			int resource_id = ((IntConstant)expr.getArgs().get(0)).value;
				
			logger.info ("Multiple setContentView calls in one Activity: {} {}", cn, m);

			activity.content_views.add(new Integer(resource_id));
			logger.info ("  setContentView ({} -> {})", resource_id, 
					resource_info.get(resource_id));
			String resource_name = resource_info.get(resource_id);
			if (resource_name == null) 
				bad_idiom (cn, m, "Resource id %08X not found", resource_id);
			String layout_name = resource_name.replace ("layout.", "");
			Layout layout = find_layout_by_name (layout_name);
			if (layout == null) 
				bad_idiom (cn, m, "No layout named %s", layout);
			layout.activities.add(activity);

			// Remember the class that instantiated this view/layout
			layout.classes.add(cn);
			logger.info ("Found activity/class {}/{} for layout {}\n", activity, 
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
	
	public Set<SootMethod> getAllHandlers() {
		return allHandlers;
	}
	
	public boolean isHandler(SootMethod m) {
		return allHandlers.contains(m);
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
			// logger.info ("{}Text Node {}, {}\n", tab, n.getNodeValue(), 
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
	
	
}
