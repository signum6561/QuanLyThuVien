package test;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import application.entity.Sach;
import application.entity.SachGiaoKhoa;
import common.IdGenerator;
import common.SachFactory;
import common.TinhTrang;
import database.SachDatabaseFile;

public class InitDatabaseTest {
    public static void main(String[] args) {
        String filePath = new StringBuilder()
            .append(Path.of("").toAbsolutePath().toString())
            .append(File.separator)
            .append("data")
            .append(File.separator)
            .append("sach.db")
            .toString();
        SachDatabaseFile dbFile = new SachDatabaseFile(filePath);

        SachFactory sachFactory = new SachFactory(new IdGenerator(), new Random());
        List<Sach> sachList = sachFactory.generate(100);
        sachList.add(new SachGiaoKhoa("B-11111-22222", LocalDate.now(), 10000, 10, "IPM", TinhTrang.MOI));
        dbFile.writeAll(sachList);
        for (Sach sach : dbFile.readAll()) {
            System.out.println(sach);
        }
    }
}
