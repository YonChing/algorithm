public class Transition {
  private Expression expr;
  private State translateState;
  
  public Transition(Expression expr, State state) {
    this.expr = expr;
    this.translateState = state;
  }
  
  public Expression getExpr(){
    return expr;
  }
  public void setExpr(Expression expr){
    this.expr = expr;
  }
  public State getTranslateState(){
    return translateState;
  }
  public void setTranslateState(State translateState){
    this.translateState = translateState;
  }
}
