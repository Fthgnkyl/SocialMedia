package io.fg.socialmedia.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    BLOCK("Block"),
    FREEZE("Freeze"),
    OPEN("Open");
    private final String value;

}
