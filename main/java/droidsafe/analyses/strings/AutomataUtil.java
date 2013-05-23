package droidsafe.analyses.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.automaton.RegExp;


/*

A Utility Class, used for converting automata into regular expressions.

*/
public class AutomataUtil {

	private static Logger logger = LoggerFactory.getLogger(AutomataUtil.class);


	public static RE convertAutomata(Automaton a) {
		return RE.brzozowski(a);
	}


  private enum ReOp { 
  	EPSILON(11), 
  	EMPTY(11), 
  	CHAR(11), 
  	UNION(3), 
  	STAR(9), 
  	CONCAT(5), 
  	RANGE(11), 
  	STRING(11),
  	PLUS(9), 
  	OPTION(9);

  	private int m_prec;
  	ReOp(int prec) {
  		this.m_prec = prec;
  	}

  	int getPrec() { return m_prec; }

   };

  // The representation of regular expressions.
	public static class RE {

		public ReOp op;
		public char low,high;
		public String lit;
		public RE arg1;
		public RE arg2;

	  private static RE epsilon = new RE(ReOp.EPSILON);
	  private static RE empty = new RE(ReOp.EMPTY);


	  public boolean equals(RE x) {
	  	if (this == x ||
	  		  ((x != null) && (op == x.op) && (low == x.low) && (high == x.high) &&
	  	       ((lit == null) ? (x.lit == null) : lit.equals(x.lit)) &&
	  	       ((arg1 == null) ? (x.arg1 == null) : arg1.equals(x.arg1)) &&
	  	       ((arg2 == null) ? (x.arg2 == null) : arg2.equals(x.arg2)))) {
	  		// logger.debug("Equal " + this.toString() + x.toString());
   	  	return true;
   	  }

   	  return false;
	  }

	  public boolean vequals(RE x) {
	  	if (this == x)
	  		return true;

	  	// logger.debug("equals:\n\t" + toString() + "\n\t" + x.toString());

	  	if (x == null) {
	  		// logger.debug(x.toString() + " is not null.");
	  	  return false;
	  	}

	  	if (op != x.op) {
	  		// logger.debug("Ops do not match.");
	  		return false;
	  	}

	  	if (low != x.low) {
	  		// logger.debug("lows not match.");
	  		return false;
	  	}

	  	if (high != x.high) {
	  		// logger.debug("highs do not match.");
	  		return false;
	  	}

	  	if (! ((lit == null) ? (x.lit == null) : lit.equals(x.lit))) {
	  		// logger.debug("lits do not match.");
	  		return false;
	  	}

	  	if (! ((arg1 == null) ? (x.arg1 == null) : arg1.equals(x.arg1))) {
	  		// logger.debug("arg1s do not match.");
	  		return false;
	  	}

	  	if (! ((arg2 == null) ? (x.arg2 == null) : arg2.equals(x.arg2))) {
	  		// logger.debug("arg2s do not match.");
	  		return false;
	  	}

	  	return true;
	  }


	  public void dumpInfo() {
	  	// logger.debug("val " + toString());
	  	logger.debug("op  " + op.toString());
	  	logger.debug("lit " + lit);
	  	logger.debug("ar1 " + arg1);
	  	logger.debug("ar2 " + arg2);	  	
	  }

	  public static RE mkChar(char c) {
	  	return mkString(Character.toString(c));
	  } 

	  public static RE mkUnion(RE x, RE y ) {

	  	if (x.equals(y)) {
	  		// logger.debug("Equal union");
	  		return x;
	  	} else if (x.equals(empty)) {
	  		return y;
	  	} else if (y.equals(empty)) {
	  		return x;
	  	} else if (x.equals(epsilon)) {
	  		// logger.debug("Epsilon union");
	  		return mkOption(y);
	  	} else if (y.equals(epsilon)) {
	  		// logger.debug("Epsilon union");
	  	  return mkOption(x);	
	  	} else if (y.op == ReOp.CONCAT) {
	  		// logger.debug("Union Concat");
	  		// logger.debug("Test1: " + x.vequals(y.arg1));
	  		// logger.debug("Test2: " + x.vequals(y.arg2));	  		
	  		if (x.equals(y.arg1)) {
	  			return mkConcat(x, mkOption(y.arg2));
	  		} else if (x.equals(y.arg2)) {
	  			return mkConcat(mkOption(y.arg1), x);
	  		}
	  	} else if (x.op == ReOp.STRING && y.op == ReOp.STRING) {
          /*
	  		int xidx = y.lit.indexOf(x.lit);
	  		int yidx = x.lit.indexOf(y.lit);
	  		if (xidx >= 0) {
	  			String pre = y.lit.substring(0,xidx - 1);
	  			String post = y.lit.substring(xidx+x.lit.length());
	  			return mkConcat(mkOption(mkString(pre)), mkConcat(mkString(x.lit), mkOption(mkString(post))));
	  		} else if (yidx >= 0) {
	  			String pre = x.lit.substring(0,yidx - 1);
	  			String post = x.lit.substring(yidx+y.lit.length());
	  			return mkConcat(mkOption(mkString(pre)), mkConcat(mkString(y.lit), mkOption(mkString(post))));
	  		}
          */

	  	}
	  	// logger.debug("UNION: ");
	  	// logger.debug("\t" + x.toString());
	  	// logger.debug("\t" + y.toString());	  	
	  	RE res = new RE(ReOp.UNION);
	  	res.arg1 = x;
	  	res.arg2 = y;
	  	// logger.debug("\t" + res.toString());	  	
	  	return res;
	  }

	  public static RE mkStar(RE x) {

	  	if (x.equals(epsilon) || x.equals(empty)) {
	  		return epsilon;
	  	} 

	  	RE res = new RE(ReOp.STAR);
	  	res.arg1 = x;
	  	return res;
	  }

	  public static RE mkPlus(RE x) {

	  	if (x.equals(epsilon) || x.equals(empty)) {
	  		return epsilon;
	  	} 

	  	RE res = new RE(ReOp.PLUS);
	  	res.arg1 = x;
	  	return res;
	  }


	  public static RE mkConcat(RE x, RE y ) {
	  		  	
	  	RE res;
	  	if (x.op == ReOp.STRING && y.op == ReOp.STRING) {
	  		// logger.debug("ConcatStrings");
	  		return mkString(x.lit + y.lit);
	  	} else if (x.equals(empty) || y.equals(empty)) {
	  		return empty;
	  	} else if (y.equals(epsilon)) {
	  		return x;
	  	} else if (x.equals(epsilon)) {
	  		return y;
	  	} else if (y.op == ReOp.STAR && x.equals(y.arg1)) {
	  		return mkConcat(mkPlus(x),y.arg2);
	  	} else if (y.op == ReOp.CONCAT && y.arg1.op == ReOp.STAR) {

	  		// logger.debug("Concat start: " + x.equals(y.arg1.arg1) );
	  		// logger.debug("X: " + x.toString());
	  		// logger.debug("Y.arg1.arg1: " + y.arg1.arg1);
	  		if (x.vequals(y.arg1.arg1)) {
	  			return mkConcat(mkPlus(x),y.arg2);
	  		}
	  		// x.dumpInfo();
	  		// y.arg1.arg1.dumpInfo();

	  	}

	  	// logger.debug("CONCAT: ");
	  	// logger.debug("\t" + x.toString());
	  	// logger.debug("\t" + y.toString());	  	

	  	res = new RE(ReOp.CONCAT);
	  	res.arg1 = x;
	  	res.arg2 = y;
	  	// logger.debug("\t" + res.toString());	  	

	  	return res;
	  }


	  public static RE mkRange(char low, char high) {
	  	if (low == high) {
	  		return mkChar(low);
	  	}

	  	RE res = new RE(ReOp.RANGE);
	  	res.low = low;
	  	res.high = high;
	  	return res;
	  } 

	  public static RE mkString(String lit) {
	  	if (lit.isEmpty()) {
	  		return empty;
	  	}

	  	RE res = new RE(ReOp.STRING);
	  	res.lit = lit;
	  	return res;
	  } 


	  public static RE mkOption(RE arg) {

	  	if (arg == empty) {
	  		return empty;
	  	}

	  	if (arg.op == ReOp.STAR) {
	  		return arg;
	  	}

	  	if (arg.op == ReOp.PLUS) {
	  		return mkStar(arg.arg1);
	  	}

	  	RE res = new RE(ReOp.OPTION);
	  	res.arg1 = arg;
	  	return res;
	  }

		public RE(ReOp op) {
			this.op = op;
			low = '0';
			high = '0';
			lit = null;
			arg1 = null;
			arg2 = null;			
		}

		public String toString() {
			StringBuilder acc = new StringBuilder();
			toString(acc,0);
			return acc.toString();
		}

		public void toString(StringBuilder acc) {
			// logger.debug("Accmulator: " + acc.length());
			switch (this.op) {
				case EMPTY:
				  acc.append("<empty>");
				  return;
				case EPSILON:
				  acc.append("<epsilon>");
				  return;
				case RANGE:
				  if (this.low == '\u0000' && this.high == '\uffff') {
				  	acc.append(".");
				  	return;
				  } else {
				  	acc.append('[');
				  	acc.append(this.low);
				  	acc.append('-');
				  	acc.append(this.high);
				  	acc.append(']');
				  	return;
				  }
   			case CHAR:
   			  acc.append(this.low);
   			  return;
   			case STRING:
   			   acc.append(this.lit);
   			   return;
   			case UNION:
   			   arg1.toString(acc,op.getPrec());
   			   acc.append('|');
   			   arg2.toString(acc,op.getPrec());
   			   return;
   			case STAR:
		    	arg1.toString(acc,op.getPrec());
		      acc.append("*");
		      return;
   			case PLUS:
  			   arg1.toString(acc,op.getPrec());
   			   acc.append("+");
  		     return;
   			case OPTION:
  			   arg1.toString(acc,op.getPrec());
   			   acc.append("?");
  		     return;

   			case CONCAT:
   			    arg1.toString(acc,op.getPrec());
   			    arg2.toString(acc,op.getPrec());
   			    return;
			}
			acc.append("<unknown>");
			return;
		}

		private void toString(StringBuilder acc, int prec) {
			boolean paren = op.getPrec() < prec;
			if (paren) acc.append('(');
			toString(acc);
   		if (paren) acc.append(')');
		}





		public int size() {
			switch (this.op) {
				case UNION:
				case CONCAT:
				return arg1.size() + arg2.size();
				case STAR:
				case PLUS:
   		  return  arg1.size() + 1;
			}
			return 1;
		}

		public RE chomp() {
			switch (this.op) {
				case UNION:
				case CONCAT:
				case STAR:
				case PLUS:
   		  return  arg1;
			}
			return this;
		}



		public RE union(RE y) {
			// logger.debug("union(" + this.toString() + "," + y.toString() + ")");
		  return mkUnion(this,y);
		}

		public RE concat(RE y) {
		  // logger.debug("concat(" + x.toString() + "," + y.toString() + ")");
			return mkConcat(this,y);
		}

		public RE star() {
		// logger.debug("star(" + x.toString() + ")");
			return mkStar(this);
		}


	// Converting a DFA to a Regular Expression.
	// 
	// Translation of code from:
	// http://cs.stackexchange.com/questions/2016/how-to-convert-finite-automata-to-regular-expressions
	// http://codepad.org/dbFztCCM
	// 
	private static RE brzozowski(Automaton fsm) {

		// Check the case of a singleton string.
		String singleton = fsm.getSingleton();
		if (singleton != null) {
        // logger.debug("Singleton String");
			return mkString(singleton);
		}

		if (fsm.isEmpty() ) {
			logger.debug("Empty language");
		}

		if (fsm.getAcceptStates().size() == 0) {
			logger.debug("No Accept States");
			return empty;
		}
		
		int m = fsm.getNumberOfStates();
		int idx = 0;
		// logger.debug("Have " + m + " states");


		RE[][] a = new RE[m][m];
		RE[] b = new RE[m];


		// Give a state a name.
		Map<State,Integer> sm = new HashMap<State,Integer>();


		// Number the states; the initial state should be 0.
		State initial = fsm.getInitialState();

		Set<State> available = fsm.getLiveStates();
		Set<State> done = new HashSet<State>();
		ArrayList<State> worklist = new ArrayList<State>();

		idx = 0;

		worklist.add(initial);
		while (! worklist.isEmpty()) {
			State cur = worklist.remove(0);
			if (! done.contains(cur)) {
				// Note the numerical index of the state.
				sm.put(cur,idx);
				b[idx] = cur.isAccept() ? epsilon : empty;
				done.add(cur);
				idx++;


				for (Transition t : cur.getTransitions()) {
					State dest = t.getDest();
					if (available.contains(dest) && (! done.contains(dest))) {
						worklist.add(dest);
					}
				}
			}
		}

	
    // Init the table.
		for (State s: fsm.getStates()) {
			int i = sm.get(s);
			for (int j = 0; j < m; j++) 
				a[i][j] = empty;

			for (Transition t: s.getTransitions()) {
				int j = sm.get(t.getDest());

				RE e = RE.mkRange(t.getMin(),t.getMax());
				a[i][j] = a[i][j].union(e);

			}
		}


		// for (int r = 0; r < m; r++ ) {
		//   for (int s = 0; s < m; s++) {
		// 		 logger.debug("A[" + r + "][" + s + "] " + a[r][s].toString());
		// 	}			
		// }

		// for (int p = 0; p < m; p++)
		// 	logger.debug("B[" + p + "] " + b[p].toString());

		for (int n = m - 1; n >= 0; n--) {
			b[n] = a[n][n].star().concat(b[n]);

			for (int j = 0; j < n; j++) {
				a[n][j] = a[n][n].star().concat(a[n][j]);
			}
			for (int i = 0; i < n; i++) {
				b[i] = b[i].union(a[i][n].concat(b[n]));
				
				for (int j = 0; j < n; j++) {
					a[i][j] = a[i][j].union(a[i][n].concat(a[n][j]));
				}
			}
			for (int i = 0; i < n; i++) {
				a[i][n] = empty;
			}


			// for (int r = 0; r < m; r++ ) {
			// 	for (int s = 0; s < m; s++) {
			// 			logger.debug("A[" + r + "][" + s + "] " + a[r][s].toString());
			// 	}			
			// }

			// for (int p = 0; p < m; p++)
				// logger.debug("B[" + p + "] " + b[p].toString());
		}


		RE res = b[sm.get(fsm.getInitialState())];		
		return res;
	}
}

}
