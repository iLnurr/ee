package rest;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilnur on 24.05.17.
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;


    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(BookRestService.class);
        // для сериализации в json и обратно (для xml есть встроенная поддержка jax-rs)
        c.add(MOXyJsonProvider.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
