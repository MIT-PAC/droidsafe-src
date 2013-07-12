package droidsafe.android.app.resources;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;

import droidsafe.analyses.CallGraphFromEntryPoints;

import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.AndroidManifest.Provider;
import droidsafe.android.app.resources.AndroidManifest.Receiver;
import droidsafe.android.app.resources.AndroidManifest.Service;
import droidsafe.android.app.resources.Layout.View;
import droidsafe.android.app.resources.XmlFile;
import droidsafe.android.system.Components;

import droidsafe.utils.SootUtils;

import java.io.*;

import java.util.*;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.*;

import soot.jimple.AbstractStmtSwitch;
import soot.jimple.IntConstant;
import soot.jimple.internal.JAssignStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.VirtualInvokeExpr;

import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Modifier;

import soot.tagkit.ConstantValueTag;
import soot.tagkit.IntegerConstantValueTag;
import soot.tagkit.Tag;

import soot.util.Chain;

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
	
	/** keep a map of viewgroup/layout name => "viewGroup" (view with children) */ 
	Map<String, View> viewgroupTable = new HashMap<String, View>();
  
  // string name to RString List mappings: created while parsing.  Store multiple values in the list
	HashMap<String, Set<RString>> stringNameToRStringSet = new HashMap<String, Set<RString>>();
  
  // Stores string array name to RStringArray mapping that we create while parsing resource files in res/values
	HashMap<String, RStringArray> stringArrayNameToRStringArray = new HashMap<String, RStringArray>();
	
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
	
	public AndroidManifest getManifest() {
		return manifest;
	}

	HashMap<String, RString> stringNameToRString;

	public HashMap<String, RString> getStringNameToRStringHashMap() {
		if (stringNameToRString == null) {
			stringNameToRString = new HashMap<String, RString>();
			for (String key: stringNameToRStringSet.keySet()) {

				Iterator<RString> iter = stringNameToRStringSet.get(key).iterator();	
				if (iter.hasNext())
					stringNameToRString.put(key, iter.next()); 
			}
		}
		return this.stringNameToRString;
	}

	public HashMap<String, Set<RString>> getStringNameToRStringListHashMap() {

		return this.stringNameToRStringSet;
	}

	public HashMap<String, RStringArray> getStringArrayNameToRStringArrayHashMap() {
		return this.stringArrayNameToRStringArray;
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

			String package_name = am.manifest.package_name;

			// Process the activities of the application
			for (Activity a : v.manifest.activities) {
				v.process_activity (a);
				a.setSootClass(a.name);
				am.components.add(a.getSootClass());
			}

			// combine and remove unneeded layout
			v.consolidateLayouts();

			// Process all of the layouts
			for (Layout l : v.layouts) {
				logger.info ("  Processing layout {}\n", l.name);
				v.process_view (l, l.view);
			}
			
			//set all the underlying soot classes for the components 
			//other than activity
			for (Service s : v.manifest.services) {
				s.setSootClass(s.name);
				am.components.add(s.getSootClass());
			}

			for (Provider p : v.manifest.providers) {
				p.setSootClass(p.name);
				am.components.add(p.getSootClass());
			}

			for (Receiver r : v.manifest.receivers) {
				r.setSootClass(r.name);
				am.components.add(r.getSootClass());
			}

			//check that all source components are in the manifest
			for (SootClass clazz : droidsafe.android.app.Hierarchy.v().getAllAppComponents()) {
				if (!clazz.isAbstract() && !am.components.contains(clazz)) {
					logger.warn("\nComponent class not defined in manifest, please add to manifest: {}\n", clazz);
				}
			}		

			//build soot xml object
			v.buildXMLSootObjects();

			v.resolved = true;
		} catch (Exception e) {
			logger.error("Error resolving resources and manifest: {}", e);
		}
	}
	
	/**
	 * resolve all includes within a layout.  We will copy all the include stuff over
	 * @param myLayout
	 */
	private void resolveLayoutInclude(Layout layout) {
	    List<View> includeList = new LinkedList<View>();
	    
	    // walk through all children view, resolve any include
	    logger.warn("dumping layout {}, childrend list {} ", layout.name, layout.view.children);
	    
	    for (View view: layout.view.children) {
	        logger.warn("layout/view {}:{}: ", layout.name, view.name);
	        
	        if (!view.name.equals("include")) {
	            continue;
	        }
	        
	        logger.warn("Found include view {} in layout {} ", view, layout.name);
	        if (view.attr_exists("layout")) {
	            String layoutName = view.get_attr("layout");
	            logger.warn("include layout {} ", layoutName);
	        }
	    }
	}
	
	/**
	 * consolidate layouts:  Will go through differnt versions of layouts 
	 */
	private void consolidateLayouts() {
	    logger.info("consolidate layouts ");
	    List<Layout> origList = new LinkedList<Layout>();
	    
	    // building the original layout list which is meant to be read only
	    for(Layout layout: layouts) {
	        origList.add(layout);
	    }
	    
	    // use the map to keeps 
	    Map<String, Layout> layoutMap = new HashMap<String, Layout>();
	    
	    for (Layout layout: origList) {
	        // if layout first appeared, added to the hash
	        if (!layoutMap.containsKey(layout.name)) {
	            layoutMap.put(layout.name, layout);
	            continue;
	        }
	        
	        Layout keptLayout = layoutMap.get(layout.name);
	        logger.info("will merge layout {} to {} ", layout, keptLayout);
	        logger.info("{} <=> {} ", layout.view, keptLayout.view);
	        
	        // going through
	        for (View childView: layout.view.children) {
	            
	            if (childView.name == null) {
	                logger.info("childView.name is NULL {}", childView);
	                continue;
	            }
	            // check if the kept layout already has childredn
	            boolean alreadyInList = false;
	            for (View currentView: keptLayout.view.children) {
	                if (currentView.name == null) {
	                    continue;
	                }
	                
	                // compare name, and id of view between 2 layouts
	                if (currentView.name.equals(childView.name) &&
	                        ((currentView.id == childView.id) || 
	                                (currentView.id != null && childView.id != null && 
	                                 currentView.id.equals(childView.id)))) {
	                    alreadyInList = true;
	                    break;
	                }
	            }
	            
	            // if not in the keptlayout, add the child view in
	            if (alreadyInList == false) {
	                logger.info("*** view {} will be part of layout {} ", childView.name, layout.name);
	                keptLayout.view.children.add(childView);
	            }
	        }
	        
	        
	        logger.info("Layout {} has been MERGED ", layout.name);
	        layouts.remove(layout);
	    }
	    
	    for (Layout layout: layouts) {
	        logger.info("layout.name {}, layout.view.id {} ", layout.name, layout.view.id);
	        
	        if (layout.view.children.size() > 0) {
	            if (layout.name != null) {
	                String key = layout.name;
	                viewgroupTable.put(key, layout.view);
	                logger.info("adding viewgroup {}, key {} ", layout.view.name, key);
	            }
	        }
	    }
	}
	
	
	/** Processes the application located in the specified directory **/
	public Resources (File application_base) throws Exception {

		this.application_base = application_base;

		resource_info = HashBiMap.create();
		logger.info("Resources(): " + application_base.toString());

		// Get the manifest and read it
		File manifest_file = new File (application_base, "AndroidManifest.xml");

		manifest = new AndroidManifest (manifest_file);
		package_name = manifest.manifest.package_name;

		File resource_dir = new File(application_base, "res");

		//Take care of "res/layout" folder
		//TODO: dealing with different layout flavors???
		File[] layout_dirs = resource_dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					boolean matched = name.startsWith("layout") ||
									  name.startsWith("Layout") ;
						logger.debug("file {}, string {}, matched {} ", dir, name, matched);
						return matched;
					} 

		});
		for (File layout_dir: layout_dirs) {
			logger.info("processing layout {}", layout_dir);
			if (layout_dir.exists()) {
				for (File layout_source : layout_dir.listFiles()) {
					logger.info("***considering layout file {}", layout_source);
					String name = layout_source.getName();
					String[] name_ext = name.split ("[.]", 2);
					// logger.info ("name/ext = {}/{}", name_ext[0], name_ext[1]);
					if (name_ext[1].equals ("xml")) {
					    Layout layout = new Layout(layout_source);
						layouts.add (layout);
						
					    logger.info("layout {} => has {} views ", layout.name, layout.view.children.size());
						logger.info("layouts length {} ", layouts.size());
						logger.info("Dumping layout ");
						logger.info("{} view", layout.view);
					}
				}
			}
		}

		// Dealing with res/values, and res/values-v15*******
		File[] values_dirs = resource_dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					boolean matched = name.startsWith("values") ||
									  name.startsWith("Values") ;
						logger.debug("file {}, string {}, matched {} ", dir, name, matched);
						return matched;
					} 
				});

		logger.info("{} value dirs exist", values_dirs.length);

		for(File values_dir : values_dirs) {
			// Process .xml files in res/values
			for (File value_source : values_dir.listFiles()) {
				logger.info("processing {} ", value_source.getName());
				String[] name_ext = value_source.getName().split ("[.]", 2);
				if (name_ext[1].equals ("xml")) {
					process_values(new XmlFile(value_source.getPath()));
				}
			}
		}

		// Read in the resource id to name map
		read_resources();
		
		//adding system default resources
		String resourceName = "android.R.string.untitled";
		resource_info.put(new Integer(0x0104000f), resourceName);
		RString rString = new RString("");
		Set<RString> valueSet = new HashSet<RString>();
		valueSet.add(rString);
		stringNameToRStringSet.put(resourceName, valueSet);
		
	}

	/**
	 * buildXMLSootObjects():
	 * 		This method builds internal UI Objects for use in soot analysis
	 */
	public void buildXMLSootObjects() {
	    // Add This point, all resrouces will have been parsed and loaded
		ResourcesSoot.v().setNumberToStringMap(resource_info);
		ResourcesSoot.v().setStringToValueSetMap(stringNameToRStringSet); 
		for (Layout layout: layouts) {
		    // build all getView_ID for all possible values of IDs
			layout.buildViews(stringNameToRStringSet);
			
			// build the method that instantiates view objects
			Integer layoutNumericId = resource_info.inverse().get(layout.view.id);
			if (layoutNumericId == null) {
			    logger.warn("Layout has no viewID, skipped");
			    continue;
			}
			
			// Challenge: there maybe different flavors of layouts 
			
			layout.buildInitLayout();
			
		}
        // Anything other than view need to be built and injected???

	}

	/**
	 * Takes in an xml files and processes the following values from it:
	 *  - string (stores them in HashMap<String, RString> stringNameToRStringSet
	 *  - string-array (stores them in HashMap<String, RString> stringNameToRStringSetArray
	 * TODO: add support for colors, dimensions, typed arrays and styles.
	 * @param xmlFile an XmlFile instance that we treat as a source of values (e.g. res/values/arrays.xml)
	 */
	void process_values(XmlFile xmlFile) {
		logger.info("Processing values from {}", xmlFile);

		BaseElement baseElement = new BaseElement(xmlFile.getDocumentElement(), null);
		List<Node> children = baseElement.gather_children();

		// process strings
		// IMPORTANT: this must execute fully before we process string-arrays because some string values in a string array
		// can be string names. We want to substitute the values in instead but don't have them all until this finishes
		for(int i = 0; i < children.size(); ++i){
			Element element = (Element)children.get(i);
			String tagName = element.getTagName();

			if (tagName.equals("string")){
				Node firstChild = element.getFirstChild();
				if (firstChild != null) {
					logger.debug("firstChild {} ", firstChild);
					String stringValue = firstChild.getNodeValue();
					// create an instance of our internal representation of the android string - RString
					RString rString = null;
					try{
						rString = new RString(element, xmlFile, stringValue);
					} catch (InvalidPropertiesFormatException e) {
						logger.error("String {} is not formatted correctly in {} : {}", element, xmlFile, e);
						continue;
					}
					// the name automatically gets assigned during xml parsing
					String stringName = rString.name;
					logger.debug("name: {} ", stringName);

					//normalize stringname
					if (stringName.startsWith("android:")) {
						stringName = stringName.substring("android:".length());
					}
					if (stringName.startsWith("@+")) {
						stringName = stringName.substring(2);
					}

					if (stringName.startsWith("@")) {
						stringName = stringName.substring(1);
					}

					stringName = "string." + stringName;

					logger.debug("Adding a string name to string value mapping: ({}:{})", 
							stringName, stringValue);

					Set<RString> valueSet = stringNameToRStringSet.get(stringName);
					if (valueSet == null) {
						valueSet = new HashSet<RString>();
						stringNameToRStringSet.put(stringName, valueSet);
					}
					valueSet.add(rString);
				}
			}
		}

		// process string arrays
		for(int i = 0; i < children.size(); ++i){
			Element element = (Element)children.get(i);
			String tagName = element.getTagName();

			if (tagName.equals("string-array")){
				// get the value of the string-array, a List<string>
				NodeList stringArrayNodes = element.getChildNodes();
				List<String> stringArrayValues = new ArrayList<String>();

				for (int j = 0; j < stringArrayNodes.getLength(); ++j) {
					Node child = stringArrayNodes.item(j);
					if(child instanceof Element){
						Element childElement = (Element)child;
						Node firstChild = childElement.getFirstChild();
						if(firstChild!= null){
							String stringArrayValue = firstChild.getNodeValue();
							int index = stringArrayValue.indexOf("@string");

							String stringName = null;
							if (index >= 0 )
								stringName = stringArrayValue.substring("@string".length()+1, stringArrayValue.length());
							if((index >= 0) && stringNameToRStringSet.containsKey(stringName)){
								logger.debug("Expanding string {} to put in string array ", stringName);
								// Expand the stringlist and put them to string array 
								for (RString rString: stringNameToRStringSet.get(stringName)) {
									stringArrayValues.add(rString.value);
								}
							}
							else {
								stringArrayValues.add(stringArrayValue);
							}
						}
					}
				}
				// create an instance of our internal representation of the android string-array - RStringArray
				RStringArray rStringArray = null;
				try{
					rStringArray = new RStringArray(element, xmlFile, stringArrayValues);
				} catch (InvalidPropertiesFormatException e) {
					logger.error("string-array {} is not formatted correctly in {} : {}", element, xmlFile, e);
					continue;
				}
				// the name automatically gets assigned during xml parsing
				String stringArrayName = rStringArray.name;

				stringArrayNameToRStringArray.put(stringArrayName, rStringArray);
				logger.info("\nAdding a string-array name to string-array value mapping: ({}:{})", stringArrayName, stringArrayValues);

			}
		}
	}

	/** 
	 * Reads all of the resources ids defined in R and adds them 
	 * to resource info.  The map is from the resource id to the
	 * name of the resource (eg, 0x7F030000 -> layout.main)
	 * ALSO: it removes default constructors <init> from all autogenerated 
	 **/
	void read_resources () throws Exception {

		//find all classes that start with R$ and assume they are 
		//generated resource classes
		// for (SootClass clz : Scene.v().getClasses()) {
		for (SootClass clz : Scene.v().getApplicationClasses()) {
			/* We skip internal android stuff */
			if (clz.getName().startsWith("android.R$"))
				continue;

			String shortName = clz.getShortName();
			if (shortName.equals("BuildConfig") || shortName.equals("R")) {
				SootUtils.removeNonstaticMethods(clz);
				continue;
			}

			if (clz.getShortName().startsWith("R$")) {
				String component = clz.getShortName().substring(2);

				logger.debug("R component {} ", component);
				//Remove nonstatic method inside a static class
				//Resources R$xyz is a static class and it SHOULD NOT have any non static method
				SootUtils.removeNonstaticMethods(clz);

				for (SootField field : clz.getFields()) {
					logger.debug("field : {} ", field);
					Integer value = new Integer(0);

					Tag tag = field.getTag("IntegerConstantValueTag");
					//ug, the initializer value is stored in a tag
					//not documented anywhere...except a mailing list post from years ago
					if (tag instanceof IntegerConstantValueTag) {
						value = new Integer(((IntegerConstantValueTag)tag).getIntValue());
						logger.debug("field {}.{} = {}", component, field, 
								String.format("%08X", value));

						String resource_value = component + "." + field.getName();
						if (resource_info.get(value) != null) {
							logger.warn("resource_info.put({}, {}) ALREADY existed ", 
							            String.format("%08x", value), resource_value); 
						}
						else {
							logger.info("ADDING resource_info.put({}, {}) ", 
							           String.format("%08x", value), resource_value); 
							resource_info.put(value, resource_value);
						}
					}
					else {
						logger.info("Unknown initial value for field of resource class: {} {}", field.getName(), tag);
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
			droidsafe.main.Main.exit(1);
		}
		
		//NOTE: do we want to read in all methods????????

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
	/*
	private void process_entry (SootClass cn, String methSubSig) 

		throws UnsupportedIdiomException, MissingElementException {
			SootMethod m = cn.getMethod(methSubSig);

			if (!cn.declaresMethod(methSubSig) || m == null) 
				throw new MissingElementException ("Method " + methSubSig 
						+ " not found in class " + cn);
			logger.info ("process entry {}.{}()", cn, m);
			process_method (null, cn, m);
		}
	*/

	/**
	 * Processes any entry points (onClick attributes) specified in this
	 * view or any of its children
	 */
	void process_view (Layout layout, View view) throws Exception {

		logger.info ("  processing view {}.{}", layout.name, view.name);
		String id = view.get_attr("id");
		
		if (id == null) {
		    logger.info("No id for view {} ", view.name);
		}
		
		// Block to extract on_click signature 
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
				String signature = "<" + cn + ": void " + view.on_click + "(android.view.View)>";
				view.on_click = signature;
				logger.debug("Replace onclick signature {} ", view.on_click);
			}
		}
		
		//block to skip requestFocus tag => delete it
		//requestFocus tag can be inside a view, if so, we remove the subview
		if (view.children.size() == 1 &&  view.children.get(0).name.equals("requestFocus")) {
		    logger.info("Detected requestFocus for view {} ", view.name);
		    view.children.clear();
		}
		
		
		//block to handle include tag.  If there is, we will do replacement of include with 
		//clones of individual views
		
		// use the original list so that we can iterate over
		List<View> originalList = new LinkedList<View>();
		for (View child: view.children) {
		    originalList.add(child);
		}
		
		// iterate over original list and perform include replace ment
		for (View child : originalList) {
		    //we filter out childview with no attributes
		    if (child.getAttributes().size() == 0) {
		        logger.warn("View {} has no attribute ", child.name);
		        continue;
		    }
		    
		    // skip view that was filtered in earlier phase
		    if (!view.children.contains(child))
		        continue;
		    
		    if (child.name.equals("include") && child.attr_exists("layout")) {
		        String includeName = child.get_attr("layout");
		        
		        includeName = includeName.replace("@layout/","");
		        logger.info("**include layout {} in {} ", includeName, layout.name); 
		        
		        if (viewgroupTable.containsKey(includeName)) {
		            View viewgroup = viewgroupTable.get(includeName);
		            logger.info("**** included layout is found ");
		            logger.info("{}", viewgroup);
		            
		            // swapout included element with its children list
		            view.children.remove(child);
		            
		            // add all members inside the include view to the current group
		            for (View newMember: viewgroup.children) {
		                view.children.add((View)newMember.clone());
		            }
		        }
		    }
		    
			process_view (layout, child);
		}
	}


	/**
	 * Processes a method.  If the method is in an activity, activity should
	 * reference that activity.
	 */
	private void process_method (final Activity activity, final SootClass cn, final SootMethod m) 
		throws UnsupportedIdiomException {
			//find all invoke calls in method...
			StmtBody stmtBody = null;

			try {
				stmtBody = (StmtBody)m.retrieveActiveBody();
			} catch (Exception e) {
				logger.debug("No active body for {}", m);
				return;
			}

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
				droidsafe.main.Main.exit(1);
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
	    /*
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
		*/
	    return null;
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
