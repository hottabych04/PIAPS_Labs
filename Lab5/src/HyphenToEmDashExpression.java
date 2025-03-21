// Выражение для замены дефиса на тире в соответствующих контекстах
class HyphenToEmDashExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();
        // Заменяем дефис на тире, когда он окружен пробелами
        text = text.replaceAll("\\s-\\s", " — ");
        context.setText(text);
    }
}
