package com.artsgard.retailapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 */
@Mapper(componentModel = "spring")
@Component
public interface BaseMapper {

    @Named("prepareOptionalParams")
    public static <T> T prepareOptionalParams(T param) {
        if (param instanceof List) {
            ((List)param).removeAll(Arrays.asList("", null));
        }

        return param != null && param.equals("") ? null : param;
    }

}
