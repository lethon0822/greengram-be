package com.green.greengram.config.enumcode;

import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumUserRole implements EnumMapperType{
    // 구조와 객체화가 동시에 이루어짐(생성자 호출)
        USER_1("01", "유저1")
      , USER_2("02", "유저2")
      ;

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumUserRole> {
        public CodeConverter() { super(EnumUserRole.class, false);}
    }
}
