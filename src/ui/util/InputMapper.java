package ui.util;

import java.util.Map;

import common.LoaiSach;
import common.TinhTrang;

public final class InputMapper {
    public static final Map<String, LoaiSach> LOAI_SACH = Map.of(
        "0", LoaiSach.GIAO_KHOA,
        "1", LoaiSach.THAM_KHAO
    );

    public static final Map<String, TinhTrang> TINH_TRANG = Map.of(
        "0", TinhTrang.MOI,
        "1", TinhTrang.CU
    );
}
