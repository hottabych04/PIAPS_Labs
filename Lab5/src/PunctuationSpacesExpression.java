// Выражение для исправления пробелов перед знаками пунктуации
class PunctuationSpacesExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();
        // Удаляем пробел перед запятой
        text = text.replaceAll("\\s+,", ",");
        // Удаляем пробел перед точкой
        text = text.replaceAll("\\s+\\.", ".");
        context.setText(text);
    }
}
