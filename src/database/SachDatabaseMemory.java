package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Sach;

public class SachDatabaseMemory {
    private Map<String, Sach> sachList;

    public SachDatabaseMemory() {
        sachList = new HashMap<>();
    }

    public Sach selectById(String id) {
        return sachList.get(id);
    }

    public List<Sach> selectAll() {
        return new ArrayList<>(sachList.values());
    }

    public void insert(Sach sach) {
        sachList.put(sach.getMaSach(), sach);
    }

    public void update(Sach sach) {
        sachList.put(sach.getMaSach(), sach);
    }

    public void delete(String id) {
        sachList.remove(id);
    }

    public int getCount() {
        return sachList.size();
    }
}
