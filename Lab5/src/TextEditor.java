import java.util.ArrayList;
import java.util.List;

// Текстовый редактор, который использует выражения для коррекции текста
class TextEditor {
    private List<AbstractExpression> expressions = new ArrayList<>();

    public TextEditor() {
        // Добавляем все выражения в коллекцию
        expressions.add(new MultipleSpacesExpression());
        expressions.add(new HyphenToEmDashExpression());
        expressions.add(new QuotationMarksExpression());
        expressions.add(new TabCorrectionExpression());
        expressions.add(new BracketSpacesExpression());
        expressions.add(new PunctuationSpacesExpression());
        expressions.add(new MultipleLineBreaksExpression());
    }

    public String correctText(String text) {
        Context context = new Context(text);

        // Применяем каждое выражение по очереди
        for (AbstractExpression expression : expressions) {
            expression.interpret(context);
        }

        return context.getText();
    }
}
