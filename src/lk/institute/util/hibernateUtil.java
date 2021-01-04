package lk.institute.util;

import lk.institute.entity.Course;
import lk.institute.entity.Registration;
import lk.institute.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateUtil {
    private static SessionFactory sessionFactory=buildSessionFactory();
    private static  SessionFactory buildSessionFactory(){

        //01

        StandardServiceRegistry serReg=new StandardServiceRegistryBuilder().loadProperties("application.properties").build();

        //02
        Metadata mData=new MetadataSources(serReg)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Registration.class)
                .addAnnotatedClass(Student.class)
                .getMetadataBuilder()
                .build();

        //03
        return mData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
