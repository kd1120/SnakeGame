import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    int B_HEIGHT = 1000;
    int B_WIDTH = 1000;
    int MAX_DOTS = 2500;
    int DOT_SIZE = 10;
    int DOTS;
    int x[] = new int[MAX_DOTS];
    int y[] = new int[MAX_DOTS];

    int apple_x;
    int apple_y;

    //images

    Image body, head, apple;

    Timer timer;
    int DELAY = 300;
    boolean left = true;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    boolean inGame = true;


    Board() {
        TAdapter tAdapter = new TAdapter();
        addKeyListener(tAdapter);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);
        setBackground((Color.BLACK));
        initGame();
        load();
    }

    public void initGame() {
        DOTS = 3;
        x[0] = 300;
        y[0] = 300;
        for (int i = 0; i < DOTS; i++) {
            x[i] = x[0] + DOT_SIZE * i;
            y[i] = y[0];

        }
        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();


    }

    // load images from resources
    public void load() {
        ImageIcon bodyIcon = new ImageIcon("src/resources/dot.png");
        body = bodyIcon.getImage();

        ImageIcon headIcon = new ImageIcon("src/resources/head.png");
        head = headIcon.getImage();

        ImageIcon appleIcon = new ImageIcon("src/resources/apple.png");
        apple = appleIcon.getImage();

    }

    //draw images at snakes and apples position
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

    }

    // draw image
    public void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this);
            for (int i = 0; i < DOTS; i++)
                if (i == 0) {
                    g.drawImage(head, x[0], y[0], this);

                } else {
                    g.drawImage(body, x[i], y[i], this);
                }
        } else {
            gameOver(g);
            timer.stop();
        }
    }

    public void locateApple() {
        apple_x = (int) (Math.random() * 39) * DOT_SIZE;
        apple_y = (int) (Math.random() * 39) * DOT_SIZE;

    }

    //check in game
    public void checkCollision() {
        for (int i = 1; i < DOTS; i++) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {

                inGame = false;
            }
        }
        if (x[0] < 0) {
            inGame = false;

        }
        if (x[0] >= B_WIDTH) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
        if (y[0] >= B_HEIGHT) {
            inGame = false;

        }


    }

    public void gameOver(Graphics g) {
        String msg = "GAME OVER";
        int score = (DOTS - 3) * 100;
        String scrmsg = "Score:" + Integer.toString(score);
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fontMetrics = getFontMetrics(small);

        g.setColor(Color.BLUE);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fontMetrics.stringWidth(msg)) / 2, B_HEIGHT / 4);
        g.drawString(scrmsg, (B_WIDTH - fontMetrics.stringWidth(scrmsg)) / 2, 3 * (B_HEIGHT / 4));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }

    public void move() {
        for (int i = DOTS - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;

        }
        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple() {
        if (apple_x == x[0] && apple_y == y[0]) {
            DOTS++;
            if (DELAY > 90) {
                DELAY -= 30;
            }
            timer = new Timer(DELAY, this);
            timer.start();

            locateApple();
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int key = keyEvent.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down) {
                up = true;
                right = false;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                down = true;
                right = false;
                left = false;
            }
        }

    }

}

