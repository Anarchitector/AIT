package models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class LabworkRepo {
    private HashMap<Long, Labwork> map;

    public LabworkRepo() {
        this.map = new HashMap<>();
    }

    public Collection<Labwork> getValues() {
        return map.values();
    }

    public void add(Labwork labwork) {
        map.put(labwork.getId(), labwork);
    }

    public Labwork getById(int id) {
        return map.get(id);
    }

    public int size() {
        return this.map.size();
    }

    public boolean containsKey(int idValue) {
        return this.map.containsKey(idValue);
    }

    public void remove(int idValue) {
        this.map.remove(idValue);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<Long> getIdSet() {
        return this.map.keySet();
    }
}

