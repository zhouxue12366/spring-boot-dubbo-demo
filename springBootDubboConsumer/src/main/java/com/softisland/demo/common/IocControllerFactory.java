//package com.softisland.demo.common;
//
//import java.lang.reflect.Field;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//
//import com.softisland.demo.common.config.Application;
//
//public class IocControllerFactory extends ClassPathXmlApplicationContext {
//	@Nullable
//	private Resource[] configResources;
//
//
//	/**
//	 * Create a new IocControllerFactory for bean-style configuration.
//	 * @see #setConfigLocation
//	 * @see #setConfigLocations
//	 * @see #afterPropertiesSet()
//	 */
//	public IocControllerFactory() {
//	}
//
//	/**
//	 * Create a new IocControllerFactory for bean-style configuration.
//	 * @param parent the parent context
//	 * @see #setConfigLocation
//	 * @see #setConfigLocations
//	 * @see #afterPropertiesSet()
//	 */
//	public IocControllerFactory(ApplicationContext parent) {
//		super(parent);
//	}
//
//	/**
//	 * Create a new IocControllerFactory, loading the definitions
//	 * from the given XML file and automatically refreshing the context.
//	 * @param configLocation resource location
//	 * @throws BeansException if context creation failed
//	 */
//	public IocControllerFactory(String configLocation) throws BeansException {
//		this(new String[] {configLocation}, true, null);
//	}
//
//	/**
//	 * Create a new IocControllerFactory, loading the definitions
//	 * from the given XML files and automatically refreshing the context.
//	 * @param configLocations array of resource locations
//	 * @throws BeansException if context creation failed
//	 */
//	public IocControllerFactory(String... configLocations) throws BeansException {
//		this(configLocations, true, null);
//	}
//
//	/**
//	 * Create a new IocControllerFactory with the given parent,
//	 * loading the definitions from the given XML files and automatically
//	 * refreshing the context.
//	 * @param configLocations array of resource locations
//	 * @param parent the parent context
//	 * @throws BeansException if context creation failed
//	 */
//	public IocControllerFactory(String[] configLocations, @Nullable ApplicationContext parent)
//			throws BeansException {
//
//		this(configLocations, true, parent);
//	}
//
//	/**
//	 * Create a new IocControllerFactory, loading the definitions
//	 * from the given XML files.
//	 * @param configLocations array of resource locations
//	 * @param refresh whether to automatically refresh the context,
//	 * loading all bean definitions and creating all singletons.
//	 * Alternatively, call refresh manually after further configuring the context.
//	 * @throws BeansException if context creation failed
//	 * @see #refresh()
//	 */
//	public IocControllerFactory(String[] configLocations, boolean refresh) throws BeansException {
//		this(configLocations, refresh, null);
//	}
//
//	/**
//	 * Create a new IocControllerFactory with the given parent,
//	 * loading the definitions from the given XML files.
//	 * @param configLocations array of resource locations
//	 * @param refresh whether to automatically refresh the context,
//	 * loading all bean definitions and creating all singletons.
//	 * Alternatively, call refresh manually after further configuring the context.
//	 * @param parent the parent context
//	 * @throws BeansException if context creation failed
//	 * @see #refresh()
//	 */
//	public IocControllerFactory(
//			String[] configLocations, boolean refresh, @Nullable ApplicationContext parent)
//			throws BeansException {
//
//		super(parent);
//		setConfigLocations(configLocations);
//		if (refresh) {
//			refresh();
//		}
//	}
//
//
//	/**
//	 * Create a new IocControllerFactory, loading the definitions
//	 * from the given XML file and automatically refreshing the context.
//	 * <p>This is a convenience method to load class path resources relative to a
//	 * given Class. For full flexibility, consider using a GenericApplicationContext
//	 * with an XmlBeanDefinitionReader and a ClassPathResource argument.
//	 * @param path relative (or absolute) path within the class path
//	 * @param clazz the class to load resources with (basis for the given paths)
//	 * @throws BeansException if context creation failed
//	 * @see org.springframework.core.io.ClassPathResource#ClassPathResource(String, Class)
//	 * @see org.springframework.context.support.GenericApplicationContext
//	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader
//	 */
//	public IocControllerFactory(String path, Class<?> clazz) throws BeansException {
//		this(new String[] {path}, clazz);
//	}
//
//	/**
//	 * Create a new IocControllerFactory, loading the definitions
//	 * from the given XML files and automatically refreshing the context.
//	 * @param paths array of relative (or absolute) paths within the class path
//	 * @param clazz the class to load resources with (basis for the given paths)
//	 * @throws BeansException if context creation failed
//	 * @see org.springframework.core.io.ClassPathResource#ClassPathResource(String, Class)
//	 * @see org.springframework.context.support.GenericApplicationContext
//	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader
//	 */
//	public IocControllerFactory(String[] paths, Class<?> clazz) throws BeansException {
//		this(paths, clazz, null);
//	}
//
//	/**
//	 * Create a new IocControllerFactory with the given parent,
//	 * loading the definitions from the given XML files and automatically
//	 * refreshing the context.
//	 * @param paths array of relative (or absolute) paths within the class path
//	 * @param clazz the class to load resources with (basis for the given paths)
//	 * @param parent the parent context
//	 * @throws BeansException if context creation failed
//	 * @see org.springframework.core.io.ClassPathResource#ClassPathResource(String, Class)
//	 * @see org.springframework.context.support.GenericApplicationContext
//	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader
//	 */
//	public IocControllerFactory(String[] paths, Class<?> clazz, @Nullable ApplicationContext parent)
//			throws BeansException {
//
//		super(parent);
//		Assert.notNull(paths, "Path array must not be null");
//		Assert.notNull(clazz, "Class argument must not be null");
//		this.configResources = new Resource[paths.length];
//		for (int i = 0; i < paths.length; i++) {
//			this.configResources[i] = new ClassPathResource(paths[i], clazz);
//		}
//		refresh();
//	}
//
//
//	@Override
//	@Nullable
//	protected Resource[] getConfigResources() {
//		return this.configResources;
//	}
//	
//	public void start(ClassPathXmlApplicationContext context) {
//		try {
//			getController(Application.class, context);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		System.out.println("执行的重写后的工厂类");
//		super.start();
//	}
//	
//
//	private Object getController(Class<?> controllerClass,ClassPathXmlApplicationContext context)throws InstantiationException, IllegalAccessException {
//		Object target = controllerClass.newInstance();
//		Field[] fields = controllerClass.getDeclaredFields();
//		for (Field field : fields) {
//			Object bean = null;
//			if (field.isAnnotationPresent(Inject.BY_NAME.class)) {
//				bean = context.getBean(field.getName());
//			} else if (field.isAnnotationPresent(Inject.BY_TYPE.class)) {
//				bean = context.getBean(field.getType());
//			} else {
//				continue;
//			}
//			
//			try {
//				if (bean != null) {
//					field.setAccessible(true);
//					field.set(target, bean);
//				}
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return target;
//	}
//}
