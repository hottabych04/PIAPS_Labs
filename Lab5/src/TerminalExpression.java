// Абстрактный класс терминального выражения
abstract class TerminalExpression implements AbstractExpression {
    @Override
    public abstract void interpret(Context context);
}
