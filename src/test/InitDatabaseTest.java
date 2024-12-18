package test;

import java.util.ArrayList;
import java.util.List;

import common.AppConstant;
import common.TinhTrang;
import database.SachDatabaseFile;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import util.IdGenerator;

public class InitDatabaseTest {
    public static void main(String[] args) {
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_FILE_PATH);
        IdGenerator idGenerator = new IdGenerator();
        List<Sach> sachList = new ArrayList<>();
        sachList.add(new SachGiaoKhoa("2021-01-01", 10000, 10, "Kim Dong", TinhTrang.MOI));
        sachList.add(new SachGiaoKhoa("2021-02-11", 11000, 11, "IPM", TinhTrang.CU));
        sachList.add(new SachThamKhao("2021-02-11", 19000, 11, "IPM", 0.5));
        sachList.add(new SachThamKhao("2021-02-11", 21000, 11, "IPM", 0.4));
        sachList.add(new SachThamKhao("2021-02-11", 31000, 11, "Kim Dong", 0.2));
        sachList.forEach(sach -> {
            sach.setMaSach(idGenerator.generate());
        });
        dbFile.writeAll(sachList);
        for (Sach sach : dbFile.readAll()) {
            System.out.println(sach);
        }
    }
}
