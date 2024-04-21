package org.example;

public interface Repository<DO, ID> {

    DO get(ID id);

    ID save(DO entity);
}
