package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}