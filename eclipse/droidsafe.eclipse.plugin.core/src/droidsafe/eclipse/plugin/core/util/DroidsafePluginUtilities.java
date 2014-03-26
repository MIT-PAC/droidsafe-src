package droidsafe.eclipse.plugin.core.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.SubActionBars;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import droidsafe.android.app.Project;
import droidsafe.eclipse.plugin.core.Activator;
import droidsafe.eclipse.plugin.core.view.spec.TreeElementLabelProvider;
import droidsafe.main.Config;
import droidsafe.speclang.model.CodeLocationModel;
import droidsafe.speclang.model.HotspotModel;
import droidsafe.speclang.model.MethodArgumentModel;
import droidsafe.speclang.model.MethodModel;
import droidsafe.speclang.model.SecuritySpecModel;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.transforms.objsensclone.CloneInheritedMethods;
import droidsafe.utils.SourceLocationTag;

public class DroidsafePluginUtilities {

    /**
     * Standard logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(DroidsafePluginUtilities.class);

    /**
     * Id for the markers to be added to the Android app files.
     */
    public static final String DROIDSAFE_MARKER_ID = Activator.PLUGIN_ID + ".droidsafemarker";

    /**
     * Returns the relative path for a fully qualified classname. Adds "src/" before the pathname for
     * the class. Strips away internal class names.
     */
    public static String classNamePath(String className) {
        // change package separator (.) into path separator
        String filename = className.replace(".", File.separator);
        // Remove any internal classes from the name
        filename = filename.replaceFirst("[$][0-9]+", "");
        if (filename.indexOf("$") > 0) {
            filename = filename.substring(0, filename.indexOf("$"));
        }
        return "src" + File.separator + filename + ".java";
    }

    /**
     * Returns the Java source file with the given class name in the given project.
     */
    public static IFile getFile(IProject project, String className) {
        String classPath = classNamePath(className);
        IFile file = project.getFile(classPath);
        IPath path = file.getLocation();
        if (path.toFile().exists())
            return file;
        return null;
    }

    /**
     * Returns the Java file store with the given class name in the file system.
     */
    public static IFileStore getFileStore(String className) {
        String classPath = getApacHome() + "/modeling/api/"+classNamePath(className).substring(4);
        java.io.File localFile = new java.io.File(classPath);
        if (localFile.exists()) {
            IFileSystem fileSystem = EFS.getLocalFileSystem();
            IFileStore fileStore = fileSystem.fromLocalFile(localFile);
            return fileStore;
        }
        return null;
    }

    public static String droidsafeOutputFile(IProject project, String fileName) {
        String projectRootPath = project.getLocation().toOSString();
        String fullPath = projectRootPath + File.separator + Project.OUTPUT_DIR + File.separator + fileName;
        return fullPath;
    }
    
    /**
     * Reads the JSON object for an indicator display from the given JSON file
     */
    public static JsonObject parseIndicatorDisplay(String jsonFileName) {
        File file = new File(jsonFileName);
        if (file.exists()) {
            try {
                JsonParser jp = new JsonParser();
                JsonElement je = jp.parse(new FileReader(file));
                if (je.isJsonObject())
                    return (JsonObject) je; 
            } catch (Exception ex) {
                showError("JSON file pare error", "Error parsing the JSON file " + jsonFileName, ex);
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static void showError(String title, String msg, Exception ex) {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageDialog.openError(shell, title, msg + "\n\n" + ex);
    }

    /**
     * Returns the default editor ID for the given file name.
     */
    private static String getEditorId(String fileName) {
        IEditorDescriptor desc =
                PlatformUI.getWorkbench().getEditorRegistry()
                .getDefaultEditor(fileName);
        return desc.getId();
    }

    /**
     * Reveals and highlights the given source line for the given project in an editor. Activates  
     * the editor if the parameter 'activate' is true.
     */
    public static void revealInEditor(IProject project, SourceLocationTag line, boolean activate) {
        String className = line.getClz();
        int lineNumber = line.getLine();
        revealInEditor(project, className, lineNumber, activate);
    }

    /**
     * Reveals and highlights the given source line for the given project in an editor. Activates  
     * the editor if the parameter 'activate' is true.
     */
    public static void revealInEditor(IProject project, String className, int lineNumber, boolean activate) {
        IEditorPart openedEditor = openEditor(project, className, activate);
        if (openedEditor != null && openedEditor instanceof ITextEditor) {
            ITextEditor textEditor = (ITextEditor) openedEditor;
            IDocument document =
                    textEditor.getDocumentProvider().getDocument(
                        textEditor.getEditorInput());
            try {
                textEditor.selectAndReveal(
                    document.getLineOffset(lineNumber - 1),
                    document.getLineLength(lineNumber - 1));
            } catch (BadLocationException e) {
                error("Bad source location: line " + lineNumber + " for class " + className);
                e.printStackTrace();
            }
        }
    }

    private static void error(String errMsg) {
        //IActionBars bars = viewPart.getViewSite().getActionBars();
        //((SubActionBars)bars).activate();
        IWorkbenchPage page =
                PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage();
        IWorkbenchPart part = page.getActivePart();
        IActionBars bars = null;
        if (part instanceof IViewPart) {
            bars = ((IViewPart) part).getViewSite().getActionBars();
        } else if (part instanceof IEditorPart) {
            bars = ((IEditorPart) part).getEditorSite().getActionBars();
        }
        if (bars != null) {
            bars.getStatusLineManager().setErrorMessage(errMsg);
        }
        logger.debug(errMsg);
    }

    /**
     * Reveals and highlights the given method argument or receiver for the given project in an editor.  
     * Activates the editor if the parameter 'activate' is true.
     */
    public static void revealInEditor(IProject project, MethodArgumentModel methArg, boolean activate) {
        MethodModel method = methArg.getMethod();
        SourceLocationTag line = getLine(method);
        if (line != null) {
            String className = line.getClz();
            IEditorPart openedEditor = openEditor(project, className, activate);
            if (openedEditor != null && openedEditor instanceof ITextEditor) {
                ITextEditor textEditor = (ITextEditor) openedEditor;
                IDocument document =
                        textEditor.getDocumentProvider().getDocument(
                            textEditor.getEditorInput());
                int lineNumber = line.getLine();
                boolean isDecl = method.getLines().isEmpty();
                IRegion region = getRegion(document, methArg, line, isDecl);
                try {
                    int offset = (region == null) ? document.getLineOffset(lineNumber - 1) : region.getOffset();
                    int length = (region == null) ? document.getLineLength(lineNumber - 1) : region.getLength();
                    textEditor.selectAndReveal(offset, length);
                } catch (BadLocationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Reveals and highlights the given method argument or receiver for the given project in an editor.  
     * Activates the editor if the parameter 'activate' is true.
     */
    public static void revealInEditor(IProject project, MethodModel method, boolean activate) {
        SourceLocationTag line = getLine(method);
        if (line != null) {
            revealInEditor(project, line, activate);
        }
    }

    public static SourceLocationTag getLine(MethodModel method) {
        List<CodeLocationModel> lines = method.getLines();
        SourceLocationTag line = null;
        if (lines.isEmpty()) {
            line = method.getDeclSourceLocation();
        } else {
            line = lines.get(0);
        }
        return line;
    }

    /**
     * A map that caches computed highlight regions for method arguments.
     */
    private static Map<MethodArgumentModel, IRegion> methodArgumentRegionMap = new HashMap<MethodArgumentModel, IRegion>();

    /**
     * Returns the highlight region for the given method argument.
     */
    private static IRegion getRegion(IDocument document, MethodArgumentModel methArg, SourceLocationTag loc, boolean isDecl) {
        IRegion region = methodArgumentRegionMap.get(methArg);
        if (region == null) {
            int line = loc.getLine() - 1;
            try {
                region = (isDecl) ?
                        getRegionForDecl(document, methArg, line - 1) :
                            getRegionForCall(document, methArg, line);
                        if (region == null)
                            region = new Region(document.getLineOffset(line), document.getLineLength(line));
                        methodArgumentRegionMap.put(methArg, region);
            } catch (BadLocationException e) {
                String className = loc.getClz();
                logger.debug("Exception while revealing line {} for class {}", line + 1, className);
                e.printStackTrace();
            }
        }
        return region;
    }

    /**
     * Computes and returns the highlight region for the given method parameter in the method declaration.
     */
    private static IRegion getRegionForDecl(IDocument document, MethodArgumentModel methodArg,
                                            int line) throws BadLocationException {
        MethodModel method = methodArg.getMethod();
        String methodName = method.getMethodName();
        int end = document.getLineOffset(line) + document.getLineLength(line) - 1;
        String text = document.get(0, end);
        int index = text.lastIndexOf(methodName);
        int startLine = document.getLineOfOffset(index);
        String regex = "(^|(.*)?\\s+)(" + methodName + ")\\s*\\((.*\\)).*\\{.*";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        boolean matched = false;
        int offset;
        IRegion region = null;
        while (startLine > 0 && !matched) {
            offset = document.getLineOffset(startLine);
            String str = text.substring(offset);
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                matched = true;
                if (methodArg.isReceiver()) {
                    region = new Region(offset, document.getLineLength(startLine));
                } else {
                    int argIndex = methodArg.getArgumentIndex();
                    int start = matcher.start(4);
                    str = str.substring(start, matcher.end(4));
                    region = getRegionForParameter(str, offset + start, 0, argIndex);
                }
            } else {
                startLine--;
            }

        }
        return region; 
    }

    /**
     * Computes and returns the highlight region for the given method parameter.
     */
    private static IRegion getRegionForParameter(String input, int offset, int start, int argIndex) {
        while (input.charAt(start) == ' ')
            start++;
        int curPos = start;
        int levels = 0;
        int curArgIndex = 0;
        while (curArgIndex <= argIndex && curPos < input.length()) {
            char ch = input.charAt(curPos++);
            switch (ch) {
                case '<':
                    levels++; 
                    break;
                case '>':
                    levels--;
                    break;
                case ')':
                    if (levels == 0) {
                        if (curArgIndex == argIndex) {
                            int length = curPos - start - 1;
                            return new Region(offset + start, length);
                        } else {
                            return null;
                        }
                    } else {
                        levels--;
                    }
                    break;
                case ',':
                    if (levels == 0) {
                        if (curArgIndex == argIndex) {
                            int length = curPos - start - 1;
                            return new Region(offset + start, length);
                        } else {
                            curArgIndex++;
                            while (input.charAt(curPos) == ' ')
                                curPos++;
                            start = curPos;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    /**
     * Computes and returns the highlight region for the given method argument/receiver in a method
     * call.
     */
    private static IRegion getRegionForCall(IDocument document, MethodArgumentModel methodArg, int line) throws BadLocationException {
        int offset = document.getLineOffset(line);
        int length = document.getLineLength(line);
        String str = document.get(offset, length);
        MethodModel method = methodArg.getMethod();
        String methodName = method.getMethodName();
        boolean hasReceiver = method.getReceiverType() != null;
        String regex = (hasReceiver) ?
                "(.*\\s)?(\\S+)\\.\\s*" + methodName + "\\s*\\((.*)" :
                    "(^|(.*)?(\\W+)" + methodName + "\\s*\\((.*)";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(str);
        IRegion region = null;
        if (matcher.matches()) {
            region = (methodArg.isReceiver()) ?
                    getRegionForReceiver(str, offset, matcher.end(2) - 1) :
                        getRegionForArgument(str, offset, matcher.start(3), methodArg.getArgumentIndex()); 
        }
        return region; 
    }

    /**
     * Computes and returns the highlight region for a method receiver.
     */
    private static IRegion getRegionForReceiver(String input, int offset, int end) {
        int curPos = end;
        int levels = 0;
        int quotes = 0;
        while (curPos > 0) {
            char ch = input.charAt(curPos--);
            switch (ch) {
                case '(':
                case '[':
                case '{': 
                    if (quotes == 0)
                        levels--; 
                    break;
                case ']':
                case '}':
                case ')':
                    if (quotes == 0)
                        levels++;
                    break;
                case '"':
                    if (quotes > 0)
                        quotes--;
                    else
                        quotes++;
                case '\t':
                case ' ':
                    if (quotes == 0 && levels == 0) {
                        curPos += 2;
                        int length = end - curPos + 1;
                        return new Region(offset + curPos, length);
                    }
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    /**
     * Computes and returns the highlight region for a method argument.
     */
    private static IRegion getRegionForArgument(String input, int offset, int start, int argIndex) {
        while (input.charAt(start) == ' ')
            start++;
        int curPos = start;
        int levels = 0;
        int quotes = 0;
        int curArgIndex = 0;
        while (curArgIndex <= argIndex && curPos < input.length()) {
            char ch = input.charAt(curPos++);
            switch (ch) {
                case '(':
                case '[':
                case '{': 
                    if (quotes == 0)
                        levels++; 
                    break;
                case ']':
                case '}':
                    if (quotes == 0)
                        levels--;
                    break;
                case ')':
                    if (quotes == 0) {
                        if (levels == 0) {
                            if (curArgIndex == argIndex) {
                                int length = curPos - start - 1;
                                return new Region(offset + start, length);
                            } else {
                                return null;
                            }
                        } else {
                            levels--;
                        }
                    }
                    break;
                case ',':
                    if (quotes == 0) {
                        if (levels == 0) {
                            if (curArgIndex == argIndex) {
                                int length = curPos - start - 1;
                                return new Region(offset + start, length);
                            } else {
                                curArgIndex++;
                                while (input.charAt(curPos) == ' ')
                                    curPos++;
                                start = curPos;
                            }
                        }
                    }
                    break;
                case '"':
                    if (quotes > 0)
                        quotes--;
                    else
                        quotes++;
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    /**
     * Returns an editor on the given Java class for the given project. Activates  
     * the editor if the parameter 'activate' is true.
     */
    public static IEditorPart openEditor(IProject project, String className, boolean activate) {
        IFile file = getFile(project, className);
        IEditorPart openEditor = null;
        IWorkbenchPage page =
                PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage();
        try {
            if (file != null) {
                IEditorInput input = new FileEditorInput(file);
                String id = getEditorId(file.getName());
                openEditor = page.openEditor(input, id, activate);
            } else {
                IFileStore fileStore = getFileStore(className);;
                if (fileStore != null) {
                    IEditorInput input = new FileStoreEditorInput(fileStore);
                    String id = getEditorId(fileStore.getName());
                    openEditor = page.openEditor(input, id, activate);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (openEditor == null)
            error("Failed to find Java source for class " + className);      
        return openEditor;
    }



    /**
     * Returns the path name for Apac Home.
     */
    public static String getApacHome() {
        String apacHome = Config.v().getApacHome();
        if (apacHome == null) {
            String pluginId = Activator.PLUGIN_ID;
            Bundle bundle = Platform.getBundle(pluginId);
            try {
                File file = FileLocator.getBundleFile(bundle);
                apacHome = file.getAbsolutePath();
                Config.v().setApacHome(apacHome);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return apacHome;
    }

    /**
     * Return the terminal classname from a fully specified classname
     * 
     */
    public static String extractClassname(String fullname) {
        return fullname.replaceFirst("^.*[.]", "");
    }

    public static void removeAllDroidsafeMarkers(IProject project) {
        IMarker markers[];
        if (project != null) {
            try {
                markers = project.findMarkers(DROIDSAFE_MARKER_ID, true, IResource.DEPTH_INFINITE);
                for (IMarker marker : markers) {
                    marker.delete();
                }
            } catch (CoreException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String removeCloneSuffix(String str) {
        return CloneInheritedMethods.removeMethodCloneSuffix(ClassCloner.removeClassCloneSuffix(str));
    }


    /**
     * Creates eclipse task markers for all input events locations in the selected app.
     * 
     * @param spec The security spec.
     * @param project the Android java project for the application.
     * 
     */
    public static void generateMarkersForSecuritySpecification(IProject project) {
        if (project != null) {
            String projectRootPath = project.getLocation().toOSString();
            SecuritySpecModel spec = SecuritySpecModel.deserializeSpecFromFile(projectRootPath);
            if (spec != null) {
                generateMarkersForSecuritySpecification(spec, project);
            }
        }
    }


    /**
     * Creates eclipse task markers for all input events locations in the selected app.
     * 
     * @param spec The security spec.
     * @param project the Android java project for the application.
     * 
     */
    public static void generateMarkersForSecuritySpecification(SecuritySpecModel spec,
                                                               IProject project) {
        removeAllDroidsafeMarkers(project);
        List<MethodModel> methods = new ArrayList<MethodModel>(spec.getEntryPoints());
        Collections.sort(methods);
        Map<MethodModel, List<MethodModel>> inputEventBlocks = spec.getInputEventBlocks();
        if (inputEventBlocks != null) {
            for (MethodModel inputMethod : inputEventBlocks.keySet()) {
                SourceLocationTag line = inputMethod.getDeclSourceLocation();
                if (line != null) {
                    String clz = line.getClz();
                    String classPath = DroidsafePluginUtilities.classNamePath(clz);
                    IFile file = project.getFile(classPath);
                    int lineNbr = line.getLine() - 1;
                    if (file.exists()) {
                        try {
                            addMarkerForMethod(inputMethod, file, inputMethod.getShortSignature(), lineNbr);
                            addMarkerForMethod(inputMethod, file, inputMethod.getSignature(), lineNbr);
                            if (inputMethod.getReceiverValue() != null) {
                                addMarkerForMethod(inputMethod, file, inputMethod.getReceiverValue(), lineNbr);
                            }
                            if (inputMethod.getPermissions() != null) {
                                for (String permission : inputMethod.getPermissions()) {
                                    String message = "Permission: " + permission;
                                    addMarkerForMethod(inputMethod, file, message, lineNbr);
                                }
                            }
                        } catch (CoreException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                for (MethodModel outputMethod : inputEventBlocks.get(inputMethod)) {
                    List<CodeLocationModel> locations = outputMethod.getLines();
                    if (locations != null) {
                        for (CodeLocationModel location : locations) {
                            String clz = location.getClz();
                            String classPath = DroidsafePluginUtilities.classNamePath(clz);
                            IFile file = project.getFile(classPath);
                            int lineNbr = location.getLine();
                            if (file.exists()) {
                                try {
                                    addMarkerForMethod(outputMethod, file, outputMethod.getShortSignature(), lineNbr);
                                    addMarkerForMethod(outputMethod, file, outputMethod.getSignature(), lineNbr);
                                    if (outputMethod.getPermissions() != null) {
                                        for (String permission : outputMethod.getPermissions()) {
                                            String message = "Permission: " + permission;
                                            addMarkerForMethod(outputMethod, file, message, lineNbr);
                                        }
                                    }
                                    if (outputMethod.getReceiverValue() != null) {
                                        addMarkerForMethod(outputMethod, file, outputMethod.getReceiverValue(), lineNbr);
                                    }
                                    List<HotspotModel> hotspots = location.getHotspots();
                                    for (HotspotModel hotspot : hotspots) {
                                        addMarkerForMethod(outputMethod, file, hotspot.toString(), lineNbr);
                                    }
                                } catch (CoreException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void addMarkerForMethod(MethodModel method, IFile file, String message, int lineNbr)
            throws CoreException {
        IMarker marker = file.createMarker(DROIDSAFE_MARKER_ID);
        marker.setAttribute(IMarker.LINE_NUMBER, lineNbr);
        marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
        marker.setAttribute("methodName", method.getMethodName());
        marker.setAttribute("methodClass", method.getClassName());
        marker.setAttribute(IMarker.MESSAGE, message);
    }

    /**
     * Helper Method to load the images
     * 
     * @param file The string with the path to the image file.
     * 
     * @return An Image object corresponding to the file name.
     * 
     */
    public static Image getImage(String file) {
        Bundle bundle = FrameworkUtil.getBundle(TreeElementLabelProvider.class);
        URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
        ImageDescriptor image = ImageDescriptor.createFromURL(url);
        return image.createImage();
    }

    public static String[] enumStrings(Class<? extends Enum<?>> e) {
        Enum<?>[] values = e.getEnumConstants();
        String[] strings = new String[values.length];
        for (int i = 0; i < values.length; i++)
            strings[i] = values[i].toString();
        return strings;
    }
}

