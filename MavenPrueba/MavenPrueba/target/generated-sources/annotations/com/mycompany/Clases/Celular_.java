package com.mycompany.Clases;

import com.mycompany.Clases.Cliente;
import com.mycompany.Clases.Recarga;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-05T22:25:18", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Celular.class)
public class Celular_ { 

    public static volatile SingularAttribute<Celular, Cliente> cliente;
    public static volatile SingularAttribute<Celular, Integer> estado;
    public static volatile SingularAttribute<Celular, String> numero;
    public static volatile SingularAttribute<Celular, Integer> saldo;
    public static volatile SingularAttribute<Celular, Recarga> recarga;
    public static volatile SingularAttribute<Celular, Integer> idCelular;
    public static volatile SingularAttribute<Celular, Integer> megas;

}