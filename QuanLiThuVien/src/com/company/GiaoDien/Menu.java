package com.company.GiaoDien;

import com.company.ChucNang.CN_DocGia;
import com.company.ChucNang.CN_Sach;
import com.company.DocGhiFile.DocGiaDAL;
import com.company.DocGhiFile.SachDAL;
import com.company.DoiTuong.DocGia;
import com.company.DoiTuong.Sach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static ArrayList<Sach> saches=new ArrayList<>();
    static ArrayList<DocGia>nguois=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public  int Menu()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("║           Chương trình quản lý thư viện         ║");
        System.out.println("---------------------------------------------------");
        System.out.println("║               1. Quản lý người mượn             ║");
        System.out.println("║               2. Quản lý sách                   ║");
        System.out.println("║               3. Thoát                          ║");
        System.out.println("---------------------------------------------------");
        int number;
        do {
            System.out.print(" Chọn: ");
            number = sc.nextInt();
            sc.nextLine();
        }while (number<1 || number >3);

        return number;
    }
    public  int Menu1()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("║                 Quản lý sách                    |");
        System.out.println("---------------------------------------------------");
        System.out.println("║                1. Thêm sách                     ║");
        System.out.println("║                2. Hiện sách                     ║");
        System.out.println("║                3. Tìm Sách                      ║");
        System.out.println("║                4. Xóa sách                      ║");
        System.out.println("║                5. Sửa thông tin sách            ║");
        System.out.println("║                6. Trở lại                       ║");
        System.out.println("---------------------------------------------------");
        int number;
        do {
            System.out.print("Chọn: ");
            number = sc.nextInt();
            sc.nextLine();
        }while (number<1 || number >6);
        return number;
    }
    public  int Menu2()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("║               Quản lý người mượn                ║");
        System.out.println("---------------------------------------------------");
        System.out.println("║              1. Thêm người mượn                 ║");
        System.out.println("║              2. Hiện người mượn                 ║");
        System.out.println("║              3. Tìm kiếm người mượn             ║");
        System.out.println("║              4. Xóa người mượn                  ║");
        System.out.println("║              5. Sửa thông tin người mượn        ║");
        System.out.println("║              6. Trả sách                        ║");
        System.out.println("║              7. Thống kê người nợ               ║");
        System.out.println("║              8. Quay lại                        ║");
        System.out.println("---------------------------------------------------");
        int number;
        do {
            System.out.print("Chọn: ");
            number = sc.nextInt();
            sc.nextLine();
        }while (number<1 || number >8);
        return number;
    }
    public  void Docfile()
    {
        DocGiaDAL ng=new DocGiaDAL();
        nguois=ng.Doc();
        SachDAL sach=new SachDAL();
        saches=sach.Doc();
    }
    public  void Luufile() throws IOException {
        DocGiaDAL ng=new DocGiaDAL();
        ng.Luu(nguois);
        SachDAL sach=new SachDAL();
        sach.Luu(saches);
    }
    public  void Run() throws IOException {
        String ma;
        int chon;
        do {
            chon=Menu();
            switch (chon)
            {
                case 1:
                    CN_DocGia ng=new CN_DocGia();
                    do {
                        chon=Menu2();
                        switch (chon)
                        {
                            case 1:
                                ng.Them(nguois);
                                break;
                            case 2:
                                ng.Hien(nguois);
                                sc.nextLine();
                                break;
                            case 3:
                                System.out.print("Nhập mã thẻ cần tìm hoặc nhập họ tên: ");
                                ma=sc.nextLine();
                                ng.Tim(nguois,ma);
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.print("Nhập mã thẻ cần xóa: ");
                                ma= sc.nextLine();
                                ng.Xoa(nguois,ma);
                                sc.nextLine();
                                break;
                            case 5:
                                System.out.print("Nhập mã thẻ cần sửa: ");
                                ma=sc.nextLine();
                                ng.Sua(nguois,ma);
                                break;
                            case 6:
                                System.out.print("Nhập mã thẻ người trả: ");
                                ma=sc.nextLine();
                                System.out.print("Nhập mã sách trả: ");
                                String masach=sc.nextLine();
                                ng.Tra(nguois,ma,masach);
                                sc.nextLine();
                                break;
                            case 7:
                                ng.Thongke(nguois);
                                sc.nextLine();
                                break;
                        }
                    }while (chon!=8);
                    break;
                case 2:
                    do {
                        CN_Sach sach=new CN_Sach();
                        chon=Menu1();
                        switch (chon)
                        {
                            case 1:
                                sach.Them(saches);
                                break;
                            case 2:
                                sach.Hien(saches);
                                sc.nextLine();
                                break;
                            case 3:
                                System.out.print("Nhập mã sách hoặc tên sách cần tìm: ");
                                ma=sc.nextLine();
                                sach.Tim(saches,ma);
                                sc.nextLine();
                                break;
                            case 4:
                                System.out.print("Nhập mã sách cần xóa: ");
                                ma=sc.nextLine();
                                sach.Xoa(saches,ma);
                                sc.nextLine();
                                break;
                            case 5:
                                System.out.print("Nhập mã sách cần sửa: ");
                                ma=sc.nextLine();
                                sach.Sua(saches,ma);
                                break;
                        }
                    }while (chon!=6);
                    break;
                case 3:
                    Luufile();
                    System.exit(0);
                    break;
            }
        }while (true);
    }
    public  void Pass() throws IOException {

        do {
            System.out.println("---------------------------------------------------");
            System.out.println("║                   Đăng nhập                     ║");
            System.out.println("---------------------------------------------------");
            System.out.print("          Tài Khoản:(manh)  ");
            String tk=sc.nextLine();
            System.out.print("          Mật Khẩu: (manh)  ");
            String mk=sc.nextLine();
            System.out.println("---------------------------------------------------");

            if(tk.equalsIgnoreCase("manh")&&mk.equalsIgnoreCase("manh"))
            {
                Docfile();
                Run();
            }
            else
            {
                System.out.println("Tài khoản hoặc mật khẩu nhập sai vui lòng nhâp lại. ");
            }
        }while (true);
    }
}
