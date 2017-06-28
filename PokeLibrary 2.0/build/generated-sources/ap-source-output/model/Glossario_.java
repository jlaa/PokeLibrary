package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-28T00:50:03")
@StaticMetamodel(Glossario.class)
public class Glossario_ { 

    public static volatile SingularAttribute<Glossario, Usuario> cliente;
    public static volatile SingularAttribute<Glossario, String> Verbete;
    public static volatile SingularAttribute<Glossario, Integer> id_glossario;
    public static volatile SingularAttribute<Glossario, Integer> id_usuario;
    public static volatile SingularAttribute<Glossario, String> DescricaoVerbete;

}