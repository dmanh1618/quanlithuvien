package com.company.DocGhiFile;


import com.company.DoiTuong.Sach;

import java.io.*;
import java.util.ArrayList;

public class SachDAL{

    public void Luu(ArrayList<Sach> saches) throws IOException {
        File file=new File("Sach.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        for (Sach s:
             saches) {
            fileOutputStream.write(s.toString().getBytes());
        }
    }

    public ArrayList<Sach> Doc() {
        ArrayList<Sach>saches=new ArrayList<>();
        try {
            File file=new File("Sach.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null)
            {
                //maSach+"#"+tenSach+"#"+tenTg+"#"+nhaXb+"#"+ngaySx+"#"+soLuong;
                String masach=line.split("#")[0];
                String tensach=line.split("#")[1];
                String tentg=line.split("#")[2];
                String nhaxb=line.split("#")[3];
                String namxb=line.split("#")[4];
                int soluong=Integer.parseInt(line.split("#")[5]);
                Sach s=new Sach(masach,tensach,tentg,nhaxb,namxb,soluong);
                saches.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saches;
    }
}
