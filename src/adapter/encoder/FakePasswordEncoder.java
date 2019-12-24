package adapter.encoder;

import usecase.port.encoder.PasswordEncoder;

public class FakePasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String str) {
        return str + ": FooBar";
    }
}
