abstract class Expr
case class Num(value: Int) extends Expr
case class Var(name: String) extends Expr
case class UnOp(op: String, expr: Expr) extends Expr
case class BinOp(op: String, left: Expr, right: Expr) extends Expr
