package com.example.CDTT2.Genneric;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class MapModelToDto<D extends Object, T extends Object> {

	public T mapper(D dto, T model) {
		Method[] dtoMethod = dto.getClass().getMethods();

		List<String> dtoGetterName = new LinkedList<>();

		for (Method method : dtoMethod) {

			String gettername = method.getName();

			if (!gettername.equals("getClass") && gettername.startsWith("get")) {
				dtoGetterName.add(gettername);
			}

		}

		for (String getterName : dtoGetterName) {

			Object dtoPropertyValue;
			try {
				dtoPropertyValue = dto.getClass().getMethod(getterName).invoke(dto);

				String modelSetterName = getterName.replaceFirst("get", "set");

				if (dtoPropertyValue != null && dtoPropertyValue.getClass() != new HashSet<>().getClass()
						&& dtoPropertyValue.getClass() != new ArrayList<>().getClass()
						&& dtoPropertyValue.getClass() != Long.class) {//
					Class<?>[] modelSetterNamePropertyTypeClasses = model.getClass()
							.getMethod(modelSetterName, dtoPropertyValue.getClass()).getParameterTypes();
					Class<?> modelSetterNamePropertyType = modelSetterNamePropertyTypeClasses[0];

					model.getClass().getMethod(modelSetterName, modelSetterNamePropertyType).invoke(model,
							modelSetterNamePropertyType.cast(dtoPropertyValue));
				}

			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return model;

	}

}
