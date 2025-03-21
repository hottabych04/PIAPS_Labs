// Выражение для исправления множественных пробелов
class MultipleSpacesExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();
        // Заменяем два и более пробелов на один
        text = text.replaceAll("\\s{2,}", " ");
        context.setText(text);
    }
}
