package org.sjc.transparencia.cargo;

import java.util.UUID;

public class Cargo {

    private UUID cargo_uuid;
    private String cargo;

    public Cargo(UUID cargo_uuid, String cargo) {
        this.cargo_uuid = cargo_uuid;
        this.cargo = cargo;
    }

    public UUID getCargo_uuid() {
        return cargo_uuid;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo_uuid(UUID cargo_uuid) {
        this.cargo_uuid = cargo_uuid;
    }
}
