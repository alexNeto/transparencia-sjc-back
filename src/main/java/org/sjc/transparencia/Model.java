package org.sjc.transparencia;

import java.util.List;
import java.util.UUID;

public interface Model<T> {

    List<T> retrieveAll();

    T retrieveByUuid(UUID uuid);

    T retrieve(T t);

    UUID insert(T t);

    Boolean delete(UUID uuid);
}
