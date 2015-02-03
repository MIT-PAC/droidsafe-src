package dk.brics.string.annotation;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.Body;
import soot.Hierarchy;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.AbstractStmtSwitch;
import soot.jimple.AssignStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.jimple.internal.JInstanceFieldRef;
import soot.tagkit.AnnotationStringElem;
import soot.tagkit.AnnotationTag;
import soot.tagkit.VisibilityAnnotationTag;
import soot.tagkit.VisibilityParameterAnnotationTag;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import dk.brics.string.BindingAutomatonProvider;
import dk.brics.string.java.StaticStringTypes;

public class AnnotationAnalyzer extends AbstractStmtSwitch implements StaticStringTypes {
	
	//Maps an artifact like field, return or parameter to a declared @Type annotation
	private Map<SootField,Automaton> fieldAutomatonMap = new HashMap<SootField,Automaton>();
	
	/** The annotations placed directly at the return type */
	private Map<SootMethod,Automaton> returnAutomatonMap = new HashMap<SootMethod,Automaton>();
	
	/** The annotations placed or inherited at the return type */
    private Map<SootMethod,Automaton> returnAutomatonMapFull = new HashMap<SootMethod,Automaton>();
    
    /** The annotations placed directly on each parameter */
	private Map<SootMethod,Map<Integer,Automaton>> parameterAutomatonMap = new HashMap<SootMethod,Map<Integer,Automaton>>();
	
	/** The annotations placed or inherited at each parameter */
    private Map<SootMethod,Map<Integer,Automaton>> parameterAutomatonMapFull = new HashMap<SootMethod,Map<Integer,Automaton>>();
	
	private Set<ValueBox> hotspots = new HashSet<ValueBox>();
	private Map<ValueBox,Automaton> boxAutomatonMap = new HashMap<ValueBox,Automaton>();
	private Map<ValueBox,Stmt> boxStmtMap = new HashMap<ValueBox,Stmt>();
	
	private Map<Automaton,String> automatonDescriptionMap = new HashMap<Automaton,String>();
	
	private BindingAutomatonProvider bindings;
	
	private SootMethod currentMethod;
	
	private List<StaticTypeError> errors = new ArrayList<StaticTypeError>();

	public AnnotationAnalyzer() {
	    this(new BindingAutomatonProvider());
	}
	
    @SuppressWarnings("unchecked")
	public AnnotationAnalyzer(BindingAutomatonProvider bindings) {
	    this.bindings = bindings;
	    
		//Find @Type and @LoadType annotations and add to a map
		Collection<SootClass> classes = Scene.v().getApplicationClasses();
		Hierarchy h = Scene.v().getActiveHierarchy();
		if (h == null)
		    h = new Hierarchy();
		for (SootClass sootClass : classes) {
			//Find fields containing the @Type annotation and add to map
			Collection<SootField> fields = sootClass.getFields();
			for (SootField field : fields) {
				if (field.hasTag("VisibilityAnnotationTag")) {
					VisibilityAnnotationTag vat = (VisibilityAnnotationTag)field.getTag("VisibilityAnnotationTag");
					Automaton automaton = getAutomatonFromTag(vat);
					if (automaton != null) {
						fieldAutomatonMap.put(field, automaton);
					}
				}
				//Remove all tags from field. JSA tags will be added later
				field.removeAllTags();
			}
			
			//Find methods containing @Type or @LoadType annotation and add to map
			Collection<SootMethod> methods = sootClass.getMethods();
			for (SootMethod m : methods) {
				//Find return annotation
				if (isStringType(m.getReturnType())) {
					VisibilityAnnotationTag vat = (VisibilityAnnotationTag)m.getTag("VisibilityAnnotationTag");
					if (vat != null) {
						Automaton automaton = getAutomatonFromTag(vat);
						if (automaton != null) {
						    returnAutomatonMap.put(m, automaton);
						}
					}
				}
				
				//Find parameter annotations
				int count = m.getParameterCount();
				for (int i = 0; i<count; i++) {
					if (isStringType(m.getParameterType(i))) {
						VisibilityParameterAnnotationTag vpat = (VisibilityParameterAnnotationTag)m.getTag("VisibilityParameterAnnotationTag");
						if (vpat != null) {
							VisibilityAnnotationTag vat = vpat.getVisibilityAnnotations().get(i);
							Automaton automaton = getAutomatonFromTag(vat);
							if (automaton != null) {
								Map<Integer,Automaton> pMap;
								if (parameterAutomatonMap.containsKey(m)) {
									pMap = parameterAutomatonMap.get(m);
								}
								else {
									pMap = new HashMap<Integer,Automaton>();
									parameterAutomatonMap.put(m, pMap);
								}
								pMap.put(i, automaton);
							}
						}
					}
				}
				//Remove all tags from method. JSA tags will be added later
				m.removeAllTags();
			}
		}
		
		// apply inheritance relations to construct the 'full' maps
		for (SootClass sootClass : classes) {
		    for (SootMethod m1 : sootClass.getMethods()) {
		        Automaton m1Returns = returnAutomatonMap.get(m1);
		        Map<Integer, Automaton> m1Parameters = parameterAutomatonMap.get(m1);
		        //if (m1Returns == null && m1Parameters == null)
		        //    continue;
		        if (m1Parameters == null)
		        	m1Parameters = Collections.emptyMap();
		        for (SootMethod m2 : (List<SootMethod>)h.resolveAbstractDispatch(sootClass, m1)) {
		            // HANDLE RETURN TYPES
		            if (m1Returns != null) {
		                inheritReturnType(m1, m1Returns, m2);
		            }
		            
		            // HANDLE PARAMETER TYPES
		            //if (m1Parameters != null) {
	                    if (!parameterAutomatonMapFull.containsKey(m2)) {
	                        parameterAutomatonMapFull.put(m2, new HashMap<Integer,Automaton>());
	                    }
    		            for (int i=0; i<m1.getParameterCount(); i++) {
    		                Automaton m1Parameter = m1Parameters.get(i);
    		                if (m1Parameter == null) {
    		                	// ensure that the child's parameter has no annotation
    		                	Map<Integer,Automaton> m2Parameters = parameterAutomatonMap.get(m2);
    		                	if (m2Parameters != null && m2Parameters.containsKey(i)) {
    		                		errorSuperParameterNotAnnotated(m2, m1, i);
    		                	}
    		                } else {
    		                	inheritParameterType(m1, m2, i, m1Parameter);
    		                }
    		            }
		            //}
		        }
		    }
		}
		
		//Visit every statement to check if it is a hotspot
		for (SootClass sootClass : classes) {
			Collection<SootMethod> methods = sootClass.getMethods();
			for (SootMethod method : methods) {
				currentMethod = method;
				if (method.hasActiveBody()) {
					Body body = method.getActiveBody();
					Collection<Unit> uc = body.getUnits();
					for (Unit u : uc) {
						if (u instanceof Stmt) {
							Stmt stmt = (Stmt)u;
							stmt.apply(this);
							if (stmt.containsInvokeExpr()) {
								createHotspotsFromInvokeExpr(stmt);
							}
						}
					}
				}
			}
		}
	}

    private void inheritParameterType(SootMethod m1, SootMethod m2, int paramIndex, Automaton m1Parameter) {
        Map<Integer,Automaton> m2Parameters = parameterAutomatonMap.get(m2);
        Automaton m2Parameter = (m2Parameters == null) ? null : m2Parameters.get(paramIndex);
        
        if (m2Parameter == null) {
            Automaton m2ParameterFull = parameterAutomatonMapFull.get(m2).get(paramIndex);
            if (m2ParameterFull == null) {
                // if super method's parameter is not annotated, then any string must be accepted
                // by the child method
                parameterAutomatonMapFull.get(m2).put(paramIndex, Automaton.makeAnyString());
            } else {
                parameterAutomatonMapFull.get(m2).put(paramIndex, m1Parameter.union(m2ParameterFull));
            }
        } else {
            if (!m1Parameter.subsetOf(m2Parameter)) {
                errorParameterMoreRestrictive(m2, m1, paramIndex);
            }
            parameterAutomatonMapFull.get(m2).put(paramIndex, m2Parameter);
        }
    }
    
    private void inheritReturnType(SootMethod m1, Automaton m1Returns, SootMethod m2) {
        Automaton m2Returns = returnAutomatonMap.get(m2);
        
        // if subtype has no annotation, inherit this one
        if (m2Returns == null) {
            Automaton m2full = returnAutomatonMapFull.get(m2);
            if (m2full == null) {
                returnAutomatonMapFull.put(m2, m1Returns);
            } else {
                // if inheriting for more than one place, intersect the languages
                returnAutomatonMapFull.put(m2, m1Returns.intersection(m2full));
            }
        } else {
            if (!m2Returns.subsetOf(m1Returns)) {
                errorReturnTypeLessRestrictive(m2, m1);
            }
            
            returnAutomatonMapFull.put(m2, m2Returns);
        }
    }
    
	private void errorReturnTypeLessRestrictive(SootMethod childMethod, SootMethod superMethod) {
        errors.add(new StaticTypeError(
                childMethod.getName() 
                + " has a less restrictive return type in " 
                + childMethod.getDeclaringClass().getName()
                + " than in the super class "
                + superMethod.getDeclaringClass().getName()));
	}
    private void errorParameterMoreRestrictive(SootMethod childMethod, SootMethod superMethod, int paramIndex) {
        errors.add(new StaticTypeError(
                childMethod.getName() 
                + " has a more restrictive parameter type for parameter #" + (paramIndex+1) + " in " // 1-based index in readable messages
                + childMethod.getDeclaringClass().getName()
                + " than in the super class "
                + superMethod.getDeclaringClass().getName()));
    }
    private void errorSuperParameterNotAnnotated(SootMethod childMethod, SootMethod superMethod, int paramIndex) {
    	errors.add(new StaticTypeError(
    			childMethod.getName()
    			+ " may not annotate parameter #" + (paramIndex+1) + " in "
    			+ childMethod.getDeclaringClass().getName()
    			+ " because it is not annotated in super class "
    			+ superMethod.getDeclaringClass().getName()
    			));
    }
	
	public Set<ValueBox> getHotspots() {
		return hotspots;
	}
	
	public Automaton getAutomaton(ValueBox box) {
		return boxAutomatonMap.get(box);
	}
	
	public String getDescription(Automaton a) {
		return automatonDescriptionMap.get(a);
	}
	
	public Stmt getStmt(ValueBox box) {
		return boxStmtMap.get(box);
	}
	
	private boolean isStringType(soot.Type t) {
		if (t instanceof RefType)
			if (((RefType)t).getSootClass().getName().equals("java.lang.String"))
				return true;
		return false;
	}
	
	private Automaton getAutomatonFromTag(VisibilityAnnotationTag vat) {
		Collection<AnnotationTag> annotations = vat.getAnnotations();
		if (annotations != null) {
			for (AnnotationTag at: annotations) {
				String type = at.getType().trim();
				if (type.equals("Ldk/brics/string/annotation/Type;") && at.getElems().size() == 1) {
				    // XXX why are we trimming the regexp here?? Although rare, it is perfectly sane for a string-type
				    // to end with blanks. E.g @Type("Hello ") would become @Type("Hello").
					String pattern = ((AnnotationStringElem)at.getElems().iterator().next()).getValue().trim();
					Automaton a = (new RegExp(pattern)).toAutomaton(bindings);
					automatonDescriptionMap.put(a, pattern);
					return a;
				}
				if (type.equals("Ldk/brics/string/annotation/LoadType;") && at.getElems().size() == 1) {
					String path = ((AnnotationStringElem)at.getElems().iterator().next()).getValue().trim();
					Automaton a = loadAutomaton(path);
					if (a != null) {
						automatonDescriptionMap.put(a, "automaton '" + path + "'");
						return a;
					}
					else {
						return null;
					}
				}
			}
		}
		return null;
	}
	
	private Automaton loadAutomaton(String path) {
		try {
			//Try to load automaton
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			Automaton a = (Automaton) in.readObject();
			return a;
		}
		catch (Exception e) {
			//Load failed.
			String error = "Loading automaton '" + path + "' failed!";
			System.err.println(error);
			return null;
		}
	}
	
	private void createHotspot(Stmt stmt, ValueBox box, Automaton automaton) {
		hotspots.add(box);
		boxStmtMap.put(box,stmt);
		boxAutomatonMap.put(box,automaton);
	}
	
	public void createHotspotsFromInvokeExpr(Stmt stmt) {
		InvokeExpr expr = stmt.getInvokeExpr();
		SootMethod target = expr.getMethod();
		for (int i=0; i<expr.getArgCount(); i++) {
			Value value = expr.getArg(i);
			ValueBox box = expr.getArgBox(i);
			if (isStringType(value.getType())) {
				Map<Integer,Automaton> pMap = parameterAutomatonMap.get(target);
				if (pMap != null && pMap.containsKey(i)) {
					Automaton automaton = pMap.get(i);
					createHotspot(stmt, box, automaton);
				}
			}
		}
	}
	
	@Override
	public void caseAssignStmt(AssignStmt stmt) {
		Value lvalue = stmt.getLeftOp();
		ValueBox rbox = stmt.getRightOpBox();
		if (lvalue instanceof JInstanceFieldRef) {
			JInstanceFieldRef ref = (JInstanceFieldRef)lvalue;
			SootField field = ref.getField();
			if (fieldAutomatonMap.containsKey(field)) {
				Automaton automaton = fieldAutomatonMap.get(field);
				createHotspot(stmt, rbox, automaton);
			}
		}
	}
	
	@Override
	public void caseIdentityStmt(IdentityStmt stmt) {
		Value rvalue = stmt.getRightOp();
		ValueBox rbox = stmt.getRightOpBox();
		if (rvalue instanceof ParameterRef) {
			ParameterRef parameter = (ParameterRef)rvalue;
			int index = parameter.getIndex();
			Map<Integer,Automaton> pMap = parameterAutomatonMap.get(currentMethod);
			if (pMap != null && pMap.containsKey(index)) {
				Automaton automaton = pMap.get(index);
				createHotspot(stmt, rbox, automaton);
			}
		}
	}
	
	@Override
	public void caseReturnStmt(ReturnStmt stmt) {
		if (returnAutomatonMap.containsKey(currentMethod)) {
			ValueBox box = stmt.getOpBox();
			Automaton automaton = returnAutomatonMap.get(currentMethod);
			createHotspot(stmt, box, automaton);
		}
	}

    public Automaton getFieldType(SootField field) {
        return fieldAutomatonMap.get(field);
    }

    public Automaton getMethodReturnType(SootMethod method) {
        return returnAutomatonMapFull.get(method);
    }

    public Automaton getParameterType(SootMethod method, int paramIndex) {
        Map<Integer, Automaton> map = parameterAutomatonMapFull.get(method);
        if (map != null) {
            return map.get(paramIndex);
        } else {
            return null;
        }
    }

    public List<StaticTypeError> getErrors() {
        return Collections.unmodifiableList(errors);
    }
    
    
	
	
}
