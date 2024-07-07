package org.example.protocol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MsgProtocol {

    private int length;

    private byte[] content;

    public MsgProtocol(int length, byte[] content) {
        this.length = length;
        this.content = content;
    }
}
