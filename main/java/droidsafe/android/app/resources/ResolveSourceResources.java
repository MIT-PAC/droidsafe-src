package droidsafe.android.app.resources;

import java.io.File;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import droidblaze.project.Droidblaze;
import droidblaze.project.Messages;
import droidblaze.project.Project;
import droidblaze.project.analyses.DroidblazeAnalysis;
import droidsafe.analyses.resources.AndroidManifest.Activity;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.speclang.utils.*;

@Droidblaze(
		name         = "resources",
		consumes     = { "appjar", "harness"},
		produces     = "srcres",
		namesOfTypes = { "srcres" },
		types        = { SourceResources.class }
		)

public class ResolveSourceResources extends DroidblazeAnalysis {
	static String blanks = "                                               ";

	public void run() {
		SourceResources                srcres = (SourceResources) Project.g().getTrgt("srcres");


		String appRoot = System.getProperty("droidsafe.approot");

		if (appRoot == null) {
			//no application root defined, so don't try to resolve the source xml resources
			Messages.log("No application source root given.  No source resources resolved. Use -Ddroidsafe.approot to define application root.");
		} else {
			try {
				srcres.setManifest(resolveManifest(appRoot));
			} catch (Exception e) {
                Messages.log(e.toString());
				Messages.log(Utils.getStackTrace(e));
				Messages.print(Utils.getStackTrace(e));
				Messages.log("!!! Error resolving resourses !!!");
				srcres.setResolved(false);
				Messages.fatal("");
			}
		}
	}

	private Application resolveManifest(String rootDir) throws Exception {
		Application app = new Application (new File (rootDir));
		
		// Dump manifest information
		AndroidManifest am = app.manifest;
		Messages.log ("Manifest = %s\n", am.manifest);
		Messages.log ("appliction = %s\n", am.application);
		Messages.log ("Activities: \n");
		for (Activity a : am.activities) {
			Messages.log ("  %s\n", a);
		}

		// Dump layout information
		Messages.log ("\nLayouts:\n");
		for (Layout l : app.layouts) {
			Messages.log ("  layout %s: %s\n", l.name, l.view);
		}

   		String package_name = am.manifest.package_name;

		// Process the activities of the application
		for (Activity a : app.manifest.activities)
			app.process_activity (a);

		// Process all of the layouts
		for (Layout l : app.layouts) {
			Messages.log ("  Processing layout %s\n", l.name);
			app.process_view (l, l.view);
		} 
		
		return app;
	}

	static void dump_node (Node n, int indent) {

		String tab = blanks.substring (0, indent);

		if (n.getNodeType() == Node.TEXT_NODE) {
			// text nodes appear to be any text that occurs between real nodes.
			// This is pretty uninteresting, so just skip them
			// Messages.log ("%sText Node %s, %s\n", tab, n.getNodeValue(), 
			//                   n.getTextContent());
		} else {
			Messages.log ("%sNode %s [%s]\n", tab, n.getNodeName(), 
					node_type(n));
		}

		// Print out the attributes (if any)
		NamedNodeMap attributes = n.getAttributes();
		if (attributes != null) {
			for (int ii = 0; ii < attributes.getLength(); ii++) {
				Node attr = attributes.item (ii);
				Messages.log ("%s  attribute %s = %s\n", tab, attr.getNodeName(), 
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
