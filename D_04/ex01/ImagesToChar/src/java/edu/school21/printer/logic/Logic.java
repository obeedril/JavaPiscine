package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {

    private BufferedImage img = null;
    int height;
    int width;
    String arrImg[][];

    public Logic() {

//        File file = new File("/resources/image.bmp");
//        if (!file.getName().equals("image.bmp")){
//            System.err.println("Wrong name of file");
//            System.exit(-1);
//        }
//        if (!file.exists()){
//            System.err.println("There isn't the file in this directory");
//            System.exit(-1);
//        }
        try {
//            img = ImageIO.read(file);
            img = ImageIO.read(Logic.class.getResource("/resources/image.bmp"));
        } catch (IOException e) {
        }
        height = img.getHeight();
        width = img.getWidth();
    }
    public void fullArr(String white, String black) {
        arrImg = new String[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));
                if (color.equals(Color.black)) {
                    arrImg[x][y] = black;
                    System.out.print(arrImg[x][y]);
                }
                if (color.equals(Color.white)) {
                    arrImg[x][y] = white;
                    System.out.print(arrImg[x][y]);
                }
            }
            System.out.print('\n');
        }
    }
}
