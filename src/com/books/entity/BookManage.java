package com.books.entity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 图书管理类
 */
public class BookManage {

    List<BookInfo> bList = new ArrayList<BookInfo>(); // 图书类集合

    Scanner input = new Scanner(System.in);

    /**
     * 初始化
     */
    public void initBook(){
        BookInfo bi1 = new BookInfo(1,"金庸全集\t","金庸","2017-05-01","小说/文摘");
        bList.add(bi1);
        BookInfo bi2 = new BookInfo(2,"Java自学通","成峰","2017-06-01","计算机/软件");
        bList.add(bi2);
        BookInfo bi3 = new BookInfo(3,"盗墓笔记","南派三叔","2017-07-01","小说/文摘");
        bList.add(bi3);
    }

    /**
     * 主菜单
     */
    public void showMenu() {
        initBook();
        try {
            do {
                System.out.println("----欢迎使用图书管理系统----");
                System.out.println("1、查看图书信息\n2、新增图书信息\n3、删除图书信息\n4、修改图书信息\n5、退出");
                System.out.println("请按键选择:");
                int choose = input.nextInt();
                switch (choose) {
                    case 1:
                        selBook();
                        continue;
                    case 2:
                        addBook();
                        continue;
                    case 3:
                        delBook();
                        continue;
                    case 4:
                        updBook();
                        continue;
                    case 5:
                        System.out.println("谢谢您的使用!");
                        break;
                }
                break;
            } while (true);
        } catch (InputMismatchException e) {
            System.err.println("输入错误!请输入数字!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("网络异常");
            e.printStackTrace();
        }
    }

    /**
     * 查看图书
     */
    public void selBook(){
        System.out.println("图书名称\t\t图书作者\t\t购买时间\t\t\t图书分类");
        try{
            for(BookInfo bi : bList){
                System.out.println(bi.getName() + "\t\t" + bi.getAuthor() + "\t\t" + bi.getBuyDate() + "\t\t" + bi.getTypeName());
            }
        }catch (IndexOutOfBoundsException e){
            System.err.println("服务器繁忙");
            e.printStackTrace();
            System.exit(-1);
        }catch (Exception e){
            System.err.println("网络异常");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * 新增图书
     */
    public void addBook(){
        try{
            BookInfo bi = new BookInfo();
            System.out.print("请输入图书名称:");
            bi.setName(input.next());
            System.out.print("请输入图书作者:");
            bi.setAuthor(input.next());
            System.out.print("请输入购买时间:");
            bi.setBuyDate(input.next());
            System.out.print("请输入图书分类:");
            bi.setTypeName(input.next());
            bList.add(bi);
            System.out.println("添加成功");
        }catch (Exception e){
            System.err.println("网络异常");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * 删除图书
     */
    public void delBook(){
        try{
            System.out.print("请输入你要删除的图书名称:");
            String name = input.next();
            boolean delete = false;
            for(BookInfo bi : bList){
                if (name.equals(bi.getName().trim())){
                    bList.remove(bi);
                    delete = true;
                    break;
                }
            }
            if (delete){
                System.out.println("删除成功！！！");
            }else{
                System.out.println("没有该图书！！！");
            }
        }catch (IndexOutOfBoundsException e){
            System.err.println("服务器繁忙");
            e.printStackTrace();
            System.exit(-1);
        }catch (Exception e){
            System.err.println("网络异常");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * 修改图书
     */
    public void updBook(){
        try{
            System.out.print("请输入你要修改的图书名称:");
            String name = input.next();
            boolean update = false;
            for(BookInfo bi : bList){
                if (name.equals(bi.getName().trim())){
                    System.out.print("请输入你要修改的书名:");
                    bi.setName(input.next());
                    System.out.print("请输入你要修改的作者:");
                    bi.setAuthor(input.next());
                    System.out.print("请输入你要修改的日期:");
                    bi.setBuyDate(input.next());
                    System.out.print("请输入你要修改的图书分类:");
                    bi.setTypeName(input.next());
                    update = true;
                    break;
                }
            }
            if (update){
                System.out.println("修改成功");
            }else{
                System.out.println("没有该图书");
            }
        }catch (Exception e){
            System.err.println("网络异常");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}