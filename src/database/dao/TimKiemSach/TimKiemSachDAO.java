package database.dao.TimKiemSach;

import java.util.List;

import application.entity.Sach;

public interface TimKiemSachDAO {
    List<Sach> layKetQuaTimKiem(String pattern);
}
