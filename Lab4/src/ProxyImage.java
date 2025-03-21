import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Proxy класс, представляющий заместитель реального изображения
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;
    private int width;
    private int height;
    private boolean isLoaded;

    public ProxyImage(String filename) {
        this.filename = filename;
        this.isLoaded = false;
        // Определяем размеры изображения без полной загрузки
        try {
            // Получаем только метаданные изображения для определения размеров
            BufferedImage tempImage = ImageIO.read(new File(filename));
            if (tempImage != null) {
                width = tempImage.getWidth();
                height = tempImage.getHeight();
            } else {
                width = 200;
                height = 150;
            }
        } catch (IOException e) {
            System.err.println("Не удалось определить размеры изображения: " + e.getMessage());
            // Устанавливаем дефолтные размеры при ошибке
            width = 200;
            height = 150;
        }
    }

    // Метод для явной загрузки реального изображения
    public void loadImage() {
        if (!isLoaded) {
            realImage = new RealImage(filename);
            isLoaded = true;
        }
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        if (isLoaded) {
            // Если изображение загружено, отображаем его
            realImage.draw(g, x, y);
        } else {
            // Иначе отображаем только бокс с размерами изображения
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x + 1, y + 1, width - 1, height - 1);
            g.setColor(Color.BLACK);
            g.drawString("Двойной клик для загрузки", x + 10, y + height / 2);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
