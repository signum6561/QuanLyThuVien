package database.dao;

import java.util.List;

import control.TimKiemSachDAO;
import database.SachDatabaseFile;
import entity.Sach;

public class TimKiemSachDAOFile implements TimKiemSachDAO {
    private final SachDatabaseFile dbFile;

    public TimKiemSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public List<Sach> layKetQuaTimKiem(String pattern) {
        List<Sach> sachList = dbFile.readAll();
        return sachList.stream()
            .filter(sach -> sach.getMaSach().contains(pattern)
                || sach.getNhaXuatBan().contains(pattern)
                || sach.getNgayNhap().toString().contains(pattern)
            )
            .toList();
    }

}
