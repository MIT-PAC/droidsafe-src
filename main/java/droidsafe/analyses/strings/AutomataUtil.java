package droidsafe.analyses.strings;

import java.util.HashMap;
import java.util.Map;


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



  private enum ReOp { EPSILON, EMPTY, CHAR, UNION, STAR, CONCAT, RANGE, STRING };

  // The representation of regular expressions.
	public static class RE {

		public ReOp op;
		public char low, high;
		public String lit;
		public RE arg1, arg2;


	  private static RE epsilon = new RE(ReOp.EPSILON);
	  private static RE empty = new RE(ReOp.EMPTY);




	  public static RE mkChar(char c) {
	  	RE res = new RE(ReOp.CHAR);
	  	res.low = c;
	  	return res;
	  } 

	  public static RE mkUnion(RE x, RE y ) {
	  	RE res = new RE(ReOp.UNION);
	  	res.arg1 = x;
	  	res.arg2 = y;
	  	return res;
	  }

	  public static RE mkStar(RE x) {
	  	RE res = new RE(ReOp.STAR);
	  	res.arg1 = x;
	  	return res;
	  }

	  public static RE mkConcat(RE x, RE y ) {
	  	RE res = new RE(ReOp.CONCAT);
	  	res.arg1 = x;
	  	res.arg2 = y;
	  	return res;
	  }


	  public static RE mkRange(char low, char high) {
	  	RE res = new RE(ReOp.RANGE);
	  	res.low = low;
	  	res.high = high;
	  	return res;
	  } 

	  public static RE mkString(String lit) {
	  	RE res = new RE(ReOp.STRING);
	  	res.lit = lit;
	  	return res;
	  } 





		public RE(ReOp op) {
			this.op = op;
		}

		public String toString() {
			switch (this.op) {
				case EMPTY:
				  return "<empty>";
				case EPSILON:
				  return "<epsilon>";
				case RANGE:
				  if (this.low == '\u0000' && this.high == '\uffff') {
				  	return ".";
				  } else {
				  	return "[" + this.low + "-" + this.high + "]";
				  }
   			case CHAR:
   			  return Character.toString(this.low);
   			case STRING:
   			   return this.lit;
   			case UNION:
   			   return "(" + this.arg1 + "|" + this.arg2 + ")"; 
   			case STAR:
   			    if (arg1.op == ReOp.CHAR || arg1.op == ReOp.RANGE)
   			    	return arg1.toString() + "*";
   			    else
   			    	return "(" + arg1.toString() + ")*";   			    

   			case CONCAT:
   			    return arg1.toString() + arg2.toString();
			}
			return "<unknown>";
		}

		public RE union(RE y) {
			// logger.debug("union(" + this.toString() + "," + y.toString() + ")");

			if (this.op == ReOp.EMPTY)
				return y;

			if (y.op == ReOp.EMPTY)
				return this;

		  // logger.debug("union(" + x.toString() + "," + y.toString() + ")");
		  return mkUnion(this,y);
		}

		public RE concat(RE y) {
			// logger.debug("concat(" + this.toString() + "," + y.toString() + ")");
			if (this.op == ReOp.EMPTY || 
				  y.op == ReOp.EMPTY)
				return new RE(ReOp.EMPTY);

			if (this.op == ReOp.EPSILON)
				return y;

			if (y.op == ReOp.EPSILON)
				return this;

		  // logger.debug("concat(" + x.toString() + "," + y.toString() + ")");
			return mkConcat(this,y);
		}

		public RE star() {

			// logger.debug("star(" + this.toString() + ")");


			if (this.op == ReOp.EPSILON || this.op == ReOp.EMPTY) {
				return epsilon;
			}

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
			logger.debug("Singleton String");
			RE re = new RE(ReOp.STRING);
			re.lit = singleton;
			return re;
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


		RE[][] a = new RE[m][m];
		RE[] b = new RE[m];


		// Give a state a name.
		Map<State,Integer> sm = new HashMap<State,Integer>();


		// Number the states; the initial state should be 0.
		State initial = fsm.getInitialState();

		// Init all of the states.
		idx = 1;
		for (State s: fsm.getStates()) {
			int dest = idx;

			if (s == initial) {
				sm.put(s,0);				
				dest = 0;
			} else {
				sm.put(s,idx);
				idx++;
			}
			
			if (s.isAccept()) {
				b[dest] = epsilon;
			} else {
				b[dest] = empty;				
			}


		}

	
    // Init the table.
		for (State s: fsm.getStates()) {
			int i = sm.get(s);
			for (int j = 0; j < m; j++) 
				a[i][j] = empty;

			for (Transition t: s.getTransitions()) {
				int j = sm.get(t.getDest());

				RE e = new RE(ReOp.RANGE);
				e.low = t.getMin();
				e.high = t.getMax();
				
				if (e.low == e.high)
					e.op = ReOp.CHAR;


				a[i][j] = a[i][j].union(e);

			}
		}


		for (int r = 0; r < m; r++ ) {
		  for (int s = 0; s < m; s++) {
				logger.debug("A[" + r + "][" + s + "] " + a[r][s].toString());
			}			
		}

		for (int p = 0; p < m; p++)
			logger.debug("B[" + p + "] " + b[p].toString());

		// logger.debug("Total size is " + m);
		for (int n = m - 1; n >= 0; n--) {
			logger.debug("Outer loop: " + n);
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


			for (int r = 0; r < m; r++ ) {
				for (int s = 0; s < m; s++) {
						logger.debug("A[" + r + "][" + s + "] " + a[r][s].toString());
				}			
			}

			for (int p = 0; p < m; p++)
				logger.debug("B[" + p + "] " + b[p].toString());
		}


		RE res = b[sm.get(fsm.getInitialState())];		
		return res;
	}
	}

}