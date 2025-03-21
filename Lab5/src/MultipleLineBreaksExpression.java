// Выражение для исправления множественных переводов строки
class MultipleLineBreaksExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();
        // Заменяем три и более переводов строки на два
        text = text.replaceAll("\\n{3,}", "\n\n");
        context.setText(text);
    }
}
