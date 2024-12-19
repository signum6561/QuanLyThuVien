package database.dao.TimKiemSach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseFile;

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
