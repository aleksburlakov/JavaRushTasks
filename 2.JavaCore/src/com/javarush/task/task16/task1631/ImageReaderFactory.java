package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        if (type == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        ImageReader targetImageReader;
        switch (type) {
            case BMP:
                targetImageReader = new BmpReader();
                break;
            case JPG:
                targetImageReader = new JpgReader();
                break;
            case PNG:
                targetImageReader = new PngReader();
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");

        }
        return targetImageReader;
    }
}
