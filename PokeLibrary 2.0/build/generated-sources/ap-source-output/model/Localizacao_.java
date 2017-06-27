package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Item;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-27T15:18:42")
@StaticMetamodel(Localizacao.class)
public class Localizacao_ { 

    public static volatile SingularAttribute<Localizacao, String> formasdechegar;
    public static volatile ListAttribute<Localizacao, Item> itens;
    public static volatile SingularAttribute<Localizacao, String> localizacaoDetalhada;
    public static volatile SingularAttribute<Localizacao, Integer> id;
    public static volatile SingularAttribute<Localizacao, String> localizacaocomum;

}