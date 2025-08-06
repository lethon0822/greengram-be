package com.green.greengram.config.enumcode;

import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
public abstract class AbstractEnumCodeConverter <E extends Enum<E> & EnumMapperType>
        implements AttributeConverter<E, String> {
    private final Class<E> targetEnumClass;
    private final boolean nullable;

    @Override
    public String convertToDatabaseColumn(E enumItem) {
        if (!nullable && enumItem == null) {
            throw new IllegalArgumentException(String.format("%s(는)은 NULL로 저장할 수 없습니다.",
                    targetEnumClass.getSimpleName()));
        }
        return EnumConvertUtils.toCode(enumItem);
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if(!nullable && StringUtils.isEmpty(dbData)) {
            throw new IllegalArgumentException(String.format("%s(는)은 DB에 NULL 혹은 Empty로 저장되어 있습니다.",
                    targetEnumClass.getSimpleName()));
        }
        return EnumConvertUtils.ofCode(targetEnumClass, dbData);
    }
}
