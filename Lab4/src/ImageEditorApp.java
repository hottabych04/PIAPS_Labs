import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Основной класс приложения
public class ImageEditorApp extends JPanel {
    private Image image;
    private int currentX = 50;
    private int currentY = 50;
    private boolean isDragging = false;
    private Point dragStartPoint;

    public ImageEditorApp() {
        // Создаем прокси-изображение
        image = new ProxyImage("TestImage.jpg");

        // Настраиваем обработчики событий мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Проверяем, находится ли курсор над изображением
                if (e.getX() >= currentX && e.getX() <= currentX + image.getWidth() &&
                        e.getY() >= currentY && e.getY() <= currentY + image.getHeight()) {

                    // Правая кнопка мыши
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        // Двойной клик правой кнопкой
                        if (e.getClickCount() == 2) {
                            // Загружаем реальное изображение
                            ((ProxyImage) image).loadImage();
                            repaint();
                        }
                    } else if (e.getButton() == MouseEvent.BUTTON1) {
                        // Левая кнопка мыши - начало перетаскивания
                        isDragging = true;
                        dragStartPoint = e.getPoint();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    // Вычисляем новую позицию изображения
                    int dx = e.getX() - dragStartPoint.x;
                    int dy = e.getY() - dragStartPoint.y;
                    currentX += dx;
                    currentY += dy;
                    dragStartPoint = e.getPoint();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Отрисовываем изображение или его заместитель
        image.draw(g, currentX, currentY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Графический редактор - Паттерн Proxy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new ImageEditorApp());
        frame.setVisible(true);
    }
}