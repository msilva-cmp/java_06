package com.models;

import com.models.Carreras;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T17:22:26", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Alumnos.class)
public class Alumnos_ { 

    public static volatile SingularAttribute<Alumnos, Date> fechaNac;
    public static volatile SingularAttribute<Alumnos, String> apellido;
    public static volatile SingularAttribute<Alumnos, Integer> id;
    public static volatile SingularAttribute<Alumnos, Carreras> carrera;
    public static volatile SingularAttribute<Alumnos, String> nombre;

}