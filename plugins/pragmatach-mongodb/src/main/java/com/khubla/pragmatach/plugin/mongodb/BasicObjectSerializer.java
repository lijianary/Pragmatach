package com.khubla.pragmatach.plugin.mongodb;

import java.lang.reflect.Field;

import org.bson.types.ObjectId;

import com.khubla.pragmatach.framework.api.PragmatachException;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author tom
 */
public class BasicObjectSerializer implements ObjectSerializer {
   /**
    * the type
    */
   private final Class<?> typeClazz;
   /**
    * type utils
    */
   private final ClassTypeUtils typeUtils;

   /**
    * ctor
    */
   public BasicObjectSerializer(Class<?> typeClazz) {
      this.typeClazz = typeClazz;
      typeUtils = new ClassTypeUtils(this.typeClazz);
   }

   /**
    * deserialize
    */
   @Override
   public void deserialize(DBObject dbObject, Object object) throws PragmatachException {
      try {
         /*
          * walk the fields
          */
         for (final Field field : typeClazz.getDeclaredFields()) {
            /*
             * filter the static ones
             */
            if (false == java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
               final FieldSerializer fieldSerializer = FieldSerializerFactory.getFieldSerializer(typeClazz, field);
               fieldSerializer.deserializeField(object, field, dbObject);
            }
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in deserialize", e);
      }
   }

   public Class<?> getTypeClazz() {
      return typeClazz;
   }

   /**
    * serialize
    */
   @Override
   public BasicDBObject serialize(Object object) throws PragmatachException {
      try {
         if (null != object) {
            /*
             * id generation
             */
            if (typeUtils.isGeneratedId()) {
               /*
                * check for an id
                */
               final String id = typeUtils.getId(object);
               if (null == id) {
                  final ObjectId objectId = new ObjectId();
                  typeUtils.setId(object, objectId.toString());
               }
            }
            /*
             * object node
             */
            final BasicDBObject ret = new BasicDBObject();
            /*
             * walk the fields
             */
            for (final Field field : typeClazz.getDeclaredFields()) {
               /*
                * filter the static ones
                */
               if (false == java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                  final FieldSerializer fieldSerializer = FieldSerializerFactory.getFieldSerializer(typeClazz, field);
                  fieldSerializer.serializeField(ret, object, field);
               }
            }
            /*
             * done
             */
            return ret;
         } else {
            throw new PragmatachException("Cannot serialize null object");
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in serialize", e);
      }
   }
}
