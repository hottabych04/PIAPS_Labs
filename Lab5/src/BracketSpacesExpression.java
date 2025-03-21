// Выражение для исправления пробелов в скобках
class BracketSpacesExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();
        // Удаляем пробел после открывающей скобки
        text = text.replaceAll("\\(\\s+", "(");
        // Удаляем пробел перед закрывающей скобкой
        text = text.replaceAll("\\s+\\)", ")");
        context.setText(text);
    }
}
