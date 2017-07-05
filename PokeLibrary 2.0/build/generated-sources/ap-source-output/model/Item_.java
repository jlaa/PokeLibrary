package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Localizacao;
import model.Preco;
import model.Usuario;
import model.Versao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-04T17:33:18")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile ListAttribute<Item, Preco> preco;
    public static volatile ListAttribute<Item, Localizacao> localizacao;
    public static volatile SingularAttribute<Item, String> nomedoitem;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile ListAttribute<Item, Usuario> usuarios;
    public static volatile ListAttribute<Item, Versao> versao;
    public static volatile SingularAttribute<Item, String> descricao;

}