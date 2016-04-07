/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.value;

import droidsafe.analyses.value.VAModel;

import droidsafe.main.Config;

import droidsafe.utils.SootUtils;

import japa.parser.ast.BlockComment;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.EnumDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.body.VariableDeclaratorId;
import japa.parser.ast.Comment;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.expr.BooleanLiteralExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.NullLiteralExpr;
import japa.parser.ast.expr.ObjectCreationExpr;
import japa.parser.ASTHelper;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.LineComment;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExplicitConstructorInvocationStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.TypeParameter;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.PrimitiveType.Primitive;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.type.VoidType;
import japa.parser.JavaParser;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.Modifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.jar.JarFile;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;

import soot.PrimType;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootField;

import soot.SootMethod;

import soot.tagkit.AbstractHost;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;


public class VAResultContainerClassGenerator {

    public static final List<String> PRIMITIVE_WRAPPER_CLASS_NAMES = Arrays.asList(new String[]{"Boolean",
        "Character",
           "Byte",
           "Short",
           "Integer",
           "Long",
           "Float",
           "Double"});
    public static final List<String> COLLECTION_CLASS_NAMES =
        Arrays.asList(new String[]{"BlockingDeque", "BlockingQueue", "Collection", "Deque", "List",
            "NavigableSet", "Queue", "Set", "SortedSet", "AbstractCollection",
        "AbstractList", "AbstractQueue", "AbstractSequentialList", "AbstractSet",
        "ArrayBlockingQueue", "ArrayDeque", "ArrayList", "AttributeList",
        "ConcurrentLinkedQueue", "ConcurrentSkipListSet", "CopyOnWriteArrayList",
        "CopyOnWriteArraySet", "DelayQueue", "EnumSet", "HashSet", "LinkedBlockingDeque",
        "LinkedBlockingQueue", "LinkedHashSet", "LinkedList", "PriorityBlockingQueue",
        "PriorityQueue", "Stack", "SynchronousQueue", "TreeSet", "Vector"});

    private Map<PrimitiveType.Primitive, Type> primitiveTypeConversionMap;

    private Map<String, Type> classTypeConversionMap;

    private static final Logger logger = LoggerFactory.getLogger(VAResultContainerClassGenerator.class);

    private static final Expression NULL = new NullLiteralExpr();

    private static final Expression ZERO = new IntegerLiteralExpr("0");

    private static final Expression FALSE = new BooleanLiteralExpr(false);

    private Set<String> classesAlreadyModeled;

    private Set<String> classesCurrentlyModeled = new HashSet<String>();

    private List<String> classesToBeModeled = new ArrayList<String>();

    private String classToModel;

    private String[] sourceDirs;

    private String modelSourceDir;
    private String[] modelSourceDirs;

    private String unqualifiedClassName;

    private String packageName;

    private SortedSet<String> imports;

    private String apacHome;

    private List<String> excludedClasses = Arrays.asList(new String[]{"android.view.WindowLeaked"});

    private Set<String> importsProcessed;
    private Map<BodyDeclaration, Comment> methodCodeCommentMap;
    private int nextLine;
    private List<File> generatedModels = new ArrayList<File>();
    private String sootClassPath;
    private Set<String> apiClasses;
    private Set<String> apiMethods;
    private String androidLibDir;
    private Set<String> sourceImports;
    private List<String> keywordsEndingWithS = Arrays.asList(new String[]{"extends", "implements"});
    private HashSet<String> localClassNames;
    private Map<SootClass, Set<SootField>> classesAndFieldsToModel;

    public VAResultContainerClassGenerator(String sourcePath) {
        sourceDirs = sourcePath.split(":");
        apacHome = System.getenv("DROIDSAFE_SRC_HOME");
        classesAlreadyModeled = new HashSet<String>();
        logger.debug("DROIDSAFE_SRC_HOME = {}", apacHome);
        if (apacHome == null) {
            logger.error("Environment variable $DROIDSAFE_SRC_HOME not set!");
            droidsafe.main.Main.exit(1);
        }
        modelSourceDir = constructPath(apacHome, "src", "gen");
        modelSourceDirs = new String[]{modelSourceDir};
        androidLibDir = constructPath(apacHome, Config.ANDROID_LIB_DIR_REL);
        loadAPIClasses();
        this.classesAndFieldsToModel = getClassesAndFieldsToModel(false);
    }

    public static boolean hasDSVAModeledAnnotation(AbstractHost ah) {
        for (Tag tag : ah.getTags()){
            if (tag instanceof VisibilityAnnotationTag) {
                VisibilityAnnotationTag vat = (VisibilityAnnotationTag)tag;
                for (AnnotationTag at : vat.getAnnotations()) {
                    if (at.getType().contains("droidsafe/annotations/DSVAModeled")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param forDisplay    If true, does not filter out non-primitive fields
     * @return    a map of sootClasses to sets of sootFields that are annotated to be resolved in the api model
     */
    public static Map<SootClass, Set<SootField>> getClassesAndFieldsToModel(boolean forDisplay) {
        Map<SootClass, Set<SootField>> classesAndFieldsToModel = new HashMap<SootClass, Set<SootField>>();

        String apiModelJarFilePath = constructPath(Config.v().getApacHome(), Config.ANDROID_LIB_DIR_REL, "droidsafe-api-model.jar");
        File apiModelJarFile = new File(apiModelJarFilePath);
        try {
            JarFile apiModelJar = new JarFile(apiModelJarFile);
            //get all the classes in the DroidSafe Model
            Set<SootClass> apiModelSootClasses = SootUtils.getSootClassesfromJar(apiModelJar);
            
            for (SootClass apiModelSootClass : apiModelSootClasses) {
                if(hasDSVAModeledAnnotation(apiModelSootClass)){
                    classesAndFieldsToModel.put(apiModelSootClass, new HashSet<SootField>());
                }
                for(SootField apiModelSootField : apiModelSootClass.getFields()){
                    if(hasDSVAModeledAnnotation(apiModelSootField)) {                
                        soot.Type fieldType = apiModelSootField.getType();
                        //moved up, this is needed if class has a field annotated, but the class is 
                        //not annotated.
                        if (!classesAndFieldsToModel.containsKey(apiModelSootClass)) {
                            classesAndFieldsToModel.put(apiModelSootClass, new HashSet<SootField>());
                        }
                        
                        if(fieldType instanceof RefType) {
                            RefType refType = (RefType)fieldType;
                            SootClass fieldTypeClass = ((RefType)fieldType).getSootClass();
                            if (refType.equals(RefType.v("java.lang.String")) ||
                                    refType.equals(RefType.v("java.lang.CharSequence")) ||
                                    refType.equals(RefType.v("java.lang.Class"))) {
                                //add string fields to the list of fields that are modeled!
                                classesAndFieldsToModel.get(apiModelSootClass).add(apiModelSootField);
                            } else if(!classesAndFieldsToModel.containsKey(fieldTypeClass)) {
                                classesAndFieldsToModel.put(fieldTypeClass, new HashSet<SootField>());
                            }
                        }
                        
                        if(fieldType instanceof PrimType || forDisplay) {
                            classesAndFieldsToModel.get(apiModelSootClass).add(apiModelSootField);
                        }
                    }
                }
            }
            } catch (IOException e) {
                logger.error("Could not open api model jar: " + e);
                System.exit(1);
            }
            return classesAndFieldsToModel;
    }


    private void loadAPIClasses() {
        try {
            apiClasses = new HashSet<String>();
            apiMethods = new HashSet<String>();

            String apiModelJarPath = constructPath(androidLibDir, "droidsafe-api-model.jar");
            String androidJarPath = constructPath(androidLibDir, "android-impl.jar");

            if (!new File(androidJarPath).exists()) {
                logger.error("android.jar does not exist");
                droidsafe.main.Main.exit(1);
            }

            if (!new File(apiModelJarPath).exists()) {
                logger.error("droidsafe-api-model.jar does not exist");
                droidsafe.main.Main.exit(1);
            }

            sootClassPath = apiModelJarPath + ":" + androidJarPath;

            System.setProperty("soot.class.path", sootClassPath);
            //load any modeled classes from the api model, overwrite the stub classes
            JarFile apiModeling = new JarFile(new File(constructPath(apacHome, Config.ANDROID_LIB_DIR_REL, "droidsafe-api-model.jar")));
            Set<SootClass> modeledClasses = SootUtils.loadClassesFromJar(apiModeling, true, new HashSet<String>()); 

            for (SootClass modeled : modeledClasses) {
                String clsName = modeled.getName();
                boolean anonymousInnerClass = false;
                int pos = clsName.lastIndexOf('$');
                if (pos > 0) {
                    String suffix = clsName.substring(pos);
                    try {
                        Integer.valueOf(suffix);
                        anonymousInnerClass = true;
                    } catch (NumberFormatException e) {
                    }
                }
                if (!anonymousInnerClass) {
                    apiClasses.add(clsName);
                    for (SootMethod meth: modeled.getMethods()) {
                        //apiMethods.add(meth.getSignature());
                    }
                }
            }
            //            hierarchy = new Hierarchy();
        } catch (Exception e) {
            logger.error("Error loading droidsafe-api-model.jar", e);
            droidsafe.main.Main.exit(1);
        }
    }

    private void run(String classToModel, Set<String> fieldsToModel) {
        generate(classToModel, fieldsToModel);
        while (!classesToBeModeled.isEmpty()) {
            classToModel = classesToBeModeled.remove(0);
            generate(classToModel, null);
        }
    }

    private void generate(String classToModel, Set<String> fieldsToModel) {
        this.classToModel = classToModel;
        packageName = getQualifier(classToModel);
        unqualifiedClassName = getUnqualifiedName(classToModel);
        imports = new TreeSet<String>();
        imports.add("droidsafe.analyses.value.RefVAModel");
        importsProcessed = new HashSet<String>();
        importsProcessed.add(classToModel);
        primitiveTypeConversionMap = new HashMap<PrimitiveType.Primitive, Type>();
        classTypeConversionMap = new HashMap<String, Type>();
        classesCurrentlyModeled.add(classToModel);
        SootClass sootClass = Scene.v().getSootClass(classToModel);
        if (fieldsToModel == null) {
            fieldsToModel = getFieldsToModel(sootClass);
        }
        CompilationUnit cu;
        CompilationUnit oldModelCu = null;
        try {
            File sourceFile = getJavaSourceFile(sourceDirs, classToModel);
            cu = parseJavaSource(sourceFile);
            computeMethodCodeMap(cu, sourceFile);
            String modelClass = ValueAnalysis.MODEL_PACKAGE_PREFIX + classToModel;
            if (classesAlreadyModeled.contains(modelClass)) {
                File oldModelFile = getJavaSourceFile(modelSourceDirs, modelClass);
                oldModelCu = parseJavaSource(oldModelFile);
            }
            CompilationUnit model = generateModel(cu, sootClass, fieldsToModel, oldModelCu);
            writeModel(model);
        } catch (Exception e) {
            logger.error("Failed to generate model for " + classToModel, e);
        }
    }

    private Set<String> getFieldsToModel(SootClass sootClass) {
        Set<String> fieldsToModel = new HashSet<String>();
        if (this.classesAndFieldsToModel.containsKey(sootClass)) {
            for (SootField field: this.classesAndFieldsToModel.get(sootClass)) {
                if (!field.isFinal())
                    fieldsToModel.add(field.getName());
            }
        }
        return fieldsToModel;
    }

    private CompilationUnit parseJavaSource(File sourceFile) throws Exception {
        logger.debug("Parsing Java source " + sourceFile + "...");
        FileInputStream in = null;
        CompilationUnit cu = null;
        in = new FileInputStream(sourceFile);
        cu = JavaParser.parse(in);
        nextLine = 1;
        return cu;
    }

    private File getJavaSourceFile(String[] sourceDirs, String className) throws IOException {
        for (String sourceDir: sourceDirs) {
            File javaFile = getJavaSourceFile(sourceDir, className);
            if (javaFile != null)
                return javaFile;
        }
        throw new IOException("Failed to find Java source file for " + className);

    }

    private File getJavaSourceFile(String sourceDir, String className) {
        File javaFile = constructFile(sourceDir, className.replace(".", File.separator) + ".java");
        return (javaFile.exists()) ? javaFile : null;
    }

    private void computeMethodCodeMap(CompilationUnit cu, File javaFile) throws IOException {
        methodCodeCommentMap = new HashMap<BodyDeclaration, Comment>();
        BufferedReader reader = null;
        List<TypeDeclaration> types = cu.getTypes();
        reader = new BufferedReader(new FileReader(javaFile));
        nextLine = 1;
        for (TypeDeclaration type : types) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                computeMethodCodeMap((ClassOrInterfaceDeclaration)type, reader);
            }
        }
        if (reader != null) 
            reader.close();
    }

    private void computeMethodCodeMap(ClassOrInterfaceDeclaration coi, BufferedReader reader) throws IOException {
        for (BodyDeclaration member: coi.getMembers()) {
            if (member instanceof ConstructorDeclaration) {
                Comment codeComment = getMethodCodeComment(reader, member, ((ConstructorDeclaration) member).getBlock());
                methodCodeCommentMap.put(member, codeComment);
            } else if (member instanceof MethodDeclaration) {
                BlockStmt body = ((MethodDeclaration) member).getBody();
                if (body != null) {
                    Comment codeComment = getMethodCodeComment(reader, member, body);
                    methodCodeCommentMap.put(member, codeComment);
                }
            } else if (member instanceof ClassOrInterfaceDeclaration) {
                computeMethodCodeMap((ClassOrInterfaceDeclaration)member, reader);
            }
        }
    }

    private Comment getMethodCodeComment(BufferedReader reader, BodyDeclaration member, BlockStmt block) throws IOException {
        List<Statement> stmts = block.getStmts();
        if (stmts == null || stmts.isEmpty())
            return null;
        Statement firstStmt = stmts.get(0);
        Statement lastStmt = stmts.get(stmts.size() - 1);
        Comment leadingComment = firstStmt.getComment();
        int beginLine = (leadingComment != null) ? leadingComment.getBeginLine() : firstStmt.getBeginLine();
        int beginColumn = firstStmt.getBeginColumn();
        int endLine = Math.max(member.getEndLine() - 1, lastStmt.getEndLine());
        return getMethodCodeComment(reader, beginLine, beginColumn, endLine);
    }

    private Comment getMethodCodeComment(BufferedReader reader, int beginLine, int beginColumn, int endLine) throws IOException {
        List<String> lines = new ArrayList<String>();
        StringBuffer buf = new StringBuffer("\n");
        boolean blockComment = true;
        while (nextLine < beginLine)
            readLine(reader);
        while (nextLine < endLine + 1) {
            String line = readLine(reader);
            lines.add(line);
            if (line.contains("*/")) {
                blockComment = false;
            } else {
                buf.append(line);
                buf.append("\n");
            }
        }
        if (blockComment) {
            for (int i = 0; i < beginColumn - 1; i++) {
                buf.append(' ');
            }
            return new BlockComment(buf.toString());
        } else {
            int size = lines.size();
            LineComment comment = new LineComment(lines.get(size - 1));
            LineComment curComment = comment;
            if (size > 1) {
                for (int i = size - 2; i >= 0; i--) {
                    String line = lines.get(i);
                    LineComment prevComment = new LineComment(" " + line.substring(stripIndex(line, beginColumn)));
                    curComment.setComment(prevComment);
                    curComment = prevComment;
                }
            }
            curComment.setComment(new LineComment(""));
            return comment;
        }
    }

    private int stripIndex(String line, int max) {
        max = Math.min(max, line.length());
        for (int i = 0; i < max; i++) {
            if (line.charAt(i) != ' ')
                return i;
        }
        return max;
    }

    private String readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line != null) nextLine++;
        return line;
    }

    private CompilationUnit generateModel(CompilationUnit cu, SootClass sootClass, Set<String> fieldsToModel, 
            CompilationUnit oldModelCu) throws Exception {
        logger.debug("Generating model for " + classToModel + "...");
        sourceImports = new HashSet<String>();
        addImports(cu, sourceImports);
        localClassNames = new HashSet<String>();
        CompilationUnit model = new CompilationUnit();

        String modelPackageName = ValueAnalysis.MODEL_PACKAGE_PREFIX + packageName;
        PackageDeclaration modelPkg = new PackageDeclaration(new NameExpr(modelPackageName));
        model.setPackage(modelPkg);

        if (oldModelCu != null) {
            addImports(oldModelCu, imports);
        }
        List<TypeDeclaration> types = cu.getTypes();
        List<TypeDeclaration> oldModelTypes = (oldModelCu == null) ? null : oldModelCu.getTypes();
        for (TypeDeclaration type : types) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                ClassOrInterfaceDeclaration coi = (ClassOrInterfaceDeclaration) type;
                if (coi.getName().equals(unqualifiedClassName)) {
                    ClassOrInterfaceDeclaration oldModelCoi = null;
                    if (oldModelTypes != null) {
                        for (TypeDeclaration oldType: oldModelTypes) {
                            if (oldType instanceof ClassOrInterfaceDeclaration && 
                                    oldType.getName().equals(type.getName())) {
                                oldModelCoi = (ClassOrInterfaceDeclaration) oldType;
                                break;
                                    }
                        }
                    }
                    ClassOrInterfaceDeclaration modelCoi = generateClassOrInterface(coi, sootClass, fieldsToModel, oldModelCoi);
                    if (modelCoi != null)
                        ASTHelper.addTypeDeclaration(model, modelCoi);
                }
            }
        }
        List<ImportDeclaration> importDecls = new ArrayList<ImportDeclaration>();
        removeConflictingImports();
        for (String imp: imports) {
            if (!imp.startsWith(ValueAnalysis.MODEL_PACKAGE_PREFIX + classToModel + "."))
                importDecls.add(new ImportDeclaration(new NameExpr(imp), false, false));
        }
        model.setImports(importDecls);
        removeQualifiers(model);
        return model;
    }

    private void removeQualifiers(CompilationUnit cu) {
        for (TypeDeclaration type : cu.getTypes()) {
            if (type instanceof ClassOrInterfaceDeclaration) {
                ClassOrInterfaceDeclaration coi = (ClassOrInterfaceDeclaration) type;
                removeQualifiers(coi);
            }
        }

    }

    private void removeQualifiers(ClassOrInterfaceDeclaration coi) {
        List<ClassOrInterfaceType> extendsList = coi.getExtends();
        if (extendsList != null)
            for (ClassOrInterfaceType extend: extendsList) {
                removeQualifiers(extend);
            }
        List<BodyDeclaration> members = coi.getMembers();
        if (members != null) {
            for (BodyDeclaration member : members) {
                if (member instanceof FieldDeclaration) {
                    FieldDeclaration field = (FieldDeclaration) member;
                    removeQualifiers(field.getType());
                } else if (member instanceof ConstructorDeclaration) {
                    ConstructorDeclaration constr = (ConstructorDeclaration) member;
                    removeQualifiers(constr.getParameters());
                } else if (member instanceof MethodDeclaration) {
                    MethodDeclaration method = (MethodDeclaration) member;
                    removeQualifiers(method.getParameters());
                    removeQualifiers(method.getType());
                } else if (member instanceof ClassOrInterfaceDeclaration) {
                    ClassOrInterfaceDeclaration memberCoi = (ClassOrInterfaceDeclaration) member;
                    removeQualifiers(memberCoi);
                }
            }
        }
    }

    private void removeQualifiers(List<Parameter> params) {
        if (params != null) {
            for (Parameter param: params) {
                removeQualifiers(param.getType());
            }
        }
    }

    private void removeQualifiers(Type type) {
        if (type instanceof ReferenceType)
            removeQualifiers(((ReferenceType)type).getType());
        else if (type instanceof ClassOrInterfaceType) {
            ClassOrInterfaceType coiType = (ClassOrInterfaceType)type;
            if (!localClassNames.contains(coiType.getName())) {
                ClassOrInterfaceType scope = coiType.getScope();
                if (scope != null) {
                    String qName = coiType.toString();
                    for (String imp: imports) {
                        if (imp.equals(qName) || imp.endsWith("." + qName))
                            coiType.setScope(null);
                    }
                }
            }
            List<Type> typeArgs = coiType.getTypeArgs();
            if (typeArgs != null) {
                for (Type typeArg: typeArgs)
                    removeQualifiers(typeArg);
            }
        }
    }

    private void removeConflictingImports() {
        Map<String, Set<String>> unQualifiedNameToImports = new HashMap<String, Set<String>>();
        for (String imp: imports) {
            String unqualifiedName = getUnqualifiedName(imp);
            Set<String> imps = unQualifiedNameToImports.get(unqualifiedName);
            if (imps == null) {
                imps = new HashSet<String>();
                unQualifiedNameToImports.put(unqualifiedName, imps);
            }
            imps.add(imp);
        }
        for (String unqualifiedName: unQualifiedNameToImports.keySet()) {
            Set<String> imps = unQualifiedNameToImports.get(unqualifiedName);
            if (imps.size() > 1) {
                for (String imp: imps) {
                    if (!sourceImports.contains(imp)) {
                        imports.remove(imp);
                        imports.add(imp.substring(0, imp.length() - unqualifiedName.length() - 1));
                    }
                }
            }
        }
    }

    private void addImports(CompilationUnit cu, Set<String> imps) {
        List<ImportDeclaration> impDecls = cu.getImports();
        if (impDecls != null) {
            for (ImportDeclaration impDecl: impDecls) {
                String imp = impDecl.getName().toString();
                if (!imp.contains("*"))
                    imps.add(imp);
            }
        }
    }

    private ClassOrInterfaceDeclaration generateClassOrInterface(ClassOrInterfaceDeclaration coi, 
            SootClass sootClass,
            Set<String> fieldsToModel,
            ClassOrInterfaceDeclaration oldModelCoi) throws Exception {
        if (apiClasses.contains(sootClass.getName())) {
            if (fieldsToModel == null)
                fieldsToModel = getFieldsToModel(sootClass);
            String name = coi.getName();
            int modifiers = coi.getModifiers();
            boolean isInterface = coi.isInterface();
            List<TypeParameter> coiTypeParams = coi.getTypeParameters();
            Set<String> coiTypeParamNames = typeParameterNames(coiTypeParams);
            ClassOrInterfaceDeclaration modelCoi = new ClassOrInterfaceDeclaration(modifiers, isInterface, name);
            modelCoi.setTypeParameters(coiTypeParams);
            List<ClassOrInterfaceType> extendsList = coi.getExtends();
            if (!isInterface && extendsList == null) {
                extendsList = new ArrayList<ClassOrInterfaceType>();
                extendsList.add(new ClassOrInterfaceType("RefVAModel"));
            } else {
                if (extendsList != null) {
                    if (isInterface) {
                        for (SootClass intf: sootClass.getInterfaces()) {
                            if (!excludedClasses.contains(intf.getName()))
                                collectImports(intf);
                        }
                    } else {
                        SootClass superClass = sootClass.getSuperclass();
                        collectImports(superClass);
                        String superName = superClass.getName();
                        if (!superName.startsWith("android")) {
                            extendsList = new ArrayList<ClassOrInterfaceType>();
                            extendsList.add(new ClassOrInterfaceType("RefVAModel"));                            
                        }
                    }

                }
            }
            SortedSet<BodyDeclaration> allMembers = new TreeSet<BodyDeclaration>(new MemberComparator());
            modelCoi.setExtends(extendsList);
            Set<String> oldMemberCoiNames = new HashSet<String>();
            if (oldModelCoi != null) {
                for (BodyDeclaration oldModelMember : oldModelCoi.getMembers()) {
                    allMembers.add(oldModelMember);
                    if (oldModelMember instanceof ClassOrInterfaceDeclaration)
                        oldMemberCoiNames.add(((ClassOrInterfaceDeclaration) oldModelMember).getName());
                }
            }
            if (!isInterface) { // generateConstructor
                ConstructorDeclaration newConstr = generateConstructor(modelCoi);
                allMembers.add(newConstr);
            }
            List<BodyDeclaration> members = coi.getMembers();
            if (members != null)
                for (BodyDeclaration member : members) {
                    BodyDeclaration newMember = null;
                    if (member instanceof FieldDeclaration) {
                        FieldDeclaration field = (FieldDeclaration) member;
                        newMember = generateField(modelCoi, sootClass, field, fieldsToModel, coiTypeParamNames);
                    } else if (member instanceof ConstructorDeclaration) {
                        ConstructorDeclaration constr = (ConstructorDeclaration) member;
                        Set<String> typeParamNames = typeParameterNames(constr.getTypeParameters(), coiTypeParamNames);
                        newMember = generateInitMethod(modelCoi, sootClass, constr, typeParamNames, fieldsToModel);
                        if (newMember != null && constr.getParameters() == null) {
                            MethodDeclaration initMethod = (MethodDeclaration) newMember;
                            constr.setAnnotations(null);
                            constr.setModifiers(initMethod.getModifiers());
                            constr.setBlock(initMethod.getBody());
                            allMembers.add(constr);
                        }
                    } else if (member instanceof MethodDeclaration) {
                        MethodDeclaration method = (MethodDeclaration) member;
                        Set<String> typeParamNames = typeParameterNames(method.getTypeParameters(), coiTypeParamNames);
                        SootMethod sootMethod = getSootMethod(sootClass, method.getName(), method.getParameters(), typeParamNames);
                        if (sootMethod != null && apiMethods.contains(sootMethod.getSignature())) {
                            Comment oldCode = (sootMethod.isConcrete()) ? methodCodeCommentMap.get(method) : null;
                            method.setThrows(null);
                            newMember = convertMethod(modelCoi, method, sootMethod, typeParamNames, oldCode, fieldsToModel);
                        }
                    } else if (member instanceof ClassOrInterfaceDeclaration) {
                        ClassOrInterfaceDeclaration memberCoi = (ClassOrInterfaceDeclaration) member;
                        String memberCoiName = memberCoi.getName();
                        if (!oldMemberCoiNames.contains(memberCoiName)) {
                            String memberCoiQName = sootClass.getName() + "$" + memberCoiName;
                            if (apiClasses.contains(memberCoiQName)) {
                                SootClass memberSootClass = Scene.v().getSootClass(memberCoiQName);
                                ClassOrInterfaceDeclaration oldMemberCoi = null;
                                newMember = generateClassOrInterface(memberCoi, memberSootClass, null, oldMemberCoi);
                            }
                        }
                    } else if (member instanceof EnumDeclaration) {
                        EnumDeclaration enumDecl = (EnumDeclaration) member;
                        if (enumDecl.getMembers() != null) {
                            for (BodyDeclaration enumMember: enumDecl.getMembers()) {
                                enumMember.setAnnotations(null);
                            }
                        }
                        newMember = enumDecl;
                    }
                    if (newMember != null)
                        newMember.setAnnotations(null);
                    allMembers.add(newMember);
                }
            for (BodyDeclaration member: allMembers) {
                if (member != null)
                    ASTHelper.addMember(modelCoi, member);
            }
            return modelCoi;
        }
        return null;
    }

    private Set<String> typeParameterNames(List<TypeParameter> typeParams) {
        return typeParameterNames(typeParams, null);
    }

    private Set<String> typeParameterNames(List<TypeParameter> typeParams, Set<String> initTypeParamNames) {
        Set<String> typeParamNames = (initTypeParamNames == null) ? 
            new HashSet<String>() :
            new HashSet<String>(initTypeParamNames);
        if (typeParams != null) {
            for (TypeParameter typeParam: typeParams) {
                typeParamNames.add(typeParam.getName());
            }
        }
        return typeParamNames;
    }

    private void addComment(BodyDeclaration member, Comment newComment) {
        Comment comment = member.getComment();
        if (comment == null) {
            member.setComment(newComment);
        } else {
            addComment(comment, newComment);
        }
    }

    private void addComment(Comment comment, Comment newComment) {
        Comment prevComment = comment.getComment();
        if (prevComment == null)
            comment.setComment(newComment);
        else 
            addComment(prevComment, newComment);
    }

    private FieldDeclaration generateField(ClassOrInterfaceDeclaration modelCoi, SootClass sootClass, 
            FieldDeclaration field, Set<String> fieldsToModel, Set<String> coiTypeParamNames) {
        localClassNames.add(modelCoi.getName());
        List<VariableDeclarator> vars = field.getVariables();
        List<VariableDeclarator> modelVars = new ArrayList<VariableDeclarator>();
        for (VariableDeclarator var: vars) {
            if (fieldsToModel.contains(var.getId().getName()))
                modelVars.add(var);   
        }
        if (!modelVars.isEmpty()) {
            SootField sootField = sootClass.getFieldByName(modelVars.get(0).getId().getName());
            int modifiers = makePublic(field.getModifiers());
            Type type = field.getType();
            soot.Type sootType = sootField.getType();
            Type modelType = convertType(type, sootType, coiTypeParamNames);
            if (modelType == null)
                return null;
            convertInit(modelVars, type, (ReferenceType) modelType);
            FieldDeclaration modelField = new FieldDeclaration(modifiers, modelType, modelVars);
            modelField.setJavaDoc(field.getJavaDoc());
            modelField.setComment(field.getComment());
            if (ModifierSet.isFinal(modifiers)) {
                modifiers = ModifierSet.removeModifier(modifiers, Modifier.FINAL);
                addComment(modelField, new LineComment(" was final"));
            }
            return modelField;
        }
        return null;
    }

    private void convertInit(List<VariableDeclarator> modelVars, Type type, ReferenceType modelType) {
        Expression init = (modelType != type) ? new ObjectCreationExpr(null, (ClassOrInterfaceType)modelType.getType(), null) : null;
        for (VariableDeclarator modelVar: modelVars){
            modelVar.setInit(init);
        }
    }

    private Expression initForSetOfValues(ReferenceType modelType) {
        ClassOrInterfaceType coi = (ClassOrInterfaceType) modelType.getType();
        Type argType = coi.getTypeArgs().get(0);
        return makeModelingSetCreationExpr(argType);
    }

    private Type convertType(Type type, soot.Type sootType, Set<String> typeParamNames) {
        if (type instanceof ReferenceType) {
            Set<String> clsRefs = getClassReferences(type, sootType, typeParamNames);
            if (intersect(clsRefs, excludedClasses))
                return null;
            collectImports(clsRefs);
            ReferenceType refType = (ReferenceType) type;
            if (refType.getArrayCount() == 0 && refType.getType() instanceof ClassOrInterfaceType) {
                ClassOrInterfaceType coi = (ClassOrInterfaceType)refType.getType();
                String coiName = coi.getName();
                if (coiName.equals("String") || coiName.equals("CharSequence")) {
                    type = getStringType();
                } else if (coiName.startsWith("Class")) {
                    type = getClassType();
                } else if (PRIMITIVE_WRAPPER_CLASS_NAMES.contains(coiName)) {
                    type = convertStringOrPrimitiveWrapperType(coiName);
                } else if (COLLECTION_CLASS_NAMES.contains(coiName)){
                    List<Type> typeArgs = coi.getTypeArgs();
                    if (typeArgs != null && typeArgs.size() == 1) {
                        Type argType = typeArgs.get(0);
                        if (PRIMITIVE_WRAPPER_CLASS_NAMES.contains(argType.toString())) {
                            imports.add(((RefType)sootType).getClassName());
                        }
                    }
                    type = makeSetOfType(type);
                }
            }
        } else if (type instanceof PrimitiveType) {
            PrimitiveType primType = (PrimitiveType) type;
            return convertPrimitive(primType.getType());
        }
        return type;
    }

    private boolean intersect(Set<String> set1, List<String> set2) {
        for (String elt1: set1)
            if (set2.contains(elt1))
                return true;
        return false;
    }
    
    private Type getStringType() {
        //System.out.println("**Converting string!!");
        String vaString = "String" + "VAModel";
        Type type = classTypeConversionMap.get(vaString);
        if (type == null) {
            imports.add("droidsafe.analyses.value.primitives." + vaString);
            type = makeReferenceType(vaString);
            classTypeConversionMap.put(vaString, type);
        }
        
        return type;
    }
    
    private Type getClassType() {
        //System.out.println("**Converting class!!");
        String vaClass = "Class" + "VAModel";
        Type type = classTypeConversionMap.get(vaClass);
        if (type == null) {
            imports.add("droidsafe.analyses.value.primitives." + vaClass);
            type = makeReferenceType(vaClass);
            classTypeConversionMap.put(vaClass, type);
        }
        
        return type;
    }
    
    

    private Type convertStringOrPrimitiveWrapperType(String clsName) {
        Type type = classTypeConversionMap.get(clsName);
        if (type == null) {
            type = makeSetOfType(clsName);
            classTypeConversionMap.put(clsName, type);
        }
        return type;
    }

    private Type convertPrimitive(Primitive prim) {
        Type type = primitiveTypeConversionMap.get(prim);
        if (type == null) {
            imports.add("droidsafe.analyses.value.primitives." + prim + "VAModel");
            type = makeReferenceType(prim + "VAModel");
            primitiveTypeConversionMap.put(prim, type);
        }
        return type;
    }

    private List<Type> getTypeArgs(Type type) {
        if (type instanceof ReferenceType)
            return getTypeArgs(((ReferenceType)type).getType());
        if (type instanceof ClassOrInterfaceType)
            return ((ClassOrInterfaceType)type).getTypeArgs();
        return null;
    }

    private String matchClassName(String name, Set<String> clsNames, boolean error) {
        Set<String> matchedNames = matchedClassNames(name, clsNames);
        if (matchedNames.size() == 1) {
            return matchedNames.iterator().next();
        } 
        if (error) {
            logger.error("Found " + matchedNames.size() + " api classes for " + name);
            droidsafe.main.Main.exit(1);
        }
        return null;
    }

    private Set<String> matchedClassNames(String name, Set<String> clsNames) {
        Set<String> matchedNames = new HashSet<String>();
        for (String clsName: clsNames) {
            if (clsName.equals(name) || clsName.endsWith("."+name) || clsName.endsWith("$"+name)) {
                matchedNames.add(clsName);
            }
        }
        return matchedNames;
    }

    private void collectImports(Set<String> clsRefs) {
        for (String clsRef: clsRefs)
            collectImports(clsRef);
    }

    private void collectImports(SootClass sootClass) {
        collectImports(sootClass.getName());
    }

    private void collectImports(String clsName) {
        if (!importsProcessed.contains(clsName)) {
            String modelClsName = ValueAnalysis.MODEL_PACKAGE_PREFIX + clsName;
            if (!getQualifier(clsName).equals("java.lang")) {
                if (clsName.startsWith("android")) {
                    int pos = clsName.indexOf('$');
                    String rootClsName = (pos < 0) ? clsName : clsName.substring(0, pos);
                    boolean isAPIClass = apiClasses.contains(clsName);
                    if (isAPIClass &&
                            !classesAlreadyModeled.contains(modelClsName) &&
                            !classesCurrentlyModeled.contains(rootClsName) &&
                            !classesToBeModeled.contains(rootClsName)) {
                        classesToBeModeled.add(rootClsName);
                            }
                    if (isAPIClass)
                        imports.add(modelClsName.replace('$', '.'));
                    else
                        imports.add(clsName.replace('$', '.'));
                } else {
                    if (classesAlreadyModeled.contains(modelClsName))
                        imports.add(modelClsName.replace('$', '.'));
                    else
                        imports.add(clsName.replace('$', '.'));
                }
            }
            importsProcessed.add(clsName);
        }
    }

    private Set<String> getClassReferences(Type type, soot.Type sootType, Set<String> typeParamNames) {
        Set<String> result = new HashSet<String>();
        getClassReferences(type, sootType, typeParamNames, result);
        return result;
    }

    private void getClassReferences(Type type, soot.Type sootType, Set<String> typeParamNames, Set<String> result) {
        if (sootType instanceof ArrayType) {
            getClassReferences(((ReferenceType)type).getType(), ((ArrayType)sootType).baseType, typeParamNames, result);
        } else if (sootType instanceof RefType) {
            String className = ((RefType)sootType).getClassName();
            result.add(className);
            List<Type> typeArgs = getTypeArgs(type);
            if (typeArgs != null) {
                for (Type typeArg: typeArgs) {
                    getClassReferences(typeArg, typeParamNames, result);
                }
            }
        }
    }

    private void getClassReferences(Type type, Set<String> typeParamNames, Set<String> result) {
        if (type instanceof ReferenceType)
            getClassReferences(((ReferenceType)type).getType(), typeParamNames, result);
        else if (type instanceof ClassOrInterfaceType) {
            ClassOrInterfaceType coiType = (ClassOrInterfaceType) type;
            ClassOrInterfaceType scope = coiType.getScope();
            String name = coiType.getName();
            if (scope != null) {
                String scopeName = scope.toString();
                char separator = '.';
                if (scopeName.indexOf('$') >= 0)
                    separator = '$';
                else {
                    int pos = scopeName.lastIndexOf('.');
                    String lastComp = (pos >= 0) ? scopeName.substring(pos + 1) : scopeName;
                    if (Character.isUpperCase(lastComp.charAt(0)))
                        separator = '$';
                }
                name = scopeName + separator + name;
            }
            if (!typeParamNames.contains(name)) {
                String candidate = classToModel + '$' + name;
                if (apiClasses.contains(candidate))
                    result.add(candidate);
                else {
                    candidate = packageName + '.' + name;
                    if (apiClasses.contains(candidate))
                        result.add(candidate);
                    else {
                        String matchedClsName = matchClassName(name, sourceImports, false);
                        if (matchedClsName == null)
                            matchedClsName = matchClassName(name, apiClasses, true);
                        result.add(matchedClsName);
                    }
                }
            }
            List<Type> typeArgs = coiType.getTypeArgs();
            if (typeArgs != null) {
                for (Type typeArg: typeArgs) {
                    getClassReferences(typeArg, typeParamNames, result);
                }
            }
        }
    }

    private ConstructorDeclaration generateConstructor(ClassOrInterfaceDeclaration modelCoi) {
        ConstructorDeclaration modelConstr = new ConstructorDeclaration(Modifier.PUBLIC, modelCoi.getName());
        Parameter parameter = ASTHelper.createParameter(makeReferenceType("soot.jimple.toolkits.pta.IAllocNode"), "node");
        modelConstr.setParameters(makeParameterList(parameter));
        Statement stmt = new ExplicitConstructorInvocationStmt(false, null, makeExprList(new NameExpr("node")));
        modelConstr.setBlock(makeBlockStmt(stmt));
        return modelConstr;
    }

    private MethodDeclaration generateInitMethod(ClassOrInterfaceDeclaration modelCoi,
            SootClass sootClass,
            ConstructorDeclaration constr, Set<String> typeParamNames,
            Set<String> fieldsToModel) throws Exception {
        List<Parameter> params = constr.getParameters();
        int modifiers = makePublic(constr.getModifiers());
        MethodDeclaration method = new MethodDeclaration(modifiers, ASTHelper.VOID_TYPE, "_init_", params);
        method.setTypeParameters(constr.getTypeParameters());
        method.setJavaDoc(constr.getJavaDoc());
        method.setComment(constr.getComment());
        method.setBody(constr.getBlock());
        SootMethod sootMethod = getSootMethod(sootClass, "<init>", params, typeParamNames);
        if (sootMethod != null &&  apiMethods.contains(sootMethod.getSignature())) {
            Comment codeComment = methodCodeCommentMap.get(constr);
            return convertMethod(modelCoi, method, sootMethod, typeParamNames, codeComment, fieldsToModel);
        }
        return null;
    }

    private SootMethod getSootMethod(SootClass sootClass, String name, List<Parameter> parameters, Set<String> typeParamNames) {
        SootMethod sootMethod = null;
        int paramCount = (parameters == null) ? 0 : parameters.size();
        for (SootMethod m: sootClass.getMethods()) {
            if (m.getName().equals(name)) {
                boolean match = true;
                if (m.getParameterCount() == paramCount) {
                    for (int i = 0; i < paramCount; i++) {
                        Parameter param = parameters.get(i);
                        Type type = param.getType();
                        VariableDeclaratorId id = param.getId();
                        if (param.isVarArgs())
                            type = new ReferenceType(type, 1);
                        if (id.getArrayCount() > 0)
                            type = new ReferenceType(type, id.getArrayCount());
                        soot.Type sootType = m.getParameterType(i);
                        if (!typeMatch(type, sootType, typeParamNames)) {
                            match = false;
                            break;
                        }
                    }
                    if (match)
                        sootMethod = m;
                }
            }
        }
        if (sootMethod == null) {
            StringBuffer buf = new StringBuffer(name);
            buf.append('(');
            for (int i = 0; i < paramCount; i++) {
                if (i > 0)
                    buf.append(",");
                buf.append(parameters.get(i));
            }
            buf.append(')');
            //throw new Exception("Failed to find soot method " + buf);
            //logger.warn("Failed to find soot method " + buf);
        }
        return sootMethod;
    }

    private boolean typeMatch(Type type, soot.Type sootType, Set<String> typeParamNames) {
        if (type instanceof ReferenceType) {
            ReferenceType refType = (ReferenceType) type;
            int dim = refType.getArrayCount();
            Type baseType = refType.getType();
            if (sootType instanceof ArrayType) {
                ArrayType arrType = (ArrayType) sootType;
                return (dim == arrType.numDimensions && 
                        typeMatch(baseType, arrType.baseType, typeParamNames));
            } else
                return dim == 0 && typeMatch(baseType, sootType, typeParamNames);
        } else if (type instanceof ClassOrInterfaceType) {
            ClassOrInterfaceType coiType = (ClassOrInterfaceType) type;
            if (sootType instanceof RefType) {
                RefType sootRefType = (RefType) sootType;
                String clsName = coiType.getName();
                if (typeParamNames.contains(clsName))
                    clsName = "java.lang.Object";
                String sootClsName = sootRefType.getClassName();
                if (clsName.contains("."))
                    return clsName.equals(sootClsName);
                else
                    return clsName.equals(getUnqualifiedName(sootClsName));
            } else
                return false;
        } else
            return type.toString().equals(sootType.toString());
    }

    private MethodDeclaration convertMethod(ClassOrInterfaceDeclaration modelCoi, MethodDeclaration method, SootMethod sootMethod, 
            Set<String> typeParamNames, Comment codeComment, Set<String> fieldsToModel) {
        method.setModifiers(makePublic(method.getModifiers()));
        Type returnType = method.getType();
        soot.Type sootReturnType = sootMethod.getReturnType();
        Set<String> clsRefs = getClassReferences(returnType, sootReturnType, typeParamNames);
        if (intersect(clsRefs, excludedClasses))
            return null;
        collectImports(clsRefs);
        List<Parameter> params = method.getParameters();
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                Parameter param = params.get(i);
                Type type = param.getType();
                soot.Type sootType = sootMethod.getParameterType(i);
                Type newType = convertType(type, sootType, typeParamNames);
                if (newType == null)
                    return null;
                param.setType(newType);
                if (isSetOfType(newType) && !isSetOfType(type)) {
                    String name = param.getId().getName();
                    if (!name.endsWith("s")) {
                        String newName = name + 's';
                        if (!keywordsEndingWithS.contains(newName))
                            param.setId(new VariableDeclaratorId(newName));
                    }
                }
            }
        }
        if (codeComment != null) {
            if (isGetterMethodForModeledField(method, fieldsToModel)) {
                Type newReturnType = convertType(returnType, sootReturnType, typeParamNames);
                if (newReturnType == null)
                    return null;
                method.setType(newReturnType);
            } else {
                List<Statement> newStmts = new ArrayList<Statement>();
                if (!ModifierSet.isStatic(modelCoi.getModifiers()) && !sootMethod.isStatic()) {
                    Statement invalidateStmt = new ExpressionStmt(new MethodCallExpr(null, "__ds__invalidate"));
                    newStmts.add(invalidateStmt);
                }
                if (!(returnType instanceof VoidType)) {
                    Expression returnExpr = defaultInitValue(returnType);
                    Statement returnStmt = new ReturnStmt(returnExpr);
                    newStmts.add(returnStmt);
                }
                BlockStmt newBody = new BlockStmt(newStmts);
                if (codeComment != null) {
                    newBody.setEndComment(codeComment);
                }
                method.setBody(newBody);
            }
        }
        return method;
    }

    private boolean isGetterMethodForModeledField(MethodDeclaration method, Set<String> fieldsToModel) {
        BlockStmt body = method.getBody();
        List<Statement> stmts = body.getStmts();
        if (stmts != null && stmts.size() == 1) {
            Statement stmt = stmts.get(0);
            if (stmt instanceof ReturnStmt) {
                Expression returnExpr = ((ReturnStmt)stmt).getExpr();
                if (returnExpr instanceof FieldAccessExpr) {
                    FieldAccessExpr fldAccess = (FieldAccessExpr) returnExpr;
                    Expression scope = fldAccess.getScope();
                    if (scope.toString().equals("this")) {
                        String field = fldAccess.getField();
                        return fieldsToModel.contains(field);
                    }
                } else if (returnExpr instanceof NameExpr) {
                    String field = ((NameExpr)returnExpr).getName();
                    return fieldsToModel.contains(field);
                }
            }
        }
        return false;
    }

    private int makePublic(int modifiers) {
        modifiers = ModifierSet.removeModifier(modifiers, Modifier.PROTECTED);
        modifiers = ModifierSet.removeModifier(modifiers, Modifier.PRIVATE);
        return ModifierSet.addModifier(modifiers, Modifier.PUBLIC);
    }

    private Expression defaultInitValue(Type type) {
        if (type instanceof ReferenceType)
            return NULL;
        if (type instanceof PrimitiveType) {
            switch (((PrimitiveType) type).getType()) {
                case Boolean: return FALSE;
                default: return ZERO;
            }
        }
        return null;
    }

    private void writeModel(CompilationUnit cu) {
        String modelPackageName = ValueAnalysis.MODEL_PACKAGE_PREFIX + packageName;
        File dir = constructFile(modelSourceDir, modelPackageName.replace(".", File.separator));
        dir.mkdirs();
        PrintWriter out = null;
        File outFile = new File(dir, unqualifiedClassName + ".java");
        logger.debug("Writing model code to " + outFile.getPath() + "...");
        try {
            out = new PrintWriter(outFile);
            out.print(cu.toString());
        } catch (FileNotFoundException e) {
            logger.error("generateCodeForModeledClass failed", e);
            droidsafe.main.Main.exit(1);
        } finally {
            if (out != null)
                out.close();
        }
        generatedModels.add(outFile);
    }

    private boolean isSetOfType(Type type) {
        if (type instanceof ReferenceType) {
            type = ((ReferenceType) type).getType();
            return type instanceof ClassOrInterfaceType && ((ClassOrInterfaceType)type).getName().equals("Set");
        }
        return false;
    }

    private ReferenceType makeSetOfType(String className) {
        return makeSetOfType(new ClassOrInterfaceType(className));
    }

    private ReferenceType makeSetOfType(Type type) {
        imports.add("java.util.Set");
        return makeGenericReferenceType("Set", type);
    }

    private static ReferenceType makeReferenceType(String className) {
        return new ReferenceType(new ClassOrInterfaceType(className));
    }

    private static ReferenceType makeGenericReferenceType(String genericClassName, Type ... typeArgs) {
        ClassOrInterfaceType genericType = makeGenericType(genericClassName, typeArgs);
        return new ReferenceType(genericType);
    }

    private static ClassOrInterfaceType makeGenericType(String genericClassName, Type ... typeArgs) {
        ClassOrInterfaceType genericType = new ClassOrInterfaceType(genericClassName);
        genericType.setTypeArgs(Arrays.asList(typeArgs));
        return genericType;
    }

    private static Expression makeModelingSetCreationExpr(Type typeArg) {
        return makeGenericObjectCreationExpr("ValueAnalysisModelingSet", typeArg);
    }

    private static Expression makeGenericObjectCreationExpr(String genericClassName, Type ... typeArgs) {
        ClassOrInterfaceType genericType = makeGenericType(genericClassName, typeArgs);
        return new ObjectCreationExpr(null, genericType, null);
    }

    private static List<Parameter> makeParameterList(Parameter ...parameters) {
        List<Parameter> params = new ArrayList<Parameter>();
        for (Parameter param: parameters)
            params.add(param);
        return params;
    }

    private static List<Expression> makeExprList(Expression ...expressions) {
        List<Expression> exprs = new ArrayList<Expression>();
        for (Expression expr: expressions)
            exprs.add(expr);
        return exprs;
    }

    private static BlockStmt makeBlockStmt(Statement ...statements) {
        List<Statement> stmts = new ArrayList<Statement>();
        for (Statement stmt: statements)
            stmts.add(stmt);
        BlockStmt block = new BlockStmt(stmts);
        return block;
    }

    private String getUnqualifiedName(String name) {
        int index = name.lastIndexOf('.');
        if (index >= 0)
            name = name.substring(index + 1);
        index = name.lastIndexOf('$');
        if (index >= 0)
            name = name.substring(index + 1);
        return name;
    }

    private String getQualifier(String name) {
        int index = name.lastIndexOf('.');
        return (index < 0) ? "" : name.substring(0, index);
    }

    private File constructFile(String ...comps) {
        String path = constructPath(comps);
        return new File(path);        
    }

    private static String constructPath(String ...comps) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < comps.length; i++) {
            if (i > 0)
                buf.append(File.separator);
            buf.append(comps[i]);
        }
        return buf.toString();        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Usage: VAResultContainerClassGenerator <source path>");
            droidsafe.main.Main.exit(1);
        } else {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            try {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                // Call context.reset() to clear any previous configuration, e.g. default
                // configuration. For multi-step configuration, omit calling context.reset().
                context.reset();
                configurator.doConfigure(System.getenv("DROIDSAFE_SRC_HOME") + File.separator + "config-files/va-result-container-class-generator-logging.xml");
            } catch (JoranException je) {
                // StatusPrinter will handle this
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);

            String sourcePath = args[0];
            VAResultContainerClassGenerator generator = new VAResultContainerClassGenerator(sourcePath);
            for(Map.Entry<SootClass, Set<SootField>> entry : generator.classesAndFieldsToModel.entrySet()){
                Set<String> fieldNames = new HashSet<String>();
                for (SootField sootField : entry.getValue()) {
                    fieldNames.add(sootField.getName());
                }
                generator.run(entry.getKey().getName(), fieldNames);
            }
        }
    }
}
