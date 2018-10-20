package config;

import service.ActiveSubstanceServiceImpl;
import service.MedicineServiceImpl;
import service.SideEffectServiceImpl;
import service.UserServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(MedicineServiceImpl.class);
        classes.add(ActiveSubstanceServiceImpl.class);
        classes.add(SideEffectServiceImpl.class);
        classes.add(UserServiceImpl.class);
        return classes;
    }
}
