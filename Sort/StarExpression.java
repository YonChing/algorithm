public class StarEpxression implements Exprssion {
  private Expression expr;
  public static final ExpressionType TYPE = ExpressionType.STAR;
  public StarExpression(Expression expr1, Expression expr2){
    this.expr = expr;
  }
  public ExpressionType getExpressionType(){
    return TYPE;
  }
  public Expression getExpr(){
    return expr;
  }
 
}
