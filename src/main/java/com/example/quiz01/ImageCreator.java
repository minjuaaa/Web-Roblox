package com.example.quiz01;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCreator {

    public void create(int[] px, int[] py, int size, String filename) {

        int width = 250;
        int height = 250;

        //create a BufferedImage for mentioned image types.
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //create a graphics2d object which can be used to draw into the buffered image
        Graphics2D g2d = buffImg.createGraphics();

        //fill the rectangle with grey color
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, width, height);

        //draw a string
        g2d.setColor(Color.yellow);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g2d.drawString("JavaXp.com", 20, 100);



//        int[] px = {1, 5,110,  150};
//        int[] py = {1, 5, 110, 150};
//        int r = 5;

        g2d.setColor(Color.blue);


        g2d.setStroke(new BasicStroke(10));
        g2d.drawPolyline(px, py, 4);



        //disposes of this graphics context and releases any system resources that it is using
        g2d.dispose();

        //write the image file
        File f = new File(filename);
        try {
            ImageIO.write(buffImg, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(f.getAbsolutePath()+" created successfully!");
    }

}