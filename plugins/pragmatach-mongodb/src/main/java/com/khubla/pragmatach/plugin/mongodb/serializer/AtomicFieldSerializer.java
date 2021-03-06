package com.khubla.pragmatach.plugin.mongodb.serializer;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.BeanUtils;

import com.khubla.pragmatach.framework.api.PragmatachException;
import com.khubla.pragmatach.plugin.mongodb.MongoDBDAO;
import com.khubla.pragmatach.plugin.mongodb.util.ClassTypeUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author tom
 */
public class AtomicFieldSerializer implements FieldSerializer {
   /**
    * type utils
    */
   private final ClassTypeUtils classTypeUtils;
   /**
    * the type
    */
   private final Class<?> typeClazz;

   /**
    * ctor
    */
   public AtomicFieldSerializer(Class<?> typeClazz) {
      this.typeClazz = typeClazz;
      classTypeUtils = new ClassTypeUtils(this.typeClazz);
   }

   @Override
   public void deserializeField(Object object, Field field, DBObject dbObject) throws PragmatachException {
      try {
         /*
          * read all fields, treating id as special
          */
         if (field.getName().compareTo(classTypeUtils.getIdFieldName()) != 0) {
            BeanUtils.setProperty(object, field.getName(), dbObject.get(field.getName()));
         } else {
            final String objectId = (String) dbObject.get(MongoDBDAO.ID);
            if (null == objectId) {
               throw new PragmatachException("Object '" + dbObject.toString() + "' has null id");
            }
            classTypeUtils.setId(object, objectId);
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in deserializeField", e);
      }
   }

   @Override
   public void serializeField(BasicDBObject parentDBObject, Object object, Field field) throws PragmatachException {
      try {
         /*
          * persist all fields, treating id as special
          */
         if (field.getName().compareTo(classTypeUtils.getIdFieldName()) != 0) {
            final String propertyValue = BeanUtils.getProperty(object, field.getName());
            parentDBObject.append(field.getName(), propertyValue);
         } else {
            final String id = classTypeUtils.getId(object);
            parentDBObject.append(MongoDBDAO.ID, id);
         }
      } catch (final Exception e) {
         throw new PragmatachException("Exception in serializeField", e);
      }
   }
}
