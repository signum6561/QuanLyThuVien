package control;

import java.util.List;

import entity.Sach;

public interface TimKiemSachDAO {
    List<Sach> layKetQuaTimKiem(String pattern);
}
