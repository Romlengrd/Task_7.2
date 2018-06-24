package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Prop <T> implements Runnable {
    private File file = new File("src\\com\\company\\file.properties");

    private Properties properties = new Properties();
    private int n;
    //private String s=null;

    private void getFile() {
        try (FileReader fileReader = new FileReader(file)) {
            synchronized (this) {
                properties.load(fileReader);
            }
            n = properties.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    void getProps () throws NoSuchFieldException {
        Object[] values = new Object[properties.size()];
        T value1 = (T) properties.getProperty("value1");
        values[0]=value1;
        T value2 = (T) properties.getProperty("value2");
        values[1]=value2;
        T value3 = (T) properties.getProperty("value3");
        values[2]=value3;
        T value4 = (T) properties.getProperty("value4");
        values[3]=value4;
        T value5 = (T) properties.getProperty("value7"); //Ошибка ключа, выбрасывается исключение
        values[4]=value5;

        for (int i=0;i<n;i++) {
            if (values[i] != null) {
                System.out.println(values[i]);
            } else {
                System.out.println("номер поля " +i);
                throw new NoSuchFieldException("нэт такого поля");
            }
        }


    }

    @Override
    public void run() {
        getFile();
    }
}
