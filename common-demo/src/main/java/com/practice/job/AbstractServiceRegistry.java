package com.practice.job;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/13 21:04
 */
public class AbstractServiceRegistry<TYPE extends Enum<TYPE>, SERVICE extends WithType<TYPE>> {
	protected final boolean notCheckMissingServiceType;
	private Map<TYPE, SERVICE> registry;
	private Class<TYPE> typeClz;
	private Class<SERVICE> serviceClz;

	public AbstractServiceRegistry() {
		this(false);
	}

	public AbstractServiceRegistry(boolean notCheckMissingServiceType) {
		this.notCheckMissingServiceType = notCheckMissingServiceType;
	}

	@Resource
	protected void initServices(SERVICE[] services) {
		if (services != null && services.length != 0) {
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type[] typeArguments = parameterizedType.getActualTypeArguments();
			this.typeClz = (Class) typeArguments[0];
			Type serviceType = typeArguments[1];
			if (serviceType instanceof ParameterizedType) {
				serviceType = ((ParameterizedType) serviceType).getRawType();
			}

			this.serviceClz = (Class) serviceType;
			this.registry = Maps.newHashMap();
			WithType[] var5 = services;
			int var6 = services.length;

			int var7;
			for (var7 = 0; var7 < var6; ++var7) {
				SERVICE service = (SERVICE) var5[var7];
				TYPE type = service.getType();
				if (this.typeClz.isInstance(type) && this.serviceClz.isInstance(service)) {
					if (this.registry.containsKey(type)) {
						Preconditions.checkState(false, "service of type %s already registered, existing service %s, conflicting service %s", type, ((WithType) this.registry.get(type)).getClass().getName(), service.getClass().getName());
					}

					this.registry.put(type, service);
				}
			}

			if (!this.notCheckMissingServiceType) {
				if (this.registry.size() != ((Enum[]) this.typeClz.getEnumConstants()).length - 1) {
					Enum[] var10 = (Enum[]) this.typeClz.getEnumConstants();
					var6 = var10.length;

					for (var7 = 0; var7 < var6; ++var7) {
						TYPE type = (TYPE) var10[var7];
						if (!type.name().equals("UNKNOWN")) {
							Preconditions.checkState(this.registry.containsKey(type), "missing service type %s for service registry %s", type, this.getClass().getName());
						}
					}
				}

			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
