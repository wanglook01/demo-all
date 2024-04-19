package org.example;

public interface Repository<DO, ID> {

    DO get(ID id);

    void delete(ID id);

    ID save(DO entity);
}
