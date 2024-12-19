package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.entity.Sach;
import application.entity.SachGiaoKhoa;
import application.entity.SachThamKhao;
import common.AppConstant;
import common.IdGenerator;
import common.TinhTrang;
import database.SachDatabaseFile;

public class InitDatabaseTest {
    public static void main(String[] args) {
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);
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
        sachList.add(new SachGiaoKhoa("B-11111-22222", LocalDate.now(), 10000, 10, "Kim Dong", TinhTrang.MOI));
        dbFile.writeAll(sachList);
        for (Sach sach : dbFile.readAll()) {
            System.out.println(sach);
        }
    }
}
