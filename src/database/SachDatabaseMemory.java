package database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.TinhTrang;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

public class SachDatabaseMemory {
    private List<Sach> sachList;

    public SachDatabaseMemory() {
        sachList = new ArrayList<>();
        sachList.add(new SachGiaoKhoa("B-MM323-43GF5", LocalDate.parse("2021-01-01"), 100000, 10, "Kim Dong", TinhTrang.Moi));
        sachList.add(new SachGiaoKhoa("B-M2334-GRF54", LocalDate.parse("2021-02-11"), 110000, 11, "IPM", TinhTrang.Cu));
        sachList.add(new SachThamKhao("B-TK324-G4354", LocalDate.parse("2021-02-11"), 110000, 11, "IPM", 0.5));
        sachList.add(new SachThamKhao("B-T7604-GGF54", LocalDate.parse("2021-02-11"), 110000, 11, "IPM", 0.4));
        sachList.add(new SachThamKhao("B-BG564-F54GG", LocalDate.parse("2021-02-11"), 110000, 11, "Kim Dong", 0.2));
    }

    public Sach selectById(String id) {
        return sachList
                .stream()
                .filter(sach -> sach.getMaSach().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Sach> selectAll() {
        return sachList;
    }

    public void insert(Sach sach) {
        sachList.add(sach);
    }

    public void update(Sach sach) {
        for(int i = 0; i < sachList.size(); i++) {
            if(sachList.get(i).getMaSach().equals(sach.getMaSach())) {
                sachList.set(i, sach);
                break;
            }
        }
    }

    public void delete(String id) {
        for(int i = 0; i < sachList.size(); i++) {
            if(sachList.get(i).getMaSach().equals(id)) {
                sachList.remove(i);
                break;
            }
        }
    }

    public List<Sach> findByPattern(String pattern) {
        return sachList
            .stream()
            .filter(sach -> 
                sach.getMaSach().contains(pattern) 
                || sach.getNhaXuatBan().contains(pattern)
                || sach.getNgayNhap().toString().contains(pattern)
            )
            .toList();
    }

    public int getCount() {
        return sachList.size();
    }
}
