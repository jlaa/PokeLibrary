package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Glossario;
import model.Item;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-11T18:48:34")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile ListAttribute<Usuario, Item> itens;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile ListAttribute<Usuario, Glossario> glossario;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, String> username;

}