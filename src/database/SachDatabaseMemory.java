package database;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.entity.Sach;
import application.entity.SachGiaoKhoa;
import application.entity.SachThamKhao;
import common.TinhTrang;

public final class SachDatabaseMemory {
    private Map<String, Sach> sachMap;
    public static final SachDatabaseMemory INSTANCE = new SachDatabaseMemory();

    public SachDatabaseMemory() {
        sachMap = new HashMap<>();
        init();
    }
    
    public void init() {
        insert(new SachGiaoKhoa("B-MM323-43GF5", LocalDate.parse("2021-01-01"), 100000, 10, "Kim Dong", TinhTrang.MOI));
        insert(new SachGiaoKhoa("B-M2334-GRF54", LocalDate.parse("2021-02-11"), 110000, 11, "IPM", TinhTrang.CU));
        insert(new SachThamKhao("B-TK324-G4354", LocalDate.parse("2021-02-11"), 110000, 11, "IPM", 0.5));
        insert(new SachThamKhao("B-T7604-GGF54", LocalDate.parse("2021-02-11"), 110000, 11, "IPM", 0.4));
        insert(new SachThamKhao("B-BG564-F54GG", LocalDate.parse("2021-02-11"), 110000, 11, "Kim Dong", 0.2));
    }

    public Sach selectById(String id) {
        return sachMap.get(id);
    }

    public List<Sach> selectAll() {
        return sachMap.values().stream().toList();
    }

    public void insert(Sach sach) {
        sachMap.put(sach.getMaSach(), sach);
    }

    public void update(Sach sach) {
        String maSach = sach.getMaSach();
        if(sachMap.containsKey(maSach)) {
            sachMap.put(maSach, sach);
        }
    }

    public void delete(String id) {
        sachMap.remove(id);
    }

    public List<Sach> selectByPattern(String pattern) {
        return sachMap.values()
            .stream()
            .filter(sach -> 
                sach.getMaSach().contains(pattern) 
                || sach.getNhaXuatBan().contains(pattern)
                || sach.getNgayNhap().toString().contains(pattern)
            )
            .toList();
    }

    public int getCount() {
        return sachMap.size();
    }
}
