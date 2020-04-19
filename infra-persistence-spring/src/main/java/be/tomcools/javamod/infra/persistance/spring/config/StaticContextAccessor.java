package be.tomcools.javamod.infra.persistance.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class StaticContextAccessor {

    private static final Map<Class, DynamicInvocationhandler> classHandlers = new HashMap<>();
    private static ApplicationContext context;

    @Autowired
    public StaticContextAccessor(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (context == null) {
            return getProxy(clazz);
        }
        return context.getBean(clazz);
    }

    private static <T> T getProxy(Class<T> clazz) {
        DynamicInvocationhandler<T> invocationhandler = new DynamicInvocationhandler<>();
        classHandlers.put(clazz, invocationhandler);
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                invocationhandler
        );
    }

    @PostConstruct
    private void init() {
        classHandlers.forEach((key, value) -> {
            Object bean = context.getBean(key);
            value.setActual(bean);
        });
    }

    static class DynamicInvocationhandler<T> implements InvocationHandler {

        private T actual;

        public void setActual(T actual) {
            this.actual = actual;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (actual == null) {
                throw new RuntimeException("Not initialized yet! :(");
            }
            return method.invoke(actual, args);
        }
    }

}
