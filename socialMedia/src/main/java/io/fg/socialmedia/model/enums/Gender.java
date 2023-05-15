package io.fg.socialmedia.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("Man"),
    FEMALE("Woman"),
    INDEFINITE("Indefinity");
    private final String value;
}
