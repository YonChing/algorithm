public class SingleSymbolEpxression implements Exprssion {
  private Symbol Symbol;
  public static final ExpressionType TYPE = ExpressionType.SYMBOL;
  public SingleSymbolExpression(Symbol symbol){
    this.symbol = symbol;
  }
  public ExpressionType getExpressionType(){
    return TYPE;
  }
  
 
}
