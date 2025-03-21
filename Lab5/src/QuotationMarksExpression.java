// Выражение для исправления кавычек
class QuotationMarksExpression extends TerminalExpression {
    @Override
    public void interpret(Context context) {
        String text = context.getText();

        // Заменяем парные кавычки на «»
        // Это упрощенная реализация, для полноценной работы с вложенными кавычками
        // требуется более сложная логика
        StringBuilder result = new StringBuilder();
        boolean isOpen = true;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '"') {
                if (isOpen) {
                    result.append('«');
                } else {
                    result.append('»');
                }
                isOpen = !isOpen;
            } else {
                result.append(c);
            }
        }

        context.setText(result.toString());
    }
}
