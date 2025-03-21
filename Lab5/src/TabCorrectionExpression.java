// Выражение для исправления табуляции
class TabCorrectionExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();
        // Заменяем последовательности табов на один таб
        text = text.replaceAll("\\t+", "\t");
        context.setText(text);
    }
}
