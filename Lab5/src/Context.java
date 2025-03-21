// Контекст, содержащий информацию, которую интерпретируют выражения
class Context {
    private String text;

    public Context(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
