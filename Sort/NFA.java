public class NFA {
  private State start;
  private State end;
  Expression expr;
  public NFA(){
    this.start = new State();
    this.end = new State();
    this.start.getTransition()[0] = new Transition(new EpsilonExpression(), end);
  }
  public NFA(Expression expr){
    this();
    this.expr = expr;
    buildNFA(this);
  }
  public State getStart(){
    return start;
  }
  public void setStart(State start){
    this.start = start;
  }
  public State getEnd(){
    return end;
  }
  public void setEnd(State end){
    this.end = end;
  }
  public Expression getExpr(){
    return expr;
  }
  public void setExpr(Expression expr){
    this.expr = expr;
  }
  public void buildNFA(NFA parent){
    switch(parent.getExpr().getExpressionType()){
      case CONCAT:
        concat(parent);
        break;
      case UNION:
        union(parent);
        break;
      case SYMBOL:
        symbol(parent);
        break;
      case STAR:
        star(parent);
        break;
      default:
        break;
    }
  }
  
  public void concat(NFA parent){
    NFA nfa = new NFA();
    NFA nfa1 = new NFA(((ConcatExpression)parent.getExpr()).getExpr1());
    NFA nfa2 = new NFA(((ConcatExpression)parent.getExpr()).getExpr2());
    
    parent.getStart().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getStart());
    nfa.getStart().getTransition()[0] = new Transition(new EpsilonExpression(), nfa1.getStart());
    nfa.getStart().getTransition()[1] = new Transition(new EpsilonExpression(), nfa2.getStart());
    nfa1.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getEnd());
    nfa2.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getEnd());
    nfa.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), parent.getEnd());
   }
   
   public void symbol(NFA parent){
    NFA nfa = new NFA();
    
    parent.getStart().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getStart());
    nfa.getStart().getTransition()[0] = new Transtion(parent.getExpr(), nfa.getEnd());
    nfa.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), parent.getEnd());
   }
   
   public void star(NFA parent){
    NFA nfa = new NFA();
    
    nfa.getStart().getTransition()[0] = new Transition(parent.getExpr(), nfa.getEnd());
    nfa.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getStart());
    parent.getStart().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getStart());
    nfa.getEnd().getTransition()[1] = new Transition(new EpsilonExpression(), parent.getEnd());
   }
   
   public void union(NFA parent) {
    NFA nfa = new NFA();
    NFA nfa1 = new NFA(((UnionExpression)parent.getExpr()).getExpr1());
    NFA nfa2 = new NFA(((UnionEpxression)parent.getExpr()).getExpr2());
    
    parent.getStart().getTransition()[0] = new Transtion(new EpsilonExpression(), nfa.getStart());
    nfa.getStart().getTransition()[0] = new Transition(new EpsilonExpression(), nfa1.getStart());
    nfa1.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), nfa2.getStart());
    nfa2.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), nfa.getEnd());
    nfa.getEnd().getTransition()[0] = new Transition(new EpsilonExpression(), parent.getEnd());
   }
}
