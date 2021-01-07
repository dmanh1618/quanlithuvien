package com.company.DoiTuong;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tenTg;
    private String nhaXb;
    private String namXb;
    private int soLuong;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTg() {
        return tenTg;
    }

    public void setTenTg(String tenTg) {
        this.tenTg = tenTg;
    }

    public String getNhaXb() {
        return nhaXb;
    }

    public void setNhaXb(String nhaXb) {
        this.nhaXb = nhaXb;
    }

    public String getNamXb() {
        return namXb;
    }

    public void setNamXb(String namXb) {
        this.namXb = namXb;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Sach(String maSach, String tenSach, String tenTg, String nhaXb, String namXb, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTg = tenTg;
        this.nhaXb = nhaXb;
        this.namXb = namXb;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return maSach+"#"+tenSach+"#"+tenTg+"#"+nhaXb+"#"+namXb+"#"+soLuong+"\n";
    }
}
