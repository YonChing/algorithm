public class AST {
 private String expr;
 public static final Map<Character, Integer> isp = new Hash<Character, Integer>();
 static {
  isp.put('(', 1);
  isp.put('|', 2);
  isp.put('-', 3);
 }
 private Stack<Expression> ast;
 public AST(String expr){
  this.expr = expr;
  ast = new Stack<Expression>();
 }
 public String getExpr(){
  return expr;
 }
 public void setExpr(String expr){
  this.expr = expr;
 }
 public Expression buildAST(){
  Stack<Character> ops = new Stack<Character>();
  for(int i = 0; i < expr.length; i++) {
    if(expr.charAt(i) == '(') {
      ops.push(expr.charAt(i));
    } else if(expr.chartAt(i) == '*') {
      ast.push(new StarExpression(ast.pop()));
      if((i+1) < expr.length() && ast.peek() != null && expr.charAt(i+1) != '*' 
        && expr.charAt(i+1) != '|' && expr.charAt(i+1) != ')') {
        ops.push('-');
      }
    } else if(expr.charAt(i) == '|') {
      ops.push(expr.charAt(i));
    } else if(expr.charAt(i) == ')) {
      while(ops.peek() != '(') {
        char op = ops.pop();
        if(op == '-') {
          Expression e2 = ast.pop();
          Expression e1 = ast.pop();
          ast.push(new ConcatExpression(e1, e2));
        } else if(op == '|') {
          Expression e2 = ast.pop();
          Expression e1 = ast.pop();
          ast.push(new UnionExpression(e1, e2));
        }
        ops.pop();
        if((i+1) < expr.length() && ast.peek() != null && expr.charAt(i+1) != '*' 
          && expr.charAt(i+1) != '|' && expr.charAt(i+1) != ')') {
         ops.push('-');
        }
      }
    } else {
        ast.push(new SingleSymbolExpression(new Symbol(expr.charAt(i))));
        if((i+1) < expr.length() && ast.peek() != null && expr.charAt(i+1) != '*' 
          && expr.charAt(i+1) != '|' && expr.charAt(i+1) != ')') {
          Stack<Character> temp = new Stack<Character>();
          while(!ops.isEmpty() && isp.get('-') < isp.get(ops.peek())) {
            temp.push(ops.pop());
          }
          ops.push('-');
          while(!temp.isEmpty()) {
            ops.push(temp.pop());
          }
        }
      }
    }
    while(!ops.isEmpty()) {
      char op = ops.pop();
      if(op == '-') {
        Expression e2 = ast.pop();
        Expression e1 = ast.pop();
        ast.push(new ConcatEpxression(e1, e2));
      } else if(op == '|') {
        Expression e2 = ast.pop();
        Expression e1 = ast.pop();
        ast.push(new UnionExpression(e1, e2));
      }
    }
    if(ast.isEmpty()) {
      return new EpsilonExpression();
    } else {
      return ast.pop();
    }
 }
}
 
