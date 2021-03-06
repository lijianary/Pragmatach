package com.khubla.pragmatach.plugin.mongodb.serializer;

import java.lang.reflect.Field;
import java.util.Set;

import javax.persistence.Entity;

import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.plugin.mongodb.util.AtomicTypeUtil;

/**
 * @author tom
 */
public class FieldSerializerFactory {
   public static FieldSerializer getFieldSerializer(Class<?> clazz, Field field) throws PragmatachException {
      if (AtomicTypeUtil.isSimpleType(field.getType())) {
         return new AtomicFieldSerializer(clazz);
      } else if (field.getType() == Set.class) {
         return new SetFieldSerializer(clazz);
      } else if (null != field.getType().getAnnotation(Entity.class)) {
         return new EntityFieldSerializer(clazz);
      } else if (field.getType().isEnum()) {
         return new EnumFieldSerializer(clazz);
      } else {
         throw new PragmatachException("Invalid serialization type '" + field.getType().getName() + "' for field '" + field.getName() + "'");
      }
   }
}
