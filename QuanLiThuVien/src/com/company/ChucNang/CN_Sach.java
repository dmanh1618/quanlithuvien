package com.company.ChucNang;

import com.company.DoiTuong.Sach;

import java.util.ArrayList;
import java.util.Scanner;

public class CN_Sach {
    public Scanner sc = new Scanner(System.in);

    public String Rangbuocstring() {
        String rb;
        do {
            rb = sc.nextLine();
            if (!(rb.equalsIgnoreCase(""))) {
                break;
            } else {
                System.out.print("Nhập lại");
            }
        } while (true);
        return rb;
    }

    public int Rangbuocint() {
        int so;
        do {
            try {
                so = Integer.parseInt(sc.nextLine());
                if (so >= 0) {
                    break;
                }
            } catch (Exception exception) {
                System.out.println("phải là số nguyên mời nhập lại");
            }
        } while (true);
        return so;
    }

    public void Them(ArrayList<Sach> saches) {

        System.out.print("         Nhập mã sách: ");
        String masach = Rangbuocstring();
        System.out.print("         Nhập tên sách: ");
        String tensach = Rangbuocstring();
        System.out.print("         Nhâp tên tác giả: ");
        String tentg = Rangbuocstring();
        System.out.print("         Nhập nhà xuất bản: ");
        String nxb = Rangbuocstring();
        System.out.print("         Nhập năm xuất bản: ");
        String namxb = Rangbuocstring();
        System.out.print("         Nhập số lượng sách: ");
        int soluong = Rangbuocint();

        Sach s = new Sach(masach, tensach, tentg, nxb, namxb, soluong);
        saches.add(s);
    }

    public void Hien1sach(Sach s) {
        System.out.printf("║%10s║%30s║%25s║%20s║%20s║%15s║\n", s.getMaSach(), s.getTenSach(), s.getTenTg(), s.getNhaXb(), s.getNamXb(), s.getSoLuong());
    }


    public void Hien(ArrayList<Sach> saches) {

        System.out.printf("║%10s║%30s║%25s║%20s║%20s║%15s║\n", "Mã sách", "Tên sách", "Tên tác giả", "Nhà xuất bản", "Năm xuất bản", "Số lượng");

        for (Sach s :
                saches) {
            Hien1sach(s);
        }

    }


    public void Sua(ArrayList<Sach> saches, String ma) {
        for (Sach s :
                saches) {
            if (s.getMaSach().equalsIgnoreCase(ma)) {


                System.out.print("         Sửa mã sách: ");
                s.setMaSach(sc.nextLine());
                System.out.print("         Sửa tên sách: ");
                s.setTenSach(sc.nextLine());
                System.out.print("         Sửa tên tác giả: ");
                s.setTenTg(sc.nextLine());
                System.out.print("         Sửa nhà xuất bản: ");
                s.setNhaXb(sc.nextLine());
                System.out.print("         Sửa năm xuất bản: ");
                s.setNamXb(sc.nextLine());
                System.out.print("         Sửa số lượng sách: ");
                s.setSoLuong(Integer.parseInt(sc.nextLine()));
            }
        }
    }


    public void Tim(ArrayList<Sach> saches, String ma) {
        boolean kt = false;

        System.out.printf("║%10s║%30s║%25s║%20s║%20s║%15s║\n", "Mã sách", "Tên sách", "Tên tác giả", "Nhà xuất bản", "Năm xuất bản", "Số lượng");

        for (Sach s :
                saches) {
            if (ma.equalsIgnoreCase(s.getMaSach()) || s.getTenSach().toUpperCase().indexOf(ma.toUpperCase()) >= 0) {
                kt = true;
                Hien1sach(s);
            }
        }

        if (!kt) {
            System.out.println("Không có sách hoặc mã sách cần tìm");
        }
    }


    public void Xoa(ArrayList<Sach> saches, String ma) {
        boolean kt = false;
        for (int i = 0; i < saches.size(); i++) {
            if (saches.get(i).getMaSach().equalsIgnoreCase(ma)) {
                kt = true;
                saches.remove(i);
            }
        }
        if (kt) {
            System.out.println("Xóa thành công");
        }
    }
}
