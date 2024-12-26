package common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import application.entity.Sach;
import application.entity.SachGiaoKhoa;
import application.entity.SachThamKhao;

public class SachFactory {
    private IdGenerator idGenerator;
    private Random random;
    private static final String[] nhaXuatBans = {"IPM", "Kim Đồng", "Trẻ", "Amak", "Nhã Nam"};
    
    public SachFactory(IdGenerator idGenerator, Random random) {
        this.idGenerator = idGenerator;
        this.random = random;
    }
    
    public List<Sach> generate(int size) {
        List<Sach> sachList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Sach sach = randomSach();
            sachList.add(sach);
        }
        return sachList;
    }

    public Sach randomSach() {
        int randIndex = random.nextInt(LoaiSach.size);
        LoaiSach loaiSach = LoaiSach.get(randIndex);

        double donGiaRand = random.nextInt(10, 100) / 10.0 * 20000;
        int soLuongRand = random.nextInt(5, 30);
        LocalDate ngayNhapRand = LocalDate.now().minusDays(random.nextInt(0, 100));
        String nhaXuatBanRand = nhaXuatBans[random.nextInt(nhaXuatBans.length)];
        
        Sach sach = getSach(loaiSach);
        sach.setMaSach(idGenerator.generate());
        sach.setNhaXuatBan(nhaXuatBanRand);
        sach.setDonGia(donGiaRand);
        sach.setSoLuong(soLuongRand);
        sach.setNgayNhap(ngayNhapRand);
        return sach;
    }

    private Sach getSach(LoaiSach loaiSach) {
        switch (loaiSach) {
            case GIAO_KHOA:
                return randomSachGiaoKhoa();
            case THAM_KHAO:
                return randomSachThamKhao();
            default:
                return null;
        }
    }

    private SachGiaoKhoa randomSachGiaoKhoa() {
        TinhTrang tinhTrangRand = TinhTrang.get(random.nextInt(TinhTrang.size));
        SachGiaoKhoa sach = new SachGiaoKhoa();
        sach.setTinhTrang(tinhTrangRand);
        return sach;
    }
    
    private SachThamKhao randomSachThamKhao() {
        double thueRand = random.nextInt(10, 40) / 100.0;
        SachThamKhao sach = new SachThamKhao();
        sach.setThue(thueRand);
        return sach;
    }
}
