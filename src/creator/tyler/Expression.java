package creator.tyler;

public interface Expression
{
    double getValue();
}

class Number implements Expression
{
    double value;

    public Number(String value)
    {
        this.value = Double.valueOf(value);
    }

    @Override
    public double getValue()
    {
        return value;
    }
}

abstract class BinaryOperator implements Expression
{
    Expression left;
    Expression right;

    public BinaryOperator(Expression left)
    {
        this.left = left;
    }

    public Expression getLeft()
    {
        return left;
    }

    public Expression getRight()
    {
        return right;
    }

    public Expression setRight(Expression right)
    {
        this.right = right;
        return this;
    }
}

class Sum extends BinaryOperator
{
    public Sum(Expression left)
    {
        super(left);
    }

    @Override
    public double getValue()
    {
        return left.getValue() + right.getValue();
    }
}




// 123 + 243 + 789 =
// + +
// 1 ++ 2
// 88 +
// 1 +* 2 -> 1 * 2
class AST
{

    public void PlusButtonHandler()
    {
        if (!ast.addSum())
        {
            DisplayModal("Need to enter a number first!!!");
        }
    }

    private Expression root;

    public boolean addSum(String value)
    {
        if (value.isBlank()) return false;
        Expression left = new Number(value);
        if (root == null)
        {
            root = new Sum(left);
        }
        else
        {
            root = new Sum(((BinaryOperator) root).setRight(left));
        }
        return true;
    }

    public double evaluate(String value)
    {
        if (value.isBlank()) throw new IllegalArgumentException();
        Expression right = new Number(value);
        if (root == null)
        {
            root = right;
        }
        else
        {
            ((BinaryOperator) root).setRight(right);
        }
        return root.getValue();
    }
}

// accumulate digits into a complete number
// when user enters operator, previous number becomes left argument
// operator becomes root
// next number becomes right argument
// (+ 12 14 42 39)
// 12<enter>
// 14<enter>
// 42<enter>
// 39<enter>
// +
// 12 + (14 + (42 + 39))