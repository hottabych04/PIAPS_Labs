// Демонстрационный класс
public class TextEditorApp {
    public static void main(String[] args) {
        String inputText = "Это  пример   текста с множественными  пробелами,\n\n\n"
                + "с использованием дефиса - вместо тире,\n"
                + "с \"неправильными\" кавычками,\n"
                + "с неправильными\t\t\tтабуляторами,\n"
                + "с лишними пробелами ( в скобках ) и перед , запятой .\n";

        TextEditor editor = new TextEditor();
        String correctedText = editor.correctText(inputText);

        System.out.println("Исходный текст:");
        System.out.println(inputText);

        System.out.println("\nИсправленный текст:");
        System.out.println(correctedText);
    }
}