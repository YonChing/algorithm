public class ConcatEpxression implements Exprssion {
  private Expression expr1;
  private Expression expr2;
  public static final ExpressionType TYPE = ExpressionType.CONCAT;
  public ConcatExpression(Expression expr1, Expression expr2){
    this.expr1 = expr1;
    this.expr2 = expr2;
  }
  public ExpressionType getExpressionType(){
    return TYPE;
  }
  public Expression getExpr1(){
    this.expr1 = expr1;
  }
  public Expression getExpr2(){
    this.expr2 = expr2;
  }
}
