import java.awt.*;

// Интерфейс Image, определяющий общий API для RealImage и ProxyImage
interface Image {
    void draw(Graphics g, int x, int y);

    int getWidth();

    int getHeight();
}
