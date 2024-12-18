package database.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.LoaiSach;
import control.LayDSLoaiSachChiTietDAO;
import database.SachDatabaseFile;
import entity.LoaiSachChiTiet;
import entity.Sach;

public class LayDSLoaiSachChiTietDAOFile implements LayDSLoaiSachChiTietDAO {
    private final SachDatabaseFile dbFile;

    public LayDSLoaiSachChiTietDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public List<LoaiSachChiTiet> layDSLoaiSachChiTiet() {
        List<Sach> sachList = dbFile.readAll();
        List<LoaiSachChiTiet> data = new ArrayList<>();
        Map<LoaiSach, LoaiSachChiTiet> loaiSachMap = new HashMap<>();
        for (LoaiSach loaiSach : LoaiSach.values) {
            LoaiSachChiTiet loaiSachChiTiet = new LoaiSachChiTiet();
            loaiSachChiTiet.setTenLoai(loaiSach.getName());
            loaiSachChiTiet.setSachList(new ArrayList<>());
            loaiSachMap.put(loaiSach, loaiSachChiTiet);
            data.add(loaiSachChiTiet);
        }
        sachList.forEach(sach -> {
            loaiSachMap.get(sach.getLoaiSach()).addSach(sach);
        });
        return data;
    }    
}
