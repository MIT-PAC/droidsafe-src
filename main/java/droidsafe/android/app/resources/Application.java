package droidsafe.android.app.resources;

import java.util.*;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import soot.Scene;
import soot.SootClass;
import soot.SootField;


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
	HashMap<Layout, HashMap<View, String>> handlers 
	= new LinkedHashMap<Layout, HashMap<View, String>>();

	static String[] activity_entry_points = {"onCreate", "onStart", "OnResume",
		"onPause", "onStop", "onDestroy",
	"onRestart"};

	private static boolean already_read_activity_subclasses = false;
	private static HashSet activity_subclasses = new HashSet(); // Filled from config-files/activity_subclasses.txt 
	// Entries look like "android.app.ActivityGroup"

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
	 * Get the class information for the specified class.  Caches the 
	 * information so each class is only processed once 
	 **/
	MyClassNode get_class (String package_name, String class_name) 
			throws MsgException {

		// Find the .class file. Create MyClassNode from the .class file
		// .class file may be in bin/classes/<packagename>.<classname>.class
		// else it may be in     bin/classes/<classname>.class
		MyClassNode cn;
		File class_file = new File(class_base(package_name + "." + class_name).getPath() + ".class");

		if (class_file.isFile()) {
			cn = get_class(package_name + "." + class_name);
		} else {
			class_file = new File(class_base(class_name).getPath() + ".class");
			if (class_file.isFile()) {
				cn = get_class(class_name);
			} else {
				// Can't find .class file in bin/classes
				// Search the jar files in libs/ for the class
				cn = search_application_lib_for_class(class_name);
			}
		}

		return cn;
	}


	/**
	 * <pre>
	 * This method is called only if the class is not found in bin/classes
	 * This method searches for the class in lib/*.jar files
	 *
	 * Search all lib/*jar for jarfile containing the class: package_name.class_name.class
	 * Get the bytes of the class from the jar file.
	 * Form a MyClassNode from the bytes
	 * Save the MyClassNode in global HashMap class_info with key of full class name
	 *
	 * full_classname looks like "java/lang/String"  (does not end with ".class")
	 * Return the MyClassnode
	 * </pre>
	 */
	private MyClassNode search_application_lib_for_class(final String full_classname) throws MsgException {
		MyClassNode cn = null;

		logger.info(full_classname + " not found in bin/classes");

		Vector<String> bad_jarnames  = new Vector<String>();
		String bad_jarname_errmsg = null;
		// Current directory is Top level of application. directory lib/ is in current dir.
		// Loop thru the application lib/.jar files
		final File libs_dir = new File("libs");

		final File[] files = libs_dir.listFiles();
		JarFile jarfile = null;
		JarEntry found_jar_entry = null;  // On finding the class in a
		String found_entryname = null;    // jar file, these three variables
		String found_jarfile_name = null; // are set.
		String full_classname_with_suffix = full_classname + ".class";
		for (int i = 0; found_jar_entry == null && i < files.length; i++) {
			final File dir_file = files[i];
			final String jarfile_name = dir_file.getName();
			if (jarfile_name.endsWith(".jar")) {
				try {
					jarfile = new JarFile(dir_file); // IOException
					final Enumeration<JarEntry>entries = jarfile.entries();
					// Loop thru classes of each .jar file looking for class_name 
					while(found_jar_entry == null && entries.hasMoreElements()) {
						final JarEntry jar_entry = entries.nextElement();
						// entryName looks like: "LogDroidCalls/AndroidCalls.class"
						final String entryName = jar_entry.getName();
						if (entryName.equals(full_classname_with_suffix)) {
							found_jar_entry = jar_entry;
							found_entryname = entryName;
							found_jarfile_name = jarfile_name;
						}
					}
				} catch (IOException ex) {
					bad_jarnames.addElement(jarfile_name);
					bad_jarname_errmsg = ex.toString();
				}
			}
		} // for loop

		if(found_jar_entry == null) {
			if (bad_jarnames.size() > 0) {
				System.out.println(full_classname + "was not found in any jar files in libs directory.\n" +
						"But there were errors searching the following .jar files:" +
						bad_jarnames.toString() + "\n" +
						bad_jarname_errmsg);

			}

		} else {
			// full_classname exists in JarFile jarfile in JarEntry found_jar_entry
			// Check to see if we've already processed full_classname
			final String full_classname_with_dots = full_classname.replace('/', '.');
			cn = class_info.get (full_classname_with_dots);
			if (cn == null) {
				InputStream is = null;
				try {
					// Get binary of the jar entry
					// Create a MyClassNode with its collection of asmlines etc
					// Save the MyClassNode in global class_info

					is = jarfile.getInputStream(found_jar_entry); // IOException
					final ClassParser parser = new ClassParser(is, found_entryname);
					final JavaClass javaclass = parser.parse(); // IOExceptin
					final byte[]bytes = javaclass.getBytes();

					cn = MyClassNode.verify(bytes,
							AsmOutput.NO_VERIFICATION,
							AsmOutput.ASM_OUTPUT.OUTPUT_TO_STDOUT);

					class_info.put(full_classname_with_dots, cn );

				} catch(Exception ex) {
					throw new MsgException("Failed to parse class:" + found_entryname +
							" in jarfile:" + jarfile + "\n" +
							ex.toString());
				} finally {
					try {
						if (is != null) {
							is.close();
						}
					} catch(Exception ex) {
					}
				}
			}
		}

		if (cn == null)
			logger.info(full_classname + " not found in any jar file in libs/");
		else
			logger.info("Located " + full_classname + " in libs/" + found_jarfile_name);

		return cn;
	}


	// full_classname looks like: "com.example.helloandroid.R$att"
	MyClassNode get_class (String full_classname) throws MsgException {
		File class_file = new File (class_base(full_classname).getPath() + 
				".class");
		// Check to see if we've already processed this file
		MyClassNode cn = class_info.get (full_classname);

		// If we haven't processed this, read it in and perform an initial analysis
		if (cn == null) {
			byte[] bytes = MyClassNode.classFileToByteArray(class_file); 
			cn = MyClassNode.verify(bytes, AsmOutput.NO_VERIFICATION, 
					AsmOutput.ASM_OUTPUT.OUTPUT_TO_STDOUT);
			class_info.put (full_classname, cn);
		}

		return cn;
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
		final MyClassNode cn = get_class(package_name, activity.name); // MsgExcetpion
		if (cn == null) {
			logger.info ("Warning: No class file found for manifest activity '%s' "
					+ "(package %s)", activity.name, package_name);
			return;
		}
		logger.info ("read in class file " + cn.name);

		// Process methods of cn only if cn is an "Activity" or inherits Activity
		if (classNodeIsAnAndroidActivity(cn)) {
			for (int ii = 0; ii < cn.methods.size(); ii++) {
				MethodNode m = (MethodNode) cn.methods.get(ii);
				logger.info ("  processing method %s (%s)", m.name, m.desc);
				process_method (activity, cn, m);
			}
		} else {
			logger.info ("Class %s not processed, it is not an Activity "
					+ " or subclass of Activity.", cn.name);
		}
	}

	/** Processes an entry point **/
	// full_classname looks like: "com.example.helladroid.HelloAndroid"
	private void process_entry (String full_classname, String method_name) 
			throws UnsupportedIdiomException, MissingElementException, MsgException {

		final MyClassNode cn;
		final File file = new File(class_base(full_classname).getPath() + ".class");
		if (file.isFile()) {
			cn = get_class (full_classname);
		} else {
			cn = search_application_lib_for_class(full_classname);
		}
		if (cn == null)
			throw new MissingElementException ("Class not found: " + full_classname);

		MethodNode m = get_method (cn, method_name);
		if (m == null) 
			throw new MissingElementException ("Method " + method_name 
					+ " not found in class " + cn.name);
		logger.info ("process entry %s.%s()", cn.name, m.name);
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
					class_name (layout.cn), view.on_click,
					view.name, layout.name, view.get_resource_name());

			//build the method signature in the soot format
			String methodSig = soot_method_signature (layout.cn, view.on_click,
					"(android.view.View)");

			//record the handler in the map for the layout
			//for the entire application there could be multiple layouts, and multiple
			//handler per layout
			if (!handlers.containsKey(layout)) 
				handlers.put(layout, new HashMap<View, String>());

			logger.info("Putting: %s %s %s\n", layout, view, methodSig);
			handlers.get(layout).put(view, methodSig);	 	

			// Its not entirely clear why we are processing the on_click entry
			// point itself.  What are we looking for here?
			try {
				process_entry (class_name (layout.cn), view.on_click);
			} catch (MissingElementException mee) {
				logger.info ("Warning, Error processing on click handler %s in "
						+ "layout %s: %s", view.on_click, layout.name, 
						mee.getMessage());
			}
		}
		for (View child : view.children)
			process_view (layout, child);
	}


	/** Returns the first method in cn named name **/
	static MethodNode get_method (MyClassNode cn, String name) {

		Visitations v = cn.getVisitations();
		for (MethodNode m : v.getMethods(cn)) {
			if (m.name.equals (name))
				return m;
		}

		return null;
	}


	/**
	 * Processes a method.  If the method is in an activity, activity should
	 * reference that activity.
	 */
	private void process_method (Activity activity, MyClassNode cn, MethodNode m) 
			throws UnsupportedIdiomException, MsgException {

		Visitations v = cn.getVisitations();
		Vector<AsmLine> alvec = v.getAsmLinesOfMethod (cn, m);
		for (AsmLine al : alvec) {
			Vector<Vector<TypeElem>> stack = al.stackSet;
			// logger.info ("opcode = %s [stack size = %d]\n", 
			//           al.getOpcodeName(), stack.size());
			if (al.getOpcode() == Opcodes.INVOKEVIRTUAL) {
				MethodInsnNode method_inst = (MethodInsnNode) al.inst;
				if (false) {
					logger.info ("invoke %s.%s (%s)\n", method_inst.owner, 
							method_inst.name, method_inst.desc);
					Type[] args = Type.getArgumentTypes (method_inst.desc);
					int top = stack.size() - 1;
					for (Type t : args) {
						Vector<TypeElem> telems = stack.get (top);
						logger.info ("  type %s: %s (%d)\n", t, telems, top);
						top--;
					}
				}
				process_invoke (cn, m, al, activity);
			}
		}
	}


	// Returns true if cn is class android/app/Activity or is a class
	// that inherits from android/app/Activity
	private boolean classNodeIsAnAndroidActivity(final MyClassNode cn) {
		final String supername_slashes = cn.superName;
		boolean retval = supername_slashes.equals ("android/app/Activity");

		if (!retval) { // cn is NOT android/app/Activity.

			// If have not already read file "activity_subclass", read
			// lines from the file into global HashSet activity_subclasses
			if (!already_read_activity_subclasses) {
				already_read_activity_subclasses = true;

				final File file = new File(System.getenv ("APAC_HOME"), 
						"peg-extract/config-files/activity_subclasses.txt");
				if (file.isFile()) {
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader (file));
						String line = null;
						while ((line = br.readLine()) != null) {
							line = line.trim();
							if (line.charAt(0) != '#' && !line.isEmpty()) {
								activity_subclasses.add(line);
							}
						}

					} catch (IOException e) {
						throw new RuntimeException ("can't open " + file, e);
					} finally {
						try {
							if (br != null)
								br.close();
						} catch (Exception ex) {
						}
					}

				} else { // file activity_subclasses.txt does not exit
					// This message will appear only once
					logger.info("WARNING: " + file.getPath() + " is missing.\n" +
							"Android application files that are subclasses of Activity will not be processed correctly.");
				}
			}

			// Determine if supername_slashes inherits from class android.app.Activity
			if (activity_subclasses.size() > 0) {
				final String supername_dots = supername_slashes.replace('/', '.');
				retval = activity_subclasses.contains(supername_dots);

				logger.info(supername_slashes +
						(retval ? " inherits" : " does not inherit") +
						" from android.app.Activity");
			}
		}

		return retval;
	}


	/** 
	 * Process an invoke opcode.  This is responsible for method call
	 * specific processing 
	 **/
	private void process_invoke (MyClassNode cn, MethodNode m, AsmLine al,
			Activity activity) throws UnsupportedIdiomException {
		MethodInsnNode method_inst = (MethodInsnNode) al.inst;

		logger.info ("process_invoke [%s] %s.%s calling %s %s", cn.superName,
				cn.name, m.name, method_inst.name, method_inst.desc);

		// If calling setContentView, remember the layout file associated with
		// this activity
		if (method_inst.name.equals ("setContentView")&&
				method_inst.desc.equals ("(I)V")) {

			Vector<TypeElem> elems = al.stackSet.get (al.stackSet.size()-1);
			if (elems.size() > 1)
				bad_idiom (cn, m, al, "Multiple sources for setContentView");
			TypeElem te = elems.get(0);
			AsmLine val_source = te.getAsmLine_thatCreatedConstVal();
			if (val_source == null)
				bad_idiom (cn, m, al, "unknown source for setContentView resource");
			AbstractInsnNode inst = val_source.inst;
			if (!(inst instanceof LdcInsnNode)) 
				bad_idiom (cn, m, al, "non constant src for setContentView resource");
			LdcInsnNode ldc = (LdcInsnNode) inst;
			int resource_id = (Integer) ldc.cst;
			if (activity == null)
				bad_idiom (cn, m, al, "setContentView outside of Activity");

			// This can happen.  We should probably change content_view to a list
			if (false && activity.content_view != 0)
				bad_idiom (cn, m, al, "Multiple setContentView calls in one Activity");

			activity.content_view = resource_id;
			logger.info ("  setContentView (%08X -> %s)", resource_id, 
					resource_info.get(resource_id));
			String resource_name = resource_info.get(resource_id);
			if (resource_name == null) 
				bad_idiom (cn, m, al, "Resource id %08X not found", resource_id);
			String layout_name = resource_name.replace ("layout.", "");
			Layout layout = find_layout_by_name (layout_name);
			if (layout == null) 
				bad_idiom (cn, m, al, "No layout named %s", layout);
			layout.activity = activity;

			// Remember the class that instantiated this view/layout
			layout.cn = cn;
			logger.info ("Found activity/class %s/%s for layout %s\n", activity, 
					cn.name, layout.name);
		}
	}


	/**
	 * Throws an UnsupportedIdiomException for the current class/method/line
	 */
	private static void bad_idiom (MyClassNode class_node,
			MethodNode method_node,
			AsmLine asmline,
			String format,  Object... args) 
					throws UnsupportedIdiomException {

		String msg = String.format (format, args);
		throw new UnsupportedIdiomException (class_node, method_node,
				asmline, msg);
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
	 * Returns a string defining the method in the soot format.
	 **/
	static String soot_method_signature (MyClassNode cn, String method, 
			String args) {
		return "<" + class_name(cn) + ": void " + method + args + ">";
	}

	/** Returns the fully specified class name (with dot separators) **/
	static String class_name (MyClassNode cn) {
		return cn.name.replace ("/", ".");
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
			String ret = manifest.resource_info.get(i); 
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
			return manifest.resource_info.inverse().get(l);
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
	public Map<Layout.View, String> getOnClickHandlers(Integer i) {
		if (resolved) {
			//find the layout
			String fullname = findLayoutName(i);
			
			//in the resource_info of application, entries are stored by component.name
			//we just want the name when searching for a layout
			String[] name_ext = fullname.split ("[.]", 2);
		    String name = name_ext[1];
		    
			if (name == null || name.equals("")) {
				Messages.print("Warning: name of layout null when analyzing setContentView()");
				return null;
			}
				
			Layout layout = manifest.find_layout_by_name(name);
			if (layout == null) {
				Messages.print("Warning: cannot find layout when analyzing setContentView()");
				return null;
			}
			
			HashMap<Layout.View, String> handlers = manifest.handlers.get(layout);
			if (handlers == null) 
				return new HashMap<Layout.View, String>();
			return handlers;
			
		} else  {
			//Messages.print("Unresolved!");
			return null;
		}
	}
	
}
