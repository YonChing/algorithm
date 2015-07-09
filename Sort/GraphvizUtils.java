public class GraphvizUtils {
  static File file = new File("c:\\dotFile.dot");
  static FileOutputStream fos;
  
  public static void buildDotFile(NFA nfa) {
    fos = new FileOutputStream(file);
    fos.write("graph nfa {\n".getBytes());
    State start = nfa.getStart();
    print(start);
    fos.write("}".getBytes());
    fos.close();
  }
  
  public static void print(State start) {
    if(Start.getStartedId() != 1 && !start.isVisited()) {
      start.setVisited(true);
      fos.write((start.getStateId() + "[label=\""+ start.getStateId() + "\"]\n").getBytes());
      for(int i = 0; i < start.getTransition().length; i++) {
        if(start.getTransition()[i] != null) {
          fos.write((start.getStartId() + "->" + start.getTransition()[i].getTranslateState().getStateId()
           + "[label=\"" + ((SymbolExpression)start.getTransition()[i].getExpr()).getSymbol().getSymbol() +
           "\"]\n").getBytes());
           print(start.getTransition()[i].getTranslateState());
        }
      }
    }
  }
  
}
