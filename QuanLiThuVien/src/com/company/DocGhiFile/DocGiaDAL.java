package com.company.DocGhiFile;


import com.company.DoiTuong.DocGia;

import java.io.*;
import java.util.ArrayList;

public class DocGiaDAL {

    public void Luu(ArrayList<DocGia> nguois) throws IOException {
        File file = new File("Nguoi.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        for (DocGia ng :nguois)
        {
            fileOutputStream.write(ng.toString().getBytes());
        }
    }


    public ArrayList<DocGia> Doc() {
        ArrayList<DocGia>nguois=new ArrayList<>();
        try
        {
            File file =new File("Nguoi.txt");
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null)
            {
                // maThe+"#"+hoTen+"#"+maLop+"#"+maSach+"#"+ngayMuon+"#"+ngayTra+"#"+soLuong;
                String mathe=line.split("#")[0];
                String ten=line.split("#")[1];
                String lop=line.split("#")[2];
                String masach=line.split("#")[3];
                String ngaymuon=line.split("#")[4];
                String ngaytra=line.split("#")[5];
                int soluong=Integer.parseInt(line.split("#")[6]);
                DocGia s=new DocGia(mathe,ten,lop,masach,ngaymuon,ngaytra,soluong);
                nguois.add(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nguois;
    }
}
