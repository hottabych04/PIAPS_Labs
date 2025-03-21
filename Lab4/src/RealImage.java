import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Класс, представляющий реальное изображение
class RealImage implements Image {
    private String filename;
    private BufferedImage image;
    private int width;
    private int height;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    // Загрузка изображения с диска
    private void loadImageFromDisk() {
        try {
            image = ImageIO.read(new File(filename));
            width = image.getWidth();
            height = image.getHeight();
            System.out.println("Изображение " + filename + " загружено с диска");
        } catch (IOException e) {
            System.err.println("Ошибка загрузки изображения: " + e.getMessage());
            // Устанавливаем дефолтные размеры при ошибке
            width = 200;
            height = 150;
        }
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x, y, null);
        } else {
            // Если изображение не удалось загрузить, отображаем заглушку
            g.setColor(Color.RED);
            g.drawRect(x, y, width, height);
            g.drawString("Ошибка загрузки", x + 10, y + height / 2);
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
