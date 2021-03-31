package guru.springframework;

public class Sum implements Expression {
    final Expression augmend;
    final Expression addmend;

    public Sum(Expression augmend, Expression addmend){
        this.augmend = augmend;
        this.addmend = addmend;
    }

    // Take two Money objects, add their respective amounts to produce one Money Object
    // with a currency value specified in the "to" parameter
    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank,to).amount + addmend.reduce(bank,to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this,addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
