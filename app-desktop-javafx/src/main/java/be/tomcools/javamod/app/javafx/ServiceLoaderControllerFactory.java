package be.tomcools.javamod.app.javafx;

import javafx.util.Callback;

import java.lang.reflect.Constructor;
import java.util.Optional;
import java.util.ServiceLoader;

/*
    A custom dependency injection example, uses the serviceloader to load instances;
    I have not yet made it stable enough to work with any number of parameters!
 */
public class ServiceLoaderControllerFactory implements Callback<Class<?>, Object> {
    @Override
    public Object call(Class<?> typeToCreate) {
        try {
            // look for constructor taking MyService as a parameter
            for (Constructor<?> c : typeToCreate.getConstructors()) {
                if (c.getParameterCount() == 1) {
                    Class<?> parameterType = c.getParameterTypes()[0];
                    // This is the magic :-)
                    Optional<?> instance = searchServiceLoaderForInstance(parameterType);
                    if (instance.isPresent()) {
                        return c.newInstance(instance.get());
                    }
                } else if(c.getParameterCount() > 1) {
                    return handleMultiParameterConstructors();
                }
            }
            // didn't find appropriate constructor, just use default constructor:
            return typeToCreate.getDeclaredConstructor().newInstance();
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    // Extracted for explicit location of ServiceLoader
    private Optional<?> searchServiceLoaderForInstance(Class<?> parameterType) {
        return ServiceLoader.load(parameterType).findFirst();
    }

    private Object handleMultiParameterConstructors() {
        // TODO extend this class so it will work!
        throw new IllegalArgumentException("Can't create objects yet who don't have a no or 1 parameter constructor.");
    }
}
