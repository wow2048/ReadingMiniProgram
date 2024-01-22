package com.example.model.vo;

import com.example.model.po.bookPO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class bookVO implements Serializable{

    private String bookID;

    private String name;

    private String author;

    private String publisher;

    private String publishingTime;

    private String imageBase64;

    private String brief;

    public bookVO(bookPO bookPO) {
        this.bookID = bookPO.getBookID();
        this.name = bookPO.getName();
        this.author = bookPO.getAuthor();
        this.publisher = bookPO.getPublisher();
        this.publishingTime = bookPO.getPublishingTime();
        this.imageBase64 = getImageBase64(bookPO);
        this.brief = getBrief(bookPO);
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublishingTime(String publishingTime) {
        this.publishingTime = publishingTime;
    }

    public String getPublishingTime() {
        return publishingTime;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    // 读取本地图片获得图片base64二进制流
    private String getImageBase64(bookPO bookPO) {
        String imageUrl = bookPO.getImageUrl();
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            BufferedImage bi;
            bi = ImageIO.read(new File(imageUrl));
            ImageIO.write(bi, "png", baos);
            bytes = baos.toByteArray();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }

    // 读取本地txt获得书籍简介brief
    private String getBrief(bookPO bookPO) {
        String url = bookPO.getTxtUrl();
        File file = new File(url);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
