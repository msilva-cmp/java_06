package com.models;

import com.models.Materias;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-27T17:22:26", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Carreras.class)
public class Carreras_ { 

    public static volatile ListAttribute<Carreras, Materias> listaMaterias;
    public static volatile SingularAttribute<Carreras, Integer> id;
    public static volatile SingularAttribute<Carreras, String> nombre;

}