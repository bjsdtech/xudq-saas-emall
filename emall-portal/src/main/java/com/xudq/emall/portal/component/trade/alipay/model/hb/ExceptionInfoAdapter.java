package com.xudq.emall.portal.component.trade.alipay.model.hb;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.xudq.emall.portal.component.trade.alipay.utils.Utils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Type;
import java.util.List;


public class ExceptionInfoAdapter implements JsonSerializer<List<ExceptionInfo>> {
    @Override
    public JsonElement serialize(List<ExceptionInfo> exceptionInfos, Type type, JsonSerializationContext jsonSerializationContext) {
        if (Utils.isListEmpty(exceptionInfos)) {
            return null;
        }

        return new JsonPrimitive(StringUtils.join(exceptionInfos, "|"));
    }
}
