package adapter.idGenerator;

import usecase.port.idGenerator.IdGenerator;

import java.util.UUID;

public class UUidGenerator implements IdGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
